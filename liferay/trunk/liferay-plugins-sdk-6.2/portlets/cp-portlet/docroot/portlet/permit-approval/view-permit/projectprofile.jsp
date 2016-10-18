<%@page import="com.justonetech.sys.model.Dictionary"%>
<%@page import="com.justonetech.sys.service.DictionaryLocalServiceUtil"%>
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
	long permitId = ParamUtil.getLong(request, "permitId");
	Permit permit = PermitLocalServiceUtil.getPermit(permitId);
	ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
	String xmlx =  DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx()).getName();
	String jsddssqx = projectProfile.getJsddssqx() == 0 ? null : DictionaryLocalServiceUtil.getDictionary(
			projectProfile.getJsddssqx()).getName();
	Dictionary jsgclb = DictionaryLocalServiceUtil.findByCode("jsgclb");
	List<Dictionary> jsgclbs = jsgclb != null ? DictionaryLocalServiceUtil.findByParentId(
			jsgclb.getDictionaryId(), -1, -1) : null;
	request.setAttribute("permit", permit);
	request.setAttribute("projectProfile", projectProfile);
	request.setAttribute("jsddssqx", jsddssqx);
	request.setAttribute("jsgclbs", jsgclbs);
	request.setAttribute("xmlx", xmlx);
%>
<table class="table table-bordered">
	<tr class="body">
		<td class="title">项目类型<input name="xmlx" id="xmlx" type="hidden" value="${xmlx}"/></td>
		<td class="content"><%=DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx()).getName()%></td>
		<td class="title">立项级别</td>
		<td class="content">${projectProfile.lxjb}</td>
	</tr>
	<tr class="body">
		<td class="title">项目性质</td>
		<td class="content"><%=DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmxz()).getName()%></td>
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
		<td class="content" colspan="3">${jsddssqx}</td>
	</tr>
	<tr class="body">
		<td class="title">建设工程类别</td>
		<td class="content" colspan="3"><c:forEach items="${jsgclbs}"
				var="jsgclb" varStatus="sortNo">
				<aui:input name="jsgclb" type="checkbox" id="jsgclb${sortNo.index}"
					value="${jsgclb.dictionaryId}"
					checked="${fn:contains(projectProfile.jsgclb,jsgclb.dictionaryId)}"
					label="${jsgclb.name}" inlineField="true" onClick="return false" />
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
		<td class="text-right">公里数</td>
		<td class="bg-white">${projectProfile.gls}</td>
		<td class="text-right">建筑面积(㎡)</td>
		<td class="bg-white">${projectProfile.jzmj}</td>
	</tr>
	<tr class="body">
		<td class="text-right">桥梁数量</td>
		<td class="bg-white">${projectProfile.qlsl}</td>
		<td class="text-right">桥梁跨度</td>
		<td class="bg-white">${projectProfile.qlkd}</td>
	</tr>
	<tr class="body">
		<td class="text-right">轨交数量</td>
		<td class="bg-white">${projectProfile.guijiaosl}</td>
		<td class="text-right">隧道数量</td>
		<td class="bg-white">${projectProfile.sdsl}</td>
	</tr>
	<tr class="body">
		<td class="text-right">高架数量</td>
		<td class="bg-white" colspan="3">${projectProfile.gaojiasl}</td>
	</tr>
	<tr class="body">
		<td class="title">工程内容</td>
		<td class="content" colspan="3">${projectProfile.gcnr}</td>
	</tr>
	<tr class="body">
		<td class="title">国有资金比重%</td>
		<td class="content" colspan="3">${projectProfile.gyzjbz}</td>
	</tr>
<%-- 	<tr class="body">
		<td class="title">房屋建筑面积(㎡)</td>
		<td class="content" colspan="3">${projectProfile.fwjzmj}</td>
	</tr> --%>
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
		<%-- <td class="title">用地批文名称及文号</td>
		<td class="content" colspan="3">${projectProfile.jsydpzwjhfdccqzbh}</td> --%>
	</tr>
	<tr class="body">
		<td class="title">建设工程规划许可证编号</td>
		<td class="content" colspan="3">${projectProfile.jsgcghxkzbh}</td>
	</tr>
	<tr class="body">
		<td class="title">现场开工情况</td>
		<td class="content" colspan="3"><%=DictionaryLocalServiceUtil.getDictionary(Long.valueOf(projectProfile.getXckgqk())).getName()%></td>
	</tr>
	<tr class="body">
		<td class="title">计划开工</td>
		<td class="content"><fmt:formatDate value="${projectProfile.jhkg}"
				pattern="yyyy-MM-dd" /></td>
		<td class="title">计划竣工</td>
		<td class="content"><fmt:formatDate value="${projectProfile.jhjg}"
				pattern="yyyy-MM-dd" /></td>
	</tr>
	<tbody style="display: none" id="hd">
		<tr class="body">
			<td class="text-center" colspan="4">主要设计单位</td>
		</tr>
		<tr class="body">
			<td class="text-right">主要设计单位</td>
			<td class="bg-white" colspan="3">${projectProfile.zysjdw}</td>
		</tr>
		<tr class="body">
			<td class="text-right">招标方式</td>
			<td class="bg-white">${projectProfile.sj_zbfs}</td>
			<td class="text-right">中标价</td>
			<td class="bg-white">${projectProfile.sj_zbj}</td>
		</tr>
		<tr class="body">
			<td class="text-right">资质等级</td>
			<td class="bg-white">${projectProfile.sj_zzdj}</td>
			<td class="text-right">资质等级证书编号</td>
			<td class="bg-white">${projectProfile.sj_zzdjzsbh}</td>
		</tr>
		<tr class="body">
			<td class="text-right">项目负责人</td>
			<td class="bg-white">${projectProfile.sj_xmfzr}</td>
			<td class="text-right">项目负责人证书编号</td>
			<td class="bg-white">${projectProfile.sj_xmfzrzsbh}</td>
		</tr>
		<tr class="body">
			<td class="text-center" colspan="4">主要监理单位</td>
		</tr>
		<tr class="body">
			<td class="text-right">主要监理单位</td>
			<td class="bg-white" colspan="3">${projectProfile.zyjldw}</td>
		</tr>
		<tr class="body">
			<td class="text-right">招标方式</td>
			<td class="bg-white">${projectProfile.jl_zbfs}</td>
			<td class="text-right">中标价</td>
			<td class="bg-white">${projectProfile.jl_zbj}</td>
		</tr>
		<tr class="body">
			<td class="text-right">资质等级</td>
			<td class="bg-white">${projectProfile.jl_zzdj}</td>
			<td class="text-right">资质等级证书编号</td>
			<td class="bg-white">${projectProfile.jl_zzdjzsbh }</td>
		</tr>
		<tr class="body">
			<td class="text-right">总监</td>
			<td class="bg-white">${projectProfile.jl_zj}</td>
			<td class="text-right">总监证书编号</td>
			<td class="bg-white">${projectProfile.jl_zjzsbh}</td>
		</tr>
		<tr class="body">
			<td class="text-center" colspan="4">主要施工单位</td>
		</tr>
		<tr class="body">
			<td class="text-right">主要施工单位</td>
			<td class="bg-white" colspan="3">${projectProfile.zysgdw}</td>
		</tr>
		<tr class="body">
			<td class="text-right">招标方式</td>
			<td class="bg-white">${projectProfile.sg_zbfs}</td>
			<td class="text-right">中标价</td>
			<td class="bg-white">${projectProfile.sg_zbj}</td>
		</tr>
		<tr class="body">
			<td class="text-right">资质等级</td>
			<td class="bg-white">${projectProfile.sg_zzdj }</td>
			<td class="text-right">资质等级证书编号</td>
			<td class="bg-white">${projectProfile.sg_zzdjzsbh}</td>
		</tr>
		<tr class="body">
			<td class="text-right">项目经理</td>
			<td class="bg-white">${projectProfile.sg_xmjl }</td>
			<td class="text-right">项目经理证书编号</td>
			<td class="bg-white">${projectProfile.sg_xmjlzsbh }</td>
		</tr>
		<tr class="body">
			<td class="text-center" colspan="4">建设依据</td>
		</tr>
		<tr class="body">
			<td class="text-right">工可批准或核准机关和文号</td>
			<td class="bg-white" colspan="3">${projectProfile.gkpzhhzjghwh }</td>
		</tr>
		<tr class="body">
			<td class="text-right">批复或核准日期</td>
			<td class="bg-white" colspan="3"><fmt:formatDate value="${projectProfile.pfhhzrq}"
				pattern="yyyy-MM-dd" /></td>
		</tr>
		<tr class="body">
			<td class="text-right">初步设计批准机关和文号</td>
			<td class="bg-white" colspan="3">${projectProfile.cbsjpzjghwh}</td>
		</tr>
		<tr class="body">
			<td class="text-right">批复日期</td>
			<td class="bg-white"><fmt:formatDate value="${projectProfile.pfrq}"
				pattern="yyyy-MM-dd" /></td>
			<td class="text-right">批复工期(天)</td>
			<td class="bg-white">${projectProfile.pfgq}</td>
		</tr>
		<tr class="body">
			<td class="text-right">主体工程施工图审批批准机关和文号</td>
			<td class="bg-white" colspan="3">${projectProfile.pzjghwh}</td>
		</tr>
		<tr class="body">
			<td class="text-right">投资来源</td>
			<td class="bg-white" colspan="3">${projectProfile.tzly}</td>
		</tr>
		<tr class="body">
			<td class="text-right">建设资金计划落实情况 </td>
			<td class="bg-white" colspan="3">${projectProfile.jszjjhlsqk}</td>
		</tr>
		<tr class="body">
			<td class="text-right">动、拆迁完成情况 </td>
			<td class="bg-white" colspan="3">${projectProfile.dcqwcqk}</td>
		</tr>
		<tr class="body">
			<td class="text-right">施工准备情况 </td>
			<td class="bg-white" colspan="3">${projectProfile.sgzbqk}</td>
		</tr>
		<tr class="body">
			<td class="text-right">使用土地等相关文件 </td>
			<td class="bg-white" colspan="3">${projectProfile.sytdxgwj}</td>
		</tr>
		<tr class="body">
			<td class="text-right">工程质量（施工安全）监督登记情况 </td>
			<td class="bg-white" colspan="3">${projectProfile.gczljddjqk}</td>
		</tr>
		<tr class="body">
			<td class="text-right">项目单位</td>
			<td class="bg-white" colspan="3">${projectProfile.xmdw}</td>
		</tr>
		<tr class="body">
			<td class="text-right">项目单位负责人</td>
			<td class="bg-white">${projectProfile.xmfzr}</td>
			<td class="text-right">项目负责人联系电话</td>
			<td class="bg-white">${projectProfile.xmfzrlxdh}</td>
		</tr>
		</tbody>
	<tr class="body">
		<td class="title">备注</td>
		<td class="content" colspan="3">${projectProfile.sgxkzsbz}</td>
	</tr>
	<tr class="body">
		<td colspan="4" style="background-color: white" class="sfzftzl"><aui:input name="是否政府投资类"
				type="checkbox" checked="${projectProfile.sfzftzl?true:false}"
				onClick="return false" />
		</td>
	</tr>
	<c:choose>
			<c:when test="${projectProfile.sfzftzl }">
				<tr class="body" id="yzzpl">
			</c:when>
			<c:otherwise>
				<tr class="body" id="yzzpl" style="display: none">
			</c:otherwise>
		</c:choose>
		<td colspan="4">
			<table style="width: 99%;">
				<tr class="body">
					<td class="text-right" rowspan="4">预制装配率</td>
					<td class="bg-white" colspan="2">单跨跨径100米以下桥梁工程承台顶面以上构件</td>
					<td class="bg-white"><aui:row>${projectProfile.yzzpl1}%</aui:row></td>
				</tr>
				<tr class="body">
					<td class="bg-white" colspan="2">隧道工程盾构段</td>
					<td class="bg-white"><aui:row>${projectProfile.yzzpl2}%</aui:row></td>
				</tr>
				<tr class="body">
					<td class="bg-white" colspan="2">轨道交通工程地下过街通道</td>
					<td class="bg-white"><aui:row>${projectProfile.yzzpl3}%</aui:row></td>
				</tr>
				<tr class="body">
					<td class="bg-white" colspan="2">水运工程（港口）桩顶面以上构件</td>
					<td class="bg-white"><aui:row>${projectProfile.yzzpl4}%</aui:row></td>
				</tr>
			</table>
		</td>
		</tr>
		<tr class="body">
			<td  class="bg-white" colspan="4">注:信息保存后，请进入参见单位和项目负责人信息页面，填写参建单位和项目负责人信息</td>
		</tr>
</table>
<script>
$(document).ready(function(){
	var xmlx = $("#xmlx").val();
	if(xmlx=="航道"){
		document.getElementById("hd").style.display = "";
	} 
})
</script>