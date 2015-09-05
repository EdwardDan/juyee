<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var form2Id = "bean2";
    //保存操作
    function save(operationId, buttonName) {
        if (!validateForm(form2Id)) {
            return;
        }

        //提交表单
        if (buttonName != "") {
            if (confirm("是否确定执行 " + buttonName + " 操作？")) {
                saveAjaxData("${ctx}/oaReceive/pressSave.do?operationId=" + operationId,form2Id);
            }
        }
    }

</script>
<style type="text/css">
    .td_border {
        /*border: 1px solid;*/
        border-top-width: 1px;
        border-bottom-width: 1px;
        border-left-width: 1px;
        border-right-width: 1px;
        border-top-style: solid;
        border-bottom-style: solid;
        border-left-style: solid;
        border-right-style: solid;
        border-top-color: #333;
        border-bottom-color: #333;
        border-left-color: #333;
        border-right-color: #333;
    }
</style>
<form:form commandName="bean2">
    <form:hidden path="id"/>
    <form:hidden path="openTime"/>
    <form:hidden path="stepId"/>
    <form:hidden path="dealUser"/>
    <input name="userId" type="hidden" value="${userId}">
    <input type="hidden" name="oaReceive" id="oaReceive" value="${bean2.oaReceive.id}">

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table" style="border-collapse: collapse">
            <tr>
                <td class="head_title form_border" colspan="4">上海市路政局收文登记单催办</td>
            </tr>
            <tr class="tr_dark ">
                <td class="td_border" align="right" width="25%">收到时间：</td>
                <td class="td_border" align="left" width="25%"> &nbsp;
                    <fmt:formatDate value="${bean2.receiveTime}" pattern="yyyy-MM-dd HH:mm"/>
                </td>
                <td class="td_border" align="right" width="25%">打开时间：</td>
                <td class="td_border " align="left" width="25%">  &nbsp;
                    <fmt:formatDate value="${bean2.openTime}" pattern="yyyy-MM-dd HH:mm"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="td_border" align="right"> &nbsp;处理意见：</td>
                <td class="td_border" align="left" colspan="3">
                    <textarea  class="input_textarea_long"  id="dealResult"  name="dealResult">请<c:forEach items="${users}" var="user">${user.displayName} </c:forEach>及时审核收文信息。</textarea>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_border" align="center" colspan="4">
                    <c:forEach items="${operations}" var="operation">
                        <input type="button" value="${operation.name}" class="button_normal_longer"
                               onclick="save('${operation.id}',this.value)">&nbsp;
                    </c:forEach>
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>