package com.justonetech.biz.controller.plan;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OrderFormService;
import com.justonetech.biz.daoservice.PlanDetailService;
import com.justonetech.biz.daoservice.PlanMainInfoService;
import com.justonetech.biz.daoservice.PollingWorkGroupService;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * note:计划明细
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class PlanDetailController extends BaseCRUDActionController<PlanDetail> {
    private Logger logger = LoggerFactory.getLogger(PlanDetailController.class);
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysParameterManager sysParameterManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private PlanDetailService planDetailService;

    @Autowired
    private PlanMainInfoService planMainInfoService;

    @Autowired
    private PollingWorkGroupService pollingWorkGroupService;

    @Autowired
    private PlanMainInfoManager planMainInfoManager;

    @Autowired
    private PollingRecordManager pollingRecordManager;

    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private OrderFormService orderFormService;

    @Autowired
    private ExcelJdTasksManager excelJdTasksManager;

    public static final String all = "all";
    public static final String nothing = "nothing";
    public static final String danger = "danger";
    public static final String leaving = "leaving";

    /**
     * 列表显示页面
     *
     * @param model          .
     * @param planMainInfoId .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, Long planMainInfoId) {
        PlanMainInfo planMainInfo = planMainInfoService.get(planMainInfoId);
        String typeCode = planMainInfo.getPlanType().getCode();
        SysCodeDetail formClassData = pollingRecordManager.getFormClassData(typeCode);
        if (formClassData != null) {
            model.addAttribute("formClass", formClassData.getId());
        }
        model.addAttribute("bean", planMainInfo);
        model.addAttribute("flag", typeCode);
        //编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(pollingRecordManager.getPrivilegePrefix(typeCode) + PrivilegeCode.JD_RECORD_EDIT));

        //取消任务的权限
        String auditPrivilegeCode = planMainInfoManager.getPrivilegeCode(typeCode, true);
        Boolean isPermitAudit = sysUserManager.hasPrivilege(auditPrivilegeCode);
        model.addAttribute("isPermitAudit", isPermitAudit);

        return "view/plan/planDetail/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response       .
     * @param filters        .
     * @param columns        .
     * @param page           .
     * @param rows           .
     * @param planMainInfoId .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, Long planMainInfoId) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from PlanDetail where plan.id=" + planMainInfoId + " order by id desc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = planDetailService.findByPage(pageModel, queryTranslate.toString());

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 监督工程显示页面 -- ajax加载
     *
     * @param model  .
     * @param id     .
     * @param param  .
     * @param isEdit .
     * @return .
     */
    @RequestMapping
    public String getDetailList(Model model, Long id, String param, String jdTaskCode, String causex, String selectCauseOtherx, Boolean isEdit, Boolean isAudit,HttpServletRequest request) {
        String deleteDetailId = request.getParameter("deleteDetailId");
        if (StringHelper.isEmpty(deleteDetailId)) {
            deleteDetailId = "";
        }
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        //监督组
//        List<PollingWorkGroup> workGroupList = pollingWorkGroupService.findByQuery("from PollingWorkGroup order by name asc");

        Set<String> jdTaskCodeSet = new HashSet<String>();

        //已保存的记录 (排除页面删除的)
        if (id != null) {
            PlanMainInfo mainInfo = planMainInfoService.get(id);
            Set<PlanDetail> details = mainInfo.getPlanDetails();
            Map<String, Object> map;
            for (PlanDetail detail : details) {
                if (!deleteDetailId.contains("," + String.valueOf(detail.getId()) + ",")) {
                    ExcelJdTasks excelJdTasks = excelJdTasksManager.findExcelJdTasks(detail.getJdTaskCode());
                    map = new HashMap<String, Object>();

                    if (detail.getJdTaskCode().equals(jdTaskCode)) {
                        detail.setSelectCause(causex);
                        detail.setSelectCauseOther(selectCauseOtherx);
                    }
                    map.put("detail", detail);
                    setdate(detail.getJdTaskCode(), map);
                    if (excelJdTasks != null) {
                        map.put("flow", detail.getJdTaskCode());
                        map.put("task", excelJdTasks);
//                    map.put("groupList", workGroupList);
                        Set<PlanDetailUser> set = detail.getPlanDetailUsers();
                        String userIds = "";
                        String names = "";
                        if (null != set) {
                            for (PlanDetailUser p : set) {
                                userIds += p.getUser().getId() + ",";
                                names += sysUserService.get(p.getUser().getId()).getDisplayName() + ",";
                            }
                        }
                        map.put("jdManager", userIds.length() != 0 ? userIds.substring(0, userIds.length() - 1) : "");
                        map.put("jdManagerName", names.length() != 0 ? names.substring(0, names.length() - 1) : "");
//                    map.put("groupId", detail.getGroup().getId());
                        list.add(map);
                        jdTaskCodeSet.add(detail.getJdTaskCode());
                    }
                }
            }
        }

        //选择进来的监督工程
        String jdTaskCodes = StringHelper.getElementValue(param, "jdTaskCode");
        String date = StringHelper.getElementValue(param, "date");
        String cause = StringHelper.getElementValue(param, "cause");
        String causeOther = StringHelper.getElementValue(param, "causeOther");
        String jdManager = StringHelper.getElementValue(param, "jdManager");
        if (!StringHelper.isEmpty(jdTaskCodes)) {
            String[] codes = StringHelper.stringToStringArray(jdTaskCodes, ",");
            String[] dates = StringHelper.stringToStringArray(date, ",");
            String[] causes = StringHelper.stringToStringArray(cause, ",");
            String[] causeOthers = StringHelper.stringToStringArray(causeOther, ",");
            String[] jdManagers = StringHelper.stringToStringArray(jdManager, "!");
            for (int i = 0; i < codes.length; i++) {
                ExcelJdTasks excelJdTasks = excelJdTasksManager.findExcelJdTasks(codes[i].trim());
                Map<String, Object> map = new HashMap<String, Object>();
                PlanDetail detail = new PlanDetail();
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                format.setLenient(false);
                if (codes[i].trim().equals(jdTaskCode)) {
                    detail.setSelectCause(causex);
                    detail.setSelectCauseOther(selectCauseOtherx);
                } else {
                    detail.setSelectCause(causes[i].trim());
                    detail.setSelectCauseOther(causeOthers[i].trim());
                    if (null != dates[i].trim() && !"".equals(dates[i].trim())) {
                        try {
                            Timestamp ts = new Timestamp(format.parse(dates[i].trim()).getTime());
                            detail.setPlanEndTime(ts);
                        } catch (ParseException e) {
                        }
                    }
                }
                map.put("detail", detail);
                setdate(codes[i].trim(), map);
                if (excelJdTasks != null) {
                    if (!jdTaskCodeSet.contains(excelJdTasks.getJdTaskCode())) {
                        map.put("flow", excelJdTasks.getJdTaskCode());
                        map.put("task", excelJdTasks);
                        if (i <jdManagers.length && !codes[i].trim().equals(jdTaskCode)) {
                            map.put("jdManager", jdManagers[i].trim());
                            String userName = "";
                            for (String userid : jdManagers[i].trim().split(",")) {
                                if (!StringHelper.isEmpty(userid.trim())) {
                                    userName += sysUserService.get(Long.parseLong(userid.trim())).getDisplayName() + ",";
                                }
                            }
                            map.put("jdManagerName", userName.length() != 0 ? userName.substring(0, userName.length() - 1) : "");
                        }
//                        map.put("groupList", workGroupList);
//                        if (i < jdManager.length() && !codes[i].trim().equals(jdTaskCode)) {
//                            map.put("groupId", jdManagers[i].trim());
//                        }
                        list.add(map);
                        jdTaskCodeSet.add(excelJdTasks.getJdTaskCode());
                    }
                }
            }
        }
        model.addAttribute("list", list);
        model.addAttribute("isEdit", isEdit);
        model.addAttribute("isAudit", isAudit);
        return "view/plan/planDetail/getDetailList";
    }

    /**
     * 工程最后一次计划或预约时间
     */
    public void setdate(String jdTaskCode, Map<String, Object> map) {

        // 监督计划
        String hqld = "from PlanDetail where planEndTime is not null and jdTaskCode ='" + jdTaskCode + "' order by planEndTime desc";
        List<PlanDetail> lt = planDetailService.findByQuery(hqld);
        // 监督预约
        String hqlxx = "from OrderForm where orderDatetime is not null and jdTaskCode ='" + jdTaskCode + "' order by orderDatetime desc";
        List<OrderForm> orderForms = orderFormService.findByQuery(hqlxx);
        if (lt.size() > 0 || orderForms.size() > 0) {
            // 监督计划的时间
            if (lt.size() > 0 && orderForms.size() <= 0) {
                PlanDetail p = lt.get(0);
                map.put("planEndTimeLast", p.getPlanEndTime() != null ? p.getPlanEndTime() : "");
                // 监督预约的时间
            } else if (lt.size() <= 0 && orderForms.size() > 0) {
                map.put("planEndTimeLast", orderForms.get(0).getOrderDatetime() != null ? orderForms.get(0).getOrderDatetime() : "");

            } else if (lt.size() > 0 && orderForms.size() > 0) {
                // 监督计划的时间
                Timestamp lst = lt.get(0).getPlanEndTime();
                // 监督预约的时间
                Timestamp time = orderForms.get(0).getOrderDatetime();
                if (lst.before(time)) {
                    map.put("planEndTimeLast", time);
                } else {
                    map.put("planEndTimeLast", lst);
                }
            }
        } else {
            map.put("planEndTimeLast", "");
        }
    }

    /**
     * 选择填报监督记录
     *
     * @param model    .
     * @param typeCode .
     * @return .
     */
    @RequestMapping
    public String select(Model model, String typeCode,String jdTaskCode,String planDetailId) {
        if (typeCode.equals("safe")) {
            model.addAttribute("name", "安全");
        } else if (typeCode.equals("quality")) {
            model.addAttribute("name", "质量");
        }
        model.addAttribute("typeCode", typeCode);
        model.addAttribute("jdTaskCode", jdTaskCode);
        model.addAttribute("planDetailId", planDetailId);

        return "view/plan/planDetail/select";
    }

    /**
     * 选择监督项目入口
     *
     * @param model .
     * @param id    .
     * @return .
     */
    @RequestMapping
    public String selectProject(Model model, Long id) {
        model.addAttribute("id", id);
        return "view/plan/planDetail/selectProject";
    }

    /**
     * 检查30天（参数配置）内有（todo），不能安排在本次巡查计划中。
     *
     * @param model          .
     * @param planMainInfoId .
     * @param jdTaskCode     .
     * @param type           .
     */
    @RequestMapping
    public void checkSelectProjectGridData(Model model, String planMainInfoId, String jdTaskCode, String type, HttpServletResponse response) throws Exception {
        Boolean flag = false;

//        String hql = "from PlanDetail where plan.id=" + planMainInfoId + " and flowCode=" + flowCode + " order by id desc";
//        String hql = "from PlanDetail where flowCode='" + flowCode + "' order by id desc";
//        List<PlanDetail> pdList = planDetailService.findByQuery(hql);

        String hql2 = "SELECT * FROM ( Select A.jd_task_code,MAX(A.TIME) as Time from(SELECT P .jd_task_code as jd_task_code, P .PLAN_END_TIME as time " +
                " FROM PLAN_DETAIL P WHERE P .PLAN_END_TIME IS not NULL UNION " +
                " SELECT O .jd_task_code as jd_task_code, O .order_dateTime as time FROM ORDER_FORM O" +
                " WHERE O .order_dateTime IS  not NULL) A GROUP BY A.jd_task_code ) PlanDetail " +
                " WHERE PlanDetail.jd_task_code='" + jdTaskCode + "'";
        List pdList = planDetailService.findBySql(hql2);


        for (Object object : pdList) {
            Object[] ss = (Object[]) object;
            String planEndTime = String.valueOf(ss[1]);
            String jdTaskCodeXX = String.valueOf(ss[0]);

            SysCodeDetail detailStatus = sysCodeManager.getCodeDetailByCode(Constants.PLAN_DETAIL_STATUS, Constants.PLAN_DETAIL_STATUS_CHECKED);
            String hql = "from PlanDetail where jdTaskCode='" + jdTaskCodeXX + "'";
            List<PlanDetail> li = planDetailService.findByQuery(hql);
            boolean flagDetail = false;
            if (null != li) {
                for (PlanDetail pla : li) {
                    if (detailStatus.getCode().equals(pla.getStatus().getCode())) {
                        flagDetail = true;
                        break;
                    }
                }
            }

            SysCodeDetail detailStatu2 = sysCodeManager.getCodeDetailByCode(Constants.ORDER_FORM_STATUS, Constants.ORDER_FORM_STATUS_ACCEPT);
            String hql3 = "from OrderForm t where t.jdTaskCode=? order by t.orderCode desc";
            List<OrderForm> orderForms = orderFormService.findByQuery(hql3, jdTaskCodeXX);
            boolean flagOrderForm = false;
            if (null != orderForms) {
                for (OrderForm or : orderForms) {
                    if (detailStatu2.getCode().equals(or.getOrderStatus().getCode())) {
                        flagOrderForm = true;
                        break;
                    }
                }
            }
            String day = sysParameterManager.getSysParameterValue(Constants.PLAN_DETAIL_DAY_SET);
            if (null != day && !"".equals(day)) {
                int cc = -Integer.parseInt(day);
                if (flagOrderForm || flagDetail) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Timestamp endTime = new Timestamp(simpleDateFormat.parse(planEndTime).getTime());
                    Calendar now = Calendar.getInstance();
                    now.add(Calendar.DAY_OF_MONTH, cc);
                    if (endTime.after(new Timestamp(now.getTimeInMillis()))) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        model.addAttribute("flag", flag);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(String.valueOf(flag));
    }

    /**
     * 备注说明原因
     *
     * @param model .
     * @param id    .
     * @return .
     */
    @RequestMapping
    public String msgSelectProjectGridData(Model model, String id) {

        model.addAttribute("PLAN_DETAIL_SELECT_CAUSE", Constants.PLAN_DETAIL_SELECT_CAUSE);
        model.addAttribute("PLAN_DETAIL_SELECT_CAUSE_OTHER", Constants.PLAN_DETAIL_SELECT_CAUSE_OTHER);
        model.addAttribute("jdTaskCode", id);

        return "view/plan/planDetail/descriptionInput";
    }

    /**
     * 选择监督项目列表
     *
     * @param model .
     * @param id    .
     * @return .
     */
    @RequestMapping
    public String selectProjectGrid(Model model, Long id, String tabType) {
        model.addAttribute("id", id);
        model.addAttribute("tabType", tabType);
        setEmu(model);
        return "view/plan/planDetail/selectProjectGrid";
    }


    public void setEmu(Model model) {
        model.addAttribute("all", all);
        model.addAttribute("nothing", nothing);
        model.addAttribute("danger", danger);
        model.addAttribute("leaving", leaving);
    }

    /**
     * 选择监督项目列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     * @param id       .
     */
    @RequestMapping
    public void selectProjectGridData(HttpServletResponse response, HttpServletRequest request, String filters, String columns, int page, int rows, Long id, String tabType) {
        try {
            Page pageModel = new Page(page, rows, true);
            String sql = "";
            // 本组所有的普通工程
            if (all.equals(tabType)) {
                sql += "select t.id as fid,t.jd_task_code,t.bjbh,t.JS_UNIT_NAME,t.jd_datetime,t.project_name" +
                        " from excel_jd_tasks t where 1=1 and t.jd_task_code is not null order by t.jd_datetime desc";
                // 存在重大危险源的项目
            } else if (danger.equals(tabType)) {
                Calendar cad = Calendar.getInstance();
                SimpleDateFormat sdp = new SimpleDateFormat("yyyy-MM-dd");
                sdp.format(cad.getTimeInMillis());
                sql += " SELECT * FROM(" +
                        " SELECT  Z .fid, Z .jd_task_code, Z .bjbh, Z.JS_UNIT_NAME, min(Z.START_DATETIME) as START_DATETIME ,max(Z.END_DATETIME) as END_DATETIME ,  Z.project_name " +
                        " FROM (" +
                        " SELECT  TX. ID AS fid,TX.jd_task_code as jd_task_code,TX.bjbh as bjbh,TX.JS_UNIT_NAME as  JS_UNIT_NAME,TX.jd_datetime as jd_datetime,TX.project_name as project_name,sd.START_DATETIME as START_DATETIME,SD.END_DATETIME as END_DATETIME " +
                        " FROM share_gd_info sg " +
                        " LEFT JOIN syn_great_danger sd ON sg.GD_CODE = sd.GDBH " +
                        " LEFT JOIN excel_jd_tasks TX ON TX.bjbh = sg.bjbh " +
                        " WHERE TX.jd_task_code IS NOT NULL AND TO_DATE('" + sdp.format(cad.getTime()) + "','yyyy-MM-dd') > SD.START_DATETIME " +
                        " AND TO_DATE('" + sdp.format(cad.getTime()) + "','yyyy-MM-dd') < SD.END_DATETIME ) Z " +
                        " GROUP BY Z.fid,Z.jd_task_code, Z.bjbh, Z.JS_UNIT_NAME, Z.project_name ) T order by T.END_DATETIME desc";


                // 未安排过首次的工程
            } else if (nothing.equals(tabType)) {
                sql += "SELECT * FROM ( SELECT  " +
                        " xT. ID AS fid, xT.jd_task_code AS jd_task_code, xT.bjbh AS bjbh, xT.JS_UNIT_NAME AS JS_UNIT_NAME, xT.jd_datetime AS jd_datetime, " +
                        " xT.project_name AS project_name, P .TIME AS TIME FROM excel_jd_tasks xT " +
                        " LEFT JOIN  (Select A.jd_task_code,MAX(A.TIME) as Time from(SELECT " +
                        " P .jd_task_code as jd_task_code, P .PLAN_END_TIME as time  FROM PLAN_DETAIL P " +
                        " WHERE P .PLAN_END_TIME IS not NULL  UNION " +
                        " SELECT O .jd_task_code as jd_task_code, O .order_dateTime as time " +
                        " FROM ORDER_FORM O  WHERE O .order_dateTime IS  not NULL) A GROUP BY A.jd_task_code)P " +
                        " ON  P .jd_task_code = xT.jd_task_code ) T" +
                        " WHERE T .TIME IS NULL  ORDER BY  T .jd_datetime DESC ";

                // 3个月未安排过
            } else if (leaving.equals(tabType)) {
                Calendar ca = Calendar.getInstance();
                ca.add(Calendar.MONTH, -3);
                SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
                sp.format(ca.getTimeInMillis());
                sql += " SELECT * FROM(SELECT  TX.ID AS fid, TX.jd_task_code AS jd_task_code,TX .bjbh AS bjbh,TX.JS_UNIT_NAME AS JS_UNIT_NAME, " +
                        " Z.time AS time, TX.project_name AS project_name " +
                        " FROM excel_jd_tasks TX " +
                        " LEFT JOIN " +
                        "(Select A.jd_task_code,MAX(A.TIME) as Time from(SELECT " +
                        " P .jd_task_code as jd_task_code,P .PLAN_END_TIME as time " +
                        " FROM PLAN_DETAIL P " +
                        " WHERE P .PLAN_END_TIME IS NOT NULL " +
                        " UNION SELECT O .jd_task_code as jd_task_code, O .order_dateTime as time " +
                        " FROM ORDER_FORM O " +
                        " WHERE O .order_dateTime IS NOT NULL) A GROUP BY A.jd_task_code) Z on Z.jd_task_code =TX.jd_task_code)T " +
                        " where T.time < TO_DATE ('" + sp.format(ca.getTime()) + "', 'yyyy-MM-dd') " +
                        " AND T.time is not null " +
                        " ORDER BY T.time desc ";
            }

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(sql, filters);
            pageModel = planMainInfoService.findBySql(pageModel, queryTranslate.toString(), null);

            //输出显示
            String json = GridJq.toJSON(pageModel.getRows(), pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 回写任务状态
     *
     * @param response     .
     * @param planDetailId .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void cancelPlan(HttpServletResponse response, Long planDetailId) throws Exception {
        try {
            String cancelCode = sysCodeManager.getCodeDetailByCode(Constants.PLAN_DETAIL_STATUS, Constants.PLAN_DETAIL_STATUS_CANCEL).getCode();
            planMainInfoManager.setDetailStatus(planDetailId, cancelCode, java.sql.Date.valueOf(DateTimeHelper.getCurrentDate()));

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 任务执行和查看
     *
     * @param response .
     * @param model    .
     * @param id       .
     * @param isView   是否查看
     * @throws java.io.IOException .
     */
    @RequestMapping
    public void task(HttpServletResponse response, Model model, Long id, String isView) throws IOException {
        //查看任务
        if ("true".equals(isView)) {
            PlanDetail detail = planDetailService.get(id);
            response.reset();
            response.sendRedirect("../planMainInfo/view.do?id=" + detail.getPlan().getId());

        } else {
            //执行任务
            String url = "../pollingRecord/init.do?formClass={0}&action=add&taskParam=<typeCode>{1}</typeCode><typeId>{2}</typeId><referId>{3}</referId>";
            Boolean isSuccess = false;
            List<PlanDetail> list = planDetailService.findByQuery("from PlanDetail where id=" + id);
            if (list.size() > 0) {
                PlanDetail planDetail = list.iterator().next();
                PlanMainInfo plan = planDetail.getPlan();
                SysCodeDetail planType = plan.getPlanType();
                SysCodeDetail formClassData = pollingRecordManager.getFormClassData(planType.getCode());
                if (formClassData != null) {
                    isSuccess = true;
                    response.sendRedirect(FormatUtils.format(url, String.valueOf(formClassData.getId()), planType.getCode(), String.valueOf(planType.getId()), String.valueOf(id)));
                }
            }
            if (!isSuccess) {
//            sendErrorJSON(response,"未找到有效表单，可能表单已删除");
                response.sendRedirect(Constants.OA_TASK_NULL_PAGE + id);
            }
        }
    }

}