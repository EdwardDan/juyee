<%@ page contentType="text/html; charset=UTF-8"%>
<table class="table table-bordered">
	<tr class="body">
		<td class="title">标段号</td>
		<td class="content" colspan="3">${contract.bdh}</td>
	</tr>
	<tr class="body">
		<td class="title">发包方式</td>
		<td class="content">${contract.fbfs}</td>
		<td class="title">承包方式</td>
		<td class="content">${contract.cbfs}</td>
	</tr>
	<tr class="body">
		<td class="title">合同名称</td>
		<td class="content" colspan="3">${contract.htmc}</td>
	</tr>
	<tr class="body">
		<td class="title">发包单位</td>
		<td class="content" colspan="3">${contract.fbdw}</td>
	</tr>
	<tr class="body">
		<td class="title">设计单位</td>
		<td class="content" colspan="3">${contract.sjdw}</td>
	</tr>
	<tr class="body">
		<td class="title">设计负责人</td>
		<td class="content">${contract.sjfzr}</td>
		<td class="title"></td>
		<td class="content"></td>
	</tr>
	<tr class="body">
		<td class="title">证件类型</td>
		<td class="content">${contract.sjfzrzjlx}</td>
		<td class="title">证件号</td>
		<td class="content">${contract.sjfzrzjh}</td>
	</tr>
	<tr class="body">
		<td class="title">勘察单位</td>
		<td class="content" colspan="3">${contract.kcdw}</td>
	</tr>
	<tr class="body">
		<td class="title">勘察负责人</td>
		<td class="content">${contract.kcfzr}</td>
		<td class="title"></td>
		<td class="content"></td>
	</tr>
	<tr class="body">
		<td class="title">证件类型</td>
		<td class="content">${contract.kcfzrzjlx}</td>
		<td class="title">证件号</td>
		<td class="content">${contract.kcfzrzjh}</td>
	</tr>
	<tr class="body">
		<td class="title">施工单位</td>
		<td class="content" colspan="3">${contract.sgdw}</td>
	</tr>
	<tr class="body">
		<td class="title">施工负责人</td>
		<td class="content">${contract.sgfzr}</td>
		<td class="title"></td>
		<td class="content"></td>
	</tr>
	<tr class="body">
		<td class="title">证件类型</td>
		<td class="content">${contract.sgfzrzjlx}</td>
		<td class="title">证件号</td>
		<td class="content">${contract.sgfzrzjh}</td>
	</tr>
	<tr class="body">
		<td class="title">设计项目类别</td>
		<td class="content">${contract.sjxmlb}</td>
		<td class="title">设计工程类别</td>
		<td class="content">${contract.sjgclb}</td>
	</tr>
	<tr class="body">
		<td class="title">设计工程规模</td>
		<td class="content" colspan="3">${contract.sjgcgm}</td>
	</tr>
	<tr class="body">
		<td class="title">施工项目类别</td>
		<td class="content">${contract.sgxmlb}</td>
		<td class="title">施工工程类别</td>
		<td class="content">${contract.sggclb}</td>
	</tr>
	<tr class="body">
		<td class="title">施工工程规模</td>
		<td class="content" colspan="3">${contract.sggcgm}</td>
	</tr>
	<tr class="body">
		<td class="title">开竣工日期</td>
		<td class="content" colspan="3"><fmt:formatDate
				value="${contract.kgrq}" pattern="yyyy-MM-dd" /> 至 <fmt:formatDate
				value="${contract.jgrq}" pattern="yyyy-MM-dd" /></td>
	</tr>
	<tr class="body">
		<td class="title">合同价(万元)</td>
		<td class="content">${contract.htj}</td>
		<td class="title">设计费(万元)</td>
		<td class="content">${contract.sjf}</td>
	</tr>
	<tr class="body">
		<td class="title">勘察费(万元)</td>
		<td class="content" colspan="3">${contract.kcf}</td>
	</tr>
	<tr class="body">
		<td class="title">建安造价(万元)</td>
		<td class="content" colspan="3">${contract.jazj}</td>
	</tr>
	<tr class="body">
		<td class="title">暂列金额(万元)</td>
		<td class="content" colspan="3">${contract.zlje}</td>
	</tr>
	<tr class="body">
		<td class="title">暂估价(万元)</td>
		<td class="content">${contract.zgj}</td>
		<td class="title">安全防护文明施工<br>措施费(万元)
		</td>
		<td class="content">${contract.wmcsf}</td>
	</tr>
	<tr class="body">
		<td class="title">合同签订日期</td>
		<td class="content"><fmt:formatDate value="${contract.htqdrq}"
				pattern="yyyy-MM-dd" /></td>
		<td class="title">合同起止日期<br>(合同有效期)
		</td>
		<td class="content">${contract.htqzrq}</td>
	</tr>
	<tr class="body">
		<td class="title">采用合同示范文本</td>
		<td class="content" colspan="3">${contract.htsfwbmc}</td>
	</tr>
	<tr class="body">
		<td class="title">附注及其他说明</td>
		<td class="content" colspan="3">${contract.bz}</td>
	</tr>
	<tr class="body">
		<td class="title">是否注销</td>
		<td class="content" colspan="3">${contract.sfzx}</td>
	</tr>
	<tr class="body">
		<td class="title">注销时间</td>
		<td class="content" colspan="3"><fmt:formatDate
				value="${contract.zxsj}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
	</tr>
	<tr class="body">
		<td class="title">注销说明</td>
		<td class="content" colspan="3">${contract.zxsm}</td>
	</tr>
</table>