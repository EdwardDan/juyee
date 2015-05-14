package com.justonetech.biz.controller.query;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.ProjBidType;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.ExcelPrintManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.hibernate.annotations.common.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.*;


/**
 * note:项目办证推进查询
 */
@Controller
public class ProjectQueryStageController extends BaseCRUDActionController<ProjInfo> {
    private Logger logger = LoggerFactory.getLogger(ProjectQueryStageController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ProjInfoService projInfoService;

    @Autowired
    private ProjBidService projBidService;

    @Autowired
    private ProjStageService projStageService;

    @Autowired
    private DataStageReportService dataStageReportService;

    @Autowired
    private DataStageReportItemService dataStageReportItemService;

    @Autowired
    private DataStageReportLogService dataStageReportLogService;

    @Autowired
    private ExcelPrintManager excelPrintManager;

    private static final String xlsTemplateName = "DataStageReport.xls";

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有查看汇总权限
        model.addAttribute("canViewAll", sysUserManager.hasPrivilege(PrivilegeCode.PROJECT_QUERY_STAGE_SUM));

        return "view/query/projectQueryStage/grid";
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
            String hql = "from ProjInfo where 1=1";
//            //增加项目过滤
//            hql += projectRelateManager.getRelateProjectHql("id");

            hql += "order by id desc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = projInfoService.findByPage(pageModel, query);

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 查看办证推进信息
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String viewStage(Model model, Long id) {
        model.addAttribute("id", id);
        Calendar c = Calendar.getInstance();
        model.addAttribute("yearOptions", DateTimeHelper.getYearSelectOptions(String.valueOf(c.get(Calendar.YEAR))));
        model.addAttribute("currentYear", c.get(Calendar.YEAR));
        model.addAttribute("currentMonth", c.get(Calendar.MONTH) + 1);

        return "view/query/projectQueryStage/viewStage";
    }

    /**
     * 查看办证推进信息--获取数据
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String viewStageData(Model model, HttpServletRequest request) {
        String projectId = request.getParameter("id");
        String projectName = request.getParameter("projectName");
        String bidName = request.getParameter("bidName");
        String jsDept = request.getParameter("jsDept");
        String year = request.getParameter("year");
        Boolean isSum = StringHelper.isEmpty(projectId);   //是否汇总
        model.addAttribute("isSum", isSum);
        model.addAttribute("year", year);

        //办证阶段
        List<ProjStage> firstStages = new ArrayList<ProjStage>();
        List<ProjStage> secondStages = new ArrayList<ProjStage>();
        List<ProjStage> leafStages = new ArrayList<ProjStage>();
        List<ProjStage> projStages = projStageService.findByQuery("from ProjStage where isValid=1 order by treeId asc");
        for (ProjStage stage : projStages) {
            if (stage.getParent() == null) {
                firstStages.add(stage);
            } else {
                secondStages.add(stage);
            }
            if (stage.getIsLeaf()) {
                leafStages.add(stage);
            }
        }
        model.addAttribute("firstStages", firstStages);
        model.addAttribute("secondStages", secondStages);
        model.addAttribute("leafStages", leafStages);

        //审核步骤
        List<SysCodeDetail> steps = sysCodeManager.getCodeListByCode(Constants.DATA_REPORT_STEP);
        model.addAttribute("steps", steps);

        //标段列表
        String conditionHql = "from ProjBid where typeCode='" + ProjBidType.TYPE_STAGE.getCode() + "'";
        if (isSum) {
            if (!StringHelper.isEmpty(projectName)) {
                conditionHql += " and project.name like '%" + projectName + "%'";
            }
            if (!StringHelper.isEmpty(bidName)) {
                conditionHql += " and name like '%" + bidName + "%'";
            }
            if (!StringHelper.isEmpty(jsDept)) {
                conditionHql += " and project.jsDept like '%" + jsDept + "%'";
            }
            if (!StringHelper.isEmpty(year)) {
                conditionHql += " and project.year='" + year + "'";
            }
        } else {
            conditionHql += " and project.id=" + projectId;
        }
//        System.out.println("conditionHql = " + conditionHql);
        List<ProjBid> bids = projBidService.findByQuery(conditionHql + " order by project.id asc,id asc");
        model.addAttribute("bids", bids);

        //用于数据过滤
        conditionHql = "select id " + conditionHql;

        //填报数据
        Map<String, Object> dataMap = new HashMap<String, Object>();
        Set<String> oneBidHS = new HashSet<String>();  //只取最新上报的数据
        String hql = "from DataStageReportItem where stageReport.bid.id in(" + conditionHql + ") order by stageReport.year desc,stageReport.month desc,id desc";
//        System.out.println("hql = " + hql);
        List<DataStageReportItem> dataStageReportItems = dataStageReportItemService.findByQuery(hql);
        for (DataStageReportItem item : dataStageReportItems) {
            Long bidId = item.getStageReport().getBid().getId();
            String key = bidId + "_" + item.getStep().getId() + "_" + item.getStage().getId();
            if (!oneBidHS.contains(key)) {
                oneBidHS.add(key);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("resultCode", item.getResult().getCode());
                map.put("resultName", item.getResult().getName());
                map.put("dealDate", item.getDealDate());
                map.put("updateTime", item.getUpdateTime());
                dataMap.put(key, map);
            }
        }
        model.addAttribute("dataMap", dataMap);

        //上次填报数据
        Map<String, Object> lastMap = new HashMap<String, Object>();
        Set<String> keyHS = new HashSet<String>();
        String lastHql = "from DataStageReportLog where stageReport.bid.id in(" + conditionHql + ") order by updateTime desc";
        List<DataStageReportLog> lastLogs = dataStageReportLogService.findByQuery(lastHql);
        for (DataStageReportLog item : lastLogs) {
            Long bidId = item.getStageReport().getBid().getId();
            String key = bidId + "_" + item.getStep().getId() + "_" + item.getStage().getId();
            if (!keyHS.contains(key)) {
                Object currentData = dataMap.get(key);
                if (currentData != null) {
                    Map<String, Object> currentDataMap = (Map<String, Object>) currentData;
                    if (item.getUpdateTime().before((Timestamp) currentDataMap.get("updateTime"))) {
                        keyHS.add(key);
                        Map<String, Object> map = new HashMap<String, Object>();
                        map.put("resultCode", item.getResult().getCode());
                        map.put("resultName", item.getResult().getName());
                        map.put("dealDate", item.getDealDate());
                        lastMap.put(key, map);
                    }
                } else {
                    keyHS.add(key);
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("resultCode", item.getResult().getCode());
                    map.put("resultName", item.getResult().getName());
                    map.put("dealDate", item.getDealDate());
                    lastMap.put(key, map);
                }
            }
        }
        model.addAttribute("lastMap", lastMap);

        return "view/query/projectQueryStage/viewStageData";
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
        String fileName = "年度项目办证推进表.xls";

        String projectId = request.getParameter("id");
        String projectName = request.getParameter("projectName");
        String bidName = request.getParameter("bidName");
        String jsDept = request.getParameter("jsDept");
        String year = request.getParameter("year");
        Boolean isSum = StringHelper.isEmpty(projectId);   //是否汇总
        beans.put("year", year);

        //办证阶段
        List<ProjStage> firstStages = new ArrayList<ProjStage>();
        List<ProjStage> secondStages = new ArrayList<ProjStage>();
        List<ProjStage> leafStages = new ArrayList<ProjStage>();
        List<ProjStage> projStages = projStageService.findByQuery("from ProjStage where isValid=1 order by treeId asc");
        for (ProjStage stage : projStages) {
            if (stage.getParent() == null) {
                firstStages.add(stage);
                Set<ProjStage> childs = stage.getProjStages();
                if (childs.size() > 1) {
                    for (int i = 1; i <= (childs.size() - 1); i++) {
                        firstStages.add(new ProjStage());
                    }
                } else if (childs.size() == 0) {
                    secondStages.add(new ProjStage());
                }
            } else {
                secondStages.add(stage);
            }
            if (stage.getIsLeaf()) {
                leafStages.add(stage);
            }
        }
        beans.put("firstStages", firstStages);
        beans.put("secondStages", secondStages);
        beans.put("leafStages", leafStages);

        //审核步骤
        List<SysCodeDetail> steps = sysCodeManager.getCodeListByCode(Constants.DATA_REPORT_STEP);
        beans.put("steps", steps);

        //标段列表
        String conditionHql = "from ProjBid where typeCode='" + ProjBidType.TYPE_STAGE.getCode() + "'";
        if (isSum) {
            if (!StringHelper.isEmpty(projectName)) {
                conditionHql += " and project.name like '%" + projectName + "%'";
            }
            if (!StringHelper.isEmpty(bidName)) {
                conditionHql += " and name like '%" + bidName + "%'";
            }
            if (!StringHelper.isEmpty(jsDept)) {
                conditionHql += " and project.jsDept like '%" + jsDept + "%'";
            }
            if (!StringHelper.isEmpty(year)) {
                conditionHql += " and project.year='" + year + "'";
            }
        } else {
            conditionHql += " and project.id=" + projectId;
        }
//        System.out.println("conditionHql = " + conditionHql);
        List<ProjBid> bids = projBidService.findByQuery(conditionHql + " order by project.id asc,id asc");
        beans.put("bids", bids);

        //用于数据过滤
        conditionHql = "select id " + conditionHql;

        //填报数据
        Map<String, Object> dataMap = new HashMap<String, Object>();
        Set<String> oneBidHS = new HashSet<String>();  //只取最新上报的数据
        String hql = "from DataStageReportItem where stageReport.bid.id in(" + conditionHql + ") order by stageReport.year desc,stageReport.month desc,id desc";
//        System.out.println("hql = " + hql);
        List<DataStageReportItem> dataStageReportItems = dataStageReportItemService.findByQuery(hql);
        for (DataStageReportItem item : dataStageReportItems) {
            Long bidId = item.getStageReport().getBid().getId();
            String key = bidId + "_" + item.getStep().getId() + "_" + item.getStage().getId();
            if (!oneBidHS.contains(key)) {
                oneBidHS.add(key);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("resultCode", item.getResult().getCode());
                map.put("resultName", item.getResult().getName());
                map.put("dealDate", item.getDealDate());
                map.put("updateTime", item.getUpdateTime());
                dataMap.put(key, map);
            }
        }

        beans.put("dataMap", dataMap);

        //合并单元格
//        int col1, int row1, int col2, int row2
//        1、项目合并
//        row+3
//        0,3,0,stepCount+2
//        1,3,1,stepCount+2
//        ...
//        6,3,6,stepCount+2
//
//        2、单位合并
//                col=7
//        row+3
//        step=2
//        7,3,7,4
//        7,5,7,6
//
//        3、阶段合并
//        col+8
//        row+1
//        8,1,8,2
//        9,1,9,2
//        10,3,10,3
//
//        11,1,12,1
//        13,1,14,1

        Map<String, Object> mergeMap = new HashMap<String, Object>();
        List<int[]> mergerCellsList = new ArrayList<int[]>();
        int startColNo = 0;
        int startRowNo = 3;
        int bidCount = bids.size();
        int stepCount = steps.size();
        //项目标段合并
        for (int r = 0; r < bidCount; r++) {
            for (int c = 0; c <= 6; c++) {
                mergerCellsList.add(new int[]{c, startRowNo + stepCount * 2 * r, c, startRowNo + stepCount * 2 * (r + 1) - 1});
            }
        }
//        mergerCellsList.add(new int[]{0,3,0,12});
//        mergerCellsList.add(new int[]{1,3,1,12});
//        mergerCellsList.add(new int[]{0,13,0,23});
//        mergerCellsList.add(new int[]{1,13,1,23});

        //单位类型合并
        startColNo = 7;
        for (int r = 0; r < bidCount; r++) {
            for (int c = 1; c <= stepCount; c++) {
                mergerCellsList.add(new int[]{startColNo, startRowNo, startColNo, startRowNo + 1});
                startRowNo += 2;
            }
        }
//        mergerCellsList.add(new int[]{7,3,7,4});
//        mergerCellsList.add(new int[]{7,5,7,6});

        //前期阶段合并
        startColNo = 8;
        for (ProjStage stage : firstStages) {
            if (!StringHelper.isEmpty(stage.getName())) {
                startRowNo = 1;
                Set<ProjStage> childs = stage.getProjStages();
                if (childs.size() == 0) {  //竖向合并
                    mergerCellsList.add(new int[]{startColNo, startRowNo, startColNo, startRowNo + 1});
                    startColNo ++;
                } else if (childs.size() > 1) { //横向合并
                    mergerCellsList.add(new int[]{startColNo, startRowNo, startColNo + childs.size() - 1, startRowNo});
                    startColNo += childs.size();
                }else{
                    startColNo ++;
                }
            }
        }
//        col+8
//        row+1
//        mergerCellsList.add(new int[]{8,1,8,2});
//        mergerCellsList.add(new int[]{9,1,9,2});
//        mergerCellsList.add(new int[]{10,3,10,3});
//        mergerCellsList.add(new int[]{11,1,12,1});
//        mergerCellsList.add(new int[]{13,1,14,1});

        //大标题合并
        mergerCellsList.add(new int[]{0,0,leafStages.size()+8-1,0});

        //for test
//        for (int[] ints : mergerCellsList) {
//            String s = "";
//            for (int anInt : ints) {
//                s += "," + anInt;
//            }
//            System.out.println("s = " + s);
//        }
        mergeMap.put("mergerCellsList", mergerCellsList);
        excelPrintManager.printExcel(response, request, DataStageReport.class.getSimpleName(), xlsTemplateName, beans, fileName, mergeMap);
    }
}