<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"name", rule:"validate[required,maxSize[255]]"}
        ];
        validateInit(validateCondition, formId);

        if($("#id").val()==""){document.getElementById("person").disabled=true;}
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //提交表单
        disableBtn(btn);
        saveAjaxData("${ctx}/bpmSwimlane/save.do", formId);

    }
    function queryPerson(obj) {
        var swimlaneId = document.getElementById("id").value;
        var groupId = document.getElementById("groupId").value;
        var positionTypeId = document.getElementById("positionTypeId").value;
        var expression = encodeURIComponent(document.getElementById("expression").value);
        if (obj == 'test') {
            isScriptVaild(groupId, positionTypeId, expression);
        } else {
            var url = "?id=" + swimlaneId + "&groupId=" + groupId + "&positionTypeId=" + positionTypeId + "&expression=" + expression;
            openWindow("查看人员", "${ctx}/bpmSwimlane/queryPerson.do" + url, false);
        }
    }

    function isScriptVaild(groupId, positionTypeId, expression) {
        if (expression == '') {
            alert("表达式为空，无法测试");
        } else {
            var url = "?groupId=" + groupId + "&positionTypeId=" + positionTypeId + "&expression=" + expression;
            var msg = "${ctx}/bpmSwimlane/isScriptVaild.do" + url;
            var message = getAjaxData(msg);
            if (message.msg) {
                alert("表达式OK!");
            } else {
                alert("表达式有误!!")
            }
        }
    }

    function disabledQueryPerson() {
        document.getElementById("button_query").disabled = true;
    }

    function enabledQueryPerson() {
        document.getElementById("button_query").disabled = false;
    }

</script>
<form:form commandName="bean">
    <form:hidden path="id" id="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">泳道名称：</td>
                <td class="form_content">
                    <form:input path="name" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">项目组类型：</td>
                <td class="form_content">
                    <sys:code code="${groupType}" name="groupId" id="groupId"
                              type="select"
                              sysCodeDetailId="${bean.swimlaneDefinition.group.id}"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">项目组岗位类型：</td>
                <td class="form_content">
                    <sys:code code="${positionType}" name="positionTypeId" id="positionTypeId"
                              type="select"
                              sysCodeDetailId="${bean.swimlaneDefinition.positionType.id}"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">其他限制(表达式):</td>
                <td class="form_content">
                    <textarea name="expression" id="expression"
                              class="input_textarea"
                              onkeydown="disabledQueryPerson();">${bean.swimlaneDefinition.expression}</textarea>
                        <%--<form:textarea id="expression"--%>
                        <%--path="swimlaneDefinition.expression" cssClass="input_textarea"/>--%>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_label"></td>
                <td class="form_content">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" id="person" value="人员" class="button_all" onclick="queryPerson('query')">&nbsp;
                    <input type="button" value="测试" class="button_all" onclick="queryPerson('test')">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>