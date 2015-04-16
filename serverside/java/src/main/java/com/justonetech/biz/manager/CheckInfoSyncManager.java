package com.justonetech.biz.manager;

import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.daoservice.CheckDeviceInfoService;
import com.justonetech.biz.daoservice.CheckInfoService;
import com.justonetech.biz.daoservice.CheckManagerService;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.utils.DateUtil;
import com.justonetech.biz.utils.webService.checkWebservice.CheckWebServiceClient;
import com.justonetech.system.manager.SimpleQueryManager;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.List;

/**
 * 考勤信息同步主要程序
 * User: Chen Junping
 * Date: 12-9-17
 */
@Service
public class CheckInfoSyncManager {
    private Logger logger = LoggerFactory.getLogger(CheckInfoSyncManager.class);
    @Autowired
    private CheckWebServiceClient client;

    @Autowired
    private CheckInfoService checkInfoService;

    @Autowired
    private CheckDeviceInfoService checkDeviceInfoService;

    @Autowired
    private CheckManagerService checkManagerService;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private CheckSyncManager checkSyncManager;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    /**
     * *************************************上传数据到平安工地******************************************************
     */
    /**
     * 考勤设备信息上传至平安工地
     *
     * @param deviceInfo
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void saveCheckDeviceInfo(CheckDeviceInfo deviceInfo) throws InvocationTargetException, IllegalAccessException {
        String gdCode = deviceInfo.getGdCode();
        if (!StringHelper.isEmpty(gdCode)) {
            //上传工地信息
            ShareGdInfo shareGdInfo = projectManager.getGDInfo(gdCode);
            if (shareGdInfo != null) {
                client.saveGdInfo(gdCode, shareGdInfo.getGdName(), configManager.getSyncCheckArea());
            }

            //上传设备信息
            com.justonetech.biz.utils.webService.checkWebservice.CheckDeviceInfo data = new com.justonetech.biz.utils.webService.checkWebservice.CheckDeviceInfo();
            data.setBelongArea(deviceInfo.getBelongArea());
            data.setCancelDateTime(DateUtil.timeToXmlDate(deviceInfo.getCancelDateTime()));
            data.setCreateTime(DateUtil.timeToXmlDate(deviceInfo.getCreateTime()));
            data.setDeleteTime(DateUtil.timeToXmlDate(deviceInfo.getDeleteTime()));
            data.setLastOnlineTime(DateUtil.timeToXmlDate(deviceInfo.getLastOnlineTime()));
            data.setRegDateTime(DateUtil.timeToXmlDate(deviceInfo.getRegDateTime()));
            data.setUpdateTime(DateUtil.timeToXmlDate(deviceInfo.getUpdateTime()));
            data.setPositionTime(DateUtil.timeToXmlDate(deviceInfo.getPositionTime()));
            data.setCancelStatus(deviceInfo.getCancelStatus());
            data.setCancelUserName(deviceInfo.getCancelUserName());
            data.setCreateUser(deviceInfo.getCreateUser());
            data.setDeleteUser(deviceInfo.getDeleteUser());
            data.setDevIp(deviceInfo.getDevIp());
            data.setDevMode(deviceInfo.getDevMode());
            data.setDevName(deviceInfo.getDevName());
            data.setDevSim(deviceInfo.getDevSim());
            data.setDevSn(deviceInfo.getDevSn());
            data.setGdCode(gdCode);
            data.setGuid(deviceInfo.getGuid());
            data.setIsDelete(deviceInfo.getIsDelete());
            data.setLatitude(deviceInfo.getLatitude());
            data.setLongitude(deviceInfo.getLongitude());
            data.setOnlineStatus(deviceInfo.getOnlineStatus());
//        data.setPositionLatitude(deviceInfo.get();
            data.setRegUserName(deviceInfo.getRegUserName());
//            data.setCategory("G"); //管理人员--无须设置，上传接口会自动赋值
            client.saveCheckDeviceInfo(data);
        }
    }

    //删除设备信息同步至平安工地
    public void deleteCheckDeviceInfo(String deviceGuid) {
        client.deleteCheckDeviceInfo(deviceGuid);
    }

    /**
     * 将考勤人员信息上传到平安工地.
     *
     * @param userInfo .
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void saveCheckManager(CheckManager userInfo) throws InvocationTargetException, IllegalAccessException {
        com.justonetech.biz.utils.webService.checkWebservice.CheckManager data = new com.justonetech.biz.utils.webService.checkWebservice.CheckManager();
        data.setId(userInfo.getId());
        data.setGuid(userInfo.getGuid());
//        data.setCardNo(userInfo.getCardNo());
        data.setIdCard(userInfo.getCardNo()); //调整为身份证专用字段，不再放入cardNo
//        data.setCategory("G"); //管理人员--无须设置，上传接口会自动赋值
        data.setMobile(userInfo.getMobile());
        data.setName(userInfo.getName());
        data.setSex(userInfo.getSex());
        data.setIsDelete(userInfo.getIsDelete());
        data.setPhotoFile(userInfo.getPhotoFile());
        data.setPhoto(getPhotoByteByUrl(userInfo.getPhotoFile()));
        data.setCreateTime(DateUtil.timeToXmlDate(userInfo.getCreateTime()));
        data.setUpdateTime(DateUtil.timeToXmlDate(userInfo.getUpdateTime()));
        data.setCreateUser(userInfo.getCreateUser());
        data.setUpdateUser(userInfo.getUpdateUser());
        data.setDeleteTime(DateUtil.timeToXmlDate(userInfo.getDeleteTime()));
        data.setDeleteUser(userInfo.getDeleteUser());
        client.saveCheckManager(data);
    }

    /**
     * 删除平安工地的考勤人员.
     *
     * @param userGuid .
     */
    public void deleteCheckManager(String userGuid) {
        client.deleteCheckManager(userGuid);
    }

    //根据图片url取得图片的byte[].
    private byte[] getPhotoByteByUrl(String url) {
        byte[] content = new byte[0];
        if (StringHelper.isNotEmpty(url)) {
//            url = "/uploads/success.jpg";
            String filePath = configManager.getFilePath();
            if (url.startsWith("/") || url.startsWith("\\")) {
                url = url.substring(1);
            }
            filePath = filePath + url;
            try {
                File file = new File(filePath);
                if(file.exists()){
                    content = org.apache.commons.io.FileUtils.readFileToByteArray(file);
                }

            } catch (IOException e) {
                logger.error("error", e);
            }
        }
        return content;
    }

    /**
     * 将考勤人员的指纹信息上传到平安工地.
     *
     * @param checkFingerPrint .
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void saveCheckFingerPrint(CheckFingerPrint checkFingerPrint) throws InvocationTargetException, IllegalAccessException {
        com.justonetech.biz.utils.webService.checkWebservice.CheckFingerPrint data = new com.justonetech.biz.utils.webService.checkWebservice.CheckFingerPrint();
        data.setManager(null);
        data.setGuid(checkFingerPrint.getGuid());
        data.setManagerGuid(checkFingerPrint.getManager().getGuid());
        data.setBioType(checkFingerPrint.getBioType());
        data.setCreateTime(DateUtil.timeToXmlDate(checkFingerPrint.getCreateTime()));
        data.setUpdateTime(DateUtil.timeToXmlDate(checkFingerPrint.getUpdateTime()));
        data.setCreateUser(checkFingerPrint.getCreateUser());
        data.setUpdateUser(checkFingerPrint.getUpdateUser());
        data.setDeleteTime(DateUtil.timeToXmlDate(checkFingerPrint.getDeleteTime()));
        data.setDeleteUser(checkFingerPrint.getDeleteUser());
        data.setDevSn(checkFingerPrint.getDevSn());
        data.setFingerid(checkFingerPrint.getFingerid());
        data.setFingerVersion(checkFingerPrint.getFingerVersion());
        data.setTemplate(checkFingerPrint.getTemplate());
        data.setIsDelete(checkFingerPrint.getIsDelete());
        client.saveCheckFingerPrint(data);
    }

    public void deleteCheckFingerPrint(String guid) {
        client.deleteCheckFingerPrint(guid);
    }

    /**
     * 考勤人员、岗位上传至平安工地
     *
     * @param userPosition
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void saveCheckManagerPosition(CheckManagerPosition userPosition) throws InvocationTargetException, IllegalAccessException {
        //从webService获取岗位数据
        com.justonetech.biz.utils.webService.checkWebservice.CheckManagerPosition data = new com.justonetech.biz.utils.webService.checkWebservice.CheckManagerPosition();
        data.setGuid(userPosition.getGuid());
        if (userPosition.getManager() != null)
            data.setManagerGuid(userPosition.getManager().getGuid());
        data.setJdTaskCode(userPosition.getJdTaskCode());
        data.setGdCode(userPosition.getGdCode());
        data.setIsValid(userPosition.getIsValid());
        if (userPosition.getPositionType() != null)
            data.setPositionType(userPosition.getPositionType().getId());
        data.setPositionName(userPosition.getPositionName());
        data.setCertificateCode(userPosition.getCertificateCode());
        data.setCertificateName(userPosition.getCertificateName());
        data.setCreateUser(userPosition.getCreateUser());
        data.setCreateTime(DateUtil.timeToXmlDate(userPosition.getCreateTime()));
        data.setUpdateUser(userPosition.getUpdateUser());
        data.setUpdateTime(DateUtil.timeToXmlDate(userPosition.getUpdateTime()));
        data.setDeleteUser(userPosition.getDeleteUser());
        data.setDeleteTime(DateUtil.timeToXmlDate(userPosition.getDeleteTime()));
        data.setIsDelete(userPosition.getIsDelete());

        client.saveCheckManagerPosition(data);
    }

    //删除人员、岗位信息同步至平安工地
    public void deleteCheckManagerPosition(String gdCode, String userGuid) {
        client.deleteCheckManagerPosition(gdCode, userGuid);
    }


    /**
     * *************************************从平安工地下载数据******************************************************
     */
    /**
     * /**
     * 下载考勤数据.
     */
    public void getCheckInfoList() throws Exception {
        //取最后一条考勤记录的createTime。
        Long lastId = checkSyncManager.getLastId(null, checkSyncManager.PARAM_CODE_OF_CHECKINFO_DOWNTIME, checkSyncManager.PARAM_NAME_OF_CHECKINFO_DOWNTIME);
        String json = client.getCheckInfoList(configManager.getSyncCheckArea(), lastId, checkSyncManager.SYNC_LIMIT_COUNT);

        json = json.replaceAll("new Date\\((\\d*)\\)", "$1");
        JSONArray jsonArray = JSONArray.fromObject(json);
        int len = jsonArray.size();
        CheckManager checkManager;
        for (int i = 0; i < len; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Timestamp checkTime = getNotNullTime(jsonObject.get("checkTime"));
            if (checkTime == null) {
                continue;
            }
            logger.info("check info time is " + checkTime);
            lastId = checkSyncManager.getTimeFormat(checkTime);

            //检查该guid的相关考勤记录在静安系统数据库中是否已经存在，若已存在则不保存。
            String managerGuid = getNotNullString(jsonObject.get("managerGuid"));
            if (!checkGuid(getNotNullString(jsonObject.get("guid")))) {
                continue;
            }
            checkManager = getCheckManagerByGuid(managerGuid);
            String photoFile = savePhoto(jsonObject, checkManager.getId());
            logger.debug(i + "|" + managerGuid + " : photoFile = " + photoFile);

            com.justonetech.biz.domain.CheckInfo info = new com.justonetech.biz.domain.CheckInfo();
            info.setManager(checkManager);
            info.setGuid(getNotNullString(jsonObject.get("guid")));
            info.setCardNo(getNotNullString(jsonObject.get("cardNo"))); //暂时不用
            info.setCheckStatus(getNotNullString(jsonObject.get("checkStatus")));
            info.setCheckTime(checkTime);
            info.setDev(getCheckDeviceInfoByGuid(getNotNullString(jsonObject.get("devGuid"))));
            info.setDevSn(getNotNullString(jsonObject.get("devSn")));
            info.setGdCode(getNotNullString(jsonObject.get("gdCode")));

            info.setLatitude(getDouble(jsonObject.get("positionLatitude")));
            info.setLatitude(getDouble(jsonObject.get("positionLongitude")));
            info.setPositionTime(getNotNullTime(jsonObject.get("positionTime")));
            info.setManagerName(getNotNullString(jsonObject.get("managerName")));
            info.setVerifyCode(getNotNullString(jsonObject.get("verifyCode")));

//            info.setCreateUser(getNotNullString(jsonObject.get("createUser")));
//            info.setCreateTime(getNotNullTime(jsonObject.get("createTime")));
//            info.setUpdateTime(getNotNullTime(jsonObject.get("updateTime")));
//            info.setUpdateUser(getNotNullString(jsonObject.get("updateUser")));

            info.setPhotoFile(photoFile);

            checkInfoService.save(info);
        }

        //更新最后的考勤记录时间
//        logger.info("............................checkManager = " + lastId);
        checkSyncManager.getLastId(lastId, checkSyncManager.PARAM_CODE_OF_CHECKINFO_DOWNTIME, checkSyncManager.PARAM_NAME_OF_CHECKINFO_DOWNTIME);
    }

    /**
     * 保存图片文件.
     *
     * @param jsonObject     .
     * @param checkManagerId .
     * @return .
     */
    private String savePhoto(JSONObject jsonObject, Long checkManagerId) {
        String fileName = null;
        String year = null;
        String month = null;
        String timeString = null;
        Timestamp time = getNotNullTime(jsonObject.get("checkTime"));
        if (time != null) {
            try {
                year = DateTimeHelper.dateToString(time, "YYYY");
                month = DateTimeHelper.dateToString(time, "MMDD");
                timeString = DateTimeHelper.dateToString(time, "YYYYMMDDHH24MISS");
            } catch (Exception e) {
                logger.error("error", e);
            }
            String rootPath = configManager.getFilePath();
            if (rootPath.endsWith("/")) {
                rootPath = rootPath.substring(0, rootPath.length() - 1);
            }
            String filePath = File.separator + "checkInfoPhoto" + File.separator + year + File.separator + month + File.separator;

            String photoString = getNotNullString(jsonObject.get("photoString"));
            String photoName = getNotNullString(jsonObject.get("photoFile"));

            if (StringHelper.isNotEmpty(photoString)) {
                try {
                    byte[] photo = org.apache.commons.codec.binary.Base64.decodeBase64(photoString.getBytes());
                    if (StringHelper.isNotEmpty(photoName) || photo.length != 0) {
                        //根据实例的id和图片的后缀名重新生成图片全名。
                        fileName = getNotNullString(getNotNullString(jsonObject.get("devSn")) + "_" + checkManagerId + "_" + timeString + StringHelper.substring(photoName, photoName.indexOf(".")));
//                    System.out.println("..........photo = " + photo);
                        fileName = savePhotoToDisc(rootPath, filePath, fileName, photo);
                    }
                } catch (Exception e) {
                    logger.error("error", e);
                }
            }
        }

        return fileName;
    }


    /**
     * 使用byte[]生成并保存图片文件
     *
     * @param fileName .
     * @param photo    .
     * @return .
     */
    public String savePhotoToDisc(String rootPath, String filePath, String fileName, byte[] photo) {
        String ret = "";
        if (photo != null && photo.length > 0) {
            try {
                String s = rootPath + filePath + fileName;
                logger.info(".....save  photo path = " + s);
                File file = new File(rootPath + filePath);
                if (!file.exists()) {
                    file.mkdirs();
                }
                ret = filePath + fileName;
                org.apache.commons.io.FileUtils.writeByteArrayToFile(new File(s), photo);
            } catch (Exception e) {
                logger.error("error", e);
            }
        }
        return ret;
    }

    /**
     * 下载设备数据.
     */
    public void getDeviceInfoList() {
        //取最后一条设备信息的createTime。
        Long lastId = checkSyncManager.getLastId(null, checkSyncManager.PARAM_CODE_OF_DEVICEINFO_DOWNTIME, checkSyncManager.PARAM_NAME_OF_DEVICEINFO_DOWNTIME);
        String json = client.getCheckDeviceInfoList(configManager.getSyncCheckArea(), lastId, checkSyncManager.SYNC_LIMIT_COUNT);

        json = json.replaceAll("new Date\\((\\d*)\\)", "$1");
        JSONArray jsonArray = JSONArray.fromObject(json);
        int len = jsonArray.size();
        for (int i = 0; i < len; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            //检查该guid的相关设备信息在静安系统数据库中是否已经存在，若已存在则不保存。
            CheckDeviceInfo info = getCheckDeviceInfoByGuid(getNotNullString(jsonObject.get("guid")));
            if (info == null) {
                continue;
            }
//            设备记录Guid，设备Sim卡号，设备IP，最近联机时间，设备联机状态，最近定位经度，最近定位纬度，最近定位时间，更新序列号。
//            info.setGuid(getNotNullString(jsonObject.get("guid")));
//            info.setDevName(getNotNullString(jsonObject.get("devName")));
            info.setDevIp(getNotNullString(jsonObject.get("devIp")));
            info.setDevSim(getNotNullString(jsonObject.get("devSim")));
//            info.setDevSn(getNotNullString(jsonObject.get("devSn")));
            info.setDevMode(getNotNullString(jsonObject.get("devMode")));
//            info.setDevSn(getNotNullString(jsonObject.get("devSn")));
//            info.setGdCode(getNotNullString(jsonObject.get("gdCode")));
//            info.setRegUserName(getNotNullString(jsonObject.get("regUserName")));
//            info.setBelongArea(getNotNullString(jsonObject.get("belongArea")));
//            info.setCancelUserName(getNotNullString(jsonObject.get("cancelUserName")));

//            info.setCancelStatus(JspHelper.getLong(jsonObject.get("cancelStatus").equals("null") ? null : jsonObject.get("cancelStatus")));
            info.setOnlineStatus(JspHelper.getLong(jsonObject.get("onlineStatus").equals("null") ? null : jsonObject.get("onlineStatus")));

            info.setCurrentLongitude(getDouble(jsonObject.get("positionLatitude")));
            info.setCurrentLatitude(getDouble(jsonObject.get("positionLongitude")));
//            info.setLatitude(getDouble(jsonObject.get("latitude")));
//            info.setLatitude(getDouble(jsonObject.get("longitude")));

//            info.setCancelDateTime(getNotNullTime(jsonObject.get("cancelDateTime")));
//            info.setRegDateTime(getNotNullTime(jsonObject.get("regDateTime")));
            info.setLastOnlineTime(getNotNullTime(jsonObject.get("lastOnlineTime")));
            info.setPositionTime(getNotNullTime(jsonObject.get("positionTime")));

//            info.setIsDelete(!jsonObject.get("isDelete").equals("null") && jsonObject.getBoolean("isDelete"));

//            info.setDeleteUser(getNotNullString(jsonObject.get("deleteUser")));
//            info.setDeleteTime(getNotNullTime(jsonObject.get("deleteTime")));
//            info.setCreateUser(getNotNullString(jsonObject.get("createUser")));
//            info.setCreateTime(getNotNullTime(jsonObject.get("createTime")));
//            info.setUpdateTime(getNotNullTime(jsonObject.get("updateTime")));
//            info.setUpdateUser(getNotNullString(jsonObject.get("updateUser")));

            checkDeviceInfoService.save(info);

//            lastId = info.getUpdateTime().getTime();
            lastId = checkSyncManager.getTimeFormat(DateTimeHelper.getTimestamp());
        }

//        //更新最后的设备信息时间
        checkSyncManager.getLastId(lastId, checkSyncManager.PARAM_CODE_OF_DEVICEINFO_DOWNTIME, checkSyncManager.PARAM_NAME_OF_DEVICEINFO_DOWNTIME);
    }

    /**
     * List转json时null值会转为“null”字符串，所以必须转回来。
     *
     * @param obj .
     * @return .
     */
    private Double getDouble(Object obj) {
        return obj.equals("null") ? null : JspHelper.getDouble(obj);
    }

    /**
     * List转json时null值会转为“null”字符串，所以必须转回来。
     *
     * @param obj .
     * @return .
     */
    private String getNotNullString(Object obj) {
        return obj.equals("null") ? null : JspHelper.getString(obj);
    }

    /**
     * List转json时null值会转为“null”字符串，所以必须转回来。
     *
     * @param obj .
     * @return .
     */
    private Timestamp getNotNullTime(Object obj) {
        String s = getNotNullString(obj);
        if (StringHelper.isNotBlank(s)) {
            return new Timestamp(JspHelper.getLong(s));
        } else {
            return null;
        }
    }


    /**
     * *************************************根据guid获取对象******************************************************
     */
    //根据guid取得相应的考勤设备信息。
    private CheckDeviceInfo getCheckDeviceInfoByGuid(String guid) {
        CheckDeviceInfo checkDeviceInfo = null;
        if (StringHelper.isNotEmpty(guid)) {
            String hql = "from CheckDeviceInfo where guid='{0}'";
            hql = FormatUtils.format(hql, guid);
            List<CheckDeviceInfo> checkDeviceInfoList = checkDeviceInfoService.findByQuery(hql);
            if (checkDeviceInfoList.size() > 0) {
                checkDeviceInfo = checkDeviceInfoList.get(0);
            }
        }
        return checkDeviceInfo;
    }

    //根据guid取得相应的考勤人员信息。(注意：传入的guid实际上是id。)
    private CheckManager getCheckManagerByGuid(String guid) {
        CheckManager checkManager = null;
        if (StringHelper.isNotEmpty(guid)) {
            String hql = "from CheckManager where guid='{0}'"; //注意：传入的guid实际上是id。
            hql = FormatUtils.format(hql, guid);
            List<CheckManager> checkManagerList = checkManagerService.findByQuery(hql);
            if (checkManagerList.size() > 0) {
                checkManager = checkManagerList.get(0);
            }
        }
        return checkManager;
    }

    //检查该guid的相关考勤记录在静安系统数据库中是否已经存在。
    private Boolean checkGuid(String guid) {
        if (StringHelper.isNotEmpty(guid)) {
            String hql = "from CheckInfo where guid='{0}'";
            hql = FormatUtils.format(hql, guid);
            List<CheckInfo> checkInfoList = checkInfoService.findByQuery(hql);
            if (checkInfoList.size() > 0) {
                return false;
            }
        }
        return true;
    }

}
