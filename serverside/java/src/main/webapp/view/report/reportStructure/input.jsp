<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"code", rule:"validate[required,maxSize[100]]"},
            {name:"name", rule:"validate[required,maxSize[200]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //提交表单
        saveAjaxData("${ctx}/reportStructure/save.do", formId, null);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <input type="hidden" name="parent" id="parent" value="${bean.parent.id}"/>
    <input type="hidden" name="version" id="version" value="${bean.version.id}"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">编码：</td>
                <td class="form_content">
                    <form:input path="code" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">名称：</td>
                <td class="form_content">
                    <form:input path="name" cssClass="input_text"/>
                </td>
            </tr>

            <tr class="tr_dark" <c:if test="${not empty bean.parent.id}">style="display: none"</c:if>>
                <td class="form_label">部门：</td>
                <td class="form_content">
                    <select name="reportDeptDefine" id="reportDeptDefine" class="form_select">
                        <c:forEach items="${list}" var="item" varStatus="status">
                            <option value="${item.id}"
                                    <c:if test="${bean.reportDeptDefine.deptName==item.deptName}">selected="selected"</c:if>>${item.deptName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr class="tr_dark" <c:if test="${empty bean.parent.id}">style="display: none"</c:if>>
                <td class="form_label">计算单位：</td>
                <td class="form_content">
                    <sys:code code="${REPORT_MEASURE_UNIT}" name="measureUnit" type="select" defaultName=""
                              sysCodeDetailId="${bean.measureUnit.id}" disabled="" id="measureUnit"
                              isAlowedNull="true"/>
                </td>
            </tr>
            <tr class="tr_dark"
                <c:if test="${not empty bean.version.id && empty bean.parent.id}">style="display: none"</c:if>>
                <td class="form_label">是否计算累计值：</td>
                <td class="form_content">
                    <c:choose>
                        <c:when test="${bean.isSumAccu==false}">
                            <form:checkbox path="isSumAccu" id="isValid" value="1"/>
                        </c:when>
                        <c:otherwise>
                            <form:checkbox path="isSumAccu" id="isValid" value="1" checked="checked"/>
                        </c:otherwise>
                    </c:choose>
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