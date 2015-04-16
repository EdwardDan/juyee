<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
    <script type="text/javascript">
        function doSubmit(btn, bpmProcessTransitionId, toNodeName) {
            document.dataBean.bpmProcessTransitionId.value = bpmProcessTransitionId;
            //            alert(toNodeName);
            //            return;
            document.dataBean.toNodeName.value = toNodeName;
            document.dataBean.submit();
        }
    </script>

<div style="height:300px;overflow:auto">
<form:form name="dataBean" commandName="bean" action="${ctx}/bpmProcessInstance/standardSave.do">
    <input type="hidden" name="bpmTaskInstanceId" value="${bpmTaskInstanceId}">
    <input type="hidden" name="bpmProcessTransitionId">
    <input type="hidden" name="toNodeName" value="">
    <form:hidden path="id"/>
    <table width="100%" height="300px" cellpadding="0" cellspacing="0" border="0">

        <tr>
            <td colspan="2" height="99%" style="vertical-align:top;" bgcolor="#E5F8FC">
                <!-- main content begin -->
                <table width="100%" border="0" cellpadding="2" cellspacing="0" bordercolor="#FFFFFF">
                    <tr class="tr_head">
                        <td align="center">当前审核步骤：${currentTaskName}
                        </td>
                        <td width="30">
                            <!--<input type="button" value="日志" onclick="viewLog()" class="button_normal">--></td>
                    </tr>
                    <tr class="td_light">
                        <td align="center" colspan="2" height="30">
                            <fieldset>
                                <legend class="form_legend">任务信息：</legend>
                                <table border="0" width="95%">
                                    <tr>
                                        <td height="25" width="30%" nowrap align="right">
                                            处理截止时间：
                                        </td>
                                        <td nowrap>
                                                ${endDate} <c:if test="${hours>0}">（剩余约${hours}个小时）</c:if>
                                        </td>
                                    </tr>
                                </table>
                            </fieldset>
                        </td>
                    </tr>
                    <tr class="td_light">
                        <td align="center" style="vertical-align:top;" colspan="2">
                            <fieldset>
                                <legend class="form_legend"><b>审核操作：</b></legend>
                                <table border="0" width="95%">
                                    <c:if test="${isShowRead}">
                                        <tr>
                                            <td>&nbsp;</td>
                                            <td height="35" nowrap>
                                                <form:radiobuttons path="isRead" items="${readValues}"/>
                                            </td>
                                        </tr>
                                    </c:if>
                                    <c:if test="${isShowPermitted}">
                                        <tr>
                                            <td>&nbsp;</td>
                                            <td nowrap>
                                                <form:radiobuttons path="permitValue" items="${permitValues}"/>
                                            </td>
                                        </tr>
                                    </c:if>

                                    <c:if test="${isShowOpinion}">
                                        <tr>
                                            <td height="35" nowrap align="right" style="vertical-align:middle">
                                                输入意见：
                                            </td>
                                            <td nowrap>
                                                <form:textarea path="opinion" cssClass="input_textarea"/>
                                            </td>
                                        </tr>
                                    </c:if>
                                    <tr class="td_light">
                                        <td align="center" style="vertical-align:top;" colspan="2">
                                            <fieldset>
                                                <legend class="form_legend"><b>下一步任务：</b></legend>
                                                <table border="0" width="95%">
                                                    <c:forEach items="${taskNodes}" var="taskNode">
                                                        <tr>
                                                            <td height="35" width="30%" nowrap align="right">
                                                                <b>${taskNode.transition.name}:</b>
                                                            </td>
                                                            <td nowrap>
                                                                <input name="button_sub${taskNode.transition.id}"
                                                                       type="button" class="button_confirm" value="提交"
                                                                       onclick="doSubmit(this,${taskNode.transition.id},'${taskNode.toNode.name}')">
                                                            </td>
                                                            <td>
                                                                <c:if test="${taskNode.isSelectUser==true}">
                                                                    <input type="text"
                                                                           id="users_${taskNode.toNode.name}"
                                                                           name="users_${taskNode.toNode.name}" value=""
                                                                           class="input_text" readonly="true">
                                                                    <input type="hidden"
                                                                           id="userIds_${taskNode.toNode.name}"
                                                                           name="userIds_${taskNode.toNode.name}"
                                                                           value="">
                                                                    <img src="${themePath}/workflow/user.gif"
                                                                         alt="" border="0"
                                                                         onclick="multiSelectSysUser(null,'userIds_${taskNode.toNode.name}','users_${taskNode.toNode.name}')">
                                                                </c:if>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </table>

                                            </fieldset>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td height="30" nowrap align="right">

                                        <%--</td>--%>
                                        <%--<td nowrap>--%>
                                                <%--<c:choose >--%>
                                                <%--<c:when test="${view!=1}">--%>
                                                <%--<input name="button_sub1" type="submit" class="button_confirm" value="确定">--%>
                                                <%--<input name="button_sub1" type="button" class="button_cancel" value="取消" onclick="popup_exit_standard()">--%>
                                                <%--</c:when>--%>
                                                <%--<c:otherwise>--%>
                                                <%--<input name="button_sub1" type="button" class="button_confirm" value="关闭" onclick="window.close();">--%>
                                                <%--</c:otherwise>--%>
                                                <%--</c:choose>--%>
                                        </td>
                                    </tr>
                                </table>

                            </fieldset>
                        </td>
                    </tr>
                </table>
                <!-- main content end -->
            </td>
        </tr>
    </table>
</form:form>