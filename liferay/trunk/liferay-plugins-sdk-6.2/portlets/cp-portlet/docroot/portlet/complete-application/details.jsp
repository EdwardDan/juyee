<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<p style="text-align:center;"><h3>${materialName}${upLoadMessage}</h3></p>
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
