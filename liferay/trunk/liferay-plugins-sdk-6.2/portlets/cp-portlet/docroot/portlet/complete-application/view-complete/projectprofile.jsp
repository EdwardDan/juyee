<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<style type="text/css">
tr.body td.title {
	width: 20%;
	text-align: right;
}

tr.body td.content {
	width: 30%;
	background-color: white;
	text-align: left;
}
</style>
<%
	long completeId = ParamUtil.getLong(request, "completeId");
	Complete complete = CompleteLocalServiceUtil.getComplete(completeId);
	CompleteProjectProfile projectProfile = CompleteProjectProfileLocalServiceUtil.getCompleteProjectProfile(completeId);
	
	Dictionary jsgclb = DictionaryLocalServiceUtil.findByCode("jsgclb");
	List<Dictionary> jsgclbs = jsgclb != null ? DictionaryLocalServiceUtil.findByParentId(
			jsgclb.getDictionaryId(), -1, -1) : null;
	request.setAttribute("complete", complete);
	request.setAttribute("projectProfile", projectProfile);
	request.setAttribute("jsgclbs", jsgclbs);
%>

