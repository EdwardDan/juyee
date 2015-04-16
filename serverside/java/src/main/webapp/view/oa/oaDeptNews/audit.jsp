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
    //保存操作
    function save(status, buttonName) {
        if (!validateForm(formId)) {
            return;
        }

        //提交表单
        if (status == '${STATUS_PASS}') {
            if (confirm("审核通过后将不能再修改，确定继续吗？")) {
                saveAjaxData("${ctx}/oaDeptNews/save.do?status=" + status, formId);
            }
        }
        if (status == '${STATUS_BACK}') {
            var officeOpinion = $("#officeOpinion").val();
            if (officeOpinion == '') {
                showInfoMsg("审核意见未输入！", null);
                return false;
            }
            if (confirm("确定要退回修改吗？")) {
                saveAjaxData("${ctx}/oaDeptNews/save.do?status=" + status, formId);
            }
        }
    }

</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <div class="form_div">
        <fieldset style="width: 90%;margin:0px auto">
            <legend class="form_legend">新闻信息</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label_right">新闻主题：</td>
                    <td class="form_content" colspan="3">
                        <form:input path="title" cssClass="input_text_long" readonly="true"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">提交人：</td>
                    <td class="form_content" colspan="3">
                        <input type="text" name="reportPerson" id="reportPerson" class="input_text_long"
                               value="${bean.reportPerson}" readonly="true">
                        <input type="hidden" name="reportPersonId" id="reportPersonId"
                               value=""/>
                        <input type="button" value=" " class="button_select"
                               onclick="selectSysPerson('reportPersonId','reportPerson')"
                               title="点击选择提出人">
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">提交部门：</td>
                    <td class="form_content" colspan="3">
                        <input type="text" name="reportDept" id="reportDept" class="input_text_long"
                               value="${bean.reportDept}" readonly="true">
                        <input type="hidden" name="reportDeptId" id="reportDeptId"
                               value=""/>
                        <input type="button" value=" " class="button_select"
                               onclick="selectSysDept('reportDeptId','reportDept')"
                               title="点击选择提交部门">
                    </td>
                </tr>
                    <%--<tr class="tr_dark">--%>
                    <%--<td class="form_label">主要内容(预留)：</td>--%>
                    <%--<td class="form_content">--%>
                    <%--<form:input path="content" cssClass="input_text"/>--%>
                    <%--</td>--%>
                    <%--</tr>--%>

                <tr class="tr_light">
                    <td class="form_label_right">附件：</td>
                    <td class="form_content" colspan="3">
                            ${docButton}
                    </td>
                </tr>

            </table>
        </fieldset>
        <fieldset style="width: 90%;margin:0px auto">
            <legend class="form_legend">进行审核</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label_right" style="width: 18%">审核意见：</td>
                    <td class="form_content">
                        <form:textarea path="officeOpinion" cssClass="input_textarea_long"/>
                    </td>
                <tr class="tr_button" align="center">
                    <td class="form_border" colspan="4">

                        <input type="button" value="退回修改" class="button_normal_long"
                               onclick="save('${STATUS_BACK}',this.value)">&nbsp;
                        <input type="button" value="审核通过" class="button_normal_long"
                               onclick="save('${STATUS_PASS}',this.value)">&nbsp;
                        <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                    </td>
                </tr>
            </table>
        </fieldset>
    </div>
</form:form>