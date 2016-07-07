<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="com.justonetech.sys.model.Dictionary"%>
<%@page import="com.justonetech.sys.service.DictionaryLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ page import="java.util.*"%>
<%@ include file="/common/init.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<c:set var="contentPath"
	value="${request.contextPath}/portlet/construction-permit-material" />
<portlet:defineObjects />
<portlet:renderURL var="studentInput">
	<portlet:param name="mvcPath" value="${contentPath}/input.jsp" />
</portlet:renderURL>
<portlet:renderURL var="viewURL" />
<% long what=ParamUtil.getLong(request, "what");%>
<select name="projectType" onchange="test()">
			<%
			long groupId = PortalUtil.getScopeGroupId(request);
				Dictionary dictionary = DictionaryLocalServiceUtil
									.findByGroupIdAndCode(groupId, "ProjectType");
			if (null != dictionary) {
							List<Dictionary> dictionaries = DictionaryLocalServiceUtil
									.findByGroupIdAndParentId(groupId,
											dictionary.getDictionaryId(), -1, -1);
							for (Dictionary dic : dictionaries) {
			%>
			<option value="<%=dic.getDictionaryId()%>" <c:if test="<%=what==dic.getDictionaryId()%>">selected</c:if>><%=dic.getName()%></option>
			<%
				}}
			%>
</select> 
<aui:form action="${viewURL }" name="fm">
	<aui:nav-bar>
		<aui:nav>
			<portlet:renderURL var="addDispatchURL">
				<portlet:param name="mvcPath"
					value="${contentPath }/edit-dispatch.jsp" />
			</portlet:renderURL>
			 <aui:nav-item  iconCssClass="icon-plus"
				label="添加"  onclick="test1()"/>
		</aui:nav>
	</aui:nav-bar>
	<liferay-ui:search-container emptyResultsMessage="没有找到施工材料信息。"> 
		<liferay-ui:search-container-results results="${projApprovals}"
			total="${projApprovalsCount}">
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row className="com.justonetech.proj.approval.portlet.ProjApproval" modelVar="projApproval" keyProperty="dictionaryId">
			 
			<liferay-ui:search-container-column-text name="序号" property="no"/>
			<%Dictionary projectType=DictionaryLocalServiceUtil.getDictionary(projApproval.getDictionaryId());
			if(null!=projectType){
			%>
			<liferay-ui:search-container-column-text name="项目类型" value="<%=projectType.getName() %>"/>
			<%} %>
			 <%
			Dictionary materialType = DictionaryLocalServiceUtil.getDictionary(projApproval.getType());
			%> 
			<liferay-ui:search-container-column-text name="材料类型" value="<%=materialType.getName() %>"/>
			<liferay-ui:search-container-column-text name="材料名称" property="materialName"/>
			<liferay-ui:search-container-column-text name="审核要求" property="auditReq"/>
			<liferay-ui:search-container-column-text name="绿色审核要求" property="auditReqGreen"/>
			<liferay-ui:search-container-column-text name="应交份数" property="yjNum"/>
			<liferay-ui:search-container-column-text>
				<liferay-ui:icon-menu>
					<portlet:actionURL var="editProjApprovalURL" name="editProjApproval">
						<portlet:param name="no" value="${projApproval.no}" />
						<portlet:param name="dictionaryId" value="${projApproval.dictionaryId}" />
						<portlet:param name="mvcPath" value="${contentPath}/input.jsp" />
					</portlet:actionURL>
					<portlet:actionURL var="deleteProjApprovalURL" name="deleteProjApproval">
					<portlet:param name="id" value="${projApproval.id}" />
					<portlet:param name="dictionaryId" value="${projApproval.dictionaryId}" />
					<portlet:param name="redirect" value="${viewURL}" />
				</portlet:actionURL>
					<liferay-ui:icon image="edit" label="编辑" url="${editProjApprovalURL}" />
				<liferay-ui:icon image="delete" label="删除" url="${deleteProjApprovalURL}" /> 
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator/>
	</liferay-ui:search-container> 
</aui:form>
<script>
	function test1(){
		window.location.href="${studentInput}&<portlet:namespace/>dictionaryId="+document.getElementsByName("projectType")[0].value;
	}
	function test(){
		window.location.href="${viewURL}&<portlet:namespace/>what="+document.getElementsByName("projectType")[0].value;
	}
</script>
	