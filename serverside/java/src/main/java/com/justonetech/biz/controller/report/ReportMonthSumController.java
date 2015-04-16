package com.justonetech.biz.controller.report;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.ReportDeptDefineService;
import com.justonetech.biz.daoservice.ReportMonthDetailService;
import com.justonetech.biz.daoservice.ReportMonthService;
import com.justonetech.biz.daoservice.ReportStructureService;
import com.justonetech.biz.domain.ReportMonth;
import com.justonetech.biz.manager.ReportMonthManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.JspHelper;
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
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date: 14-7-18
 * Time: 上午10:23
 */
@Controller
public class ReportMonthSumController extends BaseCRUDActionController<ReportMonth> {
    private Logger logger = LoggerFactory.getLogger(ReportMonthSumController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private ReportMonthService reportMonthService;

    @Autowired
    private ReportMonthDetailService reportMonthDetailService;

    @Autowired
    private ReportDeptDefineService reportDeptDefineService;

    @Autowired
    private ReportMonthManager reportMonthManager;

    @Autowired
    private ReportStructureService reportStructureService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //获取上一月
        Calendar c = Calendar.getInstance();
        String yearSelectOptions = DateTimeHelper.getYearSelectOptions(String.valueOf(c.get(Calendar.YEAR)));
        String monthSelectOptions = DateTimeHelper.getMonthSelectOptions(String.valueOf(c.get(Calendar.MONTH)));
        model.addAttribute("yearOptions", yearSelectOptions);
        model.addAttribute("monthOptions", monthSelectOptions);

        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.REPORT_STRUCTURE_EDIT));

        return "view/report/reportMonthSum/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     * @param session  .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session) {
        try {
            //按年月查询数据
            Page pageModel = new Page(page, rows, true);

//            String hql = "select year||month ,year,month from Report_Month  where 1=1 group by year,month order by year desc,month desc";
            String hql = "select year||month ,year,month,max(report_date)report_date from Report_Month  where 1=1 group by year,month order by year desc,month desc";
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = reportMonthService.findBySql(pageModel, query, null);

            //输出显示
            List list = pageModel.getRows();
            for (Object o : list) {
                Object[] objects = (Object[]) o;
                objects[1] = String.valueOf(objects[1]) + "年" + String.valueOf(objects[2]) + "月";
                objects[2] = objects[3];
            }
            //输出显示
            String json = GridJq.toJSON(list, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 查看汇总页面
     *
     * @param model .
     * @param id    .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        String yearMonth = JspHelper.getString(id);
        String year = yearMonth.substring(0, 4);//获取年
        String month = yearMonth.substring(4, yearMonth.length()); //获取月
        //根据年月得到科室的月报
        String hql = "from ReportMonth where 1=1 and year=" + Integer.parseInt(year) + " and month=" + Integer.parseInt(month) + " order by reportDeptDefine.id";
        List<ReportMonth> reportMonthList = reportMonthService.findByQuery(hql);
        ReportMonth reportMonth = reportMonthList.iterator().next();
        model.addAttribute("bean", reportMonth);

        List<Map<String, Object>> mapList = reportMonthManager.getReportStructureSumMapList(reportMonth);
        model.addAttribute("list", mapList);
        //如需增加其他默认值请在此添加
        model.addAttribute("reportTime", year + "年" + month + "月");

        return "view/report/reportMonthSum/view";
    }
}
