<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<portlet:defineObjects />

<portlet:renderURL var="viewURL" />
<portlet:actionURL var="saveGzjlURL" name="saveGzjls">
	<portlet:param name="redirectURL" value="${addExpertUrl}" />
</portlet:actionURL>

<%
	long expertId = ParamUtil.getLong(request, "expertId");
	if(expertId!=0){
	List<Gzjl>	gzjls = GzjlLocalServiceUtil.getGzjls(expertId, -1,-1);
	request.setAttribute("gzjls", gzjls);
	}
%>

<aui:form action="${saveGzjlURL}">
	<aui:input name="expertId" type="hidden" value="${expertId }"></aui:input>
	<div class="accordion-inner">
		<table width="100%" class="table table-bordered table-hover">
			<thead>
				<th style="width: 5%; text-align: center">序号</th>
				<th style="width: 25%; text-align: center">工作单位</th>
				<th style="width: 25%; text-align: center">起止年月</th>
				<th style="width: 25%; text-align: center">从事主要专业工作</th>
				<th style="width: 15%; text-align: center">职务</th>
				<th style="width: 5%; text-align: center"><input type="button"
					value="添加" class="btn" style=""
					onclick="${renderResponse.namespace}changeLine(this)" /></th>
			</thead>
			<tbody id="gzjlData">
				<c:if test="${!empty gzjls}">
					<c:forEach items="${gzjls }" var="gzjl" varStatus="indexNo">
						<tr>
							<td>${indexNo.index+1 }</td>
							<td><aui:input name="gzdw" value="${gzjl.gzdw }"
									style="width: 98%;" type="text" label="" /></td>
							<td><aui:input name="qzny" value="${gzjl.qzny }" type="text"
									style="width: 98%;" label="" /></td>
							<td><aui:input name="cszyzygz" value="${gzjl.cszyzygz }"
									type="text" style="width: 98%;" label="" /></td>
							<td><aui:input name="zw" value="${gzjl.zw }" type="text"
									style="width: 98%;" label="" /></td>
							<td><input type="button" value="删除" class="btn" style=""
								onclick="${renderResponse.namespace}changeLine(this)" /></td>
						</tr>

					</c:forEach>
				</c:if>
			</tbody>
			<tbody id="hiddenStyle" style="display: none">
				<tr>
					<td>${indexNo.index +1}</td>
					<td><aui:input name="gzdw_stand" value="" style="width: 98%;"
							type="text" label="" /></td>
					<td><aui:input name="qzny_stand" value="" type="text"
							style="width: 98%;" label="" /></td>
					<td><aui:input name="cszyzygz_stand" value="" type="text"
							style="width: 98%;" label="" /></td>
					<td><aui:input name="zw_stand" value="" type="text"
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
			var tbody = document.getElementById("gzjlData");
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