package com.justonetech.biz.manager;

import com.justonetech.biz.daoservice.OaDeptNewsService;
import com.justonetech.biz.daoservice.OaMonthplanService;
import com.justonetech.biz.daoservice.OaQuarterplanService;
import com.justonetech.biz.daoservice.ProjectBidSignService;
import com.justonetech.biz.domain.OaDeptNews;
import com.justonetech.biz.domain.OaMonthplan;
import com.justonetech.biz.domain.OaQuarterplan;
import com.justonetech.biz.domain.ProjectBidSign;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.system.daoservice.SysPersonDeptService;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.domain.SysPersonDept;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import freemarker.template.utility.StringUtil;
import org.hibernate.annotations.common.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 每天和每月的短信提醒
 * Date: 2014-7-2
 */
@Service
public class MsgAlertManager {

    private Logger logger = LoggerFactory.getLogger(MsgAlertManager.class);

    @Autowired
    private MsgMessageManager msgMessageManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private SysPersonDeptService sysPersonDeptService;

    @Autowired
    private OaMonthplanService oaMonthplanService;

    @Autowired
    private OaDeptNewsService oaDeptNewsService;

    @Autowired
    private SysDeptManager sysDeptManager;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private OaQuarterplanService oaQuarterplanService;

    @Autowired
    private ProjectBidSignService projectBidSignService;

    /**
     * ******************************************************每天短信通知***************************************************************
     */
    public void sendSmsEveryday() {
//        if (configManager.getSendSms()) {  //开关打开后才能发送短信，否则只有系统消息
        //查询待办事项
        Map<Long, Integer> taskMap = new HashMap<Long, Integer>();
        String taskSql = "select distinct p.id,count(td.id) as num from oa_task_deal td,sys_user u,sys_person p" +
                " where td.status<>'{0}' and td.user_id=u.id and u.person_id=p.id group by p.id";
        taskSql = FormatUtils.format(taskSql, Constants.OA_TASK_DELETE);
        List tasks = simpleQueryManager.getMapList(taskSql);
        for (Object task : tasks) {
            Map map = (Map) task;
            taskMap.put(JspHelper.getLong(map.get("ID")), JspHelper.getInteger(map.get("NUM")));
        }

        //查询消息通知
        Map<Long, Integer> msgMap = new HashMap<Long, Integer>();
        String msgSql = "select distinct sd.sys_person_id as id,count(sd.id) as num from msg_send_detail sd" +
                " where sys_person_id is not null and read_time is null" +
                " group by sd.sys_person_id";
        List msgs = simpleQueryManager.getMapList(msgSql);
        for (Object msg : msgs) {
            Map map = (Map) msg;
            msgMap.put(JspHelper.getLong(map.get("ID")), JspHelper.getInteger(map.get("NUM")));
        }

        //获取建管署人员
        List<Map<String, Object>> waitList = new ArrayList<Map<String, Object>>();
        String hql = "from SysPersonDept pd where pd.dept.code='{0}' or (pd.dept.parent is not null and pd.dept.parent.code='{0}') order by orderNo asc";
        hql = FormatUtils.format(hql, Constants.SYS_DEPT_OWNER);
        List<SysPersonDept> persons = sysPersonDeptService.findByQuery(hql);
        for (SysPersonDept personDept : persons) {
            SysPerson person = personDept.getPerson();
            String mobile = person.getMobile();
            Long personId = person.getId();
            int taskCount = JspHelper.getInteger(taskMap.get(personId));
            int msgCount = JspHelper.getInteger(msgMap.get(personId));
            int oaCount = 0;
            Set<SysUser> sysUsers = person.getSysUsers();
            if (sysUsers.size() > 0) {

            }
            if (!StringHelper.isEmpty(mobile)) {
                if (taskCount > 0 || msgCount > 0 || oaCount > 0) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("mobile", mobile);
                    map.put("taskCount", taskCount);
                    map.put("msgCount", msgCount);
                    map.put("oaCount", oaCount);
                    waitList.add(map);
                }
            }
        }

        //发送短信
        String msgTemp = "MIS系统提醒：您有{0}条待办事项，{1}条事项通知，{2}条OA待办事项。";
        for (Map<String, Object> map : waitList) {
            String mobile = JspHelper.getString(map.get("mobile"));
            int taskCount = JspHelper.getInteger(map.get("taskCount"));
            int msgCount = JspHelper.getInteger(map.get("msgCount"));
            int oaCount = JspHelper.getInteger(map.get("oaCount"));
            String msg = FormatUtils.format(msgTemp, taskCount, msgCount, oaCount);
            msgMessageManager.sendSms(msg, mobile);
        }
//        }
    }


    /**
     * ******************************************************每月短信通知***************************************************************
     */
    //每月通知入口
    public void sendSmsEveryMonth() {
//        if (configManager.getSendSms()) {  //开关打开后才能发送短信
        Map<String, SysPerson> deptLeaderMap = sysDeptManager.getDeptLeaderMap();

        sendSmsByOaDeptNews(deptLeaderMap);   //科室新闻
        sendSmsByOaMonthPlan(deptLeaderMap);  //月度计划
        sendSmsByOaYearPlan(deptLeaderMap);   //季度年度计划
        sendSmsByBidPay();     //  招标科录入提醒

//        }
    }

    /**
     * 招投标保证金，发给招标科录入提醒
     */
    private void sendSmsByBidPay() {
        String privilegeCode = PrivilegeCode.PROJECT_BID_PAY_APPLY;
        List<SysUser> sysUsers = sysUserManager.getUsersByPrivilegeCode(privilegeCode);
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);
        int month = ca.get(Calendar.MONTH) + 1;
        int day = ca.get(Calendar.DAY_OF_MONTH);
        int hour = ca.get(Calendar.HOUR_OF_DAY);
        // 每天9点发信息
        if (9 == hour) {
            String projectNames = "";
            // 查询投标保证金截止日期是当天的记录
            String hql_ProjectName = "from ProjectBidSign where to_char(signDate,'YYYY-MM-DD')='{0}-{1}-{2}'";
            hql_ProjectName = FormatUtils.format(hql_ProjectName, String.valueOf(year),
                    StringUtil.leftPad(String.valueOf(month), 2, "0"), StringUtil.leftPad(String.valueOf(day), 2, "0"));
            List<ProjectBidSign> signs = projectBidSignService.findByQuery(hql_ProjectName);
            if (null != signs) {
                for (ProjectBidSign sign : signs) {
                    projectNames += "," + sign.getProjectName();
                }
            }
            if (StringHelper.isNotEmpty(projectNames) && null != sysUsers) {
                String msgTemp = projectNames.substring(1) + "项目，保证金今天截止缴纳，请尽快录入缴纳信息。";
                for (SysUser sysUser : sysUsers) {
                    //判断是否要提醒
                    SysPerson person = sysUser.getPerson();
                    if (person != null) {
                        msgMessageManager.sendSms(msgTemp, person.getMobile());
                    }
                }
            }
        }
    }

    /**
     * 科室新闻月度通知
     */
    private void sendSmsByOaDeptNews(Map<String, SysPerson> deptLeaderMap) {
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);
        int month = ca.get(Calendar.MONTH) + 1;
        int day = ca.get(Calendar.DAY_OF_MONTH);
        if (10 == day || 20 == day || 30 == day) {
            String msgTemp = "MIS系统提醒：您的科室本月还未提交过一篇新闻，请尽快提交！";

            // 查询当月已提交的计划和总结
            Set<String> existDeptHS = new HashSet<String>();
            String hql = "from OaDeptNews where to_char(reportDate,'YYYY-MM')='{0}-{1}'";
            hql = FormatUtils.format(hql, String.valueOf(year), StringUtil.leftPad(String.valueOf(month), 2, "0"));
            List<OaDeptNews> list = oaDeptNewsService.findByQuery(hql);
            for (OaDeptNews data : list) {
                existDeptHS.add(data.getReportDept());
            }

            //判断是否要提醒
            checkIsSendMsg(existDeptHS, deptLeaderMap, msgTemp);
        }
    }

    /**
     * 总结和计划月度通知
     */
    private void sendSmsByOaMonthPlan(Map<String, SysPerson> deptLeaderMap) {
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);
        int month = ca.get(Calendar.MONTH) + 1;
        int day = ca.get(Calendar.DAY_OF_MONTH);

        // 科长每月20日到23日每天增加一条事项通知
        if (20 <= day && day <= 23) {
            String msgTemp = "MIS系统提醒：您的科室还未提交" + month + "月份的总结和计划，请尽快提交！";

            // 查询当月已提交的计划和总结
            Set<String> existDeptHS = new HashSet<String>();
            String hql = "from OaMonthplan where year=? and period=?";
            List<OaMonthplan> list = oaMonthplanService.findByQuery(hql, year, month);
            for (OaMonthplan data : list) {
                existDeptHS.add(data.getReportDept());
            }

            //判断是否要提醒
            checkIsSendMsg(existDeptHS, deptLeaderMap, msgTemp);
        }
    }

    /**
     * 总结和计划季度/年度度通知
     */
    private void sendSmsByOaYearPlan(Map<String, SysPerson> deptLeaderMap) {
        Calendar ca = Calendar.getInstance();
        // 年
        Integer year = ca.get(Calendar.YEAR);
        // 月
        Integer month = ca.get(Calendar.MONTH) + 1;
        // 日
        Integer day = ca.get(Calendar.DAY_OF_MONTH);
        // 季度
        Integer season = getSeason();
        // 当前季度的最后一个月
        Integer lastMonth = getLastMonth(season);

        //季度计划：最后一个月的10日开始每天增加一条事项通知
        if (10 <= day && lastMonth.equals(month)) {
            String msgTemp = "MIS系统提醒：您的科室还未提交第" + season + "季度的总结和计划，请尽快提交！";

            // 查询本季度已提交的计划和总结
            Set<String> quarterplanDeptHS = new HashSet<String>();
            String hql = "from OaQuarterplan where year=? and period=?";
            List<OaQuarterplan> list = oaQuarterplanService.findByQuery(hql, year, season);
            for (OaQuarterplan data : list) {
                quarterplanDeptHS.add(data.getReportDept());
            }

            //判断是否要提醒
            checkIsSendMsg(quarterplanDeptHS, deptLeaderMap, msgTemp);
        }

        //年度计划：最后一个月的10日开始每天增加一条事项通知
        if (10 <= day && lastMonth == (Calendar.DECEMBER + 1)) {
            String msgTemp = "MIS系统提醒：您的科室还未提交" + year + "年度的总结和计划，请尽快提交！";

            // 查询本季度已提交的计划和总结
            Set<String> yearplanDeptHS = new HashSet<String>();
            String hql = "from OaQuarterplan where year=? and period is null";
            List<OaQuarterplan> list = oaQuarterplanService.findByQuery(hql, year);
            for (OaQuarterplan data : list) {
                yearplanDeptHS.add(data.getReportDept());
            }

            //判断是否要提醒
            checkIsSendMsg(yearplanDeptHS, deptLeaderMap, msgTemp);
        }
    }

    /**
     * 判断是否要发送提醒短信
     *
     * @param existDeptHS   .
     * @param deptLeaderMap .
     * @param msgTemp       .
     */
    private void checkIsSendMsg(Set<String> existDeptHS, Map<String, SysPerson> deptLeaderMap, String msgTemp) {
        //业主部门
        List<SysDept> ownerDepts = sysDeptManager.getOwnerDepts();
        for (SysDept ownerDept : ownerDepts) {
            if (!existDeptHS.contains(ownerDept.getName())) {
                SysPerson person = deptLeaderMap.get(ownerDept.getName());
                if (person != null) {
                    msgMessageManager.sendSms(msgTemp, person.getMobile());
                }
            }
        }
    }

    /**
     * 获取当前季度的最后一个月
     *
     * @param season 季度
     * @return month 月份
     */
    private int getLastMonth(int season) {
        int month = 0;
        switch (season) {
            case 1:
                month = Calendar.MARCH;
                break;
            case 2:
                month = Calendar.JUNE;
                break;
            case 3:
                month = Calendar.SEPTEMBER;
                break;
            case 4:
                month = Calendar.DECEMBER;
                break;
            default:
                break;
        }
        return month + 1;
    }

    /**
     * 获取当前日期季度
     * 1 第一季度 2 第二季度 3 第三季度 4 第四季度
     *
     * @return season
     */
    private int getSeason() {

        int season = 0;
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH);
        switch (month) {
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
            case Calendar.MARCH:
                season = 1;
                break;
            case Calendar.APRIL:
            case Calendar.MAY:
            case Calendar.JUNE:
                season = 2;
                break;
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.SEPTEMBER:
                season = 3;
                break;
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
            case Calendar.DECEMBER:
                season = 4;
                break;
            default:
                break;
        }
        return season;
    }
}
