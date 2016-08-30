<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<liferay-ui:header title="报送合同查询" />
<liferay-ui:panel-container accordion="false" extended="true">
	<liferay-ui:panel title="查询条件" collapsible="true">
		<aui:form name="fm" method="get">
			<aui:input name="p_p_id" type="hidden" useNamespace="false"
				value="${portletDisplay.id }"></aui:input>
			<aui:input type="hidden" name="delta" value="${delta}"></aui:input>
			<table style="width: 100%;" border="1">
				<tr>
					<td style="width: 10%;">报建编号</td>
					<td style="width: 40%;"><aui:input type="text" name="bjbh"
							label="" /></td>
					<td style="width: 15%;">标段号</td>
					<td style="width: 35%;"><aui:input type="text" name="bdh"
							label="" /></td>
				</tr>
				<tr>
					<td style="width: 10%;">项目名称</td>
					<td style="width: 40%;"><aui:input type="text" name="xmmc"
							label="" /></td>
					<td style="width: 15%;">合同类型</td>
					<td style="width: 35%;">
						<%
					    	String[] htlbLabels = {"勘察合同", "设计合同", "施工合同", "监理合同", "一体化合同", "设备监理合同", "招标代理合同", "造价合同", "项目管理合同"};
							String[] htlbValues = {"kc", "sj", "sg", "jl", "yth", "sbjl", "dl", "zj", "xmgl"};
						%>
						<aui:select name="htlx" showEmptyOption="true"
							cssClass="input-small" label="">
								<c:forEach var="htlbLabel" items="<%=htlbLabels %>">
									<aui:option label="${htlbLabel }" value="${htlbLabel }"></aui:option>
								</c:forEach>
						</aui:select></td>
				</tr>  
				<tr>
					<td>合同信息报送编号</td>
					<td><aui:select name="htxxbsbh" showEmptyOption="true"
							cssClass="input-small" label="">
						</aui:select></td>
					<td>变更状态</td>
					<td><aui:select name="bgzt" showEmptyOption="true"
							cssClass="input-small" label="">
						</aui:select></td>
				</tr>
				<tr style="height: 40px;">
					<td colspan="4" align="center"><aui:button type="submit"
							value="提交查询"></aui:button></td>
				</tr>
			</table>
		</aui:form>
	</liferay-ui:panel>
	<liferay-ui:panel title="合同列表" collapsible="false">
		<liferay-ui:search-container emptyResultsMessage="没有报送合同数据。">
			<liferay-ui:search-container-results results="${contracts }"
				total="${contractsCount }">
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="com.justonetech.cp.contract.model.Contract" keyProperty="contractId"> 
				<liferay-portlet:renderURL varImpl="rowURL">
					<portlet:param name="bjbh" value="${contract.bjbh}" />
					<portlet:param name="mvcPath"
						value="${contextPath }/view-contract.jsp" />
				</liferay-portlet:renderURL>
				<liferay-ui:search-container-column-text property="htxxbsbh"
					name="合同信息报送编号" href="${rowURL }" align="right" />
				<liferay-ui:search-container-column-text property="zfbgxbm"
					name="总分包关系编号" href="${rowURL }" align="center" />
				<liferay-ui:search-container-column-text property="htmc"
					name="合同名称" href="${rowURL }" />
				<liferay-ui:search-container-column-text property="htbsrq"
					name="合同报送（备案）日期" href="${rowURL }" />
				<liferay-ui:search-container-column-text property="cbfs" name="承包方式"
					href="${rowURL }" />
				<liferay-ui:search-container-column-text property="fbdw" name="发包单位"
					href="${rowURL }" />
				<liferay-ui:search-container-column-text property="cbdw" name="承包单位"
					href="${rowURL }" />
				<liferay-ui:search-container-column-text property="htzt" name="合同状态"
					href="${rowURL }" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</liferay-ui:panel>
</liferay-ui:panel-container>