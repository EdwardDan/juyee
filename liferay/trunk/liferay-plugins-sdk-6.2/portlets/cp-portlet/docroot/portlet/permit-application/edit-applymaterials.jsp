<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<portlet:actionURL var="saveApplyMaterialsURL" name="saveApplyMaterials">
<portlet:param name="redirectURL" value="${editPermitURL }"/>
</portlet:actionURL>
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
	List<ApplyMaterial> materialList=ApplyMaterialLocalServiceUtil.findByPermitId(1, -1, -1);
    System.out.println(Arrays.asList(materialList));
    System.out.println(123);
%>


<c:set var="namespace" value="<%=renderResponse.getNamespace()%>"></c:set>
<portlet:resourceURL var="fileUpLoadURL" id="fileUpLoad" />
<portlet:resourceURL var="fileDeleteURL" id="fileDelete" />

<aui:form id="fmFile" enctype="multipart/form-data" action="${saveApplyMaterialsURL }">
<aui:input name="permitId" type="hidden" value="<%=permitId%>" />
<table class="table table-bordered" style="font-size: 14px;">
	<tr style="text-align: center; height: 45px;">
		<td style="text-align: center; width: 5%;">序号</td>
		<td style="text-align: center; width: 30%;">申请材料名称</td>
		<td style="text-align: center; width: 45%;">附件</td>
		<td style="text-align: center; width: 20%;">操作</td>
	</tr>
	<c:forEach items="<%=materialList%>" var="material" varStatus="status"> 
		<tr style="text-align: center">
			<td style="text-align: center">${material.xh}</td>
			<td>${material.clmc}</td>
			<td style="text-align: center">
				<div id="fileDiv${status.index+1}">
				<c:if test="${not empty material.fileEntryIds}">
				<c:forEach items="${fn:split(material.fileEntryIds,',')}" var="fileEntryId" varStatus="statusSub">
					<div name="file${status.index+1}">
					<a class="fileName" href="javascript:void(0);">
								${material.clmc}-${statusSub.index+1}</a> &nbsp;&nbsp;&nbsp;
					<a href='javascript:void(0)'; onclick="fileDelete(this,${fileEntryId},${material.materialId})">删除</a></div>
				</c:forEach>
				</c:if>
				</div>
			</td>
			<td style="text-align: center">
				<input type="button" value="上传" onclick="document.getElementById('fileInput${status.index+1}').click();"> 
				<input id="fileInput${status.index+1}" name="${namespace}fileInput${status.index+1}" type="file" multiple=""
				style="display:none;width: 150px;"  onchange="fileUpLoad(${status.index+1},${material.materialId},'${material.clmc}');"></input>
	
			</td>
		</tr>
	</c:forEach>
	
</table>

<div style="text-align: center">
	<aui:button type="submit" value="保存" />
</div>
</aui:form>

<aui:script>
	/* 上传 */
	function fileUpLoad(divNo,materialId,materialName) {
		var fmFile = document.getElementById("fmFile");
		var oMyForm = new FormData(fmFile);
		oMyForm.append("<portlet:namespace/>divNo",divNo);
		oMyForm.append("<portlet:namespace/>materialId",materialId);
		var no = findFileNo(divNo);
		
		$.ajax({
					url : "<%=fileUpLoadURL%>",
					type : "post",
					data : oMyForm,
					cache : false,
					processData : false,
					contentType : false,
					success : function(data) {
						var fileData = eval("(" + data + ")");
						if(fileData.upLoadStatus){
							var ele = "<div name='file"+divNo+"'><a class='fileName' href='javascript:void(0);'>"
							+ materialName+"-"+no+"."+fileData.extension
							+ "</a> &nbsp;&nbsp;&nbsp;<a href='javascript:void(0)'; onclick='fileDelete(this,"
							+ fileData.fileId + ","+materialId+")'>删除</a></div>";
							$("#fileDiv" + divNo).append(ele);
							domSort(divNo); 
							alert("操作成功！");		}
						else{
							alert(fileData.validatorMessage);
							}			

					},
					error : function(e) {
						alert("网络错误，请重试！！");
					}
				});
	}

	/* 删除 */
	function fileDelete(divObj, fileId, materialId) {
		if (!confirm("确定要删除此文件吗？"))
			return;
		$.ajax({
			url : "<%=fileDeleteURL%>",
			type : "post",
			data : {
				'<portlet:namespace/>fileId' : fileId,
				'<portlet:namespace/>materialId' : materialId
			},
			success : function(data) {
				$(divObj).parent().remove();
				alert("成功删除文件!");
			},
			error : function(e) {
				alert("网络错误，请重试！！");
			}
		});
	}
	/* 查找某一类文件的数量 */
	function findFileNo(divNo) {
		var indexNo = 0;
		var fileNameNoArr=new Array();
		$("div[name^='file" + divNo + "']").each(function() {
			var text=$(this).children("a.fileName").text().split('.')[0].split('-')[1];
			fileNameNoArr[indexNo]=text;
			indexNo = (indexNo + 1);
		});
		return getNo(fileNameNoArr);
	}
	
	function getNo(fileNameNoArr){
		var no;
		for(var i=1;i<50;i++){
			var r=fileNameNoArr.indexOf(i.toString());
			if(r==-1){
				no=i;
				return no;
			}
		}
	}
	
	
	/* 给div元素重新排序 */
	function domSort(divNo){
		var sortEle=$("div[name^='file" + divNo + "']").sort(function(a,b){
		    var valveNumOfa = $(a).children("a.fileName").text().split('.')[0].split('-')[1];
		    var valveNumOfb = $(b).children("a.fileName").text().split('.')[0].split('-')[1];
		    if(parseInt(valveNumOfa) < parseInt(valveNumOfb)) return -1;
		    else return 1;
		});
		$('#fileDiv'+divNo).empty().append(sortEle);
	}
	
	
	
	
</aui:script>