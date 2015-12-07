<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%--<link href="${themePath}/style_index.css" rel="stylesheet" type="text/css"/>--%>

<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="shadow">
    <tr>
        <td colspan="2" valign="top">
            <div class="title">
                <div class="txt_left"><img src="${ctx}/view/platform/images/main_icon_1.png"/>&nbsp;整改单据</div>
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
                <tr>
                    <td colspan="2">
                        <c:choose>
                            <c:when test="${fn:length(infoList)>0}">
                                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                    <c:forEach items="${list}" var="item" varStatus="status">
                                        <tr class="tr_light">
                                            <c:if test="${status.index == 0}">
                                                <td rowspan="${fn:length(list)}" class="form_border" align="center" width="30%"
                                                    nowrap="true">安全监督
                                                </td>
                                            </c:if>
                                            <td nowrap class="form_border" align="center" width="50%"
                                                nowrap="true">${item.typeName}</td>
                                            <td nowrap class="form_border" align="center" width="20%"
                                                nowrap="true">${item.count[0]} 张
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <c:forEach items="${list}" var="item" varStatus="status">
                                        <tr class="tr_dark">
                                            <c:if test="${status.index == 0}">
                                                <td rowspan="${fn:length(list)}" class="form_border" align="center" width="30%"
                                                    nowrap="true">质量监督
                                                </td>
                                            </c:if>
                                            <td nowrap class="form_border" align="center" width="50%"
                                                nowrap="true">${item.typeName}</td>
                                            <td nowrap class="form_border" align="center" width="20%"
                                                nowrap="true">${item.count[3]} 张
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </c:when>
                            <c:otherwise>
                                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                    <tr>
                                        <td width="20" align="center">
                                            <img src="${themePath}/index/dit.png" width="5" height="8" border="0"/>
                                        </td>
                                        <td align="left">暂无记录</td>
                                    </tr>
                                </table>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
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