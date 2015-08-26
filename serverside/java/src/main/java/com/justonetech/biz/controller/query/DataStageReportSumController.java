package com.justonetech.biz.controller.query;

import com.justonetech.biz.daoservice.DataStageReportItemService;
import com.justonetech.biz.daoservice.ProjInfoService;
import com.justonetech.biz.domain.DataStageReportItem;
import com.justonetech.biz.domain.ProjBid;
import com.justonetech.biz.domain.ProjInfo;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.MathHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * 项目推进主要证照完成情况汇总
 * User: gq
 * Date: 15-8-4
 */
@Controller
public class DataStageReportSumController {

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ProjInfoService projInfoService;

    @Autowired
    private DataStageReportItemService dataStageReportItemService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        model.addAttribute("canView", sysUserManager.hasPrivilege(PrivilegeCode.DATA_STAGE_REPORT_SUM));
        //设置年 月
        Calendar cal = Calendar.getInstance();  //获取当前时间
        String yearSelectOptions = DateTimeHelper.getYearSelectOptions(JspHelper.getString(cal.get(Calendar.YEAR)));
        String monthSelectOptions = DateTimeHelper.getMonthSelectOptions(JspHelper.getString(cal.get(Calendar.MONTH) + 1));

        model.addAttribute("yearSelectOptions", yearSelectOptions);
        model.addAttribute("monthSelectOptions", monthSelectOptions);

        return "view/query/dataStageReportSum/grid";
    }


    /**
     * 根据所选年月和项目汇总数据
     *
     * @param model 。
     * @return 。
     */
    @RequestMapping
    public String sumData(Model model, String year, String month, String prjInfoIds) {
        model.addAttribute("PSOpinions", Constants.PROJ_STAGE_PSOPINIONS);//规划选址意见书
        model.addAttribute("Reply4Workers", Constants.PROJ_STAGE_REPLY4WORKERS);//工可批复
        model.addAttribute("PreDesign", Constants.PROJ_STAGE_PREDESIGN);//初步设计
        model.addAttribute("LandUsePlanning", Constants.PROJ_STAGE_LANDUSERPLANNING);//用地规划许可证
        model.addAttribute("LandUseApproval", Constants.PROJ_STAGE_LANDUSERAPPROVAL);//用地批准书
        model.addAttribute("EngineerPlanningPermit", Constants.PROJ_STAGE_ENGINEERPLANNINGPERMIT);//工程规划许可证
        model.addAttribute("ConstructionPermits", Constants.PROJ_STAGE_CONSTRUCTIONPERMITS);//施工许可证

        model.addAttribute("year", year);
        model.addAttribute("month", month);
        List<ProjInfo> projList = new ArrayList<ProjInfo>();
        if (!StringHelper.isEmpty(prjInfoIds)) {
            String[] projIds = prjInfoIds.split(",");
            for (String projId : projIds) {
                ProjInfo projInfo = projInfoService.get(Long.valueOf(projId));
                projList.add(projInfo);
            }
        }
        List<ProjBid> bidList = new ArrayList<ProjBid>();
        if (null != projList && projList.size() > 0) {
            for (ProjInfo projInfo : projList) {
                Set<ProjBid> projBids = projInfo.getProjBids();
                for (ProjBid projBid : projBids) {
                    bidList.add(projBid);
                }
            }
        }
        String bidIds = "";
        if (null != bidList && bidList.size() > 0) {
            for (ProjBid projBid : bidList) {
                bidIds += "," + projBid.getId();
            }
        }
        if (!StringHelper.isEmpty(bidIds)) {
            bidIds = bidIds.substring(1);
        }
        List<SysCodeDetail> categorys = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_CATEGORY);
        List<SysCodeDetail> list = new ArrayList<SysCodeDetail>();
        for (SysCodeDetail category : categorys) {
            if (category.getCode().equals("3") || category.getCode().equals("4") || category.getCode().equals("6")) {
                list.add(category);
            }
        }
        model.addAttribute("categorys", list);
        //定义汇总用的数量属性
        Integer totalPlanXZ = 0;
        Integer totalPlanGK = 0;
        Integer totalPlanCB = 0;
        Integer totalPlanYDGH = 0;
        Integer totalPlanYDPZ = 0;
        Integer totalPlanGC = 0;
        Integer totalPlanSG = 0;
        Integer yearPlanXZ = 0;
        Integer yearPlanGK = 0;
        Integer yearPlanCB = 0;
        Integer yearPlanYDGH = 0;
        Integer yearPlanYDPZ = 0;
        Integer yearPlanGC = 0;
        Integer yearPlanSG = 0;
        Integer monthPlanXZ = 0;
        Integer monthPlanGK = 0;
        Integer monthPlanCB = 0;
        Integer monthPlanYDGH = 0;
        Integer monthPlanYDPZ = 0;
        Integer monthPlanGC = 0;
        Integer monthPlanSG = 0;
        Integer accPlanXZ = 0;
        Integer accPlanGK = 0;
        Integer accPlanCB = 0;
        Integer accPlanYDGH = 0;
        Integer accPlanYDPZ = 0;
        Integer accPlanGC = 0;
        Integer accPlanSG = 0;
        //封装数据
        Map<String, Object> map = new HashMap<String, Object>();
        for (SysCodeDetail category : list) {
            String code = category.getCode();
            Long categoryId = category.getId();
            //选址意见书
            Integer totalXZ = getProjectNum(prjInfoIds, Constants.PROJ_STAGE_PSOPINIONS, categoryId, null, null, null);
            totalPlanXZ += totalXZ;
            map.put("total_" + Constants.PROJ_STAGE_PSOPINIONS + "_" + code, JspHelper.getInteger(totalXZ));
            Integer yearXZ = getProjectNum(prjInfoIds, Constants.PROJ_STAGE_PSOPINIONS, categoryId, Integer.valueOf(year), null, null);
            yearPlanXZ += yearXZ;
            map.put("year_" + Constants.PROJ_STAGE_PSOPINIONS + "_" + code, JspHelper.getInteger(yearXZ));
            Integer monthXZ = getProjectNum(prjInfoIds, Constants.PROJ_STAGE_PSOPINIONS, categoryId, Integer.valueOf(year), Integer.valueOf(month), null);
            monthPlanXZ += monthXZ;
            map.put("month_" + Constants.PROJ_STAGE_PSOPINIONS + "_" + code, JspHelper.getInteger(monthXZ));
            Integer accXZ = getProjectNum(prjInfoIds, Constants.PROJ_STAGE_PSOPINIONS, categoryId, Integer.valueOf(year), Integer.valueOf(month), "acc");
            accPlanXZ += accXZ;
            map.put("acc_" + Constants.PROJ_STAGE_PSOPINIONS + "_" + code, JspHelper.getInteger(accXZ));
            if (null == yearXZ || 0 == yearXZ) {
                map.put("per_" + Constants.PROJ_STAGE_PSOPINIONS + "_" + code, 0);
            } else {
                double perXZ = MathHelper.roundDouble(accXZ * 100 / yearXZ, 0);
                map.put("per_" + Constants.PROJ_STAGE_PSOPINIONS + "_" + code, perXZ);
            }
            //工可批复
            Integer totalGK = getProjectNum(prjInfoIds, Constants.PROJ_STAGE_REPLY4WORKERS, categoryId, null, null, null);
            totalPlanGK += totalGK;
            map.put("total_" + Constants.PROJ_STAGE_REPLY4WORKERS + "_" + code, JspHelper.getInteger(totalGK));
            Integer yearGK = getProjectNum(prjInfoIds, Constants.PROJ_STAGE_REPLY4WORKERS, categoryId, Integer.valueOf(year), null, null);
            yearPlanGK += yearGK;
            map.put("year_" + Constants.PROJ_STAGE_REPLY4WORKERS + "_" + code, JspHelper.getInteger(yearGK));
            Integer monthGK = getProjectNum(prjInfoIds, Constants.PROJ_STAGE_REPLY4WORKERS, categoryId, Integer.valueOf(year), Integer.valueOf(month), null);
            monthPlanGK += monthGK;
            map.put("month_" + Constants.PROJ_STAGE_REPLY4WORKERS + "_" + code, JspHelper.getInteger(monthGK));
            Integer accGK = getProjectNum(prjInfoIds, Constants.PROJ_STAGE_REPLY4WORKERS, categoryId, Integer.valueOf(year), Integer.valueOf(month), "acc");
            accPlanGK += accGK;
            map.put("acc_" + Constants.PROJ_STAGE_REPLY4WORKERS + "_" + code, JspHelper.getInteger(accGK));
            if (null == yearGK || 0 == yearGK) {
                map.put("per_" + Constants.PROJ_STAGE_REPLY4WORKERS + "_" + code, 0);
            } else {
                double perGK = MathHelper.roundDouble(accGK * 100 / yearGK, 0);
                map.put("per_" + Constants.PROJ_STAGE_REPLY4WORKERS + "_" + code, perGK);
            }
            //初步设计
            Integer totalCB = getProjectNum(prjInfoIds, Constants.PROJ_STAGE_PREDESIGN, categoryId, null, null, null);
            totalPlanCB += totalCB;
            map.put("total_" + Constants.PROJ_STAGE_PREDESIGN + "_" + code, JspHelper.getInteger(totalCB));
            Integer yearCB = getProjectNum(prjInfoIds, Constants.PROJ_STAGE_PREDESIGN, categoryId, Integer.valueOf(year), null, null);
            yearPlanCB += yearCB;
            map.put("year_" + Constants.PROJ_STAGE_PREDESIGN + "_" + code, JspHelper.getInteger(yearCB));
            Integer monthCB = getProjectNum(prjInfoIds, Constants.PROJ_STAGE_PREDESIGN, categoryId, Integer.valueOf(year), Integer.valueOf(month), null);
            monthPlanCB += monthCB;
            map.put("month_" + Constants.PROJ_STAGE_PREDESIGN + "_" + code, JspHelper.getInteger(monthCB));
            Integer accCB = getProjectNum(prjInfoIds, Constants.PROJ_STAGE_PREDESIGN, categoryId, Integer.valueOf(year), Integer.valueOf(month), "acc");
            accPlanCB += accCB;
            map.put("acc_" + Constants.PROJ_STAGE_PREDESIGN + "_" + code, JspHelper.getInteger(accCB));
            if (null == yearCB || 0 == yearCB) {
                map.put("per_" + Constants.PROJ_STAGE_PREDESIGN + "_" + code, 0);
            } else {
                double perCB = MathHelper.roundDouble(accCB * 100 / yearCB, 0);
                map.put("per_" + Constants.PROJ_STAGE_PREDESIGN + "_" + code, perCB);
            }
            //用地规划许可证
            Integer totalYDGH = getBidNum(bidIds, Constants.PROJ_STAGE_LANDUSERPLANNING, categoryId, null, null, null);
            totalPlanYDGH += totalYDGH;
            map.put("total_" + Constants.PROJ_STAGE_LANDUSERPLANNING + "_" + code, JspHelper.getInteger(totalYDGH));
            Integer yearYDGH = getProjectNum(bidIds, Constants.PROJ_STAGE_LANDUSERPLANNING, categoryId, Integer.valueOf(year), null, null);
            yearPlanYDGH += yearYDGH;
            map.put("year_" + Constants.PROJ_STAGE_LANDUSERPLANNING + "_" + code, JspHelper.getInteger(yearYDGH));
            Integer monthYDGH = getProjectNum(bidIds, Constants.PROJ_STAGE_LANDUSERPLANNING, categoryId, Integer.valueOf(year), Integer.valueOf(month), null);
            monthPlanYDGH += monthYDGH;
            map.put("month_" + Constants.PROJ_STAGE_LANDUSERPLANNING + "_" + code, JspHelper.getInteger(monthYDGH));
            Integer accYDGH = getProjectNum(bidIds, Constants.PROJ_STAGE_LANDUSERPLANNING, categoryId, Integer.valueOf(year), Integer.valueOf(month), "acc");
            accPlanYDGH += accYDGH;
            map.put("acc_" + Constants.PROJ_STAGE_LANDUSERPLANNING + "_" + code, JspHelper.getInteger(accYDGH));
            if (null == yearYDGH || 0 == yearYDGH) {
                map.put("per_" + Constants.PROJ_STAGE_LANDUSERPLANNING + "_" + code, 0);
            } else {
                double perYDGH = MathHelper.roundDouble(accYDGH * 100 / yearYDGH, 0);
                map.put("per_" + Constants.PROJ_STAGE_LANDUSERPLANNING + "_" + code, perYDGH);
            }
            //用地批准书
            Integer totalYDPZ = getBidNum(bidIds, Constants.PROJ_STAGE_LANDUSERAPPROVAL, categoryId, null, null, null);
            totalPlanYDPZ += totalYDPZ;
            map.put("total_" + Constants.PROJ_STAGE_LANDUSERAPPROVAL + "_" + code, JspHelper.getInteger(totalYDPZ));
            Integer yearYDPZ = getBidNum(bidIds, Constants.PROJ_STAGE_LANDUSERAPPROVAL, categoryId, Integer.valueOf(year), null, null);
            yearPlanYDPZ += yearYDPZ;
            map.put("year_" + Constants.PROJ_STAGE_LANDUSERAPPROVAL + "_" + code, JspHelper.getInteger(yearYDPZ));
            Integer monthYDPZ = getBidNum(bidIds, Constants.PROJ_STAGE_LANDUSERAPPROVAL, categoryId, Integer.valueOf(year), Integer.valueOf(month), null);
            monthPlanYDPZ += monthYDPZ;
            map.put("month_" + Constants.PROJ_STAGE_LANDUSERAPPROVAL + "_" + code, JspHelper.getInteger(monthYDPZ));
            Integer accYDPZ = getBidNum(bidIds, Constants.PROJ_STAGE_LANDUSERAPPROVAL, categoryId, Integer.valueOf(year), Integer.valueOf(month), "acc");
            accPlanYDPZ += accYDPZ;
            map.put("acc_" + Constants.PROJ_STAGE_LANDUSERAPPROVAL + "_" + code, JspHelper.getInteger(accYDPZ));
            if (null == yearYDPZ || 0 == yearYDPZ) {
                map.put("per_" + Constants.PROJ_STAGE_LANDUSERAPPROVAL + "_" + code, 0);
            } else {
                double perYDPZ = MathHelper.roundDouble(accYDPZ * 100 / yearYDPZ, 0);
                map.put("per_" + Constants.PROJ_STAGE_LANDUSERAPPROVAL + "_" + code, perYDPZ);
            }
            //工程规划许可证
            Integer totalGC = getBidNum(bidIds, Constants.PROJ_STAGE_ENGINEERPLANNINGPERMIT, categoryId, null, null, null);
            totalPlanGC += totalGC;
            map.put("total_" + Constants.PROJ_STAGE_ENGINEERPLANNINGPERMIT + "_" + code, JspHelper.getInteger(totalGC));
            Integer yearGC = getBidNum(bidIds, Constants.PROJ_STAGE_ENGINEERPLANNINGPERMIT, categoryId, Integer.valueOf(year), null, null);
            yearPlanGC += yearGC;
            map.put("year_" + Constants.PROJ_STAGE_ENGINEERPLANNINGPERMIT + "_" + code, JspHelper.getInteger(yearGC));
            Integer monthGC = getBidNum(bidIds, Constants.PROJ_STAGE_ENGINEERPLANNINGPERMIT, categoryId, Integer.valueOf(year), Integer.valueOf(month), null);
            monthPlanGC += monthGC;
            map.put("month_" + Constants.PROJ_STAGE_ENGINEERPLANNINGPERMIT + "_" + code, JspHelper.getInteger(monthGC));
            Integer accGC = getBidNum(bidIds, Constants.PROJ_STAGE_ENGINEERPLANNINGPERMIT, categoryId, Integer.valueOf(year), Integer.valueOf(month), "acc");
            accPlanGC += accGC;
            map.put("acc_" + Constants.PROJ_STAGE_ENGINEERPLANNINGPERMIT + "_" + code, JspHelper.getInteger(accGC));
            if (null == yearGC || 0 == yearGC) {
                map.put("per_" + Constants.PROJ_STAGE_ENGINEERPLANNINGPERMIT + "_" + code, 0);
            } else {
                double perGC = MathHelper.roundDouble(accGC * 100 / yearGC, 0);
                map.put("per_" + Constants.PROJ_STAGE_ENGINEERPLANNINGPERMIT + "_" + code, perGC);
            }
            //施工许可证
            Integer totalSG = getBidNum(bidIds, Constants.PROJ_STAGE_CONSTRUCTIONPERMITS, categoryId, null, null, null);
            totalPlanSG += totalSG;
            map.put("total_" + Constants.PROJ_STAGE_CONSTRUCTIONPERMITS + "_" + code, JspHelper.getInteger(totalSG));
            Integer yearSG = getBidNum(bidIds, Constants.PROJ_STAGE_CONSTRUCTIONPERMITS, categoryId, Integer.valueOf(year), null, null);
            yearPlanSG += yearSG;
            map.put("year_" + Constants.PROJ_STAGE_CONSTRUCTIONPERMITS + "_" + code, JspHelper.getInteger(yearSG));
            Integer monthSG = getBidNum(bidIds, Constants.PROJ_STAGE_CONSTRUCTIONPERMITS, categoryId, Integer.valueOf(year), Integer.valueOf(month), null);
            monthPlanSG += monthSG;
            map.put("month_" + Constants.PROJ_STAGE_CONSTRUCTIONPERMITS + "_" + code, JspHelper.getInteger(monthSG));
            Integer accSG = getBidNum(bidIds, Constants.PROJ_STAGE_CONSTRUCTIONPERMITS, categoryId, Integer.valueOf(year), Integer.valueOf(month), "acc");
            accPlanSG += accSG;
            map.put("acc_" + Constants.PROJ_STAGE_CONSTRUCTIONPERMITS + "_" + code, JspHelper.getInteger(accSG));
            if (null == yearSG || 0 == yearSG) {
                map.put("per_" + Constants.PROJ_STAGE_CONSTRUCTIONPERMITS + "_" + code, 0);
            } else {
                double perSG = MathHelper.roundDouble(accSG * 100 / yearSG, 0);
                map.put("per_" + Constants.PROJ_STAGE_CONSTRUCTIONPERMITS + "_" + code, perSG);
            }
        }
        model.addAttribute("map", map);
        model.addAttribute("totalPlanXZ", totalPlanXZ);
        model.addAttribute("totalPlanGK", totalPlanGK);
        model.addAttribute("totalPlanCB", totalPlanCB);
        model.addAttribute("totalPlanYDGH", totalPlanYDGH);
        model.addAttribute("totalPlanYDPZ", totalPlanYDPZ);
        model.addAttribute("totalPlanGC", totalPlanGC);
        model.addAttribute("totalPlanSG", totalPlanSG);

        model.addAttribute("yearPlanXZ", yearPlanXZ);
        model.addAttribute("yearPlanGK", yearPlanGK);
        model.addAttribute("yearPlanCB", yearPlanCB);
        model.addAttribute("yearPlanYDGH", yearPlanYDGH);
        model.addAttribute("yearPlanYDPZ", yearPlanYDPZ);
        model.addAttribute("yearPlanGC", yearPlanGC);
        model.addAttribute("yearPlanSG", yearPlanSG);

        model.addAttribute("monthPlanXZ", monthPlanXZ);
        model.addAttribute("monthPlanGK", monthPlanGK);
        model.addAttribute("monthPlanCB", monthPlanCB);
        model.addAttribute("monthPlanYDGH", monthPlanYDGH);
        model.addAttribute("monthPlanYDPZ", monthPlanYDPZ);
        model.addAttribute("monthPlanGC", monthPlanGC);
        model.addAttribute("monthPlanSG", monthPlanSG);

        model.addAttribute("accPlanXZ", accPlanXZ);
        model.addAttribute("accPlanGK", accPlanGK);
        model.addAttribute("accPlanCB", accPlanCB);
        model.addAttribute("accPlanYDGH", accPlanYDGH);
        model.addAttribute("accPlanYDPZ", accPlanYDPZ);
        model.addAttribute("accPlanGC", accPlanGC);
        model.addAttribute("accPlanSG", accPlanSG);

        if (null == yearPlanXZ || 0 == yearPlanXZ) {
            model.addAttribute("perXZ", 0);
        } else {
            double perPlanXZ = MathHelper.roundDouble(accPlanXZ * 100 / yearPlanXZ, 0);
            model.addAttribute("perXZ", perPlanXZ);
        }
        if (null == yearPlanGK || 0 == yearPlanGK) {
            model.addAttribute("perGK", 0);
        } else {
            double perPlanGK = MathHelper.roundDouble(accPlanGK * 100 / yearPlanGK, 0);
            model.addAttribute("perGK", perPlanGK);
        }
        if (null == yearPlanCB || 0 == yearPlanCB) {
            model.addAttribute("perCB", 0);
        } else {
            double perPlanCB = MathHelper.roundDouble(accPlanCB * 100 / yearPlanCB, 0);
            model.addAttribute("perCB", perPlanCB);
        }
        if (null == yearPlanYDGH || 0 == yearPlanYDGH) {
            model.addAttribute("perYDGH", 0);
        } else {
            double perPlanYDGH = MathHelper.roundDouble(accPlanYDGH * 100 / yearPlanYDGH, 0);
            model.addAttribute("perYDGH", perPlanYDGH);
        }
        if (null == yearPlanYDPZ || 0 == yearPlanYDPZ) {
            model.addAttribute("perYDPZ", 0);
        } else {
            double perPlanYDPZ = MathHelper.roundDouble(accPlanYDPZ * 100 / yearPlanYDPZ, 0);
            model.addAttribute("perYDPZ", perPlanYDPZ);
        }
        if (null == yearPlanGC || 0 == yearPlanGC) {
            model.addAttribute("perGC", 0);
        } else {
            double perPlanGC = MathHelper.roundDouble(accPlanGC * 100 / yearPlanGC, 0);
            model.addAttribute("perGC", perPlanGC);
        }
        if (null == yearPlanSG || 0 == yearPlanSG) {
            model.addAttribute("perSG", 0);
        } else {
            double perPlanSG = MathHelper.roundDouble(accPlanSG * 100 / yearPlanSG, 0);
            model.addAttribute("perSG", perPlanSG);
        }

        return "view/query/dataStageReportSum/sumData";
    }

    /**
     * 统计前项的数据
     *
     * @param code       项目办证阶段管理的code
     * @param categoryId 项目类型id
     * @param year       年
     * @param month      月
     * @param acc        是否是统计
     * @return 。
     */
    public Integer getProjectNum(String prjInfoIds, String code, Long categoryId, Integer year, Integer month, String acc) {
        SysCodeDetail plan = sysCodeManager.getCodeDetailByCode(Constants.DATA_STAGE_RESULT, Constants.DATA_STAGE_RESULT_1);
        SysCodeDetail complete = sysCodeManager.getCodeDetailByCode(Constants.DATA_STAGE_RESULT, Constants.DATA_STAGE_RESULT_3);
        List<SysCodeDetail> detailList = sysCodeManager.getCodeListByCode(Constants.DATA_STAGE_RESULT);
        String ids = "";
        for (SysCodeDetail detail : detailList) {
            ids += "," + detail.getId();
        }
        if (!StringHelper.isEmpty(ids)) {
            ids = ids.substring(1);
        }
        String hql = "from DataStageReportItem where stage.code='" + code + "' and stageReport.project.category.id=" + categoryId;
        if (!StringHelper.isEmpty(prjInfoIds)) {
            hql += " and stageReport.project.id in (" + prjInfoIds + ")";
        }
        if (null == year && null == month) {
            hql += " and result.id in (" + ids + ")";
        }
        if (null != year && null == month) {
            hql += " and stageReport.year=" + year + " and (result.id=" + plan.getId() + " or result.id=" + complete.getId() + ")";
        }
        if (null != year && null != month) {
            hql += " and stageReport.year=" + year + " and stageReport.month=" + month + " and result.id=" + complete.getId();
        }
        if (null != year && null != month && !StringHelper.isEmpty(acc)) {
            String months = "";
            for (int i = 1; i <= month; i++) {
                months += "," + i;
            }
            if (!StringHelper.isEmpty(months)) {
                months = months.substring(1);
            }
            hql += " and stageReport.year=" + year + " and stageReport.month in(" + months + ") and result.id=" + complete.getId();
        }
        List<DataStageReportItem> itemList = dataStageReportItemService.findByQuery(hql);

        Map<Long, DataStageReportItem> map = new HashMap<Long, DataStageReportItem>();
        for (DataStageReportItem reportItem : itemList) {
            ProjInfo project = reportItem.getStageReport().getProject();
            map.put(project.getId(), reportItem);
        }
        List<DataStageReportItem> itemListNew = new ArrayList<DataStageReportItem>();
        for (DataStageReportItem reportItem : map.values()) {
            itemListNew.add(reportItem);
        }
        return itemListNew.size();
    }

    /**
     * 根据标段汇总
     *
     * @param bidIds     标段id
     * @param categoryId 项目类型id
     * @param year       年
     * @param month      月
     * @param acc        是否是统计
     * @return 。
     */
    public Integer getBidNum(String bidIds, String code, Long categoryId, Integer year, Integer month, String acc) {
        SysCodeDetail plan = sysCodeManager.getCodeDetailByCode(Constants.DATA_STAGE_RESULT, Constants.DATA_STAGE_RESULT_1);
        SysCodeDetail complete = sysCodeManager.getCodeDetailByCode(Constants.DATA_STAGE_RESULT, Constants.DATA_STAGE_RESULT_3);
        List<SysCodeDetail> detailList = sysCodeManager.getCodeListByCode(Constants.DATA_STAGE_RESULT);
        String ids = "";
        for (SysCodeDetail detail : detailList) {
            ids += "," + detail.getId();
        }
        if (!StringHelper.isEmpty(ids)) {
            ids = ids.substring(1);
        }
        String hql = "from DataStageReportItem where stage.code='" + code + "' and stageReport.bid.project.category.id=" + categoryId;
        if (!StringHelper.isEmpty(bidIds)) {
            hql += " and stageReport.bid.id in (" + bidIds + ")";
        }
        if (null == year && null == month) {
            hql += " and result.id in (" + ids + ")";
        }
        if (null != year && null == month) {
            hql += " and stageReport.year=" + year + " and (result.id=" + plan.getId() + " or result.id=" + complete.getId() + ")";
        }
        if (null != year && null != month) {
            hql += " and stageReport.year=" + year + " and stageReport.month=" + month + " and result.id=" + complete.getId();
        }
        if (null != year && null != month && !StringHelper.isEmpty(acc)) {
            String months = "";
            for (int i = 1; i <= month; i++) {
                months += "," + i;
            }
            if (!StringHelper.isEmpty(months)) {
                months = months.substring(1);
            }
            hql += " and stageReport.year=" + year + " and stageReport.month in(" + months + ") and result.id=" + complete.getId();
        }
        List<DataStageReportItem> itemList = dataStageReportItemService.findByQuery(hql);

        Map<Long, DataStageReportItem> map = new HashMap<Long, DataStageReportItem>();
        for (DataStageReportItem reportItem : itemList) {
            ProjBid bid = reportItem.getStageReport().getBid();
            map.put(bid.getId(), reportItem);
        }
        List<DataStageReportItem> itemListNew = new ArrayList<DataStageReportItem>();
        for (DataStageReportItem reportItem : map.values()) {
            itemListNew.add(reportItem);
        }
        return itemListNew.size();
    }
}
