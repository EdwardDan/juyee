package com.justonetech.biz.controller.check;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.Constant;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.CheckInfo;
import com.justonetech.biz.domain.CheckManager;
import com.justonetech.biz.domain.CheckReason;
import com.justonetech.biz.manager.CheckInfoManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.Constants;
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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 考勤历史列表
 * User: Chen Junping
 * Date: 12-9-12
 */
@Controller
public class CheckInfoHistoryController extends BaseCRUDActionController<CheckInfo> {
    private Logger logger = LoggerFactory.getLogger(CheckInfoHistoryController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private CheckReasonService checkReasonService;

    @Autowired
    private CheckManagerService checkManagerService;

    @Autowired
    private CheckInfoService checkInfoService;

    @Autowired
    private ProjectWorkSiteService projectWorkSiteService;

    @Autowired
    private CheckManagerPositionService checkManagerPositionService;

    @Autowired
    private CheckInfoManager checkInfoManager;

    /**
     * 列表显示页面
     *
     * @param model    .
     * @param gdCode   .
     * @param jdTaskCode .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, String gdCode, String jdTaskCode) {
        //判断是否有编辑权限
        model.addAttribute("gdCode", gdCode);
        model.addAttribute("jdTaskCode", jdTaskCode);

        //查询工地管理人员
        List<CheckManager> checkManagerList = checkInfoManager.getCheckManagerList(gdCode);

        //默认显示最近一周的考勤记录
        Calendar calendar = Calendar.getInstance();
        String endTime = DateTimeHelper.formatTimestamp(new Timestamp(calendar.getTimeInMillis()), "YYYY-MM-DD");
        calendar.add(Calendar.DATE, -7);
        String beginTime = DateTimeHelper.formatTimestamp(new Timestamp(calendar.getTimeInMillis()), "YYYY-MM-DD");

        //参数输出
        model.addAttribute("beginTime", JspHelper.getString(beginTime));
        model.addAttribute("endTime", JspHelper.getString(endTime));
        model.addAttribute("managerList", checkManagerList);

        return "view/check/checkInfoHistory/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, String gdCode, String jdTaskCode, String queryJson) {
        try {
            SysCodeDetail sysCodeDetail = sysCodeManager.getCodeDetailByCode(Constants.CHECK_MANAGER_POSITION, Constants.CHECK_MANAGER_POSITION_SBGUL);
            Long detailId = sysCodeDetail.getId();
            String beginTime = StringHelper.getElementValue(queryJson, "beginTime");
            String endTime = StringHelper.getElementValue(queryJson, "endTime");
            String managerId = StringHelper.getElementValue(queryJson, "managerId");
            String status = StringHelper.getElementValue(queryJson, "status");

            //查询工地管理人员
            List<CheckManager> managerList = new ArrayList<CheckManager>();
            List<CheckManager> checkManagerList = checkInfoManager.getCheckManagerList(gdCode);
            for (CheckManager data : checkManagerList) {
                if (!StringHelper.isEmpty(managerId)) {
                    if (String.valueOf(data.getId()).equals(managerId)) {
                        managerList.add(data);
                    }
                } else {
                    managerList.add(data);
                }
            }

            //默认显示最近一周的考勤记录
            if (StringHelper.isEmpty(queryJson)) {
                Calendar calendar = Calendar.getInstance();
                endTime = DateTimeHelper.formatTimestamp(new Timestamp(calendar.getTimeInMillis()), "YYYY-MM-DD");
                calendar.add(Calendar.DATE, -7);
                beginTime = DateTimeHelper.formatTimestamp(new Timestamp(calendar.getTimeInMillis()), "YYYY-MM-DD");
            }

            //时间段
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            List<String> dateList = new ArrayList<String>();
            Date s1 = sdf.parse(beginTime);
            Date s2 = sdf.parse(endTime);
            long betweenDays = DateTimeHelper.getBetweenDays(s1, s2);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(s2);
            dateList.add(endTime);
            for (long i = betweenDays; i >= 1; i--) {
                calendar.add(Calendar.DATE, -1);
                dateList.add(DateTimeHelper.formatTimestamp(new Timestamp(calendar.getTimeInMillis()), "YYYY-MM-DD"));
            }

            //查找该时间段内的考勤记录
            Map<String, List<CheckInfo>> checkMap = new HashMap<String, List<CheckInfo>>();
            String checkInfoHql = "select a from CheckInfo a,CheckManager b,CheckManagerPosition c where a.gdCode='" + gdCode + "'" +
                    " and a.manager.id = b.id" +
                    " and c.manager.id = b.id" +
                    " and c.positionType.id !=" + detailId;

            if (!StringHelper.isEmpty(managerId)) {
                checkInfoHql += " and a.manager.id=" + managerId;
            }
            if (!StringHelper.isEmpty(beginTime)) {
                checkInfoHql += " and to_char(a.checkTime,'YYYY-MM-DD')>='" + beginTime + "'";
            }
            if (!StringHelper.isEmpty(endTime)) {
                checkInfoHql += " and to_char(a.checkTime,'YYYY-MM-DD')<='" + endTime + "'";
            }
//            System.out.println("..............checkInfoHql = " + checkInfoHql);

            List<CheckInfo> checkInfoList = checkInfoService.findByQuery(checkInfoHql);
            for (CheckInfo data : checkInfoList) {
                String key = DateTimeHelper.dateToString(data.getCheckTime(), "YYYY-MM-DD") + "_" + data.getManager().getId();
                List<CheckInfo> checkInfos = checkMap.get(key);
                if (checkInfos == null) checkInfos = new ArrayList<CheckInfo>();
                checkInfos.add(data);
                checkMap.put(key, checkInfos);
            }

            //查找该时间段内的未考勤记录
            Map<String, CheckReason> reasonMap = new HashMap<String, CheckReason>();
            String checkReasonHql = "from CheckReason where gdCode='" + gdCode + "'";
            if ("check".equals(status)) {
                checkInfoHql += " and 1=2";
            }
            if (!StringHelper.isEmpty(managerId)) {
                checkReasonHql += " and manager.id=" + managerId;
            }
            if (!StringHelper.isEmpty(beginTime)) {
                checkReasonHql += " and to_char(checkDate,'YYYY-MM-DD')>='" + beginTime + "'";
            }
            if (!StringHelper.isEmpty(endTime)) {
                checkReasonHql += " and to_char(checkDate,'YYYY-MM-DD')<='" + endTime + "'";
            }
//            System.out.println("..............checkReasonHql = " + checkReasonHql);

            List<CheckReason> checkReasonList = checkReasonService.findByQuery(checkReasonHql);
            for (CheckReason data : checkReasonList) {
                String key = DateTimeHelper.formatTimestamp(new Timestamp(data.getCheckDate().getTime()), "YYYY-MM-DD") + "_" + data.getManager().getId();
                reasonMap.put(key, data);
            }

            //日期循环--仅用于分页，不压入过多数据，便于快速分页
            List<String> list = new ArrayList<String>();
            for (String date : dateList) {
                Timestamp curTime = Timestamp.valueOf(date + " 00:00:00.0");

                //分2次循环是为了把考勤信息优先排在前面
                if (!"notCheck".equals(status)) {
                    for (CheckManager manager : managerList) {
                        String key = date + "_" + manager.getId();
                        if (checkMap.containsKey(key)) {
                            if ((new Timestamp(manager.getCreateTime().getTime())).before(curTime)) {
                                list.add(key);
                            }
                        }
                    }
                }

                if (!"check".equals(status)) {
                    for (CheckManager manager : managerList) {
                        String key = date + "_" + manager.getId();
                        if (!checkMap.containsKey(key)) {
                            if ((new Timestamp(manager.getCreateTime().getTime())).before(curTime)) {
                                list.add(key);
                            }
                        }
                    }
                }
            }
            //分页处理
            Page pageModel = new Page<String>(page, rows, list);


            //对当前分页组织数据
            List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
            int i = 0;  //仅用于区分不同记录
            for (Object object : pageModel.getRows()) {
                String key = JspHelper.getString(object);
                List<CheckInfo> checkInfos = checkMap.get(key);
                if (checkInfos != null) {
                    //考勤信息
                    for (CheckInfo info : checkInfos) {
                        i++;
                        Map<String, Object> map = new HashMap<String, Object>();
                        map.put("id", i);
                        map.put("checkTime", DateTimeHelper.formatTimestamp(info.getCheckTime(), "YYYY-MM-DD HH:MM"));
                        map.put("managerName", info.getManagerName());
                        map.put("position", info.getManager().getPositionNames());
                        map.put("checkStatusName", getCheckStatusName(info.getCheckStatus()));
                        map.put("checkInfoId", info.getId());
                        retList.add(map);
                    }
                } else {
                    i++;
                    //未考勤信息
                    Map<String, Object> map = new HashMap<String, Object>();
                    String[] ss = StringHelper.stringToStringArray(key, "_");
                    CheckManager manager = checkManagerService.get(Long.valueOf(ss[1]));
                    map.put("id", i);
                    map.put("checkTime", ss[0] + " 00:00");
                    map.put("managerName", manager.getName());
                    map.put("position", manager.getPositionNames());
                    map.put("checkStatusName", "未签到");

                    //未签到原因
                    CheckReason checkReason = reasonMap.get(key);
                    if (checkReason != null) {
                        map.put("reasonId", checkReason.getId());
                    }
                    retList.add(map);
                }
            }

            //输出显示
            String json = GridJq.toJSON(retList, pageModel);

            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 考勤状态名称-- todo 可能需要修改
     *
     * @param checkStatus .
     * @return .
     */
    private String getCheckStatusName(String checkStatus) {
        if (Constant.FLAG_TRUE.equals(checkStatus)) {
            return "下班";
        } else {
            return "上班";
        }
    }

    /**
     * 照片对比
     *
     * @param mid   .
     * @param model .
     * @param id    .
     * @return .
     */
    @RequestMapping
    public String checkImage(String mid, Model model, String id) {
        CheckInfo checkInfo = checkInfoService.get(JspHelper.getLong(id));
        CheckManager checkManager = checkInfo.getManager();
        model.addAttribute("originPhoto", checkManager.getPhotoFile());
        model.addAttribute("checkPhoto", StringHelper.findAndReplace(JspHelper.getString(checkInfo.getPhotoFile()), "\\", "/"));
        model.addAttribute("bean", checkInfo);

        return "view/check/checkInfoHistory/view";
    }

}
