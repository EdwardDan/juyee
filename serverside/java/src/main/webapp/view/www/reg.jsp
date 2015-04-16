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
        function next() {
            var val = $('input:radio[name="regType"]:checked').val();
            if (val != null && val != "") {
                window.location.href = "${ctx}/site/regNext.do?regType=" + val;
            }else{alert("请先输入!");}
        }
    </script>
</head>
<body>
<%@ include file="top.jsp" %>
<div class="ContentHome" style="padding-top: 29px">
    <div class="fousZhuce" style="height: 400px">
        <div class="bg"><img src="${ctx}/view/www/images/yhzc.jpg" alt=""/></div>
        <div id="step" align="center" class="step_zhuce">
            请选择注册类型:
            <input type="radio" name="regType" value="${SYS_REGPERSON_TYPE_UNIT_SG}" checked="checked">施工单位
            <input type="radio" name="regType" value="${SYS_REGPERSON_TYPE_UNIT_JS}">建设单位
            <input type="radio" name="regType" value="${SYS_REGPERSON_TYPE_UNIT_JL}">监理单位
            <div class="step_zhuce">
                <input type="button" value="下一步" onclick="next()" class="button_long">
            </div>
        </div>
        <div align="left" style="padding-top: 120px;padding-left: 200px;line-height: 22px">
            注册说明：<br>
            1、施工单位账号为施工单位提供登录入口，请根据上海市建筑建材网统一提供的企业信息卡进行注册，如企业编码、企业标识码；<br>
            2、建设单位账号为建设单位提供登录入口，请根据项目报建时发放的项目卡进行注册，如报建编号、项目卡号；<br>
            3、监理单位账号为监理单位提供登录入口，请根据上海市建筑建材网统一提供的企业信息卡进行注册，如企业编码、企业标识码；<br>
            4、所有帐号注册时请提供正确的联系人和手机号码，注册审核通过后，将以短信方式通知登录帐号和登录密码；<br>
            5、注册时，各单位按承建项目的报建编号进行注册；<br>
            <%--<a target=blank href=http://wpa.qq.com/msgrd?V=1&Uin=202477828&Site=&Menu=yes><img border="0" SRC=http://wpa.qq.com/pa?p=1:202477828:8 alt="点击这里给我发消息"></a>--%>
            <%--<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=1833606488&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:1833606488:41" alt="点击这里给我发消息" title="点击这里给我发消息" align="absmiddle"></a>--%>
        </div>
    </div>
</div>
    <%--<%@include file="bottom.jsp" %>--%>

</body>
</html>



