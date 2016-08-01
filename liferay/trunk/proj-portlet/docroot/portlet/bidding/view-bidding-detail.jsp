<%@ page contentType="text/html;charset=utf-8"%>
<%@include file="/common/init.jsp"%>
<c:set var="contextPath" value="${request.contextPath}/portlet/bidding" />
<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="${contextPath}/view-bidding.jsp" />
	<portlet:param name="projectId" value="${projectId}" />
</portlet:renderURL>
<portlet:actionURL var="saveBidding" name="saveBidding">
	<portlet:param name="redirect" value="${viewURL}" />
</portlet:actionURL>
<liferay-ui:header title="查看标段详细信息" backURL="${viewURL}" />
<aui:form action="${saveBidding}" method="post">
	<aui:row>
		<aui:col span="12" cssClass="text-left">
			<aui:input name="bidCategoryCode"
				value="${bidding.bidCategoryCode eq '1'?'形象进度':'办证推进'}"
				label="标段类别编码" disabled="true" />
		</aui:col>
	</aui:row>
	<aui:fieldset>
		<aui:input name="projectId" type="hidden" value="${projectId}" />
		<aui:input name="biddingId" type="hidden"
			value="${bidding.biddingId }" />
		<aui:row>
			<aui:col span="6" cssClass="text-left">
				<aui:input type="text" label="标段序号" name="sortNo"
					value="${bidding.sortNo}" disabled="true">
				</aui:input>
			</aui:col>
			<aui:col span="6" cssClass="text-left">
				<aui:input type="text" label="标段名称" name="bidName"
					value="${bidding.bidName}" disabled="true">
				</aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="6" cssClass="text-left">
				<aui:input type="text" label="建设里程" name="buildMileage"
					value="${bidding.buildMileage}" disabled="true">
				</aui:input>
			</aui:col>
			<aui:col span="6" cssClass="text-left">
				<label class="control-label" for="startDate"> 开工日期 </label>
				<input type="text" class="field"
					name="<portlet:namespace/>startDate" id="startDate"
					onfocus="WdatePicker({lang:'zh-cn'})" required="required"
					disabled="true"
					value='<fmt:formatDate value="${bidding.startDate }" pattern="yyyy-MM-dd"/>'>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="12" cssClass="text-left">
				<aui:field-wrapper name="涉及区县">
					<c:forEach items="${involveCountys}" var="involveCounty">
						<aui:input name="involveCounty" type="checkbox"
							value="${involveCounty.dictionaryId}" disabled="true"
							checked="${fn:contains(bidding.involveCounty,involveCounty.dictionaryId)}"
							label="${involveCounty.name}" inlineField="true" />
					</c:forEach>
				</aui:field-wrapper>
			</aui:col>

		</aui:row>
		<aui:row>
			<aui:col span="6" cssClass="text-left">
				<aui:input type="text" label="项目联系人" name="projLinkman"
					value="${bidding.projLinkman}" disabled="true">
				</aui:input>
			</aui:col>
			<aui:col span="6" cssClass="text-left">
				<aui:input type="text" label="联系电话" name="linkTel"
					value="${bidding.linkTel}" disabled="true">
				</aui:input>
			</aui:col>
		</aui:row>

		<c:forEach items="${companyMap}" var="map">
			<fieldset>
				<legend>${map.key.name }</legend>
				<aui:input name="companyId" type="hidden"
					value="${map.value.companyId }" />
				<aui:input name="typeId" type="hidden"
					value="${map.key.dictionaryId }" />
				<aui:row>
					<aui:col span="4" cssClass="text-left">
						<aui:input type="text" label="名称" name="unitName"
							value="${map.value.unitName}" disabled="true" />
					</aui:col>
					<aui:col span="4" cssClass="text-left">
						<aui:input type="text" label="联系人" name="linkman"
							value="${map.value.linkman}" disabled="true" />
					</aui:col>
					<aui:col span="4" cssClass="text-left">
						<aui:input type="text" label="联系电话" name="linkmanTel"
							value="${map.value.linkmanTel}" disabled="true" />
					</aui:col>
				</aui:row>
			</fieldset>
		</c:forEach>
	</aui:fieldset>
</aui:form>
