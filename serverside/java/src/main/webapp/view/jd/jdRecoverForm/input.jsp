<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            //{name:"year", rule:"validate[required,custom[integer],maxSize[4]"},
            //{name:"orderNo", rule:"validate[required,custom[integer],maxSize[4]"},
            //{name:"dutyDept", rule:"validate[required,maxSize[200]]"},
            //{name:"projectName", rule:"validate[required,maxSize[200]]"},
            {name: "reformBeginDate", rule: "validate[required,custom[date],maxSize[10]"},
            {name: "recoverDate", rule: "validate[required,custom[date],maxSize[10]"},
            {name: "signDept", rule: "validate[required,maxSize[200]]"},
            {name: "signPerson", rule: "validate[required,maxSize[50]]"},
            {name: "signDate", rule: "validate[required,custom[date],maxSize[10]"}
            //{name:"description", rule:"validate[required,maxSize[5000]]"},
            //{name:"status", rule:"validate[required,custom[integer],maxSize[2]"},
        ];
        validateInit(validateCondition, formId);
    });

    //检查时间前后的合法性
    function checkTime() {
        var reformBeginDate = document.getElementById("reformBeginDate");
        var recoverDate = document.getElementById("recoverDate");
        if (dayCompare(reformBeginDate.value, recoverDate.value) == false) {
            showInfoMsg('整改起始时间要小于恢复施工时间！', null);
            return false;
        }
        return true;
    }
    //日期比较
    function dayCompare(startDate, endDate) {
        if ((startDate == "") || (endDate == "")) {
            return false;
        }
        //年份比较
        var startS = startDate.indexOf('-');
        var yearS = startDate.substring(0, startS);
        var startE = endDate.indexOf('-');
        var yearE = endDate.substring(0, startE);
        if ((yearS - yearE) > 0)
            return false;

        //月份比较
        startS++;
        var startS2 = startDate.indexOf('-', startS);
        var monthS = startDate.substring(startS, startS2);

        startE++;
        var startE2 = endDate.indexOf('-', startE);
        var monthE = endDate.substring(startE, startE2);
        if ((yearS - yearE) == 0) {
            if ((monthS - monthE) > 0)
                return false;
        }

        //日期比较
        var dayS = startDate.substring(startS2 + 1);
        var dayE = endDate.substring(startE2 + 1);
        if ((yearS - yearE) == 0 && (monthS - monthE) == 0 && (dayS - dayE) > 0)
            return false;
        return true;
    }

    //保存操作
    function save(status, buttonName) {
        if (!validateForm(formId)) {
            return;
        }
        //时间判断
        if (!checkTime()) {
            return;
        }

        //提交表单
        if (buttonName != "") {
            if (confirm("是否确定执行" + buttonName + "操作？")) {
                saveAjaxData("${ctx}/jdRecoverForm/save.do?stopId=${stopId}&year=${year}&status=" + status, formId);
            }
        } else {
            saveAjaxData("${ctx}/jdRecoverForm/save.do?stopId=${stopId}&year=${year}&status=" + status, formId);
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_title">
                <td colspan="2">上海市建设工程复工通知单</td>
            </tr>
            <tr class="tr_dark">
                <td class="form_td_line" colspan="2">
                    虹口质监（${year}）复字[${bean.orderNo}]号
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">责任主体：</td>
                <td class="form_content">
                    <form:input path="dutyDept" cssClass="input_text_long" readonly="true"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">工程名称：</td>
                <td class="form_content">
                    <form:input path="projectName" cssClass="input_text_long" readonly="true"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">整改起始时间：</td>
                <td class="form_content">
                    <form:input path="reformBeginDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('reformBeginDate');">
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">恢复施工时间：</td>
                <td class="form_content">
                    <form:input path="recoverDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('recoverDate');">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">签发单位：</td>
                <td class="form_content">
                    <form:input path="signDept" cssClass="input_text_long"/>
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
            <tr class="tr_button">
                <td class="form_label"></td>
                <td class="form_content">
                    <input type="button" value="提交" class="button_confirm"
                           onclick="save('${STATUS_SUBMIT}',this.value)">&nbsp;
                    <input type="button" value="保存" class="button_confirm" onclick="save('${STATUS_EDIT}','')">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>