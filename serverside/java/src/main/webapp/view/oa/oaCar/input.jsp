<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "applyDept", rule: "validate[required]"},
            {name: "applyUser", rule: "validate[required]"},
            {name: "useDate", rule: "validate[required]"},
            {name: "personNum", rule: "validate[required,custom[integer]]"},
            {name: "address", rule: "validate[required]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(t, btn) {
        if (!validateForm(formId)) {
            return;
        }
        //修改状态
        if (t == '1') {
            $("#status").val(1);
        } else if (t == '2') {
            $("#status").val(2);
        } else if (t == '3') {
            $("#status").val(3);
        } else if (t == '4') {
            $("#status").val(4);
        } else if (t == '5') {
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
            $("#status").val(5);
        } else if (t == '6') {
            $("#status").val(6);
        }

        $("#beginTime").val($("#useDate").val() + " " + $("#beginHour").val() + ":" + $("#beginMin").val() + ":00.0");
        $("#endTime").val($("#useDate").val() + " " + $("#endHour").val() + ":" + $("#endMin").val() + ":00.0");

        //提交表单
        saveAjaxData("${ctx}/oaCar/save.do", formId);
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
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right" width="15%">申请部门：</td>
                <td class="form_content">
                    <input type="text" name="applyDeptName" id="applyDeptName" class="input_datetime"
                           value="${bean.applyDept.name}"
                           readonly="true"/>
                    <input type="hidden" name="applyDeptId" id="applyDeptId" value="${bean.applyDept.id}"/>
                    <input type="button" value=" " class="button_select"
                           onclick="selectSysDept('applyDeptId','applyDeptName')" title="点击选择申请部门">
                </td>
                <td class="form_label_right" width="15%">申请人：</td>
                <td class="form_content" width="35%">
                    <input type="text" name="applyUserName" id="applyUserName" class="input_text"
                           value="${bean.applyUser.displayName}" readonly="true"/>
                    <input type="hidden" name="applyUserId" id="applyUserId" value="${bean.applyUser.id}"/>
                    <input type="button" value=" " class="button_select"
                           onclick="selectSysUser('applyUserId','applyUserName');" title="点击申请人">
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" width="15%">使用车辆日期：</td>
                <td class="form_content" width="35%">
                    <input type="text" name="useDate" id="useDate" class="input_date"
                           value="<fmt:formatDate value="${bean.beginTime}" pattern="yyyy-MM-dd"/>"
                           readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('useDate')">
                </td>
                <td class="form_label_right" width="15%">用车起止时间：</td>
                <td class="form_content" width="35%">
                    <select name="beginHour" id="beginHour" style="width: 40px">${startHour}</select>时
                    <select name="beginMin" id="beginMin" style="width: 40px">${startMinute}<</select>分~
                    <select name="endHour" id="endHour" style="width: 40px">${endHour}<</select>时
                    <select name="endMin" id="endMin" style="width: 40px">${endMinute}<</select>分

                    <input type="hidden" name="beginTime" id="beginTime" class="input_date" value=""/>
                    <input type="hidden" name="endTime" id="endTime" class="input_date" value=""/>

                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" width="15%">用车人数：</td>
                <td class="form_content" colspan="3">
                    <form:input path="personNum" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" width="15%">用车事由：</td>
                <td class="form_content" colspan="3">
                    <form:textarea path="useCause" cssClass="input_textarea_long"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" width="15%">目的地：</td>
                <td class="form_content" colspan="3">
                    <form:input path="address" cssClass="input_text_long"/>
                </td>
            </tr>
            <c:if test="${bean.status=='2'|| bean.status=='3'}">
                <tr class="tr_dark">
                    <td class="form_label_right" width="15%">科长审核意见：</td>
                    <td class="form_content" colspan="3">
                        <form:textarea path="kzAuditOpinion" cssClass="input_textarea_long"/>
                    </td>
                </tr>
            </c:if>
        </table>
        <c:if test="${bean.status=='3'||bean.status=='5'}">
            <fieldset class="form_fieldset">
                <legend class="form_legend">
                    办公室主任审核
                </legend>
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_light">
                        <td class="form_label_right" width="15%">办公室主任审核意见：</td>
                        <td class="form_content" colspan="3">
                            <form:textarea path="zrAuditOpinion" cssClass="input_textarea_long"/>
                        </td>
                    </tr>
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
                            <input type="checkbox" id="isAgree" name="isAgree" onchange="showDriver()">是否拟派司机
                        </td>
                    </tr>
                    <tr id="agreeDriver" class="tr_dark" style="display: none">
                        <td class="form_label_right" width="15%">司机：</td>
                        <td class="form_content" width="35%">
                            <input type="text" name="driverPersonName" id="driverPersonName" class="input_text"
                                   value="${bean.driverPerson.name}"
                                   readonly="true"/>
                            <input type="hidden" name="driverPersonId" id="driverPersonId"
                                   value="${bean.driverPerson.id}"/>
                            <input type="button" value=" " class="button_select"
                                   onclick="selectSysPersonDriver('driverPersonId','driverPersonName')" title="点击选择驾驶员">
                        </td>
                        <td class="form_label_right" width="15%">电话：</td>
                        <td class="form_content" width="35%">
                            <form:input path="driverMobile" cssClass="input_text"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </c:if>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_button">
                <td style="text-align: center" colspan="4">
                    <c:if test="${bean.status==3 ||bean.status==5}">
                        <input type="button" value="审核通过" class="button_normal_long" onclick="save('5',this)">&nbsp;
                        <input type="button" value="退回修改" class="button_normal_long" onclick="save('6',this)">&nbsp;
                    </c:if>

                    <c:if test="${bean.status==2}">
                        <input type="button" value="审核通过" class="button_normal_long" onclick="save('3',this)">&nbsp;
                        <input type="button" value="退回修改" class="button_normal_long" onclick="save('4',this)">&nbsp;
                    </c:if>
                    <c:if test="${bean.status==1|| empty bean.status || bean.status==4 || bean.status==6}">
                        <input type="button" value="提交" class="button_confirm" onclick="save('2',this)">&nbsp;
                        <input type="button" value="暂存" class="button_confirm" onclick="save('1',this)">&nbsp;
                    </c:if>
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>