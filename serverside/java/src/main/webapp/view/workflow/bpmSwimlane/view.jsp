<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="no_scrollbar">
<div class="form_div">
    <table cellpadding="1" cellspacing="1" class="form_table">
        <tr class="tr_light">
            <td class="form_label">泳道名称：</td>
            <td class="form_content">&nbsp;
                ${bean.name}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">项目组类型：</td>
            <td class="form_content">
                ${bean.swimlaneDefinition.group.name}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">项目组岗位类型：</td>
            <td class="form_content">
                ${bean.swimlaneDefinition.positionType.name}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">表达式：</td>
            <td class="form_content">
                <sys:toHtml>${bean.swimlaneDefinition.expression}</sys:toHtml>
            </td>
        </tr>
        <tr class="tr_header">
            <td width="20%">序号：</td>
            <td width="80%">引用本泳道的流程定义</td>
        </tr>
        <c:forEach var="swimlane" items="${swimlanes}"
                   varStatus="status"><c:choose>
            <c:when test="${status.count%2==0}">
                <tr class="tr_light" align="center">
            </c:when>
            <c:otherwise>
                <tr class="tr_dark" align="center">
            </c:otherwise></c:choose>
            <td width="10%">${status.count}</td>
            <td width="90%">${swimlane.name}</td>
            </tr>
        </c:forEach>

        <tr class="tr_button">
            <td class="form_border" colspan="2" align="center">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>
</div>