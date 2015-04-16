<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "bjbh", rule: "validate[required,maxSize[25]]"},
            {name: "projectName", rule: "validate[required,maxSize[100]]"},
            {name: "projectAddress", rule: "validate[required,maxSize[100]]"},
            {name: "jsDept", rule: "validate[required,maxSize[100]]"},
            {name: "jsDeptLxr", rule: "validate[required,maxSize[25]]"},
            {name: "jsDeptTel", rule: "validate[required,maxSize[25]]"},
            {name: "sgDept", rule: "validate[required,maxSize[100]]"},
            {name: "sgDeptLxr", rule: "validate[required,maxSize[25]]"},
            {name: "sgDeptTel", rule: "validate[required,maxSize[25]]"},
            {name: "xzName", rule: "validate[required,maxSize[25]]"},
            {name: "xzTel", rule: "validate[required,maxSize[25]]"},
            {name: "xzDept", rule: "validate[required,maxSize[100]]"},
            {name: "zzName", rule: "validate[required,maxSize[25]]"},
            {name: "zzTel", rule: "validate[required,maxSize[25]]"},
            {name: "zzDept", rule: "validate[required,maxSize[100]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //提交表单
        saveAjaxData("${ctx}/workerSchool/save.do", formId);
    }
    //获取监督记录相关的工程信息
    function getProjectInfo(btn) {
        var v = $("#bjbh").val();
        if (v == "") {
            showInfoMsg("报建编号!");
            return;
        }
        btn.value = "请稍候";
        btn.disabled = true;
        $.ajax({
            url: CONTEXT_NAME + "/workerSchool/getProjectInfo.do?bjbh=" + v,
            cache: false,
            data: "",
            success: function (ret) {
//                console.log()
                if (ret.indexOf("{") >= 0) {
                    var json = eval("(" + ret + ")");
                    var data = json[0];
                    if (data.projectName != "") {
                        for (var key in data) {
                            $('#' + key).val(data[key]);
                        }
                    } else {
                        showErrorMsg("未获取到有效工程信息");
                    }
                } else {
                    showErrorMsg("未获取到有效工程信息");
                }
                btn.value = "获取";
                btn.disabled = false;
            }, error: function () {
                btn.value = "获取";
                btn.disabled = false;
            }
        });
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr>
                <td colspan="2">
                    <fieldset style="width: 90%;margin:0px auto">
                        <legend class="form_legend">务工人员学校管理</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td class="form_label_right" width="20%">报建编号：</td>
                                <td class="form_content" nowrap width="30">
                                    <form:input path="bjbh" cssClass="input_text"/>
                                    <input type="button" value="获取" class="button_all" onclick="getProjectInfo(this)">
                                </td>
                                <td class="form_label_right" width="20%">创建时间：</td>
                                <td class="form_content" width="30%">
                                    <input type="text" name="createTime" id="createTime" class="input_datetime"
                                           value="<fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                                           readonly="true"/>
                                    <input type="button" class="button_calendar" value=" "
                                           onClick="calendar('createTime','all')">
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">项目名称：</td>
                                <td class="form_content" colspan="3">
                                    <form:input path="projectName" cssClass="input_text_long"/>
                                </td>

                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">项目地点：</td>
                                <td class="form_content" colspan="3">
                                    <form:input path="projectAddress" cssClass="input_text_long"/>
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">建设单位：</td>
                                <td class="form_content" colspan="3">
                                    <form:input path="jsDept" cssClass="input_text_long"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">建设单位负责人：</td>
                                <td class="form_content">
                                    <form:input path="jsDeptLxr" cssClass="input_text"/>
                                </td>
                                <td class="form_label_right">建设单位联系电话：</td>
                                <td class="form_content">
                                    <form:input path="jsDeptTel" cssClass="input_text"/>
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">施工单位：</td>
                                <td class="form_content" colspan="3">
                                    <form:input path="sgDept" cssClass="input_text_long"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">施工单位负责人：</td>
                                <td class="form_content">
                                    <form:input path="sgDeptLxr" cssClass="input_text"/>
                                </td>
                                <td class="form_label_right">施工单位联系电话：</td>
                                <td class="form_content">
                                    <form:input path="sgDeptTel" cssClass="input_text"/>
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">校长姓名：</td>
                                <td class="form_content" >
                                    <form:input path="xzName" cssClass="input_text"/>
                                </td>
                                <td class="form_label_right">校长电话：</td>
                                <td class="form_content">
                                    <form:input path="xzTel" cssClass="input_text"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">校长所属单位名称：</td>
                                <td class="form_content" colspan="3">
                                    <form:input path="xzDept" cssClass="input_text_long"/>
                                </td>

                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">组长姓名：</td>
                                <td class="form_content" >
                                    <form:input path="zzName" cssClass="input_text"/>
                                </td>
                                <td class="form_label_right">组长电话：</td>
                                <td class="form_content">
                                    <form:input path="zzTel" cssClass="input_text"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">组长所属单位名称：</td>
                                <td class="form_content" colspan="3">
                                    <form:input path="zzDept" cssClass="input_text_long"/>
                                </td>

                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>
            <tr class="tr_button">
                <td align="center" colspan="4">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>