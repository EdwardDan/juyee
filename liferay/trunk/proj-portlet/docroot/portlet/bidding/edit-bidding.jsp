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
<liferay-ui:header title="${empty biddingId?'添加':'编辑'}标段信息"
	backURL="${viewURL}" />
<aui:form action="${saveBidding}" method="post">
	<aui:fieldset>
		<aui:input name="projectId" type="hidden" value="${projectId}" />
		<aui:input name="biddingId" type="hidden"
			value="${bidding.biddingId }" />
		<aui:row>
			<aui:col span="12" cssClass="text-left">
				<aui:select label="标段类别编码" name="bidCategoryCode">
					<aui:option value="1" selected="${bidding.bidCategoryCode eq '1'}">形象进度</aui:option>
					<aui:option value="2" selected="${bidding.bidCategoryCode eq '2'}">办证推进</aui:option>
				</aui:select>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="6" cssClass="text-left">
				<aui:input type="text" label="标段序号" name="sortNo"
					value="${sortNo}">
					<aui:validator name="maxLength" errorMessage="">75</aui:validator>
				</aui:input>
			</aui:col>
			<aui:col span="6" cssClass="text-left">
				<aui:input type="text" label="标段名称" name="bidName"
					value="${bidding.bidName}">
					<aui:validator name="required" errorMessage="标段名称不能为空!"></aui:validator>
				</aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="6" cssClass="text-left">
				<aui:input type="text" label="建设里程" name="buildMileage"
					value="${bidding.buildMileage}">
				</aui:input>
			</aui:col>
			<aui:col span="6" cssClass="text-left">
				<label class="control-label" for="startDate">开工日期 </label>
				<input type="text" class="field" onfocus="WdatePicker()"
					name="<portlet:namespace/>startDate" id="startDate"
					value='<fmt:formatDate value="${bidding.startDate }" pattern="yyyy-MM-dd"/>'>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="12" cssClass="text-left">
				<aui:field-wrapper name="涉及区县">
					<c:forEach items="${involveCountys}" var="involveCounty">
						<aui:input name="involveCounty" type="checkbox"
							value="${involveCounty.dictionaryId}"
							checked="${fn:contains(bidding.involveCounty,involveCounty.dictionaryId)}"
							label="${involveCounty.name}" inlineField="true" />
					</c:forEach>
				</aui:field-wrapper>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="6" cssClass="text-left">
				<aui:input type="text" label="项目联系人" name="projLinkman"
					value="${bidding.projLinkman}">
				</aui:input>
			</aui:col>
			<aui:col span="6" cssClass="text-left">
				<aui:input type="text" label="联系电话" name="linkTel"
					value="${bidding.linkTel}">
				</aui:input>
			</aui:col>
		</aui:row>

		<c:forEach items="${companyMap }" var="map">
			<fieldset>
				<legend>${map.key.name }</legend>
				<aui:input name="companyId" type="hidden"
					value="${map.value.companyId }" />
				<aui:input name="typeId" type="hidden"
					value="${map.key.dictionaryId }" />

				<aui:row>
					<aui:col span="4" cssClass="text-left">
						<aui:input type="text" label="名称" name="unitName"
							value="${map.value.unitName}" />
					</aui:col>
					<aui:col span="4" cssClass="text-left">
						<aui:input type="text" label="联系人" name="linkman"
							value="${map.value.linkman}" />
					</aui:col>
					<aui:col span="4" cssClass="text-left">
						<aui:input type="text" label="联系电话" name="linkmanTel"
							value="${map.value.linkmanTel}" />
					</aui:col>
				</aui:row>
			</fieldset>
		</c:forEach>
	</aui:fieldset>
	<aui:button type="submit"></aui:button>
	<aui:button type="reset" value="重置"></aui:button>
</aui:form>
