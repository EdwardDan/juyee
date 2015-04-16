package com.justonetech.biz.utils.webService.smsWebservice;

import com.justonetech.biz.utils.webService.smsWebservice.bean.MessageStatus;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * User: wisewang
 * Date: 2009-6-15
 * Time: 10:22:51
 * To change this template use File | Settings | File Templates.
 */

@WebService
public interface SmsWebService {
    /**
     * 发送短信息
     *
     * @param clientCode .
     * @param mobile     .
     * @param isSingle   .
     * @param content    .
     * @param level      .
     * @param sendDate   .
     * @return .
     */
    int sendMessage(
            @WebParam(name = "clientCode")
            String clientCode,
            @WebParam(name = "mobile")
            String mobile,
            @WebParam(name = "isSingle")
            boolean isSingle,
            @WebParam(name = "content")
            String content,
            @WebParam(name = "level")
            String level,
            @WebParam(name = "sendDate")
            Date sendDate);

    /**
     * 得到信息的状态
     *
     * @param clientCode .
     * @param bizId      .
     * @return .
     */
    public MessageStatus getMessageStatus(
            @WebParam(name = "clientCode")
            String clientCode,
            @WebParam(name = "bizId")
            String bizId);

    public MessageStatus[] getMessageStatuses(
            @WebParam(name = "clientCode")
            String clientCode,
            @WebParam(name = "bizIds")
            String[] bizIds);

    String getVersion();

    String test(
            @WebParam(name = "clientCode")
            String clientCode,
            @WebParam(name = "mobile")
            String mobile,
            @WebParam(name = "isSingle")
            boolean isSingle,
            @WebParam(name = "content")
            String content,
            @WebParam(name = "level")
            String level,
            @WebParam(name = "sendDate")
            Date sendDate);

}