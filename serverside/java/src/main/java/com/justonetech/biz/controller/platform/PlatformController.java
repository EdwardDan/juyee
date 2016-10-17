package com.justonetech.biz.controller.platform;

import com.justonetech.biz.daoservice.AreaSgPermitService;
import com.justonetech.biz.daoservice.SgPermitService;
import com.justonetech.biz.domain.AreaSgPermit;
import com.justonetech.biz.domain.SgPermit;
import com.justonetech.biz.manager.SiteMenuManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.SysUtils;
import com.justonetech.biz.utils.UrlParser;
import com.justonetech.biz.utils.operationMsg.OperationMsgManager;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.RandomUtils;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.filter.CustomAuthenticationProcessingFilter;
import com.justonetech.system.manager.SysLogCustomManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.manager.UserManager;
import net.sf.json.JSONObject;
import org.hibernate.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

/**
 * 外网监管平台
 */
@Controller
public class PlatformController extends BaseCRUDActionController {

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SgPermitService sgPermitService;

    @Autowired
    private AreaSgPermitService areaSgPermitService;

    @Autowired
    private UserManager userManager;

    @Autowired
    private SysLogCustomManager sysLogManager;

    /**
     * 监管平台首页
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String index(Model model) {
        SysUser user = sysUserManager.getSysUser();
        model.addAttribute("realName", user.getDisplayName());
        model.addAttribute("categoryCode", Constants.BPM_PROCESS_DEFINITION_CATEGORY_GD);

        return "view/platform/index";
    }

    /**
     * 主页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String main(Model model) {

        return "view/platform/main";
    }

    /**
     * 主页面--施工许可
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String mainSgxk(Model model) {
        //注册用户只能看到自己的记录
        SysUser sysUser = sysUserManager.getSysUser();
        String hql = "from SgPermit where 1=1";
        if (null != sysUser.getRegPerson()) {
            hql += " and createUser='" + sysUser.getLoginName() + "'";
        }
        hql += " order by id desc";
        List<SgPermit> list = sgPermitService.findByQuery(hql);
        if (list.size() > 5) {
            list = list.subList(0, 5);
        }
        model.addAttribute("list", list);

        return "view/platform/mainSgxk";
    }

    /**
     * 主页面--施工许可
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String mainQxsgxk(Model model) {
        //注册用户只能看到自己的记录
        SysUser sysUser = sysUserManager.getSysUser();
        String hql = "from AreaSgPermit where 1=1";
        if (null != sysUser.getRegPerson()) {
            hql += " and createUser='" + sysUser.getLoginName() + "'";
        }
        hql += " order by id desc";
        List<AreaSgPermit> list = areaSgPermitService.findByQuery(hql);
        if (list.size() > 5) {
            list = list.subList(0, 5);
        }
        model.addAttribute("list", list);

        return "view/platform/mainQxsgxk";
    }

    /**
     * 附件下载
     *
     * @return 。
     */
    @RequestMapping
    public String attachDownload() {

        return "view/platform/mainDownload";
    }


    /**
     * 外网权限登录时验证接口
     * http://192.168.1.89:8084/platform/loginCheck.do?account=admin&password=1234
     *
     * @return .
     */
    @RequestMapping
    public String loginCheck(Model model, HttpServletRequest request) {
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        String jumpUrl = request.getParameter("jumpUrl");

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("msg", "用户名或密码不正确，请重新输入！");
        map.put("success", "false");
        map.put("url", "");
        if (!StringHelper.isEmpty(loginName) && !StringHelper.isEmpty(password)) {
            //查询用户是否存在
            SysUser sysUser = sysUserManager.getSysUser(loginName);
            if (sysUser != null) {
//                String savePass = SysUtils.getPassword(sysUser.getPassword());
                //查询用户是否合法
//                if (password.equals(savePass)) {
                if (password.equals(sysUser.getMd5Pass())) {
                    map.put("msg", "验证通过！");
                    map.put("success", "true");

                    String basePath = UrlParser.getFrontUrl(request);
                    String url = basePath + "platform/loginProcess.do" + "?loginName=" + loginName + "&jumpUrl=" + jumpUrl;
                    map.put("url", url);
                    request.getSession().setAttribute("SITE_USER", loginName);
                }
            }
        }
        model.addAttribute("msg", JSONObject.fromObject(map).toString());
        return "common/msg";
    }

    /**
     * 登录处理过程
     * http://192.168.1.89:8084/platform/loginProcess.do?account=admin
     *
     * @param model   .
     * @param request .
     * @return .
     */
    @RequestMapping
    public String loginProcess(Model model, HttpServletRequest request) {
        String loginName = JspHelper.getString(request.getParameter("loginName"));
        String jumpUrl = request.getParameter("jumpUrl");
        HttpSession session = request.getSession();
        String site_user = JspHelper.getString(request.getSession().getAttribute("SITE_USER"));
//        System.out.println("loginName = " + loginName);
//        System.out.println("site_user = " + site_user);
//        System.out.println("jumpUrl = " + jumpUrl);
        SysUser sysUser = sysUserManager.getSysUser(loginName);
        if (sysUser != null) {
            String j_validation_code = RandomUtils.generateString("0123456789", 4);
            session.setAttribute(CustomAuthenticationProcessingFilter.VALIDATION_CODE, j_validation_code);

            model.addAttribute("j_username", loginName);
            model.addAttribute("j_password", SysUtils.getPassword(sysUser.getPassword()));
            model.addAttribute("j_validation_code", j_validation_code);
            model.addAttribute("jumpUrl", jumpUrl);

            session.setAttribute(userManager.USERTYPE_KEY, userManager.USERTYPE_SITE);
            session.setAttribute("jumpUrl", jumpUrl);

            return "view/loginLiferay/dispatch";

        } else {
            return OperationMsgManager.errorMsg(model, null, "未找到此用户，请重新登录！");
        }
    }

    /**
     * liferay网站跳转http://192.168.1.89:8084/platform/jump.do?code=cljcys
     *
     * @param model   .
     * @param request .
     */
    @RequestMapping
    public String jump(Model model, HttpServletRequest request) throws IOException {
        String basePath = UrlParser.getFrontUrl(request);
        String code = request.getParameter("code");   //菜单编码
        String account = request.getParameter("account");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        if (!com.justonetech.core.utils.StringHelper.isEmpty(name)) {
            name = URLDecoder.decode(name, "utf-8");
        }

        String menuLink = SiteMenuManager.getActualLink(code, account, name, type);
        System.out.println("menuLink = " + menuLink);
        if (menuLink != null) {
            String url = basePath + menuLink;
            System.out.println("url = " + url);
            model.addAttribute("url", url);
        }
        HttpSession session = request.getSession();
        session.setAttribute(userManager.USERTYPE_KEY, userManager.USERTYPE_SITE);
        session.setAttribute(userManager.SITE_USERNAME_KEY, account);

        return "view/platform/jump";
    }

    /**
     * 测试专用
     * http://192.168.1.89:8084/platform/jump.do?code=cljcys
     *
     * @param model .
     */
    @RequestMapping
    public String liferayJump(Model model, String loginName, String password, String jumpUrl, HttpSession session) throws IOException {
        model.addAttribute("loginName", loginName);
        model.addAttribute("password", password);
        model.addAttribute("jumpUrl", jumpUrl);
        Object site_user = session.getAttribute("SITE_USER");
        String sessionUser = JspHelper.getString(site_user);
        model.addAttribute("isLogin", sessionUser.equals(loginName));

        return "view/platform/liferayJump";

    }
}
