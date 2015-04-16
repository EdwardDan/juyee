<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="no_scrollbar">
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">单位代码:</td>
            <td class="form_content">
                ${bean.code}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">单位名称:</td>
            <td class="form_content">
                ${bean.name}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">简称:</td>
            <td class="form_content">
                ${bean.shortName}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">机构代码证:</td>
            <td class="form_content">
                ${bean.cardNo}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">注册地编码:</td>
            <td class="form_content">
                ${bean.cityCode}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">注册地名称:</td>
            <td class="form_content">
                ${bean.cityName}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">隶属省市代码:</td>
            <td class="form_content">
                ${bean.provinceCode}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">隶属省市名称:</td>
            <td class="form_content">
                ${bean.provinceName}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">注册地址:</td>
            <td class="form_content">
                ${bean.address}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">单位标志:</td>
            <td class="form_content">
                <c:choose><c:when test="${bean.isTag}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">是否有效:</td>
            <td class="form_content">
                <c:choose><c:when test="${bean.isValid}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">排序:</td>
            <td class="form_content">
                ${bean.orderNo}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">备注:</td>
            <td class="form_content">
                <sys:toHtml>${bean.memo}</sys:toHtml>
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
    </div>