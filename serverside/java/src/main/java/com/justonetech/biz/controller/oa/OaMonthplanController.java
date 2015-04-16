package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaMonthplanItemService;
import com.justonetech.biz.daoservice.OaMonthplanService;
import com.justonetech.biz.domain.OaMonthplan;
import com.justonetech.biz.domain.OaMonthplanItem;
import com.justonetech.biz.manager.OaFgldManager;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.manager.MsgMessageManager;
import com.justonetech.biz.utils.enums.OaMonthplanStatus;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.*;
import com.justonetech.system.domain.SysDept;
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
 * note:月度总结和计划
 * author: 黄国荣
 * create date:
 * modify date:2014-05-06
 */
@Controller
public class OaMonthplanController extends BaseCRUDActionController<OaMonthplan> {
    private Logger logger = LoggerFactory.getLogger(OaMonthplanController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private OaMonthplanService oaMonthplanService;

    @Autowired
    private OaMonthplanItemService oaMonthplanItemService;

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
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_MONTHPLAN_EDIT));//编辑权限
        model.addAttribute("canAudit", sysUserManager.hasPrivilege(PrivilegeCode.OA_MONTHPLAN_AUDIT));  //审核权限
//        model.addAttribute("canDelete", sysUserManager.hasPrivilege(PrivilegeCode.OA_CAR_DELETE));//强制删除权限
        model.addAttribute("currentUser", sysUserManager.getSysUser().getLoginName());//当前用户名
        setOaMonthplanStatus(model);

        //获取年和月的下拉框（为空为当前年月）
        Calendar c = Calendar.getInstance();
        String yearSelectOptions = DateTimeHelper.getYearSelectOptions(String.valueOf(c.get(Calendar.YEAR)));
        String monthSelectOptions = DateTimeHelper.getMonthSelectOptions(String.valueOf(c.get(Calendar.MONTH) + 1));
        model.addAttribute("yearOptions", yearSelectOptions);
        model.addAttribute("monthOptions", monthSelectOptions);

        return "view/oa/oaMonthplan/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpServletRequest request) {
        try {
            //增加自定义查询条件
            String year = request.getParameter("year");
            String period = request.getParameter("period");

            Page pageModel = new Page(page, rows, true);
            String hql = "from OaMonthplan  where 1=1 ";
            if (!StringHelper.isEmpty(year)) {
                hql += " and year=" + Integer.parseInt(year);
            }
            if (!StringHelper.isEmpty(period)) {
                hql += " and period=" + Integer.parseInt(period);
            }
            hql += " order by id desc";
            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = oaMonthplanService.findByPage(pageModel, queryTranslate.toString());

//            //将年份和月份拼接在grid中显示
            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : list) {
                Object id = bean.get("id");
                if (null != id) {
                    OaMonthplan oaMonthplan = oaMonthplanService.get(JspHelper.getLong(id));
                    bean.put("reportTime", oaMonthplan.getReportTime());

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
    private void setOaMonthplanStatus (Model model) {
        model.addAttribute("STATUS_EDIT", OaMonthplanStatus.STATUS_EDIT.getCode()); //填写
        model.addAttribute("STATUS_SUBMIT", OaMonthplanStatus.STATUS_SUBMIT.getCode()); //提交
        model.addAttribute("STATUS_BACK", OaMonthplanStatus.STATUS_BACK.getCode()); //退回修改
        model.addAttribute("STATUS_PASS", OaMonthplanStatus.STATUS_PASS.getCode()); //审核通过
    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        OaMonthplan oaMonthplan = new OaMonthplan();

        //默认申请人为当前用户
        SysUser sysUser = sysUserManager.getSysUser();
        oaMonthplan.setReportPerson(sysUser.getDisplayName());
        //获取登录人的部门
        SysDept dept = sysUser.getPerson().getDept();
        oaMonthplan.setReportDept(dept.getName());
        oaMonthplan.setReportDate(new Date(System.currentTimeMillis()));
        oaMonthplan.setStatus(OaMonthplanStatus.STATUS_EDIT.getCode());

        //设置年 月
        Calendar cal = Calendar.getInstance();  //获取当前时间
        String YearSelectOptions = DateTimeHelper.getYearSelectOptions(JspHelper.getString(cal.get(Calendar.YEAR)));
        String PeriodSelectOptions = DateTimeHelper.getMonthSelectOptions(JspHelper.getString(cal.get(Calendar.MONTH) + 1));

        model.addAttribute("YearSelectOptions", YearSelectOptions);
        model.addAttribute("PeriodSelectOptions", PeriodSelectOptions);


        //如需增加其他默认值请在此添加
        model.addAttribute("bean", oaMonthplan);
        setOaMonthplanStatus(model);
        return "view/oa/oaMonthplan/input";
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
        OaMonthplan oaMonthplan = oaMonthplanService.get(id);

        //设置审核时间为当前时间
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if (oaMonthplan.getStatus() == OaMonthplanStatus.STATUS_SUBMIT.getCode())
            oaMonthplan.setFgAuditTime(timestamp);

        //年月显示
        String YearSelectOptions = DateTimeHelper.getYearSelectOptions(oaMonthplan.getYear().toString());
        String PeriodSelectOptions = DateTimeHelper.getMonthSelectOptions(oaMonthplan.getPeriod().toString());
        model.addAttribute("YearSelectOptions", YearSelectOptions);
        model.addAttribute("PeriodSelectOptions", PeriodSelectOptions);

        model.addAttribute("bean", oaMonthplan);
        setOaMonthplanStatus(model);

        return "view/oa/oaMonthplan/input";
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
        OaMonthplan oaMonthplan = oaMonthplanService.get(id);

        model.addAttribute("bean", oaMonthplan);
        return "view/oa/oaMonthplan/view";
    }


    /**
     * 保存操作（编辑）
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaMonthplan entity, HttpServletRequest request, String status) throws Exception {
        try {
            OaMonthplan target;
            if (entity.getId() != null) {
                target = oaMonthplanService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "reportDept",
                        "reportPerson",
                        "year",
                        "period",
                });

            } else {
                target = entity;
            }
            if (null != status && !"".equals(status)) {
                target.setStatus(Integer.valueOf(status));
            }

            //根据状态判断是否存“提交时间”
            if (target.getStatus() != OaMonthplanStatus.STATUS_EDIT.getCode()) {
                target.setReportDate(new Date(System.currentTimeMillis()));//"填写"状态存储提交时间
            }
            //根据部门名称获取审核领导信息
            if(target.getStatus()==OaMonthplanStatus.STATUS_SUBMIT.getCode()){
                if(oaFgldManager.getAuditUserId(target.getReportDept(),null)!=null){
                      String fgAuditUser = oaFgldManager.getAuditUserId(target.getReportDept(),null).getLoginName();
                      target.setFgAuditUser(fgAuditUser);
                }
            }
            //退回修改时将审核信息清空
            target.setFgOpinion("");
            target.setFgAuditTime(null);

            oaMonthplanService.save(target);

            //保存从表信息
            saveOaMonthplanItem(target, request);

            if (target.getStatus()!= OaMonthplanStatus.STATUS_EDIT.getCode()) {//创建待办事项
                createOaTask(target,target.getStatus());
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
    public void createOaTask(OaMonthplan data ,int Status) throws Exception {
        //创建任务
        Set<Long> managers = new HashSet<Long>();
        String  fgAuditUserName=oaFgldManager.getAuditUserName(data.getReportDept(),data.getFgAuditUser());
        SysUser fgAuditUser= null;
        if (null!=fgAuditUserName) {
            fgAuditUser = sysUserManager.getSysUser(fgAuditUserName);
        }
        if(Status==OaMonthplanStatus.STATUS_SUBMIT.getCode()&&null!=fgAuditUser) {
            String title = oaTaskManager.getTaskTitle(data, OaMonthplan.class.getSimpleName());
            managers.add(fgAuditUser.getId());
            if (managers.size() > 0&&null!=title) {
                oaTaskManager.createTask(OaMonthplan.class.getSimpleName(), data.getId(), title, managers, false, null, null);
            }
        }
        if(Status==OaMonthplanStatus.STATUS_PASS.getCode()||Status==OaMonthplanStatus.STATUS_BACK.getCode()) {
            SysUser sysUser = sysUserManager.getSysUser();
            SysUser receiveUser = sysUserManager.getSysUserByDisplayName(data.getReportPerson());
            String msgTemp = oaTaskManager.getTaskTitle(data, OaMonthplan.class.getSimpleName()+"_Pass");
            if(Status==OaMonthplanStatus.STATUS_BACK.getCode()){
                msgTemp =oaTaskManager.getTaskTitle(data, OaMonthplan.class.getSimpleName()+"_Back");
            }
            String[] ids = new String[1];
            if (null!=receiveUser) {
                ids[0]= String.valueOf(receiveUser.getId());
                msgMessageManager.sendSmsByUser(msgTemp , sysUser, ids);
            }
        }

    }



    /**
     * 保存操作（审核）
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void auditSave(HttpServletResponse response, @ModelAttribute("bean") OaMonthplan entity, HttpServletRequest request, String status) throws Exception {
        try {
            OaMonthplan target;
            if (entity.getId() != null) {
                target = oaMonthplanService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "fgOpinion",
                        "fgAuditTime",
                });

            } else {
                target = entity;
            }
            target.setStatus(Integer.valueOf(status));
//            //获取当前登录用户
//            String loginName = SpringSecurityUtils.getCurrentUser().getLoginName();
//            //保存当前审核人
//            if (target.getStatus() == OaMonthplanStatus.STATUS_PASS.getCode()) {
//                target.setFgAuditUser(loginName);
//            }
            oaMonthplanService.save(target);
            //保存从表信息
            String[] itemZjses=request.getParameterValues("itemZjs");
            String[] itemJhses=request.getParameterValues("itemJhs");
            if(null!=itemZjses){
                for(int i=0;i<itemZjses.length;i++){
                    OaMonthplanItem oaMonthplanItem = oaMonthplanItemService.get(Long.parseLong(itemZjses[i]));
                    oaMonthplanItem.setContent(request.getParameter("contentZj_"+itemZjses[i]));
                    oaMonthplanItemService.save(oaMonthplanItem);
                }
            }
            if(null!=itemJhses){
                for(int i=0;i<itemJhses.length;i++ ){
                    OaMonthplanItem oaMonthplanItem = oaMonthplanItemService.get(Long.parseLong(itemJhses[i]));
                    oaMonthplanItem.setContent(request.getParameter("contentJh_"+itemJhses[i]));
                    oaMonthplanItemService.save(oaMonthplanItem);
                }
            }
            //创建待办事项
            createOaTask(target,target.getStatus());

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
        OaMonthplan oaMonthplan = oaMonthplanService.get(id);

        //设置审核时间为当前时间
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if (oaMonthplan.getStatus() == OaMonthplanStatus.STATUS_SUBMIT.getCode())
            oaMonthplan.setFgAuditTime(timestamp);

        //年月显示
        String YearSelectOptions = DateTimeHelper.getYearSelectOptions(oaMonthplan.getYear().toString());
        String PeriodSelectOptions = DateTimeHelper.getMonthSelectOptions(oaMonthplan.getPeriod().toString());
        model.addAttribute("YearSelectOptions", YearSelectOptions);
        model.addAttribute("PeriodSelectOptions", PeriodSelectOptions);

        //处理其他业务逻辑
        model.addAttribute("bean", oaMonthplan);
        setOaMonthplanStatus(model);

        return "view/oa/oaMonthplan/audit";
    }


    /**
     * 保存从表信息
     *
     * @param oaMonthplan 。
     * @param request     。
     */
    private void saveOaMonthplanItem(OaMonthplan oaMonthplan, HttpServletRequest request) {
        //先删除从表信息，在保存
        Set<OaMonthplanItem> oaMonthplanItems = oaMonthplan.getOaMonthplanItems();
        if (oaMonthplanItems.size() > 0) {
            for (OaMonthplanItem oaMonthplanItem : oaMonthplanItems) {
                oaMonthplanItemService.delete(oaMonthplanItem);

            }
        }
        //获取报告总结的详细信息
        //工作内容
        String[] contents = request.getParameterValues("content");
        //时间结点
        String[] timeNodes = request.getParameterValues("timeNode");
        //报告类型
        String[] reportTypes = request.getParameterValues("reportType");
        //是否完成
        String[] isCompletes = request.getParameterValues("isComplete");
        if (contents != null) {
            for (int i = 0; i < contents.length; i++) {
                OaMonthplanItem oaMonthplanItem = new OaMonthplanItem();
                oaMonthplanItem.setMonthplan(oaMonthplan);
                if (!StringHelper.isEmpty(contents[i])) {
                    oaMonthplanItem.setContent(contents[i]);
                }
                if (!StringHelper.isEmpty(timeNodes[i])) {
                    oaMonthplanItem.setTimeNode(Date.valueOf(timeNodes[i]));//date型
                }
                if (!StringHelper.isEmpty(reportTypes[i])) {
                    oaMonthplanItem.setReportType(reportTypes[i]);
                }
                if (!StringHelper.isEmpty(isCompletes[i])) {
                    oaMonthplanItem.setIsComplete(Boolean.valueOf(isCompletes[i]));//布尔型
                }
                oaMonthplanItem.setIsSumDelete(false);//保存时将从表的是否删除设置为false
                oaMonthplanItemService.save(oaMonthplanItem);
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
        OaMonthplan oaMonthplan = oaMonthplanService.get(id);
        Set<OaMonthplanItem> oaMonthplanItems = oaMonthplan.getOaMonthplanItems();
        if (oaMonthplanItems.size() > 0) {
            for (OaMonthplanItem oaMonthplanItem : oaMonthplanItems) {
                oaMonthplanItemService.delete(oaMonthplanItem);
            }
        }
        oaTaskManager.removeTask(OaMonthplan.class.getSimpleName(), id);//删除任务

        oaMonthplanService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}