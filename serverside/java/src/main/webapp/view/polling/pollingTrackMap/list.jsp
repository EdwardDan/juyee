<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>

<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_header">
            <td align="left" style="padding-left: 20px">巡检记录单列表</td>
            <td align="right" style="padding-right: 20px">
                <input type="button" value="返回" class="button_back" onclick="window.history.back(-1)">
            </td>
        </tr>
    </table>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_header">
            <td class="form_border">监督任务书编号</td>
            <td class="form_border">报建编号</td>
            <td class="form_border">工程名称</td>
            <td class="form_border">监督类别</td>
            <td class="form_border">监督阶段</td>
            <td class="form_border">监督日期</td>
            <td class="form_border">监督记录附件</td>


        </tr>
        <c:forEach items="${list}" var="item" varStatus="status">
            <tr
                    <c:choose>
                        <c:when test="${(status.index) % 2 == 0}">class="tr_dark" </c:when>
                        <c:otherwise>class="tr_light"</c:otherwise>
                    </c:choose>>
                <td class="form_border">&nbsp;${item.jdTaskCode}</td>
                <td class="form_border">&nbsp;${item.bjbh}</td>
                <td class="form_border">&nbsp;${item.projectName}</td>
                <td class="form_border">&nbsp;${item.pollingType}</td>
                <td class="form_border">&nbsp;${item.stage}</td>
                <td class="form_border">&nbsp;
                    <fmt:formatDate value="${item.pollingDate}" pattern="yyyy-MM-dd"/>
                </td>
                <td class="form_border">&nbsp;${item.pollingRecodDoc}</td>
            </tr>
        </c:forEach>
    </table>
</div>
