<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        //提交表单
        saveAjaxData("${ctx}/pollingUnlawfulProject/saveBelongArea.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label">项目名称：</td>
                <td class="form_content">
                        ${bean.projectName}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">建设单位：</td>
                <td class="form_content">
                    ${bean.buildUnit}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">项目属地：</td>
                <td class="form_content">
                    <sys:code code="${ProBelongArea}" isAlowedNull="true" type="select" isSaveName="true" name="belongArea"
                              defaultName="${bean.belongArea}"></sys:code>
                </td>
            </tr>
        </table>
    </div>
    <div style="height: 30px"></div>
    <div>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_button">
                <td align="center" style="padding-right: 30px">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>