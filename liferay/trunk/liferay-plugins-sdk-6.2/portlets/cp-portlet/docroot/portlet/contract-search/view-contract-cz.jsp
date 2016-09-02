<%@page
	import="com.justonetech.cp.contract.service.ContractLocalServiceUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%
	String contractId = ParamUtil.getString(request, "bjbh");
	Contract contract = ContractLocalServiceUtil.getContract(contractId);
	request.setAttribute("contract", contract);
%>
<style type="text/css">
table {
	width: 100%
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
	background-color: #D1EEEE;
	text-align: center;
}

tr.body td.content {
	width: 30%;
}

td.content span {
	font-weight: bold;
	color: #104E8B;
}
</style>
<!-- 施工总包合同详细信息 -->
<table border="2">
	<tr class="head">
		<td colspan="4">合同信息报送编号:${contract.contractId}</td>
	</tr>
	<tr class="body">
		<td class="title">施工标段号:</td>
		<td class="content">${contract.bdh}</td>
		<td class="title">发包方式:</td>
		<td class="content">${contract.fbfs}</td>
	</tr>
	<tr class="body">
		<td class="title">专业承包合同:</td>
		<td class="content">${contract.zycbht}</td>
		<td class="title">专业工程类别:</td>
		<td class="content">${contract.zygclb}</td>
	</tr>
	<tr class="body">
		<td class="title">合同名称:</td>
		<td class="content" colspan="3">${contract.htmc}</td>
	</tr>
	<tr class="body">
		<td class="title">发包单位:</td>
		<td class="content" colspan="3">${contract.fbdw}</td>
	</tr>
	<tr class="body">
		<td class="title">承包单位:</td>
		<td class="content" colspan="3">${contract.cbdw}</td>
	</tr>
	<tr class="body">
		<td class="title">项目负责人:</td>
		<td class="content">${contract.xmfzr}</td>
		<td class="title"></td>
		<td class="content"></td>
	</tr>
	<tr class="body">
		<td class="title">证件类型:</td>
		<td class="content">${contract.kcfzrzjlx}</td>
		<td class="title">证件号:</td>
		<td class="content">${contract.kcfzrzjh}</td>
	</tr>
	<tr class="body">
		<td class="title">项目类别:</td>
		<td class="content">${contract.xmlb}</td>
		<td class="title">工程类别:</td>
		<td class="content">${contract.gclb}</td>
	</tr>
	<tr class="body">
		<td class="title">工程规模:</td>
		<td class="content" colspan="3">${contract.gcgm}</td>
	</tr>
	<tr class="body" style="border-top: 2px solid;">
		<td class="title">合同价(万元):</td>
		<td class="content">${contract.htj}</td>
		<td class="title">暂列金额(万元):</td>
		<td class="content">${contract.zlje}</td>
	</tr>
	<tr class="body">
		<td class="title">暂估价(万元):</td>
		<td class="content">${contract.zgj}</td>
		<td class="title">安全防护<br>文明施工措施费(万元):
		</td>
		<td class="content">${contract.aqfhwmsgcsf}</td>
	</tr>
	<tr class="body">
		<td class="title">开竣工日期:</td>
		<td class="content"><fmt:formatDate value="${contract.kgrq}"
				pattern="yyyy-MM-dd" /> 至 <fmt:formatDate value="${contract.jgrq}"
				pattern="yyyy-MM-dd" /></td>
		<td class="title">结算方式:</td>
		<td class="content">${contract.jsfs}</td>
	</tr>
	<tr class="body">
		<td class="title">合同签订日期:</td>
		<td class="content"><fmt:formatDate value="${contract.htqdrq}"
				pattern="yyyy-MM-dd" /></td>
		<td class="title">合同起止日期<br>(合同有效期):
		</td>
		<td class="content">${contract.htqzrq}</td>
	</tr>
	<tr class="body">
		<td class="title">承包内容:</td>
		<td class="content" colspan="3">${contract.cbnr}</td>
	</tr>
	<tr class="body">
		<td class="title">采用合同示范文本:</td>
		<td class="content" colspan="3">${contract.cyhtsfwb}</td>
	</tr>
	<tr class="body">
		<td class="title">附注及其他说明:</td>
		<td class="content" colspan="3">${contract.fzjqtsm}</td>
	</tr>
	<tr class="body" style="border-top: 2px solid;">
		<td class="title">是否注销:</td>
		<td class="content" colspan="3">${contract.sfzx}</td>
	</tr>
	<tr class="body">
		<td class="title">注销时间:</td>
		<td class="content" colspan="3"><fmt:formatDate
				value="${contract.zxsj}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
	</tr>
	<tr class="body">
		<td class="title">注销说明:</td>
		<td class="content" colspan="3">${contract.zxsm}</td>
	</tr>
</table>