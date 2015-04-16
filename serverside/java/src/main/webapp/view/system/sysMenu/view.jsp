<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">名称:</td>
            <td class="form_content">
                ${bean.name}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">编码:</td>
            <td class="form_content">
                ${bean.privilege}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">层次:</td>
            <td class="form_content">
                ${bean.menuLevel}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">链接地址:</td>
            <td class="form_content">
                <sys:toHtml>${bean.url}</sys:toHtml>
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">事件:</td>
            <td class="form_content">
                ${bean.jsEvent}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">是否有效:</td>
            <td class="form_content">
                <c:choose><c:when test="${bean.isValid}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">参数:</td>
            <td class="form_content">
                ${bean.param}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">目标窗口:</td>
            <td class="form_content">
                ${bean.target}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">显示图标:</td>
            <td class="form_content">
                <c:if test="${bean.icon != ''}">
                    <img src="${themePath}/index_new/menu_icon/${bean.icon}.png" border="0"/>
                </c:if>
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