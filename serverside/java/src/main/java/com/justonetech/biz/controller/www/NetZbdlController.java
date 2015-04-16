package com.justonetech.biz.controller.www;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.ProjectBidSignDeptService;
import com.justonetech.biz.daoservice.ProjectBidSignService;
import com.justonetech.biz.domain.ProjectBidSign;
import com.justonetech.biz.domain.ProjectBidSignDept;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.biz.manager.projectInfo.CustomProjectInfo;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.*;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.filter.CustomAuthenticationProcessingFilter;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysLogCustomManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.manager.UserManager;
import com.justonetech.system.utils.PrivilegeCode;
import com.sheca.safeengine.javasafeengine;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.util.*;


/**
 * note:数字证书用户登录和招标单位登记功能
 * User: Shaxj
 * Date: 14-8-25
 * Time: 上午10:59
 */
@Controller
public class NetZbdlController extends BaseCRUDActionController {

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private ProjectBidSignService projectBidSignService;

    @Autowired
    private SysLogCustomManager sysLogManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private UserManager userManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ProjectBidSignDeptService projectBidSignDeptService;

    @Autowired
    private ProjectManager projectManager;

    /**
     * 数字证书登录页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String login(Model model) {
        model.addAttribute("UUID", UUID.randomUUID().toString());
        model.addAttribute("certSwitch", configManager.getCertSwitch());

        return "view/www/netZbdl/login";
    }

    /**
     * 数字证书验证
     *
     * @param request .
     * @param model   .
     * @return .
     * @throws Exception
     */
    @RequestMapping
    public String checkLogin(HttpServletRequest request, Model model) throws Exception {
        model.addAttribute("certSwitch", configManager.getCertSwitch());
        //不需要证书验证
        if (!configManager.getCertSwitch()) {
//            String userName = "test";
            String userName = request.getParameter("userName");
            String prikeypwd = request.getParameter("prikeypwd");
            SysUser user = sysUserManager.getSysUser(userName);
            String password = JspHelper.getString(user.getPassword());
            if (password.length() > 10) {
                password = CryptUtil.decrypt(password);
            }
            if (!password.equals(prikeypwd)) {
                model.addAttribute("UUID", UUID.randomUUID().toString());
                model.addAttribute("errMsg", "用户名或密码错误！");
                return "view/www/netZbdl/login";

            } else {
                HttpSession session = request.getSession();

                String j_validation_code = RandomUtils.generateString("0123456789", 4);
                session.setAttribute(CustomAuthenticationProcessingFilter.VALIDATION_CODE, j_validation_code);
                session.setAttribute("user2", userName);
                model.addAttribute("j_username", userName);
                model.addAttribute("loginName", userName);
                model.addAttribute("j_password", password);
                model.addAttribute("j_validation_code", j_validation_code);

                model.addAttribute("UUID", "");
                model.addAttribute("errMsg", "");

                session.setAttribute(userManager.USERTYPE_KEY, userManager.USERTYPE_NET);
                return "view/www/netZbdl/index";
            }
        } else {
//            密码错误：-2113667069
//            无key：-2113666989
            //数字证书验证
            String verifyMessage = null;
            String cCert = request.getParameter("cCert");
            String cSign = request.getParameter("cSign");
            String content = request.getParameter("content");
            logger.debug("cCert = " + cCert);
            logger.debug("cSign = " + cSign);
            logger.debug("content = " + content);

            javasafeengine oSE = new javasafeengine();
            boolean is = false;
            //转为二进制
            byte[] signed = oSE.base64Decode(cSign);
            byte[] clientCert = oSE.base64Decode(cCert);
            //获取证书链
            FileInputStream oFile = new FileInputStream(configManager.getCertPath());
            byte[] bChain = null;
            int iFile = 0;
            try {
                iFile = oFile.available();
                bChain = new byte[iFile];
                iFile = oFile.read(bChain);
            } catch (Exception e) {
                logger.debug("testVerifyCert file read error");
                try {
                    oFile.close();
                } catch (Exception e1) {
                    logger.debug("testVerifyCert file close error");
                }
            }
            String UniqueID = null;
            //验证客户端证书
//            int iRet = oSE.verifyCert(clientCert, bChain, 101);
            int iRet = oSE.verifyCert(clientCert, bChain, 0);
            logger.debug("iRet = " + iRet);
            if (iRet == 1) {
                //验证签名
                is = oSE.verifySign(content.getBytes(), signed, "SHA1withRSA", clientCert, "SunRsaSign");
                if (!is) {
                    verifyMessage = "数字签名信息验证失败！";
                } else {
                    //获取证书组织机构代码证（非一证通证书）
                    UniqueID = oSE.getCertExtInfo("1.2.156.1.8888.148", clientCert);
                    if (StringHelper.isEmpty(UniqueID)) {
                        //获取证书组织机构代码证（一证通证书）
                        UniqueID = oSE.getCertExtInfo("1.2.156.10260.4.1.4", clientCert);
                    }
                    if (StringHelper.isEmpty(UniqueID)) {
                        verifyMessage = "获取组织机构代码失败！";
                    }
                }
            } else {
                verifyMessage = "证书验证失败！";
            }

            //如果验证或无法获取机构代码则返回登录页面
            if (verifyMessage != null) {
                model.addAttribute("UUID", UUID.randomUUID().toString());
                model.addAttribute("errMsg", verifyMessage);
                return "view/www/netZbdl/login";

            } else {
                HttpSession session = request.getSession();

                logger.debug("证书登录：组织机构代码证UniqueID = " + UniqueID + "<br/>");
                String j_password = RandomUtils.generateString("0123456789", 6);
                String j_validation_code = RandomUtils.generateString("0123456789", 4);
                session.setAttribute(CustomAuthenticationProcessingFilter.VALIDATION_CODE, j_validation_code);

                String j_username = UniqueID + "|" + j_password + "|" + "组织机构代码证";
                model.addAttribute("j_username", j_username);
                model.addAttribute("loginName", UniqueID);
                model.addAttribute("j_password", j_password);
                model.addAttribute("j_validation_code", j_validation_code);

                model.addAttribute("UUID", "");
                model.addAttribute("errMsg", "");
                model.addAttribute("cCert", cCert);
                model.addAttribute("cSign", cSign);
                session.setAttribute("orgCode", UniqueID);
                session.setAttribute("user2", UniqueID);
                session.setAttribute(userManager.USERTYPE_KEY, userManager.USERTYPE_NET);

                //记录系统日志
                sysLogManager.log(request, Constants.LOG_TYPE_LOGIN);

//                return "view/www/netZbdl/dispatch";
                return "view/www/netZbdl/index";
            }
        }
    }

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.PROJECT_BID_SIGN_EDIT));

        return "view/www/netZbdl/grid";
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
            Page pageModel = new Page(page, rows, true);
            String hql = "from ProjectBidSign  where create_user ='" + String.valueOf(session.getAttribute("user2")) + "' order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = projectBidSignService.findByPage(pageModel, query);

            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : list) {
                Object id = bean.get("id");
                if (null != id) {
                    ProjectBidSign projectBidSign = projectBidSignService.get(JspHelper.getLong(id));
                    if (checkTime(projectBidSign)) {
                        projectBidSign.setStatus(sysCodeManager.getCodeDetailByCode(Constants.PROJECT_BID_SIGN_STATUS, Constants.PROJECT_BID_SIGN_STATUS_DS));
                        projectBidSignService.save(projectBidSign);
                    }
                    if (null != projectBidSign.getStatus()) {
                        bean.put("statusName", projectBidSign.getStatus().getName());
                    }
                }
            }
            //输出显示
            String json = GridJq.toJSON(list, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 判断是否超过报名截止72h
     *
     * @param projectBidSign .
     */
    private boolean checkTime(ProjectBidSign projectBidSign) {
        Timestamp timestamp = projectBidSign.getSignLastDate();
        Calendar ca = Calendar.getInstance();
        ca.setTimeInMillis(timestamp.getTime());

        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_YEAR, -3);
        return now.after(ca);
    }


    /**
     * 根据报建编号获取工程信息
     *
     * @param bjbh  .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String getProjectInfoByBjbh(String bjbh, Model model) {
        String json = "";
//        ShareProTobuild project = projectManager.getProject(bjbh);
        CustomProjectInfo project = projectManager.getProjectInfoByBjbh(bjbh);
        if (project != null) {
            JSONArray jsonArray = JSONArray.fromObject(project);
            json = jsonArray.toString();
        }
        model.addAttribute("msg", json);
        return "common/msg";
    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        ProjectBidSign projectBidSign = new ProjectBidSign();
        projectBidSign.setSignLastDate(new Timestamp(System.currentTimeMillis()));
        projectBidSign.setSignDate(new Timestamp(System.currentTimeMillis()));
        //如需增加其他默认值请在此添加
        model.addAttribute("bean", projectBidSign);

        return "view/www/netZbdl/input";
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
        ProjectBidSign projectBidSign = projectBidSignService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", projectBidSign);

        return "view/www/netZbdl/input";
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
        ProjectBidSign projectBidSign = projectBidSignService.get(id);
        String hql = "from ProjectBidSignDept where projectBidSign.id='" + id + "'";
        List<ProjectBidSignDept> list = projectBidSignDeptService.findByQuery(hql);
        if (list.size() > 0) {
            model.addAttribute("list", list);
        }
        model.addAttribute("bean", projectBidSign);
        return "view/www/netZbdl/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") ProjectBidSign entity, HttpServletRequest request) throws Exception {
        try {
            ProjectBidSign target;
            if (entity.getId() != null) {
                target = projectBidSignService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "bjbh",
                        "bdh",
                        "projectName",
                        "buildUnit",
                        "buildAddress",
                        "signLastDate",
                        "signProxyUnit",
                        "linkPerson",
                        "linkTel",
                        "signDate",
                        "signAccount"

                });
                BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
                target.setUpdateUser(String.valueOf(request.getSession().getAttribute("user2")));

            } else {
                target = entity;
                BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
                target.setCreateUser(String.valueOf(request.getSession().getAttribute("user2")));
            }
            target.setStatus(sysCodeManager.getCodeDetailByCode(Constants.PROJECT_BID_SIGN_STATUS, Constants.PROJECT_BID_SIGN_STATUS_DJ));
            if (checkTime(target)) {
                target.setStatus(sysCodeManager.getCodeDetailByCode(Constants.PROJECT_BID_SIGN_STATUS, Constants.PROJECT_BID_SIGN_STATUS_DS));
            }

            projectBidSignService.save(target);

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
        ProjectBidSign projectBidSign = projectBidSignService.get(id);
        Set<ProjectBidSignDept> projectBidSignDepts = projectBidSign.getProjectBidSignDepts();
        for (ProjectBidSignDept projectBidSignDept : projectBidSignDepts) {
            projectBidSignDeptService.delete(projectBidSignDept);
        }
        projectBidSignService.delete(id);
        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 退出
     *
     * @param model   .
     * @param session .
     * @param request .
     * @return .
     * @throws Exception
     */
    @RequestMapping
    public String logout(Model model, HttpSession session, HttpServletRequest request) throws Exception {
        //记录系统日志
        sysLogManager.log(request, Constants.LOG_TYPE_LOGOUT);

        if (session != null) {
            session.invalidate();
        }

        String url = "netZbdl/login.do";
        model.addAttribute("url", url);

        return "view/www/netZbdl/logout";
    }

    /**
     * 帮助页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String help(Model model) {

        return "view/net/netProject/help";
    }
}
