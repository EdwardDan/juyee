<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            //{name:"beginTime", rule:"validate[required,maxSize[7]]"},
            //{name:"endTime", rule:"validate[required,maxSize[7]]"},
            //{name:"address", rule:"validate[required,maxSize[200]]"},
            //{name:"innerPersons", rule:"validate[required,maxSize[${prop.length}]]"},
            //{name:"outerPersons", rule:"validate[required,maxSize[${prop.length}]]"},
            //{name:"title", rule:"validate[required,maxSize[200]]"},
            //{name:"content", rule:"validate[required,maxSize[${prop.length}]]"},
            //{name:"isValid", rule:"validate[required,maxSize[1]]"},
            //{name:"createTime", rule:"validate[required,maxSize[7]]"},
            //{name:"createUser", rule:"validate[required,maxSize[100]]"},
            //{name:"updateTime", rule:"validate[required,maxSize[7]]"},
            //{name:"updateUser", rule:"validate[required,maxSize[100]]"},
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //加入其他业务判断
//        if ($('#name').val() == '') {
//            showInfoMsg('请输入姓名！',null);
//            return;
//        }

        //提交表单
        saveAjaxData("${ctx}/oaMeetingInner/save.do", formId);
    }
    function removePersons() {
        document.getElementById("innerPersons").value = "";
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label">会议时间：</td>
                <td class="form_content">
                    <input type="text" name="beginTime" id="beginTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.beginTime}" pattern="yyyy-MM-dd HH:mm"/>"
                           readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('beginTime','all')">

                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">会议地点：</td>
                <td class="form_content">
                    <form:input path="address" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" width="20%">内部人员：</td>
                <td class="form_content">
                    <form:input path="innerPersons" cssClass="input_text"/>
                    <input type="button" value=" " class="button_select_add"
                           onclick="multiSelectSysPerson('','innerPersonIds','innerPersons')"
                           title="请选择人员">
                    <input typ="button" value="" class="button_select_remove" onclick="removePersons()"/>
                    <input type="hidden" name="innerPersonIds" id="innerPersonIds" value="">

                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">外部人员：</td>
                <td class="form_content">
                    <form:input path="outerPersons" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">会议议题：</td>
                <td class="form_content">
                    <form:input path="title" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">会议内容：</td>
                <td class="form_content">
                    <form:textarea path="content" cssStyle="width: 150px;height: 100px;"></form:textarea>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">附件：</td>
                <td class="form_content">
                        ${uploadButton}
                </td>
            </tr>

            <tr class="tr_button">
                <td class="form_label"></td>
                <td class="form_content">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>