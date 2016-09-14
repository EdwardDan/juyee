<%@ page contentType="text/html; charset=UTF-8"%>
<table class="table table-bordered">
	<tr class="body">
		<td class="title">报建编号</td>
		<td class="content">${contract.bjbh}</td>
		<td class="title">所在地区</td>
		<td class="content">${contract.szdq}</td>
	</tr>
	<tr class="body">
		<td class="title">项目名称</td>
		<td class="content" colspan="3">${contract.xmmc}</td>
	</tr>
	<tr class="body">
		<td class="title">建设单位</td>
		<td class="content" colspan="3">${contract.jsdw}</td>
	</tr>
	<tr class="body">
		<td class="title">建设地点</td>
		<td class="content" colspan="3">${contract.jsdd}</td>
	</tr>
	<tr class="body">
		<td class="title">立项批文</td>
		<td class="content">${contract.lxpw}</td>
		<td class="title">批准文号</td>
		<td class="content">${contract.pzwh}</td>
	</tr>
	<tr class="body">
		<td class="title">单位性质</td>
		<td class="content">${contract.dwxz}</td>
		<td class="title">资金来源构成</td>
		<td class="content">${contract.zjlygc}</td>
	</tr>
	<tr class="body">
		<td class="title">总投资(万元)</td>
		<td class="content">${contract.ztz}</td>
		<td class="title">总建筑面积(㎡)</td>
		<td class="content">${contract.zmj}</td>
	</tr>
	<tr class="body">
		<td class="title">项目分类</td>
		<td class="content">${contract.xmfl}</td>
		<td class="title">建设规模</td>
		<td class="content">${contract.jsgm}</td>
	</tr>
</table>