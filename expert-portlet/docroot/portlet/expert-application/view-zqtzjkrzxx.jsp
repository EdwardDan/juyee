<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<portlet:defineObjects />

<portlet:renderURL var="viewURL" />

<%
	long expertId = ParamUtil.getLong(request, "expertId");
	if(expertId!=0){
	List<Zqtzjkrzqk>	zqtzjkrzqks = ZqtzjkrzqkLocalServiceUtil.getZqtzjkrzqks(expertId, -1,-1);
	request.setAttribute("zqtzjkrzqks", zqtzjkrzqks);
	}
%>

<aui:form>
	<div class="accordion-inner">
		<table width="100%" class="table table-bordered table-hover">
			<thead>
				<th style="width: 5%; text-align: center">序号</th>
				<th style="width: 35%; text-align: center">专家库系统隶属单位</th>
				<th style="width: 30%; text-align: center">申请专业</th>
				<th style="width: 30%; text-align: center">批准日期</th>
			</thead>
			<tbody id="zqtzjkrzqkData">
				<c:if test="${!empty zqtzjkrzqks}">
					<c:forEach items="${zqtzjkrzqks }" var="zqtzjkrzqk" varStatus="indexNo">
						<tr>
								<td>${indexNo.index +1}</td>
							<td>${zqtzjkrzqk.zjkxtlsdw }</td>
							<td>${zqtzjkrzqk.sqzy }</td>
							<td><fmt:formatDate value="${zqtzjkrzqk.pzrq }" pattern="yyyy-MM-dd"/></td>
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
