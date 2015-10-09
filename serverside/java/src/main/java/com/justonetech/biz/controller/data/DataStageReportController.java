package com.justonetech.biz.controller.data;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.ProjBidType;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysCodeManager;
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
        model.addAttribute("projinfostageList",projinfostageList); //项目状态
        model.addAttribute("projinfocategoryList",projinfocategoryList); //业务类别
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
            //按区县过滤
            SysUser sysUser = sysUserManager.getSysUser();
            String name = "";
            if (null != sysUser) {
                name = sysUser.getPerson().getName();
            }
            List<SysCodeDetail> areaList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_BELONG_AREA);
            String areaNames = "";
            for (SysCodeDetail detail : areaList) {
                areaNames += detail.getName();
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
            if (!StringHelper.isEmpty(name) && areaNames.contains(name)) {
                hql += " and areaCode is not null and areaCode like '%" + name + "%'";
            }
            hql += " order by no asc,id asc";
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
        model.addAttribute("currentMonth", month);
        model.addAttribute("projectId", projectId);

        return "view/data/dataStageReport/input";
    }

    /**
     * 数据处理页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String stageDataItem(Model model, Long projectId, Integer month, Long bidId, String type) {
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
    public String resultInput(Model model, String resultCode, Long bidId, Long stepId, Long stageId, String dealDate) {
        if (!StringHelper.isEmpty(resultCode)) {
            SysCodeDetail codeDetailByCode = sysCodeManager.getCodeDetailByCode(Constants.DATA_STAGE_RESULT, resultCode);
            model.addAttribute("result", codeDetailByCode);
            model.addAttribute("bidId", bidId);
            model.addAttribute("stepId", stepId);
            model.addAttribute("stageId", stageId);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (!StringHelper.isEmpty(dealDate)) {
                model.addAttribute("dealDate", dealDate);
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
            for (ProjStage stage : projStages) {
                for (SysCodeDetail step : steps) {
                    if (step.getIsValid()) {
                        Long stageId = stage.getId();
                        Long stepId = step.getId();
                        String resultCode = request.getParameter("resultCode_" + target.getBid().getId() + "_" + stepId + "_" + stageId);
                        String dealDate = request.getParameter("dealDate_" + target.getBid().getId() + "_" + stepId + "_" + stageId);
                        if (!StringHelper.isEmpty(resultCode)) {
                            DataStageReportItem reportItem = new DataStageReportItem();
                            reportItem.setStageReport(target);
                            reportItem.setStep(step);
                            reportItem.setStage(stage);
                            SysCodeDetail result = sysCodeManager.getCodeDetailByCode(Constants.DATA_STAGE_RESULT, resultCode);
                            reportItem.setResult(result);
                            reportItem.setResultDesc(result.getName());
                            if (!StringHelper.isEmpty(dealDate)) {
                                reportItem.setDealDate(dealDate);
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
        //填报数据
        Map<String, Object> dataMap = new HashMap<String, Object>();
        DataStageReport report = getDataStageReport(projectId, c.get(Calendar.YEAR), month, bidId);
        if (null == report) {
            month = month - 1;
        }
        List<DataStageReportItem> dataStageReportItems = findDataItems(projectId, c.get(Calendar.YEAR), month, bidId);
        for (DataStageReportItem item : dataStageReportItems) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("resultId", item.getResult().getId());
            map.put("resultCode", item.getResult().getCode());
            map.put("resultName", item.getResult().getName());
            map.put("dealDate", item.getDealDate());
            SysCodeDetail step = item.getStep();
            if (null != step) {
                dataMap.put(bidId + "_" + step.getId() + "_" + item.getStage().getId(), map);
            }
        }
        model.addAttribute("dataMap", dataMap);
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