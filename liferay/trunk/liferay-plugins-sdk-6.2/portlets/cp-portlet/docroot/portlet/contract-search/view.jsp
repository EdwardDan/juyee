<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/contract-search" />
<portlet:renderURL var="searchURL">
	<portlet:param name="bjbh" value="${bjbh}"/>
	<portlet:param name="bdh" value="${bdh}"/>
	<portlet:param name="xmmc" value="${xmmc}"/>  
</portlet:renderURL>
<liferay-ui:header title="报送合同查询" />
<liferay-ui:panel-container accordion="false" extended="true">
	<liferay-ui:panel title="查询条件" collapsible="true">
		<aui:form name="fm" id="fm" method="get" action="${searchURL}">
			<aui:input name="p_p_id" type="hidden" useNamespace="false"
				value="${portletDisplay.id }"></aui:input>
			<aui:input type="hidden" name="delta" value="${delta}"></aui:input>
			<table style="width: 100%;" border="1">
				<tr>
					<td style="width: 10%; text-align: right">报建编号：</td>
					<td style="width: 40%;"><aui:input type="text" name="bjbh" id="bjbh"
							label="" /></td>
					<td style="width: 15%; text-align: right">标段号：</td>
					<td style="width: 35%;"><aui:input type="text" name="bdh"
							label="" /></td>
				</tr>
				<tr>
					<td style="width: 10%; text-align: right">项目名称：</td>
					<td colspan="3"><aui:input type="text" name="xmmc" label="" /></td>
				<tr style="height: 40px;">
					<td colspan="4" align="center"><aui:button type="submit"
							value="提交查询"></aui:button></td>
				</tr>
			</table>
			</br>
			<%
				String htlbLabel = "所有,勘察合同,设计合同,施工合同,监理合同,一体化合同,设备监理合同,招标代理合同,造价合同,项目管理合同";			
				String htlbValue = "sy,kc,sj,sg,jl,yth,sbjl,dl,zj,xmgl";
				int sortNo = 0;
				Integer contractsCount = (Integer)request.getAttribute("contractsCount");
			%>
			<liferay-ui:tabs names="<%=htlbLabel%>" param="htlb" tabsValues="<%=htlbValue%>" url="<%=searchURL%>">				
				<liferay-ui:panel title="合同列表" collapsible="false">
					<liferay-ui:search-container 
						emptyResultsMessage="没有报送合同数据。">
						<liferay-ui:search-container-results results="${contracts}"
							total="${contractsCount}">
						</liferay-ui:search-container-results>
						<liferay-ui:search-container-row
							className="com.justonetech.cp.contract.model.Contract"
							keyProperty="contractId" modelVar="contract">
							<liferay-portlet:renderURL varImpl="rowURL">
								<portlet:param name="bjbh" value="${contract.contractId}" />
								<portlet:param name="mvcPath"
									value="${contextPath}/view-contract.jsp" />
							</liferay-portlet:renderURL>
							<liferay-ui:search-container-column-text name="序号"
								value="<%=String.valueOf(++sortNo)%>" />
							<liferay-ui:search-container-column-text property="bjbh"
								name="报建编号" href="${rowURL }" />
							<liferay-ui:search-container-column-text property="bdh"
								name="标段号" href="${rowURL }" />
							<liferay-ui:search-container-column-text property="contractId"
								name="合同信息报送编号" href="${rowURL }" />
							<liferay-ui:search-container-column-text property="htmc"
								name="合同名称" href="${rowURL }" />
						</liferay-ui:search-container-row>
						<liferay-ui:search-iterator/>					
					</liferay-ui:search-container>
				</liferay-ui:panel>
			</liferay-ui:tabs>
		</aui:form>
	</liferay-ui:panel>
</liferay-ui:panel-container>
