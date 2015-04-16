package com.justonetech.biz.utils.webService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;

import javax.net.ssl.TrustManager;

/**
 * 用来设置WebService的Client
 *
 * @author MaJi
 * @version 1.0
 * @since 2011-1-6
 */
public class ClientUtils {
    private static final Log log = LogFactory.getLog(ClientUtils.class);

    /**
     * 设置受信任的客户端
     *
     * @param c client
     */
    public static void configureSSLOnTheClient(Object c) {
        org.apache.cxf.endpoint.Client client = ClientProxy.getClient(c);
        HTTPConduit httpConduit = (HTTPConduit) client.getConduit();

        try {
            TLSClientParameters tlsParams = new TLSClientParameters();
            tlsParams.setDisableCNCheck(true);

            tlsParams.setTrustManagers(new TrustManager[]{
                    //
                    new FakeTrustManager()
            });

            httpConduit.setTlsClientParameters(tlsParams);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}

/**
 * X509TrustManager实现类
 * 用来生成一个空的信任方案
 */
class FakeTrustManager implements javax.net.ssl.X509TrustManager {
    private static final Log log = LogFactory.getLog(FakeTrustManager.class);

    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        log.info("getAcceptedIssuers");
        return null;
    }

    public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
        log.info("checkClientTrusted");
    }

    public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
        log.info("checkServerTrusted");
    }
}