<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="shadow">
    <tr>
        <td colspan="2" valign="top">
            <div class="title">
                <div class="txt_left"><img src="${ctx}/view/platform/images/main_icon_2.png"/>&nbsp;网上办事流程</div>
                <div class="right">
                    <%--<h3><a href="#">更多>></a></h3>--%>
                </div>
            </div>
        </td>
    </tr>

    <tr>
        <%--<td class="main_left"></td>--%>
        <td class="index_area_bg" style="height:188px;" valign="top">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td colspan="2" class="line"></td>
                </tr>
                <c:choose>
                    <c:when test="${fn:length(infoList)>0}">
                        <c:forEach items="${infoList}" var="item">
                            <tr>
                                <td width="3%" align="center">
                                    <img src="${themePath}/index/dit.png" width="5"
                                         height="8" border="0"/>
                                </td>
                                <td width="97%">
                                    <a href="javascript:void(0)" onclick="viewInfo(${item.id})" title="${item.title}">
                                        <sys:cutString length="${maxWordCount}">${item.title}</sys:cutString>&nbsp;&nbsp;
                                        [<fmt:formatDate value="${item.reportDate}" pattern="yyyy年MM月dd日"/>]
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="line"></td>
                            </tr>
                        </c:forEach>
                        <%--<c:if test="${fn:length(infoList)>recordCount}">--%>
                        <tr>
                            <td>&nbsp;</td>
                            <td align="right">
                                <%--<img src="${themePath}/index/more.jpg" width="42" height="16"--%>
                                     <%--border="0" style="cursor:pointer"--%>
                                     <%--onclick='loadUrl(null,"${ctx}/oaPublicInfo/grid.do?range=${range}&typeCode=${typeCode}","网上办事流程");'--%>
                                     <%--title="查看更多"/>--%>
                            </td>
                        </tr>
                        <%--</c:if>--%>
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