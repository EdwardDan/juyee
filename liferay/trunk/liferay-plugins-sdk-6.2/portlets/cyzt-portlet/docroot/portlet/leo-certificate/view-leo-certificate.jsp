<%@page import="sun.java2d.pipe.SpanShapeRenderer.Simple"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page
	import="com.justonetech.cyzt.leo.service.LEOCertificateLocalServiceUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@page import="com.justonetech.cyzt.leo.model.LEOCertificate"%>
<%@page import="java.util.List"%>
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
<table style="width: 100%;" class="table table-bordered">
	<tr class="body">
		<td style="width: 10%; text-align: right">姓名</td>
		<td style="width: 40%;" class="content">${xm}</td>
		<td style="width: 15%; text-align: right">专业类型</td>
		<td style="width: 35%;" class="content">${zylx}</td>
	</tr>

	<tr class="body">
		<td style="width: 10%; text-align: right">证件编号</td>
		<td class="content">${certificateId}</td>
		<td style="width: 15%; text-align: right">发证日期</td>
		<td style="width: 35%;" class="content"><fmt:formatDate value='${fzrq}' pattern='yyyy-MM-dd' /></td>
	</tr>
	<tr class="body">
		<td style="width: 10%; text-align: right">有效期</td>
		<td class="content"><fmt:formatDate value='${yxq}' pattern='yyyy-MM-dd' /></td>
		<td></td>
		<td></td>
	</tr>
</table>