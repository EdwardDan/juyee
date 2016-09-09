<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<aui:form action="">
	<div class="text-center">
		<div>
			预审意见：
			<textarea rows="3" name="ysyj" style="width: 70%; margin-bottom: 15px;margin-top: 15px"></textarea>
		</div>
		<div>
			<div class="btn-group">
				<aui:button name="pass" value="预审通过" cssClass="btn btn-primary" />
			</div>
			<div class="btn-group">
				<aui:button name="reject" value="预审退回" cssClass="btn btn-danger" />
			</div>
			<div class="btn-group">
				<aui:button name="close" value="关闭" cssClass="btn" href="${viewURL}"/>
			</div>
		</div>
	</div>
</aui:form>