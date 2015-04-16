<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>

<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="td_light">
            <td width="30%" align="right" nowrap>
                当前审核步骤：
            </td>
            <td nowrap>
                <c:out value="${currentTaskName}"/>
            </td>
        </tr>
        <c:if test="${isShowRead}">
            <tr class="td_dark">
                <td align="right" nowrap>&nbsp;</td>
                <td nowrap>
                    <form:radiobuttons path="isRead" items="${readValues}"/>&nbsp;
                </td>
            </tr>
        </c:if>
        <c:if test="${isShowPermitted}">
            <tr class="td_light">
                <td align="right" nowrap>&nbsp;</td>
                <td colspan="3" nowrap>
                    <form:radiobuttons path="permitValue" items="${permitValues}"/>&nbsp;
                </td>
            </tr>
        </c:if>
        <c:if test="${isShowOpinion}">
            <tr class="td_dark">
                <td align="right" nowrap>意见：</td>
                <td height="100px" nowrap><sys:toHtml>${bean.opinion}</sys:toHtml>&nbsp;</td>
            </tr>
        </c:if>
        <tr>
            <td colspan="2">
                <input name="button_back" type="button" class="button_cancel" value="关闭"
                       onclick="parent.closeWindow()"/>
            </td>
        </tr>
    </table>
</div>