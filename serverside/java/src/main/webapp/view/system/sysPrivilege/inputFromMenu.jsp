<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        multiSelectMenu('menuSelect','menuIds','menuNames',save);
    });

    //保存操作
    function save() {
        var btn = "";
        var v = getSelectValues(document.getElementById("menuSelect"));
        if(v != ""){
            document.getElementById("menuIds").value = v;
            saveAjaxData("${ctx}/sysPrivilege/addFromMenuSave.do", formId, null);
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="parent" value="${bean.parent.id}"/>
    <form:hidden path="platform"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light" style="display: none">
                <td class="form_label">选择菜单:</td>
                <td class="form_content">
                    <select name="menuSelect" id="menuSelect" multiple="multiple"></select>
                    <input type="text" name="menuIds" id="menuIds" value="">
                    <input type="text" name="menuNames" id="menuNames" value="">
                </td>
            </tr>
            <tr class="tr_light" id="btnShow">
                <td class="form_content" align="center">
                    <input type="button" value="选择" class="button_all" onclick="multiSelectMenu('menuSelect','menuIds','menuNames',save)">
                </td>
            </tr>
        </table>
    </div>
</form:form>