<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        var validateCondition = [
            {name: "applyDept", rule: "validate[required,maxSize[100]]"},
            {name: "applyPerson", rule: "validate[required,maxSize[50]]"},
            {name: "useDate", rule: "validate[required,custom[date],maxSize[10]"},
            {name: "useTime", rule: "validate[required,maxSize[20]]"},
            {name: "personNum", rule: "validate[custom[integer],maxSize[4]"},
            {name: "outerPersons", rule: "validate[maxSize[200]]"},
            {name: "title", rule: "validate[required,maxSize[200]]"},
            {name: "status", rule: "validate[required,custom[integer],maxSize[2]"}
        ];
        validateInit(validateCondition, formId);
        <c:if test="${empty bean.id}">
        checkDate();
        </c:if>
    });

    //保存操作
    function save(status, buttonName) {
        if (!validateForm(formId)) {
            return;
        }

        //提交表单
        if (buttonName != "") {
            if (confirm("是否确定执行 " + buttonName + " 操作？")) {
                saveAjaxData("${ctx}/oaMeeting/save.do?status=" + status, formId);
            }
        } else {
            saveAjaxData("${ctx}/oaMeeting/save.do?status=" + status, formId);
        }
    }
    //先检查日期是否已经申请
    function checkDate() {
        var useDate = $("#useDate").val();
        var useTime = encodeURI($("#useTime").val());
        loadAjaxDataCallback(null, "${ctx}/oaMeeting/checkDate.do?useDate=" + useDate + "&useTime=" + useTime, backCheckDate);
    }
    function backCheckDate(ret) {
        var obj = eval("(" + ret + ")");
        if (obj.success == true) {
            showInfoMsg("当前日期已经申请，请重新选择！");
            return;
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">申请会议室：</td>
                <td class="form_content">
                    <sys:code code="OaMeetingRoom" name="room" type="select" defaultName=""
                              sysCodeDetailId="${bean.room.id}" disabled="" id="room" isAlowedNull="false"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">会议召开时间：</td>
                <td class="form_content">
                    <form:input path="useDate" cssClass="input_date" readonly="true" onchange="checkDate();"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('useDate');">&nbsp;&nbsp;
                    <form:select path="useTime" cssClass="select_normal" onchange="checkDate()">
                        <form:option value="上午"/>
                        <form:option value="下午"/>
                    </form:select>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">申请人：</td>
                <td class="form_content">
                    <form:input path="applyPerson" cssClass="input_text"/>
                    <input name="person" id="person" value="" type="hidden">
                    <input class="button_select" onclick="selectSysPerson('person','applyPerson');" title="点击选择申请人员"
                           type="button">
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">申请部门名称：</td>
                <td class="form_content">
                    <form:input path="applyDept" cssClass="input_text"/>
                    <input name="sysDeptId" id="sysDeptId" value="" type="hidden">
                    <input class="button_select" onclick="selectSysDept('sysDeptId','applyDept')" title="点击选择申请部门"
                           type="button">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">预计参与人数：</td>
                <td class="form_content">
                    <form:input path="personNum" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" width="20%">内部人员：</td>
                <td class="form_content">
                    <select multiple="multiple" id="innerPerson" name="innerPerson"
                            style="width:250px;height:60px;">
                        <c:forEach items="${innerPersons}" var="innerPerson">
                            <option value="${innerPerson.id}">${innerPerson.name}</option>
                        </c:forEach>
                    </select>
                    <input type="button" value=" " class="button_select_add"
                           onclick="multiSelectSysPerson('innerPerson','innerPersons','innerPersonNames')"
                           title="点击选择内部接收人">
                    <input type="button" value=" " class="button_select_remove"
                           onclick="removeMultiSelectOpt('innerPerson','innerPersons','innerPersonNames')"
                           title="点击移除内部接收人">
                    <input type="hidden" id="innerPersons" name="innerPersons" value="${bean.innerPersons}">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">外部人员：</td>
                <td class="form_content">
                    <form:input path="outerPersons" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">会议主题：</td>
                <td class="form_content">
                    <form:input path="title" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">会议内容：</td>
                <td class="form_content">
                    <form:textarea path="content" cssClass="input_textarea_long" cssStyle="height: 130px"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">附件：</td>
                <td class="form_content">
                        ${uploadButton}
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_label"></td>
                <td class="form_content">
                    <input type="button" value="提交" class="button_confirm"
                           onclick="save('${STATUS_SUBMIT}',this.value)">&nbsp;
                    <input type="button" value="暂存" class="button_confirm" onclick="save('${STATUS_EDIT}','')">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>