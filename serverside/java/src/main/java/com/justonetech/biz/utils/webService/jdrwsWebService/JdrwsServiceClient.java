package com.justonetech.biz.utils.webService.jdrwsWebService;

import com.justonetech.biz.utils.webService.ClientFactory;
import com.justonetech.biz.utils.webService.jdrwsWebService.bean.Jdrws;
import com.justonetech.biz.utils.webService.jdrwsWebService.bean.JdrwsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * 监督任务书的webservice客户端
 */
public class JdrwsServiceClient {

    private static final Log log = LogFactory.getLog(JdrwsServiceClient.class);

    //WebService 地址
    private String endPointURL;
    //用户名
    private String user;
    //密码
    private String password;

    public void setEndPointURL(String endPointURL) {
        this.endPointURL = endPointURL;
    }

    private JdrwsService getJdrwsServiceClient() {
//        endPointURL = "http://192.168.1.42:8080/service/jdrwsWebService?wsdl";
        return ClientFactory.getClient(JdrwsService.class, endPointURL);
    }

    //根据监督任务编号获取监督任务书详细信息
    public Jdrws getJdrwsByJdrwsbh(String jdrwsbh) {
        return getJdrwsServiceClient().getJdrwsByJdrwsbh(jdrwsbh);
    }

    //根据报建编号获取监督任务书详细信息
    public List<Jdrws> getJdrwsByBjbh(String bjbh) {
        return getJdrwsServiceClient().getJdrwsByBjbh(bjbh);
    }

    //返回指定时间之后的所有监督任务书记录数量
    public int getJdrwsCountByLastId(String qxmc, String lastId) {
        return getJdrwsServiceClient().getJdrwsCountByLastId(qxmc, lastId);
    }

    //返回指定时间之后的所有监督任务书编号(指定数量)
    public List<String> getJdrwsBhByLastId(String qxmc, String lastId, int count) {
        return getJdrwsServiceClient().getJdrwsBhByLastId(qxmc, lastId, count);
    }

    //返回指定时间之后的所有监督任务书记录数量
    public int getJdrwsCountByLastTime(String qxmc, String lastTime) {
        return getJdrwsServiceClient().getJdrwsCountByLastTime(qxmc, lastTime);
    }

    //返回指定时间之后的所有监督任务书编号(指定数量)
    public List<String> getJdrwsBhByLastTime(String qxmc, String lastTime, int count) {
        return getJdrwsServiceClient().getJdrwsBhByLastTime(qxmc, lastTime, count);
    }
}
