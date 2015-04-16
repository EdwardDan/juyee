package com.justonetech.biz.manager;

import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysPrivilege;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysRoleManager;
import com.justonetech.system.manager.SysUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * description: 数字证书验证
 * User: Chenjp
 * Date: 13-9-13 下午5:40
 */
@Service
public class NetAuthManager {
    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private SysRoleManager sysRoleManager;

    @Autowired
    private SysUserManager sysUserManager;

    /**
     * 验证信息
     *
     * @param name     .
     * @param password .
     * @return .
     */
    public Map getNetUserData(String name, String password) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("LoginName",name);
        map.put("Password",password);
        map.put("RealName","测试项目账户");
        return map;
    }

    public String getClearStr(String s) {
        if (!StringHelper.isEmpty(s)) {
            s = StringHelper.findAndReplace(s, " or ", "");
            s = StringHelper.findAndReplace(s, "1=1", "");
            s = StringHelper.findAndReplace(s, "insert", "");
            s = StringHelper.findAndReplace(s, "update", "");
            s = StringHelper.findAndReplace(s, "delete", "");
            s = StringHelper.findAndReplace(s, ";", "");
            return s;
        }
        return null;
    }

    /**
     * 获取专家的审核权限
     * @return .
     */
    public List<SysPrivilege> getNetProjectPrivileges() {
        String SYS_ROLE_CODE_BY_EXPERT = "NET_PROJECT";
        return sysRoleManager.getRolePrivileges(SYS_ROLE_CODE_BY_EXPERT);
    }
    public Set<String> getNetProjectPrivilegeCodes() {
        Set<String> privileges = new HashSet<String>();
        List<SysPrivilege> expertPrivileges = getNetProjectPrivileges();
        if (expertPrivileges != null && expertPrivileges.size() > 0) {
            for (SysPrivilege tmp : expertPrivileges) {
                privileges.add(tmp.getCode());
            }
        }
        return privileges;
    }

    /**
     * 判断是否系统用户还是专家
     * @param userName .
     * @return .
     */
    public Boolean isSysUser(String userName){
        return sysUserManager.getSysUser(userName) != null;
    }
}
