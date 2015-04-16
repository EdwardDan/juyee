<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"code", rule:"validate[required,maxSize[50]]"},
            {name:"person", rule:"validate[required,maxSize[50]]"},
            {name:"petitionDate", rule:"validate[required,custom[date]"},
            {name:"contactAddress", rule:"validate[required,maxSize[100]]"},
            //{name:"targetDept", rule:"validate[required,maxSize[200]]"},
            {name:"fileContent", rule:"validate[required,maxSize[1000]]"},
            <%--${prop.length}]]"},            --%>
            {name:"fileSourceId", rule:"validate[required,custom[integer],maxSize[10]"},
            //{name:"fileSourceDesc", rule:"validate[required,maxSize[100]]"},
            //{name:"receiveDate", rule:"validate[required,custom[date],maxSize[7]"},
            //{name:"dealTime", rule:"validate[required,custom[date],maxSize[7]"},
            {name:"dealOpinion", rule:"validate[required,maxSize[1000]]"},
            <%--${prop.length}]]"},            --%>
            //{name:"dealDeptNames", rule:"validate[required,maxSize[500]]"},
            //{name:"dealPerson", rule:"validate[required,maxSize[200]]"},
            //{name:"dealUsername", rule:"validate[required,maxSize[200]]"},
            //{name:"dealDate", rule:"validate[required,custom[date],maxSize[7]"},
            {name:"leaderOpinion", rule:"validate[required,maxSize[1000]]"},
            <%--${prop.length}]]"},            --%>
            {name:"leaderPerson", rule:"validate[required,maxSize[25]]"},
            {name:"leaderDate", rule:"validate[required,custom[date]"},
            //{name:"toDeptDate", rule:"validate[required,custom[date],maxSize[7]"},
            //{name:"requireReplyDate", rule:"validate[required,custom[date],maxSize[7]"},
            //{name:"actualReplyDate", rule:"validate[required,custom[date],maxSize[7]"},
            {name:"caseAnalyze", rule:"validate[required,maxSize[1000]]"},
            <%--${prop.length}]]"},            --%>
            {name:"caseAttitude", rule:"validate[required,maxSize[1000]]"}
            <%--${prop.length}]]"},            --%>
            //{name:"description", rule:"validate[required,maxSize[
            <%--${prop.length}]]"},            --%>
            //{name:"status", rule:"validate[required,custom[integer],maxSize[2]"},
            //{name:"isRemind", rule:"validate[required,maxSize[1]]"},
        ];
        validateInit(validateCondition, formId);
    });

    function disableBtnById(id) {
        var v = document.getElementById(id);
        if (v != undefined && v != null && v != "") {
            v.disabled = true;
        }
    }

    function disableAllBtn() {
        disableBtnById("pass");
        disableBtnById("back");

        disableBtnById("submit");
        disableBtnById("edit");
    }

    function enableBtnById(id, name) {
        var v = document.getElementById(id);
        if (v != undefined && v != null && v != "") {
            v.value = name;
            v.disabled = false;
        }
    }

    function enableAllBtn() {
        enableBtnById("pass", "通过");
        enableBtnById("back", "退回");

        enableBtnById("submit", "提交");
        enableBtnById("edit", "保存");
    }

    //保存操作
    function save(status, btn) {
        disableBtn(btn);

//        disableAllBtn();
//        disableBtn(btn);

        $("#status").val(status);
        if (!validateForm(formId)) {
            enableBtn(btn);
//            enableAllBtn();
            return;
        }

        <%--if ($("#planStartDate").val() > $("#planEndDate").val()) {--%>
            <%--showErrorMsg("计划结束日期不能小于计划开始日期！");--%>
            <%--$("#planEndDate")[0].focus();--%>
            <%--enableAllBtn();--%>
            <%--return;--%>
        <%--}--%>

        <%--if (status == '${STATUS_SUBMIT}') {--%>
            <%--if (!confirm("是否提交，提交后不能修改？")) {--%>
                <%--enableAllBtn();--%>
                <%--return false;--%>
            <%--}--%>
        <%--} else if (status == '${STATUS_PASS}') {--%>
            <%--if (!confirm("是否通过，通过后不能修改？")) {--%>
                <%--enableAllBtn();--%>
                <%--return false;--%>
            <%--}--%>
        <%--} else if (status == '${STATUS_BACK}') {--%>
            <%--if (!confirm("是否确定执行退回操作？")) {--%>
                <%--enableAllBtn();--%>
                <%--return false;--%>
            <%--}--%>
        <%--}--%>

        //提交表单
        saveAjaxData("${ctx}/scjgFilePetition/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="code"/>
    <form:hidden path="status"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr>
                <td>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr>
                            <td colspan="2" class="net_form_title">
                                虹口区监管署信访处理单
                                    <%--<span class="net_form_title2">--%>
                                    <%--（表一）--%>
                                    <%--</span>--%>
                            </td>
                        </tr>
                        <tr>
                            <td width="70%" style="text-align:right;">
                                &nbsp;编号：
                            </td>
                            <td align="left">
                                &nbsp;${bean.code}

                                    <%--<span class="net_form_title2">--%>
                                    <%--<form:input path="code" cssClass="input_text" readonly="true"/>--%>
                                    <%--</span>--%>
                            </td>
                        </tr>
                            <%--<tr>--%>
                            <%--<td colspan="2">--%>
                            <%--&nbsp;--%>
                            <%--</td>--%>
                            <%--</tr>--%>
                    </table>
                </td>
            </tr>

            <tr>
                <td align="center">
                    <fieldset class="net_form_fieldset" style="width: 90%">
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_dark">
                                <td class="form_label_right" width="30%">信访人：</td>
                                <td class="form_content" width="33%">
                                    <form:input path="person" cssClass="input_text"/>
                                </td>
                                <td class="form_label_right" width="15%">信访时间：</td>
                                <td class="form_content">
                                    <form:input path="petitionDate" cssClass="input_date" readonly="true"/>
                                    <input type="button" class="button_calendar" value=" "
                                           onClick="calendar('petitionDate');">

                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">联系地址电话：</td>
                                <td class="form_content">
                                    <form:input path="contactAddress" cssClass="input_text_long"/>
                                </td>

                                <td class="form_label_right">投诉来源:</td>
                                <td class="form_content">
                                    <sys:code code="${recordSource}" name="fileSourceId" type="select" defaultName=""
                                              sysCodeDetailId="${bean.fileSourceId}" disabled="" id="fileSourceId"
                                              isAlowedNull="true"
                                              onChange=""/>
                                </td>
                            </tr>

                            <tr class="tr_dark">
                                <td class="form_label_right">投诉内容：</td>
                                <td class="form_content" colspan="3">
                                    <form:textarea path="fileContent" cssClass="input_textarea_long"/>
                                </td>
                            </tr>


                            <tr class="tr_light" colspan="3">
                                <td class="form_label_right">领导批示：</td>
                                <td class="form_content" colspan="3">
                                    <%--<form:textarea path="leaderOpinion" cssClass="input_textarea_long"/>--%>

                                    <table cellpadding="0" cellspacing="0" class="form_table">
                                        <tr class="tr_dark">
                                            <td class="form_content" colspan="4">
                                                <form:textarea path="leaderOpinion" cssClass="input_textarea_long"/>
                                            </td>
                                        </tr>

                                        <tr class="tr_dark">
                                            <td class="form_label_right" width="18%">领导签字：</td>
                                            <td class="form_content" width="30%">
                                                <form:input path="leaderPerson" cssClass="input_text"/>
                                            </td>
                                            <td class="form_label_right" width="15%">日期：</td>
                                            <td class="form_content">
                                                <form:input path="leaderDate" cssClass="input_date" readonly="true"/>
                                                <input type="button" class="button_calendar" value=" "
                                                       onClick="calendar('leaderDate');">
                                            </td>
                                        </tr>
                                    </table>

                                </td>
                            </tr>

                            <%--<tr class="tr_light">--%>
                                <%--<td class="form_label_right">领导批示签字：</td>--%>
                                <%--<td class="form_content">--%>
                                    <%--<form:input path="leaderPerson" cssClass="input_text"/>--%>
                                <%--</td>--%>
                                <%--<td class="form_label_right">领导批示日期：</td>--%>
                                <%--<td class="form_content">--%>
                                    <%--<form:input path="leaderDate" cssClass="input_date" readonly="true"/>--%>
                                    <%--<input type="button" class="button_calendar" value=" "--%>
                                           <%--onClick="calendar('leaderDate');">--%>

                                <%--</td>--%>
                            <%--</tr>--%>

                            <tr class="tr_dark">
                                <td class="form_label_right">情况核查及分析：</td>
                                <td class="form_content" colspan="3">
                                    <form:textarea path="caseAnalyze" cssClass="input_textarea_long"/>
                                </td>
                            </tr>

                            <tr class="tr_light">
                                <td class="form_label_right">处理情况：</td>
                                <td class="form_content" colspan="3">
                                    <form:textarea path="dealOpinion" cssClass="input_textarea_long"/>
                                </td>
                            </tr>

                            <tr class="tr_dark">
                                <td class="form_label_right">信访人对处理情况态度：</td>
                                <td class="form_content" colspan="3">
                                    <form:textarea path="caseAttitude" cssClass="input_textarea_long"/>
                                </td>
                            </tr>

                            <tr class="tr_light">
                                <td class="form_label_right">附件：</td>
                                <td class="form_content" colspan="4">
                                        ${uploadButton}
                                </td>
                            </tr>

                            <tr class="tr_button">
                                <td class="form_border" colspan="4">
                                    <%--<c:choose>--%>
                                        <%--<c:when test="${bean.status == STATUS_SUBMIT}">--%>
                                            <%--<input id="back" name="back" type="button" value="退回" class="button_back"--%>
                                                   <%--onclick="save('${STATUS_BACK}',this)"> &nbsp;--%>
                                            <%--<input id="pass" name="pass" type="button" value="通过" class="button_confirm"--%>
                                                   <%--onclick="save('${STATUS_PASS}',this)"> &nbsp;--%>
                                        <%--</c:when>--%>
                                        <%--<c:otherwise>--%>
                                            <%--<input id="submit" name="submit" type="button" value="提交" class="button_confirm"--%>
                                                   <%--onclick="save('${STATUS_SUBMIT}',this)">&nbsp;--%>
                                            <%--<input id="edit" name="edit" type="button" value="保存" class="button_confirm"--%>
                                                   <%--onclick="save('${STATUS_EDIT}',this)">&nbsp;--%>
                                        <%--</c:otherwise>--%>
                                    <%--</c:choose>--%>
                                    <%--<input type="button" value="取消" class="button_cancel" onclick="closeWindow()">--%>
                                    <input type="button" value="确定" class="button_confirm" onclick="save('${STATUS_EDIT}',this)">&nbsp;
                                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                                </td>
                            </tr>
                        </table>

                    </fieldset>
                </td>
            </tr>
        </table>
    </div>
</form:form>