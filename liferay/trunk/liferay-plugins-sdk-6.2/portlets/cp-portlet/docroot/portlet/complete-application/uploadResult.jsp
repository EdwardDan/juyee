<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<liferay-ui:error key="error-key" message="文件上传仅限于jpg或者pdf格式！" />
<liferay-ui:error key="error-key-2" message="上传的jpg文件超过2M,请压缩后上传！" />
<liferay-ui:error key="error-key-3" message="上传的pdf文件超过20M,请压缩或拆分后上传！" />
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
