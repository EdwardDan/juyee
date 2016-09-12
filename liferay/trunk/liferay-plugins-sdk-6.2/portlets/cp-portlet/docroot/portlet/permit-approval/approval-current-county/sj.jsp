<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<style>
input,textarea{
	margin-bottom: 10px !important;
}
span{
    font-size: 15px;
    font-weight: 200;
    padding-top: 5px;
    padding-left: 5px;
    padding-right: 5px;
    position: relative;
    top: -4px;
}
</style>
<%
	long permitId = ParamUtil.getLong(request, "permitId");
	request.setAttribute("permitId", permitId);
	Permit permit = PermitLocalServiceUtil.getPermit(permitId);
	request.setAttribute("permit", permit);
	
%>

<portlet:actionURL var="saveSjURL" name="saveSj">
<portlet:param name="permitId" value="${permitId}"/>
</portlet:actionURL>
<form class="form-horizontal" action="${saveSjURL}" method="post">
	<aui:row>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="slbh">受理编号：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>slbh" value="${permit.slbh}">
			</div>
		</aui:col>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="cltjr">材料提交人：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>cltjr" value="${permit.cltjr}">
			</div>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="hjgsz">沪交管收字（</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>hjgsz" style="width: 10%" value="${permit.hjgsz}">&nbsp;&nbsp;<span>)&nbsp;第</span><input type="text" name="<portlet:namespace/>hjgsh" style="width: 5%" value="${permit.hjgsh}"><span>号</span>
			</div>
		</aui:col>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="cltjrlxdh">联系电话：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>cltjrlxdh" value="${permit.cltjrlxdh}">
			</div>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="sqr">申请人：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>sqr" value="${permit.sqr}">
			</div>
		</aui:col>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="cltjrlxdz">联系地址：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>cltjrlxdz" value="${permit.cltjrlxdz}">
			</div>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="sqsx">申请事项：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>sqsx" value="${permit.sqsx}">
			</div>
		</aui:col>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="sjr">收件人：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>sjr" value="${permit.sjr}">
			</div>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="sqh">申请号：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>sqh" value="${permit.sqh}">
			</div>
		</aui:col>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="sjrlxdh">联系电话：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>sjrlxdh" value="${permit.sjrlxdh}">
			</div>
		</aui:col>
	</aui:row>
	<%-- <aui:row>
		<aui:col span="12" cssClass="text-left">
		<label class="control-label" for="lxdh">审核意见：</label>
			<div class="controls">
				<textarea rows="3" name="<portlet:namespace/>lxdh" style="width: 70%"></textarea>
			</div>
		</aui:col>
	</aui:row> --%>
	<div class="text-center">
		<div>
			<div class="btn-group">
				<aui:button name="pass" type="submit" value="保存" cssClass="btn btn-primary" />
			</div>
			<%-- <div class="btn-group">
				<aui:button name="pass" value="收件通过" cssClass="btn btn-primary" />
			</div>
			<div class="btn-group">
				<aui:button name="reject" value="收件退回" cssClass="btn btn-danger" />
			</div> --%>
			<div class="btn-group">
				<aui:button name="close" value="关闭" cssClass="btn" href="${viewURL}"/>
			</div>
		</div>
	</div>
</form>