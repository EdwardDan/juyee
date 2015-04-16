<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<c:if test="${from =='view'}">
    <%@include file="/common/header.jsp" %>
</c:if>
<script type="text/javascript">
    function logDetail(bpmTaskInstanceId, operateType) {
        openFullWindow("${ctx}/bpmProcessLog/logDetail.do?bpmTaskInstanceId=" + bpmTaskInstanceId + "&operateType=" + operateType, 900, 550, "auditPageWin");
    }
</script>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_header" align="center">
            <td class="form_border" width="15%" nowrap>操作时间</td>
            <td class="form_border" width="12%" nowrap>任务名称</td>
            <td class="form_border" width="10%" nowrap>操作人员</td>
            <td class="form_border" width="20%" nowrap
                <c:if test="${!existStandardOperation}">style="display:none"</c:if>>审核意见(仅标准操作)
            </td>
            <td class="form_border" width="15%" nowrap>附件</td>
            <td class="form_border" width="15%" nowrap>详细</td>
        </tr>
        <c:forEach items="${logs}" var="log" varStatus="status">
            <tr
                    <c:if test="${status.index%2==1}"> class="tr_light"</c:if>
                    <c:if test="${status.index%2==0}"> class="tr_dark"</c:if>
                    align="center">
                <td class="form_border" nowrap><fmt:formatDate value="${log.opTime}"
                                                               pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;</td>
                <td class="form_border">${log.name}&nbsp;</td>
                <td class="form_border">${log.actor}&nbsp;</td>
                <td class="form_border"
                    style="word-break:break-all;<c:if test="${!existStandardOperation}">display:none</c:if>">${log.opinion}&nbsp;</td>
                <td class="form_border" style="word-break:break-all">&nbsp;${log.documentLink}</td>

                <td class="form_border">
                    <input name="button_sub1" type="button" class="button_normal" value="详细"
                           onclick="logDetail('${log.bpmTaskInstanceId}','${log.operateType}')"
                           title="点击查看具体审核页面">
                </td>
            </tr>
        </c:forEach>
        <c:if test="${fn:length(logs)==0}">
            <tr class="tr_light">
                <td colspan="6" height="100">
                    暂无流转日志！
                </td>
            </tr>
        </c:if>

        <tr class="tr_button">
            <td class="form_border" align="center" colspan="6">
                <c:choose>
                    <c:when test="${from =='view'}">
                        <input type="button" value="关闭" class="button_cancel" onclick="parent.closeWindow()">
                    </c:when>
                    <c:otherwise>
                        <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </table>
</div>
