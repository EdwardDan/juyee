<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            //{name:"unitName", rule:"validate[required,maxSize[100]]"},
            //{name:"description", rule:"validate[required,maxSize[1000]]"},
            {name: "name", rule: "validate[required,maxSize[100]]"},
            //{name:"sex", rule:"validate[required,maxSize[1]]"},
            //{name:"birthDate", rule:"validate[required,custom[date],maxSize[7]"},
            //{name:"idCard", rule:"validate[required,maxSize[50]]"},
            //{name:"graduationTime", rule:"validate[required,maxSize[7]]"},
            //{name:"graduationSchool", rule:"validate[required,maxSize[200]]"},
            //{name:"major", rule:"validate[required,maxSize[200]]"},
            //{name:"workResume", rule:"validate[required,maxSize[200]]"},
            //{name:"production", rule:"validate[required,maxSize[1000]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn, status) {
        if (!validateForm(formId)) {
            return;
        }
        //加入其他业务判断
        //修改状态
        if (status == '${STATUS_SUBMIT}') {
            $("#status").val(status);

            $.messager.confirm('系统提示', "确定提交吗？提交后将不能修改！", function (r) {
                if (r) {
                    //提交表单
                    saveAjaxData("${ctx}/slryQualify/save.do", formId);
                }
            });
        } else {
            $("#status").val(status);
            //提交表单
            saveAjaxData("${ctx}/slryQualify/save.do", formId);
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="status"/>
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right" width="20%">姓名：</td>
                <td class="form_content" width="80%">
                    <form:input path="name" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">性别：</td>
                <td class="form_content">

                    <select name="sex" class="form_select" style="width: 45px">
                        <option value="true">男</option>
                        <option value="false">女</option>
                    </select>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">出生日期：</td>
                <td class="form_content">
                    <form:input path="birthDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('birthDate');">
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">证件类型：</td>
                <td class="form_content">
                    <sys:code code="${cardType}" name="cardType" type="select" defaultName=""
                              sysCodeDetailId="${bean.cardType.id}" disabled="" id="cardType" isAlowedNull="true"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">证件号码：</td>
                <td class="form_content">
                    <form:input path="idCard" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">学历：</td>
                <td class="form_content">
                    <sys:code code="${education}" name="educationType" type="select" defaultName=""
                              sysCodeDetailId="${bean.educationType.id}" disabled="" id="educationType"
                              isAlowedNull="true"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">技术职称：</td>
                <td class="form_content">
                    <sys:code code="${techType}" name="techType" type="select" defaultName=""
                              sysCodeDetailId="${bean.techType.id}" disabled="" id="techType" isAlowedNull="true"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">毕业时间：</td>
                <td class="form_content">
                    <input type="text" name="graduationTime" id="graduationTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.graduationTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                           readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('graduationTime','all')">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">毕业院校：</td>
                <td class="form_content">
                    <form:input path="graduationSchool" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">所学专业：</td>
                <td class="form_content">
                    <form:input path="major" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">申请类型：</td>
                <td class="form_content">
                    <sys:code code="${applyType}" name="applyType" type="select" defaultName=""
                              sysCodeDetailId="${bean.applyType.id}" disabled="" id="applyType" isAlowedNull="true"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">工作简历：</td>
                <td class="form_content">
                    <form:textarea path="workResume" style="height: 100px; width: 200px;"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">生产业绩：</td>
                <td class="form_content">
                    <form:textarea path="production" style="height: 100px; width: 200px;"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">申请类别：</td>
                <td class="form_content">
                    <sys:code code="${applyCerType}" name="applyCerType" type="select" defaultName=""
                              sysCodeDetailId="${bean.applyCerType.id}" disabled="" id="applyCerType"
                              isAlowedNull="true"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">企业名称：</td>
                <td class="form_content">
                    <form:input path="unitName" cssClass="input_text"/>
                </td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label_right">企业类型：</td>
                <td class="form_content">
                    <sys:code code="${unitType}" name="unitType" type="select" defaultName=""
                              sysCodeDetailId="${bean.unitType.id}" disabled="" id="unitType" isAlowedNull="true"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">照片：</td>
                <td class="form_content">
                        ${uploadButtondocphoto}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">身份证照片：</td>
                <td class="form_content">
                        ${uploadButtondoccard}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">学历证或职称证照片：</td>
                <td class="form_content">
                        ${uploadButtondoceducation}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">合同文件：</td>
                <td class="form_content">
                        ${uploadButtondoccontract}
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_label_right"></td>
                <td class="form_content">
                    <c:if test="${canEdit}">
                        <c:if test="${empty bean.status|| STATUS_EDIT ==bean.status|| STATUS_BACK ==bean.status}">
                            <input type="button" value="提交" class="button_confirm"
                                   onclick="save(this,'${STATUS_SUBMIT}')">&nbsp;
                            <input type="button" value="保存" class="button_confirm"
                                   onclick="save(this,'${STATUS_EDIT}')">&nbsp;
                        </c:if>
                    </c:if>
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>