<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<style>
.sp{
	margin-right: 30px;
}
</style>
<%
    String curTab = ParamUtil.getString(request, "curTab" , "工程概况");
	request.setAttribute("curTab", curTab);
	Long permitId = ParamUtil.getLong(request, "permitId");
	Permit permit = PermitLocalServiceUtil.getPermit(permitId);
	ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
	int status = permit.getStatus();
	request.setAttribute("permitId", permitId);
	String contractId = ParamUtil.getString(request, "contractId");
	Project project = null;
	Contract contract = null;
	if (Validator.isNotNull(contractId)) {
		contract = ContractLocalServiceUtil.getContract(contractId);
		renderRequest.setAttribute("contract", contract);
		renderRequest.setAttribute("bdh", contract.getBdh());
	}
	if (permitId != 0) {
		projectProfile = ProjectProfileLocalServiceUtil
				.getProjectProfile(permitId);
		renderRequest.setAttribute("bdh", permit.getBdh());
		renderRequest.setAttribute("bjbh",permit.getBjbh());
		renderRequest.setAttribute("xmmc", projectProfile.getGcmc());
	} else {
		String bjbh = ParamUtil.getString(request, "bjbh");
		project = ProjectLocalServiceUtil.getProject(bjbh);
		renderRequest.setAttribute("bjbh",bjbh);
		renderRequest.setAttribute("xmmc", project.getXmmc());
	}
%>
<liferay-ui:header title="施工许可申请查看" backURL="${viewURL }" />
<div class="alert alert-info"><span class="sp">当前报建编号：${bjbh}</span><span class="sp">项目名称：${xmmc}</span><span class="sp">标段号:${bdh}</span></div>
<liferay-ui:tabs names="工程概况,参建单位,单位工程,申请材料" refresh="false" value="${curTab}">
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-permit/projectprofile.jsp" />
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-permit/participationunits.jsp" />
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-permit/unitprojects.jsp" />
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-permit/applymaterials.jsp" />
	</liferay-ui:section>
</liferay-ui:tabs>
<br>

<aui:button-row cssClass="text-center">
	<portlet:renderURL var="printsjpzURL" windowState="pop_up">
		<portlet:param name="mvcPath" value="${contextPath}/print/sjpz.jsp" />
		<portlet:param name="permitId" value="${permitId}" />
	</portlet:renderURL>
	<portlet:renderURL var="printsltzsURL" windowState="pop_up">
		<portlet:param name="mvcPath" value="${contextPath}/print/sltzs.jsp" />
		<portlet:param name="permitId" value="${permitId}" />
	</portlet:renderURL>
	<portlet:renderURL var="printbysljdsURL" windowState="pop_up">
		<portlet:param name="mvcPath" value="${contextPath}/print/bysljds.jsp" />
		<portlet:param name="permitId" value="${permitId}" />
	</portlet:renderURL>
	<portlet:renderURL var="printbzclURL" windowState="pop_up">
		<portlet:param name="mvcPath" value="${contextPath}/print/bzcl.jsp" />
		<portlet:param name="permitId" value="${permitId}" />
	</portlet:renderURL>
	<portlet:renderURL var="printjsscbURL" windowState="pop_up">
		<portlet:param name="mvcPath" value="${contextPath}/print/jsscb.jsp" />
		<portlet:param name="permitId" value="${permitId}" />
	</portlet:renderURL>
	<portlet:resourceURL var="printsgxkURL" id="printsgxkPdf">
	</portlet:resourceURL>
	<portlet:resourceURL var="printsgxklsURL" id="printsgxklsPdf">
	</portlet:resourceURL>
	<portlet:resourceURL var="printkgbaURL" id="printkgbaPdf"> 
	</portlet:resourceURL>
	<portlet:resourceURL var="printsgxk" id="ptintsgxkExcel">  
		<portlet:param name="permitId" value="${permitId}" /> 
	</portlet:resourceURL>
	<portlet:resourceURL var="printsgxkls" id="printsgxklsExcel">
		<portlet:param name="permitId" value="${permitId}" />
	</portlet:resourceURL>
	<portlet:resourceURL var="printkgba" id="printkgbaExcel">
		<portlet:param name="permitId" value="${permitId}" />
	</portlet:resourceURL>
	<portlet:resourceURL var="viewCertificateURL" id="view">
	<portlet:param name="permitId" value="${permitInit}"/>
</portlet:resourceURL>
	<c:if test="<%=!projectProfile.getLxjb().equals(\"区县级机关或区县级单位\")%>">
		<c:if test="<%=status >=2&& status<=16%>">
			<a class="btn" onclick="viewCertificate()">预览施工许可证书</a>
		</c:if>
		<c:if test="<%=status >= 13&&status!=17%>">
			<a class="btn" href="${printsjpzURL}" target="_blank">收件凭证</a>
		</c:if>
		<%-- <c:if test="<%=status >= 9%>">
			<a class="btn" href="${printsltzsURL}" target="_blank">受理通知书</a>
		</c:if> --%>
		<%-- <c:if test="<%=status == 10%>">
			<a class="btn" href="${printbysljdsURL}" target="_blank">不予受理决定书</a>
		</c:if> --%>
		<%-- <c:if test="<%=status == 23%>">
			<a class="btn" href="${printbzclURL}" target="_blank">补正材料</a>
		</c:if> --%>
		<c:if
			test="<%=status == CityPermitStatus.STATUS_ZXLD_PASS.getCode()
								|| status == CityPermitStatus.STATUS_WLD_PASS.getCode()%>">
			<a class="btn" href="${printjsscbURL}" target="_blank">技术审查表</a>
		</c:if>
		<c:if test="<%=status==14&&status==15&&status==18%>">
			<c:choose>
				<c:when test="<%=projectProfile.getXmlx() == 29741%>">
					<a class="btn" onclick="kgba()">开工备案Pdf</a>
					<a class="btn" href="${printkgba}">开工备案Excel</a>
				</c:when>
				<c:otherwise>
					<c:if test="<%=projectProfile.getXmxz() != 29769%>">
						<a class="btn" onclick="sgxkls()" >施工许可(绿色)Pdf</a>
						<a class="btn" href="${printsgxkls}">施工许可(绿色)Excel</a>
					</c:if>
					<c:if test="<%=projectProfile.getXmxz() == 29769%>">
						<a class="btn" onclick="sgxk()">施工许可Pdf</a>
						<a class="btn" href="${printsgxk}">施工许可Excel</a>
					</c:if>
				</c:otherwise>
			</c:choose>
		</c:if>
		<c:if test="<%=status == CityPermitStatus.STATUS_WLD_BACK.getCode()%>">
			<a class="btn" href="" target="_blank">不予许可通知书</a>
		</c:if>
	</c:if>
	<c:if test="<%=projectProfile.getLxjb().equals(\"区县级机关或区县级单位\")%>">
		<c:if test="<%=status >=2&&status!=4&&status!=7%>">
			<a class="btn" onclick="viewCertificate()">预览施工许可证书</a>
		</c:if>
		<c:if test="<%=status >= 3%>">
			<a class="btn" href="${printsjpzURL}" target="_blank">收件凭证</a>
		</c:if>
		<%-- <c:if
			test="<%=status == CountyPermitStatus.STATUS_SP_PASS.getCode()
								|| status == CountyPermitStatus.STATUS_SP_BACK.getCode()%>">
			<a class="btn" href="${printsltzsURL}" target="_blank">受理通知书</a>
		</c:if> --%>
		<%-- <c:if test="<%=status == 8%>">
			<a class="btn" href="${printbysljdsURL}" target="_blank">不予受理决定书</a>
		</c:if> --%>
		<c:if test="<%=status == 9%>">
			<a class="btn" href="${printbzclURL}" target="_blank">补正材料</a>
		</c:if>
		<c:if test="<%=status == CountyPermitStatus.STATUS_SP_PASS.getCode()%>">
			<c:choose>
				<c:when test="<%=projectProfile.getXmlx() == 29741%>">
					<a class="btn" onclick="kgba()">开工备案Pdf</a>
					<a class="btn" href="${printkgba}">开工备案Excel</a>
				</c:when>
				<c:otherwise>
					<c:if test="<%=projectProfile.getXmxz() != 29769%>">
						<a class="btn" onclick="sgxkls()" >施工许可(绿色)Pdf</a>
						<a class="btn" href="${printsgxkls}">施工许可(绿色)Excel</a>
					</c:if>
					<c:if test="<%=projectProfile.getXmxz() == 29769%>">
						<a class="btn" onclick="sgxk()">施工许可Pdf</a>
						<a class="btn" href="${printsgxk}">施工许可Excel</a>
					</c:if>
				</c:otherwise>
			</c:choose>
		</c:if>
	</c:if>
<script type="text/javascript">
	function viewCertificate(){
		window.location = '${viewCertificateURL}';
	}
	
	function kgba(){
		$.ajax({
			type:"GET",	
			url:"<%=printkgbaURL%>",
			data:{
				'permitId':<%=permitId%>
			},
			success:function(data){
				location.href=data;
			}
		})
	}
	function sgxk(){
		$.ajax({
			type:"GET",
			url:"<%=printsgxkURL%>",
			data:{
				'permitId':<%=permitId%>
			},
			success:function(data){
				location.href=data;
			}
		})
	}
	function sgxkls(){
		$.ajax({
			type:"GET",
			url:"<%=printsgxklsURL%>",
			data:{
				'permitId':<%=permitId%>
			},
			success:function(data){
				location.href=data;
			}
		})
	}
</script>
</aui:button-row>