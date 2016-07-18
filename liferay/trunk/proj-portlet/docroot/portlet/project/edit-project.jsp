<%@ page contentType="text/html;charset=utf-8"%>
<%@include file="/common/init.jsp"%>
<%@include file="/common/init-ext.jsp"%>
<script src="${staticServerURL}/My97DatePicker/WdatePicker.js"></script>

<c:set var="contentPath" value="${request.contextPath}/portlet/project" />
<portlet:actionURL var="input" name="doEdit">
	<portlet:param name="redirect" value="${def}" />
</portlet:actionURL>
<portlet:renderURL var="def" />
<%
	long projectId = ParamUtil.getInteger(request, "projectId");
	String title = "添加项目信息";
	if (Validator.isNotNull(projectId)) {
		title = "编辑项目信息";
	}
	List<String> projStatuses = ProjectManager.getProjStatus();
	List<String> industryCategorys = ProjectManager
	.getIndustryCategory();
	List<String> manageAttrs = ProjectManager.getManageAttr();
	List<String> projAttrs = ProjectManager.getProjAttr();
	List<String> projSources = ProjectManager.getProjSource();
	List<String> roadLevels = ProjectManager.getRoadLevel();
	List<String> roadTechLevels = ProjectManager.getRoadTechLevel();
	List<String> countys = ProjectManager.getCountys();
	List<String> companys =ProjectManager.getCompanys();
	request.setAttribute("projStatuses", projStatuses);
	request.setAttribute("industryCategorys", industryCategorys);
	request.setAttribute("manageAttrs", manageAttrs);
	request.setAttribute("projAttrs", projAttrs);
	request.setAttribute("projSources", projSources);
	request.setAttribute("roadLevels", roadLevels);
	request.setAttribute("roadTechLevels", roadTechLevels);
	request.setAttribute("countys", countys);
	request.setAttribute("companys", companys);
%>
<liferay-ui:header title="<%=title %>" backURL="${def}" />
<aui:form action="${doEdit}" method="post">
	<aui:input name="projectId" type="hidden" value="<%=projectId%>" />
	<div class="row-fluid">
		<div class="span12 lfr-asset-column lfr-asset-column-details">
			<div class="accordion " id="projectPanelContainer">
				<div class="accordion-group lfr-panel lfr-panel-extended">
					<div
						class="accordion-heading toggler-header toggler-header-extended toggler-header-expanded">
						<div class="accordion-toggle">
							<span class="title-text"> 项目基本信息 </span>
						</div>
					</div>
					<div class="toggler-content toggler-content-extended">
						<div class="accordion-inner">
							<div class="form-section active tab-pane" role="tabpanel"
								aria-labelledby="_2_detailsLink">
								<div class="row-fluid">
									<fieldset class="fieldset span6">
										<aui:input type="text" label="项目编号" inlineLabel="true"
											name="projNum" value="${projNum}">
											<aui:validator name="required" errorMessage="项目编号不能为空!"></aui:validator>
											<aui:validator name="maxLength" errorMessage="">75</aui:validator>
										</aui:input>
										<aui:input type="text" label="项目排序号" inlineLabel="true"
											name="sortNo" value="${sortNo}">
											<aui:validator name="required" errorMessage="项目排序号不能为空!"></aui:validator>
										</aui:input>
										<aui:select label="项目状态" inlineLabel="true" name="projStatus">
											<c:forEach items="${projStatuses }" var="projStatus"
												varStatus="sortNo">
												<aui:option value="${sortNo.index+1 }">${projStatus }</aui:option>
											</c:forEach>
										</aui:select>
										<aui:select label="业态类别" inlineLabel="true"
											name="industryCategory">
											<c:forEach items="${industryCategorys }"
												var="industryCategory" varStatus="sortNo">
												<aui:option value="${sortNo.index+1 }">${industryCategory }</aui:option>
											</c:forEach>
										</aui:select>
										<aui:select label="管理属性" inlineLabel="true" name="manageAttr"
											inlineField="true">
											<c:forEach items="${manageAttrs }" var="managerAttr"
												varStatus="sortNo">
												<aui:option value="${sortNo.index+1 }">${managerAttr }</aui:option>
											</c:forEach>
										</aui:select>
										<aui:select label="" inlineLabel="true" name="isMajor"
											inlineField="true">
											<aui:option value="1">重大</aui:option>
											<aui:option value="0">非重大</aui:option>
										</aui:select>
										<aui:select label="项目来源" inlineLabel="true" name="projSource">
											<c:forEach items="${projSources }" var="projSource"
												varStatus="sortNo">
												<aui:option value="${sortNo.index+1 }">${projSource }</aui:option>
											</c:forEach>
										</aui:select>
										<aui:select label="所属区县" inlineLabel="true"
											name="belongCounty">
											<aui:option value="0">上海市</aui:option>
											<c:forEach items="${countys }" var="belongCounty"
												varStatus="sortNo">
												<aui:option value="${sortNo.index+1 }">${belongCounty }</aui:option>
											</c:forEach>
										</aui:select>
										<aui:select label="项目属性" inlineLabel="true" name="projAttr">
											<c:forEach items="${projAttrs }" var="projAttr"
												varStatus="sortNo">
												<aui:option value="${sortNo.index+1 }">${projAttr }</aui:option>
											</c:forEach>
										</aui:select>
										<aui:input type="text" label="起讫地点" inlineLabel="true"
											name="location" value="${location}">
											<aui:validator name="required" errorMessage="起讫地点不能为空!"></aui:validator>
										</aui:input>
									</fieldset>
									<fieldset class="fieldset span6">
										<aui:input type="text" label="项目名称" inlineLabel="true"
											name="projName" value="${projName}">
											<aui:validator name="required" errorMessage="项目名称不能为空!"></aui:validator>
										</aui:input>
										<aui:input type="text" label="实际开工" inlineLabel="true"
											class="Wdate" name="startDate"
											onfocus="WdatePicker({lang:'zh-cn'})" value="">
											<aui:validator name="required" errorMessage="实际开工不能为空!"></aui:validator>
										</aui:input>
										<aui:input type="text" label="实际完成" inlineLabel="true"
											class="Wdate" name="endDate"
											onfocus="WdatePicker({lang:'zh-cn'})" value="">
											<aui:validator name="required" errorMessage="实际完成不能为空!"></aui:validator>
										</aui:input>
										<aui:field-wrapper name="涉及区县">
											<c:forEach items="${countys }" var="county"
												varStatus="sortNo">
												<aui:input name="involveCounty" type="checkbox"
													value="${sortNo.index+1 }" label="${county }"
													inlineField="true" />
												<c:if test="${sortNo.index>0 && (sortNo.index+1) % 9 == 0}">
													<br>
												</c:if>
											</c:forEach>
										</aui:field-wrapper>
										<aui:input type="text" label="规划红线（宽度m）" inlineLabel="true"
											name="ghhx" value="${ghhx}">
											<aui:validator name="required" errorMessage="规划红线（宽度m）不能为空!"></aui:validator>
										</aui:input>
										<aui:select label="道路技术等级" inlineLabel="true"
											name="roadTechLevel">
											<c:forEach items="${roadTechLevels }" var="roadTechLevel"
												varStatus="sortNo">
												<aui:option value="${sortNo.index+1 }">${roadTechLevel }</aui:option>
											</c:forEach>
										</aui:select>
										<aui:select label="道路等级" inlineLabel="true" name="roadLevel">
											<c:forEach items="${roadLevels }" var="roadLevel"
												varStatus="sortNo">
												<aui:option value="${sortNo.index+1 }">${roadLevel }</aui:option>
											</c:forEach>
										</aui:select>
									</fieldset>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="accordion-group lfr-panel lfr-panel-extended">
					<div
						class="accordion-heading toggler-header toggler-header-extended toggler-header-expanded">
						<div class="accordion-toggle">
							<span class="title-text"> 项目扩展信息 </span>
						</div>
					</div>
					<div class="toggler-content toggler-content-extended">
						<div class="accordion-inner">
							<div class="form-section active tab-pane" role="tabpanel"
								aria-labelledby="_2_detailsLink">
								<div class="row-fluid">
									<fieldset class="fieldset span6">
										<aui:input type="text" label="目标开工节点" inlineLabel="true"
											class="Wdate" name="startNode"
											onfocus="WdatePicker({lang:'zh-cn'})" value="">
											<aui:validator name="required" errorMessage="目标开工节点不能为空!"></aui:validator>
										</aui:input>
										<aui:input type="text" label="目标完工节点" inlineLabel="true"
											class="Wdate" name="endNode"
											onfocus="WdatePicker({lang:'zh-cn'})" value="">
											<aui:validator name="required" errorMessage="目标完工节点不能为空!"></aui:validator>
										</aui:input>
										<aui:input type="text" label="目标计划开工时间" inlineLabel="true"
											class="Wdate" name="planStartDate"
											onfocus="WdatePicker({lang:'zh-cn'})" value="">
											<aui:validator name="required" errorMessage="目标计划开工时间不能为空!"></aui:validator>
										</aui:input>
										<aui:input type="text" label="目标计划完工时间" inlineLabel="true"
											class="Wdate" name="planEndDate"
											onfocus="WdatePicker({lang:'zh-cn'})" value="">
											<aui:validator name="required" errorMessage="目标计划完工时间能为空!"></aui:validator>
										</aui:input>
										工程范围和主要内容
										<liferay-ui:input-textarea param="introduction">

										</liferay-ui:input-textarea>
									</fieldset>
									<fieldset class="fieldset span6">
										<aui:input type="text" label="计划总投资" inlineLabel="true"
											name="planTotle" value="${planTotle}">
											<aui:validator name="required" errorMessage="计划总投资不能为空!"></aui:validator>
										</aui:input>
										<aui:input type="text" label="工可批复总投资" inlineLabel="true"
											name="gkpfTotle" value="${gkpfTotle}" />
										<aui:input type="text" label="工可批复前期费用" inlineLabel="true"
											name="gkpfPre" value="${gkpfPre}" />
										<aui:input type="text" label="工可批复建安费用" inlineLabel="true"
											name="gkpfJafy" value="${gkpfJafy}" />
										<aui:input type="text" label="初设批复总投资" inlineLabel="true"
											name="csTotle" value="${csTotle}" />
										<aui:input type="text" label="初设批复前期费用" inlineLabel="true"
											name="csPre" value="${csPre}" />
										<aui:input type="text" label="初设批复建安费用" inlineLabel="true"
											name="csJafy" value="${csJafy}" />
									</fieldset>
								</div>
								<c:forEach items="${companys }" var="company">
									<fieldset>
										<legend>${company }</legend>
										<div class="row-fluid">
											<fieldset class="fieldset span12">
												<aui:input type="text" label="${company }" name="unitName"
													value="${unitName}" />
											</fieldset>
										</div>
										<div class="row-fluid">
											<fieldset class="fieldset span3">
												<aui:input type="text" label="独立法人" name="indepLegal"
													value="${indepLegal}" />
											</fieldset>
											<fieldset class="fieldset span3">
												<aui:input type="text" label="独立法人电话" name="indepLegalTel"
													value="${indepLegalTel}" />
											</fieldset>
											<fieldset class="fieldset span3">
												<aui:input type="text" label="独立法人传真" name="indepLegalFax"
													value="${indepLegalFax}" />
											</fieldset>
											<fieldset class="fieldset span3">
												<aui:input type="text" label="独立法人手机" name="indepLegalPhone"
													value="${indepLegalPhone}" />
											</fieldset>
										</div>
										<div class="row-fluid">
											<fieldset class="fieldset span3">
												<aui:input type="text" label="项目法人" name="indepLegal"
													value="${indepLegal}" />
											</fieldset>
											<fieldset class="fieldset span3">
												<aui:input type="text" label="项目法人电话" name="indepLegalTel"
													value="${indepLegalTel}" />
											</fieldset>
											<fieldset class="fieldset span3">
												<aui:input type="text" label="项目法人传真" name="indepLegalFax"
													value="${indepLegalFax}" />
											</fieldset>
											<fieldset class="fieldset span3">
												<aui:input type="text" label="项目法人手机" name="indepLegalPhone"
													value="${indepLegalPhone}" />
											</fieldset>
										</div>
										<div class="row-fluid">
											<fieldset class="fieldset span3">
												<aui:input type="text" label="联系人" name="indepLegal"
													value="${indepLegal}" />
											</fieldset>
											<fieldset class="fieldset span3">
												<aui:input type="text" label="联系人电话" name="indepLegalTel"
													value="${indepLegalTel}" />
											</fieldset>
											<fieldset class="fieldset span3">
												<aui:input type="text" label="联系人传真" name="indepLegalFax"
													value="${indepLegalFax}" />
											</fieldset>
											<fieldset class="fieldset span3">
												<aui:input type="text" label="联系人人手机" name="indepLegalPhone"
													value="${indepLegalPhone}" />
											</fieldset>
										</div>
									</fieldset>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<aui:button type="submit"></aui:button>
	<aui:button type="reset" value="重置"></aui:button>
</aui:form>
<script type="text/javascript">
	AUI().use("aui-toggler", function(a) {
		(function() {
			var b;
			Liferay.component("projectPanelContainer", function() {
				if (!b) {
					b = new a.TogglerDelegate({
						animated : true,
						closeAllOnExpand : false,
						container : "#projectPanelContainer",
						content : ".toggler-content",
						header : ".toggler-header",
						on : {
							"toggler:expandedChange" : function(d) {
								var f = d.target.get("header");
								var c = f.getData("persist-id");
								if (c && !d.silent) {
									var e = {};
									e[c] = d.newVal ? "closed" : "open";
									Liferay.Store(e)
								}
							}
						},
						transition : {
							duration : 0.3
						}
					})
				}
				return b
			});
			Liferay.component("projectPanelContainer")
		})()
	});
</script>




<liferay-ui:panel-container accordion="true" extended="true">
<liferay-ui:panel title="1"> 1 Content </liferay-ui:panel>
<liferay-ui:panel title="2"> 2 Content</liferay-ui:panel>
</liferay-ui:panel-container>
