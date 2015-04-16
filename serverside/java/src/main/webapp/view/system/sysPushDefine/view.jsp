<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label">模块名称：</td>
            <td class="form_content">&nbsp;
                ${bean.modelName}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">首页推送图标:</td>
            <td class="form_content">
                <c:if test="${bean.taskImg != ''}">
                    <img src="${themePath}/index_new/task_img/${bean.taskImg}.png" border="0"/>
                </c:if>
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">推送时间间隔(天)：</td>
            <td class="form_content">&nbsp;
                ${bean.pushDelay}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">排序号：</td>
            <td class="form_content">&nbsp;
                ${bean.orderNo}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">是否有效：</td>
            <td class="form_content">&nbsp;
                <c:choose><c:when test="${bean.isValid}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">查询语句：</td>
            <td class="form_content" style="word-break: break-all;">&nbsp;
                <sys:toHtml>${bean.querySql}</sys:toHtml>
            </td>
        </tr>
        <tr class="tr_dark">
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