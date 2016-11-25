<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<portlet:defineObjects />

<%
	long expertId = ParamUtil.getLong(request, "expertId");
	if(expertId!=0){
	List<Gzjl>	gzjls = GzjlLocalServiceUtil.getGzjls(expertId, -1,-1);
	request.setAttribute("gzjls", gzjls);
	}
%>
<aui:form>
	<div class="accordion-inner">
		<table width="100%" class="table table-bordered table-hover">
			<thead>
				<th style="width: 5%; text-align: center">序号</th>
				<th style="width: 25%; text-align: center">工作单位</th>
				<th style="width: 25%; text-align: center">起止年月</th>
				<th style="width: 25%; text-align: center">从事主要专业工作</th>
				<th style="width: 20%; text-align: center">职务</th>
			</thead>
			<tbody id="gzjlData">
				<c:if test="${!empty gzjls}">
					<c:forEach items="${gzjls }" var="gzjl" varStatus="indexNo">
						<tr>
							<td>${indexNo.index+1 }</td>
							<td>${gzjl.gzdw }</td>
							<td>${gzjl.qzny }</td>
							<td>${gzjl.cszyzygz }</td>
							<td>${gzjl.zw }</td>
						</tr>

					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
	<aui:button-row>
		<div style="text-align: center">
			<aui:button type="cancel" value="返回" href="${viewURL}" />
		</div>
	</aui:button-row>

</aui:form>