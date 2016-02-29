package com.justonetech.biz.controller;

import com.justonetech.biz.domain.OaPublicInfo;
import com.justonetech.biz.manager.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.Platform;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.CryptUtil;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysMenu;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysMenuManager;
import com.justonetech.system.manager.SysUserManager;
import org.hibernate.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 系统首页
 * User: Chen Junping
 * Date: 12-2-23
 */
@Controller
public class MainPageController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(MainPageController.class);

    @Autowired
    private SysMenuManager sysMenuManager;

    @Autowired
    private OaPublicInfoManager oaPublicInfoManager;

    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private PushUserManager pushUserManager;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private CustomGridManager customGridManager;

    @Autowired
    private MsgMessageManager msgMessageManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    private static final String IM_LOGIN_SWITCH = "IM_LOGIN_SWITCH";    //即时通信登录--只需要登录一次，刷新主页不再登录

    /**
     * 系统主页面框架
     *
     * @param model .
     * @return .
     * @throws IOException .
     */
    @RequestMapping
    public String index(Model model, HttpSession session) throws IOException {
        SysUser sysUser = sysUserManager.getSysUser();
        if (sysUser != null) {
            model.addAttribute("realName", sysUser.getDisplayName());
            model.addAttribute("userName", sysUser.getLoginName());
            String password = sysUser.getPassword();
            if (password.length() > 20) {
                try {
                    password = CryptUtil.decrypt(password);
                } catch (Exception e) {

                }
            }
            model.addAttribute("password", password);
            model.addAttribute("Md5Pass", sysUser.getMd5Pass());
        }
        model.addAttribute("siteName", configManager.getSiteName());

        //初始时间
        String init_dateTime = DateTimeHelper.formatTimestamp(new Timestamp(System.currentTimeMillis()), "");
        init_dateTime = StringHelper.replace(init_dateTime, "-", ":");
        init_dateTime = StringHelper.replace(init_dateTime, " ", ":");
        model.addAttribute("init_dateTime", init_dateTime);

        //所属平台
        model.addAttribute("PLATFORM_OA", Platform.PLATFORM_OA.getCode());
        model.addAttribute("PLATFORM_OA_NAME", Platform.PLATFORM_OA.getName());
        model.addAttribute("PLATFORM_BIZ", Platform.PLATFORM_BIZ.getCode());
        model.addAttribute("PLATFORM_BIZ_NAME", Platform.PLATFORM_BIZ.getName());

        return "view/index";
    }

    /**
     * 获取菜单
     *
     * @param model .
     * @return .
     * @throws IOException
     */
    @RequestMapping
    public String menu(Model model, String platform) throws IOException {
        //用户授权菜单
//        model.addAttribute("xmlJsonString", sysMenuManager.getUserMenuJson(loginUser.getId()));
//        model.addAttribute("xmlJsonString", sysMenuManager.getAllMenuJson());

        if (StringHelper.isEmpty(platform)) {
            platform = Platform.PLATFORM_OA.getCode();
        }
        List<Map> newMenus = sysMenuManager.getNewMenus(platform);
        model.addAttribute("list", newMenus);

        String ids = "";
        for (Map newMenu : newMenus) {
            SysMenu menu = (SysMenu) newMenu.get("menu");
            String id = String.valueOf(menu.getId());
            if ("".equals(ids)) {
                ids = id;
            } else {
                ids += "," + id;
            }
        }
        model.addAttribute("menuIds", ids);

        return "view/index/menu";
    }

    /**
     * 系统首页
     *
     * @param model .
     * @return .
     * @throws IOException .
     */
    @RequestMapping
    public String main(Model model) {
        SysUser sysUser = sysUserManager.getSysUser();
        boolean flag = true;
        if (null != sysUser) {
            //是否外网用户
            if (null != sysUser.getRegPerson()) {
                flag = false;
            }
            //是否是建设单位用户
            if (null != sysUser.getPerson()) {
                SysDept dept = sysUser.getPerson().getDept();
                if (null != dept) {
                    SysDept company = getParentCompany(dept);
                    if (null != company) {
                        String code = company.getCode();
                        if (StringHelper.isEmpty(code) || (!StringHelper.isEmpty(code) && !code.equals("OWNER") && !code.equals("JYKJ") && !code.equals("3"))) {
                            flag = false;
                        }
                    }
                }
            }
        }
        model.addAttribute("flag", flag);

        //公共信息
        model.addAttribute("code_policy", Constants.OA_PUBLIC_INFO_TYPE_POLICY);    //政策法规
        model.addAttribute("code_bulletin", Constants.OA_PUBLIC_INFO_TYPE_BULLETIN); //公告

        return "view/index/main";
    }

    private SysDept getParentCompany(SysDept dept) {
        if (dept.getIsTag() != null && dept.getIsTag()) {
            return dept;
        }
        if (dept.getParent() != null) {
            return getParentCompany(dept.getParent());
        } else {
            return dept;
        }
    }

    /**
     * 推送列表
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String mainTask(Model model) {

        model.addAttribute("list", pushUserManager.getPushDefineList());

        return "view/index/mainTask";
    }

    /**
     * 公共信息
     *
     * @param model   .
     * @param orderNo .
     * @return .
     */
    @RequestMapping
    public String mainInfo(Model model, int orderNo) {
        model.addAttribute("orderNo", orderNo);
        model.addAttribute("bean", customGridManager.getGridData(orderNo));

        return "view/index/mainInfo";
    }

    /**
     * 公告
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String mainBulletin(Model model) {
        List<OaPublicInfo> publicList = oaPublicInfoManager.getPublicList(Constants.OA_PUBLIC_INFO_RANGE_IN, Constants.OA_PUBLIC_INFO_TYPE_BULLETIN, 6);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (OaPublicInfo info : publicList) {
            Map<String, Object> map = new HashMap<String, Object>();
            Date reportDate = info.getReportDate();
            Date endDate = new Date(System.currentTimeMillis());
            int days = DateTimeHelper.getDays(endDate, reportDate);
            map.put("info", info);
            map.put("day", days <= 3 ? true : false);
            list.add(map);
        }
        model.addAttribute("infoList", list);
        model.addAttribute("typeCodeBulletin", Constants.OA_PUBLIC_INFO_TYPE_BULLETIN);
        SysCodeDetail detail = sysCodeManager.getCodeDetailByCode(Constants.OA_PUBLIC_INFO_TYPE, Constants.OA_PUBLIC_INFO_TYPE_BULLETIN);
        model.addAttribute("typeName", detail.getName());

        return "view/index/mainBulletin";
    }

    /**
     * 日程
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String mainDaily(Model model, HttpServletRequest request) throws ParseException {

        Calendar c = Calendar.getInstance();      //当前日期
        int thisyear = c.get(Calendar.YEAR);
        int thismonth = (c.get(Calendar.MONTH) + 1);


        //查询日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String curdate = request.getParameter("curdate") == null ? DateTimeHelper.getCurrentDate() : request.getParameter("curdate");
        String query = request.getParameter("query") == null ? "" : request.getParameter("query");

        c.setTime(sdf.parse(curdate));
        if ("prev".equals(query)) {
            c.add(Calendar.MONTH, -1);
        } else if ("next".equals(query)) {
            c.add(Calendar.MONTH, 1);
        }

        //2005.12.31 增加：当返回同年同月时，同时设置日期为当前日期
        if (c.get(Calendar.YEAR) == thisyear && (c.get(Calendar.MONTH) + 1) == thismonth) {
            curdate = DateTimeHelper.getCurrentDate();
            c.setTime(sdf.parse(curdate));
//        System.out.println("curdate = " + curdate);
        }

        //星期排列
        String[] weeks = new String[]{"日", "一", "二", "三", "四", "五", "六"};
        int day_of_week = c.get(Calendar.DAY_OF_WEEK);

        //标题
        String title = c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1) + "月";
        String title_week = "星期" + weeks[day_of_week - 1];
        model.addAttribute("title", title);
        model.addAttribute("week", title_week);

        //该1日是星期几
        Calendar start = Calendar.getInstance();
        start.setTime(sdf.parse(curdate));
        if ("prev".equals(query)) {
            start.add(Calendar.MONTH, -1);
        } else if ("next".equals(query)) {
            start.add(Calendar.MONTH, 1);
        }
        //2005.12.31 增加：当返回同年同月时，同时设置日期为当前日期
        if (c.get(Calendar.YEAR) == thisyear && (c.get(Calendar.MONTH) + 1) == thismonth) {
            start.setTime(sdf.parse(curdate));
        }

        //查询本月的个人日程
        Map<Integer, Object> existMap = new HashMap<Integer, Object>();
//        String startdate = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-1";
//        String enddate = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.getActualMaximum(Calendar.DAY_OF_MONTH);
//        String dailyHql = "from OaDailyplan where personid={0} and status='{1}'" +
//                " and begintime<=(to_date('{3}','YYYY-MM-DD')+1)" +
//                " and (begintime>=to_date('{2}','YYYY-MM-DD') or endtime>=to_date('{2}','YYYY-MM-DD'))";
//        dailyHql += " order by begintime asc";
//        dailyHql = FormatUtil.format(dailyHql, String.valueOf(userSession.getPersonId()), Constant.OA_DAILYSTATUS_NORMAL, startdate, enddate);
////        System.out.println("dailyHql = " + dailyHql);
//        List<OaDailyplan> dailyList = AppService.getService().findByQuery(dailyHql);
//        Calendar c2 = Calendar.getInstance();
//        for (OaDailyplan data : dailyList) {
//            c2.setTimeInMillis(data.getBegintime().getTime());
//            existMap.put(c2.get(Calendar.DATE), data);
//        }

        start.set(Calendar.DATE, 1);
        int startno = start.get(Calendar.DAY_OF_WEEK) - 1;

        //当前查询日期
        curdate = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DATE);
        model.addAttribute("curdate", curdate);
        boolean isthismonth = false;
        if (thisyear == c.get(Calendar.YEAR) && thismonth == (c.get(Calendar.MONTH) + 1))       //是否当月
        {
            isthismonth = true;
        }

        int s = (1 - startno);
        int actualMaximum = c.getActualMaximum(Calendar.DATE);
        int e = actualMaximum;

        //补足td  *7的倍数
        if ((e + startno) % 7 > 0) {
            e += 7 - ((e + startno) % 7);
        }

        //日期
        StringBuffer sb = new StringBuffer();
        int curday = c.get(Calendar.DAY_OF_MONTH);

        String style = " style=\"background-image: url( /skin/index_new/rili_td_alert.png)\"";

        model.addAttribute("startNo", startno);
        model.addAttribute("beginDay", s);
        model.addAttribute("endDay", e);

        List<Map> ret = new ArrayList<Map>();
        for (int i = s; i <= e; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("no", i);
            map.put("day", i);
            map.put("hint", "");
            map.put("alert", false);
            map.put("alertDate", "");
            map.put("id", "");

            String tdClass = "";
            if (i > 0 && i <= actualMaximum) {
                tdClass = "rili_normal";
                if (isthismonth && curday == i) {
                    tdClass = "rili_today";         //当天
                } else if ((i + startno) % 7 == 1 || (i + startno) % 7 == 0) {
                    tdClass = "rili_weekend";         //周末
                }

                Object o = existMap.get(i);
                if (o != null) {
                    map.put("alert", true);
                    map.put("alertDate", c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + i);
                    map.put("hint", "点击查看当天个人日程");
//                    OaDailyplan plan = (OaDailyplan) o;
//                    map.put("hint", plan.getTitle());
//                    map.put("id", plan.getId());

                } else {
                    map.put("hint", c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1) + "月" + i + "日");
                }
            } else if (i <= 0) {
                Calendar m = Calendar.getInstance();
                m.setTime(start.getTime());
                m.add(Calendar.DATE, (i - 1));
                tdClass = "rili_none";
                map.put("day", m.get(Calendar.DAY_OF_MONTH));

            } else if (i > actualMaximum) {
                Calendar m = Calendar.getInstance();
                m.setTime(start.getTime());
                m.add(Calendar.MONTH, 1);
                m.add(Calendar.DATE, (i - actualMaximum - 1));
                tdClass = "rili_none";
                map.put("day", m.get(Calendar.DAY_OF_MONTH));
            }
            map.put("tdClass", tdClass);
            ret.add(map);
        }
        model.addAttribute("data", ret);
        model.addAttribute("weeks", weeks);
        model.addAttribute("sb", sb);

        return "view/index/mainDaily";
    }

    /**
     * 其他
     *
     * @param model 。
     * @return 。
     */
    @RequestMapping
    public String mainQt(Model model) {

        return "view/index/mainQt";
    }

    /**
     * 消息通知
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String mainMsg(Model model) {
        SysUser sysUser = sysUserManager.getSysUser();

        //MIS系统待办事项和通知
        int taskCount = oaTaskManager.getTaskDealList(sysUser.getId()).size();
        int msgCount = msgMessageManager.getMyMsgs(true).size();
        model.addAttribute("count1", taskCount);
        model.addAttribute("count2", msgCount);
        model.addAttribute("taskCount", taskCount);

        return "view/index/mainMsg";
    }
}
