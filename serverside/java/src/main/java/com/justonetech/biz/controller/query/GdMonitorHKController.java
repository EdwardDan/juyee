package com.justonetech.biz.controller.query;

import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.utils.webService.hkVideoWebservice.HkVideoServiceClient;
import com.justonetech.biz.utils.webService.hkVideoWebservice.bean.*;
import com.justonetech.biz.utils.webService.hkVideoWebservice.xmlbean.*;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.utils.Md5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 工地视频--海康视频接口
 * User: Chen Junping
 * Date: 14-9-19
 */
@Controller
public class GdMonitorHKController extends BaseCRUDActionController {

    private Logger logger = LoggerFactory.getLogger(ProjectQueryController.class);

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private HkVideoServiceClient videoServiceClient;

    public static String VIDEO_SESSION_ID = null;
    public static String VIDEO_LOCAL_IP = null;
    public static int VIDEO_LOCAL_PORT = 0;

    /**
     * 获取SessionId
     *
     * @return .
     */
    private String getSessionId() {
        String userName = configManager.getHkVideoUser();
        String password = configManager.getHkVideoPass();
        String pwd = Md5Utils.md5(password);
        LoginResult loginResult = videoServiceClient.userLogin(userName, pwd, VIDEO_LOCAL_IP, VIDEO_LOCAL_PORT, "");
        if (loginResult != null) {
            return loginResult.getSessionId().getValue();
        }
        return null;
    }

    /**
     * 检查是否登录，如未登录或过期则重新登录
     *
     * @return .
     */
    private HkVideoServiceClient getClient() {
        if (VIDEO_SESSION_ID == null) {
            VIDEO_SESSION_ID = getSessionId();
            return videoServiceClient;
        } else {
            CommonResult commonResult = videoServiceClient.userOnlineHeartbeat(VIDEO_SESSION_ID);
            if (commonResult.getErrorCode() > 0) {
                VIDEO_SESSION_ID = getSessionId();
            }
            return videoServiceClient;
        }
    }

    private String getIntegerValue(JAXBElement<Integer> object) {
        return JspHelper.getString(object.getValue());
    }

    private String getStringValue(JAXBElement<String> object) {
        return JspHelper.getString(object.getValue());
    }

    /**
     * 入口页面
     *
     * @param model .
     */
    @RequestMapping
    public String init(Model model) {

        return "view/query/gdMonitorHK/init";
    }

    /**
     * 显示页面
     *
     * @param model 。
     */
    @RequestMapping
    public String view(Model model, HttpServletRequest request) {
        //获取本机IP地址和端口
        if (VIDEO_LOCAL_IP == null) {
            String ip = JspHelper.getString(request.getLocalAddr());
            if (ip.split(".").length == 4) {
                VIDEO_LOCAL_IP = ip;
            } else {
                VIDEO_LOCAL_IP = "192.168.1.42";
            }
            VIDEO_LOCAL_PORT = request.getLocalPort();
            if (VIDEO_LOCAL_PORT <= 0) {
                VIDEO_LOCAL_PORT = 8080;
            }
        }
//        System.out.println("VIDEO_LOCAL_IP = " + VIDEO_LOCAL_IP+"|"+VIDEO_LOCAL_PORT);

        //获取所有摄像头
        Map<String, List<Map<String, Object>>> allCameraHM = new HashMap<String, List<Map<String, Object>>>();
        CameraInfoResult allCameraInfoForList = getClient().getAllCameraInfoForList(VIDEO_SESSION_ID);
        List<CameraInfoDTO> cameraInfoDTOArray = allCameraInfoForList.getCameraInfoDTOArray();
        for (CameraInfoDTO data : cameraInfoDTOArray) {
            String regionId = getIntegerValue(data.getRegionId());
            List<Map<String, Object>> maps = allCameraHM.get(regionId);
            if (maps == null) maps = new ArrayList<Map<String, Object>>();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("cameraId", getIntegerValue(data.getCameraId()));
            map.put("cameraName", getStringValue(data.getName()));
            maps.add(map);
            allCameraHM.put(regionId, maps);
        }

        List<Map<String, Object>> regionList = new ArrayList<Map<String, Object>>();
        //获取所有区域
        RegionInfoResult allRegionInfoForList = getClient().getAllRegionInfoForList(VIDEO_SESSION_ID);
        List<RegionInfoDTO> regionInfoArray = allRegionInfoForList.getRegionInfoArray();
        for (RegionInfoDTO data : regionInfoArray) {
            String regionId = getIntegerValue(data.getRegionId());
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("regionId", regionId);
            map.put("regionName", getStringValue(data.getName()));
            map.put("cameras", allCameraHM.get(regionId));
            regionList.add(map);
        }
        model.addAttribute("regionList", regionList);

        return "view/query/gdMonitorHK/view";
    }

    /**
     * 将从webservice获取的视频参数masurall成xml提供给ocx
     *
     * @param cameraId 视频点ID
     * @return xml
     */
    @RequestMapping
    public String getVideoXml(Model model, String cameraId) {
//        String ip = "101.231.79.178";   //固定IP
        String ip = configManager.getHkVideoIp();
        String result = "";
        try {
            if (!StringHelper.isEmpty(cameraId)) {
                CameraInfoDTO camera = null;
                CameraInfoResult allCameraInfoForList = getClient().getAllCameraInfoForList(VIDEO_SESSION_ID);
                List<CameraInfoDTO> cameraInfoDTOArray = allCameraInfoForList.getCameraInfoDTOArray();
                for (CameraInfoDTO data : cameraInfoDTOArray) {
                    if (getIntegerValue(data.getCameraId()).equals(cameraId)) {
                        camera = data;
                        break;
                    }
                }
                if (camera != null) {
                    //无法通过getPreviewParam方法获取getPreviewXml，否则下面数据都不需要一一赋值
//                    System.out.println("camera = " + getStringValue(camera.getIndexCode()));
//                    PreviewResult previewParam = getClient().getPreviewParam(VIDEO_SESSION_ID, getStringValue(camera.getIndexCode()));
//                    System.out.println("getClient().getPreviewParam(VIDEO_SESSION_ID,camera.getIndexCode()) = " + previewParam.getPreviewXml().getValue());

                    //获取pagserver -- 与静安不同
                    PagServerDTO pagServerDTO = null;
                    ServerResult allServers = getClient().getAllServers(VIDEO_SESSION_ID);
                    List<PagServerDTO> pagServerArray = allServers.getPagServerArray();
                    if(pagServerArray.size()>0){
                        pagServerDTO = pagServerArray.iterator().next();
                    }

                    String deviceId = getIntegerValue(camera.getDeviceId());       //设备ID
//            System.out.println("deviceId = " + deviceId);
                    //获取设备信息
                    DeviceDTO device = null;

                    //每次获取记录数
                    CommonPageReq page = new CommonPageReq();
                    page.setPageItems(200);
                    page.setReqPage(1);
                    DeviceResult allDevice = getClient().getAllDevice(VIDEO_SESSION_ID, page);
                    List<DeviceDTO> deviceArray = allDevice.getDeviceArray();
                    for (DeviceDTO deviceDTO : deviceArray) {
                        if (deviceDTO.getDeviceId().getValue() == Integer.parseInt(deviceId)) {
                            device = deviceDTO;
                            break;
                        }
                    }

//            System.out.println("device = " + device);

                    MessageType messageType = new MessageType();

                    CameraType cameraType = new CameraType();
                    cameraType.setId(getIntegerValue(camera.getCameraId()));        //1
                    cameraType.setIndexCode(getStringValue(camera.getIndexCode())); //10001310012917
                    cameraType.setName(getStringValue(camera.getName()));           //常德路370号大门
                    cameraType.setChanNo(getIntegerValue(camera.getChanNum()));     //0

                    MatrixType matrixType = new MatrixType();
                    matrixType.setId("0");
                    matrixType.setCode("0");
                    cameraType.setMatrix(matrixType);
                    messageType.setCamera(cameraType);

                    DevType devType = new DevType();
                    if (device != null) {
                        devType.setId(deviceId);           //1
                        devType.setRegtype(getIntegerValue(device.getRegisterType()));      //4 --可以控制
                        devType.setIndexCode(getStringValue(device.getIndexCode())); //1000
//                        devType.setDevtype("0");      //0
                        devType.setDevtype(getIntegerValue(device.getTypeCode()));      //10008 -- 可以控制
                    }

                    AddrType addrType = new AddrType();
                    addrType.setIP(getStringValue(device.getNetworkAddr()));    //112.64.191.100  设备IP
                    addrType.setPort(getIntegerValue(device.getNetworkPort())); //1035 设备端口
                    devType.setAddr(addrType);

                    AuthType authType = new AuthType();
                    authType.setUser(getStringValue(device.getUserName()));       //admin
                    authType.setPwd(getStringValue(device.getUserPwd()));        //12345
                    devType.setAuth(authType);
                    messageType.setDev(devType);

                    VagType vagType = new VagType();
                    if(pagServerDTO != null){   //从pagserver中获取
                        vagType.setIP(getStringValue(pagServerDTO.getIpAddr()));       //10.205.106.1
                        vagType.setPort(getIntegerValue(pagServerDTO.getDataPort()));  //7302
                    }else{
//                        vagType.setIP(getStringValue(device.getDnsAddr()));       //101.231.188.174  -->192.168.1.3
//                        vagType.setPort(getIntegerValue(device.getDnsPort()));    //7302
                        vagType.setIP("10.205.106.1");
                        vagType.setPort("7302");
                    }
                    messageType.setVag(vagType);

                    VoiceType voiceType = new VoiceType();
                    voiceType.setEncode("0");
                    messageType.setVoice(voiceType);

                    UserType userType = new UserType();
                    userType.setName(getStringValue(device.getUserName()));    //admin
                    userType.setIP(ip);                                      //101.231.188.174
                    messageType.setUser(userType);

                    MediaType mediaType = new MediaType();
                    mediaType.setProtocol("0");
                    mediaType.setStream("0");
                    VtduType vtduType = new VtduType();
                    vtduType.setIP(ip);         //101.231.188.174
                    vtduType.setPort("554");   //554
                    mediaType.setVtdu(vtduType);
                    messageType.setMedia(mediaType);

                    PrivilegeType privilegeType = new PrivilegeType();
                    privilegeType.setPriority("50");
                    privilegeType.setCode("15");    //15,7,3
                    messageType.setPrivilege(privilegeType);

                    OptionType optionType = new OptionType();
                    optionType.setPreviewType("1");
                    optionType.setTalk("1");
                    messageType.setOption(optionType);

                    JAXBContext context = JAXBContext.newInstance(MessageType.class);
                    Marshaller marshaller = context.createMarshaller();
//                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  //格式化
                    marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");      //编码

                    StringWriter writer = new StringWriter();
                    marshaller.marshal(messageType, writer);
                    result = writer.toString();
                    logger.debug("result = " + result);
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        model.addAttribute("msg", result);
        return "common/msg";
    }
}
