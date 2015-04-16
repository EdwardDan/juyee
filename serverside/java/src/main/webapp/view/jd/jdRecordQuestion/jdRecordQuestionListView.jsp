<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="div_space"></div>
<table cellpadding="0" cellspacing="0" class="form_table" id="${questionTypeCode}"
       style="border-color: #004444">

    <tr class="tr_header" align="center">
        <td class="form_td_line" nowrap style="width: 330px">问题</td>
        <td class="form_td_line" nowrap style="width: 150px">违反条约</td>
        <td class="form_td_line" nowrap style="width: 80px">监督员</td>
    </tr>

    <c:forEach items="${jdRecordQItem}" var="item" varStatus="statusNo">
        <tr class="tr_dark">
            <td class="form_td_line" align="left">&nbsp;${item.questionDesc}</td>
            <td class="form_td_line" align="left">&nbsp;${item.unlawDesc}</td>
            <td class="form_td_line" align="left">&nbsp;${item.jdPersonDesc}</td>
        </tr>
    </c:forEach>
</table>
