package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.OaReceiveNodeService;
import com.justonetech.biz.domain.OaReceiveNode;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
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
 * note:收文管理流转节点
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaReceiveNodeController extends BaseCRUDActionController<OaReceiveNode> {
    private Logger logger = LoggerFactory.getLogger(OaReceiveNodeController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private OaReceiveNodeService oaReceiveNodeService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, HttpServletRequest request) {
        String oaReceiveId = request.getParameter("oaReceiveId");
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_SAMPLE_EDIT));
        model.addAttribute("oaReceiveId", oaReceiveId);
        return "view/oa/oaReceiveNode/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, HttpServletRequest request) {
        try {
            String oaReceiveId = request.getParameter("oaReceiveId");

            Page pageModel = new Page(page, rows, true);
            String hql = "from OaReceiveNode where 1=1 ";
            hql += "  and oaReceive.id=" + oaReceiveId;
            hql += " order by completeTime,id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = oaReceiveNodeService.findByPage(pageModel, query);

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
        OaReceiveNode oaReceiveNode = new OaReceiveNode();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", oaReceiveNode);

        return "view/oa/oaReceiveNode/input";
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
        OaReceiveNode oaReceiveNode = oaReceiveNodeService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", oaReceiveNode);

        return "view/oa/oaReceiveNode/input";
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
        OaReceiveNode oaReceiveNode = oaReceiveNodeService.get(id);

        model.addAttribute("bean", oaReceiveNode);
        return "view/oa/oaReceiveNode/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaReceiveNode entity, HttpServletRequest request) throws Exception {
        try {
            OaReceiveNode target;
            if (entity.getId() != null) {
                target = oaReceiveNodeService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "stepId",
                        "isDeal",
                        "dealUser",
                        "dealResult",
                        "receiveTime",
                        "openTime",
                        "completeTime",
                        "createTime",
                        "createUser",
                        "updateTime",
                        "updateUser"
                });

            } else {
                target = entity;
            }
            oaReceiveNodeService.save(target);

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
        oaReceiveNodeService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}