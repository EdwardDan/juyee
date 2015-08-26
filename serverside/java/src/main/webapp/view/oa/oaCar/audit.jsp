<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "driverMobile", rule: "validate[custom[phone]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(t, btn) {
        if (!validateForm(formId)) {
            return;
        }

        //修改状态
        if (t == '${STATUS_BRANCH_PASS}') {
            $("#status").val('${STATUS_BRANCH_PASS}');

            $.messager.confirm('系统提示', "确定审核通过吗？通过后将不能修改！", function (r) {
                if (r) {
                    //提交表单
                    saveAjaxData("${ctx}/oaCar/auditSave.do", formId);
                }
            });
        } else if (t == '${STATUS_BRANCH_BACK}') {
            $("#status").val('${STATUS_BRANCH_BACK}');
            $.messager.confirm('系统提示', "确定退回吗？", function (r) {
                if (r) {
                    //提交表单
                    saveAjaxData("${ctx}/oaCar/auditSave.do", formId);
                }
            });
        } else if (t == '${STATUS_MAIN_PASS}') {
            $("#status").val('${STATUS_MAIN_PASS}');

            $.messager.confirm('系统提示', "确定审核通过吗？通过后将不能修改！", function (r) {
                if (r) {
                    //提交表单
                    saveAjaxData("${ctx}/oaCar/auditSave.do", formId);
                }
            });
        } else if (t == '${STATUS_MAIN_BACK}') {
            $("#status").val('${STATUS_MAIN_BACK}');
            $.messager.confirm('系统提示', "确定退回吗？", function (r) {
                if (r) {
                    //提交表单
                    saveAjaxData("${ctx}/oaCar/auditSave.do", formId);
                }
            });
        } else if (t == '${STATUS_CAR_SCHEDULE}') {
            if (document.getElementById("isAgree").checked) {
                if ($("#driverPersonName").val() == '') {
                    showInfoMsg("请选择司机！")
                    return;
                }
            }

            if ($("#car").val() == '') {
                showInfoMsg("请选择车辆！")
                return;
            }
            $("#status").val('${STATUS_CAR_SCHEDULE}');
            $.messager.confirm('系统提示', "调度车辆吗？确定后将不能修改！", function (r) {
                if (r) {
                    //提交表单
                    saveAjaxData("${ctx}/oaCar/auditSave.do", formId);
                }
            });
        }
    }

    function showDriver() {
        if (document.getElementById("isAgree").checked) {
            $("#isAgree").val("true");
            document.getElementById("agreeDriver").style.display = "";
        } else {
            $("#isAgree").val("false");
            document.getElementById("agreeDriver").style.display = "none";
        }
    }

</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="status"/>

    <div class="form_div">
        <fieldset class="form_fieldset">
            <legend class="form_legend">
                车辆申请信息
            </legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label_right" width="15%">申请部门：</td>
                    <td class="form_content">
                            ${bean.applyDept.name}
                    </td>
                    <td class="form_label_right" width="15%">申请人：</td>
                    <td class="form_content" width="35%">
                            ${bean.applyUser.displayName}
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" width="15%">使用车辆日期：</td>
                    <td class="form_content" width="35%">
                        <fmt:formatDate value="${bean.beginTime}" pattern="yyyy-MM-dd"/>
                    </td>
                    <td class="form_label_right" width="15%">用车起止时间：</td>
                    <td class="form_content" width="35%">
                        &nbsp;${startHour} 时 ${startMinute} 分~ ${endHour} 时 ${endMinute} 分
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" width="15%">用车人数：</td>
                    <td class="form_content" colspan="3">
                            ${bean.personNum}
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" width="15%">用车事由：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml> ${bean.useCause}  </sys:toHtml>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" width="15%">目的地：</td>
                    <td class="form_content" colspan="3">
                            ${bean.address}
                    </td>
                </tr>
            </table>
        </fieldset>
        <c:if test="${canKzAudit||canZrAudit||canClddAudit}">
            <fieldset class="form_fieldset">
                <legend class="form_legend">
                    科长审核
                </legend>
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_dark">
                        <td class="form_label_right" width="15%">科长审核意见：</td>
                        <td class="form_content" colspan="3">
                            <c:if test="${canZrAudit}">
                                <c:if test="${bean.status==STATUS_BRANCH_PASS||bean.status==STATUS_MAIN_PASS}">
                                    <sys:toHtml> ${bean.kzAuditOpinion}</sys:toHtml>
                                </c:if>
                            </c:if>
                            <c:if test="${canKzAudit}">
                                <c:if test="${bean.status==STATUS_SUBMIT}">
                                    <form:textarea path="kzAuditOpinion" cssClass="input_textarea_long"/>
                                </c:if>
                            </c:if>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </c:if>

        <c:if test="${canZrAudit||canClddAudit}">
            <c:if test="${bean.status==STATUS_BRANCH_PASS||bean.status==STATUS_MAIN_PASS}">
                <fieldset class="form_fieldset">
                    <legend class="form_legend">
                        办公室主任审核
                    </legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
                            <td class="form_label_right" width="15%">办公室主任审核意见：</td>
                            <td class="form_content" colspan="3">
                                <c:if test="${bean.status==STATUS_BRANCH_PASS}">
                                    <form:textarea path="zrAuditOpinion" cssClass="input_textarea_long"/>
                                </c:if>
                                <c:if test="${bean.status==STATUS_MAIN_PASS}">
                                    ${bean.zrAuditOpinion}
                                </c:if>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </c:if>
        </c:if>
        <c:if test="${canClddAudit}">
            <c:if test="${bean.status==STATUS_MAIN_PASS}">
                <fieldset class="form_fieldset">
                    <legend class="form_legend">
                        车辆调度
                    </legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_dark">
                            <td class="form_label_right" width="15%">拟派车辆：</td>
                            <td class="form_content" colspan="3">
                                <select id="car" name="car" class="input_text">
                                    <option value="" selected></option>
                                    <c:forEach var="carIn" items="${carList}">
                                        <option value="${carIn.id}" <c:if
                                                test="${bean.car.id==carIn.id}">selected </c:if>>${carIn.name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_content" colspan="4">
                                <input type="checkbox" id="isAgree" name="isAgree"
                                       <c:if test="${not empty bean.driverPerson}">checked </c:if>
                                       onchange="showDriver()">是否拟派司机
                            </td>
                        </tr>
                        <tr id="agreeDriver" class="tr_dark"
                            <c:if test="${empty bean.driverPerson}">style="display: none"</c:if>>
                            <td class="form_label_right" width="15%">司机：</td>
                            <td class="form_content" width="35%">
                                <input type="text" name="driverPersonName" id="driverPersonName" class="input_text"
                                       value="${bean.driverPerson.name}"
                                       readonly="true"/>
                                <input type="hidden" name="driverPersonId" id="driverPersonId"
                                       value="${bean.driverPerson.id}"/>
                                <input type="button" value=" " class="button_select"
                                       onclick="selectSysPersonDriver('driverPersonId','driverPersonName')"
                                       title="点击选择驾驶员">
                            </td>
                            <td class="form_label_right" width="15%">电话：</td>
                            <td class="form_content" width="35%">
                                <form:input path="driverMobile" cssClass="input_text"/>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </c:if>
        </c:if>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_button">
                <td style="text-align: center" colspan="4">
                    <c:if test="${bean.status==STATUS_BRANCH_PASS}">
                        <input type="button" value="审核通过" class="button_normal_long"
                               onclick="save('${STATUS_MAIN_PASS}',this)">&nbsp;
                        <input type="button" value="退回修改" class="button_normal_long"
                               onclick="save('${STATUS_MAIN_BACK}',this)">&nbsp;
                    </c:if>

                    <c:if test="${bean.status==STATUS_SUBMIT}">
                        <input type="button" value="审核通过" class="button_normal_long"
                               onclick="save('${STATUS_BRANCH_PASS}',this)">&nbsp;
                        <input type="button" value="退回修改" class="button_normal_long"
                               onclick="save('${STATUS_BRANCH_BACK}',this)">&nbsp;
                    </c:if>
                    <c:if test="${bean.status==STATUS_MAIN_PASS}">
                        <input type="button" value="确定" class="button_normal"
                               onclick="save('${STATUS_CAR_SCHEDULE}',this)">&nbsp;
                    </c:if>
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>