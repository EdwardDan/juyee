<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {

    });

    //保存操作
    function save(btn) {
        var val = $('input:radio[name="newSkinId"]:checked').val();
        if (val == null) {
            alert("请选择一种样式!");
            return;
        } else {

            //提交表单
            loadAjaxDataCallback(null, "${ctx}/sysSkin/selectSave.do?newSkinId=" + val, refreshPage());
        }
    }

    //刷新页面
    function refreshPage() {
        var oldSkinId = "${oldSkinId}";
        var newSkinId = $("#newSkinId").val();
        if (oldSkinId != newSkinId) {
            parent.window.location.reload();
        }
    }
</script>
<form:form commandName="bean">
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <c:forEach items="${list}" var="item" varStatus="status">
                <tr class="tr_light">
                    <td class="form_border" width="50%" align="left">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="newSkinId" value="${item.id}"
                               <c:if test="${oldSkinId==item.id || (oldSkinId==null && status.index==0)}">checked="true"</c:if>>
                            ${item.name}
                    </td>
                    <td class="form_border" width="50%" align="left">
                        <img id="skinPic" src="${ctx}/skin/${item.path}/skin.png" border="1"
                             style="border: #00438a #00438a #00438a #00438a;padding-top: 10px;padding-bottom: 10px"/>
                    </td>
                </tr>
            </c:forEach>

            <tr class="tr_button">
                <td class="form_border" colspan="2">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>