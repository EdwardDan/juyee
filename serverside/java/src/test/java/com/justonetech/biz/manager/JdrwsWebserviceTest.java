package com.justonetech.biz.manager;

import com.justonetech.biz.utils.webService.ClientFactory;
import com.justonetech.biz.utils.webService.jdrwsWebService.bean.Jdrws;
import com.justonetech.biz.utils.webService.jdrwsWebService.bean.JdrwsService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * description:
 * User: Chenjp
 * Date: 14-5-22 下午4:23
 */
public class JdrwsWebserviceTest {
    private static Logger logger = LoggerFactory.getLogger(JdrwsWebserviceTest.class);

    @Test
    public void testMethod1() {
        String endPointURL = "http://192.168.1.42:8080/service/jdrwsWebService?wsdl";
        JdrwsService client = ClientFactory.getClient(JdrwsService.class, endPointURL);
        Jdrws data = client.getJdrwsByJdrwsbh("1302HK0107JDS001");
        System.out.println("data = " + data.getXmmc());
    }
}