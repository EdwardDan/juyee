<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>

<iframe
	src="${reportServerURL}?reportlet=jtjs%2Fleader-weekly-work.cpt&op=write&groupId=${scopeGroupId}&roleId=${roleId}&userId=${user.userId}"
	width="100%" height="800" frameborder="no"></iframe>



