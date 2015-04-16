package com.justonetech.biz.controller.net;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.NetAcceptStepService;
import com.justonetech.biz.domain.NetAcceptStep;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.NetMatterDefine;
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
 * note:项目审批_受理环节设置
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class NetAcceptStepController extends BaseCRUDActionController<NetAcceptStep> {
    private Logger logger = LoggerFactory.getLogger(NetAcceptStepController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private NetAcceptStepService netAcceptStepService;

    /**
     * 入口页面
     * @param model .
     * @return  .
     */
    @RequestMapping
    public String init(Model model) {
        model.addAttribute("list", NetMatterDefine.values());

        return "view/net/netAcceptStep/init";
    }

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model,String matterCode) {
        //判断是否有编辑权限
        model.addAttribute("canEdit",sysUserManager.hasPrivilege(PrivilegeCode.NET_ACCEPT_STEP_EDIT));
        model.addAttribute("matterCode",matterCode);
        model.addAttribute("matterName",NetMatterDefine.getNameByCode(matterCode));

        return "view/net/netAcceptStep/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters .
     * @param columns .
     * @param page .
     * @param rows .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session,String matterCode) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from NetAcceptStep where matterCode='"+matterCode+"' order by no,id asc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = netAcceptStepService.findByPage(pageModel, query);

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
    public String add(Model model,String matterCode) {
        NetAcceptStep netAcceptStep = new NetAcceptStep();

        //如需增加其他默认值请在此添加
        netAcceptStep.setIsShowButton(true);
        netAcceptStep.setMatterCode(matterCode);
        model.addAttribute("bean", netAcceptStep);

        return "view/net/netAcceptStep/input";
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
        NetAcceptStep netAcceptStep = netAcceptStepService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", netAcceptStep);

        return "view/net/netAcceptStep/input";
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
        NetAcceptStep netAcceptStep = netAcceptStepService.get(id);

        model.addAttribute("bean", netAcceptStep);
        return "view/net/netAcceptStep/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") NetAcceptStep entity, HttpServletRequest request) throws Exception {
        try {
            NetAcceptStep target;
            if (entity.getId() != null) {
                target = netAcceptStepService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "no",
                        "code",
                        "matterCode",
                        "name",
                        "isShowButton",
                        "note"
                });

            } else {
                target = entity;
            }
            netAcceptStepService.save(target);

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
     * @param id  .
     * @throws Exception  .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) throws Exception {
        netAcceptStepService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}