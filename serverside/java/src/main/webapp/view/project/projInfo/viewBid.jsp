<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_header">
            <td class="">标段编号</td>
            <td class="">标段名称</td>
            <td class="">涉及区县</td>
            <td class="">建设里程（公里）</td>
            <td class="">项目联系人</td>
            <td class="">联系电话</td>
            <td class="">开工日期</td>
        </tr>
        <c:forEach items="${projBids}" var="bid">
            <tr
                    <c:if test="${st/2==0}">class="tr_dark"</c:if> <c:if test="${st/2==1}">class="tr_light"</c:if>>
                <td class="">${bid.code}</td>
                <td class="">${bid.name}</td>
                <td class="">${bid.belongArea.name}</td>
                <td class="">${bid.buildMileage}</td>
                <td class="">${bid.projLink}</td>
                <td class="">${bid.linkTel}</td>
                <td class="">${bid.startDate}</td>
            </tr>
        </c:forEach>
        <tr class="tr_button">
            <td class="form_content" colspan="7" style="text-align: center">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>