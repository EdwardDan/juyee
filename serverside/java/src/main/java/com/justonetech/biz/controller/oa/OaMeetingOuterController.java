package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.OaFgldSetItemService;
import com.justonetech.biz.daoservice.OaFgldSetService;
import com.justonetech.biz.daoservice.OaMeetingOuterService;
import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.domain.OaFgldSet;
import com.justonetech.biz.domain.OaFgldSetItem;
import com.justonetech.biz.domain.OaMeetingOuter;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.OaFgldManager;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.OaMeetingStatus;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysPerson;
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
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * note:外出会议
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaMeetingOuterController extends BaseCRUDActionController<OaMeetingOuter> {
    private Logger logger = LoggerFactory.getLogger(OaMeetingOuterController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private OaMeetingOuterService oaMeetingOuterService;

    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private OaFgldManager oaFgldManager;

    @Autowired
    private OaFgldSetService oaFgldSetService;

    @Autowired
    private OaFgldSetItemService oaFgldSetItemService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        String statusList = OaMeetingStatus.getOptions("");
        model.addAttribute("statusList", statusList);
        setStatus(model);
        return "view/oa/oaMeetingOuter/grid";
    }

    public void setStatus(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_MEETING_OUTER_EDIT));
        model.addAttribute("canEdit_FG", sysUserManager.hasPrivilege(PrivilegeCode.OA_MEETING_OUTER_AUDIT_FG));
        model.addAttribute("canEdit_ZR", sysUserManager.hasPrivilege(PrivilegeCode.OA_MEETING_OUTER_AUDIT_ZR));

        //填报状态
        model.addAttribute("STATUS_EDIT", OaMeetingStatus.STATUS_EDIT.getCode());
        model.addAttribute("STATUS_SUBMIT", OaMeetingStatus.STATUS_SUBMIT.getCode());
        model.addAttribute("STATUS_BRANCH_PASS", OaMeetingStatus.STATUS_BRANCH_PASS.getCode());
        model.addAttribute("STATUS_BRANCH_BACK", OaMeetingStatus.STATUS_BRANCH_BACK.getCode());
        model.addAttribute("STATUS_MAIN_PASS", OaMeetingStatus.STATUS_MAIN_PASS.getCode());
        model.addAttribute("STATUS_MAIN_BACK", OaMeetingStatus.STATUS_MAIN_BACK.getCode());
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, String queryJson) {
        try {
            String status = StringHelper.getElementValue(queryJson, "status");
            Page pageModel = new Page(page, rows, true);
            String hql = "from OaMeetingOuter where 1=1 ";

            if (sysUserManager.hasPrivilege(PrivilegeCode.OA_MEETING_OUTER_AUDIT_ZR)) {
                hql += " and status in(" + OaMeetingStatus.STATUS_BRANCH_PASS.getCode() + "," + OaMeetingStatus.STATUS_MAIN_PASS.getCode() + "," + OaMeetingStatus.STATUS_MAIN_BACK.getCode() + ")";
            } else if (sysUserManager.hasPrivilege(PrivilegeCode.OA_MEETING_OUTER_AUDIT_FG)) {
                String fgldByLoginNames = getFgldPersonNames(sysUserManager.getSysUser());
                hql += " and createUser in('" + StringHelper.findAndReplace(fgldByLoginNames, ",", "','") + "')";
            } else if (sysUserManager.hasPrivilege(PrivilegeCode.OA_MEETING_OUTER_EDIT)) {
                //取当前用户部门下的人员
                List<SysUser> deptUsers = sysUserManager.getDeptUsers(sysUserManager.getSysUser().getPerson().getDept());
                String sysUserDeptNames = "";
                for (SysUser deptUser : deptUsers) {
                    sysUserDeptNames += "," + deptUser.getLoginName();
                }
                hql += " and createUser in('" + StringHelper.findAndReplace(sysUserDeptNames, ",", "','") + "')";
            }

            if (!StringHelper.isEmpty(status)) {
                hql += " and status =" + status;
            }
            hql += " order by id desc";
            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = oaMeetingOuterService.findByPage(pageModel, queryTranslate.toString());
            session.setAttribute(Constants.GRID_SQL_KEY, queryTranslate.toString());
            List<Map> mapList = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : mapList) {
                Object id = bean.get("id");
                if (null != id) {
                    OaMeetingOuter oaMeetingOuter = oaMeetingOuterService.get(JspHelper.getLong(id));
                    if (null != oaMeetingOuter.getDoc()) {
                        bean.put("docButton", documentManager.getDownloadButton(oaMeetingOuter.getDoc()));
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
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        OaMeetingOuter oaMeetingOuter = new OaMeetingOuter();
        oaMeetingOuter.setStatus(OaMeetingStatus.STATUS_EDIT.getCode());
        setStatus(model);
        //如需增加其他默认值请在此添加
        model.addAttribute("bean", oaMeetingOuter);
        //上传文档功能
        model.addAttribute("uploadButtonDocument", documentManager.getUploadButtonForMulti(documentManager.getDefaultXmlConfig(), OaMeetingOuter.class.getSimpleName(), oaMeetingOuter.getDoc(), null, null, "Document"));

        return "view/oa/oaMeetingOuter/input";
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
        OaMeetingOuter oaMeetingOuter = oaMeetingOuterService.get(id);
        setStatus(model);
        //处理其他业务逻辑
        model.addAttribute("bean", oaMeetingOuter);
        //上传文档功能
        model.addAttribute("uploadButtonDocument", documentManager.getUploadButtonForMulti(documentManager.getDefaultXmlConfig(), OaMeetingOuter.class.getSimpleName(), oaMeetingOuter.getDoc(), null, null, "Document"));

        return "view/oa/oaMeetingOuter/input";
    }

    /**
     * 审核显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String audit(Model model, Long id) {
        OaMeetingOuter oaMeetingOuter = oaMeetingOuterService.get(id);
        setStatus(model);
        //处理其他业务逻辑
        model.addAttribute("bean", oaMeetingOuter);
        model.addAttribute("docButton", documentManager.getDownloadButton(oaMeetingOuter.getDoc()));

        return "view/oa/oaMeetingOuter/audit";
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
        OaMeetingOuter oaMeetingOuter = oaMeetingOuterService.get(id);
        setStatus(model);
        model.addAttribute("docButton", documentManager.getDownloadButton(oaMeetingOuter.getDoc()));
        model.addAttribute("bean", oaMeetingOuter);

        return "view/oa/oaMeetingOuter/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaMeetingOuter entity, HttpServletRequest request, Integer status) throws Exception {
        String msg = "保存成功";
        try {
            OaMeetingOuter target;
            if (entity.getId() != null) {
                target = oaMeetingOuterService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "beginTime",
                        "endTime",
                        "address",
                        "chargePerson",
                        "startDept",
                        "leader",
                        "innerPersons",
                        "title",
                        "content",
                        "relateMatter",
                        "workAdvise",
                        "attendDepts",
                        "attendPersons",
                });
            } else {
                target = entity;
            }
            //附件保存
            String docIdDocument = request.getParameter("docIdDocument");
            if (!StringHelper.isEmpty(docIdDocument)) {
                DocDocument docDocument = docDocumentService.get(Long.parseLong(docIdDocument));
                target.setDoc(docDocument);
                documentManager.updateDocumentByBizData(docDocument, null, target.getTitle());
            }
            target.setStatus(status);
            oaMeetingOuterService.save(target);
            if (OaMeetingStatus.STATUS_SUBMIT.getCode() == target.getStatus()) {
                msg = "提交!";
                createOaTask(target);
            }
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, msg);
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void auditSave(HttpServletResponse response, @ModelAttribute("bean") OaMeetingOuter entity, Integer status) throws Exception {
        String msg = "保存成功";
        try {
            OaMeetingOuter target;
            if (entity.getId() != null) {
                target = oaMeetingOuterService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "fgAuditOpinion",
                        "zrAuditOpinion"
                });
            } else {
                target = entity;
            }
            target.setStatus(status);
            //根据状态保存相应的时间
            if (OaMeetingStatus.STATUS_BRANCH_PASS.getCode() == status || OaMeetingStatus.STATUS_BRANCH_BACK.getCode() == status) {
                target.setFgAuditTime(new Timestamp(System.currentTimeMillis()));
                BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
                if (loginUser != null) {
                    target.setFgAuditUser(sysUserManager.getSysUser(loginUser.getLoginName()));
                }
            }
            if (OaMeetingStatus.STATUS_MAIN_PASS.getCode() == status || OaMeetingStatus.STATUS_MAIN_BACK.getCode() == status) {
                target.setZrAuditTime(new Timestamp(System.currentTimeMillis()));
                BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
                if (loginUser != null) {
                    target.setZrAuditUser(sysUserManager.getSysUser(loginUser.getLoginName()));
                }
            }

            oaMeetingOuterService.save(target);
            if (OaMeetingStatus.STATUS_BRANCH_BACK.getCode() == target.getStatus() || OaMeetingStatus.STATUS_MAIN_BACK.getCode() == target.getStatus()) {
                msg = "已退回修改!";
            } else if (OaMeetingStatus.STATUS_BRANCH_PASS.getCode() == target.getStatus() || OaMeetingStatus.STATUS_MAIN_PASS.getCode() == target.getStatus()) {
                msg = "审核已通过!";
            }
            createOaTask(target);
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, msg);
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
        oaMeetingOuterService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 分管领导所管辖的人员登录名
     *
     * @param sysUser .
     * @return .
     */
    public String getFgldPersonNames(SysUser sysUser) {
        String personNames = "";
        String hql = "from OaFgldSet where user.loginName=?";
        OaFgldSet data = oaFgldSetService.findUnique(hql + " and isLeaf=1", sysUser.getLoginName());
        if (null == data) {
            data = oaFgldSetService.findUnique(hql + " and isLeaf=0", sysUser.getLoginName());
        }
        if (data != null) {
            Set<OaFgldSet> childsets = data.getChildsets();
            if (childsets.size() > 0) {
                for (OaFgldSet childset : childsets) {
                    personNames += "," + childset.getUser().getLoginName();
                }
                personNames = personNames.substring(1);
            } else {
                Set<OaFgldSetItem> oaFgldSetItems = data.getOaFgldSetItems();
                if (oaFgldSetItems.size() > 0) {
                    for (OaFgldSetItem oaFgldSetItem : oaFgldSetItems) {
                        List<SysUser> deptUsers = sysUserManager.getDeptUsers(oaFgldSetItem.getDept());
                        for (SysUser deptUser : deptUsers) {
                            personNames += "," + deptUser.getLoginName();
                        }
                    }
                    personNames = personNames.substring(1);
                }
            }
        }
        return personNames;
    }

    /**
     * 创建系统任务
     *
     * @param data .
     * @throws Exception .
     */
    public void createOaTask(OaMeetingOuter data) throws Exception {
        int status = data.getStatus();
        //创建任务
        Set<Long> managers = new HashSet<Long>();
        SysUser currentUser = sysUserManager.getSysUser();
        SysPerson person = currentUser.getPerson();
        if (status == OaMeetingStatus.STATUS_SUBMIT.getCode()) {
            if (null != person) {
                SysDept dept = person.getDept();
                List<OaFgldSetItem> setItems = oaFgldSetItemService.findByProperty("dept.id", dept.getId());
                for (OaFgldSetItem item : setItems) {
                    SysUser user = item.getFgldSet().getUser();
                    if (null != user)
                        managers.add(user.getId());
                }
            }
            String taskTitle = oaTaskManager.getTaskTitle(data, OaMeetingOuter.class.getSimpleName() + "_BRANCH_PASS");
            if (managers.size() > 0) {
                oaTaskManager.createTask(OaMeetingOuter.class.getSimpleName() + "_BRANCH_PASS", data.getId(), taskTitle, managers, false, null, null);
            }
        } else if (status == OaMeetingStatus.STATUS_BRANCH_PASS.getCode()) {
            if (null != person) {
                List<OaFgldSet> setItems = oaFgldSetService.findByQuery("from OaFgldSet where parent is null");
                for (OaFgldSet setItem : setItems) {
                    managers.add(setItem.getUser().getId());
                }
            }
            String taskTitle = oaTaskManager.getTaskTitle(data, OaMeetingOuter.class.getSimpleName() + "_MAIN_PASS");
            if (managers.size() > 0) {
                oaTaskManager.createTask(OaMeetingOuter.class.getSimpleName() + "_MAIN_PASS", data.getId(), taskTitle, managers, false, null, null);
            }
        } else if (status == OaMeetingStatus.STATUS_BRANCH_BACK.getCode() || status == OaMeetingStatus.STATUS_MAIN_BACK.getCode()) {
            String createUser = data.getCreateUser();
            SysUser sysUser = sysUserManager.getSysUser(createUser);
            managers.add(sysUser.getId());
            String taskTitle = oaTaskManager.getTaskTitle(data, OaMeetingOuter.class.getSimpleName() + "_BACK");
            if (managers.size() > 0) {
                oaTaskManager.createTask(OaMeetingOuter.class.getSimpleName() + "_BACK", data.getId(), taskTitle, managers, false, null, null);
            }
        }
    }
}