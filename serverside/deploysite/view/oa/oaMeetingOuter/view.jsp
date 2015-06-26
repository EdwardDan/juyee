<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<form:form commandName="bean">

    <div class="form_div">
        <fieldset class="form_fieldset">
            <legend class="form_legend">
                外出会议
            </legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label_right" style="width: 150px">会议时间：</td>
                    <td class="form_content" colspan="3">
                        ${bean.meetTime}
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">会议地点：</td>
                    <td class="form_content" colspan="3">
                        ${bean.address}
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" style="width: 20%">主持人：</td>
                    <td class="form_content" style="width: 30%">       ${bean.chargePerson}
                    </td>

                    <td class="form_label_right" style="width: 20%" >发起单位：</td>
                    <td class="form_content">     ${bean.startDept}
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">会议领导：</td>
                    <td class="form_content" colspan="3">     ${bean.leader}
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">与会单位：</td>
                    <td class="form_content" colspan="3">    <sys:toHtml>${bean.innerPersons}</sys:toHtml>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">会议名称：</td>
                    <td class="form_content" colspan="3">      <sys:toHtml>${bean.title}</sys:toHtml>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">会议内容：</td>
                    <td class="form_content" colspan="3">   <sys:toHtml>${bean.content}</sys:toHtml>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">与中心相关事宜：</td>
                    <td class="form_content" colspan="3">    <sys:toHtml>${bean.relateMatter}</sys:toHtml>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">工作建议：</td>
                    <td class="form_content" colspan="3"> <sys:toHtml>${bean.workAdvise}</sys:toHtml>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">附件：</td>
                    <td class="form_content" colspan="3">
                            ${docButton}
                    </td>
                </tr>
            </table>
        </fieldset>
        <c:choose>
            <c:when test="${bean.status == STATUS_SUBMIT||bean.status == STATUS_BRANCH_PASS||bean.status == STATUS_MAIN_PASS||bean.status == STATUS_BRANCH_BACK||bean.status == STATUS_MAIN_BACK}">
                <fieldset class="form_fieldset">
                    <legend class="form_legend">
                        分管领导审核
                    </legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
                            <td class="form_label_right" style="width: 150px">分管领导审核意见：</td>
                            <td class="form_content" colspan="3">
                                <sys:toHtml>${bean.fgAuditOpinion}</sys:toHtml>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right" style="width: 150px">审核人：</td>
                            <td class="form_content" colspan="3">
                                    ${bean.fgAuditUser.displayName}
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right" style="width: 150px">审核时间：</td>
                            <td class="form_content" colspan="3">
                                <fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${bean.fgAuditTime}"/>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </c:when>
            <c:otherwise>
                <form:hidden path="fgAuditOpinion"/>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${bean.status == STATUS_BRANCH_PASS||bean.status == STATUS_MAIN_BACK||bean.status == STATUS_MAIN_PASS}">
                <fieldset class="form_fieldset">
                    <legend class="form_legend">
                        主任审核批示
                    </legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
                            <td class="form_label_right" style="width: 150px">主任审核意见：</td>
                            <td class="form_content" colspan="3">
                                <sys:toHtml>${bean.zrAuditOpinion}</sys:toHtml>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right" style="width: 150px">审核人：</td>
                            <td class="form_content" colspan="3">
                                <sys:toHtml>${bean.zrAuditUser.displayName}</sys:toHtml>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right" style="width: 150px">审核时间：</td>
                            <td class="form_content" colspan="3">
                                <fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${bean.zrAuditTime}"/>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </c:when>
            <c:otherwise>
                <form:hidden path="zrAuditOpinion"/>
            </c:otherwise>
        </c:choose>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_button">
                <td class="form_content" style="text-align: center">
                    <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>