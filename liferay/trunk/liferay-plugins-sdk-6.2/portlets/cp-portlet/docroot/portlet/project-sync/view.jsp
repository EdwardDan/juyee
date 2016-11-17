<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<liferay-ui:header title="报建项目" /> 
<portlet:renderURL var="viewURL"/>
<aui:form action="${viewURL }">
<liferay-ui:search-container emptyResultsMessage="没有项目报建数据。">
	<aui:nav-bar>
		<aui:nav-bar-search cssClass="pull-right">
			<div class="form-search">
				<liferay-ui:input-search autoFocus="true" name="keywords" placeholder="报建编号" />
			</div>
		</aui:nav-bar-search>
	</aui:nav-bar>
	<liferay-ui:search-container-results>
	<%
		String keywords = ParamUtil.getString(request,"keywords");
	    results = ProjectLocalServiceUtil.getProjects("", keywords, "", "", null, null, null, searchContainer.getStart(), searchContainer.getEnd());
		searchContainer.setResults(results);
		total = ProjectLocalServiceUtil.getProjectsCount("", keywords, "", "", null, null, null);
		searchContainer.setTotal(total);
	%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="Project" keyProperty="bjbh"
		modelVar="project">
		<liferay-ui:search-container-column-text name="报建编号" property="bjbh" />
		<liferay-ui:search-container-column-text name="项目名称" property="xmmc" />
		<liferay-ui:search-container-column-text name="action">
			<aui:button id="" onClick="syncProject('${project.bjbh}')" value="同步数据"></aui:button>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
</aui:form>
<portlet:resourceURL var="resourceURL"/>
<aui:script>
function syncProject(bjbh){
    AUI().use('aui-io-request', function(A){
    	var loadingMask = new A.LoadingMask({
			'strings.loading' : '数据正在同步中。。。',
			target : A.getBody()
		});
        A.io.request('${resourceURL}', {
               method: 'get',
               data:{
            	   <portlet:namespace/>bjbh:bjbh
               },
               on: {
            	   	start: function(){
            	   		loadingMask.show();
            	   	},
                   	success: function() {
                   		loadingMask.hide();
                   		alert("同步成功！");
                    },
                    failure: function(){
                    	loadingMask.hide();
                    	alert("同步失败！");
                    }
              }
        });
 
    });
}
</aui:script>