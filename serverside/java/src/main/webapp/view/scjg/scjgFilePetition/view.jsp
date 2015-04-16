<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function printExcelFR() {
        printFR("ScjgFilePetition", "id=${bean.id}");
    }
</script>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr>
            <td>
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr>
                        <td colspan="2" class="net_form_title">
                            虹口区监管署信访处理单
                        </td>
                    </tr>
                    <tr>
                        <td width="70%" style="text-align:right;">
                            &nbsp;编号：
                        </td>
                        <td align="left">
                            &nbsp;${bean.code}
                        </td>
                    </tr>
                </table>
            </td>
        </tr>

        <tr>
            <td align="center">
                <fieldset class="net_form_fieldset" style="width: 90%">
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_dark">
                            <td class="form_label_right" width="22%">信访人：</td>
                            <td class="form_content" width="40%">
                                &nbsp;${bean.person}
                            </td>
                            <td class="form_label_right" width="13%">信访时间：</td>
                            <td class="form_content">
                                &nbsp;<fmt:formatDate value="${bean.petitionDate}" pattern="yyyy-MM-dd"/>

                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right">联系地址电话：</td>
                            <td class="form_content">
                                &nbsp;${bean.contactAddress}
                            </td>
                            <td class="form_label_right">投诉来源:</td>
                            <td class="form_content">
                                &nbsp;${fileSource}
                            </td>
                        </tr>

                        <tr class="tr_dark">
                            <td class="form_label_right">投诉内容：</td>
                            <td class="form_content" colspan="3">
                                <sys:toHtml>${bean.fileContent}</sys:toHtml>&nbsp;
                            </td>
                        </tr>

                        <tr class="tr_light" colspan="3">
                            <td class="form_label_right">领导批示：</td>
                            <td class="form_content" colspan="3">
                                <%--<sys:toHtml>${bean.leaderOpinion}</sys:toHtml>&nbsp;--%>

                                <table cellpadding="0" cellspacing="0" class="form_table">
                                    <tr class="tr_light">
                                        <td class="form_content" colspan="4">
                                            <sys:toHtml>${bean.leaderOpinion}</sys:toHtml>&nbsp;
                                        </td>
                                    </tr>

                                    <tr class="tr_light">
                                        <td class="form_label_right" width="18%">领导签字：</td>
                                        <td class="form_content" width="30%">
                                            &nbsp;${bean.leaderPerson}
                                        </td>
                                        <td class="form_label_right" width="15%">日期：</td>
                                        <td class="form_content">
                                            &nbsp;<fmt:formatDate value="${bean.leaderDate}" pattern="yyyy-MM-dd"/>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <%--<tr class="tr_light">--%>
                            <%--<td class="form_label_right">领导批示签字：</td>--%>
                            <%--<td class="form_content">--%>
                                <%--&nbsp;${bean.leaderPerson}--%>
                            <%--</td>--%>
                            <%--<td class="form_label_right">领导批示日期：</td>--%>
                            <%--<td class="form_content">--%>
                                <%--&nbsp;<fmt:formatDate value="${bean.leaderDate}" pattern="yyyy-MM-dd"/>--%>
                            <%--</td>--%>
                        <%--</tr>--%>

                        <tr class="tr_dark">
                            <td class="form_label_right">情况核查及分析：</td>
                            <td class="form_content" colspan="3">
                                <sys:toHtml>${bean.caseAnalyze}</sys:toHtml>&nbsp;
                            </td>
                        </tr>

                        <tr class="tr_light">
                            <td class="form_label_right">处理情况：</td>
                            <td class="form_content" colspan="3">
                                <sys:toHtml>${bean.dealOpinion}</sys:toHtml>&nbsp;
                            </td>
                        </tr>

                        <tr class="tr_dark">
                            <td class="form_label_right">信访人对处理情况态度：</td>
                            <td class="form_content" colspan="3">
                                <sys:toHtml>${bean.caseAttitude}</sys:toHtml>&nbsp;
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right">附件：</td>
                            <td class="form_content" colspan="3">
                                ${docButton}
                            </td>
                        </tr>
                        <tr class="tr_button">
                            <td class="form_border" colspan="4">
                                <input type="button" class="button_all" value="打印" onclick="printExcelFR();"/>
                                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </td>
        </tr>
    </table>
</div>