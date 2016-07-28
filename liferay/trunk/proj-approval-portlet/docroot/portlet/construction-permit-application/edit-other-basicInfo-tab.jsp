<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>

<%
	SimpleDateFormat sf = new SimpleDateFormat(defaultDateFormatPattern);
	ConstructionPermit consPer = (ConstructionPermit) renderRequest
			.getAttribute("constructionPermit");
	if (consPer == null) {
		consPer = new ConstructionPermitClp();
	}

	Dictionary projPropertyDictionary = DictionaryLocalServiceUtil
			.findByCode("ProjectProperty");
	List<Dictionary> projPropertyDics = new ArrayList<Dictionary>();
	if (null != projPropertyDictionary) {
		projPropertyDics = DictionaryLocalServiceUtil.findByParentId(
				projPropertyDictionary.getDictionaryId(), -1, -1);
	}

	Dictionary areaNameDictionary = DictionaryLocalServiceUtil
			.findByCode("AreaName");
	List<Dictionary> areaNameDics = new ArrayList<Dictionary>();
	if (null != areaNameDictionary) {
		areaNameDics = DictionaryLocalServiceUtil.findByParentId(
				areaNameDictionary.getDictionaryId(), -1, -1);
	}

	Dictionary consTypeDictionary = DictionaryLocalServiceUtil
			.findByCode("ConstructionType");
	List<Dictionary> consTypeDics = new ArrayList<Dictionary>();
	if (null != consTypeDictionary) {
		consTypeDics = DictionaryLocalServiceUtil.findByParentId(
				consTypeDictionary.getDictionaryId(), -1, -1);
	}

	Dictionary consProperDictionary = DictionaryLocalServiceUtil
			.findByCode("ConstructionProperty");
	List<Dictionary> consProperDics = new ArrayList<Dictionary>();
	if (null != consProperDictionary) {
		consProperDics = DictionaryLocalServiceUtil.findByParentId(
				consProperDictionary.getDictionaryId(), -1, -1);
	}
%>


<liferay-ui:panel-container accordion="true" extended="true">
	<liferay-ui:panel title="项目基本信息">
		<aui:row>
			<aui:col span="6">
				<aui:select label="项目性质：" name="projProperty" cssClass="span8">
					<c:forEach items="<%=projPropertyDics%>" var="projPropertyDic">
						<aui:option value="${projPropertyDic.dictionaryId}"
							selected="${constructionPermit.projProperty eq projPropertyDic.dictionaryId}">${projPropertyDic.name}</aui:option>
					</c:forEach>

				</aui:select>
			</aui:col>
			<aui:col span="6">
				<aui:select label="所属区县：" name="county" cssClass="span8">
					<c:forEach items="<%=areaNameDics%>" var="areaNameDic">
						<aui:option value="${areaNameDic.dictionaryId}"
							selected="${constructionPermit.county eq areaNameDic.dictionaryId}">${areaNameDic.name}</aui:option>
					</c:forEach>
				</aui:select>
			</aui:col>
		</aui:row>

		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="项目名称：" name="projName"
					cssClass="span8" value="${constructionPermit.projName}">
					<aui:validator name="required" errorMessage="项目名称不能为空!"></aui:validator>

				</aui:input>
			</aui:col>

			<aui:col span="6">
				<aui:input type="text" label="标段号：" name="bidingCode"
					cssClass="span8" value="${constructionPermit.bidingCode}">
					<aui:validator name="required" errorMessage="标段号不能为空!"></aui:validator>
				</aui:input>
			</aui:col>
		</aui:row>


		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="报建编号：" name="constructionCode"
					cssClass="span8" value="${constructionPermit.constructionCode}">
					<aui:validator name="required" errorMessage="报建编号不能为空!"></aui:validator>

				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="业务编号：" name="businessCode"
					cssClass="span8" value="${constructionPermit.businessCode}"
					disabled="true">
				</aui:input>
			</aui:col>

		</aui:row>

		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="发证日期：" name="certificationDate"
					cssClass="span8"
					value="<%=consPer.getCertificationDate() == null ? null : sf.format(consPer
										.getCertificationDate())%>"
					disabled="true">
				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="收件号：" name="receiptNum"
					cssClass="span8" value="${constructionPermit.receiptNum}"
					disabled="true">

				</aui:input>
			</aui:col>

		</aui:row>

		<aui:row>
			<aui:col span="6">
				<aui:input label="建设单位：" name="company" cssClass="span8"
					value="${constructionPermit.company}">
					<aui:validator name="required" errorMessage="建设单位不能为空!"></aui:validator>

				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input label="建设单位性质：" name="companyProperty" cssClass="span8"
					value="${constructionPermit.companyProperty}">

				</aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="建设单位法定代表人：" name="legalPerson"
					cssClass="span8" value="${constructionPermit.legalPerson}">

				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="建设单位联系人：" name="companyContacts"
					cssClass="span8" value="${constructionPermit.companyContacts}">

				</aui:input>
			</aui:col>

		</aui:row>

		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="建设单位联系电话：" name="companyTel"
					cssClass="span8" value="${constructionPermit.companyTel}">
				</aui:input>
			</aui:col>

			<aui:col span="6">
				<aui:input type="text" label="手机号：" name="companyContactPhone"
					cssClass="span8" value="${constructionPermit.companyContactPhone}">
				</aui:input>
			</aui:col>

		</aui:row>


		<aui:row>

			<aui:col span="6">
				<aui:input type="text" label="建设单位地址：" name="companyAddress"
					cssClass="span8" value="${constructionPermit.companyAddress}">
				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="建设地点：" name="companySite"
					cssClass="span8" value="${constructionPermit.companySite}">

				</aui:input>
			</aui:col>
		</aui:row>



		<aui:row>
			<aui:col span="2" cssClass="textcenter">
			建设地点所属区县：
			</aui:col>
			<aui:col span="6">
				
					<c:forEach items="<%=areaNameDics%>" var="areaNameDic">
					<aui:input type="radio" name="companySiteCounty"
						label="${areaNameDic.name}" inlineLabel="right"
						inlineField="true" value="${areaNameDic.dictionaryId}"
						checked="${constructionPermit.companySiteCounty eq areaNameDic.dictionaryId}"></aui:input>
					</c:forEach>
					
			</aui:col>
			

		</aui:row>



		<aui:row>
			<aui:col span="2" cssClass="textcenter">
			建设工程类别：
			</aui:col>
			<aui:col span="10">
				<c:forEach items="<%=consTypeDics%>" var="consTypeDic">
				<c:if test='${fn:contains(constructionPermit.engineerCategory, consTypeDic.dictionaryId)}' >
 						<c:set var="isChecked" value="true"></c:set>
 					</c:if>
					<aui:input type="checkbox" name="engineerCategory"
						label="${consTypeDic.name}" inlineLabel="right" inlineField="true"
						value="${consTypeDic.dictionaryId}"
						checked="${isChecked}"
						 />
					<c:set var="isChecked" value="false"></c:set>
				</c:forEach>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="2" cssClass="textcenter">
			建设工程属性：
			</aui:col>
			<aui:col span="10">

				<c:forEach items="<%=consProperDics%>" var="consProperDic">
					<aui:input type="radio" name="engineerAttribute"
						label="${consProperDic.name}" inlineLabel="right"
						inlineField="true" value="${consProperDic.dictionaryId}"
						checked="${constructionPermit.engineerAttribute eq consProperDic.dictionaryId}"></aui:input>
				</c:forEach>

			</aui:col>
		</aui:row>

		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="建设工程规模：" name="engineerScale"
					cssClass="span8" value="${constructionPermit.engineerScale}">

				</aui:input>
			</aui:col>

			<aui:col span="6">
				<aui:input type="text" label="国有资金比重%："
					name="nationalFundsProportion" cssClass="span8"
					value="${constructionPermit.nationalFundsProportion}">

				</aui:input>
			</aui:col>
			
		</aui:row>

		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="合同价格：" name="contractPrice"
					cssClass="span8"
					value="${constructionPermit.contractPrice}">

				</aui:input>
			</aui:col>

			<aui:col span="6">
				<aui:input type="text" label="合同工期：" name="contractSchedule"
					cssClass="span8" value="${constructionPermit.contractSchedule}">
				</aui:input>
			</aui:col>
			
		</aui:row>


		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="中标价格：" name="bidPrice"
					cssClass="span8" value="${constructionPermit.bidPrice}">

				</aui:input>
			</aui:col>

			<aui:col span="6">
				<aui:input type="text" label="项目投资估算：" name="investBudget"
					cssClass="span8" value="${constructionPermit.investBudget}">
				</aui:input>
			</aui:col>
			
		</aui:row>

		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="计划开工：" name="planStartDate"
					value="<%=consPer.getPlanStartDate() == null ? null : sf.format(consPer
										.getPlanStartDate())%>"
					onfocus="WdatePicker({lang:'zh-cn'})">

				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="计划竣工：" name="planEndDate"
					value="<%=consPer.getPlanEndDate() == null ? null : sf.format(consPer.getPlanEndDate())%>"
					onfocus="WdatePicker({lang:'zh-cn'})">
				</aui:input>
			</aui:col>
			
		</aui:row>
		<aui:row>
		<aui:col span="6">
				<aui:input type="text" label="施工单位名称：" cssClass="span8" value="${permitApplication.constructionCompany}"
					name="constructionCompany">

				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="项目经理：" cssClass="span8" value="${permitApplication.projManager}"
					name="projManager">

				</aui:input>
			</aui:col>
		</aui:row>
		
		<aui:row>	
			
			
			<aui:col span="6">
				<aui:input type="text" label="监理单位名称：" name="supervisionCompany" cssClass="span8" value="${permitApplication.supervisionCompany}">
				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="项目总监：" cssClass="span8" value="${permitApplication.projDirector}"
					name="projDirector">
				</aui:input>
			</aui:col>
		</aui:row>

		<aui:row>
		<aui:col span="6">
				<aui:input type="text" label="设计单位名称：" cssClass="span8" value="${permitApplication.designCompany}"
					name="designCompany">
				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="textarea" label="现场开工情况：" cssClass="span8" value="${constructionPermit.workSituation}"
					name="workSituation">
				</aui:input>
			</aui:col>
		</aui:row>

	</liferay-ui:panel>
</liferay-ui:panel-container>
