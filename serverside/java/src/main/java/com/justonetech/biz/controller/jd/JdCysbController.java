package com.justonetech.biz.controller.jd;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.JdCysbService;
import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.domain.JdCysb;
import com.justonetech.biz.domain.ShareProTobuild;
import com.justonetech.biz.manager.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.JdCysbStatus;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysRegPerson;
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

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * note:创优申报
 * author:huangguorong
 * create date:
 * modify date:2014-05-20
 */
@Controller
public class JdCysbController extends BaseCRUDActionController<JdCysb> {
    private Logger logger = LoggerFactory.getLogger(JdCysbController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private JdCysbService jdCysbService;

    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private MsgMessageManager msgMessageManager;

    @Autowired
    private RegPersonManager regPersonManager;


    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {

        //判断是否有编辑权限
        SysUser sysUser = sysUserManager.getSysUser();
        model.addAttribute("isCJDW", sysUser.getRegPerson() != null);  //是否参建单位

        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.JD_CYSB_EDIT));    //内网用户允许编辑，但不允许添加
        model.addAttribute("canAudit", sysUserManager.hasPrivilege(PrivilegeCode.JD_CYSB_AUDIT));  //内网用户允许审核

        setJdCysbStatus(model, null);

        return "view/jd/jdCysb/grid";
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
            String hql = "from JdCysb where 1=1";

            //外网参建单位只允许查看自己项目的数据
            SysRegPerson regPerson = sysUserManager.getSysUser().getRegPerson();
            if (regPerson != null) {
                String bjbh = regPersonManager.getJdBjbhCondition();
                hql += " and bjbh in (" + bjbh + ")";
            }
            hql += " order by id desc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = jdCysbService.findByPage(pageModel, queryTranslate.toString());

            List<Map> mapList = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : mapList) {
                JdCysb jdCysb = jdCysbService.get(JspHelper.getLong(bean.get("id")));
                ShareProTobuild project = projectManager.getProject(jdCysb.getBjbh());
                bean.put("projectName", project != null ? project.getProjectName() : "");

                //附件显示
                bean.put("docButton", documentManager.getDownloadButton(jdCysb.getDocument()));
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
    private void setJdCysbStatus(Model model, String bjbh) {
        model.addAttribute("STATUS_EDIT", JdCysbStatus.STATUS_EDIT.getCode()); //填写
        model.addAttribute("STATUS_SUBMIT", JdCysbStatus.STATUS_SUBMIT.getCode()); //提交
        model.addAttribute("STATUS_BACK", JdCysbStatus.STATUS_BACK.getCode()); //退回修改
        model.addAttribute("STATUS_PASS", JdCysbStatus.STATUS_PASS.getCode()); //审核通过

        ShareProTobuild project = projectManager.getProject(bjbh);
        if (project != null) {
            model.addAttribute("projectName", project.getProjectName());
        }
    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @param bjbh  .
     * @return .
     */
    @RequestMapping
    public String add(Model model, String bjbh) {
        SysUser sysUser = sysUserManager.getSysUser();

        JdCysb jdCysb = new JdCysb();
        jdCysb.setStatus(JdCysbStatus.STATUS_EDIT.getCode());

        //获取报建编号
        SysRegPerson regPerson = sysUser.getRegPerson();
        if (regPerson != null) {
            jdCysb.setBjbh(bjbh);
//            jdCysb.setBjbh(regPerson.getBjbh());
        }
        model.addAttribute("bean", jdCysb);

        //附件按钮
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), JdCysb.class.getSimpleName(), null, sysUser.getId(), null));
        model.addAttribute("reportType", Constants.JD_CYSB_TYPE);

        setJdCysbStatus(model, bjbh);
//        setJdCysbStatus(model, jdCysb.getBjbh());

        return "view/jd/jdCysb/input";
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
        JdCysb jdCysb = jdCysbService.get(id);
        model.addAttribute("bean", jdCysb);

        //修改附件
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), JdCysb.class.getSimpleName(), jdCysb.getDocument(), sysUserManager.getSysUser().getId(), null));
        model.addAttribute("reportType", Constants.JD_CYSB_TYPE);

        setJdCysbStatus(model, jdCysb.getBjbh());

        return "view/jd/jdCysb/input";
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
        JdCysb jdCysb = jdCysbService.get(id);
        model.addAttribute("bean", jdCysb);

        //显示附件
        model.addAttribute("uploadButton", documentManager.getDownloadButton(jdCysb.getDocument()));

        setJdCysbStatus(model, jdCysb.getBjbh());

        return "view/jd/jdCysb/view";
    }

    /**
     * 创建系统任务
     *
     * @param data .
     * @throws Exception .
     */
    public void createOaTask(JdCysb data) throws Exception {
        //创建任务
        int Status = data.getStatus();
        if (Status == JdCysbStatus.STATUS_SUBMIT.getCode()) {

            String privilegeCode = PrivilegeCode.JD_CYSB_AUDIT;
            String title = oaTaskManager.getTaskTitle(data, JdCysb.class.getSimpleName());
            Set<Long> managers = sysUserManager.getUserIdsByPrivilegeCode(privilegeCode);
            if (managers.size() > 0&&null!=title) {
                oaTaskManager.createTask(JdCysb.class.getSimpleName(), data.getId(), title, managers, false, null, null);
            }
        }
        if (Status == JdCysbStatus.STATUS_PASS.getCode() || Status == JdCysbStatus.STATUS_BACK.getCode()) {
            SysUser sysUser = sysUserManager.getSysUser();
            SysUser receiveUser = sysUserManager.getSysUser(data.getCreateUser());

            String msgTemp = oaTaskManager.getTaskTitle(data, JdCysb.class.getSimpleName() + "_Pass");
            if (Status == JdCysbStatus.STATUS_BACK.getCode()) {
                msgTemp = oaTaskManager.getTaskTitle(data, JdCysb.class.getSimpleName() + "_Back");
            }
            String[] ids = new String[1];
            if (null != receiveUser&&null!=msgTemp) {
                ids[0] = String.valueOf(receiveUser.getId());
                msgMessageManager.sendSmsByUser(msgTemp, sysUser, ids);
            }
        }

    }


    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param docId    .
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") JdCysb entity, String docId) throws Exception {
        try {
            JdCysb target;
            if (entity.getId() != null) {
                target = jdCysbService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "bjbh",
                        "projectAddress",
                        "buildArea",
                        "structureType",
                        "structureLevel",
                        "reportType",
                        "status"

                });

            } else {
                target = entity;
            }

            if (target.getReportType() != null) {
                target.setReportTypeDesc(target.getReportType().getName());
            }

            //保存附件
            if (StringHelper.isNotEmpty(docId)) {
                DocDocument docDocument = docDocumentService.get(Long.valueOf(docId));
                target.setDocument(docDocument);
            }

            jdCysbService.save(target);

            if (target.getStatus() != JdCysbStatus.STATUS_EDIT.getCode()) {//创建待办事项
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
     * 审核页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String audit(Model model, Long id) {
        JdCysb jdCysb = jdCysbService.get(id);
        model.addAttribute("bean", jdCysb);

        //修改附件
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), JdCysb.class.getSimpleName(), jdCysb.getDocument(), sysUserManager.getSysUser().getId(), null));

        setJdCysbStatus(model, jdCysb.getBjbh());

        return "view/jd/jdCysb/audit";
    }

    /**
     * 审核保存
     *
     * @param response .
     * @param entity   .
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void auditSave(HttpServletResponse response, @ModelAttribute("bean") JdCysb entity) throws Exception {
        try {
            JdCysb target;
            if (entity.getId() != null) {
                target = jdCysbService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "auditOpinion",
                        "status"
                });

            } else {
                target = entity;
            }

            //保存当前审核人
            if (target.getStatus() == JdCysbStatus.STATUS_PASS.getCode()) {
                String loginName = SpringSecurityUtils.getCurrentUser().getLoginName();
                target.setAuditUser(loginName);
                target.setAuditTime(new Timestamp(System.currentTimeMillis()));
            }
            jdCysbService.save(target);
            createOaTask(target);

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

        JdCysb jdCysb = jdCysbService.get(id);
        Long docId = jdCysb.getDocument() != null ? jdCysb.getDocument().getId() : null;
        oaTaskManager.removeTask(JdCysb.class.getSimpleName(), id);//删除任务

        jdCysbService.delete(id);

        //删除文档
        documentManager.removeAllDoc(docId, null);

        sendSuccessJSON(response, "删除成功");
    }

}