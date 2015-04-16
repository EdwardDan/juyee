package com.justonetech.biz.controller.net;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.NetAcceptStatusService;
import com.justonetech.biz.daoservice.NetAcceptStepService;
import com.justonetech.biz.domain.NetAcceptStatus;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * note:项目审批_受理状态设置
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class NetAcceptStatusController extends BaseCRUDActionController<NetAcceptStatus> {
    private Logger logger = LoggerFactory.getLogger(NetAcceptStatusController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private NetAcceptStepService netAcceptStepService;

    @Autowired
    private NetAcceptStatusService netAcceptStatusService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, Long acceptStepId) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.NET_ACCEPT_STEP_EDIT));

        model.addAttribute("acceptStep", netAcceptStepService.get(acceptStepId));

        return "view/net/netAcceptStatus/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, Long acceptStepId) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from NetAcceptStatus where acceptStep.id="+acceptStepId+" order by no,id asc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = netAcceptStatusService.findByPage(pageModel, query);

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model, Long acceptStepId) {
        NetAcceptStatus netAcceptStatus = new NetAcceptStatus();

        //如需增加其他默认值请在此添加
        netAcceptStatus.setAcceptStep(netAcceptStepService.get(acceptStepId));
        netAcceptStatus.setLabel("受理日期");
        model.addAttribute("bean", netAcceptStatus);

        return "view/net/netAcceptStatus/input";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id) {
        NetAcceptStatus netAcceptStatus = netAcceptStatusService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", netAcceptStatus);

        return "view/net/netAcceptStatus/input";
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        NetAcceptStatus netAcceptStatus = netAcceptStatusService.get(id);

        model.addAttribute("bean", netAcceptStatus);
        return "view/net/netAcceptStatus/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") NetAcceptStatus entity, HttpServletRequest request) throws Exception {
        try {
            NetAcceptStatus target;
            if (entity.getId() != null) {
                target = netAcceptStatusService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "no",
                        "name",
                        "isPass",
                        "isStart",
                        "isEnd",
                        "label",
                        "acceptStep"
                });

            } else {
                target = entity;
            }
            netAcceptStatusService.save(target);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 删除操作
     *
     * @param response .
     * @param id       .
     * @throws Exception .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) throws Exception {
        NetAcceptStatus acceptStatus = netAcceptStatusService.get(id);
        if (acceptStatus.getNetOpLogs().size() > 0) {
            sendFailureJSON(response, "删除失败，已有操作日志生成");
        } else {
            netAcceptStatusService.delete(id);
            sendSuccessJSON(response, "删除成功");
        }
    }
}