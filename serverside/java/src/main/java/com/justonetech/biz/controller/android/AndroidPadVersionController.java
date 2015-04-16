package com.justonetech.biz.controller.android;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.*;
import com.justonetech.biz.utils.DateUtil;
import com.justonetech.biz.utils.enums.PadVersionType;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.FileUtils;
import flexjson.JSONSerializer;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.*;

/**
 * 手持终端信息交互--版本及巡检轨迹
 * User: Chen Junping
 * Date: 12-9-10
 */
@Controller
public class AndroidPadVersionController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(AndroidPadVersionController.class);

    @Autowired
    private ProjectExtendService projectExtendService;

    @Autowired
    private PadVersionInfoService padVersionInfoService;

    @Autowired
    private PadRegVersionService padRegVersionService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private PadPollingTracksService padPollingTracksService;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private RelateManager relateManager;

    @Autowired
    PadEventLogService padEventLogService;

    @Autowired
    SysCodeDetailService sysCodeDetailService;

    @Autowired
    ConfigManager configManager;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    ProjectManager projectManager;

    @Autowired
    JdRecordFirstService jdRecordFirstService;

    /**
     * 获取最新版本信息
     *
     * @param model
     * @param versionType
     * @param request
     * @return
     */
    @RequestMapping
    public String getVersion(Model model, String versionType, HttpServletRequest request) {
        String hql;
        if (StringHelper.isNotEmpty(versionType)) {
            hql = "from PadVersionInfo where versionType='{0}' order by versionCode desc";
            hql = FormatUtils.format(hql, versionType);
        } else
            hql = "from PadVersionInfo order by versionCode desc";

        List<PadVersionInfo> padVersionInfoList = padVersionInfoService.findByQuery(hql);
        PadVersionInfo padVersionInfo;
        Map<String, Object> map = new HashMap<String, Object>();
        if (padVersionInfoList.size() > 0) {
            padVersionInfo = padVersionInfoList.get(0);
            map.put("verCode", padVersionInfo.getVersionCode());
            map.put("isForce", padVersionInfo.getVersionForceFlage());
            map.put("verDesc", padVersionInfo.getVersionDesc());
            map.put("verType", padVersionInfo.getVersionType());
            if (padVersionInfo.getApkDoc() != null) {
                map.put("apkDoc", "androidPadVersion/download.do?version=" + padVersionInfo.getVersionCode());
            } else {
                map.put("apkDoc", null);

            }
        }
        model.addAttribute("msg", new JSONSerializer().exclude("*.class").serialize(map));

        return "common/msg";
    }


    /**
     * 更新终端注册版本信息
     *
     * @param json
     * @param padTime
     * @param response
     */
    @RequestMapping
    public void updateRegVersion(String json, String padTime, HttpServletResponse response) {
        try {
            JSONObject jsonObject = JSONObject.fromObject(json);
            String padImei = jsonObject.getString("padImei");
            String versionCode = jsonObject.getString("versionCode");
            String versionType = jsonObject.getString("versionType");
            if (StringHelper.isNotEmpty(padImei) && StringHelper.isNotEmpty(versionType) && StringHelper.isNotEmpty(versionCode)) {
                String hql = "from PadRegVersion where padImei='{0}' and versionCode='{1}' and versionType='{2}'";
                List<PadRegVersion> padRegVersionList = padRegVersionService.findByQuery(FormatUtils.format(hql, padImei, versionCode, versionType));
                PadRegVersion padRegVersion;
                if (padRegVersionList.size() > 0) {
                    padRegVersion = padRegVersionList.get(0);
                    padRegVersion.setUpdateTime(new Timestamp(System.currentTimeMillis()));
                } else {
                    padRegVersion = new PadRegVersion();
                    padRegVersion.setPadImei(padImei);
                }
                padRegVersion.setVersionCode(versionCode);
                padRegVersion.setVersionType(Long.valueOf(versionType));
                padRegVersionService.save(padRegVersion);
                sendSuccessJSON(response, "成功！");
            }
        } catch (Exception e) {
            sendFailureJSON(response, e.getMessage());
        }
    }

    /**
     * 更新手持系统的用户轨迹表
     *
     * @param json
     * @param padTime
     * @param response
     */
    @RequestMapping
    public void updatePollingTracks(String json, String padTime, HttpServletResponse response) {
        try {
            JSONArray jsonArray = JSONArray.fromObject(json);
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Long userId = jsonObject.getLong("userId");
                String userName = jsonObject.getString("userName");
                String imei = jsonObject.getString("imei");
                String latitude = jsonObject.getString("latitude");
                String longitude = jsonObject.getString("longitude");
                String createDate = jsonObject.getString("createDate");
                Timestamp timestamp = AndroidPadManager.getTrueTime(padTime, createDate);
                SysUser sysUser = sysUserManager.getSysUser(userName);
                if (sysUser == null) {
                    sendFailureJSON(response, "用户不存在");
                    return;
                } else {
                    PadPollingTracks padPollingTracks = new PadPollingTracks();
                    padPollingTracks.setCreateTime(timestamp);
                    padPollingTracks.setUser(sysUser);
                    padPollingTracks.setImei(imei);
                    padPollingTracks.setLatitude(Double.valueOf(latitude));
                    padPollingTracks.setLongitude(Double.valueOf(longitude));
                    padPollingTracks.setUserName(userName);
                    padPollingTracksService.save(padPollingTracks);
                }
            }
            sendSuccessJSON(response, "成功");
        } catch (Exception e) {
            sendFailureJSON(response, e.getMessage());
        }
    }

    /**
     * 更新移动巡检事件日志
     */
    @RequestMapping
    public void updateEventLog(String json, String padTime, HttpServletResponse response) {
        try {
            JSONArray jsonArray = JSONArray.fromObject(json);
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String padImei = jsonObject.getString("padImei");
                String eventMsg = jsonObject.getString("eventMsg");
                Long eventType = jsonObject.getLong("eventType");
                String eventTime = jsonObject.getString("eventTime");
                String remark = jsonObject.getString("remark");
                String userName = jsonObject.getString("userName");
                PadEventLog padEventLog = new PadEventLog();
                padEventLog.setEventType(eventType);
                padEventLog.setPadImei(padImei);
                padEventLog.setEventMsg(eventMsg);
                padEventLog.setRemark(remark);
                padEventLog.setUserName(userName);
                Timestamp eventTime1 = AndroidPadManager.getTrueTime(padTime, eventTime);
                padEventLog.setEventTime(eventTime1);
                padEventLog.setPadCommitTime(new Timestamp(System.currentTimeMillis()));
                padEventLogService.save(padEventLog);
            }
            sendSuccessJSON(response, "成功！");
        } catch (Exception e) {
            sendFailureJSON(response, e.getMessage());
        }

    }

    /**
     * 更新项目位置标识
     */
    @RequestMapping
    public void updateProjectPosition(String json, String padTime, HttpServletResponse response) {
        try {
            //update table PRO_POSITION
            JSONObject jsonObject = JSONObject.fromObject(json);
            String bjbh = jsonObject.getString("bjbh");
            String longitude = jsonObject.getString("longitude");
            String latitude = jsonObject.getString("latitude");
            ProjectExtend proPosition = relateManager.getProjectExtend(bjbh);
            if (null != proPosition) {
                proPosition.setPosX(Double.valueOf(longitude));
                proPosition.setPosY(Double.valueOf(latitude));
                proPosition.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            } else {
                proPosition = new ProjectExtend();
                proPosition.setBjbh(bjbh);
//                if (projectManager.getProject(bjbh) != null) {
//                    proPosition.setProName(projectManager.getProject(bjbh).getProjectName());
//                }
                proPosition.setPosX(Double.valueOf(longitude));
                proPosition.setPosY(Double.valueOf(latitude));
            }
            projectExtendService.save(proPosition);
            sendSuccessJSON(response, "成功！");
        } catch (Exception e) {
            sendFailureJSON(response, e.getMessage());

        }
    }

    /**
     * 获取巡检轨迹
     * 8:30 - 17:30
     * @param imei
     * @param userName
     * @param queryDate
     * @param model
     * @return
     * @throws java.text.ParseException
     */
    @RequestMapping
    public String getPollingTrackList(String imei, String userName, String queryDate, Model model) throws ParseException {
        String[] workDate = DateUtil.getWorkDate(queryDate);
        String hqlTracks = "from PadPollingTracks where imei ='" + imei + "' and userName='" + userName + "' and createTime>='" + workDate[0] + "' and createTime<='" + workDate[1] + "' order by createTime";
//        System.out.println("hqlTracks = " + hqlTracks);
        List<PadPollingTracks> tracksList = padPollingTracksService.findByQuery(hqlTracks);
        List<Map<String, Object>> trackMaps = new ArrayList<Map<String, Object>>();
        for (PadPollingTracks padPollingTracks : tracksList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("trackId", padPollingTracks.getId());
            map.put("longitude", padPollingTracks.getLongitude());
            map.put("latitude", padPollingTracks.getLatitude());
            map.put("imei", padPollingTracks.getImei());
            map.put("createDate", padPollingTracks.getCreateTime());
            map.put("userName", padPollingTracks.getUserName());
            if (padPollingTracks.getUser() != null)
                map.put("userId", padPollingTracks.getUser().getId());
            else
                map.put("userId", null);
            trackMaps.add(map);

        }
//        String hqlProblem = "from PollingRecord where createUser='" + userName + "' and pollingStartTime >='" + workDate[0] + "' and pollingEndTime <='" + workDate[1] + "' order by createTime";
        String hqlProblem = "SELECT * from JD_RECORD where jd_MANAGER_NAME='" + sysUserManager.getDisplayName(userName) + "' and JD_DATETIME >='" + workDate[0] + "' and JD_DATETIME <='" + workDate[1] + "' order by JD_DATETIME";
        List recordList = jdRecordFirstService.findBySql(hqlProblem);
        List<Map<String, Object>> recordMaps = new ArrayList<Map<String, Object>>();
        for (Object o : recordList) {
            Map<String, Object> map = new HashMap<String, Object>();
            Object[] objects = (Object[]) o;
            map.put("recordType",objects[0]);
            map.put("recordId",objects[1]);
            map.put("bjbh", objects[3]);
            map.put("jdTaskCode", objects[4]);
            map.put("projectName",objects[7]);
            map.put("recordTime",objects[6]);
            map.put("createUser", objects[8]);
            map.put("jdManagerName", objects[5]);
//            Set<PollingRecordDetail> detailSet = record.getPollingRecordDetails();
//            PollingRecordDetail pollingRecordDetail = null;
//            if (detailSet.iterator().hasNext()) {
//                pollingRecordDetail = detailSet.iterator().next();
//                map.put("longitude", pollingRecordDetail.getLongitude());
//                map.put("latitude", pollingRecordDetail.getLatitude());
//            }else{
                map.put("longitude", null);
                map.put("latitude", null);
//            }
            recordMaps.add(map);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tracks", trackMaps);
        map.put("problem", recordMaps);
        model.addAttribute("msg", new JSONSerializer().exclude("*.class").deepSerialize(map));
        return "common/msg";
    }

    /**
     * 下载apk
     *
     * @param version
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping
    public void download(String version, HttpServletRequest request, HttpServletResponse response) throws Exception {
        downloadByVersion(version, null, request, response);
    }

    @RequestMapping
    public void downloadNormal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        downloadByVersion(null, String.valueOf(PadVersionType.TYPE_NORMAL.getCode()), request, response);
    }

    @RequestMapping
    public void downloadLeader(HttpServletRequest request, HttpServletResponse response) throws Exception {
        downloadByVersion(null, String.valueOf(PadVersionType.TYPE_LEADER.getCode()), request, response);
    }

    private void downloadByVersion(String version, String versionType, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String hql = "from PadVersionInfo where 1=1";
        if (!StringHelper.isEmpty(version)) {
            hql += " and versionCode='" + version + "'";
        }
        if (!StringHelper.isEmpty(versionType)) {
            hql += " and versionType=" + versionType;
        }
        hql += " order by versionCode desc";
        logger.debug("download pad's version hql = " + hql);
        List<PadVersionInfo> list = padVersionInfoService.findByQuery(hql);
        if (list.size() > 0) {
            PadVersionInfo info = list.iterator().next();
            DocDocument apkDoc = info.getApkDoc();
            if (apkDoc != null) {
                Set<DocDocumentAttach> docDocumentAttachs = apkDoc.getDocDocumentAttachs();
                if (docDocumentAttachs.size() > 0) {
                    DocDocumentAttach docDocumentAttach = docDocumentAttachs.iterator().next();
                    DocCategory docCategory = docDocumentAttach.getDocument().getCategory();

                    //获得附件存放的目录
                    String attachFileDir = documentManager.getRelatePathByCategory(docCategory, "");

                    String attachFileName = docDocumentAttach.getSaveFileName();

                    //获得附件存放的目录
                    String path = configManager.getFilePath() + attachFileDir + File.separator;
//                    System.out.println("path = " + path + attachFileName);
                    File file = new File(path + attachFileName);
                    if (!file.exists()) {
                        //必须设置编码否则返回的提示是乱码
                        response.setContentType("text/html; charset=UTF-8");

                        PrintWriter writer = response.getWriter();
                        writer.print("<script language='JavaScript'>alert('");
                        writer.print("对不起，本文件不存在!");
                        writer.println("');</script>");
                        return;
                    }
                    FileUtils.downloadSection(request, response, path + attachFileName, docDocumentAttach.getFileName(), false);
                }
            }
        }
    }
}
