<%@ page contentType="text/html;charset=utf-8"%>
<%@include file="/common/init.jsp"%>

<c:set var="contextPath" value="${request.contextPath}/portlet/bidding" />

<%
	Long biddingId = (Long) request.getAttribute("biddingId");
	List<Company> companies = null;
	if (Validator.isNotNull(biddingId)) {
		companies = CompanyLocalServiceUtil.findByBiddingId(biddingId);
	}
	Dictionary companyTypeDic = DictionaryLocalServiceUtil.findByCode("CompanyType");
	List<Dictionary> companyTypes = companyTypeDic != null ? DictionaryLocalServiceUtil.findByParentId(
			companyTypeDic.getDictionaryId(), -1, -1) : null;
	Map<Dictionary, Company> companyMap = new TreeMap<Dictionary, Company>();
	for (Dictionary dictionary : companyTypes) {
		companyMap.put(dictionary, null);
		if (companies != null) {
			for (Company com : companies) {
				if (Validator.isNotNull(com.getType())) {
					Dictionary dic = DictionaryLocalServiceUtil.getDictionary(com.getType());
					if (dictionary.equals(dic)) {
						companyMap.put(dictionary, com);
					}
				}
			}
		}
	}
	Dictionary involveCountyDic = DictionaryLocalServiceUtil.findByCode("areaName");
	List<Dictionary> involveCountys = involveCountyDic != null ? DictionaryLocalServiceUtil.findByParentId(
			involveCountyDic.getDictionaryId(), -1, -1) : null;
	request.setAttribute("involveCountys", involveCountys);
	request.setAttribute("companyMap", companyMap);
	request.setAttribute("companies", companies);
%>

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
			<aui:col span="6" cssClass="text-left">
				<aui:input type="text" label="标段序号" name="sortNo"
					value="${sortNo}">
					<aui:validator name="required" errorMessage="标段序号不能为空!"></aui:validator>
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
				<label class="control-label" for="startDate"> 开工日期 </label>
				<input type="text" class="field"
					name="<portlet:namespace/>startDate" id="startDate"
					onfocus="WdatePicker({lang:'zh-cn'})" required="required"
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
					<aui:validator name="required" errorMessage="联系电话!"></aui:validator>
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
