<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td>
                <c:if test="${empty originPhoto}"><img src="${themePath}/images/no_picture.gif"  width="240" height="320"></c:if>
                <c:if test="${not empty originPhoto}"><img src="${ctx}/uploads/doc${originPhoto}" width="240" height="320"></c:if>
            </td>
            <td><c:if test="${empty checkPhoto}"><img src="${themePath}/images/no_picture.gif"  width="240" height="320"></c:if>
                <c:if test="${not empty checkPhoto}"><img src="${ctx}/uploads/doc${checkPhoto}"  width="240" height="320"></c:if>
            </td>
        </tr>
        <tr class="tr_light">
            <td>
                原始照片
            </td>
            <td>
                考勤照片(采集时间：<fmt:formatDate value="${bean.checkTime}" pattern="yyyy-MM-dd HH:mm:ss"/>)
            </td>
        </tr>
        <tr class="tr_button">
            <td colspan="2">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()"></td>
        </tr>
    </table>
</div>