package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.OaExpertiseService;
import com.justonetech.biz.daoservice.OaExpertiseUserService;
import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.domain.OaExpertise;
import com.justonetech.biz.domain.OaExpertiseUser;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.manager.MsgMessageManager;
import com.justonetech.biz.utils.enums.OaExpertiseStatus;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.*;


/**
 * note:专业知识学习
 * author: 张超凡
 * create date:
 * modify date:
 */
@Controller
public class OaExpertiseController extends BaseCRUDActionController<OaExpertise> {
    private Logger logger = LoggerFactory.getLogger(OaExpertiseController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private OaExpertiseService oaExpertiseService;

    @Autowired
    private OaExpertiseUserService oaExpertiseUserService;

    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private MsgMessageManager msgMessageManager;
    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_EXPERTISE_EDIT));
        model.addAttribute("canAudit", sysUserManager.hasPrivilege(PrivilegeCode.OA_EXPERTISE_AUDIT));
        model.addAttribute("canDelete", sysUserManager.hasPrivilege(PrivilegeCode.OA_EXPERTISE_DELETE));//强制删除权限

        model.addAttribute("currentUser", sysUserManager.getSysUser().getLoginName());
        pushStaticValueToPage(model);
        return "view/oa/oaExpertise/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from OaExpertise order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = oaExpertiseService.findByPage(pageModel, queryTranslate.toString());
            //获取数据库中数据对应另作处理
            List<Map> mapList = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : mapList) {
                Object id = bean.get("id");
                if (null != id) {
                    OaExpertise oaExpertise = oaExpertiseService.get(JspHelper.getLong(id));
                    bean.put("time", oaExpertise.getBeginDate() + "~" + oaExpertise.getEndDate());
                    bean.put("docButton", documentManager.getDownloadButton(oaExpertise.getDocument()));
                    if (null != oaExpertise.getStatus()) {
                        bean.put("statusName", OaExpertiseStatus.getColorNameByCode(oaExpertise.getStatus()));
                    }
                }
            }
            //输出显示
            String json = GridJq.toJSON(mapList, pageModel);
            sendJSON(response, json);


        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 各种状态的编码
     *
     * @param model .
     */
    private void pushStaticValueToPage(Model model) {

        model.addAttribute("STATUS_EDIT", OaExpertiseStatus.STATUS_EDIT.getCode()); //填写
        model.addAttribute("STATUS_SUBMIT", OaExpertiseStatus.STATUS_SUBMIT.getCode()); //提交
        model.addAttribute("STATUS_BACK", OaExpertiseStatus.STATUS_BACK.getCode()); //退回修改
        model.addAttribute("STATUS_PASS", OaExpertiseStatus.STATUS_PASS.getCode()); //审核通过
        model.addAttribute("STATUS_COMPLETE", OaExpertiseStatus.STATUS_COMPLETE.getCode());//完成操作
    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        OaExpertise oaExpertise = new OaExpertise();

        //如需增加其他默认值请在此添加
        oaExpertise.setBeginDate(new Date(System.currentTimeMillis()));
        oaExpertise.setEndDate(new Date(System.currentTimeMillis()));
        oaExpertise.setDuration("0天");
        String reportPersonName = sysUserManager.getSysUser().getDisplayName();//当前登录用户名
        oaExpertise.setReportPerson(reportPersonName);

        model.addAttribute("bean", oaExpertise);
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), OaExpertise.class.getSimpleName(), oaExpertise.getDocument(), null, null));
        pushStaticValueToPage(model);
        return "view/oa/oaExpertise/input";
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
        OaExpertise oaExpertise = oaExpertiseService.get(id);

        oaExpertise.setBeginDate(new Date(System.currentTimeMillis()));
        oaExpertise.setEndDate(new Date(System.currentTimeMillis()));
        String reportPersonName = sysUserManager.getSysUser().getDisplayName();//当前登录用户名
        oaExpertise.setReportPerson(reportPersonName);


        //处理其他业务逻辑
        model.addAttribute("bean", oaExpertise);
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), OaExpertise.class.getSimpleName(), oaExpertise.getDocument(), null, null));
        pushStaticValueToPage(model);
        return "view/oa/oaExpertise/input";
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
        OaExpertise oaExpertise = oaExpertiseService.get(id);
        pushStaticValueToPage(model);
        //用颜色设定权限控制
        List<SysUser> list = new ArrayList<SysUser>();
        Set<OaExpertiseUser> oaExpertiseUsers = oaExpertise.getOaExpertiseUsers();
        for (OaExpertiseUser oaExpertiseUser : oaExpertiseUsers) {
            list.add(oaExpertiseUser.getUser());
        }
        model.addAttribute("status", OaExpertiseStatus.getColorNameByCode(oaExpertise.getStatus()));
        model.addAttribute("list", list);
        model.addAttribute("oaExpertiseSet", oaExpertise.getOaExpertiseUsers());
        model.addAttribute("docButton", documentManager.getDownloadButton(oaExpertise.getDocument()));
        model.addAttribute("bean", oaExpertise);
        return "view/oa/oaExpertise/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaExpertise entity, HttpServletRequest request) throws Exception {
        try {
            OaExpertise target;
            if (entity.getId() != null) {
                target = oaExpertiseService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "title",
                        "beginDate",
                        "endDate",
                        "duration",
                        "reportPerson",
                        "method",
                        "fee",
                        "studyTarget",
                        "studyContent",
                        "auditMemo",
                        "reportDate",
                        "studyDesc",
                        "status"
                });

            } else {
                target = entity;
            }
            target.setReportDate(new Date(System.currentTimeMillis()));
            String docId = request.getParameter("docId");
            if (StringHelper.isNotEmpty(docId)) {
                DocDocument docDocument = docDocumentService.get(Long.valueOf(docId));
                target.setDocument(docDocument);
            }

            oaExpertiseService.save(target);
            //将知识培训ID绑定到每个人参加人,提取时提取到的是oaExpertiseUserId,
            //保存时先删除
            Set<OaExpertiseUser> oaExpertiseUsers = target.getOaExpertiseUsers();
            if(oaExpertiseUsers.size()>0){
                for (OaExpertiseUser oaExpertiseUser : oaExpertiseUsers) {
                    oaExpertiseUserService.delete(oaExpertiseUser);
                }
            }
            String sysUserIds = request.getParameter("oaExpertiseUserId");//提取字符串参数

            if (!StringHelper.isEmpty(sysUserIds)) {
                String[] userIds = StringHelper.stringToStringArray(sysUserIds, ",");
                for (String userId : userIds) {
                    OaExpertiseUser oaExpertiseUser = new OaExpertiseUser();
                    SysUser sysUser = sysUserService.get(Long.valueOf(userId));
                    oaExpertiseUser.setExpertise(target);
                    oaExpertiseUser.setUser(sysUser);
                    oaExpertiseUserService.save(oaExpertiseUser);
                }
            }
            if (target.getStatus()!= OaExpertiseStatus.STATUS_EDIT.getCode()) {//创建待办事项
                createOaTask(target);
            }

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 创建系统任务
     *
     * @param data .
     * @throws Exception .
     */
    public void createOaTask(OaExpertise data ) throws Exception {
        //创建任务
        int Status=data.getStatus();
        if(Status==OaExpertiseStatus.STATUS_SUBMIT.getCode()) {
            Set<Long> allUserIds = new HashSet<Long>();

            String privilegeCode = PrivilegeCode.OA_EXPERTISE_AUDIT;
            String title = oaTaskManager.getTaskTitle(data, OaExpertise.class.getSimpleName());

            Set<Long> managers = sysUserManager.getUserIdsByPrivilegeCode(privilegeCode);
            if (managers.size() > 0) {
                oaTaskManager.createTask(OaExpertise.class.getSimpleName(), data.getId(), title, managers, false, null, null);
                allUserIds.addAll(managers);
            }
        }
        if(Status==OaExpertiseStatus.STATUS_PASS.getCode()||Status==OaExpertiseStatus.STATUS_BACK.getCode()) {
            SysUser sysUser = sysUserManager.getSysUser();
            SysUser receiveUser = sysUserManager.getSysUserByDisplayName(data.getReportPerson());
            String msgTemp = oaTaskManager.getTaskTitle(data, OaExpertise.class.getSimpleName()+"_Pass");
            if(Status==OaExpertiseStatus.STATUS_BACK.getCode()){
                msgTemp = oaTaskManager.getTaskTitle(data, OaExpertise.class.getSimpleName()+"_Back");
            }
            String[] ids = new String[1];
            if (null!=receiveUser) {
                ids[0]= String.valueOf(receiveUser.getId());
                msgMessageManager.sendSmsByUser(msgTemp, sysUser, ids);
            }
        }

    }



    /**
     * 审核页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String audit(Model model, Long id) {
        OaExpertise oaExpertise = oaExpertiseService.get(id);
        oaExpertise.setReportDate(new Date(System.currentTimeMillis()));
        model.addAttribute("docButton", documentManager.getDownloadButton(oaExpertise.getDocument()));
        model.addAttribute("bean", oaExpertise);
        pushStaticValueToPage(model);
        return "view/oa/oaExpertise/audit";
    }

    /*
    * 完成页面
    * */

    @RequestMapping
    public String complete(Model model, Long id) {
        OaExpertise oaExpertise = oaExpertiseService.get(id);
        oaExpertise.setReportDate(new Date(System.currentTimeMillis()));
        model.addAttribute("docButton", documentManager.getDownloadButton(oaExpertise.getDocument()));
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), OaExpertise.class.getSimpleName(), oaExpertise.getDocument(), null, null));
        model.addAttribute("bean", oaExpertise);
        pushStaticValueToPage(model);
        return "view/oa/oaExpertise/complete";

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
        OaExpertise oaExpertise = oaExpertiseService.get(id);
        Long docId = oaExpertise.getDocument() != null ? oaExpertise.getDocument().getId() : null;
        Set<OaExpertiseUser> oaExpertiseUsers = oaExpertise.getOaExpertiseUsers();
        for (OaExpertiseUser oaExpertiseUser : oaExpertiseUsers) {
            oaExpertiseUserService.delete(oaExpertiseUser.getId());
        }
        oaTaskManager.removeTask(OaExpertise.class.getSimpleName(), id);//删除任务

        oaExpertiseService.delete(id);
        documentManager.removeAllDoc(docId,null);
        sendSuccessJSON(response, "删除成功");
    }

}