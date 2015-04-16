<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label">编码：</td>
            <td class="form_content">&nbsp;
                ${bean.code}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">名称：</td>
            <td class="form_content">&nbsp;
                ${bean.name}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">部门：</td>
            <td class="form_content">&nbsp;
                ${bean.reportDeptDefine.deptName}
            </td>
        </tr>
        <c:if test="${not empty bean.measureUnit.name}">
            <tr class="tr_dark">
                <td class="form_label">计算单位：</td>
                <td class="form_content">&nbsp;
                        ${bean.measureUnit.name}
                </td>
                </td>
            </tr>
        </c:if>
        <c:if test="${not empty bean.measureUnit.name}">
        <tr class="tr_dark">
            <td class="form_label">是否计算累计值：</td>
            <td class="form_content">&nbsp;
                <c:choose><c:when test="${bean.isSumAccu}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
            </td>
        </tr>
        </c:if>
        <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>