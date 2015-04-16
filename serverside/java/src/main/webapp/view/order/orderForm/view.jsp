<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var jdTaskCodeValue = "${bean.orderForm.jdTaskCode}";
        if(jdTaskCodeValue != ""){
            loadAjaxData("dwgcList","${ctx}/orderForm/excelJdDwgcView.do?isEdit=false&jdTaskCode=" + jdTaskCodeValue);
        }
    });
</script>
<div class="no_scrollbar">
    <div class="form_div" align="center">
        <table cellpadding="0" cellspacing="0" id="mainTable" bgcolor="#f0f8ff" style="width: 100%">
            <tr>
                <td align="center">
                    <fieldset class="form_fieldset">
                        <legend align="left" class="form_legend">监督预约</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td class="form_label_right" width="15%">建设单位：</td>
                                <td class="form_content" width="35%">
                                    &nbsp;${bean.orderForm.buildUnitName}
                                </td>
                                <td class="form_label_right" width="15%">工程名称：</td>
                                <td class="form_content" width="35%">
                                    &nbsp;${bean.orderForm.projectName}
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">施工单位：</td>
                                <td class="form_content">
                                    &nbsp;${bean.orderForm.sgUnitName}
                                </td>
                                <td class="form_label_right">工程地点：</td>
                                <td class="form_content">
                                    &nbsp;${bean.orderForm.buildAddress}
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">建筑面积(㎡)：</td>
                                <td class="form_content">
                                    &nbsp;<fmt:formatNumber value="${bean.orderForm.buildArea}" pattern="#,###.##"/>
                                </td>
                                <td class="form_label_right">结构层次：</td>
                                <td class="form_content">
                                    &nbsp;${bean.orderForm.structure}
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">建设单位法人：</td>
                                <td class="form_content">
                                    &nbsp;${bean.orderForm.buildLegalPerson}
                                </td>
                                <td class="form_label_right">项目经理：</td>
                                <td class="form_content">
                                    &nbsp;${bean.orderForm.projectManager}
                                </td>

                            </tr>
                            <%--<tr class="tr_light">--%>
                            <%--<td class="form_label_right" colspan="3">联系电话：</td>--%>
                            <%--<td class="form_content">--%>
                            <%--&nbsp;${bean.orderForm.buildLegalPhone}--%>
                            <%--</td>--%>
                            <%--</tr>--%>
                            <tr class="tr_dark">
                                <td class="form_label_right" nowrap height="60">隐蔽工程部位：</td>
                                <td class="form_content" colspan="3">
                                    &nbsp;${bean.orderForm.sgPosition}
                                </td>
                                <%--<td class="form_label_right" nowrap>--%>
                                <%--&nbsp;计划隐蔽日期：--%>
                                <%--</td>--%>
                                <%--<td class="form_content">--%>
                                <%--&nbsp;<fmt:formatDate value="${bean.orderForm.planSgDatatime}" pattern="yyyy-MM-dd HH:mm"/>--%>
                                <%--</td>--%>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">联系人：</td>
                                <td class="form_content">
                                    &nbsp;${bean.orderForm.linkMan}
                                </td>
                                <td class="form_label_right">联系人手机号：</td>
                                <td class="form_content">
                                    &nbsp;${bean.orderForm.linkManPhone}
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">预约附件：</td>
                                <td class="form_content">
                                    ${docButton}
                                </td>
                                <td class="form_label_right">预约日期：</td>
                                <td class="form_content">
                                    &nbsp;<fmt:formatDate value="${bean.orderForm.orderDatetime}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">填表日期：</td>
                                <td class="form_content" colspan="3">
                                    &nbsp;<fmt:formatDate value="${bean.orderForm.inputTime}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                            <tr>
                                <td class="form_border" colspan="4"></td>
                            </tr>
                        </table>
                    </fieldset>

                </td>
            </tr>
            <tr>
                <td align="center">
                    <fieldset class="form_fieldset">
                        <legend align="left" class="form_legend">受理信息</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td class="form_label_right" width="15%">受理人：</td>
                                <td class="form_content" width="35%">
                                    &nbsp;${bean.acceptUserName}
                                </td>
                                <td class="form_label_right" width="15%">受理时间：</td>
                                <td class="form_content" width="35%">
                                    &nbsp;<fmt:formatDate value="${bean.acceptDatetime}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">监督负责人：</td>
                                <td class="form_content">
                                    &nbsp;${jdManagerName}
                                </td>
                                <td class="form_label_right">监督任务书编号：</td>
                                <td class="form_content">
                                    <c:choose>
                                        <c:when test="${isRegPerson}">
                                            &nbsp;${bean.orderForm.jdTaskCode}
                                        </c:when>
                                        <c:otherwise>
                                            &nbsp;<a href="javascript:void(0)" title="查看项目信息" onclick="viewProjectInfo('查看项目信息','${bjbh}',null,'${bean.orderForm.jdTaskCode}',false,true);" class="page_link">${bean.orderForm.jdTaskCode}</a>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">受理意见：</td>
                                <td class="form_content" colspan="3">
                                    &nbsp;${bean.acceptOpinion.name}
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">受理备注：</td>
                                <td class="form_content" colspan="3">
                                    &nbsp;<sys:toHtml>${bean.acceptOpinionDesc}</sys:toHtml>
                                </td>
                            </tr>
                            <tr>
                                <td class="form_border" colspan="4"></td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>
            <tr>
                <td align="center" id="dwgcList">&nbsp;</td>
            </tr>
            <tr class="tr_button" align="center">
                <td class="form_border">
                    <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</div>