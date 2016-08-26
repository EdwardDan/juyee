<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contentPath"
	value="${request.contextPath}/portlet/construction-project" />

<portlet:renderURL var="viewURL" />

<portlet:renderURL var="viewProject">
	<portlet:param name="mvcPath" value="${contentPath}/view-project.jsp" />
</portlet:renderURL>

<portlet:resourceURL var="queryProjectURL"/>

<table style="width: 100%;" border="1">
	<tr>
		<td colspan="4">报建项目查询</td>
	</tr>
	<tr>
		<td style="width: 10%;">报建编号</td>
		<td style="width: 40%;"><input type="text"
			id="<portlet:namespace/>bjbh" name="bjbh" /></td>
		<td style="width: 15%;">网上申请编号</td>
		<td style="width: 35%;"><input type="text"
			id="<portlet:namespace/>wssqbh" name="wssqbh" /></td>
	</tr>
	<tr>
		<td>项目名称</td>
		<td colspan="3"><input type="text" id="<portlet:namespace/>xmmc"
			name="xmmc" /></td>
	</tr>
	<tr>
		<td>报建日期从</td>
		<td><input type="text" id="<portlet:namespace/>ksbjrq"
			name="ksbjrq" class="Wdate" value=""
			onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'<portlet:namespace/>jsbjrq\')}'})"
			style="width:100px;" />&nbsp;到&nbsp;<input type="text"
			id="<portlet:namespace/>jsbjrq" name="jsbjrq" class="Wdate" value=""
			onfocus="WdatePicker({minDate:'#F{$dp.$D(\'<portlet:namespace/>ksbjrq\')}'})"
			style="width:100px;" /></td>
		<td>项目状态</td>
		<td><select id="<portlet:namespace/>bjwcbj" name="bjwcbj">
				<option value=""></option>
				<option value="y">已完成</option>
				<option value="n">未完成</option>
		</select></td>
	</tr>
	<tr>
		<td colspan="4" align="center"><input type="button" name="query"
			value="提交查询" onClick="queryProject();" /></td>
	</tr>
</table>

<br>
<table style="width: 100%;" border="1">
	<tr>
		<td align="center" style="width: 10%;">报建编号</td>
		<td align="center" style="width: 15%;">网上申请编号</td>
		<td align="center" style="width: 45%;">项目名称</td>
		<td align="center" style="width: 10%;">报建日期</td>
		<td align="center" style="width: 10%;">状态</td>
		<td align="center" style="width: 10%;">操作</td>
	</tr>
	<tr>
		<td align="center">1401BS0030</td>
		<td align="center">W2014050100008</td>
		<td align="left">test</td>
		<td align="center">2014-05-06</td>
		<td align="center">已完成</td>
		<td align="center"><a
			href="${viewProject}&<portlet:namespace/>bjbh=1401BS0030">查看</a></td>
	</tr>
</table>

<script type="text/javascript">
	function queryProject() {
		$.ajax({
			type:"GET",
			url:"<%=queryProjectURL%>",
			data : {
				'<portlet:namespace/>bjbh' : $('#<portlet:namespace/>bjbh').val(),
				'<portlet:namespace/>wssqbh' : $('#<portlet:namespace/>wssqbh').val(), 
				'<portlet:namespace/>xmmc' : $('#<portlet:namespace/>xmmc').val(), 
				'<portlet:namespace/>ksbjrq' : $('#<portlet:namespace/>ksbjrq').val(), 
				'<portlet:namespace/>jsbjrq' : $('#<portlet:namespace/>jsbjrq').val(), 
				'<portlet:namespace/>bjwcbj' : $('#<portlet:namespace/>bjwcbj').val(), 
			},
			error : function(err) {
				alert("查询失败!");
			},
			success : function(data) {
				alert("查询成功!");	
			}
		});
	}
</script>
