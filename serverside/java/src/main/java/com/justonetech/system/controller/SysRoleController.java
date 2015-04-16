package com.justonetech.system.controller;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.daoservice.SysPrivilegeService;
import com.justonetech.system.daoservice.SysRolePrivilegeService;
import com.justonetech.system.daoservice.SysRoleService;
import com.justonetech.system.daoservice.SysUserRoleService;
import com.justonetech.system.domain.*;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysPrivilegeManager;
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
import java.util.*;


/**
 * author:
 * create date:
 * modify date:
 */
@Controller
public class SysRoleController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(SysRoleController.class);

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysPrivilegeManager sysPrivilegeManager;

    @Autowired
    private SysRolePrivilegeService sysRolePrivilegeService;

    @Autowired
    private SysPrivilegeService sysPrivilegeService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_ROLE_EDIT));
        return "view/system/sysRole/grid";
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
            Page<SysRole> pageModel = new Page<SysRole>(page, rows, true);
            String hql = "from SysRole order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = sysRoleService.findByPage(pageModel, query);
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
     * 设置角色权限页面
     *
     * @param model .
     * @param id    .
     * @return .
     */
    @RequestMapping
    public String setPrivilege(Model model, Long id) {
        SysRole sysRole = sysRoleService.get(id);
        model.addAttribute("bean", sysRole);

        Set<Long> rolePrivilegeIdSet = new HashSet<Long>();
        //获取当前用户已拥有的权限
        Set<SysRolePrivilege> sysRolePrivileges = sysRole.getSysRolePrivileges();
        for (SysRolePrivilege sysRolePrivilege : sysRolePrivileges) {
            rolePrivilegeIdSet.add(sysRolePrivilege.getPrivilege().getId());
        }

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        //获取系统的所有权限
        List<SysPrivilege> sysPrivileges = sysPrivilegeManager.getAllPrivileges();

        for (SysPrivilege sysPrivilege : sysPrivileges) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("sysPrivilege", sysPrivilege);
            //如果用户已经拥有该权限则被选中，页面显示时选框被勾选。
            map.put("isChecked", rolePrivilegeIdSet.contains(sysPrivilege.getId()));
            map.put("space", JspHelper.getLevelStr(sysPrivilege.getTreeId(), "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"));
            list.add(map);
        }

        //按钮权限
        SysCodeDetail privilegeType = sysCodeManager.getCodeDetailByCode(Constants.SYS_PRIVILEGE_TYPE, Constants.SYS_PRIVILEGE_TYPE_BUTTON);
        model.addAttribute("buttonType", privilegeType.getId());

        model.addAttribute("list", list);
        return "view/system/sysRole/setPrivilege";
    }


    /**
     * 保存权限
     *
     * @param response .
     * @param id       .
     * @param request  .
     * @throws Exception .
     */
    @RequestMapping
    public void savePrivilege(HttpServletResponse response, Long id,
                              HttpServletRequest request) throws Exception {

        String[] privilegeIds = request.getParameterValues("sysPrivilegeId");

        SysRole sysRole = sysRoleService.get(id);

        //获取之前保存的记录
        Map<Long,SysRolePrivilege> existHM = new HashMap<Long, SysRolePrivilege>();
        Set<SysRolePrivilege> sysRolePrivileges = sysRole.getSysRolePrivileges();
        for (SysRolePrivilege sysRolePrivilege : sysRolePrivileges) {
            existHM.put(sysRolePrivilege.getPrivilege().getId(),sysRolePrivilege);
        }

        //获取页面的授权记录ID集合
        Set<Long> newPrivilegeIdHS = new HashSet<Long>();
        if (privilegeIds != null) {
            for (String privilegeId : privilegeIds) {
                Long privilegeIdLong = Long.valueOf(privilegeId);
                SysPrivilege sysPrivilege = sysPrivilegeService.get(privilegeIdLong);
                SysRolePrivilege sysRolePrivilege = existHM.get(privilegeIdLong);
                if(sysRolePrivilege==null){
                    sysRolePrivilege = new SysRolePrivilege();
                    sysRolePrivilege.setRole(sysRole);
                    sysRolePrivilege.setPrivilege(sysPrivilege);
                    sysRolePrivilegeService.save(sysRolePrivilege);
//                    System.out.println("new privilegeId = " + privilegeIdLong);
                }
                newPrivilegeIdHS.add(privilegeIdLong);
            }
        }

        //删除无效的记录
        for (SysRolePrivilege sysRolePrivilege : sysRolePrivileges) {
            Long id1 = sysRolePrivilege.getPrivilege().getId();
            if(!newPrivilegeIdHS.contains(id1))
            {
                sysRolePrivilegeService.delete(sysRolePrivilege);
//                System.out.println("remove privilegeId = " + id1);
            }
        }

        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        SysRole sysRole = new SysRole();

        model.addAttribute("bean", sysRole);

        return "view/system/sysRole/input";
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
        SysRole sysRole = sysRoleService.get(id);

        //处理其他业务逻辑

        model.addAttribute("bean", sysRole);
        return "view/system/sysRole/input";
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
        SysRole sysRole = sysRoleService.get(id);

        model.addAttribute("bean", sysRole);
        return "view/system/sysRole/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @return .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") SysRole entity) throws Exception {
        try {
            SysRole target;
            if (entity.getId() != null) {
                target = sysRoleService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "code",
                        "roleName",
                        "description"
                });

            } else {
                target = entity;
            }
            sysRoleService.save(target);

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
        SysRole sysRole = sysRoleService.get(id);
        //删除角色与权限关联
        Set<SysRolePrivilege> rolePrivileges = sysRole.getSysRolePrivileges();
        for (SysRolePrivilege sysRolePrivilege : rolePrivileges) {
            sysRolePrivilegeService.delete(sysRolePrivilege);
        }
        //删除角色与用户关联
        Set<SysUserRole> sysUserRoles = sysRole.getSysUserRoles();
        for (SysUserRole sysUserRole : sysUserRoles) {
            sysUserRoleService.delete(sysUserRole);
        }
        //删除角色
        sysRoleService.delete(sysRole);
        sendSuccessJSON(response, "删除成功");
    }

}