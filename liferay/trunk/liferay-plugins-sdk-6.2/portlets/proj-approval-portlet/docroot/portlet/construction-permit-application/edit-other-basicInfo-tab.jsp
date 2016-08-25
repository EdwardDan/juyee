<%@page import="com.liferay.portal.kernel.search.Document"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<c:set var="namespace" value="<%=renderResponse.getNamespace()%>"></c:set>
<%
	SimpleDateFormat sf = new SimpleDateFormat(defaultDateFormatPattern);
	ConstructionPermit consPer = (ConstructionPermit) renderRequest.getAttribute("constructionPermit");
	if (consPer == null) {
		consPer = new ConstructionPermitClp();
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

	String projectTypeCode = (String) renderRequest.getAttribute("projectTypeCode");
	System.out.println(projectTypeCode);
	List<ConstructionPermitMaterial> materials;
	List<ConstructionPermitMaterial> applyMaterials = new ArrayList<ConstructionPermitMaterial>();
	if (Validator.isNotNull(projectTypeCode)) {
		Dictionary channelDictionary = DictionaryLocalServiceUtil.findByCode(projectTypeCode);
		String jsonString = channelDictionary.getCustomContent();
		materials = JSON.parseArray(jsonString, ConstructionPermitMaterial.class);
		for (ConstructionPermitMaterial material : materials) {
			long type = material.getType();
			Dictionary materialType = DictionaryLocalServiceUtil.getDictionary(type);
			if (materialType.getCode().equals("apply")) {
				applyMaterials.add(material);
			}
		}
	}
%>
<c:set var="applyMaterials" value="<%=applyMaterials%>" />
<!--编辑时，从后台传来的对象集合materials  -->
<c:if test="${materials!=null}">
	<c:set var="applyMaterials" value="${materials}" />
</c:if>



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
					cssClass="Wdate"
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
					<aui:validator name="digits" />

				</aui:input>
			</aui:col>

			<aui:col span="6">
				<aui:input type="text" label="手机号" name="companyContactPhone"
					cssClass="span8" value="${constructionPermit.companyContactPhone}">
					<aui:validator name="digits" />

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
					<aui:validator name="number" />
				</aui:input>
			</aui:col>

		</aui:row>

		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="合同价格" name="contractPrice"
					cssClass="span8" value="${constructionPermit.contractPrice}">
					<aui:validator name="number" />
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
					<aui:validator name="number" />
				</aui:input>
			</aui:col>

			<aui:col span="6">
				<aui:input type="text" label="项目投资估算" name="investBudget"
					cssClass="span8" value="${constructionPermit.investBudget}">
					<aui:validator name="number" />
				</aui:input>
			</aui:col>

		</aui:row>

		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="计划开工" name="planStartDate"
					id="planStartDate" cssClass="Wdate"
					value="<%=consPer.getPlanStartDate() == null ? null : sf.format(consPer
										.getPlanStartDate())%>"
					onfocus="WdatePicker({maxDate:'#F{$dp.$D(\\'${namespace}planEndDate\\')}',maxDate:'2020-10-01'})">

				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="计划竣工" name="planEndDate"
					id="planEndDate" cssClass="Wdate"
					value="<%=consPer.getPlanEndDate() == null ? null : sf.format(consPer.getPlanEndDate())%>"
					onfocus="WdatePicker({minDate:'#F{$dp.$D(\\'${namespace}planStartDate\\')}',maxDate:'2020-10-01'})">
				</aui:input>

			</aui:col>

		</aui:row>
		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="施工单位名称" cssClass="span8"
					value="${permitApplication.constructionCompany}"
					name="constructionCompany">

				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="项目经理" cssClass="span8"
					value="${permitApplication.projManager}" name="projManager">

				</aui:input>
			</aui:col>
		</aui:row>

		<aui:row>


			<aui:col span="6">
				<aui:input type="text" label="监理单位名称" name="supervisionCompany"
					cssClass="span8" value="${permitApplication.supervisionCompany}">
				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="项目总监" cssClass="span8"
					value="${permitApplication.projDirector}" name="projDirector">
				</aui:input>
			</aui:col>
		</aui:row>

		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="设计单位名称" cssClass="span8"
					value="${permitApplication.designCompany}" name="designCompany">
				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="textarea" label="现场开工情况" cssClass="span8"
					value="${constructionPermit.workSituation}" name="workSituation">
				</aui:input>
			</aui:col>
		</aui:row>

	</liferay-ui:panel>
	<c:if test="${constructionPermit.status ge 0}">
		<liferay-ui:panel title="附件信息" defaultState="">
			<table class="table table-bordered">
				<tr style="text-align: center">
					<td class="span1" style="text-align: center">序号</td>
					<td class="span5">申请材料名称</td>
					<td class="span2" style="text-align: center">应交分数</td>
					<td class="span2" style="text-align: center">实交分数</td>
					<td class="span2" style="text-align: center">附件</td>
				</tr>
				<c:forEach var="constructionApplyMaterial" items="${applyMaterials}"
					varStatus="status">
					<tr style="text-align: center">
						<td class="span1" style="text-align: center">${constructionApplyMaterial.sortNo}</td>
						<td class="span5">${constructionApplyMaterial.materialName}</td>
						<td class="span2" style="text-align: center">${constructionApplyMaterial.yjNum}</td>
						<td class="span2" style="text-align: center"><aui:input
								type="text" label="" name="realPostNum" cssClass="span4"
								value="${constructionApplyMaterial.realPostNum==null?0:constructionApplyMaterial.realPostNum}">
							</aui:input></td>

						<td class="span2" style="text-align: center">
						<a href="javascript:void(0);" onclick="uploadedDocument()">
						<img src="<%=request.getContextPath()%>/icons/document.png" alt="文件"/></a>
						<input name="${namespace}applyMaterial${constructionApplyMaterial.sortNo}"
							type="file" multiple="multiple"></input>
						</td>
					</tr>
				</c:forEach>
			</table>
		</liferay-ui:panel>
</c:if>
</liferay-ui:panel-container>

<!-- <script>
  function uploadedDocument(){
	  alert(1234);
	  var documentDiv= document.createElement("div");
	  var style=documentDiv.style;
	  style.position="fixed";
	  style['z-index']=99;
	  style.boder="0px cyan solid";
	  style['border-radius'] = '5px';
	  style['background-color'] = 'red';
	  style['color'] = 'black';
	  style.fontSize='18px';
	  style['fontr-weight']='normal';
	  style['paddding']='4px';
	  style['height']='400px';
	  style['width']='400px';
	  documentDiv.innerText='test';
	  documentDiv.id="divTest";
	  document.body.appendChild(documentDiv);
	  $("#divTest").show();
  }

</script> -->





