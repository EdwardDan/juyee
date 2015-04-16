<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "projectName", rule: "validate[required,maxSize[200]]"},
            {name: "formFont", rule: "validate[required,maxSize[50]]"},
            {name: "formCode", rule: "validate[required,maxSize[50]]"},
            {name: "unitName", rule: "validate[required,maxSize[200]]"},
            {name: "stopTime", rule: "validate[required,maxSize[30]]"},
            {name: "signDate", rule: "validate[required,custom[date],maxSize[10]"},
            {name: "checkPerson", rule: "validate[required,maxSize[50]]"},
            {name: "signPerson", rule: "validate[required,maxSize[50]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        $("#stopTime").val($("#stopTime").val() + ":00:00.0");
        //提交表单
        saveAjaxData("${ctx}/workerStopForm/save.do", formId);
    }

    //选择日历
    function calendarStop(objName) {
        var json = "";
        json += "dateFmt:'yyyy-MM-dd HH'";
        if (objName != null && objName != "") {
            if (json != "") {
                json = "el:'" + objName + "'," + json;
            } else {
                json = "el:'" + objName + "'";
            }
        }
        if (json != "") json = "{" + json + "}";
        WdatePicker(eval("(" + json + ")"));
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label_right" width="15%">工程名称：</td>
                <td class="form_content" width="45%">
                    <form:input path="projectName" cssClass="input_text_long"/>
                </td>
                <td class="form_label_right" width="5%">字：</td>
                <td class="form_content">
                    <form:input path="formFont" cssClass="input_text" cssStyle="width: 70%;"/>
                </td>
                <td class="form_label_right" width="5%">号：</td>
                <td class="form_content">
                    <form:input path="formCode" cssClass="input_text" cssStyle="width: 70%;"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">责任主体：</td>
                <td class="form_content" colspan="5">
                    <form:input path="unitName" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr>
                <td colspan="6" align="center">
                    <br>
                    <table cellpadding="0" cellspacing="0" class="table_thin_line_center" border="1"
                           style="width: 90%;">
                        <tr class="tr_header">
                            <td width="40%">存在问题</td>
                            <td width="60%">违反法律、法规、强制性标准、规范、标准、<br>规范性文件的名称</td>
                        </tr>
                        <tr class="tr_dark">
                            <td>未取得施工许可证擅自施工。</td>
                            <td align="left">
                                □《上海市建筑市场管理条例》第三十一条第三款；<br>
                                □《建筑工程施工许可管理办法》第三条第一款。
                            </td>
                        </tr>
                    </table>
                    <br>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">停工时间：</td>
                <td class="form_content" colspan="5">
                    <input type="text" id="stopTime" name="stopTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.stopTime}" pattern="yyyy-MM-dd HH"/>"
                           readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendarStop('stopTime')">
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">签发日期：</td>
                <td class="form_content" colspan="5">
                    <form:input path="signDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('signDate');">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">检查人员：</td>
                <td class="form_content" colspan="5">
                    <form:input path="checkPerson" cssClass="input_text"/>
                    <input type="hidden" id="checkId" name="checkId" value="">
                    <input type="button" class="button_select" title="点击选择人员"
                           onclick="selectSysPerson('checkId','checkPerson')" value="">
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">签发人：</td>
                <td class="form_content" colspan="5">
                    <form:input path="signPerson" cssClass="input_text"/>
                    <input type="hidden" id="signId" name="signId" value="">
                    <input type="button" class="button_select" title="点击选择人员"
                           onclick="selectSysPerson('signId','signPerson')" value="">
                </td>
            </tr>

            <tr class="tr_button">
                <td class="form_border" colspan="6" align="center">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>