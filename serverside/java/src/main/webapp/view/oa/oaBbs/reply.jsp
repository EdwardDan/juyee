<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    //修改发帖
    function newPost() {
        var parentId = $("#parentId").val();
        window.location = "${ctx}/oaBbs/newPost.do?parentId=" + parentId;
    }
    //保存回帖
    function saveReply(btn) {
        var parentId = $("#parentId").val();
        var content = $("#content").val();
        var docId = $("#docId").val();
        window.location = "${ctx}/oaBbs/saveReply.do?parentId=" + parentId + "&content=" + content + "&docId=" + docId;
    }
    //返回列表
    function reBackList() {
        window.location = "${ctx}/oaBbs/grid.do";
    }
    //移除（删除）
    function removeBbs(id, flag) {
        loadAjaxData("view", "${ctx}/oaBbs/remove.do?id=" + id + "&flag=" + flag);
    }
    //关闭(设置无效)
    function closeBbs(id, flag) {
        loadAjaxData("view", "${ctx}/oaBbs/close.do?id=" + id + "&flag=" + flag);
    }
</script>
<form:form commandName="bean">
    <div class="form_div" style="text-align: center;">
        <br>
        <table cellpadding="0" cellspacing="0" class="form_table" border="0">
            <input type="hidden" name="parentId" id="parentId" value="${bean.id}">
            <tr>
                <td rowspan="2" style="width: 105px;height: 100px;">&nbsp;<img src="${themePath}/img/bbs.jpg"></td>
                <td style="text-align: left;">&nbsp;【${bean.type.name}】${bean.title}</td>
                <td style="text-align:right;">浏览/回复：${bean.visitTimes} / ${bean.replyTimes}&nbsp;&nbsp;&nbsp;&nbsp;</td>
            </tr>
            <tr>
                <td style="text-align: left;">
                    &nbsp;${bean.personName} 发表于
                    <fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    [只看楼主]
                </td>
                <td style="text-align:right;">
                    <a onclick="newPost()" style="cursor: pointer;">编辑</a>
                    |<a onclick="closeBbs('${bean.id}','reply')" style="cursor: pointer;">关闭</a>
                    |<a onclick="removeBbs('${bean.id}','removeParent')" style="cursor: pointer;">移除</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                </td>
            </tr>
        </table>
        <hr>
        <table cellpadding="0" cellspacing="0" class="form_table" border="0">
            <tr class="tr_dark">
                <td style="width: 40px;"></td>
                <td colspan="3" style="text-align: left;">回复内容：</td>
            </tr>
            <tr class="tr_light">
                <td style="width: 40px;"></td>
                <td colspan="3" style="text-align: left;">
                    <textarea class="input_textarea" name="content" id="content"
                              style="width: 96%;height: 300px;">${child.content}</textarea>
                </td>
            </tr>
            <tr class="tr_dark">
                <td style="width: 40px;"></td>
                <td style="text-align: left;" colspan="3">选择附件：${uploadButton}</td>
            </tr>
            <tr class="tr_button">
                <td colspan="4">
                    <input type="button" class="button_confirm" value="提交" onclick="saveReply(this);">
                    <input type="button" class="button_cancel" value="取消" onclick="reBackList();">
                </td>
            </tr>
        </table>
    </div>
</form:form>