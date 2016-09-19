<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/leo-training" />
<portlet:renderURL var="viewURL" />

<liferay-ui:panel-container accordion="false" extended="true">
	<liferay-ui:panel title="查询条件" collapsible="true">
		<aui:form name="fm" method="get" action="${searchURL }">
			<aui:input name="p_p_id" type="hidden" useNamespace="false"
				value="${portletDisplay.id }"></aui:input>
			<aui:input type="hidden" name="delta" value="${delta}"></aui:input>
			<table style="width: 100%;" class="table table-bordered">
				<tr>
					<td style="width: 10%;" class="text-right">专业类型</td>
					<td style="width: 40%;" class="bg-white"><aui:input
							type="text" name="zylx" style="width:80%" label="" /></td>
					<td style="width: 10%;" class="text-right">姓名</td>
					<td style="width: 40%;" class="bg-white"><aui:input
							type="text" name="xm" value="" style="width:80%" label="" /></td>
				</tr>
				<tr>
					<td style="width: 10%;" class="text-right">证件编号</td>
					<td style="width: 40%;" class="bg-white"><aui:input
							type="text" name="zjbh" style="width:80%" label="" /></td>
					<td style="width: 10%;" class="text-right">有效期</td>
					<td style="width: 40%;" class="bg-white"><input type="text"
						id="yxq" name="<portlet:namespace/>yxq" style="width: 80%"
						class="field Wdate"
						value="<fmt:formatDate value='${yxq }' pattern='yyyy-MM-dd' />"
						onfocus="WdatePicker({yxq,lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" /></td>
				</tr>
				<tr style="height: 40px;">
					<td colspan="4" align="center" class="bg-white"><aui:button
							type="submit" value="查询"></aui:button></td>
				</tr>
			</table>
		</aui:form>
	</liferay-ui:panel>
	<%
		int sortNo = 0;
	%>
	<liferay-ui:panel title="教育人员列表" collapsible="false">
		<liferay-ui:search-container emptyResultsMessage="没有继续教育人员数据。">
			<liferay-ui:search-container-results results="${leoCertificates}"
				total="${leoCertificatesCount}">
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="LEOCertificate"
				keyProperty="certificateId" modelVar="leoCertificate">
				<liferay-ui:search-container-column-text
					value="<%=String.valueOf(++sortNo)%>" />
				<liferay-ui:search-container-column-text property="xm" name="姓名" />
				<liferay-ui:search-container-column-text property="zylx" name="专业类型" />
				<liferay-ui:search-container-column-text property="zjbh"
					name="证件编号" />
				<liferay-ui:search-container-column-text name="发证日期">
					<fmt:formatDate value="${leoCertificate.fzrq}" pattern="yyyy-MM-dd" />
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="有效期">
					<fmt:formatDate value="${leoCertificate.yxq}" pattern="yyyy-MM-dd" />
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="action">
					<portlet:renderURL var="editLEOCertificateURL">
						<portlet:param name="mvcPath"
							value="${contextPath }/edit-leotraining.jsp" />
						<portlet:param name="certificateId"
							value="${leoCertificate.certificateId}" />
					</portlet:renderURL>
					<aui:button value="教育记录" href="${editLEOCertificateURL}" />
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator>
				<%
					String zjbh = (String) request.getAttribute("zjbh");
									PortletURL portletURL = searchContainer.getIteratorURL();
									portletURL.setParameter("zjbh", zjbh);
				%>
			</liferay-ui:search-iterator>
		</liferay-ui:search-container>
	</liferay-ui:panel>
</liferay-ui:panel-container>
