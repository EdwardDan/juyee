<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>

<c:choose>
	<c:when test="${empty assetEntry }">
		<div class="alert alert-info">您想要查看的资源不存在。</div>
	</c:when>
	<c:otherwise>
		<liferay-ui:journal-article articleResourcePrimKey="${assetEntry.classPK}"></liferay-ui:journal-article>
		<div>附件：</div>
		<c:forEach items="${lists}" var="map">
			<portlet:renderURL var="attachmentViewerUrl">
				<%-- <portlet:param name="mvcPath" value="${contextPath}/attachment-viewer/view.jsp" /> --%>
				<portlet:param name="mvcPath" value="${contextPath}/attachment-viewer/pdfjs-view.jsp" />
				<portlet:param name="title" value="${map['dlFileEntry'].title}" />
				<portlet:param name="entryId" value="${map['assetEntry'].entryId}" />
				<portlet:param name="classNameId" value="${map['assetEntry'].classNameId}" />
				<portlet:param name="classPK" value="${map['assetEntry'].classPK}" />
				<portlet:param name="groupId" value="${map['assetEntry'].groupId}" />
				<portlet:param name="folderId" value="${map['dlFileEntry'].folderId}" />
				<portlet:param name="uuid" value="${map['dlFileEntry'].uuid}" />
				<portlet:param name="extension" value="${map['dlFileEntry'].extension}" />
			</portlet:renderURL>
			<a href="${attachmentViewerUrl}">${map['dlFileEntry'].title}</a>
			<br />
		</c:forEach>
	</c:otherwise>
</c:choose>
