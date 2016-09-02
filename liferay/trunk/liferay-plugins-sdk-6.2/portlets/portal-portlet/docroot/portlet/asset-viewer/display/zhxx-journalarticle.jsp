<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contextPath" value="${request.contextPath}/portlet" />

<%
	String portalUrl = PortalUtil.getPortalURL(request);
%>
<c:choose>
	<c:when test="${empty assetEntry }">
		<div class="alert alert-info">您想要查看的资源不存在。</div>
	</c:when>
	<c:otherwise>
		<liferay-ui:journal-article articleResourcePrimKey="${assetEntry.classPK}"></liferay-ui:journal-article>
		<c:if test="${listsSize>0}">
			<div>附件：</div>
		</c:if>
		<c:forEach items="${lists}" var="map">

			<c:if test="${map['dlFileEntry'].extension=='pdf'}">
				<portlet:renderURL var="zhxxPdfUrl">
					<portlet:param name="mvcPath" value="${contextPath}/asset-viewer/display/zhxx-pdf.jsp" />
					<portlet:param name="title" value="${map['dlFileEntry'].title}" />
					<portlet:param name="entryId" value="${entryId}" />
					<portlet:param name="classNameId" value="${map['assetEntry'].classNameId}" />
					<portlet:param name="classPK" value="${map['assetEntry'].classPK}" />
					<portlet:param name="groupId" value="${map['assetEntry'].groupId}" />
					<portlet:param name="folderId" value="${map['dlFileEntry'].folderId}" />
					<portlet:param name="uuid" value="${map['dlFileEntry'].uuid}" />
					<portlet:param name="extension" value="${map['dlFileEntry'].extension}" />
				</portlet:renderURL>
				<a href="${zhxxPdfUrl}">${map['dlFileEntry'].title}</a>
				<br>
				<br />
			</c:if>
			<c:if test="${map['dlFileEntry'].extension!='pdf'}">
				<a href="<%=portalUrl%>/documents/${map['assetEntry'].groupId}/${map['dlFileEntry'].folderId}/${map['dlFileEntry'].title}/${map['dlFileEntry'].uuid}">${map['dlFileEntry'].title}</a>
				<br>
			</c:if>

		</c:forEach>
	</c:otherwise>
</c:choose>
