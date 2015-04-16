<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr>
            <td>
                <fieldset class="form_fieldset" style="width: 90%;margin: 0 auto;display: true;">
                    <legend class="form_legend">申报信息</legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
                            <td class="form_label_right" width="20%">工程名称：</td>
                            <td class="form_content" colspan="3">
                                ${projectName}
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right" width="20%">工程地址：</td>
                            <td class="form_content" colspan="3">
                                ${bean.projectAddress}
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right" width="20%">申报类型：</td>
                            <td class="form_content" width="30%">
                                ${bean.reportTypeDesc}
                            </td>
                            <td class="form_label_right" width="20%">建筑面积：</td>
                            <td class="form_content" width="30%">
                                ${bean.buildArea}
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right" width="20%">结构类型：</td>
                            <td class="form_content" width="30%">
                                ${bean.structureType}
                            </td>

                            <td class="form_label_right" width="20%">结构层次：</td>
                            <td class="form_content" width="30%">
                                ${bean.structureLevel}
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right" width="20%">&nbsp;附件：</td>
                            <td class="form_content" colspan="3">${uploadButton}</td>
                        </tr>
                    </table>
                </fieldset>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="form_fieldset_space">&nbsp;</td>
        </tr>
        <c:if test="${bean.status==STATUS_PASS}">
            <tr>
                <td>
                    <fieldset class="form_fieldset" style="width: 90%;margin: 0 auto;">
                        <legend class="form_legend">审核信息</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_dark" height="100">
                                <td class="form_label_right" width="20%">质量科审核意见：</td>
                                <td class="form_content">&nbsp;
                                    <sys:toHtml>${bean.auditOpinion}</sys:toHtml>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">质量科审核时间：</td>
                                <td class="form_content">&nbsp;
                                    <fmt:formatDate value="${bean.auditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>
        </c:if>
        <tr class="tr_button">
            <td class="form_border" align="center" colspan="4">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()"></td>
        </tr>
    </table>
</div>