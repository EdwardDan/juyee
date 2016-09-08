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
<liferay-ui:panel-container accordion="false" extended="true">
	<liferay-ui:panel title="" collapsible="false">
		<table class="table table-bordered">
			<tr>
				<td style="width: 15%%;" class="text-right">报建日期</td>
				<td style="width: 35%;" class="bg-white"><fmt:formatDate value="${project.bjrq}" pattern="yyyy-MM-dd" /></td>
				<td style="width: 15%;" class="text-right">报建编号</td>
				<td style="width: 35%;" class="bg-white">${project.bjbh}</td>
			</tr>
			<tr>
				<td class="text-right">网上申请编号</td>
				<td class="bg-white">${project.bj_webid}</td>
				<td class="text-right">统一审批编码</td>
				<td class="bg-white">&nbsp;</td>
			</tr>
			<tr>
				<td class="text-right">所在区县</td>
				<td class="bg-white">${project.szqx}</td>
				<td class="text-right">所在区域</td>
				<td class="bg-white">${project.szqy}</td>
			</tr>
			<tr>
				<td class="text-right">建设工程名称</td>
				<td colspan="3" class="bg-white">${project.xmmc}</td>
			</tr>
			<tr>
				<td class="text-right">建设地点</td>
				<td colspan="3" class="bg-white">${project.jsdd}</td>
			</tr>
			<tr>
				<td class="text-right">建设单位</td>
				<td colspan="3" class="bg-white">${project.jsdw}</td>
			</tr>
			<tr>
				<td class="text-right">建设单位办公地址</td>
				<td class="bg-white">${project.jsdwdz}</td>
				<td class="text-right">邮政编码</td>
				<td class="bg-white">${project.jsdwyb}</td>
			</tr>
			<tr>
				<td class="text-right">机构代码</td>
				<td class="bg-white">${project.jsdwjgdm}</td>
				<td class="text-right">工程账户号</td>
				<td class="bg-white">${project.gczh}</td>
			</tr>
			<tr>
				<td class="text-right">建设单位法定代表人</td>
				<td class="bg-white">${project.jsdwfr}</td>
				<td class="text-right">建设单位联系人</td>
				<td class="bg-white">${project.jsdwlxr}</td>
			</tr>
			<tr>
				<td class="text-right">联系人手机</td>
				<td class="bg-white">${project.jsdwdh}</td>
				<td class="text-right">建设单位注册资金（万元）</td>
				<td class="bg-white">${project.jsdwzczj}</td>
			</tr>
			<tr>
				<td class="text-right">建设单位性质</td>
				<td class="bg-white">${project.jsdwxz}</td>
				<td class="text-right">建设性质</td>
				<td class="bg-white">${project.jsxz}</td>
			</tr>
			<tr>
				<td class="text-right">立项或批准文件名称</td>
				<td colspan="3" class="bg-white">${project.lxwj}</td>
			</tr>
			<tr>
				<td class="text-right">立项或批准文件文号</td>
				<td class="bg-white">${project.lxwh}</td>
				<td class="text-right">立项文件项目代码</td>
				<td class="bg-white">&nbsp;</td>
			</tr>
			<tr>
				<td class="text-right">发文单位</td>
				<td class="bg-white">${project.pzjg}</td>
				<td class="text-right">发文日期</td>
				<td class="bg-white">${project.pzrq}</td>
			</tr>
			<tr>
				<td class="text-right">立项级别</td>
				<td class="bg-white">${project.lxjb}</td>
				<td class="text-right">立项分类</td>
				<td class="bg-white">${project.lxfl}</td>
			</tr>
			<tr>
				<td class="text-right">是否文物或优秀历史建筑</td>
				<td colspan="3" class="bg-white"></td>
			</tr>
			<tr>
				<td class="text-right">总投资</td>
				<td colspan="3" class="bg-white">${project.ztz}万元，其中设备投资${project.sbtz}万元</td>
			</tr>
			<tr>
				<td class="text-right">建设工程规模</td>
				<td colspan="3" class="bg-white">${project.jsgm}</td>
			</tr>
			<tr>
				<td class="text-right">项目资金来源构成</td>
				<td colspan="3" class="bg-white">&nbsp;</td>
			</tr>
			<tr>
				<td class="text-right">项目分类</td>
				<td colspan="3" class="bg-white">${project.xmfl}</td>
			</tr>
			<tr>
				<td class="text-right">建设单位是否具备自行招标条件</td>
				<td class="bg-white">&nbsp;</td>
				<td class="text-right">是否财政性资金工程项目</td>
				<td class="bg-white">&nbsp;</td>
			</tr>
			<tr>
				<td class="text-right">立项批文中是否指定招标方式</td>
				<td class="bg-white">&nbsp;</td>
				<td class="text-right">是否国有资本控股</td>
				<td class="bg-white"><c:if test="${project.sfgyzbkg=='y'}">是</c:if> <c:if test="${project.sfgyzbkg=='n'}">否</c:if></td>
			</tr>
			<tr>
				<td class="text-right">是否正式立项</td>
				<td class="bg-white"><c:if test="${project.sffb=='y'}">是</c:if> <c:if test="${project.sffb=='n'}">否</c:if></td>
				<td class="text-right">是否保护性建筑</td>
				<td class="bg-white">&nbsp;</td>
			</tr>
			<tr>
				<td class="text-right">是否重大工程项目</td>
				<td colspan="3" class="bg-white"><c:if test="${project.zdxmyn=='y'}">是</c:if> <c:if test="${project.zdxmyn=='n'}">否</c:if></td>
			</tr>
			<tr>
				<td class="text-right">建设部编号</td>
				<td colspan="3" class="bg-white">${project.jsbh}</td>
			</tr>
			<tr>
				<td class="text-right">备注</td>
				<td colspan="3" class="bg-white">${project.bjbz}</td>
			</tr>
		</table>
	</liferay-ui:panel>
	<liferay-ui:panel title="其他相关信息" collapsible="false">
		<table class="table table-bordered">
			<tr>
				<td style="width: 15%" class="text-right">是否地处风景名胜区</td>
				<td style="width: 35%" class="bg-white"><c:if test="${project.fjms=='y'}">是</c:if> <c:if test="${project.fjms=='n'}">否</c:if></td>
				<td style="width: 15%" class="text-right">如为既有建筑改造是否有节能改造内容</td>
				<td style="width: 35%" class="bg-white"><c:if test="${project.sfyjngz=='y'}">是</c:if> <c:if test="${project.sfyjngz=='n'}">否</c:if></td>
			</tr>
			<tr>
				<td class="text-right">是否有民防设施</td>
				<td class="bg-white"><c:if test="${project.sfmfss=='y'}">是</c:if> <c:if test="${project.sfmfss=='n'}">否</c:if></td>
				<td class="text-right">有无配套绿化</td>
				<td class="bg-white"></td>
			</tr>
			<tr>
				<td class="text-right">最大单体面积（平方米）</td>
				<td class="bg-white">&nbsp;</td>
				<td class="text-right">建筑最大高度是否超过100米</td>
				<td class="bg-white">&nbsp;</td>
			</tr>
			<tr>
				<td class="text-right">全装修住宅比例（%）</td>
				<td colspan="3" class="bg-white"></td>
			</tr>
			<tr>
				<td class="text-right">是否装配式建筑</td>
				<td class="bg-white">&nbsp;</td>
				<td class="text-right">装配式建筑落实比例（%）</td>
				<td class="bg-white">&nbsp;</td>
			</tr>
			<tr>
				<td class="text-right">装配式建筑面积（平方米）</td>
				<td class="bg-white">&nbsp;</td>
				<td class="text-right">单体预制装配率（%）</td>
				<td class="bg-white">&nbsp;</td>
			</tr>
		</table>
	</liferay-ui:panel>
	<liferay-ui:panel title="土地合同出让信息" collapsible="false">
		<table class="table table-bordered">
			<tr>
				<td style="width: 15%" class="text-right">土地出让合同地块编号</td>
				<td style="width: 35%" class="bg-white">&nbsp;</td>
				<td style="width: 15%" class="text-right">土地出让合同签订日期</td>
				<td style="width: 35%" class="bg-white">&nbsp;</td>
			</tr>
			<tr>
				<td class="text-right">土地出让合同编号</td>
				<td class="bg-white">&nbsp;</td>
				<td class="text-right">土地出让合同宗地号</td>
				<td class="bg-white">&nbsp;</td>
			</tr>
			<tr>
				<td class="text-right">是否申报绿色建筑标识</td>
				<td colspan="3" class="bg-white"><c:if test="${project.sflsjzbs=='y'}">是</c:if> <c:if test="${project.sflsjzbs=='n'}">否</c:if></td>
			</tr>
			<tr>
				<td class="text-right">设计标识</td>
				<td class="bg-white">&nbsp;</td>
				<td class="text-right">运行标识</td>
				<td class="bg-white">&nbsp;</td>
			</tr>
		</table>
	</liferay-ui:panel>
	<liferay-ui:panel title="是否采用建筑信息模型（BIM）技术" collapsible="false">
		<table style="width: 100%;" class="table table-bordered">
			<tr>
				<td style="width: 15%;" class="text-right">设计阶段</td>
				<td style="width: 17%;" class="bg-white">&nbsp;</td>
				<td style="width: 15%;" class="text-right">施工阶段</td>
				<td style="width: 17%;" class="bg-white">&nbsp;</td>
				<td style="width: 15%;" class="text-right">运行阶段</td>
				<td style="width: 17%;" class="bg-white">&nbsp;</td>
			</tr>
			<tr>
				<td class="text-right">立项文件中BIM技术专项费用（万元）（如有）</td>
				<td colspan="5" class="bg-white">&nbsp;</td>
			</tr>
		</table>
	</liferay-ui:panel>
</liferay-ui:panel-container>