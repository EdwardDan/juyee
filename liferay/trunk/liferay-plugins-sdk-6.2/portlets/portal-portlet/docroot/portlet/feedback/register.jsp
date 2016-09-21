<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<portlet:renderURL var="viewURL" />
<style type="text/css">
.xh {
	color: #ff954f;;
}

.register_input {
	margin: 10px auto 0px !important;
	border-radius: 5px !important;
}

.register_table {
	margin: 0px auto;
}
</style>
<script type="text/javascript">
    window.jQuery || document.write("<script src='/static/jquery/jquery-1.12.4.min.js'>"+"<"+"/script>");
</script>
<div class="main">
	<div class="head"></div>
	<div class="body">
		<table class="thead">
			<tr>
				<td colspan="2" class="td"><span style="width: 5px; height: 20px; background-color: #ffa200; display: inline-block"></span><span>新用户注册</span>
				</td>
			</tr>
		</table>
	</div>
	<div>
		<form
			action="${themeDisplay.getURLHome()}?p_p_id=58&amp;p_p_lifecycle=1&amp;p_p_state=normal&amp;p_p_mode=view&amp;p_p_col_id=column-1&amp;p_p_col_pos=2&amp;p_p_col_count=3&amp;_58_struts_action=%2Flogin%2Flogin"
			class="form sign-in-form " id="<portlet:namespace/>_58_fm" method="post" name="<portlet:namespace/>_58_fm" autocomplete="off">
			<input class="field" id="_58_saveLastPath" name="_58_saveLastPath" type="hidden" value="false"> <input class="field" id="_58_redirect"
				name="_58_redirect" type="hidden" value="${themeDisplay.getURLCurrent()}"> <input class="field" id="_58_doActionAfterLogin"
				name="_58_doActionAfterLogin" type="hidden" value="false"> <input class="field" id="_58_login" name="_58_login" type="hidden" value="">
			<input class="field" id="_58_password" name="_58_password" type="hidden" value="">
		</form>
		<aui:form>
			<table class="register_table">
				<tr>
					<td class="text-right"><span class="xh">*</span>用户名</td>
					<td class="text-left"><aui:input name="yhm" id="yhm" label="">
							<aui:validator name="required" />
							<aui:validator name="alphanum" />
							<aui:validator name="maxLength">18</aui:validator>
							<aui:validator name="minLength">4</aui:validator>
						</aui:input></td>
				</tr>
				<tr>
					<td class="text-right"><span class="xh">*</span>密码</td>
					<td class="text-left"><aui:input name="mm" id="mm" label="" type="password">
							<aui:validator name="required" />
						</aui:input></td>
				</tr>
				<tr>
					<td class="text-right"><span class="xh">*</span>确认密码</td>
					<td class="text-left"><aui:input name="qrmm" id="qrmm" label="" type="password">
							<aui:validator name="equalTo">'#<portlet:namespace />mm'</aui:validator>
						</aui:input></td>
				</tr>
				<tr>
					<td class="text-right"><span class="xh">*</span>身份证号</td>
					<td class="text-left"><aui:input name="sfzh" id="sfzh" label="">
							<aui:validator name="required" />
						</aui:input></td>
				</tr>
				<tr>
					<td class="text-right"><span class="xh">*</span>姓名</td>
					<td class="text-left"><aui:input name="xm" id="xm" label="">
							<aui:validator name="required" />
						</aui:input></td>
				</tr>
				<tr>
					<td class="text-right"><span class="xh">*</span>联系电话</td>
					<td class="text-left"><aui:input name="lxdh" id="lxdh" label="">
							<aui:validator name="digits" />
							<aui:validator name="required" />
						</aui:input></td>
				</tr>
				<tr>
					<td class="text-right"><span class="xh">*</span>邮箱地址</td>
					<td class="text-left"><aui:input name="yxdz" id="yxdz" label="">
							<aui:validator name="email" />
							<aui:validator name="required" />
						</aui:input></td>
				</tr>
				<tr>
					<td class="text-right">联系地址</td>
					<td class="text-left"><aui:input name="lxdz" id="lxdz" label="">
							<aui:validator name="maxLength">40</aui:validator>
						</aui:input></td>
				</tr>
			</table>
			<div class="text-center">
				<div class="btn-group">
					<aui:button-row>
						<aui:button name="submit" value="提交" onClick="createUser()" cssClass="btn btn-primary" />
					</aui:button-row>
				</div>
				<div class="btn-group">
					<aui:button name="close" value="取消" cssClass="btn" href="${viewURL}" />
				</div>
			</div>
		</aui:form>
	</div>
</div>
<portlet:resourceURL var="createUserURL" id="createUser" />
<script>
	function createUser(){
		if($('#<portlet:namespace/>_58_login').val()==""||$('#<portlet:namespace/>_58_password').val()==""||$('#<portlet:namespace/>qrmm').val()==""||$('#<portlet:namespace/>sfzh').val()==""||$('#<portlet:namespace/>xm').val()==""||$('#<portlet:namespace/>lxdh').val()==""||$('#<portlet:namespace/>yxdz').val()==""){
			alert("请填写带星号的必填项！");
			return false;
		}
		
		if($("#<portlet:namespace/>yhm").attr("class").toString().indexOf("error-field", 0)>0){
			alert("请输入正确用户名！");
			return false;
		}
		if($("#<portlet:namespace/>mm").attr("class").toString().indexOf("error-field", 0)>0){
			alert("请输入正确密码！");
			return false;
		}
		if($("#<portlet:namespace/>qrmm").attr("class").toString().indexOf("error-field", 0)>0){
			alert("请确认密码与第一次输入的相同！");
			return false;
		}
		if($("#<portlet:namespace/>sfzh").attr("class").toString().indexOf("error-field", 0)>0){
			alert("请输入正确身份证！");
			return false;
		}
		
		var IDCard = $("#<portlet:namespace />sfzh").val();
		var isIDCard = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
		if (IDCard != null && IDCard != "") {
	        if (IDCard.indexOf(",") == -1) {
	            if (!isIDCard.test(IDCard)) {
	                alert('“' + IDCard + '”是无效的身份证号！');
	                focusInput($("#<portlet:namespace />sfzh"));
	                return false;
	            }
	        } else {
	            var arr = IDCard.split(",");
	            var length = arr.length;
	            for (var i = 0; i < length; i++) {
	                if (!isIDCard.test(arr[i])) {
	                	alert('“' + arr[i] + '”是无效的身份证号！');
	                	focusInput($("#<portlet:namespace />sfzh"));
	                    return false;
	                }
	            }
	        }
	    }
		
		if($("#<portlet:namespace/>xm").attr("class").toString().indexOf("error-field", 0)>0){
			alert("请输入正确姓名！");
			return false;
		}
		if($("#<portlet:namespace/>lxdh").attr("class").toString().indexOf("error-field", 0)>0){
			alert("请输入正确联系电话！");
			return false;
		}
		
		var mobiles = $("#<portlet:namespace />lxdh").val();
	    var reg = /^1[3|4|5|7|8][0-9]\d{8}$/;
	    if (mobiles != null && mobiles != "") {
	        if (mobiles.indexOf(",") == -1) {
	            if (!reg.test(mobiles)) {
	                alert('“' + mobiles + '”是无效的手机号码！');
	                focusInput($("#<portlet:namespace />lxdh"));
	                return false;
	            }
	        } else {
	            var arr = mobiles.split(",");
	            var length = arr.length;
	            for (var i = 0; i < length; i++) {
	                if (!reg.test(arr[i])) {
	                	alert('“' + arr[i] + '”是无效的手机号码！');
	                	focusInput($("#<portlet:namespace />lxdh"));
	                    return false;
	                }
	            }
	        }
	    }
		
		if($("#<portlet:namespace/>yxdz").attr("class").toString().indexOf("error-field", 0)>0){
			alert("请输入正确邮箱地址！");
			return false;
		}
		
		
		$.ajax({
			type:"post",
			url:"<%=createUserURL%>",
					data : {
						'<portlet:namespace/>yhm' : $(
								'#<portlet:namespace/>yhm').val(),
						'<portlet:namespace/>mm' : $('#<portlet:namespace/>mm')
								.val(),
						'<portlet:namespace/>qrmm' : $(
								'#<portlet:namespace/>qrmm').val(),
						'<portlet:namespace/>sfzh' : $(
								'#<portlet:namespace/>sfzh').val(),
						'<portlet:namespace/>xm' : $('#<portlet:namespace/>xm')
								.val(),
						'<portlet:namespace/>lxdh' : $(
								'#<portlet:namespace/>lxdh').val(),
						'<portlet:namespace/>yxdz' : $(
								'#<portlet:namespace/>yxdz').val(),
						'<portlet:namespace/>lxdz' : $(
								'#<portlet:namespace/>lxdz').val()
					},
					error : function(err) {
						alert("提交失败!");
					},
					success : function(data) {
						var exception = eval("(" + data + ")");
						if (exception.toString().indexOf(
								"UserScreenNameException", 0) > 0) {
							alert("用户名已存在");
							return false;
						} else if (exception.toString().indexOf(
								"UserEmailAddressException", 0) > 0) {
							alert("邮箱已存在");
							return false;
						}
						$("#_58_login")
								.val($("#<portlet:namespace/>yhm").val());
						$("#_58_password").val(
								$("#<portlet:namespace/>mm").val());
						console.log($("#_58_login").val());
						console.log($("#_58_password").val());
						document.getElementById("<portlet:namespace/>_58_fm")
								.submit();
					}
				});
	}
</script>