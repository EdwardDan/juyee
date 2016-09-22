<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<liferay-ui:header title="施工许可申请查看" backURL="${viewURL }" />
<liferay-ui:tabs names="工程概况,参建单位,单位工程,申请材料" refresh="false">
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-permit/projectprofile.jsp" />
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-permit/participationunits.jsp" />
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-permit/unitprojects.jsp" />
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-permit/applymaterials.jsp" />
	</liferay-ui:section>
</liferay-ui:tabs>
<br>
<%
	Long permitId = ParamUtil.getLong(request, "permitId");
	Permit permit = PermitLocalServiceUtil.getPermit(permitId);
	ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
	int status = permit.getStatus();
	request.setAttribute("permitId", permitId);
%>
<aui:button-row cssClass="text-center">
	<portlet:renderURL var="printsjpzURL" windowState="pop_up">
		<portlet:param name="mvcPath" value="${contextPath}/print/sjpz.jsp" />
		<portlet:param name="permitId" value="${permitId}" />
	</portlet:renderURL>
	<portlet:renderURL var="printsltzsURL" windowState="pop_up">
		<portlet:param name="mvcPath" value="${contextPath}/print/sltzs.jsp" />
		<portlet:param name="permitId" value="${permitId}" />
	</portlet:renderURL>
	<portlet:renderURL var="printbysljdsURL" windowState="pop_up">
		<portlet:param name="mvcPath" value="${contextPath}/print/bysljds.jsp" />
		<portlet:param name="permitId" value="${permitId}" />
	</portlet:renderURL>
	<portlet:renderURL var="printbzclURL" windowState="pop_up">
		<portlet:param name="mvcPath" value="${contextPath}/print/bzcl.jsp" />
		<portlet:param name="permitId" value="${permitId}" />
	</portlet:renderURL>
	<portlet:renderURL var="printjsscbURL" windowState="pop_up">
		<portlet:param name="mvcPath" value="${contextPath}/print/jsscb.jsp" />
		<portlet:param name="permitId" value="${permitId}" />
	</portlet:renderURL>
	<portlet:actionURL var="printsgxkURL" name="sgxk"> 
		<portlet:param name="permitId" value="${permitId}" />
	</portlet:actionURL>
	<portlet:actionURL var="printsgxklsURL" name="sgxkls"> 
		<portlet:param name="permitId" value="${permitId}" />
	</portlet:actionURL>
	<c:if test="<%=!projectProfile.getLxjb().equals(\"区县级机关或区县级单位\")%>">
	<a class="btn" href="${printsgxkURL}">施工许可</a>
	<a class="btn" href="${printsgxklsURL}" target="_blank">施工许可(绿色)</a>
		<c:if test="<%=status >= 5%>">
			<a class="btn" href="${printsjpzURL}" target="_blank">收件凭证</a>
		</c:if>
		<c:if test="<%=status >= 9%>">
			<a class="btn" href="${printsltzsURL}" target="_blank">受理通知书</a>
		</c:if>
		<c:if test="<%=status == 10%>">
			<a class="btn" href="${printbysljdsURL}" target="_blank">不予受理决定书</a>
		</c:if>
		<c:if test="<%=status==23%>">
			<a class="btn" href="${printbzclURL}" target="_blank">补正材料</a>
		</c:if>
		<c:if
			test="<%=status == CityPermitStatus.STATUS_WLD_PASS.getCode()%>">
			<a class="btn" href="${printjsscbURL}" target="_blank">技术审查表</a>
			<c:choose>
				<c:when test="<%=projectProfile.getXmlx() == 29741%>">
					<a class="btn" href="" target="_blank">开工备案</a>
				</c:when>
				<c:otherwise>
					<c:if test="<%=projectProfile.getXmxz() != 29769%>">
						<a class="btn" href="${printsgxklszsURL}" target="_blank">施工许可(绿色)</a>
					</c:if>
					<c:if test="<%=projectProfile.getXmxz() == 29769%>">
						<a class="btn" href="${printsgxkURL}">施工许可</a>
					</c:if>
				</c:otherwise>
			</c:choose>
		</c:if>
		<c:if test="<%=status == CityPermitStatus.STATUS_WLD_BACK.getCode()%>">
			<a class="btn" href="" target="_blank">不予许可通知书</a>
		</c:if>
	</c:if>
	<c:if test="<%=projectProfile.getLxjb().equals(\"区县级机关或区县级单位\")%>">
		<c:if
			test="<%=status >=3%>">
			<a class="btn" href="${printsjpzURL}" target="_blank">收件凭证</a>
		</c:if>
		<c:if
			test="<%=status == CountyPermitStatus.STATUS_SP_PASS.getCode()
								|| status == CountyPermitStatus.STATUS_SP_BACK.getCode()%>">
			<a class="btn" href="${printsltzsURL}" target="_blank">受理通知书</a>
		</c:if>
		<c:if test="<%=status==8%>">
			<a class="btn" href="${printbysljdsURL}" target="_blank">不予受理决定书</a>
		</c:if>
		<c:if test="<%=status==9%>">
			<a class="btn" href="${printbzclURL}" target="_blank">补正材料</a>
		</c:if>
		<c:if
			test="<%=status == CountyPermitStatus.STATUS_SP_PASS.getCode()%>">
			<c:choose>
				<c:when test="<%=projectProfile.getXmlx() == 29741%>">
					<a class="btn" href="" target="_blank">开工备案</a>
				</c:when>
				<c:otherwise>
					<a class="btn" href="${printsgxkURL}">施工许可</a>
				</c:otherwise>
			</c:choose>
		</c:if>
	</c:if>
</aui:button-row>