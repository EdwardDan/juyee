<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<portlet:defineObjects />

<div class="table1">
	<table border="1" cellpadding="0" cellspacing="0">
		<tr class="tr1">
			<td rowspan="5" class="td1">当前证书信息</td>
			<td class="td2">企业名称：</td>
			<td class="td3">${digitalCertificate.userOrganization}</td>
		</tr>
		<tr>
			<td class="td2">机构代码证：</td>
			<td class="td3">${digitalCertificate.UniqueID}</td>
		</tr>
		<tr>
			<td class="td2">证书唯一标识码：</td>
			<td class="td3">暂无</td>
		</tr>
		<tr>
			<td class="td2">证书序列号：</td>
			<td class="td3">${digitalCertificate.certificateSerialNo}</td>
		</tr>
		<tr>
			<td class="td2">有效期至：</td>
			<td class="td3">${digitalCertificate.expirationDate}</td>
		</tr>
	</table>
</div>
<div class="table2">
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td rowspan="3" class="td1">附加信息</td>
			<td class="td2">证书昵称：</td>
			<td class="td3">暂无</td>
		</tr>
		<tr>
			<td class="td2">证书持有人：</td>
			<td class="td3">${digitalCertificate.userName}</td>
		</tr>
		<tr>
			<td class="td2">证书持有人手机：</td>
			<td class="td3">暂无</td>
		</tr>
	</table>
</div>

<style>
table {
	width: 800px;
	height: auto;
	margin: 20px 0px 0px 0px;
}

table tr {
	height: 60px;
}

.td1 {
	width: 5%;
	text-align: center;
	color: dodgerblue;
	font-size: 20px;
	word-break: break-all;
	background-color: #D1E9E9;
}

.td2 {
	width: 45%;
	text-align: right;
	background-color: #D1E9E9;
}

.td3 {
	width: 50%;
	text-align: left;
}
</style>