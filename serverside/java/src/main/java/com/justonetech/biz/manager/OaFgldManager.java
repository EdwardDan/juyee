package com.justonetech.biz.manager;

import com.justonetech.biz.daoservice.OaFgldSetItemService;
import com.justonetech.biz.daoservice.OaFgldSetService;
import com.justonetech.biz.domain.OaFgldSet;
import com.justonetech.biz.domain.OaFgldSetItem;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysPersonDeptService;
import com.justonetech.system.daoservice.SysUserRoleService;
import com.justonetech.system.domain.*;
import com.justonetech.system.manager.SysUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @description 分管领导业务类
 * @revisor Stanley
 */
@Service
public class OaFgldManager {
    @Autowired
    private OaFgldSetService oaFgldSetService;

    @Autowired
    private OaFgldSetItemService oaFgldSetItemService;

    @Autowired
    private SysPersonDeptService sysPersonDeptService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysUserManager sysUserManager;

    /**
     * 根据部门名称和分管领导姓名获取用户信息
     *
     * @param deptName     .
     * @param fgldUserName .
     */
    public SysUser getAuditUserId(String deptName, String fgldUserName) {
        //根据部门名称获取审核用户
        if (null != deptName) {
            String hql = "from OaFgldSetItem where dept.name='" + deptName + "'";
            List<OaFgldSetItem> oaFgldSetItemList = oaFgldSetItemService.findByQuery(hql);
            if (oaFgldSetItemList.size() > 0) {
                OaFgldSetItem oaFgldSetItem = oaFgldSetItemList.iterator().next();
                return oaFgldSetItem.getFgldSet().getUser();
            }
            return null;
        }

        //根据分管领导用户名返回领导用户对象
        if (null != fgldUserName) {
            String hql = "from OaFgldSet where user.loginName='" + fgldUserName + "'";
            List<OaFgldSet> oaFgldSetList = oaFgldSetService.findByQuery(hql);
            if (oaFgldSetList.size() > 0) {
                OaFgldSet oaFgldSet = oaFgldSetList.iterator().next();
                if (null != oaFgldSet.getParent()) {
                    return oaFgldSet.getParent().getUser();
                } else {
                    return oaFgldSet.getUser();
                }
            }
        }
        return null;
    }

    /**
     * 获取审核用户名
     *
     * @param deptName     .
     * @param fgldUserName .
     * @return .
     */
    public String getAuditUserName(String deptName, String fgldUserName) {
        SysUser auditUserId = getAuditUserId(deptName, fgldUserName);
        if (auditUserId != null) {
            return auditUserId.getLoginName();
        } else {
            return null;
        }
    }

    /**
     * 通过科员获取所在科室科长
     *
     * @param loginName .
     * @return .
     */
    public String getDeptLeader(String loginName) {
        SysUser sysUser = sysUserManager.getSysUser(loginName);  //通过loginName获取sysUser
        SysDept sysDept = sysUser.getPerson().getDept(); //获取部门
        String hql = "from SysPersonDept t where t.dept.id='{0}'and t.position='{1}'";
        List<SysPersonDept> sysPersonDeptList = sysPersonDeptService.findByQuery(FormatUtils.format(hql, JspHelper.getString(sysDept.getId()), Constants.SYS_DEPT_LEADER_NAME));
        if (sysPersonDeptList.size() > 0) {
            SysPersonDept sysPersonDept = sysPersonDeptList.iterator().next();
            SysPerson person = sysPersonDept.getPerson();
            Set<SysUser> sysUsers = person.getSysUsers();
            if (sysUsers.size() > 0) {
                SysUser data = sysUsers.iterator().next();
                return data.getLoginName();
            }
        }
        return null;
    }

    /**
     * 通过当前用户的角色判断其是否扮演科长
     *
     * @param loginName
     * @return
     */
    public String getDeptLeaderByRole(String loginName) {
        String loginUsrName = getDeptLeader(loginName);
        //考虑职务为空，但却被授予科长角色的人员。
        if (StringHelper.isEmpty(loginUsrName)) {
            List<SysUserRole> sysUserRoles = sysUserRoleService.findByQuery("select sur from SysUserRole sur left join sur.role sysrole where sur.user.id = " + sysUserManager.getSysUser(loginName).getId() + " and (sysrole.code like '%kz%' or sysrole.roleName like '%" + Constants.SYS_DEPT_LEADER_NAME + "%') ");
            if (sysUserRoles.isEmpty()) {
                return null;
            }
            return sysUserRoles.iterator().next().getUser().getLoginName();
        }
        return loginUsrName;
    }

    /**
     * 获取主任
     *
     * @return .
     */
    public String getTopLeader() {
        String hql = "from SysPersonDept where position='{0}'";
        List<SysPersonDept> list = sysPersonDeptService.findByQuery(FormatUtils.format(hql, Constants.SYS_TOP_LEADER_NAME));
        if (list.size() > 0) {
            if (list.size() > 1) {
                StringBuilder topLeaders = new StringBuilder();
                for (SysPersonDept sysPersonDept : list) {
                    Set<SysUser> sysUsrs = sysPersonDept.getPerson().getSysUsers();
                    if (sysUsrs.size() > 0) {
                        topLeaders.append(JspHelper.getString(sysUsrs.iterator().next().getLoginName()).concat(list.indexOf(sysPersonDept) != list.size() - 1 ? "," : ""));
                    }
                }
                return topLeaders.toString();
            }
            SysPersonDept sysPersonDept = list.iterator().next();
            Set<SysUser> sysUsers = sysPersonDept.getPerson().getSysUsers();
            if (sysUsers.size() > 0) {
                SysUser sysUser = sysUsers.iterator().next();
                return JspHelper.getString(sysUser.getLoginName());
            }
        }
        return "";
    }

    /**
     * 通过当前用户的角色判断其是否扮演主任
     *
     * @param loginUsrId
     * @return
     */
    public String getTopLeaderByRole(Long loginUsrId) {
        String loginTopLeaderName = getTopLeader();
        //考虑职务为空，但却被授予主任角色的人员。
        if (StringHelper.isEmpty(loginTopLeaderName)) {
            List<SysUserRole> sysUserRoles = sysUserRoleService.findByQuery("select sur from SysUserRole sur left join sur.role sysrole where sur.user.id = " + loginUsrId + " and (sysrole.code like '%zr%' or sysrole.roleName like '%" + Constants.SYS_TOP_LEADER_NAME + "%') ");
            if (sysUserRoles.isEmpty()) {
                return "";
            }
            return JspHelper.getString(sysUserRoles.iterator().next().getUser().getLoginName());
        }
        return loginTopLeaderName;
    }

    /**
     * 获取所管辖的部门或人员
     *
     * @param sysUser .
     * @return .
     */
    public String[] getManagerPersonAndDepts(SysUser sysUser) {
        String deptNames = "";
        String personNames = "";
        String hql = "from OaFgldSet where user.loginName=?";
        OaFgldSet data = oaFgldSetService.findUnique(hql + " and isLeaf=1", sysUser.getLoginName());
        if (null == data) {
            data = oaFgldSetService.findUnique(hql + " and isLeaf=0", sysUser.getLoginName());
        }
        if (data != null) {
            Set<OaFgldSet> childsets = data.getChildsets();
            if (childsets.size() > 0) {
                for (OaFgldSet childset : childsets) {
                    personNames += "," + childset.getUser().getPerson().getName();
                }
                personNames = personNames.substring(1);
            } else {
                Set<OaFgldSetItem> oaFgldSetItems = data.getOaFgldSetItems();
                if (oaFgldSetItems.size() > 0) {
                    for (OaFgldSetItem oaFgldSetItem : oaFgldSetItems) {
                        deptNames += "," + oaFgldSetItem.getDept().getName();
                    }
                    deptNames = deptNames.substring(1);
                }
            }
        }
        return new String[]{deptNames, personNames};
    }

    /**
     * 获取所管辖的人员下的所有部门
     *
     * @param sysUser .
     * @return .
     */
    public String getManagerAllDepts(SysUser sysUser) {
        String deptNames = "";
        String hql = "from OaFgldSet where user.loginName=?";
        OaFgldSet data = oaFgldSetService.findUnique(hql + " and isLeaf=0", sysUser.getLoginName());
        if (data != null) {
            Set<OaFgldSet> childsets = data.getChildsets();
            if (childsets.size() > 0) {
                for (OaFgldSet childset : childsets) {
                    Set<OaFgldSetItem> oaFgldSetItems = childset.getOaFgldSetItems();
                    if (oaFgldSetItems != null && oaFgldSetItems.size() > 0) {
                        for (OaFgldSetItem oaFgldSetItem : oaFgldSetItems) {
                            if (!deptNames.contains(oaFgldSetItem.getDept().getName()))
                                deptNames += "," + oaFgldSetItem.getDept().getName();
                        }
                        deptNames = deptNames.substring(1);
                    }
                }
            }
        }
        return deptNames;
    }
}