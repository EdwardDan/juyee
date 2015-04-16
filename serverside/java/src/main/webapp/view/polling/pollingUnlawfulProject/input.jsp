<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "projectName", rule: "validate[required]"},
            {name: "buildAddress", rule: "validate[required]"},
            {name: "buildUnit", rule: "validate[required]"},
            {name: "sgUnit", rule: "validate[required]"},
            {name: "buildLinkman", rule: "validate[required,maxSize[100]]"},
            {name: "sgUnitLinkman", rule: "validate[required,maxSize[100]]"},
            {name: "mainPerson", rule: "validate[required,maxSize[100]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //提交表单
        saveAjaxData("${ctx}/pollingUnlawfulProject/save.do", formId);
    }
</script>
<style type="text/css">
    .form_selectss{
        width: 50px;
        height:22px;
        border: 1px solid #b8b6b9;
    }
</style>
<form:form commandName="bean">
    <form:hidden path="id" />

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right" width="20%">工程名称：
                </td>
                <td class="form_content" width="30%">&nbsp;
                    <form:input path="projectName"  cssClass="input_text"/>
                </td>
                <td class="form_label_right" width="20%">建设地址：
                </td>
                <td class="form_content" width="30%">&nbsp;
                    <form:input path="buildAddress"  cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">建设单位：
                </td>
                <td class="form_content">&nbsp;
                    <form:input path="buildUnit" cssClass="input_text"/>
                </td>
                <td class="form_label_right">施工单位：
                </td>
                <td class="form_content">&nbsp;
                    <form:input path="sgUnit" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">建设单位联系人：
                </td>
                <td class="form_content">&nbsp;
                    <form:input path="buildLinkman" cssClass="input_text"/>
                </td>
                <td class="form_label_right">建设单位联系电话：
                </td>
                <td class="form_content">&nbsp;
                    <form:input path="buildLinkPhone" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">施工单位联系人：
                </td>
                <td class="form_content">&nbsp;
                    <form:input path="sgUnitLinkman" cssClass="input_text"/>
                </td>
                <td class="form_label_right">施工单位联系电话：
                </td>
                <td class="form_content">&nbsp;
                    <form:input path="sgUnitLinkPhone" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">立项申请：</td>
                <td class="form_content">&nbsp;
                    <select name="isLx" class="form_selectss">
                        <option value="true"
                                <c:if test="${bean.isLx}">selected="true"</c:if> >有
                        </option>
                        <option value="false"
                                <c:if test="${!bean.isLx}">selected="true"</c:if> >无
                        </option>
                    </select>
                <td class="form_label_right">土地权证：</td>
                <td class="form_content">&nbsp;
                    <select name="isTdqz" class="form_selectss">
                        <option value="true"
                                <c:if test="${bean.isTdqz}">selected="true"</c:if> >有
                        </option>
                        <option value="false"
                                <c:if test="${!bean.isTdqz}">selected="true"</c:if> >无
                        </option>
                    </select>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">规划许可：</td>
                <td class="form_content">&nbsp;
                    <select name="isGhxk" class="form_selectss">
                        <option value="true"
                                <c:if test="${bean.isGhxk}">selected="true"</c:if> >有
                        </option>
                        <option value="false"
                                <c:if test="${!bean.isGhxk}">selected="true"</c:if> >无
                        </option>
                    </select>
                </td>
                <td class="form_label_right">施工许可：</td>
                <td class="form_content">&nbsp;
                    <select name="isSgxk" class="form_selectss">
                        <option value="true"
                                <c:if test="${bean.isSgxk}">selected="true"</c:if> >有
                        </option>
                        <option value="false"
                                <c:if test="${!bean.isSgxk}">selected="true"</c:if> >无
                        </option>
                    </select>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">监督负责人：</td>
                <td class="form_content">&nbsp;
                    <form:input path="mainPerson" cssClass="input_text"/></td>
                <td class="form_label_right">监督成员：</td>
                <td class="form_content">&nbsp;
                    <form:input path="groupPerson" cssClass="input_text"/></td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">问题描述：</td>
                <td class="form_content" colspan="3">&nbsp;
                    <form:input path="questionDesc" cssClass="input_text"/></td>
            </tr>

            <tr class="tr_button">
                <td class="form_label" colspan="2">
                    <input align="right" type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                </td>
                <td class="form_content" colspan="2">
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>