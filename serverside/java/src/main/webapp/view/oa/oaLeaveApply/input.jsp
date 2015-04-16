<%--
  Created by IntelliJ IDEA.
  User: HGR
  Date: 2014/4/23
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "reportPerson", rule: "validate[required,maxSize[25]]"},
            {name: "reportDept", rule: "validate[required,maxSize[50]]"},
            {name: "reportDate", rule: "validate[required,custom[date],maxSize[20]"},
            {name: "durationTime", rule: "validate[required,maxSize[50]]"},
            {name: "cause", rule: "validate[required,maxSize[1000]"},
            {name: "leaderOpinion", rule: "validate[required,maxSize[1000]]"},
            {name: "leaderAuditTime", rule: "validate[required,maxSize[20]]"}
        ];
        validateInit(validateCondition, formId);
        getInfo();
    });

   function getInfo(){
       var reportPerson=$('#reportPerson').val();
        $('#sqr').html(reportPerson);
   }
    //保存操作
    //保存操作
    function save(status, buttonName) {
        if (!validateForm(formId)) {
            return;
        }

        //加入其他业务判断
        if (status == '${STATUS_PASS}')
            if (!checkTime()) return;
        //判断请假天数是否为实数
        var dayCount=document.getElementById("dayCount");
        var reg =/^(0|([1-9]\d*))(\.\d+)?$/.test(dayCount.value);
        if(!reg){
             alert("请假天数输入有误,请重新输入！");
             return;
        }

        //提交表单
        if (buttonName != "") {
            if (confirm("提交之后将不能再修改，确定继续吗？")) {
                saveAjaxData("${ctx}/oaLeaveApply/save.do?status=" + status, formId);
            }
        } else {
            saveAjaxData("${ctx}/oaLeaveApply/save.do?status=" + status, formId);
        }
    }

</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr>
                <td>
                    <fieldset class="form_fieldset" style="width: 90%;margin: 0 auto;display: true;">
                        <legend class="form_legend">请假申请</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_dark">
                                <td class="form_label_right" width="20%">申请部门：</td>
                                <td class="form_content" width="30%">
                                    <input type="text" name="reportDept" id="reportDept" class="input_text"
                                           value="${bean.reportDept}"
                                           readonly="true">
                                    <input type="hidden" name="reportDeptId" id="reportDeptId"
                                           value=""/>
                                    <input type="button" value=" " class="button_select"
                                           onclick="selectSysDept('reportDeptId','reportDept')"
                                           title="点击选择所属单位（部门）">
                                </td>
                                <td class="form_label_right" width="20%">申请人：</td>
                                <td class="form_content" width="30%">
                                    <input type="text" name="reportPerson" id="reportPerson" class="input_text"
                                           value="${bean.reportPerson}" onkeyup="getInfo()"
                                           onmouseup="getInfo()" onmouseover="getInfo()" onpropertychange="getInfo()"
                                           readonly="true">
                                    <input type="hidden" name="reportPersonId" id="reportPersonId"
                                           value=""/>
                                    <input type="button" value=" " class="button_select"
                                           onclick="selectSysPerson('reportPersonId','reportPerson');"
                                           title="点击选择发布人">
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" width="20%">岗位：</td>
                                <td class="form_content" width="30%">
                                    <form:input path="duty" cssClass="input_text"/>
                                </td>
                                <td class="form_label_right" width="20%">申请日期：</td>
                                <td class="form_content" width="30%">
                                    <form:input path="reportDate" cssClass="input_date" readonly="true"/>
                                    <input type="button" class="button_calendar" value=" "
                                           onClick="calendar('reportDate');">
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right" width="20%"> 请假起始时间：</td>
                                <td class="form_content">
                                    <form:input path="durationTime" cssClass="input_text"/>
                                </td>
                                <td class="form_label_right">请假天数：</td>
                                <td class="form_content">
                                    <form:input path="dayCount" cssClass="input_text"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right"><span style="color: red;">通知食堂</span>： </td>
                                <td class="form_content" colspan="3">
                                    <input type="checkbox" name="isSendSms" id="isSendSms" <c:if test="${bean.isSendSms}">checked="checked"</c:if> />
                                    短 信 内 容：<span id="sqr" style="color: #0000ff;"></span> 在 <form:input path="smsTimearea" cssClass="input_text"/> 已 请 假，不 用 准 备 午 餐。
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" width="20%">请假事由：</td>
                                <td class="form_content" colspan="3">
                                    <form:textarea path="cause" cssClass="input_textarea_long"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_border" align="center" colspan="4">
                    <input type="button" value="提交" class="button_confirm"
                           onclick="save('${STATUS_SUBMIT}',this.value)">&nbsp;
                    <input type="button" value="暂存" class="button_confirm" onclick="save('${STATUS_EDIT}','')">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>