<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "replyPerson", rule: "validate[required]"},
            {name: "receivePerson", rule: "validate[required]"},
            {name: "replyContent", rule: "validate[required]"},
            {name: "replyDate", rule: "validate[required]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn2, stat) {
        if (!validateForm(formId)) {
            return;
        }
        // 新增或者填写
        if ('${STATUS_EDIT}' == stat) {
            $("#status").val(stat);
            saveDate(btn2);

            // 提交
        } else if ('${STATUS_SUBMIT}' == stat) {
            $.messager.confirm('系统提示', '提交后不能再修改，确定吗?', function (r) {
                if (r) {
                    $("#status").val(stat);
                    saveDate(btn2);
                }
            });
        }
    }

    function saveDate(btn2) {
        disableBtn(btn2);
        //提交表单
        saveAjaxData("${ctx}/jdReformReply/save.do", formId);
    }

</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <input type="hidden" value="${bean.status}" name="status" id="status"/>
    <input type="hidden" value="${stopFormId}" id="stopFormId" name="stopFormId"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <c:if test="${bean.status == STATUS_FIRST_BACK||showFlag}">
                <tr class="tr_light">
                    <td class="form_label">复查意见：</td>
                    <td class="form_content">
                        <sys:code code="${opinionType}" name="opinion" type="select" defaultName=""
                                  sysCodeDetailId="${bean.opinion.id}" disabled="true" id="opinion" isAlowedNull="true"
                                  onChange="changeOpinion()"/>
                    </td>
                </tr>
                <tr class="tr_dark" id="showId1">
                    <td class="form_label">存在问题：</td>
                    <td class="form_content">
                        <form:textarea path="existQuestion" readonly="true" cssClass="input_textarea"/>
                    </td>
                </tr>
            </c:if>

            <tr class="tr_light">
                <td class="form_label">回复内容：</td>
                <td class="form_content">
                    <form:textarea path="replyContent" cssClass="input_textarea"/>
                </td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label">文件附件：</td>
                <td class="form_content">
                        ${uploadButton}
                    <input type="hidden" value="${code}" name="code">
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label">回复人：</td>
                <td class="form_content">
                    <form:input path="replyPerson" cssClass="input_text"/>
                    <form:hidden path="replyUsername"/>
                    <input type="button" value=" " class="button_select"
                           onclick="selectSysPerson(null,'replyPerson')" title="选择回复人"/>
                </td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label">回复日期：</td>
                <td class="form_content">
                    <form:input path="replyDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('replyDate');"/>
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label">接收人：</td>
                <td class="form_content">
                    <form:input path="receivePerson" cssClass="input_text" readonly="true"/>
                    <form:hidden path="receiveUsername"/>
                    <input type="button" value=" " class="button_select"
                           onclick="selectSysPerson(null,'receivePerson')" title="选择接收人"/>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_content" colspan="2" style="text-align: center">
                        <c:if test="${bean.status==STATUS_EDIT||bean.status==STATUS_FIRST_BACK}">
                            <input type="button" value="提交" class="button_confirm" onclick="save(this,'${STATUS_SUBMIT}')">&nbsp;
                            <input type="button" value="保存" class="button_confirm" onclick="save(this,'${STATUS_EDIT}')">&nbsp;
                        </c:if>
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>