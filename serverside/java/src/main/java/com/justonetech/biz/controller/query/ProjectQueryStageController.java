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
    private DataStageReportItemService dataStageReportItemService;

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
            String hql = "from ProjInfo order by id desc";
            //todo 根据权限过滤项目

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
        Set<Long> oneBidHS = new HashSet<Long>();  //只取最新上报的数据
        String hql = "from DataStageReportItem where stageReport.bid.id in(" + conditionHql + ") order by stageReport.year desc,stageReport.month desc,id desc";
//        System.out.println("hql = " + hql);
        List<DataStageReportItem> dataStageReportItems = dataStageReportItemService.findByQuery(hql);
        for (DataStageReportItem item : dataStageReportItems) {
            Long bidId = item.getStageReport().getBid().getId();
            if (!oneBidHS.contains(bidId)) {
                oneBidHS.add(bidId);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("resultCode", item.getResult().getCode());
                map.put("resultName", item.getResult().getName());
                map.put("dealDate", item.getDealDate());
                map.put("updateTime", item.getUpdateTime());
                dataMap.put(bidId + "_" + item.getStep().getId() + "_" + item.getStage().getId(), map);
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
                        lastMap.put(key + "_last", map);
                    }
                } else {
                    keyHS.add(key);
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("resultCode", item.getResult().getCode());
                    map.put("resultName", item.getResult().getName());
                    map.put("dealDate", item.getDealDate());
                    lastMap.put(key + "_last", map);
                }
            }
        }
        model.addAttribute("lastMap", lastMap);

        return "view/query/projectQueryStage/viewStageData";
    }
}