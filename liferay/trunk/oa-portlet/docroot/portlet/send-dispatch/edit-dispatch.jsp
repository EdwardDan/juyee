<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<script src="${staticServerURL}/My97DatePicker/WdatePicker.js"></script>
<%
	long groupId = PortalUtil.getScopeGroupId(request);
	Dispatch dispatch = (Dispatch) request.getAttribute("dispatch");
	String writtenDateFormat = "";
	if (null != dispatch) {
		writtenDateFormat = DateUtil.getDate(dispatch.getWrittenDate(), defaultDateFormatPattern, locale, timeZone);
	}
%>

<c:set var="contentPath"
	value="${request.contextPath}/portlet/send-Dispatch" />
	<portlet:renderURL var="viewURL" />
<aui:model-context bean="${dispatch}" model="<%=Dispatch.class %>" />

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
			if (null != dictionary) {
							List<Dictionary> dictionaries = DictionaryLocalServiceUtil
									.findByGroupIdAndParentId(groupId,
											dictionary.getDictionaryId(), -1, -1);
							for (Dictionary dic : dictionaries) {
			%>
			<aui:option value="<%=dic.getDictionaryId()%>"><%=dic.getName()%></aui:option>
			<%
							}}
			%>
		</aui:select>
		<aui:select name="securityLevel" label="密级">
			<%
				Dictionary dictionary = DictionaryLocalServiceUtil
									.findByGroupIdAndCode(groupId, "securityLevel");
			if (null != dictionary) {
							List<Dictionary> dictionaries = DictionaryLocalServiceUtil
									.findByGroupIdAndParentId(groupId,
											dictionary.getDictionaryId(), -1, -1);
							for (Dictionary dic : dictionaries) {
			%>
			<aui:option value="<%=dic.getDictionaryId()%>"><%=dic.getName()%></aui:option>
			<%
							}}
			%>
		</aui:select>
		<aui:select name="organaAbbreviation" label="发文机关代字">
			<%
				Dictionary dictionary = DictionaryLocalServiceUtil
									.findByGroupIdAndCode(groupId,
											"organaAbbreviation");
			if (null != dictionary) {
							List<Dictionary> dictionaries = DictionaryLocalServiceUtil
									.findByGroupIdAndParentId(groupId,
											dictionary.getDictionaryId(), -1, -1);
							for (Dictionary dic : dictionaries) {
			%>
			<aui:option value="<%=dic.getDictionaryId()%>"><%=dic.getName()%></aui:option>
			<%
							}}
			%>
		</aui:select>
		<aui:select name="year" label="发文年份">
			<%
				Dictionary dictionary = DictionaryLocalServiceUtil
									.findByGroupIdAndCode(groupId, "year");
							if (null != dictionary) {
								List<Dictionary> dictionaries = DictionaryLocalServiceUtil
										.findByGroupIdAndParentId(groupId,
												dictionary.getDictionaryId(), -1,
												-1);
								for (Dictionary dic : dictionaries) {
			%>
			<aui:option value="<%=dic.getDictionaryId()%>"><%=dic.getName()%></aui:option>
			<%
				}
							}
			%>
		</aui:select>
		<aui:input name="serialNo" label="文件顺序号">
		<aui:validator name="required"/>
		<aui:validator name="number" />
		</aui:input>
		<aui:input name="title" label="发文标题">
		<aui:validator name="required"/>
		</aui:input>
		<aui:input name="sendOrgan" label="主送机关">
		<aui:validator name="required"/>
		</aui:input>
		<aui:input name="ccOrgan" label="抄送机关">
		<aui:validator name="required"/>
		</aui:input>
		<aui:input name="writtenOrgan" label="成文机关">
		<aui:validator name="required"/>
		</aui:input>
		<aui:input type="text" cssClass="Wdate" name="writtenDateFormat"
			label="成文日期" onfocus="WdatePicker({lang:'zh-cn'})"
			value="<%=writtenDateFormat%>" />
		<aui:select name="urgencyDegree" label="紧急程度">
			<%
				Dictionary dictionary = DictionaryLocalServiceUtil
									.findByGroupIdAndCode(groupId, "urgencyDegree");
			if (null != dictionary) {
							List<Dictionary> dictionaries = DictionaryLocalServiceUtil
									.findByGroupIdAndParentId(groupId,
											dictionary.getDictionaryId(), -1, -1);
							for (Dictionary dic : dictionaries) {
			%>
			<aui:option value="<%=dic.getDictionaryId()%>"><%=dic.getName()%></aui:option>
			<%
				}}
			%>
		</aui:select>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="提交" />
		<aui:button type="cancel" value="取消" href="${viewURL }" />
	</aui:button-row>
</aui:form>