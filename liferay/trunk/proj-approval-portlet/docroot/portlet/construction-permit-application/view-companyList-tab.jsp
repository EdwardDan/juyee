<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>

<c:if test="${empty officeSupplyApplicationItems}">
	<div class="member-fields" id="member-fields2">
		<div class="lfr-form-row lfr-form-row-inline">
			<div class="row-fields" style="display: flex;">
				<aui:input fieldParam='unitProCode1' name="unitProCode1" label="单位工程编号"
					 type="text" style="width:150px"/>
				<aui:input fieldParam='unitProName1' name="unitProName1" label="单位工程名称" type="text" style="width:150px"/>
				<aui:input fieldParam='unitProType1' name="unitProType1" label="单位工程类型" type="text" style="width:150px"/>
				<aui:input fieldParam='engineeringRequirements' name="engineeringRequirements" label="工程指标" type="text" style="width:300px"/>
				
			</div>
		</div>
	</div>
</c:if>
<div class="member-fields">
	<c:forEach items="${officeSupplyApplicationItems}" var="item"
		varStatus="status">
		<div class="lfr-form-row lfr-form-row-inline">
			<div class="row-fields" style="display: flex;">
				<aui:input fieldParam='unitProCode1' name="unitProCode1" label="单位工程编号"
					required="true" />
				<aui:input fieldParam='unitProName1' name="unitProName1" label="单位工程名称" />
				<aui:input fieldParam='unitProType1' name="unitProType1" label="单位工程类型" />
				<aui:input fieldParam='engineeringRequirements' name="engineeringRequirements" label="工程指标" type="text" style="width:300px"/>
			</div>
		</div>
	</c:forEach>
</div>
<aui:script>
	AUI().use('liferay-auto-fields', function(A) {
		new Liferay.AutoFields({
			contentBox : '#member-fields2',
			fieldIndexes : '<portlet:namespace/>rowIndexes'
		}).render();
	});

	
</aui:script>