<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<portlet:defineObjects />

<portlet:renderURL var="viewURL" />

<%
	long expertId = ParamUtil.getLong(request, "expertId");
	if(expertId!=0){
	List<Xlxx>	xlxxs = XlxxLocalServiceUtil.getXlxxs(expertId, -1,-1);
	request.setAttribute("xlxxs", xlxxs);
	}
%>

<aui:form>
	<div class="accordion-inner">
		<table width="100%" class="table table-bordered table-hover">
			<thead>
				<th style="width: 5%; text-align: center">序号</th>
				<th style="width: 25%; text-align: center">毕业院校</th>
				<th style="width: 25%; text-align: center">所学专业</th>
				<th style="width: 20%; text-align: center">学历和学位</th>
				<th style="width: 25%; text-align: center">在校时间</th>
			</thead>
			<tbody id="xlxx">
				<c:if test="${!empty xlxxs}">
					<c:forEach items="${xlxxs }" var="xlxx" varStatus="indexNo">
						<tr>
							<td>${indexNo.index +1}</td>
							<td>${xlxx.byyx }</td>
							<td>${xlxx.sxzy }</td>
							<td>${xlxx.xlhxw }</td>
							<td>${xlxx.zxsj }</td>
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
