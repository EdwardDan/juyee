package com.justonetech.biz.utils.webService.hkVideoWebservice;

import com.justonetech.biz.utils.webService.ClientFactory;
import com.justonetech.biz.utils.webService.hkVideoWebservice.bean.CmsServicePortType;
import com.justonetech.biz.utils.webService.hkVideoWebservice.bean.CommonPageReq;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 海康视频
 */
public class HkVideoServiceClient {

    private static final Log log = LogFactory.getLog(HkVideoServiceClient.class);

    private String endPointURL;

    public void setEndPointURL(String endPointURL) {
        this.endPointURL = endPointURL;
    }

    private CmsServicePortType getCmsServiceClient() {
        return ClientFactory.getClient(CmsServicePortType.class, endPointURL);
    }

    public com.justonetech.biz.utils.webService.hkVideoWebservice.bean.DeviceResult getAllDevice(String sessionId, CommonPageReq req) {
        return getCmsServiceClient().getAllDevice(sessionId, req);
    }

    public com.justonetech.biz.utils.webService.hkVideoWebservice.bean.ServerResult getAllServers(String sessionId) {
        return getCmsServiceClient().getAllServers(sessionId);
    }

    public com.justonetech.biz.utils.webService.hkVideoWebservice.bean.CameraInfoResult getAllCameraInfoForList(String sessionId) {
        return getCmsServiceClient().getAllCameraInfoForList(sessionId);
    }

    public com.justonetech.biz.utils.webService.hkVideoWebservice.bean.LogoutResult userLogout(String sessionId) {
        return getCmsServiceClient().userLogout(sessionId);
    }

    public com.justonetech.biz.utils.webService.hkVideoWebservice.bean.CameraResult getAllCamera(String sessionId, com.justonetech.biz.utils.webService.hkVideoWebservice.bean.CommonPageReq req) {
        return getCmsServiceClient().getAllCamera(sessionId, req);
    }

    public com.justonetech.biz.utils.webService.hkVideoWebservice.bean.ControlUnitsResult getAllControlCenterForList(String sessionId) {
        return getCmsServiceClient().getAllControlCenterForList(sessionId);
    }

    public com.justonetech.biz.utils.webService.hkVideoWebservice.bean.CmsTimingResult setCmsTime(String sessionId, String time) {
        return getCmsServiceClient().setCmsTime(sessionId, time);
    }

    public com.justonetech.biz.utils.webService.hkVideoWebservice.bean.CameraResult getCameraInfoByDeviceInfo(String sessionId, String indexCode) {
        return getCmsServiceClient().getCameraInfoByDeviceInfo(sessionId, indexCode);
    }

    public com.justonetech.biz.utils.webService.hkVideoWebservice.bean.LoginResult userLogin(String userName, String pwd, String clientIp, Integer clientPort, String cmsUrl) {
        return getCmsServiceClient().userLogin(userName, pwd, clientIp, clientPort, cmsUrl);
    }

    public com.justonetech.biz.utils.webService.hkVideoWebservice.bean.PlaybackResult getPlaybackParam(String sessionId, com.justonetech.biz.utils.webService.hkVideoWebservice.bean.PlaybackParamReq req) {
        return getCmsServiceClient().getPlaybackParam(sessionId, req);
    }

    public com.justonetech.biz.utils.webService.hkVideoWebservice.bean.CommonResult userOnlineHeartbeat(String sessionId) {
        return getCmsServiceClient().userOnlineHeartbeat(sessionId);
    }

    public com.justonetech.biz.utils.webService.hkVideoWebservice.bean.RegionInfoResult getAllRegionInfoForList(String sessionId) {
        return getCmsServiceClient().getAllRegionInfoForList(sessionId);
    }

    public com.justonetech.biz.utils.webService.hkVideoWebservice.bean.StreamServerResult getAllStreamServer(String sessionId) {
        return getCmsServiceClient().getAllStreamServer(sessionId);
    }

    public com.justonetech.biz.utils.webService.hkVideoWebservice.bean.PreviewResult getPreviewParam(String sessionId, String cameraIndexCode) {
        return getCmsServiceClient().getPreviewParam(sessionId, cameraIndexCode);
    }

    public com.justonetech.biz.utils.webService.hkVideoWebservice.bean.VrmServerResult getAllVrmServer(String sessionId) {
        return getCmsServiceClient().getAllVrmServer(sessionId);
    }

    public com.justonetech.biz.utils.webService.hkVideoWebservice.bean.VrmRecordScheduleListForPMS getVrmRecordScheduleListForCMS(String sessionId) {
        return getCmsServiceClient().getVrmRecordScheduleListForCMS(sessionId);
    }
}
