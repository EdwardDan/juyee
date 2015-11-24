package com.justonetech.biz.manager;

import com.justonetech.core.utils.FormatUtils;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 任务处理（待办事项）
 * User: Chen Junping
 * Date: 12-4-5
 */
@Service
public class OaTaskManager {
    private Logger logger = LoggerFactory.getLogger(OaTaskManager.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private OaTaskService oaTaskService;

    @Autowired
    private OaTaskDealService oaTaskDealService;

    @Autowired
    private OaTaskTypeService oaTaskTypeService;

    @Autowired
    private OaTaskTypePrivilegeService oaTaskTypePrivilegeService;

    @Autowired
    private OaTaskLogService oaTaskLogService;

    @Autowired
    private OaTaskDealLogService oaTaskDealLogService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private MsgMessageManager msgMessageManager;

    //任务类型
    private Map<String, Long> taskTypeIdMap = null;

    /**
     * 初始化任务类型
     *
     * @param reload 重新加载
     * @return .
     */
    private synchronized Map<String, Long> initTaskType(Boolean reload) {
        if (taskTypeIdMap == null || reload) {
            taskTypeIdMap = new HashMap<String, Long>();
            String hql = "from OaTaskType t where isValid={0}";
            List<OaTaskType> taskTypes = oaTaskTypeService.findByQuery(FormatUtils.format(hql, Constants.FLAG_TRUE));
            for (OaTaskType taskType : taskTypes) {
                taskTypeIdMap.put(taskType.getCode(), taskType.getId());
            }
        }
        return taskTypeIdMap;
    }

    /**
     * 重新刷新任务类型缓存
     */
    public void reloadTaskType() {
        initTaskType(true);
    }

    public OaTaskType getTaskType(String taskTypeCode) {
        initTaskType(false);
        Long sysTaskTypeId = taskTypeIdMap.get(taskTypeCode);
        if (sysTaskTypeId != null) {
            return oaTaskTypeService.get(sysTaskTypeId);
        }
        return null;
    }

    //创建任务
    public void createTask(String taskTypeCode, Long referId, String title, Set<Long> userIds) throws Exception {
        createTask(taskTypeCode, referId, title, userIds, true, Constants.OA_PRIORITY_NORMAL, Constants.OA_AUDIT_METHOD_SHARE);
    }

    /**
     * 创建任务
     *
     * @param taskTypeCode .
     * @param referId      .
     * @param title        .
     * @param userIds      .
     * @param isSendSms    是否发送短信
     * @param priority     .
     * @param auditMethod  .
     * @throws Exception .
     */
    public void createTask(String taskTypeCode, Long referId, String title, Set<Long> userIds, Boolean isSendSms, String priority, String auditMethod) throws Exception {
        SysUser sysUser = sysUserManager.getSysUser();
        OaTaskType taskType = getTaskType(taskTypeCode);
        if (taskType != null) {
            //删除原来的任务
            removeTask(taskTypeCode, referId);

            //创建新任务
            if (userIds.size() > 0) {
                OaTask sysTask = new OaTask();
                sysTask.setReferId(referId);
                sysTask.setType(taskType);
                sysTask.setTitle(title);
                sysTask.setCreateTime(new Timestamp(System.currentTimeMillis()));
                sysTask.setCreateUser(sysUser);
                sysTask.setPriority(priority != null ? priority : Constants.OA_PRIORITY_NORMAL);
                sysTask.setAuditMethod(auditMethod != null ? priority : Constants.OA_AUDIT_METHOD_SHARE);
                oaTaskService.save(sysTask);
                System.out.println("..........create task complete,ID is " + sysTask.getId());

                //创建明细
                createFlowTaskDetail(sysTask, userIds);

                //发送消息
                if (isSendSms) {
                    String[] ids = new String[userIds.size()];
                    int i = 0;
                    for (Long userId : userIds) {
                        ids[i] = String.valueOf(userId);
                        i++;
                    }

                    String content = " 提交人：系统";
                    if (sysUser != null) {
                        content = " 提交人：" + sysUser.getDisplayName();
                    }
                    msgMessageManager.sendSmsByUser(title + content, sysUser, ids);
                }
            }
        }
    }

    /**
     * 创建任务明细
     *
     * @param sysTask .
     * @param userIds .
     * @throws Exception .
     */
    private void createFlowTaskDetail(OaTask sysTask, Set<Long> userIds) throws Exception {
        for (Long userId : userIds) {
            OaTaskDeal sysTaskDeal = new OaTaskDeal();
            sysTaskDeal.setTask(sysTask);
            sysTaskDeal.setUser(sysUserService.get(userId));
            sysTaskDeal.setStatus(Constants.OA_TASK_NOTREAD);//系统任务状态--未读
            oaTaskDealService.save(sysTaskDeal);
        }
    }

    /**
     * 删除任务
     *
     * @param taskTypeCode .
     * @param referId      .
     */
    public void removeTask(String taskTypeCode, Long referId) {
        OaTaskType taskType = getTaskType(taskTypeCode);
        if (taskType != null) {
            OaTask task = getTask(taskType, referId);
            if (task != null) {

                //复制到log表
                copyToLog(task);

                //删除任务
                Set<OaTaskDeal> sysTaskDeals = task.getOaTaskDeals();
                for (OaTaskDeal sysTaskDeal : sysTaskDeals) {
                    oaTaskDealService.delete(sysTaskDeal);
                }
                oaTaskService.delete(task);
            }
        }
    }

    /**
     * 将任务记录复制到日志表中用于以后查询历史操作
     *
     * @param task .
     */
    private void copyToLog(OaTask task) {
        Boolean isAccept = false;
        Set<OaTaskDeal> sysTaskDeals = task.getOaTaskDeals();
        for (OaTaskDeal sysTaskDeal : sysTaskDeals) {
            if (sysTaskDeal.getAcceptTime() != null) {
                isAccept = true;
                break;
            }
        }

        //todo 需要设置接收状态，否则不复制到日志表中
//        if (isAccept) {
        OaTaskLog taskLog = getOaTaskLog(task);
        if (taskLog == null) taskLog = new OaTaskLog();
        taskLog.setType(task.getType());
        taskLog.setReferId(task.getReferId());
        taskLog.setTitle(task.getTitle());
        taskLog.setAuditMethod(task.getAuditMethod());
        taskLog.setPriority(task.getPriority());
        taskLog.setOpDatetime(new Timestamp(System.currentTimeMillis()));
        taskLog.setCreateTime(task.getCreateTime());
        taskLog.setCreateUser(task.getCreateUser());
        oaTaskLogService.save(taskLog);

        for (OaTaskDeal taskDeal : sysTaskDeals) {
            //todo 暂做增量处理，保留每次审核操作的痕迹
//                OaTaskDealLog log = getOaTaskDealLog(taskLog,taskDeal);
//                if(log == null) log = new OaTaskDealLog();;
            OaTaskDealLog log = new OaTaskDealLog();
            log.setTask(taskLog);
            log.setUser(taskDeal.getUser());
//                log.setStatus(taskDeal.getStatus());
            log.setStatus(Constants.OA_TASK_ACCEPT);
            log.setAcceptTime(taskDeal.getAcceptTime());
            log.setOpDatetime(new Timestamp(System.currentTimeMillis()));
            oaTaskDealLogService.save(log);
        }
//        }
    }

    private OaTaskLog getOaTaskLog(OaTask task) {
        String hql = "from OaTaskLog where type.id={0} and referId={1}";
        List<OaTaskLog> list = oaTaskLogService.findByQuery(FormatUtils.format(hql, task.getType().getId(), task.getReferId()));
        if (list.size() > 0) {
            return list.iterator().next();
        }
        return null;
    }

    private OaTaskDealLog getOaTaskDealLog(OaTaskLog taskLog, OaTaskDeal taskDeal) {
        String hql = "from OaTaskDealLog where task.id={0} and user.id={1} and status='{2}'";
        List<OaTaskDealLog> list = oaTaskDealLogService.findByQuery(FormatUtils.format(hql, String.valueOf(taskLog.getId()), String.valueOf(taskDeal.getUser().getId()), taskDeal.getStatus()));
        if (list.size() > 0) {
            return list.iterator().next();
        }
        return null;
    }

    /**
     * 获取任务对象
     *
     * @param sysTaskType .
     * @param referId     .
     * @return .
     */
    public OaTask getTask(OaTaskType sysTaskType, Long referId) {
        if (sysTaskType != null) {
            Set<OaTask> sysTasks = sysTaskType.getOaTasks();
            if (null != sysTasks && sysTasks.size() > 0) {
                for (OaTask sysTask : sysTasks) {
                    Long referIdOld = sysTask.getReferId();
                    if (null != referIdOld && referIdOld.equals(referId)) {
                        return sysTask;
                    }
                }
            }
        }
        return null;
    }

//    /**
//     * 获取用户任务列表
//     *
//     * @param userId .
//     * @return .
//     */
//    public List<OaTask> getTaskList(Long userId) {
//        String hql = "select t.task from OaTaskDeal t where t.user.id={0} and status<>'{1}' order by t.task.id desc";
//        return oaTaskService.findByQuery(FormatUtils.format(hql,String.valueOf(userId),Constants.OA_TASK_DELETE));
//    }

    /**
     * 获取用户任务列表
     *
     * @param userId .
     * @return .
     */
    public List<OaTaskDeal> getTaskDealList(Long userId) {
        String hql = "from OaTaskDeal t where t.user.id={0} and status='{1}' order by t.task.id desc";
        return oaTaskDealService.findByQuery(FormatUtils.format(hql, String.valueOf(userId), Constants.OA_TASK_NOTREAD));
    }

    /**
     * 获取任务状态
     *
     * @param status .
     * @return .
     */
    public String getStatusName(String status) {
        if (Constants.OA_TASK_NOTREAD.equals(status)) {
            return "<font color=red>未读</font>";
        } else if (Constants.OA_TASK_READ.equals(status)) {
            return "<font color=blue>已读</font>";
        } else if (Constants.OA_TASK_ACCEPT.equals(status)) {
            return "<font color=green>已处理</font>";
        } else if (Constants.OA_TASK_DELETE.equals(status)) {
            return "已删除";
        }
        return "";
    }

    /**
     * 获取内容替换属性
     *
     * @param object   .
     * @param taskCode .
     * @return .
     */
    public String getTaskTitle(Object object, String taskCode) {
        String msg = "";
        OaTaskType taskType = getTaskType(taskCode);
        if (taskType != null) {
            String template = taskType.getTitleTemplate();
            if (!StringHelper.isEmpty(template)) {
                Pattern p = Pattern.compile("\\{[[a-z][A-Z]]+\\}");
                Set<String> set = new TreeSet<String>();
                findTaskTitleTag(template, p, set);
                for (String s : set) {
                    String substring = s.substring(s.lastIndexOf("{"), s.lastIndexOf("}"));
                    String substring1 = substring.substring(1, substring.length());
                    try {
                        String msg1 = "{" + substring1 + "}";
                        Object method = getInvokeMethod(object, substring1);
                        template = template.replace(msg1, JspHelper.getString(method));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    msg = template;
                }
            }
        }
        return msg;
    }

    /**
     * 找到替换的标签
     *
     * @param input 。
     * @param p     。
     * @param set   。
     */
    private void findTaskTitleTag(String input, Pattern p, Set<String> set) {
        if (!StringHelper.isEmpty(input)) {
            int l = input.length();
            String output;
            for (int j = l; j >= 0; j--) {
                Matcher m = p.matcher(input.substring(0, j));
                while (m.find()) {
                    int n = m.groupCount();
                    for (int i = 0; i <= n; i++) {
                        output = m.group(i);
                        if (output != null) {
                            set.add(output);
                        }
                    }
                }
            }
        }
    }

    /**
     * 根据对象和属性名获取值
     *
     * @param owner      .
     * @param methodName .
     * @return .
     * @throws Exception .
     */
    private Object getInvokeMethod(Object owner, String methodName) throws Exception {
        Class ownerClass = owner.getClass();
        methodName = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
        Method method = null;
        try {
            method = ownerClass.getMethod("get" + methodName);
        } catch (NoSuchMethodException e) {
            return "error";
        }
        return method.invoke(owner);
    }

}
