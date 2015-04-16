package com.justonetech.biz.controller.document;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocCategoryService;
import com.justonetech.biz.domain.DocCategory;
import com.justonetech.biz.utils.Constants;
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


/**
 * note:文档目录
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class DocCategoryController extends BaseCRUDActionController<DocCategory> {
    //logback+slf4j
    private Logger logger = LoggerFactory.getLogger(DocCategoryController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private DocCategoryService docCategoryService;

    /**
     * 树+列表显示页面
     *
     * @param model .
     */
    @RequestMapping
    public String init(Model model) {
        return "view/document/docCategory/init";
    }

    /**
     * 树显示页面
     *
     * @param model .
     */
    @RequestMapping
    public String tree(Model model, HttpServletRequest request) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.DOC_CATEGORY_EDIT));
        model.addAttribute("clazz", DocCategory.class.getName());

        return "view/document/docCategory/tree";
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
            treeBranch.addTreeNode(treeBranch.getRootNode("文档目录树"));
        } else if (StringUtils.equals(id, "root")) {
            String hql = "from DocCategory where parent.id is null order by treeId asc";
            List<DocCategory> nodeList = docCategoryService.findByQuery(hql);
            for (DocCategory data : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getName());
                treeNode.setIsLeaf(data.getIsLeaf());
                treeNode.setIcon("1");
                treeNode.setType("data");
                treeBranch.addTreeNode(treeNode);
            }
        } else if (StringUtils.equals(type, "data")) {
            String hql = "from DocCategory where parent.id=" + id + " order by treeId asc";
            List<DocCategory> nodeList = docCategoryService.findByQuery(hql);
            for (DocCategory data : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getName());
                treeNode.setIsLeaf(data.getIsLeaf());
                treeNode.setIcon("1");
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

        return "view/document/docCategory/grid";
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
            String hql = "from DocCategory order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = docCategoryService.findByPage(pageModel, query);
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
        DocCategory docCategory = new DocCategory();

        //如需增加其他默认值请在此添加
        if (!StringHelper.isEmpty(parentId) && !"root".equals(parentId)) {
            docCategory.setParent(docCategoryService.get(Long.valueOf(parentId)));
        }
        model.addAttribute("bean", docCategory);

        return "view/document/docCategory/input";
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
        DocCategory docCategory = docCategoryService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", docCategory);

        return "view/document/docCategory/input";
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        DocCategory docCategory = docCategoryService.get(id);

        model.addAttribute("bean", docCategory);
        return "view/document/docCategory/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") DocCategory entity, HttpServletRequest request) throws Exception {
        try {
            DocCategory target;
            if (entity.getId() != null) {
                target = docCategoryService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "code",
                        "name",
                        "path",
                        "bizCode",
                        "bizName"
                });

            } else {
                target = entity;
            }
            docCategoryService.save(target);

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
        DocCategory category = docCategoryService.get(id);
        if (category.getDocDocuments().size() > 0) {
            sendErrorJSON(response, "删除失败，该目录下已经有文档");
        } else {
            docCategoryService.delete(id);
            sendSuccessJSON(response, "删除成功");
        }
    }

}