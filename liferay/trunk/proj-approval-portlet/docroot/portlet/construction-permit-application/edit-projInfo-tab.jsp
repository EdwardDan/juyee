<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>
<portlet:actionURL var="def" name="add" ></portlet:actionURL>
<aui:form action="${def}">
<liferay-ui:panel-container accordion="true" extended="true">
	<liferay-ui:panel title="项目基本信息">
		<aui:row>
			<aui:col span="6">
				<aui:select label="项目性质：" name="projNature">
					

				</aui:select>
			</aui:col>
			<aui:col span="6">
				<aui:select label="所属区县：" name="area">
					
				</aui:select>
			</aui:col>
		</aui:row>

		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="报建编号：" name="projNum">
					<aui:validator name="required" errorMessage="报建编号不能为空!"></aui:validator>

				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="标段号：" name="sortNo">
					<aui:validator name="required" errorMessage="标段号不能为空!"></aui:validator>
				</aui:input>
			</aui:col>
		</aui:row>


		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="业务编号：" name="businessNum" autoSize="true">
					<aui:validator name="required" errorMessage="业务编号不能为空!"></aui:validator>

				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="项目名称：" name="projName">
					<aui:validator name="required" errorMessage="项目名称不能为空!"></aui:validator>

				</aui:input>
			</aui:col>
		</aui:row>




		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="建设单位：" name="constructionUnit">
					<aui:validator name="required" errorMessage="建设单位不能为空!"></aui:validator>

				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="建设单位性质：" name="constUnitNature">
					<aui:validator name="required" errorMessage="建设单位性质不能为空!"></aui:validator>

				</aui:input>
			</aui:col>
		</aui:row>


		<aui:row>

			<aui:col span="6">
				<aui:input type="text" label="建设单位地址：" name="constUnitAddress">
					<aui:validator name="required" errorMessage="建设单位地址不能为空!"></aui:validator>
				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="建设地点：" name="constructionSite">
					<aui:validator name="required" errorMessage="建设地点不能为空!"></aui:validator>

				</aui:input>
			</aui:col>
		</aui:row>



		<aui:row>
			<aui:col span="2" cssClass="textcenter">
			建设工程类别：
			</aui:col>
			<aui:col span="10">
				<aui:input type="checkBox" name="constructionType" label="土建" inlineLabel="right"
					inlineField="true"></aui:input>
				<aui:input type="checkBox" name="constructionType" label="房建" inlineLabel="right"
					inlineField="true"></aui:input>
				<aui:input type="checkBox" name="constructionType" label="机电" inlineLabel="right"
					inlineField="true"></aui:input>
				<aui:input type="checkBox" name="constructionType" label="设备" inlineLabel="right"
					inlineField="true"></aui:input>
				<aui:input type="checkBox" name="constructionType" label="绿化" inlineLabel="right"
					inlineField="true"></aui:input>
				<aui:input type="checkBox" name="constructionType" label="给排水" inlineLabel="right"
					inlineField="true"></aui:input>
				<aui:input type="checkBox" name="constructionType" label="交通工程" inlineLabel="right"
					inlineField="true"></aui:input>
				<aui:input type="checkBox" name="constructionType" label="供配电" inlineLabel="right"
					inlineField="true"></aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="2" cssClass="textcenter" >
			建设工程属性：
			</aui:col>
			<aui:col span="10">
				<aui:input type="radio" name="constructionAttribute" label="新建" inlineLabel="right"
					inlineField="true"></aui:input>
				<aui:input type="radio" name="constructionAttribute" label="改建" inlineLabel="right"
					inlineField="true"></aui:input>
				<aui:input type="radio" name="constructionAttribute" label="扩建" inlineLabel="right"
					inlineField="true"></aui:input>
				<aui:input type="radio" name="constructionAttribute" label="大修" inlineLabel="right"
					inlineField="true"></aui:input>
			</aui:col>
		</aui:row>

		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="建设工程规模：" name="constructionScale">
					<aui:validator name="required" errorMessage="建设工程规模不能为空!"></aui:validator>

				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="合同价格：" name="contractPrice">
					<aui:validator name="required" errorMessage="合同价格不能为空!"></aui:validator>

				</aui:input>
			</aui:col>
		</aui:row>

		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="合同工期：" name="contractDuration">
					<aui:validator name="required" errorMessage="合同工期不能为空!"></aui:validator>
				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="中标价格：" name="bidPrice">
					<aui:validator name="required" errorMessage="中标价格不能为空!"></aui:validator>

				</aui:input>
			</aui:col>
		</aui:row>
		

		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="项目投资估算：" name="investmentEstimate">
					<aui:validator name="required" errorMessage="项目投资估算不能为空!"></aui:validator>
				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="计划开工：" id="startDate" name="startDate" onfocus="WdatePicker({lang:'zh-cn'})">
					<aui:validator name="required" errorMessage="计划开工不能为空!"></aui:validator>

				</aui:input>
			</aui:col>
		</aui:row>

		<aui:row>
			<aui:col span="6">
				<aui:input type="text" label="计划竣工：" id="endDate" name="endDate" onfocus="WdatePicker({lang:'zh-cn'})">
					<aui:validator name="required" errorMessage="计划竣工不能为空!"></aui:validator>
				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="法定代表人：" name="legalRepresentative]">
					<aui:validator name="required" errorMessage="法定代表人不能为空!"></aui:validator>

				</aui:input>
			</aui:col>
		</aui:row>

		<aui:row>
			
			<aui:col span="6">
				<aui:input type="text" label="建设单位联系电话：" name="contactNum">
					<aui:validator name="required" errorMessage="建设单位联系电话不能为空!"></aui:validator>
				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="建设单位联系人：" name="contactPerson">
					<aui:validator name="required" errorMessage="建设单位联系人不能为空!"></aui:validator>

				</aui:input>
			</aui:col>
		</aui:row>

		<aui:row>
			
			<aui:col span="6">
				<aui:input type="text" label="手机号：" name="mobilePhone">
					<aui:validator name="required" errorMessage="手机号不能为空!"></aui:validator>
				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" label="现场开工情况：" name="fieldOperationConditions">
					<aui:validator name="required" errorMessage="现场开工情况不能为空!"></aui:validator>

				</aui:input>
			</aui:col>
		</aui:row>
	</liferay-ui:panel>

	<liferay-ui:panel title="主要设计单位：" defaultState="">
		<aui:row>
			<aui:col span="12" >
				<aui:input type="textarea" label="主要设计单位：" 
					name="mainDesignUnit">
				</aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="6" >
				<aui:input type="text" label="招标方式：" 
					name="designTenderMethod">
				</aui:input>
				<aui:input type="text" label="资质等级："  name="designQualificationLevel">
				</aui:input>
				<aui:input type="text" label="项目负责人：" 
					name="designProjectLeader">
				</aui:input>
			</aui:col>
			<aui:col span="6" >
				<aui:input type="text" label="中标价："  name="designBidPrice">
				</aui:input>
				<aui:input type="text" label="证书编号："  name="designCertificateCode">
				</aui:input>
				<aui:input type="text" label="证书编号："  name="designCertificateCodes">
				</aui:input>
			</aui:col>
		</aui:row>
		
	</liferay-ui:panel>
	<liferay-ui:panel title="主要监理单位" defaultState="">
	<aui:row>
			<aui:col span="12" >
				<aui:input type="textarea" label="主要监理单位：" 
					name="mainSupervisionUnit">
					<aui:validator name="required" errorMessage="主要监理单位不能为空!"></aui:validator>
				</aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="6" >
				<aui:input type="text" label="招标方式：" 
					name="supervisionTenderMethod">
				</aui:input>
				<aui:input type="text" label="资质等级："  name="supervisionQualificationLevel">
				</aui:input>
				<aui:input type="text" label="项目负责人：" 
					name="supervisionProjectLeader">
				</aui:input>
			</aui:col>
			<aui:col span="6" >
				<aui:input type="text" label="中标价："  name="supervisionBidPrice">
				</aui:input>
				<aui:input type="text" label="证书编号："  name="supervisionCertificateCode"
					>
				</aui:input>
				<aui:input type="text" label="证书编号："  name="supervisionCertificateCodes">
				</aui:input>
			</aui:col>
		</aui:row>
	</liferay-ui:panel>
	<liferay-ui:panel title="主要施工单位" defaultState="">
		<aui:row>
			<aui:col span="12" >
				<aui:input type="textarea" label="主要施工单位：" 
					name="mainConstructionUnit">
				<aui:validator name="required" errorMessage="主要施工单位不能为空!"></aui:validator>	
				</aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="6" >
				<aui:input type="text" label="招标方式：" 
					name="constructionTenderMethod">
				</aui:input>
				<aui:input type="text" label="资质等级："  name="constructionQualificationLevel">
				</aui:input>
				<aui:input type="text" label="项目负责人：" 
					name="constructionProjectLeader">
				</aui:input>
			</aui:col>
			<aui:col span="6" >
				<aui:input type="text" label="中标价："  name="constructionBidPrice">
				</aui:input>
				<aui:input type="text" label="证书编号："  name="constructionCertificateCode">
				</aui:input>
				<aui:input type="text" label="证书编号："  name="constructionCertificateCodes">
				</aui:input>
			</aui:col>
		</aui:row>
		
	</liferay-ui:panel>
	<liferay-ui:panel title="建设依据"  defaultState="">
		<aui:row>
			<aui:col span="6" >
				<aui:input type="text" label="工可批准或核准机关和文号：" 
					name="unionApprovedOrApprovalOrgansAndNumber">
				</aui:input>
				<aui:input type="text" label="批复或核准日期："  class="Wdate"
					name="approvalOrReplyDate" onfocus="WdatePicker({lang:'zh-cn'})">
				<aui:validator name="required" errorMessage="批复或核准日期不能为空!"></aui:validator>
				</aui:input>
				<aui:input type="text" label="批复日期："  class="Wdate"
					name="approvalDate" onfocus="WdatePicker({lang:'zh-cn'})" >
				<aui:validator name="required" errorMessage="批复日期不能为空!"></aui:validator>
				</aui:input>
				<aui:input type="text" label="总概算："  name="generalEstimation">
				<aui:validator name="required" errorMessage="总概算不能为空!"></aui:validator>
				</aui:input>
			</aui:col>
			<aui:col span="6" >
				<aui:input type="text" label="初步设计批准机关和文号：" 
					name="firstDesignApprovalOrganAndNumber">
				</aui:input>
				<aui:input type="text" label="投资估算："  name="investmentEstimation">
				<aui:validator name="required" errorMessage="投资估算不能为空!"></aui:validator>
				</aui:input>
				<aui:input type="text" label="批复工程："  name="approvalEngineering">
				</aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="12" >
				<aui:input type="text" label="批准机关和文号：" 
					name="approvalOrganAndNumber">
				</aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="12" >
				<aui:input type="text" label="投资来源：" 
					name="investmentSources">
				</aui:input>

			</aui:col>
		</aui:row>
	</liferay-ui:panel>

<aui:button type="submit"   value="提交"/>
</liferay-ui:panel-container>
</aui:form>