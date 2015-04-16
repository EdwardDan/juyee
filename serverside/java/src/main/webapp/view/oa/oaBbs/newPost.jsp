<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    //保存主题帖
    function savePublish() {
        var typeId = $("#type").val();
        var title = $("#title").val();
        var content = $("#content").val();
        var docId = $("#docId").val();
        window.location = "${ctx}/oaBbs/savePublish.do?type=" + typeId + "&title=" + title + "&content=" + content + "&docId=" + docId + "&id=${bean.id}";
    }
    //返回列表
    function reBackList() {
        window.location = "${ctx}/oaBbs/grid.do";
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <div class="form_div" style="text-align: center;">
        <table cellpadding="0" cellspacing="0" class="form_table" border="0">
            <tr class="tr_light">
                <td style="width: 40px;"></td>
                <td style="text-align: left;">发表帖子</td>
            </tr>
        </table>
        <hr>
        <table cellpadding="0" cellspacing="0" class="form_table" border="0">
            <tr class="tr_light">
                <td style="width: 40px;"></td>
                <td style="width: 85px;">
                    <select name="type" id="type" class="form_select" style="width: 80px;">
                        <c:forEach items="${types}" var="item">
                            <option value="${item.id}"
                                    <c:if test="${item.id == bean.type.id}">selected</c:if>>${item.name}</option>
                        </c:forEach>
                    </select>
                </td>
                <td style="width: 60px;">主题：</td>
                <td style="text-align: left;">
                    <input type="text" class="input_text" name="title" id="title" style="width: 95%;"
                           value="${bean.title}">
                </td>
            </tr>
            <tr class="tr_dark">
                <td style="width: 40px;"></td>
                <td colspan="3" style="text-align: left;">主要内容：</td>
            </tr>
            <tr class="tr_light">
                <td style="width: 40px;"></td>
                <td colspan="3" style="text-align: left;">
                    <textarea class="input_textarea" name="content" id="content"
                              style="width: 96%;height: 300px;">${bean.content}</textarea>
                </td>
            </tr>
            <tr class="tr_dark">
                <td style="width: 40px;"></td>
                <td style="text-align: left;" colspan="3">选择附件：${uploadButton}</td>
            </tr>
            <tr class="tr_button">
                <td colspan="4">
                    <input type="button" class="button_confirm" value="发表" onclick="savePublish();">
                    <input type="button" class="button_cancel" value="取消" onclick="reBackList();">
                </td>
            </tr>
        </table>
    </div>
</form:form>
