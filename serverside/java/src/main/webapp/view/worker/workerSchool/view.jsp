<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">

    function doEditReply(id) {
        openWindow("修改活动信息", "${ctx}/workerSchool/actionModify.do?id=" + id);
    }

    var lastId = null;
    function doActivityDelete(id, msg) {
        if (msg == null) msg = "您确定要删除此记录吗?";
        $.messager.confirm('系统提示', msg, function (r) {
            if (r) {
                lastId = id;
                id = "+" + id + "+";

                loadAjaxDataCallback(null, "${ctx}/workerSchool/actionDelete.do?id=" + id, delTr);
            }
        });
    }
    function delTr() {
        if (lastId != null) {
            $("#" + lastId + "_space").remove();
            $("#" + lastId).remove();

        }
    }

</script>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr>
            <td colspan="2">
                <fieldset style="width: 90%;margin:0px auto">
                    <legend class="form_legend">务工人员学校管理</legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
                            <td class="form_label_right" width="20%">报建编号：</td>
                            <td class="form_content" nowrap width="30%">
                                ${bean.bjbh}
                            </td>
                            <td class="form_label_right" width="20%">创建时间：</td>
                            <td class="form_content" width="30%">
                                <fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right">项目名称：</td>
                            <td class="form_content" colspan="3">
                                ${bean.projectName}
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right">项目地点：</td>
                            <td class="form_content" colspan="3">
                                ${bean.projectAddress}
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right">建设单位：</td>
                            <td class="form_content">
                                ${bean.jsDept}
                            </td>
                            <td class="form_label_right">建设单位负责人：</td>
                            <td class="form_content">
                                ${bean.jsDeptLxr}(电话：${bean.jsDeptTel})
                            </td>

                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right">施工单位：</td>
                            <td class="form_content">
                                ${bean.sgDept}
                            </td>
                            <td class="form_label_right">施工单位负责人：</td>
                            <td class="form_content">
                                ${bean.sgDeptLxr}(电话： ${bean.sgDeptTel})
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right">校长姓名：</td>
                            <td class="form_content">
                                ${bean.xzName}
                            </td>
                            <td class="form_label_right">校长电话：</td>
                            <td class="form_content">
                                ${bean.xzTel}
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right">校长所属单位名称：</td>
                            <td class="form_content" colspan="3">
                                ${bean.xzDept}
                            </td>

                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right">组长姓名：</td>
                            <td class="form_content">
                                ${bean.zzName}
                            </td>
                            <td class="form_label_right">组长电话：</td>
                            <td class="form_content">
                                ${bean.zzTel}
                            </td>

                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right">组长所属单位名称：</td>
                            <td class="form_content" colspan="3">
                                ${bean.zzDept}
                            </td>

                        </tr>
                    </table>
                </fieldset>
            </td>
        </tr>
        <c:forEach items="${mapList}" var="item" varStatus="index">
            <tr id="${item.id}_space">
                <td colspan="2" class="form_fieldset_space">&nbsp;</td>
            </tr>
            <tr id="${item.id}">
                <td colspan="2">
                    <fieldset style="width: 90%;margin:0px auto">
                        <legend class="form_legend">开展活动信息</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_dark">
                                <td class="form_label_right">活动开展时间：</td>
                                <td class="form_content" colspan="3">
                                    <fmt:formatDate value="${item.openDate}" pattern="yyyy-MM-dd"/>
                                </td>
                            </tr>

                            <tr class="tr_light">
                                <td class="form_label_right" width="20%">活动性质：</td>
                                <td class="form_content" nowrap width="30">
                                        ${item.property}
                                </td>
                                <td class="form_label_right" width="20%">参加人数：</td>
                                <td class="form_content" width="30%">
                                        ${item.attendCount}
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">活动主题：</td>
                                <td class="form_content" colspan="3">
                                        ${item.title}
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">活动内容：</td>
                                <td class="form_content" colspan="3">
                                    <sys:toHtml> ${item.content}</sys:toHtml>
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right" nowrap>附件：</td>
                                <td colspan="3" class="form_content">&nbsp;
                                        ${item.docButton}
                                </td>
                            </tr>
                                <%-- 确定只有本人才能修改--%>
                            <c:if test="${currentUserName == item.createUser}">
                                <tr class="tr_light">
                                    <td colspan="4" align="right">
                                        <input type="button" value="修改" onclick="doEditReply(' + ${item.id} + ')"
                                               class="button_normal"/>
                                        <input type="button" value="删除" onclick="doActivityDelete('${item.id}')"
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
            <td align="center" colspan="4">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>