<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table width="92%" cellpadding="0" cellspacing="0" align="center">
        <tr>
            <td colspan="6">&nbsp;</td>
        </tr>
        <tr>
            <td height="36" colspan="6" align="center"><h2 style="font-size:2.0em">${bean.title}</h2></td>
        </tr>
        <tr style="color:gray;">
            <td height="25" align="right" width="20%">发布时间：</td>
            <td align="left" width="20%">
                <fmt:formatDate value="${bean.reportDate}" pattern="yyyy-MM-dd"/>
                &nbsp;
            </td>

            <td align="right" width="15%">发布科室：</td>
            <td align="left" width="15%">
                ${bean.reportDept}
                &nbsp;
            </td>
            <td align="right" width="15%">发布人：</td>
            <td align="left" width="15%">
                ${bean.reportPerson}
                &nbsp;
            </td>

        </tr>
    </table>
</div>
<hr width="90%" align="center" color="gray"/>
<div align="center" style="width:100%">
    <div style="width:85%;min-height:175px;word-break:break-all;line-height:2.0em;" align="left">
        <sys:toHtml>${bean.content}</sys:toHtml></div>
</div>

<div class="form_div">
    <table width="90%" cellpadding="0" cellspacing="0" align="center">
        <tr>
            <td height="20"></td>
        </tr>
        <tr>
            <c:if test="${not empty docButton}">
                <td align="left" style="color:red;height: 30px">&nbsp;附件：${docButton}</td>
            </c:if>

            <td align="right" style="height: 30px">&nbsp;访问次数：</td>
            <td align="left">
                ${bean.visitTimes}
            </td>
        </tr>
        <tr>
            <td align="center" colspan="4">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow();refreshGrid();">
            </td>
        </tr>

        <tr>
            <td>&nbsp;</td>
        </tr>
    </table>
</div>