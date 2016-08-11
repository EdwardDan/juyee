<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>

<portlet:actionURL var="uploadURL" name="testFile">
</portlet:actionURL>
 
<div id="message" title="上传文件">
	   
	<form id="upload" action="${uploadURL}" method="post"
		enctype="multipart/form-data">
		<input class="lfr-input-text" name='<portlet:namespace/>photo' type="file"  multiple/> <br />  
		  <input type="submit" value="提交"/>
	</form>
	   
</div>


<portlet:resourceURL var="download"/>
<br/>
图片：<img src="<%=request.getContextPath()%>/icons/icon.png" alt="下载" />
<br/>
<input type="button" value="下载" onclick="download();">
<br/>
<aui:a href="/documents/20201/0/11+-+%E5%89%AF%E6%9C%AC.txt/5cf4de78-1d26-49b7-9502-a79327f57c02">下载</aui:a>
<script type="text/javascript">
function download(){
 window.location = '${download}';
}
</script>


