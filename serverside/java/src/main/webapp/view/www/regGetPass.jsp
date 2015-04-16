<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@ include file="/common/header.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎访问${siteName}--找回密码</title>
    <link href="${ctx}/view/www/images/style.css" rel="stylesheet" type="text/css"/>
    <script src="${ctx}/js/document.js"></script>
    <script type="text/javascript">
        var formId = "bean";
        $(function () {
            //页面验证初始化
            var validateCondition = [
                {name:"personName", rule:"validate[required,maxSize[50]]"},
                {name:"code", rule:"validate[required,maxSize[50]]"},
                {name:"mobile", rule:"validate[required,custom[mobile]]"}
                //{name:"acceptDesc", rule:"validate[required,maxSize[200]]"},

            ];
            validateInit(validateCondition, formId);
        });

        //验证是否已注册
        //自动获取项目名或单位名
        function save() {
            if (!validateForm(formId)) {
                return;
            }
        }

        function getChecks() {
            var inputs = document.getElementsByName("regType");
            var j = 2;
            var xgbh = document.getElementById("xgbh");
            for (var i = 0; i < inputs.length; i++) {
                if (inputs[i].checked == true) {
                    j = i;
                }
            }

            if (j == 0 || j == 2) {
                xgbh.innerHTML = "企业编码:";
            } else if (j == 1) {
                xgbh.innerHTML = "报建编号:";
            }
//            else {
//                xgbh.innerHTML = "工地编号:";
//            }
        }
    </script>

</head>
<body>
<%@ include file="top.jsp" %>
<div class="ContentHome" style="padding-top: 29px">
    <div class="fousZhuce">
        <div class="bg"></div>
        <div id="step" align="center" class="step_zhuce">
            <form action="${ctx}/site/regGetPassSend.do" method="post" id="bean" onsubmit="return save()">
                <table width="734" height="192" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td></td>
                        <td style="font-size:x-large; font-family:微软雅黑;" align="left">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;找回密码
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="font-size:x-large;" align="left">&nbsp;</td>
                    </tr>
                    <tr>
                        <td width="184" align="right">请选择注册类型:</td>
                        <td width="550" align="left">
                            <input type="radio" name="regType" value="${SYS_REGPERSON_TYPE_UNIT_SG}" onclick="getChecks()" checked="checked">施工单位账号
                            <input type="radio" name="regType" value="${SYS_REGPERSON_TYPE_UNIT_JS}" onclick="getChecks()">建设单位账号
                            <input type="radio" name="regType" value="${SYS_REGPERSON_TYPE_UNIT_JL}" onclick="getChecks()">监理单位账号
                        </td>
                    </tr>
                    <tr>
                        <td width="184" align="right" id="xgbh">工地编号:</td>
                        <td width="550" align="left">
                            <input type="text" name="code" Class="input_text_long" id="code"/>&nbsp;(输入注册时的账号)
                        </td>
                    </tr>
                    <tr>
                        <td align="right">联系人:</td>
                        <td align="left">
                            <input type="text" name="personName" Class="input_text_long" id="personName"/>&nbsp;(输入注册时的联系人)
                        </td>
                    </tr>
                    <tr>
                        <td align="right">手机号:</td>
                        <td align="left">
                            <input type="text" name="mobile" Class="input_text_long" id="mobile"/>&nbsp;(输入注册时的手机号，11位数字)
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><label>
                            <input type="submit" name="btnSub" value="提交" class="button_long"/>
                            <input type="reset" name="btnReset" value="重写" class="button"/>
                        </label></td>
                    </tr>
                    <tr><td colspan="2">&nbsp;</td></tr>
                </table>
            </form>
        </div>
    </div>
</div>
<%@include file="bottom.jsp" %>

</body>
</html>



