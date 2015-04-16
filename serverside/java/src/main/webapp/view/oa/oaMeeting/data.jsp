<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<div class="form_div">
    <fieldset class="form_fieldset" style="width: 90%;margin: 0 auto;display: true;">
        <table cellpadding="0" cellspacing="1" class="form_table">
            <tr class="tr_header">
                <td width="100" nowrap>${title}</td>
                <c:forEach items="${showTitle}" var="dt">
                    <td width="">${dt}</td>
                </c:forEach>
            </tr>
            <c:forEach items="${bean}" var="room">
                <tr class="tr_light">
                    <td rowspan="2" nowrap>${room.key.name}</td>
                    <c:forEach items="${room.value}" var="t" begin="0" end="0">
                        <c:forEach items="${t.value}" var="week">
                            <td title="${week.value[0]}"
                                style="height:30px;background-color:${week.value[1]};" <c:if test="${not empty week.value[3]}">onclick="viewMeeting('${week.value[3]}')"</c:if>>${week.value[2]}</td>
                        </c:forEach>
                    </c:forEach>
                </tr>
                <tr class="tr_dark">
                    <c:forEach items="${room.value}" var="t" begin="1">
                        <c:forEach items="${t.value}" var="week">
                            <td title="${week.value[0]}"
                                style="height:30px;background-color:${week.value[1]};" <c:if test="${not empty week.value[3]}">onclick="viewMeeting('${week.value[3]}')"</c:if>>${week.value[2]}</td>
                        </c:forEach>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
        <br>
    </fieldset>
</div>