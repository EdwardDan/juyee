<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">板块编码：</td>
            <td class="form_content">&nbsp;
                ${bean.modelCode}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">板块名称：</td>
            <td class="form_content">&nbsp;
                ${bean.modelName}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">系统权限：</td>
            <td class="form_content">&nbsp;

            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">更多链接：</td>
            <td class="form_content">
                ${bean.moreLink}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">是否有效：</td>
            <td class="form_content">&nbsp;
                <c:choose><c:when test="${bean.isValid}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">排序号：</td>
            <td class="form_content">&nbsp;
                ${bean.orderNo}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">最后更新时间：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>

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