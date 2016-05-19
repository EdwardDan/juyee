package kxt;

import com.justonetech.biz.domain.MsgSendDetail;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.core.utils.StringHelper;
import kxt.util.JsonHandlerGson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by gq on 2016/4/11.
 * 快信通短信发送（暂时）
 */
public class SendKxt {
    private ConfigManager configManager;
    public static void SendKxtSMS(MsgSendDetail msgSendDetail) {
        String url = "http://121.40.152.72:8180/webservice/http/service";
        SMSMessage sm = new SMSMessage();
        /**
         * 先设置Timestamp 取当前时间，
         * SMSMessage 内部会自动生成 Timestamp 要求字符串
         * 一定要在设置密码前面，密码加密用到 Timestamp
         * 密码md5加密也是SMSMessage 内部实现
         *
         */
        sm.setTimestamp(new Date());
        sm.setCid("8000517");
        sm.setUid("admin");
        sm.setPwd("20160519");
        sm.setContent(msgSendDetail.getSmsMessage().getContent());
        List<String> msd = new ArrayList<String>();
//        String receiveMobile = msgSendDetail.getSmsMessage().getMobiles();
        String receiveMobile = msgSendDetail.getReceiveMobile();
        if (!StringHelper.isEmpty(receiveMobile)) {
            String[] mobiles = receiveMobile.split(",");
            for (String mobile : mobiles) {
                msd.add(mobile);
            }
        }
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
