package com.justonetech.biz.controller.net;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.NetApplyService;
import com.justonetech.biz.daoservice.NetCfbService;
import com.justonetech.biz.daoservice.NetSgpermitService;
import com.justonetech.biz.domain.NetAcceptStatus;
import com.justonetech.biz.domain.NetApply;
import com.justonetech.biz.domain.NetCfb;
import com.justonetech.biz.domain.NetSgpermit;
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
 * note:项目施工许可
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class NetSgpermitController extends BaseCRUDActionController<NetSgpermit> {
    private Logger logger = LoggerFactory.getLogger(NetSgpermitController.class);

    @Autowired
    private NetSgpermitService netSgpermitService;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private NetCfbService netCfbService;

    @Autowired
    private NetApplyService netApplyService;

    @Autowired
    private NetAcceptManager netAcceptManager;


    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.NET_SGPERMIT_EDIT));

        model.addAttribute("matterCode", NetMatterDefine.MATTER_SGPERMIT.getCode());
        model.addAttribute("className", "NetSgpermit");

        return "view/net/netSgpermit/grid";
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
    public void gridDataCustom(String setCode, HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = " from NetSgpermit  where 1=1 ";
            if (!StringHelper.isEmpty(setCode)) {
                hql += " and acceptStatus.name='" + setCode + "'";
            }
            hql += " order by netDate desc nulls last";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = netCfbService.findByPage(pageModel, query);
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
        NetSgpermit netSgpermit = new NetSgpermit();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", netSgpermit);
        return "view/net/netSgpermit/input";
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
        NetCfb netCfb = netCfbService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", netCfb);
        return "view/net/netSgpermit/input";
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
        NetSgpermit netSgpermit = netSgpermitService.get(id);

        model.addAttribute("bean", netSgpermit);
        return "view/net/netSgpermit/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") NetSgpermit entity, HttpServletRequest request) throws Exception {
        String netCode = entity.getNetCode();
        String bjbh = request.getParameter("bjbh");
        String bdh = entity.getBdh();
//        Date netDate = netAcceptManager.getDateFromCode(netCode);
        NetApply net = netAcceptManager.getProjectUnLimit(bjbh);
        String hql = "from NetSgpermit where apply.bjbh='" + bjbh + "' and bdh='" + bdh + "'";
        List<NetSgpermit> cfbs = netSgpermitService.findByQuery(hql);
//        if (null == netDate) {
//            sendFailureJSON(response, "网上受理编号不正确，请重新输入！");
//        } else if (null == net) {
        if(null == net){
            sendFailureJSON(response, "未找到指定的项目工程，请重新输入报建编号！");
        } else if (null != cfbs && cfbs.size() > 0) {
            sendFailureJSON(response, "该标段号已录入!");
        } else {
            try {
                NetSgpermit target;
                if (entity.getId() != null) {
                    target = netSgpermitService.get(entity.getId());
                    ReflectionUtils.copyBean(entity, target, new String[]{
                            "netCode",
                            "bdh"
                    });

                } else {
                    target = entity;
                    String matterCode = NetMatterDefine.MATTER_SGPERMIT.getCode();
                    // 获取第一步
                    NetAcceptStatus netAcceptStatus = netAcceptManager.getFirstStatus(matterCode);
                    target.setAcceptStatus(netAcceptStatus);
                }
                String sql = "from NetApply where bjbh='" + bjbh + "'";
                List<NetApply> list = netApplyService.findByQuery(sql);
                if (null != list && list.size() > 0) {
                    NetApply netApply = list.iterator().next();
                    target.setApply(netApply);
                }
//                target.setNetDate(netDate);
                netSgpermitService.save(target);

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
        netSgpermitService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}