package com.justonetech.biz.controller.jd;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.JdInformService;
import com.justonetech.biz.daoservice.ShareProTobuildService;
import com.justonetech.biz.domain.JdInform;
import com.justonetech.biz.manager.MsgMessageManager;
import com.justonetech.biz.manager.OaFgldManager;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.utils.enums.JdInformStatus;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
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
import java.util.Set;


/**
 * note:质量监督告知书
 * author: 黄国荣
 * create date:
 * modify date:2014-05-21
 */
@Controller
public class JdInformController extends BaseCRUDActionController<JdInform> {
    private Logger logger = LoggerFactory.getLogger(JdInformController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private JdInformService jdInformService;

    @Autowired
    private ShareProTobuildService shareProTobuildService;

    @Autowired
    private OaFgldManager oaFgldManager;

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
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.JD_INFORM_EDIT));
        model.addAttribute("canAudit", sysUserManager.hasPrivilege(PrivilegeCode.JD_INFORM_AUDIT_KZ));
        model.addAttribute("canFgAudit", sysUserManager.hasPrivilege(PrivilegeCode.JD_INFORM_AUDIT_FG));

        setJdInformStatus(model);

        return "view/jd/jdInform/grid";
    }

    /**
     * 编辑审核权限状态
     *
     * @param model .
     */
    private void setJdInformStatus(Model model) {

        // 正在填写
        model.addAttribute("STATUS_EDIT", JdInformStatus.STATUS_EDIT.getCode());
        // 科长审核
        model.addAttribute("STATUS_SUBMIT", JdInformStatus.STATUS_SUBMIT.getCode());
        // 科长退回
        model.addAttribute("STATUS_BACK", JdInformStatus.STATUS_BACK.getCode());
        // 分管领导退回
        model.addAttribute("STATUS_BACK_LEADER", JdInformStatus.STATUS_BACK_LEADER.getCode());
        // 分管领导审核
        model.addAttribute("STATUS_SUBMIT_LEADER", JdInformStatus.STATUS_SUBMIT_LEADER.getCode());
        // 审核通过
        model.addAttribute("STATUS_PASS", JdInformStatus.STATUS_PASS.getCode());
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
            String sql = " select t.id,t.bjbh,p.project_name,p.build_unit_name,p.build_address,t.sgxk_date,t.status,'' as statusName" +
                    " from Jd_Inform t " +
                    " left join Share_Pro_ToBuild p on p.bjbh=t.bjbh" +
                    " where 1=1";
            sql += "order by t.id desc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(sql, filters);
            String querySql = queryTranslate.toString();
            Page pageModel = new Page(page, rows, true);
            pageModel = shareProTobuildService.findBySql(pageModel, querySql, null);
            List list = pageModel.getRows();
            for (Object o : list) {
                Object[] objects = (Object[]) o;
                objects[7] = JdInformStatus.getColorNameByCode(JspHelper.getInteger(objects[6]));
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
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        JdInform jdInform = new JdInform();
        jdInform.setStatus(JdInformStatus.STATUS_EDIT.getCode());
        model.addAttribute("bean", jdInform);

        setJdInformStatus(model);

        return "view/jd/jdInform/input";
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
        JdInform jdInform = jdInformService.get(id);
        model.addAttribute("bean", jdInform);
        model.addAttribute("canGain", false);

        setJdInformStatus(model);

        return "view/jd/jdInform/input";
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
        JdInform jdInform = jdInformService.get(id);
        model.addAttribute("bean", jdInform);

        setJdInformStatus(model);

        return "view/jd/jdInform/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") JdInform entity) throws Exception {
        try {
            JdInform target;
            if (entity.getId() != null) {
                target = jdInformService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "bjbh",
                        "lxr",
                        "tel",
                        "zipCode",
                        "address",
                        "fax",
                        "description",
                        "status",
                        "sgxkDate"

                });

            } else {
                target = entity;
            }

            //重新提交时清空审核意见
            if (JdInformStatus.STATUS_SUBMIT.getCode() == entity.getStatus()) {
                target.setAuditOpinion(null);
                target.setAuditUser(null);
                target.setAuditTime(null);

                target.setFgOpinion(null);
                target.setFgAuditUser(null);
                target.setFgAuditTime(null);
            }

            jdInformService.save(target);

            if (target.getStatus() != JdInformStatus.STATUS_EDIT.getCode()) {//创建待办事项
                createJdTask(target, target.getStatus());
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
    public void createJdTask(JdInform data, int Status) throws Exception {
        //创建任务
        String title = oaTaskManager.getTaskTitle(data, JdInform.class.getSimpleName());
        //获取科长用户
        String privilegeCode = PrivilegeCode.JD_INFORM_AUDIT_KZ;
        Set<Long> managers = sysUserManager.getUserIdsByPrivilegeCode(privilegeCode);
        //获取分管领导
        SysUser fgAuditUser = oaFgldManager.getAuditUserId(null, data.getFgAuditUser());
        if (Status == JdInformStatus.STATUS_SUBMIT.getCode() || Status == JdInformStatus.STATUS_SUBMIT_LEADER.getCode()) {
            if (Status == JdInformStatus.STATUS_SUBMIT_LEADER.getCode() && null != fgAuditUser) {
                managers.clear();
                privilegeCode = PrivilegeCode.JD_INFORM_AUDIT_FG;
                managers = sysUserManager.getUserIdsByPrivilegeCode(privilegeCode);
            }
            if (managers.size() > 0 && null != title) {
                oaTaskManager.createTask(JdInform.class.getSimpleName(), data.getId(), title, managers, false, null, null);
            }
        }
        if (Status == JdInformStatus.STATUS_PASS.getCode() || Status == JdInformStatus.STATUS_BACK.getCode() || Status == JdInformStatus.STATUS_BACK_LEADER.getCode()) {
            SysUser sysUser = sysUserManager.getSysUser();
            SysUser receiveUser = sysUserManager.getSysUser(data.getCreateUser());
            String msgTemp = oaTaskManager.getTaskTitle(data, JdInform.class.getSimpleName() +"_Back" );
            if (Status == JdInformStatus.STATUS_PASS.getCode()) {
                msgTemp = oaTaskManager.getTaskTitle(data, JdInform.class.getSimpleName() +"_Pass" );
            }
            String[] ids = new String[1];
            if (null != receiveUser && null != msgTemp) {
                ids[0] = String.valueOf(receiveUser.getId());
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
        JdInform jdInform = jdInformService.get(id);
        model.addAttribute("canGain", false);
        model.addAttribute("bean", jdInform);

        setJdInformStatus(model);

        return "view/jd/jdInform/audit";
    }


    /**
     * 审核保存操作
     *
     * @param response .
     * @param entity   .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void auditSave(HttpServletResponse response, @ModelAttribute("bean") JdInform entity) throws Exception {
        try {
            JdInform target = jdInformService.get(entity.getId());

            //保存当前审核人
            target.setStatus(entity.getStatus());
            Integer status = target.getStatus();
            String loginName = SpringSecurityUtils.getCurrentUser().getLoginName();
            if (status == JdInformStatus.STATUS_SUBMIT_LEADER.getCode() || status == JdInformStatus.STATUS_BACK.getCode()) {
                target.setAuditOpinion(entity.getAuditOpinion());
                target.setAuditUser(loginName);
                target.setAuditTime(new Timestamp(System.currentTimeMillis()));
            }
            if (status == JdInformStatus.STATUS_PASS.getCode() || status == JdInformStatus.STATUS_BACK_LEADER.getCode()) {
                target.setFgOpinion(entity.getFgOpinion());
                target.setFgAuditUser(loginName);
                target.setFgAuditTime(new Timestamp(System.currentTimeMillis()));
            }

            jdInformService.save(target);
            createJdTask(target, target.getStatus());
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
        jdInformService.delete(id);
        oaTaskManager.removeTask(JdInform.class.getSimpleName(), id);//删除任务

        sendSuccessJSON(response, "删除成功");
    }
}