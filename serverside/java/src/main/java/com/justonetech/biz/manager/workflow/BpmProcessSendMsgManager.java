package com.justonetech.biz.manager.workflow;

import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.MsgMessageManager;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 流程发送短信
 * author: Chen Junping
 * Date: 2012-05-07
 */
@Service
public class BpmProcessSendMsgManager {
    private Logger logger = LoggerFactory.getLogger(BpmProcessSendMsgManager.class);

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private MsgMessageManager msgMessageManager;

    @Autowired
    private BpmProcessInstanceManager bpmProcessInstanceManager;

    @Autowired
    private SysUserManager sysUserManager;

    /**
     * 取短信模板内容
     *
     * @param bpmTaskInstance .
     * @param curUser .
     * @return  .
     * @throws Exception  .
     */
    public Map<String, Object> getMsgContent(BpmTaskInstance bpmTaskInstance, SysUser curUser) throws Exception {
        Map<String, Object> retMap = new HashMap<String, Object>();

        BpmProcessInstance processInstance = bpmTaskInstance.getProcessInstance();
        BpmProcessDefinition processDefinition = processInstance.getProcessDefinition();

        //发送人
        SysUser senderUser = null;
        if (curUser != null) {
            senderUser = curUser;
        } else {
            BpmFormAction formAction = bpmTaskInstance.getBpmFormAction();
            BpmStandardAction standardAction = bpmTaskInstance.getBpmStandardAction();
            if (formAction != null) {
                senderUser = formAction.getSubmitUser();
            } else if (standardAction != null) {
                senderUser = standardAction.getSubmitUser();
            }
        }

        //短信模板
        String title = "系统提醒：";
        String content = "";
        //流程发送系统消息及短信（取固定写死的短信内容）
        //标题
        if (!StringHelper.isEmpty(processInstance.getCode())) {
            title += "编号为[" + processInstance.getCode() + "]";
        } else if (!StringHelper.isEmpty(processInstance.getTitle())) {
            title += "标题为[" + processInstance.getTitle() + "]";
        }
        title += "的" + processDefinition.getName() + "已经提交，待您处理！";

        //内容
        content = DateTimeHelper.formatTimestamp(new Timestamp(System.currentTimeMillis()), "YYYY-MM-DD HH:MM");
        if (senderUser != null) {
            content = " 提交人：" + senderUser.getDisplayName() + " " + content;
        }
        retMap.put("title", title);
        retMap.put("content", content);
//        retMap.put("senderUser", senderUser);

        //接收人
        List<String> currentActorIds = bpmProcessInstanceManager.getCurrentActorIds(processInstance);
        String ids = "";
        for (String userId : currentActorIds) {
            try {
                SysUser user = sysUserService.get(Long.valueOf(userId));
                if("".equals(ids)){
                    ids += user.getPerson().getId();
                }else{
                    ids += ","+user.getPerson().getId();
                }
            } catch (NumberFormatException e) {
            }
        }
        retMap.put("receivePersonIds",ids);

        return retMap;
    }

    /**
     * 提交审核发送信息（固定写死的内容）--已取消，
     *
     * @param bpmTaskInstance 任务实例
     * @param receiveUserIds  接收用户
     * @throws Exception .
     */
    public void sendJbpmMsg(BpmTaskInstance bpmTaskInstance, String[] receiveUserIds) throws Exception {
        Map<String, Object> map = getMsgContent(bpmTaskInstance, null);
        SysUser sendUser = map.get("senderUser") != null ? (SysUser) map.get("senderUser") : null;
        msgMessageManager.sendSmsByUser(JspHelper.getString(map.get("title"))+JspHelper.getString(map.get("content")), sendUser, receiveUserIds);
    }


    /**
     * 抄送用户发送信息（固定写死的内容）
     *
     * @param bpmTaskInstance 任务实例
     * @throws Exception .
     */
    public void sendJbpmCCMsg(BpmTaskInstance bpmTaskInstance) throws Exception {
        BpmProcessInstance processInstance = bpmTaskInstance.getProcessInstance();
        BpmProcessDefinition processDefinition = processInstance.getProcessDefinition();

        //提交时间
        Timestamp submitTime = new Timestamp(System.currentTimeMillis());
        SysUser senderUser = null;
        BpmFormAction formAction = bpmTaskInstance.getBpmFormAction();
        BpmStandardAction standardAction = bpmTaskInstance.getBpmStandardAction();
        if (formAction != null) {
            senderUser = formAction.getSubmitUser();
        } else if (standardAction != null) {
            senderUser = standardAction.getSubmitUser();
        }

        //抄送人员id
        String ccUserIds = processInstance.getCcUserIds();
//        logger.debug("sendMsgManager```````````````````ccUserIds=" + ccUserIds);
        if (StringUtils.isNotBlank(ccUserIds)) {
            String[] ccUserIdArray = ccUserIds.split(",");

            //抄送标题
            String ccTitle = "";
            if (StringUtils.isNotBlank(processInstance.getCode())) {
                ccTitle += "编号为[" + processInstance.getCode() + "]";
            } else if (StringUtils.isNotBlank(processInstance.getTitle())) {
                ccTitle += "标题为[" + processInstance.getTitle() + "]";
            }
            ccTitle += "的" + processDefinition.getName() + "已经提交！";

            //抄送内容
            String ccContent = DateTimeHelper.formatTimestamp(submitTime, "YYYY-MM-DD HH:MM");
            if (senderUser != null) {
                ccContent = "提交人：" + senderUser.getDisplayName() + " " + ccContent;
            }
            ccContent += " （请到业务流程中的查看列表页面查阅！）";

            msgMessageManager.sendSmsByUser(ccTitle + ccContent, senderUser, ccUserIdArray);
        }
    }

}
