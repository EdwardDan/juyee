<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<html>
<head>
    <title>查看视频</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <%--<script src="${ctx}/js/jquery/jquery-1.7.1.js" type="text/javascript"></script>--%>
    <%--<script src="${ctx}/js/jquery/ui/jquery-ui-1.8.17.min.js" type="text/javascript"></script>--%>
    <%--<script src="${ctx}/js/jquery/easyui/jquery.easyui.min.1.2.2.js" type="text/javascript"></script>--%>
    <%--<script src="${ctx}/js/jquery/easyui/jquery.linkbutton.js" type="text/javascript"></script>--%>
    <%--<script src="${ctx}/js/jquery/easyui/easyui-lang-zh_CN.js" type="text/javascript"></script>--%>
    <%--<script src="${ctx}/js/default.js" type="text/javascript"></script>--%>
    <%--<link rel="stylesheet" type="text/css" href="${ctx}/skin/jquery/easyui/default.css"/>--%>
    <%@include file="/common/header.jsp" %>
    <script type="text/javascript">
        //初始化ocx
        var ocxObject;
        function pageLoad() {
            ocxObject = document.getElementById("OcxObject");
            ocxObject.SetOcxMode(0); //正常预览
            ocxObject.SetWndNum(1);  //分屏数目
            ocxObject.SetCapturParam("c:\\pic",0);    //设置图片保存路径和格式
//            setTimeout(function () {  //延迟1秒开始显示
//                startPreview();
//            }, 1000);
            changeVideoWin();
        }
        $(window).resize(function() {
            changeVideoWin();
        });
        function changeVideoWin(){
            var w = parent.$("#mainContent").width();
            var h = parent.$("#mainContent").height();
            var newH = h-27;
            $("#tab1").height(newH);
            $("#OcxObject").height(newH-29);
            $("#OcxObject").width(w - 470);
        }
        function closeMenu(){
            if (screen.width <= 1366) {
                $(".easyui-layout").layout("collapse", "west");
            }
        }

        //获取视频参数
        function loadXml(cameraId) {
            //通过WebService获取预览所需的参数
            loadAjaxDataCallback(null,"${ctx}/gdMonitorHK/getVideoXml.do?cameraId="+cameraId,startPreview)
        }

        //开始预览
        var vm = 0;
        function startPreview(previewXml) {
            if(previewXml ==null || previewXml==""){

            }else{
                var freeWin = ocxObject.GetFreePreviewWnd;
                var count = ocxObject.GetWndNum();
                if(count>1 && freeWin == -1){
                    freeWin = 0;
                    ocxObject.SelWindow(0);  //设置选中窗口
                }
                if(count ==1 && vm ==1){
                    ocxObject.SetWndNum(4);  //分屏数目
                    ocxObject.SelWindow(1);  //设置选中窗口
                    freeWin = 1;
                }
                var ret = ocxObject.StartTask_Preview_InWnd(previewXml, freeWin);
                if (ret == 0) {
                    vm ++;
                    if(count>1 && vm == count) vm = 0;
                } else {
                    alert("startPreview fail >>> " + ret)
                }
            }
        }

        //更换按钮样式
        function changePic(flag, isdown) {
            var pics = ["left.jpg", "right.jpg", "up.jpg", "down.jpg"];
            if (!isdown) {
                $("#opImage").attr("src", "${ctx}/skin/default/img/control.jpg");
            } else {
                $("#opImage").attr("src", "${ctx}/skin/default/img/" + pics[flag - 1]);
            }
        }

        //控制抬头方向
        function goptz(flag){
            ocxObject.StartTask_PTZ(flag,4);  //4为速度，默认为3
        }

        //更换分屏
        function changeScreen(count){
            ocxObject.SetWndNum(count);
        }

        //明暗调整
        function goEffect(type,flag){
            var diff = 2;
            if(flag ==2) diff = -2;
            var xml = ocxObject.GetVideoEffect();
//            alert(xml);
            if(type == "Bright"){
                var lBrightValue = getElementValue(xml,"Bright");
                var lContrastValue = getElementValue(xml,"Contrast");
                var lSaturationValue = getElementValue(xml,"Saturation");
                var lHueValue = getElementValue(xml,"Hue");
                lBrightValue = parseInt(lBrightValue)+diff;
                if(parseInt(lBrightValue)>10) lBrightValue= 10;
                if(parseInt(lBrightValue)<1) lBrightValue= 1;
                var ret = ocxObject.GetVideoEffect(lBrightValue,lContrastValue,lSaturationValue,lHueValue);
            }
        }
    </script>
    <style type="text/css">
        .tree_title{
            line-height: 28px;
            font-weight: bold;
        }
        .tree_camera{
            line-height: 25px;
            padding-left: 20px;
        }
    </style>
</head>

<body onLoad="pageLoad();" style="background-color:#333;overflow: hidden;">
<table width="100%" height="100%" cellpadding="0" cellspacing="0" border="0">
    <tr>
        <td width="200" valign="top" style="background-color: white;">
            <div>
                <!-- camera list begin -->
                <c:forEach items="${regionList}" var="region">
                    <div class="tree_title">
                        <img src="${ctx}/skin/default/jquery/zTreeStyle/img/icons/default.gif" />${region.regionName}
                    </div>
                    <c:forEach items="${region.cameras}" var="camera">
                        <div class="tree_camera">
                            <img src="${ctx}/skin/default/jquery/zTreeStyle/img/icons/video_on.gif" />
                            <a href="#" onclick="loadXml('${camera.cameraId}')">${camera.cameraName}</a>
                        </div>
                    </c:forEach>
                </c:forEach>
                <!-- camera list end -->
            </div>
        </td>
        <td valign="top">
            <!-- camera view begin -->
            <table width="100%" cellpadding="0" cellspacing="0" border="0">
                <tr>
                    <td valign="top">
                        <object classid="clsid:D5E14042-7BF6-4E24-8B01-2F453E8154D7" id="OcxObject" width="600" height="400" name="OcxObject"></object>
                    </td>
                    <td valign="top" width="270"><table width="270" border="0" cellpadding="0" cellspacing="0">
                            <tr style="background:url(${ctx}/skin/default/img/title.jpg) repeat-x;color:#fff">
                                <td height="20" colspan="2">&nbsp;云台控制</td>
                            </tr>
                            <tr>
                                <td height="135" width="146"><img src="${ctx}/skin/default/img/control.jpg" id="opImage" usemap="#opImage" border="0"/></td>
                                <td valign="top" width="124"><img src="${ctx}/skin/default/img/control3.jpg" id="opImage3" usemap="#opImage3" border="0"/></td>
                            </tr>
                            <tr>
                                <td height="44" colspan="2">
                                    <img src="${ctx}/skin/default/img/control2.jpg" usemap="#opImage4" border="0"/>
                                </td>
                            </tr>
                            <tr style="background:url(${ctx}/skin/default/img/title.jpg) repeat-x;color:#fff">
                                <td height="20" colspan="2">&nbsp;插件下载</td>
                            </tr>
                            <tr>
                                <td height="50" valign="top" colspan="2">
                                    <div style="line-height: 40px">
                                    &nbsp;&nbsp;<a href="${ctx}/tools/cmsocx.exe" target="_blank"><font color="yellow">[视频插件cmsocx.exe]</font></a>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <map name="opImage">
                                        <area alt="上" id="up" shape="poly" coords="25,20,67.5,67.5,120,20,67.5,8" onclick="goptz(21)" onmousedown="changePic(3,true)" onmouseup="changePic(3,false)">
                                        <area alt="左" id="left" shape="poly" coords="25,20,67.5,67.5,25,100,8,67.5"  onclick="goptz(23)" onmousedown="changePic(1,true)" onmouseup="changePic(1,false)">
                                        <area alt="下" id="right" shape="poly" coords="25,100,67.5,67.5,120,115,67.5,127" onclick="goptz(22)" onmousedown="changePic(4,true)" onmouseup="changePic(4,false)">
                                        <area alt="右" id="down" shape="poly" coords="120,115,67.5,67.5,120,20,127,67.5" onclick="goptz(24)" onmousedown="changePic(2,true)" onmouseup="changePic(2,false)">

                                    </map>
                                    <map name="opImage3">
                                        <area alt="切换屏" shape="poly" coords="20,30,20,55,72,55,72,30" onclick="changeScreen(0)" style="cursor: pointer">
                                        <area alt="1分屏" shape="poly" coords="20,70,20,95,72,95,72,70" onclick="changeScreen(1)">
                                        <area alt="4分屏" shape="poly" coords="75,30,75,55,117,55,117,30" onclick="changeScreen(4)">
                                        <area alt="9分屏" shape="poly" coords="75,70,75,95,117,95,117,70" onclick="changeScreen(9)">
                                    </map>
                                    <map name="opImage4">
                                        <area alt="放大" shape="poly" coords="15,12,15,40,65,40,65,12" onclick="goptz(15)">
                                        <area alt="缩小" shape="poly" coords="80,12,80,40,130,40,130,12" onclick="goptz(16)">
                                        <area alt="调亮" shape="poly" coords="145,12,145,40,195,40,195,12" onclick="goEffect('Bright',1)">
                                        <area alt="调暗" shape="poly" coords="210,12,210,40,260,40,260,12" onclick="goEffect('Bright',2)">
                                    </map>
                                </td>
                            </tr>
                        </table></td>
                </tr>
            </table>
            <!-- camera view end -->
        </td>
    </tr>
</table>
</body>
</html>