<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"code", rule:"validate[required,maxSize[50]]"},
            {name:"name", rule:"validate[required,maxSize[300]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //提交表单
        saveAjaxData("${ctx}/projBid/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="typeCode"/>
    <input type="hidden" name="projInfoId" value="${bean.project.id}">

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right"  style="width: 20%">标段编号：</td>
                <td class="form_content" style="width: 30%">
                    <form:input path="code" cssClass="input_text"/>
                </td>
                <td class="form_label_right"style="width: 20%">标段名称：</td>
                <td class="form_content" style="width: 30%">
                    <form:input path="name" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right"style="width: 20%">建设里程：</td>
                <td class="form_content" >
                    <form:input path="buildMileage" cssClass="input_text"/>
                </td>
                <td class="form_label_right"style="width: 20%">开工日期：</td>
                <td class="form_content"  style="width: 30%">
                    <form:input path="startDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('startDate');">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right"style="width: 20%">涉及区（县）：</td>
                <td class="form_content"  style="width: 30%" colspan="3">
                    <sys:checkbox  name="ProjBelongArea" code="ProjBelongArea" checkedNames="${areas}" inputType="checkbox" isSaveName="false" showType="edit" colNum="9"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right"style="width: 20%">项目联系人：</td>
                <td class="form_content"  style="width: 30%">
                    <form:input path="projLink" cssClass="input_text"/>
                </td>
                <td class="form_label_right"style="width: 20%">联系电话：</td>
                <td class="form_content"  style="width: 30%">
                    <form:input path="linkTel" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_content" colspan="4" style="text-align: center">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>