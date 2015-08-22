<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<div class="form_div">
<table cellpadding="0" cellspacing="0" class="form_table">
<tr class="tr_light">
    <td class="form_label_right" style="width: 20%;">工可批复总投资（亿元）：</td>
    <td class="form_content" style="width: 80%;">${bean.gctxGkpfTotal}</td>
</tr>
<tr class="tr_dark">
    <td class="form_label_right">初设批复总投资（亿元）：</td>
    <td class="form_content">${bean.gctxCspfTotal}</td>
</tr>
<tr class="tr_light">
    <td class="form_label_right">资金来源：</td>
    <td class="form_content">${bean.gctxSourceFund}</td>
</tr>
<tr>
    <td colspan="2">
        <div class="div_space"></div>
        <table cellpadding="0" cellspacing="0" class="table_thin_line" border="1" style="width: 99%;">
            <tr class="tr_header">
                <td style="width: 15%;">截止时间</td>
                <td style="width: 30%;">累计完成投资（亿元）</td>
            </tr>
            <c:forEach items="${listType1}" var="type1" varStatus="status1">
                <tr style="height: 30px;">
                    <td style=";width: 15%;text-align: center;">${type1.title}</td>
                    <td style="width: 30%;text-align: center;">${type1.accComplete}</td>
                </tr>
            </c:forEach>
        </table>
        <div class="div_space"></div>
    </td>
</tr>
<tr>
    <td colspan="2">
        <table cellpadding="0" cellspacing="0" class="table_thin_line" border="1" style="width: 99%;">
            <tr class="tr_header">
                <td style="width: 15%;">时间</td>
                <td style="width: 30%;">年度计划投资（亿元）</td>
            </tr>
            <c:forEach items="${listType2}" var="type2" varStatus="status2">
                <tr style="height: 30px;">
                    <td style="width: 15%;text-align: center;">${type2.title}</td>
                    <td style="width: 30%;text-align: center;">${type2.accComplete}</td>
                </tr>
            </c:forEach>
        </table>
        <div class="div_space"></div>
    </td>
</tr>
<tr>
    <td colspan="2">
        <table cellpadding="0" cellspacing="0" class="table_thin_line" border="1" style="width: 99%;">
            <tr class="tr_header">
                <td style="width: 15%;">时间</td>
                <td style="width: 30%;">累计完成投资（亿元）</td>
            </tr>
            <c:forEach items="${listType3}" var="type3" varStatus="status3">
                <tr style="height: 30px;">
                    <td style="width: 15%;text-align: center;">${type3.title}</td>
                    <td style="width: 30%;text-align: center;">${type3.accComplete}</td>
                </tr>
            </c:forEach>
        </table>
        <div class="div_space"></div>
    </td>
</tr>
<tr>
    <td colspan="2">
        <table cellpadding="0" cellspacing="0" class="table_thin_line" border="1" style="width: 99%;">
            <tr class="tr_header">
                <td style="width: 15%;">时间</td>
                <td style="width: 30%;">财政资金已拨付额（亿元）</td>
                <td style="width: 30%;">财政资金已完成额（亿元））</td>
            </tr>
            <c:forEach items="${listType4}" var="type4" varStatus="status4">
                <tr style="height: 30px;">
                    <td style="width: 15%;text-align: center;">${type4.title}</td>
                    <td style="width: 30%;text-align: center;">${type4.czzjYbf}</td>
                    <td style="width: 30%;text-align: center;">${type4.czzjYwc}</td>
                </tr>
            </c:forEach>
        </table>
    </td>
</tr>
<tr class="tr_button" style="text-align: center;">
    <td class="form_content" colspan="2" style="text-align: center;">
        <input type="button" value="关闭" class="button_cancel" onclick="parent.closeWindow()">
    </td>
</tr>
</table>
</div>