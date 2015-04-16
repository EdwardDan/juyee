<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">

    function doEditReply(id) {
        openWindow("修改回复业务知识", "${ctx}/oaKnowledge/replyModify.do?id=" + id);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaKnowledge/delete.do?id=" + id);
    }

</script>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr>
            <td>
                <fieldset style="width: 90%;margin:0px auto">
                    <legend class="form_legend">主题信息</legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_dark">
                            <td class="form_label_right" width="15%">主题内容：</td>
                            <td class="form_content" width="35%">&nbsp;
                                ${bean.title}
                            </td>

                            <td class="form_label_right" width="15%">提出时间：</td>
                            <td class="form_content" width="35%">&nbsp;
                                <fmt:formatDate value="${bean.reportDate}" pattern="yyyy-MM-dd HH:mm"/>
                            </td>

                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right">提出人：</td>
                            <td class="form_content">&nbsp;
                                ${bean.reportPerson}
                            </td>

                            <td class="form_label_right">提出部门：</td>
                            <td class="form_content">&nbsp;
                                ${bean.reportDept}
                            </td>
                        </tr>

                        <tr class="tr_light">
                            <td class="form_label_right">内容：</td>
                            <td class="form_content" colspan="3">&nbsp;
                                <sys:toHtml>${bean.content}</sys:toHtml>
                            </td>
                        </tr>

                        <tr class="tr_dark">
                            <td class="form_label_right" nowrap>附件：</td>
                            <td colspan="3" class="form_content">&nbsp;
                                ${docButton}
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </td>
        </tr>
        <c:forEach items="${refLists}" var="refDoc">
            <tr><td class="form_fieldset_space"></td></tr>
            <tr>
                <td>
                    <fieldset style="width: 90%;margin:0px auto">
                        <legend class="form_legend">回复信息</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td class="form_label_right" width="15%">回复人：</td>
                                <td class="form_content" width="35%">&nbsp;
                                        ${refDoc.ref.reportPerson}
                                </td>

                                <td class="form_label_right" width="15%">所属部门：</td>
                                <td class="form_content" width="35%">&nbsp;
                                        ${refDoc.ref.reportDept}
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">回复时间：</td>
                                <td class="form_content">&nbsp;
                                    <fmt:formatDate value="${refDoc.ref.reportDate}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>

                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">内容：</td>
                                <td class="form_content" colspan="3">
                                    <sys:toHtml>${refDoc.ref.content}</sys:toHtml>
                                </td>
                            </tr>

                            <tr class="tr_dark">
                                <td class="form_label_right" nowrap>附件：</td>
                                <td colspan="3" class="form_content">&nbsp;
                                        ${refDoc.doc}
                                </td>
                            </tr>
                                <%-- 确定只有本人才能修改--%>
                            <c:if test="${currentUserName == refDoc.ref.createUser}">
                                <tr class="tr_button" style="text-align: right">
                                    <td colspan="4">
                                        <input type="button" value="修改" onclick="doEditReply(' + ${refDoc.ref.id} + ')"
                                               class="button_normal" />
                                        <input type="button" value="删除" onclick="doDelete(' + ${refDoc.ref.id} + ')"
                                               class="button_normal"/>
                                    </td>
                                </tr>
                            </c:if>
                        </table>
                    </fieldset>
                </td>
            </tr>
        </c:forEach>
        <tr class="tr_button">
            <td class="form_border" colspan="4">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>