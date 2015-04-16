<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<table cellpadding="0" cellspacing="0" class="form_table" border="0">
    <input type="hidden" name="bjbhNew" id="bjbhNew" value="${bjbh}">
    <input type="hidden" name="projectNameNew" id="projectNameNew" value="${project.data.projectName}">
    <input type="hidden" name="gdCodeNew" id="gdCodeNew" value="${gdCode}">
    <input type="hidden" name="gdNameNew" id="gdNameNew" value="${gdName}">
    <%--<input type="hidden" name="buildUnitName" id="buildUnitName" value="${project.data.buildUnitName}">--%>
    <%--<input type="hidden" name="sgUnitName" id="sgUnitName" value="${gd.sgTotalUnitName}">--%>
</table>