<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"modelCode", rule:"validate[required,maxSize[50]]"},
            {name:"modelName", rule:"validate[required,maxSize[100]]"},
            {name:"orderNo", rule:"validate[custom[integer],maxSize[4]"},
            {name:"moreLink", rule:"validate[required,maxSize[100]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //提交表单
        saveAjaxData("${ctx}/sysCustomGrid/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">板块编码：</td>
                <td class="form_content">
                    <form:input path="modelCode" cssClass="input_text"/>（使用类名ClassName）
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">板块名称：</td>
                <td class="form_content">
                    <form:input path="modelName" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">系统权限：</td>
                <td class="form_content">
                    <select name="privilege" id="privilege">
                        <c:forEach items="${privileges}" var="item">
                            <option value="${item.id}" <c:if test="${item.id==bean.privilege.id}">selected </c:if>><c:if
                                    test="${item.parent.id == null}">○</c:if>${item.description} ${item.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">更多链接：</td>
                <td class="form_content">
                    <form:input path="moreLink" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">是否有效：</td>
                <td class="form_content">
                    <form:checkbox path="isValid" value="1"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">排序号：</td>
                <td class="form_content">
                    <form:input path="orderNo" cssClass="input_text"/>
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