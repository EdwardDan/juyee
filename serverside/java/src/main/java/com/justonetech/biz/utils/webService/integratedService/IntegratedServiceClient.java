package com.justonetech.biz.utils.webService.integratedService;

import com.justonetech.biz.utils.webService.ClientFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * User: juyee
 * Date: 12-4-26
 * Time: 上午10:36
 * To change this template use File | Settings | File Templates.
 */
public class IntegratedServiceClient {

    private static final Log log = LogFactory.getLog(IntegratedServiceClient.class);

    //WebService 地址
    private String endPointURL;
    //用户名
    private String user;
    //密码
    private String password;

    public void setEndPointURL(String endPointURL) {
        this.endPointURL = endPointURL;
    }

    public String getJdrwsByBjbh(String bjbh) {
        return getIntegratedServiceClient().getJdrwsByBjbh(bjbh);
    }

    public String getGcmxByJdrwsbh(String jdrwsbh) {
        return getIntegratedServiceClient().getGcmxByJdrwsbh(jdrwsbh);
    }

    public String helloWorld() {
        return getIntegratedServiceClient().helloWorld();
    }

    private IntegratedServiceSoap getIntegratedServiceClient() {
//        String endpointUrl = "http://192.168.1.164:8080/sms/service/smsWebService";
        return ClientFactory.getClient(IntegratedServiceSoap.class, endPointURL);
    }

}
