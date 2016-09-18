<%@page import="sun.java2d.pipe.SpanShapeRenderer.Simple"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page
	import="com.justonetech.cyzt.leo.service.LEOCertificateLocalServiceUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@page import="com.justonetech.cyzt.leo.model.LEOCertificate"%>
<%@page import="java.util.List"%>

<portlet:defineObjects />
<%
	String certificateId = ParamUtil.getString(request,
			"certificateId", "");
	String dateFormatPattern = PropsUtil
			.get("default.date.format.pattern");
	LEOCertificate leoCertificate = null;
	if (certificateId != "") {
		leoCertificate = LEOCertificateLocalServiceUtil
				.getLEOCertificate(certificateId);
		System.out.println(leoCertificate);
		if (leoCertificate != null) {
			request.setAttribute("xm", leoCertificate.getXm());
			request.setAttribute("zylx", leoCertificate.getZylx());
			request.setAttribute("certificateId",
					leoCertificate.getCertificateId());
			request.setAttribute("fzrq", leoCertificate.getFzrq());
			request.setAttribute("yxq", leoCertificate.getYxq());
		}
	}
%>
<portlet:actionURL var="saveLEOCertificateURL" name="saveLEOCertificate"></portlet:actionURL>
<form name="fm" id="fm" method="post"
	action="${saveLEOCertificateURL}">
	<table style="width: 100%;" class="table table-bordered">
		<tr class="body">
			<td style="width: 10%; text-align: right">姓名</td>
			<td style="width: 40%;" class="content"><aui:input type="text" id="xm"
					name="xm" label="" cssClass="span12" required="required"
					value="${xm}" /></td>
			<td style="width: 15%; text-align: right">专业类型</td>
			<td style="width: 35%;" class="content"><aui:input type="text" id="zylx"
					name="zylx" label="" cssClass="span12" required="required"
					value="${zylx}" /></td>
		</tr>

		<tr class="body">
			<td style="width: 10%; text-align: right">证件编号</td>
			<td class="content"><aui:input type="text" name="certificateId" id="certificateId"
					label="" cssClass="span12" required="required" value="${certificateId}" /></td>
			<td style="width: 15%; text-align: right">发证日期</td>
			<td style="width: 35%;" class="content"><input type="text"
				class="Wdate span12" id="fzrq" name="<portlet:namespace/>fzrq"
				value="<fmt:formatDate value='${fzrq}' pattern='yyyy-MM-dd' />"
				onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"
				required="required" /></td>
		</tr>
		<tr class="body">
			<td style="width: 10%; text-align: right">有效期</td>
			<td class="content"><input type="text" class="Wdate span12"
				id="yxq" name="<portlet:namespace/>yxq" value="<fmt:formatDate value='${yxq}' pattern='yyyy-MM-dd' />"
				onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"
				required="required" /></td>
			<td></td>
			<td></td>
		</tr>
		<tr style="height: 40px;" class="body">
			<td colspan="4" style="text-align: center" class="content"><aui:button
					type="button" value="保存" onClick="checkIsExist()">
					<portlet:renderURL var="viewURL" />
				</aui:button> <aui:button href="${viewURL}" value="取消"></aui:button></td>
		</tr>
	</table>
</form>
<portlet:resourceURL var="ajaxUrl" id="checkIsExist" />
<script>
function checkIsExist(){
	if($("#xm").val()!=""&&$("#zylx").val()!=""&&$("#certificateId").val()!=""&&$("#fzrq").val()!=""&&$("#yxq").val()!=""){
		$.ajax({
			type:"GET",
			url:"<%=ajaxUrl%>",
			data : {
				'<portlet:namespace/>certificateId' : $('#<portlet:namespace/>certificateId').val()
			},
			error : function(err) {
			},
			success : function(data) {
				var result = eval("(" + data + ")");
				if(result==""){
					alert("该证件编号已存在，请重新输入！");
				}else{
					$("#fm").submit();
				}
			}
		});
	}else{
		alert("请输入完整信息！");
	}
}
	
</script>