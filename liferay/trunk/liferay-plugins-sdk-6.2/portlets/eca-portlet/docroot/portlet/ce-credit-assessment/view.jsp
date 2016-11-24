<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/portlet/common/init.jsp"%>

<c:set var="contextPath" value="${request.contextPath}/portlet/ce-credit-assessment" />
<portlet:renderURL var="viewURL"/>
<aui:form action="${viewURL }">
<liferay-ui:search-container id="tvSeriesSearchContainer" delta="10" emptyResultsMessage="没有施工企业信用评价数据" >

	<aui:fieldset>
		<aui:input name="enterpriseName" label="企业名称" inlineField="true" inlineLabel="left"></aui:input>
		<aui:input name="enterpriseCode" label="企业组织机构代码" inlineField="true" inlineLabel="left"></aui:input>
		<aui:button type="submit" value="查询"></aui:button>
	</aui:fieldset>
	<liferay-ui:search-container-results results="${ceCreditAssessments }" total="${ceCreditAssessmentsCount }"/>

	<liferay-ui:search-container-row indexVar="index" className="com.justonetech.eca.model.CECreditAssessment" keyProperty="enterpriseCode" modelVar="ceCreditAssessment">
		<liferay-ui:search-container-column-text value="<%=String.valueOf(index+1) %>" name="序号" align="center"/>
		<liferay-ui:search-container-column-text property="enterpriseName" name="企业名称"/>
		<liferay-ui:search-container-column-text name="当日评分">
			<portlet:renderURL var="curDayScoreURL">
				<portlet:param name="mvcPath" value="${contextPath}/cur-day-score.jsp"/>
				<portlet:param name="enterpriseCode" value="<%=ceCreditAssessment.getEnterpriseCode()%>"/>
			</portlet:renderURL>
			<aui:a href="${curDayScoreURL }">当日评价分值</aui:a>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="上月评分分值">
			<%=ceCreditAssessment.getUltoScore() %>
			<portlet:renderURL var="ultoScoreScoreURL">
				<portlet:param name="mvcPath" value="${contextPath}/ulto-score.jsp"/>
				<portlet:param name="ultoReportId" value="<%=ceCreditAssessment.getUltoReportId()%>"/>
			</portlet:renderURL>
			<aui:a href="${ultoScoreScoreURL }">明细</aui:a>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text property="ultoScoreBaseDate" name="上月评分基准日"/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator type="approximate"/>
</liferay-ui:search-container>
</aui:form>