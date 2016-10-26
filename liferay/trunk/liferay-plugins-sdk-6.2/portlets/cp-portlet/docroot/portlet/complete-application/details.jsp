<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<h3>${materialName}上传成功！</h3>
<br>
<aui:button name="cancel" type="button" value="关闭" />
<aui:script use="aui-base">
	A.one('#<portlet:namespace/>cancel').on(
			'click',
			function(event) {
				var data = '${materialId}/${materialName}/${divNo}/${fileExtension}/${fieId}';
				
				Liferay.Util.getOpener().<portlet:namespace/>closeYourPopUp(
						data, '<portlet:namespace/>dialog');
			});

	
</aui:script>
