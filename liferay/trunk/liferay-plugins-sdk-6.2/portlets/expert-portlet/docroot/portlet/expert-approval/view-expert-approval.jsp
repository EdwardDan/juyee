<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>

<%
	long zysqlbId=ParamUtil.getLong(request, "zysqlbId",0);
	Zysqlb zysqlb=new ZysqlbClp();
	if(zysqlbId!=0){
		zysqlb=ZysqlbLocalServiceUtil.getZysqlb(zysqlbId);
	}
    renderRequest.setAttribute("zysqlb", zysqlb);
    renderRequest.setAttribute("zysqlbId", zysqlbId);
%>
<!--保存审核信息 -->
<portlet:actionURL var="saveAuditInfoURL" name="saveAuditInfo">
	<portlet:param name="zysqlbId" value="${zysqlbId}" />
</portlet:actionURL>

<!-- 审核信息 -->
<aui:form action="${saveAuditInfoURL}" enctype="multipart/form-data" name="fm">

	<table class="table table-bordered">
		<tr style="height:30px;">
			<td class="span12" style="text-align: center;vertical-align:middle;" colspan="2">
			<aui:input type="radio" name="expertStatus" label="加入预备专家库" inlineLabel="true" disabled="true" inlineField="true" value="1" checked="true"></aui:input>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<aui:input type="radio" name="expertStatus" label="加入正式专家库" inlineLabel="true" disabled="true" inlineField="true" value="2"></aui:input>
			</td>
		</tr>

		<tr style="height:60px;">
			<td class="span2" style="text-align: right;vertical-align:middle;">审核意见</td>
			<td class="span10" style="vertical-align:middle;" >
			${zysqlb.shyj}
			</td>
		</tr>



		<tr style="height:60px;">
			<td class="span2" style="text-align: right;vertical-align:middle;">审核人</td>
			<td class="span10" style="vertical-align:middle;">${zysqlb.shr}</td>
		</tr>

		<tr style="height:60px;">
			<td class="span2" style="text-align: right;vertical-align:middle;">审核日期</td>
			<td class="span10" style="vertical-align:middle;">
			<fmt:formatDate value="${zysqlb.shrq}" pattern="yyyy-MM-dd"/>
			</td>
		</tr>

	</table>
	

	<div style="text-align:center">
		<aui:button name="cancel" type="button" value="关闭" />
	</div>
</aui:form>

<!-- For Closing -->
<aui:script use="aui-base">
	A.one('#<portlet:namespace/>cancel').on(
			'click',
			function(event) {	
				var data = '';
				Liferay.Util.getOpener().closeYourPopUp(data,'<portlet:namespace/>dialogView');
	});
</aui:script>