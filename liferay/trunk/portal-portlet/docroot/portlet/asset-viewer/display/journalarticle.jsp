<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:choose>
	<c:when test="${empty assetEntry }">
		<div class="alert alert-info">您想要查看的资源不存在。</div>
	</c:when>
	<c:otherwise>
		<liferay-ui:journal-article articleResourcePrimKey="${assetEntry.classPK}"></liferay-ui:journal-article>
		<liferay-ui:asset-links
			className="<%=JournalArticle.class.getName()%>"
			classPK="${assetEntry.classPK}" />
	</c:otherwise>
</c:choose>
