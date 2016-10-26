<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<%-- <%@page import="com.liferay.portlet.documentlibrary.DuplicateFileException" %>
<%@page import="com.liferay.portlet.documentlibrary.DuplicateFolderNameException" %>
<%@page import="com.liferay.portlet.documentlibrary.FileExtensionException" %>
<%@page import="com.liferay.portlet.documentlibrary.FileMimeTypeException" %>
<%@page import="com.liferay.portlet.documentlibrary.FileNameException" %>
<%@page import="com.liferay.portlet.documentlibrary.NoSuchFolderException" %>
<%@page import="com.liferay.portlet.documentlibrary.SourceFileNameException" %>

<%@page import="com.liferay.portlet.documentlibrary.util.DLUtil" %> --%>
<%@page import="com.liferay.portlet.documentlibrary.FileSizeException" %>
<%
	String uploadProgressId = "dlFileEntryUploadProgress";
	long fileMaxSize = PrefsPropsUtil.getLong(PropsKeys.DL_FILE_MAX_SIZE);
	if (fileMaxSize == 0) {
		fileMaxSize = PrefsPropsUtil.getLong(PropsKeys.UPLOAD_SERVLET_REQUEST_IMPL_MAX_SIZE);
	}
	  fileMaxSize /= 1024*1024; 
%>
<liferay-ui:error exception="<%= FileSizeException.class %>">
		<liferay-ui:message arguments="<%= fileMaxSize %>" key="please-enter-a-file-with-a-valid-file-size-no-larger-than-x" />
	</liferay-ui:error>
	<liferay-ui:asset-categories-error />

	<liferay-ui:asset-tags-error />
<%-- <liferay-ui:error exception="<%= DuplicateFileException.class %>" message="please-enter-a-unique-document-name" />
	<liferay-ui:error exception="<%= DuplicateFolderNameException.class %>" message="please-enter-a-unique-document-name" />

	<liferay-ui:error exception="<%= FileExtensionException.class %>">
		<liferay-ui:message key="document-names-must-end-with-one-of-the-following-extensions" /> <%= StringUtil.merge(PrefsPropsUtil.getStringArray(PropsKeys.DL_FILE_EXTENSIONS, StringPool.COMMA), StringPool.COMMA_AND_SPACE) %>.
	</liferay-ui:error>

	<liferay-ui:error exception="<%= FileMimeTypeException.class %>">
		<liferay-ui:message key="media-files-must-be-one-of-the-following-formats" /> <%= StringUtil.merge(DLUtil.getMediaGalleryMimeTypes(portletPreferences, renderRequest), StringPool.COMMA_AND_SPACE) %>.
	</liferay-ui:error>

	<liferay-ui:error exception="<%= FileNameException.class %>" message="please-enter-a-file-with-a-valid-file-name" />
	<liferay-ui:error exception="<%= NoSuchFolderException.class %>" message="please-enter-a-valid-folder" />

	<liferay-ui:error exception="<%= SourceFileNameException.class %>">
		<liferay-ui:message key="the-source-file-does-not-have-the-same-extension-as-the-original-file" />
	</liferay-ui:error>
<liferay-ui:error exception="<%= FileSizeException.class %>">
		<liferay-ui:message arguments="<%= fileMaxSize %>" key="please-enter-a-file-with-a-valid-file-size-no-larger-than-x" />
	</liferay-ui:error> --%>
<portlet:renderURL var="viewURL">
<portlet:param name="path" value="details" /> 
</portlet:renderURL>

<portlet:actionURL name="addDLFileEntry" var="addDLFileEntryURL">
	<portlet:param name="divNo" value="${divNo}" />
	<portlet:param name="no" value="${no}" />
	<portlet:param name="materialId" value="${materialId}" />
</portlet:actionURL>

<aui:form action="<%=addDLFileEntryURL%>" enctype="multipart/form-data"
	name="fm">
		<aui:field-wrapper>
			<c:if test="<%=fileMaxSize != 0%>">
				<div class="alert alert-info">
					<%="PDF文件大小不能超过"+String.valueOf(fileMaxSize)+"MB,JPG文件大小不能超过2MB"%>
				</div>
			</c:if>
		</aui:field-wrapper>
		<aui:input type="file" name="file" style="width: auto;">
			<aui:validator name="required" />
		</aui:input>
	<aui:button-row>
		<aui:button type="submit" value="上传"
			onClick='<%= renderResponse.getNamespace() + "saveFileEntry();" %>'></aui:button>
		<aui:button name="cancel" type="button" value="关闭" />
	</aui:button-row>
</aui:form>
<liferay-ui:upload-progress id="<%=uploadProgressId%>"
	message="uploading" redirect="<%=viewURL%>" />

<aui:script>
function <portlet:namespace />saveFileEntry() {
	<%= HtmlUtil.escape(uploadProgressId) %>.startProgress();
	submitForm(document.<portlet:namespace />fm); 
}
</aui:script>

<!-- For Closing -->
<aui:script use="aui-base">
	A.one('#<portlet:namespace/>cancel').on(
			'click',
			function(event) {	
				var data = '';
				Liferay.Util.getOpener().<portlet:namespace/>closeYourPopUp(
						data, '<portlet:namespace/>dialog');
			});

	
</aui:script>