package com.justonetech.biz.controller.www;

import com.justonetech.biz.daoservice.DocDocumentAttachService;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.OaPublicInfoService;
import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.domain.DocDocumentAttach;
import com.justonetech.biz.domain.OaPublicInfo;
import com.justonetech.biz.manager.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.UrlParser;
import com.justonetech.biz.utils.enums.PersonRegOpinion;
import com.justonetech.biz.utils.enums.PersonRegSource;
import com.justonetech.biz.utils.operationMsg.OperationMsgManager;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.CryptUtil;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.daoservice.SysRegPersonService;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysRegPerson;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.filter.CustomAuthenticationProcessingFilter;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.FileUtils;
import com.justonetech.system.utils.Md5Utils;
import com.justonetech.system.utils.PrivilegeCode;
import com.justonetech.system.utils.UserSessionUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.sql.Timestamp;
import java.util.*;


/**
* 外部网站
* Date: 12-4-20
*/
@Controller
public class SiteController extends BaseCRUDActionController {

    @Autowired
    private OaPublicInfoManager oaPublicInfoManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private OaPublicInfoService oaPublicInfoService;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SiteManager siteManager;

    @Autowired
    private DocDocumentAttachService docDocumentAttachService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private SysRegPersonService sysRegPersonService;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private SysCodeDetailService sysCodeDetailService;

    @Autowired
    private RegPersonManager regPersonManager;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private MsgMessageManager msgMessageManager;

    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private SysUserManager sysUserManager;

    /**
     * 网站首页
     *
     * @param model .
     * @param type  .
     * @return .
     */
    @RequestMapping
    public String index(Model model, String type) {
        siteManager.setTypeModel(model, type);

        //获取各个板块详细
        model.addAttribute("work", oaPublicInfoManager.getPublicList(Constants.OA_PUBLIC_INFO_RANGE_OUT, Constants.OA_PUBLIC_INFO_TYPE_WORK, 7));
        List<OaPublicInfo> oaNews = oaPublicInfoManager.getPublicList(Constants.OA_PUBLIC_INFO_RANGE_OUT, Constants.OA_PUBLIC_INFO_TYPE_NEWS, 6);
        if (oaNews.size()>0) {
            oaNews.remove(0);
        }
        //不包括置顶信息
        model.addAttribute("news", oaNews);
        model.addAttribute("bulletin", oaPublicInfoManager.getPublicList(Constants.OA_PUBLIC_INFO_RANGE_OUT, Constants.OA_PUBLIC_INFO_TYPE_BULLETIN, 7));
        model.addAttribute("policy", oaPublicInfoManager.getPublicList(Constants.OA_PUBLIC_INFO_RANGE_OUT, Constants.OA_PUBLIC_INFO_TYPE_POLICY, 7));
        model.addAttribute("policyopen", oaPublicInfoManager.getPublicList(Constants.OA_PUBLIC_INFO_RANGE_OUT, Constants.OA_PUBLIC_INFO_TYPE_POLICYOPEN, 7));
        model.addAttribute("partyMeber", oaPublicInfoManager.getPublicList(Constants.OA_PUBLIC_INFO_RANGE_OUT, Constants.OA_PUBLIC_INO_TYPE_PARTYMEMBER, 7));
        model.addAttribute("pic", oaPublicInfoManager.getPublicList(Constants.OA_PUBLIC_INFO_RANGE_OUT, Constants.OA_PUBLIC_INFO_TYPE_PIC, 7));

        //显示最多字符数量
        model.addAttribute("maxWordCount", 25);
        model.addAttribute("maxCountList", 27);

        //置顶新闻
        model.addAttribute("topNews", oaPublicInfoManager.getTopNews(Constants.OA_PUBLIC_INFO_TYPE_NEWS));

        //公告信息
        List<OaPublicInfo> gonggao = oaPublicInfoManager.getPublicList(Constants.OA_PUBLIC_INFO_RANGE_OUT, Constants.OA_PUBLIC_INFO_TYPE_BULLETIN, 3);
        model.addAttribute("gonggao", gonggao);

        return "view/www/index";
    }

    /**
     * 获取首页顶部的图片幻灯页面
     *
     * @param model   .
     * @param request .
     * @return .
     * @throws java.io.IOException .
     */
    @RequestMapping
    public String getPictureSideShow(Model model, HttpServletRequest request) throws IOException {
        //模块类型，首页取建管新闻类型
        String type = request.getParameter("type");
        if (StringHelper.isEmpty(type)) type = Constants.OA_PUBLIC_INFO_TYPE_NEWS;

        //物理路径
        String ctx = request.getRealPath("");
        int maxCount = 5;//设置最大图片数量

        List<OaPublicInfo> news = oaPublicInfoManager.getPublicList(Constants.OA_PUBLIC_INFO_RANGE_OUT, type, 10, oaPublicInfoManager.IS_SHOW_TOP_ALL, true);
        List<Map<String, Object>> images = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        for (OaPublicInfo oa : news) {

            //判断图片是否存在
            if ((oa.getThumbnail()) != null) {
                if (FileUtils.exist(ctx + oa.getThumbnail())) {
                    map = new HashMap<String, Object>();
                    map.put("urls", oa.getThumbnail());
                    map.put("titles", oa.getTitle());
                    map.put("id", oa.getId());
                    images.add(map);
                }
            }
            if (images.size() >= maxCount) {
                break;
            }
        }

        //不足5张图片时,用默认补充至5张
        if (images.size() < 5) {
            int size = images.size();
            for (int i = 0; i < 5 - size; i++) {
                map = new HashMap<String, Object>();
                map.put("urls", "/view/www/images/newsimagedefault" + i + ".jpg");
                map.put("title", "default" + i);
                map.put("id", "none");
                images.add(map);
            }
        }
        model.addAttribute("newsUrl", images);

        return "view/www/getPictureSideShow";
    }

    /**
     * 获取首页中部的图片滚动页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String getIndexPicRolling(Model model, HttpServletRequest request) {
        int maxCount = 6; //设置最大图片数量
        List<OaPublicInfo> oaPublicLists = oaPublicInfoManager.getPublicList(Constants.OA_PUBLIC_INFO_RANGE_OUT, Constants.OA_PUBLIC_INFO_TYPE_PIC, 10, oaPublicInfoManager.IS_SHOW_TOP_ALL, true);
        List<Map<String, Object>> picList = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        int count = maxCount - 1;
        for (OaPublicInfo oaPublicInfo : oaPublicLists) {
            if (oaPublicInfo.getIconImage() != null) {
                map = new HashMap<String, Object>();
                if (oaPublicInfo.getThumbnail() != null) {
                    if (FileUtils.exist(request.getRealPath("") + oaPublicInfo.getThumbnail())) {
                        map.put("url", oaPublicInfo.getThumbnail());
                    } else {
                        map.put("url", "/view/www/images/defaultRollingImage-" + count + ".jpg");
                        count--;
                    }
                    if (picList.size() >= maxCount) {
                        break;
                    } else {
                        picList.add(map);
                    }
                }
                if (picList.size() >= maxCount)
                    break;
            }
        }
        int size = picList.size();
        if (size < maxCount) {
            for (int i = 0; i < maxCount - size; i++) {
                map = new HashMap<String, Object>();
                map.put("url", "/view/www/images/defaultRollingImage-" + i + ".jpg");
                picList.add(map);
            }
        }
        model.addAttribute("OA_PUBLIC_INFO_TYPE_PIC", Constants.OA_PUBLIC_INFO_TYPE_PIC);
        model.addAttribute("picList", picList);
        return "view/www/getIndexPicRolling";
    }

    /**
     * 信息查看页面
     *
     * @param model .
     * @param id    .
     * @return .
     */
    @RequestMapping
    public String infoView(Model model, Long id, String type) {
        siteManager.setTypeModel(model, type);

        OaPublicInfo oaPublicInfo = oaPublicInfoService.get(id);
        if (oaPublicInfo.getDocument() != null) {
            model.addAttribute("document", documentManager.getDownloadFile(oaPublicInfo.getDocument()));
        }
        model.addAttribute("bean", oaPublicInfo);

        //更新访问次数
        oaPublicInfoManager.updateVisitTimes(oaPublicInfo);

        return "view/www/infoView";
    }

    /**
     * 网站二级页面
     *
     * @param model  .
     * @param type   .
     * @param pageNo .
     * @return .
     */
    @RequestMapping
    public String list(Model model, String type, String pageNo) {
        siteManager.setTypeModel(model, type);

        //置顶新闻
//        model.addAttribute("topNews", oaPublicInfoManager.getTopNews(Constants.OA_PUBLIC_INFO_TYPE_NEWS));

        //列表翻页记录
        int topRecordNum = 7;
        List<OaPublicInfo> list = oaPublicInfoManager.getPublicList(Constants.OA_PUBLIC_INFO_RANGE_OUT, type, 0, oaPublicInfoManager.IS_SHOW_TOP_ALL, false);
        Page page = new Page(StringHelper.isEmpty(pageNo) ? 1 : Integer.parseInt(pageNo), siteManager.PAGE_SIZE, list);
        List<OaPublicInfo> pageall = page.getRows();
        List<OaPublicInfo> pagepart1 = new ArrayList<OaPublicInfo>();
        List<OaPublicInfo> pagepart2 = new ArrayList<OaPublicInfo>();

        for (int i = 0; i < pageall.size(); i++) {
            if (i < topRecordNum) {
                pagepart1.add(pageall.get(i));
            } else {
                pagepart2.add(pageall.get(i));
            }
        }
        model.addAttribute("listWordCountpart1", 25);
        model.addAttribute("listWordCountpart2", 45);
        model.addAttribute("pagepart1", pagepart1);
        model.addAttribute("pagepart2", pagepart2);
        model.addAttribute("page", page);
        model.addAttribute("pageUrl", "list.do?type=" + type);

        //公告信息
        List<OaPublicInfo> gonggao = oaPublicInfoManager.getPublicList(Constants.OA_PUBLIC_INFO_RANGE_OUT, Constants.OA_PUBLIC_INFO_TYPE_BULLETIN, 1);
        model.addAttribute("gonggao", gonggao);

        //机构介绍比较特殊
        if (type.equals("intro")) {
            return "view/www/introduce";
        }
        return "view/www/list";
    }

    /**
     * 工程图片--列表页面
     *
     * @param model  .
     * @param type   .
     * @param pageNo .
     * @return .
     */
    @RequestMapping
    public String pic(Model model, String type, String pageNo) {
        siteManager.setTypeModel(model, type);

        //列表翻页记录
        List<OaPublicInfo> list = oaPublicInfoManager.getPublicList(Constants.OA_PUBLIC_INFO_RANGE_OUT, type, 0, 0, false);
        Page page = new Page(StringHelper.isEmpty(pageNo) ? 1 : Integer.parseInt(pageNo), siteManager.PAGE_SIZE, list);

        model.addAttribute("page", page);
        model.addAttribute("pageUrl", "list.do?type=" + type);
        model.addAttribute("topWordCount", 20);

        return "view/www/pic";
    }

    /**
     * 工程图片--查看页面
     *
     * @param model .
     * @param id    .
     * @return .
     */
    @RequestMapping
    public String picView(Model model, Long id, String type) {
        siteManager.setTypeModel(model, type);
        model.addAttribute("siteName", configManager.getSiteName());

        OaPublicInfo oaPublicInfo = oaPublicInfoService.get(id);
        DocDocument docDocument = oaPublicInfo.getDocument();
        Set<DocDocumentAttach> attaches = new HashSet<DocDocumentAttach>();
        if (docDocument != null) {
            if (docDocument.getDocDocumentAttachs() != null) {
                attaches = docDocument.getDocDocumentAttachs();
            }
        }
        model.addAttribute("attach", attaches);
        model.addAttribute("bean", oaPublicInfo);

        return "view/www/picView";
    }

    /**
     * 图片展示
     *
     * @param request  .
     * @param response .
     * @param id       .
     * @return .
     * @throws java.io.IOException .
     */
    @RequestMapping
    public String displayPhoto(HttpServletRequest request, HttpServletResponse response, @RequestParam Long id) throws IOException {
        String path = "";
        OutputStream outputStream = response.getOutputStream();
        request.setCharacterEncoding("utf-8");
        if (id > 0) {
            DocDocumentAttach attach = docDocumentAttachService.get(id);
            //response.setContentType("image/*");
            //图片存放的路径
            path = documentManager.getDocPath(attach.getDocument().getCategory(), "") + File.separator + attach.getSaveFileName();
        } else {
            path = request.getRealPath("") + "/view/www/images/defaultRollingImage" + id + ".jpg";
        }
        if (FileUtils.exist(path)) {
            InputStream inputStream = new FileInputStream(path);
            IOUtils.copy(inputStream, outputStream);
        } else {
            path = request.getSession().getServletContext().getRealPath("") + File.separator + "skin/images" + File.separator + Constants.SYS_NOPICTURE_PIC;
            InputStream inputStream = new FileInputStream(path);
            IOUtils.copy(inputStream, outputStream);
        }
        outputStream.flush();
        outputStream.close();
        return null;
    }

    /**
     * 验证登录--预先验证再用spring验证
     *
     * @param request      .
     * @param userName     .
     * @param password     .
     * @param validateCode .
     * @param model        .
     * @return .
     * @throws java.io.IOException .
     */
    @RequestMapping
    public String checkLogin(HttpServletRequest request, String userName, String password, String validateCode, Model model) throws Exception {
        SysUser user = sysUserService.findUniqueByProperty("loginName", userName);
        String msg = "{status:false,msg:'用户名或密码不正确!'}";
        String code = request.getSession().getAttribute(CustomAuthenticationProcessingFilter.VALIDATION_CODE).toString();
        if (user != null) {
            if (!StringHelper.isEmpty(user.getPassword())) {
                String userPassword = CryptUtil.decrypt(user.getPassword());
                if (!password.equals(userPassword)) {
                    msg = "{status:false,msg:'账号或密码不正确!'}";

                } else if (!validateCode.toUpperCase().equals(code.toUpperCase())) {
                    msg = "{status:false,msg:'验证码不正确!'}";

                } else if (!UserSessionUtils.getInstance().isUserValid(user) || (user.getCloseDate() != null && user.getCloseDate().before(new Date(System.currentTimeMillis())))) {
                    msg = "{status:false,msg:'账号已失效或被锁定!'}";

                } else if (user.getRegPerson() == null) {
                    msg = "{status:false,msg:'指定账号不存在，请检查输入是否正确!'}";

                } else {
                    msg = "{status:true,msg:'验证成功!'}";
                }
            }
        }
        model.addAttribute("msg", msg);
        return "common/msg";
    }

    @RequestMapping
    public String about(Model model, String type) throws Exception {
        siteManager.setTypeModel(model, type);
        model.addAttribute("typeName", "联系我们");
        return "view/www/about";
    }

    /**
     * 用户注册页面跳转
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String reg(Model model, String type) throws Exception {
        siteManager.setTypeModel(model, type);
        siteManager.setRegType(model, Constants.SYS_REGPERSON_TYPE_UNIT_SG);
//        model.addAttribute("typeName", "注册");
        return "view/www/reg";
    }

    /**
     * 用户注册下一步
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String regNext(Model model, String type, String regType) throws Exception {
        siteManager.setTypeModel(model, type);
        siteManager.setRegType(model, regType);
        return "view/www/reg_next";
    }

    /**
     * 用户注册
     *
     * @param request .
     * @param model   .
     * @return .
     * @throws java.io.IOException .
     */
    @RequestMapping
    public String regPerson(HttpServletRequest request, Model model) throws Exception {
        String regType = request.getParameter("regType");
        String regPersonType = "";
        SysRegPerson sysRegPerson = new SysRegPerson();
        if (regType.equals(Constants.SYS_REGPERSON_TYPE_Gd)) {
            regPersonType = "工地用户";
            String gdCode = request.getParameter("gdCode");
            String bjbh = projectManager.getGDInfo(gdCode).getBjbh();
            String projectName = request.getParameter("projectName");
            sysRegPerson.setBjbh(bjbh);
            sysRegPerson.setGdCode(gdCode);
            sysRegPerson.setProjectName(projectName);
            sysRegPerson.setRegType(sysCodeManager.getCodeDetailByCode(Constants.SYS_REGPERSON_TYPE, Constants.SYS_REGPERSON_TYPE_Gd));

        } else if (regType.equals(Constants.SYS_REGPERSON_TYPE_UNIT_JS)) {
            regPersonType = "建设单位用户";
            String bjbh = request.getParameter("bjbh");
            String projectCard = request.getParameter("projectCard");
            String projectName = request.getParameter("projectName");
            sysRegPerson.setBjbh(bjbh);
            sysRegPerson.setProjectCard(projectCard);
            sysRegPerson.setProjectName(projectName);
            sysRegPerson.setRegType(sysCodeManager.getCodeDetailByCode(Constants.SYS_REGPERSON_TYPE, Constants.SYS_REGPERSON_TYPE_UNIT_JS));

        } else if (regType.equals(Constants.SYS_REGPERSON_TYPE_UNIT_SG)) {
            regPersonType = "施工单位用户";
            String bjbh = request.getParameter("bjbh");
            String unitCode = request.getParameter("unitCode");
            String unitIdentifyCode = request.getParameter("unitIdentifyCode");
            String unitName = request.getParameter("unitName");
            sysRegPerson.setBjbh(bjbh);
            sysRegPerson.setUnitCode(unitCode);
            sysRegPerson.setUnitIdentifyCode(unitIdentifyCode);
            sysRegPerson.setUnitName(unitName);
            sysRegPerson.setRegType(sysCodeManager.getCodeDetailByCode(Constants.SYS_REGPERSON_TYPE, Constants.SYS_REGPERSON_TYPE_UNIT_SG));
        } else if (regType.equals(Constants.SYS_REGPERSON_TYPE_UNIT_JL)) {
            regPersonType = "监理单位用户";
            String bjbh = request.getParameter("bjbh");
            String unitCode = request.getParameter("unitCode");
            String unitIdentifyCode = request.getParameter("unitIdentifyCode");
            String unitName = request.getParameter("unitName");
            sysRegPerson.setBjbh(bjbh);
            sysRegPerson.setUnitCode(unitCode);
            sysRegPerson.setUnitIdentifyCode(unitIdentifyCode);
            sysRegPerson.setUnitName(unitName);
            sysRegPerson.setRegType(sysCodeManager.getCodeDetailByCode(Constants.SYS_REGPERSON_TYPE, Constants.SYS_REGPERSON_TYPE_UNIT_JL));
        }
        String personName = request.getParameter("personName").trim();
        String mobile = request.getParameter("mobile").trim();
        sysRegPerson.setAcceptDatetime(DateTimeHelper.getTimestamp());
        sysRegPerson.setMobile(mobile);
        sysRegPerson.setPersonName(personName);
        sysRegPerson.setRegResource(PersonRegSource.RESOURCE_WEBSITE.getCode());
        sysRegPerson.setAcceptOpinion(PersonRegOpinion.OPINION_NOTACCEPT.getCode());
        sysRegPersonService.save(sysRegPerson);

        String title = regPersonType + "（" + personName + "）" + "提交注册，请您及时审核！";

        //角色权限
        String hql1 = "select distinct r.user from SysUserRole r,SysRolePrivilege g where g.role.id=r.role.id and g.privilege.code='{0}'";
        hql1 = FormatUtils.format(hql1, PrivilegeCode.SYS_REGPERSON_EDIT);
        List<SysUser> byQuery1 = sysUserService.findByQuery(hql1);

        //用户权限
        String hql2 = "select distinct p.user from SysUserPrivilege p where p.isDeny=false and p.privilege.code='{0}'";
        hql2 = FormatUtils.format(hql2, PrivilegeCode.SYS_REGPERSON_EDIT);
        List<SysUser> byQuery2 = sysUserService.findByQuery(hql2);
        Set<Long> useIds = new HashSet<Long>();
        for (SysUser sysUser : byQuery1) {
            useIds.add(sysUser.getId());
        }
        for (SysUser sysUser : byQuery2) {
            useIds.add(sysUser.getId());
        }
        //创建任务提示
        oaTaskManager.createTask(SysRegPerson.class.getSimpleName(), sysRegPerson.getId(), title, useIds);

        return OperationMsgManager.successCloseMsg(model, null, "注册成功,请等待受理");
    }


    /**
     * 验证是否已有注册
     *
     * @throws Exception .
     */
    @RequestMapping
    public String getReg(String loginName, Model model, String regType) throws Exception {
        String regInfo = regPersonManager.isReg(loginName, regType);
        if (regInfo.equals("用户已经注册!!") || regInfo.equals("未找到有效编号!!")) {
            model.addAttribute("msg", "{success:'false',msg:'" + regInfo + "'}");
        } else {
            model.addAttribute("msg", "{success:'true',msg:'" + regInfo + "'}");
        }
        return "common/msg";
    }

    /**
     * 找回密码页面跳转
     *
     * @throws Exception .
     */
    @RequestMapping
    public String regGetPass(Model model, String type) throws Exception {
        siteManager.setTypeModel(model, type);
        siteManager.setRegType(model, Constants.SYS_REGPERSON_TYPE_UNIT_SG);
        return "view/www/regGetPass";
    }

    /**
     * 找回密码页面跳转
     *
     * @throws Exception .
     */
    @RequestMapping
    public String regGetPassSend(HttpServletRequest request, Model model, String type) throws Exception {
        String regType = request.getParameter("regType");
        siteManager.setTypeModel(model, type);
        siteManager.setRegType(model, regType);

        String personName = request.getParameter("personName").trim();
        String mobile = request.getParameter("mobile").trim();
        String code = request.getParameter("code").trim();
        SysRegPerson sysRegPerson = regPersonManager.getRegPerson(code);
        if (sysRegPerson != null) {
            SysUser sysUser = sysUserService.findUniqueByProperty("loginName", code);
            if (sysRegPerson.getRegType().getCode().equals(regType) && sysRegPerson.getMobile().equals(mobile) && sysRegPerson.getPersonName().equals(personName)) {
                int pas = (int) (Math.random() * 999999);
                if (pas < 100000) {
                    pas += 100000;
                }
                sysUser.setPassword(CryptUtil.encrypt(String.valueOf(pas)));
                sysUser.setMd5Pass(Md5Utils.md5(String.valueOf(pas)));
                sysUser.setPasswordUpdateTime(new Timestamp(System.currentTimeMillis()));
                String message = "您注册的用户已通过找回功能重置密码,您的用户名为:" + sysUser.getLoginName() + ",密码为:" + pas + ",请牢记!";
                sysUserService.update(sysUser);
                msgMessageManager.sendSmsByRegPerson(message + " " + configManager.getSiteName(), null, sysRegPerson);
                return OperationMsgManager.successCloseMsg(model, null, "重置密码已经通过短信发送到您的手机,请注意查收");
            } else {
                return OperationMsgManager.errorMsg(model, null, "填写信息与注册信息不一致!");
            }
        }
        return OperationMsgManager.errorMsg(model, null, "账号未注册!");
    }

    /**
     * 查询受理号
     * --从建交委网站获取数据
     *
     * @param model .
     * @param code  .
     * @return .
     */
    @RequestMapping
    public String querySlh(Model model, String code) throws Exception {
        String link = "http://bsdt.ciac.sh.cn/ApproveManage/Home/Details_SN/" + code;
        URL url = new URL(link);
        org.jsoup.nodes.Document doc = UrlParser.getDocument(url, 3000);
        Boolean getDataSuccess = false;
        if (doc != null) {
            //申请信息
            String[] applyInfos = UrlParser.getDocTexts(doc, "table[class=biao_jg]");
//            for (String s : applyInfos) {
//                System.out.println("s = " + s);
//            }
            if (!StringHelper.isEmpty(applyInfos[0])) {
                getDataSuccess = true;
            }
            model.addAttribute("applyInfos", applyInfos);

            //过程信息
            String[] processInfos = UrlParser.getDocTexts(doc, "table[class=biao_nb]");
//            for (String s : processInfos) {
//                System.out.println("s = " + s);
//            }
            int columnLen = 3;
            List<String[]> processList = new ArrayList<String[]>();
            String[] columns = new String[columnLen];
            for (int i = 1; i <= processInfos.length; i++) {
                String processInfo = processInfos[i - 1];
                int tmp = i % columnLen;
//                System.out.println(i + " = " + tmp + "|" + processInfo);
                if (i == 1 || tmp == 1) {
                    columns = new String[columnLen];
                }
                if (tmp == 0) tmp = 3;
                columns[tmp - 1] = processInfo;

                if (i > 1 && tmp == 3) {
                    processList.add(columns);
                }
            }
            model.addAttribute("processList", processList);
        }
        model.addAttribute("getDataSuccess", getDataSuccess);
        model.addAttribute("code", code);
        return "view/www/querySlh";
    }
}
