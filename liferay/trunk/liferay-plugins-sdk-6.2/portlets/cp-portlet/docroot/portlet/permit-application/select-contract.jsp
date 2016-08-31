<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/permit-application" />
<portlet:renderURL var="searchURL">
	<portlet:param name="mvcPath"
		value="${contextPath }/select-contract.jsp" />
</portlet:renderURL>
<liferay-ui:panel-container accordion="false" extended="true">
	<liferay-ui:panel title="查询条件" collapsible="true">
		<aui:form name="fm" method="get" action="${searchURL }">
			<aui:input name="p_p_id" type="hidden" useNamespace="false"
				value="${portletDisplay.id }"></aui:input>
			<aui:input name="mvcPath" type="hidden"
				value="${contextPath }/select-contract.jsp"></aui:input>
			<table style="width: 100%;" border="1">
				<tr>
					<td style="width: 10%;">报建编号</td>
					<td style="width: 40%;"><aui:input type="text" name="bjbh"
							label="" /></td>
					<td style="width: 15%;">标段号</td>
					<td style="width: 35%;"><aui:input type="text" name="bdh"
							label="" /></td>
				</tr>
				<tr>
					<td style="width: 10%;">合同名称</td>
					<td colspan="3"><aui:input type="text" name="gcmc" label=""
							cssClass="span12" /></td>
				</tr>
				<tr style="height: 40px;">
					<td colspan="4" align="center"><aui:button type="submit"
							value="查询"></aui:button></td>
				</tr>
			</table>
		</aui:form>
	</liferay-ui:panel>
	<liferay-ui:panel title="已报送施工总包合同信息列表" collapsible="false">
		已报送施工总包合同信息列表
		${contracts } ${contractsCount }
		
		<c:set var="contextPath"
			value="${request.contextPath}/portlet/permit-application" />
		<portlet:renderURL var="editPermitURL">
			<portlet:param name="mvcPath" value="${contextPath }/edit-permit.jsp" />
		</portlet:renderURL>
		<aui:button type="button" value="选择" href="${editPermitURL }"></aui:button>
	</liferay-ui:panel>
</liferay-ui:panel-container>