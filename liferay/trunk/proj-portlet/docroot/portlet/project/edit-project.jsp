<%@ page contentType="text/html;charset=utf-8"%>
<%@include file="/common/init.jsp"%>
<c:set var="contextPath" value="${request.contextPath}/portlet/project" />
<portlet:renderURL var="viewURL" />
<portlet:actionURL var="saveProjectURL" name="saveProject">
	<portlet:param name="redirect" value="${viewURL}" />
</portlet:actionURL>
<liferay-ui:header title="${empty project?'添加':'编辑'}项目基本信息"
	backURL="${viewURL}" />
<aui:form action="${saveProjectURL}" method="post">
	<liferay-ui:panel-container accordion="true" extended="true">
		<liferay-ui:panel title="项目基本信息">
			<aui:fieldset>
				<aui:input name="projectId" type="hidden" value="${projectId}" />
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<aui:input type="text" label="项目编号" name="projNum"
							value="${project.projNum}">
							<aui:validator name="maxLength" errorMessage="">75</aui:validator>
						</aui:input>
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<aui:input type="text" label="项目名称" name="projName"
							value="${project.projName}">
							<aui:validator name="required" errorMessage="项目名称不能为空!"></aui:validator>
						</aui:input>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<aui:input type="text" label="项目排序号" name="sortNo"
							value="${sortNo}">
							<aui:validator name="required" errorMessage="项目排序号不能为空!"></aui:validator>
						</aui:input>
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<label class="control-label" for="startDate">实际开工时间 </label>
						<input type="text" class="field"
							name="<portlet:namespace/>startDate" id="startDate"
							onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')}',lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"
							value='<fmt:formatDate value="${project.startDate}" pattern="yyyy-MM-dd"/>'>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<aui:select label="项目状态" name="projStatus" showEmptyOption="true">
							<c:forEach items="${projectStatuses}" var="projStatus">
								<aui:option value="${projStatus.dictionaryId}"
									selected="${projStatus.dictionaryId eq project.projStatus}">${projStatus.name }</aui:option>
							</c:forEach>
						</aui:select>
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<label class="control-label" for="endDate">实际完成时间</label>
						<input type="text" class="field"
							name="<portlet:namespace/>endDate" id="endDate"
							onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}',lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"
							value='<fmt:formatDate value="${project.endDate }" pattern="yyyy-MM-dd"/>'>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<aui:select label="业态类别" name="industryCategory"
							showEmptyOption="true">
							<c:forEach items="${industryCategories}" var="industryCategory">
								<aui:option value="${industryCategory.dictionaryId}"
									selected="${industryCategory.dictionaryId eq project.industryCategory}">${industryCategory.name }</aui:option>
							</c:forEach>
						</aui:select>
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<aui:field-wrapper name="涉及区县">
							<c:forEach items="${involveCounties}" var="involveCounty"
								varStatus="sortNo">
								<aui:input name="involveCounty" type="checkbox"
									value="${involveCounty.dictionaryId}"
									checked="${fn:contains(project.involveCounty ,involveCounty.dictionaryId)}"
									label="${involveCounty. name}" inlineField="true" />
								<c:if test="${sortNo.index>0 && (sortNo.index+1) % 9 == 0}">
									<br>
								</c:if>
							</c:forEach>
						</aui:field-wrapper>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<aui:select label="管理属性" name="manageAttribute" inlineField="true"
							showEmptyOption="true">
							<c:forEach items="${manageAttributes}" var="manageAttribute">
								<aui:option value="${manageAttribute. dictionaryId }"
									selected="${manageAttribute. dictionaryId eq project.manageAttribute }">${manageAttribute.name }</aui:option>
							</c:forEach>
						</aui:select>
						<aui:select label="" name="isMajor" inlineField="true">
							<aui:option value="1" selected="${project. isMajor}">重大</aui:option>
							<aui:option value="0" selected="${!project. isMajor}">非重大</aui:option>
						</aui:select>
					</aui:col>

					<aui:col span="6" cssClass="text-left">
						<aui:input type="text" label="规划红线（宽度m）" name="planRedLine"
							placeholder="请输入正数" value="${project.planRedLine}"
							onkeyup="value=value.replace(/[^\d.]/g,'')">
						</aui:input>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<aui:select label="项目来源" name="projSource" showEmptyOption="true">
							<c:forEach items="${projectSources }" var="projSource">
								<aui:option value="${projSource. dictionaryId }"
									selected="${projSource.dictionaryId eq project.projSource}">${projSource.name }</aui:option>
							</c:forEach>
						</aui:select>
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<aui:select label="道路技术等级" name="roadTechLevel"
							showEmptyOption="true">
							<c:forEach items="${roadTechLevels }" var="roadTechLevel">
								<aui:option value="${roadTechLevel.dictionaryId }"
									selected="${roadTechLevel.dictionaryId eq project.roadTechLevel}">${roadTechLevel.name }</aui:option>
							</c:forEach>
						</aui:select>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<aui:select label="所属区县" name="belongCounty"
							showEmptyOption="true">
							<aui:option value="0" selected="${project.belongCounty==0}">上海市</aui:option>
							<c:forEach items="${countys}" var="belongCounty">
								<aui:option value="${belongCounty.dictionaryId}"
									selected="${belongCounty.dictionaryId eq project.belongCounty}">${project.belongCounty }</aui:option>
							</c:forEach>
						</aui:select>
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<aui:select label="道路等级" name="roadLevel" showEmptyOption="true">
							<c:forEach items="${roadLevels}" var="roadLevel">
								<aui:option value="${roadLevel.dictionaryId}"
									selected="${roadLevel.dictionaryId eq project.roadLevel}">${roadLevel .name}</aui:option>
							</c:forEach>
						</aui:select>
					</aui:col>

				</aui:row>

				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<aui:select label="项目属性" name="projAttr" showEmptyOption="true">
							<c:forEach items="${projAttrs}" var="projAttr">
								<aui:option value="${projAttr.dictionaryId }"
									selected="${projAttr.dictionaryId eq project.projAttr}">${projAttr.name }</aui:option>
							</c:forEach>
						</aui:select>
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<aui:input type="text" label="起讫地点" name="location"
							value="${project.location}">
						</aui:input>
					</aui:col>
				</aui:row>
			</aui:fieldset>
		</liferay-ui:panel>
		<liferay-ui:panel title="项目扩展信息">
			<aui:fieldset>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<label class="control-label" for="startNode"> 目标开工节点 </label>
						<input type="text" class="field"
							name="<portlet:namespace/>startNode" id="startNode"
							onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endNode\')}',lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"
							value='<fmt:formatDate value="${project.startNode }" pattern="yyyy-MM-dd"/>'>
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<aui:input type="text" label="计划总投资" name="planTotalInvestment"
							placeholder="请输入正数" value="${project.planTotalInvestment}"
							onkeyup="value=value.replace(/[^\d.]/g,'')">
						</aui:input>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<label class="control-label" for="endNode"> 目标完工节点 </label>
						<input type="text" class="field"
							name="<portlet:namespace/>endNode" id="endNode"
							onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startNode\')}',lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"
							value='<fmt:formatDate value="${project.endNode }" pattern="yyyy-MM-dd"/>'>
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<aui:input type="text" label="工可批复总投资" placeholder="请输入正数"
							name="feasibilityTotalInvestment"
							onkeyup="value=value.replace(/[^\d.]/g,'')"
							value="${project.feasibilityTotalInvestment}" />
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<label class="control-label" for="planStartDate"> 目标计划开工时间
						</label>
						<input type="text" class="field"
							name="<portlet:namespace/>planStartDate"
							id="planStartDate"
							onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'planEndDate\')}',lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"
							value='<fmt:formatDate value="${project.planStartDate }" pattern="yyyy-MM-dd"/>'>
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<aui:input type="text" label="工可批复前期费用" name="feasibilityPreCost"
							placeholder="请输入正数" value="${project.feasibilityPreCost}"
							onkeyup="value=value.replace(/[^\d.]/g,'')" />
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<label class="control-label" for="planEndDate"> 目标计划完工时间 </label>
						<input type="text" class="field"
							name="<portlet:namespace/>planEndDate"
							id="planEndDate"
							onfocus="WdatePicker({minDate:'#F{$dp.$D(\'planStartDate\')}',lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"
							value='<fmt:formatDate value="${project.planEndDate }" pattern="yyyy-MM-dd"/>'>
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<aui:input type="text" label="工可批复建安费用"
							name="feasibilityJiananCost" placeholder="请输入正数"
							onkeyup="value=value.replace(/[^\d.]/g,'')"
							value="${project.feasibilityJiananCost}" />
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<aui:input type="textarea" label="工程范围和主要内容" name="introduction"
							value="${project.introduction}" />
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<aui:input type="text" label="初设批复总投资"
							name="firstFoundedTotalInvestment" placeholder="请输入正数"
							onkeyup="value=value.replace(/[^\d.]/g,'')"
							value="${project.firstFoundedTotalInvestment}" />
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<aui:input type="text" label="初设批复前期费用" name="firstFoundedPreCost"
							value="${project.firstFoundedPreCost}" placeholder="请输入正数"
							onkeyup="value=value.replace(/[^\d.]/g,'')" />
					</aui:col>
					<aui:col span="6" cssClass="text-left">
						<aui:input type="text" label="初设批复建安费用"
							name="firstFoundedJiananCost" placeholder="请输入正数"
							value="${project.firstFoundedJiananCost}"
							onkeyup="value=value.replace(/[^\d.]/g,'')" />
					</aui:col>
				</aui:row>
				<liferay-ui:tabs names="${companyName}" refresh="false">
					<c:forEach items="${companyMap}" var="map">
						<liferay-ui:section>
							<aui:input name="type" type="hidden"
								value="${map.key.dictionaryId}" />
							<aui:input name="companyId" type="hidden"
								value="${map.value.companyId}" />
							<aui:row>
								<aui:col span="6" cssClass="text-left">
									<aui:input type="text" label="单位名称" name="unitName"
										value="${map.value.unitName}" />
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="3" cssClass="text-left">
									<aui:input type="text" label="独立法人" name="indepLegal"
										value="${map.value.indepLegal}" />
								</aui:col>
								<aui:col span="3" cssClass="text-left">
									<aui:input type="text" label="独立法人电话" name="indepLegalTel"
										value="${map.value.indepLegalTel}" />
								</aui:col>
								<aui:col span="3" cssClass="text-left">
									<aui:input type="text" label="独立法人传真" name="indepLegalFax"
										value="${map.value.indepLegalFax}" />
								</aui:col>
								<aui:col span="3" cssClass="text-left">
									<aui:input type="text" label="独立法人手机" name="indepLegalPhone"
										value="${map.value.indepLegalPhone}" />
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="3" cssClass="text-left">
									<aui:input type="text" label="项目法人" name="projLegal"
										value="${map.value.projLegal}" />
								</aui:col>
								<aui:col span="3" cssClass="text-left">
									<aui:input type="text" label="项目法人电话" name="projLegalTel"
										value="${map.value.projLegalTel}" />
								</aui:col>
								<aui:col span="3" cssClass="text-left">
									<aui:input type="text" label="项目法人传真" name="projLegalFax"
										value="${map.value.projLegalFax}" />
								</aui:col>
								<aui:col span="3" cssClass="text-left">
									<aui:input type="text" label="项目法人手机" name="projLegalPhone"
										value="${map.value.projLegalPhone}" />
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="3" cssClass="text-left">
									<aui:input type="text" label="联系人" name="linkman"
										value="${map.value.linkman}" />
								</aui:col>
								<aui:col span="3" cssClass="text-left">
									<aui:input type="text" label="联系人电话" name="linkmanTel"
										value="${map.value.linkmanTel}" />
								</aui:col>
								<aui:col span="3" cssClass="text-left">
									<aui:input type="text" label="联系人传真" name="linkmanFax"
										value="${map.value.linkmanFax}" />
								</aui:col>
								<aui:col span="3" cssClass="text-left">
									<aui:input type="text" label="联系人手机" name="linkmanPhone"
										value="${map.value.linkmanPhone}" />
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
