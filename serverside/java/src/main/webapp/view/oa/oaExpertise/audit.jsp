<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "status", rule: "validate[required,custom[integer],maxSize[2]"}
        ];
        validateInit(validateCondition, formId);
    });
    //保存操作
    function save(status, buttonName) {
        if (!validateForm(formId)) {
            return;
        }
        $('#oaExpertiseUserId').val(getSelectValues(document.getElementById("oaExpertiseUser")));
        if (status == '${STATUS_PASS}') {
            if (confirm("审核通过后将不能再修改，确定继续吗？")) {
                saveAjaxData("${ctx}/oaExpertise/save.do?status=" + status, formId);
            }
        }

        if (status == '${STATUS_BACK}') {
            var auditMemo = $("#auditMemo").val();
            if (auditMemo == '') {
                showInfoMsg("审核意见未输入！", null);
                return false;
            }
            if (confirm("确定要退回修改吗？")) {
                saveAjaxData("${ctx}/oaExpertise/save.do?status=" + status, formId);
            }
        }
    }

</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <div class="form_div">
        <fieldset style="width: 90%;margin:0px auto">
            <legend class="form_legend">学习信息</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label_right">主题：</td>
                    <td class="form_content" colspan="3">
                        <form:input path="title" cssClass="input_text_long" readonly="true"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">学习时间：</td>
                    <td class="form_content">
                        <form:input path="beginDate" id="beginDate" cssClass="input_date" readonly="true"/>
                        <input type="button" class="button_calendar" value=" " onClick="calendar('beginDate');"
                               onchange="getDuration()">
                        ~
                        <form:input path="endDate" cssClass="input_date" readonly="true" onchange="getDuration()"/>
                        <input type="button" class="button_calendar" value=" " onClick="calendar('endDate');">
                    </td>
                    <td class="form_label_right">学习时长：</td>
                    <td class="form_content">
                        <form:input path="duration" cssClass="input_text" readonly="true"/>
                    </td>
                </tr>

                <tr class="tr_light">
                    <td class="form_label_right">责任人：</td>
                    <td class="form_content">
                        <input type="text" name="reportPerson" id="reportPerson" class="input_text"
                               value="${bean.reportPerson}" readonly="true">
                        <input type="hidden" name="reportPersonId" id="reportPersonId"
                               value=""/>
                        <input type="button" value=" " class="button_select"
                               onclick="selectSysPerson('reportPersonId','reportPerson')"
                               title="点击选择提出人">
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">措施与方法：</td>
                    <td class="form_content">
                        <form:input path="method" cssClass="input_text_long" cssStyle="width: 80%" readonly="true"/>
                    </td>

                    <td class="form_label_right">费用：</td>
                    <td class="form_content">
                        <form:input path="fee" cssClass="input_text"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">参加人员：</td>
                    <td class="form_content" colspan="3">
                        <select multiple="multiple" name="oaExpertiseUser" id="oaExpertiseUser"
                                style="width:150px;height:110px;">
                            <c:forEach items="${bean.oaExpertiseUsers}" var="oaExpertiseUser" varStatus="status">
                            <option value="${oaExpertiseUser.user.id}">${oaExpertiseUser.user.displayName}</option>
                            </c:forEach>
                            <select>
                                <input type="hidden" id="oaExpertiseUserId" name="oaExpertiseUserId" value=""/>
                                <input type="hidden" id="oaExpertiseUserName" name="oaExpertiseUserName" value=""/>
                                <input type="button" value="" class="button_select_add"
                                       onclick="multiSelectSysUser('oaExpertiseUser','oaExpertiseUserId','oaExpertiseUserName')"
                                       title="点击添加参加人员"/>
                                <input type="button" value="" class="button_select_remove"
                                       onclick="removeMultiSelectOpt('oaExpertiseUser','oaExpertiseUserId','oaExpertiseUserName')"
                                       title="点击移除参加人员"/>
                    </td>

                </tr>

                <tr class="tr_dark">
                    <td class="form_label_right">学习目标：</td>
                    <td class="form_content" colspan="3">
                        <form:textarea path="studyTarget" cssClass="input_textarea_long" cssStyle="width: 91%"
                                       readonly="true"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">学习内容：</td>
                    <td class="form_content" colspan="3">
                        <form:textarea path="studyContent" cssClass="input_textarea_long" cssStyle="width: 91%"
                                       readonly="true"/>
                    </td>
                </tr>

                <tr class="tr_light">
                    <td class="form_label_right" nowrap>学习附件：</td>
                    <td class="form_content" colspan="3">&nbsp;
                            ${docButton}
                    </td>
                </tr>
            </table>
        </fieldset>
        <fieldset style="width: 90%;margin:0px auto">
            <legend class="form_legend">进行审核</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label_right" style="width: 14%">备注情况：</td>
                    <td class="form_content" colspan="3">
                        <form:textarea path="auditMemo" cssClass="input_textarea_long" cssStyle="width: 91%"/>
                    </td>
                </tr>
                <tr class="tr_button" align="center">
                    <td class="form_border" colspan="4">
                        <input type="button" value="退回修改" class="button_normal_long"
                               onclick="save('${STATUS_BACK}',this.value)">&nbsp;
                        <input type="button" value="审核通过" class="button_normal_long"
                               onclick="save('${STATUS_PASS}',this.value)">&nbsp;
                        <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                    </td>
                </tr>
            </table>
        </fieldset>
    </div>
</form:form>