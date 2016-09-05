<%@page import="com.justonetech.cp.permit.service.PermitLocalServiceUtil"%>
<%@page import="com.justonetech.cp.permit.service.ProjectProfileLocalServiceUtil"%>
<%@page import="com.justonetech.cp.permit.model.Permit"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<<<<<<< .mine
<portlet:renderURL var="searchURL"/>
<liferay-ui:header title="施工许可审核" />
<%	
	String _ywbh = ParamUtil.getString(request, "ywbh");
	String _bjbh = ParamUtil.getString(request, "bjbh");
	String _xmmc = ParamUtil.getString(request, "xmmc");
	String _xmlx = ParamUtil.getString(request, "xmlx");
	String _jsdw = ParamUtil.getString(request, "jsdw");
	String state = ParamUtil.getString(request, "state");
	int defaultDelta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
	int delta = ParamUtil.getInteger(renderRequest, "delta", defaultDelta);
	int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
	int start = delta * (cur - 1);
	int end = delta * cur;
	List<Permit> permits = PermitLocalServiceUtil.getPermits( start, end);
	int permitsCount = PermitLocalServiceUtil.getPermitsCount("", "", "", "");
	request.setAttribute("permits", permits);
	request.setAttribute("permitsCount", permitsCount);
%>
||||||| .r1338
=======
<c:set var="contextPath"
	value="${request.contextPath}/portlet/permit-approval" />
>>>>>>> .r1344
<liferay-ui:panel-container accordion="false" extended="true">
	<liferay-ui:panel title="查询条件" collapsible="true">
		<aui:form name="fm" id="fm" method="get" action="${searchURL}">
			<aui:input name="p_p_id" type="hidden" useNamespace="false"
				value="${portletDisplay.id }"></aui:input>
			<aui:input type="hidden" name="delta" value="${delta}"></aui:input>
			<table style="width: 100%;" border="1">
				<tr>
					<td style="width: 10%; text-align: right">业务编号：</td>
					<td style="width: 40%;"><aui:input type="text" name="ywbh"
							id="bjbh" label="" cssClass="span12" /></td>
					<td style="width: 15%; text-align: right">报建编号：</td>
					<td style="width: 35%;"><aui:input type="text" name="bjbh"
							label="" cssClass="span12" /></td>
				</tr>
				<tr>
					<td style="width: 10%; text-align: right">项目名称：</td>
					<td ><aui:input type="text" name="xmmc" label=""
							cssClass="span12" /></td>
					<td style="width: 15%; text-align: right">项目类型：</td>
					<td style="width: 35%;"><aui:input type="text" name="xmlx"
							label="" cssClass="span12" /></td>
				</tr>
				<tr>
					<td style="width: 10%; text-align: right">建设单位：</td>
					<td colspan="3"><aui:input type="text" name="jsdw" label=""
							cssClass="span12" /></td>
				</tr>
				<tr style="height: 40px;">
					<td colspan="4" align="center"><aui:button type="submit"
							value="提交查询"></aui:button></td>
				</tr>
			</table>
			<br>
			<%
				String stateLabel = "所有,撤回,未提交,已提交";
				String stateValue = "sy,ch,wtj,ytj";
			%>
			<liferay-ui:tabs names="<%=stateLabel%>" param="state"
				tabsValues="<%=stateValue%>" url="<%=searchURL%>" type="pills">
			</liferay-ui:tabs>
		</aui:form>
	</liferay-ui:panel>
	<%
		int sortNo = 0;
	%>
	<liferay-ui:panel title="施工许可列表" collapsible="false">
		<liferay-ui:search-container emptyResultsMessage="没有施工许可数据。">
			<liferay-ui:search-container-results results="${permits}"
				total="${permitsCount}">
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="com.justonetech.cp.permit.model.Permit"
				keyProperty="permitId" modelVar="permit">
				<%
					Long permitId = permit.getPermitId();
					String xmmc = ProjectProfileLocalServiceUtil.getProjectProfile(permitId).getGcmc();
					Long xmxz = ProjectProfileLocalServiceUtil.getProjectProfile(permitId).getXmxz();
					Long xmlx = ProjectProfileLocalServiceUtil.getProjectProfile(permitId).getXmlx();
					String jsdw = ProjectProfileLocalServiceUtil.getProjectProfile(permitId).getJsdwmc();
					request.setAttribute("xmxz", xmxz);
					request.setAttribute("xmmc", xmmc);
					request.setAttribute("xmlx", xmlx);
					request.setAttribute("jsdw", jsdw);
				%>
				<liferay-ui:search-container-column-text name="序号"
					value="<%=String.valueOf(++sortNo)%>" />
				<liferay-ui:search-container-column-text name="绿色" value="${xmxz==21817?'':'★' }"/>
				<liferay-ui:search-container-column-text property="ywbh" name="业务编号" />
				<liferay-ui:search-container-column-text property="bjbh" name="报建编号" />
				<liferay-ui:search-container-column-text name="项目名称" value="${xmmc}"/>
				<liferay-ui:search-container-column-text name="项目类型" value="${xmlx}"/>
				<liferay-ui:search-container-column-text name="建设单位" value="${jsdw}"/>
				<liferay-ui:search-container-column-text name="状态" value=""/>
				<liferay-ui:search-container-column-text name="操作">
					<liferay-ui:icon-menu>
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator/>
		</liferay-ui:search-container>
		<portlet:renderURL var="viewPermitURL">
			<portlet:param name="mvcPath" value="${contextPath}/view-permit.jsp"/>
		</portlet:renderURL>
		<aui:button href="${viewPermitURL }"></aui:button>
	</liferay-ui:panel>
</liferay-ui:panel-container>