<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "projectName", rule: "validate[required,maxSize[200]]"},
            {name: "projectAdd", rule: "validate[required,maxSize[200]]"},
            {name: "jsUnitName", rule: "validate[required,maxSize[200]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }


        //提交表单
        saveAjaxData("${ctx}/projectMajor/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right" width="20%">报建编号：</td>
                <td class="form_content">
                    <form:input path="bjbh" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">项目名称：</td>
                <td class="form_content">
                    <form:input path="projectName" cssClass="input_text" cssStyle="width: 80%;"/>
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right">项目地址：</td>
                <td class="form_content">
                    <form:input path="projectAdd" cssClass="input_text" cssStyle="width: 80%;"/>
                </td>
            </tr>
            <c:if test="${ not empty bean.id}">
                <tr class="tr_dark">
                    <td class="form_label_right">坐标X：</td>
                    <td class="form_content">
                        <input type="text" value="${bean.posX}" readonly="true"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">坐标Y：</td>
                    <td class="form_content">
                        <input type="text" value="${bean.posY}" readonly="true"/>
                    </td>
                </tr>
            </c:if>
            <tr class="tr_dark">
                <td class="form_label_right">建设单位：</td>
                <td class="form_content">
                    <form:input path="jsUnitName" cssClass="input_text" cssStyle="width: 80%;"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">项目类型：</td>
                <td class="form_content">
                    <sys:code code="ProjectMajorType" name="projectType" type="select" isAlowedNull="true"
                              sysCodeDetailId="${bean.projectType.id}"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">当前进度：</td>
                <td class="form_content">
                    <sys:code code="ProjectMajorSchedule" name="schedule" type="select" isAlowedNull="true"
                              sysCodeDetailId="${bean.schedule.id}"/>
                </td>
            </tr>

            <tr class="tr_button" aligh="center">
                <td class="form_border" colspan="2" aligh="center">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>

</form:form>