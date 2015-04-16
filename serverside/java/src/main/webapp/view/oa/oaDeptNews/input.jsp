<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
           {name:"title", rule:"validate[required,maxSize[200]]"},
            {name:"reportPerson", rule:"validate[required,maxSize[50]]"},
            {name:"reportDept", rule:"validate[required,maxSize[100]]"},
            {name:"content", rule:"validate[required,maxSize[2000]]"},
            {name:"status", rule:"validate[required,custom[integer],maxSize[2]"}

        ];
        validateInit(validateCondition, formId);
    });

    //提交操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        //提交表单
        if (confirm("提交之后将不能再修改，确定继续吗？")) {
            saveAjaxData("${ctx}/oaDeptNews/save.do?status=${STATUS_SUBMIT}", formId);
        }
    }
    //保存操作
    function tempSave(btn) {
        if (!validateForm(formId)) {
            return;
        }
        saveAjaxData("${ctx}/oaDeptNews/save.do?status=${STATUS_EDIT}", formId);
    }

    function getPersonInfo(){
        var personId = $("#reportPersonId").val();
        var url="${ctx}/sysPerson/getPersonInfo.do?personId="+personId;
        var data = getAjaxData(url);
        $("#reportDept").val(data.deptName);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table" width="50">
            <tr class="tr_light">
                <td class="form_label_right">新闻主题：</td>
                <td class="form_content"  align="left">
                    <form:input path="title" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">提交人：</td>
                <td class="form_content">
                    <input type="text" name="reportPerson" id="reportPerson" class="input_text_long"
                           value="${bean.reportPerson}" readonly="true">
                    <input type="hidden" name="reportPersonId" id="reportPersonId"
                           value=""/>
                    <input type="button" value=" " class="button_select"
                           onclick="selectSysPerson('reportPersonId','reportPerson',getPersonInfo)"
                           title="点击选择提出人">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label" >提交部门：</td>
                <td class="form_content">
                    <form:input path="reportDept" cssClass="input_text_long" readonly="true"/>

                </td>
            </tr>
            <%--<tr class="tr_dark">--%>
                <%--<td class="form_label">主要内容(预留)：</td>--%>
                <%--<td class="form_content">--%>
                    <%--<form:input path="content" cssClass="input_text"/>--%>
                <%--</td>--%>
            <%--</tr>--%>

            <tr class="tr_light">
                <td class="form_label">附件：</td>
                <td class="form_content">
                   ${uploadButton}
                </td>
            </tr>

            <tr class="tr_button">
                <td class="form_label"></td>
                <td class="form_content">
                    <input type="button" value="提交" class="button_confirm"
                           onclick="save(this)">&nbsp;
                    <input type="button" value="暂存" class="button_confirm"
                           onclick="tempSave(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>