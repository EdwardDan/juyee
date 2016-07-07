<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contentPath"
	value="${request.contextPath}/portlet/office-supply-application" />
<portlet:renderURL var="viewURL" />
<liferay-ui:header title='查看办公用品申请' backURL="${viewURL}" />
<div align="center">
	申请部门：<span>${officeSupplyApplication.deptName}</span> 　　　　　　　　　　　　　　申请人：<span>${officeSupplyApplication.userName}</span>
<table width="90%" border="1">
	<tr align="center">
		<td>申请物品</td>
		<td>型号</td>
		<td>单位</td>
		<td>预计单价</td>
		<td>数量</td>
	</tr>
	<c:forEach items="${officeSupplyApplicationItems}" var="items">
	<tr align="center">
		<td>${items.name}</td>
		<td>${items.model}</td>
		<td>${items.unit}</td>
		<td>${items.unitPrice}</td>
		<td>${items.quantity}</td>
	</tr>
	</c:forEach>
</table>
</div>
<div>
　　　　　申请说明：<span>${officeSupplyApplication.introductions}</span>
</div>