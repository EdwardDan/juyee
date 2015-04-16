package com.justonetech.system.controller;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.Platform;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysMenuService;
import com.justonetech.system.domain.SysMenu;
import com.justonetech.system.manager.SysMenuManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.tree.ZTreeBranch;
import com.justonetech.system.tree.ZTreeNode;
import com.justonetech.system.utils.PrivilegeCode;
import com.justonetech.system.utils.PrivilegeUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
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
import java.io.File;
import java.util.*;


/**
 * 菜单管理
 * author:
 * create date:
 * modify date:
 */
@Controller
public class SysMenuController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(SysMenuController.class);

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysMenuManager sysMenuManager;


    /**
     * 树+列表显示页面
     *
     * @param model 。
     */
    @RequestMapping
    public String init(Model model) {
        return "view/system/sysMenu/init";
    }

    /**
     * 树显示页面
     *
     * @param model 。
     */
    @RequestMapping
    public String tree(Model model, HttpServletRequest request) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_MENU_EDIT));
        model.addAttribute("clazz", SysMenu.class.getName());
        return "view/system/sysMenu/tree";
    }

    /**
     * 获取树数据
     *
     * @param model 。
     */
    @RequestMapping
    public String treeData(String type, String id, String icon, Model model) {
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));

        if (StringUtils.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("根节点"));
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
//                treeBranch.addTreeNode(treeNode);
//            }
//        } else if (StringUtils.equals(type, "platform")) {
//            String hql = "from SysMenu where parent.id is null and platform=? order by treeId asc";
            String hql = "from SysMenu where parent is null order by treeId asc";
            List<SysMenu> nodeList = sysMenuService.findByQuery(hql);
            for (SysMenu node : nodeList) {
                boolean isLeaf = node.getSysMenus().size() == 0;
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(node.getId()));
                treeNode.setIsLeaf(isLeaf);
                treeNode.setName(node.getName());
                treeNode.setIcon(node.getIsValid() ? "1" : "2");
                treeNode.setType("data");
                treeBranch.addTreeNode(treeNode);
            }
        } else if (StringUtils.equals(type, "data")) {
            String hql = "from SysMenu where parent.id=" + id + " order by treeId asc";
            List<SysMenu> nodeList = sysMenuService.findByQuery(hql);
            for (SysMenu node : nodeList) {
                boolean isLeaf = node.getSysMenus().size() == 0;
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(node.getId()));
                treeNode.setIsLeaf(isLeaf);
                treeNode.setName(node.getName());
                treeNode.setIcon(node.getIsValid() ? "1" : "2");
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
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_MENU_EDIT));

        return "view/system/sysMenu/grid";
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
            String hql = "from SysMenu where 1=1";
            if (!StringHelper.isEmpty(platform)) {
                hql += " and platform='" + platform + "'";
            }
            hql += " order by treeId desc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = sysMenuService.findByPage(pageModel, query);
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
    public String add(Model model, String parentId, String platform) {
        if (StringHelper.isEmpty(platform)) {
            platform = Platform.PLATFORM_OA.getCode();
        }
        SysMenu sysMenu = new SysMenu();
        sysMenu.setIsValid(true);
        sysMenu.setPlatform(platform);

        //如需增加其他默认值请在此添加
        String[] menuIcons = getMenuIcons();
        if (!StringHelper.isEmpty(parentId) && !"root".equals(parentId)) {
            SysMenu parent = sysMenuService.get(Long.valueOf(parentId));
            sysMenu.setParent(parent);
            sysMenu.setPlatform(parent.getPlatform());
        }

        sysMenu.setIcon(menuIcons[0]);
        model.addAttribute("bean", sysMenu);

        //图标
        model.addAttribute("MENU_ICON_LIST", menuIcons);

        return "view/system/sysMenu/input";
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
        SysMenu sysMenu = sysMenuService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", sysMenu);

        //图标
        model.addAttribute("MENU_ICON_LIST", getMenuIcons());

        return "view/system/sysMenu/input";
    }

    //获取菜单图标供选择
    private String[] getMenuIcons(){
        String iconPath = getServletContext().getRealPath("/")+"skin\\default\\index_new\\menu_icon";
        IOFileFilter ioFileFilter = FileFilterUtils.prefixFileFilter("");
        Collection<File> files = FileUtils.listFiles(new File(iconPath), ioFileFilter, null);
        String[] icons = new String[files.size()];
        int i = 0;
        for (File file : files) {
            icons[i] = FilenameUtils.getBaseName(file.getName());
            i++;
        }
        return icons;
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        SysMenu sysMenu = sysMenuService.get(id);
        model.addAttribute("bean", sysMenu);

        return "view/system/sysMenu/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") SysMenu entity, HttpServletRequest request) throws Exception {
        try {
            SysMenu target;
            if (entity.getId() != null) {
                target = sysMenuService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "name",
                        "privilege",
                        "menuLevel",
                        "url",
                        "jsEvent",
                        "isValid",
                        "param",
                        "target",
                        "icon",
                        "platform"
                });
                String parentId = request.getParameter("parent");
                if (!StringHelper.isEmpty(parentId)) {
                    target.setParent(sysMenuService.get(Long.valueOf(parentId)));
                }


            } else {
                target = entity;
            }
            sysMenuService.save(target);

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
        sysMenuService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 移动节点
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String move(Long id, Model model) {
        SysMenu sysMenu = sysMenuService.findUniqueByProperty("id", id);

        //所有菜单：去掉子节点和自身节点
        List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();
        String hql = "from SysMenu where treeId not like '" + sysMenu.getTreeId() + "%' order by platform asc,treeId asc";
        List<SysMenu> menuList = sysMenuService.findByQuery(hql);
        for (SysMenu menu : menuList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", menu.getId());
            map.put("name", JspHelper.getLevelStr(menu.getTreeId(), "&nbsp;&nbsp;&nbsp;") + menu.getName());
            ret.add(map);
        }
        model.addAttribute("menuList", ret);

        model.addAttribute("bean", sysMenu);
        return "view/system/sysMenu/move";
    }

    /**
     * 保存移动
     *
     * @param response .
     * @param request  .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void moveSave(HttpServletResponse response, HttpServletRequest request) {
        String id = request.getParameter("id");
        String parentid = request.getParameter("parentid");
        SysMenu sysMenu = sysMenuService.findUniqueByProperty("id", Long.parseLong(id));

        Long oldParentId = null;
        SysMenu oldParent = sysMenu.getParent();
        if (oldParent != null) {
            oldParentId = oldParent.getId();
        }
        //判断平台编码是否有变动
        String platform = JspHelper.getString(sysMenu.getPlatform());
        String newPlatform = "";

        if (parentid.contains("platform")) {    //移动到第1层
            newPlatform = StringHelper.getElementValue(parentid, "platform");
            sysMenu.setParent(null);

            //重置treeid
            String maxTreeId = null;
            List<SysMenu> list = sysMenuService.findByQuery("from SysMenu where parent is null order by treeId desc");
            if (list.size() > 0) {
                SysMenu next = list.iterator().next();
                maxTreeId = next.getTreeId();
            }
            String nextTreeId = PrivilegeUtils.getNextTreeId(null, maxTreeId);
            sysMenu.setTreeId(nextTreeId);
            sysMenuService.save(sysMenu);

            setTreeId(sysMenu,nextTreeId);

        } else {      //移动到第2层或第N层
            SysMenu parentsysMenu = sysMenuService.findUniqueByProperty("id", Long.parseLong(parentid));
            sysMenu.setParent(parentsysMenu);
            newPlatform = JspHelper.getString(parentsysMenu.getPlatform());

            //重置treeid
            String maxTreeId = null;
            List<SysMenu> list = sysMenuService.findByQuery("from SysMenu where parent.id=" + parentid + " order by treeId desc");
            if (list.size() > 0) {
                SysMenu next = list.iterator().next();
                maxTreeId = next.getTreeId();
            }
            String nextTreeId = PrivilegeUtils.getNextTreeId(parentsysMenu.getTreeId(), maxTreeId);
            sysMenu.setTreeId(nextTreeId);
            sysMenuService.save(sysMenu);

            if (parentsysMenu.getIsLeaf()) {
                parentsysMenu.setIsLeaf(false);
                sysMenuService.save(parentsysMenu);
            }

            setTreeId(sysMenu,nextTreeId);
        }

        //更新父节点的叶节点标记
        if (oldParentId != null) {
            List<SysMenu> list = sysMenuService.findByQuery("from SysMenu where parent.id=" + oldParentId + " and id<>" + id);
            if (list.size() == 0) {
                oldParent.setIsLeaf(true);
                sysMenuService.save(oldParent);
            }
        }

        //更新平台编码
        if (!platform.equals(newPlatform)) {
            String hql = "from SysMenu where treeId like '" + sysMenu.getTreeId() + "%' order by treeId asc";
            List<SysMenu> menus = sysMenuService.findByQuery(hql);
            for (SysMenu menu : menus) {
                if (!newPlatform.equals(menu.getPlatform())) {
                    menu.setPlatform(newPlatform);
                    sysMenuService.save(menu);
                }
            }
        }

        sendSuccessJSON(response, "移动成功");
    }

    /**
     * 设置子节点的treeId
     * @param menu .
     * @param treeId .
     */
    private void setTreeId(SysMenu menu,String treeId){
        Set<SysMenu> childs = menu.getSysMenus();
        if(childs.size()>0){
            String lastTreeId = null;
            for (SysMenu child : childs) {
                lastTreeId = PrivilegeUtils.getNextTreeId(treeId, lastTreeId != null?lastTreeId:null);
                child.setTreeId(lastTreeId);
                sysMenuService.save(child);

                setTreeId(child,lastTreeId);
            }
        }
    }
}