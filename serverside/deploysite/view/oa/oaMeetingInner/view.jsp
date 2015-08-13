<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label">会议时间：</td>
            <td class="form_content">
                ${meetTime}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">会议地点：</td>
            <td class="form_content">
                ${bean.address} </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">内部人员：</td>
            <td class="form_content">
                <c:forEach var="item" items="${innerPersons}" varStatus="st">
                    <c:choose>
                        <c:when test="${st.index!=fn:length(innerPersons)-1}">
                            ${item.name},
                        </c:when>
                        <c:otherwise>
                            ${item.name}
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">外部人员：</td>
            <td class="form_content">
                <sys:toHtml>${bean.outerPersons}</sys:toHtml>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">会议议题：</td>
            <td class="form_content">
                ${bean.title} </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">会议内容：</td>
            <td class="form_content">
                <sys:toHtml>${bean.content}</sys:toHtml>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">附件：</td>
            <td class="form_content">
                ${docButton}
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