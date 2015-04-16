package com.justonetech.biz.controller.net;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.NetApplyService;
import com.justonetech.biz.domain.NetApply;
import com.justonetech.biz.domain.NetCfb;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
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

/**
 * 项目属性选择
 * User: Shaxj
 * Date: 14-6-23
 * Time: 下午2:51
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class NetPropertyController extends BaseCRUDActionController<NetApply> {
    private Logger logger = LoggerFactory.getLogger(NetPropertyController.class);

    @Autowired
    private SysUserManager sysUserManager;

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
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.NET_CFB_EDIT));

        return "view/net/netProperty/grid";
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
        NetApply netApply = netApplyService.get(id);

        model.addAttribute("bean", netApply);
        return "view/net/netProperty/view";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from NetApply where acceptStatus.id=2  ";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = netApplyService.findByPage(pageModel, query);

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
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
        NetApply netApply = netApplyService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", netApply);

        return "view/net/netProperty/input";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") NetApply entity, HttpServletRequest request) throws Exception {
        try {
            NetApply target = netApplyService.get(entity.getId());
            String isImport = request.getParameter("isImportant");
            if (!StringHelper.isEmpty(isImport)) {
                Boolean isImportant = Boolean.parseBoolean(isImport);
                target.setIsImportant(isImportant);
                netApplyService.save(target);
            }
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }
}
