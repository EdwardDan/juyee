package com.justonetech.biz.utils.webService.smsWebservice.client;

import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.utils.webService.ClientFactory;
import com.justonetech.biz.utils.webService.smsWebservice.SmsWebService;
import com.justonetech.biz.utils.webService.smsWebservice.bean.MessageStatus;
import com.justonetech.biz.utils.webService.smsWebservice.bean.MobileStatus;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Date;

/**
 * WebService的客户端程序
 * 供需要调用WebService的各应用程序使用
 *
 * @author MaJi
 * @version 1.0
 * @since 2010-12-28
 */
public class SmsWSClientService {

    private static final Log log = LogFactory.getLog(SmsWSClientService.class);

    //WebService 地址
    private String endPointURL;
    //用户名
    private String user;
    //密码
    private String password;
    //客户端代码
    private String clientCode;

    public void setEndPointURL(String endPointURL) {
        this.endPointURL = endPointURL;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    /**
     * 发送信息
     * 使用当前时间做为默认的信息发送时间
     *
     * @param mobile   .
     * @param isSingle .
     * @param content  .
     * @param level    .
     * @return .
     */

    public int sendMessage(String mobile, boolean isSingle, String content, char level) {
        mobile = checkMsg(mobile, level);
        if (!StringHelper.isEmpty(mobile)) {
            return sendMessage(mobile, isSingle, content, level, new Date());
        } else {
            return 0;
        }
    }
    private String checkMsg(String mobile, char level) {
        //step1. check mobile empty
        if (StringHelper.isEmpty(mobile)) {
            return null;
        }

        //step2. level must in ('D',....)
        if (!isValidLevel(level)) {
            return null;
//            throw new RuntimeException("this is a valid level");
        }

        //step3. check mobile valid
        String[] mobiles = mobile.trim().split(";");
        if (mobiles.length < 1) {
            return null;
//            throw new RuntimeException("at least one valid mobile phone is required!");
        }

        String ret = "";
        for (String s : mobiles) {
            if (isValidMobile(s)) {
                ret += ";" + s;
            }
//                throw new RuntimeException(s + "is not a valid mobile phone number!");
        }
        if (!ret.equals("")) {
            ret = ret.substring(1);
        }
        return ret;
    }

    /**
     * 发送信息
     *
     * @param mobile   .
     * @param isSingle .
     * @param content  .
     * @param level    .
     * @param sendDate .
     * @return .
     */
    public int sendMessage(String mobile, boolean isSingle, String content, char level, Date sendDate) {
        //step4. call webservice and return id
        SmsWebService clientService = getSmsClient();

        //为客户端设置信任
//        ClientUtils.configureSSLOnTheClient(clientService);

        return clientService.sendMessage(clientCode, mobile, isSingle, content, String.valueOf(level), new Date());
    }


    /**
     * 获取消息的状态
     *
     * @return mobile status
     */
    public MobileStatus[] getMobileStatuses() {
        SmsWebService smsClient = getSmsClient();
        log.debug("smsClient = " + smsClient);
        if (null == smsClient) {
            log.error("the sms client is null");
        }
        log.info("ready to get message status");
        MessageStatus messageStatus = smsClient.getMessageStatus("admin", "4");
        log.debug("the bizId is " + messageStatus.getBizId());
        MobileStatus[] statuses = messageStatus.getMobileStatuses();
        return statuses;
    }

    /**
     * 获取版本号
     *
     * @return version 返回WebService的具体版本
     */
    public String getVersion() {
        SmsWebService smsClient = getSmsClient();
        return smsClient.getVersion();
    }

    /**
     * 测试方法
     *
     * @param mobile   .
     * @param isSingle .
     * @param content  .
     * @param level    .
     * @param sendDate .
     * @return .
     */
    public String test(String mobile, boolean isSingle, String content, String level, Date sendDate) {
        return null;
    }

    private SmsWebService getSmsClient() {
//        String endpointUrl = "http://192.168.1.164:8080/sms/service/smsWebService";
        return ClientFactory.getClient(SmsWebService.class, endPointURL, user, password);
    }

    /**
     * 判断手机号码是否合法
     * 检查：
     * 1.位数是否是11位
     * 2.是否以0－9的字符组成的
     * 3.是否以1开头
     *
     * @param mobile 手机号码
     * @return 是否合法
     */
    private boolean isValidMobile(String mobile) {
        if (mobile.length() != 11)
            return false;

        for (int i = 0; i < mobile.length(); i++) {
            if (mobile.charAt(i) < '0' || (mobile.charAt(i) > '9')) {
                return false;
            }
        }

        //手机号以‘1’开头
        return mobile.charAt(0) == '1';
    }

    /**
     * 判断发送等级是否合法
     *
     * @param level 发送等级
     * @return 是否合法
     */
    private boolean isValidLevel(char level) {
        return (level >= '0' && level <= '9') || level == 'N' || level == 'D';
    }
}