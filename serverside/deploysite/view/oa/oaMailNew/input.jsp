<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "title", rule: "validate[required,maxSize[200]]"},
//            {name: "content", rule: "validate[required]"},
            {name: "receivePersons", rule: "validate[required]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(msg, buttonName) {
        if (!validateForm(formId)) {
            return;
        }
        //提交表单
        if (buttonName != "") {
            if (confirm("是否 " + buttonName + " 邮件?")) {
                saveAjaxData("${ctx}/oaMailNew/save.do?msgSend=" + msg, formId, backTabMsgSend);
            }
        } else {
            saveAjaxData("${ctx}/oaMailNew/save.do?msgSend=" + msg, formId, backTabMsgSave);
        }
    }
    function backTabMsgSend() {
        parent.jumbTab('已发送邮件');
    }
    function backTabMsgSave() {
        parent.jumbTab('发件箱');
    }

</script>
<style type="text/css">
    .input_textarea_long_long {
        font-size: 12px;
        border: 1px solid #b8b6b9;
        color: #007DBC;
        background-color: #FFFFFF;
        width: 500px;
        height: 260px;
    }
</style>

<form:form commandName="bean">
    <form:hidden path="id"/>
    <%--<div class="form_div">--%>
        <table cellpadding="0" cellspacing="0" class="form_table" style="position:absolute">

            <tr class="tr_light">
                <td class="form_label_right" width="15%">收件人：</td>
                <td class="form_content">
                    &nbsp;<input type="text" id="receivePersons" name="receivePersons" value="" readonly="true"
                                 class="input_text_long" style="width: 50%"/>
                    &nbsp;<input type="hidden" id="receivePersonId" name="receivePersonId" value="" class="input_text"/>
                    &nbsp;<input type="button" value="通讯录" class="button_normal_long"
                                 onclick="parent.openWindow('选择用户','${ctx}/oaMailGroupUser/select.do?objId=receivePersonId&objName=receivePersons&tabNo=tab5',false,700,450,null)"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" width="15%">抄送人：</td>
                <td class="form_content">
                    &nbsp;<input type="text" id="ccPersons" name="ccPersons" value="" readonly="true"
                                 class="input_text_long" style="width: 50%"/>
                    &nbsp;<input type="hidden" id="ccPersonId" name="ccPersonId" value="" class="input_text"/>
                    &nbsp;<input type="button" value="通讯录" class="button_normal_long"
                                 onclick="parent.openWindow('选择用户','${ctx}/oaMailGroupUser/select.do?objId=ccPersonId&objName=ccPersons&tabNo=tab5',false,700,450,null)">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" width="15%">主题：</td>
                <td class="form_content">
                    &nbsp;<form:input path="title" cssClass="input_text_long" cssStyle="width: 90%"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" width="15%">附件：</td>
                <td class="form_content">
                    &nbsp;${uploadButton}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" width="15%">内容：</td>
                <td class="form_content">
                    &nbsp;<form:textarea path="content" cssClass="input_textarea_long_long" cssStyle="width: 90%"/>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_border" colspan="2" align="center">
                    <input type="button" value="发送" class="button_confirm" onclick="save('send',this.value)">&nbsp;&nbsp;
                    <input type="button" value="保存" class="button_confirm" onclick="save('save','')">
                </td>
            </tr>
        </table>
    <%--</div>--%>
</form:form>