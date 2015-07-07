<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<table cellpadding="0" cellspacing="0" class="form_table">
    <tr class="tr_light">
        <td align="left" nowrap>&nbsp;
            <c:choose>
                <c:when test="${isSum}">
                    项目形象进度汇总表
                </c:when>
                <c:otherwise>
                    &nbsp;共有${bidSize}个标段
                </c:otherwise>
            </c:choose>
            &nbsp;<input type="button" value="导出" class="button_all" onclick="printMonthReport(this)"/>
            &nbsp; <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
        </td>
</table>
<table cellpadding="0" cellspacing="0" border="1" class="table_thin_line">
    <tr class="tr_header">
        <td rowspan="3" width="2%" nowrap>序号</td>
        <td rowspan="3" nowrap>项目名称</td>
        <td rowspan="3" nowrap>起讫地点</td>
        <td rowspan="3" nowrap>标段名称</td>
        <td rowspan="3" nowrap>建设里程</td>
        <td rowspan="3" nowrap>涉及区县</td>
        <td rowspan="3" nowrap>开工日期</td>
        <c:if test="${stepSize>1}"><td rowspan="3" nowrap>上报单位类型</td></c:if>
        <c:forEach items="${firstNodes}" var="firstNode">
            <td colspan="${firstNode.totalChildCount}" <c:if test="${firstNode.totalLevel<3}">rowspan="${firstNode.totalLevel}" </c:if> nowrap>${firstNode.name}</td>
        </c:forEach>
    </tr>
    <tr class="tr_header">
        <c:forEach items="${secondNodes}" var="secondNode">
            <td width="4%" colspan="${fn:length(secondNode.projNodes)}" nowrap>&nbsp;&nbsp;${secondNode.name}&nbsp;&nbsp;</td>
        </c:forEach>
    </tr>
    <tr class="tr_header">
        <c:forEach items="${thirdNodes}" var="thirdNode">
            <td width="4%" nowrap>&nbsp;&nbsp;${thirdNode.name}&nbsp;&nbsp;</td>
        </c:forEach>
    </tr>
    <c:forEach items="${projects}" var="projInfo" varStatus="projIndex">
        <c:forEach items="${projInfo.bids}" var="bid" varStatus="bidIndex">
            <c:set var="stepCount" value="${fn:length(steps)*2}" />
            <c:set var="bidCount" value="${fn:length(projInfo.bids)*stepCount}" />
            <c:forEach items="${steps}" var="step" varStatus="stepIndex">
                <tr class="tr_light">
                    <c:if test="${stepIndex.index == 0}">
                        <c:if test="${bidIndex.index == 0}">
                            <td rowspan="${bidCount}" width="2%" nowrap>${projIndex.index+1}</td>
                            <td rowspan="${bidCount}">${bid.project.name}</td>
                            <td rowspan="${bidCount}">${bid.project.location}</td>
                        </c:if>
                        <td rowspan="${stepCount}">${bid.name}</td>
                        <td rowspan="${stepCount}">${bid.buildMileage}</td>
                        <td rowspan="${stepCount}">${bid.belongAreaNames}</td>
                        <td rowspan="${stepCount}" nowrap>${bid.startDate}</td>
                    </c:if>
                    <c:if test="${stepSize>1}"><td rowspan="2">${step.name}</td></c:if>
                    <c:forEach items="${leafNodes}" var="leafNode">
                        <c:set var="dataKey" value="${bid.id}_${step.id}_${leafNode.id}" />
                        <td>&nbsp;${dataMap[dataKey].content}</td>
                    </c:forEach>
                </tr>
                <tr class="tr_dark">
                    <c:forEach items="${firstNodes}" var="firstNode">
                        <c:set var="dataKey" value="${bid.id}_${step.id}_${firstNode.childFirstLeafId}" />
                        <td colspan="${firstNode.totalChildCount}">&nbsp;${dataMap[dataKey].problem}</td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </c:forEach>
    </c:forEach>
</table>
<table cellpadding="0" cellspacing="0" border="0" class="form_div">
    <tr class="tr_button">
        <td class="form_border" align="center">
            <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
        </td>
    </tr>
</table>