<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>

<c:set var="contentPath"
	value="${request.contextPath}/portlet/dept-weekly-work" />
	
<portlet:renderURL var="viewURL" />
<aui:form action="${viewURL }" name="fm">
	<aui:nav-bar>
		<aui:nav>
			<portlet:renderURL var="addUrl">
				<portlet:param name="mvcPath"
					value="${contentPath}/edit-dept-weekly-work.jsp" />
				<%-- <portlet:param name="deptWorkId" value="" />  --%>
			</portlet:renderURL>
			<aui:nav-item href="<%=addUrl%>" iconCssClass="icon-plus" label="添加" />
		</aui:nav>
		<aui:nav-bar-search cssClass="pull-right">
			<div class="form-search">
				<liferay-ui:input-search />
			</div>
		</aui:nav-bar-search>
	</aui:nav-bar>
	<aui:button-row>
		<aui:button disabled="<%=true%>" name="deleteDeptWorksBtn"
			value="delete"
			onClick='<%=renderResponse.getNamespace() + "deleteDeptWorks();"%>' />
	</aui:button-row>
	<liferay-ui:search-container emptyResultsMessage="没有数据" delta="5"
		orderByCol="${orderByCol }"
		orderByType="${empty orderByType?'asc':orderByType }"
		rowChecker="<%=new RowChecker(renderResponse)%>">
		<liferay-ui:search-container-results results="${deptWorks}"
			total="${deptWorksCount}">
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row className="DeptWork"
			modelVar="deptWork" keyProperty="deptWorkId">
			<%-- <liferay-ui:search-container-row className="Student"
			modelVar="student" keyProperty="studentId"> --%>
			<liferay-ui:search-container-column-text property="deptName"
				name="上报科室" orderable="<%=true%>" orderableProperty="deptName" />
			<liferay-ui:search-container-column-text property="userName"
				name="提交人" orderable="<%=true%>" orderableProperty="userName" />
			<liferay-ui:search-container-column-text name="上报日期">
				<%=DateUtil.getDate(deptWork.getStartDate(),	"yyyy-MM-dd", locale, timeZone)%>~
				<%=DateUtil.getDate(deptWork.getEndDate(),"yyyy-MM-dd", locale, timeZone)%>
			</liferay-ui:search-container-column-text>
			<%-- 		<liferay-ui:search-container-column-text name="sex">
				<liferay-ui:message key="${student.sex eq 0?'女':'男'}" />
			</liferay-ui:search-container-column-text> --%>
			<liferay-ui:search-container-column-text property="status" name="状态"
				orderable="<%=true%>" orderableProperty="status" />

			<liferay-ui:search-container-column-text>
				<liferay-ui:icon-menu>
					<%-- <portlet:actionURL var="viewUrl" name="editDeptWork">
						<portlet:param name="deptWorkId" value="${deptWork.deptWorkId}" />
					</portlet:actionURL> --%>
					<%-- <liferay-ui:icon image="view" url="${editUrl}" /> --%>
					<portlet:actionURL var="editUrl" name="editDeptWork">
						<portlet:param name="deptWorkId" value="${deptWork.deptWorkId}" />
					</portlet:actionURL>
					<liferay-ui:icon image="edit" url="${editUrl}" />
					<portlet:actionURL var="delUrl" name="deleteDeptWorks">
						<portlet:param name="deptWorkIds" value="${deptWork.deptWorkId}" />
						<portlet:param name="redirect" value="${viewUrl}" />
					</portlet:actionURL>
					<liferay-ui:icon image="delete" url="${delUrl}" />
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator>
			<%-- <%
				String orderByCol = (String)renderRequest.getAttribute("orderByCol");
																									PortletURL portletURL = searchContainer.getIteratorURL();
																									portletURL.setParameter("orderByCol", orderByCol);
			%> --%>
		</liferay-ui:search-iterator>
	</liferay-ui:search-container>
</aui:form>
<portlet:actionURL var="deleteDeptWorksURL" name="deleteDeptWorks">
	<portlet:param name="redirect" value="${viewURL}" />
</portlet:actionURL>
<aui:script>
	Liferay.Util
			.toggleSearchContainerButton(
					'#<portlet:namespace />deleteDeptWorksBtn',
					'#<portlet:namespace /><%=searchContainerReference.getId("searchContainer")%>SearchContainer',
					document.<portlet:namespace />fm,
					'<portlet:namespace />allRowIds');
	Liferay
			.provide(
					window,
					'<portlet:namespace />deleteDeptWorks',
					function() {
						location.href = "<%=deleteDeptWorksURL%>&<portlet:namespace />deptWorkIds="
								+ Liferay.Util.listCheckedExcept(
										document.<portlet:namespace />fm,
										'<portlet:namespace />allRowIds');
					}, [ 'liferay-util-list-fields' ]);
</aui:script>
	




























