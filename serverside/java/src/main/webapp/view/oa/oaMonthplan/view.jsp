<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr>
            <td>
                <fieldset class="form_fieldset" style="width: 90%;margin: 0 auto;display: true;">
                    <legend class="form_legend">月度总结和计划</legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
                            <td class="form_label_right">提交部门：</td>
                            <td class="form_content">&nbsp;
                                ${bean.reportDept}                    </td>

                            <td class="form_label_right">责任人：</td>
                            <td class="form_content">&nbsp;
                                ${bean.reportPerson}                    </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right">报告年份：</td>
                            <td class="form_content" colspan="4">&nbsp;
                                ${bean.year} 年 ${bean.period} 月
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4">

                                <table cellpadding="0" cellspacing="0" width="100%" align="center">
                                    <tr class="tr_header">
                                        <td class="form_td_line" width="40" nowrap>序号</td>
                                        <td class="form_td_line" width="155" nowrap>工作内容</td>
                                        <td class="form_td_line" width="155" nowrap>时间节点</td>
                                        <td class="form_td_line" width="155" nowrap>报告类型</td>
                                        <td class="form_td_line" width="155" nowrap>是否完成</td>
                                    </tr>
                                </table>

                            </td>
                        </tr>
                        <tr>
                            <td colspan="4">
                                <fieldset class="form_fieldset" style="width:98%;margin: 0 auto;display: true;">
                                    <legend class="form_legend">月度总结</legend>
                                    <table id="table1" cellpadding="0" cellspacing="0" width="100%" align="center">
                                        <c:forEach items="${bean.oaMonthplanItems}" var="item" varStatus="status">
                                            <c:if test="${item.reportType=='总结'}">
                                                <tr class="tr_dark">
                                                    <td align="center" class="form_td_line" width="40"
                                                        nowrap>${status.index+1}</td>
                                                    <td align="left" class="form_td_line" width="155">
                                                        <sys:toHtml>${item.content}</sys:toHtml></td>
                                                    <td align="center" class="form_td_line" width="155"
                                                        nowrap>${item.timeNode}</td>
                                                    <td align="center" class="form_td_line" width="155"
                                                        nowrap>${item.reportType}</td>
                                                    <td align="center" class="form_td_line" width="155" nowrap>
                                                        <c:if test="${item.isComplete==false}">否</c:if><c:if
                                                            test="${item.isComplete==true}">是</c:if>
                                                    </td>
                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </table>
                                </fieldset>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4">
                                <fieldset class="form_fieldset" style="width:98%;margin: 0 auto;display: true;">
                                    <legend class="form_legend">月度计划</legend>
                                    <table id="table2" cellpadding="0" cellspacing="0" width="100%" align="center">

                                        <c:forEach items="${bean.oaMonthplanItems}" var="item" varStatus="status">
                                            <c:if test="${item.reportType=='计划'}">
                                                <tr class="tr_dark">
                                                    <td align="center" class="form_td_line" width="40"
                                                        nowrap>${status.index+1}</td>
                                                    <td align="left" class="form_td_line" width="155">
                                                        <sys:toHtml>${item.content}</sys:toHtml></td>
                                                    <td align="center" class="form_td_line" width="155"
                                                        nowrap>${item.timeNode}</td>
                                                    <td align="center" class="form_td_line" width="155"
                                                        nowrap>${item.reportType}</td>
                                                    <td align="center" class="form_td_line" width="155" nowrap>
                                                        <c:if test="${item.isComplete==false}">否</c:if><c:if
                                                            test="${item.isComplete==true}">是</c:if>
                                                    </td>
                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </table>
                                </fieldset>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </td>
        </tr>
        <tr style="<c:if test="${bean.fgAuditTime==null}">display: none;</c:if>">
            <td>
                <fieldset class="form_fieldset" style="width: 90%;margin: 0 auto;display: true;">
                    <legend class="form_legend">分管领导审核</legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_dark" height="100">
                            <td class="form_label_right" width="20%">分管领导审核意见：</td>
                            <td class="form_content">&nbsp;
                                <sys:toHtml> ${bean.fgOpinion}</sys:toHtml>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right">分管领导审核时间：</td>
                            <td class="form_content">&nbsp;
                                <fmt:formatDate value="${bean.fgAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </td>
        </tr>
        <tr class="tr_button">
            <td class="form_border" align="center" colspan="4">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()"></td>


        </tr>
    </table>
</div>