package com.justonetech.system.controller;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysMenuService;
import com.justonetech.system.daoservice.SysPrivilegeService;
import com.justonetech.system.daoservice.SysRolePrivilegeService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysMenu;
import com.justonetech.system.domain.SysPrivilege;
import com.justonetech.system.domain.SysRolePrivilege;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.tree.ZTreeBranch;
import com.justonetech.system.tree.ZTreeNode;
import com.justonetech.system.utils.PrivilegeCode;
import com.justonetech.system.utils.PrivilegeUtils;
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
import java.util.*;


/**
 * 权限管理
 * author:
 * create date:
 * modify date:
 */
@Controller
public class SysPrivilegeController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(SysPrivilegeController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysPrivilegeService sysPrivilegeService;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private SysRolePrivilegeService sysRolePrivilegeService;

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 树+列表显示页面
     *
     * @param model 。
     */
    @RequestMapping
    public String init(Model model) {

        return "view/system/sysPrivilege/init";
    }

    /**
     * 树显示页面
     *
     * @param model 。
     */
    @RequestMapping
    public String tree(Model model, HttpServletRequest request) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_PRIVILEGE_EDIT));

        model.addAttribute("clazz", SysPrivilege.class.getName());
        return "view/system/sysPrivilege/tree";
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
//            Platform[] values = Platform.values();
//            for (Platform node : values) {
//                boolean isLeaf = false;
//                ZTreeNode treeNode = new ZTreeNode();
//                treeNode.setId(String.valueOf(node.getCode()));
//                treeNode.setIsLeaf(isLeaf);
//                treeNode.setName(node.getName());
//                treeNode.setIcon(Platform.PLATFORM_OA.getCode().equals(node.getCode()) ? "3" : "4");
//                treeNode.setType("platform");
//                ZTreeBranch.addTreeNode(treeNode);
//            }
//        } else if (StringUtils.equals(type, "platform")) {
//            String hql = "from SysPrivilege where parent.id is null and platform=? order by treeId asc";
            String hql = "from SysPrivilege where parent is null order by treeId asc";
            List<SysPrivilege> nodeList = sysPrivilegeService.findByQuery(hql);
            for (SysPrivilege node : nodeList) {
                boolean isLeaf = BooleanUtils.isTrue(node.getIsLeaf());
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(JspHelper.getString(node.getId()));
                treeNode.setIsLeaf(isLeaf);
                treeNode.setName(node.getName());
                treeNode.setIcon("1");
                treeNode.setType("data");
                ZTreeBranch.addTreeNode(treeNode);
            }
        }else if (StringUtils.equals(type, "data")) {
            //按钮权限
            SysCodeDetail privilegeType = sysCodeManager.getCodeDetailByCode(Constants.SYS_PRIVILEGE_TYPE, Constants.SYS_PRIVILEGE_TYPE_BUTTON);

            String hql = "from SysPrivilege where parent.id=" + id + " order by treeId asc";
            List<SysPrivilege> nodeList = sysPrivilegeService.findByQuery(hql);
            for (SysPrivilege node : nodeList) {
                boolean isLeaf = BooleanUtils.isTrue(node.getIsLeaf());
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(JspHelper.getString(node.getId()));
                treeNode.setIsLeaf(isLeaf);
                treeNode.setName(node.getName());

                treeNode.setIcon("1");
                if (privilegeType != null && node.getType().getId().equals(privilegeType.getId())) {
                    treeNode.setIcon("2");
                }

                treeNode.setType("data");
                ZTreeBranch.addTreeNode(treeNode);
            }
        }
        model.addAttribute("msg", ZTreeBranch.toJsonString(true));
        return "common/msg";
    }

    /**
     * 列表显示页面
     *
     * @param model .
     */
    @RequestMapping
    public String grid(Model model) {

        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_PRIVILEGE_EDIT));

        return "view/system/sysPrivilege/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, String platform) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from SysPrivilege where 1=1";
            if (!org.hibernate.util.StringHelper.isEmpty(platform)) {
                hql += " and platform='" + platform + "'";
            }
            hql += " order by treeId desc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = sysPrivilegeService.findByPage(pageModel, query);
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
    public String add(Model model, Long parentId, String platform) {
        SysPrivilege sysPrivilege = new SysPrivilege();

        //如需增加其他默认值请在此添加
        if (parentId != null) {
            SysPrivilege parent = sysPrivilegeService.get(parentId);
            sysPrivilege.setParent(parent);
            sysPrivilege.setPlatform(parent.getPlatform());
        } else {
            sysPrivilege.setPlatform(platform);
        }

        model.addAttribute("bean", sysPrivilege);
        model.addAttribute("typeCode", Constants.SYS_PRIVILEGE_TYPE);

        return "view/system/sysPrivilege/input";
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
        SysPrivilege sysPrivilege = sysPrivilegeService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", sysPrivilege);
        model.addAttribute("typeCode", Constants.SYS_PRIVILEGE_TYPE);

        return "view/system/sysPrivilege/input";
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        SysPrivilege sysPrivilege = sysPrivilegeService.get(id);
        model.addAttribute("bean", sysPrivilege);

        //已授权的角色列表
        model.addAttribute("roles", sysRolePrivilegeService.findByQuery("from SysRolePrivilege where privilege.id=? order by role.roleName asc",id));

        return "view/system/sysPrivilege/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") SysPrivilege entity, HttpServletRequest request) throws Exception {
        try {
            SysPrivilege target;
            if (entity.getId() != null) {
                target = sysPrivilegeService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "code",
                        "name",
                        "tag",
                        "url",
                        "definition",
                        "description",
                        "type",
                        "platform"
                });

            } else {
                target = entity;
            }
            sysPrivilegeService.save(target);
            sysPrivilegeService.flush();

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
        List<SysRolePrivilege> list = sysRolePrivilegeService.findByQuery("from SysRolePrivilege where privilege.id=" + id);
        if (list.size() > 0) {
            for (SysRolePrivilege rolePrivilege : list) {
                sysRolePrivilegeService.delete(rolePrivilege.getId());
            }
            sysPrivilegeService.delete(id);
            sendSuccessJSON(response, "删除成功");
//            sendErrorJSON(response, "删除失败，已被角色引用");
        } else {
            sysPrivilegeService.delete(id);
            sendSuccessJSON(response, "删除成功");
        }
    }

    /**
     * 批量创建按钮权限
     *
     * @param model
     * @param parentId
     * @return
     */
    @RequestMapping
    public String batchInput(Model model, Long parentId) {
        SysPrivilege sysPrivilege = new SysPrivilege();

        //如需增加其他默认值请在此添加
        if (parentId != null) {
            sysPrivilege.setParent(sysPrivilegeService.get(parentId));
        }
        model.addAttribute("bean", sysPrivilege);

        return "view/system/sysPrivilege/batchInput";
    }

    /**
     * 批量创建按钮权限--保存
     *
     * @param response
     * @param request
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void batchInputSave(HttpServletResponse response, HttpServletRequest request) throws Exception {
        try {
            String parentId = request.getParameter("parent");
            String[] batchTypes = request.getParameterValues("batchType");
            if (!StringHelper.isEmpty(parentId)) {
                if (batchTypes != null && batchTypes.length > 0) {
                    SysPrivilege parent = sysPrivilegeService.get(Long.valueOf(parentId));
                    SysCodeDetail privilegeType = sysCodeManager.getCodeDetailByCode(Constants.SYS_PRIVILEGE_TYPE, Constants.SYS_PRIVILEGE_TYPE_BUTTON);
                    if (privilegeType != null) {
                        String name = "";
                        for (String batchType : batchTypes) {
                            if ("edit".equals(batchType)) {
                                name = "编辑";
                            } else if ("audit".equals(batchType)) {
                                name = "审核";
                            } else if ("view".equals(batchType)) {
                                name = "查看";
                            }
                            SysPrivilege data = new SysPrivilege();
                            data.setCode(parent.getCode() + "_" + batchType);
                            data.setName(parent.getName() + "_" + name);
                            data.setType(privilegeType);
                            data.setParent(parent);
                            sysPrivilegeService.save(data);
                        }
                    }
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
     * 查看移动权限
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String move(Long id, Model model) {
        SysPrivilege sysPrivilege = sysPrivilegeService.findUniqueByProperty("id", id);

        //所有权限：去掉子节点和自身节点，去掉按钮
        List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();
        SysCodeDetail codeDetailByCode = sysCodeManager.getCodeDetailByCode(Constants.SYS_PRIVILEGE_TYPE, Constants.SYS_PRIVILEGE_TYPE_BUTTON);
        String hql = "from SysPrivilege where type<> " + codeDetailByCode.getId() + " and treeId not like '" + sysPrivilege.getTreeId() + "%'   order by treeId asc";
        List<SysPrivilege> sysPrivilegeList = sysPrivilegeService.find(hql);
        for (SysPrivilege privilege : sysPrivilegeList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", privilege.getId());
            map.put("name", JspHelper.getLevelStr(privilege.getTreeId(), "&nbsp;&nbsp;&nbsp;") + privilege.getName());//树形节点前加空格
            ret.add(map);
        }
        model.addAttribute("sysList", ret);

        model.addAttribute("bean", sysPrivilege);

        return "view/system/sysPrivilege/move";
    }

    /**
     * 保存权限
     *
     * @param response .
     * @param request  .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void moveSave(HttpServletResponse response, HttpServletRequest request) {
        String id = request.getParameter("id");
        String parentid = request.getParameter("parentid");
        SysPrivilege sysPrivilege = sysPrivilegeService.findUniqueByProperty("id", Long.parseLong(id));

        Long oldParentId = null;
        SysPrivilege oldParent = sysPrivilege.getParent();
        if (oldParent != null) {
            oldParentId = oldParent.getId();
        }

        //判断平台编码是否有变动
        String platform = JspHelper.getString(sysPrivilege.getPlatform());
        String newPlatform = "";

        if (parentid.contains("platform")) {    //移动到第1层
            newPlatform = StringHelper.getElementValue(parentid, "platform");
            sysPrivilege.setParent(null);

            //重置treeid
            String maxTreeId = null;
            List<SysPrivilege> list = sysPrivilegeService.findByQuery("from SysPrivilege where parent is null order by treeId desc");
            if (list.size() > 0) {
                SysPrivilege next = list.iterator().next();
                maxTreeId = next.getTreeId();
            }
            String nextTreeId = PrivilegeUtils.getNextTreeId(null, maxTreeId);
            sysPrivilege.setTreeId(nextTreeId);
            sysPrivilegeService.save(sysPrivilege);

            setTreeId(sysPrivilege,nextTreeId);

        } else {        //移动到第2层或第N层
            SysPrivilege parentsysPrivilege = sysPrivilegeService.findUniqueByProperty("id", Long.parseLong(parentid));
            sysPrivilege.setParent(parentsysPrivilege);
            newPlatform = JspHelper.getString(parentsysPrivilege.getPlatform());

            //重置treeid
            String maxTreeId = null;
            List<SysPrivilege> list = sysPrivilegeService.findByQuery("from SysPrivilege where parent.id=" + parentid + " order by treeId desc");
            if (list.size() > 0) {
                SysPrivilege next = list.iterator().next();
                maxTreeId = next.getTreeId();
            }
            sysPrivilege.setTreeId(PrivilegeUtils.getNextTreeId(parentsysPrivilege.getTreeId(), maxTreeId));
            String nextTreeId = PrivilegeUtils.getNextTreeId(parentsysPrivilege.getTreeId(), maxTreeId);
            sysPrivilege.setTreeId(nextTreeId);
            sysPrivilegeService.save(sysPrivilege);

            if (parentsysPrivilege.getIsLeaf()) {
                parentsysPrivilege.setIsLeaf(false);
                sysPrivilegeService.save(parentsysPrivilege);
            }
            setTreeId(sysPrivilege,nextTreeId);
        }

        //更新父节点的叶节点标记
        if (oldParentId != null) {
            List<SysPrivilege> list = sysPrivilegeService.findByQuery("from SysPrivilege where parent.id=" + oldParentId + " and id<>" + id);
            if (list.size() == 0) {
                oldParent.setIsLeaf(true);
                sysPrivilegeService.save(oldParent);
            }
        }

        //更新平台编码
        if (!platform.equals(newPlatform)) {
            String hql = "from SysPrivilege where treeId like '" + sysPrivilege.getTreeId() + "%' order by treeId asc";
            List<SysPrivilege> privileges = sysPrivilegeService.findByQuery(hql);
            for (SysPrivilege privilege : privileges) {
                if (!newPlatform.equals(privilege.getPlatform())) {
                    privilege.setPlatform(newPlatform);
                    sysPrivilegeService.save(privilege);
                }
            }
        }

        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 设置子节点的treeId
     * @param privilege .
     * @param treeId .
     */
    private void setTreeId(SysPrivilege privilege,String treeId){
        Set<SysPrivilege> childs = privilege.getSysPrivileges();
        if(childs.size()>0){
            String lastTreeId = null;
            for (SysPrivilege child : childs) {
                lastTreeId = PrivilegeUtils.getNextTreeId(treeId, lastTreeId != null?lastTreeId:null);
                child.setTreeId(lastTreeId);
                sysPrivilegeService.save(child);

                setTreeId(child,lastTreeId);
            }
        }
    }

    /**
     * 新增录入页面--从菜单添加
     *
     * @param model .
     */
    @RequestMapping
    public String addFromMenu(Model model, Long parentId, String platform) {
        SysPrivilege sysPrivilege = new SysPrivilege();

        //如需增加其他默认值请在此添加
        if (parentId != null) {
            SysPrivilege parent = sysPrivilegeService.get(parentId);
            sysPrivilege.setParent(parent);
            sysPrivilege.setPlatform(parent.getPlatform());
        } else {
            sysPrivilege.setPlatform(platform);
        }
        model.addAttribute("bean", sysPrivilege);
        model.addAttribute("typeCode", Constants.SYS_PRIVILEGE_TYPE);

        return "view/system/sysPrivilege/inputFromMenu";
    }

    /**
     * 保存操作--从菜单添加
     *
     * @param response .
     * @param request  .
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void addFromMenuSave(HttpServletResponse response, HttpServletRequest request) throws Exception {
        try {
            String platform = request.getParameter("platform");
            String parent = request.getParameter("parent");
            String menuIds = request.getParameter("menuIds");
//            System.out.println("platform = " + platform);
//            System.out.println("parent = " + parent);
//            System.out.println("menuIds = " + menuIds);
            if (!StringHelper.isEmpty(menuIds)) {
                String[] ids = StringHelper.stringToStringArray(menuIds,",");
                for (String id : ids) {
                    SysMenu menu = sysMenuService.get(Long.valueOf(id));
                    SysPrivilege data = new SysPrivilege();
                    data.setPlatform(platform);
                    if (!StringHelper.isEmpty(parent)) {
                        SysPrivilege parentData = sysPrivilegeService.get(Long.valueOf(parent));
                        data.setParent(parentData);
                        data.setPlatform(parentData.getPlatform());
                    }
                    data.setType(sysCodeManager.getCodeDetailByCode(Constants.SYS_PRIVILEGE_TYPE, Constants.SYS_PRIVILEGE_TYPE_PAGE));
                    data.setCode(menu.getPrivilege());
                    data.setName(menu.getName());
                    sysPrivilegeService.save(data);
                }
            }
            sysPrivilegeService.flush();

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }
}