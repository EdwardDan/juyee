<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<table cellpadding="0" cellspacing="0" border="1" class="table_thin_line" style="width: 100%;">
    <tr class="tr_header">
        <td rowspan="2" colspan="2">推进阶段</td>
        <c:forEach items="${steps}" var="step">
            <td colspan="2">${step.name}</td>
        </c:forEach>
    </tr>
    <tr class="tr_header">
        <c:forEach items="${steps}" var="step">
            <td>推进结果</td>
            <td>计划日期/办结<br>日期/问题</td>
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
                        <c:set var="dataKey" value="${bidId}_${step.id}_${stageSecond.id}"/>
                        <td>
                            <select class="form_select" style="width: 75px;"
                                    name="resultCode_${bidId}_${step.id}_${stageSecond.id}"
                                    id="resultCode_${bidId}_${step.id}_${stageSecond.id}"
                                    onchange="changeResult(this.value,'${bidId}','${step.id}','${stageSecond.id}')">
                                <option value="">请选择</option>
                                <c:forEach items="${results}" var="result">
                                    <option value="${result.code}"
                                            <c:if test="${dataMap[dataKey].resultCode == result.code}">selected</c:if>>${result.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <textarea class="input_text" style="width: 95%;cursor: pointer;" readonly="true"
                                      id="dealDate_${bidId}_${step.id}_${stageSecond.id}"
                                      name="dealDate_${bidId}_${step.id}_${stageSecond.id}"
                                      title="${dataMap[dataKey].dealDate}"
                                      onclick="changeResult(document.getElementById('resultCode_${bidId}_${step.id}_${stageSecond.id}').value,'${bidId}','${step.id}','${stageSecond.id}')">${dataMap[dataKey].dealDate}</textarea>
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${fn:length(stageFirst.projStages)==0 && null==stageFirst.parent}">
            <tr class="tr_dark">
                <td colspan="2">${stageFirst.name}</td>
                <c:forEach items="${steps}" var="step">
                    <c:set var="dataKey" value="${bidId}_${step.id}_${stageFirst.id}"/>
                    <td>
                        <select class="form_select" style="width: 75px;"
                                name="resultCode_${bidId}_${step.id}_${stageFirst.id}"
                                id="resultCode_${bidId}_${step.id}_${stageFirst.id}"
                                onchange="changeResult(this.value,'${bidId}','${step.id}','${stageFirst.id}')">
                            <option value="">请选择</option>
                            <c:forEach items="${results}" var="result">
                                <option value="${result.code}"
                                        <c:if test="${dataMap[dataKey].resultCode == result.code}">selected</c:if>>${result.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <textarea class="input_text" style="width: 95%;cursor: pointer;" readonly="true"
                                  id="dealDate_${bidId}_${step.id}_${stageFirst.id}"
                                  name="dealDate_${bidId}_${step.id}_${stageFirst.id}"
                                  title="${dataMap[dataKey].dealDate}"
                                  onclick="changeResult(document.getElementById('resultCode_${bidId}_${step.id}_${stageFirst.id}').value,'${bidId}','${step.id}','${stageFirst.id}')">${dataMap[dataKey].dealDate}</textarea>
                    </td>
                </c:forEach>
            </tr>
        </c:if>
    </c:forEach>
</table>

