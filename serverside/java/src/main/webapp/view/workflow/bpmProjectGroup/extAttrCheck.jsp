<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!-- main content begin -->
<table width="100%" border="0"
       cellpadding="0" cellspacing="1"
       bordercolor="#FFFFFF"
       id="table_list">
    <tr class="tr_header" align="center">
        <td width="10%">序号</td>
        <td width="40%">${defName}</td>
        <td width="40%">选择</td>
    </tr>
    <c:forEach var="bean"
               items="${extAttrItems}"
               varStatus="status">
        <c:choose>
            <c:when test="${status.count%2==0}">
                <tr class="tr_light" >
            </c:when>
            <c:otherwise>
                <tr class="tr_dark">
            </c:otherwise>
        </c:choose>
        <td align="center">${status.count}&nbsp;</td>
        <td>${bean.value}&nbsp;</td>
        <td align="center">
            <c:choose>
                <%--<c:when test="${attributeType=='all'}">--%>
                <%--<input id="itemId"--%>
                <%--name="itemId"--%>
                <%--value="${bean.id}"--%>
                <%--type="checkbox"--%>
                <%--checked="true"--%>
                <%--disabled="true"> &nbsp;--%>
                <%--</c:when>--%>
                <c:when test="${attributeType=='values'}">
                    <c:if test="${bean.isChecked=='true'}">
                        <input id="itemId"
                               name="itemId"
                               value="${bean.id}"
                               type="checkbox"
                               checked="true"> &nbsp;
                    </c:if>
                    <c:if test="${bean.isChecked=='false'}">
                        <input id="itemId"
                               name="itemId"
                               value="${bean.id}"
                               type="checkbox"> &nbsp;
                    </c:if>
                </c:when>
                <c:otherwise>
                    <input id="itemId"
                           name="itemId"
                           value="${bean.id}"
                           type="checkbox"
                           checked="true"
                           disabled="true"> &nbsp;
                </c:otherwise>
            </c:choose>
        </td>
        </tr>
    </c:forEach>
</table>
                                    