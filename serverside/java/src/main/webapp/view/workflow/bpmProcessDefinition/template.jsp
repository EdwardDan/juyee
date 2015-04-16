<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<script type="text/javascript">
    function viewTemplate(id, column) {
        var strFeatures = "dialogWidth=800px;dialogHeight=600px;center=yes;help=no;resizable:yes";
        openFullWindow("${ctx}/bpmFormTemplate/viewTemplate.do?id=" + id + "&column=" + column,800,500);
    }
    function viewFormHtml(id) {
        openFullWindow("${ctx}/bpmFormTemplate/viewFormHtml.do?id=" + id + "", 800,500);
    }
</script>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_header">
            <td class="form_border" width="10%">序号</td>
            <td class="form_border" width="25%">类型</td>
            <td class="form_border" width="25%">模板名称</td>
            <td class="form_border" width="40%">模板预览</td>
        </tr>
        <c:forEach var="bean" items="${forms}" varStatus="status">
            <c:choose>
                <c:when test="${status.count%2==0}">
                    <tr class="tr_light" align="center">
                </c:when>
                <c:otherwise>
                    <tr class="tr_dark" align="center">
                </c:otherwise>
            </c:choose>
            <td class="form_border">${status.count}&nbsp;</td>
            <td class="form_border">${bean.type}&nbsp;</td>
            <td class="form_border">${bean.name}&nbsp;</td>
            <td class="form_border">
                <input type="button" class="button_normal_long" value="模板定义"
                       onclick="viewTemplate(${bean.id},'parXml');">
                <input type="button" class="button_normal_long" value="模板源码"
                       onclick="viewTemplate(${bean.id},'htmlTemplate');">
                <input type="button" class="button_normal_long" value="网页预览"
                       onclick="viewFormHtml(${bean.id})">
            </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4" class="form_border"></td>
        </tr>
    </table>
</div>