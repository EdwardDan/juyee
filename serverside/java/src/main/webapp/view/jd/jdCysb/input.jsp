<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "bjbh", rule: "validate[required,maxSize[30]]"},
            {name: "reportTypeDesc", rule: "validate[required,maxSize[30]]"},
            {name: "projectAddress", rule: "validate[required,maxSize[200]]"},
            {name: "buildArea", rule: "validate[required,custom[number],maxSize[9]"},
            {name: "structureType", rule: "validate[required,maxSize[100]]"},
            {name: "structureLevel", rule: "validate[required,maxSize[100]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(status, btn) {
        if (!validateForm(formId)) {
            return;
        }

        //提交表单
        if ("${STATUS_SUBMIT}" == status) {
            if (confirm("提交之后将不能再修改，确定继续吗？")) {
                $("#status").val(status);
                saveAjaxData("${ctx}/jdCysb/save.do", formId);
            }
        } else {
            $("#status").val(status);
            saveAjaxData("${ctx}/jdCysb/save.do", formId);
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="status"/>
    <form:hidden path="bjbh"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label_right" width="20%">报建编号：</td>
                <td class="form_content" colspan="3">
                        ${bean.bjbh}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" width="20%">工程名称：</td>
                <td class="form_content" colspan="3">
                        ${projectName}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" width="20%">工程地址：</td>
                <td class="form_content" colspan="3">
                    <form:input path="projectAddress" cssClass="input_text" cssStyle="width: 350px"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" width="20%">申报类型：</td>
                <td class="form_content">
                    <sys:code code="${reportType}" name="reportType" id="reportType" type="select"
                              sysCodeDetailId="${bean.reportType.id}"/>
                </td>
                <td class="form_label_right" width="20%">建筑面积：</td>
                <td class="form_content">
                    <form:input path="buildArea" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" width="20%">结构类型：</td>
                <td class="form_content">
                    <form:input path="structureType" cssClass="input_text"/>
                </td>

                <td class="form_label_right" width="20%">结构层次：</td>
                <td class="form_content">
                    <form:input path="structureLevel" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" width="20%">附件：</td>
                <td class="form_content" colspan="3">
                        ${uploadButton}
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_border" align="center" colspan="4">
                    <input type="button" value="提交" class="button_confirm"
                           onclick="save('${STATUS_SUBMIT}',this)">&nbsp;
                    <input type="button" value="暂存" class="button_confirm"
                           onclick="save('${STATUS_EDIT}',this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>