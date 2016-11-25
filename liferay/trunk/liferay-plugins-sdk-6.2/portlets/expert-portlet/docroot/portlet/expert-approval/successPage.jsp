<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>



<div style="text-align:center">
		<aui:button name="cancel" type="button" value="关闭" />
	</div>
<aui:script use="aui-base">

	A.one('#<portlet:namespace/>cancel').on(
			'click',
			function(event) {	
				var data = 'success';
				Liferay.Util.getOpener().closeYourPopUp(data,'<portlet:namespace/>dialogEdit');
			});  
</aui:script>