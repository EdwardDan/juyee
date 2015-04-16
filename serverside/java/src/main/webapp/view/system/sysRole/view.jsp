<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">角色编码:</td>
            <td class="form_content">
                ${bean.code}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">角色名称:</td>
            <td class="form_content">
                ${bean.roleName}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">描述:</td>
            <td class="form_content">
                <sys:toHtml>${bean.description}</sys:toHtml>
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">已分配的用户:</td>
            <td class="form_content" style="word-break: break-all;">
                <c:forEach items="${bean.sysUserRoles}" var="item" varStatus="status">
                   <c:if test="${status.index>0}">，</c:if>${item.user.displayName}
                </c:forEach>
                &nbsp;
            </td>
        </tr>
        <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>