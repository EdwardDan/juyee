<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<style type="text/css">
tr.body td.title {
	width: 20%;
	text-align: right;
}

tr.body td.content {
	width: 30%;
	background-color: white;
	text-align: left;
}
</style>
<%
	long completeId = ParamUtil.getLong(request, "completeId");
	Complete complete = CompleteLocalServiceUtil.getComplete(completeId);
	CompleteProjectProfile projectProfile = CompleteProjectProfileLocalServiceUtil.getCompleteProjectProfile(completeId);
	
	Dictionary jsgclb = DictionaryLocalServiceUtil.findByCode("jsgclb");
	List<Dictionary> jsgclbs = jsgclb != null ? DictionaryLocalServiceUtil.findByParentId(
			jsgclb.getDictionaryId(), -1, -1) : null;
	request.setAttribute("complete", complete);
	request.setAttribute("projectProfile", projectProfile);
	request.setAttribute("jsgclbs", jsgclbs);
%>
<table class="table table-bordered">
	<tr class="body">
		<td class="title">工程名称</td>
		<td class="content" colspan="3">${projectProfile.gcmc}</td>
	</tr>
	<tr class="body">
		<td class="title">建设单位名称</td>
		<td class="content" colspan="3">${projectProfile.jsdwmc}</td>
	</tr>
	<tr class="body">
		<td class="title">建设单位地址</td>
		<td class="content" colspan="3">${projectProfile.jsdwdz}</td>
	</tr>
	<tr class="body">
		<td class="title">建设地点</td>
		<td class="content">${projectProfile.jsdd}</td>
		<td class="title">所在区县</td>
		<td class="content">${projectProfile.szqx}</td>
	</tr>
	<tr class="body">
		<td class="title">法定代表人</td>
		<td class="content" colspan="3">${projectProfile.fddbr}</td>
	</tr>
	<tr class="body">
		<td class="title">联系人</td>
		<td class="content">${projectProfile.lxr}</td>
		<td class="title">联系电话</td>
		<td class="content">${projectProfile.lxdh}</td>
	</tr>
	<tr class="body">
		<td class="title">备注</td>
		<td class="content" colspan="3">${projectProfile.bz}</td>
	</tr>
</table>
