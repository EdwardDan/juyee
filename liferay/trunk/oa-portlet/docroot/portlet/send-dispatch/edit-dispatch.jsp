<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<script src="${staticServerURL}/My97DatePicker/WdatePicker.js"></script>
<%
	long groupId = PortalUtil.getScopeGroupId(request);
	Dispatch dispatch = (Dispatch) request.getAttribute("dispatch");
	String writtenDateFormat = "";
	if (null != dispatch) {
		writtenDateFormat = DateUtil.getDate(dispatch.getWrittenDate(), defaultDateFormatPattern, locale,
				timeZone);
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
		<aui:row>
			<aui:col span="3" cssClass="text-left">
				<aui:select name="rocordType" label="文种" inlineField="true"
					inlineLabel="left" type="select" style="width:100px">
					<%
						Dictionary dictionary = DictionaryLocalServiceUtil.findByCode(
													"rocordType");
											if (null != dictionary) {
												List<Dictionary> dictionaries = DictionaryLocalServiceUtil
														.findByParentId( dictionary.getDictionaryId(), -1, -1);
												for (Dictionary dic : dictionaries) {
					%>
					<aui:option value="<%=dic.getDictionaryId()%>"><%=dic.getName()%></aui:option>
					<%
						}
											}
					%>
				</aui:select>
			</aui:col>
			<aui:col span="3" cssClass="text-left">
				<aui:select name="securityLevel" label="密级" inlineField="true"
					inlineLabel="left" type="select" style="width:70px">
					<%
						Dictionary dictionary = DictionaryLocalServiceUtil.findByCode(
													"securityLevel");
											if (null != dictionary) {
												List<Dictionary> dictionaries = DictionaryLocalServiceUtil
														.findByParentId( dictionary.getDictionaryId(), -1, -1);
												for (Dictionary dic : dictionaries) {
					%>
					<aui:option value="<%=dic.getDictionaryId()%>"><%=dic.getName()%></aui:option>
					<%
						}
											}
					%>
				</aui:select>
			</aui:col>
			<aui:col span="6" cssClass="text-left">
				<aui:select name="organaAbbreviation" label="" inlineField="true"
					inlineLabel="left" type="select" style="width:90px">
					<%
						Dictionary dictionary = DictionaryLocalServiceUtil.findByCode(
													"organaAbbreviation");
											if (null != dictionary) {
												List<Dictionary> dictionaries = DictionaryLocalServiceUtil
														.findByParentId( dictionary.getDictionaryId(), -1, -1);
												for (Dictionary dic : dictionaries) {
					%>
					<aui:option value="<%=dic.getDictionaryId()%>"><%=dic.getName()%></aui:option>
					<%
						}
											}
					%>
				</aui:select>(
		<aui:select name="year" label="" inlineField="true" inlineLabel="left"
					type="select" style="width:70px">
					<%
						Dictionary dictionary = DictionaryLocalServiceUtil
													.findByCode( "year");
											if (null != dictionary) {
												List<Dictionary> dictionaries = DictionaryLocalServiceUtil
														.findByParentId( dictionary.getDictionaryId(), -1, -1);
												for (Dictionary dic : dictionaries) {
					%>
					<aui:option value="<%=dic.getDictionaryId()%>"><%=dic.getName()%></aui:option>
					<%
						}
											}
					%>
				</aui:select>)
		<aui:input name="serialNo" label="" inlineField="true"
					inlineLabel="left" type="text" style="width: 60px; ">
					<aui:validator name="required" />
					<aui:validator name="number" />
				</aui:input>号
		</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="6" cssClass="text-left">
				<aui:input name="title" label="发文标题" inlineLabel="left" type="text"
					style="width: 70%; ">
					<aui:validator name="required" />
				</aui:input>
			</aui:col>
			<aui:col span="6" cssClass="text-left">
				<aui:input name="sendOrgan" label="主送机关" inlineLabel="left"
					type="text" style="width: 70%; ">
					<aui:validator name="required" />
				</aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="6" cssClass="text-left">
				<aui:input name="ccOrgan" label="抄送机关" inlineLabel="left"
					type="text" style="width: 70%; ">
					<aui:validator name="required" />
				</aui:input>
			</aui:col>
			<aui:col span="6" cssClass="text-left">
				<aui:input name="writtenOrgan" label="成文机关" inlineLabel="left"
					type="text" style="width: 70%; ">
					<aui:validator name="required" />
				</aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="6" cssClass="text-left">
				<aui:input type="text" cssClass="Wdate" inlineField="true"
					inlineLabel="left" name="writtenDateFormat" label="成文日期"
					onfocus="WdatePicker({lang:'zh-cn'})" style="width:100px"
					value="<%=writtenDateFormat%>" />
			</aui:col>
			<aui:col span="6" cssClass="text-left">
				<aui:select name="urgencyDegree" label="紧急程度" inlineField="true"
					inlineLabel="left" type="select" style="width: 60px;">
					<%
						Dictionary dictionary = DictionaryLocalServiceUtil.findByCode(
													"urgencyDegree");
											if (null != dictionary) {
												List<Dictionary> dictionaries = DictionaryLocalServiceUtil
														.findByParentId( dictionary.getDictionaryId(), -1, -1);
												for (Dictionary dic : dictionaries) {
					%>
					<aui:option value="<%=dic.getDictionaryId()%>"><%=dic.getName()%></aui:option>
					<%
						}
											}
					%>
				</aui:select>
			</aui:col>
		</aui:row>
	</aui:fieldset>
	<aui:button-row cssClass="text-center">
		<aui:button type="submit" value="提交" />
		<aui:button type="cancel" value="取消" href="${viewURL }" />
	</aui:button-row>
</aui:form>