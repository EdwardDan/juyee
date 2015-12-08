<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function doViewOrderForm(id) {
        openWindow("查看监督预约", "${ctx}/orderForm/view.do?id=" + id, false, 800, 500);
    }
</script>

<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="shadow">
    <tr>
        <td colspan="2" valign="top">
            <div class="title">
                <div class="txt_left"><img src="${ctx}/view/platform/images/main_icon_2.png"/>&nbsp;监督预约</div>
                <div class="right">
                    <%--<h3><a href="#">更多>></a></h3>--%>
                </div>
            </div>
        </td>
    </tr>

    <tr>
        <%--<td class="main_left"></td>--%>
        <td class="index_area_bg" style="height:160px;" valign="top">
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_table">
                <tr>
                    <td colspan="6" class="line"></td>
                </tr>
                <c:choose>
                    <c:when test="${fn:length(list)>0}">
                        <tr class="tr_header">
                            <td width="15%" class="form_border">预约单号</td>
                            <td width="40%" class="form_border">工程名称</td>
                            <td width="15%" class="form_border">预约日期</td>
                            <td width="15%" class="form_border">受理状态</td>
                            <td width="10%" class="form_border">分配监督组</td>
                            <td width="10%" class="form_border">操作</td>
                        </tr>
                        <c:forEach items="${list}" var="item" varStatus="status">
                            <tr class="<c:choose><c:when test="${status.index % 2==0}">tr_light</c:when><c:otherwise>tr_dark</c:otherwise></c:choose>"
                                align="center">
                                <td class="form_border">${item.orderForm.orderCode}</td>
                                <td class="form_border">${item.orderForm.projectName}</td>
                                <td class="form_border"><fmt:formatDate value="${item.orderForm.orderDatetime}"
                                                                        pattern="yyyy年MM月dd日"/></td>
                                <td class="form_border">${item.orderForm.orderStatus.name}</td>
                                <td class="form_border">${item.workGroup.name}</td>
                                <td class="form_border">
                                    <input type="button" value="查看" onclick="doViewOrderForm('${item.id}')"
                                           class="button_normal"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6" class="line"></td>
                            </tr>
                        </c:forEach>
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
                    <td align="right" colspan="6">
                        <img src="${themePath}/index/more.jpg" width="42" height="16"
                             border="0" style="cursor:pointer"
                             onclick="loadPlatPage('jdyy');" title="查看更多"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="6" class="line"></td>
                </tr>
            </table>
        </td>
        <%--<td class="main_right"></td>--%>
        <td width="2px"></td>
    </tr>
    <%--<tr>--%>
        <%--<td class="down_left"></td>--%>
        <%--<td class="down_main"></td>--%>
        <%--<td class="down_right"></td>--%>
    <%--</tr>--%>
</table>