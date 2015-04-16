<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"content", rule:"validate[required,maxSize[2000]"},
            {name:"reportDept", rule:"validate[required]"},
            //{name:"isValid", rule:"validate[required,maxSize[1]]"},
            {name:"updateTime", rule:"validate[required,maxSize[20]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //提交表单
        saveAjaxData("${ctx}/oaDynamicWork/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right" nowrap>工作内容：</td>
                <td class="form_content" colspan="4">
                    <form:textarea path="content" cssClass="input_textarea_long" cssStyle="height: 300px;width: 512px"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" nowrap>提出部门：</td>
                <td class="form_content" nowrap>
                    <input type="text" name="reportDept" id="reportDept" class="input_text" value="${bean.reportDept}"
                           readonly="true">
                    <%--<input type="hidden" name="reportDeptId" id="reportDeptId"--%>
                           <%--value=""/>--%>
                    <%--<input type="button" value=" " class="button_select"--%>
                           <%--onclick="selectSysDept('reportDeptId','reportDept')"--%>
                           <%--title="点击选择所属单位（部门）">--%>
                </td>

                <td class="form_label_right" nowrap>提交时间：</td>
                <td class="form_content" nowrap>
                    <input type="text" name="updateTime" id="updateTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.updateTime}"  pattern="yyyy-MM-dd HH:mm:ss"/>"
                           readonly="true"/>
                    <%--<input type="button" class="button_calendar" value=" " onClick="calendar('updateTime','all')">--%>
                </td>
            </tr>

                <%--<tr class="tr_light">--%>
                <%--<td class="form_label">是否有效：</td>--%>
                <%--<td class="form_content">--%>
                <%--<form:checkbox path="isValid" value="1"/>--%>
                <%--</td>--%>
                <%--</tr>--%>

            <tr class="tr_button" align="center">
                <td class="form_border" colspan="4">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>