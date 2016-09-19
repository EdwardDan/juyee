<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<style type="text/css">
div.main {
	border-left: 1px solid #ddd;
	border-bottom: 1px solid #ddd;
	border-right: 1px solid #ddd;
	box-shadow: 2px 2px 2px #e8e8e8
}

div.head {
	background-color: #00a2ee;
	height: 10px;
}

div.body {
	border-bottom: 1px solid #ddd;
}

table.thead tr td.head {
	color: #0073d4;
	font-size: 18px;
	line-height: 30px;
}

table.thead tr td span {
	margin-left: 15px;
	display: inline-block;
	vertical-align: middle;
	font-family: "Microsoft YaHei UI";
}

table.thead tr td a {
	display: inline-block;
	width: 160px;
	height: 30px;
	line-height: 30px;
	text-align: center;
	color: #fff;
	border-radius: 5px;
	text-decoration: none;
	background-color: #ff954f;
	margin-left: 56px
}

table.thead tr td input {
	width: 200px;
	height: 25px;
	border-radius: 5px;
}

table.thead tr td select {
	width: 200px;
	height: 30px;
	border-radius: 5px
}
</style>
<div class="main">
	<div class="head"></div>
	<div class="body">
		<table class="thead">
			<tr>
				<td colspan="2" class="head"><span
					style="width: 5px; height: 20px; background-color: #ffa200; display: inline-block"></span><span>回复查询</span>
				</td>
			</tr>
		</table>
	</div>
	<table class="thead" style="margin-top: 10px">
		<tr>
			<td><span>主题:&nbsp;<input name="subject"></span></td>
			<td><span>类型:&nbsp;<select name="type">
						<option>选择类型</option>
				</select></span></td>
		</tr>
		<tr>
			<td></td>
			<td><a href="#" class="btn">查询</a></td>
		</tr>
	</table>
	<br>
</div>