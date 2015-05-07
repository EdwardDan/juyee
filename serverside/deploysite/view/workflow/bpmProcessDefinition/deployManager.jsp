<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>虹口区建设工程远程监控信息系统</title>
    <%@include file="/common/header.jsp" %>
    <script type="text/javascript">
        function doDeploy() {
            $.messager.confirm('提示框', '确定要布署吗？', function (bool) {
                if (bool) {
                    saveAjaxData("doDeploy.do", "bean", function () {
                        window.location.reload();
                    }, {});
                }
            });
        }

        function doUpgrade() {
            $.messager.confirm('提示框', '确定要升级吗？', function (bool) {
                if (bool) {
                    saveAjaxData("doUpgrade.do", "bean", function () {
                        window.location.reload();
                    }, {});
                }
            });
        }

        function doClear() {
            $.messager.confirm('提示框', '确定要清空jBPM定义并重新发布吗？', function (bool) {
                if (bool) {
                    saveAjaxData("doClear.do", "bean", function () {
                        window.location.reload();
                    }, {});
                }
            });
        }

        function viewError() {
            document.bean.action = "errorInfo.do";
            document.bean.submit();
        }
        function saveIsValid() {
            saveAjaxData("saveIsValid.do", "bean", function () {
                window.location.reload();
            }, {});
        }

        function testProcess() {
            $.getJSON("${ctx}/bpmProcessDefinition/testProcess.do",
                    {code:"${bean.code}"},
                    function (data) {
                        $("#path").html(data.path.join("-->"));
                        $("#error").html(data.errors);
                        $("#log").html(data.log);
                    })
        }
    </script>
</head>
<body>
<form:form commandName="bean" action="about:blank" name="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">
                    <input type="button" class="button_all"
                           <c:if test="${bean.jbpmDefinitionId!=null}">disabled="disabled"
                           style="color: #808080;"</c:if>
                           value="发布" onclick="doDeploy();">
                    <input type="button" class="button_all"
                           <c:if test="${bean.jbpmDefinitionId==null}">disabled="disabled"
                           style="color: #808080;"</c:if>
                           value="升级" onclick="doUpgrade();">
                </td>
                <td class="form_content">
                    <input type="button" class="button_all"
                           <c:if test="${bean.jbpmDefinitionId==null}">disabled="disabled"
                           style="color: #808080;"</c:if>
                           value="清空" onclick="doClear();">
                    <input name="errors" id="errors" value="检查" type="button" class="button_all"
                           onclick="viewError();this.disabled=true">
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">是否启用：</td>
                <td class="form_content" nowrap="nowrap">
                    <input type="radio" name="isValid" value="1"
                           <c:if test="${bean.jbpmDefinitionId==null}">disabled="disabled"</c:if>
                           <c:if test="${bean.isValid==true}">checked</c:if>>启用
                    <input type="radio" name="isValid" value="0"
                           <c:if test="${bean.jbpmDefinitionId==null}">disabled="disabled"</c:if>
                           <c:if test="${bean.isValid==false}">checked</c:if>>禁用
                    <input type="button" value="设置" class="button_all"
                           <c:if test="${bean.jbpmDefinitionId==null}">disabled="disabled"
                           style="color: #808080;"</c:if>
                           onclick="saveIsValid();">
                    <input type="button" value="自建流程" class="button_normal_long"
                           <c:if test="${bean.jbpmDefinitionId==null}">disabled="disabled"
                           style="color: #808080;"</c:if>
                           onclick="testProcess();">
                </td>
            </tr>
        </table>
        <div style="background-color: #ecf1f7;word-break: break-all;word-wrap: break-word">
            <div class="div_space"></div>
            <fieldset style="min-height:50px; text-align: left">
                <legend class="form_legend">流程操作路径：</legend>
                <span id="path" class="tr_light"></span>
            </fieldset>
            <div class="div_space"></div>
            <fieldset style="min-height:50px">
                <legend class="form_legend">错误内容：</legend>
                <span id="error" class="tr_light"></span>
            </fieldset>
            <div class="div_space"></div>
            <fieldset style="text-align: left;min-height:50px">
                <legend class="form_legend">详细日志：</legend>
                <span id="log" class="tr_light" style="text-align: left;"></span>
            </fieldset>
            <br/>
        </div>
    </div>
</form:form>
</body>
</html>