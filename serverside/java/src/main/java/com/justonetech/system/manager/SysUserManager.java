package com.justonetech.system.manager;

import com.justonetech.biz.utils.Constants;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.*;
import com.justonetech.system.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * </p>
 * User: <a href="mailto:hzxia2002@gmail.com">Jackie</a> Date: 2009-11-23 Time:
 * 23:40:36 Version: 1.0
 */
@Service
public class SysUserManager {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysUserPrivilegeService sysUserPrivilegeService;

    @Autowired
    private SysPersonService sysPersonService;

    @Autowired
    private SysPersonManager sysPersonManager;

    //用户权限cache
    private Map<Long, Set<String>> USER_PRIVILEGE_CODES = null;

    @Autowired
    private SysPersonDeptService sysPersonDeptService;

    /**
     * 判断用户是否具有权限---用于按钮控制
     *
     * @param privilegeCode .
     * @return .
     */
    public Boolean hasPrivilege(String privilegeCode) {
//        BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
//        return hasPrivilege(loginUser != null ? loginUser.getId() : null, privilegeCode);

        BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
        if (loginUser != null) {
            if (loginUser.getId() != null) {
                //系统用户
                return hasPrivilege(loginUser != null ? loginUser.getId() : null, privilegeCode);
            } else {
                //网上报建--数字证书用户
//                return netAuthManager.getNetProjectPrivilegeCodes().contains(privilegeCode);
            }
        }
        return false;
    }

    public Boolean hasPrivilege(Long userId, String privilegeCode) {
        return getUserPrivilegeCodesCache(userId).contains(privilegeCode);
    }

    /**
     * 获取用户权限---从cache
     *
     * @param userId
     * @return
     */
    public Set<String> getUserPrivilegeCodesCache(Long userId) {
        if (userId != null) {
            loadUserPrivileges(userId, false);
            Set<String> privilegeSet = USER_PRIVILEGE_CODES.get(userId);
            if (privilegeSet != null) {
                return privilegeSet;
            }
        }
        return new HashSet<String>();
    }

    /**
     * 加载用户权限cache ---登录时加载
     *
     * @param userId  .
     * @param isForce 强制刷新
     */
    public void loadUserPrivileges(Long userId, Boolean isForce) {
        if (userId != null) {
            if (USER_PRIVILEGE_CODES == null) USER_PRIVILEGE_CODES = new HashMap<Long, Set<String>>();
            if (isForce || !USER_PRIVILEGE_CODES.containsKey(userId)) {
                USER_PRIVILEGE_CODES.put(userId, getUserPrivilegeCodes(userId));
            }
        }
    }

    /**
     * 获取用户权限
     *
     * @param userId
     * @return
     */
    private Set<String> getUserPrivilegeCodes(Long userId) {
        Set<String> ret = new HashSet<String>();
        Set<String> deniedList = new HashSet<String>();
        if (userId != null) {
            SysUser user = sysUserService.get(userId);

            //角色权限
            Set<SysUserRole> userRoles = user.getSysUserRoles();
            for (SysUserRole userRole : userRoles) {
                Set<SysRolePrivilege> rolePrivileges = userRole.getRole().getSysRolePrivileges();
                for (SysRolePrivilege rolePrivilege : rolePrivileges) {
                    ret.add(JspHelper.getString(rolePrivilege.getPrivilege().getCode()));
                }
            }

            //用户权限
            Set<SysUserPrivilege> sysUserPrivileges = user.getSysUserPrivileges();
            for (SysUserPrivilege sysUserPrivilege : sysUserPrivileges) {
                SysPrivilege sysPrivilege = sysUserPrivilege.getPrivilege();
                if (null == sysUserPrivilege.getIsDeny() || !sysUserPrivilege.getIsDeny()) {
                    ret.add(JspHelper.getString(sysPrivilege.getCode()));
                } else {
                    deniedList.add(JspHelper.getString(sysPrivilege.getCode()));
                }
            }

            //用户禁止权限
            ret.removeAll(deniedList);
        }
        return ret;
    }

    /**
     * 仅用于security权限验证
     *
     * @param userId
     * @return
     */
    public List<SysPrivilege> getUserPrivilegeCodesForSecurity(Long userId) {
        List<SysPrivilege> ret = new ArrayList<SysPrivilege>();
        Set<SysPrivilege> deniedList = new HashSet<SysPrivilege>();
        if (userId != null) {
            SysUser user = sysUserService.get(userId);

            //角色权限
            Set<SysUserRole> userRoles = user.getSysUserRoles();
            for (SysUserRole userRole : userRoles) {
                Set<SysRolePrivilege> rolePrivileges = userRole.getRole().getSysRolePrivileges();
                for (SysRolePrivilege rolePrivilege : rolePrivileges) {
                    ret.add(rolePrivilege.getPrivilege());
                }
            }

            //用户权限
            Set<SysUserPrivilege> sysUserPrivileges = user.getSysUserPrivileges();
            for (SysUserPrivilege sysUserPrivilege : sysUserPrivileges) {
                SysPrivilege sysPrivilege = sysUserPrivilege.getPrivilege();
                if (null == sysUserPrivilege.getIsDeny() || !sysUserPrivilege.getIsDeny()) {
                    ret.add(sysPrivilege);
                } else {
                    deniedList.add(sysPrivilege);
                }
            }

            //用户禁止权限
            ret.removeAll(deniedList);
        }
        return ret;
    }

    /**
     * 取得用户的所有角色
     *
     * @param bean
     * @return
     */
    public List<Map<String, Object>> getRoleList(SysUser bean) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Set<Long> existHS = new HashSet<Long>();
        Set<SysUserRole> sysUserRoles = bean.getSysUserRoles();
        for (SysUserRole sysUserRole : sysUserRoles) {
            existHS.add(sysUserRole.getRole().getId());
        }
        List<SysRole> roleList = sysRoleService.findByQuery("from SysRole order by id asc");
        for (SysRole role : roleList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("role", role);
            map.put("check", existHS.contains(role.getId()));
            list.add(map);
        }
        return list;
    }

    /**
     * 根据登陆名获取用户
     *
     * @param loginName
     * @return
     */
    public SysUser getSysUser(String loginName) {
        List<SysUser> list = sysUserService.findByProperty("loginName", loginName);
        if (list.size() > 0) {
            return list.iterator().next();
        }
        return null;
    }

    public SysUser getSysUser() {
        BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
        if (loginUser != null) {
            return getSysUser(loginUser.getLoginName());
        }
        return null;
    }

    /**
     * 根据显示名获取用户
     *
     * @param displayName
     * @return
     */
    public SysUser getSysUserByDisplayName(String displayName) {
        List<SysUser> list = sysUserService.findByProperty("displayName", displayName);
        if (list.size() > 0) {
            return list.iterator().next();
        }
        return null;
    }

    /**
     * 根据登陆名获取真实姓名
     *
     * @param loginName .
     * @return .
     */
    public String getDisplayName(String loginName) {
        SysUser sysUser = getSysUser(loginName);
        if (sysUser != null) {
            return sysUser.getDisplayName();
        }
        return "";
    }
    /****************************角色维护和用户维护***********************************/
    /**
     * 保存用户信息
     *
     * @param bean    用户
     * @param roleIds 角色ID
     */
    public void saveRoles(SysUser bean, String[] roleIds) {
        Set<SysUserRole> sysUserRoles = bean.getSysUserRoles();
        for (SysUserRole sysUserRole : sysUserRoles) {
            sysUserRoleService.delete(sysUserRole);
        }
        sysUserRoleService.getSession().flush();

        if (roleIds != null) {
            if (roleIds.length > 0) {
                for (String roleId : roleIds) {
                    SysRole role = sysRoleService.get(Long.valueOf(roleId));
                    SysUserRole userRole = new SysUserRole();
                    userRole.setUser(bean);
                    userRole.setRole(role);
                    sysUserRoleService.save(userRole);
                }
            }
        }
    }

    /**
     * 删除用户信息
     *
     * @param id 用户ID
     */
    public void delete(Long id) {
        SysUser bean = sysUserService.get(id);

        //删除角色授权
        Set<SysUserRole> sysUserRoles = bean.getSysUserRoles();
        for (SysUserRole sysUserRole : sysUserRoles) {
            sysUserRoleService.delete(sysUserRole);
        }
        //删除用户特权
        Set<SysUserPrivilege> sysUserPrivileges = bean.getSysUserPrivileges();
        for (SysUserPrivilege sysUserPrivilege : sysUserPrivileges) {
            sysUserPrivilegeService.delete(sysUserPrivilege);
        }
        //删除用户
        sysUserService.delete(id);
    }

    /**
     * 获取用户姓名
     *
     * @param userIds .
     * @return .
     */
    public String getSysUserNames(String[] userIds) {
        String names = "";
        for (String uid : userIds) {
            if (!StringHelper.isEmpty(uid)) {
                try {
                    if ("".equals(names)) {
                        names += sysUserService.get(Long.valueOf(uid)).getDisplayName();
                    } else {
                        names += "," + sysUserService.get(Long.valueOf(uid)).getDisplayName();
                    }
                } catch (Exception e) {

                }
            }
        }
        return names;
    }

    /**
     * 获取系统管理员用户
     *
     * @return
     */
    public SysUser getAdminUser() {
        List<SysUser> sysUserList = sysUserService.findByQuery("from SysUser where loginName='" + Constants.SYS_USER_ADMIN + "'");
        if (sysUserList.size() > 0) {
            return sysUserList.iterator().next();
        } else {
            return null;
        }
    }

    /**
     * 将用户转换为人员
     *
     * @param userIds .
     * @return .
     */
    public String[] getPersonIds(String[] userIds) {
        if (userIds != null) {
            if (userIds.length > 0) {
                String s = "";
                for (String userId : userIds) {
                    SysUser sysUser = sysUserService.get(Long.valueOf(userId));
                    SysPerson person = sysUser.getPerson();
                    if (person != null) {
                        if (!"".equals(s)) {
                            s += "," + person.getId();
                        } else {
                            s += person.getId();
                        }
                    }
                }
                return StringHelper.stringToStringArray(s, ",");
            }
        }
        return null;
    }

    /**
     * 根据权限编码获取用户ID
     *
     * @param privilegeCodes .
     * @return .
     */
    public Set<Long> getUserIdsByPrivilegeCodes(String[] privilegeCodes) {
        Set<Long> ret = new HashSet<Long>();
        String ss = StringHelper.stringArrayToString(privilegeCodes, "','");
        ss = "'" + ss + "'";
        String hql = "select u from SysUser u left join u.sysUserRoles ur left join ur.role r left join r.sysRolePrivileges p where p.privilege.code in({0})";
        List<SysUser> list = sysUserService.findByQuery(FormatUtils.format(hql, ss));
        for (SysUser user : list) {
            ret.add(user.getId());
        }
        return ret;
    }
    public Set<Long> getUserIdsByPrivilegeCode(String privilegeCode) {
        Set<Long> ret = new HashSet<Long>();
        String hql = "select u from SysUser u left join u.sysUserRoles ur left join ur.role r left join r.sysRolePrivileges p where p.privilege.code='{0}'";
        List<SysUser> list = sysUserService.findByQuery(FormatUtils.format(hql, privilegeCode));
        for (SysUser user : list) {
            ret.add(user.getId());
        }
        return ret;
    }
    public  List<SysUser>  getUsersByPrivilegeCode(String privilegeCode) {
        String hql = "select u from SysUser u left join u.sysUserRoles ur left join ur.role r left join r.sysRolePrivileges p where p.privilege.code='{0}'";
        List<SysUser> list = sysUserService.findByQuery(FormatUtils.format(hql, privilegeCode));
        return list;
    }

    /**
     * 获取指定部门或单位下面的所有用户
     *
     * @param dept .
     * @return .
     */
    public List<SysUser> getDeptUsers(SysDept dept) {
        List<SysUser> ret = new ArrayList<SysUser>();

        String hql = "select pd.person from SysPersonDept pd where pd.dept.treeId like '{0}%' and pd.isValid=1 order by pd.orderNo asc,pd.person.id asc";
        List<SysPerson> list = sysPersonService.findByQuery(FormatUtils.format(hql, dept.getTreeId()));
        for (SysPerson person : list) {
            Set<SysUser> sysUsers = person.getSysUsers();
            for (SysUser sysUser : sysUsers) {
                ret.add(sysUser);
            }
        }
        return ret;
    }
}
