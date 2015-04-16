<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<html>
<head>
    <OBJECT classid="clsid:A318A9AC-E75F-424C-9364-6B40A848FC6B" width=0 height=0 id=zkonline>
        <PARAM NAME="FPEngineVersion" VALUE="10">
    </OBJECT>

    <COMMENT>
        <EMBED type="application/x-eskerplus"
               classid="clsid:A318A9AC-E75F-424C-9364-6B40A848FC6B"
               codebase="ZKOnline.ocx"
               width=0 height=0 style="visibility:hidden">
        </EMBED>
    </COMMENT>
    <script type="text/javascript">
        var formId = "bean";
        zkonline.FPEngineVersion = '10';
        zkonline.EnrollCount = 3;

        if (navigator.appName == "Microsoft Internet Explorer") {
            if (typeof zkonline.RegisterTemplate != "undefined") {
            } else {
                showErrorMsg("插件未正确安装！请先安装插件");
                closeWindow();
            }
        } else {
            showErrorMsg("请使用IE浏览器!!");
            closeWindow();
        }

        function registerTemplates() {
            var tem = document.getElementById("templates");
            zkonline.checkFinger = document.getElementById("initRegisteredFingers").value;
            if (zkonline.register()) {
                document.getElementById("registeredFingers").value = zkonline.checkFinger;
                var regs = document.getElementById("registeredFingers").value;
                var inis = document.getElementById("initRegisteredFingers").value;
                for (var i = 1; i < 11; i++) {
                    var template = zkonline.GetRegFingerTemplate(i);
                    tem.value += i - 1 + "_" + template;
                    if ((regs.charAt(i - 1) != inis.charAt(i - 1) ) && inis.charAt(i - 1) == "1") {
                        tem.value += "1";
                    }
                    tem.value += ",";
                }
                zkonline.RegisterTemplate = "";
                saveFinger(null);
            }
            else {
                document.getElementById("registeredFingers").value = zkonline.checkFinger;
                if (document.getElementById("initRegisteredFingers").value != zkonline.checkFinger) {
                    regs = document.getElementById("registeredFingers").value;
                    inis = document.getElementById("initRegisteredFingers").value;
                    for (var j = 0; j < 10; j++) {
                        if (regs.charAt(j) != inis.charAt(j)) {
                            tem.value += j + "_" + "1,"
                        } else {
                            tem.value += j + "_,"
                        }
                    }
                    $.messager.confirm("指纹删除成功", "你确定要删除吗?", function (r) {
                        if (r) {
                            saveFinger(null);
                        }
                    });
                }
                else
                    showErrorMsg("指纹采集失败或取消!");
                    closeWindow();
            }
        }
        //保存操作

        function saveFinger(btn) {
            //提交表单
            if (document.getElementById("templates").value.length < 1) {
                showErrorMsg("未采集指纹无法保存！");
                return;
            }

            var mid = $("#id").val();
            var templates = document.getElementById("templates").value;

            saveAjaxData("${ctx}/checkFingerPrint/save.do?mid=" + mid + "&text=", formId);
        }

        $(function () {
            registerTemplates();
        })

    </script>
</head>
<body>
<form:form commandName="bean" action="post">
    <div class="form_div">
        <input type="hidden" id="id" name="id" value="${bean.man.id}"/>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">姓名：</td>
                <td class="form_content">
                        ${bean.man.name}
                    <input type="button" value="采集指纹" class="button_normal_long" onclick="registerTemplates()"/>
                    <input type="hidden" name="template" value=""/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">手指标识：</td>
                <td class="form_content">
                    <input type="text" name="fingerid" id="initRegisteredFingers"
                           value="${bean.initRegisteredFingers}" readonly="readonly"/>0表示未采集手指1表示已采集手指<br/>
                    <input type="hidden" id="templates" name="templates" value="">
                    <input type="hidden" id="registeredFingers" name="registeredFingers" value="">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">已采集指纹数量：</td>
                <td class="form_content">
                        ${bean.num}
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_label"></td>
                <td class="form_content">
                    <input type="button" value="确定" class="button_confirm" onclick="saveFinger(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>
</body>
</html>