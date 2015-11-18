package com.justonetech.biz.controller.oa;

import com.justonetech.biz.daoservice.OaWeekArrangeService;
import com.justonetech.biz.domain.OaWeekArrange;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysDeptService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysUser;
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
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * note:领导一周安排
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaWeekArrangeController extends BaseCRUDActionController<OaWeekArrange> {
    private Logger logger = LoggerFactory.getLogger(OaWeekArrangeController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysDeptService sysDeptService;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private OaWeekArrangeService oaWeekArrangeService;

    /**
     * 初始化页面
     *
     * @param model 。
     * @return 。
     */
    @RequestMapping
    public String init(Model model, HttpServletRequest request) {
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        System.out.println("startDate///////////////////////////////// = " + startDate);
        System.out.println("endDate = " + endDate);
        String start;
        String end;
        if (!StringHelper.isEmpty(startDate) && !StringHelper.isEmpty(endDate)) {
            start = startDate;
            end = endDate;
            model.addAttribute("startDate", Date.valueOf(start));
            model.addAttribute("endDate", Date.valueOf(end));
        } else {
            Calendar c = Calendar.getInstance();
            int i1 = c.get(Calendar.DAY_OF_WEEK);
            c.add(Calendar.DATE, 2 - i1); //回溯到周一
            //日历循环
            for (int i = 0; i < 7; i++) {
                String month = (c.get(Calendar.MONTH) + 1) + "";
                String day = (c.get(Calendar.DATE)) + "";
                if (month.length() == 1) {
                    month = "0" + month;
                }
                if (day.length() == 1) {
                    day = "0" + day;
                }
                if (i == 0) {
                    start = c.get(Calendar.YEAR) + "-" + month + "-" + day;
                    model.addAttribute("startDate", start);
                }
                if (i == 6) {
                    end = c.get(Calendar.YEAR) + "-" + month + "-" + day;
                    model.addAttribute("endDate", end);
                }
                c.add(Calendar.DATE, 1);//日历+1
            }
        }
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_WEEKARRANGE_EDIT));
        return "view/oa/oaWeekArrange/init";
    }

    /**
     * data数据封装
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String data(Model model, HttpServletRequest request) {
        doData(model, request);

        return "view/oa/oaWeekArrange/data";
    }

    /**
     * 编辑页面
     *
     * @param model   。
     * @param request 。
     * @return 。
     */
    @RequestMapping
    public String modify(Model model, HttpServletRequest request) {
        doData(model, request);

        return "view/oa/oaWeekArrange/input";
    }

    /**
     * 处理数据
     *
     * @param model   。
     * @param request 。
     */
    public void doData(Model model, HttpServletRequest request) {
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        Date start = Date.valueOf(startDate);
        Date end = Date.valueOf(endDate);
        model.addAttribute("start", start);
        model.addAttribute("end", end);

        Calendar c = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        //星期数组
        String[] weeks = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
        String[] weekDates = new String[7];
        String[] dates = new String[7];
        for (int i = 1; i < 8; i++) {
            c.setTime(start);
            c.add(Calendar.DATE, i - 1);
            weekDates[i - 1] = weeks[i - 1] + "<br>(" + sdf.format(c.getTime()) + ")";
            dates[i - 1] = sdf.format(c.getTime());
        }
        model.addAttribute("weekDates", weekDates);
        model.addAttribute("dates", dates);
        List<SysDept> deptList = sysDeptService.findByQuery("from SysDept where code=?", Constants.OA_WEEK_ARRANGE_ZXLD);
        if (null != deptList && deptList.size() > 0) {
            SysDept dept = deptList.iterator().next();
            List<SysUser> userList = sysUserManager.getDeptUsers(dept);
            model.addAttribute("userList", userList);
        }
        List<SysCodeDetail> periodList = sysCodeManager.getCodeListByCode(Constants.OA_WEEK_ARRANGE_PERIOD);
        model.addAttribute("periodList", periodList);

        String hql = "from OaWeekArrange where day between ? and ? order by day asc";
        List<OaWeekArrange> list = oaWeekArrangeService.findByQuery(hql, start, end);
        Map<String, Object> mapHM = new HashMap<String, Object>();
        if (null != list && list.size() > 0) {
            for (OaWeekArrange arrange : list) {
                mapHM.put("content_" + arrange.getUser().getId() + "_" + arrange.getTimePeriod().getId() + "_" + arrange.getDay(), arrange.getContent());
            }
        }
        model.addAttribute("mapHM", mapHM);
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
    public void save(HttpServletResponse response, HttpServletRequest request) throws Exception {
        try {
            Calendar c = new GregorianCalendar();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date start = Date.valueOf(request.getParameter("start"));
            String[] dates = new String[7];
            for (int i = 1; i < 8; i++) {
                c.setTime(start);
                c.add(Calendar.DATE, i - 1);
                dates[i - 1] = sdf.format(c.getTime());
            }
            List<OaWeekArrange> list = new ArrayList<OaWeekArrange>();
            List<SysDept> deptList = sysDeptService.findByQuery("from SysDept where code=?", Constants.OA_WEEK_ARRANGE_ZXLD);
            if (null != deptList && deptList.size() > 0) {
                SysDept dept = deptList.iterator().next();
                List<SysUser> userList = sysUserManager.getDeptUsers(dept);
                List<SysCodeDetail> periodList = sysCodeManager.getCodeListByCode(Constants.OA_WEEK_ARRANGE_PERIOD);
                for (SysUser user : userList) {
                    for (SysCodeDetail period : periodList) {
                        for (String date : dates) {
                            String value = request.getParameter("content_" + user.getId() + "_" + period.getId() + "_" + date);
                            if (!StringHelper.isEmpty(value)) {
                                OaWeekArrange oaWeekArrange = new OaWeekArrange();
                                String hql = "from OaWeekArrange where day=? and user.id=? and timePeriod.id=?";
                                List<OaWeekArrange> arrangeList = oaWeekArrangeService.findByQuery(hql, Date.valueOf(date), user.getId(), period.getId());
                                if (null != arrangeList && arrangeList.size() > 0) {
                                    oaWeekArrange = arrangeList.iterator().next();
                                }
                                oaWeekArrange.setUser(user);
                                oaWeekArrange.setTimePeriod(period);
                                oaWeekArrange.setDay(Date.valueOf(date));
                                oaWeekArrange.setContent(value);
                                list.add(oaWeekArrange);
                            }
                        }
                    }
                }
            }
            oaWeekArrangeService.batchSave(list, list.size());

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

}