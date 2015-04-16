<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [

            {name: "bjbh", rule: "validate[required,maxSize[100]"},
            {name: "projectName", rule: "validate[required,maxSize[200]"},
            {name: "jsLinkman", rule: "validate[required,maxSize[100]"},
            {name: "jsPhone",rule:"validate[maxSize[30],custom[phone]"},
            {name: "sgzbPhone",rule:"validate[maxSize[30],custom[phone]"},
            {name: "kcPhone",rule:"validate[maxSize[30],custom[phone]"},
            {name: "sjPhone",rule:"validate[maxSize[30],custom[phone]"},
            {name: "jlPhone",rule:"validate[maxSize[30],custom[phone]"},
            {name: "sgPhone",rule:"validate[maxSize[30],custom[phone]"}
        ];
        validateInit(validateCondition, formId);
    });
    //保存成功后切换到单位工程tab页面
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        var reportType = $("#reportType").val();
        if (reportType == '') {
            showInfoMsg("请选择项目类型", null);
            return false;
        }

        $("#jdDatetime").val($("#jdDatetime").val()+" 00:00:000");
        saveAjaxData("${ctx}/excelJdTasks/modifyTaskSave.do", formId);
    }
</script>

<form:form commandName="bean">
<form:hidden path="id"/>
<div class="form_div">
<table cellpadding="0" cellspacing="0" class="form_table">
    <tr class="tr_dark">
        <td class="form_label_right">
            报监日期：
        </td>
        <td class="form_content">
            <input type="text" name="jdDatetime" id="jdDatetime" class="input_date"
                   value="<fmt:formatDate value="${bean.jdDatetime}" pattern="yyyy-MM-dd"/>" readonly="true"/>
            <input type="button" class="button_calendar" value=" "
                   onClick="calendar('jdDatetime');">
        </td>
        <td class="form_content" colspan="2">
            &nbsp;
        </td>
    </tr>
    <tr class="tr_light">
        <td class="form_label_right" width="15%">
            监督任务书编号：
        </td>
        <td class="form_content" width="35%">
            <form:input path="jdTaskCode" cssClass="input_text_long" readonly="true"/>
        </td>
        <td class="form_label_right" width="15%">项目类型：</td>
        <td class="form_content" width="35%">
            <sys:code code="${EXCEL_JDTASK_OTHER1.code}" name="reportType" type="select"
                      defaultName="${bean.reportType}"
                      id="reportType" isSaveName="true"
                      isAlowedNull="true"
                      onChange=""/>
        </td>
    </tr>
    <tr class="tr_dark">
        <td class="form_label_right">
            报建编号：
        </td>
        <td class="form_content">
            <form:input path="bjbh" cssClass="input_text_long" readonly="true"/>
        </td>
        <td class="form_label_right">
            标段号：
        </td>
        <td class="form_content">
            <form:input path="bid" cssClass="input_text_long"/>
        </td>
    </tr>
    <tr class="tr_light">
        <td class="form_label_right">
            项目名称：
        </td>
        <td class="form_content" colspan="3">
            <form:input path="projectName" cssClass="input_text_long"/>
        </td>
    </tr>
    <tr class="tr_dark">
        <td class="form_label_right">
            工程地点：
        </td>
        <td class="form_content" colspan="3">
            <form:input path="projectAdd" cssClass="input_text_long"/>
        </td>
    </tr>
    <tr class="tr_light">
        <td class="form_label_right">
            所在县区：
        </td>
        <td class="form_content">
            <form:input path="belongArea" cssClass="input_text_long"/>
        </td>
        <td class="form_label_right">
            合同价：
        </td>
        <td class="form_content">
            <form:input path="contMoney" cssClass="input_text_long"/>&nbsp;(万元)
        </td>
    </tr>
    <tr class="tr_dark">
        <td class="form_label_right">
            建安工作量：
        </td>
        <td class="form_content" nowrap>
            <form:input path="jagzl" cssClass="input_text_long"/>&nbsp;(万元)
        </td>
        <td class="form_label_right">
            面积：
        </td>
        <td class="form_content">
            <form:input path="buildArea" cssClass="input_text_long"/>&nbsp;(㎡)
        </td>
    </tr>
    <tr class="tr_light">
        <td class="form_label_right">
            单体数量：
        </td>
        <td class="form_content" colspan="3">
            <form:input path="dtsl" cssClass="input_text_long"/>&nbsp;(个)
        </td>
    </tr>
    <tr class="tr_dark">
        <td class="form_label_right">建设单位：</td>
        <td class="form_content" colspan="3">
            <form:input path="jsUnitName" cssClass="input_text_long"/>
        </td>
    </tr>
    <tr class="tr_light">
        <td class="form_label_right">建设单位地址：</td>
        <td class="form_content">
            <form:input path="jsUnitAdd" cssClass="input_text_long"/>
        </td>
        <td class="form_label_right">邮政编码：</td>
        <td class="form_content">
            <form:input path="zipcode" cssClass="input_text_long"/>
        </td>
    </tr>
    <tr class="tr_dark">
        <td class="form_label_right">联系人：</td>
        <td class="form_content">
            <form:input path="jsLinkman" cssClass="input_text_long"/>
        </td>
        <td class="form_label_right">联系电话：</td>
        <td class="form_content">
            <form:input path="jsPhone" cssClass="input_text_long"/>
        </td>
    </tr>
</table>

<table cellpadding="0" cellspacing="0" class="form_table">
    <tr class="tr_header">
        <td colspan="6">参建单位</td>
    </tr>

    <tr class="tr_dark">
        <td class="form_label_right" width="20%" nowrap>施工总包单位：</td>
        <td class="form_content" width="15%">
            <form:input path="sgzbUnitName" cssClass="input_text_long"/>
        </td>
        <td class="form_label_right" width="15%" nowrap>联系人：</td>
        <td class="form_content" width="15%">
            <form:input path="sgzbLinkman" cssClass="input_text_long"/>
        </td>
        <td class="form_label_right" width="20%" nowrap>联系电话：</td>
        <td class="form_content" width="15%">
            <form:input path="sgzbPhone" cssClass="input_text_long"/>
        </td>
    </tr>
    <tr class="tr_light">
        <td class="form_label_right">勘察单位：</td>
        <td class="form_content">
            <form:input path="kcUnitName" cssClass="input_text_long"/>
        </td>
        <td class="form_label_right">联系人：</td>
        <td class="form_content">
            <form:input path="kcLinkman" cssClass="input_text_long"/>
        </td>
        <td class="form_label_right">联系电话：</td>
        <td class="form_content">
            <form:input path="kcPhone" cssClass="input_text_long"/>
        </td>
    </tr>
    <tr class="tr_dark">
        <td class="form_label_right">设计单位：</td>
        <td class="form_content">
            <form:input path="sjUnitName" cssClass="input_text_long"/>
        </td>
        <td class="form_label_right">联系人：</td>
        <td class="form_content">
            <form:input path="sjLinkman" cssClass="input_text_long"/>
        </td>
        <td class="form_label_right">联系电话：</td>
        <td class="form_content">
            <form:input path="sjPhone" cssClass="input_text_long"/>
        </td>
    </tr>
    <tr class="tr_light">
        <td class="form_label_right">监理单位：</td>
        <td class="form_content">
            <form:input path="jlUnitName" cssClass="input_text_long"/>
        </td>
        <td class="form_label_right">联系人：</td>
        <td class="form_content">
            <form:input path="jlLinkman" cssClass="input_text_long"/>
        </td>
        <td class="form_label_right">联系电话：</td>
        <td class="form_content">
            <form:input path="jlPhone" cssClass="input_text_long"/>
        </td>
    </tr>
    <tr class="tr_dark">
        <td class="form_label_right">施工单位：</td>
        <td class="form_content">
            <form:input path="sgUnitName" cssClass="input_text_long"/>
        </td>
        <td class="form_label_right">联系人：</td>
        <td class="form_content">
            <form:input path="sgLinkman" cssClass="input_text_long"/>
        </td>
        <td class="form_label_right">联系电话：</td>
        <td class="form_content">
            <form:input path="sgPhone" cssClass="input_text_long"/>
        </td>
    </tr>
</table>
<table cellpadding="0" cellspacing="0" class="form_table">
    <tr class="tr_button">
        <td class="form_td_line" colspan="4">
            <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
            <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
        </td>
    </tr>
</table>
</div>
</form:form>