<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
//        var validateCondition = [
//            //{name:"originCode", rule:"validate[required,maxSize[40]]"},
//            {name:"code", rule:"validate[required,maxSize[40]]"},
//            {name:"name", rule:"validate[required,maxSize[200]]"}
//            //{name:"author", rule:"validate[required,maxSize[40]]"},
//            //{name:"keywords", rule:"validate[required,maxSize[500]]"},
//            //{name:"abstractContent", rule:"validate[required,maxSize[1000]]"},
//            //{name:"createUser", rule:"validate[required,maxSize[20]]"},
//            //{name:"createDate", rule:"validate[required,custom[date],max[16]"},
//            //{name:"achStatus", rule:"validate[required,custom[integer],max[2]"},
//            //{name:"description", rule:"validate[required,maxSize[1000]]"},
//        ];
//        validateInit(validateCondition, formId);
    });
    function init(btn) {
        if (!validateForm(formId)) {
            return;
        }
        openWindow("添加文档信息", "${ctx}/docDocument/add.do?bizCode=" + $("#docMenu").val());
    }
</script>
<form:form commandName="bean">
    <%--<form:hidden path="id"/>--%>
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">请选择文档目录：</td>
                <td class="form_content">
                    <select name="docMenu" id="docMenu" class="form_select">
                        <c:forEach items="${docCategoryList}" var="docCategoryList">
                            <option id="${docCategoryList.id}"
                                    value="${docCategoryList.bizCode}">${docCategoryList.name}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            <tr class="tr_button">
                <td class="form_label"></td>
                <td class="form_content">
                    <input type="button" value="确定" class="button_confirm" onclick="init(this)">
                    <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>