<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        confirm
        //提交表单
            if (confirm("确定要复制数据吗？")) {
                saveAjaxData("${ctx}/reportStructure/copySave.do", formId);
            }
    }
</script>
<form:form commandName="bean">
    <table border="0" align="center" cellpadding="0" cellspacing="0">
        <tr class="tr_light">
            <td  class="form_content" style="text-align: center" nowrap>
                将
                <input type="text" value="${sourceName}" name="ver" id="ver" readonly="true"/>
                版本数据复制到
                <input type="text" value="${sourceName}-副本" name="desVer" id="desVer" readonly="true"/>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_content"></td>
        </tr>
        <tr class="tr_button">
            <td class="form_label" colspan="2" style="text-align: center">
                <input type="button" value="准备复制" class="button_normal_long" onclick="save(this)">&nbsp;
                <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</form:form>
