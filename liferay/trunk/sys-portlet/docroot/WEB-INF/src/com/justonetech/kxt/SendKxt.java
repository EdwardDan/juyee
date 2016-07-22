package com.justonetech.kxt;

import com.justonetech.kxt.util.JsonHandlerGson;
import com.justonetech.sys.model.SMS;
import com.liferay.portal.kernel.util.PropsUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by gq on 2016/4/11.
 * 快信通短信发送（暂时）
 */
public class SendKxt {
    public static void SendKxtSMS(String content,String receiver) {
        String url = PropsUtil.get("sms.server.url");;
        SMSMessage sm = new SMSMessage();
        /**
         * 先设置Timestamp 取当前时间，
         * SMSMessage 内部会自动生成 Timestamp 要求字符串
         * 一定要在设置密码前面，密码加密用到 Timestamp
         * 密码md5加密也是SMSMessage 内部实现
         *
         */
        sm.setTimestamp(new Date());
        sm.setCid(PropsUtil.get("sms.server.cid"));
        sm.setUid(PropsUtil.get("sms.server.uid"));
        sm.setPwd(PropsUtil.get("sms.server.pwd"));
        sm.setContent(content);
        List<String> msd = new ArrayList<String>();
            String[] mobiles = receiver.split(",");
            for (String mobile : mobiles) {
                msd.add(mobile);
            }
//        }
        sm.setMobiles(msd.toArray(new String[msd.size()]));

        System.out.println(JsonHandlerGson.ToJsonStr(sm));
        long startTime = System.currentTimeMillis();
        ResultMessage rm = SendSMS.sendSMS(url, sm);
        long endTime = System.currentTimeMillis();
        System.out.println(JsonHandlerGson.ToJsonStr(rm));
        System.out.println("毫时：" + (endTime - startTime));
        System.out.println("返回状态：" + rm.getStateCode());
    }
}
