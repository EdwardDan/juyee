<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function doViewRole(id){
    openNewWindow("ViewRole","查看角色", "${ctx}/sysRole/view.do?id=" + id, false);
    }
</script>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">权限编码:</td>
            <td class="form_content">
                ${bean.code}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">权限名称:</td>
            <td class="form_content">
                ${bean.name}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">权限类型:</td>
            <td class="form_content">
                ${bean.type.name}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">TAG:</td>
            <td class="form_content">
                ${bean.tag}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">页面地址:</td>
            <td class="form_content">
                ${bean.url}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">定义:</td>
            <td class="form_content">
                <sys:toHtml>${bean.definition}</sys:toHtml>
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
        <tr class="tr_dark">
            <td class="form_label">已分配的角色:</td>
            <td class="form_content" style="word-break: break-all;">
                <c:forEach items="${roles}" var="item" varStatus="status">
                    <c:if test="${status.index>0}">，</c:if><a href="#" onclick="doViewRole('${item.role.id}')"><font color="blue">${item.role.roleName}</font></a>
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