<%@page
	import="com.justonetech.cp.contract.service.ContractLocalServiceUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/contract-search/view-contract" />
<%
	String contractId = ParamUtil.getString(request, "bjbh");
	Contract contract = ContractLocalServiceUtil.getContract(contractId);
	request.setAttribute("contract", contract);
%>
<style type="text/css">

tr.body td.title {
	width: 20%;
	text-align: right;
}

tr.body td.content {
	width: 30%;
	background-color: white;
}

</style>
<portlet:renderURL var="viewURL" />
<liferay-ui:header title="查看详细信息" backURL="${viewURL}" />
<liferay-ui:panel-container accordion="false" extended="true">
	<liferay-ui:panel title="项目信息" collapsible="false">
		<jsp:include page="${contextPath}/xmxx.jsp"/>
	</liferay-ui:panel>
	<liferay-ui:panel title="合同信息报送编号:${contract.contractId}" collapsible="false">
		<c:choose>
			<c:when test="<%=contract.getHtbh()!=null && contract.getHtbh().length()>=2 && contract.getHtbh().substring(0, 2).equals(\"CZ\")%>">
				<jsp:include page="${contextPath}/contract-cz.jsp"/>
			</c:when>
			<c:when test="<%=contract.getHtbh()!=null && contract.getHtbh().length()>=2 && contract.getHtbh().substring(0, 2).equals(\"VZ\")%>">
				<jsp:include page="${contextPath}/contract-vz.jsp"/>
			</c:when>
			<c:when test="<%=contract.getHtbh()!=null && contract.getHtbh().length()>=2 && contract.getHtbh().substring(0, 2).equals(\"WZ\")%>">
				<jsp:include page="${contextPath}/contract-wz.jsp"/>
			</c:when>
		</c:choose>
	</liferay-ui:panel>
</liferay-ui:panel-container>