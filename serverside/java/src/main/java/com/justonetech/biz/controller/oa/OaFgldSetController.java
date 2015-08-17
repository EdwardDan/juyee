package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaFgldSetItemService;
import com.justonetech.biz.daoservice.OaFgldSetService;
import com.justonetech.biz.domain.OaFgldSet;
import com.justonetech.biz.domain.OaFgldSetItem;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysDeptService;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysUser;
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
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * note:分管领导审批设置
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaFgldSetController extends BaseCRUDActionController<OaFgldSet> {
    private Logger logger = LoggerFactory.getLogger(OaFgldSetController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private OaFgldSetService oaFgldSetService;

    @Autowired
    private OaFgldSetItemService oaFgldSetItemService;

    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 树+列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String init(Model model) {
        return "view/oa/oaFgldSet/init";
    }

    /**
     * 树显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String tree(Model model, HttpServletRequest request) {

        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_OAFGLDSET_EDIT));

        //上下移动使用
        model.addAttribute("clazz", OaFgldSet.class.getName());

        return "view/oa/oaFgldSet/tree";
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
            treeBranch.addTreeNode(treeBranch.getRootNode("分管领导审批设置树"));
        } else if (StringUtils.equals(id, "root")) {
            String hql = "from OaFgldSet where parent.id is null order by treeId asc";
            List<OaFgldSet> nodeList = oaFgldSetService.findByQuery(hql);
            for (OaFgldSet data : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getUser().getDisplayName());
                treeNode.setIsLeaf(data.getIsLeaf());
                treeNode.setIcon("1");
                treeNode.setType("data");
                treeBranch.addTreeNode(treeNode);
            }
        } else if (StringUtils.equals(type, "data")) {
            String hql = "from OaFgldSet where parent.id=" + id + " order by treeId asc";
            List<OaFgldSet> nodeList = oaFgldSetService.findByQuery(hql);
            for (OaFgldSet data : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getUser().getDisplayName());
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
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_OAFGLDSET_EDIT));

        return "view/oa/oaFgldSet/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from OaFgldSet order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = oaFgldSetService.findByPage(pageModel, queryTranslate.toString());

            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : list) {
                Object id = bean.get("id");
                if (null != id) {
                    OaFgldSet oaFgldSet = oaFgldSetService.get(JspHelper.getLong(id));
                    bean.put("userName", oaFgldSet.getUser().getDisplayName());
                    bean.put("deptNames", oaFgldSet.getDeptNames());
                }
            }

            //输出显示
            String json = GridJq.toJSON(list, pageModel);
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
        OaFgldSet oaFgldSet = new OaFgldSet();

        if (!StringHelper.isEmpty(parentId) && !"root".equals(parentId)) {
            oaFgldSet.setParent(oaFgldSetService.get(Long.valueOf(parentId)));
        }
        model.addAttribute("bean", oaFgldSet);

        return "view/oa/oaFgldSet/input";
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
        OaFgldSet oaFgldSet = oaFgldSetService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", oaFgldSet);

        return "view/oa/oaFgldSet/input";
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
        OaFgldSet oaFgldSet = oaFgldSetService.get(id);

        String userName = oaFgldSet.getUser().getDisplayName(); //人员姓名

        Set<OaFgldSetItem> oaFgldSetItems = oaFgldSet.getOaFgldSetItems();
        String fgDept = "";
        for (OaFgldSetItem oaFgldSetItem : oaFgldSetItems) {
            if (null != oaFgldSetItem.getDept().getName()) {
                fgDept = fgDept + oaFgldSetItem.getDept().getName() + "&nbsp;&nbsp;&nbsp;";
            }
        }
        model.addAttribute("fgDept", fgDept);
        model.addAttribute("bean", oaFgldSet);
        model.addAttribute("userName", userName);
        return "view/oa/oaFgldSet/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaFgldSet entity, HttpServletRequest request) throws Exception {
        try {
            OaFgldSet target;
            if (entity.getId() != null) {
                target = oaFgldSetService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "description"
                });

            } else {
                target = entity;
            }
            //保存所选领导
            String personId = request.getParameter("person");
            if (null != personId && !"".equals(personId)) {
                String hql = "from SysUser where person.id={0}";
                hql = FormatUtils.format(hql, personId);
                List<SysUser> list = sysUserService.findByQuery(hql);
                if (list.size() > 0) {
                    target.setUser(list.get(0));
                }
            }
            //先删除明细表
            Set<OaFgldSetItem> oaFgldSetItems = target.getOaFgldSetItems();
            for (OaFgldSetItem oaFgldSetItem : oaFgldSetItems) {
                oaFgldSetItemService.delete(oaFgldSetItem);
            }
            //保存所选部门
            String sysDeId = request.getParameter("sysDeptId");
            if (null != sysDeId && !"".equals(sysDeId)) {
                String sysDeptIds[] = sysDeId.split(",");
                oaFgldSetService.save(target);
                for (String sysDeptId : sysDeptIds) {
                    SysDept sysDept = sysDeptService.get(JspHelper.getLong(sysDeptId));
                    OaFgldSetItem oaFgldSetItem = new OaFgldSetItem();
                    oaFgldSetItem.setDept(sysDept);
                    oaFgldSetItem.setFgldSet(target);
                    oaFgldSetItemService.save(oaFgldSetItem);
                }
            }
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
        OaFgldSet oaFgldSet = oaFgldSetService.get(id);
        Set<OaFgldSetItem> oaFgldSetItems = oaFgldSet.getOaFgldSetItems();
        for (OaFgldSetItem oaFgldSetItem : oaFgldSetItems) {
            oaFgldSetItemService.delete(oaFgldSetItem);
        }
        oaFgldSetService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}