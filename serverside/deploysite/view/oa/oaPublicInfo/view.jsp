<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<div class="form_div">
    <table width="90%" cellpadding="0" cellspacing="0" align="center">
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

            <td align="right" width="10%">信息来源：</td>
            <td align="left" width="20%">
                ${bean.createDeptName}
                &nbsp;
            </td>

            <td align="right" width="15%">访问次数：</td>
            <td align="left" width="15%">
                ${bean.visitTimes}
                &nbsp;
            </td>
        </tr>
    </table>
</div>

<div align="center" style="width:100%">
    <div style="width:92%;word-break:break-all;line-height:2.0em;" align="left">${bean.content}</div>
</div>

<div class="form_div">
    <table width="90%" cellpadding="0" cellspacing="0" align="center">
        <tr>
            <td height="20"></td>
        </tr>
        <c:if test="${not empty imageButton}">
            <tr>
                <td align="left" style="color:red;height: 30px">&nbsp;图片：${imageButton}</td>
            </tr>
        </c:if>
        <c:if test="${not empty docButton}">
            <tr>
                <td align="left" style="color:red;height: 30px">&nbsp;附件：${docButton}</td>
            </tr>
        </c:if>
        <tr>
            <td align="center">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow();refreshGrid();">
            </td>
        </tr>

        <tr>
            <td>&nbsp;</td>
        </tr>
    </table>
</div>