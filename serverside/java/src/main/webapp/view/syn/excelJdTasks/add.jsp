<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<html>
<head>
    <title>添加监督任务书</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script>
        $(function () {
            document.getElementById("jdTasksCode").focus();
        });

        function inputJdTasks() {
            var jdTasksCode = document.getElementById('jdTasksCode').value;
            if (jdTasksCode == "") {
                showInfoMsg("请输入监督任务书编号！");
                document.getElementById("jdTasksCode").focus();
            } else {
                $("#btnPass").attr("disabled", false);
                $("#btnClose").attr("disabled", false);

                loadAjaxDataCallback(null, "${ctx}/excelJdTasks/inputJdTasksCheck.do?jdTasksCode=" + jdTasksCode, function (ret) {
                    var obj = eval("(" + ret + ")");
                    if (!obj.success) {
                        alert(obj.msg);
                    } else {
                        window.location = "${ctx}/excelJdTasks/inputJdTasks.do?jdTasksCode=" + jdTasksCode;
                    }
                });
            }
        }
    </script>
</head>

<body style="background-color:#e0ebf2;">
<div>
    <form:form action="" method="post">
        <table cellpadding="0" cellspacing="0" style="width: 100%;" align="center">
            <tr class="tr_light">
                <td class="form_label_right" style="height: 200px">请输入监督任务书编号：</td>
                <td class="form_content">
                    <input name="jdTasksCode" id="jdTasksCode" class="input_text_long" value="${jdTasksCode}">
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_label">&nbsp;</td>
                <td class="form_content">
                    <input type="button" id="btnPass" class="button_confirm" value="下一步" onclick="inputJdTasks()">
                    <input type="button" id="btnClose" class="button_cancel" value="关闭" onclick="parent.closeWindow()">
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>