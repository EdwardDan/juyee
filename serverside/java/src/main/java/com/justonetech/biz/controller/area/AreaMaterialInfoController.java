package com.justonetech.biz.controller.area;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.AreaMaterialInfoService;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.domain.AreaMaterialInfo;
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
 * note:区县施工材料信息
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class AreaMaterialInfoController extends BaseCRUDActionController<AreaMaterialInfo> {
    private Logger logger = LoggerFactory.getLogger(AreaMaterialInfoController.class);

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
    private AreaMaterialInfoService areaMaterialInfoService;

    /**
     * 树+列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String init(Model model) {
        return "view/area/areaMaterialInfo/init";
    }

    /**
     * 树显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String tree(Model model, HttpServletRequest request) {
        model.addAttribute("canEdit", true);
        model.addAttribute("clazz", AreaMaterialInfo.class.getName());

        return "view/area/areaMaterialInfo/tree";
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
            treeBranch.addTreeNode(treeBranch.getRootNode("区县施工材料信息树"));
        } else if (StringUtils.equals(id, "root")) {
            String hql = "from AreaMaterialInfo where parent.id is null order by treeId asc";
            List<AreaMaterialInfo> nodeList = areaMaterialInfoService.findByQuery(hql);
            for (AreaMaterialInfo data : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getProjectType().getName());
                treeNode.setIsLeaf(data.getIsLeaf());
                treeNode.setIcon("1");
                treeNode.setType("info");
                treeBranch.addTreeNode(treeNode);
            }
        } else if (StringUtils.equals(type, "info")) {
            String hql = "from AreaMaterialInfo where parent.id=" + id + " order by treeId asc";
            List<AreaMaterialInfo> nodeList = areaMaterialInfoService.findByQuery(hql);
            for (AreaMaterialInfo data : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getMaterialName());
                treeNode.setIsLeaf(data.getIsLeaf());
                treeNode.setIcon("2");
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
        //判断是否有编辑权限
        model.addAttribute("canEdit", true);

        return "view/area/areaMaterialInfo/grid";
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
            String hql = "from AreaMaterialInfo order by treeId asc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = areaMaterialInfoService.findByPage(pageModel, query);

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 添加单位类型
     *
     * @param model .
     */
    @RequestMapping
    public String addProjectType(Model model, Long parentId) {
        AreaMaterialInfo sgMaterialInfo = new AreaMaterialInfo();
        if (parentId != null) {
            sgMaterialInfo.setParent(areaMaterialInfoService.get(parentId));
        }

        model.addAttribute("bean", sgMaterialInfo);
        model.addAttribute("PROJECT_TYPE", Constants.PROJECT_TYPE);

        return "view/area/areaMaterialInfo/inputProjectType";
    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model, String parentId) {
        AreaMaterialInfo sgMaterialInfo = new AreaMaterialInfo();

        if (!StringHelper.isEmpty(parentId)) {
            AreaMaterialInfo info = areaMaterialInfoService.get(Long.valueOf(parentId));
            sgMaterialInfo.setParent(info);
            sgMaterialInfo.setProjectType(info.getProjectType());
        }
        model.addAttribute("bean", sgMaterialInfo);


        return "view/area/areaMaterialInfo/input";
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
        AreaMaterialInfo areaMaterialInfo = areaMaterialInfoService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", areaMaterialInfo);

        return "view/area/areaMaterialInfo/input";
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
        AreaMaterialInfo areaMaterialInfo = areaMaterialInfoService.get(id);

        model.addAttribute("bean", areaMaterialInfo);

        return "view/area/areaMaterialInfo/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") AreaMaterialInfo entity, HttpServletRequest request) throws Exception {
        try {
            AreaMaterialInfo target;
            if (entity.getId() != null) {
                target = areaMaterialInfoService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "no",
                        "type",
                        "materialName",
                        "auditReq",
                        "auditReqGreen",
                        "projectType",
                        "yjNum"
                });

            } else {
                target = entity;
            }
            areaMaterialInfoService.save(target);

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
        areaMaterialInfoService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}
