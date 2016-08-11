<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>

<%-- <%
	String projectTypeCode="";
	String projTypeName=ParamUtil.getString(request, "projTypeName");
	Boolean pageType=false;
	if("航道".equals(projTypeName)){
		pageType=true;
	}
	if("公路".equals(projTypeName)){
		projectTypeCode="ProjectType2";
	}else if("港口设施".equals(projTypeName)){
		projectTypeCode="ProjectType3";
	}else if("市政基础设施-隧道".equals(projTypeName)){
		projectTypeCode="ProjectType4";
	}else if("市政基础设施-轨道".equals(projTypeName)){
		projectTypeCode="ProjectType5";
	}else if("市政基础设施-公交场站".equals(projTypeName)){
		projectTypeCode="ProjectType6";
	}else if("市政基础设施-城市道路".equals(projTypeName)){
		projectTypeCode="ProjectType7";
	}
	renderRequest.setAttribute("projectTypeCode", projectTypeCode);
%> --%>



<c:set var="contextPath"
	value="${request.contextPath}/portlet/construction-permit-application" />


<portlet:renderURL var="viewURL" />

<!-- 项目信息的默认页面是 edit-projInfo-tab.jsp-->
<c:set var="pagePath"
	value="${contextPath}/view-other-basicInfo-tab.jsp" />

<!--从后台跳转来,比如编辑， 如果选择航道 页面为edit-projInfoExt-tab.jsp-->
<c:if test="${dictionary!=null}">
	<c:if test="${dictionary.name=='航道'}">
		<c:set var="pagePath"
			value="${contextPath}/view-channel-basicInfo-tab.jsp" />
	</c:if>
	<c:set var="projTypeName" value='${dictionary.name}' />
	<c:set var="projType" value='${dictionary.dictionaryId}' />
</c:if>


<liferay-ui:header title='查看施工许可申请' backURL="${viewURL}" />

<aui:input name="projType" type="hidden" value="${projType}"></aui:input>
<aui:input name="constructionPermitId" type="hidden"
	value="${constructionPermit.constructionPermitId}"></aui:input>

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
		<liferay-util:include
			page="${contextPath}/view-unit-engineering-tab.jsp"
			servletContext="<%=this.getServletContext()%>">
		</liferay-util:include>
	</liferay-ui:section>
</liferay-ui:tabs>

<aui:row>
	<aui:col span="12" >
		<aui:button type="cancel" value="关闭" href="${viewURL}" />
	</aui:col>
</aui:row>




