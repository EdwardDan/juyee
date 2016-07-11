<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>


<liferay-ui:tabs names="航道项目,参建单位和合同项目负责人信息,单位工程列表" refresh="false">
	<liferay-ui:section>
       <liferay-util:include page="/portlet/construction-permit-application/edit-projInfo-tab.jsp"
			servletContext="<%=this.getServletContext()%>">
		</liferay-util:include>
	</liferay-ui:section>
	<liferay-ui:section>
            <liferay-util:include page="/portlet/construction-permit-application/edit-unitHeadInfo-tab.jsp"
			servletContext="<%=this.getServletContext()%>">
		</liferay-util:include>
	</liferay-ui:section>
	<liferay-ui:section>
            <liferay-util:include page="/portlet/construction-permit-application/edit-unitList-tab.jsp"
			servletContext="<%=this.getServletContext()%>">
		</liferay-util:include>
	</liferay-ui:section>
</liferay-ui:tabs>
