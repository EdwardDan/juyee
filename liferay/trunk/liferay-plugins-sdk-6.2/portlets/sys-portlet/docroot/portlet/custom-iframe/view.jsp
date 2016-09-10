<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:choose>
	<c:when test="${empty src }">
		<div class="alert alert-warning">请配置源URL</div>
	</c:when>
	<c:otherwise>
		<iframe src="${src }" height="${height }" width="100%" frameborder="no"></iframe>
	</c:otherwise>
</c:choose>