package com.justonetech.biz.controller.data;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.ProjBidType;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from ProjInfo order by id desc";
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
    public String modify(Model model, Long projectId) {
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

        return "view/data/dataStageReport/input";
    }

    /**
     * 数据处理页面
     *
     * @param model     。
     * @param bidId     。
     * @param projectId 。
     * @return 。
     */
    @RequestMapping
    public String checkBidData(Model model, Long bidId, Long projectId) {
        model.addAttribute("bidId", bidId);
        //办证阶段(表格维护)
        List<ProjStage> projStages = projStageService.findByQuery("from ProjStage where isValid=1 order by treeId asc");
        model.addAttribute("projStages", projStages);

        //审核步骤
        List<SysCodeDetail> steps = sysCodeManager.getCodeListByCode(Constants.DATA_REPORT_STEP);
        model.addAttribute("steps", steps);

        //办证推进结果
        List<SysCodeDetail> results = sysCodeManager.getCodeListByCode(Constants.DATA_STAGE_RESULT);
        model.addAttribute("results", results);

        //填报数据
        Map<String, Object> dataMap = new HashMap<String, Object>();
        String hql = "from DataStageReportItem where stageReport.project.id=? and stageReport.bid.id=? order by stageReport.year desc,stageReport.month desc,id desc";
        List<DataStageReportItem> dataStageReportItems = dataStageReportItemService.findByQuery(hql, projectId, bidId);
        for (DataStageReportItem item : dataStageReportItems) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("resultId", item.getResult().getId());
            map.put("resultCode", item.getResult().getCode());
            map.put("resultName", item.getResult().getName());
            map.put("dealDate", item.getDealDate());
            dataMap.put(bidId + "_" + item.getStep().getId() + "_" + item.getStage().getId(), map);
        }
        model.addAttribute("dataMap", dataMap);

        return "view/data/dataStageReport/checkBidData";
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
            if (StringHelper.isEmpty(dealDate)) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                model.addAttribute("currentDate", sdf.format(new Date(System.currentTimeMillis())));
            } else {
                model.addAttribute("dealDate", dealDate);
                model.addAttribute("currentDate", dealDate);
            }
        }

        return "view/data/dataStageReport/resultInput";
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
            DataStageReport target;
            if (entity.getId() != null) {
                target = dataStageReportService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "year",
                        "month"
                });

            } else {
                target = entity;
            }

            //获取并保存标段
            String projectBidId = request.getParameter("projectBidId");
            if (!StringHelper.isEmpty(projectBidId)) {
                ProjBid projBid = projBidService.get(Long.valueOf(projectBidId));
                target.setBid(projBid);
            }
            //获取并保存项目
            String projectId = request.getParameter("projectId");
            if (!StringHelper.isEmpty(projectId)) {
                ProjInfo projInfo = projInfoService.get(Long.valueOf(projectId));
                target.setProject(projInfo);
            }
            dataStageReportService.save(target);

            //先删除，在保存
            Set<DataStageReportItem> dataStageReportItems = target.getDataStageReportItems();
            List<DataStageReportItem> itemList = new ArrayList<DataStageReportItem>();
            for (DataStageReportItem item : dataStageReportItems) {
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
            dataStageReportItemService.batchDelete(itemList, itemList.size());

            //保存详细表数据
            List<ProjStage> projStages = projStageService.findByQuery("from ProjStage where isValid=1 order by treeId asc");
            //审核步骤
            List<SysCodeDetail> steps = sysCodeManager.getCodeListByCode(Constants.DATA_REPORT_STEP);
            List<DataStageReportItem> listItem = new ArrayList<DataStageReportItem>();
            for (ProjStage stage : projStages) {
                for (SysCodeDetail step : steps) {
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
            dataStageReportItemService.batchSave(listItem, listItem.size());

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }
}