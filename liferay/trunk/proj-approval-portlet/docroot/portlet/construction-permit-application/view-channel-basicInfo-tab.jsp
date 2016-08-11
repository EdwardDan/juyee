<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>

<%
	SimpleDateFormat sf = new SimpleDateFormat(defaultDateFormatPattern);
	ConstructionPermit consPer = (ConstructionPermit) renderRequest.getAttribute("constructionPermit");
	if (consPer == null) {
		consPer = new ConstructionPermitClp();
	}
	ConstructionPermitApplication perApp = (ConstructionPermitApplication) renderRequest
			.getAttribute("permitApplication");
	if (perApp == null) {
		perApp = new ConstructionPermitApplication();
	}

	Dictionary projPropertyDictionary = DictionaryLocalServiceUtil.findByCode("ProjectProperty");
	List<Dictionary> projPropertyDics = new ArrayList<Dictionary>();
	if (null != projPropertyDictionary) {
		projPropertyDics = DictionaryLocalServiceUtil.findByParentId(projPropertyDictionary.getDictionaryId(),
				-1, -1);
	}

	Dictionary areaNameDictionary = DictionaryLocalServiceUtil.findByCode("AreaName");
	List<Dictionary> areaNameDics = new ArrayList<Dictionary>();
	if (null != areaNameDictionary) {
		areaNameDics = DictionaryLocalServiceUtil.findByParentId(areaNameDictionary.getDictionaryId(), -1, -1);
	}

	Dictionary consTypeDictionary = DictionaryLocalServiceUtil.findByCode("ConstructionType");
	List<Dictionary> consTypeDics = new ArrayList<Dictionary>();
	if (null != consTypeDictionary) {
		consTypeDics = DictionaryLocalServiceUtil.findByParentId(consTypeDictionary.getDictionaryId(), -1, -1);
	}

	Dictionary consProperDictionary = DictionaryLocalServiceUtil.findByCode("ConstructionProperty");
	List<Dictionary> consProperDics = new ArrayList<Dictionary>();
	if (null != consProperDictionary) {
		consProperDics = DictionaryLocalServiceUtil.findByParentId(consProperDictionary.getDictionaryId(), -1,
				-1);
	}
%>



<liferay-ui:panel-container accordion="true" extended="true">
	<liferay-ui:panel title="项目基本信息">
		<aui:row>
			<aui:col span="6">
				<aui:select label="项目性质" name="projProperty" cssClass="span8">
					<c:forEach items="<%=projPropertyDics%>" var="projPropertyDic">
						<aui:option value="${projPropertyDic.dictionaryId}"
							selected="${constructionPermit.projProperty eq projPropertyDic.dictionaryId}">${projPropertyDic.name}</aui:option>
					</c:forEach>

				</aui:select>
			</aui:col>
			<aui:col span="6">
				<aui:select label="所属区县" name="county" cssClass="span8">
					<c:forEach items="<%=areaNameDics%>" var="areaNameDic">
						<aui:option value="${areaNameDic.dictionaryId}"
							selected="${constructionPermit.county eq areaNameDic.dictionaryId}">${areaNameDic.name}</aui:option>
					</c:forEach>
				</aui:select>
			</aui:col>
		</aui:row>

		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="项目名称" name="projName" cssClass="span8"
					value="${constructionPermit.projName}">
					<aui:validator name="required" errorMessage="项目名称不能为空!"></aui:validator>

				</aui:input>
			</aui:col>

			<aui:col span="6">
				<aui:input type="text" label="标段号" name="bidingCode"
					cssClass="span8" value="${constructionPermit.bidingCode}">
					<aui:validator name="required" errorMessage="标段号不能为空!"></aui:validator>
				</aui:input>
			</aui:col>
		</aui:row>


		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="报建编号" name="constructionCode"
					cssClass="span8" value="${constructionPermit.constructionCode}">
					<aui:validator name="required" errorMessage="报建编号不能为空!"></aui:validator>

				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="业务编号" name="businessCode"
					cssClass="span8" value="${constructionPermit.businessCode}"
					disabled="true">
				</aui:input>
			</aui:col>

		</aui:row>

		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="发证日期" name="certificationDate"
					cssClass="span8"
					value="<%=consPer.getCertificationDate() == null ? null : sf.format(consPer
										.getCertificationDate())%>"
					disabled="true">
				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="收件号" name="receiptNum"
					cssClass="span8" value="${constructionPermit.receiptNum}"
					disabled="true">

				</aui:input>
			</aui:col>

		</aui:row>

		<aui:row>
			<aui:col span="6">
				<aui:input label="建设单位" name="company" cssClass="span8"
					value="${constructionPermit.company}">
					<aui:validator name="required" errorMessage="建设单位不能为空!"></aui:validator>

				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input label="建设单位性质" name="companyProperty" cssClass="span8"
					value="${constructionPermit.companyProperty}">

				</aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="建设单位法定代表人" name="legalPerson"
					cssClass="span8" value="${constructionPermit.legalPerson}">

				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="建设单位联系人" name="companyContacts"
					cssClass="span8" value="${constructionPermit.companyContacts}">

				</aui:input>
			</aui:col>

		</aui:row>

		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="建设单位联系电话" name="companyTel"
					cssClass="span8" value="${constructionPermit.companyTel}">
					<aui:validator name="digits"></aui:validator>
				</aui:input>
			</aui:col>

			<aui:col span="6">
				<aui:input type="text" label="手机号" name="companyContactPhone"
					cssClass="span8" value="${constructionPermit.companyContactPhone}">
					<aui:validator name="digits"></aui:validator>
				</aui:input>
			</aui:col>

		</aui:row>


		<aui:row>

			<aui:col span="6">
				<aui:input type="text" label="建设单位地址" name="companyAddress"
					cssClass="span8" value="${constructionPermit.companyAddress}">
				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="建设地点" name="companySite"
					cssClass="span8" value="${constructionPermit.companySite}">

				</aui:input>
			</aui:col>
		</aui:row>



		<aui:row>
			<aui:col span="2" cssClass="textcenter">
			建设地点所属区县
			</aui:col>
			<aui:col span="6">

				<c:forEach items="<%=areaNameDics%>" var="areaNameDic">
					<aui:input type="radio" name="companySiteCounty"
						label="${areaNameDic.name}" inlineLabel="right" inlineField="true"
						value="${areaNameDic.dictionaryId}"
						checked="${constructionPermit.companySiteCounty eq areaNameDic.dictionaryId}"></aui:input>
				</c:forEach>

			</aui:col>
		</aui:row>



		<aui:row>
			<aui:col span="2" cssClass="textcenter">
			建设工程类别
			</aui:col>
			<aui:col span="10">
				<c:forEach items="<%=consTypeDics%>" var="consTypeDic">
					<c:if
						test='${fn:contains(constructionPermit.engineerCategory, consTypeDic.dictionaryId)}'>
						<c:set var="isChecked" value="true"></c:set>
					</c:if>
					<aui:input type="checkbox" name="engineerCategory"
						label="${consTypeDic.name}" inlineLabel="right" inlineField="true"
						value="${consTypeDic.dictionaryId}" checked="${isChecked}" />
					<c:set var="isChecked" value="false"></c:set>
				</c:forEach>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="2" cssClass="textcenter">
			建设工程属性
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
				<aui:input type="text" label="建设工程规模" name="engineerScale"
					cssClass="span8" value="${constructionPermit.engineerScale}">

				</aui:input>
			</aui:col>

			<aui:col span="6">
				<aui:input type="text" label="国有资金比重%"
					name="nationalFundsProportion" cssClass="span8"
					value="${constructionPermit.nationalFundsProportion}">

				</aui:input>
			</aui:col>

		</aui:row>

		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="合同价格" name="contractPrice"
					cssClass="span8" value="${constructionPermit.contractPrice}">

				</aui:input>
			</aui:col>

			<aui:col span="6">
				<aui:input type="text" label="合同工期" name="contractSchedule"
					cssClass="span8" value="${constructionPermit.contractSchedule}">
				</aui:input>
			</aui:col>

		</aui:row>


		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="中标价格" name="bidPrice" cssClass="span8"
					value="${constructionPermit.bidPrice}">

				</aui:input>
			</aui:col>

			<aui:col span="6">
				<aui:input type="text" label="项目投资估算" name="investBudget"
					cssClass="span8" value="${constructionPermit.investBudget}">
				</aui:input>
			</aui:col>

		</aui:row>

		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="计划开工" name="planStartDate"
					value="<%=consPer.getPlanStartDate() == null ? null : sf.format(consPer
										.getPlanStartDate())%>"
					onfocus="WdatePicker({lang:'zh-cn'})">

				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="计划竣工" name="planEndDate"
					value="<%=consPer.getPlanEndDate() == null ? null : sf.format(consPer.getPlanEndDate())%>"
					onfocus="WdatePicker({lang:'zh-cn'})">
				</aui:input>
			</aui:col>

		</aui:row>
		<aui:row>
			<aui:col span="6">
				<aui:input type="textarea" label="现场开工情况" cssClass="span8"
					value="${constructionPermit.workSituation}" name="workSituation">
				</aui:input>
			</aui:col>
		</aui:row>



	</liferay-ui:panel>
	<c:if test="${constructionPermit.status ge 0}">
<c:if test="${not empty materials}">
		<liferay-ui:panel title="相关单位信息" defaultState="">
			<%-- 	<liferay-ui:panel title="主要设计单位名称" defaultState=""> --%>
			<aui:row>
				<aui:col span="12">
					<aui:input type="text" label="主要设计单位名称" name="designCompany"
						cssClass="span12" value="${permitApplication.designCompany}">
					</aui:input>
				</aui:col>
			</aui:row>

			<aui:row>
				<aui:col span="6">
					<aui:input type="text" label="招标方式" name="designTenderMethod"
						cssClass="span8" value="${permitApplication.designTenderMethod}">
					</aui:input>
				</aui:col>
				<aui:col span="6">
					<aui:input type="text" label="中标价" name="designBidPrice"
						cssClass="span8" value="${permitApplication.designBidPrice}">
					</aui:input>
				</aui:col>
			</aui:row>

			<aui:row>
				<aui:col span="6">
					<aui:input type="text" label="资质等级" name="designQualificationLevel"
						cssClass="span8"
						value="${permitApplication.designQualificationLevel}">
					</aui:input>
				</aui:col>

				<aui:col span="6">
					<aui:input type="text" label="证书编号"
						name="designLevelCertificateCode" cssClass="span8"
						value="${permitApplication.designLevelCertificateCode}">
					</aui:input>
				</aui:col>
			</aui:row>

			<aui:row>
				<aui:col span="6">
					<aui:input type="text" label="项目负责人" name="designProjectLeader"
						cssClass="span8" value="${permitApplication.designProjectLeader}">
					</aui:input>
				</aui:col>
				<aui:col span="6">
					<aui:input type="text" label="证书编号"
						name="designLeaderCertificateCode" cssClass="span8"
						value="${permitApplication.designLeaderCertificateCode}">
					</aui:input>
				</aui:col>
			</aui:row>
			<%-- </liferay-ui:panel>
	<liferay-ui:panel title="主要监理单位" defaultState=""> --%>
			<aui:row>
				<aui:col span="12">
					<aui:input type="text" label="主要监理单位名称" name="supervisionCompany"
						cssClass="span12" value="${permitApplication.supervisionCompany}">
					</aui:input>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col span="6">
					<aui:input type="text" label="招标方式" name="supervisionTenderMethod"
						cssClass="span8"
						value="${permitApplication.supervisionTenderMethod}">
					</aui:input>
				</aui:col>
				<aui:col span="6">
					<aui:input type="text" label="中标价" name="supervisionBidPrice"
						cssClass="span8" value="${permitApplication.supervisionBidPrice}">
					</aui:input>
				</aui:col>
			</aui:row>

			<aui:row>
				<aui:col span="6">
					<aui:input type="text" label="资质等级"
						name="supervisionQualificationLevel" cssClass="span8"
						value="${permitApplication.supervisionQualificationLevel}">
					</aui:input>
				</aui:col>

				<aui:col span="6">
					<aui:input type="text" label="证书编号"
						name="supervisionLevelCertificateCode" cssClass="span8"
						value="${permitApplication.supervisionLevelCertificateCode}">
					</aui:input>
				</aui:col>
			</aui:row>

			<aui:row>
				<aui:col span="6">
					<aui:input type="text" label="项目负责人"
						name="supervisionProjectLeader" cssClass="span8"
						value="${permitApplication.supervisionProjectLeader}">
					</aui:input>
				</aui:col>
				<aui:col span="6">
					<aui:input type="text" label="证书编号"
						name="supervisionLeaderCertificateCode" cssClass="span8"
						value="${permitApplication.supervisionLeaderCertificateCode}">
					</aui:input>
				</aui:col>
			</aui:row>
			<%-- </liferay-ui:panel>
	<liferay-ui:panel title="主要施工单位" defaultState=""> --%>
			<aui:row>
				<aui:col span="12">
					<aui:input type="text" label="主要施工单位名称" name="constructionCompany"
						cssClass="span12" value="${permitApplication.constructionCompany}">
					</aui:input>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col span="6">
					<aui:input type="text" label="招标方式" name="constructionTenderMethod"
						cssClass="span8"
						value="${permitApplication.constructionTenderMethod}">
					</aui:input>
				</aui:col>
				<aui:col span="6">
					<aui:input type="text" label="中标价" name="constructionBidPrice"
						cssClass="span8" value="${permitApplication.constructionBidPrice}">
					</aui:input>
				</aui:col>
			</aui:row>

			<aui:row>
				<aui:col span="6">
					<aui:input type="text" label="资质等级"
						name="constructionQualificationLevel" cssClass="span8"
						value="${permitApplication.constructionQualificationLevel}">
					</aui:input>
				</aui:col>

				<aui:col span="6">
					<aui:input type="text" label="证书编号"
						name="constructionLevelCertificateCode" cssClass="span8"
						value="${permitApplication.constructionLevelCertificateCode}">
					</aui:input>
				</aui:col>
			</aui:row>

			<aui:row>
				<aui:col span="6">
					<aui:input type="text" label="项目负责人"
						name="constructionProjectLeader" cssClass="span8"
						value="${permitApplication.constructionProjectLeader}">
					</aui:input>
				</aui:col>
				<aui:col span="6">
					<aui:input type="text" label="证书编号"
						name="constructionLeaderCertificateCode" cssClass="span8"
						value="${permitApplication.constructionLeaderCertificateCode}">
					</aui:input>
				</aui:col>
			</aui:row>

		</liferay-ui:panel>
		<liferay-ui:panel title="建设依据信息" defaultState="">
			<aui:row>
				<aui:col span="6">
					<aui:input type="text" label="工可批准或核准机关和文号"
						value="${permitApplication.feasibilityApprovalOrganAndNumber}"
						name="feasibilityApprovalOrganAndNumber" cssClass="span8">
					</aui:input>
				</aui:col>
				<aui:col span="6">
					<aui:input type="text" label="批复或核准日期" class="Wdate"
						value="<%=perApp.getFeasibilityReplyDate() == null ? null : sf.format(perApp
											.getFeasibilityReplyDate())%>"
						name="feasibilityReplyDate" onfocus="WdatePicker({lang:'zh-cn'})"
						cssClass="span8">
					</aui:input>
				</aui:col>
			</aui:row>

			<aui:row>
				<aui:col span="6">
					<aui:input type="text" label="初步设计批准机关和文号"
						name="initialDesignApprovalOrganAndNumber" cssClass="span8"
						value="${permitApplication.initialDesignApprovalOrganAndNumber}">
					</aui:input>
				</aui:col>
				<aui:col span="6">
					<aui:input type="text" label="投资估算" name="investmentEstimation"
						cssClass="span8" value="${permitApplication.investmentEstimation}">
					</aui:input>
				</aui:col>
			</aui:row>

			<aui:row>
				<aui:col span="6">
					<aui:input type="text" label="批复日期" class="Wdate"
						value="<%=perApp.getInitialDesignReplyDate() == null ? null : sf.format(perApp
											.getInitialDesignReplyDate())%>"
						name="initialDesignReplyDate"
						onfocus="WdatePicker({lang:'zh-cn'})" cssClass="span8">
					</aui:input>
				</aui:col>
				<aui:col span="6">
					<aui:input type="text" label="批复工程" name="replyProject"
						cssClass="span8" value="${permitApplication.replyProject}">
					</aui:input>
				</aui:col>
			</aui:row>


			<aui:row>
				<aui:col span="6">
					<aui:input type="text" label="总概算" name="totalBudget"
						cssClass="span8" value="${permitApplication.totalBudget}">
					</aui:input>
				</aui:col>
				<aui:col span="6">
					<aui:input type="text" label="主体工程施工图批准机关和文号"
						name="constructionDrawingApprovalOrganAndNumber" cssClass="span8"
						value="${permitApplication.constructionDrawingApprovalOrganAndNumber}">
					</aui:input>
				</aui:col>
			</aui:row>

			<aui:row>
				<aui:col span="6">
					<aui:input type="text" label="投资来源" name="investmentSource"
						cssClass="span8" value="${permitApplication.investmentSource}">
					</aui:input>
				</aui:col>
			</aui:row>
		</liferay-ui:panel>
		
			<liferay-ui:panel title="附件信息" defaultState="">
				<table class="table table-bordered">
					<tr>
						<td class="span1" style="text-align: center">序号</td>
						<td class="span5">申请材料名称</td>
						<td class="span2" style="text-align: center">应交分数</td>
						<td class="span2" style="text-align: center">实交分数</td>
						<td class="span2" style="text-align: center">附件</td>
					</tr>
					<c:forEach var="constructionApplyMaterial" items="${materials}"
						varStatus="status">
						<tr style="text-align: center">
							<td class="span1" style="text-align: center">${constructionApplyMaterial.sortNo}</td>
							<td class="span5">${constructionApplyMaterial.materialName}</td>
							<td class="span2" style="text-align: center">${constructionApplyMaterial.yjNum}</td>
							<td class="span2" style="text-align: center">${constructionApplyMaterial.realPostNum}</td>
							<td class="span2" style="text-align: center"><c:forEach
									items="${constructionApplyMaterial.filePaths}" var="filePath"
									varStatus="status">
									<a href="${filePath}"><img
										src="<%=request.getContextPath()%>/icons/download.png"
										alt="下载" /></a>
								</c:forEach></td>
						</tr>
					</c:forEach>
				</table>
			</liferay-ui:panel>
		</c:if>
	</c:if>
</liferay-ui:panel-container>




