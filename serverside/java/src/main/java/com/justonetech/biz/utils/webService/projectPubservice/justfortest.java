package com.justonetech.biz.utils.webService.projectPubservice;

import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import java.util.List;

public class justfortest {
    public static void main(String[] args) {

        HttpClientParams params = new HttpClientParams();
        params.setParameter(HttpClientParams.USE_EXPECT_CONTINUE, Boolean.FALSE);
        params.setParameter(HttpClientParams.CONNECTION_MANAGER_TIMEOUT, 300 * 1000L);
//        Client.getInstance(ProjectPubservice).setProperty(CommonsHttpMessageSender.HTTP_CLIENT_PARAMS, params);
        JaxWsProxyFactoryBean svr = new JaxWsProxyFactoryBean();
        svr.setServiceClass(ProjectPubservice.class);
        svr.setAddress("http://localhost:8080/mis/service/getProBuildService");
        ProjectPubservice client = (ProjectPubservice) svr.create();
        List<WebProToBuild> webProToBuildList = client.getAllProBuildInfo();
        for (WebProToBuild webProToBuild : webProToBuildList) {
            System.out.println(webProToBuild.getBuildUnitName());
        }
    }
}
