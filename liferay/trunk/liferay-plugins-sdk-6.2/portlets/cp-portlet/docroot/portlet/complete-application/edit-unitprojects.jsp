<%@page import="com.justonetech.cp.complete.service.CompleteApplyMaterialLocalServiceUtil"%>
<%@page import="com.justonetech.cp.complete.service.CompleteUnitProjectLocalServiceUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>

<c:set var="namespace" value="<%=renderResponse.getNamespace()%>" />
<portlet:actionURL var="saveUnitProjectsURL" name="saveUnitProjects">
	<portlet:param name="redirectURL" value="${editCompleteURL}" />
</portlet:actionURL>
<%
	//从render方法传来的值
	
	
	String permitUnitProjectIdsStr = ParamUtil.getString(request, "projectIds");
	String[] permitUnitProjectIds=null;
    if(Validator.isNotNull(permitUnitProjectIdsStr)){
    	permitUnitProjectIds=permitUnitProjectIdsStr.split(",");
    }
	String bjbh = ParamUtil.getString(request, "bjbh");
	System.out.println(2121);
	System.out.println(bjbh);
	long completeId = ParamUtil.getLong(request, "completeId");
	List<CompleteUnitProject> completeUnitProjects=new ArrayList<CompleteUnitProject>();
	Complete complete=null;
	if(Validator.isNotNull(completeId)){
		complete=CompleteLocalServiceUtil.getComplete(completeId);
		completeUnitProjects=CompleteUnitProjectLocalServiceUtil.findByCompleteId(completeId, -1, -1);
	}
	renderRequest.setAttribute("completeId", completeId);
	renderRequest.setAttribute("bjbh", bjbh);
%>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/complete-application" />


<portlet:renderURL var="selectUnitProjectURL">
	<portlet:param name="bjbh" value="${bjbh}"/>
	<portlet:param name="completeId" value="${completeId}"/>
	<portlet:param name="mvcPath"
		value="${contextPath }/select-permit-unitProject.jsp" />
</portlet:renderURL>



<aui:form action="${saveUnitProjectsURL}">
	<aui:input name="bjbh" value="${bjbh}" type="hidden"></aui:input>
	<aui:input name="completeId" value="${completeId}" type="hidden"></aui:input>
	<div class="divAccordion-inner">
		<aui:row>
			<aui:col span="12">
				<aui:button type="button" value="添加" class="btn" style="" href="${selectUnitProjectURL}" />
				<aui:button type="button" value="删除" class="btn" style="" onclick="${renderResponse.namespace}changeLine(this)" />
			</aui:col>
		</aui:row>
	</div>
	<div class="accordion-inner">
		<table width="100%" class="table table-bordered table-hover">
			<tr height="29px">
				<td style="width: 2%; text-align: center"></td>
				<td style="width: 10%; text-align: center">施工许可证编号</td>
				<td style="width: 20%; text-align: center">单位工程编号</td>
				<td style="width: 20%; text-align: center">单位工程名称</td>
				<td style="width: 65%; text-align: center">建设内容</td>
			</tr>
			<tbody id="unitProjects">
				
					<c:forEach items="<%=completeUnitProjects%>" var="unitProject">
						<tr>
							<td style="width: 2%; text-align: center"><input type="checkbox" name="<portlet:namespace/>isDelete" /></td>
							<td><input name="<portlet:namespace/>sgxkzbh" value="${unitProject.sgxkzbh}" readonly="true" type="text" style="width: 85%;" label="" /></td>
							<td><input name="<portlet:namespace/>gcbh" value="${unitProject.gcbh}" type="text" style="width: 93%;" label="" /></td>
							<td><input name="<portlet:namespace/>gcmc" value="${unitProject.gcmc}" type="text" style="width: 98%;" label="" /></td>
							<td><input name="<portlet:namespace/>jsnr" value="${unitProject.jsnr}" type="text" style="width: 98%;" label="" /></td>
						</tr>
					</c:forEach>
				
			</tbody>
		</table>
		<table style="display:none;" border="1" width="90%">
			<tbody id="hiddenStyle">
				<tr>
					<td style="width: 2%; text-align: center"><input type="checkbox" name="<portlet:namespace/>isDelete" /></td>
					<td><input name="<portlet:namespace/>sgxkzbh"  type="text" style="width: 85%;" label="" /></td>
					<td><input name="<portlet:namespace/>gcbh" type="text" style="width: 93%;" label="" /></td>
					<td><input name="<portlet:namespace/>gcmc" type="text" style="width: 98%;" label="" /></td>
					<td><input name="<portlet:namespace/>jsnr" type="text" style="width: 98%;" label="" /></td>
				</tr>
			</tbody>
		</table>
		<div>注释：单位工程名称请参考规划许可证内容填写</div>
	</div>
	<aui:button-row>
		<div style="text-align: center">
		<aui:button type="submit" value="保存" /> 
		<aui:button type="cancel" value="返回" href="${viewURL}" />
		</div>
	</aui:button-row>



</aui:form>
<script>
	
	$(function(){
		<%
		UnitProject unitProject=null;
		Permit permit=null;
		if(Validator.isNotNull(permitUnitProjectIds)&&permitUnitProjectIds.length>0){
			for(String permitUnitProjectId:permitUnitProjectIds){
				if(Validator.isNotNull(permitUnitProjectId)){
					unitProject=UnitProjectLocalServiceUtil.getUnitProject(Long.valueOf(permitUnitProjectId));
					long permitId= unitProject.getPermitId();
					if(Validator.isNotNull(permitId)){
						permit=PermitLocalServiceUtil.getPermit(permitId);
						renderRequest.setAttribute("sgxkzbh", permit.getSgxkzbh());
					}
					renderRequest.setAttribute("gcbh", unitProject.getGcbh());
					renderRequest.setAttribute("gcmc", unitProject.getGcmc());
					renderRequest.setAttribute("jsnr", unitProject.getJsnr()); 
		%>
		$("#unitProjects").append($("#hiddenStyle").html()); 
		$("#unitProjects>tr:last-child").find("input[name=<portlet:namespace/>sgxkzbh]").val('${sgxkzbh}');
		$("#unitProjects>tr:last-child").find("input[name=<portlet:namespace/>gcbh]").val('${gcbh}');
		$("#unitProjects>tr:last-child").find("input[name=<portlet:namespace/>gcmc]").val('${gcmc}');
		$("#unitProjects>tr:last-child").find("input[name=<portlet:namespace/>jsnr]").val('${jsnr}');			
		<%					
				}
			}
		}
		%>
	});

	function <portlet:namespace/>changeLine(obj) {
		if (confirm("确定要删除吗？")) {
			$("input[name='<portlet:namespace/>isDelete']").each(function() {
				if (this.checked) {
					$(this).parent().parent().remove();
				}
			});
		}	
	}

	
</script>

