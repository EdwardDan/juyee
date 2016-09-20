<%@page import="com.justonetech.sys.service.DictionaryLocalServiceUtil"%>
<%@page import="com.justonetech.sys.model.Dictionary"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<portlet:renderURL var="viewURL" />
<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationURL" />
<aui:form method="post" action="<%=configurationURL%>">
	<aui:fieldset>
		<aui:input type="text" name="displayPage" label="显示页面"
			value="${displayPage}" required="true" />
		<aui:select name="lxId" label="类型" showEmptyOption="true" >
			<%
				Dictionary dictionary = DictionaryLocalServiceUtil.findByCode("hdfklx");
				if (Validator.isNotNull(dictionary)) {
					List<Dictionary> dictionaries = DictionaryLocalServiceUtil.findByParentId(dictionary.getDictionaryId(), -1, -1);
					for (Dictionary dic : dictionaries) {
						request.setAttribute("dic", dic);
			%>
			<aui:option value="${dic.dictionaryId }" label="${dic.name }" selected="${lxId eq dic.dictionaryId}"/>
			<%
					}
				}
			%>
		</aui:select>
		<aui:input type="text" name="action" label="操作"
			value="${action}"/>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>