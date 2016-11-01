<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<%
	String backUrl_dynamic=PortalUtil.getCurrentURL(renderRequest);
%>

<a href="<%=backUrl_dynamic%>" id="refreshCurrentPage"></a>
<style>
.aui .table th, .aui .table td {
	vertical-align: middle;
	padding: 8px;
}

.aui input[type="file"] {
	width: 150px;
}

.mask {
	position: absolute;
	top: 0px;
	filter: alpha(opacity = 60);
	background-color: #777;
	z-index: 1002;
	left: 0px;
	opacity: 0.5;
	-moz-opacity: 0.5;
}
</style>

<%
	List<Dictionary> materialDictionaries=new ArrayList<Dictionary>();
	List<CompleteApplyMaterial> completeApplyMaterialList=new ArrayList<CompleteApplyMaterial>();
	 long completeId =ParamUtil.getLong(renderRequest,"completeId",0); 
	if(Validator.isNotNull(completeId)){
		  completeApplyMaterialList= CompleteApplyMaterialLocalServiceUtil.findByCompleteId(completeId, -1, -1);  
		//对材料表进行初始化
		if(completeApplyMaterialList.size()<=0){
	CompleteProjectProfile completeProjectProfile=CompleteProjectProfileLocalServiceUtil.fetchCompleteProjectProfile(completeId);
	long xmlxId=completeProjectProfile.getXmlx();//项目类型
	long jsgcsxId=completeProjectProfile.getJsgcsx();//建设工程属性
	if(Validator.isNotNull(xmlxId)&&Validator.isNotNull(jsgcsxId)){
		Dictionary xmlxDictionary= DictionaryLocalServiceUtil.getDictionary(xmlxId);
		Dictionary jsgcsxDictionary= DictionaryLocalServiceUtil.getDictionary(jsgcsxId);
		String xmlxCode=xmlxDictionary.getCode();
		String jsgcsxCode=jsgcsxDictionary.getCode();
		if(CpConstants.XJ.equals(jsgcsxCode)||CpConstants.KJ.equals(jsgcsxCode)||CpConstants.GJ.equals(jsgcsxCode)){//新改扩
	if(CpConstants.GK.equals(xmlxCode)){ 
		Dictionary gk_xgk_Dictionary=DictionaryLocalServiceUtil.findByCode(CpConstants.JG_GK_XGK);
		materialDictionaries=DictionaryLocalServiceUtil.findByParentId(gk_xgk_Dictionary.getDictionaryId(), -1, -1);
		}
	if(CpConstants.HD.equals(xmlxCode)){
		Dictionary hd_xgk_Dictionary=DictionaryLocalServiceUtil.findByCode(CpConstants.JG_HD_XGK);
		materialDictionaries=DictionaryLocalServiceUtil.findByParentId(hd_xgk_Dictionary.getDictionaryId(), -1, -1);
	}
	if(CpConstants.GL.equals(xmlxCode)){
		Dictionary gl_xgk_Dictionary=DictionaryLocalServiceUtil.findByCode(CpConstants.JG_GL_XGK);
		materialDictionaries=DictionaryLocalServiceUtil.findByParentId(gl_xgk_Dictionary.getDictionaryId(), -1, -1);
	}
	if(CpConstants.SZ.equals(xmlxCode)){
		Dictionary szjt_xgk_Dictionary=DictionaryLocalServiceUtil.findByCode(CpConstants.JG_SZJT_XGK);
		materialDictionaries=DictionaryLocalServiceUtil.findByParentId(szjt_xgk_Dictionary.getDictionaryId(), -1, -1);
	}
		}else{
	if(CpConstants.GL.equals(xmlxCode)){
		Dictionary gl_xgk_Dictionary=DictionaryLocalServiceUtil.findByCode(CpConstants.JG_GL_DX);
		materialDictionaries=DictionaryLocalServiceUtil.findByParentId(gl_xgk_Dictionary.getDictionaryId(), -1, -1);
	}
	if(CpConstants.SZ.equals(xmlxCode)){
		Dictionary szjt_xgk_Dictionary=DictionaryLocalServiceUtil.findByCode(CpConstants.JG_SZJT_DX);
		materialDictionaries=DictionaryLocalServiceUtil.findByParentId(szjt_xgk_Dictionary.getDictionaryId(), -1, -1);
	}
		}
	}
	for(Dictionary dic: materialDictionaries){
		CompleteApplyMaterial completeApplyMaterial=CompleteApplyMaterialLocalServiceUtil.createCompleteApplyMaterial(CounterLocalServiceUtil.increment());
		 completeApplyMaterial.setCompleteId(completeId);
		 completeApplyMaterial.setXh(dic.getTag());
		 completeApplyMaterial.setClmc(dic.getName());
		 completeApplyMaterialList.add(completeApplyMaterial);
		 CompleteApplyMaterialLocalServiceUtil.updateCompleteApplyMaterial(completeApplyMaterial);		
	}
	}
	
	}
	renderRequest.setAttribute("materialSize", completeApplyMaterialList.size());
%>

<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<portlet:renderURL var="uploadFileURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="path" value="uploadFile" />
</portlet:renderURL>

<!-- For Closing -->
<aui:script>
Liferay.provide(window,'<portlet:namespace/>closeYourPopUp',
	    function(data, dialogId) {
		var A = AUI();
		var dialog = Liferay.Util.Window.getById(dialogId);
		dialog.destroy();
		document.getElementById("refreshCurrentPage").click();
	},
	['liferay-util-window']
);
</aui:script>
	


<portlet:renderURL var="viewURL" />
<c:set var="namespace" value="<%=renderResponse.getNamespace()%>"></c:set>
<portlet:resourceURL var="fileUpLoadURL" id="fileUpLoad" />
<portlet:resourceURL var="fileDeleteURL" id="fileDelete" />

<portlet:actionURL var="fileSaveURL" name="saveCompleteApplyMaterials">
	<portlet:param name="redirectURL" value="${editCompleteURL}" />
</portlet:actionURL>

<portlet:actionURL var="submitAllURL" name="submitAll">
	<portlet:param name="redirect" value="${viewURL}" />
</portlet:actionURL>


<aui:form id="fm" action="${fileSaveURL}" enctype="multipart/form-data"
	method="post">
	<aui:input type="hidden" name="completeId" value="<%=completeId%>"></aui:input>
	<table class="table table-bordered" style="font-size: 14px;"
		id="fileTable">
		<tr style="text-align: center; height: 45px;">
			<td style="text-align: center; width: 5%;">序号</td>
			<td style="text-align: center; width: 30%;">申请材料名称</td>
			<td style="text-align: center; width: 45%;">附件</td>
			<td style="text-align: center; width: 20%;">操作 <span
				class="taglib-icon-help"> <img
					id="yui_patched_v3_11_0_1_1473298445453_1601" tabindex="0"
					src="/html/themes/control_panel/images/portlet/help.png"
					onmouseover="Liferay.Portal.ToolTip.show(this);"
					onfocus="Liferay.Portal.ToolTip.show(this);"
					onblur="Liferay.Portal.ToolTip.hide();" aria-labelledby="vfyl"
					alt=""> <span id="vfyl" class="hide-accessible tooltip-text">注:请上传jpg或pdf格式的文件，jpg格式文件大小不能超过2M,pdf格式文件不能超过20M,如果文件超过限定大小，请拆分后重新上传！</span>
			</span>
			</td>
		</tr>
		<%
			for(int i=0;i<completeApplyMaterialList.size();i++){
				CompleteApplyMaterial completeApplyMaterial=completeApplyMaterialList.get(i);
				renderRequest.setAttribute("applyMaterialId", completeApplyMaterial.getMaterialId());
				renderRequest.setAttribute("no1", i+1);
		%>
		<tr style="text-align: center" class="fileTr">
			<td style="text-align: center" class="fileNo"><%=completeApplyMaterial.getXh()%></td>
			<td><%=completeApplyMaterial.getClmc()%></td>
			<td style="text-align: center">
				<div id="fileDiv${no1}">
					<%
						String fileEntryIds=completeApplyMaterial.getFileEntryIds();
									if(Validator.isNotNull(fileEntryIds)){
										String[] fileEntryIdArr=fileEntryIds.split("\\,");
										for(int j=0; j<fileEntryIdArr.length;j++){
											String fileEntryId=fileEntryIdArr[j].split("\\|")[0];
											renderRequest.setAttribute("no2", j+1);
											DLFileEntry dlFileEntry=DLFileEntryLocalServiceUtil.getFileEntry(Long.valueOf(fileEntryId));
					%>
					<div name="file${no1}">
						<a class="fileName" href="javascript:void(0);"> <%=dlFileEntry.getTitle()%></a>
						&nbsp;&nbsp;&nbsp; <a href='javascript:void(0)'
							;  onclick="${renderResponse.namespace}fileDelete(this,<%=fileEntryId%>,<%=completeApplyMaterial.getMaterialId() %>)">删除</a>
					</div>
					<%
						}
									}
					%>
				</div>
			</td>
			<td style="text-align: center"><aui:button name="login${no1}"
					type="button" value="上传" /></td>
		</tr>
		<aui:script use="liferay-util-window">
					A.one('#<portlet:namespace/>login${no1}').on('click', function(event) {
						var no = findFileNo('${no1}');
					    <!-- alert("open"); -->
						Liferay.Util.openWindow({
							dialog: {
								centered: true,
								height: 500,
								modal: true,
								width: 500,
							},
							id: '<portlet:namespace/>dialog',
							title: '文件上传',
							uri: '<%=uploadFileURL%>${no1}/${applyMaterialId}/'+no,
						});
						$("button.close").css("display","none");
					}); 
				</aui:script>
				<%
			}
		%>
		</table>

	<div style="text-align: center">
		<aui:button type="submit" value="保存" onclick="${fileSaveURL}"
			cssClass="btn btn-primary" />
		<aui:button type="submit" value="上报"
			onclick="${namespace }fm.action='${submitAllURL }'"
			cssClass="btn btn-primary" />
	</div>
</aui:form>

<script>
	/* $('.close-content').live('mouseover',function(event){
		alert(123);
		/* document.getElementById("refreshCurrentPage").click(); */
	/*});  */

	function hideTheXButton(){
		alert(444);
		var btn=$('.close-content');
		btn.remove();
		console.log(btn);
	}

	function saveMaterials(){
		document.getElementById("fm").action='${fileSaveURL}';
		document.getElementById("fm").submit();
		alert(555);
	}
	
	function submitAll(){
		document.getElementById("fm").action='${submitAllURL}';
		document.getElementById("fm").submit();
		
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
	
	
	$(function(){
		//当文档加载完给每种材料对应的附件进行排序
		var materialSizeInt=parseInt('${materialSize}');
		for(var divNo=1;divNo<=materialSizeInt;divNo++){
			domSort(divNo);
		}
		//为弹出框的X关闭按钮添加事件
	});
</script>