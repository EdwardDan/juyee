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
 .mask {       
            position: absolute; top: 0px; filter: alpha(opacity=60); background-color: #777;     
            z-index: 1002; left: 0px;     
            opacity:0.5; -moz-opacity:0.5;     
        }   
</style>

<%
	long permitId =ParamUtil.getLong(renderRequest,"permitId");
	Permit permit = PermitLocalServiceUtil.getPermit(permitId);
	ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
	request.setAttribute("permit", permit);
	List<ApplyMaterial> materialList=ApplyMaterialLocalServiceUtil.findByPermitId(permitId, -1, -1);
	Map<Long,List<DLFileEntry>> map=new HashMap<Long,List<DLFileEntry>>();
	Map<Long,List<DLFileEntry>> mapBzcl=new HashMap<Long,List<DLFileEntry>>();
	Map<Long,List<DLFileEntry>> mapWjscbzcl=new HashMap<Long,List<DLFileEntry>>();
	if(null!=materialList){
	for(int i=0;i<materialList.size();i++){
		
	ApplyMaterial applyMaterial=materialList.get(i);
	String fileEntryIds=applyMaterial.getFileEntryIds();
	String[] fileEntryIdsArr=fileEntryIds.split("\\,");
	List<DLFileEntry> list=new ArrayList<DLFileEntry>();
	if(null!=fileEntryIdsArr&&fileEntryIdsArr.length>0){
	for(int j=0;j<fileEntryIdsArr.length;j++){
		if(Validator.isNotNull(fileEntryIdsArr[j])){
	String fileEntryId=fileEntryIdsArr[j].split("\\|")[0];
	DLFileEntry dlFileEntry=DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(fileEntryId));
		list.add(dlFileEntry);
	}
	
		}
	map.put(materialList.get(i).getMaterialId(), list);
	}
	
	String bzclIds=applyMaterial.getBzclIds();
	if(Validator.isNotNull(bzclIds)){
	String[] bzclIdsArr=bzclIds.split("\\,");
	List<DLFileEntry> listBzcl=new ArrayList<DLFileEntry>();
	if(null!=bzclIdsArr&&bzclIdsArr.length>0){
	for(int j=0;j<bzclIdsArr.length;j++){
		if(Validator.isNotNull(bzclIdsArr[j])){
	String fileEntryId=bzclIdsArr[j].split("\\|")[0];
	DLFileEntry dlFileEntry=DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(fileEntryId));
		listBzcl.add(dlFileEntry);
	}
		
		}
	mapBzcl.put(materialList.get(i).getMaterialId(), listBzcl);
	}
	}
	
	String wjscbzclIds=applyMaterial.getWjscbzclIds();
	if(Validator.isNotNull(wjscbzclIds)){
	String[] wjscbzclIdsArr=wjscbzclIds.split("\\,");
	List<DLFileEntry> listWjscbzcl=new ArrayList<DLFileEntry>();
	if(null!=wjscbzclIdsArr&&wjscbzclIdsArr.length>0){
	for(int j=0;j<wjscbzclIdsArr.length;j++){
		if(Validator.isNotNull(wjscbzclIdsArr[j])){
	String fileEntryId=wjscbzclIdsArr[j].split("\\|")[0];
	DLFileEntry dlFileEntry=DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(fileEntryId));
		listWjscbzcl.add(dlFileEntry);
	}
		
		}
	
	mapWjscbzcl.put(materialList.get(i).getMaterialId(), listWjscbzcl);
	
	}
	}
	
	
	}
	}
	String jpg = "jpg";
	String pdf = "pdf";
	request.setAttribute("jpg", jpg);
	request.setAttribute("pdf", pdf);
	request.setAttribute("map", map);
	request.setAttribute("mapBzcl", mapBzcl);
	request.setAttribute("mapWjscbzcl", mapWjscbzcl);
%>

<c:set var="namespace" value="<%=renderResponse.getNamespace()%>"></c:set>

<div id="mask" class="mask"><div id="loading" style="position:fixed;top:50%;left:50%">
</div></div>    
<form id="fm" enctype="multipart/form-data" method="post">
	<table class="table table-bordered" style="font-size: 14px;"
		id="fileTable">
		<thead style="text-align: center; height: 45px;">
			<th style="text-align: center; width: 5%;">序号</th>
			<th style="text-align: center; width: 25%;">申请材料名称</th>
			<th style="text-align: center; width: 30%;">附件</th>
			<c:if test="<%=!projectProfile.getLxjb().equals(\"区县级机关或区县级单位\")%>">
			<c:if test="${!(permit.status==2||permit.status==3||permit.status==5||permit.status==6||permit.status==10)}">
				<th style="text-align: center; width: 15%;">建管中心补正材料查看</th>
			</c:if>
			<c:if test="${permit.status==2||permit.status==3||permit.status==5||permit.status==6||permit.status==10}">
				<th style="text-align: center; width: 15%;">建管中心补正材料</th>
				<th style="text-align: center; width: 10%;">操作 <span
					class="taglib-icon-help"> <img
						id="yui_patched_v3_11_0_1_1473298445453_1601" tabindex="0"
						src="/html/themes/control_panel/images/portlet/help.png"
						onmouseover="Liferay.Portal.ToolTip.show(this);"
						onfocus="Liferay.Portal.ToolTip.show(this);"
						onblur="Liferay.Portal.ToolTip.hide();" aria-labelledby="vfyl"
						alt=""> <span id="vfyl" class="hide-accessible tooltip-text">注:请上传jpg或pdf格式的文件，jpg格式文件大小不能超过2M,pdf格式文件不能超过20M,如果文件超过限定大小，请拆分后重新上传！</span>
				</span></th>
			</c:if>
	<!--委建设处时的补正材料  -->
			<c:if test="${permit.status!=13}">
				<th style="text-align: center; width: 15%;">委建设处补正材料查看</th>
			</c:if>
			<c:if test="${permit.status==13}">
				<th style="text-align: center; width: 15%;">委建设处补正材料</th>
				<th style="text-align: center; width: 10%;">操作 <span
					class="taglib-icon-help"> <img
						id="yui_patched_v3_11_0_1_1473298445453_1601" tabindex="0"
						src="/html/themes/control_panel/images/portlet/help.png"
						onmouseover="Liferay.Portal.ToolTip.show(this);"
						onfocus="Liferay.Portal.ToolTip.show(this);"
						onblur="Liferay.Portal.ToolTip.hide();" aria-labelledby="vfyl"
						alt=""> <span id="vfyl" class="hide-accessible tooltip-text">注:请上传jpg或pdf格式的文件，jpg格式文件大小不能超过2M,pdf格式文件不能超过20M,如果文件超过限定大小，请拆分后重新上传！</span>
				</span></th>
			</c:if>
</c:if>
		</thead>
		<c:forEach items="<%=materialList%>" var="material" varStatus="status">
			<tr style="text-align: center" class="fileTr">
				<td style="text-align: center" class="fileNo">${material.xh}</td>
				<td>${material.clmc}</td>
				<td style="text-align: center">
					<div class="${material.materialId}">
						<c:if test="${not empty material.fileEntryIds}">
							<c:forEach items="${map[material.materialId]}" var="dlFileEntry"
								varStatus="varNo">
								<div>
									<c:set var="filePath"
										value="${dlFileEntry.groupId }/${dlFileEntry.folderId}/${dlFileEntry.title }" />
									<c:set var="fileName"
										value="${material.clmc }-${varNo.index+1 }.${dlFileEntry.extension }" />
									<c:if test="${dlFileEntry. extension eq jpg}">
										<a href="#"
											onclick="previewJpg(${material.materialId},${dlFileEntry.fileEntryId})">${material.clmc }-${varNo.index+1 }.${dlFileEntry.extension }</a>
										<img src="/documents/${filePath }" style="display: none;"
											id="${dlFileEntry.fileEntryId}" alt="${dlFileEntry.title}">
									</c:if>
									<c:if test="${dlFileEntry.extension eq pdf}">
										<a href="#" onclick="previewPdf('/documents/${filePath}')">${material.clmc }-${varNo.index+1 }.${dlFileEntry.extension }</a>
									</c:if>
									<a href="/documents/${filePath }?&download=true">下载</a>
								</div>
							</c:forEach>
						</c:if>
					</div>
				</td>
		<c:if test="<%=!projectProfile.getLxjb().equals(\"区县级机关或区县级单位\")%>">
				<c:if test="${!(permit.status==2||permit.status==3||permit.status==5||permit.status==6||permit.status==10)}">
					<td style="text-align: center">
						<div class="${material.materialId}">
							<c:if test="${not empty material.bzclIds}">
								<c:forEach items="${mapBzcl[material.materialId]}"
									var="dlFileEntry" varStatus="varStausNo">
									<div>
										<c:set var="filePathBzcl"
											value="${dlFileEntry.groupId }/${dlFileEntry.folderId}/${dlFileEntry.title }" />
										<c:set var="fileNameBzcl"
											value="${material.clmc }-${varStausNo.index+1 }.${dlFileEntry.extension }" />
										<c:if test="${dlFileEntry. extension eq jpg}">
											<a href="#"
												onclick="previewJpg(${material.materialId},${dlFileEntry.fileEntryId})">${material.clmc }建管中心补正材料-${varStausNo.index+1 }.${dlFileEntry.extension }</a>
											<img src="/documents/${filePathBzcl }" style="display: none;"
												id="${dlFileEntry.fileEntryId}" alt="${dlFileEntry.title}">
										</c:if>
										<c:if test="${dlFileEntry.extension eq pdf}">
											<a href="#"
												onclick="previewPdf('/documents/${filePathBzcl}')">${material.clmc }建管中心补正材料-${varStausNo.index+1 }.${dlFileEntry.extension }</a>
										</c:if>
										<a href="/documents/${filePathBzcl }?&download=true">下载</a>
									</div>
								</c:forEach>
							</c:if>
						</div>
					</td>
				</c:if>
				<c:if test="${permit.status==2||permit.status==3||permit.status==5||permit.status==6||permit.status==10}">
					<td style="text-align: center">
						<div id="fileDivBzcl${status.index+1}">
							<!-- todo
				此处可以根据状态来隐藏删除按钮的显示，提交后删除按钮不再显示
				 -->
							<c:if test="${not empty material.bzclIds}">
								<c:forEach items="${fn:split(material.bzclIds,',')}"
									var="bzclId" varStatus="statusSub">
									<div name="fileBzcl${status.index+1}">
										<a class="fileName" href="javascript:void(0);">
											${material.clmc}补正材料-${statusSub.index+1}.${fn:split(bzclId,'|')[1]}
										</a> &nbsp;&nbsp;&nbsp; <a href='javascript:void(0)'
											;  onclick="${namespace}fileBzclDelete(this,${fn:split(bzclId,'|')[0]},${material.materialId})">删除</a>
									</div>
								</c:forEach>
							</c:if>
						</div>
					</td>
					<td style="text-align: center"><input type="button" value="上传"
						onclick="document.getElementById('fileBzclInput${status.index+1}').click();">
						<input id="fileBzclInput${status.index+1}"
						name="${namespace}fileBzclInput${status.index+1}" type="file"
						multiple="" style="display: none; width: 150px;"
						accept="application/pdf,image/jpeg"
						onchange="${namespace}fileBzclUpLoad(${status.index+1},${material.materialId},'<%=portletDisplay.getId() %>');${namespace}clearValue(this);"></input>

					</td>
				</c:if>
				
				
				<!-- 委建设处补正材料 -->
				<c:if test="${permit.status!=13}">
					<td style="text-align: center">
					
						<div class="${material.materialId}">
							<c:if test="${not empty material.wjscbzclIds}">
								<c:forEach items="${mapWjscbzcl[material.materialId]}"
									var="dlFileEntry" varStatus="varStausNo">
									<div>
										<c:set var="filePathWjscbzcl"
											value="${dlFileEntry.groupId }/${dlFileEntry.folderId}/${dlFileEntry.title }" />
										<c:set var="fileNameWjscbzcl"
											value="${material.clmc }-${varStausNo.index+1 }.${dlFileEntry.extension }" />
										<c:if test="${dlFileEntry. extension eq jpg}">
											<a href="#"
												onclick="previewJpg(${material.materialId},${dlFileEntry.fileEntryId})">${material.clmc }补正材料(委建设处)-${varStausNo.index+1 }.${dlFileEntry.extension }</a>
											<img src="/documents/${filePathWjscbzcl }" style="display: none;"
												id="${dlFileEntry.fileEntryId}" alt="${dlFileEntry.title}">
										</c:if>
										<c:if test="${dlFileEntry.extension eq pdf}">
											<a href="#"
												onclick="previewPdf('/documents/${filePathWjscbzcl}')">${material.clmc }补正材料(委建设处)-${varStausNo.index+1 }.${dlFileEntry.extension }</a>
										</c:if>
										<a href="/documents/${filePathWjscbzcl }?&download=true">下载</a>
									</div>
								</c:forEach>
							</c:if>
						</div>
					</td>
				</c:if>



				<c:if test="${permit.status==13}">
					<td style="text-align: center">
						<div id="fileDivWjscbzcl${status.index+1}">
							<!-- todo
				此处可以根据状态来隐藏删除按钮的显示，提交后删除按钮不再显示
				 -->
							<c:if test="${not empty material.wjscbzclIds}">
								<c:forEach items="${fn:split(material.wjscbzclIds,',')}"
									var="wjscbzclId" varStatus="statusSub">
									<div name="fileWjscbzcl${status.index+1}">
										<a class="fileName" href="javascript:void(0);">
											${material.clmc}补正材料(委建设处)-${statusSub.index+1}.${fn:split(wjscbzclId,'|')[1]}
										</a> &nbsp;&nbsp;&nbsp; <a href='javascript:void(0)'
											;  onclick="${namespace}fileWjscbzclDelete(this,${fn:split(wjscbzclId,'|')[0]},${material.materialId})">删除</a>
									</div>
								</c:forEach>
							</c:if>
						</div>
					</td>
					<td style="text-align: center"><input type="button" value="上传"
						onclick="document.getElementById('fileWjscbzclInput${status.index+1}').click();">
						<input id="fileWjscbzclInput${status.index+1}"
						name="${namespace}fileWjscbzclInput${status.index+1}" type="file"
						multiple="" style="display: none; width: 150px;"
						accept="application/pdf,image/jpeg"
						onchange="${namespace}fileWjscbzclUpLoad(${status.index+1},${material.materialId},'<%=portletDisplay.getId() %>');${namespace}clearValue(this);"></input>

					</td>
				</c:if>
				</c:if>
			</tr>
		</c:forEach>

	</table>
</form>

<form id="fmFile" enctype="multipart/form-data" method="post"></form>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/permit-approval" />
<portlet:renderURL var="previewPdfURL" windowState="pop_up">
	<portlet:param name="mvcPath"
		value="${contextPath}/view-permit/applymaterials-pdf.jsp" />
</portlet:renderURL>
<portlet:resourceURL var="fileBzclUpLoadURL" id="fileBzclUpLoad" />
<portlet:resourceURL var="fileBzclDeleteURL" id="fileBzclDelete" />
<!-- 委建设处补正材料 -->
<portlet:resourceURL var="fileWjscbzclUpLoadURL" id="fileWjscbzclUpLoad" />
<portlet:resourceURL var="fileWjscbzclDeleteURL" id="fileWjscbzclDelete" />
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
	
	//文件类型和大小的验证
	function fileValidator(inputFileId){
		 var fileInput = $("#"+inputFileId)[0];
         if(fileInput){
         	var fileName=fileInput.files[0].name;
         	var fileBzclExtension=fileName.split('.').pop().toUpperCase();
	        var fileSize  =Math.ceil(fileInput.files[0].size / (1024*1024)) ;//M为单位
	        if(fileBzclExtension!="JPG"&&fileBzclExtension!="PDF"){
	        	alert("文件上传仅限于jpg或者pdf格式！");
	        	return false;
	        }else if(fileBzclExtension=="JPG"){
	        	if(fileSize>2){	
	        		alert("上传的jpg文件超过2M,请压缩后上传！")
	        		return false;
	        	}
	        }else if(fileBzclExtension=="PDF"){
	        	if(fileSize>20){	
	        		alert("上传的pdf文件超过20M,请压缩或拆分后上传！")
	        		return false;
	        	}
	        }	         
         }      
	     return true;
	 }

	
	/* 上传 */
	function <portlet:namespace/>fileBzclUpLoad(divNo,materialId,portletId) {
		if(fileValidator("fileBzclInput"+divNo)){
			var fileBzclExtension=$("#fileBzclInput"+divNo)[0].files[0].name.split('.').pop();
			var no = findFileNo(divNo);
			var fmFile = document.getElementById("fmFile");
			var oMyForm = new FormData(fmFile);
			oMyForm.append("<portlet:namespace/>divNo",divNo);
			oMyForm.append("<portlet:namespace/>materialId",materialId);
			oMyForm.append("<portlet:namespace/>portletId",portletId);
			oMyForm.append("<portlet:namespace/>userfileBzcl", $("#fileBzclInput"+divNo)[0].files[0]);
			oMyForm.append("<portlet:namespace/>no", no);
			oMyForm.append("<portlet:namespace/>fileBzclExtension", fileBzclExtension);
			$.ajax({
						url : "<%=fileBzclUpLoadURL%>",
						type : "post",
						data : oMyForm,
						cache : false,
						processData : false,
						contentType : false,
						beforeSend:function(XMLHttpRequest){
							$("#loading").html("<img src='/cp-portlet/icons/loading2.gif' style='width:100px;height:100px;'></img>");
							showMask();
						},
						success : function(data) {
							var fileData = eval("(" + data + ")");
							var ele = "<div name='fileBzcl"+divNo+"'><a class='fileBzclName' href='javascript:void(0);'>"
							+ fileData.materialName+"-"+no+"."+fileBzclExtension
							+ "</a> &nbsp;&nbsp;&nbsp;<a href='javascript:void(0)';  onclick='${renderResponse.namespace}fileBzclDelete(this,"
							+ fileData.fileBzclId + ","+materialId+")'>删除</a></div>";
							$("#fileDivBzcl" + divNo).append(ele);
							domSort(divNo); 
							alert("上传成功！");				
						},
						complete:function(){
							hideMask();
							$("#loading").html("");
						},
						error : function(e) {
							alert("网络错误，请重试！！");
						}
					});
		}
	}

	function <portlet:namespace/>clearValue(btn){
		var input=$(btn);
		input.replaceWith(input.val('').clone(true));
	}
	/* 删除 */
	function <portlet:namespace/>fileBzclDelete(divObj, fileId, materialId) {
		if (!confirm("确定要删除此文件吗？"))
			return;
		$.ajax({
			url : "<%=fileBzclDeleteURL%>",
			type : "post",
			data : {
				'<portlet:namespace/>fileBzclId' : fileId,
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
		$("div[name^='fileBzcl" + divNo + "']").each(function() {
			var text=$(this).children("a.fileBzclName").text().split('.')[0].split('-')[1];
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
		var sortEle=$("div[name^='fileBzcl" + divNo + "']").sort(function(a,b){
		    var valveNumOfa = $(a).children("a.fileBzclName").text().split('.')[0].split('-')[1];
		    var valveNumOfb = $(b).children("a.fileBzclName").text().split('.')[0].split('-')[1];
		    if(parseInt(valveNumOfa) < parseInt(valveNumOfb)) return -1;
		    else return 1;
		});
		$('#fileDivBzcl'+divNo).empty().append(sortEle);
	}
	
	/* 委建设处补正材料上传 */
	function <portlet:namespace/>fileWjscbzclUpLoad(divNo,materialId,portletId) {
		if(fileValidator("fileWjscbzclInput"+divNo)){
			var fileWjscbzclExtension=$("#fileWjscbzclInput"+divNo)[0].files[0].name.split('.').pop();
			var no = findFileWjscbzclNo(divNo);
			var fmFile = document.getElementById("fmFile");
			var oMyForm = new FormData(fmFile);
			oMyForm.append("<portlet:namespace/>divNo",divNo);
			oMyForm.append("<portlet:namespace/>materialId",materialId);
			oMyForm.append("<portlet:namespace/>portletId",portletId);
			oMyForm.append("<portlet:namespace/>userfileWjscbzcl", $("#fileWjscbzclInput"+divNo)[0].files[0]);
			oMyForm.append("<portlet:namespace/>no", no);
			oMyForm.append("<portlet:namespace/>fileWjscbzclExtension", fileWjscbzclExtension);
			$.ajax({
						url : "<%=fileWjscbzclUpLoadURL%>",
						type : "post",
						data : oMyForm,
						cache : false,
						processData : false,
						contentType : false,
						beforeSend:function(XMLHttpRequest){
							$("#loading").html("<img src='/cp-portlet/icons/loading2.gif' style='width:100px;height:100px;'></img>");
							showMask();
						},
						success : function(data) {
							var fileData = eval("(" + data + ")");
							var ele = "<div name='fileWjscbzcl"+divNo+"'><a class='fileWjscbzclName' href='javascript:void(0);'>"
							+ fileData.materialName+"补正材料(委建设处)-"+no+"."+fileWjscbzclExtension
							+ "</a> &nbsp;&nbsp;&nbsp;<a href='javascript:void(0)';  onclick='${renderResponse.namespace}fileWjscbzclDelete(this,"
							+ fileData.fileWjscbzclId + ","+materialId+")'>删除</a></div>";
							$("#fileDivWjscbzcl" + divNo).append(ele);
							domSortWjscbzcl(divNo); 
							alert("上传成功！");				
						},
						complete:function(){
							hideMask();
							$("#loading").html("");
						},
						error : function(e) {
							alert("网络错误，请重试！！");
						}
					});
		}
	}
	
	function <portlet:namespace/>clearValue(btn){
		var input=$(btn);
		input.replaceWith(input.val('').clone(true));
	}

	/* 委建设处补正材料上传删除 */
	function <portlet:namespace/>fileWjscbzclDelete(divObj, fileId, materialId) {
		if (!confirm("确定要删除此文件吗？"))
			return;
		$.ajax({
			url : "<%=fileWjscbzclDeleteURL%>",
			type : "post",
			data : {
				'<portlet:namespace/>fileWjscbzclId' : fileId,
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
	function findFileWjscbzclNo(divNo) {
		var indexNo = 0;
		var fileNameNoArr=new Array();
		$("div[name^='fileWjscbzcl" + divNo + "']").each(function() {
			var text=$(this).children("a.fileWjscbzclName").text().split('.')[0].split('-')[1];
			//把已有的附件名称后缀的数字放到数组中
			fileNameNoArr[indexNo]=text;
			indexNo = (indexNo + 1);
		});
		//判断数组中从1开始缺少哪些数字，缺少的数字即为需要的数字
		return getNo(fileNameNoArr);
	}
	
	/* 给div元素重新排序 */
	function domSortWjscbzcl(divNo){
		var sortEle=$("div[name^='fileBzcl" + divNo + "']").sort(function(a,b){
		    var valveNumOfa = $(a).children("a.fileWjscbzclName").text().split('.')[0].split('-')[1];
		    var valveNumOfb = $(b).children("a.fileWjscbzclName").text().split('.')[0].split('-')[1];
		    if(parseInt(valveNumOfa) < parseInt(valveNumOfb)) return -1;
		    else return 1;
		});
		$('#fileDivBzcl'+divNo).empty().append(sortEle);
	}
	
	 function showMask(){     
	        $("#mask").css("height",$(document).height());     
	        $("#mask").css("width",$(document).width());     
	        $("#mask").show();     
	    }  
	    //隐藏遮罩层  
	    function hideMask(){     
	        $("#mask").hide();     
	    }  
</script>


