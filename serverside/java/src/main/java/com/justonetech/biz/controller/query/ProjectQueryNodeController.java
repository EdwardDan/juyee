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
import com.justonetech.core.utils.FormatUtils;
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
import java.util.*;


/**
 * note:项目形象进度查询
 */
@Controller
public class ProjectQueryNodeController extends BaseCRUDActionController<ProjInfo> {
    private Logger logger = LoggerFactory.getLogger(ProjectQueryNodeController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ProjInfoService projInfoService;

    @Autowired
    private ProjBidService projBidService;

    @Autowired
    private ProjNodeService projNodeService;

    @Autowired
    private DataNodeReportService dataNodeReportService;

    @Autowired
    private DataNodeReportItemService dataNodeReportItemService;

    @Autowired
    private ExcelPrintManager excelPrintManager;

    private static final String xlsTemplateName = "DataNodeReport.xls";

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有查看汇总权限
        model.addAttribute("canViewAll", sysUserManager.hasPrivilege(PrivilegeCode.PROJECT_QUERY_NODE_SUM));

        return "view/query/projectQueryNode/grid";
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
     * 查看形象进度信息
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String viewNode(Model model, Long id) {
        model.addAttribute("id", id);
        Calendar c = Calendar.getInstance();
        model.addAttribute("yearOptions", DateTimeHelper.getYearSelectOptions(String.valueOf(c.get(Calendar.YEAR))));
        model.addAttribute("currentYear", c.get(Calendar.YEAR));
        model.addAttribute("currentMonth", c.get(Calendar.MONTH) + 1);

        return "view/query/projectQueryNode/viewNode";
    }

    /**
     * 查看形象进度信息--获取数据
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String viewNodeData(Model model, HttpServletRequest request) {
        String projectId = request.getParameter("id");
        String projectName = request.getParameter("projectName");
        String bidName = request.getParameter("bidName");
        String jsDept = request.getParameter("jsDept");
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        Boolean isSum = StringHelper.isEmpty(projectId);   //是否汇总
        model.addAttribute("isSum", isSum);

        //办证阶段
        List<ProjNode> firstNodes = new ArrayList<ProjNode>();
        List<ProjNode> secondNodes = new ArrayList<ProjNode>();
        List<ProjNode> thirdNodes = new ArrayList<ProjNode>();
        List<ProjNode> leafNodes = new ArrayList<ProjNode>();
        List<ProjNode> projNodes = projNodeService.findByQuery("from ProjNode where isValid=1 order by treeId asc");
        for (ProjNode node : projNodes) {
            int currentLevel = node.getCurrentLevel();
            int totalLevel = node.getTotalLevel();
            if (currentLevel == 1) {
                firstNodes.add(node);
            } else if (currentLevel == 2 && totalLevel == 3) {
                secondNodes.add(node);
            } else {
                thirdNodes.add(node);
            }
            if (node.getIsLeaf()) {
                leafNodes.add(node);
            }
        }
        model.addAttribute("firstNodes", firstNodes);
        model.addAttribute("secondNodes", secondNodes);
        model.addAttribute("thirdNodes", thirdNodes);
        model.addAttribute("leafNodes", leafNodes);

        //审核步骤
        List<SysCodeDetail> steps = sysCodeManager.getCodeListByCode(Constants.DATA_REPORT_STEP);
        model.addAttribute("steps", steps);
        model.addAttribute("stepSize", steps.size());

        //标段列表
        String conditionHql = "from ProjBid where typeCode='" + ProjBidType.TYPE_NODE.getCode() + "'";
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
        List<ProjBid> bids = projBidService.findByQuery(conditionHql + " order by project.no asc,project.id asc,no asc,id asc");
        model.addAttribute("bidSize", bids.size());

        //整理项目包含标段
        List<Map<String, Object>> projects = reOrgBids(bids);
        model.addAttribute("projects", projects);

        //用于数据过滤
        conditionHql = "select id " + conditionHql;

        //填报数据
        Map<String, Object> dataMap = new HashMap<String, Object>();
        String hql = "from DataNodeReportItem where nodeReport.bid.id in({0}) and nodeReport.year={1} and nodeReport.month={2} order by id asc";
        hql = FormatUtils.format(hql, conditionHql, year, month);
        List<DataNodeReportItem> dataNodeReportItems = dataNodeReportItemService.findByQuery(hql);
        for (DataNodeReportItem item : dataNodeReportItems) {
            Long bidId = item.getNodeReport().getBid().getId();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("content", item.getContent());
            map.put("problem", item.getProblem());
            dataMap.put(bidId + "_" + item.getStep().getId() + "_" + item.getNode().getId(), map);
        }
        model.addAttribute("dataMap", dataMap);

        return "view/query/projectQueryNode/viewNodeData";
    }

    //整理项目包含标段
    private List<Map<String, Object>> reOrgBids(List<ProjBid> bids) {
        List<Map<String, Object>> projects = new ArrayList<Map<String, Object>>();
        Set<Long> projIds = new HashSet<Long>();
        Map<Long, ProjInfo> infoMap = new HashMap<Long, ProjInfo>();
        Map<Long, List<ProjBid>> bidMap = new HashMap<Long, List<ProjBid>>();
        for (ProjBid bid : bids) {
            Long key = bid.getProject().getId();
            List<ProjBid> projBids = bidMap.get(key);
            if (projBids == null) projBids = new ArrayList<ProjBid>();
            projBids.add(bid);
            bidMap.put(key, projBids);
            projIds.add(key);
            infoMap.put(key, bid.getProject());
        }
        for (Long projId : projIds) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("projInfo", infoMap.get(projId));
            map.put("bids", bidMap.get(projId));
            projects.add(map);
        }
        return projects;
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
        String fileName = "项目形象进度汇总表.xls";

        String projectId = request.getParameter("id");
        String projectName = request.getParameter("projectName");
        String bidName = request.getParameter("bidName");
        String jsDept = request.getParameter("jsDept");
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        Boolean isSum = StringHelper.isEmpty(projectId);   //是否汇总
        beans.put("year", year);
        beans.put("month", month);

        //办证阶段
        List<ProjNode> firstNodes = new ArrayList<ProjNode>();
        List<ProjNode> firstNodesIncludeNull = new ArrayList<ProjNode>();
        List<ProjNode> secondNodes = new ArrayList<ProjNode>();
        List<ProjNode> secondNodesIncludeNull = new ArrayList<ProjNode>();
        List<ProjNode> thirdNodes = new ArrayList<ProjNode>();
        List<ProjNode> leafNodes = new ArrayList<ProjNode>();
        List<ProjNode> projNodes = projNodeService.findByQuery("from ProjNode where isValid=1 order by treeId asc");
        for (ProjNode node : projNodes) {
            int currentLevel = node.getCurrentLevel();
            int totalLevel = node.getTotalLevel();
            if (currentLevel == 1) {
                firstNodes.add(node);
                firstNodesIncludeNull.add(node);
                Set<ProjNode> childs = node.getProjNodes();
                if (childs.size() > 1) {
                    for (int i = 1; i < node.getTotalChildCount(); i++) {
                        firstNodesIncludeNull.add(new ProjNode());
                    }
                }
            } else if (currentLevel == 2) {
                if (totalLevel == 3) {
                    secondNodes.add(node);
                    for (int i = 1; i <= node.getProjNodes().size(); i++) {
                        secondNodesIncludeNull.add(node);
                    }
                } else {
                    secondNodesIncludeNull.add(new ProjNode());
                    thirdNodes.add(node);
                }
            } else {
                thirdNodes.add(node);
            }
            if (node.getIsLeaf()) {
                leafNodes.add(node);
            }
        }
        beans.put("firstNodes", firstNodes);
        beans.put("firstNodesIncludeNull", firstNodesIncludeNull);
        beans.put("secondNodes", secondNodes);
        beans.put("secondNodesIncludeNull", secondNodesIncludeNull);
        beans.put("thirdNodes", thirdNodes);
        beans.put("leafNodes", leafNodes);

        //审核步骤
        List<SysCodeDetail> steps = sysCodeManager.getCodeListByCode(Constants.DATA_REPORT_STEP);
        beans.put("steps", steps);
        beans.put("stepSize", steps.size());

        //标段列表
        String conditionHql = "from ProjBid where typeCode='" + ProjBidType.TYPE_NODE.getCode() + "'";
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
        List<ProjBid> bids = projBidService.findByQuery(conditionHql + " order by project.no asc,project.id asc,no asc,id asc");
//        beans.put("bids", bids);

        //整理项目包含标段
        List<Map<String, Object>> projects = reOrgBids(bids);
        beans.put("projects", projects);

        //用于数据过滤
        conditionHql = "select id " + conditionHql;

        //填报数据
        Map<String, Object> dataMap = new HashMap<String, Object>();
        String hql = "from DataNodeReportItem where nodeReport.bid.id in({0}) and nodeReport.year={1} and nodeReport.month={2} order by id asc";
        hql = FormatUtils.format(hql, conditionHql, year, month);
        List<DataNodeReportItem> dataNodeReportItems = dataNodeReportItemService.findByQuery(hql);
        for (DataNodeReportItem item : dataNodeReportItems) {
            Long bidId = item.getNodeReport().getBid().getId();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("content", item.getContent());
            map.put("problem", item.getProblem());
            dataMap.put(bidId + "_" + item.getStep().getId() + "_" + item.getNode().getId(), map);
        }
        beans.put("dataMap", dataMap);

        Map<String, Object> mergeMap = new HashMap<String, Object>();
        List<int[]> mergerCellsList = new ArrayList<int[]>();
        int startColNo = 0;
        int startRowNo = 4;
        int bidCount = bids.size();
        int stepCount = steps.size();
        //项目标段合并
//        for (int r = 0; r < bidCount; r++) {
//            for (int c = 0; c <= 6; c++) {
//                mergerCellsList.add(new int[]{c, startRowNo + stepCount * 2 * r, c, startRowNo + stepCount * 2 * (r + 1) - 1});
//            }
//        }
        int st = startRowNo;
        for (Map<String, Object> project : projects) {
            List<ProjBid> projBids = (List<ProjBid>) project.get("bids");
            int r = projBids.size();
            for (int c = 0; c <= 2; c++) {
//                System.out.println("c = " + c+","+st+"|"+c+","+(st+r*2-1));
                mergerCellsList.add(new int[]{c, st, c, st + r * 2 - 1});
            }
            st += r * 2;
        }
//        mergerCellsList.add(new int[]{0,3,0,12});
//        mergerCellsList.add(new int[]{1,3,1,12});
//        mergerCellsList.add(new int[]{0,13,0,23});
//        mergerCellsList.add(new int[]{1,13,1,23});

        //单位类型合并
//        startColNo = 7;
//        for (int r = 0; r < bidCount; r++) {
//            for (int c = 1; c <= stepCount; c++) {
//                mergerCellsList.add(new int[]{startColNo, startRowNo, startColNo, startRowNo + 1});
//                startRowNo += 2;
//            }
//        }
//        mergerCellsList.add(new int[]{7,3,7,4});
//        mergerCellsList.add(new int[]{7,5,7,6});

        //前期阶段合并
        startColNo = 8;
        for (ProjNode node : firstNodes) {
            if (!StringHelper.isEmpty(node.getName())) {
                startRowNo = 1;
                int totalLevel = node.getTotalLevel();
                int totalChildCount = node.getTotalChildCount();
                Set<ProjNode> childs = node.getProjNodes();
                if (childs.size() == 0) {  //竖向合并
                    mergerCellsList.add(new int[]{startColNo, startRowNo, startColNo, startRowNo + 2});
                    startColNo++;
                } else if (childs.size() == 1) { //横向或竖向合并
                    if (totalLevel == 2) {
                        mergerCellsList.add(new int[]{startColNo, startRowNo, startColNo, startRowNo + 1});
                    } else if (totalLevel == 3) {
                        mergerCellsList.add(new int[]{startColNo, startRowNo, startColNo + totalChildCount - 1, startRowNo});
                        mergerCellsList.add(new int[]{startColNo, startRowNo + 1, startColNo + totalChildCount - 1, startRowNo + 1});
                    }
                    startColNo += totalChildCount;
                } else if (childs.size() > 1) { //横向或竖向合并
                    if (totalChildCount == 2) {
                        mergerCellsList.add(new int[]{startColNo, startRowNo, startColNo + totalChildCount - 1, startRowNo + 1});
                        startColNo += totalChildCount;
                    } else if (totalLevel == 3) {
                        mergerCellsList.add(new int[]{startColNo, startRowNo, startColNo + totalChildCount - 1, startRowNo});
                        for (ProjNode child : childs) {
                            int size = child.getProjNodes().size();
                            if (size > 1) {
                                mergerCellsList.add(new int[]{startColNo, startRowNo + 1, startColNo + size - 1, startRowNo + 1});
                            }
                            startColNo += size;
                        }
                    }
                }
            }
        }
//        col+8
//        row+1
//        mergerCellsList.add(new int[]{8,1,9,2}); //totallevel=2
//        mergerCellsList.add(new int[]{10,1,11,2});
//        mergerCellsList.add(new int[]{12,1,13,2});
//        mergerCellsList.add(new int[]{14,1,15,2});

//        mergerCellsList.add(new int[]{18,1,23,1});//totallevel=3,leafs=6

//        mergerCellsList.add(new int[]{18,2,19,2});//totallevel=3,leafs=2
//        mergerCellsList.add(new int[]{20,2,23,2});//totallevel=3,leafs=2

        //形象进度合并
        startColNo = 8;
        startRowNo = 5;
        for (int r = 0; r < bidCount; r++) {
            for (int s = 1; s <= stepCount; s++) {
                for (ProjNode node : firstNodes) {
                    mergerCellsList.add(new int[]{startColNo, startRowNo, startColNo + node.getTotalChildCount() - 1, startRowNo});
                    startColNo += node.getTotalChildCount();
                }
                startColNo = 8;
                startRowNo += 2;
            }
        }
//        col+8
//        row+4
//        mergerCellsList.add(new int[]{8,5,9,5});
//        mergerCellsList.add(new int[]{10,5,11,5});
//        mergerCellsList.add(new int[]{12,5,13,5});
//        mergerCellsList.add(new int[]{14,5,15,5});
//        mergerCellsList.add(new int[]{18,5,23,5});

//        mergerCellsList.add(new int[]{8,7,9,7});
//        mergerCellsList.add(new int[]{10,7,11,7});
//        mergerCellsList.add(new int[]{12,7,13,7});
//        mergerCellsList.add(new int[]{14,7,15,7});
//        mergerCellsList.add(new int[]{18,7,23,7});

        //大标题合并
        mergerCellsList.add(new int[]{0, 0, leafNodes.size() + 8 - 1, 0});

//        //for test
//        for (int[] ints : mergerCellsList) {
//            String s = "";
//            for (int anInt : ints) {
//                s += "," + anInt;
//            }
//            System.out.println("s = " + s);
//        }
        mergeMap.put("mergerCellsList", mergerCellsList);
        excelPrintManager.printExcel(response, request, DataNodeReport.class.getSimpleName(), xlsTemplateName, beans, fileName, mergeMap);
    }
}