<%@page import="com.justonetech.sys.service.DictionaryLocalServiceUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<style type="text/css">
	tr.body td.title{
		text-align: right;
		width: 20%;
	}
	tr.body td.content{
		text-align: left;
		width:30%;
		background-color:white;
	}
</style>
<%@ include file="init.jsp"%>
<%
	long permitId = ParamUtil.getLong(request, "permitId");
	long xmlx = ProjectProfileLocalServiceUtil.getProjectProfile(permitId).getXmlx();
	String xmlxStr = DictionaryLocalServiceUtil.getDictionary(xmlx).getName();
	request.setAttribute("xmlxStr", xmlxStr);
%>
<liferay-ui:tabs names="${xmlxStr}项目,参建单位和合同项目负责人信息,单位工程列表" refresh="false">
<liferay-ui:header title="施工许可申请审核"  backURL="${viewURL }"/>
	<liferay-ui:section>
	<liferay-ui:panel-container accordion="false" extended="true">
		<liferay-ui:panel title="申请信息" collapsible="true">
			<table style="width: 100%;" class="table table-bordered">
				<tr class="body">
					<td class="title">项目性质</td>
					<td class="content"></td>
					<td class="title">所属区县</td>
					<td class="content"></td>
				</tr>
				<tr class="body">
					<td class="title">报建编号</td>
					<td class="content"></td>
					<td class="title">标段号</td>
					<td class="content"></td>
				</tr>
				<tr class="body">
					<td class="title">业务编号</td>
					<td class="content" colspan="3"></td>
				</tr>
				<tr class="body">
					<td class="title">项目名称</td>
					<td class="content" colspan="3"></td>
				</tr>
				<tr class="body">
					<td class="title">建设单位</td>
					<td class="content" colspan="3"></td>
				</tr>
				<tr class="body">
					<td class="title">建设单位性质</td>
					<td class="content"></td>
					<td class="title">建设单位地址</td>
					<td class="content"></td>
				</tr>
				<tr class="body">
					<td class="title">建设单位法定代表人</td>
					<td class="content"></td>
					<td class="title">建设单位联系电话</td>
					<td class="content"></td>
				</tr>
				<tr class="body">
					<td class="title">建设单位联系人</td>
					<td class="content"></td>
					<td class="title">手机号</td>
					<td class="content"></td>
				</tr>
				<tr class="body">
					<td class="title">建设地点</td>
					<td class="content" colspan="3"></td>
				</tr>
				<tr class="body">
					<td class="title">建设地点所属区县</td>
					<td class="content" colspan="3"><aui:input type="checkbox" name=""/></td>
				</tr>
			</table>
		</liferay-ui:panel>
	</liferay-ui:panel-container>
		<liferay-ui:panel-container accordion="false" extended="true">
			<liferay-ui:panel title="历史审核步骤" collapsible="true">
				<jsp:include page="${contextPath }/approval-history.jsp"/>
			</liferay-ui:panel>
			<liferay-ui:panel title="当前审核步骤" collapsible="false">
				<jsp:include page="${contextPath }/approval-current.jsp"/>
			</liferay-ui:panel>
	</liferay-ui:panel-container>
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-permit/projectprofile.jsp"/>
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-participationunits.jsp"/>
		<jsp:include page="${contextPath }/view-participationunits.jsp"/>
		<jsp:include page="${contextPath }/view-permit/participationunits.jsp"/>
	</liferay-ui:section>
	<liferay-ui:section>
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-unitprojects.jsp"/>
		<jsp:include page="${contextPath }/view-unitprojects.jsp"/>
		<jsp:include page="${contextPath }/view-permit/unitprojects.jsp"/>
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-permit/applymaterials.jsp"/>
	</liferay-ui:section>
</liferay-ui:tabs>