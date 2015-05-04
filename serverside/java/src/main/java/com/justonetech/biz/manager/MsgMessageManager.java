package com.justonetech.biz.manager;

import com.justonetech.biz.daoservice.MsgMessageService;
import com.justonetech.biz.daoservice.MsgSendDetailService;
import com.justonetech.biz.domain.MsgMessage;
import com.justonetech.biz.domain.MsgSendDetail;
import com.justonetech.biz.utils.webService.smsWebservice.client.SmsWSClientService;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysPersonService;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.domain.SysRegPerson;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysPersonManager;
import com.justonetech.system.manager.SysUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * 短信发送调用入口
 * User: chenjp
 */
@Service
public class MsgMessageManager {
    private Logger logger = LoggerFactory.getLogger(MsgMessageManager.class);

    @Autowired
    SmsWSClientService smsWSClientService;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private MsgSendDetailService msgSendDetailService;

    @Autowired
    private MsgMessageService msgMessageService;

    @Autowired
    private SysPersonService sysPersonService;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private SysPersonManager sysPersonManager;

    /**
     * 发送短信
     *
     * @param content .
     * @param mobile  .
     * @return .
     */
    public int sendSms(String content, String mobile) {
        if (!StringHelper.isEmpty(content) && JspHelper.getString(mobile).length() == 11) {
            String sender = "";
            SysUser sysUser = sysUserManager.getSysUser();
            if (sysUser != null) {
                sender = sysUser.getDisplayName();
            }
            MsgMessage data = new MsgMessage();
            data.setContent(content);
            data.setSender(sender);
            data.setMobiles(mobile);
            data.setIsSend(true);
            data.setIsSendSms(true);
            data.setSendTime(new Timestamp(System.currentTimeMillis()));
            msgMessageService.save(data);

            MsgSendDetail detail = new MsgSendDetail();
            detail.setSmsMessage(data);
            detail.setReceiveMobile(mobile);
            msgSendDetailService.save(detail);

            return sendSmsByMsgSendDetail(detail);
        }
        return 0;
    }

    /**
     * 发送短信--短信发送页面调用
     *
     * @param msgSendDetail .
     * @return .
     */
    public int sendSmsByMsgSendDetail(MsgSendDetail msgSendDetail) {
        if (configManager.getSendSms()) {  //开关打开后才能发送短信，否则只有系统消息
            String content = JspHelper.getString(msgSendDetail.getSmsMessage().getContent());
            if (!StringHelper.isEmpty(content)) {
                String mobile = JspHelper.getString(msgSendDetail.getReceiveMobile());
                if (mobile.length() == 11) {
                    content = "[" + configManager.getSiteName()+"]" + content;  //添加短信抬头
                    int ret = smsWSClientService.sendMessage(mobile, true, content, '0');
                    msgSendDetail.setSendSmsTime(new Timestamp(System.currentTimeMillis()));  //设置发送时间
                    msgSendDetailService.save(msgSendDetail);
                    return ret;
                }
            }
        }
        return 0;  //没有发送
    }

    /**
     * 将接收用户转换为人员后发送消息
     *
     * @param content        .
     * @param senderUser     .
     * @param receiveUserIds .
     */
    public void sendSmsByUser(String content, SysUser senderUser, String[] receiveUserIds) {
        if (!StringHelper.isEmpty(content) && receiveUserIds.length > 0) {
            sendSms(content, senderUser, sysUserManager.getPersonIds(receiveUserIds));
        }
    }

    /**
     * 发送短信--业务模块调用
     *
     * @param content          .
     * @param senderUser       .
     * @param receivePersonIds .
     */
    private void sendSms(String content, SysUser senderUser, String[] receivePersonIds) {
        if (receivePersonIds != null && receivePersonIds.length > 0) {
            MsgMessage target = new MsgMessage();
            target.setContent(content);
            if (senderUser != null) {
                target.setSender(senderUser.getDisplayName());
            }
            target.setIsSend(true);
            target.setSendTime(new Timestamp(System.currentTimeMillis()));
            target.setInnerPersonIds(StringHelper.stringArrayToString(receivePersonIds, ","));
            target.setInnerPersonNames(sysPersonManager.getSysPersonNames(receivePersonIds));
            msgMessageService.save(target);

            for (String personId : receivePersonIds) {
                SysPerson sysPerson = sysPersonService.get(Long.valueOf(personId));
                MsgSendDetail msgSendDetail = new MsgSendDetail();
                msgSendDetail.setSmsMessage(target);
                msgSendDetail.setReceiveName(sysPerson.getName());
                msgSendDetail.setReceiveMobile(sysPerson.getMobile());
                msgSendDetail.setSysPersonId(Long.valueOf(personId));
                msgSendDetailService.save(msgSendDetail);
                sendSmsByMsgSendDetail(msgSendDetail);
            }
        }
    }

    /**
     * 发送短信给一位用户
     *
     * @param content      .
     * @param senderUser   .
     * @param sysRegPerson .
     */
    public void sendSmsByRegPerson(String content, SysUser senderUser, SysRegPerson sysRegPerson) {
        if (sysRegPerson != null) {
            MsgMessage target = new MsgMessage();
            target.setContent(content);
            if (senderUser != null) {
                target.setSender(senderUser.getDisplayName());
            }
            target.setIsSend(true);
            target.setSendTime(new Timestamp(System.currentTimeMillis()));
            msgMessageService.save(target);

            MsgSendDetail msgSendDetail = new MsgSendDetail();
            msgSendDetail.setSmsMessage(target);
            msgSendDetail.setReceiveName(sysRegPerson.getPersonName());
            msgSendDetail.setReceiveMobile(sysRegPerson.getMobile());
            msgSendDetail.setGdPersonId(sysRegPerson.getId());
            msgSendDetailService.save(msgSendDetail);
            sendSmsByMsgSendDetail(msgSendDetail);
        }
    }

    /**
     * 获取我收到的消息
     *
     * @return 。
     */
    public List<MsgSendDetail> getMyMsgs(Boolean onlyShowUnRead) {
        Long sysPersonId = -1l;
        SysUser sysUser = sysUserManager.getSysUser();
        if (sysUser != null) {
            sysPersonId = sysUser.getPerson().getId();
        }
        String hql = "from MsgSendDetail where receiveName is not null and (sysPersonId=?)";
        if (onlyShowUnRead) {
            hql += " and readTime is null";
        }
        hql += " order by id desc";
        return msgSendDetailService.findByQuery(hql, sysPersonId);
    }
}
