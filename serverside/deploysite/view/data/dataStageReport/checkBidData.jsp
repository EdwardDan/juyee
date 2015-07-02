<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<table cellpadding="0" cellspacing="0" border="1" class="table_thin_line" style="width: 100%;">
    <tr class="tr_header">
        <td colspan="2" style="width: 15%;">推进阶段</td>
        <td style="width: 15%;">推进步骤</td>
        <td style="width: 70%;">推进结果</td>
    </tr>
    <c:forEach items="${projStages}" var="stageFirst" varStatus="first">
        <%--支持两层数据的情况--%>
        <c:if test="${fn:length(stageFirst.projStages)>0}">
            <c:forEach items="${stageFirst.projStages}" var="stageSecond" varStatus="senond">
                <tr class="tr_dark">
                    <c:if test="${senond.index==0}">
                        <td rowspan="${fn:length(stageFirst.projStages)}" nowrap>${stageFirst.name}</td>
                    </c:if>
                    <td nowrap>&nbsp;${stageSecond.name}&nbsp;</td>
                    <c:set var="dataKey" value="${bidId}_${stageSecond.id}"/>
                    <td>
                        <select class="form_select" style="width:99%;"
                                name="resultCode_${bidId}_${stageSecond.id}"
                                id="resultCode_${bidId}_${stageSecond.id}"
                                onchange="changeResult(this,'${bidId}','${stageSecond.id}')">
                            <option value="">请选择</option>
                            <c:forEach items="${results}" var="result">
                                <option value="${result.code}"
                                        <c:if test="${dataMap[dataKey].resultCode == result.code}">selected</c:if>>${result.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <textarea class="input_text" style="width: 99%;cursor: pointer;height: 50px;" readonly="true"
                                  id="dealDate_${bidId}_${stageSecond.id}" name="dealDate_${bidId}_${stageSecond.id}"
                                  title="${dataMap[dataKey].dealDate}"
                                  onclick="changeResult(document.getElementById('resultCode_${bidId}_${stageSecond.id}'),'${bidId}','${stageSecond.id}')">${dataMap[dataKey].dealDate}</textarea>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <%--支持一层数据的情况--%>
        <c:if test="${fn:length(stageFirst.projStages)==0 && null==stageFirst.parent}">
            <tr class="tr_dark">
                <td colspan="2">${stageFirst.name}</td>
                <c:set var="dataKey" value="${bidId}_${stageFirst.id}"/>
                <td>
                    <select class="form_select" style="width: 99%;"
                            name="resultCode_${bidId}_${stageFirst.id}"
                            id="resultCode_${bidId}_${stageFirst.id}"
                            onchange="changeResult(this,'${bidId}','${stageFirst.id}')">
                        <option value="">请选择</option>
                        <c:forEach items="${results}" var="result">
                            <option value="${result.code}"
                                    <c:if test="${dataMap[dataKey].resultCode == result.code}">selected</c:if>>${result.name}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <textarea class="input_text" style="width: 99%;cursor: pointer;height: 50px;" readonly="true"
                              id="dealDate_${bidId}_${stageFirst.id}" name="dealDate_${bidId}_${stageFirst.id}"
                              title="${dataMap[dataKey].dealDate}"
                              onclick="changeResult(document.getElementById('resultCode_${bidId}_${stageFirst.id}'),'${bidId}','${stageFirst.id}')">${dataMap[dataKey].dealDate}</textarea>
                </td>
            </tr>
        </c:if>
    </c:forEach>
</table>

