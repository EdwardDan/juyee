<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<link rel="stylesheet" href="/static/viewer-master/viewer.min.css">
<script src="/static/viewer-master/viewer.min.js"></script>
<style>
.aui .table th, .aui .table td {
	vertical-align: middle;
	padding: 8px;
}

.aui input[type="file"] {
	width: 150px;
}
</style>

<%
	long completeId =ParamUtil.getLong(renderRequest,"completeId");
%>

<c:set var="namespace" value="<%=renderResponse.getNamespace()%>"></c:set>

<table class="table table-bordered" style="font-size: 14px;"
	id="fileTable">
	<tr style="text-align: center; height: 45px;">
		<td style="text-align: center; width: 5%;">序号</td>
		<td style="text-align: center; width: 40%;">申请材料名称</td>
		<td style="text-align: center; width: 55%;">附件</td>
	</tr>
	

</table>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/complete-approval" />
<portlet:renderURL var="previewPdfURL" windowState="pop_up">
	<portlet:param name="mvcPath"
		value="${contextPath}/view-complete/applymaterials-pdf.jsp" />
</portlet:renderURL>


