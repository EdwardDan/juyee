<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>地图标注</title>
    <%@include file="/common/header.jsp" %>
    <style type="text/css">
        html {
            height: 100%;
        }

        body {
            height: 100%;
            margin: 0px;
            padding: 0px;
        }

        #container {
            height: 100%;
        }
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=1.2"></script>
    <%--<script type="text/javascript" src="${ctx}/js/jquery/jquery-1.7.1.min.js"></script>--%>
</head>

<body onunload="//window.opener.loadThisGrid();">
<div id="container">
</div>
<script type="text/javascript">
    var initLevel = 14;
    var initCenterObj = {"x":121.263296, "y":31.062757};
    var map = new BMap.Map("container");          // 创建地图实例
    //        var centerPoint = new BMap.Point(121.450, 31.350);  // 创建点坐标
    //        map.centerAndZoom(centerPoint, 14);                 // 初始化地图，设置中心点坐标和地图级别
    var opts = { type:BMAP_NAVIGATION_CONTROL_LARGE };
    map.addControl(new BMap.NavigationControl(opts));
    map.enableScrollWheelZoom();  // 开启鼠标滚轮缩放
    map.enableKeyboard();         // 开启键盘控制
    map.enableContinuousZoom();   // 开启连续缩放效果
    map.enableInertialDragging(); // 开启惯性拖拽效果

    //项目坐标
    var data = "${pos}";
    if (data != "") {
        var jsonObject = eval("(" + data + ")");
        map.centerAndZoom(getMapCenter(jsonObject), initLevel);

        map.addEventListener("tilesloaded", function () {
            if (jsonObject.x != 0 && jsonObject.y != 0) {
                addMarker(jsonObject);
            }

        });
    } else {
        map.centerAndZoom(getMapCenter(initCenterObj), initLevel);
    }

    //获取初始中心点
    function getMapCenter(obj) {
        var point = new BMap.Point(initCenterObj.x, initCenterObj.y);
        if (obj.x != 0 && obj.y != 0) {
            point = new BMap.Point(obj.x, obj.y);
        }
        return point;
    }

    //添加标记
    var lastMarker = null;
    function addMarker(obj) {
        var point = new BMap.Point(obj.x, obj.y);
        if (!isInTheMap(point)) {
            return;
        }
        var marker = new BMap.Marker(point);
        map.addOverlay(marker);

        lastMarker = marker;
    }
    //移除标记
    function removeMarker() {
        if (lastMarker != null) {
            map.removeOverlay(lastMarker);
            lastMarker = null;
        }
    }
    //    var cacheMarker = {};
    //    function addMarker(obj) {
    //        var point = new BMap.Point(obj.x, obj.y);
    //        if (!isInTheMap(point) || cacheMarker[obj.bjbh]) {
    //            return;
    //        }
    //        var marker = new BMap.Marker(point);
    //        map.addOverlay(marker);
    //        cacheMarker[obj.bjbh] = true;
    //    }

    //判断是否在map中
    function isInTheMap(point) {
        var bounds = map.getBounds();
        return bounds.containsPoint(point);
    }

    var curMkr = null;
    //添加右键菜单
    var contextMenu = new BMap.ContextMenu();
    var txtMenuItem = [
        {
            text:'放大',
            callback:function () {
                map.zoomIn()
            }
        },
        {
            text:'缩小',
            callback:function () {
                map.zoomOut()
            }
        },
        {
            text:'放大到最大级',
            callback:function () {
                map.setZoom(18)
            }
        },
        {
            text:'在此添加标注',
            callback:function (p) {
                var marker = new BMap.Marker(p),
                        curMkr = marker;
                px = map.pointToPixel(p);
                var currPoint = marker.getPosition();
                if (confirm("是否将该点标注为考勤工地地点？\n当前坐标为：x:" + currPoint.lng + ",y:" + currPoint.lat)) {
                    $.ajax({
                        type:'POST',
                        url:"${ctx}/checkDeviceInfo/mapSave.do",
                        data:{id:"${id}", x:currPoint.lng, y:currPoint.lat},
                        dataType:'json',
                        success:function (data) {
                            if (data.success) {
                                removeMarker();
                                map.addOverlay(marker);
                                lastMarker = marker;

                                showInfoMsg(data.msg, null,window.opener.setPostion(currPoint.lng,currPoint.lat));

                            } else {
                                showErrorMsg("考勤工地坐标更新失败!\n" + data.msg);
                            }
                        }});
                }
            }
        }
    ];

    for (var i = 0; i < txtMenuItem.length; i++) {
        contextMenu.addItem(new BMap.MenuItem(txtMenuItem[i].text, txtMenuItem[i].callback, 100));
        if (i == 1 || i == 3) {
            contextMenu.addSeparator();
        }
    }

    map.addContextMenu(contextMenu);
</script>
</body>
</html>
