<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">皮肤名称：</td>
            <td class="form_content">&nbsp;
                ${bean.name}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">路径：</td>
            <td class="form_content">&nbsp;
                ${bean.path}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">是否有效：</td>
            <td class="form_content">&nbsp;
                <c:choose><c:when test="${bean.isValid}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">是否缺省：</td>
            <td class="form_content">&nbsp;
                <c:choose><c:when test="${bean.isDefault}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">自定义属性：</td>
            <td class="form_content">&nbsp;
                ${bean.customDefine}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">更新时间：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>

            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">更新用户：</td>
            <td class="form_content">&nbsp;
                ${bean.updateUser}                    </td>
        </tr>
        <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>