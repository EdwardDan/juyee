<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%
	String bjbh = ParamUtil.getString(request, "bjbh");
	//根据报建编号获取报建项目信息
	Project project = ProjectLocalServiceUtil.getProject(bjbh);
	request.setAttribute("project", project);
%>
<portlet:renderURL var="viewURL" />
<liferay-ui:header title="项目详情" backURL="${viewURL}" />
<table class="table table-bordered">
	<tr>
		<td style="width: 15%%;">报建日期</td>
		<td style="width: 35%;"><fmt:formatDate value="${project.bjrq}"
				pattern="yyyy-MM-dd" /></td>
		<td style="width: 15%;">报建编号</td>
		<td style="width: 35%;">${project.bjbh}</td>
	</tr>
	<tr>
		<td>网上申请编号</td>
		<td>${project.bj_webid}</td>
		<td>统一审批编码</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>所在区县</td>
		<td>${project.szqx}</td>
		<td>所在区域</td>
		<td>${project.szqy}</td>
	</tr>
	<tr>
		<td>建设工程名称</td>
		<td colspan="3">${project.xmmc}</td>
	</tr>
	<tr>
		<td>建设地点</td>
		<td colspan="3">${project.jsdd}</td>
	</tr>
	<tr>
		<td>建设单位</td>
		<td colspan="3">${project.jsdw}</td>
	</tr>
	<tr>
		<td>建设单位办公地址</td>
		<td>${project.jsdwdz}</td>
		<td>邮政编码</td>
		<td>${project.jsdwyb}</td>
	</tr>
	<tr>
		<td>机构代码</td>
		<td>${project.jsdwjgdm}</td>
		<td>工程账户号</td>
		<td>${project.gczh}</td>
	</tr>
	<tr>
		<td>建设单位法定代表人</td>
		<td>${project.jsdwfr}</td>
		<td>建设单位联系人</td>
		<td>${project.jsdwlxr}</td>
	</tr>
	<tr>
		<td>联系人手机</td>
		<td>${project.jsdwdh}</td>
		<td>建设单位注册资金（万元）</td>
		<td>${project.jsdwzczj}</td>
	</tr>
	<tr>
		<td>建设单位性质</td>
		<td>${project.jsdwxz}</td>
		<td>建设性质</td>
		<td>${project.jsxz}</td>
	</tr>
	<tr>
		<td>立项或批准文件名称</td>
		<td colspan="3">${project.lxwj}</td>
	</tr>
	<tr>
		<td>立项或批准文件文号</td>
		<td>${project.lxwh}</td>
		<td>立项文件项目代码</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>发文单位</td>
		<td>${project.pzjg}</td>
		<td>发文日期</td>
		<td>${project.pzrq}</td>
	</tr>
	<tr>
		<td>立项级别</td>
		<td>${project.lxjb}</td>
		<td>立项分类</td>
		<td>${project.lxfl}</td>
	</tr>
	<tr>
		<td>是否文物或优秀历史建筑</td>
		<td colspan="3"></td>
	</tr>
	<tr>
		<td>总投资</td>
		<td colspan="3">${project.ztz}万元，其中设备投资${project.sbtz}万元</td>
	</tr>
	<tr>
		<td>建设工程规模</td>
		<td colspan="3">${project.jsgm}</td>
	</tr>
	<tr>
		<td>项目资金来源构成</td>
		<td colspan="3">&nbsp;</td>
	</tr>
	<tr>
		<td>项目分类</td>
		<td colspan="3">${project.xmfl}</td>
	</tr>
	<tr>
		<td>建设单位是否具备自行招标条件</td>
		<td>&nbsp;</td>
		<td>是否财政性资金工程项目</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>立项批文中是否指定招标方式</td>
		<td>&nbsp;</td>
		<td>是否国有资本控股</td>
		<td><c:if test="${project.sfgyzbkg=='y'}">是</c:if> <c:if
				test="${project.sfgyzbkg=='n'}">否</c:if></td>
	</tr>
	<tr>
		<td>是否正式立项</td>
		<td><c:if test="${project.sffb=='y'}">是</c:if> <c:if
				test="${project.sffb=='n'}">否</c:if></td>
		<td>是否保护性建筑</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>是否重大工程项目</td>
		<td colspan="3"><c:if test="${project.zdxmyn=='y'}">是</c:if> <c:if
				test="${project.zdxmyn=='n'}">否</c:if></td>
	</tr>
	<tr>
		<td>建设部编号</td>
		<td colspan="3">${project.jsbh}</td>
	</tr>
	<tr>
		<td>备注</td>
		<td colspan="3">${project.bjbz}</td>
	</tr>
	<tr>
		<td colspan="4">其他相关信息</td>
	</tr>
	<tr>
		<td>是否地处风景名胜区</td>
		<td><c:if test="${project.fjms=='y'}">是</c:if> <c:if
				test="${project.fjms=='n'}">否</c:if></td>
		<td>如为既有建筑改造是否有节能改造内容</td>
		<td><c:if test="${project.sfyjngz=='y'}">是</c:if> <c:if
				test="${project.sfyjngz=='n'}">否</c:if></td>
	</tr>
	<tr>
		<td>是否有民防设施</td>
		<td><c:if test="${project.sfmfss=='y'}">是</c:if> <c:if
				test="${project.sfmfss=='n'}">否</c:if></td>
		<td>有无配套绿化</td>
		<td></td>
	</tr>
	<tr>
		<td>最大单体面积（平方米）</td>
		<td>&nbsp;</td>
		<td>建筑最大高度是否超过100米</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>全装修住宅比例（%）</td>
		<td colspan="3"></td>
	</tr>
	<tr>
		<td>是否装配式建筑</td>
		<td>&nbsp;</td>
		<td>装配式建筑落实比例（%）</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>装配式建筑面积（平方米）</td>
		<td>&nbsp;</td>
		<td>单体预制装配率（%）</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="4">土地合同出让信息</td>
	</tr>
	<tr>
		<td>土地出让合同地块编号</td>
		<td>&nbsp;</td>
		<td>土地出让合同签订日期</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>土地出让合同编号</td>
		<td>&nbsp;</td>
		<td>土地出让合同宗地号</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>是否申报绿色建筑标识</td>
		<td colspan="3"><c:if test="${project.sflsjzbs=='y'}">是</c:if> <c:if
				test="${project.sflsjzbs=='n'}">否</c:if></td>
	</tr>
	<tr>
		<td>设计标识</td>
		<td>&nbsp;</td>
		<td>运行标识</td>
		<td>&nbsp;</td>
	</tr>
</table>
<table style="width: 100%;" border="1">
	<tr>
		<td colspan="6">是否采用建筑信息模型（BIM）技术</td>
	</tr>
	<tr>
		<td style="width: 15%;">设计阶段</td>
		<td style="width: 17%;">&nbsp;</td>
		<td style="width: 15%;">施工阶段</td>
		<td style="width: 17%;">&nbsp;</td>
		<td style="width: 15%;">运行阶段</td>
		<td style="width: 17%;">&nbsp;</td>
	</tr>
	<tr>
		<td>立项文件中BIM技术专项费用（万元）（如有）</td>
		<td colspan="5">&nbsp;</td>
	</tr>
</table>