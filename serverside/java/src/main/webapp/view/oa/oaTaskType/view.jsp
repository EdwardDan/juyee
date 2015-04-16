<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">编码：</td>
            <td class="form_content">&nbsp;
                ${bean.code}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">名称：</td>
            <td class="form_content">&nbsp;
                ${bean.name}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">执行链接：</td>
            <td class="form_content">&nbsp;
                ${bean.url}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">查看链接：</td>
            <td class="form_content">&nbsp;
                ${bean.viewUrl}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">是否流程任务：
            </td>
            <td class="form_content">&nbsp;
                <c:choose><c:when test="${bean.isWorkflow}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">是否有效：</td>
            <td class="form_content">&nbsp;
                <c:choose><c:when test="${bean.isValid}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">任务脚本：</td>
            <td class="form_content">&nbsp;
                ${bean.script}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">内容模板：</td>
            <td class="form_content">&nbsp;
                ${bean.titleTemplate}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">查看权限：</td>
            <td class="form_content">
                <select name="privilege" id="privilege" multiple="5" class="form_multi_select_long">
                    <c:forEach items="${bean.oaTaskTypePrivileges}" var="item">
                        <option value="${item.privilege.id}">${item.privilege.name}</option>
                    </c:forEach>
                </select>
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