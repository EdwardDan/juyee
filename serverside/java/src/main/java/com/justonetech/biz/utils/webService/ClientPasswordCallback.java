package com.justonetech.biz.utils.webService;

import org.apache.ws.security.WSPasswordCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: youyiming
 * Date: 2009-6-4
 * Time: 21:29:27
 * To change this template use File | Settings | File Templates.
 */
public class ClientPasswordCallback implements CallbackHandler {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    private String ClientCode;

    private String password;

    public void auth(String clientCode, String password) {
        this.ClientCode = clientCode;
        this.password = password;
    }

    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];

        // set the password for our message.
        pc.setIdentifier(ClientCode);
        pc.setPassword(password);
    }

}
