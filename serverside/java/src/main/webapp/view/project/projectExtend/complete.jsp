<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [  ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        //提交表单
        saveAjaxData("${ctx}/projectExtend/saveCompleteInfo.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">报建编号：</td>
                <td class="form_content">
                    ${bjbh}
                    <input type="hidden" value="${bjbh}" name="bjbh" id="bjbh"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">项目名称：</td>
                <td class="form_content">
                    ${projectName}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">竣工时间：</td>
                <td class="form_content">
                    <input type="text" name="completeDate" id="completeDate" class="input_datetime"
                           value="<fmt:formatDate value="${bean.completeDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                           readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('completeDate','all')">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">备注：</td>
                <td class="form_content">
                     <form:textarea path="description" cssClass="input_textarea"/>
                </td>
            </tr>
        </table>
    </div>
    <div style="height: 30px"></div>
    <div>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_button">
                <td align="center" style="padding-right: 30px">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>