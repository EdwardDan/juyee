package com.justonetech.biz.manager;

import com.justonetech.biz.daoservice.OaFgldSetItemService;
import com.justonetech.biz.daoservice.OaFgldSetService;
import com.justonetech.biz.domain.OaFgldSet;
import com.justonetech.biz.domain.OaFgldSetItem;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.system.daoservice.SysPersonDeptService;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.domain.SysPersonDept;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * 分管领导业务类
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
    private SysUserService sysUserService;

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
    public String getDeptLeader(String loginName){
        SysUser sysUser = sysUserManager.getSysUser(loginName);  //通过loginName获取sysUser
        SysDept sysDept = sysUser.getPerson().getDept(); //获取部门
        String hql ="from SysPersonDept t where t.dept.id='{0}'and t.position='{1}'";
        List<SysPersonDept> sysPersonDeptList = sysPersonDeptService.findByQuery(FormatUtils.format(hql, JspHelper.getString(sysDept.getId()), Constants.SYS_DEPT_LEADER_NAME));
        if(sysPersonDeptList.size()>0){
            SysPersonDept sysPersonDept =sysPersonDeptList.iterator().next();
            SysPerson person = sysPersonDept.getPerson();
            Set<SysUser> sysUsers = person.getSysUsers();
            if(sysUsers.size()>0){
                SysUser data =sysUsers.iterator().next();
                return data.getLoginName();
            }
        }
        return null;
    }

    /**
     * 获取主任
     *
     * @return .
     */
    public String getTopLeader(){
        String hql="from SysPersonDept where position='{0}'";
        List<SysPersonDept> list = sysPersonDeptService.findByQuery(FormatUtils.format(hql, Constants.SYS_TOP_LEADER_NAME));
        if(list.size()>0){
            SysPersonDept sysPersonDept = list.iterator().next();
            Set<SysUser> sysUsers = sysPersonDept.getPerson().getSysUsers();
            if(sysUsers.size()>0){
                SysUser sysUser = sysUsers.iterator().next();
                return sysUser.getLoginName();
            }
        }
        return null;
    }

    /**
     * 获取所管辖的部门或人员
     * @param sysUser .
     * @return .
     */
    public String[] getManagerPersonAndDepts(SysUser sysUser){
        String deptNames = "";
        String personNames = "";
        String hql = "from OaFgldSet where user.loginName=?";
        OaFgldSet data = oaFgldSetService.findUnique(hql, sysUser.getLoginName());
        if(data != null){
            Set<OaFgldSet> childsets = data.getChildsets();
            if(childsets.size()>0){
                for (OaFgldSet childset : childsets) {
                    personNames += ","+childset.getUser().getPerson().getName();
                }
                personNames = personNames.substring(1);
            }else{
                Set<OaFgldSetItem> oaFgldSetItems = data.getOaFgldSetItems();
                if(oaFgldSetItems.size()>0){
                    for (OaFgldSetItem oaFgldSetItem : oaFgldSetItems) {
                        deptNames += ","+oaFgldSetItem.getDept().getName();
                    }
                    deptNames = deptNames.substring(1);
                }
            }
        }
        return new String[]{deptNames,personNames};
    }
}
