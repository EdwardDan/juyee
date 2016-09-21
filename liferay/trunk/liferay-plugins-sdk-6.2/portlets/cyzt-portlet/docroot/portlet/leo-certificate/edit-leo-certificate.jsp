<%@page import="sun.java2d.pipe.SpanShapeRenderer.Simple"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.justonetech.cyzt.leo.service.LEOCertificateLocalServiceUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@page import="com.justonetech.cyzt.leo.model.LEOCertificate"%>
<%@page import="java.util.List"%>

<portlet:defineObjects />
<%
	long certificateId = ParamUtil.getLong(request,"certificateId",0L);
	String dateFormatPattern = PropsUtil.get("default.date.format.pattern");
	LEOCertificate leoCertificate = null;
	if (certificateId != 0L) {
		leoCertificate = LEOCertificateLocalServiceUtil.getLEOCertificate(certificateId);
		if (leoCertificate != null) {
			request.setAttribute("certificateId", leoCertificate.getCertificateId());
			request.setAttribute("xm", leoCertificate.getXm());
			request.setAttribute("zylx", leoCertificate.getZylx());
			request.setAttribute("zjbh",leoCertificate.getZjbh());
			request.setAttribute("fzrq", leoCertificate.getFzrq());
			request.setAttribute("yxq", leoCertificate.getYxq());
		}
	}
%>
<portlet:actionURL var="saveLEOCertificateURL" name="saveLEOCertificate"></portlet:actionURL>
<form name="fm" id="fm" method="post" action="${saveLEOCertificateURL}" class="form-horizontal">
	<input type="hidden" id="<portlet:namespace/>certificateId" name="<portlet:namespace/>certificateId" value="${certificateId}" />
	<aui:row>
		<aui:col span="6">
			<label class="control-label" for="xm">姓名：</label>
			<div class="controls">
				<aui:input type="text" id="xm" name="xm" label="" required="required" value="${xm}" inlineLabel="left" />
			</div>
		</aui:col>
		<aui:col span="6">
			<label class="control-label" for="zylx">专业类型：</label>
			<div class="controls">
				<aui:input type="text" id="zylx" name="zylx" label="" required="required" value="${zylx}" inlineLabel="left" />
			</div>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6">
			<label class="control-label" for="zjbh">证件编号：</label>
			<div class="controls">
				<aui:input type="text" name="zjbh" id="zjbh" label="" required="required" value="${zjbh}" inlineLabel="left" />
			</div>
		</aui:col>
		<aui:col span="6">
			<label class="control-label" for="fzrq">发证日期：</label>
			<div class="controls">
				<input type="text" class="Wdate" id="fzrq" name="<portlet:namespace/>fzrq"
					value="<fmt:formatDate value='${fzrq}' pattern='yyyy-MM-dd' />" onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"
					required="required" />
			</div>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6">
			<label class="control-label" for="yxq">有效期：</label>
			<div class="controls">
				<input type="text" class="Wdate" id="yxq" name="<portlet:namespace/>yxq" value="<fmt:formatDate value='${yxq}' pattern='yyyy-MM-dd' />"
					onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" required="required" />
			</div>
		</aui:col>
	</aui:row>

	<aui:row>
		<div class="text-center">
			<aui:button type="button" value="保存" onClick="checkIsExist()">
			</aui:button>
			<portlet:renderURL var="viewURL" />
			<aui:button href="${viewURL}" value="取消"></aui:button>
		</div>
	</aui:row>
</form>
<portlet:resourceURL var="ajaxUrl" id="checkIsExist" />
<script>
function checkIsExist(){
	if($("#<portlet:namespace/>xm").val()!=""&&$("#<portlet:namespace/>zylx").val()!=""&&$("#<portlet:namespace/>zjbh").val()!=""&&$("#fzrq").val()!=""&&$("#yxq").val()!=""){
		$.ajax({
			type:"GET",
			url:"<%=ajaxUrl%>",
				data : {
					'<portlet:namespace/>zjbh' : $('#<portlet:namespace/>zjbh').val(),
					'<portlet:namespace/>certificateId' : $('#<portlet:namespace/>certificateId').val()
				},
				error : function(err) {
				},
				success : function(data) {
					var result = eval("(" + data + ")");
					if (result == "") {
						alert("该证件编号已存在，请重新输入！");
					} else {
						$("#fm").submit();
					}
				}
			});
		} else {
			alert("请输入完整信息！");
		}
	}
</script>