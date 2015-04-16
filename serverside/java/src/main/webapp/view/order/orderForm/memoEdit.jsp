<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "acceptOpinionDesc", rule: "validate[required]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        //提交表单
        saveAjaxData("${ctx}/orderForm/memoEditSave.do", formId);
    }

</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right" width="15%">受理人：</td>
                <td class="form_content" width="35%">
                    &nbsp;${bean.acceptUserName}
                </td>
                <td class="form_label_right" width="15%">受理时间：</td>
                <td class="form_content" width="35%">
                    &nbsp;<fmt:formatDate value="${bean.acceptDatetime}" pattern="yyyy-MM-dd HH:mm"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">监督组：</td>
                <td class="form_content">
                    &nbsp;${bean.workGroup.name}
                </td>
                <td class="form_label_right">监督任务书编号：</td>
                <td class="form_content">
                    &nbsp;${bean.orderForm.jdTaskCode}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">受理意见：</td>
                <td class="form_content" colspan="3">
                    &nbsp;${bean.acceptOpinion.name}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">受理备注：</td>
                <td class="form_content" colspan="3">
                    <form:textarea path="acceptOpinionDesc" cssClass="input_textarea_long"/>
                </td>
            </tr>

            <tr class="tr_button">
                <td class="form_border" colspan="4">
                    <input type="button" value="保存" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>