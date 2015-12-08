<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%--<link href="${ctx}/view/platform/css/style.css" rel="stylesheet" type="text/css"/>--%>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="shadow">
    <tr>
        <td colspan="2" valign="top">
            <div class="title">
                    <div class="txt_left"><img src="${ctx}/view/platform/images/main_icon_1.png"/>&nbsp;创优申报</div>
                    <div class="right">
                        <%--<h3><a href="#">更多>></a></h3>--%>
                    </div>
                </div>
        </td>
    </tr>

    <tr>
        <%--<td class="main_left"></td>--%>
        <td class="index_area_bg" style="height:160px;" valign="top">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td colspan="2" class="line"></td>
                </tr>
                <c:choose>
                    <c:when test="${fn:length(infoList)>0}">
                <tr>
                    <c:forEach items="${list}" var="item" varStatus="status">
                    <td width="50%">
                        <table width="90%" border="0" cellpadding="0" cellspacing="0">
                            <tr>
                                <td width="40%">&nbsp;${item.name}</td>
                                <td width="20%" nowrap>待处理${item.waitAuditCount}条</td>
                                <td width="20%" nowrap>已完成${item.hasAuditCount}条</td>
                                <td width="20%" nowrap>总数${item.totalAuditCount}条</td>
                            </tr>
                        </table>
                    </td>
                    <c:if test="${status.index>0 && (status.index+1) % 2 == 0}">
                </tr>
                <tr>
                    <td colspan="2" class="line"></td>
                </tr>
                <tr>
                    </c:if>
                    </c:forEach>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td align="right">
                        <%--<img src="${themePath}/index/more.jpg" width="42" height="16" border="0" style="cursor:pointer"--%>
                             <%--onclick="loadPlatPage('gdsb')" title="查看更多"/>--%>
                    </td>
                </tr>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td width="20" align="center">
                            <img src="${themePath}/index/dit.png" width="5" height="8" border="0"/>
                        </td>
                        <td align="left">暂无记录</td>
                    </tr>
                </c:otherwise>
                </c:choose>
                <tr>
                    <td colspan="2" class="line"></td>
                </tr>
            </table>
        </td>
        <td width="2px"></td>
        <%--<td class="main_right"></td>--%>
    </tr>
    <%--<tr>--%>
        <%--<td class="down_left"></td>--%>
        <%--<td class="down_main"></td>--%>
        <%--<td class="down_right"></td>--%>
    <%--</tr>--%>
</table>