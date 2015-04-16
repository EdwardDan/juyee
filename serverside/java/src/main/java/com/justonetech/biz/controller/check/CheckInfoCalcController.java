package com.justonetech.biz.controller.check;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.daoservice.CheckManagerPositionService;
import com.justonetech.biz.daoservice.ProjectWorkSiteService;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.fushionChart.ChartData;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 考勤统计页面
 * User: Chen Junping
 * Date: 12-9-13
 */
@Controller
public class CheckInfoCalcController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(CheckInfoCalcController.class);

    @Autowired
    private ProjectWorkSiteService projectWorkSiteService;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private CheckManagerPositionService checkManagerPositionService;

    @Autowired
    private SysCodeManager sysCodeManager;
    private Map map;


    /**
     * 入口页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, String gdCode) {
        model.addAttribute("gdCode", gdCode);

        return "view/check/checkInfoCalc/grid";
    }

    /**
     * 获取图表
     *
     * @param request .
     * @param model   .
     * @return .
     */
    @RequestMapping
    public String chart(Model model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
        SysCodeDetail sysCodeDetail = sysCodeManager.getCodeDetailByCode(Constants.CHECK_MANAGER_POSITION, Constants.CHECK_MANAGER_POSITION_SBGUL);
        Long detailId = sysCodeDetail.getId();
        String gdCode = request.getParameter("gdCode");
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        if (StringHelper.isEmpty(month)) {
            Calendar c = Calendar.getInstance();
            year = c.get(Calendar.YEAR) + "";
            int m = c.get(Calendar.MONTH) + 1;
            if (m < 10) {
                month = "0" + m;
            } else {
                month = "" + m;
            }
        }

        String title = "当月签到人数统计";
        String deleteConditionSql = " and (a.is_delete={3} or (a.is_delete={4} and to_char(a.delete_time,'YYYY-MM')>'{1}-{2}'))";

        //查询管理人员总数
        String totalSql = "select count(distinct a.id) as num from check_manager a,check_manager_position b" +
                " where a.id=b.manager_id and b.gd_code='{0}'" +
                " and to_char(a.create_time,'YYYY-MM')<'{1}-{2}'" + deleteConditionSql +
                " and b.position_type<>" + detailId;

        int totalCount = simpleQueryManager.getIntegerBySql(FormatUtils.format(totalSql, gdCode, year, month, Constants.FLAG_FALSE, Constants.FLAG_TRUE));

        String monthSql = "select to_char(a.create_time,'YYYY-MM-DD') as day,count(distinct a.id) as num from check_manager a,check_manager_position b" +
                " where a.id=b.manager_id and b.gd_code='{0}'" +
                " and to_char(a.create_time,'YYYY-MM')='{1}-{2}'" + deleteConditionSql +
                " and b.position_type<>" + detailId +
                " group by to_char(a.create_time,'YYYY-MM-DD')" +
                " order by day";
        List managerList = simpleQueryManager.getMapList(FormatUtils.format(monthSql, gdCode, year, month, Constants.FLAG_FALSE, Constants.FLAG_TRUE));
        Map<String, Integer> managerHM = new HashMap<String, Integer>();
        for (Object obj : managerList) {
            Map map = (Map) obj;
            managerHM.put(JspHelper.getString(map.get("DAY")), JspHelper.getInteger(map.get("NUM")));
        }

        //查询月考勤人数
        String sql = "select day,count(mid) as num from (select distinct to_char(c.check_time,'YYYY-MM-DD') as day,c.manager_id as mid from check_info c,check_manager a"+
                " where c.gd_code='{0}' and to_char(c.check_time,'YYYY-MM')='{1}-{2}' and a.id=c.manager_id" +deleteConditionSql+
                " ) t group by day";
        sql = FormatUtils.format(sql, gdCode, year, month, Constants.FLAG_FALSE, Constants.FLAG_TRUE);
//        logger.debug("sql = " + sql);
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        List mapList = simpleQueryManager.getMapList(sql);
        for (Object object : mapList) {
            Map map = (Map) object;
            countMap.put(JspHelper.getString(map.get("DAY")), JspHelper.getInteger(map.get("NUM")));
        }
        int monthDays = DateTimeHelper.getMonthDays(Integer.valueOf(year), Integer.valueOf(month));
        Number[][] values = new Number[monthDays][2];
        String[] seriesNames = new String[]{"应签到人数", "实际签到人数"};
        String[] categoryNames = new String[monthDays];
        for (int i = 0; i < monthDays; i++) {
            String day = year + "-" + StringHelper.getPadCode(2, Integer.parseInt(month)) + "-" + StringHelper.getPadCode(2, (i + 1));
            categoryNames[i] = (i + 1) + "";
            int count = 0;
            if (countMap.containsKey(day)) {
                count = countMap.get(day);
            }
            int managerCount = JspHelper.getInteger(managerHM.get(day));
            totalCount += managerCount;
            values[i][0] = totalCount;
            values[i][1] = count;
        }
        ChartData chartData = new ChartData(title, categoryNames, seriesNames, values);

        //链接
        model.addAttribute("hasLink", false);

        //柱形图、折线颜色设置
        //        String[][] colors = {{"9933FF"},{"99CCFF"},{"FFCC33"},{"99CC00"},{"CC6633"},{"009999"},{"FF3333"}};
        String[][] colors = {{"99CC00", "9933FF", "FFCC33"}};
        model.addAttribute("colors", colors);

        model.addAttribute("data", chartData);
        return "view/check/checkInfoCalc/chart";
    }
}
