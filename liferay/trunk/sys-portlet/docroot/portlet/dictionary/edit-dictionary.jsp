<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contentPath"
	value="${request.contextPath}/portlet/dictionary" />
<c:set var="parentDictionary"
	value="${empty dictionary?parentDictionary:dictionary.parentDictionary}" />

<portlet:renderURL var="viewURL">
	<portlet:param name="parentId" value="${parentDictionary.dictionaryId}" />
</portlet:renderURL>

<aui:model-context bean="${dictionary}"
	model="<%=com.justonetech.sys.model.Dictionary.class %>" />
<liferay-ui:header title='${empty dictionary?"添加":"编辑"}字典'
	backURL="${viewURL }" />
<portlet:actionURL var="saveDictionaryURL" name="saveDictionary"> 
	<portlet:param name="redirect" value="${viewURL }" />
</portlet:actionURL>
<aui:form action="${saveDictionaryURL}">
	<aui:fieldset>
		<aui:input name="dictionaryId" type="hidden" />
		<aui:input name="parentId" type="hidden"  value="${parentDictionary.dictionaryId}" />
		<c:if test="${!empty parentDictionary}">
			<aui:input type="text" name="parentDictionaryName" label="上级代码名称"
				disabled="true" value="${parentDictionary.name}" />
		</c:if>
		<aui:input name="name" label="代码名称" required="true" />
		<aui:input name="code" label="代码编码" />
		<aui:input name="sortNo" label="排序号" value='<%=renderRequest.getAttribute("sortNo")+"" %>' >
			<aui:validator name="max">99999</aui:validator>
		</aui:input>
		<aui:field-wrapper label="是否有效" required="true">
			<aui:input name="isValid" type="radio" value="true" label="是"
				checked="${empty dictionary?true:dictionary.isValid}" required="true"></aui:input>
			<aui:input name="isValid" type="radio" value="false" label="否"
				checked="${empty dictionary?false:!dictionary.isValid}" required="true"></aui:input>
		</aui:field-wrapper>
		<aui:input name="tag" label="特殊标记" />
		<aui:input name="desc" label="描述" type="textarea" />
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="提交" />
		<aui:button type="cancel" value="取消" href="${viewURL }" />
	</aui:button-row>
</aui:form>