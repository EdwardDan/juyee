<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<c:if test="${from =='view'}">
    <%@include file="/common/header.jsp" %>
</c:if>
<div class="form_div">
    <table width="100%" border="0" cellpadding="0" cellspacing="1" STYLE="border-color:#FFFFFF ">
        <tr class="tr_header" align="center">
            <td width="20%" nowrap>步骤名称</td>
            <%--<td width="30%" nowrap>文档标题</td>--%>
            <td width="10%" nowrap>最后提交人</td>
            <td width="15%" nowrap>最后提交时间</td>
            <%--<td width="7%" nowrap>是否正式</td>--%>
            <td width="15%" nowrap>附件下载</td>
        </tr>
        <c:choose>
            <c:when test="${fn:length(fileList)>0}">
                <c:forEach var="file" items="${fileList}" varStatus="status">
                    <tr
                            <c:choose>
                                <c:when test="${status.index%2==0}">
                                    class="tr_dark"
                                </c:when>
                                <c:otherwise>
                                    class="tr_light"
                                </c:otherwise>
                            </c:choose>
                            >
                        <td align="center">
                                ${file.nodeName}
                        </td>
                            <%--<td align="left">--%>
                            <%--${file.title}--%>
                            <%--</td>--%>
                        <td align="center">
                                ${file.submitUserName}
                        </td>
                        <td align="center">
                            <fmt:formatDate value="${file.submitTime}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                            <%--<td align="center">--%>
                            <%--<input type="hidden" name="fileIds" value="${file.fileId}">--%>
                            <%--<input type="checkbox" value="1"--%>
                            <%--&lt;%&ndash;<c:if test="${file.isPublic}">checked</c:if>>&ndash;%&gt;--%>
                            <%--</td>--%>
                        <td align="center">
                                ${file.documentLink}
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr class="tr_dark">
                    <td colspan="4" align="center">
                        暂无任何附件。
                    </td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>
</div>
