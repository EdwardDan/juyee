<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            //{name:"flowCode", rule:"validate[required,maxSize[10]]"},
            //{name:"jdTaskCode", rule:"validate[required,maxSize[50]]"},
            //{name:"dwgcCode", rule:"validate[required,maxSize[50]]"},
            //{name:"customCode", rule:"validate[required,maxSize[50]]"},
            //{name:"dwgcName", rule:"validate[required,maxSize[200]]"},
            //{name:"projectType", rule:"validate[required,maxSize[50]]"},
            //{name:"structType", rule:"validate[required,maxSize[50]]"},
            //{name:"dwgcArea", rule:"validate[required,custom[number],maxSize[15]"},
            //{name:"dwgcMoney", rule:"validate[required,custom[number],maxSize[15]"},
            //{name:"upCs", rule:"validate[required,maxSize[10]]"},
            //{name:"downCs", rule:"validate[required,maxSize[10]]"},
            //{name:"ts", rule:"validate[required,maxSize[50]]"},
            //{name:"proSchedule", rule:"validate[required,maxSize[50]]"},
            //{name:"changetime", rule:"validate[required,maxSize[7]]"},
            //{name:"synDatetime", rule:"validate[required,maxSize[7]]"},
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //加入其他业务判断
//        if ($('#name').val() == '') {
//            showInfoMsg('请输入姓名！',null);
//            return;
//        }

        //提交表单
        saveAjaxData("${ctx}/excelJdDwgc/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <%--<tr class="tr_light">--%>
                <%--<td class="form_label">流转编号：</td>--%>
                <%--<td class="form_content">--%>
                    <%--<form:input path="flowCode" cssClass="input_text"/>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <tr class="tr_dark">
                <td class="form_label">监督任务书编号：</td>
                <td class="form_content">
                    <form:input path="jdTaskCode" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">单位工程编号：</td>
                <td class="form_content">
                    <form:input path="dwgcCode" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">自定义单位工程编号：</td>
                <td class="form_content">
                    <form:input path="customCode" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">单位工程名称：</td>
                <td class="form_content">
                    <form:input path="dwgcName" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">工程类型：</td>
                <td class="form_content">
                    <form:input path="projectType" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">结构类型：</td>
                <td class="form_content">
                    <form:input path="structType" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">建筑面积：</td>
                <td class="form_content">
                    <form:input path="dwgcArea" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">工程造价：</td>
                <td class="form_content">
                    <form:input path="dwgcMoney" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">地上层数：</td>
                <td class="form_content">
                    <form:input path="upCs" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">地下层数：</td>
                <td class="form_content">
                    <form:input path="downCs" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">台数：</td>
                <td class="form_content">
                    <form:input path="ts" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">工程进度：</td>
                <td class="form_content">
                    <form:input path="proSchedule" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">变化时间：</td>
                <td class="form_content">
                    <input type="text" name="changetime" id="changetime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.changetime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                           readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('changetime','all')">

                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">同步日期：</td>
                <td class="form_content">
                    <input type="text" name="synDatetime" id="synDatetime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.synDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                           readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('synDatetime','all')">

                </td>
            </tr>

            <tr class="tr_button">
                <td class="form_label"></td>
                <td class="form_content">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>