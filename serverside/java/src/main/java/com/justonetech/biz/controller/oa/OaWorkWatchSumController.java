package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.OaWorkWatchService;
import com.justonetech.biz.daoservice.OaWorkWatchSumService;
import com.justonetech.biz.domain.OaWorkWatch;
import com.justonetech.biz.domain.OaWorkWatchSum;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.manager.SimpleQueryManager;
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
 * note:工作督办汇总
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaWorkWatchSumController extends BaseCRUDActionController<OaWorkWatchSum>
{
    private Logger logger = LoggerFactory.getLogger(OaWorkWatchSumController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private OaWorkWatchSumService oaWorkWatchSumService;

    @Autowired
    private OaWorkWatchService oaWorkWatchService;

    private OaWorkWatchSum oaWorkWatchSum = new OaWorkWatchSum();


    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model)
    {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_WORK_WATCH_SUM));

        return "view/oa/oaWorkWatchSum/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session)
    {
        try
        {
            String sql = "SELECT DISTINCT YEAR,MONTH,WEEK,BEGIN_DATE,END_DATE,CREATE_TIME FROM OA_WORK_WATCH_SUM ORDER BY CREATE_TIME DESC";
            //增加自定义查询条件
            QueryTranslateJq queryTranslateJq = new QueryTranslateJq(sql, filters);
            String querySql = queryTranslateJq.toString();
            List<Map> mapList = simpleQueryManager.getMapList(querySql);
            Page pageModel = new Page(page, rows, mapList);
            List<Map> rowList = pageModel.getRows();
            List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
            //处理数据放到页面
            Map<String, Object> map;
            for (Map data : rowList) {
                map = new HashMap<String, Object>();
                map.put("yearMonth", data.get("YEAR")+"年"+data.get("MONTH")+"月");
                map.put("hzTime",data.get("CREATE_TIME"));
                map.put("queryItems", data.get("YEAR")+","+data.get("MONTH")+","+data.get("WEEK")+","+data.get("BEGIN_DATE")+","+data.get("END_DATE"));
                retList.add(map);
            }
            //输出显示
            String json = GridJq.toJSON(retList, pageModel);
            sendJSON(response, json);


        } catch (Exception e)
        {
            log.error("error", e);
            super.processException(response, e);
        }
    }


    /**
     * 修改显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, String queryItems)
    {
        String[] queryItem = queryItems.split("\\,");
        Integer year = JspHelper.getInteger(queryItem[0]);
        Integer month = JspHelper.getInteger(queryItem[1]);
        Integer week = JspHelper.getInteger(queryItem[2]);
        Integer beginDate = JspHelper.getInteger(queryItem[3]);
        Integer endDate = JspHelper.getInteger(queryItem[4]);
        String hql = "from OaWorkWatchSum where year="+year+" and month="+month+" and week="+week+" and beginDate="+beginDate+" and endDate="+endDate;
        List<OaWorkWatchSum> byQuery = oaWorkWatchSumService.findByQuery(hql);
        ArrayList<OaWorkWatch> oaWorkWatches = new ArrayList<OaWorkWatch>();

        for (OaWorkWatchSum workWatchSum : byQuery)
        {
            OaWorkWatch oaWorkWatch = workWatchSum.getWorkWatch();
            oaWorkWatches.add(oaWorkWatch);
        }

        //处理其他业务逻辑
        model.addAttribute("reportTime", year + "年" + month + "月份第" + week + "周（" + beginDate + "~" + endDate + "日）工作督办一览表");
        model.addAttribute("oaWorkWatches", oaWorkWatches);

        return "view/oa/oaWorkWatchSum/view";
    }

    /**
     * 添加页面
     *
     * @param ids   .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model, String ids)
    {
        String[] oaWorkWatchIds = ids.split("\\/");

        ArrayList<OaWorkWatch> oaWorkWatches = new ArrayList<OaWorkWatch>();
        for (String oaWorkWatchId : oaWorkWatchIds)
        {
            OaWorkWatch oaWorkWatch = oaWorkWatchService.get(JspHelper.getLong(oaWorkWatchId));
            oaWorkWatches.add(oaWorkWatch);
        }
        model.addAttribute("ids", ids);
        model.addAttribute("oaWorkWatches", oaWorkWatches);

        //获取年和月的下拉框（为空为当前年月）
        Calendar c = Calendar.getInstance();
        String yearSelectOptions = DateTimeHelper.getYearSelectOptions(String.valueOf(c.get(Calendar.YEAR)));
        String monthSelectOptions = DateTimeHelper.getMonthSelectOptions(String.valueOf(c.get(Calendar.MONTH) + 1));
        String weeksOfMonthSelectOptions = getWeeksOfMonthSelectOptions(String.valueOf(c.get(Calendar.MONTH) + 1), String.valueOf(c.get(Calendar.WEEK_OF_MONTH)));
        String daysOfMonthSelectOptions = getDaysOfMonthSelectOptions();
        model.addAttribute("yearOptions", yearSelectOptions);
        model.addAttribute("monthOptions", monthSelectOptions);
        model.addAttribute("weekOptions", weeksOfMonthSelectOptions);
        model.addAttribute("dayOptions", daysOfMonthSelectOptions);
        return "view/oa/oaWorkWatchSum/input";
    }

    /**
     * 获取指定月的周数
     *
     * @param month 。
     * @param week  。
     * @return 。
     */
    public String getWeeksOfMonthSelectOptions(String month, String week)
    {
        String options = "";
        for (int i = 1; i < 6; i++)
        {
            if (!StringHelper.isEmpty(month))
            {
                if (week.equals(String.valueOf(i)))
                {
                    options += FormatUtils.format(JspHelper.SELECT_OPTION, week, week, "selected");
                } else
                {
                    options += FormatUtils.format(JspHelper.SELECTOPTION, i, i);
                }
            } else
            {
                options += FormatUtils.format(JspHelper.SELECTOPTION, i, i);
            }
        }

        options = StringHelper.findAndReplace(options, "'", "\"");
        options = StringHelper.findAndReplace(options, "\n", "");

        return options;
    }

    /*
     *获取每个月的天数
     */
    public String getDaysOfMonthSelectOptions()
    {
        String options = "";
        for (int i = 1; i < 32; i++)
        {
            options += FormatUtils.format(JspHelper.SELECTOPTION, i, i);
        }
        options = StringHelper.findAndReplace(options, "'", "\"");
        options = StringHelper.findAndReplace(options, "\n", "");
        return options;
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, HttpServletRequest request) throws Exception
    {
        try
        {
            String ids = request.getParameter("ids");
            String year = request.getParameter("year");
            String month = request.getParameter("month");
            String week = request.getParameter("week");
            String beginDay = request.getParameter("beginDay");
            String endDay = request.getParameter("endDay");

            String[] oaWorkWatchIds = ids.split("\\/");
            for (String oaWorkWatchId : oaWorkWatchIds)
            {
                OaWorkWatchSum oaWorkWatchSum = new OaWorkWatchSum();
                oaWorkWatchSum.setYear(JspHelper.getInteger(year));
                oaWorkWatchSum.setMonth(JspHelper.getInteger(month));
                oaWorkWatchSum.setWeek(JspHelper.getInteger(week));
                oaWorkWatchSum.setBeginDate(JspHelper.getInteger(beginDay));
                oaWorkWatchSum.setEndDate(JspHelper.getInteger(endDay));
                oaWorkWatchSum.setWorkWatch(oaWorkWatchService.get(JspHelper.getLong(oaWorkWatchId)));
                oaWorkWatchSumService.save(oaWorkWatchSum);
            }

        } catch (Exception e)
        {
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
     * @param ids       .
     * @throws Exception .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, String ids) throws Exception
    {
        String[] queryItem = ids.split("\\,");
        Integer year = JspHelper.getInteger(queryItem[0]);
        Integer month = JspHelper.getInteger(queryItem[1]);
        Integer week = JspHelper.getInteger(queryItem[2]);
        Integer beginDate = JspHelper.getInteger(queryItem[3]);
        Integer endDate = JspHelper.getInteger(queryItem[4]);
        String hql = "from OaWorkWatchSum where year="+year+" and month="+month+" and week="+week+" and beginDate="+beginDate+" and endDate="+endDate;
        List<OaWorkWatchSum> byQuery = oaWorkWatchSumService.findByQuery(hql);
        for (OaWorkWatchSum workWatchSum : byQuery)
        {
            oaWorkWatchSumService.delete(workWatchSum.getId());
        }

        sendSuccessJSON(response, "删除成功");
    }

}