<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>

<c:if test="${empty officeSupplyApplicationItems}">
	<div class="member-fields" id="member-fields1">
		<div class="lfr-form-row lfr-form-row-inline">
			<div class="row-fields" style="display: flex;">
				<aui:input fieldParam='contractSubmissionCode' name="contractSubmissionCode" label="合同信息报送编号"
					 type="text" style="width:150px"/>
				<aui:input fieldParam='unitType' name="unitType" label="单位类型" type="text" style="width:150px"/>
				<aui:input fieldParam='unitName' name="unitName" label="单位名称" type="text" style="width:150px"/>
				<aui:input fieldParam='unitHead' name="unitHead" label="单位负责人" type="text" style="width:150px"/>
				<aui:input fieldParam='indentifyCard' name="indentifyCard" label="身份证号" type="text" style="width:150px"/>
				<aui:input fieldParam='telephoneNum' name="telephoneNum" label="电话号码" type="text" style="width:150px"/>
			</div>
		</div>
	</div>
</c:if>
<div class="member-fields">
	<c:forEach items="${officeSupplyApplicationItems}" var="item"
		varStatus="status">
		<div class="lfr-form-row lfr-form-row-inline">
			<div class="row-fields" style="display: flex;">
				<aui:input fieldParam='contractSubmissionCode' name="contractSubmissionCode" label="合同信息报送编号"
					required="true"  type="text" style="width:20%"/>
				<aui:input fieldParam='unitType' name="unitType" label="单位类型" type="text" style="width:16%"/>
				<aui:input fieldParam='unitName' name="unitName" label="单位名称" type="text" style="width:16%"/>
				<aui:input fieldParam='unitHead' name="unitHead" label="单位负责人" type="text" style="width:16%"/>
				<aui:input fieldParam='indentifyCard' name="indentifyCard" label="身份证号" type="text" style="width:16%"/>
				<aui:input fieldParam='telephoneNum' name="telephoneNum" label="电话号码" type="text" style="width:16%"/>
			</div>
		</div>
	</c:forEach>
</div>
<aui:script>
	AUI().use('liferay-auto-fields', function(A) {
		new Liferay.AutoFields({
			contentBox : '#member-fields1',
			fieldIndexes : '<portlet:namespace/>rowIndexes'
		}).render();
	});	
</aui:script>