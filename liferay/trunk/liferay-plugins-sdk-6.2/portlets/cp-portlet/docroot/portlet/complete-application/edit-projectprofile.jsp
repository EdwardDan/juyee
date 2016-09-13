<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<%
	String bjbh = ParamUtil.getString(request, "bjbh");
	Long completeId = ParamUtil.getLong(request, "completeId");
	CompleteProjectProfile completeProjectProfile = null;
	Project project = null;
	if (Validator.isNotNull(bjbh)) {
		project = ProjectLocalServiceUtil.getProject(bjbh);
		request.setAttribute("project", project);
	} 
	if(Validator.isNotNull(completeId)){
		completeProjectProfile = CompleteProjectProfileLocalServiceUtil.getCompleteProjectProfile(completeId);
		request.setAttribute("completeProjectProfile", completeProjectProfile);
	}
%>
<portlet:renderURL var="viewURL" />
<portlet:actionURL var="saveProjectProfileURL" name="saveProjectProfile">
	<portlet:param name="redirect" value="${viewURL}"/>
</portlet:actionURL>
<aui:model-context bean="${projectProfile}"
	model="<%=ProjectProfile.class%>" />
<aui:form action="${saveProjectProfileURL}">
	<aui:input name="permitId" type="hidden" value="<%=completeId%>" />
	<aui:input name="bjbh" type="hidden" value="${bjbh }" />
	<aui:input name="bdh" type="hidden" value="${bdh }" />
	<aui:input name="sqbz" type="hidden" value="2" />
	<table  class="table table-bordered" width="100%">
	<tr class="body">
			<td class="text-right">工程名称</td>
			<td class="bg-white" colspan="3">
			<aui:input name="gcmc" label="" type="text"
					cssClass="span12" value="${project.xmmc}" readonly="true">
				</aui:input></td>
			</td>
	</tr>
	<tr class="body">
			<td class="text-right">建设单位名称</td>
			<td class="bg-white" colspan="3">
			<aui:input name="jsdwmc" label="" type="text"
					cssClass="span12" value="${project.jsdw }" readonly="true">
				</aui:input>
			</td>
	</tr>
		<tr class="body">
			<td class="text-right">建设单位地址</td>
			<td class="bg-white"  colspan="3">
				<aui:input name="jsdwdz" label="" type="text"
					cssClass="span12" value="${project.jsdwdz }" readonly="true">
				</aui:input>
			</td>
		</tr>
		<tr>
				<td class="text-right">建设地点</td>
				<td class="bg-white">
				<aui:input name="jsdd" label="" type="text"
					cssClass="span12" value="${project.jsdd}" readonly="true"></aui:input>
				</td>
		
			<td class="text-right">所在区县</td>
			<td class="bg-white" >
				<aui:input name="szqx" label="" type="text"
					cssClass="span12" value="${project.szqx}" readonly="true">
				</aui:input>
			</td>
		</tr>
		<tr class="body">
			<td class="text-right">法定代表人</td>
			<td class="bg-white" colspan="3"><aui:input name="fddbr"
					label="" type="text" cssClass="span12" value="${project.jsdwfr}"
					readonly="true">
				</aui:input></td>
		</tr>
		<tr class="body">
			<td class="text-right">联系人</td>
			<td class="bg-white" ><aui:input name="lxr"
					label="" type="text" cssClass="span12" value="${project.jsdwlxr}">
				</aui:input></td>
		
			<td class="text-right">联系电话</td>
			<td class="bg-white" ><aui:input name="lxdh"
					label="" type="text" cssClass="span12" value="${project.jsdwdh}">
				</aui:input></td>
		</tr>
		<tr class="body">
			<td class="text-right">备注</td>
			<td class="bg-white" colspan="3">
			<aui:input name="bz" label=""
					type="textarea" cssClass="span12" value="${completeProjectProfile.bz}">
				</aui:input>
			</td>
		</tr>
		
	</table>
	<div style="text-align: center">
	<aui:button type="submit"  onClick="return checkInputMobilesNormal();"/> <aui:button
					value="返回" href="${viewURL}" />
	</div>

</aui:form>
