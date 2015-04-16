<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr height="50">
            <td colspan="6" align="center">
                <span class="net_form_title">
                     虹口建管署${bean.year}年${bean.period}月主要工作完成情况
                </span>
            </td>
        </tr>

        <tr>
            <td>
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_header" width="98%">
                        <td nawrap width="50" align="center">序号</td>
                        <td nawrap width="255" align="center">工作内容</td>
                        <td nawrap width="85" align="center">时间节点</td>
                        <td nawrap width="105" align="center">责任人</td>
                        <td nawrap width="105" align="center">部门</td>
                        <td nawrap width="55" align="center">是否完成</td>
                    </tr>
                    <tr>
                        <td colspan="6" align="center">
                            <fieldset class="form_fieldset" style="width: 98%;margin: 0 auto;display: true;">
                                <legend class="form_legend">月度总结汇总</legend>
                                <table cellpadding="0" cellspacing="0" class="form_table">
                                    <c:forEach items="${mapListZjs}" var="itemZj" varStatus="status">
                                        <c:if test="${not empty itemZj.zj}">
                                            <tr <c:choose>
                                                <c:when test="${status.index%2==0}">class="tr_light"</c:when>
                                                <c:otherwise>class="tr_dark"</c:otherwise>
                                            </c:choose>>
                                                <td nawrap class="form_border" width="50">
                                                        ${itemZj.zj.orderNo}
                                                </td>
                                                <td nawrap class="form_border" align="left" width="255">
                                                    <sys:toHtml>${itemZj.zj.content}</sys:toHtml>
                                                </td>
                                                <td nawrap class="form_border" width="85">
                                                    <fmt:formatDate value="${itemZj.zj.timeNode}"
                                                                    pattern="yyyy-MM-dd"/>
                                                </td>
                                                <td nawrap class="form_border" width="105">
                                                        ${itemZj.zj.reportPerson}
                                                </td>
                                                <td nawrap class="form_border" width="105">
                                                        ${itemZj.zj.reportDept}
                                                </td>
                                                <td nawrap class="form_border" width="55">
                                                    <c:if test="${itemZj.zj.isComplete}">是</c:if>
                                                    <c:if test="${!itemZj.zj.isComplete}">否</c:if>
                                                </td>
                                            </tr>
                                        </c:if>
                                    </c:forEach>
                                </table>
                            </fieldset>
                            <fieldset class="form_fieldset" style="width: 98%;margin: 0 auto;display: true;">
                                <legend class="form_legend">月度计划汇总</legend>
                                <table cellpadding="0" cellspacing="0" class="form_table">
                                    <c:forEach items="${mapListJhs}" var="itemJh" varStatus="status">
                                        <c:if test="${not empty itemJh.jh}">
                                            <tr <c:choose>
                                                <c:when test="${status.index%2==0}">class="tr_light"</c:when>
                                                <c:otherwise>class="tr_dark"</c:otherwise>
                                            </c:choose>>
                                                <td nawrap class="form_border" width="50">
                                                        ${itemJh.jh.orderNo}
                                                </td>
                                                <td nawrap class="form_border" align="left" width="255">
                                                    <sys:toHtml>${itemJh.jh.content}</sys:toHtml>
                                                </td>
                                                <td nawrap class="form_border" width="85">
                                                    <fmt:formatDate value="${itemJh.jh.timeNode}"
                                                                    pattern="yyyy-MM-dd"/>
                                                </td>
                                                <td nawrap class="form_border" width="105">
                                                        ${itemJh.jh.reportPerson}
                                                </td>
                                                <td nawrap class="form_border" width="105">
                                                        ${itemJh.jh.reportDept}
                                                </td>
                                                <td nawrap class="form_border" width="55">
                                                    <c:if test="${itemJh.jh.isComplete}">是</c:if>
                                                    <c:if test="${!itemJh.jh.isComplete}">否</c:if>
                                                </td>
                                            </tr>
                                        </c:if>
                                    </c:forEach>
                                </table>
                            </fieldset>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>

        <tr style="<c:if test="${empty bean.leaderAuditTime}">display: none;</c:if>">
            <td colspan="6">
                <fieldset class="form_fieldset" style="width: 98%;margin: 0 auto;display: true;">
                    <legend class="form_legend">领导审核</legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
                            <td class="form_label_right" width="15%">领导审核意见：</td>
                            <td class="form_content" height="100">
                                <sys:toHtml>${bean.leaderOpinion}</sys:toHtml>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </td>
        </tr>
        <tr class="tr_button" align="center">
            <td class="form_border" colspan="6">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>
