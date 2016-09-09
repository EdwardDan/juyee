<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<style>
.aui .table th, .aui .table td {
	vertical-align: middle;
	padding: 8px;
}

.aui input[type="file"] {
	width: 150px;
}
</style>

<% long permitId =ParamUtil.getLong(renderRequest,"permitId");
	List<ApplyMaterial> materialList=ApplyMaterialLocalServiceUtil.findByPermitId(permitId, -1, -1);
%>

<c:set var="namespace" value="<%=renderResponse.getNamespace()%>"></c:set>

<table class="table table-bordered" style="font-size: 14px;" id="fileTable">
	<tr style="text-align: center; height: 45px;">
		<td style="text-align: center; width: 5%;">序号</td>
		<td style="text-align: center; width: 40%;">申请材料名称</td>
		<td style="text-align: center; width: 55%;">附件</td>
	</tr>
	<%-- <c:forEach items="<%=materialList%>" var="material" varStatus="status">  --%>
	<%
		for(int i=0;i<materialList.size();i++){
	%>
		<tr style="text-align: center" class="fileTr">
			<td style="text-align: center" class="fileNo">${material.xh}</td>
			<td><%=materialList.get(i).getClmc() %></td>
			<td style="text-align: center">
				<%
					if(Validator.isNotNull(materialList.get(i))){
						ApplyMaterial applyMaterial=materialList.get(i);
						String fileEntryIds=applyMaterial.getFileEntryIds();
						if(Validator.isNotNull(fileEntryIds)){
							String[] fileEntryIdsArr=fileEntryIds.split("\\,");
							for(int j=0;j<fileEntryIdsArr.length;j++){
								if(Validator.isNotNull(fileEntryIdsArr[j])){
									String fileEntryId=fileEntryIdsArr[j].split("\\|")[0];
									DLFileEntry dlFileEntry=DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(fileEntryId));
									String filePath=dlFileEntry.getGroupId() + "/" + dlFileEntry.getFolderId() + "/" + dlFileEntry.getTitle();
									String fileName=applyMaterial.getClmc()+"-"+(j+1)+"."+dlFileEntry.getExtension();
				%>
					<div>
						<a  href="/documents/<%=filePath%>"  target="_Blank"><%=fileName%></a>
					</div> 
					
				<%
								}
							}
						}
					}
				%>
			</td>
		</tr>
	<%
		}
	
	%>
	<%-- </c:forEach> --%>
	
</table>



