<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_header">
            <td class="form_border" width="5%">序号</td>
            <td class="form_border" width="15%">所属单位</td>
            <td class="form_border" width="15%">项目职务</td>
            <td class="form_border" width="15%">姓名</td>
            <td class="form_border" width="15%">联系电话</td>
        </tr>
        <c:forEach items="${list}" var="item" varStatus="status">
            <tr class="tr_light">
                <td class="form_border">&nbsp;${status.index+1}</td>
                <td class="form_border">&nbsp;${item.cbUnit}</td>
                <td class="form_border">&nbsp;${item.proHeader}</td>
                <td class="form_border">&nbsp;${item.proHeader}</td>
                <td class="form_border">&nbsp;${item.proHeaderPhone}</td>
            </tr>
        </c:forEach>
        <tr class="tr_button">
            <td class="form_td_line" align="center" colspan="5">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>