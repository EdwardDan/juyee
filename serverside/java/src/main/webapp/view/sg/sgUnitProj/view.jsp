<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<div class="div_space"></div>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="table_thin_line_center" border="1" id="table1">
        <tr class="tr_header">
            <td style="width: 5%;text-align: center;">序号</td>
            <td style="width: 8%;text-align: center;">单位工程编号</td>
            <td style="width: 10%;text-align: center;">单位工程名称</td>
            <td style="width: 10%;text-align: center;">单位工程类型</td>
            <td style="width: 40%;text-align: center;">工程指标</td>
        </tr>
        <c:if test="${not empty bean}">
            <c:forEach items="${bean.sgUnitProjs}" var="item">
                <tr style="height: 30px;">
                    <td style="text-align: center;">${item.num}</td>
                    <td style="text-align: center;">${item.unitProjCode}</td>
                    <td style="text-align: center;">${item.unitProjName}</td>
                    <td style="text-align: center;">${item.unitProjType.name}</td>
                    <td style="text-align: center;">${item.projectIndex}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</div>
<div class="div_space"></div>
<div style="text-align: center;">
    <input type="button" value="取消" class="button_cancel" onclick="parent.closeWindow()">
</div>