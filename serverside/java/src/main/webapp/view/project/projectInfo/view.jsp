<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                ${bean.buildCode}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                <fmt:formatDate value="${bean.buildDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                ${bean.buildName}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                ${bean.buildDept}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                ${bean.buildDeptProperty}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                ${bean.buildDeptAddress}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                ${bean.buildDeptPhone}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                ${bean.buildDeptLegal}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                ${bean.buildDeptLinkman}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                ${bean.buildDeptZipcode}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                ${bean.buildDeptRegCapital}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                ${bean.buildAddress}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                ${bean.buildProperty}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                ${bean.buildScope}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                ${bean.buildArea}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                <fmt:formatDate value="${bean.buildStartDate}" pattern="yyyy-MM-dd"/>


                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                ${bean.totalInvest}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                ${bean.projectType}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                ${bean.belongArea}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                ${bean.proDesc}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                <fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>


                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                <fmt:formatDate value="${bean.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>


                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                ${bean.createUser}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                ${bean.updateUser}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                ${bean.proSchedule}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">${prop.get("columnName")}：</td>
            <td class="form_content">
                ${bean.proAttention}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>