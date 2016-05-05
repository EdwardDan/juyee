<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<table cellpadding="0" cellspacing="0" border="1" class="table_thin_line" style="width: 100%;">
    <tr class="tr_header">
        <td rowspan="2" colspan="2" style="width: 10%;">推进阶段</td>
        <%--<c:forEach items="${steps}" var="step">--%>
        <%--<c:if test="${step.isValid}">--%>
        <%--<td colspan="2" style="width: 90%;">${step.name}</td>--%>
        <%--</c:if>--%>
        <%--</c:forEach>--%>
    </tr>
    <tr class="tr_header">
        <c:forEach items="${steps}" var="step">
            <c:if test="${step.isValid}">
                <td style="width: 40%;" colspan="2">计划</td>
                <td style="width: 50%;" colspan="3">实际</td>
            </c:if>
        </c:forEach>
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
                    <c:forEach items="${steps}" var="step">
                        <c:if test="${step.isValid}">


                            <%--计划--%>
                            <c:set var="dataKey" value="${bidId}_${step.id}_${stageFirst.id}_jh"/>
                            <td>
                                <select class="form_select_long" style="width: 99%;"
                                        name="resultCodeJH_${bidId}_${step.id}_${stageFirst.id}"
                                        id="resultCodeJH_${bidId}_${step.id}_${stageFirst.id}"
                                        onchange="changeResultJH(this,'${bidId}','${step.id}','${stageFirst.id}')" <c:if
                                        test="${isSubmit == 1}"> disabled="disabled"</c:if>>
                                    <option value="">请选择</option>
                                    <c:forEach items="${results}" var="result">
                                        <option value="${result.code}"
                                                <c:if test="${result.code==4}">hidden="hidden"</c:if>
                                                <c:if test="${dataMap[dataKey].resultCodeJH == result.code}">selected</c:if>>${result.name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                            <textarea class="input_text" style="width: 99%;cursor: pointer;height: 50px;"
                                      readonly="true"
                                      <c:if test="${dataMap[dataKey].resultCodeJH == '1'}">hidden="hidden"</c:if>
                                      id="dealDateJH_${bidId}_${step.id}_${stageFirst.id}"
                                      name="dealDateJH_${bidId}_${step.id}_${stageFirst.id}"
                                      title="${dataMap[dataKey].dealDateJH}"
                                      <c:if test="${isSubmit != 1}">onclick="changeResultJH(document.getElementById('resultCodeJH_${bidId}_${step.id}_${stageFirst.id}'),'${bidId}','${step.id}','${stageFirst.id}')"</c:if>>${dataMap[dataKey].dealDateJH}</textarea>
                                    <%--需办理的日期选择--%>
                                <div id="xblJH_${bidId}_${step.id}_${stageFirst.id}"
                                     name="xblJH_${bidId}_${step.id}_${stageFirst.id}"
                                     <c:if test="${dataMap[dataKey].resultCodeJH != '1'}">hidden="hidden"</c:if>
                                        >
                                    计划上报：<input type="text" id="planSbDateJH_${bidId}_${step.id}_${stageFirst.id}"
                                                name="planSbDateJH_${bidId}_${step.id}_${stageFirst.id}" class="input_date"
                                                value="${dataMap[dataKey].planSbDateJH}" readonly="readonly">
                                    <input type="button"
                                           class="button_calendar"
                                    <c:if test="${isSubmit == 1}"> disabled="disabled"</c:if>
                                           value=""
                                           onClick="calendar('planSbDateJH_${bidId}_${step.id}_${stageFirst.id}','')"><br/>
                                    计划批复：<input type="text" id="planPfDateJH_${bidId}_${step.id}_${stageFirst.id}"
                                                name="planPfDateJH_${bidId}_${step.id}_${stageFirst.id}" class="input_date"
                                                value="${dataMap[dataKey].planPfDateJH}" readonly="readonly">
                                    <input type="button"
                                           class="button_calendar"
                                    <c:if test="${isSubmit == 1}"> disabled="disabled"</c:if>
                                           value=""
                                           onClick="calendar('planPfDateJH_${bidId}_${step.id}_${stageFirst.id}','')">
                                </div>
                            </td>
                            <%--实际--%>
                            <c:set var="dataKey" value="${bidId}_${step.id}_${stageFirst.id}_sj"/>
                            <td>
                                <select class="form_select_long" style="width: 99%;"
                                        name="resultCodeSJ_${bidId}_${step.id}_${stageFirst.id}"
                                        id="resultCodeSJ_${bidId}_${step.id}_${stageFirst.id}"
                                        onchange="changeResultSJ(this,'${bidId}','${step.id}','${stageFirst.id}')">
                                    <option value="">请选择</option>
                                    <c:forEach items="${results}" var="result">
                                        <option value="${result.code}"
                                                <c:if test="${dataMap[dataKey].resultCodeSJ == result.code}">selected</c:if>>${result.name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                            <textarea class="input_text" style="width: 99%;cursor: pointer;height: 50px;"
                                      readonly="true"
                                      <c:if test="${dataMap[dataKey].resultCodeSJ == '1'}">hidden="hidden"</c:if>
                                      id="dealDateSJ_${bidId}_${step.id}_${stageFirst.id}"
                                      name="dealDateSJ_${bidId}_${step.id}_${stageFirst.id}"
                                      title="${dataMap[dataKey].dealDateSJ}"
                                      onclick="changeResultSJ(document.getElementById('resultCodeSJ_${bidId}_${step.id}_${stageFirst.id}'),'${bidId}','${step.id}','${stageFirst.id}')">${dataMap[dataKey].dealDateSJ}</textarea>
                                    <%--需办理的日期选择--%>
                                <div id="xblSJ_${bidId}_${step.id}_${stageFirst.id}"
                                     name="xblSJ_${bidId}_${step.id}_${stageFirst.id}"
                                     <c:if test="${dataMap[dataKey].resultCodeSJ != '1'}">hidden="hidden"</c:if>
                                        >
                                    计划上报：<input type="text" id="planSbDateSJ_${bidId}_${step.id}_${stageFirst.id}"
                                                name="planSbDateSJ_${bidId}_${step.id}_${stageFirst.id}" class="input_date"
                                                value="${dataMap[dataKey].planSbDateSJ}" readonly="readonly">
                                    <input type="button"
                                           class="button_calendar"
                                           value=""
                                           onClick="calendar('planSbDateSJ_${bidId}_${step.id}_${stageFirst.id}','')"><br/>
                                    计划批复：<input type="text" id="planPfDateSJ_${bidId}_${step.id}_${stageFirst.id}"
                                                name="planPfDateSJ_${bidId}_${step.id}_${stageFirst.id}" class="input_date"
                                                value="${dataMap[dataKey].planPfDateSJ}" readonly="readonly">
                                    <input type="button"
                                           class="button_calendar"
                                           value=""
                                           onClick="calendar('planPfDateSJ_${bidId}_${step.id}_${stageFirst.id}','')">
                                </div>
                            </td>
                            <c:set var="dataKey2" value="${bidId}_${step.id}_${stageFirst.id}"/>
                            <td>${upButton[dataKey2]}</td>


                        </c:if>
                    </c:forEach>
                </tr>
            </c:forEach>
        </c:if>


        <%--支持一层数据的情况--%>
        <c:if test="${fn:length(stageFirst.projStages)==0 && null==stageFirst.parent}">
            <tr class="tr_dark">
                <td colspan="2">${stageFirst.name}</td>
                <c:forEach items="${steps}" var="step">
                    <c:if test="${step.isValid}">


                        <%--计划--%>
                        <c:set var="dataKey" value="${bidId}_${step.id}_${stageFirst.id}_jh"/>
                        <td>
                            <select class="form_select_long" style="width: 99%;"
                                    name="resultCodeJH_${bidId}_${step.id}_${stageFirst.id}"
                                    id="resultCodeJH_${bidId}_${step.id}_${stageFirst.id}"
                                    onchange="changeResultJH(this,'${bidId}','${step.id}','${stageFirst.id}')" <c:if
                                    test="${isSubmit == 1}"> disabled="disabled"</c:if>>
                                <option value="">请选择</option>
                                <c:forEach items="${results}" var="result">
                                    <option value="${result.code}"
                                            <c:if test="${result.code==4}">hidden="hidden"</c:if>
                                            <c:if test="${dataMap[dataKey].resultCodeJH == result.code}">selected</c:if>>${result.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <textarea class="input_text" style="width: 99%;cursor: pointer;height: 50px;"
                                      readonly="true"
                                      <c:if test="${dataMap[dataKey].resultCodeJH == '1'}">hidden="hidden"</c:if>
                                      id="dealDateJH_${bidId}_${step.id}_${stageFirst.id}"
                                      name="dealDateJH_${bidId}_${step.id}_${stageFirst.id}"
                                      title="${dataMap[dataKey].dealDateJH}"
                                      <c:if test="${isSubmit != 1}">onclick="changeResultJH(document.getElementById('resultCodeJH_${bidId}_${step.id}_${stageFirst.id}'),'${bidId}','${step.id}','${stageFirst.id}')"</c:if>>${dataMap[dataKey].dealDateJH}</textarea>
                                <%--需办理的日期选择--%>
                            <div id="xblJH_${bidId}_${step.id}_${stageFirst.id}"
                                 name="xblJH_${bidId}_${step.id}_${stageFirst.id}"
                                 <c:if test="${dataMap[dataKey].resultCodeJH != '1'}">hidden="hidden"</c:if>
                                    >
                                计划上报：<input type="text" id="planSbDateJH_${bidId}_${step.id}_${stageFirst.id}"
                                            name="planSbDateJH_${bidId}_${step.id}_${stageFirst.id}" class="input_date"
                                            value="${dataMap[dataKey].planSbDateJH}" readonly="readonly">
                                <input type="button"
                                       class="button_calendar"
                                <c:if test="${isSubmit == 1}"> disabled="disabled"</c:if>
                                       value=""
                                       onClick="calendar('planSbDateJH_${bidId}_${step.id}_${stageFirst.id}','')"><br/>
                                计划批复：<input type="text" id="planPfDateJH_${bidId}_${step.id}_${stageFirst.id}"
                                            name="planPfDateJH_${bidId}_${step.id}_${stageFirst.id}" class="input_date"
                                            value="${dataMap[dataKey].planPfDateJH}" readonly="readonly">
                                <input type="button"
                                       class="button_calendar"
                                <c:if test="${isSubmit == 1}"> disabled="disabled"</c:if>
                                       value=""
                                       onClick="calendar('planPfDateJH_${bidId}_${step.id}_${stageFirst.id}','')">
                            </div>
                        </td>
                        <%--实际--%>
                        <c:set var="dataKey" value="${bidId}_${step.id}_${stageFirst.id}_sj"/>
                        <td>
                            <select class="form_select_long" style="width: 99%;"
                                    name="resultCodeSJ_${bidId}_${step.id}_${stageFirst.id}"
                                    id="resultCodeSJ_${bidId}_${step.id}_${stageFirst.id}"
                                    onchange="changeResultSJ(this,'${bidId}','${step.id}','${stageFirst.id}')">
                                <option value="">请选择</option>
                                <c:forEach items="${results}" var="result">
                                    <option value="${result.code}"
                                            <c:if test="${dataMap[dataKey].resultCodeSJ == result.code}">selected</c:if>>${result.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <textarea class="input_text" style="width: 99%;cursor: pointer;height: 50px;"
                                      readonly="true"
                                      <c:if test="${dataMap[dataKey].resultCodeSJ == '1'}">hidden="hidden"</c:if>
                                      id="dealDateSJ_${bidId}_${step.id}_${stageFirst.id}"
                                      name="dealDateSJ_${bidId}_${step.id}_${stageFirst.id}"
                                      title="${dataMap[dataKey].dealDateSJ}"
                                      onclick="changeResultSJ(document.getElementById('resultCodeSJ_${bidId}_${step.id}_${stageFirst.id}'),'${bidId}','${step.id}','${stageFirst.id}')">${dataMap[dataKey].dealDateSJ}</textarea>
                                <%--需办理的日期选择--%>
                            <div id="xblSJ_${bidId}_${step.id}_${stageFirst.id}"
                                 name="xblSJ_${bidId}_${step.id}_${stageFirst.id}"
                                 <c:if test="${dataMap[dataKey].resultCodeSJ != '1'}">hidden="hidden"</c:if>
                                    >
                                计划上报：<input type="text" id="planSbDateSJ_${bidId}_${step.id}_${stageFirst.id}"
                                            name="planSbDateSJ_${bidId}_${step.id}_${stageFirst.id}" class="input_date"
                                            value="${dataMap[dataKey].planSbDateSJ}" readonly="readonly">
                                <input type="button"
                                       class="button_calendar"
                                       value=""
                                       onClick="calendar('planSbDateSJ_${bidId}_${step.id}_${stageFirst.id}','')"><br/>
                                计划批复：<input type="text" id="planPfDateSJ_${bidId}_${step.id}_${stageFirst.id}"
                                            name="planPfDateSJ_${bidId}_${step.id}_${stageFirst.id}" class="input_date"
                                            value="${dataMap[dataKey].planPfDateSJ}" readonly="readonly">
                                <input type="button"
                                       class="button_calendar"
                                       value=""
                                       onClick="calendar('planPfDateSJ_${bidId}_${step.id}_${stageFirst.id}','')">
                            </div>
                        </td>
                        <c:set var="dataKey2" value="${bidId}_${step.id}_${stageFirst.id}"/>
                        <td>${upButton[dataKey2]}</td>


                    </c:if>
                </c:forEach>
            </tr>
        </c:if>
    </c:forEach>
</table>


