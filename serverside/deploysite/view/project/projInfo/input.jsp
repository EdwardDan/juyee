<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
                    //{name:"name", rule:"validate[required,maxSize[500]]"},
                    {name: "year", rule: "validate[required,custom[integer],maxSize[4]"},
                    {name: "no", rule: "validate[required,custom[integer],maxSize[5]"}
                    //{name:"buildMileage", rule:"validate[required,maxSize[50]]"},
                    //{name:"location", rule:"validate[required,maxSize[500]]"},
                    //{name:"startDate", rule:"validate[required,custom[date],maxSize[7]"},
                    //{name:"intro", rule:"validate[required,maxSize[
                    <%--${prop.length}]--%>
//        ]
//        "},
                    //{name:"jsDept", rule:"validate[required,maxSize[300]]"},
                    //{name:"sgDept", rule:"validate[required,maxSize[300]]"},
                    //{name:"sgDeptPerson", rule:"validate[required,maxSize[50]]"},
                    //{name:"sgDeptTel", rule:"validate[required,maxSize[50]]"},
                    //{name:"jlDept", rule:"validate[required,maxSize[300]]"},
                    //{name:"jlDeptPerson", rule:"validate[required,maxSize[50]]"},
                    //{name:"jlDeptTel", rule:"validate[required,maxSize[50]]"},
                ]
                ;
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
        saveAjaxData("${ctx}/projInfo/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label_right">年份：</td>
                <td class="form_content">
                    <select class="form_select" name="year" id="year">
                            ${yearSelectOptions}
                    </select>
                </td>
                <td class="form_label_right">开工日期：</td>
                <td class="form_content">
                    <form:input path="startDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('startDate');">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">项目来源：</td>
                <td class="form_content">
                    <sys:code code="ProjProperty" name="ProjProperty" id="ProjProperty" type="select"
                              sysCodeDetailId="${bean.property.id}" style="width:200px"/>
                </td>
                <td class="form_label_right">项目阶段：</td>
                <td class="form_content">
                    <sys:code code="ProjStage" name="ProjStage" id="ProjStage" type="select"
                              sysCodeDetailId="${bean.stage.id}" style="width:200px"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">项目类型：</td>
                <td class="form_content">
                    <sys:code code="ProjCategory" name="ProjCategory" id="ProjCategory" type="select"
                              sysCodeDetailId="${bean.category.id}" style="width:200px"/>
                </td>
                <td class="form_label_right">建设里程：</td>
                <td class="form_content">
                    <form:input path="buildMileage" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">项目名称：</td>
                <td class="form_content" colspan="3">
                    <form:input path="name" cssClass="input_text_long" style="width:90%"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">起讫地点：</td>
                <td class="form_content" colspan="3">
                    <form:input path="location" cssClass="input_text_long" style="width:90%"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">涉及区（县）：</td>
                <td class="form_content" colspan="3">
                    <sys:checkbox name="ProjBelongArea" code="ProjBelongArea" checkedNames="${areas}"
                                  inputType="checkbox" isSaveName="false" showType="edit" colNum="9"/>
                </td>

            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">工程简介：</td>
                <td class="form_content" colspan="3">
                    <textarea name="intro" value="${bean.intro}" class="input_textarea_long">${bean.intro}</textarea>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">建设单位：</td>
                <td class="form_content" colspan="3">
                    <form:input path="jsDept" cssClass="input_text_long"/>
                </td>
            </tr>
        </table>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label_right">施工单位：</td>
                <td class="form_content">
                    <form:input path="sgDept" cssClass="input_text"/>
                </td>
                <td class="form_label_right">联系人：</td>
                <td class="form_content">
                    <form:input path="sgDeptPerson" cssClass="input_text"/>
                </td>
                <td class="form_label_right">联系电话：</td>
                <td class="form_content">
                    <form:input path="sgDeptTel" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">监理单位：</td>
                <td class="form_content">
                    <form:input path="jlDept" cssClass="input_text"/>
                </td>
                <td class="form_label_right">联系人：</td>
                <td class="form_content">
                    <form:input path="jlDeptPerson" cssClass="input_text"/>
                </td>
                <td class="form_label_right">联系电话：</td>
                <td class="form_content">
                    <form:input path="jlDeptTel" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_content" colspan="6" style="text-align: center">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>