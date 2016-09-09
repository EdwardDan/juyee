<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<aui:form action="">
	<aui:row>
		<aui:col span="12" cssClass="text-center">
			<aui:select name="select" label="请选择：" inlineLabel="true">
				<aui:option>该事项不属于本行政机关职权范围；</aui:option>
				<aui:option>申请人隐瞒有关情况、提供虚假材料；</aui:option>
				<aui:option>不具备法定的申请主体资格；</aui:option>
				<aui:option>申请材料扔不齐全、不符合法定形式；</aui:option>
				<aui:option>（法律、法规、规章规定的其他不予受理的情形）；</aui:option>
			</aui:select>
		</aui:col>
	</aui:row>

	<aui:button-row cssClass="text-center">
		<aui:button type="submit" value="确定" />
		<aui:button type="cancel" value="关闭" href="#" />
	</aui:button-row>

</aui:form>
