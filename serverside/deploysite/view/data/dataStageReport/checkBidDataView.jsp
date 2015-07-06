<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<table cellpadding="0" cellspacing="0" border="1" class="table_thin_line" style="width: 100%;">
    <tr class="tr_header">
        <td rowspan="2" colspan="2">推进阶段</td>
        <c:forEach items="${steps}" var="step">
            <c:if test="${step.isValid}">
                <td colspan="2">${step.name}</td>
            </c:if>
        </c:forEach>
    </tr>
    <tr class="tr_header">
        <c:forEach items="${steps}" var="step">
            <c:if test="${step.isValid}">
                <td>推进步骤</td>
                <td>推进结果</td>
            </c:if>
        </c:forEach>
    </tr>
    <c:forEach items="${projStages}" var="stageFirst" varStatus="first">
        <c:if test="${fn:length(stageFirst.projStages)>0}">
            <c:forEach items="${stageFirst.projStages}" var="stageSecond" varStatus="senond">
                <tr class="tr_dark">
                    <c:if test="${senond.index==0}">
                        <td rowspan="${fn:length(stageFirst.projStages)}" nowrap>${stageFirst.name}</td>
                    </c:if>
                    <td nowrap>&nbsp;${stageSecond.name}&nbsp;</td>
                    <c:forEach items="${steps}" var="step">
                        <c:if test="${step.isValid}">
                            <c:set var="dataKey" value="${bidId}_${step.id}_${stageSecond.id}"/>
                            <td>${dataMap[dataKey].resultName}</td>
                            <td><sys:toHtml>${dataMap[dataKey].dealDate}</sys:toHtml></td>
                        </c:if>
                    </c:forEach>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${fn:length(stageFirst.projStages)==0 && null==stageFirst.parent}">
            <tr class="tr_dark">
                <td colspan="2">${stageFirst.name}</td>
                <c:forEach items="${steps}" var="step">
                    <c:if test="${step.isValid}">
                        <c:set var="dataKey" value="${bidId}_${step.id}_${stageFirst.id}"/>
                        <td>${dataMap[dataKey].resultName}</td>
                        <td><sys:toHtml>${dataMap[dataKey].dealDate}</sys:toHtml></td>
                    </c:if>
                </c:forEach>
            </tr>
        </c:if>
    </c:forEach>
</table>
