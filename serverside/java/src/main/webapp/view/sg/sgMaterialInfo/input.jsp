<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [];
        validateInit(validateCondition, formId);
        var type = $("#type").val();
        checkType(type);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        //提交表单
        saveAjaxData("${ctx}/sgMaterialInfo/save.do", formId);
    }
    function checkType(objValue) {
        if (objValue == 'apply') {
            $("#tr1").hide();
            $("#tr2").hide();
            $("#auditReq").val("");
        } else {
            $("#tr_num").hide();
            $("#tr1").show();
            $("#tr2").show();
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <input type="hidden" name="parent" id="parent" value="${bean.parent.id}"/>
    <input type="hidden" name="projectType" id="projectType" value="${bean.projectType.id}"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label">材料类型：</td>
                <td class="form_content">
                    <select name="type" id="type" class="form_select_long" style="width: 100px;"
                            onchange="checkType(this.value)">
                        <option value="apply">申请材料</option>
                        <option value="submit">提交材料</option>
                    </select>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">序号：</td>
                <td class="form_content">
                    <form:input path="no" cssClass="input_number" cssStyle="width: 100px;"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">材料名称：</td>
                <td class="form_content">
                    <form:textarea path="materialName" cssClass="input_textarea" cssStyle="width: 90%;"/>
                </td>
            </tr>
            <tr class="tr_light" id="tr_num">
                <td class="form_label">应交份数：</td>
                <td class="form_content">
                    <form:input path="yjNum" cssClass="input_number" cssStyle="width: 100px;"/>
                </td>
            </tr>
            <tr class="tr_light" id="tr1">
            <td class="form_label">审核要求：</td>
            <td class="form_content">
                <form:textarea path="auditReq" cssClass="input_textarea" cssStyle="width: 90%;"/>
            </td>
        </tr>
            <tr class="tr_dark" id="tr2">
                <td class="form_label">绿色审核要求：</td>
                <td class="form_content">
                    <form:textarea path="auditReqGreen" cssClass="input_textarea" cssStyle="width: 90%;"/>
                </td>
            </tr>

            <tr class="tr_button">
                <td class="form_content" colspan="2" style="text-align: center;">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>
