package com.justonetech.biz.utils.webService.checkWebservice;

import com.justonetech.biz.utils.webService.ClientFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 考勤信息 webservice client
 */
public class CheckWebServiceClient {

    private static final Log log = LogFactory.getLog(CheckWebServiceClient.class);

    //WebService 地址
    private String endPointURL;
    //用户名
    private String user;
    //密码
    private String password;

    public void setEndPointURL(String endPointURL) {
        this.endPointURL = endPointURL;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private CheckWebService getCheckWebServiceClient() {
        return ClientFactory.getClient(CheckWebService.class, endPointURL, user, password);
    }

    public String saveCheckManager(CheckManager userInfo) {
        return getCheckWebServiceClient().saveCheckManager(userInfo);
    }

    public String saveCheckManagerForWorker(CheckManager userInfo) {
        return getCheckWebServiceClient().saveCheckManagerForWorker(userInfo);
    }

    public String deleteCheckManager(String userGuid) {
        return getCheckWebServiceClient().deleteCheckManager(userGuid);
    }

    public String saveCheckFingerPrint(CheckFingerPrint checkFingerPrint) {
        return getCheckWebServiceClient().saveCheckFingerPrint(checkFingerPrint);
    }

    public String deleteCheckFingerPrint(String guid) {
        return getCheckWebServiceClient().deleteCheckFingerPrint(guid);
    }

    public String saveCheckManagerPosition(CheckManagerPosition userPosition) {
        return getCheckWebServiceClient().saveCheckManagerPosition(userPosition);
    }

    public String deleteCheckManagerPosition(String gdCode, String userGuid) {
        return getCheckWebServiceClient().deleteCheckManagerPosition(gdCode, userGuid);
    }

    public String saveCheckDeviceInfo(CheckDeviceInfo deviceInfo) {
        return getCheckWebServiceClient().saveCheckDeviceInfo(deviceInfo);
    }
    public String saveCheckDeviceInfoForWorker(CheckDeviceInfo deviceInfo) {
        return getCheckWebServiceClient().saveCheckDeviceInfoForWorker(deviceInfo);
    }

    public String deleteCheckDeviceInfo(String deviceGuid) {
        return getCheckWebServiceClient().deleteCheckDeviceInfo(deviceGuid);
    }

    public String getCheckInfoList(String belongArea, long startIdx, int limitCount) {
        return getCheckWebServiceClient().getCheckInfoList(belongArea, startIdx, limitCount);
    }
    public String getCheckInfoListForWorker(String belongArea, long startIdx, int limitCount) {
        return getCheckWebServiceClient().getCheckInfoListForWorker(belongArea, startIdx, limitCount);
    }

    public String getCheckDeviceInfoList(String belongArea, long startIdx, int limitCount) {
        return getCheckWebServiceClient().getCheckDeviceInfoList(belongArea, startIdx, limitCount);
    }
    public String getCheckDeviceInfoListForWorker(String belongArea, long startIdx, int limitCount) {
        return getCheckWebServiceClient().getCheckDeviceInfoListForWorker(belongArea, startIdx, limitCount);
    }

    public String saveGdInfo(String gdCode, String gdName, String belongArea) {
        return getCheckWebServiceClient().saveGdInfo(gdCode, gdName, belongArea);
    }

    public String deleteGdInfo(String gdCode) {
        return getCheckWebServiceClient().deleteGdInfo(gdCode);
    }
}
