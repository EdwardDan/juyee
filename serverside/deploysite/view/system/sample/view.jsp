<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">
                姓名：
            </td>
            <td class="form_content">
                ${bean.name}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">
                生日：
            </td>
            <td class="form_content">
                ${bean.birthday}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">
                资产：
            </td>
            <td class="form_content">
                <fmt:formatNumber value="${bean.possession}" pattern="###.##"/>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">
                年龄：
            </td>
            <td class="form_content">
                ${bean.age}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">
                所属单位：
            </td>
            <td class="form_content">
                ${bean.sysDept.name}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">
                学历：
            </td>
            <td class="form_content">
                ${bean.education.name}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">
                注册时间：
            </td>
            <td class="form_content">
                <fmt:formatDate value="${bean.registerTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">
                婚否：
            </td>
            <td class="form_content">
                <input type="checkbox" name="isMarried" id="isMarried" value="1"
                       <c:if test="${bean.isMarried}">checked</c:if>/>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">
                备注：
            </td>
            <td class="form_content">
                <sys:toHtml>${bean.description}</sys:toHtml>
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