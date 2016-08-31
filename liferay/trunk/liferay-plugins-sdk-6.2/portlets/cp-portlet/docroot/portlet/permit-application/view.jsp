<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/permit-application" />
<portlet:renderURL var="searchURL">
	<portlet:param name="mvcPath" value="${contextPath }/apply-permit.jsp" />
</portlet:renderURL>

<portlet:renderURL var="selectContractURL">
	<portlet:param name="mvcPath" value="${contextPath }/select-contract.jsp" />
</portlet:renderURL>
<liferay-ui:panel-container accordion="false" extended="true">
	<liferay-ui:panel title="查询条件" collapsible="true">
		<aui:form name="fm" method="get" action="${searchURL }">
			<aui:input name="p_p_id" type="hidden" useNamespace="false"
				value="${portletDisplay.id }"></aui:input>
				<aui:input name="mvcPath" type="hidden" useNamespace="false"
				value="${contextPath }/apply-permit.jsp"></aui:input>
			<aui:input type="hidden" name="delta" value="${delta}"></aui:input>
			<table style="width: 100%;" border="1">
				<tr>
					<td style="width: 10%;">报建编号</td>
					<td style="width: 40%;"><aui:input type="text" name="bjbh"
							label="" /></td>
					<td style="width: 15%;">网上申请编号</td>
					<td style="width: 35%;"><aui:input type="text" name="bdh"
							label="" /></td>
				</tr>
				<tr>
					<td style="width: 10%;">工程名称</td>
					<td colspan="3"><aui:input type="text" name="gcmc" label=""
							cssClass="span12" /></td>
				</tr>
				<tr style="height: 40px;">
					<td colspan="4" align="center"><aui:button type="submit"
							value="查询"></aui:button> <aui:button type="button" value="申请"
							href="${selectContractURL}"></aui:button></td>
				</tr>
			</table>
		</aui:form>
	</liferay-ui:panel>
	<liferay-ui:panel title="施工许可列表" collapsible="false">
		施工许可列表${permits } ${permitsCount }
	</liferay-ui:panel>
</liferay-ui:panel-container>