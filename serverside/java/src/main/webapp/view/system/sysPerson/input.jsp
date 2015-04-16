<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"code", rule:"validate[required]"},
            {name:"name", rule:"validate[required]"},
            {name:"card", rule:"validate[required]"},
//            {name:"age", rule:"validate[required,custom[integer],max[5]"},
            //{name:"sex", rule:"validate[required]"},
            //{name:"bornDate", rule:"validate[required]"},
            //{name:"bornPlace", rule:"validate[required]"},
            {name:"mobile", rule:"validate[required]"},
            //{name:"officeTel", rule:"validate[required]"},
            //{name:"faxTel", rule:"validate[required]"},
            //{name:"email", rule:"validate[required]"},
            //{name:"zipcode", rule:"validate[required]"},
            {name:"workYear", rule:"validate[custom[integer],maxSize[2]"},
            //{name:"msnCode", rule:"validate[required]"},
            //{name:"qqCode", rule:"validate[required]"},
            //{name:"memo", rule:"validate[required]"},
            {name:"orderNo", rule:"validate[custom[integer]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        disableBtn(btn);
        //提交表单
        saveAjaxData("${ctx}/sysPerson/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label">编号:</td>
                <td class="form_content">
                    <form:input path="code" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">姓名:</td>
                <td class="form_content">
                    <form:input path="name" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">所属单位（部门）:</td>
                <td class="form_content">
                    <input type="text" name="deptName" id="deptName" class="input_text" value="${bean.dept.name}"
                           readonly="true">
                    <input type="hidden" name="sysDeptId" id="sysDeptId"
                           value="<c:if test="${bean.dept!=null}">${bean.dept.id}</c:if>"/>
                    <input type="button" value=" " class="button_select" onclick="selectSysDept('sysDeptId','deptName')"
                           title="点击选择所属单位（部门）">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">职务:</td>
                <td class="form_content">
                    <input type="text" name="position" id="position" value="${bean.positionName}" class="input_text">
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">身份证号:</td>
                <td class="form_content">
                    <form:input path="card" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">年龄:</td>
                <td class="form_content">
                    <form:input path="age" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">性别:</td>
                <td class="form_content">
                    <form:radiobutton path="sex" value="true"/>男
                    <form:radiobutton path="sex" value="false"/>女
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">出生年月:</td>
                <td class="form_content">
                    <form:input path="bornDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('bornDate');">

                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">籍贯:</td>
                <td class="form_content">
                    <form:input path="bornPlace" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">移动电话:</td>
                <td class="form_content">
                    <form:input path="mobile" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">固定电话:</td>
                <td class="form_content">
                    <form:input path="officeTel" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">传真:</td>
                <td class="form_content">
                    <form:input path="faxTel" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">邮件:</td>
                <td class="form_content">
                    <form:input path="email" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">邮政编码:</td>
                <td class="form_content">
                    <form:input path="zipcode" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">工作年限:</td>
                <td class="form_content">
                    <form:input path="workYear" cssClass="input_text"/>
                </td>
            </tr>
                <%--<tr class="tr_dark">--%>
                <%--<td class="form_label">MSN_CODE:</td>--%>
                <%--<td class="form_content">--%>
                <%--<form:input path="msnCode" cssClass="input_text"/>--%>
                <%--</td>--%>
                <%--</tr>--%>
                <%--<tr class="tr_dark">--%>
                <%--<td class="form_label">QQ_CODE:</td>--%>
                <%--<td class="form_content">--%>
                <%--<form:input path="qqCode" cssClass="input_text"/>--%>
                <%--</td>--%>
                <%--</tr>--%>
            <tr class="tr_light">
                <td class="form_label">备注:</td>
                <td class="form_content">
                    <form:textarea path="memo" cssClass="input_textarea"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">显示排序号:</td>
                <td class="form_content">
                    <input type="text" name="orderNo" id="orderNo" class="input_text"
                           value="${bean.personDept.orderNo}">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">是否显示在去向报表中:</td>
                <td class="form_content">
                    <form:checkbox path="isShowPersonOut"/>
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