<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%
    response.setHeader("Pragma", "No-cache");        //HTTP     1.1
    response.setHeader("Cache-Control", "no-cache");//HTTP     1.0
    response.setHeader("Expires", "0");               //防止被proxy

    out.clear();
%>
<div>
    <table>
        <tr>
            <td>街道名称：</td>
            <td>
                <select name="streetId" id="streetId">
                    <c:forEach var="street" items="${streets}">
                        <option value="${street.id}"
                                <c:if test="${street.id==selectId}">selected</c:if>>${street.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>显示颜色：</td>
            <td>
                <input name="color" id="color" type="text" onclick="openColorSelect(this)" value="${color}"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="button" class="form_submit" value="保存" onclick="save()">
                <input type="button" class="form_submit" value="节点编辑" onclick="editPolygon()">
                <input type="button" class="form_button" value="删除" onclick="polygonDelete()"/>
            </td>
        </tr>
    </table>
</div>