<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
//            {name: "netCode", rule: "validate[required,maxSize[50]]"},
            {name: "bjbh", rule: "validate[required,maxSize[50]]"},
            {name: "bdh", rule: "validate[required,maxSize[50]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //提交表单
        saveAjaxData("${ctx}/netCfb/save.do?fbTypeCode=${fbTypeCode}", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <input type="hidden" id="matterCode" name="matterCode" value="${matterCode}"/>
            <input type="hidden" id="bidMethod" name="bidMethod" value="${bidMethod}"/>
            <%--<tr class="tr_light">--%>
                <%--<td class="form_label">网上受理编号：</td>--%>
                <%--<td class="form_content">--%>
                    <%--<form:input path="netCode" cssClass="input_text"/>--%>
                <%--</td>--%>
            <%--</tr>--%>

            <tr class="tr_dark">
                <td class="form_label">报建编号：</td>
                <td class="form_content">
                    <input type="text" value="${bjbh}" name="bjbh" id="bjbh" class="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">标段编号：</td>
                <td class="form_content">
                    <form:input path="bdh" cssClass="input_text"/>
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