<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
     <c:if test="${not empty bean.id}">
        <%@include file="/common/header.jsp" %>
    </c:if>
    <script type="text/javascript">
        window.onload = function() {
            //输入判断格式：column,dataType,maxlength,alertmsg
            var conditions = [

                //["name","Require","10","泳道名称必须输入"],
                ["groupId","Require","100","类型必须输入"],
                ["positionTypeId","Require","100","岗位必须输入"]

            ];
//            setObjCondition(conditions);
        }

        function formCheck(form) {

            //表单验证
            if (!Validator.Validate(form)) return false;

            //增加其他判断

            return true;
        }

        function transfer(s) {
            s = s.replace(/\&/g, "&amp;");
            s = s.replace(/\"/g, "&quot;");
            //            s = s.replace(/\#/g, "@");
            return s;
        }

        function queryPerson() {
            var processDefinitionId = document.getElementById("id").value;
            //            var groupId = document.getElementById("groupId").value;
            //            var positionTypeId = document.getElementById("positionTypeId").value;
            //            var expression = transfer(document.getElementById("expression").value);
            var url = "?id=" + processDefinitionId;// + "&groupId=" + groupId + "&positionTypeId=" + positionTypeId + "&expression=" + expression;
//            var left = (parseInt(screen.width) - parseInt(800)) / 2 - window.screenLeft;
//            var top = (parseInt(screen.height) - parseInt(600)) / 2 - window.screenTop;
            loadAjaxData("start","viewSwimlanePerson.do" + url);
        }

        function disabledQueryPerson() {
            document.getElementById("button_query").disabled = true;
        }

        function enabledQueryPerson() {
            document.getElementById("button_query").disabled = false;
        }

        function save(btn) {
        var formId = "bean";

        //加入其他业务判断
//        if ($('#name').val() == '') {
//            showInfoMsg('请输入姓名！',null);
//            return;
//        }

        //提交表单
        saveAjaxData("${ctx}/bpmProcessDefinition/saveViewSwimlane.do", formId);
    }
    </script>
</head>
<body>
<div id="start">
<form:form commandName="bean" method="post" >
    <form:hidden path="id"/>
    <input type="hidden" value='${gridParam}'>

    <div class="form_div">
        <table border="0" align="center" cellpadding="0" cellspacing="0" class="form_table">
                <%--<tr class="td_light">--%>
                <%--<td align="right" width="40%">泳道名称:</td>--%>
                <%--<td>--%>
                <%--<form:input path="name" cssClass="input_text"/>--%>
                <%--</td>--%>
                <%--</tr>--%>
            <tr class="tr_dark">
                <td class="form_label">项目组类型:</td>
                <td class="form_content">
                    <sys:code code="${infoType}" name="groupId" id="groupId"
                              type="select"
                              sysCodeDetailId="${bean.viewSwimlaneDefinition.group.id}"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">项目组岗位类型:</td>
                <td class="form_content">
                    <sys:code code="${positionType}" name="positionTypeId"
                              id="positionTypeId" type="select"
                              sysCodeDetailId="${bean.viewSwimlaneDefinition.positionType.id}"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">其他限制(表达式):</td>
                <td class="form_content">
                    <textarea name="expression" id="expression"
                              class="input_textarea"
                              onkeydown="disabledQueryPerson();">${bean.viewSwimlaneDefinition.expression}</textarea>
                        <%--<form:textarea id="expression"--%>
                        <%--path="swimlaneDefinition.expression" cssClass="input_textarea"/>--%>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_label"></td>
                <td class="form_content">
                    <input id="button_save" type="button" class="button_confirm" value="确定" onclick="save(this)">
                    <input id="button_reset" type="reset" class="button_cancel" value="重写"
                           onclick="enabledQueryPerson();">
                    <c:if test="${bean.id!=null}">
                        <input id="button_query" type="button" class="button_all" value="人员"
                               onclick="queryPerson();">
                    </c:if>
                        <%--<input name="button_back" type="button" class="button_back" value="返回"--%>
                        <%--onclick="history.back()">--%>
                </td>
            </tr>
        <!-- main content end -->
        </table>
    </div>
</form:form>
    </div>
</body>
</html>