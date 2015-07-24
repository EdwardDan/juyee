<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        var validateCondition = [
            {name: "code", rule: "validate[required,maxSize[50]]"},
            {name: "name", rule: "validate[required,maxSize[300]]"}
        ];
        validateInit(validateCondition, formId);
    });

    function save() {
        if (!validateForm(formId)) {
            return;
        }
        var relatedUnitInfos = $(".form_table:last input").map(
                function () {
                    return $(this).val() == null || $(this).val() == "" ? "empty" : $(this).val();
                }
        ).get().join(",");
        $("#relatedUnitInfos").val(relatedUnitInfos);
        saveAjaxData("${ctx}/projBid/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="typeCode"/>
    <input type="hidden" name="projInfoId" value="${bean.project.id}">
    <input type="hidden" id="relatedUnitInfos" name="relatedUnitInfos" value=""/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label" style="width: 20%">标段序号：</td>
                <td class="form_content" style="width: 30%">
                    <form:input path="no" cssClass="input_text"/>
                </td>
                <td class="form_label" style="width: 20%">标段名称：</td>
                <td class="form_content" style="width: 30%">
                    <form:input path="name" cssClass="input_text_long" cssStyle="width: 72%"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label" style="width: 20%">建设里程：</td>
                <td class="form_content">
                    <form:input path="buildMileage" cssClass="input_text"/>
                </td>
                <td class="form_label" style="width: 20%">开工日期：</td>
                <td class="form_content" style="width: 30%">
                    <form:input path="startDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('startDate');">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label" style="width: 20%">涉及区（县）：</td>
                <td class="form_content" style="width: 30%" colspan="3">
                    <sys:checkbox name="ProjBelongArea" code="ProjBelongArea" checkedNames="${areas}"
                                  inputType="checkbox" isSaveName="false" showType="edit" colNum="9"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label" style="width: 20%">项目联系人：</td>
                <td class="form_content" style="width: 30%">
                    <form:input path="projLink" cssClass="input_text"/>
                </td>
                <td class="form_label" style="width: 20%">联系电话：</td>
                <td class="form_content" style="width: 30%">
                    <form:input path="linkTel" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td colspan="4">
                    <table class="form_table" cellspacing="0" cellpadding="0" style="width: 90%;margin: 0 auto">
                        <tr>
                            <td class="tr_title" colspan="4" nowrap>各参建单位信息</td>
                        </tr>
                        <tr>
                            <td class="tr_header" style="width: 15%">类型</td>
                            <td class="tr_header">名称</td>
                            <td class="tr_header">联系人</td>
                            <td class="tr_header">联系电话</td>
                        </tr>
                        <c:forEach var="relatedUnit" items="${relatedUnits}" varStatus="serial">
                            <tr>
                                <td class="form_border">${relatedUnit[0]}</td>
                                <td class="form_content">
                                    <input type="text" name="${relatedUnit[1]}Name" value="${relatedUnit[2]}"
                                           class="input_text" style="width: 97%"/>
                                </td>
                                <td class="form_content">
                                    <input type="text" name="${relatedUnit[1]}Person" value="${relatedUnit[3]}"
                                           class="input_text" style="width: 97%"/>
                                </td>
                                <td class="form_content">
                                    <input type="text" name="${relatedUnit[1]}Tel" value="${relatedUnit[4]}"
                                           class="input_text" style="width: 97%"/>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_content" colspan="4" style="text-align: center">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>