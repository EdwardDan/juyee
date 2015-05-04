package com.justonetech.biz.controller;

import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysLogCustomManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * <p>
 * 登录后页面跳转处理处理类
 * </p>
 * User: Hzxia
 * Date: 2012-2-20
 * Time: 13:33:50
 */
@Controller
public class LoginController extends BaseCRUDActionController {
    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysLogCustomManager sysLogManager;

    @Autowired
    private UserManager userManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 登录后页面跳转处理（包含管理系统和网站监管平台）
     *
     * @param model    .
     * @param request  .
     * @param response .
     * @throws IOException .
     */
    @RequestMapping
    public void dispatch(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        String contextPath = request.getContextPath();
        String url = "/mainPage/index.do";
        BaseUser baseUser = SpringSecurityUtils.getCurrentUser();
        if (baseUser != null) {
//            System.out.println("baseUser.getIdCard() = " + baseUser.getIdCard());
            String user_type = JspHelper.getString(session.getAttribute(userManager.USERTYPE_KEY));
            if (userManager.USERTYPE_NET.equals(user_type)) {
                //网上报建用户转到报建页面
                url = "/netProject/index.do";
                baseUser.setIdCard(userManager.USERTYPE_NET);
                session.removeAttribute(userManager.USERTYPE_KEY);

            } else {
                SysUser user = sysUserManager.getSysUser();
                Long lastUpdateTime = 0l;
                if (user.getPasswordUpdateTime() != null) {
                    lastUpdateTime = user.getPasswordUpdateTime().getTime();
                }
                Long today = System.currentTimeMillis();
                int days = (int) (((today - lastUpdateTime) / 3600000) / 24);
//            logger.debug("days = ====================" + days);
                if (days >= 90) {
                    session.setAttribute("noticePassword", "您已经3个月没有修改密码，请及时修改密码！");
                }

                sysUserManager.loadUserPrivileges(user.getId(), true);

                if (user.getRegPerson() != null) {
                    //网站登录转到监管平台页面
                    url = "/platform/index.do";
                }
            }
        }
        url = contextPath + url;
        //记录系统日志
        sysLogManager.log(request, Constants.LOG_TYPE_LOGIN);

        response.sendRedirect(url);
//        model.addAttribute("url", url);
//        return "login_dispatch";
    }

    /**
     * 退出系统（包含管理系统和网站监管平台）
     *
     * @param session  .
     * @param request  .
     * @param response .
     * @param model    .
     * @return .
     * @throws Exception .
     */
    @RequestMapping
    public String logout(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //记录系统日志
        sysLogManager.log(request, Constants.LOG_TYPE_LOGOUT);

        String siteUrl = null;
        if (session != null) {
            session.invalidate();
        }

        //判断页面来源，如果从监管平台退出则转到网站首页，否则转到系统登录页面
        String url = "login.jsp?error=expired";
//        String referer = request.getHeader("REFERER");
//        if (!StringHelper.isEmpty(referer)) {
//            if (referer.contains("/platform/")) {
//                url = "site/index.do";
//            } else if (referer.contains("/netProject/")) {
//                url = "netProject/login.do";
//            }
//        }

        if (siteUrl != null) {
            url = siteUrl;
        }
        model.addAttribute("url", url);

        return "logout";
    }
}
