<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr>
            <td>
                <fieldset class="form_fieldset" style="width: 90%;margin: 0 auto;display: true;">
                    <legend class="form_legend">请假申请</legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">

                        <tr class="tr_dark">
                            <td class="form_label_right" width="20%">申请人：</td>
                            <td class="form_content" width="30%">
                                ${bean.reportPerson}
                            </td>
                            <td class="form_label_right" width="20%">申请部门：</td>
                            <td class="form_content" width="30%">
                                ${bean.reportDept}
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right" width="20%">岗位：</td>
                            <td class="form_content" width="30%">
                                ${bean.duty}
                            </td>
                            <td class="form_label_right">申请时间：</td>
                            <td class="form_content">
                                <fmt:formatDate value="${bean.reportDate}" pattern="yyyy-MM-dd"/>
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right">请假起始时间：</td>
                            <td class="form_content">
                                ${bean.durationTime}
                            </td>
                            <td class="form_label_right">请假天数：</td>
                            <td class="form_content">
                                ${bean.dayCount}
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right" width="20%"><span style="color: red;">通知食堂</span>：</td>
                            <td class="form_content" colspan="3">
                                <c:if test="${bean.isSendSms}"><input type="checkbox" checked disabled></c:if><c:if test="${!bean.isSendSms}"><input type="checkbox" disabled></c:if>  短 信 内 容 ：${bean.smsContent}
                            </td>
                        </tr>
                        <tr class="tr_light" height="100">
                            <td class="form_label_right" width="20%">请假事由：</td>
                            <td class="form_content" colspan="3">
                                <sys:toHtml> ${bean.cause}</sys:toHtml>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </td>
        </tr>
        <tr style="<c:if test="${bean.leaderAuditTime==null}">display: none;</c:if>">
            <td>
                <fieldset class="form_fieldset" style="width: 90%;margin: 0 auto;display: true;">
                    <legend class="form_legend">领导审核</legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_dark" height="100">
                            <td class="form_label_right" width="20%">审核意见：</td>
                            <td class="form_content">&nbsp;
                                <sys:toHtml>${bean.leaderOpinion}</sys:toHtml>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right">审核时间：</td>
                            <td class="form_content">&nbsp;
                                <fmt:formatDate value="${bean.leaderAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </td>
        </tr>
        <tr class="tr_button">
            <td class="form_border" align="center" colspan="4">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>