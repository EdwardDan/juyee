<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_header">
            <td rowspan="2" width="2%">序号</td>
            <td rowspan="2">项目名称</td>
            <td rowspan="2">起讫地点</td>
            <td rowspan="2">标段名称</td>
            <td rowspan="2">建设里程</td>
            <td rowspan="2">涉及区县</td>
            <td rowspan="2">开工日期</td>
            <td rowspan="2">上报单位类型</td>
            <c:forEach items="${firstStages}" var="firstStage">
                <td colspan="${fn:length(firstStage.projStages)}">初步设计</td>
            </c:forEach>
        </tr>
        <tr class="tr_header">
            <c:forEach items="${secondStages}" var="secondStage">
                <td width="5%">${secondStage.name}</td>
            </c:forEach>
        </tr>
        <c:forEach items="${bids}" var="bid" varStatus="bidIndex">
            <c:set var="stepCount" value="${fn:length(steps)*2}"></c:set>
            <c:forEach items="${steps}" var="step" varStatus="stepIndex">
                <tr class="tr_light">
                    <c:if test="${bidIndex.index == 0}">
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
                        <td>${bid.id}_${step.id}_${leafStage.id}1</td>
                    </c:forEach>
                </tr>
                <tr class="tr_dark">
                    <c:forEach items="${leafStages}" var="leafStage">
                        <td>${bid.id}_${step.id}_${leafStage.id}2</td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </c:forEach>
        <tr class="tr_button">
            <td class="form_border" colspan="${fn:length(leafStages)+8}" align="center">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>