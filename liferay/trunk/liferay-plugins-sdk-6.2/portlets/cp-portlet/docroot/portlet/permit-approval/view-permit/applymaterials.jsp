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
	<c:forEach items="<%=materialList%>" var="material" varStatus="status"> 
		<tr style="text-align: center" class="fileTr">
			<td style="text-align: center" class="fileNo">${material.xh}</td>
			<td>${material.clmc}</td>
			<td style="text-align: center">
				<c:if test="${not empty material.fileEntryIds}">
				<c:forEach items="${fn:split(material.fileEntryIds,',')}" var="fileEntryId" varStatus="statusSub">
					<div>
						<a class="fileName" href="${fn:split(fileEntryId,'|')[2]}" >
									${material.clmc}-${statusSub.index+1}.${fn:split(fileEntryId,'|')[1]}</a>
					</div> 
					</c:forEach>
				</c:if>
			</td>
		</tr>
	</c:forEach>
	
</table>



