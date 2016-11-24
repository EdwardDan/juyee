<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/portlet/common/init.jsp"%>
<portlet:renderURL var="viewURL"/>
${data}
<aui:button-row cssClass="text-center">
	<aui:button value="返回" href="${viewURL }" ></aui:button>
</aui:button-row>
