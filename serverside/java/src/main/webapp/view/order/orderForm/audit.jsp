<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "jdTaskCode", rule: "validate[required,maxSize[50]]"},
            {name: "acceptUserName", rule: "validate[required]"},
            {name: "acceptDatetime", rule: "validate[required]"},
//            {name:"workGroup", rule:"validate[required]"},
            {name: "acceptOpinion", rule: "validate[required]"}
        ];
        validateInit(validateCondition, formId);
        selectTuiHui();
    });

    //保存操作
    function save(btn, flag) {
        if (!validateForm(formId)) {
            return;
        }
        if (flag == 1) {
            var sid = $("#acceptOpinion").val();
            var checkOK = true;
            if ("${ORDER_FORM_DEPLOY_OPINION_ARRANGE}" == sid) {
                if ($("#jdManagerName").val() == "") {
                    checkOK = false;
                    showInfoMsg("请选择指定监督人员");
                }
            } else if ("${ORDER_FORM_DEPLOY_OPINION_NOTARRANGE}" == sid) {
                $("#jdManagerName").val("");
                $("#jdManager").val("");
                if ($("#acceptOpinionDesc").val() == "") {
                    checkOK = false;
                    showInfoMsg("请输入不安排监督的审核意见");
                }
            } else if ("${ORDER_FORM_DEPLOY_OPINION_BACK}" == sid) {
                $("#jdManagerName").val("");
                $("#jdManager").val("");
                if ($("#acceptOpinionDesc").val() == "") {
                    checkOK = false;
                    showInfoMsg("请输入退回意见");
                }
                if ($("#duanxin").val() == "") {
                    checkOK = false;
                    showInfoMsg("请输入短信内容");
                }
            }

            if (checkOK) {
                $.messager.confirm('系统提示', '提交后不能再修改，确定吗?', function (r) {
                    if (r) {
                        if ("${ORDER_FORM_DEPLOY_OPINION_ARRANGE}" == sid) {
                            $("#orderStatus").val("${ORDER_FORM_STATUS_ACCEPT}");

                        } else if ("${ORDER_FORM_DEPLOY_OPINION_NOTARRANGE}" == sid) {
                            $("#orderStatus").val("${ORDER_FORM_STATUS_ACCEPT}");

                        }
                        if ("${ORDER_FORM_DEPLOY_OPINION_BACK}" == sid) {
                            $("#orderStatus").val("${ORDER_FORM_STATUS_BACK}");

                        }
                        submitForm();
                    }
                });
            }
        }
    }
    //提交表单
    function submitForm() {
        saveAjaxData("${ctx}/orderForm/auditSave.do", formId);
    }
    // modify by shaxiaojie 2014/2/12
    // 修改：退回（不安排监督）时有短信发送，未提供短信输入框，内容固定。
    function selectTuiHui() {
        var sid = $("#acceptOpinion").val();
        if ("${ORDER_FORM_DEPLOY_OPINION_BACK}" == sid) {
            $("#duanxinTR").show();
        } else {
            $("#duanxinTR").hide();
        }
    }
    function initSysUser() {
        $("#jdManagerName").val("");
        $("#jdManager").val("");
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <input type="hidden" name="orderStatus" id="orderStatus" value="${bean.orderForm.orderStatus.id}">
    <input type="hidden" name="acceptUser" id="acceptUser" value="${bean.acceptUser.id}">

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right" width="15%">受理人：</td>
                <td class="form_content" width="35%">
                    &nbsp;${bean.acceptUserName}
                    <form:hidden path="acceptUserName"/>
                </td>
                <td class="form_label_right" width="15%">受理时间：</td>
                <td class="form_content" width="35%">
                    &nbsp;<fmt:formatDate value="${bean.acceptDatetime}" pattern="yyyy-MM-dd HH:mm"/>
                    <form:hidden path="acceptDatetime"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">监督人员：</td>
                <td class="form_content">
                    <input type="text" name="jdManagerName" id="jdManagerName" value="${jdManagerName}"
                           class="input_text" style="width: 80px" readonly="true"/>
                    <input type="hidden" name="jdManager" id="jdManager" value="${jdManager}"/>
                    <input type="button" value=" " class="button_select"
                           onclick="initSysUser();multiSelectSysUser('','jdManager','jdManagerName');" title="点击选择人员">
                        <%--<select name="workGroup" id="workGroup" class="form_select">--%>
                        <%--<option value="">===请选择===</option>--%>
                        <%--<c:forEach items="${groupList}" var="group">--%>
                        <%--<option value="${group.id}"--%>
                        <%--<c:if test="${group.id==bean.workGroup.id}">selected</c:if>>${group.name}</option>--%>
                        <%--</c:forEach>--%>
                        <%--</select>--%>
                </td>
                <td class="form_label_right">监督任务书编号：</td>
                <td class="form_content">
                    <input type="text" name="jdTaskCode" id="jdTaskCode" value="${bean.orderForm.jdTaskCode}"
                           class="input_text">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">受理意见：</td>
                <td class="form_content" colspan="3">
                    <sys:code code="${ORDER_FORM_DEPLOY_OPINION}" onChange="selectTuiHui()" name="acceptOpinion"
                              type="select"
                              defaultName=""
                              sysCodeDetailId="${bean.acceptOpinion.id}" disabled="" id="acceptOpinion"
                              isAlowedNull="false"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">受理备注：</td>
                <td class="form_content" colspan="3">
                    <form:textarea path="acceptOpinionDesc" cssClass="input_textarea_long"/>
                </td>
            </tr>
                <%--// modify by shaxiaojie 2014/2/12--%>
                <%--// 修改：退回（不安排监督）时有短信发送，未提供短信输入框，内容固定。--%>
            <tr id="duanxinTR" class="tr_light">
                <td class="form_label_right">退回原因：</td>
                <td class="form_content" colspan="3">
                    <textarea class="input_textarea_long" id="duanxin" name="duanxin"></textarea>
                </td>
            </tr>

            <tr class="tr_button">
                <td class="form_border" colspan="4">
                    <c:if test="${isAudit}">
                        <input type="button" value="提交" class="button_confirm" onclick="save(this,1)">&nbsp;
                        <%--<input type="button" value="保存" class="button_confirm" onclick="save(this,0)">&nbsp;--%>
                    </c:if>
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>