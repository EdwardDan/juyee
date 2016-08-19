package com.justonetech.kxt;


import com.justonetech.kxt.util.HttpHandler;
import com.justonetech.kxt.util.JsonHandlerGson;
import org.apache.http.client.ClientProtocolException;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 发送短信
 *
 * @author user
 */
public class SendSMS {

    static public ResultMessage sendSMS(String url, SMSMessage sm) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("op", "sendSm");
        map.put("message", JsonHandlerGson.ToJsonStr(sm));
        String qencode = "utf-8";
        String bencode = "utf-8";
        boolean isGet = false;
        String resultStr = null;
        if (isGet) {
            try {
                resultStr = HttpHandler.myhttpGet(url, map, qencode, bencode);
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                resultStr = HttpHandler.myhttpPost(url, map, qencode, bencode);
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ResultMessage rm = JsonHandlerGson.formJsonStr(resultStr,
                ResultMessage.class);
        return rm;
    }
}
