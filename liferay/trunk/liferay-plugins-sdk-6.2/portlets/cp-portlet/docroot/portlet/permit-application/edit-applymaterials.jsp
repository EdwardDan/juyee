<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>

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
	List<Dictionary> materialDictionaries=new ArrayList<Dictionary>();
	List<ApplyMaterial> applyMaterialList=new ArrayList<ApplyMaterial>();
	Long permitId =ParamUtil.getLong(renderRequest,"permitId",0);
	if(Validator.isNotNull(permitId)){
		applyMaterialList= ApplyMaterialLocalServiceUtil.findByPermitId(permitId, -1, -1);

		//对材料表进行初始化
		if(applyMaterialList.size()<=0){
			
			ProjectProfile projectProfile=ProjectProfileLocalServiceUtil.fetchProjectProfile(permitId);
			long xmlxId=projectProfile.getXmlx();//项目类型
			long jsgcsxId=projectProfile.getJsgcsx();//建设工程属性
			if(Validator.isNotNull(xmlxId)&&Validator.isNotNull(jsgcsxId)){
				Dictionary xmlxDictionary= DictionaryLocalServiceUtil.getDictionary(xmlxId);
				Dictionary jsgcsxDictionary= DictionaryLocalServiceUtil.getDictionary(jsgcsxId);
				String xmlxCode=xmlxDictionary.getCode();
				String jsgcsxCode=jsgcsxDictionary.getCode();
				if("XJ".equals(jsgcsxCode)||"KJ".equals(jsgcsxCode)||"GJ".equals(jsgcsxCode)){//新改扩
					if("GK".equals(xmlxCode)){
						Dictionary gk_xgk_Dictionary=DictionaryLocalServiceUtil.findByCode("gk_xgk");
						materialDictionaries=DictionaryLocalServiceUtil.findByParentId(gk_xgk_Dictionary.getDictionaryId(), -1, -1);
					}
					if("HD".equals(xmlxCode)){
						Dictionary hd_xgk_Dictionary=DictionaryLocalServiceUtil.findByCode("hd_xgk");
						materialDictionaries=DictionaryLocalServiceUtil.findByParentId(hd_xgk_Dictionary.getDictionaryId(), -1, -1);
					}
					if("GL".equals(xmlxCode)){
						Dictionary gl_xgk_Dictionary=DictionaryLocalServiceUtil.findByCode("gl_xgk");
						materialDictionaries=DictionaryLocalServiceUtil.findByParentId(gl_xgk_Dictionary.getDictionaryId(), -1, -1);
					}
					if("SZ".equals(xmlxCode)){
						Dictionary szjt_xgk_Dictionary=DictionaryLocalServiceUtil.findByCode("szjt_xgk");
						materialDictionaries=DictionaryLocalServiceUtil.findByParentId(szjt_xgk_Dictionary.getDictionaryId(), -1, -1);
					}
	
					
				}else{
					
					if("GL".equals(xmlxCode)){
						Dictionary gl_xgk_Dictionary=DictionaryLocalServiceUtil.findByCode("gl_dx");
						materialDictionaries=DictionaryLocalServiceUtil.findByParentId(gl_xgk_Dictionary.getDictionaryId(), -1, -1);
					}
					if("SZ".equals(xmlxCode)){
						Dictionary szjt_xgk_Dictionary=DictionaryLocalServiceUtil.findByCode("szjt_dx");
						materialDictionaries=DictionaryLocalServiceUtil.findByParentId(szjt_xgk_Dictionary.getDictionaryId(), -1, -1);
					}
				}
			}
			
			for(Dictionary dic: materialDictionaries){
				 ApplyMaterial applyMaterial=ApplyMaterialLocalServiceUtil.createApplyMaterial(CounterLocalServiceUtil.increment());
				 applyMaterial.setPermitId(permitId);
				 applyMaterial.setXh(dic.getTag());
				 applyMaterial.setClmc(dic.getName());
				 applyMaterialList.add(applyMaterial);
				 ApplyMaterialLocalServiceUtil.updateApplyMaterial(applyMaterial);		
			}
		}
	
	}
	
	
	
	
	
%>
<portlet:renderURL var="viewURL"/>
<c:set var="namespace" value="<%=renderResponse.getNamespace()%>"></c:set>
<portlet:resourceURL var="fileUpLoadURL" id="fileUpLoad" />
<portlet:resourceURL var="fileDeleteURL" id="fileDelete" />

<portlet:actionURL var="fileSaveURL" name="saveApplyMaterials">
	<portlet:param name="redirectURL" value="${editPermitURL}" />
</portlet:actionURL>

<portlet:actionURL var="submitAllURL" name="submitAll">
	<portlet:param name="redirect" value="${viewURL}" />
</portlet:actionURL>


<form id="fm" action="${fileSaveURL}" enctype="multipart/form-data" method="post">

<aui:input type="hidden" name="permitId" value="<%=permitId%>"></aui:input>
<table class="table table-bordered" style="font-size: 14px;" id="fileTable">
	<tr style="text-align: center; height: 45px;">
		<td style="text-align: center; width: 5%;">序号</td>
		<td style="text-align: center; width: 30%;">申请材料名称</td>
		<td style="text-align: center; width: 45%;">附件</td>
		<td style="text-align: center; width: 20%;">操作
			<span class="taglib-icon-help">
			<img id="yui_patched_v3_11_0_1_1473298445453_1601" tabindex="0" src="/html/themes/control_panel/images/portlet/help.png" onmouseover="Liferay.Portal.ToolTip.show(this);" onfocus="Liferay.Portal.ToolTip.show(this);" onblur="Liferay.Portal.ToolTip.hide();" aria-labelledby="vfyl" alt="">
			<span id="vfyl" class="hide-accessible tooltip-text">注:请上传jpg或pdf格式的文件，jpg格式文件大小不能超过2M,pdf格式文件不能超过20M,如果文件超过限定大小，请拆分后重新上传！</span>
			</span>
		</td>
	</tr>
	<c:forEach items="<%=applyMaterialList%>" var="material" varStatus="status"> 
		<tr style="text-align: center" class="fileTr">
			<td style="text-align: center" class="fileNo">${material.xh}</td>
			<td>${material.clmc}</td>
			<td style="text-align: center">
				<div id="fileDiv${status.index+1}">
				<!-- todo
				此处可以根据状态来隐藏删除按钮的显示，提交后删除按钮不再显示
				 -->
					<c:if test="${not empty material.fileEntryIds}">
						<c:forEach items="${fn:split(material.fileEntryIds,',')}" var="fileEntryId" varStatus="statusSub">
							<div name="file${status.index+1}">
							<a class="fileName" href="javascript:void(0);">
										${material.clmc}-${statusSub.index+1}.${fn:split(fileEntryId,'|')[1]}</a> &nbsp;&nbsp;&nbsp;
							<a href='javascript:void(0)';  onclick="${renderResponse.namespace}fileDelete(this,${fn:split(fileEntryId,'|')[0]},${material.materialId})">删除</a></div>
						</c:forEach>
					</c:if>
				</div>
			</td>
			<td style="text-align: center">
				<input type="button" value="上传" onclick="document.getElementById('fileInput${status.index+1}').click();"> 
				<input id="fileInput${status.index+1}" name="${namespace}fileInput${status.index+1}" type="file" multiple=""
				style="display:none;width: 150px;" accept="application/pdf,image/jpeg"  onchange="${renderResponse.namespace}fileUpLoad(${status.index+1},${material.materialId},'<%=portletDisplay.getId() %>');"></input>
	
			</td>
		</tr>
	</c:forEach>
	
</table>

<div style="text-align: center">
	<aui:button  value="保存"  onclick="saveMaterials()" cssClass="btn btn-primary"/>
	<aui:button  value="上报"  onclick="submitAll()" cssClass="btn btn-primary"/>
</div>


</form>

<form id="fmFile" enctype="multipart/form-data" method="post">

</form>

<script>
	function saveMaterials(){
		document.getElementById("fm").action='${fileSaveURL}';
		document.getElementById("fm").submit();
	}

	function submitAll(){
		document.getElementById("fm").action='${submitAllURL}';
		document.getElementById("fm").submit();
		
	}





	//文件类型和大小的验证
	function fileValidator(inputFileId){
		 var fileInput = $("#"+inputFileId)[0];
         if(fileInput){
         	var fileName=fileInput.files[0].name;
         	var fileExtension=fileName.split('.')[1].toUpperCase();
	        var fileSize  =Math.ceil(fileInput.files[0].size / (1024*1024)) ;//M为单位
	        if(fileExtension!="JPG"&&fileExtension!="PDF"){
	        	alert("文件上传仅限于jpg或者pdf格式！");
	        	return false;
	        }else if(fileExtension=="JPG"){
	        	if(fileSize>2){	
	        		alert("上传的jpg文件超过2M,请压缩后上传！")
	        		return false;
	        	}
	        }else if(fileExtension=="PDF"){
	        	if(fileSize>20){	
	        		alert("上传的pdf文件超过20M,请压缩或拆分后上传！")
	        		return false;
	        	}
	        }	         
         }      
	     return true;
	 }



	
		
	/* 上传 */
	function <portlet:namespace/>fileUpLoad(divNo,materialId,portletId) {
		if(fileValidator("fileInput"+divNo)){
			var fileExtension=$("#fileInput"+divNo)[0].files[0].name.split('.')[1];
			var no = findFileNo(divNo);
			var fmFile = document.getElementById("fmFile");
			var oMyForm = new FormData(fmFile);
			oMyForm.append("<portlet:namespace/>divNo",divNo);
			oMyForm.append("<portlet:namespace/>materialId",materialId);
			oMyForm.append("<portlet:namespace/>portletId",portletId);
			oMyForm.append("<portlet:namespace/>userfile", $("#fileInput"+divNo)[0].files[0]);
			oMyForm.append("<portlet:namespace/>no", no);
			oMyForm.append("<portlet:namespace/>fileExtension", fileExtension);
			$.ajax({
						url : "<%=fileUpLoadURL%>",
						type : "post",
						data : oMyForm,
						cache : false,
						processData : false,
						contentType : false,
						success : function(data) {
							var fileData = eval("(" + data + ")");
							var ele = "<div name='file"+divNo+"'><a class='fileName' href='javascript:void(0);'>"
							+ fileData.materialName+"-"+no+"."+fileExtension
							+ "</a> &nbsp;&nbsp;&nbsp;<a href='javascript:void(0)';  onclick='${renderResponse.namespace}fileDelete(this,"
							+ fileData.fileId + ","+materialId+")'>删除</a></div>";
							$("#fileDiv" + divNo).append(ele);
							domSort(divNo); 
							alert("上传成功！");				
						},
						error : function(e) {
							alert("网络错误，请重试！！");
						}
					});
		}
	}

	/* 删除 */
	function <portlet:namespace/>fileDelete(divObj, fileId, materialId) {
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
			//把已有的附件名称后缀的数字放到数组中
			fileNameNoArr[indexNo]=text;
			indexNo = (indexNo + 1);
		});
		//判断数组中从1开始缺少哪些数字，缺少的数字即为需要的数字
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

</script>