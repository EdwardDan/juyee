<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr>
            <td colspan="2">
                <fieldset style="width: 90%;margin:0px auto">
                    <legend class="form_legend">申请信息</legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
                            <td class="form_label_right" width="15%">申请部门：</td>
                            <td class="form_content" width="35%">
                                ${bean.applyDept}&nbsp;
                            </td>
                            <td class="form_label_right" width="15%">申请人：</td>
                            <td class="form_content" width="35%">
                                ${bean.applyPerson}&nbsp;
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right">使用车辆日期：</td>
                            <td class="form_content">
                                <fmt:formatDate value="${bean.useDate}" pattern="yyyy-MM-dd"/>
                            </td>
                            <td class="form_label_right">用车起止时间:</td>
                            <td class="form_content">
                                ${bean.useBeginTime}~${bean.useEndTime}
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right">用车人数：</td>
                            <td class="form_content">
                                ${bean.personNum}&nbsp;
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right">用车事由：</td>
                            <td class="form_content">
                                <sys:toHtml>${bean.useReason}</sys:toHtml>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right">目的地：</td>
                            <td class="form_content">
                                ${bean.arrivalPlace}&nbsp;
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </td>
        </tr>
        <tr style="
        <c:if test="${bean.status==STATUS_EDIT||bean.status==STATUS_SUBMIT}">display: none;</c:if> ">
            <td colspan="2">
                <fieldset style="width: 90%;margin:0px auto">
                    <legend class="form_legend">审批信息</legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_dark">
                            <td class="form_label_right" width="15%">审批意见：</td>
                            <td class="form_content">
                                <sys:toHtml>${bean.auditOpinion}</sys:toHtml>
                            </td>
                        </tr>
                        <tr class="tr_light" style=" <c:if test="${bean.status==STATUS_BACK}">display: none;</c:if>">
                            <td class="form_label_right">拟派车牌号：</td>
                            <td class="form_content">
                                ${bean.carNo}&nbsp;
                            </td>
                        </tr>
                        <tr class="tr_dark" style=" <c:if test="${bean.status==STATUS_BACK}">display: none;</c:if>">
                            <td class="form_label_right">是否拟派司机：</td>
                            <td class="form_content">
                                <c:choose><c:when test="${bean.isArrangeDriver}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
                            </td>
                        </tr>
                        <tr class="tr_light" style="<c:if
                                test="${bean.isArrangeDriver==false||bean.status==STATUS_BACK}">display: none</c:if>">
                            <td class="form_label_right" width="15%">拟派司机：</td>
                            <td class="form_content" width="35%">
                                ${bean.driverName}&nbsp;
                            </td>
                            <td class="form_label_right" width="15%">司机电话：</td>
                            <td class="form_content" width="35%">
                                ${bean.driverTel}&nbsp;
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </td>
        </tr>
        <tr class="tr_button">
            <td class="form_border">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>