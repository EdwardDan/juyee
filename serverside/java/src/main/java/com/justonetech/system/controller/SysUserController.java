package com.justonetech.system.controller;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.CryptUtil;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.daoservice.SysDeptService;
import com.justonetech.system.daoservice.SysPersonDeptService;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.domain.SysPersonDept;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.tree.ZTreeBranch;
import com.justonetech.system.tree.ZTreeNode;
import com.justonetech.system.utils.Md5Utils;
import com.justonetech.system.utils.PrivilegeCode;
import com.justonetech.system.utils.UserSessionUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
 * User: Chen Junping
 * Date: 12-2-23
 */
@Controller
public class SysUserController extends BaseCRUDActionController {
    @Autowired
    SysUserService sysUserService;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysDeptService sysDeptService;

    @Autowired
    private SysPersonDeptService sysPersonDeptService;

    /**
     * 用户列表
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_USER_EDIT));

        return "view/system/sysUser/grid";
    }

    /**
     * 用户列表数据
     *
     * @param response
     * @param filters
     * @param columns
     * @param page
     * @param rows
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session) {
        try {
            Page<SysUser> pageModel = new Page<SysUser>(page, rows, true);
            String hql = "select t from SysUser t" +
                    " left join t.person sp" +
                    " left join sp.sysPersonDepts spd" +
                    " left join spd.dept dept "+
                    " where t.regPerson is null";
            hql += " order by dept.treeId asc,spd.orderNo asc,sp.name asc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = sysUserService.findByPage(pageModel, query);
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
    public String add(Model model) {
        SysUser sysUser = new SysUser();
        sysUser.setStatus(UserSessionUtils.USER_STATUS_VALID);
        model.addAttribute("bean", sysUser);

        //拥有角色
        model.addAttribute("roles", sysUserManager.getRoleList(sysUser));


        return "view/system/sysUser/input";
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
        SysUser sysUser = sysUserService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", sysUser);

        //拥有角色
        model.addAttribute("roles", sysUserManager.getRoleList(sysUser));

        return "view/system/sysUser/input";
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        SysUser sysUser = sysUserService.get(id);
        model.addAttribute("bean", sysUser);

        //拥有角色
        model.addAttribute("roles", sysUserManager.getRoleList(sysUser));

        return "view/system/sysUser/view";
    }

    /**
     * 保存用户信息
     *
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") SysUser entity, HttpServletRequest request) {
        try {
            SysUser target;
            if (entity.getId() != null) {
                target = sysUserService.get(entity.getId());
                String columns = "loginName,displayName,status,person";
                ReflectionUtils.copyBean(entity, target, columns.split(","));

                String password = request.getParameter("confirmPassword");
                if (!StringHelper.isEmpty(password)) {
                    target.setPassword(CryptUtil.encrypt(password.trim()));
                    target.setMd5Pass(Md5Utils.md5(password.trim()));
                    target.setPasswordUpdateTime(new Timestamp(System.currentTimeMillis()));
                }

            } else {
                target = entity;
                if (target.getStatus() == null) {
                    target.setStatus(UserSessionUtils.USER_STATUS_VALID);
                }

                String password = target.getPassword();
                if (!StringHelper.isEmpty(password)) {
                    target.setPassword(CryptUtil.encrypt(password.trim()));
                    target.setMd5Pass(Md5Utils.md5(password.trim()));
                }
                target.setPasswordUpdateTime(new Timestamp(System.currentTimeMillis()));
            }

            sysUserService.save(target);

            //save roles
            sysUserManager.saveRoles(target, request.getParameterValues("roleId"));

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }


    /**
     * 删除数据
     *
     * @param response
     * @param id
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) {
        sysUserManager.delete(id);

        sendSuccessJSON(response, "删除成功");
    }


    /**
     * 用户选择树
     *
     * @param type
     * @param id
     * @param icon
     * @param model 。
     * @return
     */
    @RequestMapping
    public String treeDataForSelect(String type, String id, String icon, Model model) {
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));

        if (StringUtils.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("根节点"));
        } else if (StringUtils.equals(id, "root")) {
            //单位
            String hql = "from SysDept where parent.id is null order by treeId asc";
            List<SysDept> nodeList = sysDeptService.findByQuery(hql);
            for (SysDept data : nodeList) {
                boolean isLeaf = data.getChildren().size() == 0;
                if (isLeaf) {
                    isLeaf = data.getSysPersonDepts().size() == 0;
                }
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setIsLeaf(isLeaf);
                treeNode.setName(data.getName());
                if (data.getIsTag() != null && data.getIsTag()) {
                    treeNode.setIcon("1");
                    treeNode.setType("company");
                } else {
                    treeNode.setIcon("2");
                    treeNode.setType("dept");
                }
                treeBranch.addTreeNode(treeNode);
            }
        } else if (StringUtils.equals(type, "company") || StringUtils.equals(type, "dept")) {
            //单位/部门
            String hql = "from SysDept where parent.id=" + id + " order by treeId asc";
            List<SysDept> nodeList = sysDeptService.findByQuery(hql);
            for (SysDept data : nodeList) {
                boolean isLeaf = data.getChildren().size() == 0;
                if (isLeaf) {
                    isLeaf = data.getSysPersonDepts().size() == 0;
                }
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setIsLeaf(isLeaf);
                treeNode.setName(data.getName());
                if (data.getIsTag() != null && data.getIsTag()) {
                    treeNode.setIcon("1");
                    treeNode.setType("company");
                } else {
                    treeNode.setIcon("2");
                    treeNode.setType("dept");
                }
                treeBranch.addTreeNode(treeNode);
            }

            //人员
            List<SysPersonDept> personDeptList = sysPersonDeptService.findByQuery("from SysPersonDept where dept.id=" + id + " order by orderNo,person.name asc");
            for (SysPersonDept personDept : personDeptList) {
                SysPerson person = personDept.getPerson();
                Set<SysUser> sysUsers = person.getSysUsers();

                for (SysUser sysUser : sysUsers) {
                    ZTreeNode treeNode = new ZTreeNode();
                    treeNode.setId(String.valueOf(sysUser.getId()));
                    treeNode.setIsLeaf(true);
                    treeNode.setName(sysUser.getDisplayName());
                    treeNode.setIcon("3");
                    treeNode.setType("sysUser");
                    treeBranch.addTreeNode(treeNode);
                }

            }
        }
        String s = treeBranch.toJsonString(false);
        model.addAttribute("msg", s);
        return "common/msg";
    }

}