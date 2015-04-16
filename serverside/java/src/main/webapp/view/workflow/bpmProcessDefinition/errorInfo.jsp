<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>虹口区建设工程远程监控信息系统</title>
    <%@include file="/common/header.jsp" %>
</head>
<body>
<div class="form_div">
    <div align="center" class="tr_dark">
        <fieldset class="form_fieldset">
            <legend class="form_legend">
                流程设置错误分析表
            </legend>
            <div class="form_table">
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_header" align="center">
                        <td width="30%" class="form_border" nowrap>序号</td>
                        <td width="15%" class="form_border" nowrap>节点ID</td>
                        <td width="20%" class="form_border" nowrap>节点名称</td>
                        <td width="20%" class="form_border" nowrap>错误原因</td>
                    </tr>
                    <c:forEach var="bean"
                               items="${errors}"
                               varStatus="status">
                        <c:choose>
                            <c:when test="${status.count%2==0}">
                                <tr class="td_light" align="center">
                            </c:when>
                            <c:otherwise>
                                <tr class="td_dark" align="center">
                            </c:otherwise>
                        </c:choose>
                        <td align="center" nowrap class="form_border">${status.count}</td>
                        <td align="center" nowrap class="form_border">${bean.id}</td>
                        <td align="center" nowrap class="form_border">${bean.name}</td>
                        <td align="center" nowrap class="form_border">${bean.info}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </fieldset>
    </div>
    <div class="tr_button">
        <input type="button" value="返回" class="button_back" onclick="history.back();">
    </div>
</div>
</body>
</html>