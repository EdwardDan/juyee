<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"title", rule:"validate[required,maxSize[200]]"},
            {name:"reportPerson", rule:"validate[required,maxSize[50]]"},
            {name:"reportDept", rule:"validate[required,maxSize[100]]"},
            {name:"content", rule:"validate[required,maxSize[2000]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        saveAjaxData("${ctx}/oaKnowledge/save.do", formId);
    }
</script>
<style type="text/css">
    .input_textarea_long_hight {
        font-size: 12px;
        border: 1px solid #b8b6b9;
        color: #007DBC;
        background-color: #FFFFFF;
        width: 500px;
        height: 200px;
    }
</style>
<form:form commandName="bean">
    <input type="hidden" id="id" name="id" value="${bean.id}"/>
    <input type="hidden" id="refId" name="refId" value="${refId}"/>
    <div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">

        <tr class="tr_light">
            <td class="form_label">回复人：</td>
            <td class="form_content">
                <form:input path="reportPerson" cssClass="input_text" readonly="true"/>
                <%--<input type="text" name="reportPerson" id="reportPerson" class="input_text_long" value="${bean.reportPerson}"--%>
                       <%--readonly="true">--%>
                <%--<input type="hidden" name="reportPersonId" id="reportPersonId"--%>
                       <%--value=""/>--%>
                <%--<input type="button" value=" " class="button_select"--%>
                       <%--onclick="selectSysPerson('reportPersonId','reportPerson')"--%>
                       <%--title="点击选择提出人">--%>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">回复部门：</td>
            <td class="form_content">
                <%--<input type="text" name="reportDept" id="reportDept" class="input_text_long" value="${bean.reportDept}"--%>
                       <%--readonly="true">--%>
                <%--<input type="hidden" name="reportDeptId" id="reportDeptId"--%>
                       <%--value=""/>--%>
                <%--<input type="button" value=" " class="button_select"--%>
                       <%--onclick="selectSysDept('reportDeptId','reportDept')"--%>
                       <%--title="点击选择所属单位（部门）">--%>
                <form:input path="reportDept" cssClass="input_text" readonly="true"/>
            </td>
        </tr>

        <tr class="tr_light">
            <td class="form_label">内容：</td>
            <td class="form_content" colspan="3">
                <form:textarea path="content" cssClass="input_textarea_long_hight" cssStyle="width: 90%"/>
            </td>
        </tr>

        <tr class="tr_light">
            <td class="form_label" nowrap>附件：</td>
            <td colspan="3" class="form_content">&nbsp;
                    ${uploadButton}
            </td>
        </tr>

        <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="保存" class="button_confirm" onclick="save(this)">&nbsp;
                <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</form:form>
</div>
