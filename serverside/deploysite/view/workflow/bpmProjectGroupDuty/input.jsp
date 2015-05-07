<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<SCRIPT language=javascript src="${ctx}/js/select.js"></script>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            //{name:"code", rule:"validate[required,maxSize[50]]"},
            {name:"name", rule:"validate[required,maxSize[255]]"},
            {name:"type", rule:"validate[required,maxSize[100]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //提交表单
        saveAjaxData("${ctx}/bpmProjectGroupDuty/save.do", formId);

    }
    function removeRepeat() {
        var select = document.getElementById("personNames");
        for (var i = 0; i < select.options.length; i++) {
            for (var j = i + 1; j < select.options.length; j++) {
                if (select.options[i].value == select.options[j].value) {
                    $(select.options[j]).remove();
                }
            }
        }
    }
</script>
<form:form commandName="bean" method="post">
    <form:hidden path="id"/>
    <input type="hidden" name="projectGroup" value="${bean.projectGroup.id}"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label">岗位类型：</td>
                <td class="form_content">
                    <sys:code code="${infoType}" name="type" type="select" defaultName=""
                              sysCodeDetailId="${bean.type.id}" disabled="" id="type"
                              isAlowedNull="true"
                              onChange=""/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">岗位编码：</td>
                <td class="form_content">
                    <form:input path="code" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">岗位名称：</td>
                <td class="form_content">
                    <form:input path="name" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">对应人员：</td>
                <td class="form_content" nowrap>
                    <select name="personNames" id="personNames" multiple size="5"
                            style="width:200px">
                        <c:forEach var="person" items="${persons}" varStatus="status">
                            <option value="${person.id}">${person.name}</option>
                        </c:forEach>
                    </select><c:choose>
                    <c:when test="${fn:length(persons)>0}"><input type="hidden" name="personIds" id="personIds"
                                                                  value="${personsadd}"></c:when><c:otherwise>
                    <input type="hidden" name="personIds" id="personIds" value=""></c:otherwise></c:choose>
                    <input type="button" class="button_select_add"
                           onClick="multiSelectSysPersonBpmperson('personNames','personIds',null,removeRepeat);"
                           value=" ">
                    <input type="button" class="button_select_remove"
                           onClick="removeMultiSelectOpt('personNames','personIds',null);" value=" "></td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label">备注：</td>
                <td class="form_content">
                    <form:textarea path="description" cssClass="input_textarea"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">是否有效：</td>
                <td class="form_content">
                    <form:checkbox path="isValid" value="1"/>
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