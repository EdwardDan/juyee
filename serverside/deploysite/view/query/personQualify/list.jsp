<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="table_thin_line_center" border="1">
        <tr class="tr_title">
            <td colspan="9" align="center">
                执业资格统计汇总
            </td>
        </tr>
        <%--<tr>--%>
            <%--<td width="20%" class="tr_header" rowspan="2">注册证书类型</td>--%>
            <%--<td width="20%" class="tr_header" rowspan="2">等级</td>--%>
            <%--<td width="40%" class="tr_header" colspan="2">本市人员</td>--%>
            <%--<td width="20%" class="tr_header" rowspan="2">外省市备案人员</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td class="tr_header">注册</td>--%>
            <%--<td class="tr_header">资格</td>--%>
        <%--</tr>--%>
        <tr>
            <td width="20%" class="tr_header">注册证书类型</td>
            <td width="20%" class="tr_header">等级</td>
            <td width="40%" class="tr_header">本市人员</td>
            <td width="20%" class="tr_header">外省市备案人员</td>
        </tr>
        <c:forEach var="item" items="${mapList}">
            <tr class="tr_light">
                <td>${item['QUALIFY_TYPE_DESC']}</td>
                <td>${item['QUALIFY_LEVEL_DESC']}</td>
                <td>${item['THISCITY']}</td>
                <td>${item['OTHERCITY']}</td>
            </tr>
        </c:forEach>
    </table>
    <div style="height: 50px;"></div>
</div>

