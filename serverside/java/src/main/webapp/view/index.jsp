<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>${projectArea}区建设工程综合信息管理系统</title>
    <%@include file="/common/header.jsp" %>
    <script src="${ctx}/js/jquery/easyui/outlook2.js" type="text/javascript"></script>
    <link href="${ctx}/js/bootstrap/css/bootstrap-popover.css" rel="stylesheet" media="screen">
    <script src="${ctx}/js/bootstrap/js/bootstrap-popover.js" type="text/javascript"></script>
    <script type="text/javascript">
        jQuery.ajaxSetup({cache:false});//ajax不缓存

        //初始化服务器时间
        var init_dateTime = "${init_dateTime}";

        $(function () {
            $('#backIndex').click(function () {
                loadIndex();
            });
            $('#sysHelp').click(function () {
            openWindow("常用软件下载", "${ctx}/view/system/sysHelp/softList.jsp", false, 700, 380);
            });

            $('#editPass').click(function () {
                if (!checkVideoObj()) {
                    changePass();
                } else {
                    alert("请先关闭视频再修改密码");
                }
            });

            $('#loginOut').click(function () {
                if (checkVideoObj()) {   //判断视频object使用window自带confirm，解决div遮挡导致视频页面无法退出
                    if (window.confirm('您确定要退出系统吗?')) {
                        location.href = '${ctx}/j_spring_security_logout';
                    }
                } else {
                    $.messager.confirm('系统提示', '您确定要退出系统吗?', function (r) {
                        if (r) {
                            location.href = '${ctx}/j_spring_security_logout';
                        }
                    });
                }
            });

            loadIndex();

            //显示时间
            $('#pageClock').timer({format:"yy年mm月dd日 W HH:MM:ss"});

            //加载菜单
            loadLeftMenu(null);
        });

        //加载左侧菜单
        function loadLeftMenu(obj){
            var code = "${PLATFORM_OA}";
            if(obj != null){
                var img = obj.src+"";
                if(img.indexOf("qh.jpg")>=0){
                    obj.src = img.replace("qh.jpg","qh2.jpg");
                    code = "${PLATFORM_BIZ}";
                }else{
                    obj.src = img.replace("qh2.jpg","qh.jpg");
                    code = "${PLATFORM_OA}";
                }
            }
            loadAjaxData("nav","${ctx}/mainPage/menu.do?platform="+code);
        }

        //加载首页
        function loadIndex() {
            loadMainPage("${ctx}/mainPage/main.do", "系统首页");
        }

        function changePass() {
            openWindow({title:'修改密码', maximizable:false}, "${ctx}/sysPassword/changePass.do", false, 460, 180);
        }
    </script>
    <script type="text/javascript" src="${ctx}/js/im/IMInterface.js"></script>
</head>

<body class="easyui-layout" scroll="no">
<noscript>
    <div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
        <img src="${themePath}/jquery/easyui/images/noscript.gif" alt='浏览器不支持脚本！'/>
    </div>
</noscript>
<div region="north" split="true" border="false" style="overflow: hidden; height: 83px;
        background: url(${themePath}/jquery/easyui/images/layout-browser-hd-bg_1.gif) repeat-x center;
        color: #fff; font-family: 'Verdana'">
    <!-- 顶部区域 begin -->
    <div class="Header">
        <div class="titlelogo"><img src="${themePath}/index_new/title.jpg" onclick="loadIndex();" title="返回首页" style="cursor: pointer"/></div>
        <div class="titlebutton">
            <table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td><a href="#" id="backIndex"><img src="${themePath}/index_new/fhsy.png" width="77" height="17" /></a></td>
                    <td><a href="#" id="sysHelp" class="top_link"><img src="${themePath}/index_new/xtbz.png" width="76" height="19" /></a></td>
                    <td><a href="#" id="editPass" class="top_link"><img src="${themePath}/index_new/xgmm.png" width="72" height="20" /></a></td>
                    <td><a href="#" id="loginOut" class="top_link"><img src="${themePath}/index_new/aqtc.png" width="75" height="20" /></a></td>
                </tr>
            </table>
        </div>
        <div class="bar">
            <div class="left"><img src="${themePath}/index_new/boy.png" align="absmiddle" />&nbsp;欢迎您：${realName} | <span id="pageClock" style="color:#666;width:150px;"></span></div>
            <div class="clr"></div>
        </div>
    </div>
    <!-- 顶部区域 end -->
</div>

<div region="west" hide="true" split="true" title="系统菜单" id="west" style="width:120px;" onmouseover="floatOpen(this)">
    <div id="nav" class="easyui-accordion" fit="true" border="false" style="text-align: center;background-color: #F1F1F1;overflow-y: auto;"></div>
</div>

<!-- 主页面区域 -->
<div id="mainPanle" region="center" style="background: #fff; overflow-y:auto">
    <div id="mainLocation" class="mainLocation">
        <div id="mainLocationDesc" style="padding-top:6px"></div>
    </div>
    <div id="mainContent" class="gridBody" style="width:100%;height:100%;position: absolute;overflow-y: auto;"></div>
</div>

<!-- 底部区域 -->
<div region="south" split="true" style="height: 25px; background: #D2E0F2; ">
    <div class="footer">${siteName}</div>
</div>
</body>
</html>