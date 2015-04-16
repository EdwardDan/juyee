<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function cancelLock() {
    <%--$.ajax({--%>
    <%--url: "${ctx}/bpmProcessInstance/cancelLock.do",--%>
    <%--cache: false,--%>
    <%--data: "bpmTaskInstanceId=${bpmTaskInstanceId}",--%>
    <%--success: function(html) {--%>
    <%--$.prompt('取消独占成功');--%>
    <%--$("#button_sub1").attr("disabled", "true");--%>
    <%--},--%>
    <%--failure:function() {--%>
    <%--$.prompt('取消独占失败');--%>
    <%--}--%>
    <%--});--%>
        saveAjaxData("${ctx}/bpmProcessInstance/cancelLock.do?bpmTaskInstanceId=${bpmTaskInstanceId}",null,null,null);
    }
    function doForward() {
//        if (!formCheck(document.bean)) {
//            return;
//        }
        if ($("#actorId").val() == "") {
            alert("请选择转发人员");
            return;
        }
    <%--document.form.action = "${ctx}/bpmProcessInstance/forward.do";--%>
    <%--document.form.submit();--%>
        if(confirm("确定要转发给其他人吗？")){
            saveAjaxData("${ctx}/bpmProcessInstance/forward.do?bpmTaskInstanceId=${bpmTaskInstanceId}&actorId="+$("#actorId").val(),null,jumpPage,null);
        }
    }
    function jumpPage(ret){
        //转发后刷新grid
        jumpBackPage();
    }
</script>

<div style="height:320px;overflow:auto">
    <%--<form name="form" action="">--%>
    <input type="hidden" name="bpmTaskInstanceId" value="${bpmTaskInstanceId}">
    <table width="100%" height="100%" cellpadding="0" cellspacing="0" border="0">
        <tr>
            <td colspan="2" height="99%" style="vertical-align:top;" bgcolor="#E5F8FC">
                <%--<div style="overflow-x:hidden;overflow-y:auto;">--%>
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
                                    <tr>
                                        <td height="25" width="30%" nowrap align="right">
                                            取消独占：
                                        </td>
                                        <td nowrap>
                                            <input name="button_sub1" id="button_sub1" type="button"
                                                   class="button_cancel"  ${disabled} value="取消"
                                                   onclick="cancelLock();">
                                        </td>
                                    </tr>
                                </table>
                            </fieldset>
                        </td>
                    </tr>
                    <c:if test="${canForward}">
                        <tr class="td_light">
                            <td align="center" colspan="2" height="30">
                                <c:if test="${canForward}">
                                    <fieldset>
                                        <legend class="form_legend">转发：</legend>
                                        <table border="0" width="95%">
                                            <tr>
                                                <td height="25" width="30%" nowrap align="right">
                                                    选择人员：
                                                </td>
                                                <td nowrap>
                                                    <input type="text" name="user_zf" id="user_zf" value="${userNames}"
                                                           class="input_text"
                                                           readonly="true">
                                                    <input type="hidden" name="actorId" id="actorId" value="${userIds}">
                                                    <img src="${themePath}/workflow/user.gif" alt="" border="0"
                                                         onclick="selectSysUser('actorId','user_zf')">
                                                    <input name="button_sub1" type="button" class="button_normal_long"
                                                           value="转发" onclick="doForward()">
                                                </td>
                                            </tr>
                                        </table>
                                    </fieldset>
                                </c:if>
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
                                                <b>${taskNode.transitionName}:</b>
                                            </td>
                                            <td nowrap>
                                                <c:choose>
                                                    <c:when test="${taskNodeListSize >1}">
                                                        <input name="button_sub1" type="button" class="button_confirm"
                                                               value="提交"
                                                               onclick="doSub(this,${taskNode.transition.id},'${taskNode.toNode.id}')"
                                                               title="${taskNode.toNode.name}">
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input name="button_sub1" type="button" class="button_confirm"
                                                               value="提交"
                                                               onclick="doSub(this,'','${taskNode.toNode.id}')"
                                                               title="${taskNode.toNode.name}">
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <c:if test="${taskNode.isSelectUser==true}">
                                                    <input type="text" id="users_${taskNode.toNode.id}"
                                                           name="users_${taskNode.toNode.id}" value=""
                                                           class="input_text" readonly="true">
                                                    <input type="hidden" id="userIds_${taskNode.toNode.id}"
                                                           name="userIds_${taskNode.toNode.id}" value="">
                                                    <img src="${themePath}/workflow/user.gif" alt="" border="0"
                                                         onclick="multiSelectVarUser(null,'userIds_${taskNode.toNode.id}','users_${taskNode.toNode.id}',${taskNode.toNode.id})">
                                                </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </table>

                            </fieldset>
                        </td>
                    </tr>
                    <c:if test="${isFirstAuditTaskNode}">
                        <tr>
                            <td align="center" style="vertical-align:top;" colspan="2">
                                <fieldset>
                                    <legend class="form_legend">&nbsp;抄送人员：</legend>
                                    <table border="0" width="95%" align="center">
                                        <tr>
                                            <td width="5%">&nbsp;</td>
                                            <td align="left">
                                                <select name="ccUsers" id="ccUsers" size="3" multiple style="width:200px"
                                                        class="input_light">
                                                    <c:forEach var="sysUser" items="${sysUserHM}">
                                                        <option value="${sysUser.key}">${sysUser.value}</option>
                                                    </c:forEach>
                                                </select>
                                                <img src="${themePath}/workflow/user.gif" alt="请选择抄送用户" border="0"
                                                     style="cursor:pointer"
                                                     onclick="multiSelectSysUser('ccUsers','ccUserIds','ccUserNames')">
                                                <img src="${themePath}/workflow/file_delete.gif" width="16"
                                                     height="16" border="0" alt="移除选中人员" align="absbottom"
                                                     onClick="removeMultiSelectOpt('ccUsers','ccUserIds','ccUserNames')">
                                                <input type="hidden" name="ccUserIds" id="ccUserIds"
                                                       value="${processInstance.ccUserIds}">
                                                <input type="hidden" name="ccUserNames" id="ccUserNames">
                                            </td>
                                        </tr>
                                    </table>
                                </fieldset>
                            </td>
                        </tr>
                    </c:if>
                </table>
                <!-- main content end -->
            </td>
        </tr>
    </table>
    <%--</form>--%>
    <script type="text/javascript">
        function multiSelectVarUser(selectObj, inputValues, inputNames, nodeDefinitionId) {
            var icon = addIcons("company.gif,dept.gif,person.gif");
            new PopTree({
                url:CONTEXT_NAME + '/bpmNodeDefinition/nodePersonSelect.do?id=root&icon=' + icon + '&nodeDefinitionId=' + nodeDefinitionId,
                selectObj:selectObj,
                targetId:inputValues,
                check:true,
                targetValueId:inputNames,
                setMultiValues:setMultiValues,
                callback:null
            });
        }
    </script>
</div>