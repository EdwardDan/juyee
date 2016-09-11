<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<portlet:renderURL var="viewURL" />
<portlet:actionURL var="saveParticipationUnitsURL"
	name="saveParticipationUnits">
	<portlet:param name="redirectURL" value="${editPermitURL }" />
</portlet:actionURL>
<style>
.divAccordion-inner {
	padding: 9px 15px;
}

.table tr td input {
	width: 100%;
	height: 28px;
	color: #8B8B83;
	border: #D4D4D4 1px solid;
}
</style>
<%
	long permitId = ParamUtil.getLong(renderRequest, "permitId");
System.out.println("permitId========="+permitId);
List<ParticipationUnit> participationUnits = ParticipationUnitLocalServiceUtil.findByPermitId(permitId,
		-1, -1);
/* if (participationUnits == null || participationUnits.size() == 0) {
	participationUnits = new ArrayList<ParticipationUnit>();
	ParticipationUnit participationUnit = null;
	try {
		participationUnit = ParticipationUnitLocalServiceUtil
		.createParticipationUnit(CounterLocalServiceUtil.increment());
	} catch (SystemException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	participationUnit.setDwlx("建设单位");
	participationUnit.setDwmc("单位名称是是是是是是");
	participationUnit.setXmfzr("黄家辉");
	participationUnit.setZjlx("身份证");
	participationUnit.setZjh("341225879785468245");
	participationUnit.setDhhm("13127667037");
	participationUnit.setSfyssj(true);
	participationUnit.setPermitId(permitId);
	participationUnits.add(participationUnit);
} */

request.setAttribute("participationUnits", participationUnits);

Dictionary dictionaryDeptType = DictionaryLocalServiceUtil.findByCode("dwlx");
Dictionary dictionaryCertificateType = DictionaryLocalServiceUtil.findByCode("zjlx");
if(null!=dictionaryDeptType){
	List<Dictionary> deptTypes = DictionaryLocalServiceUtil.findByParentId( dictionaryDeptType.getDictionaryId(), -1, -1);
	request.setAttribute("deptTypes", deptTypes);
}

if(null!=dictionaryCertificateType){
	List<Dictionary> certificateTypes = DictionaryLocalServiceUtil.findByParentId( dictionaryCertificateType.getDictionaryId(), -1, -1);
	request.setAttribute("certificateTypes", certificateTypes);
}
%>
<aui:form action="${saveParticipationUnitsURL }">
	<aui:input name="permitId" type="hidden" value="<%=permitId%>" />
	<div class="divAccordion-inner">
		<aui:row>
			<aui:col span="12">
				<input type="button" value="添加" class="btn" style=""
					onclick="${renderResponse.namespace}changeLine(this)" />
				<input type="button" value="删除" class="btn" style=""
					onclick="${renderResponse.namespace}changeLine(this)" />

			</aui:col>
		</aui:row>
	</div>
	<div class="accordion-inner">
		<table border="1" width="100%"
			class="table table-bordered table-hover">
			<tr height="29px">
				<td style="width: 2%; text-align: center"></td>
				<td style="width: 28%; text-align: center">单位名称</td>
				<td style="width: 13%; text-align: center">单位类型</td>
				<td style="width: 10%; text-align: center">项目负责人</td>
				<td style="width: 12%; text-align: center">证件类型</td>
				<td style="width: 20%; text-align: center">证件号</td>
				<td style="width: 10%; text-align: center">手机号</td>
			</tr>

			<tbody id="participationUnits">
				<c:if test="${!empty participationUnits}">
					<c:forEach items="${participationUnits}" var="participationUnit">
						<tr height="29px">
							<td style="width: 2%; text-align: center"><input
								type="checkbox" name="<portlet:namespace/>isDelete"
								<c:if test="${participationUnit. sfyssj }">disabled="disabled"</c:if> /></td>
							<td style="width: 28%; text-align: left"><input
								style="width: 98%" name="<portlet:namespace/>dwmc"
								value="${participationUnit. dwmc}" required="required">
								<input name="<portlet:namespace/>sfyssj" type="hidden"
								value="${participationUnit. sfyssj}"></td>
							<td style="width: 13%; text-align: center"><select
								id="<portlet:namespace/>dwlx" name="<portlet:namespace/>dwlx"
								style="width: 100%">
									<c:forEach items="${deptTypes }" var="deptType">
										<option value="${deptType.name }"
											<c:if test="${deptType.name  eq participationUnit. dwlx}">selected</c:if>>${deptType.name }</option>
									</c:forEach>
							</select></td>
							<td style="width: 10%; text-align: center"><input
								style="width: 100%" name="<portlet:namespace/>xmfzr"
								value="${participationUnit. xmfzr}"></td>
							<td style="width: 12%; text-align: center"><select
								id="<portlet:namespace/>zjlx" name="<portlet:namespace/>zjlx"
								style="width: 100%">
									<c:forEach items="${certificateTypes}" var="certificateType">
										<option value="${certificateType.name }"
											<c:if test="${certificateType.name  eq participationUnit. zjlx}">selected</c:if>>${certificateType.name }</option>
									</c:forEach>
							</select></td>
							<td style="width: 20%; text-align: center"><input
								style="width: 100%" name="<portlet:namespace/>zjh"
								value="${participationUnit. zjh}"></td>
							<td style="width: 10%; text-align: center"><aui:input
									style="width: 95%" name="dhhm" label=""
									value="${participationUnit. dhhm}"></aui:input></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>

	<aui:button-row>
		<div style="text-align: center">
				 <aui:button type="submit" value="保存" onClick="return submitSave()" /> 
				 <aui:button type="cancel" value="返回" href="${viewURL}" />
		</div>
	</aui:button-row>

</aui:form>
<table style="display: none;" border="1">
	<tbody id="hiddenStyle">
		<tr height="29px">
			<td style="width: 2%; text-align: center"><input type="checkbox"
				name="<portlet:namespace/>isDelete" /></td>
			<td style="width: 28%; text-align: left"><input
				style="width: 98%" name="<portlet:namespace/>dwmc"
				required="required"> <input
				name="<portlet:namespace/>sfyssj" type="hidden" value="false"></td>
			<td style="width: 13%; text-align: center"><select
				id="<portlet:namespace/>dwlx" name="<portlet:namespace/>dwlx"
				style="width: 100%">
					<c:forEach items="${deptTypes}" var="deptType">
						<option value="${deptType.name }">${deptType.name }</option>
					</c:forEach>
			</select></td>
			<td style="width: 10%; text-align: center"><input
				style="width: 100%" name="<portlet:namespace/>xmfzr"></td>
			<td style="width: 12%; text-align: center"><select
				id="<portlet:namespace/>zjlx" name="<portlet:namespace/>zjlx"
				style="width: 100%">
					<c:forEach items="${certificateTypes}" var="certificateType">
						<option value="${certificateType.name }">${certificateType.name }</option>
					</c:forEach>
			</select></td>
			<td style="width: 20%; text-align: center"><input
				style="width: 100%" name="<portlet:namespace/>zjh"></td>
			<td style="width: 10%; text-align: center"><aui:input
					style="width: 95%" name="dhhm" label="" value="">
				</aui:input></td>
		</tr>
	</tbody>
</table>
<script>
	function <portlet:namespace/>changeLine(obj) {
		if (obj.value == "添加") {
			$("#participationUnits").append($("#hiddenStyle").html());
		} else {
			if (confirm("确定要删除吗？")) {
				$("input[name='<portlet:namespace/>isDelete']").each(
						function() {
							if (this.checked) {
								$(this).parent().parent().remove();
							}
						});
			}
		}
	}

	function focusInput(obj) {
		$(obj).css("border", "1px solid red");
	}

	function submitSave() {
		var reg = /^0?1[3|4|5|8|7][0-9]\d{8}$/;
		var flagPhone = true;

		$("input[name='<portlet:namespace/>dhhm']").each(function() {
			if (!reg.test($(this).val()) && $(this).val() != '') {
				flagPhone = false;
				focusInput(this);
			}
		});
		if (!flagPhone) {
			alert("电话号码有误！！")
			return false;
		}

		var deptCodes = "";
		var flagDept = true;
		var len = $("select[name='<portlet:namespace/>dwlx']").length;
		$("select[name='<portlet:namespace/>dwlx']").each(function(i) {
			if (i <= (len - 2)) {
				if (deptCodes.indexOf($(this).val()) != -1) {
					flagDept = false;
				}
				deptCodes = deptCodes + "," + $(this).val();
			}

		});

		if (!flagDept) {
			alert("单位类型存在重复！！")
			return false;
		}
		return true;
	}
</script>