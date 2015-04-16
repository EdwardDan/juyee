<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">参数代码:</td>
            <td class="form_content">
                ${bean.code}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">参数名称:</td>
            <td class="form_content">
                ${bean.name}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">参数值:</td>
            <td class="form_content">
                ${bean.value}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">约束:</td>
            <td class="form_content">
                ${bean.constraint}
                &nbsp;
            </td>
        </tr>
        <%--<tr class="tr_light">--%>
            <%--<td class="form_label">长参数:</td>--%>
            <%--<td class="form_content">--%>
                <%--${bean.clobvalue}--%>
                <%--&nbsp;--%>
            <%--</td>--%>
        <%--</tr>--%>
        <tr class="tr_light">
            <td class="form_label">更新时间:</td>
            <td class="form_content">
                <fmt:formatDate value="${bean.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">更新人:</td>
            <td class="form_content">
                ${bean.updateUser}
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