<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/permit-approval/approval-history-city" />
<portlet:renderURL var="ysURL">
	<portlet:param name="mvcPath" value="${contextPath}/ys.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="sjURL">
	<portlet:param name="mvcPath" value="${contextPath}/sj.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="csURL">
	<portlet:param name="mvcPath" value="${contextPath}/cs.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="fhURL">
	<portlet:param name="mvcPath" value="${contextPath}/fh.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="shURL">
	<portlet:param name="mvcPath" value="${contextPath}/sh.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="fgldshURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/fgldsh.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="zxldshURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/zxldsh.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="wjscshURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/wjscsh.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="wspcshURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/wspcsh.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="wldshURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/wldsh.jsp"/>
</portlet:renderURL>
历史审核步骤
<table border="1" style="width: 100%；text-align:center;">
	<tr>
		<td>审核步骤</td>
		<td>审核意见</td>
		<td>审核人</td>
		<td>审核时间</td>
	</tr>
	<tr>
		<td><a href="${ysURL}">预审</a></td> 
		<td><a href="${ysURL}"></a></td>
		<td><a href="${ysURL}"></a></td>
		<td><a href="${ysURL}"></a></td>
	</tr>
	<tr>
		<td><a href="${sjURL}">收件</a></td>
		<td><a href="${sjURL}"></a></td>
		<td><a href="${sjURL}"></a></td>
		<td><a href="${sjURL}"></a></td>
	</tr>
	<tr>
		<td><a href="${csURL}">初审</a></td>
		<td><a href="${csURL}"></a></td>
		<td><a href="${csURL}"></a></td>
		<td><a href="${csURL}"></a></td>
	</tr>
	<tr>
		<td><a href="${fhURL}">复核</a></td>
		<td><a href="${fhURL}"></a></td>
		<td><a href="${fhURL}"></a></td>
		<td><a href="${fhURL}"></a></td>
	</tr>
	<tr>
		<td><a href="${shURL}">审核</a></td>
		<td><a href="${shURL}"></a></td>
		<td><a href="${shURL}"></a></td>
		<td><a href="${shURL}"></a></td>
	</tr>
	<tr>
		<td><a href="${fgldshURL}">分管领导审核</a></td>
		<td><a href="${fgldshURL}"></a></td>
		<td><a href="${fgldshURL}"></a></td>
		<td><a href="${fgldshURL}"></a></td>
	</tr>
	<tr>
		<td><a href="${zxldshURL}">中心领导审核</a></td>
		<td><a href="${zxldshURL}"></a></td>
		<td><a href="${zxldshURL}"></a></td>
		<td><a href="${zxldshURL}"></a></td>
	</tr>
	<tr>
		<td><a href="${wjscshURL}">委建设处审核</a></td>
		<td><a href="${wjscshURL}"></a></td>
		<td><a href="${wjscshURL}"></a></td>
		<td><a href="${wjscshURL}"></a></td>
	</tr>
	<tr>
		<td><a href="${wspcshURL}">委审批处审核</a></td>
		<td><a href="${wspcshURL}"></a></td>
		<td><a href="${wspcshURL}"></a></td>
		<td><a href="${wspcshURL}"></a></td>
	</tr>
	<tr>
		<td><a href="${wldshURL}">委领导审核</a></td>
		<td><a href="${wldshURL}"></a></td>
		<td><a href="${wldshURL}"></a></td>
		<td><a href="${wldshURL}"></a></td>
	</tr>
</table>