<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/project-search" />
<liferay-ui:header title="报建项目查询" />
<liferay-portlet:renderURL varImpl="iteratorURL" plid="${plid}"
	portletName="${portletDisplay.id }">
	<liferay-portlet:param name="bjbh" value="${bjbh }" />
	<liferay-portlet:param name="wssqbh" value="${wssqbh }" />
	<liferay-portlet:param name="xmmc" value="${xmmc }" />
	<liferay-portlet:param name="bjrqStart" value="${bjrqStart }" />
	<liferay-portlet:param name="bjrqEnd" value="${bjrqEnd }" />
	<liferay-portlet:param name="bjwcbj" value="${bjwcbj }" />
	<liferay-portlet:param name="delta" value="${delta }" />
	<liferay-portlet:param name="cur" value="${cur }" />
</liferay-portlet:renderURL>
<liferay-ui:panel-container accordion="false" extended="true">
	<liferay-ui:panel title="查询条件" collapsible="true">
		<aui:form name="fm" method="get">
			<aui:input name="p_p_id" type="hidden" useNamespace="false"
				value="${portletDisplay.id }"></aui:input>
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
					<td>项目名称</td>
					<td colspan="3"><aui:input type="text" name="xmmc" label=""
							cssClass="span12" /></td>
				</tr>
				<tr>
					<td>报建日期从</td>
					<td><aui:input type="text" name="bjrqStart"
							cssClass="Wdate input-small" label=""
							onfocus="WdatePicker({maxDate:\'#F{$dp.$D(\\'${renderResponse.namespace }bjrqEnd\\');}\'})"
							inlineField="true"></aui:input> &nbsp;至&nbsp; <aui:input
							type="text" name="bjrqEnd" cssClass="Wdate input-small" label=""
							onfocus="WdatePicker({minDate:\'#F{$dp.$D(\\'${renderResponse.namespace }bjrqStart\\');}\'})"
							inlineField="true"></aui:input></td>
					<td>项目状态</td>
					<td><aui:select name="bjwcbj" showEmptyOption="true"
							cssClass="input-small" label="">
							<aui:option value="y" label="已完成"></aui:option>
							<aui:option value="n" label="未完成"></aui:option>
						</aui:select></td>
				</tr>
				<tr style="height: 40px;">
					<td colspan="4" align="center"><aui:button type="submit"
							value="提交查询"></aui:button></td>
				</tr>
			</table>
		</aui:form>
	</liferay-ui:panel>
	<liferay-ui:panel title="项目列表" collapsible="false">
		<liferay-ui:search-container emptyResultsMessage="没有报建项目数据。"
			iteratorURL="<%=iteratorURL%>">
			<liferay-ui:search-container-results results="${projects }"
				total="${projectsCount }">
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="com.justonetech.cp.project.model.Project"
				modelVar="project" keyProperty="projectId">
				<liferay-portlet:renderURL varImpl="rowURL">
					<portlet:param name="projectId" value="${project.projectId}" />
					<portlet:param name="mvcPath"
						value="${contextPath }/view-project.jsp" />
				</liferay-portlet:renderURL>
				<liferay-ui:search-container-column-text property="projectId" name="报建编号"
					href="${rowURL }" align="right" />
				<liferay-ui:search-container-column-text property="xmmc"
					name="项目名称" href="${rowURL }" align="center" />
				<liferay-ui:search-container-column-text property="wssqbh"
					name="网上申报编号" href="${rowURL }" />
				<liferay-ui:search-container-column-text name="报建日期"
					href="${rowURL }">
					<fmt:formatDate value="${project.bjrq}" pattern="yyyy-MM-dd" />
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="状态"
					value="${project.bjwcbj eq \"y\"?\"已完成\":\"未完成\" }"
					href="${rowURL }" />
				<liferay-ui:search-container-column-text name="操作">
					<liferay-ui:icon-menu>
						<liferay-ui:icon image="view" label="查看" url="${rowURL}" />
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</liferay-ui:panel>
</liferay-ui:panel-container>





