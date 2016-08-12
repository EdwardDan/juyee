<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<form
	action="${themeDisplay.getURLCurrent()}?p_p_id=58&amp;p_p_lifecycle=1&amp;p_p_state=normal&amp;p_p_mode=view&amp;p_p_col_id=column-1&amp;p_p_col_pos=2&amp;p_p_col_count=3&amp;_58_struts_action=%2Flogin%2Flogin"
	class="form sign-in-form " id="_58_fm" method="post" name="_58_fm"
	autocomplete="off">
	<fieldset class="input-container">
		<input name="_58_formDate" type="hidden" value="1470964064174">
		<input class="field" id="_58_saveLastPath" name="_58_saveLastPath"
			type="hidden" value="false"> <input class="field"
			id="_58_redirect" name="_58_redirect" type="hidden" value="${redirectPage}">
		<input class="field" id="_58_doActionAfterLogin"
			name="_58_doActionAfterLogin" type="hidden" value="false">
		<fieldset class="fieldset ">
			<div class="">
				<div class="control-group input-text-wrapper">
					<label class="control-label" for="_58_login"> 屏幕显示名称 </label> <input
						class="field clearable" id="_58_login" name="_58_login"
						type="text" value="">
				</div>
				<div class="control-group input-text-wrapper">
					<label class="control-label" for="_58_password"> 密码 </label> <input
						class="field" id="_58_password" name="_58_password"
						type="password" value="">
				</div>
				<span id="_58_passwordCapsLockSpan" style="display: none;">大写锁定键处于打开状态。</span>
				<div class="control-group form-inline input-checkbox-wrapper">
					<label class="checkbox" for="_58_rememberMeCheckbox"> <input
						id="_58_rememberMe" name="_58_rememberMe" type="hidden"
						value="false"> <input class="field"
						id="_58_rememberMeCheckbox" name="_58_rememberMeCheckbox"
						onclick="Liferay.Util.updateCheckboxValue(this); " type="checkbox"
						value="false"> 记住我
					</label>
				</div>
			</div>
		</fieldset>
		<div class="button-holder ">
			<button class="btn btn-primary" type="submit">登录</button>
		</div>
	</fieldset>
</form>