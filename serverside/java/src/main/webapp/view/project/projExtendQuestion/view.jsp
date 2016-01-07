<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" border="1" class="table_thin_line"
           style="text-align: center;width: 98%;" id="table1">
        <tr class="tr_header">
            <td style="width: 20%;">时间</td>
            <td
                    <c:if test="${qdType==dutyType}">style="width:45%;" </c:if>
                    <c:if test="${qdType==questionType}">style="width:75%;"</c:if>>
                问题描述
            </td>
            <c:if test="${qdType==dutyType}">
                <td style="width:30%;">责任部门</td>
            </c:if>
        </tr>

        <c:forEach items="${bean.projExtendQuestions}" var="item" varStatus="status">
            <input type="hidden" name="questionId" value="${item.id}">
            <tr class="tr_light">
                <td>${item.year}年${item.month}月</td>
                <c:if test="${qdType==dutyType}">
                    <td style="text-align: left;">${item.question}</td>
                </c:if>
                <c:if test="${qdType==questionType}">
                    <td>${item.question}</td>
                </c:if>
                <c:if test="${qdType==dutyType}">
                    <td>${item.deptName}</td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="div_space"></div>
<div class="form_content" style="text-align: center;">
    <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
</div>
