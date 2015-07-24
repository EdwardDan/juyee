<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<table cellpadding="0" cellspacing="0" class="form_table">
    <tr class="tr_light">
        <td align="left" nowrap>&nbsp;
            <c:choose>
                <c:when test="${isSum}">
                    ${year}年度项目办证推进表
                </c:when>
                <c:otherwise>
                    共有${bidSize}个标段
                </c:otherwise>
            </c:choose>
            &nbsp;<input type="button" value="导出" class="button_all" onclick="selectStage(this)"/>
            &nbsp; <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
        </td>
</table>
<table cellpadding="0" cellspacing="0" border="1" class="table_thin_line">
    <tr class="tr_header">
        <td rowspan="2" width="2%" nowrap>序号</td>
        <td rowspan="2" nowrap>&nbsp;&nbsp;项目名称&nbsp;&nbsp;</td>
        <td rowspan="2" nowrap>起讫地点</td>
        <td rowspan="2" nowrap>&nbsp;&nbsp;标段名称&nbsp;&nbsp;</td>
        <td rowspan="2" nowrap>建设里程</td>
        <td rowspan="2" nowrap>涉及区县</td>
        <td rowspan="2" nowrap>&nbsp;&nbsp;开工日期&nbsp;&nbsp;</td>
        <c:if test="${stepSize>1}"><td rowspan="2" nowrap>上报单位类型</td></c:if>
        <c:forEach items="${firstStages}" var="firstStage">
            <td colspan="${fn:length(firstStage.projStages)}" <c:if test="${fn:length(firstStage.projStages)<1}">rowspan="2" </c:if> style="width: 90px;" nowrap>${firstStage.name}</td>
        </c:forEach>
    </tr>
    <tr class="tr_header">
        <c:forEach items="${secondStages}" var="secondStage">
            <td width="4%" nowrap>&nbsp;&nbsp;${secondStage.name}&nbsp;&nbsp;</td>
        </c:forEach>
    </tr>
    <c:forEach items="${projects}" var="projInfo" varStatus="projIndex">
    <c:forEach items="${projInfo.bids}" var="bid" varStatus="bidIndex">
        <c:set var="stepCount" value="${fn:length(steps)*1}" />
        <c:set var="bidCount" value="${fn:length(projInfo.bids)}" />
        <c:forEach items="${steps}" var="step" varStatus="stepIndex">
            <tr class="tr_light">
                <c:if test="${stepIndex.index == 0}">
                    <c:if test="${bidIndex.index == 0}">
                        <td rowspan="${bidCount}" width="2%">${projIndex.index+1}</td>
                        <td rowspan="${bidCount}">${bid.project.name}</td>
                        <td rowspan="${bidCount}">${bid.project.location}</td>
                    </c:if>
                    <td rowspan="${stepCount}">${bid.name}</td>
                    <td rowspan="${stepCount}">${bid.buildMileage}</td>
                    <td rowspan="${stepCount}">${bid.belongAreaNames}</td>
                    <td rowspan="${stepCount}" nowrap>${bid.startDate}</td>
                </c:if>
                <c:if test="${stepSize>1}"><td>${step.name}</td></c:if>
                <c:forEach items="${leafStages}" var="leafStage">
                    <c:set var="dataKey" value="${bid.id}_${step.id}_${leafStage.id}" />
                    <td class="td_normal" title="${dataMap[dataKey].resultName}" <c:if test="${not empty dataMap[dataKey].color}">style="background-color: ${dataMap[dataKey].color}"</c:if>>${dataMap[dataKey].resultName}</td>
                </c:forEach>
            </tr>
            <%--<tr class="tr_dark">--%>
                <%--<c:forEach items="${leafStages}" var="leafStage">--%>
                    <%--<c:set var="dataKey" value="${bid.id}_${step.id}_${leafStage.id}" />--%>
                    <%--<td nowrap class="td_normal" title="${dataMap[dataKey].dealDate}"><span <c:if test="${dataMap[dataKey].dealDate!=lastMap[dataKey].dealDate}">class="td_change"</c:if>><sys:cutString length="10">${dataMap[dataKey].dealDate}</sys:cutString></span></td>--%>
                <%--</c:forEach>--%>
            <%--</tr>--%>
        </c:forEach>
        </c:forEach>
    </c:forEach>
</table>
<table cellpadding="0" cellspacing="0" border="0" class="form_div">
    <tr class="tr_light">
        <td class="form_border" align="left">
            <div style="padding-left: 50px;">
                <div>图示说明：</div>
                <li><div class="td_note" style="background-color: yellow"></div><div class="td_note_font">计划办理（显示计划办理时间，如果时间在当前天之后则不显示底色，反之显示黄色）</div></li>
                <li><div class="td_note" style="background-color: lightskyblue"></div><div class="td_note_font">办理中（显示“办理中”）</div></li>
                <li><div class="td_note" style="background-color: green"></div><div class="td_note_font">办理完成（显示“√”）</div></li>
                <li><div class="td_note" style="background-color: red"></div><div class="td_note_font">办理受阻（显示受阻原因）</div></li>
                <li><div class="td_note" style="background-color: white;"></div><div class="td_note_font">无需办理（显示“—”）</div></li>
            </div>
        </td>
    </tr>
    <tr class="tr_button">
        <td class="form_border" align="center">
            <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
        </td>
    </tr>
</table>