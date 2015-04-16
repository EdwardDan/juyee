package com.justonetech.biz.utils.webService.monitorWebService;

import com.justonetech.biz.utils.webService.ClientFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * User: juyee
 * Date: 12-4-26
 * Time: 上午10:36
 * To change this template use File | Settings | File Templates.
 */
public class MonitorWebServiceClient {

    private static final Log log = LogFactory.getLog(MonitorWebServiceClient.class);

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

    public MonitorService getMonitorService(String arg) throws Exception_Exception {
        return getMonitorWebServiceClient().getMonitorService(arg);
    }

    public List<Monitor> getMonitorList(MonitorParam monitorParam) throws Exception_Exception {
        return getMonitorWebServiceClient().getMonitorList(monitorParam);
    }

    private MonitorWebService getMonitorWebServiceClient() {
        return ClientFactory.getClient(MonitorWebService.class, endPointURL, user, password);
    }
}
