<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/common/init.jsp"%>
<script type="text/javascript">
	document.write("<script src='${staticServerURL}/jquery/jquery-1.12.4.min.js'>" + "<"+"/script>"+"系统处理中，请稍候！");
</script>
<script>
	$(function() {
		setTimeout("skip()", 1000);
	});
	function skip(){
		window.location.href = "/group/zhxx/-";
	}
</script>