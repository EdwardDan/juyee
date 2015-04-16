<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<script>
    function print() {
        printFR("scjgBidRecord", "id=${bean.id}");
    }
</script>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" bgcolor="#f0f8ff" style="width: 100%">
        <tr>
            <td align="center">
                <fieldset class="form_fieldset">
                    <legend align="center">上海市建设工程招投标监督记录</legend>

                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
                            <td class="form_label_right" nowrap >标段号：</td>
                            <td class="form_content" colspan="2">
                                &nbsp; ${bean.bdh} </td>

                            <td class="form_label_right" nowrap>流水号：</td>
                            <td class="form_content" colspan="2" nowrap>
                                &nbsp;  ${bean.code} </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right" nowrap>项目名称：</td>
                            <td class="form_content"nowrap colspan="2">
                                &nbsp;${bean.projectName}
                            </td>

                            <td class="form_label_right" nowrap>报建编号：</td>
                            <td class="form_content"nowrap colspan="2">
                                &nbsp;${bean.bjbh}
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right" nowrap width="10%">招标方式：</td>
                            <td class="form_content"nowrap width="20%">
                                &nbsp;
                                ${bean.bidMethod.name}
                            </td>

                            <td class="form_label_right" nowrap style="text-align: left" width="30%"> &nbsp;项目类别： &nbsp;
                                ${bean.bizType.name}&nbsp;</td>

                            <td class="form_label_right" nowrap width="20%">记录日期：</td>
                            <td class="form_content" colspan="3"nowrap width="20%">
                                <fmt:formatDate value="${bean.fillDate}" pattern="yyyy-MM-dd"/>
                            </td>
                        </tr>
                        <tr class="tr_dark">
                        <td class="form_label_right" rowspan="3" nowrap>参加人员：</td>
                            <td class="form_label_right" nowrap>招标单位名称：</td>
                            <td class="form_content"nowrap>
                                &nbsp;
                                ${bean.bidDeptName}
                            </td>
                            <td class="form_label_right" nowrap>招标单位人员：</td>
                            <td class="form_content"nowrap colspan="2">
                                &nbsp;
                                ${bean.bidDeptPerson}
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right" nowrap>招标代理单位名称：</td>
                            <td class="form_content"nowrap>
                                &nbsp;
                                ${bean.bidDlDeptName}
                            </td>
                            <td class="form_label_right" nowrap>招标代理单位人员：</td>
                            <td class="form_content"nowrap colspan="2">
                                &nbsp;
                                ${bean.bidDlDeptPerson}
                            </td>
                        </tr>

                        <tr class="tr_dark">
                            <td class="form_label_right" nowrap>评标委员会人员：</td>
                            <td class="form_content" nowrap colspan="3">
                                &nbsp;
                                ${bean.bidCheckPerson}
                            </td>
                        </tr>

                        <tr class="tr_light">
                            <td class="form_label_right" nowrap>监督类型：</td>
                            <td class="form_content" nowrap colspan="5">
                                &nbsp;
                                ${bean.jdStage.name}
                            </td>
                        </tr>

                        <tr class="tr_dark">
                            <td class="form_label_right" nowrap>监督记录：</td>
                            <td class="form_content"  colspan="5">
                                &nbsp; <sys:toHtml> ${bean.jdRecord}</sys:toHtml>
                            </td>
                        </tr>

                        <tr class="tr_dark">
                            <td class="form_label_right" nowrap>处理意见：</td>
                            <td class="form_content"  colspan="5">
                                &nbsp;     <sys:toHtml> ${bean.dealOpinion}</sys:toHtml>
                            </td>
                        </tr>

                        <tr class="tr_light">
                            <td class="form_label_right" nowrap>经办人：</td>
                            <td class="form_content" nowrap>
                                &nbsp;
                                ${bean.jbr}
                            </td>
                            <td class="form_label_right" nowrap>复核人：</td>
                            <td class="form_content"nowrap colspan="3">
                                &nbsp;
                                ${bean.fhr}
                            </td>
                        </tr>

                    </table>
                </fieldset>
            </td>
        </tr>

    </table>
    <tr class="tr_button">
        <td align="center">
            <input type="button" value="打印" class="button_all" onclick="print()">
            <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
        </td>
    </tr>
</div>