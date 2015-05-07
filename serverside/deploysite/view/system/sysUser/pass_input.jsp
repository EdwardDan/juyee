<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"oldPass", rule:"validate[required,maxSize[10]]"},
            {name:"newPass", rule:"validate[required,minSize[4],maxSize[10]]"},
            {name:"confirmPass", rule:"validate[required,minSize[4],maxSize[10]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        //check
        var oldP = $('#oldPass');
        var newP = $('#newPass');
        var conP = $('#confirmPass');

        if (newP.val() == '') {
            showInfoMsg('请输入密码！',null);
            newP.focus();
            return;
        }
        if (conP.val() == '') {
            showInfoMsg('请输入确认密码！',null);
            conP.focus();
            return;
        }

        if (newP.val() != conP.val()) {
            showInfoMsg('两次密码不一致！请重新输入',null);
            newP.focus();
            return;
        }

        //提交表单
        saveAjaxData("${ctx}/sysPassword/savePass.do", formId);
    }
</script>
<form:form commandName="bean">
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form-table" width="96%">
            <tr class="tr_light">
                <td class="form_label">
                    原密码：
                </td>
                <td class="form_content">
                    <input type="password" name="oldPass" id="oldPass" class="input_text" value=""/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">
                    新密码：
                </td>
                <td class="form_content">
                    <input type="password" name="newPass" id="newPass" class="input_text" value=""/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">
                    确认密码：
                </td>
                <td class="form_content">
                    <input type="password" name="confirmPass" id="confirmPass" class="input_text" value=""/>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_border" colspan="2">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>
