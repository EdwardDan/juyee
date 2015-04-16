<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "reportPerson", rule: "validate[required,maxSize[25]]"},
            {name: "reportDept", rule: "validate[required,maxSize[50]]"},
            {name: "reportDate", rule: "validate[required,custom[date],maxSize[20]"},
            {name: "durationTime", rule: "validate[required,maxSize[50]]"},
            {name: "cause", rule: "validate[required,maxSize[1000]"}
            <c:if test="${bean.status == STATUS_SUBMIT_LEADER}">
            ,{name: "leaderAuditTime", rule: "validate[required,maxSize[20]]"}
            </c:if>
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    //保存操作
    function save(status, buttonName) {
        if (!validateForm(formId)) {
            return;
        }

        if (buttonName == "审核通过") {
            if (confirm("审核通过后将不能再修改，确定继续吗？")) {
                saveAjaxData("${ctx}/oaLeaveApply/auditSave.do?status=" + status, formId, doRefreshIframGrid);
            }
        }
        else if (buttonName == "退回修改") {
            var leaderOpinion = $("#leaderOpinion").val();
            var leaderAuditTime = $("#leaderAuditTime").val();
            //若审核通过则不需填写审核意见
            if (leaderAuditTime == '') {
                if (officeOpinion == '') {
                    showInfoMsg("审核意见不为空！");
                    return;
                }
            } else if (leaderOpinion == '') {
                showInfoMsg("审核意见不为空！");
                return;
            }
            if (confirm("确定要退回修改吗？")) {
                saveAjaxData("${ctx}/oaLeaveApply/auditSave.do?status=" + status, formId, doRefreshIframGrid);
            }
        }
        else {
            saveAjaxData("${ctx}/oaLeaveApply/auditSave.do?status=" + status, formId);
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="isSendSms"/>
    <form:hidden path="smsTimearea"/>
    <form:hidden path="smsContent"/>
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr>
                <td>
                    <fieldset class="form_fieldset" style="width: 90%;margin: 0 auto;display: true;">
                        <legend class="form_legend">请假申请</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_dark">
                                <td class="form_label_right" width="20%">申请部门：</td>
                                <td class="form_content" width="30%">
                                    <input type="text" name="reportDept" id="reportDept" class="input_text"
                                           value="${bean.reportDept}"
                                           readonly="true">
                                    <input type="hidden" name="reportDeptId" id="reportDeptId"
                                           value=""/>
                                    <input type="button" value=" " class="button_select"
                                           onclick="selectSysDept('reportDeptId','reportDept')"
                                           title="点击选择所属单位（部门）">
                                </td>
                                <td class="form_label_right" width="20%">申请人：</td>
                                <td class="form_content" width="30%">
                                    <input type="text" name="reportPerson" id="reportPerson" class="input_text"
                                           value="${bean.reportPerson}"
                                           readonly="true">
                                    <input type="hidden" name="reportPersonId" id="reportPersonId"
                                           value=""/>
                                    <input type="button" value=" " class="button_select"
                                           onclick="selectSysPerson('reportPersonId','reportPerson')"
                                           title="点击选择发布人">
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" width="20%">岗位：</td>
                                <td class="form_content" width="30%">
                                    <form:input path="duty" cssClass="input_text"/>
                                </td>
                                <td class="form_label_right" width="20%">申请时间：</td>
                                <td class="form_content" width="30%">
                                    <form:input path="reportDate" cssClass="input_date" readonly="true"/>
                                    <input type="button" class="button_calendar" value=" "
                                           onClick="calendar('reportDate');">
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right" width="20%">请假起始时间：</td>
                                <td class="form_content">
                                    <form:input path="durationTime" cssClass="input_text"/>
                                </td>
                                <td class="form_label_right">请假天数：</td>
                                <td class="form_content">
                                    <form:input path="dayCount" cssClass="input text"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" width="20%"><span style="color: red;">通知食堂</span>：</td>
                                <td class="form_content" colspan="3">
                                    <c:if test="${bean.isSendSms}"><input type="checkbox" checked disabled></c:if><c:if test="${!bean.isSendSms}"><input type="checkbox" disabled></c:if> 短信内容：${bean.smsContent}
                                </td>
                            </tr>

                            <tr class="tr_light">
                                <td class="form_label_right" width="20%">请假事由：</td>
                                <td class="form_content" colspan="3">
                                    <form:textarea path="cause" cssClass="input_textarea_long"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>
            <tr>
                <td>
                    <fieldset class="form_fieldset" style="width: 90%;margin: 0 auto;display: true;">
                        <legend class="form_legend">领导审核</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_dark">
                                <td class="form_label_right" width="20%">审核意见：</td>
                                <td class="form_content">
                                    <form:textarea path="leaderOpinion" cssClass="input_textarea_long"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">审核时间：</td>
                                <td class="form_content">
                                    <input type="text" name="leaderAuditTime" id="leaderAuditTime"
                                           class="input_datetime"
                                           value="<fmt:formatDate value="${bean.leaderAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                                           readonly="true"/>
                                    <input type="button" class="button_calendar" value=" "
                                           onClick="calendar('leaderAuditTime','all')">

                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_border" align="center" colspan="4">
                    <c:choose>
                        <c:when test="${bean.status == STATUS_SUBMIT}">
                            <input type="button" value="审核通过" class="button_normal_long"
                                   onclick="save('${STATUS_PASS}',this.value)">&nbsp;
                            <input type="button" value="退回修改" class="button_normal_long"
                                   onclick="save('${STATUS_BACK_LEADER}',this.value)">&nbsp;
                        </c:when>
                    </c:choose>
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>