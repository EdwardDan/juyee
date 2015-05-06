<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "name", rule: "validate[required,maxSize[50]]"},
            {name: "linkAddress", rule: "validate[maxSize[100]]"},
            {name: "zipcode", rule: "validate[maxSize[6]]"},
            {name: "tel", rule: "validate[custom[integer],maxSize[15]"}
            //{name:"isLeaf", rule:"validate[required]"},
            //{name:"treeId", rule:"validate[required]"}
        ];
        validateInit(validateCondition, formId);
    });

    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        disableBtn(btn);
        saveAjaxData("${ctx}/projRelateDept/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="parent" value="${bean.parent.id}"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right">单位名称&nbsp;</td>
                <td class="form_content">
                    <form:input path="name" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">单位简称&nbsp;</td>
                <td class="form_content">
                    <form:input path="shortName" cssClass="input_text"/>
                </td>
                <td class="form_label_right">单位负责人&nbsp;</td>
                <td class="form_content">
                    <form:input path="manager" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">通讯地址&nbsp;</td>
                <td class="form_content">
                    <form:input path="linkAddress" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">公司邮编&nbsp;</td>
                <td class="form_content">
                    <form:input path="zipcode" cssClass="input_text"/>
                </td>
                <td class="form_label_right">公司电话&nbsp;</td>
                <td class="form_content">
                    <form:input path="tel" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">传真&nbsp;</td>
                <td class="form_content">
                    <form:input path="fax" cssClass="input_text"/>
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