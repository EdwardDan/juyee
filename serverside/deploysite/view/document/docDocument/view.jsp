<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">原始编号：</td>
            <td class="form_content">
                ${bean.originCode}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">编号：</td>
            <td class="form_content">
                ${bean.code}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">标题：</td>
            <td class="form_content">
                ${bean.name}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">作者：</td>
            <td class="form_content">
                ${bean.author}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">关键字：</td>
            <td class="form_content">
                ${bean.keywords}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">摘要：</td>
            <td class="form_content">
                ${bean.abstractContent}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">创建者：</td>
            <td class="form_content">
                ${bean.createUser}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">创建日期：</td>
            <td class="form_content">
                <fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd"/>


                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">归档状态：</td>
            <td class="form_content">
                ${bean.achStatus}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">描述：</td>
            <td class="form_content">
                ${bean.description}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">附件：</td>
            <td class="form_content">
                ${docButton}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">文档目录：</td>
            <td class="form_content">
                ${docMenu}
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