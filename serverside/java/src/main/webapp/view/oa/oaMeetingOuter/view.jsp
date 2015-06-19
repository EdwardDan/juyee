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
                    <td class="form_border" style="width: 150px">会议时间：</td>
                    <td class="form_content" colspan="3">
                        <fmt:formatDate value="${bean.beginTime}" pattern="yyyy-MM-dd HH:mm"/>
                        ~
                        <fmt:formatDate value="${bean.endTime}" pattern="yyyy-MM-dd HH:mm"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_border">会议地点：</td>
                    <td class="form_content" colspan="3">
                        ${bean.address}
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_border">主持人：</td>
                    <td class="form_content">       ${bean.chargePerson}
                    </td>

                    <td class="form_border">发起单位：</td>
                    <td class="form_content">     ${bean.startDept}
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_border">会议领导：</td>
                    <td class="form_content" colspan="3">     ${bean.leader}
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_border">与会单位：</td>
                    <td class="form_content" colspan="3">     ${bean.innerPersons}
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_border">会议名称：</td>
                    <td class="form_content" colspan="3">     ${bean.title}
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_border">会议内容：</td>
                    <td class="form_content" colspan="3">   ${bean.content}
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_border">与中心相关事宜：</td>
                    <td class="form_content" colspan="3">      ${bean.relateMatter}
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_border">工作建议：</td>
                    <td class="form_content" colspan="3">    ${bean.workAdvise}
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_border">附件：</td>
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
                            <td class="form_border" style="width: 150px">分管领导审核意见：</td>
                            <td class="form_content" colspan="3">
                                    ${bean.fgAuditOpinion}
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
                            <td class="form_border" style="width: 150px">主任审核意见：</td>
                            <td class="form_content" colspan="3">
                                    ${bean.zrAuditOpinion}
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
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>