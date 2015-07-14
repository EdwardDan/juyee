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
import java.util.*;


/**
 * note:形象进度推进填报
 * author: hgr
 * create date:
 * modify date:2015-05-11
 */
@Controller
public class DataNodeReportController extends BaseCRUDActionController<DataNodeReport> {
    private Logger logger = LoggerFactory.getLogger(DataNodeReportController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ProjBidService projBidService;

    @Autowired
    private ProjNodeService projNodeService;

    @Autowired
    private DataNodeReportItemService dataNodeReportItemService;

    @Autowired
    private DataNodeReportService dataNodeReportService;

    @Autowired
    private ProjInfoService projInfoService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.DATA_NODE_REPORT_EDIT));
        model.addAttribute("TYPE_NODE", ProjBidType.TYPE_NODE.getCode());
        return "view/data/dataNodeReport/grid";
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
            String hql = "from ProjInfo order by no asc,id asc";
            //增加自定义查询条件

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
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        DataNodeReport dataNodeReport = new DataNodeReport();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", dataNodeReport);

        return "view/data/dataNodeReport/input";
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
        List<DataNodeReport> dataNodeReportList = dataNodeReportService.findByProperty("project.id", projectId);
        List<ProjBid> projBids = getBids(projectId);
        DataNodeReport dataNodeReport = new DataNodeReport();
        if (dataNodeReportList.size() > 0) {
            dataNodeReport = dataNodeReportList.iterator().next();
        }
        //处理其他业务逻辑
        model.addAttribute("currentMonth", c.get(Calendar.MONTH) + 1);
        model.addAttribute("projInfo", projInfo);
        model.addAttribute("projBids", projBids);
        model.addAttribute("bean", dataNodeReport);
        model.addAttribute("id", projInfo.getId());
        return "view/data/dataNodeReport/input";
    }

    /**
     * 形象进度填报详情
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String nodeDataItem(Model model, Long id, Integer month, String bidId,String type) {
        //办证阶段
        List<ProjNode> firstNodes = projNodeService.findByQuery("from ProjNode where isValid=1 and parent.id is null order by treeId asc");
        model.addAttribute("firstNodes", firstNodes);
        //审核步骤
        List<SysCodeDetail> steps = sysCodeManager.getCodeListByCode(Constants.DATA_REPORT_STEP);
        model.addAttribute("steps", steps);
        if (null != id) {
            //标段列表
            ProjInfo projInfo = projInfoService.get(id);
            //填报数据
            Map<String, Object> dataMap = new HashMap<String, Object>();
            List<DataNodeReportItem> dataNodeReportItems = findDataItems(id, projInfo.getYear(), month, bidId);
            for (DataNodeReportItem item : dataNodeReportItems) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("content", item.getContent());
                map.put("problem", item.getProblem());
                dataMap.put(item.getNode().getId() + "_" + item.getStep().getId(), map);
            }
            model.addAttribute("dataMap", dataMap);
        }
        String url ="view/data/dataNodeReport/nodeDataItem";
        if(type!=null){
            url+=type;
        }
        return url;
    }

    /**
     * 查看页面
     *
     * @param projectId .
     * @param model     .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long projectId) {
        Calendar c = Calendar.getInstance();
        ProjInfo projInfo = projInfoService.get(projectId);
        List<DataNodeReport> dataNodeReportList = dataNodeReportService.findByProperty("project.id", projectId);
        List<ProjBid> projBids = getBids(projectId);
        DataNodeReport dataNodeReport = new DataNodeReport();
        if (dataNodeReportList.size() > 0) {
            dataNodeReport = dataNodeReportList.iterator().next();
        }
        //处理其他业务逻辑
        model.addAttribute("currentMonth", c.get(Calendar.MONTH) + 1);
        model.addAttribute("projInfo", projInfo);
        model.addAttribute("projBids", projBids);
        model.addAttribute("bean", dataNodeReport);
        model.addAttribute("id", projInfo.getId());
        return "view/data/dataNodeReport/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") DataNodeReport entity, HttpServletRequest request) throws Exception {
        try {
            String month = request.getParameter("month");
            DataNodeReport target;
            if (entity.getId() != null) {
                DataNodeReport dataNodeReport = dataNodeReportService.get(entity.getId());
                if (dataNodeReport.getMonth().equals(Integer.valueOf(month))) {
                    target = dataNodeReport;
                } else {
                    target = new DataNodeReport();
                }
            } else {
                target = new DataNodeReport();
            }
            if (month != null && !month.equals("")) {
                target.setMonth(Integer.valueOf(month));
            }
            String projectId = request.getParameter("projectId");
            String projBidId = request.getParameter("projBid");
            if (projectId != null && !projectId.equals("")) {
                ProjInfo projInfo = projInfoService.get(Long.valueOf(projectId));
                target.setProject(projInfo);
                target.setYear(projInfo.getYear());
            }
            if (projBidId != null && !projBidId.equals("")) {
                ProjBid projBid = projBidService.get(Long.valueOf(projBidId));
                target.setBid(projBid);
            }
            dataNodeReportService.save(target);
            //保存之前先删除旧数据
            if (target.getProject() != null && target.getBid() != null) {
                List<DataNodeReportItem> dataNodeReportItems = findDataItems(target.getProject().getId(), target.getProject().getYear(), Integer.valueOf(month), target.getBid().getId().toString());
                dataNodeReportItemService.batchDelete(dataNodeReportItems, dataNodeReportItems.size());
            }

            //保存填报明细
            List<ProjNode> leafNodes = projNodeService.findByQuery("from ProjNode where isValid=1 and isLeaf=1  order by treeId asc");
            //审核步骤
            List<SysCodeDetail> steps = sysCodeManager.getCodeListByCode(Constants.DATA_REPORT_STEP);
            List<DataNodeReportItem> dataItems = new ArrayList<DataNodeReportItem>();
            for (ProjNode leafNode : leafNodes) {
                Long firstNodeId = leafNode.getFirstNodeId();
                for (SysCodeDetail step : steps) {
                    if (step.getIsValid()) {
                        String contentName = leafNode.getId() + "_" + step.getId();
                        String problemName = firstNodeId + "_" + step.getId() + "_problem";
                        String content = request.getParameter(contentName);
                        String problem = request.getParameter(problemName);
                        if (!StringHelper.isEmpty(problem) || !StringHelper.isEmpty(content)) {
                            DataNodeReportItem dataItem = new DataNodeReportItem();
                            if (!StringHelper.isEmpty(problem)) {
                                dataItem.setProblem(problem);
                            }
                            if (!StringHelper.isEmpty(content)) {
                                dataItem.setContent(content);
                            }
                            dataItem.setNode(leafNode);
                            dataItem.setStep(step);
                            dataItem.setNodeReport(target);
                            dataItems.add(dataItem);
                        }
                    }
                }
            }
            dataNodeReportItemService.batchSave(dataItems, dataItems.size());
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 删除操作
     *
     * @param response .
     * @param id       .
     * @throws Exception .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) throws Exception {
        dataNodeReportService.delete(id);

        sendSuccessJSON(response, "删除成功");
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
    private List<DataNodeReportItem> findDataItems(Long projectId, Integer year, Integer month, String bidId) {
        String hql = "from DataNodeReportItem where nodeReport.project.id=" + projectId + " and nodeReport.year=" + year + " and nodeReport.month=" + month;
        if (null != bidId) {
            hql += " and nodeReport.bid.id=" + bidId;
        }
        hql += " order by id asc";
        return dataNodeReportItemService.findByQuery(hql);
    }

    /**
     * 获取形象进度标段
     *
     * @param projectId .
     * @return .
     */
    private List<ProjBid> getBids(Long projectId) {
        return projBidService.findByQuery(" from ProjBid where project.id=" + projectId + " and  typeCode='" + ProjBidType.TYPE_NODE.getCode() + "' order by no asc,id asc");
    }
}