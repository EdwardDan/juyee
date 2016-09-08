<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<aui:row>
	<aui:col span="12" cssClass="text-left">
		<aui:input name="opinion" label="审核意见：" inlineLabel="true"
			type="textarea" cssClass="span7" value=""></aui:input>
	</aui:col>
</aui:row>

<aui:button-row cssClass="text-center">
	<aui:button type="cancel" value="关闭" href="#" />
</aui:button-row>
