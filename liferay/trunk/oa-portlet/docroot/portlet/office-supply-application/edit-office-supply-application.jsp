<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<script type="text/javascript">
   document.write("<script src='${staticServerURL}/jquery/jquery-1.12.4.min.js'>"+"<"+"/script>");
</script>
<portlet:renderURL var="viewURL" />
<script>
	function count() {
		var total = 0;
		var indexes = $(".row-fields").length;
		for (var i = 1; i <= indexes; i++) {
			var unitPrice = $("#<portlet:namespace/>unitPrice" + i).val();
			var quantity = $("#<portlet:namespace/>quantity" + i).val();
			total += unitPrice * quantity;
		}
		$("#<portlet:namespace/>total").val(total);
	}
</script>
<%
	long userId = PortalUtil.getUserId(request);
	String userName = PortalUtil.getUserName(userId, "");
%>
<liferay-ui:header
	title="${empty officeSupplyApplication?'':'编辑'}办公用品申请"
	backURL="${viewURL}" />
<portlet:actionURL var="saveOfficeSupplyApplicationURL"
	name="saveOfficeSupplyApplication">
	<portlet:param name="redirect" value="${viewURL }" />
</portlet:actionURL>
<aui:form action="${saveOfficeSupplyApplicationURL}">
	<aui:row>
		<aui:col span="6">
			<aui:input type="hidden" name="officeSupplyApplicationId"
				value="${officeSupplyApplication.officeSupplyApplicationId}" />
			<aui:input name="deptName" label="申请部门"
				value="${officeSupplyApplication.deptName}" inlineField="true"/>
		</aui:col>
		<aui:col span="6">
			<aui:input name="userName" label="申请人" value="<%=userName%>"
				disabled="true" />
		</aui:col>
	</aui:row>
	<c:if test="${empty officeSupplyApplicationItems}">
		<div class="member-fields">
			<div class="lfr-form-row lfr-form-row-inline">
				<div class="row-fields" style="display: flex;">
					<aui:input fieldParam='name1' name="name1" label="申请物品"
						required="true" />
					<aui:input fieldParam='model1' name="model1" label="型号"/>
					<aui:input fieldParam='unit1' name="unit1" label="单位" />
					<aui:input fieldParam='unitPrice1' name="unitPrice1" label="预计单价"
						id="unitPrice1" onChange="count()">
						<aui:validator name="number" />
					</aui:input>
					<aui:input fieldParam='quantity1' name="quantity1" id="quantity1"
						label="数量" onChange="count()">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input>
				</div>
			</div>
		</div>
	</c:if>
	<div class="member-fields">
		<c:forEach items="${officeSupplyApplicationItems}" var="item"
			varStatus="status">
			<div class="lfr-form-row lfr-form-row-inline">
				<div class="row-fields" style="display: flex;">
					<aui:input name="name${status.index+1}" id="name${status.index+1}"
						label="申请物品" value="${item.name }" required="true" />
					<aui:input name="model${status.index+1}"
						id="model${status.index+1}" label="型号" value="${item.model }" />
					<aui:input name="unit${status.index+1}" id="unit${status.index+1}"
						label="单位" value="${item.unit }" />
					<aui:input name="unitPrice${status.index+1}"
						id="unitPrice${status.index+1}" label="预计单价" onChange="count()"
						value="${item.unitPrice}">
						<aui:validator name="number" />
					</aui:input>
					<aui:input name="quantity${status.index+1}" label="数量"
						id="quantity${status.index+1}" onChange="count()"
						value="${item.quantity}">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input>
				</div>
			</div>
		</c:forEach>
	</div>
	<aui:script>
		AUI().use('liferay-auto-fields', function(A) {
			new Liferay.AutoFields({
				contentBox : '.member-fields',
				fieldIndexes : '<portlet:namespace/>rowIndexes'
			}).render();
		});
	</aui:script>	
	
	<aui:row>
		<aui:col span="6"></aui:col>
		<aui:col span="6">
			<aui:input id="total" name="total" label="预计总价" value="${total}" disabled="true"/>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="12">
			<aui:input type="textarea" name="introductions" label="申请说明"
				value="${officeSupplyApplication.introductions}" cssClass="span12" />
		</aui:col>
	</aui:row>
	<aui:button-row>
		<aui:button type="submit" value="提交" />
		<aui:button type="submit" value="暂存" />
		<aui:button type="cancel" value="取消" href="${viewURL }"/>
	</aui:button-row>
</aui:form>





