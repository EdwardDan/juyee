<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"bjbh", rule:"validate[required,maxSize[50]]"},
            {name:"bdh", rule:"validate[required,maxSize[50]]"},
            {name:"projectName", rule:"validate[required,maxSize[200]]"},
            {name:"buildUnit", rule:"validate[required,maxSize[200]]"},
            {name:"buildAddress", rule:"validate[required,maxSize[200]]"},
            {name:"signLastDate", rule:"validate[required,maxSize[50]]"},
            {name:"signProxyUnit", rule:"validate[required,maxSize[200]]"},
            {name:"linkPerson", rule:"validate[required,maxSize[50]]"},
            {name:"linkTel", rule:"validate[required,custom[phone],maxSize[50]]"},
            {name:"signAccount", rule:"validate[custom[integer],maxSize[10]]"}
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
        saveAjaxData("${ctx}/netZbdl/save.do", formId);
    }
    //获取监督记录相关的工程信息
    function getProjectInfo(btn) {
        var v = $("#bjbh").val();
        if (v == "") {
            showInfoMsg("请输入报建编号!");
            return;
        }
        btn.value = "请稍候";
        btn.disabled = true;
        $.ajax({
            url: CONTEXT_NAME + "/netZbdl/getProjectInfoByBjbh.do?bjbh=" + v,
            cache: false,
            data: "",
            success: function (ret) {
//                console.log()
                if (ret.indexOf("{") >= 0) {
                    var json = eval("(" + ret + ")");
                    var data = json[0];
                    if (data.projectName != "") {
                        $("#projectName").val(data["projectName"]);
                        $("#buildUnit").val(data["jsdwmc"]);
                        $("#buildAddress").val(data["jsdwAddress"]);

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
            <tr class="tr_light">
                <td class="form_label_right">报建编号：</td>
                <td class="form_content">
                    <form:input path="bjbh" cssClass="input_text"/>
                </td>
                <td class="form_label_right">标段号：</td>
                <td class="form_content">
                    <form:input path="bdh" cssClass="input_text"/>
                    <input type="button" value="获取" class="button_all" onclick="getProjectInfo(this)">
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">项目名称：</td>
                <td class="form_content" colspan="3">
                    <form:input path="projectName" cssClass="input_text" cssStyle="width:90%"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">建设单位：</td>
                <td class="form_content" colspan="3">
                    <form:input path="buildUnit" cssClass="input_text" cssStyle="width:90%"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">建设地点：</td>
                <td class="form_content" colspan="3">
                    <form:input path="buildAddress" cssClass="input_text" cssStyle="width:90%"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">购买标书截至时间：</td>
                <td class="form_content">
                    <form:input path="signLastDate" cssClass="input_datetime" readonly="true"/>
                    <input type="button" class="button_calendar" value="" onClick="calendar('signLastDate','all');">
                </td>
                <td class="form_label_right">投标保证金截止日期：</td>
                <td class="form_content">
                    <form:input path="signDate" cssClass="input_datetime" readonly="true"/>
                    <input type="button" class="button_calendar" value="" onClick="calendar('signDate','all');">
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">招标代理单位：</td>
                <td class="form_content" colspan="3">
                    <form:input path="signProxyUnit" cssClass="input_text" cssStyle="width:90%"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">联系人：</td>
                <td class="form_content">
                    <form:input path="linkPerson" cssClass="input_text"/>
                </td>
                <td class="form_label_right">联系电话：</td>
                <td class="form_content">
                    <form:input path="linkTel" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">项目投标保证金：</td>
                <td class="form_content" colspan="3">
                    <form:input path="signAccount" cssClass="input_number"/>（元）
                </td>
            </tr>
            <tr class="tr_button">
                <td colspan="4">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>