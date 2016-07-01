<%@page import="org.apache.taglibs.standard.lang.jstl.test.Bean1"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<script type="text/javascript"
	src="/html/js/My97DatePicker/WdatePicker.js"></script>
<% long groupId = PortalUtil.getScopeGroupId(request);
Dispatch dispatch = (Dispatch) request.getAttribute("dispatch");
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
String writtenDateFormat="";
if(null!=dispatch){
	writtenDateFormat=sdf.format(dispatch.getWrittenDate());
}
%>

<c:set var="contentPath"
	value="${request.contextPath}/portlet/send-Dispatch" />
<portlet:renderURL var="viewURL" />
<aui:model-context bean="${dispatch}" model="<%=Dispatch.class %>" />
<portlet:renderURL var="viewURL" />
<liferay-ui:header title='${empty dispatch?"添加":"编辑"}发文记录'
	backURL="${viewURL }" />
<portlet:actionURL var="saveDispatchURL" name="saveDispatch">
	<portlet:param name="redirect" value="${viewURL }" />
</portlet:actionURL>
<aui:form action="${saveDispatchURL}">
	<aui:fieldset>
		<aui:input name="dispatchId" type="hidden" />
		<aui:select name="rocordType" label="文种">
			<%
							Dictionary dictionary = DictionaryLocalServiceUtil
									.findByGroupIdAndCode(groupId, "rocordType");
							List<Dictionary> dictionaries = DictionaryLocalServiceUtil
									.findByGroupIdAndParentId(groupId,
											dictionary.getDictionaryId(), -1, -1);
							for (Dictionary dic : dictionaries) {
			%>
			<aui:option value="<%=dic.getDictionaryId()%>"><%=dic.getName()%></aui:option>
			<%
				}
			%>
		</aui:select>
		<aui:select name="securityLevel" label="密级">
			<%
							Dictionary dictionary = DictionaryLocalServiceUtil
									.findByGroupIdAndCode(groupId, "securityLevel");
							List<Dictionary> dictionaries = DictionaryLocalServiceUtil
									.findByGroupIdAndParentId(groupId,
											dictionary.getDictionaryId(), -1, -1);
							for (Dictionary dic : dictionaries) {
			%>
			<aui:option value="<%=dic.getDictionaryId()%>"><%=dic.getName()%></aui:option>
			<%
				}
			%>
		</aui:select>
		<aui:select name="organaAbbreviation" label="沪交建">
			<%
							Dictionary dictionary = DictionaryLocalServiceUtil
									.findByGroupIdAndCode(groupId, "organaAbbreviation");
							List<Dictionary> dictionaries = DictionaryLocalServiceUtil
									.findByGroupIdAndParentId(groupId,
											dictionary.getDictionaryId(), -1, -1);
							for (Dictionary dic : dictionaries) {
			%>
			<aui:option value="<%=dic.getDictionaryId()%>"><%=dic.getName()%></aui:option>
			<%
				}
			%>
		</aui:select>
		<aui:select name="year" label="年">
			<%
							Dictionary dictionary = DictionaryLocalServiceUtil
									.findByGroupIdAndCode(groupId, "year");
							List<Dictionary> dictionaries = DictionaryLocalServiceUtil
									.findByGroupIdAndParentId(groupId,
											dictionary.getDictionaryId(), -1, -1);
							for (Dictionary dic : dictionaries) {
			%>
			<aui:option value="<%=dic.getDictionaryId()%>"><%=dic.getName()%></aui:option>
			<%
				}
			%>
		</aui:select>
		<aui:input name="serialNo" label="号" />
		<aui:input name="title" label="发文标题" />
		<aui:input name="sendOrgan" label="主送机关" />
		<aui:input name="ccOrgan" label="抄送机关" />
		<aui:input name="writtenOrgan" label="成文机关" />
		<aui:input type="text" cssClass="Wdate" name="writtenDateFormat"
			label="成文日期" onfocus="WdatePicker({lang:'zh-cn'})" value="<%=writtenDateFormat %>" /> 
		<%--  <input type="text" name="<portlet:namespace/>writtenDate" class="Wdate "  onfocus="WdatePicker({lang:'zh-cn'})" value="<fmt:formatDate value="${dispatch.writtenDate}" pattern="yyyy-MM-dd"/> "/> --%> 
		<aui:select name="urgencyDegree" label="紧急程度">
		<%
							Dictionary dictionary = DictionaryLocalServiceUtil
									.findByGroupIdAndCode(groupId, "urgencyDegree");
							List<Dictionary> dictionaries = DictionaryLocalServiceUtil
									.findByGroupIdAndParentId(groupId,
											dictionary.getDictionaryId(), -1, -1);
							for (Dictionary dic : dictionaries) {
			%>
			<aui:option value="<%=dic.getDictionaryId()%>"><%=dic.getName()%></aui:option>
			<%
				}
			%>
		</aui:select>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="提交" />
		<aui:button type="cancel" value="取消" href="${viewURL }" />
	</aui:button-row>
</aui:form>