<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <fieldset class="form_fieldset">
        <legend class="form_legend">
            车辆申请信息
        </legend>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right" width="15%">申请部门：</td>
                <td class="form_content">
                    ${bean.applyDept.name}
                </td>
                <td class="form_label_right" width="15%">申请人：</td>
                <td class="form_content" width="35%">
                    ${bean.applyUser.displayName}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" width="15%">使用车辆日期：</td>
                <td class="form_content" width="35%">
                    <fmt:formatDate value="${bean.beginTime}" pattern="yyyy-MM-dd"/>
                </td>
                <td class="form_label_right" width="15%">用车起止时间：</td>
                <td class="form_content" width="35%">
                    &nbsp;${startHour} 时 ${startMinute} 分~ ${endHour} 时 ${endMinute} 分

                    <input type="hidden" name="beginTime" id="beginTime" class="input_date" value=""/>
                    <input type="hidden" name="endTime" id="endTime" class="input_date" value=""/>

                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" width="15%">用车人数：</td>
                <td class="form_content" colspan="3">
                    ${bean.personNum}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" width="15%">用车事由：</td>
                <td class="form_content" style="height: 50px" colspan="3">
                    <sys:toHtml>${bean.useCause}</sys:toHtml>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" width="15%">目的地：</td>
                <td class="form_content" colspan="3">
                    ${bean.address}
                </td>
            </tr>
        </table>
    </fieldset>
    <c:if test="${bean.status>=STATUS_BRANCH_PASS}">
        <fieldset class="form_fieldset">
            <legend class="form_legend">
                科长审核
            </legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_dark">
                    <td class="form_label_right" width="15%">科长审核意见：</td>
                    <td class="form_content" height="50px">
                        <sys:toHtml> ${bean.kzAuditOpinion}</sys:toHtml>
                    </td>
                </tr>
            </table>
        </fieldset>
    </c:if>
    <c:if test="${bean.status>=STATUS_MAIN_PASS}">
        <fieldset class="form_fieldset">
            <legend class="form_legend">
                办公室主任审核
            </legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label_right" width="15%" height="50px" nowrap>办公室主任审核意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.zrAuditOpinion}</sys:toHtml>
                    </td>
                </tr>
            </table>
        </fieldset>
    </c:if>
    <c:if test="${bean.status>STATUS_CAR_SCHEDULE}">
        <fieldset class="form_fieldset">
            <legend class="form_legend">
                车辆调度
            </legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_dark">
                    <td class="form_label_right" width="15%">拟派车辆：</td>
                    <td class="form_content" colspan="3">
                            ${bean.car.name}
                            <%--<select id="car" name="car" disabled class="input_text">--%>
                            <%--<option value="" selected></option>--%>
                            <%--<c:forEach var="carIn" items="${carList}">--%>
                            <%--<option value="${carIn.id}" <c:if--%>
                            <%--test="${bean.car.id==carIn.id}">selected </c:if>>${carIn.name}</option>--%>
                            <%--</c:forEach>--%>
                            <%--</select>--%>
                    </td>
                </tr>
                <tr id="agreeDriver" class="tr_light">
                    <td class="form_label_right" width="15%">司机：</td>
                    <td class="form_content" width="35%">
                            ${bean.driverPerson.name}
                    </td>
                    <td class="form_label_right" width="15%">电话：</td>
                    <td class="form_content" width="35%">
                            ${bean.driverMobile}
                    </td>
                </tr>
            </table>
        </fieldset>
    </c:if>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_button">
            <td style="text-align: center" colspan="4">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>