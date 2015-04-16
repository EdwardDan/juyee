<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"tableName", rule:"validate[required,maxSize[100]]"}

            //{name:"logType", rule:"validate[required,maxSize[20]]"},
        ];
        validateInit(validateCondition, formId);
    });

    function test(select) {
        var className = select.value;
        $.getJSON("${ctx}/configTable/info.do", {className:className}, function (data) {
            var tableName = data.tableName
            $("#tableName").val(tableName);

        });
    }
    //保存操作

    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        disableBtn(btn);
        saveAjaxData("${ctx}/configTable/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label">类名：</td>
                <td class="form_content">
                    <select id="className" name="className" style="width: 150px" onchange="test(this)">
                        <c:forEach items="${bizClasses}" var="biz">
                            <option value="${biz.className}"
                                    <c:if test="${biz.className==bean.className}">selected="true"</c:if>>${biz.allClassName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">表名：</td>
                <td class="form_content">
                    <form:input path="tableName" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">扩展XML：</td>
                <td class="form_content">
                    <form:textarea path="extendXml" cssClass="input_textarea"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">记录日志：</td>
                <td class="form_content">
                    <form:checkbox path="isLog"/>
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