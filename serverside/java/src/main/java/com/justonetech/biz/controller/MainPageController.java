package com.justonetech.biz.controller;

import com.justonetech.biz.daoservice.NetSgpermitService;
import com.justonetech.biz.manager.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.JdStopOrderType;
import com.justonetech.biz.utils.enums.Platform;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.CryptUtil;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.system.domain.SysMenu;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SimpleQueryManager;
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
    private JdStopOrderManager jdStopOrderManager;

    @Autowired
    private NetSgpermitService netSgpermitService;

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
        model.addAttribute("projectArea", configManager.getProjectArea());
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
        //是否外网用户
        model.addAttribute("isRegPerson", sysUserManager.getSysUser().getRegPerson() != null);

        //公共信息
        model.addAttribute("code_policy", Constants.OA_PUBLIC_INFO_TYPE_POLICY);    //政策法规
        model.addAttribute("code_bulletin", Constants.OA_PUBLIC_INFO_TYPE_BULLETIN); //公告

        return "view/index/main";
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
        model.addAttribute("infoList", oaPublicInfoManager.getPublicList(Constants.OA_PUBLIC_INFO_RANGE_IN, Constants.OA_PUBLIC_INFO_TYPE_BULLETIN, 5));
        model.addAttribute("typeCodeBulletin", Constants.OA_PUBLIC_INFO_TYPE_BULLETIN);

        return "view/index/mainBulletin";
    }

    /**
     * 监督管理单据
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String mainJdForm(Model model, HttpServletRequest request) throws ParseException {
        Calendar c = Calendar.getInstance();      //当前日期

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
        String newcurdate = sdf.format(c.getTime()).substring(0, 7);
        //开据整改单
        int reformNum = jdStopOrderManager.getNum(JdStopOrderType.TYPE_REFORM.getCode(), newcurdate);
        model.addAttribute("reformNum", reformNum);

        //开据局部暂缓指令单
        int suspendNum = jdStopOrderManager.getNum(JdStopOrderType.TYPE_SUSPEND.getCode(), newcurdate);
        model.addAttribute("suspendNum", suspendNum);

        //开据停工指令单
        int stopNum = jdStopOrderManager.getNum(JdStopOrderType.TYPE_STOP.getCode(), newcurdate);
        model.addAttribute("stopNum", stopNum);

        //发放中标通知书
        String projectAreaCode = configManager.getProjectAreaCode().toUpperCase();
        String sqlFirst = "select count(bdh) num ,";
        String sqlLast = " where bid_date is not null and to_char(bid_date,'yyyy-mm')='" + newcurdate + "' and (bjbh like '__01" + projectAreaCode + "%' or bjbh like '__02" + projectAreaCode + "%') ";
        String sqlCfb = "select sum(num) from (" +
                sqlFirst + "'jl' as type from share_pro_jl_info" + sqlLast +
                "union " +
                sqlFirst + "'sg' as type from share_pro_sg_info" + sqlLast +
                "union " +
                sqlFirst + "'sj' as type from share_pro_sj_info" + sqlLast +
                "union " +
                sqlFirst + "'kc' as type from share_pro_kc_info" + sqlLast +
                ")";
        List listCfb = simpleQueryManager.getListBySql(sqlCfb);

        int cfbNum = 0;
        if (null != listCfb && listCfb.size() > 0) {
            cfbNum = JspHelper.getInteger(listCfb.iterator().next());
        }
        model.addAttribute("cfbNum", cfbNum);

        //发放施工许可
        String sqlSgpermit = "select count(bdh) from share_pro_sg_permit where issue_datetime is not null and to_char(issue_datetime,'yyyy-mm') = '" + newcurdate + "' and (bjbh like '__01" + projectAreaCode + "%' or bjbh like '__02" + projectAreaCode + "%') ";
        List listSgpermit = netSgpermitService.findBySql(sqlSgpermit);
        int sgpermitNum = 0;
        if (null != listSgpermit && listSgpermit.size() > 0) {
            sgpermitNum = JspHelper.getInteger(listSgpermit.iterator().next());
        }
        model.addAttribute("sgpermitNum", sgpermitNum);

        //企业资质
        String sqlUnitQualitify = "select count(a.id) from share_unit_qualify a,share_unit_info b where to_char(a.accept_datetime,'yyyy-mm')= '" + newcurdate + "' and a.unit_id=b.id and b.reg_city_code='310109'";
        int unitqualifyNum = simpleQueryManager.getIntegerBySql(sqlUnitQualitify);
        model.addAttribute("unitqualifyNum", unitqualifyNum);

        //标题
        String title = c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1) + "月";
        model.addAttribute("title", title);
        //当前查询日期
        curdate = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DATE);
        model.addAttribute("curdate", curdate);

        return "view/index/mainJdForm";
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
        model.addAttribute("taskCount", taskCount + msgCount);

        return "view/index/mainMsg";
    }
}
