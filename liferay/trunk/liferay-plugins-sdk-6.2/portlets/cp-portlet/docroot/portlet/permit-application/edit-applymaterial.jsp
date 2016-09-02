<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<style>
.aui .table th, .aui .table td {
	vertical-align: middle;
	padding: 8px;
}

</style>

<c:set var="namespace" value="<%=renderResponse.getNamespace()%>"></c:set>
<portlet:resourceURL var="fileUpLoadURL" id="fileUpLoad" />

<form>
<table class="table table-bordered" style="font-size: 14px;">
	<tr style="text-align: center; height: 45px;">
		<td style="text-align: center; width: 5%;">序号</td>
		<td style="text-align: center; width: 30%;">申请材料名称</td>
		<td style="text-align: center; width: 50%;">附件</td>
		<td style="text-align: center; width: 15%;">操作</td>
	</tr>
	<tr style="text-align: center">
		<td style="text-align: center">1</td>
		<td>航道建设项目项目开工备案表</td>
		<td style="text-align: center">
			<div id="div1">
				<a href="javascript:void(0);">航道建设项目项目开工备案表-01.jpg</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0);">删除</a><br /> <a
				href="javascript:void(0);">航道建设项目项目开工备案表-02.pdf</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0);">删除</a><br /> <a
				href="javascript:void(0);">航道建设项目项目开工备案表-03.jpg</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0);">删除</a><br />
			</div>
		</td>
		<td style="text-align: center">
			<input type="button" value="上传"  onclick="document.getElementById('file1').click();">
			
				<input  id="file1" name="${namespace}file1" type="file" multiple=""
					style="display: none; width: 150px;"
					onchange=";"></input>
			
		</td>
	</tr>
	<tr style="text-align: center">
		<td style="text-align: center">2</td>
		<td>工程可行性研究报告批复</td>
		<td style="text-align: center"></td>
		<td style="text-align: center">
		<input type="button" value="上传" >
		</td>
	</tr>
	<tr style="text-align: center">
		<td style="text-align: center">3</td>
		<td>工程初步设计文件批复</td>
		<td style="text-align: center"></td>
		<td style="text-align: center">
		<input type="button" value="上传" >
		</td>
	</tr>
	<tr style="text-align: center">
		<td style="text-align: center">4</td>
		<td>建设项目用地规划许可证</td>
		<td style="text-align: center"></td>
		<td style="text-align: center">
		<input type="button" value="上传" >
		</td>
	</tr>
	<tr style="text-align: center">
		<td style="text-align: center">5</td>
		<td>施工图设计文件批复</td>
		<td style="text-align: center"></td>
		<td style="text-align: center">
		<input type="button" value="上传" >
		</td>
	</tr>
	<tr style="text-align: center">
		<td style="text-align: center">6</td>
		<td>建设资金落实证明</td>
		<td style="text-align: center"></td>
		<td style="text-align: center">
		<input type="button" value="上传" >
		</td>
	</tr>
	<tr style="text-align: center">
		<td style="text-align: center">7</td>
		<td>提供项目场地内完成动迁的证明材料</td>
		<td style="text-align: center"></td>
		<td style="text-align: center">
		<input type="button" value="上传" >
		</td>
	</tr>
	<tr style="text-align: center">
		<td style="text-align: center">8-1</td>
		<td>主体工程施工中标通知书</td>
		<td style="text-align: center"></td>
		<td style="text-align: center">
		<input type="button" value="上传" >
		</td>
	</tr>
	<tr style="text-align: center">
		<td style="text-align: center">8-2</td>
		<td>承发包合同</td>
		<td style="text-align: center"></td>
		<td style="text-align: center">
		<input type="button" value="上传" >
		</td>
	</tr>
	<tr style="text-align: center">
		<td style="text-align: center">8-3</td>
		<td>企业的营业执照</td>
		<td style="text-align: center"></td>
		<td style="text-align: center">
		<input type="button" value="上传" >
		</td>
	</tr>
	<tr style="text-align: center">
		<td style="text-align: center">8-4</td>
		<td>资质证书</td>
		<td style="text-align: center"></td>
		<td style="text-align: center">
		<input type="button" value="上传" >
		</td>
	</tr>
	<tr style="text-align: center">
		<td style="text-align: center">8-5</td>
		<td>安全生产许可证书</td>
		<td style="text-align: center"></td>
		<td style="text-align: center">
		<input type="button" value="上传" >
		</td>
	</tr>
	<tr style="text-align: center">
		<td style="text-align: center">8-6</td>
		<td>项目经理的注册建造师资格证书</td>
		<td style="text-align: center"></td>
		<td style="text-align: center">
		<input type="button" value="上传" >
		</td>
	</tr>

	<tr style="text-align: center">
		<td style="text-align: center">9-1</td>
		<td>主体工程监理中标通知书</td>
		<td style="text-align: center"></td>
		<td style="text-align: center">
		<input type="button" value="上传" >
		</td>
	</tr>
	<tr style="text-align: center">
		<td style="text-align: center">9-2</td>
		<td>承发包合同</td>
		<td style="text-align: center"></td>
		<td style="text-align: center">
		<input type="button" value="上传" >
		</td>
	</tr>
	<tr style="text-align: center">
		<td style="text-align: center">9-3</td>
		<td>企业的营业执照</td>
		<td style="text-align: center"></td>
		<td style="text-align: center">
		<input type="button" value="上传" >
		</td>
	</tr>
	<tr style="text-align: center">
		<td style="text-align: center">9-4</td>
		<td>资质证书</td>
		<td style="text-align: center"></td>
		<td style="text-align: center">
		<input type="button" value="上传" >
		</td>
	</tr>
	<tr style="text-align: center">
		<td style="text-align: center">9-5</td>
		<td>相应的总监注册监理工程师资格证书</td>
		<td style="text-align: center"></td>
		<td style="text-align: center">
		<input type="button" value="上传" >
		</td>
	</tr>
	<tr style="text-align: center">
		<td style="text-align: center">10</td>
		<td>主体工程安全质量报监证明手续</td>
		<td style="text-align: center"></td>
		<td style="text-align: center">
		<input type="button" value="上传" >
		</td>
	</tr>
	<tr style="text-align: center">
		<td style="text-align: center">11</td>
		<td>其他证明资料</td>
		<td style="text-align: center"></td>
		<td style="text-align: center">
		<input type="button" value="上传" >
		</td>
	</tr>

</table>

<div style="text-align: center">
	<aui:button type="submit" value="保存" />
</div>

</form>





