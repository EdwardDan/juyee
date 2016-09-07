<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<br>
<input type="button" class="button_normal_long" value="建设单位管理"
       onclick="window.location.href='${ctx}/platform/jump.do?code=jsdwgl&account=admin&name=&type=sg'">
<br><br>
<input type="button" class="button_normal_long" value="项目基本信息填报"
       onclick="window.location.href='${ctx}/platform/jump.do?code=xmjbxxtb&account=admin&name=&type=sg'">
<br><br>
<input type="button" class="button_normal_long" value="项目办证标段管理"
       onclick="window.location.href='${ctx}/platform/jump.do?code=xmbzbdgl&account=admin&name=&type=sg'">
