<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<style type="text/css">
tr.body td.content {
	background-color: white;
}
</style>
<liferay-ui:header title="竣工备案审核" />
<%
	String bjbh = ParamUtil.getString(renderRequest, "bjbh");
	String wssqbh = ParamUtil.getString(renderRequest, "wssqbh");
	String gcmc = ParamUtil.getString(renderRequest, "gcmc");
	int status = ParamUtil.getInteger(renderRequest, "state");
	int defaultDelta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
	int delta = ParamUtil.getInteger(renderRequest, "delta", defaultDelta);
	int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
	int start = delta * (cur - 1);
	int end = delta * cur;
	List<Complete> completes = CompleteLocalServiceUtil.getCompletes("", bjbh, wssqbh, gcmc, status, start, end);
	int completesCount = CompleteLocalServiceUtil.getCompletesCount("", bjbh, wssqbh, gcmc, status);
	request.setAttribute("completes", completes);
	request.setAttribute("completesCount", completesCount);
%>
<portlet:renderURL var="searchURL" />
<c:set var="contextPath"
	value="${request.contextPath}/portlet/complete-approval" />
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
					<td colspan="3" class="bg-white"><aui:input type="text"
							name="gcmc" style="width:80%" label="" /></td>
					<%-- <td style="width: 10%;" class="text-right">状态</td>
					<td style="width: 40%;" class="bg-white"><aui:select name="zt"
							showEmptyOption="true" cssClass="input-small" label="">
							<aui:option value="1" label="填写"></aui:option>
							<aui:option value="2" label="已备案"></aui:option>
						</aui:select></td> --%>
				</tr>
				<tr style="height: 40px;">
					<td colspan="4" align="center" class="bg-white"><aui:button
							type="submit" value="查询"></aui:button></td>
				</tr>
			</table>
		</aui:form>
	</liferay-ui:panel>

	<%
		int sortNo = 0;
			String stateLabel = "所有,填写,已备案";
			String stateValue = "0,1,2";
	%>
	<liferay-ui:panel title="竣工备案列表" collapsible="false">
		<liferay-ui:tabs names="<%=stateLabel%>" param="state"
			tabsValues="<%=stateValue%>" url="<%=searchURL%>" type="pills">
		</liferay-ui:tabs>
		<liferay-ui:search-container emptyResultsMessage="没有竣工备案数据。">
			<liferay-ui:search-container-results results="${completes}"
				total="${completesCount}"/>
			<liferay-ui:search-container-row className="Complete"
				keyProperty="completeId" modelVar="complete">
				<%
					CompleteProjectProfile projectProfile = CompleteProjectProfileLocalServiceUtil
											.getCompleteProjectProfile(complete.getCompleteId());
				%>
				<liferay-ui:search-container-column-text
					value="<%=String.valueOf(++sortNo)%>" name="序号" />
				<liferay-ui:search-container-column-text property="bjbh" name="报建编号" />
				<liferay-ui:search-container-column-text property="wssqbh"
					name="网上申请编号" />
				<liferay-ui:search-container-column-text property="babh" name="备案编号" />
				<liferay-ui:search-container-column-text
					value="<%=projectProfile.getGcmc() %>" name="工程名称"/>
				<liferay-ui:search-container-column-text name="上报日期">
					<fmt:formatDate value="${complete.sbrq}" pattern="yyyy-MM-dd" />
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="状态"
					value="${(complete.status==2)?\"已备案\":\"填写\" }"/>
				<liferay-ui:search-container-column-text name="action">
					<liferay-ui:icon-menu>
					<portlet:renderURL var="viewCompleteURL">
						<portlet:param name="mvcPath" value="${contextPath}/view-complete.jsp"/>
						<portlet:param name="completeId" value="${complete.completeId}"/>
					</portlet:renderURL>
						<liferay-ui:icon image="view" url="${viewCompleteURL}"/>
						<liferay-ui:icon image="check" url="${rowURL}"/>
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</liferay-ui:panel>
</liferay-ui:panel-container>