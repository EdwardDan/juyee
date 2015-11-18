package com.justonetech.biz.controller.project;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.ProjStageService;
import com.justonetech.biz.domain.ProjStage;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
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
import java.util.Calendar;
import java.util.List;


/**
 * note:项目办证阶段管理
 * author: Stanley
 * create date: 2015-05-05
 * modify date: 2015-05-05
 */
@Controller
public class ProjStageController extends BaseCRUDActionController<ProjStage> {
    private Logger logger = LoggerFactory.getLogger(ProjStageController.class);

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
    private ProjStageService projStageService;

    /**
     * 树形与列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String init(Model model) {
        return "view/project/projStage/init";
    }

    /**
     * 树显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String tree(Model model, HttpServletRequest request) {
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.PROJ_STAGE_EDIT));
        //上下移动节点使用
        model.addAttribute("clazz", ProjStage.class.getName());
        return "view/project/projStage/tree";
    }

    /**
     * 获取树数据
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String treeData(String type, String id, String icon, Model model) {
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));
        if (StringUtils.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("项目办证阶段管理树"));
        } else if (StringUtils.equals(id, "root")) {
            String hql = "from ProjStage where parent.id is null order by treeId asc";
            List<ProjStage> nodeList = projStageService.findByQuery(hql);
            for (ProjStage data : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getName());
//                treeNode.setIsLeaf(data.getIsLeaf());
                treeNode.setIsLeaf(data.getProjStages().size() == 0);
                treeNode.setIcon("1");
                treeNode.setType("data");
                treeBranch.addTreeNode(treeNode);
            }
        } else if (StringUtils.equals(type, "data")) {
            String hql = "from ProjStage where parent.id=" + id + " order by treeId asc";
            List<ProjStage> nodeList = projStageService.findByQuery(hql);
            for (ProjStage data : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getName());
//                treeNode.setIsLeaf(data.getIsLeaf());
                treeNode.setIsLeaf(data.getProjStages().size() == 0);
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
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.PROJ_STAGE_EDIT));
        return "view/project/projStage/grid";
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
            String hql = "from ProjStage order by id desc";
            //增加自定义查询条件
            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = projStageService.findByPage(pageModel, query);
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
    public String add(Model model, String parentId) {
        ProjStage projStage = new ProjStage();
        //如需增加其他默认值请在此添加
        if (!StringHelper.isEmpty(parentId) && !"root".equals(parentId)) {
            projStage.setParent(projStageService.get(Long.valueOf(parentId)));
        }
        projStage.setIsValid(true);
        Calendar c = Calendar.getInstance();
        projStage.setYear(c.get(Calendar.YEAR));//默认年份
        model.addAttribute("bean", projStage);
        return "view/project/projStage/input";
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
        ProjStage projStage = projStageService.get(id);
        //处理其他业务逻辑
        model.addAttribute("bean", projStage);
        return "view/project/projStage/input";
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
        ProjStage projStage = projStageService.get(id);
        model.addAttribute("bean", projStage);
        return "view/project/projStage/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") ProjStage entity, HttpServletRequest request) throws Exception {
        try {
            ProjStage target;
            if (entity.getId() != null) {
                target = projStageService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "code",
                        "name",
                        "auditDept",
                        "isValid",
                        "defaultDays",
                        "alertDays",
                        "linkInfo",
                        "year"
                });
            } else {
                target = entity;
            }
            projStageService.save(target);
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
        projStageService.delete(id);
        sendSuccessJSON(response, "删除成功");
    }
}