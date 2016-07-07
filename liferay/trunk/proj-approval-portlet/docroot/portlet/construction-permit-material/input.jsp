<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="com.justonetech.sys.model.Dictionary"%>
<%@ page import="com.justonetech.proj.approval.portlet.ProjApproval"%>
<%@page import="com.justonetech.sys.service.DictionaryLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ page import="java.util.*"%>
<%@ include file="/common/init.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<portlet:defineObjects />
<%long dictionaryId=ParamUtil.getLong(renderRequest, "dictionaryId"); 
	long groupId = PortalUtil.getScopeGroupId(request);%>
<portlet:renderURL var="viewURL" />
 <aui:model-context bean="${projApproval}" model="<%=ProjApproval.class %>" />
<liferay-ui:header title='${empty projApproval?"添加":"编辑"}材料'
	backURL="${viewURL }" /> 
<portlet:actionURL var="saveProjApprovalURL" name="saveProjApproval">
	<portlet:param name="redirect" value="${viewURL }" />
</portlet:actionURL>
<aui:form action="${saveProjApprovalURL}">
	<aui:fieldset>
		<aui:input name="dictionaryId" type="hidden" value="<%=dictionaryId %>"/>
		<aui:input name="id" type="hidden"/> 
		<aui:select name="type" label="材料类型">
			<%
				Dictionary dictionary = DictionaryLocalServiceUtil
									.findByGroupIdAndCode(groupId, "materialType");
			if (null != dictionary) {
							List<Dictionary> dictionaries = DictionaryLocalServiceUtil
									.findByGroupIdAndParentId(groupId,
											dictionary.getDictionaryId(), -1, -1);
							for (Dictionary dic : dictionaries) {
			%>
			<aui:option value="<%=dic.getDictionaryId()%>"><%=dic.getName()%></aui:option>
			<%
							}}
			%>
		</aui:select>
		<aui:input  type="text" name="no" label="序号" value="${projApproval.no}">
		</aui:input>
		<aui:input  type="text" name="materialName" label="材料名称" value="${projApproval.materialName}">
		</aui:input>
		<aui:input  type="text" name="auditReq" label="审核要求">
		</aui:input>
		<aui:input  type="text" name="auditReqGreen" label="绿色审核要求">
		</aui:input>
		<aui:input  type="text" name="yjNum" label="应交份数">
		</aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="提交" />
		<aui:button type="cancel" value="取消" href="${viewURL }" />
	</aui:button-row>
</aui:form>
