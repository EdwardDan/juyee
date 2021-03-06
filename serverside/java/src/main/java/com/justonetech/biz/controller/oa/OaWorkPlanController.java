package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaFgldSetItemService;
import com.justonetech.biz.daoservice.OaWorkPlanItemService;
import com.justonetech.biz.daoservice.OaWorkPlanService;
import com.justonetech.biz.domain.OaFgldSetItem;
import com.justonetech.biz.domain.OaWorkPlan;
import com.justonetech.biz.domain.OaWorkPlanItem;
import com.justonetech.biz.manager.OaFgldManager;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.OaWorkPlanStatus;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.ExcelPrintManager;
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
import java.util.*;


/**
 * note:科室工作周上报
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaWorkPlanController extends BaseCRUDActionController<OaWorkPlan> {
    private Logger logger = LoggerFactory.getLogger(OaWorkPlanController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private ExcelPrintManager excelPrintManager;

    @Autowired
    private OaWorkPlanService oaWorkPlanService;

    @Autowired
    private OaWorkPlanItemService oaWorkPlanItemService;

    @Autowired
    private OaFgldManager oaFgldManager;

    @Autowired
    private OaTaskManager oaTaskManager;

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
        //判断是否有编辑权限
        setStatus(model);
        return "view/oa/oaWorkPlan/grid";
    }

    public void setStatus(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_WORK_PLAN_EDIT));
        model.addAttribute("canEdit_KZ", sysUserManager.hasPrivilege(PrivilegeCode.OA_WORK_PLAN_AUDIZ_KZ));
        model.addAttribute("canEdit_FG", sysUserManager.hasPrivilege(PrivilegeCode.OA_WORK_PLAN_AUDIT_FG));
        model.addAttribute("canView_ALL", sysUserManager.hasPrivilege(PrivilegeCode.OA_WORK_PLAN_VIEW_ALL));
        //常量定义
        model.addAttribute("STATUS_EDIT", OaWorkPlanStatus.STATUS_EDIT.getCode());
        model.addAttribute("STATUS_SUBMIT", OaWorkPlanStatus.STATUS_SUBMIT.getCode());
        model.addAttribute("STATUS_BRANCH_PASS", OaWorkPlanStatus.STATUS_BRANCH_PASS.getCode());
        model.addAttribute("STATUS_BRANCH_BACK", OaWorkPlanStatus.STATUS_BRANCH_BACK.getCode());
        model.addAttribute("STATUS_MAIN_PASS", OaWorkPlanStatus.STATUS_MAIN_PASS.getCode());
        model.addAttribute("STATUS_MAIN_BACK", OaWorkPlanStatus.STATUS_MAIN_BACK.getCode());
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
            String deptNames = "";
            String hql = "from OaWorkPlan where 1=1";
            //增加自定义查询条件-判断只有编辑权限和科长权限的只能获取本科室数据
            if (!sysUserManager.hasPrivilege(PrivilegeCode.OA_WORK_PLAN_VIEW_ALL)) {//判断是否有查看全部权限
                if (sysUserManager.hasPrivilege(PrivilegeCode.OA_WORK_PLAN_EDIT) || sysUserManager.hasPrivilege(PrivilegeCode.OA_WORK_PLAN_AUDIZ_KZ)) {
                    hql += " and reportDept = '" + sysUserManager.getSysUser().getPerson().getDeptName() + "'";
                } else {
                    String[] managerPersonAndDepts = oaFgldManager.getManagerPersonAndDepts(sysUserManager.getSysUser());
                    deptNames = managerPersonAndDepts[0];
                }
            }
            hql += " order by id desc";
            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = oaWorkPlanService.findByPage(pageModel, query);

            List<OaWorkPlan> rowList = pageModel.getRows();
            List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
            for (OaWorkPlan data : rowList) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", data.getId());
                map.put("reportDept", data.getReportDept());//上报科室
                map.put("reportPerson", data.getReportPerson());//上报人姓名
                map.put("workTime", data.getWorkTime());//工作时间
                map.put("status", data.getStatus());//当前状态
                map.put("statusName", data.getStatusName());//当前状态名
                map.put("deptNames", deptNames);//分管部门名称
                retList.add(map);
            }

            //输出显示
            String json = GridJq.toJSON(retList, pageModel);
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
        OaWorkPlan oaWorkPlan = new OaWorkPlan();
        //默认申请人为当前用户
        SysUser sysUser = sysUserManager.getSysUser();
        oaWorkPlan.setReportUser(sysUser.getLoginName());
        oaWorkPlan.setReportPerson(sysUser.getPerson().getName());
        //获取登录人的部门
        SysDept dept = sysUser.getPerson().getDept();
        oaWorkPlan.setReportDept(dept.getName());
        //如需增加其他默认值请在此添加
        setStatus(model);
        model.addAttribute("bean", oaWorkPlan);
        model.addAttribute("applyPersonId", sysUser.getId());

        return "view/oa/oaWorkPlan/input";
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
        OaWorkPlan oaWorkPlan = oaWorkPlanService.get(id);
        setStatus(model);
        if (oaWorkPlan.getReportUser() != null) {
            model.addAttribute("applyPersonId", sysUserManager.getSysUser(oaWorkPlan.getReportUser()).getId());
        }
        Set<OaWorkPlanItem> oaWorkPlanItems = oaWorkPlan.getOaWorkPlanItems();
        //处理其他业务逻辑
        model.addAttribute("bean", oaWorkPlan);
        model.addAttribute("oaWorkPlanItems", oaWorkPlanItems);

        return "view/oa/oaWorkPlan/input";
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
        OaWorkPlan oaWorkPlan = oaWorkPlanService.get(id);
        setStatus(model);
        if (oaWorkPlan.getReportUser() != null) {
            model.addAttribute("applyPersonId", sysUserManager.getSysUser(oaWorkPlan.getReportUser()).getId());
        }
        Set<OaWorkPlanItem> oaWorkPlanItems = oaWorkPlan.getOaWorkPlanItems();
        //处理其他业务逻辑
        model.addAttribute("bean", oaWorkPlan);
        model.addAttribute("oaWorkPlanItems", oaWorkPlanItems);

        return "view/oa/oaWorkPlan/audit";
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
        OaWorkPlan oaWorkPlan = oaWorkPlanService.get(id);
        setStatus(model);
        Set<OaWorkPlanItem> oaWorkPlanItems = oaWorkPlan.getOaWorkPlanItems();
        //处理其他业务逻辑
        model.addAttribute("oaWorkPlanItems", oaWorkPlanItems);

        model.addAttribute("bean", oaWorkPlan);
        return "view/oa/oaWorkPlan/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaWorkPlan entity, HttpServletRequest request) throws Exception {
        String msg = "保存成功";
        try {
            OaWorkPlan target;
            if (entity.getId() != null) {
                target = oaWorkPlanService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "reportDept",
                        "reportUser",
                        "reportPerson",
                        "beginDate",
                        "endDate",
                        "status"
//                        "kzOpinion",
//                        "fgOpinion",
                });

            } else {
                target = entity;
            }
            oaWorkPlanService.save(target);//保存上报记录
            for (OaWorkPlanItem workPlanItem : target.getOaWorkPlanItems()) {
                oaWorkPlanItemService.delete(workPlanItem);//删除关联item表
            }
            //保存详细信息
            String[] orderNo = request.getParameterValues("orderNo");
            String[] dutyPerosn = request.getParameterValues("dutyPerosn");
            String[] keyWork = request.getParameterValues("keyWork");
            String[] content = request.getParameterValues("content");
            String[] schedule = request.getParameterValues("schedule");
            String[] jbr = request.getParameterValues("jbr");
            String kzOpinion = request.getParameter("kzOpinion");
            String fgOpinion = request.getParameter("fgOpinion");
            if (orderNo != null) {
                for (int i = 0; i < orderNo.length; i++) {
                    OaWorkPlanItem oaWorkPlanItem = new OaWorkPlanItem();
                    oaWorkPlanItem.setWeekPlan(target);
                    oaWorkPlanItem.setOrderNo(JspHelper.getInteger(orderNo[i]));
                    oaWorkPlanItem.setDutyPerosn(dutyPerosn[i]);
                    oaWorkPlanItem.setKeyWork(keyWork[i]);
                    oaWorkPlanItem.setContent(content[i]);
                    oaWorkPlanItem.setSchedule(schedule[i]);
                    oaWorkPlanItem.setJbr(jbr[i]);
                    oaWorkPlanItemService.save(oaWorkPlanItem);//插入关联表数据item
                }
            }
            Integer status = target.getStatus();
            SysUser sysUser = sysUserManager.getSysUser();
            if (status.equals(OaWorkPlanStatus.STATUS_BRANCH_BACK.getCode()) || status.equals(OaWorkPlanStatus.STATUS_BRANCH_PASS.getCode())) {
                target.setKzOpinion(kzOpinion);//保存科长审核意见
                target.setKzAuditTime(new Timestamp(System.currentTimeMillis()));
                target.setKzAuditUser(sysUser.getDisplayName());
            }
            if (status.equals(OaWorkPlanStatus.STATUS_MAIN_BACK.getCode()) || status.equals(OaWorkPlanStatus.STATUS_MAIN_PASS.getCode())) {
                target.setFgOpinion(fgOpinion);//保存分管领导审核意见
                target.setFgAuditTime(new Timestamp(System.currentTimeMillis()));
                target.setFgAuditUser(sysUser.getDisplayName());
            }
            oaWorkPlanService.save(target);//保存上报记录
            if (OaWorkPlanStatus.STATUS_BRANCH_BACK.getCode() == status || OaWorkPlanStatus.STATUS_MAIN_BACK.getCode() == status) {
                msg = "已退回修改!";//ststus=4/6
            } else if (OaWorkPlanStatus.STATUS_BRANCH_PASS.getCode() == status || OaWorkPlanStatus.STATUS_MAIN_PASS.getCode() == status) {
                msg = "审核已通过!";//status=3/5
            } else if (OaWorkPlanStatus.STATUS_SUBMIT.getCode() == status) {
                msg = "已提交!";//status=2
            }
            if (!status.equals(OaWorkPlanStatus.STATUS_EDIT.getCode())) {
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
     * 导出excel
     *
     * @param response .
     * @throws Exception .
     */
    @RequestMapping
    public void printExcel(HttpServletResponse response, Long id, HttpServletRequest request) throws Exception {
        //把打印的数据压入map中
        String xlsTemplateName = "OaWorkPlanItem.xls";
        String fileName = "科室一周工作安排.xls";
        Map<String, Object> beans = new HashMap<String, Object>();
        OaWorkPlan oaWorkPlan = oaWorkPlanService.get(id);
        Set<OaWorkPlanItem> oaWorkPlanItemList = oaWorkPlan.getOaWorkPlanItems();
        beans.put("items", oaWorkPlanItemList);
        beans.put("reportDept", oaWorkPlan.getReportDept());//科室
        beans.put("workTime", oaWorkPlan.getWorkTime());//工作时间
        //一周工作行合并
        Map<String, Object> mergeMap = new HashMap<String, Object>();
        List<int[]> mergerCellsList = new ArrayList<int[]>();
        int startColNo = 0;
        int startRowNo = 2;
        int AddRow = oaWorkPlanItemList.size();//工作行
        mergerCellsList.add(new int[]{startColNo, startRowNo, startColNo, startRowNo + AddRow - 1});
        mergeMap.put("mergerCellsList", mergerCellsList);
        excelPrintManager.printExcel(response, request, OaWorkPlanItem.class.getSimpleName(), xlsTemplateName, beans, fileName, mergeMap);
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
        OaWorkPlan oaWorkPlan = oaWorkPlanService.get(id);
        for (OaWorkPlanItem workPlanItem : oaWorkPlan.getOaWorkPlanItems()) {//删除关联item表
            oaWorkPlanItemService.delete(workPlanItem);
        }
        oaWorkPlanService.delete(id);
        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 创建系统任务
     *
     * @param data .
     * @throws Exception .
     */
    public void createOaTask(OaWorkPlan data) throws Exception {
        int status = data.getStatus();
        //创建任务
        Set<Long> managers = new HashSet<Long>();
        SysUser currentUser = sysUserManager.getSysUser();
        if (status == OaWorkPlanStatus.STATUS_SUBMIT.getCode()) {
            SysUser kz = sysUserManager.getDeptLeaderByRole(currentUser.getLoginName());
            String privilegeCode = PrivilegeCode.OA_WORK_PLAN_AUDIZ_KZ;
            Set<Long> managersKZ = sysUserManager.getUserIdsByPrivilegeCode(privilegeCode);
            if (null != kz && managersKZ.contains(kz.getId())) {
                managers.add(kz.getId());
            }
            String taskTitle = oaTaskManager.getTaskTitle(data, OaWorkPlan.class.getSimpleName() + "_BRANCH_PASS");
            if (managers.size() > 0) {
                oaTaskManager.createTask(OaWorkPlan.class.getSimpleName() + "_BRANCH_PASS", data.getId(), taskTitle, managers, false, null, null);
            }
        } else if (status == OaWorkPlanStatus.STATUS_BRANCH_PASS.getCode()) {
//            String privilegeCode = PrivilegeCode.OA_WORK_PLAN_AUDIT_FG;
//            Set<Long> managersFG = sysUserManager.getUserIdsByPrivilegeCode(privilegeCode);
//            managers.addAll(managersFG);
            SysPerson person = currentUser.getPerson();
            if (null != person) {
                SysDept dept = person.getDept();
                List<OaFgldSetItem> setItems = oaFgldSetItemService.findByProperty("dept.id", dept.getId());
                for (OaFgldSetItem item : setItems) {
                    SysUser user = item.getFgldSet().getUser();
                    if (null != user)
                        managers.add(user.getId());
                }
            }
            String taskTitle = oaTaskManager.getTaskTitle(data, OaWorkPlan.class.getSimpleName() + "_MAIN_PASS");
            if (managers.size() > 0) {
                oaTaskManager.createTask(OaWorkPlan.class.getSimpleName() + "_MAIN_PASS", data.getId(), taskTitle, managers, false, null, null);
            }
        } else if (status == OaWorkPlanStatus.STATUS_BRANCH_BACK.getCode() || status == OaWorkPlanStatus.STATUS_MAIN_BACK.getCode()) {
            String reportUser = data.getReportUser();
            SysUser sysUser = sysUserManager.getSysUser(reportUser);
            managers.add(sysUser.getId());
            String taskTitle = oaTaskManager.getTaskTitle(data, OaWorkPlan.class.getSimpleName());
            if (managers.size() > 0) {
                oaTaskManager.createTask(OaWorkPlan.class.getSimpleName(), data.getId(), taskTitle, managers, false, null, null);
            }
        }
    }
}