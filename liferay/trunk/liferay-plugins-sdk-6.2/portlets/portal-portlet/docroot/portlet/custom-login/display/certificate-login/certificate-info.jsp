<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<portlet:defineObjects />

<liferay-ui:panel-container accordion="false" extended="true">
	<liferay-ui:panel title="当前证书信息" collapsible="false">
		<table cellpadding="0" cellspacing="0" class="table table-bordered">
			<tr class="tr1">
				<td class="text-right" style="width: 40%">企业名称</td>
				<td class="bg-white">${digitalCertificate.userOrganization}</td>
			</tr>
			<tr>
				<td class="text-right">机构代码证</td>
				<td class="bg-white">${digitalCertificate.UniqueID}</td>
			</tr>
			<tr>
				<td class="text-right">证书唯一标识码</td>
				<td class="bg-white">暂无</td>
			</tr>
			<tr>
				<td class="text-right">证书序列号</td>
				<td class="bg-white">${digitalCertificate.certificateSerialNo}</td>
			</tr>
			<tr>
				<td class="text-right">有效期至</td>
				<td class="bg-white">${digitalCertificate.expirationDate}</td>
			</tr>
		</table>
	</liferay-ui:panel>
	<liferay-ui:panel title="附加信息" collapsible="false">
		<table cellpadding="0" cellspacing="0" class="table table-bordered">
			<tr>
				<td class="text-right" style="width: 40%">证书昵称</td>
				<td class="bg-white">暂无</td>
			</tr>
			<tr>
				<td class="text-right">证书持有人</td>
				<td class="bg-white">${digitalCertificate.userName}</td>
			</tr>
			<tr>
				<td class="text-right">证书持有人手机</td>
				<td class="bg-white">暂无</td>
			</tr>
		</table>
		</div>
	</liferay-ui:panel>
</liferay-ui:panel-container>

<style>
table {
	width: 800px;
	height: auto;
	margin: 20px 0px 0px 0px;
}

table tr {
	height: 60px;
}

</style>