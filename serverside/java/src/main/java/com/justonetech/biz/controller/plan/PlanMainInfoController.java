package com.justonetech.biz.controller.plan;

import com.justonetech.biz.daoservice.PlanDetailUserService;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.PlanDetailService;
import com.justonetech.biz.daoservice.PlanMainInfoService;
import com.justonetech.biz.daoservice.PollingWorkGroupService;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.daoservice.SysPersonService;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.hibernate.util.StringHelper;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * note:监督计划
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class PlanMainInfoController extends BaseCRUDActionController<PlanMainInfo> {
    private Logger logger = LoggerFactory.getLogger(PlanMainInfoController.class);
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserManager sysUserManager;
    @Autowired
    private PlanDetailUserService planDetailUserService;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private PollingWorkGroupService pollingWorkGroupService;

    @Autowired
    private PlanDetailService planDetailService;

    @Autowired
    private PlanMainInfoService planMainInfoService;

    @Autowired
    private PlanMainInfoManager planMainInfoManager;

    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private ExcelJdTasksManager excelJdTasksManager;


    /**
     * 列表显示页面
     *
     * @param model .
     * @param flag  .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, String flag) {
        //判断是否有编辑权限
        String editPrivilegeCode = planMainInfoManager.getPrivilegeCode(flag, false);
        String auditPrivilegeCode = planMainInfoManager.getPrivilegeCode(flag, true);
        Boolean isPermitEdit = sysUserManager.hasPrivilege(editPrivilegeCode);
        Boolean isPermitAudit = sysUserManager.hasPrivilege(auditPrivilegeCode);
        model.addAttribute("isPermitEdit", isPermitEdit);
        model.addAttribute("isPermitAudit", isPermitAudit);
        model.addAttribute("isPermitExcute", sysUserManager.hasPrivilege(PrivilegeCode.POLLING_FORM_EDIT));
//        model.addAttribute("isPermitExcute", sysUserManager.hasPrivilege(pollingRecordManager.getPrivilegePrefix(flag) + PrivilegeCode.POLLING_FORM_EDIT));

        //状态编码
        model.addAttribute("status_edit_code", Constants.PLAN_MAIN_INFO_STATUS_EDIT);
        model.addAttribute("status_submit_code", Constants.PLAN_MAIN_INFO_STATUS_SUBMIT);
        model.addAttribute("status_back_code", Constants.PLAN_MAIN_INFO_STATUS_BACK);
        model.addAttribute("status_pass_code", Constants.PLAN_MAIN_INFO_STATUS_EXCUTE);

        model.addAttribute("flag", flag);
        if (Constants.PLAN_MAIN_INFO_TYPE_SAFE.equals(flag)) {
            model.addAttribute("flagName", "安全");
        } else if (Constants.PLAN_MAIN_INFO_TYPE_QUALITY.equals(flag)) {
            model.addAttribute("flagName", "质量");
        } else if (Constants.PLAN_MAIN_INFO_TYPE_SPECIAL.equals(flag)) {
            model.addAttribute("flagName", "专项");
        } else if (Constants.PLAN_MAIN_INFO_TYPE_ORDER.equals(flag)) {
            model.addAttribute("flagName", "预约");
        } else if (Constants.PLAN_MAIN_INFO_TYPE_CHECK.equals(flag)) {
            model.addAttribute("flagName", "稽查");
        }

        return "view/plan/planMainInfo/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     * @param planType .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, String planType, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from PlanMainInfo where planType.code='{0}' order by planCode desc";
            hql = FormatUtils.format(hql, planType);

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = planMainInfoService.findByPage(pageModel, query);
            session.setAttribute(Constants.GRID_SQL_KEY, query);

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 新增录入页面
     *
     * @param model    .
     * @param planType .
     * @return .
     */
    @RequestMapping
    public String add(Model model, String planType) {
        PlanMainInfo planMainInfo = new PlanMainInfo();

        //如需增加其他默认值请在此添加
        planMainInfo.setPlanType(sysCodeManager.getCodeDetailByCode(Constants.PLAN_MAIN_INFO_TYPE, planType));
        planMainInfo.setPlanStatus(sysCodeManager.getCodeDetailByCode(Constants.PLAN_MAIN_INFO_STATUS, Constants.PLAN_MAIN_INFO_STATUS_EDIT));

        //权限控制
        planMainInfoManager.getStatusAttribute(model, planMainInfo);

        //默认编号自动生成（年份+序号）
        planMainInfo.setPlanCode(planMainInfoManager.getPlanCode(planType));

        model.addAttribute("bean", planMainInfo);

        return "view/plan/planMainInfo/input";
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
        PlanMainInfo planMainInfo = planMainInfoService.get(id);

        //处理其他业务逻辑
        if (planMainInfo.getPlanStatus() == null) {
            planMainInfo.setPlanStatus(sysCodeManager.getCodeDetailByCode(Constants.PLAN_MAIN_INFO_STATUS, Constants.PLAN_MAIN_INFO_STATUS_EDIT));
        }

        //权限控制
        planMainInfoManager.getStatusAttribute(model, planMainInfo);
        model.addAttribute("bean", planMainInfo);

        return "view/plan/planMainInfo/input";
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
        PlanMainInfo planMainInfo = planMainInfoService.get(id);

        model.addAttribute("bean", planMainInfo);

        model.addAttribute("isEdit", false);

        return "view/plan/planMainInfo/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") PlanMainInfo entity, HttpServletRequest request) throws Exception {
        try {
            PlanMainInfo target;
            if (entity.getId() != null) {
                target = planMainInfoService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "planCode",
                        "planName",
                        "planDesc",
                        "planStatus",
                        "checkUser",
                        "checkUserName",
                        "checkDateTime",
                        "checkOpinion",
                        "checkMemo"
                });

            } else {
                target = entity;

                SysUser sysUser = sysUserManager.getSysUser();
                if (sysUser != null) {
                    target.setcUser(sysUser);
                    target.setCreateUserName(sysUser.getDisplayName());
                }
            }
            planMainInfoService.save(target);
            //先删除
            Set<PlanDetail> details = target.getPlanDetails();
            for (PlanDetail detail : details) {
                Set<PlanDetailUser> planDetailUsers = detail.getPlanDetailUsers();
                if (null != planDetailUsers) {
                    for (PlanDetailUser p : planDetailUsers) {
                        planDetailUserService.delete(p);
                    }
                }
                planDetailService.delete(detail);
            }

            //再增加
            String[] jdTaskCodes = request.getParameterValues("jdTaskCode");
            if (jdTaskCodes != null) {
                SysCodeDetail detailStatus = sysCodeManager.getCodeDetailByCode(Constants.PLAN_DETAIL_STATUS, Constants.PLAN_DETAIL_STATUS_NOCHECK);
                for (String jdTaskCode : jdTaskCodes) {
                    ExcelJdTasks excelJdTasks = excelJdTasksManager.findExcelJdTasks(jdTaskCode);
                    if (excelJdTasks != null) {
                        String bjbh = excelJdTasks.getBjbh();
                        //建设单位
                        String jsDeptName = "";
                        ShareProTobuild project = projectManager.getProject(bjbh);
                        if (project != null) {
                            jsDeptName = project.getBuildUnitName();
                        } else {
//                            ExcelJdTasks excelJdTasks = excelJdTasksManager.getExcelJdTasks(flowCode);
                            if (excelJdTasks != null) {
                                jsDeptName = excelJdTasks.getJsUnitName();
                            }
                        }

                        //todo proFlowCode中没有存储工地编号，所以如果项目存在多个工地那么只能取第1个工地
                        ShareGdInfo gdInfo = projectManager.getGDInfo(bjbh, null);

                        String jdManagerIds = request.getParameter("jdManager_" + jdTaskCode);
                        String planEndTime = request.getParameter("completeDate_" + jdTaskCode);
                        String v_selectCause = request.getParameter("v_selectCause_" + jdTaskCode);
                        String v_causeOther = request.getParameter("v_causeOther_" + jdTaskCode);

                        if (!StringHelper.isEmpty(planEndTime)) {
                            PlanDetail detail = new PlanDetail();
                            detail.setBjbh(bjbh);
                            detail.setJdTaskCode(jdTaskCode);
//                            detail.setBdh(proFlowCode.getBdh());
                            detail.setBuildUnitName(jsDeptName);
                            detail.setPlan(target);

//                            detail.setGroup(sysPersonService.get(Long.valueOf(groupId)));
                            if (!StringHelper.isEmpty(planEndTime)) {
                                detail.setPlanEndTime(Timestamp.valueOf(planEndTime + " 00:00:000"));
                            }
                            detail.setSelectCause(v_selectCause);
                            detail.setSelectCauseOther(v_causeOther);
                            if (gdInfo != null) {
                                detail.setSgUnitName(gdInfo.getSgTotalUnitName());
                                detail.setGdName(gdInfo.getGdName());
                            }
                            detail.setStatus(detailStatus);
                            planDetailService.save(detail);

                            if (!StringHelper.isEmpty(jdManagerIds)) {
                                String jdManager[] = jdManagerIds.split(",");
                                for (String id : jdManager) {
                                    PlanDetailUser planDetailUser = new PlanDetailUser();
                                    planDetailUser.setUser(sysUserService.get(Long.parseLong(id)));
                                    planDetailUser.setPlanDetail(detail);
                                    planDetailUserService.save(planDetailUser);
                                }
                            }
                        }
                    }
                }
            }
            if (target.getPlanStatus().getCode().equals(Constants.PLAN_MAIN_INFO_STATUS_EXCUTE)) {
                planMainInfoManager.createPlanTask(target);
            }
//            if (target.getPlanStatus().getCode().equals(Constants.PLAN_MAIN_INFO_STATUS_SUBMIT)) {
//               createSysTask(target);
//            }

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
    public void createSysTask(PlanMainInfo data) throws Exception {
        //创建任务

        String title = oaTaskManager.getTaskTitle(data, PlanMainInfo.class.getSimpleName()+"_Pass");
        if(data.getPlanStatus().getCode().equals(Constants.PLAN_MAIN_INFO_STATUS_BACK)){
            title = oaTaskManager.getTaskTitle(data, PlanMainInfo.class.getSimpleName()+"_Back");
        }
        //获取科长用户
        String privilegeCode = PrivilegeCode.PLAN_MAIN_INFO_SAFE_AUDIT;
        if(data.getPlanType().getName().equals("质量监督计划")) {
          privilegeCode = PrivilegeCode.PLAN_MAIN_INFO_QUALITY_AUDIT;
        }
        Set<Long> managers = sysUserManager.getUserIdsByPrivilegeCode(privilegeCode);
            if (managers.size() > 0) {
                oaTaskManager.createTask(JdInform.class.getSimpleName(), data.getId(), title, managers, false, null, null);
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
        PlanMainInfo planMainInfo = planMainInfoService.get(id);

        //先删除明细
        List<Long> detailIds = new ArrayList<Long>();
        Set<PlanDetail> details = planMainInfo.getPlanDetails();
        for (PlanDetail detail : details) {
            Set<PlanDetailUser> planDetailUsers = detail.getPlanDetailUsers();
            if (null != planDetailUsers) {
                for (PlanDetailUser p : planDetailUsers) {
                    planDetailUserService.delete(p);
                }
            }
            detailIds.add(detail.getId());
            planDetailService.delete(detail);
        }

        //再删除主表
        planMainInfoService.delete(id);

        //删除任务
        for (Long detailId : detailIds) {
            oaTaskManager.removeTask(PlanDetail.class.getSimpleName(), detailId);
        }

        sendSuccessJSON(response, "删除成功");
    }

}