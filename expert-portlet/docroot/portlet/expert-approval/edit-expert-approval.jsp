<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ page import="com.liferay.portal.model.User" %>
<style>
.aui .table th, .aui .table td {
	vertical-align: middle;
	padding: 8px;
	line-height:50px;
}
.aui input[type="color"], .aui input[type="date"], .aui input[type="datetime"], .aui input[type="datetime-local"], .aui input[type="email"], .aui input[type="month"], .aui input[type="number"], .aui input[type="password"], .aui input[type="search"], .aui input[type="tel"], .aui input[type="text"], .aui input[type="time"], .aui input[type="url"], .aui input[type="week"], .aui select, .aui textarea, .aui .input-prepend .add-on, .aui .navbar-search .search-query, .aui .uneditable-input
 {
 font-size:15px;
 }
 .aui .control-group{
 margin-bottom:0px;
 }
</style>

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
			<td class="span12" style="text-align: center;vertical-align:middle;" colspan="2">
			<aui:input type="radio" name="expertStatus" label="加入预备专家库" inlineLabel="right" inlineField="true" value="preExpert" checked="<%=zysqlb.getZt()==1?true:(zysqlb.getZt()==2)%>"></aui:input>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<aui:input type="radio" name="expertStatus" label="加入正式专家库" inlineLabel="right" inlineField="true" value="fomalExpert" checked="<%=(zysqlb.getZt()==3)%>"></aui:input>
			</td>
		</tr>

		<tr>
			<td class="span2" style="text-align: right;vertical-align:middle;" >审核意见</td>
			<td class="span10" style="vertical-align:middle;">
			<aui:input type="textarea" label="" name="shyj" value="${zysqlb.shyj}"
					cssClass="span8" >
		</aui:input>		
			</td>
		</tr>



		<tr>
			<td class="span2" style="text-align: right;vertical-align:middle;height:30px;">审核人</td>
			<td class="span10" style="vertical-align:middle;"><aui:input type="text" label="" name="shr"
					cssClass="span8" value='<%=zysqlb.getShr()==""?user.getScreenName():zysqlb.getShr() %>'>
				</aui:input></td>
		</tr>

		<tr>
			<td class="span2" style="text-align: right;vertical-align:middle;height:30px;">审核日期</td>
			<td class="span10" style="vertical-align:middle;">
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
	A.one('#<portlet:namespace/>cancel').on(
			'click',
			function(event) {	
				var data = 'cancel';
				Liferay.Util.getOpener().closeYourPopUp(data,'<portlet:namespace/>dialogEdit');
			}); 
</aui:script>