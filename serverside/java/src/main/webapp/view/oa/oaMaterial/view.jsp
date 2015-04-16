<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr>
            <td>
                <fieldset class="form_fieldset" style="width: 90%;margin: 0 auto;display: true;">
                    <legend class="form_legend">物资申请</legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
                            <td class="form_label_right">申请编号：</td>
                            <td class="form_content">&nbsp;
                                ${bean.code}
                            </td>
                            <td class="form_label_right">申请日期：</td>
                            <td class="form_content">&nbsp;
                                <fmt:formatDate value="${bean.reportDate}" pattern="yyyy-MM-dd"/>
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right">申请部门：</td>
                            <td class="form_content">&nbsp;
                                ${bean.reportDept}
                            </td>
                            <td class="form_label_right">申请人：</td>
                            <td class="form_content">&nbsp;
                                ${bean.reportPerson}
                            </td>
                        </tr>
                        <tr class="tr_light" height="100">
                            <td class="form_label_right">备注要求：</td>
                            <td class="form_content" colspan="3">&nbsp;
                                <sys:toHtml>${bean.requireDesc}</sys:toHtml>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4">
                                <table id="table1" cellpadding="0" cellspacing="0" width="100%" align="center">
                                    <tr class="tr_header">
                                        <td class="form_td_line" width="40" nowrap>序号</td>
                                        <td class="form_td_line" width="155" nowrap>物资设备名称</td>
                                        <td class="form_td_line" width="155" nowrap>具体规格型号</td>
                                        <td class="form_td_line" width="155" nowrap>供应商情况</td>
                                        <td class="form_td_line" width="155" nowrap>数量</td>
                                    </tr>
                                    <c:forEach items="${bean.oaMaterialItems}" var="item" varStatus="status">
                                        <tr class="tr_dark">
                                            <td align="center" nowrap>${status.index+1}</td>
                                            <td align="center" nowrap>${item.materialName}</td>
                                            <td align="center" nowrap>${item.materialModel}</td>
                                            <td align="center" nowrap>${item.supplier}</td>
                                            <td align="center" nowrap>${item.materialNum}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </td>
        </tr>
        <tr style="<c:if test="${empty bean.officeAuditTime}">display: none;</c:if>">
            <td>
                <fieldset class="form_fieldset" style="width: 90%;margin: 0 auto;display: true;">
                    <legend class="form_legend">办公室审核</legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_dark" height="100">
                            <td class="form_label_right" width="20%">办公室审核意见：</td>
                            <td class="form_content">&nbsp;
                                <sys:toHtml>${bean.officeOpinion}</sys:toHtml>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right">办公室审核时间：</td>
                            <td class="form_content">&nbsp;
                                <fmt:formatDate value="${bean.officeAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </td>
        </tr>
        <tr style="<c:if test="${empty bean.leaderAuditTime}">display: none;</c:if>">
            <td>
                <fieldset class="form_fieldset" style="width: 90%;margin: 0 auto;display: true;">
                    <legend class="form_legend">领导审核</legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light" height="100">
                            <td class="form_label_right" width="20%">主管领导审核意见：</td>
                            <td class="form_content">&nbsp;
                                <sys:toHtml>${bean.leaderOpinion}</sys:toHtml>
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right">主管领导审核时间：</td>
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