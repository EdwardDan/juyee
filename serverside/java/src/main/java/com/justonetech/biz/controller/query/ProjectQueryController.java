package com.justonetech.biz.controller.query;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


/**
 * note:项目查询
 */
@Controller
public class ProjectQueryController extends BaseCRUDActionController<ProjInfo> {
    private Logger logger = LoggerFactory.getLogger(ProjectQueryController.class);

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
    private ProjNodeService projNodeService;

    @Autowired
    private DataStageReportService dataStageReportService;

    @Autowired
    private DataStageReportItemService dataStageReportItemService;

    @Autowired
    private DataNodeReportService dataNodeReportService;

    @Autowired
    private DataNodeReportItemService dataNodeReportItemService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有查看汇总权限
//      model.addAttribute("canViewAll",sysUserManager.hasPrivilege(PrivilegeCode.SYS_SAMPLE_EDIT));
        model.addAttribute("canViewAll", true);

        return "view/query/projectQuery/grid";
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
            //根据权限过滤项目

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
        ProjInfo projInfo = projInfoService.get(id);
        Set<ProjBid> bids = projInfo.getProjBids();
        model.addAttribute("bids", bids);

        //填报数据
        Map<String, Object> dataMap = new HashMap<String, Object>();
        Set<Long> oneBidHS = new HashSet<Long>();  //只取最新上报的数据
        String hql = "from DataStageReportItem where stageReport.project.id=? order by stageReport.year desc,stageReport.month desc,id desc";
        List<DataStageReportItem> dataStageReportItems = dataStageReportItemService.findByQuery(hql, id);
        for (DataStageReportItem item : dataStageReportItems) {
            Long bidId = item.getStageReport().getBid().getId();
            if (!oneBidHS.contains(bidId)) {
                oneBidHS.add(bidId);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("resultCode", item.getResult().getCode());
                map.put("resultName", item.getResult().getName());
                map.put("dealDate", item.getDealDate());
                dataMap.put(bidId + "_" + item.getStep().getId() + "_" + item.getStage().getId(), map);
            }
        }
        model.addAttribute("dataMap", dataMap);

        return "view/query/projectQuery/viewStage";
    }

    /**
     * 查看形象进度信息
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String viewNode(Model model, Long id) {
        Calendar c = Calendar.getInstance();
        model.addAttribute("yearOptions", DateTimeHelper.getYearSelectOptions(String.valueOf(c.get(Calendar.YEAR))));
        model.addAttribute("id", id);
        model.addAttribute("currentMonth", c.get(Calendar.MONTH) + 1);

        return "view/query/projectQuery/viewNode";
    }

    /**
     * 查看形象进度信息
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String viewNodeData(Model model, Long id, int year, int month) {
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

        //标段列表
        ProjInfo projInfo = projInfoService.get(id);
        Set<ProjBid> bids = projInfo.getProjBids();
        model.addAttribute("bids", bids);

        //填报数据
        Map<String, Object> dataMap = new HashMap<String, Object>();
        String hql = "from DataNodeReportItem where nodeReport.project.id=? and nodeReport.year=? and nodeReport.month=? order by id asc";
        List<DataNodeReportItem> dataNodeReportItems = dataNodeReportItemService.findByQuery(hql, id, year, month);
        for (DataNodeReportItem item : dataNodeReportItems) {
            Long bidId = item.getNodeReport().getBid().getId();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("content", item.getContent());
            map.put("problem", item.getProblem());
            dataMap.put(bidId + "_" + item.getStep().getId() + "_" + item.getNode().getId(), map);
        }
        model.addAttribute("dataMap", dataMap);

        return "view/query/projectQuery/viewNodeData";
    }
}