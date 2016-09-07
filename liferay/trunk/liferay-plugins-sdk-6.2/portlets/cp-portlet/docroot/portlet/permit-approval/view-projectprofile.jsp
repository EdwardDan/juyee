<%@page import="com.justonetech.sys.model.Dictionary"%>
<%@page import="com.justonetech.sys.service.DictionaryLocalServiceUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
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
	long permitId = ParamUtil.getLong(request, "permitId");
	Permit permit = PermitLocalServiceUtil.getPermit(permitId);
	ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
	Dictionary areaName = DictionaryLocalServiceUtil.findByCode("areaName");
	Dictionary constructionType = DictionaryLocalServiceUtil.findByCode("constructionType");
	Dictionary constructionProperty = DictionaryLocalServiceUtil.findByCode("constructionProperty");
	List<Dictionary> areaNames = areaName != null ? DictionaryLocalServiceUtil.findByParentId(
			areaName.getDictionaryId(), -1, -1) : null;
	List<Dictionary> constructionTypes = constructionType != null ? DictionaryLocalServiceUtil.findByParentId(
			constructionType.getDictionaryId(), -1, -1) : null;
	List<Dictionary> constructionProperties = constructionProperty != null ? DictionaryLocalServiceUtil
			.findByParentId(constructionProperty.getDictionaryId(), -1, -1) : null;
	request.setAttribute("permit", permit);
	request.setAttribute("projectProfile", projectProfile);
	request.setAttribute("areaNames", areaNames);
	request.setAttribute("constructionTypes", constructionTypes);
	request.setAttribute("constructionProperties", constructionProperties);
%>
<fieldset style="">
	<legend align="center">申请信息</legend>
	<table border="1" width="100%">
		<tr class="body">
			<td class="title">项目类型</td>
			<td class="content"><%=DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx()).getName()%></td>
			<td class="title">立项级别</td>
			<td class="content">${projectProfile.lxjb}</td>
		</tr>
		<tr class="body">
			<td class="title">项目性质</td>
			<td class="content">${projectProfile.xmxz}</td>
			<td class="title">所属区县</td>
			<td class="content">${projectProfile.ssqx}</td>
		</tr>
		<tr class="body">
			<td class="title">业务编号</td>
			<td class="content" colspan="3">${permit.ywbh}</td>
		</tr>
		<tr class="body">
			<td class="title">建设单位名称</td>
			<td class="content" colspan="3">${projectProfile.jsdwmc}</td>
		</tr>
		<tr class="body">
			<td class="title">建设单位性质</td>
			<td class="content" colspan="3">${projectProfile.jsdwxz}</td>
		</tr>
		<tr class="body">
			<td class="title">建设单位地址</td>
			<td class="content" colspan="3">${projectProfile.jsdwdz}</td>
		</tr>
		<tr class="body">
			<td class="title">工程名称</td>
			<td class="content" colspan="3">${projectProfile.gcmc}</td>
		</tr>
		<tr class="body">
			<td class="title">建设地点</td>
			<td class="content" colspan="3">${projectProfile.jsdd}</td>
		</tr>
		<tr class="body">
			<td class="title">建设地点所属区县</td>
			<td class="content" colspan="3"><%=DictionaryLocalServiceUtil.getDictionary(projectProfile.getJsddssqx()).getName()%></td>
		</tr>
		<tr class="body">
			<td class="title">建设工程类别</td>
			<td class="content" colspan="3"><c:forEach items="${constructionTypes}"
					var="constructionType" varStatus="sortNo">
					<aui:input name="jsgclb" type="checkbox" id="constructionType${sortNo.index}"
						value="${constructionType.dictionaryId}"
						checked="${fn:contains(projectProfile.jsgclb,constructionType.dictionaryId)}"
						label="${constructionType.name}" inlineField="true" readonly="true"/>
				</c:forEach></td>
		</tr>
		<tr class="body">
			<td class="title">建设工程属性</td>
			<td class="content" colspan="3"><%=DictionaryLocalServiceUtil.getDictionary(projectProfile.getJsgcsx()).getName()%></td>
		</tr>
		<tr class="body">
			<td class="title">建设工程规模</td>
			<td class="content" colspan="3">${projectProfile.jsgcgm}</td>
		</tr>
		<tr class="body">
			<td class="title">国有资金比重%</td>
			<td class="content" colspan="3">${projectProfile.gyzjbz}</td>
		</tr>
		<tr class="body">
			<td class="title">房屋建筑面积(㎡)</td>
			<td class="content" colspan="3">${projectProfile.fwjzmj}</td>
		</tr>
		<tr class="body">
			<td class="title">合同价格(万元)</td>
			<td class="content">${projectProfile.htjg}</td>
			<td class="title">合同工期(日历天)</td>
			<td class="content">${projectProfile.htgq}</td>
		</tr>
		<tr class="body">
			<td class="title">中标价格(万元)</td>
			<td class="content">${projectProfile.zbjg}</td>
			<td class="title">项目投资估算(万元)</td>
			<td class="content">${projectProfile.xmtzgs}</td>
		</tr>
		<tr class="body">
			<td class="title">法定代表人</td>
			<td class="content">${projectProfile.fddbr}</td>
			<td class="title">建设单位联系电话</td>
			<td class="content">${projectProfile.jsdwlxdh}</td>
		</tr>
		<tr class="body">
			<td class="title">建设单位联系人</td>
			<td class="content">${projectProfile.jsdwlxr}</td>
			<td class="title">联系人手机号</td>
			<td class="content">${projectProfile.jsdwsjh}</td>
		</tr>
		<tr class="body">
			<td class="title">建设用地批准文件或房地产产权证编号</td>
			<td class="content" colspan="3">${projectProfile.jsydpzwjhfdccqzbh}</td>
		</tr>
		<tr class="body">
			<td class="title">建设工程规划许可证编号</td>
			<td class="content" colspan="3">${projectProfile.jsgcghxkzbh}</td>
		</tr>
		<tr class="body">
			<td class="title">现场开工情况</td>
			<td class="content" colspan="3">${projectProfile.xckgqk}</td>
		</tr>
		<tr class="body">
			<td class="title">计划开工</td>
			<td class="content"><fmt:formatDate value="${project.jhkg}" pattern="yyyy-MM-dd"/></td>
			<td class="title">计划竣工</td>
			<td class="content"><fmt:formatDate value="${project.jhjg}" pattern="yyyy-MM-dd"/></td>
		</tr>
		<tr class="body">
			<td class="content" colspan="4"><aui:input name="是否政府投资类" type="checkbox" checked="${projectProfile.sfzftzl?true:false}" readonly="true"/></td>
		</tr>
	</table>
</fieldset>
