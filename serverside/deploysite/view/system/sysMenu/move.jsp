<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function save(btn) {
        var formId = "bean";
        //提交保存
        saveAjaxData("${ctx}/sysMenu/moveSave.do", formId);
        loadAjaxData("treeLeft", "${ctx}/sysMenu/tree.do");
    }
</script>
<form:form commandName="bean">
    <input type="hidden" id="id" name="id" value="${bean.id}"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">菜单名称:</td>
                <td class="form_content">
                        ${bean.name}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">移动菜单至:</td>
                <td class="form_content">
                    <select id="parentid" name="parentid">
                        <option value="">根节点</option>
                        <c:forEach items="${menuList}" var="menu">
                            <option value="${menu.id}">&nbsp;&nbsp;${menu.name}</option>
                        </c:forEach>
                    </select>
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
