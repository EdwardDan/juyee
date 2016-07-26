<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>
<portlet:renderURL var="def"/>
<portlet:actionURL var="addFieldURL" name="addAutoFieldTest"></portlet:actionURL>
<aui:form action="${addFieldURL}">
<aui:input name="code" value="${filedMap.code}"></aui:input>

		<%-- <div class="member-fields">
			<div class="lfr-form-row lfr-form-row-inline">
				<div class="row-fields" style="display: flex;">
					<aui:input fieldParam='type1' name="type1" label="申请物品"
						required="true" />
				</div>
			</div>
		</div> --%>

	 <div class="member-fields">
		<c:forEach items="${officeSupplyApplicationItems}" var="item"
			varStatus="status">
			<div class="lfr-form-row lfr-form-row-inline">
				<div class="row-fields" style="display: flex;">
					<aui:input name="type${status.index+1}" id="type${status.index+1}"
						label="申请物品" value="${item.type}" required="true" />
				</div>
			</div>
		</c:forEach>
	</div> 
	<aui:button type="submit" value="提交"/>
	 <aui:button type="cancel" value="取消" href="${def}"/>
</aui:form>
	<aui:script>
		AUI().use('liferay-auto-fields', function(A) {
			new Liferay.AutoFields({
				contentBox : '.member-fields',
				fieldIndexes : '<portlet:namespace/>rowIndexes'
			}).render();
		});
	</aui:script>	

