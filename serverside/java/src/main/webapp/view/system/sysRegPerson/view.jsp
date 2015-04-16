<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <c:if test="${bean.regType.code==SYS_REGPERSON_TYPE_Gd}">
            <tr class="tr_dark">
                <td class="form_label">工地编号：</td>
                <td class="form_content">
                        ${bean.gdCode}
                </td>
            </tr>
        </c:if>
        <c:if test="${regTypeName=='project'}">
            <tr class="tr_light">
                <td class="form_label">报建编号：</td>
                <td class="form_content">
                        ${bean.bjbh}
                </td>
            </tr>
        </c:if>
        <c:if test="${regTypeName=='project'}">
            <tr class="tr_dark">
                <td class="form_label">项目卡号：</td>
                <td class="form_content">
                        ${bean.projectCard}
                </td>
            </tr>
        </c:if>
        <c:if test="${regTypeName=='gongdi'||regTypeName=='project'}">
            <tr class="tr_light">
                <td class="form_label">工程名称：</td>
                <td class="form_content">
                        ${bean.projectName}
                </td>
            </tr>
        </c:if>
        <c:if test="${regTypeName=='company'}">
            <tr class="tr_light">
                <td class="form_label">企业编码：</td>
                <td class="form_content">
                        ${bean.unitCode}
                </td>
            </tr>
        </c:if>
        <c:if test="${regTypeName=='company'}">
            <tr class="tr_dark">
                <td class="form_label">企业标识码：</td>
                <td class="form_content">
                        ${bean.unitIdentifyCode}
                </td>
            </tr>
        </c:if>
        <c:if test="${regTypeName=='company'}">
            <tr class="tr_light">
                <td class="form_label">企业名称：</td>
                <td class="form_content">
                        ${bean.unitName}
                </td>
            </tr>
        </c:if>
        <tr class="tr_dark">
            <td class="form_label">联系人：</td>
            <td class="form_content">
                ${bean.personName}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">手机号码：</td>
            <td class="form_content">
                ${bean.mobile}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">受理意见：</td>
            <td class="form_content">
                ${acceptOption}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">受理描述：</td>
            <td class="form_content">&nbsp;
                ${bean.acceptDesc}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">受理来源：</td>
            <td class="form_content">
                <c:if test="${bean.regResource==0}">窗口</c:if>
                <c:if test="${bean.regResource==1}">网站</c:if>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">受理人：</td>
            <td class="form_content">
                ${bean.acceptUser.displayName}
            </td>
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