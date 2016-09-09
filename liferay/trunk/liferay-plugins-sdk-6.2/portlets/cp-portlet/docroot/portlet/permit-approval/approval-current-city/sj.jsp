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
<form class="form-horizontal">
	<aui:row>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="slbh">受理编号：</label>
			<div class="controls">
				<input type="text" id="slbh">
			</div>
		</aui:col>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="cltjr">材料提交人：</label>
			<div class="controls">
				<input type="text" id="cltjr">
			</div>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="hjgsz">沪交管收字（</label>
			<div class="controls">
				<input type="text" id="hjgsz" style="width: 10%">&nbsp;&nbsp;<span>)&nbsp;第</span><input type="text" id="slbh" style="width: 5%"><span>号</span>
			</div>
		</aui:col>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="lxdh">联系电话：</label>
			<div class="controls">
				<input type="text" id="lxdh">
			</div>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="sqr">申请人：</label>
			<div class="controls">
				<input type="text" id="sqr">
			</div>
		</aui:col>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="lxdz">联系地址：</label>
			<div class="controls">
				<input type="text" id="lxdz">
			</div>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="sqsx">申请事项：</label>
			<div class="controls">
				<input type="text" id="sqsx">
			</div>
		</aui:col>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="sjr">收件人：</label>
			<div class="controls">
				<input type="text" id="sjr">
			</div>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="sqh">申请号：</label>
			<div class="controls">
				<input type="text" id="sqh">
			</div>
		</aui:col>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="lxdh">联系电话：</label>
			<div class="controls">
				<input type="text" id="lxdh">
			</div>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="12" cssClass="text-left">
		<label class="control-label" for="lxdh">审核意见：</label>
			<div class="controls">
				<textarea rows="3" id="lxdh" style="width: 70%"></textarea>
			</div>
		</aui:col>
	</aui:row>
	<div class="text-center">
		<div>
			<div class="btn-group">
				<aui:button name="pass" value="收件通过" cssClass="btn btn-primary" />
			</div>
			<div class="btn-group">
				<aui:button name="reject" value="收件退回" cssClass="btn btn-danger" />
			</div>
			<div class="btn-group">
				<aui:button name="close" value="关闭" cssClass="btn" href="${viewURL}"/>
			</div>
		</div>
	</div>
</form>