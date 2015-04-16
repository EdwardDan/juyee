<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        $("input[name='recheckDept']").click(function (e) {
            var vals = $("input[id^='recheckDept']");
            var flag = false;
            var recheckDeptValues = "";
            for (var i = 0; i < vals.length; i++) {
                if (vals[i].checked) {
                    recheckDeptValues += (vals[i].value + ",");
                    if (vals[i].value == '其他') {
                        flag = true;
                        break;
                    }
                }
            }
            recheckDeptValues = recheckDeptValues.substring(0, recheckDeptValues.length - 1);
            $("#checkBoxRecheckDept").val(recheckDeptValues);
            if (flag) {
                $("#recheckOther").attr("readonly", false);
            } else {
                $("#recheckOther").val("");
                $("#recheckOther").attr("readonly", true);
            }
//            if ($(e.target).val() == "其他") {
//                $("#recheckOther").attr("readonly", false);
//            } else {
//                $("#recheckOther").val("");
//                $("#recheckOther").attr("readonly", true);
//            }
        });
        var recheckDept = '${bean.recheckDept}'.split(",");
        for (var ii = 0; ii < recheckDept.length; ii++) {
            var vals = $("input[id^='recheckDept']");
            var flag = false;
            var recheckDeptValues = "";
            for (var i = 0; i < vals.length; i++) {
                if (vals[i].value == recheckDept[ii]) {
                    vals[i].checked = true;
                    if(vals[i].value=='其他'){
                        flag =true;
                    }
                }
            }
        }
           if(flag){
               $("#recheckOther").attr("readonly", false);
           }  else{
               $("#recheckOther").attr("readonly", true);
           }
//        if ($("input[name='recheckDept']:checked").val() != '其他') {
//            $("#recheckOther").attr("readonly", true);
//        }

        //页面验证初始化
        var validateCondition = [
            {name: "dutyDept", rule: "validate[required,maxSize[100]"},
            {name: "reformLimit", rule: "validate[required,custom[date],maxSize[10]"},
            {name: "signDept", rule: "validate[required,maxSize[200]]"},
            {name: "signPerson", rule: "validate[required,maxSize[50]]"},
            {name: "signDate", rule: "validate[required,custom[date],maxSize[10]"},
            {name: "description", rule: "validate[maxSize[2000]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //责任主体-单选
    function selectDutyDept(inputId, inputName, callback) {
        var icon = addIcons("company.gif");
        new PopTree({
            url: CONTEXT_NAME + '/jdStopOrder/dutyDeptForSelect.do?icon=' + icon + "&jdTypeCode=${bean.jdTypeCode}&recordId=${bean.recordId}",
            targetId: inputId,
            targetValueId: inputName,
            callback: callback
        });
    }

    //保存操作
    function save(status, btn) {
        if (!validateForm(formId)) {
            return;
        }
        if (status == "${UNREFORMED}") {
            $.messager.confirm('系统提示', '提交后不能再修改，确定吗?', function (r) {
                if (r) {
                    submitForm(status, btn);
                }
            });
        } else {
            submitForm(status, btn);
        }
    }
    //提交表单
    function submitForm(status, btn) {
        $('#status').val(status);
        disableBtn(btn);
        saveAjaxData("${ctx}/jdStopOrder/save.do", formId);
    }
</script>
<style type="text/css">
    .form_label {
        width: 20%;
    }
</style>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="status"/>
    <form:hidden path="formCode"/>
    <form:hidden path="jdTypeCode"/>
    <form:hidden path="jdAttributeCode"/>
    <form:hidden path="year"/>
    <form:hidden path="projectName"/>
    <form:hidden path="bjbh"/>
    <form:hidden path="recordId"/>
    <form:hidden path="signDept"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td colspan="2">
                    <h1>上海市建设工程质量安全监督整改指令单</h1>
                </td>
            </tr>
            <tr class="tr_dark">
                <td colspan="2">
                    虹口质监（${bean.year}）整字【${bean.orderNo}】号
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">责任主体：</td>
                <td class="form_content">
                    <form:input path="dutyDept" cssClass="input_text_long"/>
                    <img src="${ctx}/skin/workflow/user.gif" alt="" border="0"
                         onclick="selectDutyDept('','dutyDept')">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">选择存在问题：</td>
                <td class="form_content">
                    <table cellpadding="0" cellspacing="0" class="table_thin_line_center" border="1">
                        <tr class="tr_header">
                            <td width="10%">序号</td>
                            <td width="40%">问题</td>
                            <td width="30%">违反条款</td>
                            <td width="15%">监督员</td>
                            <td width="15%">选择</td>
                        </tr>
                        <c:forEach items="${jdRecordQuestionMapList}" var="jdRecordQuestion" varStatus="varStatus">
                            <tr
                                    <c:if test="${varStatus.index%2==0}">class="tr_dark"</c:if>
                                    <c:if test="${varStatus.index%2==1}">class="tr_light"</c:if>
                                    >
                                <td>${varStatus.index+1}</td>
                                <td align="left">${jdRecordQuestion["questionDesc"]}</td>
                                <td>${jdRecordQuestion["unlawDesc"]}</td>
                                <td>${jdRecordQuestion["jdPersonDesc"]}</td>

                                <td><input type="checkbox" name="jdRecordQuestionIds" id=""
                                           value="${jdRecordQuestion["id"]}"  ${questionCheck[jdRecordQuestion["checkId"]]}/>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">复查单位：</td>
                <td class="form_content">
                        <%--<form:radiobuttons path="recheckDept" items="${recheckDepts}"></form:radiobuttons>--%>
                    <form:checkboxes path="recheckDept" items="${recheckDepts}"></form:checkboxes>
                    <input type="hidden" id="checkBoxRecheckDept" name="checkBoxRecheckDept" value="${recheckDept}"/>
                    <form:input path="recheckOther"  cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">整改期限：</td>
                <td class="form_content">
                    <form:input path="reformLimit" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('reformLimit');">

                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">签发单位：</td>
                <td class="form_content">
                        ${bean.signDept}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">签发人：</td>
                <td class="form_content">
                    <form:input path="signPerson" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">签发日期：</td>
                <td class="form_content">
                    <form:input path="signDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('signDate');">

                </td>
            </tr>
            <tr class="tr_dark" style="display: none">
                <td class="form_label">备注：</td>
                <td class="form_content">
                    <form:textarea path="description" cssClass="input_textarea"></form:textarea>
                </td>
            </tr>
            <tr class="tr_button">
                <td colspan="2">
                    <input type="button" value="提交" class="button_confirm" onclick="save('${UNREFORMED}',this)">&nbsp;
                    <input type="button" value="保存" class="button_confirm" onclick="save('${EDIT}',this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>

    </div>
</form:form>