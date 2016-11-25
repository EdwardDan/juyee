<%@page import="com.justonetech.expert.service.ZysqlbLocalServiceUtil"%>
<%@page import="com.justonetech.expert.model.Zysqlb"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<%@page import="com.justonetech.sys.service.DictionaryLocalServiceUtil"%>
<%@ page import="com.justonetech.sys.model.Dictionary"%>
<%
	String zysqlbId = ParamUtil.getString(request, "zysqlbId");
System.out.println(zysqlbId);
Zysqlb zysqlb = ZysqlbLocalServiceUtil.getZysqlb(Long.parseLong(zysqlbId));
Dictionary dictionary = DictionaryLocalServiceUtil.getDictionary(Long.parseLong(zysqlb.getSx()));
request.setAttribute("dictionary",dictionary);
request.setAttribute("zysqlb",zysqlb);
long expertId = ParamUtil.getLong(request, "expertId");
request.setAttribute("expertId",expertId);
%>
<portlet:renderURL var="viewExpertURL">
		<portlet:param name="mvcPath" value="${contextPath }/view-expert.jsp"/>
		<portlet:param name="expertId" value="${expertId}" />
</portlet:renderURL>
<aui:model-context bean="${zysqlb}" model="<%=Zysqlb.class %>" />
<liferay-ui:header title='查看专业申请'
	backURL="${viewExpertURL}" />
<aui:form>
	<aui:input name="expertId" type="hidden" value="2" />
	<aui:input name="zysqlbId" type="hidden" />
	<aui:input name="zt" type="hidden" value="3" />
	<table class="table table-bordered" width="100%">
		<tr>
			<td class="text-left" width="10%">选择申请事项:</td>
			<td class="bg-white"  width="90%">
					${dictionary.name }
				</td>
				</tr>
				<tr>
			<td class="text-right">选择专业类别</td>
			<td class="bg-white">
				<div id="<portlet:namespace />zyInput">
					<%
											Dictionary dic = DictionaryLocalServiceUtil.getDictionary(Long.parseLong(zysqlb.getSx()));
											if (null != dic) {
												List<Dictionary> lb = DictionaryLocalServiceUtil
														.findByParentId( dic.getDictionaryId(), -1, -1);
												request.setAttribute("lb", lb);
											}
					%>
					<c:forEach items="${lb}" var="lb" varStatus="sortNo">
						<c:choose>
							<c:when test="${fn:contains(zysqlb.zy,lb.name)}">
								<input name="<portlet:namespace/>zy" type="checkbox"
									id="lb${sortNo.index}" value="${lb.dictionaryId}"
									checked="checked" inlineField="true" onClick="return false">${lb. name}</input>
							</c:when>
							<c:otherwise>
								<input name="<portlet:namespace/>zy" type="checkbox"
									id="lb${sortNo.index}" value="${lb.dictionaryId}"
									inlineField="true" onClick="return false">${lb. name}</input>
							</c:otherwise> 
						</c:choose>
					</c:forEach>
				</div>
			</td>
			</tr>
</aui:form>
