<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<style type="text/css">
tr {
	text-align: center;
}

tr.head  td {
	background-color: #63B8FF;
	text-align: center;
	font-size: 16px;
	color: white;
	font-family: "宋体";
	font-weight: bold;
}

tr.body td.title {
	width: 20%;
}

tr.body td.content {
	width: 30%;
	text-align: left;
}
</style>
<%
	String bjbh = ParamUtil.getString(request, "bjbh");
	Long permitId = ParamUtil.getLong(request, "permitId");
	ProjectProfile projectProfile = null;
	Project project = null;
	if (permitId != 0) {
		projectProfile = ProjectProfileLocalServiceUtil
				.getProjectProfile(permitId);
		request.setAttribute("projectProfile", projectProfile);
	} else {
		if (Validator.isNotNull(bjbh)) {
			project = ProjectLocalServiceUtil.getProject(bjbh);
			request.setAttribute("project", project);
		}
	}
%>
<portlet:renderURL var="viewURL" />
<portlet:actionURL var="saveProjectProfileURL" name="saveProjectProfile">
	<portlet:param name="redirect" value="${viewURL }" />
</portlet:actionURL>
<aui:model-context bean="${projectProfile}"
	model="<%=ProjectProfile.class%>" />
<aui:form action="${saveProjectProfileURL}">
	<aui:input name="permitId" type="hidden" value="<%=permitId%>" />
	<aui:input name="bjbh" type="hidden" value="<%=bjbh%>" />
	<aui:input name="bdh" type="hidden" value="${bdh }" />
	<aui:input name="sqbz" type="hidden" value="2" />
	<table border="1" width="100%">
		<tr class="body">
			<td class="title">建设单位名称</td>
			<td class="content" colspan="3"><aui:input name="jsdwmc"
					label="" type="text" style="width:50%" value="${project.jsdw}"
					readonly="true">
				</aui:input></td>
		</tr>
		<tr class="body">
			<td class="title">建设单位性质</td>
			<td class="content" colspan="3"><aui:input name="jsdwxz"
					label="" type="text" style="width:50%" value="${project.jsdwxz}"
					readonly="true">
				</aui:input></td>
		</tr>
		<tr class="body">
			<td class="title">建设单位地址</td>
			<td class="content" colspan="3"><aui:input name="jsdwdz"
					label="" type="text" style="width:50%" value="${project.jsdwdz}"
					readonly="true">
				</aui:input></td>
		</tr>
		<tr class="body">
			<td class="title">工程名称</td>
			<td class="content" colspan="3"><aui:input name="gcmc" label=""
					type="text" style="width:60%" value="${project.xmmc}">
				</aui:input>(本次申请施工许可名称)</td>
		</tr>
		<tr class="body">
			<td class="title">建设地点</td>
			<td class="content" colspan="3"><aui:input name="jsdd" label=""
					type="text" style="width:50%" value="${project.jsdd}">
				</aui:input>(请按建设工程规划许可证填写本次申请施工许可的建设地点)</td>
		</tr>
		<tr class="body">
			<td class="title">建设工程规模</td>
			<td class="content" colspan="3"><aui:input name="jsgcgm"
					label="" type="text" style="width:50%" value="${project.jsgm}">
				</aui:input></td>
		</tr>
		<tr class="body">
			<td class="title">房屋建筑面积(㎡)</td>
			<td class="content" colspan="3"><aui:input name="fwjzmj"
					label="" type="text" style="width:18.7%" value="">
				</aui:input></td>
		</tr>
		<tr class="body">
			<td class="title">合同价格(万元)</td>
			<td class="content"><aui:input name="htjg" label="" type="text"
					style="width:50%" value="${contract.ztz}">
				</aui:input></td>
			<td class="title">合同工期(日历天)</td>
			<td class="content"><aui:input name="htgq" label="" type="text"
					style="width:50%" value="">
				</aui:input></td>
		</tr>
		<tr class="body">
			<td class="title">法定代表人</td>
			<td class="content"><aui:input name="fddbr" label="" type="text"
					style="width:50%" value="${project.jsdwfr }" readonly="true">
				</aui:input></td>
			<td class="title">建设单位联系电话</td>
			<td class="content"><aui:input name="jsdwlxdh" label=""
					type="text" style="width:50%" value="${project.jsdwdh}">
				</aui:input></td>
		</tr>
		<tr class="body">
			<td class="title">建设单位联系人</td>
			<td class="content"><aui:input name="jsdwlxr" label=""
					type="text" style="width:50%" value="${project.jsdwlxr}">
				</aui:input></td>
			<td class="title">联系人手机号</td>
			<td class="content"><aui:row>
					<aui:input name="jsdwsjh" label="" inlineField="true" type="text"
						style="width:93%" value="">
					</aui:input>
					<aui:button name="button" value="验证手机"></aui:button>
				</aui:row></td>
		</tr>
		<tr class="body">
			<td class="title">建设用地批准文件或房地产产权证编号</td>
			<td class="content" colspan="3"><aui:input
					name="jsydpzwjhfdccqzbh" label="" type="text" style="width:50%"
					value="">
				</aui:input></td>
		</tr>
		<tr class="body">
			<td class="title">建设工程规划许可证编号</td>
			<td class="content" colspan="3"><aui:input name="jsgcghxkzbh"
					label="" type="text" style="width:50%" value="">
				</aui:input></td>
		</tr>
		<tr class="body">
			<td class="title">现场开工情况</td>
			<td class="content" colspan="3"><aui:select name="xckgqk"
					label="" style="width:20%">
					<aui:option value=""></aui:option>
					<aui:option value="0" selected="${projectProfile.xckgqk eq 0}">未开工</aui:option>
					<aui:option value="1" selected="${projectProfile.xckgqk eq 1}">已开工</aui:option>
				</aui:select></td>
		</tr>
		<tr class="body">
			<td class="title" colspan="4">注:信息保存后，请进入参见单位和项目负责人信息页面，填写参建单位和项目负责人信息</td>
		</tr>
		<tr class="body">
			<td class="title" colspan="4"><aui:button type="submit" /> <aui:button
					value="返回" href="${viewURL}" /></td>
		</tr>
	</table>

</aui:form>
