package com.justonetech.biz.controller.query;

import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.ProjExtendCostType;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.manager.ExcelPrintManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目推进汇总
 * User: gq
 * Date: 15-8-24
 */
@Controller
public class ProjectQueryProjectController {

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private ProjInfoService projInfoService;

    @Autowired
    private ProjExtendCostService projExtendCostService;

    @Autowired
    private ProjExtendScheduleService projExtendScheduleService;

    @Autowired
    private ProjBidService projBidService;

    @Autowired
    private ProjStageService projStageService;

    @Autowired
    private DataStageReportItemService dataStageReportItemService;

    @Autowired
    private DataStageReportDocService dataStageReportDocService;

    @Autowired
    private ExcelPrintManager excelPrintManager;

    private static final String xlsTemplateName = "DataProjectReport.xls";

    /**
     * 查看项目推进信息
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String viewProject(Model model, Long id) {
        model.addAttribute("id", id);
        Calendar c = Calendar.getInstance();
        model.addAttribute("yearOptions", DateTimeHelper.getYearSelectOptions(String.valueOf(c.get(Calendar.YEAR))));
        model.addAttribute("currentYear", c.get(Calendar.YEAR));
        model.addAttribute("PROJ_INFO_CATEGORY", Constants.PROJ_INFO_CATEGORY);
        model.addAttribute("PROJ_INFO_BELONG_AREA", Constants.PROJ_INFO_BELONG_AREA);
        model.addAttribute("PROJ_INFO_PROPERTY", Constants.PROJ_INFO_PROPERTY);

        return "view/query/projectQueryProject/viewProject";
    }

    /**
     * 查看项目推进信息--获取数据
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String viewProjectData(Model model, HttpServletRequest request) {
        String projectName = request.getParameter("projectName");
        String jsDept = request.getParameter("jsDept");
        String year = request.getParameter("year");
        String propertyId = request.getParameter("propertyId");
        String isMajor = request.getParameter("isMajor");
        String categoryId = request.getParameter("categoryId");
        String areaId = request.getParameter("areaId");
        model.addAttribute("year", year);

        //标段列表
        String conditionHql = "from ProjInfo where 1=1";
        if (!StringHelper.isEmpty(projectName)) {
            conditionHql += " and name like '%" + projectName + "%'";
        }
        if (!StringHelper.isEmpty(jsDept)) {
            conditionHql += " and jsDept like '%" + jsDept + "%'";
        }
        if (!StringHelper.isEmpty(year)) {
            conditionHql += " and year='" + year + "'";
        }
        if (!StringHelper.isEmpty(propertyId)) {
            conditionHql += " and property.id=" + propertyId;
        }
        if (!StringHelper.isEmpty(isMajor)) {
            conditionHql += " and isMajor=" + isMajor;
        }
        if (!StringHelper.isEmpty(categoryId)) {
            conditionHql += " and category.id=" + categoryId;
        }
        if (!StringHelper.isEmpty(areaId)) {
            conditionHql += " and areaCode='" + sysCodeManager.getCodeListById(Long.valueOf(areaId)).getCode() + "'";
        }
        List<ProjInfo> projInfos = projInfoService.findByQuery(conditionHql + " order by no asc,id asc");
        model.addAttribute("projects", projInfos);

        //用于数据过滤
        conditionHql = "select id " + conditionHql;
//        System.out.println("conditionHql = " + conditionHql);
        //工程投资情况
        String hqlCost = "from ProjExtendCost where projExtend.project.id in (" + conditionHql + ")";
//        System.out.println("hqlCost = " + hqlCost);
        List<ProjExtendCost> costList = projExtendCostService.findByQuery(hqlCost);

        Calendar c = Calendar.getInstance();
        String key1 = (JspHelper.getInteger(year) - 1) + "_" + ProjExtendCostType.EXTEND_TYPE_1.getCode();
        String key2 = year + "_" + ProjExtendCostType.EXTEND_TYPE_2.getCode();
        String key3_1 = year + "sbn" + "_" + ProjExtendCostType.EXTEND_TYPE_3.getCode();
        String key3_2 = year + "qn" + "_" + ProjExtendCostType.EXTEND_TYPE_3.getCode();
        String key4 = year + "_" + (c.get(Calendar.MONTH) + 1) + "_" + ProjExtendCostType.EXTEND_TYPE_4.getCode();
        model.addAttribute("key1", key1);
        model.addAttribute("key2", key2);
        model.addAttribute("key3_1", key3_1);
        model.addAttribute("key3_2", key3_2);
        model.addAttribute("key4", key4);
        //填报数据
        Map<String, Object> dataMap = new HashMap<String, Object>();
        if (null != costList && costList.size() > 0) {
            for (ProjExtendCost cost : costList) {
                ProjExtend projExtend = cost.getProjExtend();
                Long projectId = projExtend.getProject().getId();
                dataMap.put(projectId + "cs", projExtend.getGctxCspfTotal());
                dataMap.put(projectId + "gk", projExtend.getGctxGkpfTotal());
                dataMap.put(projectId + "zjly", projExtend.getGctxSourceFund());
                List<ProjExtendCost> type1 = getCostByType(ProjExtendCostType.EXTEND_TYPE_1.getCode(), projExtend.getId());
                if (null != type1 && type1.size() > 0) {
                    dataMap.put(projectId + key1, type1.iterator().next().getAccComplete());
                } else {
                    dataMap.put(projectId + key1, "");
                }

                List<ProjExtendCost> type2 = getCostByType(ProjExtendCostType.EXTEND_TYPE_2.getCode(), projExtend.getId());
                if (null != type2 && type2.size() > 0) {
                    dataMap.put(projectId + key2, type2.iterator().next().getAccComplete());
                } else {
                    dataMap.put(projectId + key2, "");
                }

                List<ProjExtendCost> type3_1 = getCostByType(ProjExtendCostType.EXTEND_TYPE_3.getCode(), projExtend.getId());
                if (null != type3_1 && type3_1.size() > 0) {
                    dataMap.put(projectId + key3_1, type3_1.iterator().next().getAccComplete());
                } else {
                    dataMap.put(projectId + key3_1, "");
                }

                List<ProjExtendCost> type3_2 = getCostByType(ProjExtendCostType.EXTEND_TYPE_3.getCode(), projExtend.getId());
                if (null != type3_2 && type3_2.size() > 0) {
                    dataMap.put(projectId + key3_2, type3_2.iterator().next().getAccComplete());
                } else {
                    dataMap.put(projectId + key3_2, "");
                }
                dataMap.put(projectId + "cb", projExtend.getPlanCbsjTime());
                dataMap.put(projectId + "gk", projExtend.getPlanGkTime());
                dataMap.put(projectId + "xm", projExtend.getPlanXmjysTime());
                dataMap.put(projectId + "beginTime", projExtend.getGcjsBeginTime());
                dataMap.put(projectId + "endTime", projExtend.getGcjsEndTime());
                dataMap.put(projectId + "area", projExtend.getProject().getAreaCode());
                List<ProjExtendSchedule> scheduleList = projExtendScheduleService.findByQuery("from ProjExtendSchedule where projExtend.id=" + projExtend.getId() + "  order by year ,month desc");
                if (null != scheduleList && scheduleList.size() > 0) {
                    dataMap.put(projectId + "progress", scheduleList.iterator().next().getProjProgress());
                    dataMap.put(projectId + "question", scheduleList.iterator().next().getQuestion());
                    dataMap.put(projectId + "opinion", scheduleList.iterator().next().getImproveOpinion());
                }
            }
        }
        model.addAttribute("dataMap", dataMap);

        return "view/query/projectQueryProject/viewProjectData";
    }

    /**
     * 导出excel
     *
     * @param response .
     * @throws Exception .
     */
    @RequestMapping
    public void printExcel(HttpServletResponse response, HttpServletRequest request) throws Exception {
        //把打印的数据压入map中
        Map<String, Object> beans = new HashMap<String, Object>();
        String fileName = "年度项目推进汇总表.xls";

        String projectName = request.getParameter("projectName");
        String jsDept = request.getParameter("jsDept");
        String year = request.getParameter("year");
        String propertyId = request.getParameter("propertyId");
        String isMajor = request.getParameter("isMajor");
        String categoryId = request.getParameter("categoryId");
        String areaId = request.getParameter("areaId");
        beans.put("year", year);

        //标段列表
        String conditionHql = "from ProjInfo where 1=1";
        if (!StringHelper.isEmpty(projectName)) {
            conditionHql += " and name like '%" + projectName + "%'";
        }
        if (!StringHelper.isEmpty(jsDept)) {
            conditionHql += " and jsDept like '%" + jsDept + "%'";
        }
        if (!StringHelper.isEmpty(year)) {
            conditionHql += " and year='" + year + "'";
        }
        if (!StringHelper.isEmpty(propertyId)) {
            conditionHql += " and property.id=" + propertyId;
        }
        if (!StringHelper.isEmpty(isMajor)) {
            conditionHql += " and isMajor=" + isMajor;
        }
        if (!StringHelper.isEmpty(categoryId)) {
            conditionHql += " and category.id=" + categoryId;
        }
        if (!StringHelper.isEmpty(areaId)) {
            System.out.println("sysCodeManager.getCodeListById(Long.valueOf(areaId)).getCode()\\ = " + sysCodeManager.getCodeListById(Long.valueOf(areaId)).getCode());
            conditionHql += " and areaCode='" + sysCodeManager.getCodeListById(Long.valueOf(areaId)).getCode() + "'";
        }
        System.out.println("conditionHql = " + conditionHql);
        List<ProjInfo> projInfos = projInfoService.findByQuery(conditionHql + " order by no asc,id asc");

        //用于数据过滤
        conditionHql = "select id " + conditionHql;
        Map<String, Object> mergeMap = new HashMap<String, Object>();

        excelPrintManager.printExcel(response, request, DataStageReport.class.getSimpleName(), xlsTemplateName, beans, fileName, mergeMap);
    }

    /**
     * 根据类型和项目扩展表获取数据
     *
     * @param type     。
     * @param extendId 。
     * @return 。
     */
    public List<ProjExtendCost> getCostByType(String type, Long extendId) {
        String hql = "from ProjExtendCost where projExtend.id=? and type=? order by year asc,month asc,half desc";
        return projExtendCostService.findByQuery(hql, extendId, type);
    }
}
