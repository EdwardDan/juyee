<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ page import="com.justonetech.expert.service.ZysqlbLocalServiceUtil" %>
<%@ page import="com.justonetech.expert.model.Zysqlb" %>
<%@ page import="com.justonetech.expert.model.ZysqlbClp" %>
<%
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	long zysqlbId=ParamUtil.getLong(request, "zysqlbId",0);
	Zysqlb zysqlb=new ZysqlbClp();
	if(zysqlbId!=0){
		zysqlb=ZysqlbLocalServiceUtil.getZysqlb(zysqlbId);
	}
    renderRequest.setAttribute("zysqlb", zysqlb);
    renderRequest.setAttribute("zysqlbId", zysqlbId);
    String todayString= sf.format(new Date());
%>
<!--保存审核信息 -->
<portlet:actionURL var="saveAuditInfoURL" name="saveAuditInfo">
	<portlet:param name="zysqlbId" value="${zysqlbId}" />
</portlet:actionURL>

<!-- 审核信息 -->
<aui:form action="${saveAuditInfoURL}" enctype="multipart/form-data" name="fm">

	<table class="table table-bordered">
		<tr >
			<td class="span12" style="text-align: center;" colspan="2">
			<aui:input type="radio" name="expertStatus" label="加入预备专家库" inlineLabel="right" inlineField="true" value="preExpert" checked="true"></aui:input>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<aui:input type="radio" name="expertStatus" label="加入正式专家库" inlineLabel="right" inlineField="true" value="fomalExpert"></aui:input>
			</td>
		</tr>

		<tr>
			<td class="span2" style="text-align: right;">审核意见</td>
			<td class="span10" >
			<aui:input type="textarea" label="" name="shyj" value="${zysqlb.shyj}"
					cssClass="span8" >
		</aui:input>		
			</td>
		</tr>



		<tr>
			<td class="span2" style="text-align: right;">审核人</td>
			<td class="span10"><aui:input type="text" label="" name="shr"
					cssClass="span8" value="${zysqlb.shr}">
				</aui:input></td>
		</tr>

		<tr>
			<td class="span2" style="text-align: right;">审核日期</td>
			<td class="span10">
			<aui:input  label="" name="shrq"
					cssClass="span8" value="<%=zysqlb.getShrq() == null ? todayString : sf.format(zysqlb.getShrq())%>" onfocus="WdatePicker({lang:'zh-cn'})">
			</aui:input>
			</td>
		</tr>

	</table>
	

	<div style="text-align:center">
		<aui:button name="submit" type="submit" value="确定"/>
		<aui:button name="cancel" type="button" value="取消" />
	</div>
</aui:form>




<!-- For Closing -->
<aui:script use="aui-base">
	A.one('#<portlet:namespace/>submit').on(
		'click',
		function(event) {	
			var data = '';
			Liferay.Util.getOpener().closeYourPopUp('<portlet:namespace/>dialogEdit');
		}); 
	A.one('#<portlet:namespace/>cancel').on(
			'click',
			function(event) {	
				var data = '';
				Liferay.Util.getOpener().closeYourPopUp('<portlet:namespace/>dialogEdit');
			});
</aui:script>