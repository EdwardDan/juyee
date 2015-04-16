package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaTaskTypePrivilegeService;
import com.justonetech.biz.daoservice.OaTaskTypeService;
import com.justonetech.biz.domain.OaTaskType;
import com.justonetech.biz.domain.OaTaskTypePrivilege;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysPrivilegeService;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.tree.ZTreeBranch;
import com.justonetech.system.tree.ZTreeNode;
import com.justonetech.system.utils.PrivilegeCode;
import org.apache.commons.lang.StringUtils;
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
import java.util.Set;


/**
 * note:任务类型
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaTaskTypeController extends BaseCRUDActionController<OaTaskType> {
    private Logger logger = LoggerFactory.getLogger(OaTaskTypeController.class);

    @Autowired
    private SysUserManager sysUserManager;


    @Autowired
    private OaTaskTypeService oaTaskTypeService;

    @Autowired
    private OaTaskTypePrivilegeService oaTaskTypePrivilegeService;

    @Autowired
    private SysPrivilegeService sysPrivilegeService;

    @Autowired
    private OaTaskManager oaTaskManager;

    /**
     * 树+列表显示页面
     *
     * @param model .
     */
    @RequestMapping
    public String init(Model model) {
        return "view/oa/oaTaskType/init";
    }

    /**
     * 树显示页面
     *
     * @param model .
     */
    @RequestMapping
    public String tree(Model model, HttpServletRequest request) {

        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_TASKTYPE_EDIT));

        //上下移动使用
        model.addAttribute("clazz", OaTaskType.class.getName());

        return "view/oa/oaTaskType/tree";
    }

    /**
     * 获取树数据
     *
     * @param model .
     */
    @RequestMapping
    public String treeData(String type, String id, String icon, Model model) {
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));

        if (StringUtils.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("任务类型树"));
        } else if (StringUtils.equals(id, "root")) {
            String hql = "from OaTaskType where parent.id is null order by treeId asc";
            List<OaTaskType> nodeList = oaTaskTypeService.findByQuery(hql);
            for (OaTaskType data : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getName());
                treeNode.setIsLeaf(data.getIsLeaf());
                if (data.getIsValid()) {
                    treeNode.setIcon("1");
                } else {
                    treeNode.setIcon("2");
                }
                treeNode.setType("data");
                treeBranch.addTreeNode(treeNode);
            }
        } else if (StringUtils.equals(type, "data")) {
            String hql = "from OaTaskType where parent.id=" + id + " order by treeId asc";
            List<OaTaskType> nodeList = oaTaskTypeService.findByQuery(hql);
            for (OaTaskType data : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getName());
                treeNode.setIsLeaf(data.getIsLeaf());
                if (data.getIsValid()) {
                    treeNode.setIcon("1");
                } else {
                    treeNode.setIcon("2");
                }
                treeNode.setType("data");
                treeBranch.addTreeNode(treeNode);
            }
        }
        model.addAttribute("msg", treeBranch.toJsonString(true));
        return "common/msg";
    }

    /**
     * 列表显示页面
     *
     * @param model .
     */
    @RequestMapping
    public String grid(Model model) {

        return "view/oa/oaTaskType/grid";
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
            String hql = "from OaTaskType order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = oaTaskTypeService.findByPage(pageModel, query);
            session.setAttribute(Constants.GRID_SQL_KEY, query);

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
     */
    @RequestMapping
    public String add(Model model, String parentId) {
        OaTaskType oaTaskType = new OaTaskType();

        //如需增加其他默认值请在此添加
        if (!StringHelper.isEmpty(parentId) && !"root".equals(parentId)) {
            oaTaskType.setParent(oaTaskTypeService.get(Long.valueOf(parentId)));
        }
        model.addAttribute("bean", oaTaskType);

        return "view/oa/oaTaskType/input";
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
        OaTaskType oaTaskType = oaTaskTypeService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", oaTaskType);

        return "view/oa/oaTaskType/input";
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        OaTaskType oaTaskType = oaTaskTypeService.get(id);

        model.addAttribute("bean", oaTaskType);
        return "view/oa/oaTaskType/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @return .
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaTaskType entity, HttpServletRequest request) throws Exception {
        try {
            OaTaskType target;
            if (entity.getId() != null) {
                target = oaTaskTypeService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "code",
                        "name",
                        "url",
                        "viewUrl",
                        "isWorkflow",
                        "isValid",
                        "script",
                        "titleTemplate"
                });

            } else {
                target = entity;
            }
            oaTaskTypeService.save(target);

            //移除关联权限
            Set<OaTaskTypePrivilege> oaTaskTypePrivileges = target.getOaTaskTypePrivileges();
            if(null!=oaTaskTypePrivileges) {
                for (OaTaskTypePrivilege relate : oaTaskTypePrivileges) {
                    oaTaskTypePrivilegeService.delete(relate);
                }
            }
            String privilegeIds = request.getParameter("privilegeIds");
            if (!StringHelper.isEmpty(privilegeIds)) {
                String[] ids = StringHelper.stringToStringArray(privilegeIds, ",");
                for (String id : ids) {
                    OaTaskTypePrivilege data = new OaTaskTypePrivilege();
                    data.setTaskType(target);
                    data.setPrivilege(sysPrivilegeService.get(Long.valueOf(id)));
                    oaTaskTypePrivilegeService.save(data);
                }
            }

            //刷新任务
            oaTaskManager.reloadTaskType();

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
        OaTaskType taskType = oaTaskTypeService.get(id);
        if (taskType.getOaTasks().size() > 0) {
            sendErrorJSON(response, "删除失败，已存在相应的任务记录");
        } else {
            oaTaskTypeService.delete(id);

            sendSuccessJSON(response, "删除成功");
        }
    }

}