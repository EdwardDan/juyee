<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "bjbh", rule: "validate[required]"} ,
            {name: "visitDate", rule: "validate[required,custom[date]"},
            {name: "code", rule: "validate[required,maxSize[50]]"},
            {name: "personName", rule: "validate[required,maxSize[50]]"},
            {name: "personCount", rule: "validate[required,custom[integer],maxSize[6]"} ,
            {name: "debtPerson", rule: "validate[required,maxSize[50]]"},
            {name: "debtMoney", rule: "validate[required,custom[number],maxSize[12]"},
            {name: "dealDate", rule: "validate[required,custom[date]"},
            {name: "dealJbr", rule: "validate[required,maxSize[50]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //提交表单
        saveAjaxData("${ctx}/workerComplain/save.do", formId);
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
            url: CONTEXT_NAME + "/workerComplain/getProjectInfo.do?bjbh=" + v,
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
            <tr class="tr_light">
                <td class="form_label_right" nowrap>报建编号：</td>
                <td class="form_content" nowrap colspan="3">
                    <form:input path="bjbh" cssClass="input_text"/>
                    <input type="button" value="获取" class="button_all" onclick="getProjectInfo(this)">
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" nowrap>来访日期：</td>
                <td class="form_content">
                    <form:input path="visitDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('visitDate');">
                </td>
                <td class="form_label_right" nowrap>编号：</td>
                <td class="form_content">
                    <form:input path="code" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" nowrap>来访者姓名：</td>
                <td class="form_content">
                    <form:input path="personName" cssClass="input_text"/>
                </td>
                <td class="form_label_right" nowrap>来访人数：</td>
                <td class="form_content">
                    <form:input path="personCount" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" nowrap>来访者住址：</td>
                <td class="form_content">
                    <form:input path="personAddress" cssClass="input_text"/>
                </td>
                <td class="form_label_right" nowrap>身份证号码：</td>
                <td class="form_content">
                    <form:input path="personIdcard" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" nowrap>来访者联系电话：</td>
                <td class="form_content">
                    <form:input path="personTel" cssClass="input_text"/>
                </td>
                <td class="form_label_right" nowrap>欠款人：</td>
                <td class="form_content">
                    <form:input path="debtPerson" cssClass="input_text"/>
                </td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label_right" nowrap>项目名称：</td>
                <td class="form_content">
                    <form:input path="projectName" cssClass="input_text"/>
                </td>
                <td class="form_label_right" nowrap>项目地点：</td>
                <td class="form_content">
                    <form:input path="projectAddress" cssClass="input_text"/>
                </td>

            </tr>
            <tr class="tr_light">
                <td class="form_label_right" nowrap>建设单位名称：</td>
                <td class="form_content">
                    <form:input path="jsDept" cssClass="input_text"/>
                </td>
                <td class="form_border" nowrap>建设单位负责人： <form:input path="jsDeptLxr" cssStyle="width: 50%"
                                                                    cssClass="input_text"/>
                </td>
                <td class="form_content">
                    建设单位联系电话： <form:input path="jsDeptTel" cssStyle="width: 50%" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" nowrap>总包单位名称：</td>
                <td class="form_content">
                    <form:input path="zbDept" cssClass="input_text"/>
                </td>
                <td class="form_border" nowrap>总包单位负责人： <form:input path="zbDeptLxr" cssStyle="width: 50%"
                                                                    cssClass="input_text"/>
                </td>
                <td class="form_content">
                    总包单位联系电话： <form:input path="zbDeptTel" cssStyle="width: 50%" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" nowrap>项目经理：
                </td>
                <td class="form_content">
                    <form:input path="manager" cssStyle="width: 50%"
                                cssClass="input_text"/>
                </td>
                <td class="form_label_right" nowrap>项目经理电话：
                </td>
                <td class="form_content">
                    <form:input path="managerTel" cssStyle="width: 50%" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" nowrap>分包单位名称：</td>
                <td class="form_content">
                    <form:input path="fbDept" cssClass="input_text"/>
                </td>
                <td class="form_border" nowrap>分包单位负责人：<form:input path="fbDeptLxr" cssStyle="width: 50%"
                                                                   cssClass="input_text"/>
                </td>
                <td class="form_content">
                    分包单位联系电话： <form:input path="fbDeptTel" cssStyle="width: 50%" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" nowrap>涉及工资款：</td>
                <td class="form_content">
                    <form:input path="debtMoney" cssClass="input_text"/>
                </td>
                <td class="form_label_right" nowrap>涉及民工人数：</td>
                <td class="form_content">
                    <form:input path="debtPersons" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" nowrap>款项类型：</td>
                <td class="form_content" colspan="3">
                    <sys:code code="${monyCode}" name="moneyType" type="select"
                              defaultName="${bean.moneyType}" disabled="" id="moneyType"
                               isSaveName="true"
                              onChange=""/>
                    <%--<form:input path="moneyType" cssClass="input_text"/>--%>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" nowrap>拖欠凭证：</td>
                <td class="form_content" colspan="3">
                        <form:textarea path="debtCert" cssStyle="width: 85%" cssClass="input_textarea"/>
            </tr>
            </td>
            <tr class="tr_dark">
                <td class="form_label_right" nowrap>投诉内容：</td>
                <td class="form_content" colspan="3" >
                    <form:textarea path="content" cssStyle="width: 85%" cssClass="input_textarea"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" nowrap>处理情况：</td>
                <td class="form_content" colspan="3">
                    <form:textarea path="dealOpinion" cssStyle="width: 85%" cssClass="input_textarea"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" nowrap>处理日期：</td>
                <td class="form_content">
                    <form:input path="dealDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('dealDate');">

                </td>
                <td class="form_label_right" nowrap>经办人：</td>
                <td class="form_content">
                    <form:input path="dealJbr" cssClass="input_text"/>
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