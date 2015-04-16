<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr>
            <td colspan="2">
                <fieldset style="width: 90%;margin:0px auto">
                    <legend class="form_legend">查看总结计划</legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
                            <td class="form_label_right" width="15%" nowrap>提交部门：</td>
                            <td class="form_content" width="35%" nowrap>
                                ${bean.reportDept}
                            </td>
                            <td class="form_label_right" width="15%">责任人：</td>
                            <td class="form_content" width="35%" nowrap>
                                ${bean.reportPerson}
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right">报告时间：</td>
                            <td align="left">
                                <%--${bean.year}年--%>
                                ${reportType}
                            </td>
                            <td class="form_label_right">提交时间：</td>
                            <td class="form_content">&nbsp;
                                <fmt:formatDate value="${bean.reportDate}" pattern="yyyy-MM-dd"/>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right">内容:</td>
                            <td class="form_content" colspan="3">
                               <sys:toHtml>${bean.content}</sys:toHtml>
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
                    <legend class="form_legend">审核信息</legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_dark">
                            <td class="form_label_right" width="15%">审核意见：</td>
                            <td class="form_content">
                                <sys:toHtml>${bean.fgOpinion}</sys:toHtml>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right">审核时间：</td>
                            <td class="form_content">
                                <fmt:formatDate value="${bean.fgAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right">审核人：</td>
                            <td class="form_content">
                                ${bean.fgAuditUser}
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </td>
        </tr>
        <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>

