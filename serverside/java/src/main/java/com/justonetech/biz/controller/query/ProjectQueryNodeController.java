package com.justonetech.biz.controller.query;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.ProjectRelateManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.ProjBidType;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.system.daoservice.SysCodeDetailService;
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
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
    private DataNodeReportItemService dataNodeReportItemService;

    @Autowired
    private ExcelPrintManager excelPrintManager;

    @Autowired
    private ProjectRelateManager projectRelateManager;

    @Autowired
    private SysCodeDetailService sysCodeDetailService;

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
            //增加项目过滤
            hql += projectRelateManager.getRelateProjectHql("id");

            hql += "order by no asc,id asc";

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
        model.addAttribute("monthOptions", DateTimeHelper.getMonthSelectOptions(String.valueOf(c.get(Calendar.MONTH) + 1)));
        model.addAttribute("currentYear", c.get(Calendar.YEAR));
        model.addAttribute("currentMonth", c.get(Calendar.MONTH) + 1);
        model.addAttribute("PROJ_INFO_CATEGORY", Constants.PROJ_INFO_CATEGORY);
        model.addAttribute("PORJECT_PROJ_PROPERTY", Constants.PORJECT_PROJ_PROPERTY);
        model.addAttribute("PROJ_INFO_BELONG_AREA", Constants.PROJ_INFO_BELONG_AREA);
        model.addAttribute("PROJ_INFO_STAGE", Constants.PROJ_INFO_STAGE);
        model.addAttribute("PROJ_INFO_PROPERTY", Constants.PROJ_INFO_PROPERTY);

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
        String projectName = "";
        String jsDept = "";
        try {
            projectName = URLDecoder.decode(request.getParameter("projectName"), "UTF-8");
            jsDept = URLDecoder.decode(request.getParameter("jsDept"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String propertyId = request.getParameter("propertyId");

        String isMajor = request.getParameter("isMajor");
        String qqdj = request.getParameter("qqdj");
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String categoryId = request.getParameter("categoryId");     
        String belongAreaId = request.getParameter("belongAreaId");
        String infoStageId = request.getParameter("infoStageId");
        Boolean isSum = StringHelper.isEmpty(projectId);   //是否汇总
        model.addAttribute("isSum", isSum);

        //办证阶段
        List<ProjNode> firstNodes = new ArrayList<ProjNode>();
        List<ProjNode> secondNodes = new ArrayList<ProjNode>();
        List<ProjNode> thirdNodes = new ArrayList<ProjNode>();
        List<ProjNode> fourNodes = new ArrayList<ProjNode>();
        List<ProjNode> leafNodes = new ArrayList<ProjNode>();
        List<ProjNode> projNodes = projNodeService.findByQuery("from ProjNode where isValid=1 order by treeId asc");
        for (ProjNode node : projNodes) {
            int currentLevel = node.getCurrentLevel();
            int totalLevel = node.getTotalLevel();
            if (currentLevel == 1) {
                firstNodes.add(node);
            } else if (currentLevel == 2) {
                secondNodes.add(node);
            } else if (currentLevel == 3) {
                thirdNodes.add(node);
            } else if (currentLevel == 4) {
                fourNodes.add(node);
            }
            if (node.getIsLeaf()) {
                leafNodes.add(node);
            }
        }
        model.addAttribute("firstNodes", firstNodes);
        model.addAttribute("secondNodes", secondNodes);
        model.addAttribute("thirdNodes", thirdNodes);
        model.addAttribute("fourNodes", fourNodes);
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
            if (!StringHelper.isEmpty(isMajor)) {
                conditionHql += " and project.isMajor=" + isMajor;
            }
            if (!StringHelper.isEmpty(propertyId)) {
                conditionHql += " and project.property.id=" + propertyId;
            }
            if (!StringHelper.isEmpty(infoStageId)) {
                conditionHql += " and project.stage.id=" + infoStageId;
            }
            if (!StringHelper.isEmpty(belongAreaId)) {
                SysCodeDetail areaDetail = sysCodeDetailService.get(JspHelper.getLong(belongAreaId));
                conditionHql += " and project.areaCode='" + areaDetail.getName() + "'";
            }
            if (!StringHelper.isEmpty(jsDept)) {
                conditionHql += " and project.jsdwName like '%" + jsDept + "%'";
            }
            if (!StringHelper.isEmpty(year)) {
                conditionHql += " and project.year='" + year + "'";
            }
            if (!StringHelper.isEmpty(categoryId)) {
                conditionHql += " and project.category.id=" + categoryId;
            }
            if (!com.justonetech.core.utils.StringHelper.isEmpty(qqdj)) {
                conditionHql += " and project.projNum like '" + qqdj + "%'";
            }
        } else {
            conditionHql += " and project.id=" + projectId;
        }
        System.out.println("conditionHql = " + conditionHql);
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
        hql = FormatUtils.format(hql, conditionHql, JspHelper.getInteger(year) + "", JspHelper.getInteger(month) + "");
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
     * 选择指定节点
     *
     * @param model   .
     * @param request .
     * @throws Exception
     */
    @RequestMapping
    public String selectNode(Model model, HttpServletRequest request) throws Exception {
        String projectId = request.getParameter("id");

        String projectName = "";
        String jsDept = "";
        try {
            projectName = URLDecoder.decode(request.getParameter("projectName"), "UTF-8");
            jsDept = URLDecoder.decode(request.getParameter("jsDept"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String bidName = request.getParameter("bidName");
        String year = request.getParameter("year");
        String categoryId = request.getParameter("categoryId");
        String qqdj = request.getParameter("qqdj");
        String beginDate = request.getParameter("beginDate");
        String endDate = request.getParameter("endDate");
        String month = request.getParameter("month");

        model.addAttribute("projectId", projectId);
        model.addAttribute("projectName", projectName);
        model.addAttribute("bidName", bidName);
        model.addAttribute("jsDept", jsDept);
        model.addAttribute("year", year);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("qqdj", qqdj);
        model.addAttribute("beginDate", beginDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("month", month);

        List<ProjNode> list = projNodeService.findByQuery("from ProjNode where isValid=1 and parent is null order by treeId asc");
        model.addAttribute("list", list);

        return "view/query/projectQueryNode/selectNode";
    }

    private Boolean isIdIn(String nodeIds, Long thisId) {
        return ("," + nodeIds + ",").contains("," + thisId + ",");
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


        String projectName = "";
        String jsDept = "";
        try {
            projectName = URLDecoder.decode(request.getParameter("projectName"), "UTF-8");
            jsDept = URLDecoder.decode(request.getParameter("jsDept"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String propertyId = request.getParameter("propertyId");
        String isMajor = request.getParameter("isMajor");
        String qqdj = request.getParameter("qqdj");
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String categoryId = request.getParameter("categoryId");
        String belongAreaId = request.getParameter("belongAreaId");
        String infoStageId = request.getParameter("infoStageId");
        Boolean isSum = StringHelper.isEmpty(projectId);   //是否汇总
        beans.put("year", year);
        beans.put("month", month);

        //办证阶段
        List<ProjNode> firstNodes = new ArrayList<ProjNode>();
        List<ProjNode> firstNodesIncludeNull = new ArrayList<ProjNode>();
        List<ProjNode> secondNodes = new ArrayList<ProjNode>();
        List<ProjNode> secondNodesIncludeNull = new ArrayList<ProjNode>();
        List<ProjNode> thirdNodes = new ArrayList<ProjNode>();
        List<ProjNode> thirdNodesIncludeNull = new ArrayList<ProjNode>();
        List<ProjNode> fourNodes = new ArrayList<ProjNode>();
        List<ProjNode> leafNodes = new ArrayList<ProjNode>();
        List<ProjNode> projNodes = projNodeService.findByQuery("from ProjNode where isValid=1 and parent.id is null order by treeId asc");
        for (ProjNode projNode : projNodes) {
            firstNodes.add(projNode);
            if (projNode.getIsLeaf()) {
                leafNodes.add(projNode);
            }

            firstNodesIncludeNull.add(projNode);
            if (projNode.getProjNodes().size() > 1) {
                for (int i = 1; i < projNode.getTotalChildCount(); i++) {
                    firstNodesIncludeNull.add(new ProjNode());
                }
            }

            if (projNode.getProjNodes().size() > 0) {
                for (ProjNode node : projNode.getProjNodes()) {
                    secondNodes.add(node);
                    if (node.getIsLeaf()) {
                        leafNodes.add(node);

                        thirdNodesIncludeNull.add(new ProjNode());
                    }

                    secondNodesIncludeNull.add(node);
                    if (node.getProjNodes().size() > 1) {
                        for (int i = 1; i < node.getTotalChildCount(); i++) {
                            secondNodesIncludeNull.add(new ProjNode());
                        }
                    }

                    if (node.getProjNodes().size() > 0)
                        for (ProjNode projNode1 : node.getProjNodes()) {
                            if (projNode1.getIsLeaf()) {
                                leafNodes.add(projNode1);
                            }
                            thirdNodes.add(projNode1);

                            thirdNodesIncludeNull.add(projNode1);
                            if (projNode1.getProjNodes().size() > 1) {
                                for (int i = 1; i < projNode1.getTotalChildCount(); i++) {
                                    thirdNodesIncludeNull.add(new ProjNode());
                                }
                            }

                            if (projNode1.getProjNodes().size() > 0) {
                                for (ProjNode projNode2 : projNode1.getProjNodes()) {
                                    if (projNode2.getIsLeaf()) {
                                        leafNodes.add(projNode2);
                                    }

                                    fourNodes.add(projNode2);
                                }
                            }
                        }
                }
            }
        }

        beans.put("firstNodes", firstNodes);
        beans.put("firstNodesIncludeNull", firstNodesIncludeNull);
        beans.put("secondNodes", secondNodes);
        beans.put("secondNodesIncludeNull", secondNodesIncludeNull);
        beans.put("thirdNodes", thirdNodes);
        beans.put("thirdNodesIncludeNull", thirdNodesIncludeNull);
        beans.put("fourNodes", fourNodes);
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
            if (!StringHelper.isEmpty(isMajor)) {
                conditionHql += " and project.isMajor=" + isMajor;
            }
            if (!StringHelper.isEmpty(propertyId)) {
                conditionHql += " and project.property.id=" + propertyId;
            }
            if (!StringHelper.isEmpty(infoStageId)) {
                conditionHql += " and project.stage.id=" + infoStageId;
            }
            if (!StringHelper.isEmpty(belongAreaId)) {
                SysCodeDetail areaDetail = sysCodeDetailService.get(JspHelper.getLong(belongAreaId));
                conditionHql += " and project.areaCode='" + areaDetail.getName() + "'";
            }
            if (!StringHelper.isEmpty(jsDept)) {
                conditionHql += " and project.jsdwName like '%" + jsDept + "%'";
            }
            if (!StringHelper.isEmpty(year)) {
                conditionHql += " and project.year='" + year + "'";
            }
            if (!StringHelper.isEmpty(categoryId)) {
                conditionHql += " and project.category.id=" + categoryId;
            }
            if (!com.justonetech.core.utils.StringHelper.isEmpty(qqdj)) {
                conditionHql += " and project.projProperty.id =" + qqdj;
            }
        } else {
            conditionHql += " and project.id=" + projectId;
        }

        List<ProjBid> bids = projBidService.findByQuery(conditionHql + " order by project.no asc,project.id asc,no asc,id asc");

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
        int startRowNo = 5;
        int bidCount = bids.size();
        int stepCount = steps.size();
        //项目标段合并
//        for (int r = 0; r < bidCount; r++) {
//            for (int c = 0; c <= 6; c++) {
//                mergerCellsList.add(new int[]{c, startRowNo + stepCount * 2 * r, c, startRowNo + stepCount * 2 * (r + 1) - 1});
//            }
//        }

//        int st = startRowNo;
//        for (Map<String, Object> project : projects) {
//            List<ProjBid> projBids = (List<ProjBid>) project.get("bids");
//            int r = projBids.size();
//            for (int c = 0; c <= 2; c++) {
////                System.out.println("c = " + c+","+st+"|"+c+","+(st+r*2-1));
//                mergerCellsList.add(new int[]{c, st, c, st + r * 2 - 1});
//            }
//            st += r * 2;
//        }


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
        startColNo = 11;
        for (ProjNode node : firstNodes) {
            if (!StringHelper.isEmpty(node.getName())) {
                startRowNo = 1;
                int totalLevel = node.getTotalLevel();
                int totalChildCount = node.getTotalChildCount();
                Set<ProjNode> childs = node.getProjNodes();
                if (childs.size() == 0) {  //竖向合并
                    mergerCellsList.add(new int[]{startColNo, startRowNo, startColNo, startRowNo + 3});
                    startColNo++;
                } else {
                    //第一行合并，合并列，行不合并
                    mergerCellsList.add(new int[]{startColNo, startRowNo, startColNo + totalChildCount - 1, startRowNo});
                    for (ProjNode child : childs) {
                        //第二行合并
                        if (child.getProjNodes().size() > 0) {
                            mergerCellsList.add(new int[]{startColNo, startRowNo + 1, startColNo + child.getTotalChildCount() - 1, startRowNo + 1});
                            for (ProjNode projNode : child.getProjNodes()) {
                                //第三行合并
                                if (projNode.getProjNodes().size() > 0) {
                                    //第三行合并，当不为也子节点时，行不合并，列合并
                                    mergerCellsList.add(new int[]{startColNo, startRowNo + 2, startColNo + projNode.getTotalChildCount() - 1, startRowNo + 2});
                                    startColNo += projNode.getTotalChildCount();
                                } else {
                                    //第三行合并，当为也子节点时，行合并，列不合并
                                    mergerCellsList.add(new int[]{startColNo, startRowNo + 2, startColNo, startRowNo + 3});
                                    startColNo++;
                                }
                            }
                        } else {
                            //第二行合并，合并行，列不合并
                            mergerCellsList.add(new int[]{startColNo, startRowNo + 1, startColNo, startRowNo + 3});
                            startColNo++;
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
//        startColNo = 9;
//        startRowNo = 6;
//        for (
//                int r = 0;
//                r < bidCount; r++)
//
//        {
//            for (int s = 1; s <= stepCount; s++) {
//                for (ProjNode node : firstNodes) {
//                    mergerCellsList.add(new int[]{startColNo, startRowNo, startColNo + node.getTotalChildCount() - 1, startRowNo});
//                    startColNo += node.getTotalChildCount();
//                }
//                startColNo = 9;
//                startRowNo += 2;
//            }
//        }
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
        mergerCellsList.add(new int[]{0, 0, leafNodes.size() + 9 - 1, 0});

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