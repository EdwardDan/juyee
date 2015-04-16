package com.justonetech.biz.controller.report;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.ReportMonthManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import net.sf.json.JSONObject;
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
import java.sql.Date;
import java.util.*;


/**
 * note:综合报表月份上报
 * author: guoqiong
 * modify date:  2014-7-16
 */
@Controller
public class ReportMonthController extends BaseCRUDActionController<ReportMonth> {
    private Logger logger = LoggerFactory.getLogger(ReportMonthController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private ReportMonthService reportMonthService;

    @Autowired
    private ReportMonthDetailService reportMonthDetailService;

    @Autowired
    private ReportDeptDefineService reportDeptDefineService;

    @Autowired
    private ReportMonthManager reportMonthManager;

    @Autowired
    private ReportStructureService reportStructureService;

    @Autowired
    private ReportStructureVerService reportStructureVerService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @param code  .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, String code) {
        //判断是否有编辑权限
        String privilegeCode = FormatUtils.format(PrivilegeCode.REPORT_MONTH_EDIT, code);
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(privilegeCode));
        model.addAttribute("code", code);

        //当前科室的名称
        getDefineNameByCode(code, model);

        //获取年和月的下拉框（为空为当前年月）
        Calendar c = Calendar.getInstance();
        String yearSelectOptions = DateTimeHelper.getYearSelectOptions(String.valueOf(c.get(Calendar.YEAR)));
        String monthSelectOptions = DateTimeHelper.getMonthSelectOptions(String.valueOf(c.get(Calendar.MONTH) + 1));
        model.addAttribute("yearOptions", yearSelectOptions);
        model.addAttribute("monthOptions", monthSelectOptions);

        return "view/report/reportMonth/grid";
    }

    /**
     * 当前列表的名称
     *
     * @param code  .
     * @param model .
     */
    public void getDefineNameByCode(String code, Model model) {
        List<ReportDeptDefine> defineList = reportDeptDefineService.findAll();
        for (ReportDeptDefine define : defineList) {
            if (code.equals(define.getCode())) {
                model.addAttribute("name", define.getDeptName());
            }
        }
    }

    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     * @param session  .
     * @param code     .
     * @param request  .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, String code, HttpServletRequest request) {
        try {
            //按年月查询数据
            String year = request.getParameter("year");
            String month = request.getParameter("month");
            Page pageModel = new Page(page, rows, true);

            String hql = "from ReportMonth where 1=1";
            if (!StringHelper.isEmpty(year)) {
                hql += " and year=" + Integer.parseInt(year);
            }
            if (!StringHelper.isEmpty(month)) {
                hql += " and month=" + Integer.parseInt(month);
            }
            if (!StringHelper.isEmpty(code)) {
                hql += " and reportDeptDefine.code='{0}'";
            }
            hql += " order by year desc,month desc,id desc";
            String hqlFormat = FormatUtils.format(hql, code);
            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hqlFormat, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = reportMonthService.findByPage(pageModel, query);

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 年月选择页面
     *
     * @param model 。
     * @param code  。
     * @return 。
     */
    @RequestMapping
    public String count(Model model, String code) {
        //获取年和月的下拉框（为空为当前年月）
        Calendar c = Calendar.getInstance();
        String yearSelectOptions = DateTimeHelper.getYearSelectOptions(String.valueOf(c.get(Calendar.YEAR)));
        String monthSelectOptions = DateTimeHelper.getMonthSelectOptions(String.valueOf(c.get(Calendar.MONTH) + 1));
        model.addAttribute("yearOptions", yearSelectOptions);
        model.addAttribute("monthOptions", monthSelectOptions);
        model.addAttribute("code", code);
        //当前科室的名称
        getDefineNameByCode(code, model);

        return "view/report/reportMonth/count";
    }

    /**
     * 根据所选年月判断是否存在
     *
     * @param year  。
     * @param month 。
     * @param code  。
     * @param model 。
     * @return 。
     */
    @RequestMapping
    public String ajaxYearMonth(String year, String month, String code, Model model) {
        String msg;
        //根据年月查询是否已经存在
        String hql = "from ReportMonth where 1=1 ";
        if (!StringHelper.isEmpty(year)) {
            hql += " and year=" + Integer.parseInt(year);
        }
        if (!StringHelper.isEmpty(month)) {
            hql += " and month=" + Integer.parseInt(month);
        }
        if (!StringHelper.isEmpty(code)) {
            hql += " and reportDeptDefine.code='" + code + "'";
        }
        List<ReportMonth> list = reportMonthService.findByQuery(hql);
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != list && list.size() > 0) {
            ReportMonth reportMonth = list.iterator().next();
            map.put("id", reportMonth.getId());
            map.put("success", true);
        } else {
            map.put("year", year);
            map.put("month", month);
            map.put("success", false);
        }
        msg = JSONObject.fromObject(map).toString();

        model.addAttribute("msg", msg);

        return "common/msg";
    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @param year  .
     * @param month .
     * @param code  .
     * @return .
     */
    @RequestMapping
    public String add(Model model, String year, String month, String code) {
        ReportMonth reportMonth = new ReportMonth();
        //获取当前有效版本数据
        ReportStructureVer structureVer = reportMonthManager.getReportStructureVer();
        if (null != structureVer) {
            reportMonth.setVersion(structureVer);
        }
        //根据CODE获取综合报表单位权限
        ReportDeptDefine define = reportMonthManager.getReportDeptDefineByCode(code);
        reportMonth.setReportDeptDefine(define);
        reportMonth.setYear(Integer.valueOf(year));
        reportMonth.setMonth(Integer.valueOf(month));
        reportMonth.setReportPerson(sysUserManager.getSysUser().getDisplayName());
        //获取报表数据
        List<Map<String, Object>> mapList = reportMonthManager.getReportStructureMapList(reportMonth, code);
        model.addAttribute("list", mapList);

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", reportMonth);
        model.addAttribute("reportTime", year + "年" + month + "月");

        return "view/report/reportMonth/input";
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
        ReportMonth reportMonth = reportMonthService.get(id);
        //获取报表数据
        List<Map<String, Object>> mapList = reportMonthManager.getReportStructureMapList(reportMonth, reportMonth.getReportDeptDefine().getCode());
        model.addAttribute("list", mapList);
        //处理其他业务逻辑
        model.addAttribute("bean", reportMonth);
        model.addAttribute("reportTime", reportMonth.getYear() + "年" + reportMonth.getMonth() + "月");

        return "view/report/reportMonth/input";
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
        ReportMonth reportMonth = reportMonthService.get(id);
        //获取报表数据
        List<Map<String, Object>> mapList = reportMonthManager.getReportStructureMapList(reportMonth, reportMonth.getReportDeptDefine().getCode());
        model.addAttribute("list", mapList);

        model.addAttribute("bean", reportMonth);
        model.addAttribute("reportTime", reportMonth.getYear() + "年" + reportMonth.getMonth() + "月");

        return "view/report/reportMonth/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") ReportMonth entity, HttpServletRequest request) throws Exception {
        try {
            ReportMonth target;
            if (entity.getId() != null) {
                target = reportMonthService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "year",
                        "month",
                        "reportPerson",
                        "reportDate",
                        "isValid"
                });

            } else {
                target = entity;
            }
            //综合报表单位权限定义
            String defineId = request.getParameter("defineId");
            if (!StringHelper.isEmpty(defineId)) {
                ReportDeptDefine define = reportDeptDefineService.get(Long.valueOf(defineId));
                target.setReportDeptDefine(define);
            }
            //有效地版本数据
            String versionId = request.getParameter("versionId");
            if (!StringHelper.isEmpty(versionId)) {
                ReportStructureVer structureVer = reportStructureVerService.get(Long.valueOf(versionId));
                target.setVersion(structureVer);
            }
            target.setReportDate(new Date(System.currentTimeMillis()));
            target.setIsValid(true);
            reportMonthService.save(target);

            //保存明细表
            //获取第二层数据的ID
            String[] item2Ids = request.getParameterValues("item2Id");
            if (null != item2Ids && item2Ids.length > 0) {
                for (String item2Id : item2Ids) {
                    ReportStructure item2 = reportStructureService.get(Long.valueOf(item2Id));
                    ReportMonthDetail detail = dealDetail(target, item2, request);
                    reportMonthDetailService.save(detail);
                }
            }
            //获取第三层数据的ID
            String[] item3Ids = request.getParameterValues("item3Id");
            if (null != item3Ids && item3Ids.length > 0) {
                for (String item3Id : item3Ids) {
                    ReportStructure item3 = reportStructureService.get(Long.valueOf(item3Id));
                    ReportMonthDetail detail = dealDetail(target, item3, request);
                    reportMonthDetailService.save(detail);
                }
            }

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 处理详细信息
     *
     * @param reportMonth     。
     * @param reportStructure 。
     * @param request         。
     * @return 。
     */
    private ReportMonthDetail dealDetail(ReportMonth reportMonth, ReportStructure reportStructure, HttpServletRequest request) {
        Long reportStructureId = reportStructure.getId();
        String monthValue = request.getParameter("monthValue" + reportStructureId);
        String accuValue = request.getParameter("accuValue" + reportStructureId);
        String percentHb = request.getParameter("percentHb" + reportStructureId);
        String percentTb = request.getParameter("percentTb" + reportStructureId);
        String description = request.getParameter("description" + reportStructureId);
        ReportMonthDetail detail = reportMonthManager.getReportMonthDetail(reportMonth, reportStructure);
        if (null == detail) {
            detail = new ReportMonthDetail();
            detail.setReportMonth(reportMonth);
            detail.setReportStructure(reportStructure);
            if (!StringHelper.isEmpty(monthValue)) {
                detail.setMonthValue(Double.valueOf(monthValue));
            }
            if (!StringHelper.isEmpty(accuValue)) {
                detail.setAccuValue(Double.valueOf(accuValue));
            }
            if (!StringHelper.isEmpty(percentHb)) {
                detail.setPercentHb(Double.valueOf(percentHb));
            }
            if (!StringHelper.isEmpty(percentTb)) {
                detail.setPercentTb(Double.valueOf(percentTb));
            }
            if (!StringHelper.isEmpty(description)) {
                detail.setDescription(description);
            }
        } else {
            if (!StringHelper.isEmpty(monthValue)) {
                detail.setMonthValue(Double.valueOf(monthValue));
            }
            if (!StringHelper.isEmpty(accuValue)) {
                detail.setAccuValue(Double.valueOf(accuValue));
            }
            if (!StringHelper.isEmpty(percentHb)) {
                String percentHb1 = percentHb.substring(0, percentHb.length() - 1);
                detail.setPercentHb(Double.valueOf(percentHb1));
            }
            if (!StringHelper.isEmpty(percentTb)) {
                String percentTb1 = percentTb.substring(0, percentTb.length() - 1);
                detail.setPercentTb(Double.valueOf(percentTb1));
            }
            if (!StringHelper.isEmpty(description)) {
                detail.setDescription(description);
            }
        }

        return detail;
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
        ReportMonth reportMonth = reportMonthService.get(id);
        //先删除字表数据
        Set<ReportMonthDetail> reportMonthDetails = reportMonth.getReportMonthDetails();
        for (ReportMonthDetail detail : reportMonthDetails) {
            reportMonthDetailService.delete(detail);
        }
        reportMonthService.delete(reportMonth);

        sendSuccessJSON(response, "删除成功");
    }

}