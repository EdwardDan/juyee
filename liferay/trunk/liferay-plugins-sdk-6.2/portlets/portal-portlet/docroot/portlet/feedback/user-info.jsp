<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%
	long userId = PortalUtil.getUserId(request);
	String userName = PortalUtil.getUserName(userId, "");
	request.setAttribute("userName", userName);
%>
<c:if test="${themeDisplay.isSignedIn()}">
	<div class="main">
		<div class="head"></div>
		<div class="body">
			<table class="thead">
				<tr>
					<td colspan="2" class="td"><span
						style="width: 5px; height: 20px; background-color: #ffa200; display: inline-block"></span><span>个人中心</span>
					</td>
				</tr>
			</table>
		</div>
		<br>
		<div
			style="color: #b94a48; font-family: Microsoft YaHei UI; font-size: 18px; text-align: center">欢迎您，${userName}！</div>
		<br>
	</div>
</c:if>
