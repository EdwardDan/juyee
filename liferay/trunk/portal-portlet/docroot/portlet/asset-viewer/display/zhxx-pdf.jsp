<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<portlet:defineObjects />
<%
	String title = ParamUtil.getString(request, "title","");
	String entryId = ParamUtil.getString(request, "entryId","");
	String classNameId = ParamUtil.getString(request, "classNameId","");
	ClassName className = ClassNameLocalServiceUtil.getClassName(Long.parseLong(classNameId));
	String groupId = ParamUtil.getString(request, "groupId","");
	String folderId = ParamUtil.getString(request, "folderId","");
	String uuid = ParamUtil.getString(request, "uuid","");
	String extension = ParamUtil.getString(request, "extension","");
	String portalUrl = PortalUtil.getPortalURL(request);
	String downLoadUrl = portalUrl+"/documents/"+groupId+"/"+folderId+"/"+title+"/"+uuid;
%>
<c:set var="contextPath" value="${request.contextPath}/portlet" />

<portlet:renderURL var="infoViewerUrl">
	<portlet:param name="mvcPath" value="${contextPath}/asset-viewer/display/zhxx-journalarticle.jsp" />
	<portlet:param name="entryId" value="<%=entryId%>" />
</portlet:renderURL>
<liferay-ui:header backURL="${infoViewerUrl}" localizeTitle="<%=false%>" title="<%=title%>" />
<%--<div class="asset-details-content">
	<span class="download-document"> <span class=""> <a href="<%=downLoadUrl%>" class=" taglib-icon" id="_101_fmzi_null_null"> <img id="fmzi_null_null"
				src="<%=portalUrl%>/html/themes/classic/images/spacer.png" alt=""
				style="background-image: url('<%=portalUrl%>/sprite/html/themes/classic/images/common/_sprite.png'); background-position: 50% -560px; background-repeat: no-repeat; height: 16px; width: 16px;">
				<span class="taglib-text ">下载原件</span>
		</a>
	</span> <c:if test="<%=check%>"></span> <span class="conversions"> <span class=""> <a href="<%=downLoadUrl%>?targetExtension=csv" class=" taglib-icon" id="_101_mefv_null_null"> <img
				id="mefv_null_null" src="<%=portalUrl%>/html/themes/classic/images/spacer.png" alt=""
				style="background-image: url('<%=portalUrl%>/sprite/html/themes/classic/images/file_system/small/_sprite.png'); background-position: 50% -32px; background-repeat: no-repeat; height: 16px; width: 16px;">
				<span class="taglib-text ">CSV</span>
		</a>
	</span> <span class=""> <a href="<%=downLoadUrl%>?targetExtension=ods" class=" taglib-icon" id="_101_zyuh_null_null"> <img id="zyuh_null_null"
				src="<%=portalUrl%>/html/themes/classic/images/file_system/small/ods.png" alt=""> <span class="taglib-text ">ODS</span>
		</a>
	</span>  <span class=""> <a href="<%=downLoadUrl%>?targetExtension=pdf" class=" taglib-icon" id="_101_ozlt_null_null"> <img id="ozlt_null_null"
				src="<%=portalUrl%>/html/themes/classic/images/spacer.png" alt=""
				style="background-image: url('<%=portalUrl%>/sprite/html/themes/classic/images/file_system/small/_sprite.png'); background-position: 50% -272px; background-repeat: no-repeat; height: 16px; width: 16px;">
				<span class="taglib-text ">PDF</span>
		</a>
	</span>  <span class=""> <a href="<%=downLoadUrl%>?targetExtension=sxc" class=" taglib-icon" id="_101_rpwo_null_null"> <img id="rpwo_null_null"
				src="<%=portalUrl%>/html/themes/classic/images/file_system/small/sxc.png" alt=""> <span class="taglib-text ">SXC</span>
		</a>
	</span> <span class=""> <a href="<%=downLoadUrl%>?targetExtension=tsv" class=" taglib-icon" id="_101_bhfa_null_null"> <img id="bhfa_null_null"
				src="<%=portalUrl%>/html/themes/classic/images/spacer.png" alt=""
				style="background-image: url('<%=portalUrl%>/sprite/html/themes/classic/images/file_system/small/_sprite.png'); background-position: 50% -416px; background-repeat: no-repeat; height: 16px; width: 16px;">
				<span class="taglib-text ">TSV</span>
		</a>
	</span> <span class=""> <a href="<%=downLoadUrl%>?targetExtension=xls" class=" taglib-icon" id="_101_bqvz_null_null"> <img id="bqvz_null_null"
				src="<%=portalUrl%>/html/themes/classic/images/spacer.png" alt=""
				style="background-image: url('<%=portalUrl%>/sprite/html/themes/classic/images/file_system/small/_sprite.png'); background-position: 50% -464px; background-repeat: no-repeat; height: 16px; width: 16px;">
				<span class="taglib-text ">XLS</span>
		</a>
	</span> </c:if>
</div>--%>
<%
	String url = "";
if(extension.equals("pdf")){
	url=HtmlUtil.escapeURL(downLoadUrl+"");
}else{
	url=HtmlUtil.escapeURL(downLoadUrl+"?targetExtension=pdf");
}
if(extension.equals("pdf")||extension.equals("doc")||extension.equals("docx")){
%>

<iframe src="/static/pdf/web/viewer.html?file=<%=url%>" width="98%" height="800px" scrolling="auto" frameborder="0" style="position: relative; left: 1%"> </iframe>

<%
	}
%>

