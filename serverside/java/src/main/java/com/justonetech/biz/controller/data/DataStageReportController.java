package com.justonetech.biz.controller.data;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.ProjBidType;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
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
            String hql = "from ProjInfo order by category.treeId asc";
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

        doEditViewData(projectId, model);

        return "view/data/dataStageReport/input";
    }

    /**
     * 数据处理页面
     *
     * @param model 。
     * @param bidId 。
     * @return 。
     */
    @RequestMapping
    public String checkBidData(Model model, Long bidId, Long projectId) {

        doCheckBidData(bidId, model, projectId);

        return "view/data/dataStageReport/checkBidData";
    }

    /**
     * 标准选择页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String resultInput(Model model, String resultCode, Long bidId, Long stageId, String dealDate) {
        if (!StringHelper.isEmpty(resultCode)) {
            SysCodeDetail codeDetailByCode = sysCodeManager.getCodeDetailByCode(Constants.DATA_STAGE_RESULT, resultCode);
            model.addAttribute("result", codeDetailByCode);
            model.addAttribute("bidId", bidId);
            model.addAttribute("stageId", stageId);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (!StringHelper.isEmpty(dealDate)) {
                model.addAttribute("dealDate", dealDate);
            }
            model.addAttribute("currentDate", sdf.format(new Date(System.currentTimeMillis())));
        }

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
     * 数据处理页面
     *
     * @param model 。
     * @param bidId 。
     * @return 。
     */
    @RequestMapping
    public String checkBidDataView(Model model, Long bidId, Long projectId) {

        doCheckBidData(bidId, model, projectId);

        return "view/data/dataStageReport/checkBidDataView";
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
            //获取并保存标段
            String projectBidId = request.getParameter("projectBidId");
            ProjBid projBid = projBidService.get(Long.valueOf(projectBidId));
            if (entity.getId() != null) {
                DataStageReport dataStageReport = dataStageReportService.get(entity.getId());
                if (null != dataStageReport.getBid() && (dataStageReport.getBid().getId().equals(projBid.getId()))) {
                    target = dataStageReport;
                } else {
                    target = new DataStageReport();
                }
            } else {
                target = new DataStageReport();
            }
            target.setBid(projBid);

            //获取并保存项目
            String projectId = request.getParameter("projectId");
            target.setProject(projInfoService.get(Long.valueOf(projectId)));
            String year = request.getParameter("year");
            String month = request.getParameter("month");
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
            Calendar c = Calendar.getInstance();
            String hqlStage = "from ProjStage where year=" + c.get(Calendar.YEAR) + " and isValid=1 order by treeId asc";
            List<ProjStage> projStages = projStageService.findByQuery(hqlStage);
            List<DataStageReportItem> listItem = new ArrayList<DataStageReportItem>();
            for (ProjStage stage : projStages) {
                Long stageId = stage.getId();
                String resultCode = request.getParameter("resultCode_" + target.getBid().getId() + "_" + stageId);
                String dealDate = request.getParameter("dealDate_" + target.getBid().getId() + "_" + stageId);
                if (!StringHelper.isEmpty(resultCode)) {
                    DataStageReportItem reportItem = new DataStageReportItem();
                    reportItem.setStageReport(target);
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
        List<ProjBid> projBids = projBidService.findByQuery(" from ProjBid where project.id=" + projectId + " and typeCode='" + ProjBidType.TYPE_STAGE.getCode() + "'");
        model.addAttribute("bids", projBids);
    }

    /**
     * 处理页面详细数据
     *
     * @param bidId 。
     * @param model 。
     */
    private void doCheckBidData(Long bidId, Model model, Long projectId) {
        model.addAttribute("bidId", bidId);
        //办证阶段(表格维护)
        Calendar c = Calendar.getInstance();
        String hqlStage = "from ProjStage where year=" + c.get(Calendar.YEAR) + " and isValid=1 order by treeId asc";
        List<ProjStage> projStages = projStageService.findByQuery(hqlStage);
        model.addAttribute("projStages", projStages);

        //办证推进结果
        List<SysCodeDetail> results = sysCodeManager.getCodeListByCode(Constants.DATA_STAGE_RESULT);
        model.addAttribute("results", results);

        //填报数据
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
            dataMap.put(bidId + "_" + item.getStage().getId(), map);
        }
        model.addAttribute("dataMap", dataMap);
    }
}