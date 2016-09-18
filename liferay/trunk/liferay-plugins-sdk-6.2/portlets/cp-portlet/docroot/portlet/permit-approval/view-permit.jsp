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
	<portlet:renderURL var="printsgxklszsURL" windowState="pop_up">
		<portlet:param name="mvcPath"
			value="${contextPath}/print/sgxklszs.jsp" />
	</portlet:renderURL>
	<c:if
		test="<%=status != CityPermitStatus.STATUS_WZ.getCode()
							&& status != CityPermitStatus.STATUS_EDIT.getCode()
							&& status != CityPermitStatus.STATUS_SB.getCode()
							&& status != CityPermitStatus.STATUS_YS_PASS.getCode()
							&& status != CityPermitStatus.STATUS_YS_BACK.getCode()%>">
		<a class="btn" href="${printsjpzURL}" target="_blank">收件凭证</a>
	</c:if>
	<c:if
		test="<%=status == CityPermitStatus.STATUS_SH_PASS.getCode()
							|| status == CityPermitStatus.STATUS_SH_BACK.getCode()
							|| status == CityPermitStatus.STATUS_FGLD_PASS.getCode()
							|| status == CityPermitStatus.STATUS_FGLD_BACK.getCode()
							|| status == CityPermitStatus.STATUS_ZXLD_PASS.getCode()
							|| status == CityPermitStatus.STATUS_ZXLD_BACK.getCode()
							|| status == CityPermitStatus.STATUS_JSC_XK.getCode()
							|| status == CityPermitStatus.STATUS_JSC_BXK.getCode()
							|| status == CityPermitStatus.STATUS_JSC_BACK.getCode()
							|| status == CityPermitStatus.STATUS_SPC_XK.getCode()
							|| status == CityPermitStatus.STATUS_SPC_BXK.getCode()
							|| status == CityPermitStatus.STATUS_SPC_BACK.getCode()
							|| status == CityPermitStatus.STATUS_WLD_PASS.getCode()
							|| status == CityPermitStatus.STATUS_WLD_BACK.getCode()%>">
		<a class="btn" href="${printsltzsURL}" target="_blank">受理通知书</a>
	</c:if>
	<c:if
		test="<%=status == CityPermitStatus.STATUS_SH_PASS.getCode()
							|| status == CityPermitStatus.STATUS_SH_BACK.getCode()
							|| status == CityPermitStatus.STATUS_FGLD_PASS.getCode()
							|| status == CityPermitStatus.STATUS_FGLD_BACK.getCode()
							|| status == CityPermitStatus.STATUS_ZXLD_PASS.getCode()
							|| status == CityPermitStatus.STATUS_ZXLD_BACK.getCode()
							|| status == CityPermitStatus.STATUS_JSC_XK.getCode()
							|| status == CityPermitStatus.STATUS_JSC_BXK.getCode()
							|| status == CityPermitStatus.STATUS_JSC_BACK.getCode()
							|| status == CityPermitStatus.STATUS_SPC_XK.getCode()
							|| status == CityPermitStatus.STATUS_SPC_BXK.getCode()
							|| status == CityPermitStatus.STATUS_SPC_BACK.getCode()
							|| status == CityPermitStatus.STATUS_WLD_PASS.getCode()
							|| status == CityPermitStatus.STATUS_WLD_BACK.getCode()%>">
		<a class="btn" href="${printbysljdsURL}" target="_blank">不予受理决定书</a>
	</c:if>
	<c:if
		test="<%=status == CityPermitStatus.STATUS_SH_PASS.getCode()
							|| status == CityPermitStatus.STATUS_SH_BACK.getCode()
							|| status == CityPermitStatus.STATUS_FGLD_PASS.getCode()
							|| status == CityPermitStatus.STATUS_FGLD_BACK.getCode()
							|| status == CityPermitStatus.STATUS_ZXLD_PASS.getCode()
							|| status == CityPermitStatus.STATUS_JSC_XK.getCode()
							|| status == CityPermitStatus.STATUS_JSC_BXK.getCode()
							|| status == CityPermitStatus.STATUS_JSC_BACK.getCode()
							|| status == CityPermitStatus.STATUS_SPC_XK.getCode()
							|| status == CityPermitStatus.STATUS_SPC_BXK.getCode()
							|| status == CityPermitStatus.STATUS_SPC_BACK.getCode()
							|| status == CityPermitStatus.STATUS_WLD_PASS.getCode()
							|| status == CityPermitStatus.STATUS_WLD_BACK.getCode()%>">
		<a class="btn" href="${printbzclURL}" target="_blank">补正材料</a>
	</c:if>
	<c:if
		test="<%=status == CityPermitStatus.STATUS_ZXLD_PASS.getCode()
							|| status == CityPermitStatus.STATUS_WLD_PASS.getCode()%>">
		<a class="btn" href="" target="_blank">开工备案</a>
		<a class="btn" href="${printjsscbURL}" target="_blank">技术审查表</a>
		<c:if test="<%=projectProfile.getXmxz() != 29769%>">
			<a class="btn" href="${printsgxklszsURL}" target="_blank">施工许可(绿色)</a>
		</c:if>
	</c:if>
	<c:if test="<%=status == CityPermitStatus.STATUS_WLD_BACK.getCode()%>">
		<a class="btn" href="" target="_blank">不予许可通知书</a>
	</c:if>
	<!-- <a class="btn" href="" target="_blank">施工许可</a> -->
</aui:button-row>