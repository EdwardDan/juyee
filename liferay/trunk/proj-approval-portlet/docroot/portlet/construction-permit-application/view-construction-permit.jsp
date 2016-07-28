<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>


<c:set var="contextPath"
	value="${request.contextPath}/portlet/construction-permit-application" />


<portlet:renderURL var="viewURL" />

<!-- 项目信息的默认页面是 edit-projInfo-tab.jsp-->
<c:set var="pagePath" value="${contextPath}/view-other-basicInfo-tab.jsp" />
	
<!--从后台跳转来,比如编辑， 如果选择航道 页面为edit-projInfoExt-tab.jsp-->
<c:if test="${dictionary!=null}">
	<c:if test="${dictionary.name=='航道'}">
		<c:set var="pagePath" value="${contextPath}/view-channel-basicInfo-tab.jsp" />
	</c:if>
	<c:set var="projTypeName" value='${dictionary.name}' />
	<c:set var="projType" value='${dictionary.dictionaryId}' />
</c:if>




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
				page="${contextPath}/view-paticipant-unitsInfo-tab.jsp"
				servletContext="<%=this.getServletContext()%>">
			</liferay-util:include>
		</liferay-ui:section>
		<liferay-ui:section>
			<liferay-util:include page="${contextPath}/view-unit-engineering-tab.jsp"
				servletContext="<%=this.getServletContext()%>">
			</liferay-util:include>
		</liferay-ui:section>
	</liferay-ui:tabs>




