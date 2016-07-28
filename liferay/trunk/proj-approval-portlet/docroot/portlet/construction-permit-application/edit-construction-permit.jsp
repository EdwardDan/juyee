<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>


<c:set var="contextPath"
	value="${request.contextPath}/portlet/construction-permit-application" />


<portlet:renderURL var="viewURL" />

<!-- 项目信息的默认页面是 edit-projInfo-tab.jsp-->
<c:set var="pagePath" value="${contextPath}/edit-projInfo-tab.jsp" />


<!--从view.jsp跳转来 如果选择航道 页面为edit-projInfoExt-tab.jsp-->
<c:if test='<%=ParamUtil.getBoolean(request, "pageType")%>'>
	<c:set var="pagePath" value="${contextPath}/edit-projInfoExt-tab.jsp" />
</c:if>


<!--项目类型的名称  -->
<c:set var="projTypeName"
	value='<%=ParamUtil.getString(request, "projTypeName")%>' />


<!--项目类型的id  -->
<c:set var="projType"
	value='<%=ParamUtil.getString(request, "projType")%>' />

	
<!--从后台跳转来,比如编辑， 如果选择航道 页面为edit-projInfoExt-tab.jsp-->
<c:if test="${dictionary!=null}">
	<c:if test="${dictionary.name=='航道'}">
		<c:set var="pagePath" value="${contextPath}/edit-projInfoExt-tab.jsp" />
	</c:if>
	<c:set var="projTypeName" value='${dictionary.name}' />
	<c:set var="projType" value='${dictionary.dictionaryId}' />
</c:if>



<!--保存的方法  -->
<portlet:actionURL var="editApplicationURL"
	name="saveConstructionPermit" />

<!-- 编辑时后台来的对象 ，这个要不要都行-->
<aui:model-context bean="${constructionPermit}"
	model="<%=ConstructionPermit.class %>" />

<aui:form action="${editApplicationURL}">
	<aui:input name="projType" type="hidden" value="${projType}"></aui:input>
	<aui:input name="constructionPermitId" type="hidden" value="${constructionPermit.constructionPermitId}"></aui:input>

	<liferay-ui:tabs names="${projTypeName}项目,参建单位和合同项目负责人信息,单位工程列表"
		refresh="false">
		<liferay-ui:section>
			<liferay-util:include page="${pagePath}"
				servletContext="<%=this.getServletContext()%>">
			</liferay-util:include>
		</liferay-ui:section>
		<liferay-ui:section>
			<liferay-util:include
				page="${contextPath}/edit-companyHeadInfo-tab.jsp"
				servletContext="<%=this.getServletContext()%>">
			</liferay-util:include>
		</liferay-ui:section>
		<liferay-ui:section>
			<liferay-util:include page="${contextPath}/edit-companyList-tab.jsp"
				servletContext="<%=this.getServletContext()%>">
			</liferay-util:include>
		</liferay-ui:section>
	</liferay-ui:tabs>
	<aui:button type="submit" value="提交" />
	<aui:button type="cancel" value="取消" href="${viewURL}" />
</aui:form>


