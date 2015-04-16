<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr height="50">
            <td colspan="2" align="center">
                    <span class="net_form_title">
                        <%--虹口建管署${bean.year}年<c:if test="${not empty bean.period}">第${bean.period}季度</c:if>主要工作完成--%>
                        虹口建管署${yearPeriodName}主要工作完成
                    </span>
            </td>
        </tr>
        <tr>
            <td>
                <fieldset class="form_fieldset" style="width: 96%;margin: 0 auto;display: true;">
                    <legend class="form_legend">季度/年度汇总</legend>
                    <table cellpadding="0" cellspacing="0" class="form_table" id="table1">
                        <tr class="tr_dark">
                            <td class="form_label_right" width="15%" nowrap>发布内容：</td>
                            <td class="form_content" nawrap>
                                ${bean.sumContent}
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </td>
        </tr>

        <tr style="<c:if test="${empty bean.leaderAuditTime}">display: none;</c:if>">
            <td colspan="2">
                <fieldset class="form_fieldset" style="width: 96%;margin: 0 auto;display: true;">
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
            <td class="form_border" colspan="4">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>