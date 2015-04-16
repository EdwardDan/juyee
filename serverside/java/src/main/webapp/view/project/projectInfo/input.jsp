<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            //{name:"buildCode", rule:"validate[required,maxSize[10]]"},
            //{name:"buildDatetime", rule:"validate[required,maxSize[16]]"},
            //{name:"buildName", rule:"validate[required,maxSize[300]]"},
            //{name:"buildDept", rule:"validate[required,maxSize[100]]"},
            //{name:"buildDeptProperty", rule:"validate[required,maxSize[100]]"},
            //{name:"buildDeptAddress", rule:"validate[required,maxSize[60]]"},
            //{name:"buildDeptPhone", rule:"validate[required,maxSize[40]]"},
            //{name:"buildDeptLegal", rule:"validate[required,maxSize[20]]"},
            //{name:"buildDeptLinkman", rule:"validate[required,maxSize[20]]"},
            //{name:"buildDeptZipcode", rule:"validate[required,maxSize[6]]"},
            //{name:"buildDeptRegCapital", rule:"validate[required,custom[number],max[10]"},
            //{name:"buildAddress", rule:"validate[required,maxSize[100]]"},
            //{name:"buildProperty", rule:"validate[required,maxSize[100]]"},
            //{name:"buildScope", rule:"validate[required,maxSize[200]]"},
            //{name:"buildArea", rule:"validate[required,custom[number],max[10]"},
            //{name:"buildStartDate", rule:"validate[required,custom[date],max[10]"},
            //{name:"totalInvest", rule:"validate[required,custom[number],max[10]"},
            //{name:"projectType", rule:"validate[required,maxSize[100]]"},
            //{name:"belongArea", rule:"validate[required,maxSize[100]]"},
            //{name:"proDesc", rule:"validate[required,maxSize[${prop.length}]]"},
            //{name:"createTime", rule:"validate[required,maxSize[16]]"},
            //{name:"updateTime", rule:"validate[required,maxSize[16]]"},
            //{name:"createUser", rule:"validate[required,maxSize[100]]"},
            //{name:"updateUser", rule:"validate[required,maxSize[100]]"},
            //{name:"proSchedule", rule:"validate[required,maxSize[100]]"},
            //{name:"proAttention", rule:"validate[required,maxSize[100]]"},
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //加入其他业务判断
//        if ($('#name').val() == '') {
//            showInfoMsg('请输入姓名！',null);
//            return;
//        }

        //提交表单
        saveAjaxData("${ctx}/projectInfo/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <form:input path="buildCode" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <input type="text" name="buildDatetime" id="buildDatetime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.buildDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('buildDatetime','all')">

                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <form:input path="buildName" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <form:input path="buildDept" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <form:input path="buildDeptProperty" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <form:input path="buildDeptAddress" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <form:input path="buildDeptPhone" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <form:input path="buildDeptLegal" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <form:input path="buildDeptLinkman" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <form:input path="buildDeptZipcode" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <form:input path="buildDeptRegCapital" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <form:input path="buildAddress" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <form:input path="buildProperty" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <form:input path="buildScope" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <form:input path="buildArea" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <form:input path="buildStartDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('buildStartDate');">

                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <form:input path="totalInvest" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <form:input path="projectType" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <form:input path="belongArea" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <form:input path="proDesc" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <input type="text" name="createTime" id="createTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('createTime','all')">

                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <input type="text" name="updateTime" id="updateTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('updateTime','all')">

                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <form:input path="createUser" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <form:input path="updateUser" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <form:input path="proSchedule" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">${prop.get("columnName")}：</td>
                <td class="form_content">
                    <form:input path="proAttention" cssClass="input_text"/>
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