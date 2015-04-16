package com.justonetech.biz.controller.polling;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.biz.daoservice.PadPollingTracksService;
import com.justonetech.biz.daoservice.PollingWorkGroupService;
import com.justonetech.biz.domain.PadPollingTracks;
import com.justonetech.biz.domain.PollingWorkGroup;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysUserManager;
import flexjson.JSONSerializer;
import org.hibernate.annotations.common.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 巡检轨迹
 * User: yujun
 * Date: 12-10-15
 * Time: 上午10:14
 */
@Controller
public class PollingTrackMapController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(PollingTrackMapController.class);

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private PollingWorkGroupService pollingWorkGroupService;

    @Autowired
    private PadPollingTracksService padPollingTracksService;


    @Autowired
    private ProjectManager projectManager;

    @Autowired
    SimpleQueryManager simpleQueryManager;

    /**
     * 巡检轨迹地图
     *
     * @param date  .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String map(String date, Long personid, Model model) {
        if (StringHelper.isEmpty(date)) {
            date = DateTimeHelper.getCurrentDate();
        }
//        PollingWorkGroup pollingWorkGroup = pollingWorkGroupService.get(groupId);
//        model.addAttribute("group", pollingWorkGroup);
        if (null != personid) {
            SysUser sysUser = sysUserService.get(personid);
            model.addAttribute("personName", sysUser.getDisplayName());
            model.addAttribute("personid", sysUser.getId());
        }
        model.addAttribute("date", date);

        //取巡检组人员的所持设备
//        String sqlImei = "select distinct imei from pad_polling_tracks t where t.user_id in(select user_id from polling_group_user t where t.group_id={0}) and to_char(t.create_time,'YYYY-MM-DD')='{1}'";
        String sqlImei = "select s.imei from pad_polling_tracks s, \n" +
                "(select p.user_id,max(p.create_time)as time from pad_polling_tracks p where to_char(p.create_time,'YYYY-MM-DD')='" + date + "' " +
//                "and p.user_id in (select t.user_id from polling_group_user t where t.is_charge=1) \n" +
                "group by p.user_id) x where x.user_id=s.user_id and x.time=s.create_time  and s.user_id=" + personid;
//        logger.debug("sqlImei = " + sqlImei);
        List imeiList = simpleQueryManager.getListBySql(sqlImei);
        String imei = null;
        if (imeiList.size() > 0) {
            imei = imeiList.get(0).toString();
        }
        model.addAttribute("imeiList", imeiList);
        model.addAttribute("imei", imei);

        return "view/polling/pollingTrackMap/map";
    }

    /**
     * 获取某个设备的巡检轨迹
     *
     * @param request  .
     * @param model    .
     * @param response .
     */
    @RequestMapping
    public void getTrackList(Model model, HttpServletRequest request, HttpServletResponse response) {
        String date = request.getParameter("date");
        String personid = request.getParameter("personid");
        String imei = request.getParameter("imei");

        //取轨迹记录
        List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
        if (!StringHelper.isEmpty(imei)) {
            String sqlTracks = "from PadPollingTracks t where t.imei='{0}' and to_char(t.createTime,'YYYY-MM-DD')='{1}' and t.longitude is not null order by t.id";
            sqlTracks = FormatUtils.format(sqlTracks, imei, date);
//            logger.debug("sqlTracks = " + sqlTracks);
            List<PadPollingTracks> tracksList = padPollingTracksService.findByQuery(sqlTracks);
            for (PadPollingTracks data : tracksList) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("X", data.getLongitude());
                map.put("Y", data.getLatitude());
                map.put("createTime", data.getCreateTime());
                retList.add(map);
            }
            List trList = getPlist(personid, imei, date);
            for (Object obj : trList) {
                Map data = (Map) obj;
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("X", data.get("LONGITUDE"));
                map.put("Y", data.get("LATITUDE"));
                map.put("createTime", data.get("CREATE_TIME"));
                retList.add(map);
            }

            Collections.sort(retList, new Comparator<Map<String, Object>>() {
                public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                    String name1 = o1.get("createTime").toString();
                    String name2 = o2.get("createTime").toString();
                    String[] ary = {name1, name2};
                    Arrays.sort(ary);
                    if (ary[0].equals(name1)) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            });
        }
        JSONSerializer serializer = new JSONSerializer();
        sendJSON(response, serializer.serialize(retList));
    }

    /**
     * 获取监督工程及最后的坐标点
     *
     * @param request  .
     * @param response .
     * @param model    .
     */
    @RequestMapping
    public void getProjectList(Model model, HttpServletRequest request, HttpServletResponse response) {
        String date = request.getParameter("date");
        String personid = request.getParameter("personid");
        String imei = request.getParameter("imei");
//        String sql = "select a.flow_code,a.bjbh,p.project_name,b.longitude,b.latitude,a.polling_start_time,a.polling_end_time\n" +
//                " from polling_record a, polling_record_detail b,share_pro_tobuild p\n" +
//                " where a.id=b.polling_form_id and a.bjbh=p.bjbh\n" +
//                " and a.polling_group={0}\n" +
//                " and b.pad_imei='{1}'\n" +
//                " and to_char(a.create_time,'YYYY-MM-DD')='{2}'\n" +
//                " and b.longitude is not null" +
//                " order by b.create_time desc";
//        sql = FormatUtils.format(sql, groupId, imei, date);
//        logger.debug("getProjectList sql=" + sql);
        List tracksList = getPlist(personid, imei, date);

        Set<String> existHS = new HashSet<String>();
        List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
        for (Object obj : tracksList) {
            Map data = (Map) obj;
            String bjbh = JspHelper.getString(data.get("BJBH"));
            if (!existHS.contains(bjbh)) {
                existHS.add(bjbh);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("bjbh", bjbh);
                map.put("jdTaskCode", data.get("JD_TASK_CODE"));
                map.put("jdDatetime", data.get("JD_DATETIME").toString().substring(0, 9));
//                map.put("endTime", data.get("POLLING_END_TIME").toString().substring(0, 19));
                map.put("projectName", data.get("PROJECT_NAME"));
                map.put("X", data.get("LONGITUDE"));
                map.put("Y", data.get("LATITUDE"));
                retList.add(map);
            }
        }
        JSONSerializer serializer = new JSONSerializer();
        sendJSON(response, serializer.serialize(retList));
    }

    private List getPlist(String personid, String imei, String date) {
//        String sql = "select a.flow_code,a.bjbh,p.project_name,b.longitude,b.latitude,a.polling_start_time,a.polling_end_time,b.create_time\n" +
//                " from polling_record a, polling_record_detail b,excel_jd_tasks p\n" +
//                " where a.id=b.polling_form_id and a.bjbh=p.bjbh\n" +
//                " and a.polling_group={0}\n" +
//                " and b.pad_imei='{1}'\n" +
//                " and to_char(a.create_time,'YYYY-MM-DD')='{2}'\n" +
//                " and b.longitude is not null" +
//                " order by b.create_time desc";
        String sql = "select * from(select A.*,row_number() over(partition by A.id order by rownum desc) cn from " +
                " (SELECT  p.id, E.jd_task_code, E.bjbh,  E .project_name, P .longitude, P .latitude, j.create_time, j.jd_datetime " +
                " FROM  PAD_POLLING_TRACKS P " +
                " inner JOIN sys_user s ON s. ID = P .user_id " +
                " LEFT JOIN jd_record j ON j.jd_Manager_id = s.person_id " +
                " LEFT JOIN EXCEL_JD_TASKS E ON E .jd_task_code = j.jd_task_code " +
                " WHERE TO_CHAR (j.jd_datetime, 'YYYY-MM-DD') = '{0}' " +
                " AND P .USER_ID = {1} " +
                " AND P .imei = '{2}' " +
                " AND P .longitude IS NOT NULL " +
                " and e.JD_TASK_CODE is not null) A) where cn=1 ";

        sql = FormatUtils.format(sql, date, personid, imei);
        System.out.println("sql = " + sql);
        return simpleQueryManager.getMapList(sql);
    }

    /**
     * 巡检记录列表
     *
     * @param date  .
     * @param bjbh  .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String getPollingList(String date, Long personid, String bjbh, Model model) {
        String jdManagerName = "";
        if (null != personid) {
            SysUser sysUser = sysUserService.get(personid);
            jdManagerName = sysUser.getDisplayName();
        }
        String sql = "select j.jdTypeCode,j.id,j.code,j.bjbh,j.jd_task_code,j.jd_manager_name,j.jd_datetime,e.project_name,j.document_id,j.SCHEDULE_ITEMS " +
                " from Jd_record j left join excel_jd_tasks e on e.jd_task_code =j.jd_task_code" +
                " where TO_CHAR (j.jd_datetime, 'YYYY-MM-DD')='" + date + "' and j.jd_manager_name='" + jdManagerName + "' and j.bjbh='" + bjbh + "' ";
        List<Map> recordList = simpleQueryManager.getMapList(sql);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (Map bean : recordList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("jdTypeCode", bean.get("jdTypeCode".toUpperCase()));
            map.put("jdTaskCode", bean.get("jd_task_code".toUpperCase()));
            map.put("bjbh", bean.get("bjbh".toUpperCase()));
            map.put("projectName", bean.get("project_name".toUpperCase()));
            if ("safe".equals(bean.get("jdTypeCode".toUpperCase()))) {
                map.put("pollingType", "安全");
            } else if ("quality".equals(bean.get("jdTypeCode".toUpperCase()))) {
                map.put("pollingType", "质量");
            } else if ("first".equals(bean.get("jdTypeCode".toUpperCase()))) {
                map.put("pollingType", "首次");
            } else if ("complete".equals(bean.get("jdTypeCode".toUpperCase()))) {
                map.put("pollingType", "竣工");
            }
            map.put("stage", bean.get("SCHEDULE_ITEMS".toUpperCase()));
            map.put("pollingDate", bean.get("jd_datetime".toUpperCase()));
            if (!StringHelper.isEmpty(String.valueOf(bean.get("document_id".toUpperCase())))&&!"null".equals(String.valueOf(bean.get("document_id".toUpperCase()))))
                map.put("pollingRecodDoc", documentManager.getDownloadButton(Long.parseLong(String.valueOf(bean.get("document_id".toUpperCase())))));
            list.add(map);
        }
        model.addAttribute("list", list);
        return "view/polling/pollingTrackMap/list";
    }

}