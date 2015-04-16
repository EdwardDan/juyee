<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function printExcelFR() {
        printFR("ScjgFileAssign", "id=${bean.id}");
    }
</script>
<div class="form_div">

    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr>
            <td>
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr>
                        <td colspan="5" class="net_form_title">
                            虹口区建管署交办件处理单
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
                        <tr class="tr_light">
                            <td class="form_label_right" width="15%">来件来源：</td>
                            <td class="form_content" colspan="2" width="40%">
                                &nbsp;${bean.source}
                            </td>
                            <td class="form_label_right" width="15%">交办日期：</td>
                            <td class="form_content" width="30%">
                                &nbsp;<fmt:formatDate value="${bean.assignDate}" pattern="yyyy-MM-dd"/>
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right" width="15%">来件编号：</td>
                            <td class="form_content" colspan="4" width="75%">
                                &nbsp;${bean.fileCode}
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right" width="15%">来件名称：</td>
                            <td class="form_content" colspan="4" width="75%">
                                &nbsp;${bean.fileName}
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right" width="15%">来件内容：</td>
                            <td class="form_content" colspan="4" width="75%" height="80px">
                                <sys:toHtml>${bean.fileContent}</sys:toHtml>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right" rowspan="2" width="15%">领导批示内容：</td>
                            <td class="form_content" colspan="4" width="75%" height="80px">
                                <sys:toHtml>${bean.leaderOpinion}</sys:toHtml>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right" width="15%">领导批示签字：</td>
                            <td class="form_content" width="25%">
                                &nbsp;${bean.leaderPerson}
                            </td>
                            <td class="form_label_right" width="15%">领导批示日期：</td>
                            <td class="form_content" width="30%">
                                &nbsp;<fmt:formatDate value="${bean.leaderDate}" pattern="yyyy-MM-dd"/>
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right" rowspan="3" width="15%">处理情况：</td>
                            <td class="form_content" colspan="4" width="75%" height="80px">
                                <sys:toHtml>${bean.dealOpinion}</sys:toHtml>
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right" colspan="4" width="75%">（可附页）</td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right" width="15%">承办人：</td>
                            <td class="form_content"  width="25%">
                                &nbsp;${bean.dealPerson}
                            </td>
                            <td class="form_label_right" width="15%">承办日期：</td>
                            <td class="form_content"  width="30%">
                                &nbsp;<fmt:formatDate value="${bean.dealDate}" pattern="yyyy-MM-dd"/>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right" rowspan="2" width="15%">领导审核内容：</td>
                            <td class="form_content" colspan="4" width="75%" height="80px">
                                <sys:toHtml>${bean.checkOpinion}</sys:toHtml>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right" width="15%">领导审核签字：</td>
                            <td class="form_content"  width="25%">
                                &nbsp;${bean.checkPerson}
                            </td>
                            <td class="form_label_right" width="15%">领导审核日期：</td>
                            <td class="form_content"  width="30%">
                                &nbsp;<fmt:formatDate value="${bean.checkDate}" pattern="yyyy-MM-dd"/>
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right" width="15%">备注：</td>
                            <td class="form_content" colspan="4" width="75%" height="80px">
                                <sys:toHtml>${bean.description}</sys:toHtml>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right" width="15%">附件：</td>
                            <td class="form_content" colspan="4" width="75%">
                                &nbsp;${docButton}
                            </td>
                        </tr>
                        <tr class="tr_button">
                            <td class="form_border" colspan="5">
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