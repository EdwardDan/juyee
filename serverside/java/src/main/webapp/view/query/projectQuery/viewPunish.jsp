<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_header">
            <td class="form_border" width="5%" nowrap>序号</td>
            <td class="form_border" width="15%" nowrap>当事人</td>
            <td class="form_border" width="20% nowrap">违法行为</td>
            <td class="form_border" width="15%" nowrap>违反条款</td>
            <td class="form_border" width="15%" nowrap>处罚依据</td>
            <td class="form_border" width="8%" nowrap>执法主体</td>
            <td class="form_border" width="8%" nowrap>处罚时间</td>
        </tr>
        <c:forEach items="${list}" var="item" varStatus="status">
            <tr class="tr_light">
                <td class="form_border">&nbsp;${status.index+1}</td>
                <td class="form_border">&nbsp;${item.unitName}<c:if test="${item.personName != null}">(${item.personName})</c:if></td>
                <td class="form_border">&nbsp;${item.breakLawContent}</td>
                <td class="form_border">&nbsp;${item.breakLawRules}</td>
                <td class="form_border">&nbsp;${item.punishLawRules}</td>
                <td class="form_border">&nbsp;${item.exeUnitName}</td>
                <td class="form_border">&nbsp;<fmt:formatDate value="${item.zxCompleteTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            </tr>
        </c:forEach>
        <tr class="tr_button">
            <td class="form_td_line" colspan="7">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>