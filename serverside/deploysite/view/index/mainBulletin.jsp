<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<script type="text/javascript">
    //查看信息
    function viewInfo(id) {
        openFullWindow("${ctx}/site/infoView.do?id=" + id, 1024, 768);
    }
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td class="tableleft">&nbsp;</td>
        <td class="tablecenter">公示公告</td>
        <td class="tablecenter" align="right">
            <img src="${themePath}/index_new/more.png" width="36" height="14" title="查看更多" style="cursor: pointer" onclick="loadMainPage('${ctx}/oaPublicInfo/grid.do?typeCode=${typeCodeBulletin}','系统公告');" align="absmiddle"/>
        </td>
        <td class="tableright">&nbsp;</td>
    </tr>
    <tr>
        <td class="tablemiddle">&nbsp;</td>
        <td colspan="2">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <c:choose>
                    <c:when test="${fn:length(infoList)>0}">
                        <c:forEach items="${infoList}" var="item">
                            <tr>
                                <td class="tablelight" style="text-align: left;">&nbsp;
                                    <a href="javascript:void(0)" onclick="viewInfo('${item.info.id}')"
                                       title="${item.info.title}">
                                            ${item.info.title}
                                    </a>
                                    <c:if test="${item.day}">
                                        <img width="24" height="11" src="${themePath}/images/news.gif" alt="">
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td align="center">暂无记录</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </table>
        </td>
        <td class="tablemiddle1">&nbsp;</td>
    </tr>
    <tr>
        <td class="tablefoot1">&nbsp;</td>
        <td colspan="2" class="tablefoot2">&nbsp;</td>
        <td class="tablefoot3">&nbsp;</td>
    </tr>
</table>