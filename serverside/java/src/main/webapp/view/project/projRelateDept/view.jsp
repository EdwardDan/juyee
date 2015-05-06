<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<form:form commandName="bean">
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right">单位名称:&nbsp;</td>
                <td class="form_content">${bean.name}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">单位简称:&nbsp;</td>
                <td class="form_content">${bean.shortName}
                </td>
                <td class="form_label_right">单位负责人:&nbsp;</td>
                <td class="form_content"><c:choose><c:when test="${bean.manager == null}">暂无</c:when><c:otherwise>${bean.manager}</c:otherwise></c:choose>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">通讯地址:&nbsp;</td>
                <td class="form_content">${bean.linkAddress}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">公司邮编:&nbsp;</td>
                <td class="form_content">${bean.zipcode}
                </td>
                <td class="form_label_right">
                    公司电话:&nbsp;</td>
                <td class="form_content"><c:choose><c:when test="${bean.tel == null}">暂无</c:when><c:otherwise>${bean.tel}</c:otherwise></c:choose>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">传真:&nbsp;</td>
                <td class="form_content">${bean.fax}
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_content" colspan="4" style="text-align: center">
                    <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>