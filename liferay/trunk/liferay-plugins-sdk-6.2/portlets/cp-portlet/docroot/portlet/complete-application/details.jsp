<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<%@page import="com.liferay.portlet.documentlibrary.DuplicateFileException" %>
<%@page import="com.liferay.portlet.documentlibrary.DuplicateFolderNameException" %>
<%@page import="com.liferay.portlet.documentlibrary.FileExtensionException" %>
<%@page import="com.liferay.portlet.documentlibrary.FileMimeTypeException" %>
<%@page import="com.liferay.portlet.documentlibrary.FileNameException" %>
<%@page import="com.liferay.portlet.documentlibrary.NoSuchFolderException" %>
<%@page import="com.liferay.portlet.documentlibrary.SourceFileNameException" %>
<%@page import="com.liferay.portlet.documentlibrary.FileSizeException" %>
<%@page import="com.liferay.portlet.documentlibrary.util.DLUtil" %>
<h3>${materialName}${upLoadMessage}</h3>
<br>
<aui:button name="cancel" type="button" value="关闭" />
<aui:script use="aui-base">
	A.one('#<portlet:namespace/>cancel').on(
			'click',
			function(event) {
				var data = '${materialId}/${materialName}/${divNo}/${fileExtension}/${fieId}/${no}';
				
				Liferay.Util.getOpener().<portlet:namespace/>closeYourPopUp(
						data, '<portlet:namespace/>dialog');
			});

	
</aui:script>
