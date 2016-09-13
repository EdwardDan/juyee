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
	System.out.println("======================"+completeId);
	Complete complete = CompleteLocalServiceUtil.getComplete(completeId);
	CompleteProjectProfile completeProjectProfile = CompleteProjectProfileLocalServiceUtil.getCompleteProjectProfile(completeId);
	
	Dictionary jsgclb = DictionaryLocalServiceUtil.findByCode("jsgclb");
	List<Dictionary> jsgclbs = jsgclb != null ? DictionaryLocalServiceUtil.findByParentId(
			jsgclb.getDictionaryId(), -1, -1) : null;
	request.setAttribute("complete", complete);
	request.setAttribute("completeProjectProfile", completeProjectProfile);
	request.setAttribute("jsgclbs", jsgclbs);
%>
<table class="table table-bordered" width="100%">
		<tr class="body">
			<td class="text-right">项目类型</td>
			<td class="bg-white"><%=DictionaryLocalServiceUtil.getDictionary(completeProjectProfile.getXmlx()).getName()%></td>
			<td class="text-right">建设工程属性</td>
			<td class="bg-white"><%=DictionaryLocalServiceUtil.getDictionary(completeProjectProfile.getJsgcsx()).getName()%></td>
		</tr>
		<tr class="body">
			<td class="text-right">工程名称</td>
			<td class="bg-white" colspan="3">${completeProjectProfile.gcmc}</td>
		</tr>
		<tr class="body">
			<td class="text-right">建设单位名称</td>
			<td class="bg-white" colspan="3">${completeProjectProfile.jsdwmc}</td>
		</tr>
		<tr class="body">
			<td class="text-right">建设单位地址</td>
			<td class="bg-white" colspan="3">${completeProjectProfile.jsdwdz}</td>
		</tr>
		<tr>
			<td class="text-right">建设地点</td>
			<td class="bg-white">${completeProjectProfile.jsdd}</td>
			<td class="text-right">所在区县</td>
			<td class="bg-white">${completeProjectProfile.szqx}</td>
		</tr>
		<tr class="body">
			<td class="text-right">法定代表人</td>
			<td class="bg-white" colspan="3">${completeProjectProfile.fddbr}</td>
		</tr>
		<tr class="body">
			<td class="text-right">联系人</td>
			<td class="bg-white">${completeProjectProfile.lxr}</td>

			<td class="text-right">联系电话</td>
			<td class="bg-white">${completeProjectProfile.lxdh}</td>
		</tr>
		<tr class="body">
			<td class="text-right">备注</td>
			<td class="bg-white" colspan="3">${completeProjectProfile.bz}</td>
		</tr>
	</table>
