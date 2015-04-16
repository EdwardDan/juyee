package com.justonetech.system.controller;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * User:yujun
 * Date 12-6-7
 */
@Controller
public class SysOnlineUserController extends BaseCRUDActionController<SysUser> {

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    SessionRegistry sessionRegistry;


    @Autowired
    private SimpleQueryManager simpleQueryManager;

    /**
     * 获取在线用户显示列表
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        List countUsers = sessionRegistry.getAllPrincipals();
        List<Map> list = new ArrayList<Map>();
        Set<String> userNames = new HashSet<String>();
        //将遍历后面的用户名与前面比较
        for (Object ob : countUsers) {
            Map<String, Object> cellMap = new HashMap<String, Object>();
            BaseUser baseUser = (BaseUser) ob;
            if (!userNames.contains(baseUser.getUsername())) {
                cellMap.put("userName", baseUser.getUsername());
                cellMap.put("realName", baseUser.getRealName());
                cellMap.put("loginTime", baseUser.getLoginTime());
                SysUser sysUser = sysUserManager.getSysUser(baseUser.getLoginName());
                if (sysUser != null) {
                    String sql = "select ip_address from sys_log where enter_time=(select max(enter_time) from sys_log where user_id=" + sysUser.getId() + ") and user_id=" + sysUser.getId();
                    String ipAddress = simpleQueryManager.getStringBySql(sql);
                    cellMap.put("ipAddress", ipAddress);
                    String deptName = "";
                    if (sysUser.getRegPerson() != null) {
                        deptName = sysUser.getRegPerson().getUnitName();
                    } else if (sysUser.getPerson() != null) {
                        SysDept company = sysUser.getPerson().getCompany();
                        if (company != null) {
                            deptName = company.getName();
                        }
                    }
                    cellMap.put("dept", deptName);
                }
                cellMap.put("onlineTimeMinute", (System.currentTimeMillis() - baseUser.getLoginTime().getTime()) / 60000);
                userNames.add(baseUser.getUsername());
                list.add(cellMap);
            }
        }
        model.addAttribute("onlineUsers", list);
        return "view/system/sysOnlineUser/grid";
    }
}