<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<table cellpadding="0" cellspacing="0" class="form_table">
    <tr class="tr_light">
        <td align="left" nowrap>&nbsp;
            <c:choose>
                <c:when test="${isSum}">
                    年度项目办证推进表
                </c:when>
                <c:otherwise>
                    共有${fn:length(bids)}个标段
                </c:otherwise>
            </c:choose>
            &nbsp; <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
        </td>
</table>
<table cellpadding="0" cellspacing="0" border="1" class="table_thin_line">
    <tr class="tr_header">
        <td rowspan="2" width="2%" nowrap>序号</td>
        <td rowspan="2" nowrap>项目名称</td>
        <td rowspan="2" nowrap>起讫地点</td>
        <td rowspan="2" nowrap>标段名称</td>
        <td rowspan="2" nowrap>建设里程</td>
        <td rowspan="2" nowrap>涉及区县</td>
        <td rowspan="2" nowrap>开工日期</td>
        <td rowspan="2" nowrap>上报单位类型</td>
        <c:forEach items="${firstStages}" var="firstStage">
            <td colspan="${fn:length(firstStage.projStages)}" <c:if test="${fn:length(firstStage.projStages)<1}">rowspan="2" </c:if> nowrap>${firstStage.name}</td>
        </c:forEach>
    </tr>
    <tr class="tr_header">
        <c:forEach items="${secondStages}" var="secondStage">
            <td width="4%" nowrap>&nbsp;&nbsp;${secondStage.name}&nbsp;&nbsp;</td>
        </c:forEach>
    </tr>
    <c:forEach items="${bids}" var="bid" varStatus="bidIndex">
        <c:set var="stepCount" value="${fn:length(steps)*2}" />
        <c:forEach items="${steps}" var="step" varStatus="stepIndex">
            <tr class="tr_light">
                <c:if test="${stepIndex.index == 0}">
                    <td rowspan="${stepCount}" width="2%">${bidIndex.index+1}</td>
                    <td rowspan="${stepCount}">${bid.project.name}</td>
                    <td rowspan="${stepCount}">${bid.project.location}</td>
                    <td rowspan="${stepCount}">${bid.name}</td>
                    <td rowspan="${stepCount}">${bid.buildMileage}</td>
                    <td rowspan="${stepCount}">${bid.belongArea.name}</td>
                    <td rowspan="${stepCount}">${bid.startDate}</td>
                </c:if>
                <td rowspan="2">${step.name}</td>
                <c:forEach items="${leafStages}" var="leafStage">
                    <c:set var="dataKey" value="${bid.id}_${step.id}_${leafStage.id}" />
                    <td nowrap class="td_normal" title="${dataMap[dataKey].resultName}"><span <c:if test="${dataMap[dataKey].resultName!=lastMap[dataKey].resultName}">class="td_change"</c:if>>${dataMap[dataKey].resultName}</span></td>
                </c:forEach>
            </tr>
            <tr class="tr_dark">
                <c:forEach items="${leafStages}" var="leafStage">
                    <c:set var="dataKey" value="${bid.id}_${step.id}_${leafStage.id}" />
                    <td nowrap class="td_normal" title="${dataMap[dataKey].dealDate}"><span <c:if test="${dataMap[dataKey].dealDate!=lastMap[dataKey].dealDate}">class="td_change"</c:if>><sys:cutString length="10">${dataMap[dataKey].dealDate}</sys:cutString></span></td>
                </c:forEach>
            </tr>
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