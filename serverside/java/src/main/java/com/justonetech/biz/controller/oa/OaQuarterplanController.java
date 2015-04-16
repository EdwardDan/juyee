package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaQuarterplanService;
import com.justonetech.biz.domain.OaQuarterplan;
import com.justonetech.biz.manager.OaFgldManager;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.manager.MsgMessageManager;
import com.justonetech.biz.utils.DateUtil;
import com.justonetech.biz.utils.enums.OaQuarterplanStatus;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.DateTimeHelper;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;


/**
 * note:季度年度总结计划
 * author: chenyu
 * create date:
 * modify date:
 */
@Controller
public class OaQuarterplanController extends BaseCRUDActionController<OaQuarterplan> {
    private Logger logger = LoggerFactory.getLogger(OaQuarterplanController.class);

    @Autowired
    private SysUserManager sysUserManager;
    @Autowired
    private OaQuarterplanService oaQuarterplanService;

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
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_QUARTERPLAN_EDIT)); //编辑权限
        model.addAttribute("canAudit", sysUserManager.hasPrivilege(PrivilegeCode.OA_QUARTERPLAN_AUDIT)); //审核权限
        pushStaticValueToPage(model);
        return "view/oa/oaQuarterplan/grid";
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
            String hql = "from OaQuarterplan order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = oaQuarterplanService.findByPage(pageModel, queryTranslate.toString());

            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : list) {
                Object id = bean.get("id");
                if (null != id) {
                    OaQuarterplan oaQuarterplan = oaQuarterplanService.get(JspHelper.getLong(id));
                    if (null != oaQuarterplan.getStatus()) {
                        bean.put("statusName", OaQuarterplanStatus.getColorNameByCode(oaQuarterplan.getStatus()));
                    }
                    bean.put("reportTime", oaQuarterplan.getReportTime());
                    bean.put("reportType", oaQuarterplan.getReportType());
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
     * 各种状态的编码
     *
     * @param model .
     */
    private void pushStaticValueToPage(Model model) {

        model.addAttribute("STATUS_EDIT", OaQuarterplanStatus.STATUS_EDIT.getCode()); //填写
        model.addAttribute("STATUS_SUBMIT", OaQuarterplanStatus.STATUS_SUBMIT.getCode()); //提交
        model.addAttribute("STATUS_BACK", OaQuarterplanStatus.STATUS_BACK.getCode()); //退回修改
        model.addAttribute("STATUS_PASS", OaQuarterplanStatus.STATUS_PASS.getCode()); //审核通过

    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        OaQuarterplan oaQuarterplan = new OaQuarterplan();
        String reportPerson = sysUserManager.getSysUser().getDisplayName();//当前登录用户名
        String reportDept = sysUserManager.getSysUser().getPerson().getDept().getName();//当前登录用户的部门名称

        oaQuarterplan.setReportPerson(reportPerson);//默认责任人
        oaQuarterplan.setReportDept(reportDept); //默认提交部门
        oaQuarterplan.setReportDate(new Date(System.currentTimeMillis()));//默认提交时间
        oaQuarterplan.setStatus(OaQuarterplanStatus.STATUS_EDIT.getCode());//设置当前状态

        Calendar cal = Calendar.getInstance();  //获取当前时间
        String yearSelectOptions = DateTimeHelper.getYearSelectOptions(JspHelper.getString(cal.get(Calendar.YEAR)));
//        String quarterSelectOptions = DateTimeHelper.getQuarterSelectOptions(JspHelper.getString(0));
        String quarterSelectOptions = DateUtil.getQuarterMultiSelectOptions(JspHelper.getString(0));
        model.addAttribute("yearSelectOptions", yearSelectOptions);
        model.addAttribute("quarterSelectOptions", quarterSelectOptions);
        //如需增加其他默认值请在此添加
        model.addAttribute("bean", oaQuarterplan);
        pushStaticValueToPage(model);
        return "view/oa/oaQuarterplan/input";
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
        OaQuarterplan oaQuarterplan = oaQuarterplanService.get(id);

        String yearSelectOptions = DateTimeHelper.getYearSelectOptions(JspHelper.getString(oaQuarterplan.getYear()));
        model.addAttribute("yearSelectOptions", yearSelectOptions);

//        String quarterSelectOptions = DateTimeHelper.getQuarterSelectOptions(JspHelper.getString(oaQuarterplan.getPeriod()));
        String quarterSelectOptions = DateUtil.getQuarterMultiSelectOptions(JspHelper.getString(oaQuarterplan.getPeriod()));
        model.addAttribute("quarterSelectOptions", quarterSelectOptions);
        //处理其他业务逻辑
        model.addAttribute("bean", oaQuarterplan);
        pushStaticValueToPage(model);
        return "view/oa/oaQuarterplan/input";
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
        OaQuarterplan oaQuarterplan = oaQuarterplanService.get(id);


        String yearSelectOptions = DateTimeHelper.getYearSelectOptions(JspHelper.getString(oaQuarterplan.getYear()));
        model.addAttribute("yearSelectOptions", yearSelectOptions);

//        String quarterSelectOptions = DateTimeHelper.getQuarterSelectOptions(JspHelper.getString(oaQuarterplan.getPeriod()));
        String quarterSelectOptions = DateUtil.getQuarterMultiSelectOptions(JspHelper.getString(oaQuarterplan.getPeriod()));
        model.addAttribute("quarterSelectOptions", quarterSelectOptions);

        String fgAuditUser = sysUserManager.getSysUser().getDisplayName();//当前登录用户名
        oaQuarterplan.setFgAuditUser(fgAuditUser);//默认保存审核领导姓名
        oaQuarterplan.setFgAuditTime(new Timestamp(System.currentTimeMillis())); //默认保存审核时间
        //处理其他业务逻辑
        model.addAttribute("bean", oaQuarterplan);
        pushStaticValueToPage(model);
        return "view/oa/oaQuarterplan/audit";
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
        OaQuarterplan oaQuarterplan = oaQuarterplanService.get(id);
        pushStaticValueToPage(model);
        model.addAttribute("reportType", oaQuarterplan.getReportTime());
        model.addAttribute("bean", oaQuarterplan);
        return "view/oa/oaQuarterplan/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaQuarterplan entity, HttpServletRequest request, Integer status) throws Exception {
        try {
            OaQuarterplan target;
            if (entity.getId() != null) {
                target = oaQuarterplanService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "reportDept",
                        "reportPerson",
                        "year",
                        "period",
                        "reportDate",
                        "content",
                        "status",
                        "fgOpinion",
                        "fgAuditTime",
                        "fgAuditUser"
                });

            } else {
                target = entity;
            }
            if (target.getStatus() == OaQuarterplanStatus.STATUS_PASS.getCode()) {
                target.setIsSumDelete(false);
            }
            if (target.getStatus() == OaQuarterplanStatus.STATUS_EDIT.getCode() || target.getStatus() == OaQuarterplanStatus.STATUS_SUBMIT.getCode()) {
                target.setReportDate(new Date(System.currentTimeMillis()));//保存提交时间
            }
            if (target.getStatus() == OaQuarterplanStatus.STATUS_BACK.getCode() || target.getStatus() == OaQuarterplanStatus.STATUS_PASS.getCode()) {
                target.setFgAuditTime(new Timestamp(System.currentTimeMillis())); //保存审核时间
                target.setFgAuditUser(sysUserManager.getSysUser().getDisplayName()); //保存审核人姓名
            }
            target.setStatus(status);
            oaQuarterplanService.save(target);

            if (target.getStatus() != OaQuarterplanStatus.STATUS_EDIT.getCode()) {//创建待办事项
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
    public void createOaTask(OaQuarterplan data) throws Exception {
        //创建任务
        int Status = data.getStatus();
        Set<Long> managers = new HashSet<Long>();
        String  fgAuditUserName = oaFgldManager.getAuditUserName(data.getReportDept(), data.getFgAuditUser());
        SysUser fgAuditUser= null;
        if (null!=fgAuditUserName) {
            fgAuditUser = sysUserManager.getSysUser(fgAuditUserName);
        }
        if (Status == OaQuarterplanStatus.STATUS_SUBMIT.getCode()&&null!=fgAuditUser) {
            String title = oaTaskManager.getTaskTitle(data, OaQuarterplan.class.getSimpleName());
            managers.add(fgAuditUser.getId());
            if (managers.size() > 0&&null!=title) {
                oaTaskManager.createTask(OaQuarterplan.class.getSimpleName(), data.getId(), title, managers, false, null, null);
            }
        }
        if (Status == OaQuarterplanStatus.STATUS_PASS.getCode() || Status == OaQuarterplanStatus.STATUS_BACK.getCode()) {
            SysUser sysUser = sysUserManager.getSysUser();
            SysUser receiveUser = sysUserManager.getSysUserByDisplayName(data.getReportPerson());
            String msgTemp = oaTaskManager.getTaskTitle(data, OaQuarterplan.class.getSimpleName() + "_Pass");
            if (Status == OaQuarterplanStatus.STATUS_BACK.getCode()) {
                msgTemp = oaTaskManager.getTaskTitle(data, OaQuarterplan.class.getSimpleName() + "_Back");
            }
            String[] ids = new String[1];
            if (null != receiveUser) {
                ids[0] = String.valueOf(receiveUser.getId());
                msgMessageManager.sendSmsByUser(msgTemp, sysUser, ids);
            }
        }

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
        oaTaskManager.removeTask(OaQuarterplan.class.getSimpleName(), id);//删除任务
        oaQuarterplanService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}