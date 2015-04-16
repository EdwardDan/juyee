<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            //{name:"jdTaskCode", rule:"validate[required,maxSize[10]]"},
            //{name:"bjbh", rule:"validate[required,maxSize[50]]"},
            //{name:"gdCode", rule:"validate[required,maxSize[50]]"},
            //{name:"gdName", rule:"validate[required,maxSize[200]]"},
            //{name:"belongArea", rule:"validate[required,maxSize[50]]"},
            //{name:"streetArea", rule:"validate[required,maxSize[50]]"},
            //{name:"isValid", rule:"validate[required,maxSize[1]]"},
            //{name:"positionName", rule:"validate[required,maxSize[50]]"},
            //{name:"certificateCode", rule:"validate[required,maxSize[50]]"},
            //{name:"certificateName", rule:"validate[required,maxSize[100]]"},
            //{name:"isDelete", rule:"validate[required,maxSize[1]]"},
            //{name:"isSync", rule:"validate[required,maxSize[1]]"},
            //{name:"guid", rule:"validate[required,maxSize[50]]"},
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
        saveAjaxData("${ctx}/checkManagerPosition/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">监督任务书编号：</td>
                <td class="form_content">
                    <form:input path="jdTaskCode" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">报建编号：</td>
                <td class="form_content">
                    <form:input path="bjbh" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">工地编号：</td>
                <td class="form_content">
                    <form:input path="gdCode" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">工地名称：</td>
                <td class="form_content">
                    <form:input path="gdName" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">所属区县：</td>
                <td class="form_content">
                    <form:input path="belongArea" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">街镇：</td>
                <td class="form_content">
                    <form:input path="streetArea" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">是否有效：</td>
                <td class="form_content">
                    <form:checkbox path="isValid" value="1"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">岗位名称：</td>
                <td class="form_content">
                    <form:input path="positionName" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">证书编号：</td>
                <td class="form_content">
                    <form:input path="certificateCode" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">证书名称：</td>
                <td class="form_content">
                    <form:input path="certificateName" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">逻辑删除：</td>
                <td class="form_content">
                    <form:checkbox path="isDelete" value="1"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">是否同步：</td>
                <td class="form_content">
                    <form:checkbox path="isSync" value="1"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">GUID：</td>
                <td class="form_content">
                    <form:input path="guid" cssClass="input_text"/>
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