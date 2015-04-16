<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <c:if test="${not empty bean.id}">
        <%@include file="/common/header.jsp" %>
    </c:if>
    <script type="text/javascript">
        var formId = "bean";
        $(function () {
            //页面验证初始化
            var validateCondition = [
            ];
            validateInit(validateCondition, formId);
        });

        function save(btn) {
            if (!validateForm(formId)) {
                return;
            }

            saveAjaxData("${ctx}/bpmProcessDefinition/saveBizBiding.do", formId);
        }
    </script>
</head>

<body>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <input type="hidden" value='${gridParam}'>

    <div class="form_div">
        <table border="0" align="center" cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label">业务名称:</td>
                <td class="form_content">
                    <select id="bizObject" name="bizObject" style="width: 150px">
                        <option value="">无</option>
                        <c:forEach items="${bizClasses}" var="map">
                            <option value="${map.className}"
                                    <c:if test="${map.className==bean.bizObject}">selected="true"</c:if>>${map.comment}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">初始化脚本:</td>
                <td class="form_content">
                    <form:textarea path="initScript" cssClass="input_textarea"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">更新脚本:</td>
                <td class="form_content">
                    <form:textarea path="updateScript" cssClass="input_textarea"/>
                </td>

            </tr>
            <tr class="tr_light">
                <td class="form_label">结束脚本:</td>
                <td class="form_content">
                    <form:textarea path="finishScript" cssClass="input_textarea"/>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_label"></td>
                <td class="form_content">
                    <input name="button_save" type="button" class="button_confirm" value="确定" onclick="save(this)">
                    <input name="button_reset" type="reset" class="button_all" value="重写">
                </td>
            </tr>
        </table>
    </div>
</form:form>
</body>
</html>