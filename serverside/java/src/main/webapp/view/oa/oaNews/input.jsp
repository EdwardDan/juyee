<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "typeName", rule: "validate[required,maxSize[100]]"},
            {name: "title", rule: "validate[required,maxSize[100]]"},
            {name: "reportPerson", rule: "validate[required,maxSize[25]]"},
            {name: "reportDept", rule: "validate[required,maxSize[50]]"},
            {name: "content", rule: "validate[required,maxSize[2000]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        //提交表单
        saveAjaxData("${ctx}/oaNews/save.do", formId);
    }

</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label">新闻名称：</td>
                <td class="form_content">
                    <form:input path="title" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">发布人：</td>
                <td class="form_content">
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
            <tr class="tr_dark">
                <td class="form_label">发布科室：</td>
                <td class="form_content">
                    <input type="text" name="reportDept" id="reportDept" class="input_text" value="${bean.reportDept}"
                           readonly="true">
                    <input type="hidden" name="reportDeptId" id="reportDeptId"
                           value=""/>
                    <input type="button" value=" " class="button_select"
                           onclick="selectSysDept('reportDeptId','reportDept')"
                           title="点击选择所属单位（部门）">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">主要内容：</td>
                <td class="form_content">
                    <form:textarea path="content" cssClass="input_textarea_long" cssStyle="width: 95% ;height: 195px;"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">是否发布：</td>
                <td class="form_content">
                    <c:choose>
                        <c:when test="${bean.isValid==false}">
                            <form:checkbox path="isValid" id="isValid" value="1"/>
                        </c:when>
                        <c:otherwise>
                            <form:checkbox path="isValid" id="isValid" value="1" checked="checked"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">附件：</td>
                <td class="form_content">
                        ${uploadButton}
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