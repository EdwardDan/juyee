package com.justonetech.biz.controller.net;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.NetApplyService;
import com.justonetech.biz.daoservice.NetMonitorService;
import com.justonetech.biz.domain.NetApply;
import com.justonetech.biz.domain.NetMonitor;
import com.justonetech.biz.manager.NetAcceptManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.NetMatterDefine;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
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
import java.util.List;


/**
 * note:项目报监
 * author:hgr
 * create date:
 * modify date:2014-06-26
 */
@Controller
public class NetMonitorController extends BaseCRUDActionController<NetMonitor> {
    private Logger logger = LoggerFactory.getLogger(NetMonitorController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private NetAcceptManager netAcceptManager;

    @Autowired
    private NetMonitorService netMonitorService;

    @Autowired
    private NetApplyService netApplyService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.NET_MONITOR_EDIT));

        model.addAttribute("className", "NetMonitor");
        model.addAttribute("matterCode", NetMatterDefine.MATTER_MONITOR.getCode());

        return "view/net/netMonitor/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     * @param session  .
     * @param setCode  .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, String setCode) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from NetMonitor where 1=1";
            //增加自定义查询条件
            if (!StringHelper.isEmpty(setCode)) {
                hql += " and acceptStatus.name='" + setCode + "' ";
            }
            hql += " order by id desc";
            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = netMonitorService.findByPage(pageModel, query);

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
    public String add(Model model) {
        NetMonitor netMonitor = new NetMonitor();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", netMonitor);

        return "view/net/netMonitor/input";
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
        NetMonitor netMonitor = netMonitorService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", netMonitor);

        return "view/net/netMonitor/input";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") NetMonitor entity, HttpServletRequest request) throws Exception {
        String netCode = entity.getNetCode();
        String bjbh = request.getParameter("bjbh");
        String bdh = entity.getBdh();

//        Date date = netAcceptManager.getDateFromCode(netCode);
        String hql = "from NetMonitor where  apply.bjbh=? and bdh=?";
        List<NetMonitor> monitors = netMonitorService.findByQuery(hql, bjbh, bdh);
        NetApply net = netAcceptManager.getProjectUnLimit(bjbh);
//        if (null == date) {
//            sendFailureJSON(response, "网上受理编号不正确，请重新输入！");
//        } else if (null == net) {
        if(null == net){
            sendFailureJSON(response, "未找到指定的项目工程，请重新输入报建编号！");
        } else if (null != monitors && monitors.size() > 0) {
            sendFailureJSON(response, "该标段号已录入!");
        } else {
            try {
                NetMonitor target;
                if (entity.getId() != null) {
                    target = netMonitorService.get(entity.getId());
                    ReflectionUtils.copyBean(entity, target, new String[]{
                            "netCode",
                            "bdh"
                    });

                } else {
                    target = entity;
                }

                //与Apply中项目信息关联
                target.setAcceptStatus(netAcceptManager.getFirstStatus(NetMatterDefine.MATTER_MONITOR.getCode()));
                String sql = "from NetApply where bjbh='" + bjbh + "'";
                List<NetApply> list = netApplyService.findByQuery(sql);
                if (null != list && list.size() > 0) {
                    NetApply netApply = list.iterator().next();
                    target.setApply(netApply);
                }
                //保存网上提交日期
//                target.setNetDate(date);

                netMonitorService.save(target);
            } catch (Exception e) {
                log.error("error", e);
                super.processException(response, e);
                return;
            }
            sendSuccessJSON(response, "保存成功");

        }
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
        netMonitorService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}