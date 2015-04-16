package com.justonetech.biz.controller;

import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.CryptUtil;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.RandomUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.filter.CustomAuthenticationProcessingFilter;
import com.justonetech.system.manager.SysLogCustomManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.manager.UserManager;
import com.justonetech.system.utils.Md5Utils;
import net.sf.json.JSONArray;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

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

    /**
     * 提供给外部网站单点登录验证
     *
     * @param model    .
     * @param request  .
     * @param response .
     * @return .
     * @throws Exception
     */
    @RequestMapping
    public String loginForSite(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String loginName = "";
        AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();
//        System.out.println("request.getRemoteUser() = " + request.getRemoteUser());
        if (principal != null) {
            loginName = principal.getName();// 获取用户名
            System.out.println("loginName = " + loginName);
        }

        if (StringHelper.isEmpty(loginName)) {

            response.sendRedirect("../login.jsp");
            return null;

        } else {

            SysUser sysUser = sysUserManager.getSysUser(loginName);

            HttpSession session = request.getSession();
//            String j_password = RandomUtils.generateString("0123456789", 6);
            String j_validation_code = RandomUtils.generateString("0123456789", 4);
            session.setAttribute(CustomAuthenticationProcessingFilter.VALIDATION_CODE, j_validation_code);

            model.addAttribute("j_username", loginName);
            String password = sysUser.getPassword();
            if (!StringHelper.isEmpty(password)) {
                if (password.length() > 20) {
                    password = CryptUtil.decrypt(password);
                }
            }
            model.addAttribute("j_password", password);
            model.addAttribute("j_validation_code", j_validation_code);

            model.addAttribute("UUID", "");
            model.addAttribute("errMsg", "");
            session.setAttribute("isFromSite", "1");    //是否来自网站，如果是，那么在退出系统的时候必须返回到http://www.hkjgzx.sh.cn
            System.out.println("session = " + session.getAttribute("isFromSite"));
//            session.setAttribute(userManager.USERTYPE_KEY, sysUser.getUserType().getCode());
            return "view/loginForSite/dispatch";
        }
    }

    /**
     * 同步密码--网站修改密码后同步修改MIS系统密码
     *
     * @param model   .
     * @param request .
     * @return .
     */
    @RequestMapping
    public String passSync(Model model, HttpServletRequest request) {
        String msg = "无法获取用户信息";
        String loginName = request.getParameter("loginName");
        try {
            if (StringHelper.isEmpty(loginName)) {
                AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();
//                System.out.println("request.getRemoteUser() = " + request.getRemoteUser());
                if (principal != null) {
                    loginName = principal.getName();// 获取用户名
                }
            }
        } catch (Exception e) {
            loginName = "";
        }

        if (!StringHelper.isEmpty(loginName)) {
            String oldPass = request.getParameter("oldPass");
            String newPass = request.getParameter("newPass");
            if (!StringHelper.isEmpty(oldPass) && !StringHelper.isEmpty(newPass)) {
                SysUser sysUser = sysUserManager.getSysUser(loginName);
                if (sysUser != null) {
                    if (Md5Utils.md5(oldPass).equals(JspHelper.getString(sysUser.getMd5Pass()))) {
                        sysUser.setMd5Pass(Md5Utils.md5(newPass));
                        sysUser.setPassword(CryptUtil.encrypt(newPass));
                        sysUser.setPasswordUpdateTime(new Timestamp(System.currentTimeMillis()));
                        sysUserService.save(sysUser);
                        msg = "";

                    } else {
                        msg = "原密码不正确";
                    }
                } else {
                    msg = "用户无法匹配";
                }
            } else {
                msg = "原密码和新密码均不能为空";
            }
        }

        //返回信息
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", StringHelper.isEmpty(msg)?"密码修改成功" : msg);
        map.put("success", StringHelper.isEmpty(msg));
        String ret = JSONArray.fromObject(map).toString();

        model.addAttribute("msg", ret);
        return "common/msg";
    }
}
