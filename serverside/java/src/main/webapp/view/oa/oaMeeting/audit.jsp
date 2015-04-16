<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "status", rule: "validate[required,custom[integer],maxSize[2]"}
        ];
        validateInit(validateCondition, formId);
    });
    //审核通过操作
    function audit() {
        if (!validateForm(formId)) {
            return;
        }
        //提交表单
        if (confirm("审核通过后将不能再修改，确定继续吗？")) {
            saveAjaxData("${ctx}/oaMeeting/audit.do?status=" + ${STATUS_PASS}, formId);
        }

    }
    //退回修改操作
    function reject() {
        if (!validateForm(formId)) {
            return;
        }
        var auditOpinion = $("#auditOpinion").val();
        if (auditOpinion == '') {
            showInfoMsg("审核意见未输入！", null);
            return false;
        }
        //提交表单
        if (confirm("确定要退回修改吗？")) {
            saveAjaxData("${ctx}/oaMeeting/audit.do?status=" + ${STATUS_BACK}, formId);
        }

    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <div class="form_div">
        <fieldset class="form_fieldset" style="width: 90%;margin: 0 auto;display: true;">
            <legend class="form_legend">申请信息</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_light">
                        <td class="form_label">申请会议室：</td>
                        <td class="form_content">&nbsp;${bean.room.name}
                        </td>
                    </tr>
                    <tr class="tr_dark">
                        <td class="form_label">会议召开日期：</td>
                        <td class="form_content">&nbsp;
                            <fmt:formatDate value="${bean.useDate}" pattern="yyyy-MM-dd"/>&nbsp;${bean.useTime}&nbsp;
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label">申请人：</td>
                        <td class="form_content">&nbsp;
                                ${bean.applyPerson}                    </td>
                    </tr>
                    <tr class="tr_dark">
                        <td class="form_label">申请部门名称：</td>
                        <td class="form_content">&nbsp;
                                ${bean.applyDept}                    </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label">预计参与人数：</td>
                        <td class="form_content">&nbsp;
                                ${bean.personNum}                    </td>
                    </tr>
                    <tr class="tr_dark">
                        <td class="form_label">外部人员：</td>
                        <td class="form_content">&nbsp;
                                ${bean.outerPersons}                    </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label">会议主题：</td>
                        <td class="form_content">&nbsp;
                                ${bean.title}                    </td>
                    </tr>
                    <tr class="tr_dark">
                        <td class="form_label">会议内容：</td>
                        <td class="form_content" style="word-break:break-all; word-wrap:break-word;">&nbsp;
                                ${bean.content}                    </td>
                    </tr>
                </table>
        </fieldset>
        <fieldset class="form_fieldset" style="width: 90%;margin: 0 auto;display: true;">
            <legend class="form_legend">审核信息</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label">办公室主任审核意见：</td>
                    <td class="form_content">
                        <form:textarea path="auditOpinion" cssClass="input_textarea_long"/>
                    </td>
                </tr>
                <tr class="tr_button">
                    <td class="form_label"></td>
                    <td class="form_content">
                        <input type="button" value="审核通过" class="button_normal_long" onclick="audit()">&nbsp;
                        <input type="button" value="退回修改" class="button_normal_long" onclick="reject()">&nbsp;
                        <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                    </td>
                </tr>
            </table>
        </fieldset>
    </div>
</form:form>