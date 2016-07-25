<%@ page contentType="text/html;charset=utf-8"%>
<%@include file="/common/init.jsp"%>

<c:set var="contentPath" value="${request.contextPath}/portlet/project" />
<portlet:renderURL var="viewURL" />
<portlet:actionURL var="saveProject" name="saveProject">
	<portlet:param name="redirect" value="${viewURL}" />
</portlet:actionURL>

<%
	Long projectId = ParamUtil.getLong(request, "projectId");
	String title = "添加项目信息";
	List<Company> companies = CompanyLocalServiceUtil.findByProjectId(projectId);

	Project project = null;
	if (Validator.isNotNull(projectId)) {
		title = "编辑项目信息";
		project = ProjectLocalServiceUtil.getProject(projectId);
		request.setAttribute("project", project);
	}

	long groupId = PortalUtil.getScopeGroupId(request);
	Dictionary projectTypeDic = DictionaryLocalServiceUtil.findByGroupIdAndCode(groupId, "ProjectType");
	Dictionary projectPropertyDic = DictionaryLocalServiceUtil.findByGroupIdAndCode(groupId, "ProjectProperty");
	Dictionary areaNameDic = DictionaryLocalServiceUtil.findByGroupIdAndCode(groupId, "AreaName");
	Dictionary constructionTypeDic = DictionaryLocalServiceUtil.findByGroupIdAndCode(groupId,
			"ConstructionType");
	Dictionary constructionPropertyDic = DictionaryLocalServiceUtil.findByGroupIdAndCode(groupId,
			"ConstructionProperty");
	Dictionary projectStatusDic = DictionaryLocalServiceUtil.findByGroupIdAndCode(groupId, "ProjectStatus");
	Dictionary serviceTypeDic = DictionaryLocalServiceUtil.findByGroupIdAndCode(groupId, "ServiceType");
	Dictionary manageTypeDic = DictionaryLocalServiceUtil.findByGroupIdAndCode(groupId, "ManageType");
	Dictionary projectSourceDic = DictionaryLocalServiceUtil.findByGroupIdAndCode(groupId, "ProjectSource");
	Dictionary projectPropertiesDic = DictionaryLocalServiceUtil.findByGroupIdAndCode(groupId,
			"ProjectProperties");
	Dictionary roadLevelDic = DictionaryLocalServiceUtil.findByGroupIdAndCode(groupId, "RoadLevel");
	Dictionary roadTechLevelDic = DictionaryLocalServiceUtil.findByGroupIdAndCode(groupId, "RoadTechLevel");
	Dictionary companyTypeDic = DictionaryLocalServiceUtil.findByGroupIdAndCode(groupId, "CompanyType");
	List<Dictionary> projectTypes = projectTypeDic != null ? DictionaryLocalServiceUtil
			.findByGroupIdAndParentId(groupId, projectTypeDic.getDictionaryId(), -1, -1) : null;
	List<Dictionary> projectPropertys = projectPropertyDic != null ? DictionaryLocalServiceUtil
			.findByGroupIdAndParentId(groupId, projectPropertyDic.getDictionaryId(), -1, -1) : null;
	List<Dictionary> areaNames = areaNameDic != null ? DictionaryLocalServiceUtil.findByGroupIdAndParentId(
			groupId, areaNameDic.getDictionaryId(), -1, -1) : null;
	List<Dictionary> constructionTypes = constructionTypeDic != null ? DictionaryLocalServiceUtil
			.findByGroupIdAndParentId(groupId, constructionTypeDic.getDictionaryId(), -1, -1) : null;
	List<Dictionary> constructionPropertys = constructionPropertyDic != null ? DictionaryLocalServiceUtil
			.findByGroupIdAndParentId(groupId, constructionPropertyDic.getDictionaryId(), -1, -1) : null;
	List<Dictionary> projectStatuses = projectStatusDic != null ? DictionaryLocalServiceUtil
			.findByGroupIdAndParentId(groupId, projectStatusDic.getDictionaryId(), -1, -1) : null;
	List<Dictionary> serviceTypes = serviceTypeDic != null ? DictionaryLocalServiceUtil
			.findByGroupIdAndParentId(groupId, serviceTypeDic.getDictionaryId(), -1, -1) : null;
	List<Dictionary> manageTypes = manageTypeDic != null ? DictionaryLocalServiceUtil.findByGroupIdAndParentId(
			groupId, manageTypeDic.getDictionaryId(), -1, -1) : null;
	List<Dictionary> projectSources = projectSourceDic != null ? DictionaryLocalServiceUtil
			.findByGroupIdAndParentId(groupId, projectSourceDic.getDictionaryId(), -1, -1) : null;
	List<Dictionary> projectProperties = projectPropertiesDic != null ? DictionaryLocalServiceUtil
			.findByGroupIdAndParentId(groupId, projectPropertiesDic.getDictionaryId(), -1, -1) : null;
	List<Dictionary> roadLevels = roadLevelDic != null ? DictionaryLocalServiceUtil.findByGroupIdAndParentId(
			groupId, roadLevelDic.getDictionaryId(), -1, -1) : null;
	List<Dictionary> roadTechLevels = roadTechLevelDic != null ? DictionaryLocalServiceUtil
			.findByGroupIdAndParentId(groupId, roadTechLevelDic.getDictionaryId(), -1, -1) : null;
	List<Dictionary> companyTypes = companyTypeDic != null ? DictionaryLocalServiceUtil
			.findByGroupIdAndParentId(groupId, companyTypeDic.getDictionaryId(), -1, -1) : null;

	request.setAttribute("projectTypes", projectTypes);
	request.setAttribute("projectPropertys", projectPropertys);
	request.setAttribute("areaNames", areaNames);
	request.setAttribute("constructionTypes", constructionTypes);
	request.setAttribute("constructionPropertys", constructionPropertys);
	request.setAttribute("projectStatuses", projectStatuses);
	request.setAttribute("manageTypes", manageTypes);
	request.setAttribute("projectSources", projectSources);
	request.setAttribute("projectProperties", projectProperties);
	request.setAttribute("roadLevels", roadLevels);
	request.setAttribute("serviceTypes", serviceTypes);
	request.setAttribute("roadTechLevels", roadTechLevels);
	Map<Dictionary, Company> companyMap = new TreeMap<Dictionary, Company>();

	String companyName = "";
	for (Dictionary dictionary : companyTypes) {
		companyMap.put(dictionary, null);
		if (companies != null) {
			for (Company companyDept : companies) {
				Dictionary dictionary1 = DictionaryLocalServiceUtil.getDictionary(companyDept.getType());
				if (dictionary.equals(dictionary1)) {
					companyMap.put(dictionary, companyDept);
				}
			}
		}
		companyName += "," + dictionary.getName();
	}
	request.setAttribute("companyMap", companyMap);
	request.setAttribute("companyName", companyName.substring(1));
%>
<liferay-ui:header title="<%=title %>" backURL="${def}" />
<aui:form action="${saveProject}" method="post">
	<liferay-ui:panel-container accordion="true" extended="true">
		<liferay-ui:panel title="项目基本信息">
			<aui:fieldset>
				<%-- <aui:input name="projectId" type="hidden" value="<%=projectId%>" /> --%>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<label class="control-label"> 项目编号 </label>
						${project.projNum}
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<label class="control-label"> 项目名称 </label>
						${project.projName}
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<label class="control-label"> 项目排序号</label>${project.sortNo}
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<label class="control-label"> 实际开工</label>
						<fmt:formatDate value="${project.startDate }" pattern="yyyy-MM-dd" />
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<aui:select label="项目状态" name="projStatus" disabled="true">
							<c:forEach items="${projectStatuses }" var="projStatus">
								<aui:option value="${projStatus.dictionaryId}"
									selected="${projStatus.dictionaryId eq project.projStatus}">${projStatus.name }</aui:option>
							</c:forEach>
						</aui:select>
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<label class="control-label"> 实际完成 </label>
						<fmt:formatDate value="${project.endDate }" pattern="yyyy-MM-dd" />
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<aui:select disabled="true" label="业态类别" name="industryCategory">
							<c:forEach items="${serviceTypes }" var="industryCategory">
								<aui:option value="${industryCategory.dictionaryId}"
									selected="${industryCategory.dictionaryId eq project.industryCategory}">${industryCategory.name }</aui:option>
							</c:forEach>
						</aui:select>
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<aui:field-wrapper name="涉及区县">
							<c:forEach items="${areaNames }" var="areaName"
								varStatus="sortNo">
								<aui:input name="involveCounty" type="checkbox" disabled="true"
									value="${areaName.dictionaryId}"
									checked="${fn:contains(project.involveCounty ,areaName.dictionaryId) }"
									label="${areaName. name}" inlineField="true" />
								<c:if test="${sortNo.index>0 && (sortNo.index+1) % 9 == 0}">
									<br>
								</c:if>
							</c:forEach>
						</aui:field-wrapper>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<aui:select disabled="true" label="管理属性" name="manageAttr" inlineField="true">
							<c:forEach items="${manageTypes }" var="managerAttr">
								<aui:option value="${managerAttr. dictionaryId }"
									selected="${managerAttr. dictionaryId eq project.manageAttr }">${managerAttr.name }</aui:option>
							</c:forEach>
						</aui:select>
						<aui:select disabled="true" label="" name="isMajor" inlineField="true">
							<aui:option value="1" selected="${project. isMajor}">重大</aui:option>
							<aui:option value="0" selected="${!project. isMajor}">非重大</aui:option>
						</aui:select>
					</aui:col>

					<aui:col span="6" cssClass="text-left">
						<label class="control-label"> 规划红线（宽度m）</label>${project.ghhx}
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<aui:select disabled="true" label="项目来源" name="projSource">
							<c:forEach items="${projectSources }" var="projSource">
								<aui:option value="${projSource. dictionaryId }"
									selected="${projSource.dictionaryId eq project.projSource}">${projSource.name }</aui:option>
							</c:forEach>
						</aui:select>
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<aui:select disabled="true" label="道路技术等级" name="roadTechLevel">
							<c:forEach items="${roadTechLevels }" var="roadTechLevel">
								<aui:option value="${roadTechLevel.dictionaryId }"
									selected="${roadTechLevel.dictionaryId eq project.roadTechLevel}">${roadTechLevel.name }</aui:option>
							</c:forEach>
						</aui:select>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<aui:select disabled="true" label="所属区县" name="belongCounty">
							<aui:option value="0">上海市</aui:option>
							<c:forEach items="${countys }" var="belongCounty">
								<aui:option value="${belongCounty.dictionaryId}"
									selected="${belongCounty.dictionaryId eq project.belongCounty}">${project.belongCounty }</aui:option>
							</c:forEach>
						</aui:select>
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<aui:select disabled="true" label="道路等级" name="roadLevel">
							<c:forEach items="${roadLevels }" var="roadLevel">
								<aui:option value="${roadLevel.dictionaryId}"
									selected="${roadLevel.dictionaryId eq project.roadLevel}">${roadLevel .name}</aui:option>
							</c:forEach>
						</aui:select>
					</aui:col>

				</aui:row>

				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<aui:select disabled="true" label="项目属性" name="projAttr">
							<c:forEach items="${projectProperties }" var="projAttr">
								<aui:option value="${projAttr.dictionaryId }"
									selected="${projAttr.dictionaryId eq project.projAttr}">${projAttr.name }</aui:option>
							</c:forEach>
						</aui:select>
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<label class="control-label"> 起讫地点</label>${project.location}
					</aui:col>
				</aui:row>
			</aui:fieldset>
		</liferay-ui:panel>
		<liferay-ui:panel title="项目扩展信息">
			<aui:fieldset>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<label class="control-label"> 目标开工节点 </label>
						<fmt:formatDate value="${project.startNode }" pattern="yyyy-MM-dd" />
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<label class="control-label"> 计划总投资</label>${project.planTotle}
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<label class="control-label"> 目标开工节点 </label>
						<fmt:formatDate value="${project.endNode }" pattern="yyyy-MM-dd" />
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<label class="control-label"> 工可批复总投资</label>${project.gkpfTotle}
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<label class="control-label"> 目标开工节点 </label>
						<fmt:formatDate value="${project.planStartDate }"
							pattern="yyyy-MM-dd" />
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<label class="control-label"> 工可批复前期费用</label>${project.gkpfPre}
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<label class="control-label"> 目标开工节点</label>
						<fmt:formatDate value="${project.planEndDate }"
							pattern="yyyy-MM-dd" />
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<label class="control-label"> 工可批复建安费用</label>${project.gkpfJafy}
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<label class="control-label"> 工程范围和主要内容</label>${project.introduction}
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<label class="control-label"> 初设批复总投资</label>${project.csTotle}
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<label class="control-label"> 初设批复前期费用</label>${project.csPre}
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<label class="control-label"> 初设批复建安费用</label>${project.csJafy}
					</aui:col>
				</aui:row>

				<liferay-ui:tabs names="${companyName }" refresh="false">
					<c:forEach items="${companyMap }" var="map">
						<liferay-ui:section>
							<aui:row>
								<aui:col span="6" cssClass="text-left">
									<label class="control-label"> ${map.key.name }</label>${map.value.unitName}
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="3" cssClass="text-left">
									<label class="control-label"> 独立法人</label>${map.value.indepLegal}
								</aui:col>
								<aui:col span="3" cssClass="text-left">
									<label class="control-label"> 独立法人电话</label>${map.value.indepLegalTel}
								</aui:col>
								<aui:col span="3" cssClass="text-left">
									<label class="control-label"> 独立法人传真</label>${map.value.indepLegalFax}
								</aui:col>
								<aui:col span="3" cssClass="text-left">
									<label class="control-label"> 独立法人手机</label>${map.value.indepLegalPhone}
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="3" cssClass="text-left">
									<label class="control-label"> 项目法人</label>${map.value.projLegal}
								</aui:col>
								<aui:col span="3" cssClass="text-left">
									<label class="control-label"> 项目法人电话</label>${map.value.projLegalTel}
								</aui:col>
								<aui:col span="3" cssClass="text-left">
									<label class="control-label"> 项目法人传真</label>${map.value.projLegalFax}
								</aui:col>
								<aui:col span="3" cssClass="text-left">
									<label class="control-label"> 项目法人手机</label>${map.value.projLegalPhone}
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="3" cssClass="text-left">
									<label class="control-label"> 联系人</label>${map.value.linkman}
								</aui:col>
								<aui:col span="3" cssClass="text-left">
									<label class="control-label"> 联系人电话</label>${map.value.linkmanTel}
								</aui:col>
								<aui:col span="3" cssClass="text-left">
									<label class="control-label"> 联系人传真</label>${map.value.linkmanFax}
								</aui:col>
								<aui:col span="3" cssClass="text-left">
									<label class="control-label"> 联系人手机 </label>${map.value.linkmanPhone}
								</aui:col>
							</aui:row>
						</liferay-ui:section>
					</c:forEach>
				</liferay-ui:tabs>

			</aui:fieldset>
		</liferay-ui:panel>
	</liferay-ui:panel-container>
	<aui:button type="submit"></aui:button>
	<aui:button type="reset" value="重置"></aui:button>
</aui:form>
