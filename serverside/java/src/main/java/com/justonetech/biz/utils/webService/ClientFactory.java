package com.justonetech.biz.utils.webService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.CXFBusFactory;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.WSSConfig;
import org.apache.ws.security.handler.WSHandlerConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * 生成client的工厂类
 *
 * @author Youyiming
 */
public class ClientFactory {
    protected static Log log = LogFactory.getLog(ClientFactory.class);

    /**
     * 根据address来获得对应的client
     *
     * @param clazz
     * @param address
     * @param userName
     * @param password
     * @param <T>
     * @return
     */
    public static <T extends Object> T getClient(final Class<T> clazz, final String address, final String userName, final String password) {
        //关闭密码算法
        WSSConfig.setAddJceProviders(false);

        //默认的BusFactory是SpringBusFactory，此处将BusFactory显式更改为CXFBusFactory，以脱离spring
        log.debug("set CXFBusFactory to BusFactory as default bus.");
        CXFBusFactory busFactory = new CXFBusFactory();
        Bus bus = busFactory.createBus();
        CXFBusFactory.setDefaultBus(bus);

        //添加日志拦截器
        log.debug("add log intercept.");
        JaxWsProxyFactoryBean clientFactory = new JaxWsProxyFactoryBean();
        clientFactory.getInInterceptors().add(new LoggingInInterceptor());
        clientFactory.getOutInterceptors().add(new LoggingOutInterceptor());
        clientFactory.setServiceClass(clazz);
        clientFactory.setAddress(address);

        ClientPasswordCallback clientPasswordCallback = new ClientPasswordCallback();
        clientPasswordCallback.auth(userName, password);

        log.debug("set WSS4JOutInterceptor param.");
        Map<String, Object> outProps = new HashMap<String, Object>();
        outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
        outProps.put(WSHandlerConstants.USER, userName);
        outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        outProps.put(WSHandlerConstants.PW_CALLBACK_REF, clientPasswordCallback);

        WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
        log.debug("wssOut is " + wssOut);
        clientFactory.getOutInterceptors().add(wssOut);
        log.debug("clientFactory is " + clientFactory);

        Object client = clientFactory.create();

        //如果采用https调用则设置客户端信任
        if (address.trim().toLowerCase().startsWith("https")) {
            ClientUtils.configureSSLOnTheClient(client);
        }

        outProps = null;

        return (T) client;
    }

    /**
     * 根据address来获得对应的client
     *
     * @param clazz
     * @param address
     * @param <T>
     * @return
     */
    public static <T extends Object> T getClient(final Class<T> clazz, final String address) {
        //关闭密码算法
        WSSConfig.setAddJceProviders(false);

        //默认的BusFactory是SpringBusFactory，此处将BusFactory显式更改为CXFBusFactory，以脱离spring
        log.debug("set CXFBusFactory to BusFactory as default bus.");
        CXFBusFactory busFactory = new CXFBusFactory();
        Bus bus = busFactory.createBus();
        CXFBusFactory.setDefaultBus(bus);

        //添加日志拦截器
        log.debug("add log intercept.");
        JaxWsProxyFactoryBean clientFactory = new JaxWsProxyFactoryBean();
        clientFactory.getInInterceptors().add(new LoggingInInterceptor());
        clientFactory.getOutInterceptors().add(new LoggingOutInterceptor());
        clientFactory.setServiceClass(clazz);
        clientFactory.setAddress(address);

        log.debug("clientFactory is " + clientFactory);
        Object client = clientFactory.create();
        return (T) client;
    }
}
