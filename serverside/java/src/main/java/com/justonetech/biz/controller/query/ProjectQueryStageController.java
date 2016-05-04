package com.justonetech.biz.controller.query;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.ProjectRelateManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.ProjBidType;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.ExcelPrintManager;
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
import javax.servlet.http.HttpSession;
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
    private DocumentManager documentManager;

    @Autowired
    private ProjInfoService projInfoService;

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

    @Autowired
    private ProjectRelateManager projectRelateManager;

    private static final String xlsTemplateName = "DataStageReport.xls";

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        List<SysCodeDetail> propertyList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_PROPERTY);
        List<SysCodeDetail> projinfostageList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_STAGE);
        List<SysCodeDetail> projinfocategoryList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_CATEGORY);
        model.addAttribute("propertyList", propertyList); //管理属性
        model.addAttribute("projinfostageList", projinfostageList); //项目状态
        model.addAttribute("projinfocategoryList", projinfocategoryList); //业务类别
        model.addAttribute("canViewAll", sysUserManager.hasPrivilege(PrivilegeCode.PROJECT_QUERY_STAGE_SUM));
        model.addAttribute("xmlconfig", documentManager.getDefaultXmlConfig());
        model.addAttribute("bizCode", DataStageReportDoc.class.getSimpleName());
        model.addAttribute("userId", sysUserManager.getSysUser().getId());
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
    public void gridDataCustom(HttpServletResponse response, Model model, String filters, String columns, int page, int rows, HttpSession session, HttpServletRequest request) {
        try {
            boolean isJsdw = true;
            SysUser sysUser = sysUserManager.getSysUser();
            //是否是建设单位用户
            if (null != sysUser) {
                System.out.println("sysUser.getDisplayName() = " + sysUser.getDisplayName());
                SysPerson person = sysUser.getPerson();
                if (null != person) {
                    SysDept dept = person.getDept();
                    if (null != dept) {
                        SysDept company = getParentCompany(dept);
                        if (null != company) {
                            String code = company.getCode();
                            if (StringHelper.isEmpty(code) || (!StringHelper.isEmpty(code) && !code.equals("OWNER") && !code.equals("JYKJ") && !code.equals("3"))) {
                                isJsdw = false;
                            }
                        }
                    }
                }
            }
            //按项目屬性状态类别查询数据
            String projproperty = request.getParameter("projproperty");//项目性质
            String ismajor = request.getParameter("ismajor");//是否重大
            String projstage = request.getParameter("projstage");//项目状态
            String projcategory = request.getParameter("projcategory");//业务类别
            Page pageModel = new Page(page, rows, true);
            String hql = "from ProjInfo where 1 = 1 ";
            //增加项目过滤
            if (!StringHelper.isEmpty(projproperty)) {
                hql += " and property.name = '" + projproperty + "' ";
            }
            if (!StringHelper.isEmpty(ismajor)) {
                hql += " and isMajor = '" + ismajor + "' ";
            }
            if (!StringHelper.isEmpty(projstage)) {
                hql += " and stage.name = '" + projstage + "' ";
            }
            if (!StringHelper.isEmpty(projcategory)) {
                hql += " and category.name = '" + projcategory + "' ";
            }
            if (!isJsdw) {
                hql += projectRelateManager.getRelateProjectHql("id");
            }
            hql += " order by no asc,id asc";
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = projInfoService.findByPage(pageModel, query);
            List<Map> beans = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : beans) {
                Object docId = bean.get("doc.id");
                if (docId != null && StringHelper.isNotEmpty((String) docId)) {
                    bean.put("doc.id", documentManager.getDownloadButton(JspHelper.getLong(docId)));
                }
            }
            String json = GridJq.toJSON(beans, pageModel);
            sendJSON(response, json);
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    private SysDept getParentCompany(SysDept dept) {
        if (dept.getIsTag() != null && dept.getIsTag()) {
            return dept;
        }
        if (dept.getParent() != null) {
            return getParentCompany(dept.getParent());
        } else {
            return dept;
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
        model.addAttribute("PROJ_INFO_CATEGORY", Constants.PROJ_INFO_CATEGORY);//项目类型
        model.addAttribute("PROJ_INFO_PROPERTY", Constants.PROJ_INFO_PROPERTY);//管理属性
        model.addAttribute("PROJ_INFO_BELONG_AREA", Constants.PROJ_INFO_BELONG_AREA);//区县
        model.addAttribute("PROJ_INFO_STAGE", Constants.PROJ_INFO_STAGE);//项目状态
        model.addAttribute("PROJ_QQDJ", Constants.PROJ_QQDJ);//区区对接
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
        String projectName = request.getParameter("projectName");//项目名称
//        String bidName = request.getParameter("bidName");
        String jsDept = request.getParameter("jsDept");//建设单位
        String year = request.getParameter("year");//年份
        String month;
        if (StringHelper.isEmpty(projectId)) {
            month = request.getParameter("month");//汇总月份
        } else {
            month = request.getParameter("month2");//单个项目月份
        }


        String categoryId = request.getParameter("categoryId");//项目类型
        String propertyId = request.getParameter("propertyId");//管理属性
        String belongAreaId = request.getParameter("belongAreaId");//区县
        SysCodeDetail belongArea = null;
        if (StringHelper.isNotEmpty(belongAreaId)) {
            belongArea = sysCodeManager.getCodeListById(Long.parseLong(belongAreaId));
        }
        String isMajor = request.getParameter("isMajor");//是否重大
        String infoStageId = request.getParameter("infoStageId");//项目状态
        String qqdj = request.getParameter("qqdj");//区区对接
//        String beginDate = request.getParameter("beginDate");
//        String endDate = request.getParameter("endDate");
        Boolean isSum = StringHelper.isEmpty(projectId);   //是否汇总


        model.addAttribute("isSum", isSum);
        model.addAttribute("year", year);
        model.addAttribute("month", month);

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
        model.addAttribute("stepSize", steps.size());

        //标段列表
        String conditionHql = "from ProjBid where typeCode='" + ProjBidType.TYPE_STAGE.getCode() + "'";
        if (isSum) {
            if (!StringHelper.isEmpty(projectName)) {//OK
                conditionHql += " and project.name like '%" + projectName + "%'";//项目名称
            }
            if (!StringHelper.isEmpty(jsDept)) {//OK
                conditionHql += " and jsdwName like '%" + jsDept + "%'";//建设单位
            }
            if (!StringHelper.isEmpty(year)) {//OK
                conditionHql += " and project.year = " + year;//年份
            }
            if (!StringHelper.isEmpty(categoryId)) {//OK
                conditionHql += " and project.category.id=" + categoryId;//项目类型
            }
            if (!StringHelper.isEmpty(propertyId)) {//OK
                conditionHql += " and project.property.id =" + propertyId;//管理属性
            }
            if (belongArea != null) {//OK
                conditionHql += " and project.areaCode like '%" + belongArea.getName() + "%'";//区县
            }
            if (!StringHelper.isEmpty(isMajor)) {//OK
                conditionHql += " and project.isMajor = " + isMajor;//是否重要
            }
            if (!StringHelper.isEmpty(infoStageId)) {//OK
                conditionHql += " and project.stage.id = " + infoStageId;
            }
            if (!StringHelper.isEmpty(qqdj)) {//OK
                conditionHql += " and project.projNum like '%" + qqdj + "%'";
            }

//            if (!StringHelper.isEmpty(bidName)) {
//                conditionHql += " and name like '%" + bidName + "%'";
//            }
//            if (!StringHelper.isEmpty(beginDate)) {
//                conditionHql += " and to_char(project.createTime,'yyyy-mm-dd')>='" + beginDate + "'";
//            }
//            if (!StringHelper.isEmpty(endDate)) {
//                conditionHql += " and to_char(project.createTime,'yyyy-mm-dd')<='" + endDate + "'";
//            }
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
        Set<String> oneBidHS = new HashSet<String>();  //只取最新上报的数据
        String hql = "from DataStageReportItem where stageReport.bid.id in(" + conditionHql + ") and stageReport.year=? and stageReport.month=? order by stageReport.year desc,stageReport.month desc,id desc";
//        System.out.println("hql = " + hql);
        List<DataStageReportItem> dataStageReportItems = dataStageReportItemService.findByQuery(hql, Integer.parseInt(year), Integer.parseInt(month));
        for (DataStageReportItem item : dataStageReportItems) {
            Long bidId = item.getStageReport().getBid().getId();
            String key = bidId + "_" + item.getStep().getId() + "_" + item.getStage().getId();
//            if (!oneBidHS.contains(key)) {
//                oneBidHS.add(key);
            Map<String, Object> map = new HashMap<String, Object>();
            SysCodeDetail result = item.getResult();
            String code = result.getCode();
            if (item.getType().toString().equals("jh")) {
                map.put("resultCodeJH", code);
                map.put("resultNameJH", result.getName());
                map.put("dealDateJH", item.getDealDate());
                map.put("updateTimeJH", item.getUpdateTime());
                map.put("planSbDateJH", item.getPlanSbDate());
                map.put("planPfDateJH", item.getPlanPfDate());
                key += "_jh";
                dataMap.put(key, map);
            } else if (item.getType().toString().equals("sj")) {
                map.put("resultCodeSJ", code);
                map.put("resultNameSJ", result.getName());
                map.put("dealDateSJ", item.getDealDate());
                map.put("updateTimeSJ", item.getUpdateTime());
                map.put("planSbDateSJ", item.getPlanSbDate());
                map.put("planPfDateSJ", item.getPlanPfDate());
                key += "_sj";
                dataMap.put(key, map);
            }


            //办理状态
//                String[] ret = getColorAndResult(item, result);
//                map.put("color", ret[0]);
//                map.put("resultName", ret[1]);


//            }
        }
        model.addAttribute("dataMap", dataMap);

        return "view/query/projectQueryStage/viewStageData";
    }

    /**
     * 上载存在问题的附件
     *
     * @param response
     * @param prjId
     * @param docId
     */
    @RequestMapping
    public void uploadProblematicDoc(HttpServletResponse response, Long prjId, Long docId) {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        DataStageReportDoc dataStageReportDoc;
        List<DataStageReportDoc> dataStageReportDocs = dataStageReportDocService.findByQuery("from DataStageReportDoc where project_id = ? and doc_id = ? ", prjId, docId);
        if (!dataStageReportDocs.isEmpty()) {
            dataStageReportDoc = dataStageReportDocs.iterator().next();
        } else {
            dataStageReportDoc = new DataStageReportDoc();
            DocDocument docDocument = documentManager.getDocDocument(docId);
            dataStageReportDoc.setProject(projInfoService.get(prjId));
            dataStageReportDoc.setDoc(docDocument);
            documentManager.updateDocumentByBizData(docDocument, DataStageReportDoc.class.getSimpleName(), docDocument.getName());
        }
        dataStageReportDoc.setYear(currentYear);
        dataStageReportDoc.setMonth(currentMonth);
        dataStageReportDocService.save(dataStageReportDoc);
        sendJSON(response, "操作成功！");
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
     * 获取状态
     *
     * @param item   .
     * @param result .
     * @return .
     */
    private String[] getColorAndResult(DataStageReportItem item, SysCodeDetail result) {
        String[] ret = new String[2];
        //办理状态
        if (Constants.DATA_STAGE_RESULT_1.equals(result.getCode())) {
            String dealDate = item.getDealDate();
            ret[0] = "";
            ret[1] = dealDate;
            if (!StringHelper.isEmpty(dealDate)) {
                if (!JspHelper.getDate(dealDate).after(new Date(System.currentTimeMillis()))) {
                    ret[0] = "yellow";
                }
            }
        } else if (Constants.DATA_STAGE_RESULT_2.equals(result.getCode())) {
            ret[0] = "lightskyblue";
            ret[1] = result.getName();
        } else if (Constants.DATA_STAGE_RESULT_3.equals(result.getCode())) {
            ret[0] = "green";
            ret[1] = "√";
        } else if (Constants.DATA_STAGE_RESULT_4.equals(result.getCode())) {
            ret[0] = "red";
            ret[1] = item.getDealDate();
        } else if (Constants.DATA_STAGE_RESULT_5.equals(result.getCode())) {
            ret[0] = "";
            ret[1] = "—";
        }
        return ret;
    }

    /**
     * 选择指定阶段
     *
     * @param model   .
     * @param request .
     * @throws Exception
     */
    @RequestMapping
    public String selectStage(Model model, HttpServletRequest request) throws Exception {
        String projectId = request.getParameter("id");
        String projectName = request.getParameter("projectName");
        String bidName = request.getParameter("bidName");
        String jsDept = request.getParameter("jsDept");
        String year = request.getParameter("year");
        String categoryId = request.getParameter("categoryId");
        String qqdj = request.getParameter("qqdj");
        String beginDate = request.getParameter("beginDate");
        String endDate = request.getParameter("endDate");
        String month = request.getParameter("month");
        String propertyId = request.getParameter("propertyId");//管理属性
        String belongAreaId = request.getParameter("belongAreaId");//区县
        SysCodeDetail belongArea = null;
        if (StringHelper.isNotEmpty(belongAreaId)) {
            belongArea = sysCodeManager.getCodeListById(Long.parseLong(belongAreaId));
        }
        String isMajor = request.getParameter("isMajor");//是否重大
        String infoStageId = request.getParameter("infoStageId");//项目状态
        model.addAttribute("projectId", projectId);
        model.addAttribute("projectName", projectName);
        model.addAttribute("bidName", bidName);
        model.addAttribute("jsDept", jsDept);
        model.addAttribute("year", year);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("qqdj", qqdj);
//        model.addAttribute("beginDate", beginDate);
//        model.addAttribute("endDate", endDate);
        model.addAttribute("month", month);
        model.addAttribute("propertyId", propertyId);
        model.addAttribute("belongArea", belongArea);
        model.addAttribute("isMajor", isMajor);
        model.addAttribute("infoStageId", infoStageId);

        model.addAttribute("DATA_STAGE_RESULT", Constants.DATA_STAGE_RESULT);

        List<ProjStage> list = projStageService.findByQuery("from ProjStage where isValid=1 and parent is null order by treeId asc");
        model.addAttribute("list", list);

        return "view/query/projectQueryStage/selectStage";
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
        String projectName = request.getParameter("projectName");//项目名称
//        String bidName = request.getParameter("bidName");
        String jsDept = request.getParameter("jsDept");//建设单位
        String year = request.getParameter("year");//年份
        String month;
        if (StringHelper.isEmpty(projectId)) {
            month = request.getParameter("month");//汇总月份
        } else {
            month = request.getParameter("month2");//单个项目月份
        }


        String categoryId = request.getParameter("categoryId");//项目类型
        String propertyId = request.getParameter("propertyId");//管理属性
        String belongAreaId = request.getParameter("belongAreaId");//区县
        SysCodeDetail belongArea = null;
        if (StringHelper.isNotEmpty(belongAreaId)) {
            belongArea = sysCodeManager.getCodeListById(Long.parseLong(belongAreaId));
        }
        String isMajor = request.getParameter("isMajor");//是否重大
        String infoStageId = request.getParameter("infoStageId");//项目状态
        String qqdj = request.getParameter("qqdj");//区区对接
//        String bidName = request.getParameter("bidName");
        String stageIds = request.getParameter("stageIds");  //过滤节点
//        String beginDate = request.getParameter("beginDate");
//        String endDate = request.getParameter("endDate");
        Boolean isSum = StringHelper.isEmpty(projectId);   //是否汇总
        beans.put("year", year);

        //办证阶段
        List<ProjStage> firstStages = new ArrayList<ProjStage>();
        List<ProjStage> secondStages = new ArrayList<ProjStage>();
        List<ProjStage> leafStages = new ArrayList<ProjStage>();
        String stageHql = "from ProjStage where isValid=1";
        if (!StringHelper.isEmpty(stageIds)) {
            stageHql += " and id in(" + stageIds + ")";
        }
        stageHql += " order by treeId asc";
        List<ProjStage> projStages = projStageService.findByQuery(stageHql);
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

        //获取节点对应的选择阶段
        Map<Long, Long> selectedResultHM = new HashMap<Long, Long>();
        if (!StringHelper.isEmpty(stageIds)) {
            String resultIds = request.getParameter("resultIds");
            if (!StringHelper.isEmpty(resultIds)) {
                String[] sids = StringHelper.stringToStringArray(stageIds, ",");
                String[] rids = StringHelper.stringToStringArray(resultIds, ",");
                for (int i = 0; i < sids.length; i++) {
                    String r = rids[i];
                    if (!StringHelper.isEmpty(r)) {
                        if (!"0".equals(r)) {
                            selectedResultHM.put(Long.valueOf(sids[i]), Long.valueOf(r));
                        }
                    }
                }
            }
        }
//        System.out.println("selectedResultHM = " + selectedResultHM);

        //审核步骤
        List<SysCodeDetail> steps = sysCodeManager.getCodeListByCode(Constants.DATA_REPORT_STEP);
        beans.put("steps", steps);
        beans.put("stepSize", steps.size());

        //标段列表
        String conditionHql = "from ProjBid where typeCode='" + ProjBidType.TYPE_STAGE.getCode() + "'";
        if (isSum) {
            if (!StringHelper.isEmpty(projectName)) {//OK
                conditionHql += " and project.name like '%" + projectName + "%'";//项目名称
            }
            if (!StringHelper.isEmpty(jsDept)) {//OK
                conditionHql += " and jsdwName like '%" + jsDept + "%'";//建设单位
            }
            if (!StringHelper.isEmpty(year)) {//OK
                conditionHql += " and project.year = " + year;//年份
            }
            if (!StringHelper.isEmpty(categoryId)) {//OK
                conditionHql += " and project.category.id=" + categoryId;//项目类型
            }
            if (!StringHelper.isEmpty(propertyId)) {//OK
                conditionHql += " and project.property.id =" + propertyId;//管理属性
            }
            if (belongArea != null) {//OK
                conditionHql += " and project.areaCode like '%" + belongArea.getName() + "%'";//区县
            }
            if (!StringHelper.isEmpty(isMajor)) {//OK
                conditionHql += " and project.isMajor = " + isMajor;//是否重要
            }
            if (!StringHelper.isEmpty(infoStageId)) {//OK
                conditionHql += " and project.stage.id = " + infoStageId;
            }
            if (!StringHelper.isEmpty(qqdj)) {//OK
                conditionHql += " and project.projNum like '%" + qqdj + "%'";
            }
//            if (!StringHelper.isEmpty(beginDate)) {
//                conditionHql += " and to_char(project.createTime,'yyyy-mm-dd')>='" + beginDate + "'";
//            }
//            if (!StringHelper.isEmpty(endDate)) {
//                conditionHql += " and to_char(project.createTime,'yyyy-mm-dd')<='" + endDate + "'";
//            }
        } else {
            conditionHql += " and project.id=" + projectId;
        }
//        System.out.println("conditionHql = " + conditionHql);
        List<ProjBid> bids = projBidService.findByQuery(conditionHql + " order by project.no asc,project.id asc,no asc,id asc");

        //用于数据过滤
        conditionHql = "select id " + conditionHql;

        //填报数据
        Map<String, Object> dataMap = new HashMap<String, Object>();
        Set<String> oneBidHS = new HashSet<String>();  //只取最新上报的数据
        String hql = "from DataStageReportItem where stageReport.bid.id in(" + conditionHql + ") and stageReport.year=? and stageReport.month=? order by stageReport.year desc,stageReport.month desc,id desc";
//        System.out.println("hql = " + hql);
        List<DataStageReportItem> dataStageReportItems = dataStageReportItemService.findByQuery(hql, Integer.parseInt(year), Integer.parseInt(month));

        //只显示指定阶段的标段
        List<ProjBid> filterBids = new ArrayList<ProjBid>();
        if (!selectedResultHM.isEmpty()) {
            Set<ProjBid> existsBidHS = new HashSet<ProjBid>();
            for (DataStageReportItem dataStageReportItem : dataStageReportItems) {
                ProjBid bid = dataStageReportItem.getStageReport().getBid();
                Long stageId = dataStageReportItem.getStage().getId();
                if (!existsBidHS.contains(bid) && selectedResultHM.containsKey(stageId)) {
                    if (selectedResultHM.get(stageId).equals(dataStageReportItem.getResult().getId())) {
                        existsBidHS.add(bid);
                    }
                }
            }
            filterBids.addAll(existsBidHS);
        } else {
            filterBids.addAll(bids);
        }

        //整理项目包含标段
        List<Map<String, Object>> projects = reOrgBids(filterBids);
        beans.put("projects", projects);

        //查询数据
        for (DataStageReportItem item : dataStageReportItems) {
            Long bidId = item.getStageReport().getBid().getId();
            String key = bidId + "_" + item.getStep().getId() + "_" + item.getStage().getId();
            if (!oneBidHS.contains(key)) {
                oneBidHS.add(key);
                Map<String, Object> map = new HashMap<String, Object>();
                SysCodeDetail result = item.getResult();
                if (item.getType().toString().equals("jh")) {
                    map.put("resultCodeJH", result.getCode());
                    map.put("resultNameJH", result.getName());
                    map.put("dealDateJH", item.getDealDate());
                    map.put("updateTimeJH", item.getUpdateTime());
                    map.put("planSbDateJH", item.getPlanSbDate());
                    map.put("planPfDateJH", item.getPlanPfDate());
                    key += "_jh";
                    dataMap.put(key, map);
                } else if (item.getType().toString().equals("sj")) {
                    map.put("resultCodeSJ", result.getCode());
                    map.put("resultNameSJ", result.getName());
                    map.put("dealDateSJ", item.getDealDate());
                    map.put("updateTimeSJ", item.getUpdateTime());
                    map.put("planSbDateSJ", item.getPlanSbDate());
                    map.put("planPfDateSJ", item.getPlanPfDate());
                    key += "_sj";
                    dataMap.put(key, map);
                }

                //办理状态
//                String[] ret = getColorAndResult(item, result);
//                map.put("color", ret[0]);
//                map.put("resultName", ret[1]);

//                dataMap.put(key, map);
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
//        int bidCount = bids.size();
//        int stepCount = steps.size();
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
                mergerCellsList.add(new int[]{c, st, c, st + r - 1});
            }
            st += r;
        }

//        mergerCellsList.add(new int[]{0,3,0,12});
//        mergerCellsList.add(new int[]{1,3,1,12});
//        mergerCellsList.add(new int[]{0,13,0,23});
//        mergerCellsList.add(new int[]{1,13,1,23});

//        //单位类型合并
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
        startColNo = 9;
        for (ProjStage stage : firstStages) {
            if (!StringHelper.isEmpty(stage.getName())) {
                startRowNo = 1;
                Set<ProjStage> childs = stage.getProjStages();
                if (childs.size() == 0) {  //竖向合并
                    mergerCellsList.add(new int[]{startColNo, startRowNo, startColNo, startRowNo + 1});
                    startColNo++;
                } else if (childs.size() > 1) { //横向合并
                    mergerCellsList.add(new int[]{startColNo, startRowNo, startColNo + childs.size() - 1, startRowNo});
                    startColNo += childs.size();
                } else {
                    startColNo++;
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
        mergerCellsList.add(new int[]{0, 0, leafStages.size() + 9 - 1, 0});

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