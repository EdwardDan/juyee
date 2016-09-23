<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%><html>
<%
	String completeId=ParamUtil.getString(request,"completeId");
request.setAttribute("completeId", completeId);
Complete complete=CompleteLocalServiceUtil.getComplete(Long.parseLong(completeId));
request.setAttribute("complete",complete);
CompleteProjectProfile completeProjectProfile=CompleteProjectProfileLocalServiceUtil.getCompleteProjectProfile(Long.parseLong(completeId));
if(completeProjectProfile.getLxjb().equals("区县级机关或区县级单位")){
	request.setAttribute("lxjb",0 );
}else{
	request.setAttribute("lxjb", 1);
}
User me = PortalUtil.getUser(request);
List<Role> userRoles = RoleLocalServiceUtil.getUserRoles(me
		.getUserId());
ArrayList<String> roles = new ArrayList<String>();
for (Role role : userRoles) {
	roles.add(role.getName() + "");
}
request.setAttribute("roles", roles.toString());
%>
<portlet:actionURL var="saveCompleteURL" name="saveComplete">
	<portlet:param name="completeId" value="${completeId}" />
</portlet:actionURL>
<aui:form action="${saveCompleteURL}" method="post">
	<c:if test="${(complete.status==2&&fn:contains(roles,'市竣工备案审核'))||(complete.status==2&&fn:contains(roles,'区竣工备案审核')&&lxjb==0)}">
	<aui:input name="status" value="3" id="status" type="hidden" />
	 <div class="text-center">
		审核意见：
		<textarea rows="3" name="<portlet:namespace/>shyj"  style="width: 70%; margin-bottom: 15px; margin-top: 15px"></textarea>
	</div> 
	</c:if>
	<c:if test="${(complete.status==3)||(complete.status==2&&!fn:contains(roles,'竣工备案审核'))||(complete.status==2&&fn:contains(roles,'区竣工备案审核')&&lxjb==1)}">
	<div class="text-center">
		审核意见：
		<td class="text-left">${complete.shyj}</td>
	</div>
	</c:if>
	
	<div class="text-center">
	<div class="btn-group">
		<aui:button-row>
		<c:if test="${complete.status==2&&fn:contains(roles,'竣工备案审核')}">
			<aui:button name="pass" type="submit" 
				value="审核通过" cssClass="btn btn-primary" />
				</c:if>
				<aui:button name="close" value="关闭" cssClass="btn" href="${viewURL}" />
		</aui:button-row>
	</div>
</div>
</aui:form>
