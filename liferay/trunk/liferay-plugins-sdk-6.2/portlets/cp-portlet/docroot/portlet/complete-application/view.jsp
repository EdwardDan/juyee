<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>

<c:set var="contextPath"
	value="${request.contextPath}/portlet/complete-application" />
<portlet:renderURL var="searchURL">
	<portlet:param name="mvcPath"
		value="${contextPath }/apply-complete.jsp" />
</portlet:renderURL>
<portlet:actionURL var="deleteCompletesURL" name="deleteCompletes">
	<portlet:param name="redirect" value="${viewURL}" />
</portlet:actionURL>
<%
	int rowNo = 0;
%>
<portlet:renderURL var="selectProjectURL">
	<portlet:param name="mvcPath"
		value="${contextPath }/select-project.jsp" />
</portlet:renderURL>
<liferay-ui:panel-container accordion="false" extended="true">
	<liferay-ui:panel title="查询条件" collapsible="true">
		<aui:form name="fm" method="get" action="${searchURL }">
			<aui:input name="p_p_id" type="hidden" useNamespace="false"
				value="${portletDisplay.id }"></aui:input>
			<aui:input name="mvcPath" type="hidden" useNamespace="false"
				value="${contextPath }/apply-complete.jsp"></aui:input>
			<aui:input type="hidden" name="delta" value="${delta}"></aui:input>
			<table style="width: 100%;" class="table table-bordered">
				<tr>
					<td style="width: 10%;" class="text-right">报建编号</td>
					<td style="width: 40%;" class="bg-white"><aui:input
							type="text" name="bjbh" style="width:80%" label="" /></td>
					<td style="width: 10%;" class="text-right">网上申请编号</td>
					<td style="width: 40%;" class="bg-white"><aui:input
							type="text" name="wssqbh" style="width:80%" label="" /></td>
				</tr>
				<tr>
					<td style="width: 10%;" class="text-right">工程名称</td>
					<td style="width: 40%;" class="bg-white"><aui:input
							type="text" name="gcmc" style="width:80%" label="" /></td>
					<td style="width: 10%;" class="text-right">状态</td>
					<td style="width: 40%;" class="bg-white"><aui:select name="zt"
							showEmptyOption="true" cssClass="input-small" label="">
							<aui:option value="" label="请选择"></aui:option>
						</aui:select></td>
				</tr>
				<tr style="height: 40px;">
					<td colspan="4" align="center" class="bg-white"><aui:button
							type="submit" value="查询"></aui:button> <aui:button type="button"
							value="申请" href="${selectProjectURL}"></aui:button></td>
				</tr>
			</table>
		</aui:form>
	</liferay-ui:panel>

	<liferay-ui:panel title="竣工备案列表" collapsible="false">
		<liferay-ui:search-container emptyResultsMessage="没有施工许可数据。">
			<liferay-ui:search-container-results results="${completes}"
				total="${completesCount }">
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="Complete"
				keyProperty="completeId" modelVar="complete">
				<%
					CompleteProjectProfile projectProfile = CompleteProjectProfileLocalServiceUtil
											.getCompleteProjectProfile(complete
													.getCompleteId());
									int applyStatus = complete.getSqzt();
				%>
				<liferay-portlet:renderURL varImpl="rowURL">
					<portlet:param name="bjbh" value="${complete.bjbh}" />
					<portlet:param name="sqbz" value="${complete.sqbz}" />
					<portlet:param name="completeId" value="${complete.completeId}" />
					<portlet:param name="mvcPath"
						value="${contextPath }/edit-complete.jsp" />
				</liferay-portlet:renderURL>
				<portlet:renderURL var="viewCompleteURL">
					<portlet:param name="mvcPath"
						value="${contextPath}/view-complete.jsp" />
					<portlet:param name="completeId" value="${complete.completeId}" />
				</portlet:renderURL>

				<liferay-ui:search-container-column-text
					value="<%=String.valueOf(++rowNo)%>" />
				<liferay-ui:search-container-column-text property="bjbh" name="报建编号" />
				<liferay-ui:search-container-column-text property="wssqbh"
					name="网上申请编号" />
				<liferay-ui:search-container-column-text property="babh" name="备案编号" />
				<liferay-ui:search-container-column-text
					value="<%=projectProfile.getGcmc() %>" name="工程名称"
					href="${rowURL }" />
				<liferay-ui:search-container-column-text name="上报日期"
					href="${rowURL }">
					<fmt:formatDate value="${complete.sbrq}" pattern="yyyy-MM-dd" />
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>
		</liferay-ui:search-container>
	</liferay-ui:panel>

</liferay-ui:panel-container>
