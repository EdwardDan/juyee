<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {

    });

    //保存操作
    function save(status, btn) {
        if (!validateForm(formId)) {
            return;
        }

        if ("${STATUS_BACK}" == status) {
            var auditOpinion = $("#auditOpinion").val();
            if (auditOpinion == '') {
                showInfoMsg("请输入退回意见！");
                return;
            }
        }

        //提交表单
        if ("${STATUS_PASS}" == status) {
            if (confirm("审核通过之后将不能再修改，确定继续吗？")) {
                $("#status").val(status);
                saveAjaxData("${ctx}/jdCysb/auditSave.do", formId);
            }
        } else {
            $("#status").val(status);
            saveAjaxData("${ctx}/jdCysb/auditSave.do", formId);
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="status"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr>
                <td>
                    <fieldset class="form_fieldset" style="width: 90%;margin: 0 auto;display: true;">
                        <legend class="form_legend">申报信息</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td class="form_label_right" width="20%">工程名称：</td>
                                <td class="form_content" colspan="3">
                                        ${projectName}
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right" width="20%">工程地址：</td>
                                <td class="form_content" colspan="3">
                                        ${bean.projectAddress}
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" width="20%">申报类型：</td>
                                <td class="form_content" width="30%">
                                        ${bean.reportTypeDesc}
                                </td>
                                <td class="form_label_right" width="20%">建筑面积：</td>
                                <td class="form_content" width="30%">
                                        ${bean.buildArea}
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right" width="20%">结构类型：</td>
                                <td class="form_content" width="30%">
                                        ${bean.structureType}
                                </td>

                                <td class="form_label_right" width="20%">结构层次：</td>
                                <td class="form_content" width="30%">
                                        ${bean.structureLevel}
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" width="20%">&nbsp;附件：</td>
                                <td class="form_content" colspan="3">${uploadButton}</td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>
            <tr><td colspan="2" class="form_fieldset_space">&nbsp;</td></tr>
            <tr>
                <td>
                    <fieldset class="form_fieldset" style="width: 90%;margin: 0 auto;display: true;">
                        <legend class="form_legend">审核信息</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_dark">
                                <td class="form_label_right" width="21%">质量科领导审核意见：</td>
                                <td class="form_content">
                                    <form:textarea path="auditOpinion" cssClass="input_textarea" cssStyle="width:100%"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_border">
                    <input type="button" value="审核通过" class="button_normal_long"
                           onclick="save('${STATUS_PASS}',this)">&nbsp;
                    <input type="button" value="退回修改" class="button_normal_long"
                           onclick="save('${STATUS_BACK}',this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>