<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            //{name:"flowCode", rule:"validate[required,maxSize[10]]"},
            //{name:"bjbh", rule:"validate[required,maxSize[50]]"},
            //{name:"bdh", rule:"validate[required,maxSize[50]]"},
            //{name:"buildUnitName", rule:"validate[required,maxSize[100]]"},
            //{name:"sgUnitName", rule:"validate[required,maxSize[100]]"},
            //{name:"gdName", rule:"validate[required,maxSize[100]]"},
            //{name:"planEndTime", rule:"validate[required,maxSize[16]]"},
            //{name:"planActTime", rule:"validate[required,maxSize[16]]"},
            //{name:"createTime", rule:"validate[required,maxSize[16]]"},
            //{name:"updateTime", rule:"validate[required,maxSize[16]]"},
            //{name:"createUser", rule:"validate[required,maxSize[100]]"},
            //{name:"updateUser", rule:"validate[required,maxSize[100]]"},
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        saveAjaxData("${ctx}/planDetail/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">流转编号：</td>
                <td class="form_content">
                    <form:input path="flowCode" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">报建编号：</td>
                <td class="form_content">
                    <form:input path="bjbh" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">标段号：</td>
                <td class="form_content">
                    <form:input path="bdh" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">建设单位：</td>
                <td class="form_content">
                    <form:input path="buildUnitName" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">施工单位：</td>
                <td class="form_content">
                    <form:input path="sgUnitName" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">工地名称：</td>
                <td class="form_content">
                    <form:input path="gdName" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">计划完成日期：</td>
                <td class="form_content">
                    <input type="text" name="planEndTime" id="planEndTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.planEndTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('planEndTime','all')">

                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">实际完成日期：</td>
                <td class="form_content">
                    <input type="text" name="planActTime" id="planActTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.planActTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('planActTime','all')">

                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">创建时间：</td>
                <td class="form_content">
                    <input type="text" name="createTime" id="createTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('createTime','all')">

                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">更新时间：</td>
                <td class="form_content">
                    <input type="text" name="updateTime" id="updateTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('updateTime','all')">

                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">创建人：</td>
                <td class="form_content">
                    <form:input path="createUser" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">更新人：</td>
                <td class="form_content">
                    <form:input path="updateUser" cssClass="input_text"/>
                </td>
            </tr>

            <tr class="tr_button">
                <td class="form_label"></td>
                <td class="form_content">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>