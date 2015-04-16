<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "title", rule: "validate[required,maxSize[200]]"},
            {name: "beginDate", rule: "validate[required,custom[date],maxSize[20]"},
            {name: "endDate", rule: "validate[required,custom[date],maxSize[20]"},
            {name: "duration", rule: "validate[required,maxSize[50]]"},
            {name: "reportPerson", rule: "validate[required,maxSize[50]]"},
            {name: "method", rule: "validate[required,maxSize[200]]"},
            {name: "fee", rule: "validate[required,maxSize[100]]"},
            {name: "studyTarget", rule: "validate[required,maxSize[2000]"},
            {name: "studyContent", rule: "validate[required,maxSize[2000]"},
            {name: "reportDate", rule: "validate[required,custom[date],maxSize[7]"},
            {name: "status", rule: "validate[required,custom[integer],maxSize[2]"}
        ];
        validateInit(validateCondition, formId);
    });


    (function ($) {
        $.fn.getDistanceDay = function (dateBegin, dateEnd) {
            var sDate = new Date(dateBegin);
            var eDate = new Date(dateEnd);
            if (eDate.getTime() >= sDate.getTime()) {
                var fen = ((eDate.getTime() - sDate.getTime()) / 1000) / 60;
                var distance = parseInt(fen / (24 * 60)); //相隔distance天
                return distance + "天";
            } else {
                showInfoMsg("开始日期不小于结束日期，请重新输入！");
                return;
            }
            return;
        };
    })(jQuery);


    function getDuration() {
        var beginDate = $("#beginDate").val();
        var endDate = $("#endDate").val();
        if (beginDate == '' || beginDate == null) {
            showInfoMsg("开始时间不能为空！");
            return;
        }
        else if (endDate == '' || endDate == null) {
            showInfoMsg("结束时间不能为空！");
            return;
        } else if ((beginDate != '' || beginDate != null) && (endDate != '' || endDate != null)) {
            $('#duration').val($.fn.getDistanceDay(beginDate, endDate));
        }
    }
    //提交操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        $('#oaExpertiseUserId').val(getSelectValues(document.getElementById("oaExpertiseUser")));

        //提交表单
        if (confirm("提交之后将不能再修改，确定继续吗？")) {
            saveAjaxData("${ctx}/oaExpertise/save.do?status=${STATUS_SUBMIT}", formId);
        }
    }
    //保存操作
    function tempSave(btn) {
        if (!validateForm(formId)) {
            return;
        }
        $('#oaExpertiseUserId').val(getSelectValues(document.getElementById("oaExpertiseUser")));
        saveAjaxData("${ctx}/oaExpertise/save.do?status=${STATUS_EDIT}", formId);
    }
</script>

<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right">主题：</td>
                <td class="form_content" colspan="3">
                    <form:input path="title" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">学习时间：</td>
                <td class="form_content">
                    <form:input path="beginDate" id="beginDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('beginDate');"
                           onchange="getDuration()">
                    ~
                    <form:input path="endDate" cssClass="input_date" readonly="true" onchange="getDuration()"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('endDate');">
                </td>
                <td class="form_label_right">学习时长：</td>
                <td class="form_content">
                    <form:input path="duration" cssClass="input_text" readonly="true"/>
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right">责任人：</td>
                <td class="form_content">
                    <input type="text" name="reportPerson" id="reportPerson" class="input_text"
                           value="${bean.reportPerson}" readonly="true">
                    <input type="hidden" name="reportPersonId" id="reportPersonId"
                           value=""/>
                    <input type="button" value=" " class="button_select"
                           onclick="selectSysPerson('reportPersonId','reportPerson')"
                           title="点击选择提出人">
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">措施与方法：</td>
                <td class="form_content">
                    <form:input path="method" cssClass="input_text_long" cssStyle="width: 80%"/>
                </td>

                <td class="form_label_right">费用：</td>
                <td class="form_content">
                    <form:input path="fee" cssClass="input_text"/>
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right">参加人员：</td>
                <td class="form_content" colspan="3">
                    <select multiple="multiple" name="oaExpertiseUser" id="oaExpertiseUser"
                            style="width:150px;height:110px;">
                        <c:forEach items="${bean.oaExpertiseUsers}" var="oaExpertiseUser" varStatus="status">
                        <option value="${oaExpertiseUser.user.id}">${oaExpertiseUser.user.displayName}</option>
                        </c:forEach>
                     </select>
                            <input type="hidden" id="oaExpertiseUserId" name="oaExpertiseUserId" value=""/>
                            <input type="button" value="" class="button_select_add"
                                   onclick="multiSelectSysUser('oaExpertiseUser','oaExpertiseUserId','')"
                                   title="点击添加参加人员"/>
                            <input type="button" value="" class="button_select_remove"
                                   onclick="removeMultiSelectOpt('oaExpertiseUser','oaExpertiseUserId','')"
                                   title="点击移除参加人员"/>
                </td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label_right">学习目标：</td>
                <td class="form_content" colspan="3">
                    <form:textarea path="studyTarget" cssClass="input_textarea_long" cssStyle="width: 91%"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">学习内容：</td>
                <td class="form_content" colspan="3">
                    <form:textarea path="studyContent" cssClass="input_textarea_long" cssStyle="width: 91%"/>
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right" nowrap>学习附件：</td>
                <td class="form_content" colspan="3">&nbsp;
                        ${uploadButton}
                </td>
            </tr>

            <tr class="tr_button" align="center">
                <td class="form_border" colspan="4">
                    <input type="button" value="提交" class="button_confirm"
                           onclick="save(this)">&nbsp;
                    <input type="button" value="暂存" class="button_confirm"
                           onclick="tempSave(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>