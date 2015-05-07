<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
//        required:validate[required]
//        custom: validate[required,custom[url]]   具体支持phone ,email ,integer ,number ,date ,ipv4 ,url ,onlyNumberSp ,onlyLetterSp ,onlyLetterNumber
//        groupRequired: validate[dateRange[theSameName]],一个组中的theSameName必需相同就可以触发组验证
//        ajax:alidate[required,custom[onlyLetterNumber],maxSize[20],ajax[ajaxUserCall]]
//        minSize:validate[required,minSize[6]]
//        maxSize:validate[optional,maxSize[6]]
//        min:validate[required,custom[integer],min[-5]]
//        max:validate[required,custom[integer],max[50]]
//        past:validate[custom[date],past[2010/01/01]]
//        future:validate[custom[date],future[NOW]]
//        dateRange:validate[required,dateRange[projectDate]]
//        dateTimeRange:同上
//        maxCheckbox:validate[maxCheckbox[2]]
//        minCheckbox:validate[minCheckbox[2]]
//        equals:validate[required,equals[password]]
//        funcCall:validate[required,funcCall[checkHELLO]]
        //页面验证初始化
        var validateCondition = [
            {name:"name", rule:"validate[required]"},
            {name:"birthday", rule:"validate[required,custom[date]]"},
            {name:"possession", rule:"validate[custom[number]]"},
//            {name:"age", rule:"validate[required,custom[integer],max[200]"},
            {name:"sysDeptName", rule:"validate[required]"},
            {name:"sysDept", rule:"validate[required]"}
//            {name:"educationName", rule:"validate[required]"},
//            {name:"education", rule:"validate[required]"},
//            {name:"registerTime", rule:"validate[required,custom[date]]"},
//            {name:"isMarried", rule:""},
//            {name:"description", rule:"validate[required]"}
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
        calcAge();

        //提交表单
        saveAjaxData("${ctx}/sample/save.do", formId);
    }

    function calcAge() {
        getAge($('#birthday').val(), $('#age'));
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">
                    姓名：
                </td>
                <td class="form_content">
                    <form:input path="name" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">
                    生日：
                </td>
                <td class="form_content">
                    <form:input path="birthday" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('birthday');">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">
                    资产：
                </td>
                <td class="form_content">
                    <form:input path="possession" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">
                    年龄：
                </td>
                <td class="form_content">
                    <form:input path="age" cssClass="input_text" readonly="true" onclick="calcAge();"/>
                    <%--出生年份：<form:input path="year" cssClass="input_date" readonly="true"/>--%>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">
                    所属单位：
                </td>
                <td class="form_content">
                    <input type="text" name="sysDeptName" id="sysDeptName" class="input_text"
                           value="${bean.sysDept.name}" readonly="true"/>
                    <form:hidden path="sysDept" value="${bean.sysDept.id}"/>
                    <input type="button" value=" " class="button_select" onclick="selectSysDept('sysDept','sysDeptName')" title="点击选择单位">
                    <%--多选的调用--%>
                    <%--<select multiple="multiple" id="sysDeptSel" name="sysDeptSel" class="input_textarea"></select>--%>
                    <%--<input type="button" value=" " class="button_select" onclick="multiSelectSysDept('sysDeptSel','sysDept','sysDeptName')" title="点击选择单位">--%>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">
                    学历：
                </td>
                <td class="form_content">
                    <sys:code code="education" name="education" type="select" defaultName=""
                              sysCodeDetailId="${bean.education.id}" disabled="" id="education" isAlowedNull="true"
                              onChange="changeMethod()"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">
                    注册时间：
                </td>
                <td class="form_content">
                    <input type="text" name="registerTime" id="registerTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.registerTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('registerTime','all')">
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">
                    婚否：
                </td>
                <td class="form_content">
                    <form:checkbox path="isMarried" value="1"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">
                    备注：
                </td>
                <td class="form_content">
                    <form:textarea path="description" cssClass="input_textarea"/>
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