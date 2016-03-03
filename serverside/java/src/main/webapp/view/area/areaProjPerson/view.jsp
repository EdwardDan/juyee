<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<div class="div_space"></div>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="table_thin_line_center" border="1" id="table1">
        <tr class="tr_header">
            <td style="width: 5%;text-align: center;">序号</td>
            <td style="width: 15%;text-align: center;">合同信息报送编号</td>
            <td style="width: 15%;text-align: center;">单位类型</td>
            <td style="width: 15%;text-align: center;">单位名称</td>
            <td style="width: 15%;text-align: center;">单位负责人</td>
            <td style="width: 15%;text-align: center;">身份证号</td>
            <td style="width: 15%;text-align: center;">电话号码</td>
        </tr>
        <c:if test="${not empty bean}">
            <c:forEach items="${bean.areaProjPersons}" var="item">
                <tr style="height: 30px;">
                    <td style="text-align: center;">${item.num}</td>
                    <td style="text-align: center;">${item.contractCode}</td>
                    <td style="text-align: center;">${item.unitType.name}</td>
                    <td style="text-align: center;">${item.unitName}</td>
                    <td style="text-align: center;">${item.unitMainPerson}</td>
                    <td style="text-align: center;">${item.unitIdCard}</td>
                    <td style="text-align: center;">${item.unitPhone}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</div>
<div class="div_space"></div>
<div style="text-align: center;">
    <input type="button" value="取消" class="button_cancel" onclick="parent.closeWindow()">
</div>
