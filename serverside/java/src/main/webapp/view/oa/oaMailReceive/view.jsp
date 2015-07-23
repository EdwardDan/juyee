<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<style type="text/css">
    .input_textarea_long_long {
        font-size: 12px;
        border: 1px solid #b8b6b9;
        color: #007DBC;
        background-color: #FFFFFF;
        width: 500px;
        height: 200px;
    }
</style>
<script type="text/javascript">
    //返回列表
    function reBack() {
        location.replace("${ctx}/oaMailReceive/grid.do");
    }
    //删除邮件
    function doDelete(id) {
        $.messager.confirm('系统提示', "您确定要删除此记录吗?", function (r) {
            if (r) {
                saveAjaxData("${ctx}/oaMailReceive/delete.do?ids=" + id, null, reBack());
            }
        });
    }
    //回复邮件
    function doReply(id, mailType) {
        location.replace("${ctx}/oaMailReceive/modify.do?id=" + id + "&mailType=" + mailType);
    }
    //转发邮件
    function doForward(id, mailType) {
        location.replace("${ctx}/oaMailReceive/modify.do?id=" + id + "&mailType=" + mailType);
    }
</script>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label_right" colspan="2">
                时间：&nbsp;<fmt:formatDate value="${bean.sendTime}" pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;&nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right" width="15%">发送给：</td>
            <td class="form_content">
                &nbsp;${toNames}
            </td>
        </tr>
        <%--<tr class="tr_dark">--%>
            <%--<td class="form_label_right" width="15%">抄送人：</td>--%>
            <%--<td class="form_content">--%>
                <%--&nbsp;${bean.ccPersons}--%>
            <%--</td>--%>
        <%--</tr>--%>
        <tr class="tr_light">
            <td class="form_label_right" width="15%">主题：</td>
            <td class="form_content">
                &nbsp;${bean.title}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right" width="15%">附件下载：</td>
            <td class="form_content">
                &nbsp;${docButton}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right" width="15%">内容：</td>
            <td class="form_content">
                &nbsp;
                <textarea class="input_textarea_long_long" readonly="true" style="width: 90%">${bean.content}</textarea>
            </td>
        </tr>
        <tr class="tr_button">
            <td class="form_border" colspan="2" align="center">
                <input type="button" id="delete" value="删除" class="button_cancel" onclick="doDelete('${bean.id}')"/>&nbsp;
                <input type="button" id="reBack" value="回复" class="button_back"
                       onclick="doReply('${bean.id}','${MAIL_TYPE_RE}')"/>&nbsp;
                    <input type="button" id="forward" value="转发" class="button_confirm"
                           onclick="doForward('${bean.id}','${MAIL_TYPE_FW}')"/>&nbsp;
                <input type="button" value="返回列表" class="button_normal_long" onclick="reBack()">
            </td>
        </tr>
    </table>
</div>