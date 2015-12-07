<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">报建编号：</td>
            <td class="form_content">${bean.bjbh}</td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">工程名称：</td>
            <td class="form_content">${bean.projectName}</td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">企业编码：</td>
            <td class="form_content">${bean.unitCode}</td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">企业标识码：</td>
            <td class="form_content">${bean.unitIdentifyCode}</td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">企业名称：</td>
            <td class="form_content">${bean.unitName}</td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">联系人：</td>
            <td class="form_content">${bean.personName}</td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">手机号码：</td>
            <td class="form_content">${bean.mobile}</td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">受理日期：</td>
            <td class="form_content">
                <fmt:formatDate value="${bean.acceptDatetime}" pattern="yyyy-MM-dd"/>
            </td>
        </tr>
        <c:if test="${bean.acceptOpinion==1}">
            <tr class="tr_light">
                <td class="form_label">开通账号：</td>
                <td class="form_content">
                        ${sysUsers}
                </td>
            </tr>
        </c:if>
        <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">&nbsp;
            </td>
        </tr>
    </table>
</div>