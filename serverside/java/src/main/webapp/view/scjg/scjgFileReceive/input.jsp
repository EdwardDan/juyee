<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "code", rule: "validate[required,maxSize[50]]"},
            {name: "source", rule: "validate[required,maxSize[100]]"},
            //{name:"targetDept", rule:"validate[required,maxSize[100]]"},
            {name: "receiveDate", rule: "validate[required,custom[date],maxSize[10]"},
            {name: "fileName", rule: "validate[required,maxSize[100]]"},
            {name: "fileCode", rule: "validate[required,maxSize[50]]"},
//            {name:"fileContent", rule:"validate[required,maxSize[2000]]"},

            {name: "dealTime", rule: "validate[required,custom[date],maxSize[10]"},
            //{name:"dealOpinion", rule:"validate[required,maxSize[

//            {name:"dealDeptNames", rule:"validate[required,maxSize[500]]"},
            {name: "dealPerson", rule: "validate[required,maxSize[200]]"},
            //{name:"dealUsername", rule:"validate[required,maxSize[200]]"},
            {name: "dealDate", rule: "validate[required,custom[date],maxSize[10]"},
            //{name:"leaderOpinion", rule:"validate[required,maxSize[

            {name: "leaderPerson", rule: "validate[required,maxSize[50]]"},
            {name: "leaderDate", rule: "validate[required,custom[date],maxSize[10]"}
            //{name:"description", rule:"validate[required,maxSize[

            //{name:"status", rule:"validate[required,custom[integer],maxSize[2]"},
            //{name:"toDeptDate", rule:"validate[required,custom[date],maxSize[7]"},
            //{name:"requireReplyDate", rule:"validate[required,custom[date],maxSize[7]"},
            //{name:"actualReplyDate", rule:"validate[required,custom[date],maxSize[7]"},
            //{name:"createTime", rule:"validate[required,maxSize[7]]"},
            //{name:"createUser", rule:"validate[required,maxSize[100]]"},
            //{name:"updateTime", rule:"validate[required,maxSize[7]]"},
            //{name:"updateUser", rule:"validate[required,maxSize[100]]"},
            //{name:"isRemind", rule:"validate[required,maxSize[1]]"},
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(status, btn) {
        $("#status").val(status);
        if (!validateForm(formId)) {
            return;
        }

        //加入其他业务判断
//        if ($('#name').val() == '') {
//            showInfoMsg('请输入姓名！',null);
//            return;
//        }

        //提交表单
        saveAjaxData("${ctx}/scjgFileReceive/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="code"/>
    <input type="hidden" name="status" id="status" value="${bean.status}"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr>
                <td>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr>
                            <td colspan="2" class="net_form_title">
                                虹口区建管署来件处理单

                            </td>
                        </tr>
                        <tr>
                            <td width="70%" style="text-align:right;">
                                &nbsp;编号：
                            </td>
                            <td align="left">
                                &nbsp;${bean.code}


                            </td>
                        </tr>

                    </table>
                </td>
            </tr>
           <tr>
                <td align="center">
                    <fieldset class="net_form_fieldset" style="width: 90%">
                        <table cellpadding="0" cellspacing="0" class="form_table">
           <tr class="tr_dark">
                <td class="form_label_right" style="width: 100px">来件单位：</td>
                <td class="form_content">
                    <form:input path="source" cssClass="input_text_long"/>
                </td>
                <td clss="form_label_right" style="width: 100px" align="right">来件时间：</td>
                <td class="form_content">
                    <form:input path="receiveDate" cssClass="input_date_long" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('receiveDate');">

                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right" style="width: 100px">来件名称：</td>
                <td class="form_content">
                    <form:input path="fileName" cssClass="input_text_long"/>
                </td>
                <td class="form_label_right" style="width: 100px">来件编号：</td>
                <td class="form_content">
                    <form:input path="fileCode" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" style="width: 100px">来件内容：</td>
                <td colspan="3">
                    <form:textarea path="fileContent"
                                   cssStyle="width: 100%" cssClass="input_textarea_long"></form:textarea>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" style="width: 100px">处理时限：</td>
                <td class="form_content" colspan="3">
                    <form:input path="dealTime" cssClass="input_date_long" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('dealTime');">

                </td>
            </tr>
            <tr>
            <tr class="tr_dark">
                <td class="form_label_right" style="width: 100px">处理情况：</td>
                <td class="form_content" colspan="3">
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_dark">
                            <td colspan="4">
                                <form:textarea path="dealOpinion"
                                               cssStyle="width: 100%" cssClass="input_textarea_long"></form:textarea>
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right" style="width: 100px" nowrap>承办人：</td>
                            <td class="form_content" style="width: 200px" nowrap>
                                <form:input path="dealPerson" cssClass="input_text"/>
                            </td>
                            <td class="form_label_right" style="width: 100px" nowrap>承办日期：</td>
                            <td class="form_content" style="width: 200px" nowrap>
                                <form:input path="dealDate" cssClass="input_date_long" readonly="true"/>
                                <input type="button" class="button_calendar" value=" " onClick="calendar('dealDate');">

                            </td>
                        </tr>
                    </table>
                </td>
            </tr>

            <tr>
            <tr class="tr_light">
                <td rowapan="2" class="form_label_right" style="width: 100px">领导审核：</td>
                <td class="form_content" colspan="3">
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
                            <td colspan="4">
                            <form:textarea path="leaderOpinion"
                                           cssStyle="width: 100%" cssClass="input_textarea_long"></form:textarea>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right" style="width: 100px" nowrap>领导签字：</td>
                            <td class="form_content" style="width: 200px" nowrap>
                                <form:input path="leaderPerson" cssClass="input_text"/>
                            </td>
                            <td class="form_label_right" style="width: 100px" nowrap>日期：</td>
                            <td class="form_content" style="width: 200px" nowrap>
                                <form:input path="leaderDate" cssClass="input_date_long" readonly="true"/>
                                <input type="button" class="button_calendar" value=" "
                                       onClick="calendar('leaderDate');">

                            </td>

                        </tr>
                    </table>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" style="width: 100px" nowrap>备注：</td>
                <td colspan="3">
                    <form:textarea path="description"
                                   cssStyle="width: 100%" cssClass="input_textarea_long"></form:textarea>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">附件：</td>
                <td class="form_content" colspan="4">
                        ${uploadButton}
                </td>
            </tr>

            <tr class="tr_button">
                <td colspan="4">
                    <input type="button" value="确定" class="button_confirm"
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