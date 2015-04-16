<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "code", rule: "validate[required,maxSize[50]]"},
            {name: "source", rule: "validate[required,maxSize[100]]"},
            {name: "assignDate", rule: "validate[required,custom[date],maxSize[10]"},
            {name: "fileCode", rule: "validate[required,maxSize[50]]"},
            {name: "fileName", rule: "validate[required,maxSize[100]]"},
            {name: "fileContent", rule: "validate[required,maxSize[2000]]"},
            {name: "leaderOpinion", rule: "validate[required,maxSize[2000]]"},
            {name: "leaderPerson", rule: "validate[required,maxSize[50]]"},
            {name: "leaderDate", rule: "validate[required,custom[date],maxSize[10]"},
            {name: "dealOpinion", rule: "validate[required,maxSize[2000]]"},
            {name: "dealPerson", rule: "validate[required,maxSize[200]]"},
            {name: "dealDate", rule: "validate[required,custom[date],maxSize[10]"},
            {name: "checkOpinion", rule: "validate[required,maxSize[2000]]"},
            {name: "checkPerson", rule: "validate[required,maxSize[50]]"},
            {name: "checkDate", rule: "validate[required,custom[date],maxSize[10]"}

//            {name: "dealTime", rule: "validate[required,maxSize[10]"},
//            {name:"description", rule:"validate[required,maxSize[2000]]"},
//            {name:"status", rule:"validate[required,custom[integer],maxSize[2]"},
//            {name:"dealDeptNames", rule:"validate[required,maxSize[500]]"},
//            {name:"dealUsername", rule:"validate[required,maxSize[200]]"},
//            {name:"toDeptDate", rule:"validate[required,custom[date],maxSize[7]"},
//            {name:"requireReplyDate", rule:"validate[required,custom[date],maxSize[7]"},
//            {name:"actualReplyDate", rule:"validate[required,custom[date],maxSize[7]"},
//            {name:"isRemind", rule:"validate[required,maxSize[1]]"},
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(status, buttonName) {
        if (!validateForm(formId)) {
            return;
        }

        //加入其他业务判断
//        if ($('#name').val() == '') {
//            showInfoMsg('请输入姓名！',null);
//            return;
//        }

        //提交表单
        if (buttonName != "") {
            if (confirm("是否确定执行" + buttonName + "操作？")) {
                saveAjaxData("${ctx}/scjgFileAssign/save.do?status=" + status, formId);
            }
        } else {
            saveAjaxData("${ctx}/scjgFileAssign/save.do?status=" + status, formId);
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="code"/>

    <div class="form_div">

        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr>
                <td>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr>
                            <td colspan="5" class="net_form_title">
                                虹口区建管署交办件处理单
                            </td>
                        </tr>
                        <tr>
                            <td colspan="5" heigth="30"></td>
                        </tr>
                        <tr>
                            <td width="70%" style="text-align:right;">
                                &nbsp;编号：
                            </td>
                            <td align="left">
                                &nbsp;${bean.code}
                            </td>
                        </tr>
                        <tr>
                            <td colspan="5" heigth="30"></td>
                        </tr>
                    </table>
                </td>
            </tr>

            <tr>
                <td align="center">
                    <fieldset class="net_form_fieldset" style="width: 90%">
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td class="form_label_right" width="15%">来件来源：</td>
                                <td class="form_content" colspan="2" width="40%">
                                    <form:input path="source" cssClass="input_text_long"/>
                                </td>
                                <td class="form_label_right" width="15%">交办日期：</td>
                                <td class="form_content" width="30%">
                                    <form:input path="assignDate" cssClass="input_date" readonly="true"/>
                                    <input type="button" class="button_calendar" value=" "
                                           onClick="calendar('assignDate');">
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right" width="15%">来件编号：</td>
                                <td class="form_content" colspan="4" width="75%">
                                    <form:input path="fileCode" cssClass="input_text_long"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" width="15%">来件名称：</td>
                                <td class="form_content" colspan="4" width="75%">
                                    <form:input path="fileName" cssClass="input_text_long"/>
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">来件内容：</td>
                                <td class="form_content" colspan="4" width="75%">
                                    <form:textarea path="fileContent" cssClass="input_textarea_long"
                                                   cssStyle="width: 100%"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" rowspan="2">领导批示内容：</td>
                                <td class="form_content" colspan="4" width="75%">
                                    <form:textarea path="leaderOpinion" cssClass="input_textarea_long"
                                                   cssStyle="width: 100%"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" width="15%">领导批示签字：</td>
                                <td class="form_content" width="25%">
                                    <form:input path="leaderPerson" cssClass="input_text"/>
                                </td>
                                <td class="form_label_right" width="15%">领导批示日期：</td>
                                <td class="form_content" width="30%">
                                    <form:input path="leaderDate" cssClass="input_date" readonly="true"/>
                                    <input type="button" class="button_calendar" value=" "
                                           onClick="calendar('leaderDate');">
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right" rowspan="3" width="15%">处理情况：</td>
                                <td class="form_content" colspan="4" width="75%">
                                    <form:textarea path="dealOpinion" cssClass="input_textarea_long"
                                                   cssStyle="width: 100%"/>
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right" colspan="4">（可附页）</td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right" width="15%">承办人：</td>
                                <td class="form_content" width="25%">
                                    <form:input path="dealPerson" cssClass="input_text"/>
                                </td>
                                <td class="form_label_right" width="15%">承办日期：</td>
                                <td class="form_content" width="30%">
                                    <form:input path="dealDate" cssClass="input_date" readonly="true"/>
                                    <input type="button" class="button_calendar" value=" "
                                           onClick="calendar('dealDate');">
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" rowspan="2" width="15%">领导审核内容：</td>
                                <td class="form_content" colspan="4" width="75%">
                                    <form:textarea path="checkOpinion" cssClass="input_textarea_long"
                                                   cssStyle="width: 100%"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" width="15%">领导审核签字：</td>
                                <td class="form_content" width="25%">
                                    <form:input path="checkPerson" cssClass="input_text"/>
                                </td>
                                <td class="form_label_right" width="15%">领导审核日期：</td>
                                <td class="form_content" width="30%">
                                    <form:input path="checkDate" cssClass="input_date" readonly="true"/>
                                    <input type="button" class="button_calendar" value=" "
                                           onClick="calendar('checkDate');">
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right" width="15%">备注：</td>
                                <td class="form_content" colspan="4" width="75%">
                                    <form:textarea path="description" cssClass="input_textarea_long"
                                                   cssStyle="width: 100%"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">附件：</td>
                                <td class="form_content" colspan="4">
                                    &nbsp;${uploadButton}
                                </td>
                            </tr>
                            <tr class="tr_button">
                                <td class="form_border" colspan="5">
                                        <%--<c:choose>--%>
                                        <%--<c:when test="${bean.status == STATUS_AUDIT}">--%>
                                        <%--<input type="button" value="结束" class="button_back"--%>
                                        <%--onclick="save('${STATUS_OVER}',this.value)"> &nbsp;--%>
                                        <%--</c:when>--%>
                                        <%--<c:when test="${bean.status == STATUS_COMMAND}">--%>
                                        <%--<input type="button" value="承办" class="button_back"--%>
                                        <%--onclick="save('${STATUS_UNDERTAKE}',this.value)"> &nbsp;--%>
                                        <%--<input type="button" value="审核" class="button_confirm"--%>
                                        <%--onclick="save('${STATUS_AUDIT}',this.value)"> &nbsp;--%>
                                        <%--</c:when>--%>
                                        <%--<c:otherwise>--%>
                                        <%--<input type="button" value="批示" class="button_confirm" id="buttonSubmit"--%>
                                        <%--onclick="save('${STATUS_COMMAND}',this.value)">&nbsp;--%>
                                        <%--<input type="button" value="保存" class="button_confirm" id="buttonSave"--%>
                                        <%--onclick="save('${STATUS_EDIT}','')">&nbsp;--%>
                                        <%--</c:otherwise>--%>
                                        <%--</c:choose>--%>
                                    <input type="button" value="保存" class="button_confirm" id="buttonSave"
                                           onclick="save('${STATUS_EDIT}','')">&nbsp;
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