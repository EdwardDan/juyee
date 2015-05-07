<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<table width="240" border="0" cellpadding="0" cellspacing="0" class="ggl">
    <tr>
        <td width="30" align="right">&nbsp;</td>
        <td height="120" align="left">
            <table width="220" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td class="ggltext" align="left">
                        <img src="${themePath}/index/dit.png" border="0" align="abdmiddle"/>&nbsp;
                        <a href="javascript:void(0)" onclick="loadMainPage('${ctx}/oaTask/init.do?count1=${count1}&count2=${count2}','待办事项');" title="点击查看">待办任务（${taskCount}）</a>
                    </td>
                </tr>
                <c:if test="${fn:length(oaList)==0}">
                    <%--<tr>--%>
                        <%--<td class="ggltext8" align="left"><img src="${themePath}/index/dit.png" border="0" align="abdmiddle"/>&nbsp;暂无OA待办事项</td>--%>
                    <%--</tr>--%>
                </c:if>
            </table>
        </td>
    </tr>
</table>