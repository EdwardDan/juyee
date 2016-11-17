package com.justonetech.system.manager;

import com.justonetech.biz.utils.Constants;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysLogService;
import com.justonetech.system.domain.SysLog;
import com.justonetech.system.domain.SysMenu;
import com.justonetech.system.domain.SysUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统日志
 */
@Service
public class SysLogCustomManager {
    @Autowired
    private SysLogService sysLogService;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private SysMenuManager sysMenuManager;

    /**
     * 记录日志
     *
     * @param request .
     * @param logType .
     */
    public void log(HttpServletRequest request, String logType) {
        try {
            if (StringUtils.isEmpty(logType)) logType = Constants.LOG_TYPE_NORMAL;

            BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
            if (loginUser != null) {
                SysLog entity = new SysLog();
                SysUser sysUser = sysUserManager.getSysUser();
                if (sysUser != null) {
                    entity.setUser(sysUser);
                }
                String ipAddress = request.getHeader("X-Real-IP");
                if (StringHelper.isEmpty(ipAddress)) {
                    ipAddress = request.getRemoteHost();
                }
                entity.setIpAddress(ipAddress);
                entity.setSessionid(request.getRequestedSessionId());
                entity.setLogType(sysCodeManager.getCodeDetailByCode(Constants.LOG_TYPE_CODE, logType));
                entity.setIeVersion(request.getHeader("User-Agent"));

                //设置登入和登出时间
                entity.setPageUrl(request.getRequestURI());
                if (logType.equals(Constants.LOG_TYPE_LOGIN)) {
                    entity.setEnterTime(DateTimeHelper.getTimestamp());
                    entity.setPageUrl("*登录系统*");

                } else if (logType.equals(Constants.LOG_TYPE_LOGOUT)) {
                    entity.setOutTime(DateTimeHelper.getTimestamp());
                    entity.setPageUrl("/j_spring_security_logout");
                }
                sysLogService.save(entity);
            }
        } catch (Exception e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    /**
     * 记录日志
     *
     * @param request .
     */
    public void logAll(HttpServletRequest request) {
        try {
            SysUser sysUser = sysUserManager.getSysUser();
            if (sysUser != null) {
                SysLog entity = new SysLog();
                entity.setUser(sysUser);
                String ipAddress = request.getHeader("X-Real-IP");
                if (StringHelper.isEmpty(ipAddress)) {
                    ipAddress = request.getRemoteHost();
                }
                entity.setIpAddress(ipAddress);
                entity.setSessionid(request.getRequestedSessionId());
                entity.setIeVersion(request.getHeader("User-Agent"));
                //设置操作时间
                SysMenu menusName = sysMenuManager.getMenusName(request.getRequestURI());
                if (!StringHelper.isEmpty(menusName.getName())) {
                    entity.setPageUrl(menusName.getName());
                    entity.setEnterTime(DateTimeHelper.getTimestamp());
                    sysLogService.save(entity);
                }
            }
        } catch (Exception e) {
//           e.printStackTrace();
        }
    }
}
