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
            $("#OcxObject").height(newH-29-30);
            $("#OcxObject").width(w - 200);
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

        //更换分屏
        function changeScreen(count){
            ocxObject.SetWndNum(count);
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
                <tr style="background:url(${ctx}/skin/default/img/title.jpg) repeat-x;color:#fff">
                    <td height="30">&nbsp;&nbsp;<a href="${ctx}/tools/cmsocx.exe" target="_blank"><font color="yellow">[视频插件下载]</font></a></td>
                </tr>
                <tr>
                    <td valign="top">
                        <object classid="clsid:D5E14042-7BF6-4E24-8B01-2F453E8154D7" id="OcxObject" width="600" height="400" name="OcxObject"></object>
                    </td>
                </tr>
            </table>
            <!-- camera view end -->
        </td>
    </tr>
</table>
</body>
</html>