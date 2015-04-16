<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_header">
            <td class="form_border" width="5%" nowrap>序号</td>
            <td class="form_border" width="10%" nowrap>分包类别</td>
            <td class="form_border" width="30%" nowrap>分包单位</td>
            <td class="form_border" width="10%" nowrap>负责人</td>
            <td class="form_border" width="15%" nowrap>负责人证件</td>
            <td class="form_border" width="15%" nowrap>联系电话</td>
        </tr>
        <c:forEach items="${list}" var="item" varStatus="status">
            <tr
                <c:choose>
                    <c:when test="${status.index % 2==0}">class="tr_light" </c:when>
                    <c:otherwise>class="tr_dark" </c:otherwise>
                </c:choose>>
                <td class="form_border">&nbsp;${status.index+1}</td>
                <td class="form_border" nowrap>&nbsp;${item.cbTypeName}</td>
                <td class="form_border" align="left">&nbsp;${item.cbUnit}</td>
                <td class="form_border" nowrap>&nbsp;${item.proHeader}</td>
                <td class="form_border" nowrap>&nbsp;${item.proHeaderCard}</td>
                <td class="form_border" nowrap>&nbsp;${item.proHeaderPhone}</td>
            </tr>
        </c:forEach>
        <tr class="tr_button">
            <td class="form_td_line" align="center" colspan="6">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>