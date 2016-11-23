<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="table_thin_line_center" border="1">
        <tr class="tr_title">
            <td colspan="9" align="center">
               企业资质统计汇总
            </td>
        </tr>
        <tr class="tr_header">
            <td width="25%" class="tr_header" nowrap>企业类型</td>
            <td width="25%" class="tr_header" nowrap>本市</td>
            <td width="25%" class="tr_header" nowrap>外省市</td>
            <td width="25%" class="tr_header" nowrap>合计</td>
        </tr>
        <c:forEach var="item" items="${mapList}">
            <tr class="tr_light">
                <td>${item['TYPEDESC']}</td>
                <td>${item['THISCITY']}</td>
                <td>${item['OTHERCITY']}</td>
                <td>${item['TOTAL']}</td>
            </tr>
        </c:forEach>
    </table>
    <div style="height: 50px;"></div>
</div>
