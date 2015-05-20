package com.justonetech.system.controller;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.daoservice.SysDeptService;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.tree.ZTreeBranch;
import com.justonetech.system.tree.ZTreeNode;
import com.justonetech.system.utils.PrivilegeCode;
import net.sf.json.JSONArray;
import org.apache.commons.lang.BooleanUtils;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * author:
 * create date:
 * modify date:
 */
@Controller
public class SysDeptController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(SysDeptController.class);

    @Autowired
    private SysDeptService sysDeptService;

    @Autowired
    protected SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    /**
     * 列表显示页面
     *
     * @param model .
     */
    @RequestMapping
    public String grid(Model model) {
        return "view/system/sysDept/grid";
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
            String hql = "from SysDept where category.id = " + sysCodeManager.getCodeDetailByCode(Constants.SYS_DEPT_CATAGORY, Constants.OWNER_UNIT).getId() + " order by treeId desc";
            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = sysDeptService.findByPage(pageModel, query);
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
    public String addDw(Model model, Long parentId) {
        SysDept sysDept = new SysDept();

        //如需增加其他默认值请在此添加
        if (parentId != null) {
            sysDept.setParent(sysDeptService.get(parentId));
        }
        sysDept.setIsTag(true);

        model.addAttribute("bean", sysDept);

        return "view/system/sysDept/inputDw";
    }

    /**
     * 新增录入页面
     *
     * @param model .
     */
    @RequestMapping
    public String addDept(Model model, Long parentId) {
        SysDept sysDept = new SysDept();

        //如需增加其他默认值请在此添加
        if (parentId != null) {
            sysDept.setParent(sysDeptService.get(parentId));
        }
        sysDept.setIsTag(false);

        model.addAttribute("bean", sysDept);

        return "view/system/sysDept/inputDept";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modifyDw(Model model, Long id) {
        SysDept sysDept = sysDeptService.get(id);

        //处理其他业务逻辑

        model.addAttribute("bean", sysDept);
        return "view/system/sysDept/inputDw";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modifyDept(Model model, Long id) {
        SysDept sysDept = sysDeptService.get(id);

        //处理其他业务逻辑

        model.addAttribute("bean", sysDept);
        return "view/system/sysDept/inputDept";
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     */
    @RequestMapping
    public String viewDw(Model model, Long id) {
        SysDept sysDept = sysDeptService.get(id);

        model.addAttribute("bean", sysDept);
        return "view/system/sysDept/viewDw";
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     */
    @RequestMapping
    public String viewDept(Model model, Long id) {
        SysDept sysDept = sysDeptService.get(id);

        model.addAttribute("bean", sysDept);
        return "view/system/sysDept/viewDept";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") SysDept entity, HttpServletRequest request) throws Exception {
        try {
            SysDept target;
            if (entity.getId() != null) {
                target = sysDeptService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "code",
                        "name",
                        "shortName",
//                        "isLeaf",
//                        "treeId",
                        "cardNo",
                        "cityCode",
                        "cityName",
                        "provinceCode",
                        "provinceName",
                        "address",
                        "orderNo",
                        "isTag",
                        "memo",
//                        "createTime",
//                        "updateTime",
//                        "createUser",
//                        "updateUser",
                        "isValid"
                });
            } else {
                target = entity;
            }
            target.setCategory(sysCodeManager.getCodeDetailByCode(Constants.SYS_DEPT_CATAGORY, Constants.OWNER_UNIT));
            sysDeptService.save(target);
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
        sysDeptService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 获取树数据
     *
     * @param model 。
     */
    @RequestMapping
    public String treeDataForSelect(String type, String id, String icon, Model model) {
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));

        if (StringUtils.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("根节点"));
        } else if (StringUtils.equals(id, "root")) {
            String hql = "from SysDept where parent.id is null order by treeId asc";
            List<SysDept> nodeList = sysDeptService.findByQuery(hql);
            for (SysDept data : nodeList) {
                boolean isLeaf = data.getChildren().size() == 0;
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setIsLeaf(isLeaf);
                treeNode.setName(data.getName());
                if (BooleanUtils.isTrue(data.getIsTag())) {
                    treeNode.setIcon("1");
                    treeNode.setType("unit");
                } else {
                    treeNode.setIcon("2");
                    treeNode.setType("dept");
                }
                treeBranch.addTreeNode(treeNode);
            }
        } else if (StringUtils.equals(type, "unit") || StringUtils.equals(type, "dept")) {
            String hql = "from SysDept where parent.id=" + id + " order by treeId asc";
            List<SysDept> nodeList = sysDeptService.findByQuery(hql);
            for (SysDept data : nodeList) {
                boolean isLeaf = data.getChildren().size() == 0;
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setIsLeaf(isLeaf);
                treeNode.setName(data.getName());
                if (BooleanUtils.isTrue(data.getIsTag())) {
                    treeNode.setIcon("1");
                    treeNode.setType("unit");
                } else {
                    treeNode.setIcon("2");
                    treeNode.setType("dept");
                }
                treeBranch.addTreeNode(treeNode);
            }
        }
        model.addAttribute("msg", treeBranch.toJsonString(true));
        return "common/msg";
    }

    /**
     * 树+列表显示页面
     *
     * @param model 。
     */
    @RequestMapping
    public String init(Model model) {

        return "view/system/sysDept/init";
    }

    /**
     * 树显示页面
     *
     * @param model 。
     */
    @RequestMapping
    public String tree(Model model, HttpServletRequest request) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_DEPT_EDIT));

        model.addAttribute("clazz", SysDept.class.getName());
        return "view/system/sysDept/tree";
    }

    /**
     * 获取树数据
     *
     * @param model 。
     */
    @RequestMapping
    public String treeData(String type, String id, String icon, Model model) {
        ZTreeBranch ZTreeBranch = new ZTreeBranch();
        ZTreeBranch.setIcons(icon.split(","));

        if (StringUtils.isEmpty(id)) {
            ZTreeBranch.addTreeNode(ZTreeBranch.getRootNode("根节点"));
        } else if (StringUtils.equals(id, "root")) {
            String hql = "from SysDept where parent.id is null order by treeId asc";
            List<SysDept> nodeList = sysDeptService.findByQuery(hql);
            for (SysDept node : nodeList) {
                boolean isLeaf = BooleanUtils.isTrue(node.getIsLeaf());
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(JspHelper.getString(node.getId()));
                treeNode.setIsLeaf(isLeaf);
                treeNode.setName(node.getName());
                if (BooleanUtils.isTrue(node.getIsTag())) {
                    treeNode.setIcon("1");
                    treeNode.setType("unit");
                } else {
                    treeNode.setIcon("2");
                    treeNode.setType("dept");
                }
                ZTreeBranch.addTreeNode(treeNode);
            }
        } else if (StringUtils.equals(type, "unit") || StringUtils.equals(type, "dept")) {
            String hql = "from SysDept where parent.id=" + id + " order by treeId asc";
            List<SysDept> nodeList = sysDeptService.findByQuery(hql);
            for (SysDept node : nodeList) {
                boolean isLeaf = BooleanUtils.isTrue(node.getIsLeaf());
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(JspHelper.getString(node.getId()));
                treeNode.setIsLeaf(isLeaf);
                treeNode.setName(node.getName());
                if (BooleanUtils.isTrue(node.getIsTag())) {
                    treeNode.setIcon("1");
                    treeNode.setType("unit");
                } else {
                    treeNode.setIcon("2");
                    treeNode.setType("dept");
                }
                ZTreeBranch.addTreeNode(treeNode);
            }
        }
        model.addAttribute("msg", ZTreeBranch.toJsonString(true));
        return "common/msg";
    }

    /**
     * 获取业主部门列表
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String getOwnerDepts(Model model) {
        List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();
        List<SysDept> list = sysDeptService.findByQuery("from SysDept where parent.code=? order by treeId asc", Constants.SYS_DEPT_OWNER);
        for (SysDept sysDept : list) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", sysDept.getId());
            map.put("name", sysDept.getName());
            ret.add(map);
        }
        model.addAttribute("msg", JSONArray.fromObject(ret).toString());
        return "common/msg";
    }
}