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

<%
	long completeId =ParamUtil.getLong(renderRequest,"completeId");
	List<CompleteApplyMaterial> materialList=CompleteApplyMaterialLocalServiceUtil.findByCompleteId(completeId, -1, -1);
%>

<c:set var="namespace" value="<%=renderResponse.getNamespace()%>"></c:set>

<table class="table table-bordered" style="font-size: 14px;" id="fileTable">
	<tr style="text-align: center; height: 45px;">
		<td style="text-align: center; width: 5%;">序号</td>
		<td style="text-align: center; width: 40%;">申请材料名称</td>
		<td style="text-align: center; width: 55%;">附件</td>
	</tr>
	<%
		for(int i=0;i<materialList.size();i++){
	%>
	<tr style="text-align: center" class="fileTr">
		<td style="text-align: center" class="fileNo"><%=materialList.get(i).getXh() %></td>
		<td><%=materialList.get(i).getClmc()%></td>
		<td style="text-align: center">
			<div class=<%=materialList.get(i).getMaterialId()%>>
				<%
					if(Validator.isNotNull(materialList.get(i))){
						CompleteApplyMaterial applyMaterial=materialList.get(i);
						String fileEntryIds=applyMaterial.getFileEntryIds();
						if(Validator.isNotNull(fileEntryIds)){
						String[] fileEntryIdsArr=fileEntryIds.split("\\,");
						for(int j=0;j<fileEntryIdsArr.length;j++){
							if(Validator.isNotNull(fileEntryIdsArr[j])){
								String fileEntryId=fileEntryIdsArr[j].split("\\|")[0];
								DLFileEntry dlFileEntry=DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(fileEntryId));
								String filePath=dlFileEntry.getGroupId() + "/" + dlFileEntry.getFolderId() + "/" + dlFileEntry.getTitle();
								String fileName=dlFileEntry.getTitle();
								String jpg = "jpg";
								String pdf = "pdf";
								String pdfURL = "/documents/"+filePath;
								System.out.println("pdfURL=============="+pdfURL);
				%>
				<div>
					<c:if test="<%=dlFileEntry.getExtension().equals(jpg)%>">
						<a href="#" onclick="previewJpg(<%=materialList.get(i).getMaterialId()%>,<%=fileEntryId%>)"><%=fileName%></a>
						<img src="/documents/<%=filePath%>" hidden="true" id=<%=fileEntryId%> alt="<%=dlFileEntry.getTitle()%>">
					</c:if>
					<c:if test="<%=dlFileEntry.getExtension().equals(pdf)%>">
						
						<a href="#" onclick="previewPdf('<%=pdfURL%>')"><%=fileName%></a>
					</c:if>
					<a href="/documents/<%=filePath%>?&download=true" >下载</a>
				</div>
				<%
					}
						}
					}
						}
				%>
			</div>
		</td>
	</tr>
	<%
		}
	%>

</table>
<c:set var="contextPath" value="${request.contextPath}/portlet/complete-approval" />
<portlet:renderURL var="previewPdfURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/view-complete/applymaterials-pdf.jsp" />
</portlet:renderURL>
<script>
	function previewJpg(materialId,imgURL) {
		$('.'+materialId).viewer();
		$('#'+imgURL).click();
	}
	
	function previewPdf(pdfURL){
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				width : 1000,
				height : 600,
			},
			id : 'popup',
			title : '预览',
			uri : '${previewPdfURL}&<portlet:namespace/>pdfURL='+pdfURL,
			destroyOnClose : true
		});
	}
	
</script>


