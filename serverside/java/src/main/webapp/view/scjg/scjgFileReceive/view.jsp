<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function printExcelFR() {
        printFR("ScjgFileReceive", "id=${bean.id}");
    }
</script>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr>
            <td>
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr>
                        <td colspan="2" class="net_form_title">
                            虹口区建管署来件处理单
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
                            <td class="form_label_right">来件单位：</td>
                            <td class="form_content">&nbsp;
                                ${bean.source}                    </td>
                            <td class="form_label_right">来件日期：</td>
                            <td class="form_content">&nbsp;
                                <fmt:formatDate value="${bean.receiveDate}" pattern="yyyy-MM-dd"/>

                            </td>
                        </tr>


                        <tr class="tr_light">
                            <td class="form_label_right">来件名称：</td>
                            <td class="form_content">&nbsp;
                                ${bean.fileName}                    </td>
                            <td class="form_label_right">来件编号：</td>
                            <td class="form_content">&nbsp;
                                ${bean.fileCode}                    </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right">来件内容：</td>
                            <td class="form_content" colspan="3" height="75px">
                                <sys:toHtml>${bean.fileContent}</sys:toHtml>&nbsp;
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right">处理时限：</td>
                            <td class="form_content" colspan="3">&nbsp;
                                <fmt:formatDate value="${bean.dealTime}" pattern="yyyy-MM-dd"/>

                            </td>
                        </tr>

                        <tr class="tr_dark" colspan="3">
                            <td class="form_label_right" style="width:100px">处理情况：</td>
                            <td class="form_content" colspan="3">
                                <table cellpadding="0" cellspacing="0" class="form_table">
                                    <tr class="tr_dark">
                                        <td class="form_content" colspan="4" height="75px">
                                            <sys:toHtml>${bean.dealOpinion}</sys:toHtml>&nbsp;
                                        </td>
                                    </tr>
                                    <tr class="tr_dark">
                                        <td class="form_label_right" style="width: 100px">承办人：</td>
                                        <td class="form_content" style="width: 200px">&nbsp;
                                            ${bean.dealPerson}                    </td>
                                        <td class="form_label_right" style="width: 100px">承办日期：</td>
                                        <td class="form_content" style="width: 200px">&nbsp;
                                            <fmt:formatDate value="${bean.dealDate}" pattern="yyyy-MM-dd"/>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right" style="width:100px">领导批示内容：</td>
                            <td class="form_content" colspan="3">
                                <table cellpadding="0" cellspacing="0" class="form_table">
                                    <tr class="tr_light">
                                        <td class="form_content" colspan="4" height="75px">
                                            <sys:toHtml>${bean.leaderOpinion} </sys:toHtml>&nbsp;
                                        </td>
                                    </tr>
                                    <tr class="tr_light">
                                        <td class="form_label_right" style="width: 100px">领导批示签字：</td>
                                        <td class="form_content" style="width:200px">&nbsp;
                                            ${bean.leaderPerson}     </td>
                                        <td class="form_label_right" style="width:100px">领导批示日期：</td>
                                        <td class="form_content" style="width: 200px">&nbsp;
                                            <fmt:formatDate value="${bean.leaderDate}" pattern="yyyy-MM-dd"/>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right" style="width: 100px">备注：</td>
                            <td class="form_content" colspan="3" height="75px">
                                <sys:toHtml>${bean.description}</sys:toHtml>&nbsp;
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right">附件：</td>
                            <td class="form_content" colspan="4">
                                ${docButton}
                            </td>
                        </tr>
                    </table>


                    <%--<tr class="tr_dark">--%>
                    <%--<td class="form_label_right">是否提醒：</td>--%>
                    <%--<td class="form_content">&nbsp;--%>
                    <%--<c:choose><c:when test="${bean.isRemind}">是</c:when><c:otherwise>否</c:otherwise></c:choose>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                    <tr class="tr_button">

                        <td colspan="4">
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