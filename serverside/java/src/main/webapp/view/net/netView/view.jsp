<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<link rel="stylesheet" type="text/css" href="${themePath}/main.css"/>
<script src="${ctx}/js/jquery/jquery-1.7.1.js" type="text/javascript"></script>
<script src="${ctx}/js/jquery/ui/jquery-ui-1.8.17.min.js" type="text/javascript"></script>

<script type="text/javascript">
    $(function () {
        $("#tabCons").tabs();
        $("#tabCfbs").tabs();
    });
</script>

<div class="form_div">

<table cellpadding="0" cellspacing="0" class="form_table">
<div class="form_fieldset_space"></div>
<tr>
    <td>
        <%--项目报建--%>
        <fieldset class="form_fieldset" <c:if test="${fn:length(listApply)==0}">style="display: none" </c:if>>
            <legend>${stepApplyName}</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_dark">
                    <td class="form_border" align="left">&nbsp;${stepApplyName}</td>
                </tr>
                <tr>
                    <td>
                        <c:forEach items="${listApply}" var="itemApply">
                            <table cellpadding="0" cellspacing="0" class="form_table">
                                <tr class="tr_header">
                                    <td class="form_border" width="25%">受理环节</td>
                                    <td class="form_border" width="20%">受理意见</td>
                                    <td class="form_border" width="15%">操作人</td>
                                    <td class="form_border" width="20%">受理日期</td>
                                    <td class="form_border" width="40%">退回原因</td>
                                </tr>
                                <c:forEach items="${itemApply.logs}" var="logApply">
                                    <tr class="tr_light">
                                        <td class="form_border">${logApply.acceptStatus.acceptStep.name}</td>
                                        <td class="form_border">${logApply.acceptStatus.name}</td>
                                        <td class="form_border">${logApply.opPerson}</td>
                                        <td class="form_border">
                                            <fmt:formatDate value="${logApply.acceptDate}" pattern="yyyy-MM-dd"/>
                                        </td>
                                        <td class="form_border">
                                            <sys:toHtml>${logApply.backCause}</sys:toHtml>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:forEach>
                    </td>
                </tr>
            </table>
        </fieldset>
        <c:if test="${fn:length(listApply)!=0}">
            <div class="form_fieldset_space"></div>
        </c:if>
    </td>
</tr>

<tr>
    <td>
        <%--项目承发包（公开招标）--%>
        <fieldset class="form_fieldset" <c:if test="${fn:length(listCfb)==0}">style="display: none;" </c:if>>
            <legend>${stepCfbName}</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr>
                    <td>
                        <div id="tabCfbs" style="width: 690px;" class="easyui-tabs1">
                            <ul>
                                <c:forEach items="${listCfbCode}" var="item" varStatus="status">
                                    <li><a href="#tabCfbs-${status.index + 1}">${item.name}</a></li>
                                </c:forEach>
                            </ul>
                            <c:forEach items="${listMapCfb}" var="item" varStatus="status">
                                <div id="tabCfbs-${status.index + 1}">
                                    <table cellpadding="0" cellspacing="0" class="form_table">
                                        <tr class="tr_light">
                                            <td class="form_border" align="left" colspan="5">
                                                &nbsp;标段号：${item.value.bdhCfb}
                                            </td>
                                        </tr>
                                        <tr class="tr_dark">
                                            <td class="form_border" align="left" colspan="5">
                                                &nbsp;${item.value.stepCfbName}
                                            </td>
                                        </tr>
                                    </table>
                                    <c:forEach items="${listCfb[item.key]}" var="item1" varStatus="status">
                                        <c:forEach items="${item1}" var="item2" end="0">
                                            <table cellpadding="0" cellspacing="0" class="form_table"
                                                   style="width: 670px;">
                                                <tr class="tr_header">
                                                    <td class="form_border" width="25%">受理环节</td>
                                                    <td class="form_border" width="20%">受理意见</td>
                                                    <td class="form_border" width="15%">操作人</td>
                                                    <td class="form_border" width="20%">受理日期</td>
                                                    <td class="form_border" width="40%">退回原因</td>
                                                </tr>
                                                <c:forEach items="${item2.value}" var="logCfb">
                                                    <tr class="tr_light">
                                                        <td class="form_border">${logCfb.acceptStatus.acceptStep.name}</td>
                                                        <td class="form_border">${logCfb.acceptStatus.name}</td>
                                                        <td class="form_border">${logCfb.opPerson}</td>
                                                        <td class="form_border">
                                                            <fmt:formatDate value="${logCfb.acceptDate}"
                                                                            pattern="yyyy-MM-dd"/>
                                                        </td>
                                                        <td class="form_border">
                                                            <sys:toHtml>${logCfb.backCause}</sys:toHtml>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </table>
                                        </c:forEach>
                                    </c:forEach>
                                </div>
                            </c:forEach>
                            <c:if test="${cfbSize1>cfbSize2}">
                                <div id="tabCfbs-1"></div>
                                <div id="tabCfbs-2"></div>
                                <div id="tabCfbs-3"></div>
                                <div id="tabCfbs-4"></div>
                            </c:if>
                        </div>
                    </td>
                </tr>
            </table>
        </fieldset>
        <c:if test="${fn:length(listCfb)!=0}">
            <div class="form_fieldset_space"></div>
        </c:if>
    </td>
</tr>

<tr>
    <td>
        <%--项目承发包（直接发包） --%>
        <fieldset class="form_fieldset" <c:if test="${fn:length(listCfbZj)==0}">style="display: none;" </c:if>>
            <legend>${stepCfbZjName}</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_border" align="left">&nbsp;标段号：${bdhCfbZj}</td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_border" align="left">&nbsp;${stepCfbZjName}</td>
                </tr>
                <tr>
                    <td>
                        <c:forEach items="${listCfbZj}" var="itemCfbZj">
                            <table cellpadding="0" cellspacing="0" class="form_table">
                                <tr class="tr_header">
                                    <td class="form_border" width="25%">受理环节</td>
                                    <td class="form_border" width="20%">受理意见</td>
                                    <td class="form_border" width="15%">操作人</td>
                                    <td class="form_border" width="20%">受理日期</td>
                                    <td class="form_border" width="40%">退回原因</td>
                                </tr>
                                <c:forEach items="${itemCfbZj.logs}" var="logCfbZj">
                                    <tr class="tr_light">
                                        <td class="form_border">${logCfbZj.acceptStatus.acceptStep.name}</td>
                                        <td class="form_border">${logCfbZj.acceptStatus.name}</td>
                                        <td class="form_border">${logCfbZj.opPerson}</td>
                                        <td class="form_border">
                                            <fmt:formatDate value="${logCfbZj.acceptDate}" pattern="yyyy-MM-dd"/>
                                        </td>
                                        <td class="form_border">
                                            <sys:toHtml>${logCfbZj.backCause}</sys:toHtml>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:forEach>
                    </td>
                </tr>
            </table>
        </fieldset>
        <c:if test="${fn:length(listCfbZj)!=0}">
            <div class="form_fieldset_space"></div>
        </c:if>

    </td>
</tr>

<tr>
    <td align="center">
        <%--标段号(合同备案)--%>
        <fieldset class="form_fieldset" <c:if test="${fn:length(listContract)==0}">style="display: none;" </c:if>>
            <legend>${stepContractName}</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr>
                    <td>
                        <div id="tabCons" style="width: 690px;" class="easyui-tabs1">
                            <ul>
                                <c:forEach items="${listCon}" var="item" varStatus="status">
                                    <li><a href="#tabCons-${status.index + 1}">${item.name}</a></li>
                                </c:forEach>
                            </ul>
                            <c:forEach items="${listMapCon}" var="item" varStatus="status">
                                <div id="tabCons-${status.index + 1}">
                                    <table cellpadding="0" cellspacing="0" class="form_table">
                                        <tr class="tr_light">
                                            <td class="form_border" align="left" colspan="5">
                                                &nbsp;标段号：${item.value.bdhContract}
                                            </td>
                                        </tr>
                                        <tr class="tr_dark">
                                            <td class="form_border" align="left" colspan="5">
                                                &nbsp;${item.value.stepContractName}
                                            </td>
                                        </tr>
                                    </table>
                                    <c:forEach items="${listContract[item.key]}" var="item1" varStatus="status">
                                        <c:forEach items="${item1}" var="item2" end="0">
                                            <table cellpadding="0" cellspacing="0" class="form_table"
                                                   style="width: 670px;">
                                                <tr class="tr_header">
                                                    <td class="form_border" width="25%">受理环节</td>
                                                    <td class="form_border" width="20%">受理意见</td>
                                                    <td class="form_border" width="15%">操作人</td>
                                                    <td class="form_border" width="20%">受理日期</td>
                                                    <td class="form_border" width="40%">退回原因</td>
                                                </tr>
                                                <c:forEach items="${item2.value}" var="logContract">
                                                    <tr class="tr_light">
                                                        <td class="form_border">${logContract.acceptStatus.acceptStep.name}</td>
                                                        <td class="form_border">${logContract.acceptStatus.name}</td>
                                                        <td class="form_border">${logContract.opPerson}</td>
                                                        <td class="form_border">
                                                            <fmt:formatDate value="${logContract.acceptDate}"
                                                                            pattern="yyyy-MM-dd"/>
                                                        </td>
                                                        <td class="form_border">
                                                            <sys:toHtml>${logContract.backCause}</sys:toHtml>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </table>
                                        </c:forEach>
                                    </c:forEach>
                                </div>
                            </c:forEach>
                            <c:if test="${conSize1>conSize2}">
                                <div id="tabCons-1"></div>
                                <div id="tabCons-2"></div>
                                <div id="tabCons-3"></div>
                                <div id="tabCons-4"></div>
                            </c:if>
                        </div>
                    </td>
                </tr>
            </table>
        </fieldset>
        <c:if test="${fn:length(listContract)!=0}">
            <div class="form_fieldset_space"></div>
        </c:if>
    </td>
</tr>

<tr>
    <td>
        <%--项目报监--%>
        <fieldset class="form_fieldset" <c:if test="${fn:length(listMonitor)==0}">style="display: none" </c:if>>
            <legend>${stepMonitorName}</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_border" align="left">&nbsp;标段号：${bdhMonitor}</td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_border" align="left">&nbsp;${stepMonitorName}</td>
                </tr>
                <tr>
                    <td>
                        <c:forEach items="${listMonitor}" var="itemMonitor">
                            <table cellpadding="0" cellspacing="0" class="form_table">
                                <tr class="tr_header">
                                    <td class="form_border" width="25%">受理环节</td>
                                    <td class="form_border" width="20%">受理意见</td>
                                    <td class="form_border" width="15%">操作人</td>
                                    <td class="form_border" width="20%">受理日期</td>
                                    <td class="form_border" width="40%">退回原因</td>
                                </tr>
                                <c:forEach items="${itemMonitor.logs}" var="logMonitor">
                                    <tr class="tr_light">
                                        <td class="form_border">${logMonitor.acceptStatus.acceptStep.name}</td>
                                        <td class="form_border">${logMonitor.acceptStatus.name}</td>
                                        <td class="form_border">${logMonitor.opPerson}</td>
                                        <td class="form_border">
                                            <fmt:formatDate value="${logMonitor.acceptDate}" pattern="yyyy-MM-dd"/>
                                        </td>
                                        <td class="form_border">
                                            <sys:toHtml>${logMonitor.backCause}</sys:toHtml>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>

                        </c:forEach>
                    </td>
                </tr>
            </table>
        </fieldset>
        <c:if test="${fn:length(listMonitor)!=0}">
            <div class="form_fieldset_space"></div>
        </c:if>
    </td>
</tr>

<tr>
    <td>
        <%--标段号(施工许可)--%>
        <fieldset class="form_fieldset" <c:if test="${fn:length(listSg)==0}">style="display: none;" </c:if>>
            <legend>${stepSgName}</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_border" align="left">&nbsp;标段号：${bdhSg}</td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_border" align="left">&nbsp;${stepSgName}</td>
                </tr>
                <tr>
                    <td>
                        <c:forEach items="${listSg}" var="itemSg">
                            <table cellpadding="0" cellspacing="0" class="form_table">
                                <tr class="tr_header">
                                    <td class="form_border" width="25%">受理环节</td>
                                    <td class="form_border" width="20%">受理意见</td>
                                    <td class="form_border" width="15%">操作人</td>
                                    <td class="form_border" width="20%">受理日期</td>
                                    <td class="form_border" width="40%">退回原因</td>
                                </tr>
                                <c:forEach items="${itemSg.logs}" var="logSg">
                                    <tr class="tr_light">
                                        <td class="form_border">${logSg.acceptStatus.acceptStep.name}</td>
                                        <td class="form_border">${logSg.acceptStatus.name}</td>
                                        <td class="form_border">${logSg.opPerson}</td>
                                        <td class="form_border">
                                            <fmt:formatDate value="${logSg.acceptDate}" pattern="yyyy-MM-dd"/>
                                        </td>
                                        <td class="form_border">
                                            <sys:toHtml>${logSg.backCause}</sys:toHtml>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>

                        </c:forEach>
                    </td>
                </tr>
            </table>
        </fieldset>
        <c:if test="${fn:length(listSg)!=0}">
            <div class="form_fieldset_space"></div>
        </c:if>
    </td>
</tr>

<tr class="tr_button">
    <td class="form_border" align="center">
        <input type="button" value="关闭" class="button_cancel" onclick="parent.closeWindow()">
    </td>
</tr>
</table>
</div>