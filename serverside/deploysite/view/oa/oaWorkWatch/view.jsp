<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label_right" style="width: 15%;">上报科室：</td>
            <td class="form_content" style="width: 35%;">
                ${bean.reportDept}
            </td>
            <td class="form_label_right" style="width: 15%;">科室分管领导：</td>
            <td class="form_content" style="width: 35%;">
                ${bean.reportPerson}
            </td>
        </tr>
    </table>
    <table cellpadding="0" cellspacing="0" border="1" class="table_thin_line" style="text-align: center;width: 98%;">
        <tr class="tr_header">
            <td style="width: 5%;">序号</td>
            <td style="width: 25%;">工作内容</td>
            <td style="width: 8%;">时间节点</td>
            <td style="width: 8%;">上报形式</td>
            <td style="width: 20%;;">完成情况</td>
            <td style="width: 10%;">审核情况</td>
        </tr>
        <c:forEach items="${bean.oaWorkWatchItems}" var="item">
            <tr class="tr_light">
                <td>${item.orderNo}</td>
                <td style="text-align: left;"><sys:toHtml>${item.content}</sys:toHtml></td>
                <td>${item.timeNode}</td>
                <td>${item.reportMethod}</td>
                <td style="text-align: left;"><sys:toHtml>${item.completeDesc}</sys:toHtml></td>
                <td>
                    <select name="actualDesc" disabled>
                        <option value=""></option>
                        <option value="属实" <c:if test="${item.actualDesc =='属实'}"> selected </c:if> >属实</option>
                        <option value="不属实"
                                <c:if test="${item.actualDesc =='不属实'}">selected </c:if> >不属实
                        </option>
                    </select>
                </td>
            </tr>
        </c:forEach>
    </table>
    <c:if test="${not empty bean.zrOpinion}">
        <div style="height: 10px"></div>
        <fieldset class="form_fieldset" style="width: 96%;">
            <legend class="form_legend">
                主任审核
            </legend>
            <table cellpadding="0" cellspacing="0" class="form_table" style="text-align: center">
                <tr class="tr_light">
                    <td class="form_label_right" style="width: 15%" colspan="1">
                        审核意见：
                    </td>
                    <td class="form_content">
                        <sys:toHtml>${bean.zrOpinion}</sys:toHtml>
                    </td>
                </tr>
            </table>
        </fieldset>
    </c:if>
    <c:if test="${not empty bean.bgsOpinion}">
        <div style="height: 10px"></div>
        <fieldset class="form_fieldset" style="width: 96%;">
            <table cellpadding="0" cellspacing="0" class="form_table" style="text-align: center">
                <tr class="tr_light">
                    <td class="form_label_right" style="width: 15%" colspan="1">
                        核实意见：
                    </td>
                    <td class="form_content">
                        <sys:toHtml>${bean.bgsOpinion}</sys:toHtml>
                    </td>
                </tr>
            </table>
        </fieldset>
    </c:if>
    <table cellpadding="0" cellspacing="0" class="form_table" style="text-align: center">
        <tr class="tr_button">
            <td style="text-align: center">
                <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>
