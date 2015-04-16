<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%--<%@include file="/common/header.jsp" %>--%>
<script type="text/javascript">
    function save(btn) {
        disableBtn(btn);
        saveAjaxData("${ctx}/bpmProcessAttach/attachSave.do?bpmTaskInstanceId=${bpmTaskInstanceId}&documentId=" + $("#docId").val(), null, refreshAttach, null);
    }
    function refreshAttach(ret) {
        enableBtn($("#ok"));
        document.getElementById("tab1").contentWindow.getAttachNum();
    }
</script>
<form:form name="fileForm">
    <input type="hidden" name="bpmTaskInstanceId" value="${bpmTaskInstanceId}">

    <div style="background-color:#E5F8FC; " class="form_div">

        <table style="width: 100%">
            <tr class="tr_title">
                <td align="center">附件上传:（${taskName}）</td>
            </tr>
        </table>
        <table border="0" style="width: 100%">
            <tr>
                <td>
                    <fieldset>
                        <legend class="form_legend">已传附件：</legend>
                        <table width="100%" border="0" cellpadding="0" cellspacing="1" STYLE="border-color:#FFFFFF ">
                            <tr class="tr_header">
                                <td height="25" width="20%" nowrap align="center">步骤名称</td>
                                    <%--<td height="25" width="20%" nowrap align="center">文档标题</td>--%>
                                <td width="10%" nowrap align="center">最后提交人</td>
                                <td width="18%" nowrap align="center">最后提交时间</td>
                                    <%--<td width="7%" align="center" nowrap>是否正式</td>--%>
                                <td width="27%" align="center" nowrap>附件下载</td>
                            </tr>
                            <c:forEach var="file" items="${fileList}" varStatus="status">
                                <tr
                                        <c:choose>
                                            <c:when test="${status.index%2==0}">
                                                class="td_dark"
                                            </c:when>
                                            <c:otherwise>
                                                class="td_light"
                                            </c:otherwise>
                                        </c:choose>
                                        >
                                    <td align="center" valign="middle">
                                            ${file.nodeName}
                                    </td>
                                        <%--<td align="center" valign="middle">--%>
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
                        </table>
                    </fieldset>
                </td>
            </tr>
            <tr>
                <td>
                    <fieldset>
                        <legend class="form_legend">当前附件：</legend>
                        <table width="100%" border="0" cellpadding="0" cellspacing="1" bordercolor="#FFFFFF">
                            <tr class="tr_header">
                                <td height="25" width="20%" nowrap align="center">步骤名称</td>
                                    <%--<td height="25" width="20%" nowrap align="center">文档标题</td>--%>
                                <td width="10%" nowrap align="center">最后提交人</td>
                                <td width="18%" nowrap align="center">最后提交时间</td>
                                    <%--<td width="7%" align="center" nowrap>是否正式</td>--%>
                                <td width="17%" align="center" nowrap>附件下载</td>
                                <c:if test="${act != 'view'}">
                                    <td width="10%" align="center" nowrap>操作</td>
                                </c:if>
                            </tr>
                            <tr class="tr_light">
                                <td align="center" valign="middle">
                                        ${currentDocument.nodeName}
                                </td>
                                    <%--<td align="center" valign="middle">--%>
                                    <%--${currentDocument.title}--%>
                                    <%--</td>--%>
                                <td align="center">
                                        ${currentDocument.submitUserName}
                                </td>
                                <td align="center">
                                    <fmt:formatDate value="${currentDocument.submitTime}"
                                                    pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                    <%--<td align="center">--%>
                                    <%--<input type="hidden" name="fileIds" value="${currentDocument.fileId}">--%>
                                    <%--<input type="checkbox" value="1">--%>
                                    <%--&lt;%&ndash;<c:if test="${currentDocument.isPublic}">checked</c:if>>&ndash;%&gt;--%>
                                    <%--</td>--%>
                                <td align="center">
                                        ${currentDocument.downloadLink}
                                </td>
                                <c:if test="${act != 'view'}">
                                    <td align="center">
                                            ${currentDocument.documentLink}
                                    </td>
                                </c:if>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_border" align="center">
                    <c:if test="${act != 'view'}">
                        <font color="red">（添加完附件之后请点击本页面的保存按钮）</font>
                        <input name="button_save" type="button" class="button_confirm" id="ok" value="确定"
                               onclick="save(this)">
                    </c:if>
                    <input name="button_cancel" type="button" class="button_cancel" value="取消"
                           onclick="window.closeWindow()">
                </td>
            </tr>

        </table>
    </div>
</form:form>
