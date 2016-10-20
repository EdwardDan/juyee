<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<%@ page import="com.liferay.util.*"%>

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
	String uploadProgressId = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
	List<Dictionary> materialDictionaries=new ArrayList<Dictionary>();
	List<ApplyMaterial> applyMaterialList=new ArrayList<ApplyMaterial>();
	Long permitId =ParamUtil.getLong(renderRequest,"permitId",0);
	Project project = null;
	String type="";
	Permit permit=null;
	Boolean canTj=null;
	if(Validator.isNotNull(permitId)){
		permit = PermitLocalServiceUtil.getPermit(permitId);
		project=ProjectLocalServiceUtil.getProject(permit.getBjbh());
		if(project.getLxjb().equals("区县级机关或区县级单位")){
	type="quxian";
		}else{
	type="shishu";
		}
		applyMaterialList= ApplyMaterialLocalServiceUtil.findByPermitId(permitId, -1, -1);
		if(WorkflowInstanceLinkLocalServiceUtil.hasWorkflowInstanceLink(permit.getCompanyId(), 0L, Permit.class.getName(),permit.getPermitId())){
	canTj=false;
		}else{
	canTj=true;
		}
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
		if(CpConstants.XJ.equals(jsgcsxCode)||CpConstants. KJ.equals(jsgcsxCode)||CpConstants. GJ.equals(jsgcsxCode)){//新改扩
	if(CpConstants. GK.equals(xmlxCode)){
		Dictionary gk_xgk_Dictionary=DictionaryLocalServiceUtil.findByCode(CpConstants. GK_XGK);
		materialDictionaries=DictionaryLocalServiceUtil.findByParentId(gk_xgk_Dictionary.getDictionaryId(), -1, -1);
	}
	if(CpConstants. HD.equals(xmlxCode)){
		Dictionary hd_xgk_Dictionary=DictionaryLocalServiceUtil.findByCode(CpConstants. HD_XGK);
		materialDictionaries=DictionaryLocalServiceUtil.findByParentId(hd_xgk_Dictionary.getDictionaryId(), -1, -1);
	}
	if(CpConstants. GL.equals(xmlxCode)){
		Dictionary gl_xgk_Dictionary=DictionaryLocalServiceUtil.findByCode(CpConstants. GL_XGK);
		materialDictionaries=DictionaryLocalServiceUtil.findByParentId(gl_xgk_Dictionary.getDictionaryId(), -1, -1);
	}
	if(CpConstants. SZ.equals(xmlxCode)){
		Dictionary szjt_xgk_Dictionary=DictionaryLocalServiceUtil.findByCode(CpConstants. SZJT_XGK);
		materialDictionaries=DictionaryLocalServiceUtil.findByParentId(szjt_xgk_Dictionary.getDictionaryId(), -1, -1);
	}
	
	
		}else{
	
	if(CpConstants. GL.equals(xmlxCode)){
		Dictionary gl_xgk_Dictionary=DictionaryLocalServiceUtil.findByCode(CpConstants. GL_DX);
		materialDictionaries=DictionaryLocalServiceUtil.findByParentId(gl_xgk_Dictionary.getDictionaryId(), -1, -1);
	}
	if(CpConstants. SZ.equals(xmlxCode)){
		Dictionary szjt_xgk_Dictionary=DictionaryLocalServiceUtil.findByCode(CpConstants. SZJT_DX);
		materialDictionaries=DictionaryLocalServiceUtil.findByParentId(szjt_xgk_Dictionary.getDictionaryId(), -1, -1);
	}
		}
	}
	
	for(Dictionary dic: materialDictionaries){
		ApplyMaterial applyMaterial = ApplyMaterialLocalServiceUtil
				.createApplyMaterial(CounterLocalServiceUtil
						.increment());
		applyMaterial.setPermitId(permitId);
		applyMaterial.setXh(dic.getTag());
		applyMaterial.setClmc(dic.getName());
		applyMaterial.setShyq(dic.getCustomField1());
		applyMaterial.setYjfs(Validator.isNumber(dic
				.getCustomField2()) ? GetterUtil.getInteger(dic
				.getCustomField2()) : 0);
		applyMaterialList.add(applyMaterial);
		ApplyMaterialLocalServiceUtil
				.updateApplyMaterial(applyMaterial);
	}
		}

	}
	System.out.println(11111);
%>

<liferay-ui:upload-progress id="<%=uploadProgressId%>"
	message="uploading" />
<portlet:renderURL var="viewURL" />
<c:set var="namespace" value="<%=renderResponse.getNamespace()%>"></c:set>
<portlet:resourceURL var="fileUpLoadURL" id="fileUpLoad"/>
<portlet:resourceURL var="fileDeleteURL" id="fileDelete" />

<portlet:actionURL var="fileSaveURL" name="saveApplyMaterials">
	<portlet:param name="redirectURL" value="${editPermitURL}" />
</portlet:actionURL>

<portlet:actionURL var="submitAllURL" name="submitAll">
	<portlet:param name="redirect" value="${viewURL}" />
</portlet:actionURL>

<portlet:actionURL var="upLoadTestURL" name="upLoadResponse">
</portlet:actionURL>


<form id="fm" action="${fileSaveURL}" enctype="multipart/form-data"
	method="post">
	<aui:input type="hidden" name="permitId" value="<%=permitId%>"></aui:input>
	<aui:input name="type" type="hidden" value="<%=type%>" />
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
		<c:forEach items="<%=applyMaterialList%>" var="material"
			varStatus="status">
			<tr style="text-align: center" class="fileTr">
				<td style="text-align: center" class="fileNo">${material.xh}</td>
				<td>${material.clmc}</td>
				<td style="text-align: center">
					<div id="fileDiv${status.index+1}">
						<!-- todo
				此处可以根据状态来隐藏删除按钮的显示，提交后删除按钮不再显示
				 -->
						<c:if test="${not empty material.fileEntryIds}">
							<c:forEach items="${fn:split(material.fileEntryIds,',')}"
								var="fileEntryId" varStatus="statusSub">
								<div name="file${status.index+1}">
									<a class="fileName" href="javascript:void(0);">
										${material.clmc}-${statusSub.index+1}.${fn:split(fileEntryId,'|')[1]}</a>
									&nbsp;&nbsp;&nbsp; <a href='javascript:void(0)'
										;  onclick="${renderResponse.namespace}fileDelete(this,${fn:split(fileEntryId,'|')[0]},${material.materialId})">删除</a>
								</div>
							</c:forEach>
						</c:if>
					</div>
				</td>
				<td style="text-align: center">
				<input type="button" value="上传"
					onclick="document.getElementById('fileInput${status.index+1}').click();">
					<input id="fileInput${status.index+1}"
					name="${namespace}fileInput${status.index+1}" type="file" accept="application/pdf,image/jpeg"
					 style="display:none; width: 150px;" onchange="ajaxFileUpload(${status.index+1},${material.materialId},'<%=portletDisplay.getId() %>');"></input>

				</td>
			</tr>
		</c:forEach>

	</table>

	<div style="text-align: center">
		<c:if test="${permit.status!=2 }">
			<aui:button value="保存" onclick="saveMaterials()"
				cssClass="btn btn-primary" />
		</c:if>
		<c:if test="${permit.status==2 }">
			<aui:button value="保存" onclick="submitAll()"
				cssClass="btn btn-primary" />
		</c:if>

		<c:if test="<%=canTj%>">
			<aui:button value="上报" onclick="submitAll()"
				cssClass="btn btn-primary" />
		</c:if>

		<%
			String randomId = StringPool.BLANK;
				randomId = StringUtil.randomId();
				String strBackUrl = "http://" + request.getServerName() //服务器地址  
				        + ":"   
				        + request.getServerPort() ;          //端口号  
				String[] assetTypes = new String[1];
				    	assetTypes[0]="com.justonetech.cp.permit.model.Permit";
			    	OrderByComparator orderByComparator=null;
				    	List<WorkflowTask> results1=null;
				    	User me=PortalUtil.getUser(request);
				    	if(null!=me){
				    		try {
				    			//遍历工作流任务
				    		results1= WorkflowTaskManagerUtil.search(me.getCompanyId(), me.getUserId(), null, assetTypes, null, null, -1, -1, orderByComparator);
				} catch (WorkflowException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				    	long workflowTaskId=0L;
				    	long people=0L;
				    	String url="";
				    	List<String> transitionNames = null;//遍历工作流任务
				    	String token="";//授权随机代码
				    	if(Validator.isNotNull(permit)){
				    		 project=ProjectLocalServiceUtil.getProject(permit.getBjbh());
				    		if(project.getLxjb().equals("区县级机关或区县级单位")){
				    			type="quxian";
				    				}else{
				    			type="shishu";
				    				}
				    		if(permit.getStatus()==4||(permit.getStatus()==17&&type.equals("shishu"))){
				    		if(results1.size()>0){
				    		//工作流任务
				    	for(WorkflowTask task:results1){
				    		if(null!=task){
				    			if(KaleoTaskInstanceTokenLocalServiceUtil.getKaleoTaskInstanceToken(task.getWorkflowTaskId()).getClassPK()==permit.getPermitId()){
				    				workflowTaskId=task.getWorkflowTaskId();
							people=task.getAssigneeUserId();
					}
				    		}
				    	}
				    		}
				    		token=com.liferay.portal.security.auth.AuthTokenUtil.getToken(request);
				        if(workflowTaskId==0){
				        	transitionNames=new ArrayList<String>();
				        }else{
				    	transitionNames=WorkflowTaskManagerUtil.getNextTransitionNames(me.getCompanyId(), me.getUserId(), workflowTaskId);
				    	}
				    			for(int i=transitionNames.size()-1;i>=0;i--){
				    				String transitionName=transitionNames.get(i);
					String message = "proceed";
					if (Validator.isNotNull(transitionName)) {
						message = HtmlUtil.escape(transitionName);
					}
				url=strBackUrl+"/group/control_panel/manage/-/my_workflow_tasks/view/"+workflowTaskId+"?p_auth="+token+"&p_p_lifecycle=1&doAsGroupId="+PortalUtil.getUser(request).getGroupId()+"&refererPlid=25177&controlPanelCategory=my&_153_cmd=save&_153_assigneeUserId="+people+"&_153_redirect="+strBackUrl+themeDisplay.getURLCurrent()+"&_153_struts_action=/my_workflow_tasks/edit_workflow_task&_153_transitionName="+message;
		%>
		<div class="hide" id="<%=randomId%>updateComments">
			<aui:input cols="55" name="_153_comment" id="_153_comment"
				label="审核意见" useNamespace="false" rows="10" type="textarea" />
		</div>
		<liferay-ui:icon
			cssClass='<%="workflow-task-" + randomId + " task-change-status-link"%>'
			id='<%=randomId + HtmlUtil.escapeAttribute(transitionName) + "taskChangeStatusLink"%>'
			image="sb" message="<%=message%>" method="get" url="<%=url%>" />
		<aui:script use="liferay-workflow-tasks">
var onTaskClickFn = A.rbind('onTaskClick', Liferay.WorkflowTasks,'<%= randomId %>');
Liferay.delegateClick('<portlet:namespace /><%= randomId + HtmlUtil.escapeJS(transitionName) %>taskChangeStatusLink', onTaskClickFn);
</aui:script>
	


		
<%
			}
				    	}
				    	}
				    	}
		%>
	</div>


</form>

<script>
function ajaxFileUpload(divNo,materialId,portletId) {
	var file=getFile("fileInput"+divNo);
	var fileExtension=fileValidator("fileInput"+divNo);
	var no = findFileNo(divNo);
	if(fileExtension){
    $.ajaxFileUpload
    (
        {
            url: '${fileUpLoadURL}', //用于文件上传的服务器端请求地址
            secureuri: false, //是否需要安全协议，一般设置为false
            fileElementId: 'fileInput'+divNo, //文件上传域的ID
            data:{${namespace}materialId:materialId,${namespace}divNo:divNo,${namespace}portletId:portletId,${namespace}no:no,${namespace}fileExtension:fileExtension}, 
            dataType: 'string', //返回值类型 一般设置为json 
            success: function (data)  //服务器成功响应处理函数
            {
            	var dataArray=data.replace("</pre>","").replace(/<pre.*>/,"");
            	var fileId=dataArray.split('|')[0];var materialName=dataArray.split('|')[1];
            	 var ele = "<div name='file"+divNo+"'><a class='fileName' href='javascript:void(0);'>"
				+ materialName+"-"+no+"."+fileExtension
				+ "</a> &nbsp;&nbsp;&nbsp;<a href='javascript:void(0)';  onclick='${renderResponse.namespace}fileDelete(this,"
				+ fileId + ","+materialId+")'>删除</a></div>"; 
            	 $("#fileDiv" + divNo).append(ele);
					domSort(divNo); 
            },
            error: function (data, status, e)//服务器响应失败处理函数
            {
                alert(e);
            }
        }
    )
	}
    return false;
}

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
		//判断使用浏览器
		var browserCfg = {}; 
		var ua = window.navigator.userAgent;
		if (ua.indexOf("MSIE")>=1){ browserCfg.ie = true; }
		var obj_file = document.getElementById(inputFileId); 
		if(obj_file.value==""){ alert("请先选择上传文件"); return; } 
		var fileSize;
		var fileName;
		var fileExtension;
		if(browserCfg.ie){
			var fileobject = new ActiveXObject ("Scripting.FileSystemObject");//获取上传文件的对象
			var file = fileobject.GetFile (obj_file.value);
			fileSize=Math.ceil(file.size/(1024*1024));
			fileName=file.name;
		}else{
			var fileInput = $("#"+inputFileId)[0];
			fileName=fileInput.files[0].name;
			fileSize=Math.ceil(fileInput.files[0].size / (1024*1024)) ;
		}
		if(fileName){
			var fileExtension=fileName.split('.').pop().toUpperCase();
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
	     return fileExtension.toLowerCase();
	 }
	
	function getFile(inputFileId){
		//判断使用浏览器
		var browserCfg = {}; 
		var ua = window.navigator.userAgent;
		if (ua.indexOf("MSIE")>=1){ browserCfg.ie = true; }
		var obj_file = document.getElementById(inputFileId); 
		var file;
		if(browserCfg.ie){
			var fileobject = new ActiveXObject ("Scripting.FileSystemObject");//获取上传文件的对象
			file = fileobject.GetFile (obj_file.value);
		}else{
			var fileInput = $("#"+inputFileId)[0];
			file=fileInput.files[0];
		}
		return file;
	}

	
	function <portlet:namespace/>clearValue(btn){
		var input=$(btn);
		input.replaceWith(input.val('').clone(true));
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
		//如果是ie8浏览器，添加indexof方法
		if (!Array.prototype.indexOf)
		{
		  Array.prototype.indexOf = function(elt /*, from*/)
		  {
		    var len = this.length >>> 0;

		    var from = Number(arguments[1]) || 0;
		    from = (from < 0)
		         ? Math.ceil(from)
		         : Math.floor(from);
		    if (from < 0)
		      from += len;
		    for (; from < len; from++)
		    {
		      if (from in this &&
		          this[from] === elt)
		        return from;
		    }
		    return -1;
		  };
		}
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

