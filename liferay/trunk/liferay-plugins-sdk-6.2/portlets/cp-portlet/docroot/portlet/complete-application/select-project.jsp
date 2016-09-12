<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contextPath" value="${request.contextPath}/portlet/complete-application" />
<portlet:renderURL var="searchURL">
	<portlet:param name="mvcPath" value="${contextPath }/select-project.jsp" />
</portlet:renderURL>
<liferay-ui:panel-container accordion="false" extended="true">
	<liferay-ui:panel title="查询条件" collapsible="true">
		<aui:form name="fm" method="get" action="${searchURL }">
		<aui:input name="p_p_id" type="hidden" useNamespace="false" value="${portletDisplay.id }"></aui:input>
			<aui:input name="mvcPath" type="hidden" value="${contextPath }/select-project.jsp"></aui:input>
			<table style="width: 100%;" class="table table-bordered">
				<tr>
					<td style="width: 10%;" class="text-right">报建编号</td>
					<td style="width: 40%;" class="bg-white"><aui:input type="text" name="bjbh"
							label="" /></td>
					<td style="width: 15%;" class="text-right">网上申请编号</td>
					<td style="width: 35%;" class="bg-white"><aui:input type="text" name="wssqbh"
							label="" /></td>
				</tr>
				<tr>
					<td class="text-right">项目名称</td>
					<td colspan="3" class="bg-white"><aui:input type="text" name="xmmc" label=""
							cssClass="span12" /></td>
				</tr>
				<tr>
					<td class="text-right">报建日期从</td>
					<td class="bg-white"><aui:input type="text" name="bjrqStart"
							cssClass="Wdate input-small" label=""
							onfocus="WdatePicker({maxDate:\'#F{$dp.$D(\\'${renderResponse.namespace }bjrqEnd\\');}\'})"
							inlineField="true"></aui:input> &nbsp;至&nbsp; <aui:input
							type="text" name="bjrqEnd" cssClass="Wdate input-small" label=""
							onfocus="WdatePicker({minDate:\'#F{$dp.$D(\\'${renderResponse.namespace }bjrqStart\\');}\'})"
							inlineField="true"></aui:input></td>
					<td class="text-right">项目状态</td>
					<td class="bg-white"><aui:select name="bjwcbj" showEmptyOption="true"
							cssClass="input-small" label="">
							<aui:option value="y" label="已完成"></aui:option>
							<aui:option value="n" label="未完成"></aui:option>
						</aui:select></td>
				</tr>
				<tr style="height: 40px;">
					<td colspan="4" align="center" class="bg-white">
					<div class="text-center"><aui:button type="submit"
							value="查询"></aui:button></div>
					</td>
				</tr>
			</table>
		</aui:form>
	</liferay-ui:panel>
	<%
		int num = 1;
		String n = num + "";
	%>
	<c:set var="contextPath" value="${request.contextPath}/portlet/complete-application" />
	<liferay-ui:panel title="项目列表" collapsible="false">
		<liferay-ui:search-container emptyResultsMessage="没有报建项目数据。">
			<liferay-ui:search-container-results results="${projects}" total="${projectsCount}">
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="Project" modelVar="project" keyProperty="bjbh">
				<liferay-ui:search-container-column-text value="<%=n%>" name=" " />
				<%
					num = num + 1;
					n = num + "";
				%>
				<liferay-ui:search-container-column-text property="bjbh" name="报建编号" />
				<liferay-ui:search-container-column-text property="xmmc" name="项目名称" href="${editCompleteURL}" />
				<liferay-ui:search-container-column-text property="bj_webid" name="网上申报编号"/>
				<liferay-ui:search-container-column-text name="报建日期">
					<fmt:formatDate value="${project.bjrq}" pattern="yyyy-MM-dd" />
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="状态"
					value="${project.bjwcbj eq \"y\"?\"已完成\":\"未完成\" }"/>
				<portlet:renderURL var="editCompleteURL">
					<portlet:param name="mvcPath" value="${contextPath }/edit-complete.jsp" />
					<portlet:param name="bjbh" value="${project.bjbh}" />
				</portlet:renderURL>
				<liferay-ui:search-container-column-text name="操作">
					<liferay-ui:icon-menu>
						<a href="${editCompleteURL}">选择</a>
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator>
				<%
					String bjbh = ParamUtil.getString(request, "bjbh");
					PortletURL portletURL = searchContainer.getIteratorURL();
					portletURL.setParameter("mvcPath","/portlet/complete-application/select-project.jsp");
					portletURL.setParameter("bjbh", bjbh);
				%>
			</liferay-ui:search-iterator>
		</liferay-ui:search-container>
	</liferay-ui:panel>
</liferay-ui:panel-container>