<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        $("#myTable").chromatable({
            width: "100%", // specify 100%, auto, or a fixed pixel amount
            height: "600px",
            scrolling: "yes" // must have the jquery-1.3.2.min.js script installed to use
        });
    });
</script>
<table cellpadding="0" cellspacing="0" class="form_table">
    <tr class="tr_light">
        <td align="left" nowrap>&nbsp;
            ${year}年度项目推进汇总
            &nbsp;<input type="button" value="导出" class="button_all" onclick="printProjectData(this)"/>
            <%--&nbsp; <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">--%>
        </td>
</table>
<table cellpadding="0" cellspacing="0" border="1" class="table_thin_line" id="myTable">
    <thead>
    <tr class="tr_header">
        <th rowspan="2" width="2%" nowrap>序号</th>
        <th rowspan="2" width="10%" nowrap>&nbsp;&nbsp;建设名称&nbsp;&nbsp;</th>
        <th rowspan="2" width="10%" nowrap>&nbsp;&nbsp;工程名称&nbsp;&nbsp;</th>
        <th rowspan="2" width="5%" nowrap>&nbsp;&nbsp;联系人&nbsp;&nbsp;</th>
        <th rowspan="2" width="5%" nowrap>&nbsp;&nbsp;联系方式&nbsp;&nbsp;</th>
        <th rowspan="2" width="8%" nowrap>&nbsp;&nbsp;功能作用&nbsp;&nbsp;</th>
        <th rowspan="2" width="8%" nowrap>&nbsp;&nbsp;工程范围&nbsp;&nbsp;</th>
        <th rowspan="2" width="6%" nowrap>主要内容<br>（公里）</th>
        <th colspan="7" nowrap>&nbsp;&nbsp;工程投资（亿元）&nbsp;&nbsp;</th>
        <th colspan="3" nowrap>&nbsp;&nbsp;前期计划安排&nbsp;&nbsp;</th>
        <th rowspan="2" width="5%" nowrap>&nbsp;&nbsp;开工时间&nbsp;&nbsp;</th>
        <th rowspan="2" width="5%" nowrap>&nbsp;&nbsp;完工时间&nbsp;&nbsp;</th>
        <th rowspan="2" width="5%" nowrap>&nbsp;&nbsp;所在区县&nbsp;&nbsp;</th>
        <th rowspan="2" width="8%" nowrap>&nbsp;&nbsp;项目进展情况&nbsp;&nbsp;</th>
        <th rowspan="2" width="8%" nowrap>&nbsp;&nbsp;存在问题&nbsp;&nbsp;</th>
        <th rowspan="2" width="8%" nowrap>&nbsp;&nbsp;改进建议&nbsp;&nbsp;</th>
    </tr>
    <tr class="tr_header">
        <th width="4%" nowrap>工可批复<br>总投资</th>
        <th width="4%" nowrap>初设批复<br>总投资</th>
        <th width="4%" nowrap>2015年度<br>投资计划</th>
        <th width="4%" nowrap>截止至<br>2014年底<br>累计完成<br>投资额</th>
        <th width="4%" nowrap>上半年<br>年度累计<br>完成投资额</th>
        <th width="4%" nowrap>年度累计<br>完成额</th>
        <th width="4%" nowrap>&nbsp;&nbsp;资金来源&nbsp;&nbsp;</th>
        <th width="4%" nowrap>&nbsp;&nbsp;项目建议书&nbsp;&nbsp;</th>
        <th width="4%" nowrap>&nbsp;&nbsp;工可&nbsp;&nbsp;</th>
        <th width="4%" nowrap>&nbsp;&nbsp;初步设计&nbsp;&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${projects}" var="projInfo" varStatus="projIndex">
        <tr class="tr_light">
            <c:set var="gctxGkpfTotal" value="${projInfo.id}gkpf"/>
            <c:set var="gctxCspfTotal" value="${projInfo.id}cspf"/>
            <c:set var="type1" value="${projInfo.id}${key1}"/>
            <c:set var="type2" value="${projInfo.id}${key2}"/>
            <c:set var="type3_1" value="${projInfo.id}${key3_1}"/>
            <c:set var="type3_2" value="${projInfo.id}${key3_2}"/>
            <c:set var="gctxSourceFund" value="${projInfo.id}zjly"/>
            <c:set var="xmjysTime" value="${projInfo.id}xm"/>
            <c:set var="gkTime" value="${projInfo.id}gk"/>
            <c:set var="cbsjTime" value="${projInfo.id}cb"/>
            <c:set var="beginTime" value="${projInfo.id}begin"/>
            <c:set var="endTime" value="${projInfo.id}end"/>
            <c:set var="areaCode" value="${projInfo.id}area"/>
            <c:set var="projProgress" value="${projInfo.id}progress"/>
            <c:set var="questions" value="${projInfo.id}question"/>
            <c:set var="improveOpinion" value="${projInfo.id}opinion"/>
            <td>${projInfo.no}</td>
            <td>${projInfo.jsDept}</td>
            <td>${projInfo.name}</td>
            <td>${projInfo.jsDeptPerson}</td>
            <td>${projInfo.jsDeptTel}</td>
            <td><sys:toHtml>${projInfo.function}</sys:toHtml></td>
            <td><sys:toHtml>${projInfo.engineerRange}</sys:toHtml></td>
            <td>${projInfo.mainContent}</td>
            <td>${dataMap[gctxGkpfTotal]}</td>
            <td>${dataMap[gctxCspfTotal]}</td>
            <td>${dataMap[type1]}</td>
            <td>${dataMap[type2]}</td>
            <td>${dataMap[type3_1]}</td>
            <td>${dataMap[type3_2]}</td>
            <td>${dataMap[gctxSourceFund]}</td>
            <td>${dataMap[xmjysTime]}</td>
            <td>${dataMap[gkTime]}</td>
            <td>${dataMap[cbsjTime]}</td>
            <td>${dataMap[beginTime]}</td>
            <td>${dataMap[endTime]}</td>
            <td>${dataMap[areaCode]}</td>
            <td>${dataMap[projProgress]}</td>
            <td>${dataMap[questions]}</td>
            <td>${dataMap[improveOpinion]}</td>

        </tr>
    </c:forEach>
    <%--<c:forEach items="${projects}" var="projInfo" varStatus="projIndex">--%>
        <%--<c:forEach items="${projInfo.bids}" var="bid" varStatus="bidIndex">--%>
            <%--<c:set var="stepCount" value="${fn:length(steps)*1}"/>--%>
            <%--<c:set var="bidCount" value="${fn:length(projInfo.bids)}"/>--%>
            <%--<c:forEach items="${steps}" var="step" varStatus="stepIndex">--%>
                <%--<tr class="tr_light">--%>
                    <%--<c:if test="${stepIndex.index == 0}">--%>
                        <%--<c:if test="${bidIndex.index == 0}">--%>
                            <%--<td rowspan="${bidCount}" width="2%">${projIndex.index+1}</td>--%>
                            <%--<td rowspan="${bidCount}">${bid.project.name}</td>--%>
                            <%--<td rowspan="${bidCount}">${bid.project.location}</td>--%>
                        <%--</c:if>--%>
                        <%--<td rowspan="${stepCount}">${bid.name}</td>--%>
                        <%--<td rowspan="${stepCount}">${bid.buildMileage}</td>--%>
                        <%--<td rowspan="${stepCount}">${bid.belongAreaNames}</td>--%>
                        <%--<td rowspan="${stepCount}" nowrap>${bid.startDate}</td>--%>
                    <%--</c:if>--%>
                    <%--<c:if test="${stepSize>1}">--%>
                        <%--<td>${step.name}</td>--%>
                    <%--</c:if>--%>
                    <%--<c:forEach items="${leafStages}" var="leafStage">--%>
                        <%--<c:set var="dataKey" value="${bid.id}_${step.id}_${leafStage.id}"/>--%>
                        <%--<td class="td_normal" title="${dataMap[dataKey].resultName}"--%>
                            <%--<c:if test="${not empty dataMap[dataKey].color}">style="background-color: ${dataMap[dataKey].color}"</c:if>>${dataMap[dataKey].resultName}</td>--%>
                    <%--</c:forEach>--%>
                <%--</tr>--%>
                <%--&lt;%&ndash;<tr class="tr_dark">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<c:forEach items="${leafStages}" var="leafStage">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<c:set var="dataKey" value="${bid.id}_${step.id}_${leafStage.id}" />&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td nowrap class="td_normal" title="${dataMap[dataKey].dealDate}"><span <c:if test="${dataMap[dataKey].dealDate!=lastMap[dataKey].dealDate}">class="td_change"</c:if>><sys:cutString length="10">${dataMap[dataKey].dealDate}</sys:cutString></span></td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
            <%--</c:forEach>--%>
        <%--</c:forEach>--%>
    <%--</c:forEach>--%>
    </tbody>
</table>