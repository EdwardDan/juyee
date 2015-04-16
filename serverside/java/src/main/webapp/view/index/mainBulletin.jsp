<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<script type="text/javascript">
    //查看信息
    function viewInfo(id) {
        openFullWindow("${ctx}/site/infoView.do?id=" + id, 1024, 768);
    }
</script>
<table width="240" border="0" cellpadding="0" cellspacing="0" class="ggl">
    <tr>
        <td height="150">
            <table width="220" border="0" cellpadding="0" cellspacing="0">
                <c:choose>
                    <c:when test="${fn:length(infoList)>0}">
                        <c:forEach items="${infoList}" var="item">
                            <tr>
                                <td class="ggltext" align="left">&nbsp;
                                    <a href="javascript:void(0)" onclick="viewInfo(${item.id})" title="${item.title}">
                                        <span class="cutString"><sys:cutString length="17">${item.title}</sys:cutString></span>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td class="ggltext" align="right">
                                    <img src="${themePath}/index_new/more.png" width="36" height="14" title="查看更多" style="cursor: pointer" onclick="loadMainPage('${ctx}/oaPublicInfo/grid.do?typeCode=${typeCodeBulletin}','系统公告');" align="absmiddle"/>
                            </td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td align="center">暂无记录</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </table>
        </td>
    </tr>
</table>