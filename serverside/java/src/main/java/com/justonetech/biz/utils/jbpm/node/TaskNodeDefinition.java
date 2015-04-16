package com.justonetech.biz.utils.jbpm.node;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.xml.bind.annotation.*;

/**
 * @version 1.0
 * @author: MaJi
 * @since: 2009-4-21
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "TaskNodeDefinition")
public class TaskNodeDefinition {
    private static final Log log = LogFactory.getLog(TaskNodeDefinition.class);

    //多人排他
    public final static String MULTI_EXCLUSIVE = "1";
    //多人共享
    public final static String MULTI_SHARE = "2";
    //多人会签
    public final static String MULTI_SYNC = "3";

    //无
    public final static String WARNING_NONE = "1";
    //频繁预警
    public final static String WARNING_FREQUENTLY = "2";
    //非频繁预警
    public final static String WARNING_UNFREQUENTLY = "3";

    //继续执行
    public final static String ACTION_CONTINUE = "1";
    //暂停执行
    public final static String ACTION_PAUSE = "2";

    //全局泳道
    public final static String SWIMLANE_TYPE_GLOBAL = "1";
    //流程泳道
    public final static String SWIMLANE_TYPE_PROCESS = "2";
    //任务泳道
    public final static String SWIMLANE_TYPE_TASK = "3";

    //表单操作
    public final static String OPERATION_TYPE_FORM = "1";
    //标准操作
    public final static String OPERATION_TYPE_STANDARD = "2";

    //工作日
    public final static String DAY_TYPE_WORK_DAY = "1";
    //自然日
    public final static String DAY_TYPE_NATURE_DAY = "2";

    //common attribute for taskAction
    //创建任务类型，为上面三者之一
    @XmlAttribute
    String taskCreateType;

    //是否可转发给别人完成
    @XmlAttribute
    boolean canForward;

    //是否可以终止流程
    @XmlAttribute
    boolean canTerminate;

    //预警策略
    @XmlAttribute
    String earlyWarningType;

    //超时处理动作
    @XmlAttribute
    String timeOutAction;

    //默认选择分支
    @XmlAttribute
    String defaultTransitionName;

    //操作类型
    @XmlAttribute
    String operateType;

    //处理时限
    @XmlAttribute
    Integer dateLimit;

    //处理时限
    @XmlAttribute
    String dateType;

    //attribute for standard action
    @XmlAttribute
    boolean showPermitted;

    @XmlAttribute
    boolean showRead;

    @XmlAttribute
    boolean showOpinion;

    @XmlAttribute
    boolean showUpload;

    //attribute for form action
    //表单ID
    @XmlAttribute
    Long formId;
    //初始化脚本
    @XmlAttribute
    String initScript;
    //可输入的区域
    @XmlElement
    String[] privileges;

    //attribue for url action
    @XmlAttribute
    String url;

    //节点是否要选择人员
    @XmlAttribute
    boolean selectUser;


    public String getTaskCreateType() {
        return taskCreateType;
    }

    public void setTaskCreateType(String taskCreateType) {
        this.taskCreateType = taskCreateType;
    }

    public boolean isCanForward() {
        return canForward;
    }

    public void setCanForward(boolean canForward) {
        this.canForward = canForward;
    }

    public boolean isCanTerminate() {
        return canTerminate;
    }

    public void setCanTerminate(boolean canTerminate) {
        this.canTerminate = canTerminate;
    }

    public String getEarlyWarningType() {
        return earlyWarningType;
    }

    public void setEarlyWarningType(String earlyWarningType) {
        this.earlyWarningType = earlyWarningType;
    }

    public String getTimeOutAction() {
        return timeOutAction;
    }

    public void setTimeOutAction(String timeOutAction) {
        this.timeOutAction = timeOutAction;
    }

    public String getDefaultTransitionName() {
        return defaultTransitionName;
    }

    public void setDefaultTransitionName(String defaultTransitionName) {
        this.defaultTransitionName = defaultTransitionName;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public boolean isShowPermitted() {
        return showPermitted;
    }

    public void setShowPermitted(boolean showPermitted) {
        this.showPermitted = showPermitted;
    }

    public boolean isShowRead() {
        return showRead;
    }

    public void setShowRead(boolean showRead) {
        this.showRead = showRead;
    }

    public boolean isShowOpinion() {
        return showOpinion;
    }

    public void setShowOpinion(boolean showOpinion) {
        this.showOpinion = showOpinion;
    }

    public boolean isShowUpload() {
        return showUpload;
    }

    public void setShowUpload(boolean showUpload) {
        this.showUpload = showUpload;
    }

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public String getInitScript() {
        return initScript;
    }

    public void setInitScript(String initScript) {
        this.initScript = initScript;
    }

    public String[] getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String[] privileges) {
        this.privileges = privileges;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getDateLimit() {
        return dateLimit;
    }

    public void setDateLimit(Integer dateLimit) {
        this.dateLimit = dateLimit;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public boolean isSelectUser() {
        return selectUser;
    }

    public void setSelectUser(boolean selectUser) {
        this.selectUser = selectUser;
    }
}
