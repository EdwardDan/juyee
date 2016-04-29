package com.justonetech.biz.controller.data;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.ProjectInfoContentManager;
import com.justonetech.biz.manager.ProjectRelateManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.ProjBidType;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.apache.commons.lang.StringUtils;
import org.jsoup.select.Evaluator;
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
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * note:办证推进填报
 * author: gq
 * modify date: 2015-5-07
 */
@Controller
public class DataStageReportController extends BaseCRUDActionController<DataStageReport> {
    private Logger logger = LoggerFactory.getLogger(DataStageReportController.class);

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private DataStageReportService dataStageReportService;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private ProjInfoService projInfoService;

    @Autowired
    private ProjStageService projStageService;

    @Autowired
    private DataStageReportItemService dataStageReportItemService;

    @Autowired
    private ProjBidService projBidService;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private DataStageReportLogService dataStageReportLogService;

    @Autowired
    private ProjectRelateManager projectRelateManager;

    @Autowired
    private ProjectInfoContentManager projectInfoContentManager;


    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        List<SysCodeDetail> propertyList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_PROPERTY);
        List<SysCodeDetail> projinfostageList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_STAGE);
        List<SysCodeDetail> projinfocategoryList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_CATEGORY);
        model.addAttribute("propertyList", propertyList); //管理属性
        model.addAttribute("projinfostageList", projinfostageList); //项目状态
        model.addAttribute("projinfocategoryList", projinfocategoryList); //业务类别
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.DATA_STAGE_REPORT_EDIT));
        model.addAttribute("type_stage", ProjBidType.TYPE_STAGE.getCode());

        return "view/data/dataStageReport/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, HttpServletRequest request) {
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
//            System.out.println("hql////////////////////////// = " + hql);
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
     * 修改显示页面
     *
     * @param projectId .
     * @param model     .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long projectId, Integer month) {
        doEditViewData(projectId, model);
        pushDataStageResult(model);

        Calendar c = Calendar.getInstance();
        if (null == month) {
            month = c.get(Calendar.MONTH) + 1;
        }
        Integer year = null;
        year = c.get(Calendar.YEAR);
        model.addAttribute("currentYear", year);
        model.addAttribute("currentMonth", month);
        model.addAttribute("projectId", projectId);
        ProjInfo projInfo = projInfoService.get(projectId);
        projectInfoContentManager.setReportContent(model, projInfo.getProjContent());

        return "view/data/dataStageReport/input";
    }

    /**
     * 数据处理页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String stageDataItem(Model model, Long projectId, Integer month, Long bidId, String type) {//bidId桥段，projectId工程，month月份
        doCheckBidData(bidId, model, projectId, month);
        String url = "view/data/dataStageReport/checkBidData";
        if (type != null) {
            url += type;
        }
        return url;
    }

    /**
     * 标准选择页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String resultInput(Model model, String resultCodeJH, String resultCodeSJ, Long bidId, Long stepId, Long stageId, String dealDateJH, String dealDateSJ) {
        if (!StringHelper.isEmpty(resultCodeJH)) {
            SysCodeDetail codeDetailByCode = sysCodeManager.getCodeDetailByCode(Constants.DATA_STAGE_RESULT, resultCodeJH);
            model.addAttribute("result", codeDetailByCode);
            model.addAttribute("bidId", bidId);
            model.addAttribute("stepId", stepId);
            model.addAttribute("stageId", stageId);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            model.addAttribute("resultCodeJH", resultCodeJH);
            if (!StringHelper.isEmpty(dealDateJH)) {
                model.addAttribute("dealDateJH", dealDateJH);
            }
            model.addAttribute("currentDate", sdf.format(new Date(System.currentTimeMillis())));
        }
        if (!StringHelper.isEmpty(resultCodeSJ)) {
            SysCodeDetail codeDetailByCode = sysCodeManager.getCodeDetailByCode(Constants.DATA_STAGE_RESULT, resultCodeSJ);
            model.addAttribute("result", codeDetailByCode);
            model.addAttribute("bidId", bidId);
            model.addAttribute("stepId", stepId);
            model.addAttribute("stageId", stageId);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            model.addAttribute("resultCodeSJ", resultCodeSJ);
            if (!StringHelper.isEmpty(dealDateSJ)) {
                model.addAttribute("dealDateSJ", dealDateSJ);
            }
            model.addAttribute("currentDate", sdf.format(new Date(System.currentTimeMillis())));
        }
        pushDataStageResult(model);

        return "view/data/dataStageReport/resultInput";
    }

    /**
     * 查看显示页面
     *
     * @param projectId .
     * @param model     .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long projectId) {

        doEditViewData(projectId, model);

        return "view/data/dataStageReport/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") DataStageReport entity, HttpServletRequest request, String reportLog) throws Exception {
        try {
            //获取是否提交标识
            String isSubmit = request.getParameter("isSubmit");//isSubmit为0时为保存为1时为提交
            //获取并保存标段
            String projectBidId = request.getParameter("projectBidId");
            ProjBid projBid = projBidService.get(Long.valueOf(projectBidId));
            //获取并保存项目
            String projectId = request.getParameter("projectId");
            String year = request.getParameter("year");
            String month = request.getParameter("month");
            String hql = "from DataStageReport where project.id=? and bid.id=? and year=? and month=?";
            List<DataStageReport> list = dataStageReportService.findByQuery(hql, JspHelper.getLong(projectId), JspHelper.getLong(projectBidId), JspHelper.getInteger(year), JspHelper.getInteger(month));
            DataStageReport target = new DataStageReport();
            if (null != list && list.size() > 0) {
                target = list.iterator().next();
            }
            if (null != entity.getId() && entity.getId().equals(target.getId())) {
                DataStageReport dataStageReport = dataStageReportService.get(entity.getId());
                if (null != dataStageReport.getBid() && (dataStageReport.getBid().getId().equals(projBid.getId()))) {
                    target = dataStageReport;
                }
            }
            boolean judge = true;//判断是否提交过
            try{
                if(target.getIsSubmit().toString().equals("0")){
                    judge = false;
                }
            }catch (Exception e){
                judge = false;
            }

            //设置是保存状态还是提交状态
            try{
                if(isSubmit.equals("1")||target.getIsSubmit().toString().equals("1")){
                    target.setIsSubmit(1);
                }else{
                    target.setIsSubmit(0);
                }
            }catch (Exception e){
                target.setIsSubmit(0);
            }

            target.setBid(projBid);
            target.setProject(projInfoService.get(Long.valueOf(projectId)));
            target.setYear(Integer.valueOf(year));
            target.setMonth(Integer.valueOf(month));
            dataStageReportService.save(target);

            //先删除，在保存
            Set<DataStageReportItem> items = target.getDataStageReportItems();
            List<DataStageReportItem> itemList = new ArrayList<DataStageReportItem>();
            if (null != items && items.size() > 0) {
                for (DataStageReportItem item : items) {
                    itemList.add(item);
                    //先拷贝保存历史数据，再删除
                    List<DataStageReportLog> logList = new ArrayList<DataStageReportLog>();
                    if (!StringHelper.isEmpty(reportLog)) {
                        DataStageReportLog stageReportLog = new DataStageReportLog();
                        stageReportLog.setStageReport(item.getStageReport());
                        stageReportLog.setStage(item.getStage());
                        stageReportLog.setStep(item.getStep());
                        stageReportLog.setResult(item.getResult());
                        stageReportLog.setResultDesc(item.getResultDesc());
                        stageReportLog.setDealDate(item.getDealDate());
                        stageReportLog.setPlanSbDate(item.getPlanSbDate());
                        stageReportLog.setPlanPfDate(item.getPlanPfDate());
                        stageReportLog.setType(item.getType());
                        stageReportLog.setDoc(item.getDoc());
                        logList.add(stageReportLog);
                    }
                    dataStageReportLogService.batchSave(logList, logList.size());
                }
            }
            dataStageReportItemService.batchDelete(itemList, itemList.size());

            //保存详细表数据
            String hqlStage = "from ProjStage where isValid=1 order by treeId asc";
//            Calendar c = Calendar.getInstance();
//            String hqlStage = "from ProjStage where year=" + c.get(Calendar.YEAR) + " and isValid=1 order by treeId asc";
            List<ProjStage> projStages = projStageService.findByQuery(hqlStage);
            //审核步骤
            List<SysCodeDetail> steps = sysCodeManager.getCodeListByCode(Constants.DATA_REPORT_STEP);
            List<DataStageReportItem> listItem = new ArrayList<DataStageReportItem>();
            //如果是已提交状态计划从数据库得到
            if (target.getIsSubmit().toString().equals("1")&&judge==true){
                for (DataStageReportItem dataStageReportItem:items){
                    if (dataStageReportItem.getType().equals("jh")){
                        dataStageReportItem.setId(null);
                        listItem.add(dataStageReportItem);
                    }
                }
            }
            for (ProjStage stage : projStages) {
                for (SysCodeDetail step : steps) {
                    if (step.getIsValid()) {
                        Long stageId = stage.getId();
                        Long stepId = step.getId();
                        String resultCodeJH = request.getParameter("resultCodeJH_" + target.getBid().getId() + "_" + stepId + "_" + stageId);
                        String dealDateJH = request.getParameter("dealDateJH_" + target.getBid().getId() + "_" + stepId + "_" + stageId);
                        String resultCodeSJ = request.getParameter("resultCodeSJ_" + target.getBid().getId() + "_" + stepId + "_" + stageId);
                        String dealDateSJ = request.getParameter("dealDateSJ_" + target.getBid().getId() + "_" + stepId + "_" + stageId);
                        String planSbDateJH = request.getParameter("planSbDateJH_" + target.getBid().getId() + "_" + stepId + "_" + stageId);
                        String planPfDateJH = request.getParameter("planPfDateJH_" + target.getBid().getId() + "_" + stepId + "_" + stageId);
                        String planSbDateSJ = request.getParameter("planSbDateSJ_" + target.getBid().getId() + "_" + stepId + "_" + stageId);
                        String planPfDateSJ = request.getParameter("planPfDateSJ_" + target.getBid().getId() + "_" + stepId + "_" + stageId);
                        String docId = request.getParameter("docId"+target.getBid().getId() + "_" + stepId  + "_" + stageId);
                        java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                        if ((!StringHelper.isEmpty(resultCodeJH)&&target.getIsSubmit().toString().equals("0"))||!StringHelper.isEmpty(resultCodeJH)&&judge == false) {//保存计划列表（非提交状态）
                            DataStageReportItem reportItem = new DataStageReportItem();
                            reportItem.setType("jh");
                            reportItem.setStageReport(target);
                            reportItem.setStep(step);
                            reportItem.setStage(stage);
                            if (StringHelper.isNotEmpty(planSbDateJH)) {
                                reportItem.setPlanSbDate(formatter.parse(planSbDateJH));
                            }
                            if (StringHelper.isNotEmpty(planPfDateJH)) {
                                reportItem.setPlanPfDate(formatter.parse(planPfDateJH));
                            }
                            SysCodeDetail result = sysCodeManager.getCodeDetailByCode(Constants.DATA_STAGE_RESULT, resultCodeJH);
                            reportItem.setResult(result);
                            if (result!=null){
                                reportItem.setResultDesc(result.getName());
                            }
                            if (!StringHelper.isEmpty(dealDateJH)) {
                                reportItem.setDealDate(dealDateJH);
                            }
                            listItem.add(reportItem);
                        }
                        if (!StringHelper.isEmpty(resultCodeSJ)) {//保存实际列表
                            DataStageReportItem reportItem = new DataStageReportItem();
                            reportItem.setType("sj");
                            reportItem.setStageReport(target);
                            reportItem.setStep(step);
                            reportItem.setStage(stage);
                            if (StringHelper.isNotEmpty(planSbDateSJ)) {
                                reportItem.setPlanSbDate(formatter.parse(planSbDateSJ));
                            }
                            if (StringHelper.isNotEmpty(planPfDateSJ)) {
                                reportItem.setPlanPfDate(formatter.parse(planPfDateSJ));
                            }
                            SysCodeDetail result = sysCodeManager.getCodeDetailByCode(Constants.DATA_STAGE_RESULT, resultCodeSJ);
                            reportItem.setResult(result);
                            reportItem.setResultDesc(result.getName());
                            if (!StringHelper.isEmpty(dealDateSJ)) {
                                reportItem.setDealDate(dealDateSJ);
                            }
                            if (StringHelper.isNotEmpty(docId) && StringUtils.isNumeric(docId)) {
                                DocDocument Doc = documentManager.getDocDocument(JspHelper.getLong(docId));
                                reportItem.setDoc(Doc);
                                documentManager.updateDocumentByBizData(Doc, DataStageReportItem.class.getSimpleName(), Doc.getName());
                            }
                            listItem.add(reportItem);
                        }
                    }
                }
            }
            dataStageReportItemService.batchSave(listItem, listItem.size());
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 处理编辑和查看页面的数据
     *
     * @param projectId 。
     * @param model     。
     */
    private void doEditViewData(Long projectId, Model model) {
        model.addAttribute("projectId", projectId);
        Calendar c = Calendar.getInstance();
        ProjInfo projInfo = projInfoService.get(projectId);
        List<DataStageReport> reportList = dataStageReportService.findByProperty("project.id", projectId);
        DataStageReport dataStageReport = new DataStageReport();
        if (null != reportList && reportList.size() > 0) {
            dataStageReport = reportList.iterator().next();
        } else {
            dataStageReport.setProject(projInfo);
            dataStageReport.setYear(c.get(Calendar.YEAR));
            dataStageReport.setMonth(c.get(Calendar.MONTH) + 1);
        }
        //处理其他业务逻辑
        model.addAttribute("bean", dataStageReport);
        //标段类别--办证推进
        model.addAttribute("bidTypeCode", ProjBidType.TYPE_STAGE.getCode());
        //标段的获取
        List<ProjBid> projBids = projBidService.findByQuery(" from ProjBid where project.id=" + projectId + " and typeCode='" + ProjBidType.TYPE_STAGE.getCode() + "' order by no asc");
        model.addAttribute("bids", projBids);
    }

    /**
     * 处理页面详细数据
     *
     * @param bidId 。
     * @param model 。
     */
    private void doCheckBidData(Long bidId, Model model, Long projectId, Integer month) {
        model.addAttribute("bidId", bidId);
        //办证阶段(表格维护)
        String hqlStage = "from ProjStage where isValid=1 order by treeId asc";
        Calendar c = Calendar.getInstance();
//        String hqlStage = "from ProjStage where year=" + c.get(Calendar.YEAR) + " and isValid=1 order by treeId asc";
        List<ProjStage> projStages = projStageService.findByQuery(hqlStage);
        model.addAttribute("projStages", projStages);
        //审核步骤
        List<SysCodeDetail> steps = sysCodeManager.getCodeListByCode(Constants.DATA_REPORT_STEP);
        model.addAttribute("steps", steps);
        //办证推进结果
        List<SysCodeDetail> results = sysCodeManager.getCodeListByCode(Constants.DATA_STAGE_RESULT);
        model.addAttribute("results", results);
//        String button = documentManager.getUploadButtonForMulti(documentManager.getDefaultXmlConfig(), DataStageReportItem.class.getSimpleName(), item.getDoc(), sysUserManager.getSysUser().getId(), "DataStageReportItem", item.getId().toString());
//        model.addAttribute("uploadButton",button);
        //填报数据
        Map<String, Object> dataMap = new HashMap<String, Object>();
        DataStageReport report = getDataStageReport(projectId, c.get(Calendar.YEAR), month, bidId);
        String isSubmit = "0";
        try{
            isSubmit = report.getIsSubmit().toString();
        }catch (Exception e){
            isSubmit = "0";
        }
        model.addAttribute("isSubmit",isSubmit);
        if (null == report) {
            month = month - 1;
        }
        List<DataStageReportItem> dataStageReportItems = findDataItems(projectId, c.get(Calendar.YEAR), month, bidId);
        for (DataStageReportItem item : dataStageReportItems) {
            Map<String, Object> map = new HashMap<String, Object>();
            if (item.getType().equals("jh")) {
                map.put("resultIdJH", item.getResult().getId());
                map.put("resultCodeJH", item.getResult().getCode());
                map.put("resultNameJH", item.getResult().getName());
                map.put("planSbDateJH", item.getPlanSbDate());
                map.put("planPfDateJH", item.getPlanPfDate());
                map.put("dealDateJH", item.getDealDate());
            } else if (item.getType().equals("sj")) {
                map.put("resultIdSJ", item.getResult().getId());
                map.put("resultCodeSJ", item.getResult().getCode());
                map.put("resultNameSJ", item.getResult().getName());
                map.put("planSbDateSJ", item.getPlanSbDate());
                map.put("planPfDateSJ", item.getPlanPfDate());
                map.put("dealDateSJ", item.getDealDate());
                map.put("docId",item.getDoc());
            }
            SysCodeDetail step = item.getStep();
            if (null != step) {
                if (item.getType().equals("jh")) {
                    dataMap.put(bidId + "_" + step.getId() + "_" + item.getStage().getId() + "_jh", map);
                } else if (item.getType().equals("sj")) {
                    dataMap.put(bidId + "_" + step.getId() + "_" + item.getStage().getId() + "_sj", map);
                }
            }
        }
        model.addAttribute("dataMap", dataMap);
        //附件上传按钮
        Map<String,String> upButton = new HashMap<String,String>();
        for (ProjStage stage : projStages) {
            for (SysCodeDetail step : steps) {
                if (step.getIsValid()) {
                    Long stageId = stage.getId();
                    Long stepId = step.getId();
                    DocDocument document = null;
                    String dataKey = bidId + "_" + stepId + "_" + stageId + "_sj";
                    for(String dataKeyDataMap:dataMap.keySet()){
                        if (dataKey.equals(dataKeyDataMap)){
                            Map<String, Object> map = (Map)dataMap.get(dataKey);
                            if (map.get("docId")!=null) {
                                document = (DocDocument)map.get("docId");
                            }
                        }
                    }
                    String button = documentManager.getUploadButtonForMulti(documentManager.getDefaultXmlConfig(), DataStageReportItem.class.getSimpleName(), document, sysUserManager.getSysUser().getId(), "DataStageReportItem", bidId + "_" + stepId + "_" + stageId);
                    upButton.put(bidId + "_" + stepId + "_" + stageId, button);
                }
            }
        }
        model.addAttribute("upButton",upButton);
    }

    /**
     * 获取已填报的信息
     *
     * @param projectId .
     * @param year      .
     * @param month     .
     * @param bidId     .
     * @return .
     */
    private List<DataStageReportItem> findDataItems(Long projectId, Integer year, Integer month, Long bidId) {
        String hql = "from DataStageReportItem where stageReport.project.id=? and stageReport.bid.id=? and stageReport.year=? and stageReport.month=? order by stageReport.id desc,stageReport.year desc,stageReport.month desc";
        return dataStageReportItemService.findByQuery(hql, JspHelper.getLong(projectId), JspHelper.getLong(bidId), year, month);
    }

    /**
     * 获取主表数据
     *
     * @param projectId 。
     * @param year      。
     * @param month     。
     * @param bidId     。
     * @return 。
     */
    private DataStageReport getDataStageReport(Long projectId, Integer year, Integer month, Long bidId) {
        String hql = "from DataStageReport where project.id=? and bid.id=? and year=? and month=?";
        List<DataStageReport> list = dataStageReportService.findByQuery(hql, JspHelper.getLong(projectId), JspHelper.getLong(bidId), year, month);
        if (null != list && list.size() > 0) {
            return list.iterator().next();
        }
        return null;
    }

    public void pushDataStageResult(Model model) {
        model.addAttribute("result1", Constants.DATA_STAGE_RESULT_1);
        model.addAttribute("result2", Constants.DATA_STAGE_RESULT_2);
        model.addAttribute("result3", Constants.DATA_STAGE_RESULT_3);
        model.addAttribute("result4", Constants.DATA_STAGE_RESULT_4);
        model.addAttribute("result5", Constants.DATA_STAGE_RESULT_5);
        model.addAttribute("result6", Constants.DATA_STAGE_RESULT_6);
    }
}
