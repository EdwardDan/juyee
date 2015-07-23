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
    function reBack() {
        location.replace("${ctx}/oaMailWait/grid.do");
    }
</script>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label_right" colspan="2">
                时间：&nbsp;<fmt:formatDate value="${bean.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;&nbsp;
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
                &nbsp;<textarea class="input_textarea_long_long" readonly="true"
                                style="width: 90%">${bean.content}</textarea>
            </td>
        </tr>
        <tr class="tr_button">
            <td class="form_border" colspan="2" align="center">
                <input type="button" value="关闭" class="button_cancel" onclick="reBack();">
            </td>
        </tr>
    </table>
</div>