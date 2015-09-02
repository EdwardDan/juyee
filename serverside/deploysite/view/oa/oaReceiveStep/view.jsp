<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right" width="20%">步骤序号：</td>
                <td class="form_content" width="30%">${bean.orderNo}</td>
                <td class="form_label_right" width="20%">流转步骤种类：</td>
                <td class="form_content" width="30%">${bean.code}</td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" width="20%">流转步骤名称：</td>
                <td class="form_content"  width="30%">${bean.name}</td>
                <td class="form_label_right" width="20%">是否会签：</td>
                <td class="form_content" width="30%"><c:if test="${bean.isJoin}">是</c:if><c:if test="${!bean.isJoin}">否</c:if></td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" width="20%">是否显示：</td>
                <td class="form_content" colspan="3"><c:if test="${bean.isShow}">是</c:if><c:if test="${!bean.isShow}">否</c:if></td>
            </tr>
            <tr class="tr_dark">
                <td class="form_border" align="center" style="font-weight: bold;font-size: 17px" colspan="4">流转操作</td>
            </tr>
        </table>
        <table cellpadding="0" cellspacing="0" border="1" class="table_thin_line" style="text-align: center;width: 98%;"
               id="itemTable">
            <tr class="tr_header">
                <td style="width: 25%;">操作编码</td>
                <td style="width: 20%;;">操作名称</td>
                <td style="width: 10%;">是否有效</td>
            </tr>
            <c:forEach items="${bean.oaReceiveOperations}" var="item">
                <tr class="tr_light">
                    <td>${item.code} </td>
                    <td>${item.name}</td>
                    <td><c:if test="${item.isValid}">是</c:if><c:if test="${!item.isValid}">否</c:if></td>
                </tr>
            </c:forEach>
        </table>
        <table  cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_button" >
                <td class="form_border" align="center">
                    <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>