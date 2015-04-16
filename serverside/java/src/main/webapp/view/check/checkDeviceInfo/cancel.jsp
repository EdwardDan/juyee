<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    //    $(function () {
    //        //页面验证初始化
    //        var validateCondition = [
    //
    //        ];
    //        validateInit(validateCondition, formId);
    //    });

    //保存操作
    function save(btn) {
//        if (!validateForm(formId)) {
//            return;
//        }

        //提交表单
        saveAjaxData("${ctx}/checkDeviceInfo/cancelSave.do", formId);
    }

</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <div style="DISPLAY: null" id="projectDiv"></div>
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right" width="12%">监督任务书编号：</td>
                <td class="form_content" width="42%">
                    &nbsp;
                        ${bean.jdTaskCode}
                </td>

                <td class="form_label_right" width="10%">工地编号：</td>
                <td class="form_content">
                    &nbsp;
                        ${bean.gdCode}
                </td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label_right">工地名称：</td>
                <td class="form_content">
                    &nbsp;
                        ${bean.gdName}
                </td>

                <td class="form_label_right">工程名称：</td>
                <td class="form_content">
                    &nbsp;
                        ${project.data.projectName}
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right">工地经度：</td>
                <td class="form_content">
                    &nbsp;
                        ${bean.longitude}
                </td>

                <td class="form_label_right">工地纬度：</td>
                <td class="form_content">
                    &nbsp;
                        ${bean.latitude}
                </td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label_right">设备编号：</td>
                <td class="form_content">
                    &nbsp;
                        ${bean.devSn}
                </td>

                <td class="form_label_right">设备型号：</td>
                <td class="form_content">
                    &nbsp;
                        ${bean.devMode}
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right">设备SIM卡：</td>
                <td class="form_content">
                    &nbsp;
                        ${bean.devSim}
                </td>

                <td class="form_label_right">注册时间：</td>
                <td class="form_content">
                    &nbsp;
                    <fmt:formatDate value="${bean.regDateTime}" pattern="yyyy-MM-dd hh:mm:ss"/>
                </td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label_right">是否注销：</td>
                <td class="form_content">
                    <form:checkbox path="cancelStatus" value="1"/>
                </td>

                <td class="form_label_right">注销时间：</td>
                <td class="form_content">
                    <input type="text" name="cancelDateTime" id="cancelDateTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.cancelDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                           readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('cancelDateTime','all')">

                </td>
            </tr>

            <tr class="tr_button">
                <td class="form_content" colspan="4" style="text-align:center">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>