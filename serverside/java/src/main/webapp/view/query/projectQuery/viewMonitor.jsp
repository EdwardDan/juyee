<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function viewOrderForm(id) {
        var url = "${ctx}/orderForm/view.do?id=" + id + "&justView=justView";
        var windowId = "newWinIdd";
        openNewWindow(windowId, "查看监督预约", url, false, 900, 525);
    }
    function viewJdRecordDetail(id,jdTypeCode){
        if(jdTypeCode=="first"){
            var url ="${ctx}/jdRecordFirst/view.do?id=" + id + "&action=view";
        }else if(jdTypeCode=="safe"){
            var url="${ctx}/jdRecordSafe/view.do?id=" + id + "&action=view";
        }else if(jdTypeCode=="quality"){
            var url="${ctx}/jdRecordQuality/view.do?id=" + id + "&action=view";
        }else if(jdTypeCode=="complete"){
            var url="${ctx}/jdRecordComplete/view.do?id=" + id + "&action=view";
        }
        var windowId = "newWinId";
        openNewWindow(windowId, "查看监督记录单", url, false, 900, 525);
    }
</script>
<div class="form_div" align="center">
    <div align="center" class="tr_dark">
        <fieldset class="form_fieldset" style="width: 93%">
            <legend class="form_legend">监督记录</legend>
            <div class="form_table" align="center">
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_header">
                        <td class="form_border" width="5%" nowrap>序号</td>
                        <td class="form_border" width="15%" nowrap>监督记录编号</td>
                        <td class="form_border" width="15%" nowrap>监督人员</td>
                        <td class="form_border" width="15%" nowrap>监督类别</td>
                        <td class="form_border" width="10%" nowrap>监督记录附件</td>
                        <td class="form_border" width="10%" nowrap>问题整改单</td>
                        <td class="form_border" width="10%" nowrap>暂缓施工指令</td>
                        <td class="form_border" width="10%" nowrap>停工指令</td>
                        <td class="form_border" width="10%" nowrap>监督日期</td>
                    </tr>
                    <c:forEach items="${list}" var="item" varStatus="status">
                        <tr class="tr_light">
                            <td class="form_border">&nbsp;${status.index+1}</td>
                            <td class="form_border">&nbsp;<a href="javascript:void(0)" title="查看监督记录"
                                                             onclick="viewJdRecordDetail(${item.id},'${item.jdTypeCode}')"
                                                             class="page_link">${item.code}</a></td>
                            <td class="form_border">&nbsp;${item.jdManagerName}</td>
                            <td class="form_border">&nbsp;${item.jdType}</td>
                            <td class="form_border">&nbsp;${item.doc}</td>
                            <td class="form_border">&nbsp;${item.jdStopReform}</td>
                            <td class="form_border">&nbsp;${item.jdStopSuspend}</td>
                            <td class="form_border">&nbsp;${item.jdStopStop}</td>
                            <td class="form_border">&nbsp;<fmt:formatDate value="${item.jdDateTime}"
                                                                          type="date"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </fieldset>
        <fieldset class="form_fieldset" style="width: 93%">
            <legend class="form_legend">监督预约</legend>
            <div class="form_table">
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_header">
                        <td class="form_border" width="10%" nowrap>预约单号</td>
                        <td class="form_border" width="10%" nowrap>流转编号</td>
                        <td class="form_border" width="20%" nowrap>工程名称</td>
                        <%--<td class="form_border" width="10%" nowrap>预约日期</td>--%>
                        <td class="form_border" width="10%" nowrap>监督组</td>
                        <%--<td class="form_border" width="10%" nowrap>受理日期</td>--%>
                        <td class="form_border" width="10%" nowrap>受理意见</td>
                        <td class="form_border" width="10%" nowrap>状态</td>
                        <td class="form_border" width="10%" nowrap>附件</td>
                        <td class="form_border" width="10%" nowrap>受理日期</td>
                        <td class="form_border" width="10%" nowrap>预约日期</td>
                    </tr>
                    <c:forEach items="${list1}" var="item" varStatus="status">
                        <tr class="tr_light">
                            <td class="form_border">&nbsp;
                                <a href="javascript:void(0)" title="查看监督记录"
                                   onclick="viewOrderForm(${item.orderFormId})"
                                   class="page_link">${item.orderCode}</a>
                            </td>
                            <td class="form_border">&nbsp;${item.jdTaskCode}</td>
                            <td class="form_border">&nbsp;${item.projectName}</td>
                                <%--<td class="form_border">&nbsp;<fmt:formatDate value="${item.orderDatetime}"--%>
                                <%--type="date"/></td>--%>
                            <td class="form_border">&nbsp;${item.workGroup}</td>
                                <%--<td class="form_border">&nbsp;<fmt:formatDate value="${item.acceptDatetime}"--%>
                                <%--type="date"/></td>--%>
                            <td class="form_border">&nbsp;${item.acceptOpinion}</td>
                            <td class="form_border">&nbsp;${item.orderStatus}</td>
                            <td class="form_border">&nbsp;${item.doc}</td>
                            <td class="form_border">&nbsp;<fmt:formatDate value="${item.acceptDatetime}"
                                                                          type="date"/></td>
                            <td class="form_border">&nbsp;<fmt:formatDate value="${item.orderDatetime}"
                                                                          type="date"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </fieldset>
        <c:if test="${!siteUser}">
            <fieldset class="form_fieldset" style="width: 93%;">
                <legend class="form_legend">计划详情</legend>
                <div class="form_table">
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_header">
                            <%--<td width="10%" nowrap class="form_border">流转编号</td>--%>
                            <td width="12%" nowrap class="form_border">报建编号</td>
                            <td width="12%" nowrap class="form_border">监督任务编号</td>
                            <td width="30%" nowrap class="form_border">项目名称</td>
                            <td width="10%" nowrap class="form_border">监督组</td>
                            <td width="10%" nowrap class="form_border">报监日期</td>
                            <td width="10%" nowrap class="form_border">计划完成日期</td>
                        </tr>
                        <c:forEach items="${list2}" var="item" varStatus="status">
                            <tr class="tr_light">
                                <%--<td class="form_border">&nbsp;${item.jdTaskCode}</td>--%>
                                <td class="form_border">&nbsp;${item.bjbh}</td>
                                <td class="form_border">&nbsp;${item.jdrwsbh}</td>
                                <td class="form_border">&nbsp;${item.projectName}</td>
                                <td class="form_border">&nbsp;${item.planDetail.group.name}</td>
                                <td class="form_border">&nbsp;<fmt:formatDate value="${item.jdDatetime}"
                                                                              pattern="yyyy-MM-dd"/></td>
                                <td class="form_border">&nbsp;<fmt:formatDate value="${item.planDetail.planEndTime}"
                                                                              pattern="yyyy-MM-dd"/></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </fieldset>

            <fieldset class="form_fieldset" style="width: 93%;">
                <legend class="form_legend">招投标监管记录</legend>
                <div class="form_table">
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_header">
                            <td width="10%" nowrap class="form_border">流水号</td>
                            <td width="15%" nowrap class="form_border">监管类型</td>
                            <td width="10%" nowrap class="form_border">标段号</td>
                            <td width="10%" nowrap class="form_border">经办人</td>
                            <td width="10%" nowrap class="form_border">复核人</td>
                            <td width="10%" nowrap class="form_border">记录日期</td>
                            <td width="10%" nowrap class="form_border">状态</td>
                        </tr>
                        <c:forEach items="${bidRecordList}" var="item" varStatus="status">
                            <tr class="tr_light">
                                <td class="form_border">&nbsp;<a href="javascript:void(0)" onclick="openNewWindow('bidRecordWin','招投标监督记录', '${ctx}/scjgBidRecord/view.do?id=${item.id}', false, 900, 600)" class="page_link" title="查看详细">${item.code}</a></td>
                                <td class="form_border">&nbsp;${item.jdStage.name}</td>
                                <td class="form_border">&nbsp;${item.bdh}</td>
                                <td class="form_border">&nbsp;${item.jbr}</td>
                                <td class="form_border">&nbsp;${item.fhr}</td>
                                <td class="form_border">&nbsp;<fmt:formatDate value="${item.fillDate}" pattern="yyyy-MM-dd"/></td>
                                <td class="form_border">&nbsp;${item.dealOpinion}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </fieldset>
        </c:if>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_button">
                <td class="form_td_line" colspan="9">
                    <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</div>