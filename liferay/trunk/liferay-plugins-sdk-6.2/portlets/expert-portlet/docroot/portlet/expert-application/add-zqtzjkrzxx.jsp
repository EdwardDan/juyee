<%@page import="com.justonetech.expert.model.Zqtzjkrzqk"%>
<%@page import="com.justonetech.expert.service.ZqtzjkrzqkLocalServiceUtil"%>
<%@page import="com.justonetech.expert.model.Expert"%>
<%@page import="com.justonetech.expert.service.ExpertLocalServiceUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<portlet:defineObjects />

<portlet:renderURL var="viewURL" />
<portlet:actionURL var="saveZqtzjkrzqkURL" name="saveZqtzjkrzqks">
	<%-- <portlet:param name="redirectURL" value="${viewURL }" /> --%>
</portlet:actionURL>

<%
	long expertId = ParamUtil.getLong(request, "expertId");
	if(expertId!=0){
	List<Zqtzjkrzqk>	zqtzjkrzqks = ZqtzjkrzqkLocalServiceUtil.getZqtzjkrzqks(expertId, -1,-1);
	request.setAttribute("zqtzjkrzqks", zqtzjkrzqks);
	}
%>

<aui:form action="${saveZqtzjkrzqkURL}">
	<aui:input name="expertId" type="hidden" value="${expertId }"></aui:input>
	<div class="accordion-inner">
		<table width="100%" class="table table-bordered table-hover">
			<thead>
				<th style="width: 5%; text-align: center">序号</th>
				<th style="width: 30%; text-align: center">专家库系统隶属单位</th>
				<th style="width: 30%; text-align: center">申请专业</th>
				<th style="width: 30%; text-align: center">批准日期</th>
				<th style="width: 5%; text-align: center"><input type="button"
					value="添加" class="btn" style=""
					onclick="${renderResponse.namespace}changeLine(this)" /></th>
			</thead>
			<tbody id="zqtzjkrzqkData">
				<c:if test="${!empty zqtzjkrzqks}">
					<c:forEach items="${zqtzjkrzqks }" var="zqtzjkrzqk">
						<tr>
							<td></td>
							<td><aui:input name="zjkxtlsdw" value="${zqtzjkrzqk.zjkxtlsdw }"
									style="width: 98%;" type="text" label="" /></td>
							<td><aui:input name="sqzy" value="${zqtzjkrzqk.sqzy }" type="text"
									style="width: 98%;" label="" /></td>
							<td><aui:input name="pzrq" value="${zqtzjkrzqk.pzrq }"
									type="text" style="width: 98%;" label="" /></td>
							<td><input type="button" value="删除" class="btn" style=""
								onclick="${renderResponse.namespace}changeLine(this)" /></td>
						</tr>

					</c:forEach>
				</c:if>
			</tbody>
			<tbody id="hiddenStyle" style="display: none">
				<tr>
					<td></td>
					<td><aui:input name="zjkxtlsdw_stand" value="" style="width: 98%;"
							type="text" label="" /></td>
					<td><aui:input name="sqzy_stand" value="" type="text"
							style="width: 98%;" label="" /></td>
					<td><aui:input name="pzrq_stand" value="" type="text"
							style="width: 98%;" label="" /></td>
					<td><input type="button" value="删除" class="btn" style=""
						onclick="${renderResponse.namespace}changeLine(this)" /></td>
				</tr>
			</tbody>
		</table>
	</div>
	<aui:button-row>
		<div style="text-align: center">
			<aui:button type="submit" value="保存" />
			<aui:button type="cancel" value="返回" href="${viewURL}" />
		</div>
	</aui:button-row>

</aui:form>
<script>
	function <portlet:namespace/>changeLine(obj) {
		if (obj.value == "添加") {
			var html = document.getElementById("hiddenStyle");
			var tbody = document.getElementById("zqtzjkrzqkData");
			var rnum = tbody.rows.length + 1;
			html.rows[0].cells[0].innerHTML = rnum;

			var reg = new RegExp("_stand", "g")

			tbody.insertRow().innerHTML = html.rows[0].innerHTML.replace(reg,
					"");
		} else {
			if (confirm("确定要删除吗？")) {
				var tb = obj.parentNode.parentNode.parentNode;
				tb.removeChild(obj.parentNode.parentNode);
			}
		}
	}
</script>