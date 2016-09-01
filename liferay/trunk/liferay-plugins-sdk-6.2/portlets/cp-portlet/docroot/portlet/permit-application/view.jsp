<%@page import="com.justonetech.cp.permit.service.ProjectProfileLocalServiceUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ page import="com.justonetech.cp.permit.model.ProjectProfile"%>
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
					<td style="width: 35%;"><aui:input type="text" name="wssqbh"
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
		<liferay-ui:search-container emptyResultsMessage="没有施工许可数据。">
			<liferay-ui:search-container-results results="${permits }"
				total="${permitsCount }">
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="com.justonetech.cp.permit.model.Permit" keyProperty="permitId" modelVar="permit"> 
				<liferay-portlet:renderURL varImpl="rowURL">
					<portlet:param name="bjbh" value="${permit.bjbh}" />
					<portlet:param name="mvcPath"
						value="${contextPath }/edit-permit.jsp" />
				</liferay-portlet:renderURL> 
				<liferay-ui:search-container-column-text property="wssqbh"
					name="网上申请编号" />
					<liferay-ui:search-container-column-text property="bjbh"
					name="报建编号" />
					<liferay-ui:search-container-column-text property="bdh"
					name="施工许可标段号" />
					<%
					ProjectProfile projectProfile= ProjectProfileLocalServiceUtil.getProjectProfile(permit.getPermitId());%>
					<liferay-ui:search-container-column-text  value="<%=projectProfile.getGcmc() %>"
					name="工程名称" href="${rowURL }" />
					<liferay-ui:search-container-column-text property="sqzt"
					name="申请状态" />
					<liferay-ui:search-container-column-text name="操作">
				<liferay-ui:icon-menu>
					<liferay-ui:icon image="edit" url="${editStudent}" />
					<liferay-ui:icon-delete image="delete" url="${deleteStudent}" />
					<liferay-ui:icon image="view" url="${listExamStudent}" />
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
				<%-- <liferay-ui:search-container-column-text property="zzjgdm"
					name="组织机构代码" href="${rowURL }" />
				<liferay-ui:search-container-column-text property="bjbh"
					name="报建编号" href="${rowURL }" />
				<liferay-ui:search-container-column-text property="sqbz"
					name="申请步骤" href="${rowURL }" /> --%>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</liferay-ui:panel>
</liferay-ui:panel-container>