<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //提交表单
        saveAjaxData("${ctx}/netProperty/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label" colspan="2">&nbsp;</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">是否政府投资或重大推进项目：</td>
                <td class="form_content">
                    <select name='isImportant' id='isImportant' style="width: 200px">
                        <option value="false" <c:if test="${!bean.isImportant}">selected</c:if>>否</option>
                        <option value="true"<c:if test="${bean.isImportant}">selected</c:if>>是</option>
                    </select>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_content" colspan="2" style="text-align: center">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>