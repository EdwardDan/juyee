<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%><html>
<%
	String completeId=ParamUtil.getString(request,"completeId");
request.setAttribute("completeId", completeId);
System.out.println("aaa111"+completeId);
Complete complete=CompleteLocalServiceUtil.getComplete(Long.parseLong(completeId));
System.out.println("aaa"+complete);
request.setAttribute("complete",complete);
%>
<portlet:actionURL var="saveCompleteURL" name="saveComplete">
	<portlet:param name="completeId" value="${completeId}" />
</portlet:actionURL>
<aui:form action="${saveCompleteURL}" method="post">
	<c:if test="${complete.status==2}">
	<aui:input name="status" value="3" id="status" type="hidden" />
	 <div class="text-center">
		审核意见：
		<textarea rows="3" name="<portlet:namespace/>shyj"  style="width: 70%; margin-bottom: 15px; margin-top: 15px"></textarea>
	</div> 
	</c:if>
	<c:if test="${complete.status==3}">
	<div class="text-center">
		审核意见：
		<td class="text-left">${complete.shyj}</td>
	</div>
	</c:if>
	
	<div class="text-center">
	<div class="btn-group">
		<aui:button-row>
		<c:if test="${complete.status==2}">
			<aui:button name="pass" type="submit" 
				value="审核通过" cssClass="btn btn-primary" />
				</c:if>
				<aui:button name="close" value="关闭" cssClass="btn" href="${viewURL}" />
		</aui:button-row>
	</div>
</div>
</aui:form>
