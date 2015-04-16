<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@ include file="/common/header.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎访问${siteName}--用户注册</title>
    <link href="${ctx}/view/www/images/style.css" rel="stylesheet" type="text/css"/>
    <script src="${ctx}/js/document.js"></script>
    <script type="text/javascript">
        var formId = "bean";
        $(function () {
            //页面验证初始化
            var validateCondition = [
                {name: "personName", rule: "validate[required,maxSize[50]]"},
                    <c:if test="${isGd}">{name: "gdCode", rule: "validate[required,maxSize[50]]"},
                </c:if>
                <c:if test="${isJs}">
                {name: "bjbh", rule: "validate[required,maxSize[50]]"},
                {name: "projectCard", rule: "validate[required,maxSize[50]]"},
                </c:if>
                <c:if test="${isGd||isJs}"> {name: "projectName", rule: "validate[required,maxSize[200]]"},
                </c:if>
                <c:if test="${isSg || isJl}">
                {name: "bjbh", rule: "validate[required,maxSize[50]]"},
                {name: "unitCode", rule: "validate[required,maxSize[50]]"},
                {name: "unitIdentifyCode", rule: "validate[required,maxSize[50]]"},
                {name: "unitName", rule: "validate[required,maxSize[200]]"},
                </c:if>
                {name: "mobile", rule: "validate[required,custom[mobile]]"}
                //{name:"acceptDesc", rule:"validate[required,maxSize[200]]"},

            ];
            validateInit(validateCondition, formId);
        });

        //验证是否已注册
        //自动获取项目名或单位名
        function isReg() {
            var regType = document.getElementById("regType").value;
            var item;
            var obj = document.getElementById("item");
            if (obj.value == "" || obj.value == null) {
                return false;
            } else {
                item = obj.value;
            }
            if (${isSg || isJl}) {
                var obj2 = document.getElementById("item2");
                if (obj2.value == "" || obj2.value == null) {
                    return false;
                } else {
                    item += "," + obj2.value;
                }
            }
            var msg = getAjaxData("${ctx}/site/getReg.do?loginName=" + item + "&regType=" + regType);
            if (msg.success == "false") {
                $("span[name='msg']").eq(0).html(msg.msg);
                $("#target").val("");
            }
            else {
                $("#target").val(msg.msg);
                $("span[name='msg']").eq(0).html("");
            }
        }
        function save() {
            if (!validateForm(formId)) {
                return false;
            }
        }
    </script>

</head>
<body>
<%@ include file="top.jsp" %>
<div class="ContentHome" style="padding-top: 29px">
    <div class="fousZhuce" style="height: 500px">
        <div class="bg"><img src="${ctx}/view/www/images/yhzc.jpg" alt=""/></div>
        <div id="step" align="center" class="step_zhuce">
            <form action="${ctx}/site/regPerson.do" method="post" id="bean" onclick="return save()">
                <input type="hidden" value="${regType}" name="regType" id="regType">
                <table width="734" height="192" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td height="35">&nbsp;</td>
                        <td align="left"><span style="font-size: 14px;font-weight: bold;">[注册${regTypeName}]</span></td>
                    </tr>
                    <c:if test="${isSg||isJl}">
                        <tr>
                            <td width="184" align="right">报建编号:</td>
                            <td align="left"><input type="text" name="bjbh" Class="input_text_long" id="item2" onblur="isReg()"/>
                                <span name="msg" style="color:red;"></span>
                            </td>
                        </tr>
                        <tr>
                            <td width="184" align="right">企业编码:</td>
                            <td width="550" align="left"><input type="text" name="unitCode" Class="input_text_long"
                                                                id="item" onblur="isReg()"/>
                                <span name="msg" style="color:red;"></span>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">企业标识码:</td>
                            <td align="left"><input type="text" name="unitIdentifyCode" id="unitIdentifyCode"
                                                    class="input_text_long"/><span></span></td>
                        </tr>
                        <tr>
                            <td align="right">企业名称:</td>
                            <td align="left"><input type="text" name="unitName" Class="input_text_long" id="target"
                                                    readonly="readonly"/><span></span></td>
                        </tr>
                    </c:if>
                    <c:if test="${isGd}">
                        <tr>
                            <td width="184" align="right">工地编号:</td>
                            <td align="left"><input type="text" name="gdCode" Class="input_text_long" id="item"
                                                    onblur="isReg()"/>
                                <span name="msg" style="color:red;"></span>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">项目名称:</td>
                            <td align="left"><input type="text" name="projectName" Class="input_text_long" id="target"
                                                    readonly="readonly"/><span></span></td>
                        </tr>
                    </c:if>
                    <c:if test="${isJs}">
                        <tr>
                            <td width="184" align="right">报建编号:</td>
                            <td align="left"><input type="text" name="bjbh" Class="input_text_long" id="item"
                                                    onblur="isReg()"/>
                                <span name="msg" style="color:red;"></span>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">项目卡号:</td>
                            <td align="left"><input type="text" name="projectCard" Class="input_text_long"
                                                    id="projectCard"/><span></span></td>
                        </tr>
                        <tr>
                            <td align="right">项目名称:</td>
                            <td align="left"><input type="text" name="projectName" Class="input_text_long" id="target"
                                                    readonly="readonly"/><span></span></td>
                        </tr>
                    </c:if>
                    <tr>
                        <td align="right">联系人:</td>
                        <td align="left"><input type="text" name="personName" Class="input_text_long"
                                                id="personName"/><span style="color:red"></span></td>
                    </tr>
                    <tr>
                        <td align="right">手机号:</td>
                        <td align="left"><input type="text" name="mobile" Class="input_text_long" id="mobile"/><span
                                style="color:red"></span></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><label>
                            <input type="button" name="btnBack" value="上一步"
                                   onclick="location.href=('${ctx}/site/reg.do')" class="button_long"/>
                            <input type="submit" name="btnSub" value="提交" class="button"/>
                        </label></td>
                    </tr>
                </table>
            </form>
        </div>
        <c:if test="${isSg||isJl}">
            <div style="float: right;padding-right: 30px;padding-top: 0px">
                <img src="${themePath}/reg/qyk1.png" alt=""/><br><br>
                <img src="${themePath}/reg/qyk2.png" alt=""/>
            </div>
        </c:if>
        <c:if test="${isJs}">
            <div style="float: right;padding-right: 30px;padding-top: 0px">
                <img src="${themePath}/reg/xmk1.jpg" alt=""/><br><br>
                <img src="${themePath}/reg/xmk2.jpg" alt=""/>
            </div>
        </c:if>
    </div>
</div>
<%@include file="bottom.jsp" %>
</body>
</html>