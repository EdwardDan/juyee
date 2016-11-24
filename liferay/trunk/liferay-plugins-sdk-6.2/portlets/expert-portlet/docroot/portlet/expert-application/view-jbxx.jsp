<%@page import="com.justonetech.expert.model.Expert"%>
<%@page import="com.justonetech.expert.service.ExpertLocalServiceUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<portlet:defineObjects />
<portlet:renderURL var="viewURL" />
<portlet:actionURL var="saveJbxxURL" name="saveJbxx">
</portlet:actionURL>
<%
	long expertId = ParamUtil.getLong(request, "expertId");
	Expert expert = ExpertLocalServiceUtil.getExpert(expertId);
	String csny = expert.getSfzh().substring(6,12);
	String csn = csny.substring(0, 4);
	String csy = csny.substring(4,6);
	request.setAttribute("expert", expert);
	request.setAttribute("csn", csn);
	request.setAttribute("csy", csy);
%>
<table class="table table-bordered" width="100%">
		<tr>
			<td class="text-right" width="20%">姓名</td>
			<td class="bg-white" width="30%">${expert.xm}</td>
			<td class="text-right" width="20%">性别</td>
			<td class="bg-white" width="30%">${expert.xb}</td>
		</tr>
		<tr>
			<td class="text-right">身份证号</td>
			<td class="bg-white" colspan="3">${expert.sfzh}</td>
		</tr>
		<tr>
			<td class="text-right">出生年月</td>
			<td class="bg-white" colspan="3">${csn}">年${csy}月</td>
		</tr>
		<tr>
			<td class="text-right">工作单位</td>
			<td class="bg-white">${expert.gzdw}"</td>
			<td class="text-right">电子邮箱</td>
			<td class="bg-white">${expert.dzyx}"</td>
		</tr>
		<tr>
			<td class="text-right">通信地址</td>
			<td class="bg-white">${expert.txdz}</td>
			<td class="text-right">邮政编码</td>
			<td class="bg-white">${expert.yzbm}</td>
		</tr>
		<tr>
			<td class="text-right">现任职务</td>
			<td class="bg-white">${expert.xrzw}</td>
			<td class="text-right">职称</td>
			<td class="bg-white">${expert.zc}</td>
		</tr>
		<tr>
			<td class="text-right">执业资格</td>
			<td class="bg-white">${expert.zyzg}</td>
			<td class="text-right">从事专业</td>
			<td class="bg-white">${expert.cszy}</td>
		</tr>
		<tr>
			<td class="text-right">专业工作年限</td>
			<td class="bg-white">${expert.zygznx}</td>
			<td class="text-right">手机号码</td>
			<td class="bg-white">${expert.sjhm}</td>
		</tr>
		<tr>
			<td class="text-right">联系电话</td>
			<td class="bg-white">${expert.lxdh}</td>
			<td class="text-right">传真</td>
			<td class="bg-white">${expert.cz}</td>
		</tr>
	</table>
