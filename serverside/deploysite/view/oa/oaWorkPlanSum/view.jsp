<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_title">
            <td>
                一周工作安排（${bean.beginDate}~${bean.endDate}）
            </td>
        </tr>
    </table>
    <fieldset class="from_fieldset">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_header">
                <td class="form_border" width="10%">序号</td>
                <td class="form_border" width="20%">责任人</td>
                <td class="form_border">重点工作</td>
                <td class="form_border">工作内容</td>
                <td class="form_border">科室</td>
                <td class="form_border">工作进度</td>
                <td class="form_border">经办人</td>
            </tr>
            <c:forEach items="${oaWorkPlanItems}" var="item" varStatus="st">
                <c:if test="${st.index%2==0}">
                    <tr class="tr_dark"></c:if>
                <c:if test="${st.index%2!=0}">
                    <tr class="tr_light"></c:if>
                <td class="form_content" style="text-align: center">
                        ${item.orderNo}
                </td>
                <td class="form_content">
                        ${item.dutyPerosn}
                </td>
                <td class="form_content">
                        ${item.keyWork}
                </td>
                <td class="form_content">
                        ${item.content}
                </td>
                <td class="form_content" style="text-align: center">
                    <c:choose>
                        <c:when test="${empty bean.id}">
                            ${item.weekPlan.reportDept}
                        </c:when>
                        <c:otherwise>
                            ${item.workPlanItem.weekPlan.reportDept}
                        </c:otherwise>
                    </c:choose>
                </td>
                <td class="form_content">
                        ${item.schedule}
                </td>
                <td class="form_content">
                        ${item.jbr}
                </td>
                </tr>
            </c:forEach>
        </table>
    </fieldset>
    <c:choose>
        <c:when test="${bean.status == STATUS_SUBMIT||bean.status == STATUS_MAIN_PASS||bean.status == STATUS_MAIN_BACK}">
            <fieldset class="form_fieldset">
                <legend class="form_legend">
                    分管领导审核
                </legend>
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 150px">分管领导审核意见：</td>
                        <td class="form_content" colspan="3">
                            <sys:toHtml>${bean.leaderOpinion}</sys:toHtml>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 150px">审核人：</td>
                        <td class="form_content" colspan="3">
                                ${bean.leaderAuditUser}
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 150px">审核时间：</td>
                        <td class="form_content" colspan="3">
                            <fmt:formatDate pattern="yyyy-MM-dd" value="${bean.leaderAuditTime}"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </c:when>
    </c:choose>
    <table cellpadding="5" cellspacing="0" class="form_table">
        <tr class="tr_content">
            <td>
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>

</div>