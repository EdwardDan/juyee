<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "opinion", rule: "validate[required]"},
            {name: "limitDate", rule: "validate[required]"},
            {name: "signUsername", rule: "validate[required]"},
            {name: "signDate", rule: "validate[required]"},
            {name: "existQuestion", rule: "validate[required]"}
        ];
        if (${bean.status==STATUS_BACK}) {
            document.getElementById("opinion").disabled = 'true';
        }
        validateInit(validateCondition, formId);
        changeOpinion();
    });

    //保存操作
    function save(btn, stat) {
        if (!validateForm(formId)) {
            return;
        }
        //
        if ('${STATUS_FIRST_PASS}' == stat) {
            $.messager.confirm('系统提示', '预审通过后不能再修改，确定吗?', function (r) {
                if (r) {
                    $("#status").val(${STATUS_FIRST_PASS});
                    saveDate(btn);
                }
            });
            //
        } else if ('${STATUS_FIRST_BACK}' == stat) {
            $.messager.confirm('系统提示', '预审退回后不能再修改，确定吗?', function (r) {
                if (r) {
                    $("#status").val(${STATUS_FIRST_BACK});
                    saveDate(btn);
                }
            });
            //
        } else if ('${STATUS_BACK}' == stat) {

            $.messager.confirm('系统提示', '审核通过后不能再修改，确定吗?', function (r) {
                if (r) {
                    $("#status").val(${STATUS_BACK});
                    saveDate(btn);
                }
            });
        }
    }

    function saveDate(btn) {
        disableBtn(btn);
        //提交表单
        saveAjaxData("${ctx}/jdReformReply/saveAduit.do", formId);
    }

    function checkNeedInput() {

        var passId = "${opinionPass}";
        var v = $("#opinion").val();
        return (v != passId);
    }

    //复查意见显示
    function changeOpinion() {
        if (checkNeedInput()) {
            $("#showId1").show();
            $("#showId2").show();
            if (${bean.status==STATUS_SUBMIT}) {
                document.getElementById("buttonTuiH").style.display = "";
                document.getElementById("buttonFirstPass").style.display = "none";
            }
            if (${bean.status==STATUS_FIRST_PASS}) {
                document.getElementById("buttonPass").style.display = "";
            }

        } else {
            $("#showId1").hide();
            $("#showId2").hide();
            if (${bean.status==STATUS_SUBMIT}) {
                document.getElementById("buttonTuiH").style.display = "none";
                document.getElementById("buttonFirstPass").style.display = "";
            }
            if (${bean.status==STATUS_FIRST_PASS}) {
                document.getElementById("buttonPass").style.display = "";
            }
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <input type="hidden" value="${bean.status}" name="status" id="status"/>
    <input type="hidden" value="${stopFormId}" id="stopFormId" name="stopFormId"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <c:if test="${bean.status== STATUS_FIRST_PASS ||bean.status==STATUS_SUBMIT}">
                <tr class="tr_light">
                    <td class="form_label">回复内容：</td>
                    <td class="form_content">
                        <form:textarea path="replyContent" readonly="true" cssClass="input_textarea"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label">回复人：</td>
                    <td class="form_content">
                            ${bean.replyUsername}
                    </td>
                </tr>
            </c:if>
            <tr class="tr_light">
                <td class="form_label">复查意见：</td>
                <td class="form_content">
                    <sys:code code="${opinionType}" name="opinion" type="select" defaultName=""
                              sysCodeDetailId="${bean.opinion.id}" disabled="" id="opinion" isAlowedNull="false"
                              onChange="changeOpinion()"/>
                </td>
            </tr>
            <tr class="tr_dark" id="showId1">
                <td class="form_label">存在问题：</td>
                <td class="form_content">
                    <form:textarea path="existQuestion" cssClass="input_textarea"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">文件附件：</td>
                <td class="form_content">
                        ${uploadButton}
                    <input type="hidden" value="${code}" name="code">
                </td>
            </tr>
            <tr class="tr_dark" id="showId2">
                <td class="form_label">整改期限：</td>
                <td class="form_content">
                    <form:input path="limitDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('limitDate');">
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label">签发人：</td>
                <td class="form_content">
                    <form:input path="signUsername" cssClass="input_text" readonly="true"/>
                    <input type="hidden" name="signPerson" value="${bean.signPerson}"/>
                    <input type="button" value=" " class="button_select"
                           onclick="selectSysPerson('signPerson','signUsername');" title="点击选择人员">

                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">签发日期：</td>
                <td class="form_content">
                    <form:input path="signDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('signDate');">
                </td>
            </tr>

            <tr class="tr_button">
                <td class="form_content" colspan="2" style="text-align: center">
                    <c:if test="${bean.status==STATUS_SUBMIT}">

                        <input type="button" value="预审通过" id="buttonFirstPass" class="button_normal_long"
                               onclick="save(this,'${STATUS_FIRST_PASS}')">&nbsp;
                        <input type="button" value="预审退回" id="buttonTuiH" name="buttonTuiH" class="button_normal_long"
                               onclick="save(this,'${STATUS_FIRST_BACK}')">&nbsp;
                    </c:if>

                    <c:if test="${bean.status==STATUS_FIRST_PASS}">
                        <input type="button" value="复核通过" id="buttonPass" class="button_normal_long"
                               onclick="save(this,'${STATUS_BACK}')">&nbsp;
                    </c:if>
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>