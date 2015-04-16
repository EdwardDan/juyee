<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"bjbh", rule:"validate[required,maxSize[50]]"},
            {name:"checkAddress", rule:"validate[required,maxSize[200]]"},
            {name:"checkDate", rule:"validate[required,custom[date],maxSize[20]"},
            {name:"startTime", rule:"validate[required,maxSize[10]]"},
            {name:"endTime", rule:"validate[required,maxSize[10]]"},
            {name:"checkPerson", rule:"validate[required,maxSize[50]]"},
            {name:"checkContent", rule:"validate[required,maxSize[500]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        var beginHour = $("#beginHour").val();
        var endHour = $("#endHour").val();
        var beginMinute = $("#beginMinute").val();
        var endMinute = $("#endMinute").val();
        if (endHour < beginHour || endHour == beginHour && endMinute <= beginMinute) {
            showInfoMsg("结束时间必须大于开始时间！", null);
            return false;
        }
        //加入其他业务判断
//        if ($('#name').val() == '') {
//            showInfoMsg('请输入姓名！',null);
//            return;
//        }

        //提交表单
        saveAjaxData("${ctx}/workerInspectRecord/save.do", formId);
    }
    function getProjectInfo(btn) {
        var bjbh = $("#bjbh").val();
        if (bjbh == "") {
            showInfoMsg("请输入报建编号!");
            return;
        }
        var url ="${ctx}/workerInspectRecord/getProjectInfo.do?bjbh="+bjbh;
        var data = getAjaxData(url);
        $("#checkAddress").val(data.buildAddress);
        $("#fr").val(data.faren);
        $("#tel").val(data.tel);
    }
</script>
<style type="text/css">
    .input_textarea_longs {
        font-size: 12px;
        border: 1px solid #b8b6b9;
        color: #007DBC;
        background-color: #FFFFFF;
        width: 500px;
        height: 200px;
    }
</style>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right">报建编号：</td>
                <td class="form_content" colspan="3">
                    <form:input path="bjbh" cssClass="input_text"/>
                    <input type="button" value="获取" class="button_all" onclick="getProjectInfo(this)">
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">检查地点：</td>
                <td class="form_content" colspan="3">
                    <form:input path="checkAddress" cssClass="input_text" cssStyle="width:100%"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">检查日期：</td>
                <td class="form_content">
                    <form:input path="checkDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('checkDate');">
                </td>
                <td class="form_label">检查起止时间：</td>
                <td align="left" nowrap>
                    <select name="beginHour" id="beginHour" size="1" title="请选择开始时间（时）">
                            ${beginHourSelectOptions}
                    </select>时
                    <select name="beginMinute" id="beginMinute" size="1" title="请选择开始时间（分）">
                            ${beginMinuteSelectOptions}
                    </select>分&nbsp;~
                    <select name="endHour" id="endHour" size="1" title="请选择结束时间（时）">
                            ${endHourSelectOptions}
                    </select>时
                    <select name="endMinute" id="endMinute" size="1" title="请选择结束时间（分）">
                            ${endMinuteSelectOptions}
                    </select>分
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">当事人：</td>
                <td class="form_content">
                    <form:input path="currentPerson" cssClass="input_text"/>
                </td>
                <td class="form_label_right">地址：</td>
                <td class="form_content">
                    <form:input path="address" cssClass="input_text" cssStyle="width:100%"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">法定代表人：</td>
                <td class="form_content">
                    <form:input path="fr" cssClass="input_text"/>
                </td>
                <td class="form_label_right">电话：</td>
                <td class="form_content">
                    <form:input path="tel" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">检查人员：</td>
                <td class="form_content">
                    <form:input path="checkPerson" cssClass="input_text"/>
                </td>
                <td class="form_label_right">记录人：</td>
                <td class="form_content">
                    <form:input path="recordPerson" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">现场检查情况：</td>
                <td class="form_content" colspan="3">
                     <form:textarea path="checkContent" cssClass="input_textarea_longs"
                                     cssStyle="width:100%" />
                </td>
            </tr>
            <%--<tr class="tr_dark">--%>
                <%--<td class="form_label_right">是否来源手持终端：</td>--%>
                <%--<td class="form_content">--%>
                    <%--<form:checkbox path="isFromAndroid" value="1"/>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <tr>
                <td colspan="4">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>