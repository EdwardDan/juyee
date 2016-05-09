<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%--<script type="text/javascript">--%>
<%--$(function () {--%>
<%--$("#myTable").chromatable({--%>
<%--width: "100%", // specify 100%, auto, or a fixed pixel amount--%>
<%--height: "600px",--%>
<%--scrolling: "yes" // must have the jquery-1.3.2.min.js script installed to use--%>
<%--});--%>
<%--});--%>
<%--</script>--%>
<script type="text/javascript">
    function prevPage() {
        var begin = ${begin};
        var end = ${end};
        if((begin-10)>=0){
            begin-=10;
            end=begin+9;
            loadStageData('',null,begin,end);
        }
    }
    function nextPage() {
        var begin = ${begin};
        var end = ${end};
        var projectsSize = ${projectsSize};
        if((end+10)<=projectsSize){
            begin+=10;
            end=begin+9;
            loadStageData('',null,begin,end);
        }else if(begin+10<projectsSize&&end+10>projectsSize){
            begin+=10;
            end=projectsSize-1;
            loadStageData('',null,begin,end);
        }
    }

</script>
<table cellpadding="0" cellspacing="0" class="form_table">
    <input type="text" id="begin" name="begin" value="${begin}" hidden="hidden">
    <input type="text" id="end" name="end" value="${end}" hidden="hidden">
    <tr class="tr_light">
        <td align="left" nowrap>&nbsp;
            <c:choose>
                <c:when test="${isSum}">
                    ${year}年度项目办证推进表
                    <input type="button" name="prevPage" id="prevPage" onclick="prevPage()" value="上一页">
                    <c:set var="b" scope="session" value="${begin+1}"/>
                    <c:set var="e" scope="session" value="${end+1}"/>
                    第${b}至${e}条数据，共${projectsSize}条数据
                    <input type="button" name="nextPage" id="nextPage" onclick="nextPage()" value="下一页">
                </c:when>
                <c:otherwise>
                    共有${bidSize}个标段
                </c:otherwise>
            </c:choose>
            <%--&nbsp;<input type="button" value="导出" class="button_all" onclick="selectStage(this)"/>--%>
            <%--&nbsp; <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">--%>
        </td>
</table>
<table cellpadding="0" cellspacing="0" border="1" class="table_thin_line" id="myTable">
    <thead>
    <tr class="tr_header">
        <th rowspan="2" width="2%" nowrap>&nbsp;&nbsp;项目编号&nbsp;&nbsp;</th>
        <th rowspan="2" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;项目名称&nbsp;&nbsp;&nbsp;&nbsp;</th>
        <%--<th rowspan="2" nowrap>起讫地点</th>--%>
        <th rowspan="2" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;标段名称&nbsp;&nbsp;&nbsp;&nbsp;</th>
        <%--<th rowspan="2" nowrap>建设里程</th>--%>
        <th rowspan="2" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;所属区县&nbsp;&nbsp;&nbsp;&nbsp;</th>
        <th rowspan="2" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;项目阶段&nbsp;&nbsp;&nbsp;&nbsp;</th>
        <th rowspan="2" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;业态类别&nbsp;&nbsp;&nbsp;&nbsp;</th>
        <th rowspan="2" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;建设单位&nbsp;&nbsp;&nbsp;&nbsp;</th>
        <th rowspan="2" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;道路等级&nbsp;&nbsp;&nbsp;&nbsp;</th>
        <%--<th rowspan="2" nowrap>&nbsp;&nbsp;开工日期&nbsp;&nbsp;</th>--%>
        <%--<c:if test="${stepSize>1}"><th rowspan="2" nowrap>上报单位类型</th></c:if>--%>
        <%--<c:set var="fs" value="${(fn:length(firstStage.projStages))}"/>--%>
        <c:forEach items="${firstStages}" var="firstStage">
            <th colspan="2"
                <c:if test="${fn:length(firstStage.projStages)<1}">rowspan="2" </c:if> style="width: 200px" nowrap>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${firstStage.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </th>
        </c:forEach>
    </tr>
    <%--<tr class="tr_header">--%>
    <%--<c:forEach items="${secondStages}" var="secondStage">--%>
    <%--<th width="4%" nowrap>&nbsp;&nbsp;${secondStage.name}&nbsp;&nbsp;</th>--%>
    <%--</c:forEach>--%>
    <%--</tr>--%>
    </thead>
    <tbody>
    <c:forEach items="${projects}" var="projInfo" varStatus="projIndex" begin="${begin}" end="${end}">
        <c:forEach items="${projInfo.bids}" var="bid" varStatus="bidIndex">
            <c:set var="stepCount" value="${fn:length(steps)*4}"/>
            <c:set var="bidCount" value="${fn:length(projInfo.bids)*4}"/>
            <c:forEach items="${steps}" var="step" varStatus="stepIndex">
                <tr class="tr_dark">
                    <c:if test="${stepIndex.index == 0}">
                        <c:if test="${bidIndex.index == 0}">
                            <td rowspan="${bidCount}" width="2%">${bid.project.projNum}</td>
                            <td rowspan="${bidCount}">${bid.project.name}</td>
                            <%--<td rowspan="${bidCount}">${bid.project.location}</td>--%>
                        </c:if>
                        <td rowspan="${stepCount}">${stepCount}---${bid.name}</td>
                        <td rowspan="${stepCount}">${bid.belongAreaNames}</td>
                        <td rowspan="${stepCount}">${bid.project.stage.name}</td>
                        <td rowspan="${stepCount}">${bid.project.category.name}</td>
                        <td rowspan="${stepCount}">${bid.jsdwName}</td>
                        <td rowspan="${stepCount}">
                                <%--<c:if test="${bid.project.isMajor==true}">重大</c:if>--%>
                                <%--<c:if test="${bid.project.isMajor==false}">非重大</c:if>--%>
                                ${bid.project.roadTecGrade.name}
                        </td>

                        <%--<td rowspan="${stepCount}">${bid.buildMileage}</td>--%>
                        <%--<td rowspan="${stepCount}" nowrap>${bid.startDate}</td>--%>
                    </c:if>
                    <c:if test="${stepSize>1}">
                        <td>${step.name}</td>
                    </c:if>
                    <c:forEach items="${leafStages}" var="leafStage">
                        <c:set var="dataKeyJH" value="${bid.id}_${step.id}_${leafStage.id}_jh"/>
                        <c:set var="dataKeySJ" value="${bid.id}_${step.id}_${leafStage.id}_sj"/>
                        <%--<td class="td_normal" title="${dataMap[dataKey].resultName}"--%>
                        <%--<c:if test="${not empty dataMap[dataKey].color}">style="background-color: ${dataMap[dataKey].color}"</c:if>>${dataMap[dataKey].resultName}</td>--%>
                        <td class="td_normal">计划上报</td>
                        <td class="td_normal">计划批复</td>
                    </c:forEach>
                </tr>
                <tr class="tr_light">
                    <c:forEach items="${leafStages}" var="leafStage">
                        <c:set var="dataKeyJH" value="${bid.id}_${step.id}_${leafStage.id}_jh"/>
                        <c:set var="dataKeySJ" value="${bid.id}_${step.id}_${leafStage.id}_sj"/>
                        <%--<td class="td_normal" title="${dataMap[dataKey].resultName}"--%>
                        <%--<c:if test="${not empty dataMap[dataKey].color}">style="background-color: ${dataMap[dataKey].color}"</c:if>>${dataMap[dataKey].resultName}</td>--%>
                        <td class="td_normal">
                            <c:if test="${dataMap[dataKeyJH].resultCodeJH=='1'}">
                                ${dataMap[dataKeyJH].planSbDateJH}
                            </c:if>
                            <c:if test="${dataMap[dataKeyJH].resultCodeJH=='5'}">
                                ${dataMap[dataKeyJH].dealDateJH}
                            </c:if>
                        </td>
                        <td class="td_normal">
                            <c:if test="${dataMap[dataKeyJH].resultCodeJH=='1'}">
                                ${dataMap[dataKeyJH].planPfDateJH}
                            </c:if>
                            <c:if test="${dataMap[dataKeyJH].resultCodeJH=='5'}">
                                ${dataMap[dataKeyJH].dealDateJH}
                            </c:if>
                        </td>
                    </c:forEach>
                </tr>
                <tr class="tr_dark">
                    <c:forEach items="${leafStages}" var="leafStage">
                        <c:set var="dataKeyJH" value="${bid.id}_${step.id}_${leafStage.id}_jh"/>
                        <c:set var="dataKeySJ" value="${bid.id}_${step.id}_${leafStage.id}_sj"/>
                        <%--<td class="td_normal" title="${dataMap[dataKey].resultName}"--%>
                        <%--<c:if test="${not empty dataMap[dataKey].color}">style="background-color: ${dataMap[dataKey].color}"</c:if>>${dataMap[dataKey].resultName}</td>--%>
                        <td class="td_normal">实际上报</td>
                        <td class="td_normal">实际批复</td>
                    </c:forEach>
                </tr>
                <tr class="tr_light">
                    <c:forEach items="${leafStages}" var="leafStage">
                        <c:set var="dataKeyJH" value="${bid.id}_${step.id}_${leafStage.id}_jh"/>
                        <c:set var="dataKeySJ" value="${bid.id}_${step.id}_${leafStage.id}_sj"/>
                        <%--<td class="td_normal" title="${dataMap[dataKey].resultName}"--%>
                        <%--<c:if test="${not empty dataMap[dataKey].color}">style="background-color: ${dataMap[dataKey].color}"</c:if>>${dataMap[dataKey].resultName}</td>--%>
                        <td class="td_normal">
                            <c:if test="${dataMap[dataKeySJ].resultCodeSJ=='1'}">
                                ${dataMap[dataKeySJ].planSbDateSJ}
                            </c:if>
                            <c:if test="${dataMap[dataKeySJ].resultCodeSJ=='5'}">
                                ${dataMap[dataKeySJ].dealDateSJ}
                            </c:if>
                            <c:if test="${dataMap[dataKeySJ].resultCodeSJ=='4'}">
                                办理受阻
                            </c:if>
                        </td>
                        <td class="td_normal">
                            <c:if test="${dataMap[dataKeySJ].resultCodeSJ=='1'}">
                                ${dataMap[dataKeySJ].planPfDateSJ}
                            </c:if>
                            <c:if test="${dataMap[dataKeySJ].resultCodeSJ=='5'}">
                                ${dataMap[dataKeySJ].dealDateSJ}
                            </c:if>
                            <c:if test="${dataMap[dataKeySJ].resultCodeSJ=='4'}">
                                办理受阻
                            </c:if>
                        </td>
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
    </tbody>
</table>