<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>地图标注</title>
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
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=1.3"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/library/MarkerTool/1.2/src/MarkerTool_min.js"></script>
    <style type="text/css">
        .labelS {
            margin: 0;
            padding: 8px 14px;
            font-size: 13px;
            font-weight: normal;
            line-height: 18px;
            border-bottom: 1px solid #ebebeb;
            -webkit-border-radius: 5px 5px 0 0;
            -moz-border-radius: 5px 5px 0 0;
            border-radius: 5px 5px 0 0;
        }
    </style>
</head>


<body>
<div id="searchContainer" class="form_div tr_title"
     style="z-index: 1000;position: absolute;top: 0px;left: 0px;overflow-y: hidden;background-repeat: repeat;height: 30px;">
    <form id="searchForm">
        <div id="firstRow">
            <label class="labelS">项目名称:</label> <label  class="labelS"> ${name} </label>
            <label class="labelS"> 项目地址: </label><input type="text" id="buildAddress" name="buildAddress" class="input_text"
                                         value="${address}">
            <input type="button" value="查询" onclick="search()" class="button_query"/>
            <input type="button" value="关闭" onclick="window.close()" class="button_back_long" name="button_back">
        </div>
    </form>
</div>
<div id="container"></div>
<script type="text/javascript">
    var initLevel = ${level}; //默认14
    var initCenterObj = {"x": 121.612095, "y": 31.200391};
    var map = new BMap.Map("container");          // 创建地图实例
    //        var centerPoint = new BMap.Point(121.450, 31.350);  // 创建点坐标
    //        map.centerAndZoom(centerPoint, 14);                 // 初始化地图，设置中心点坐标和地图级别
    var opts = { type: BMAP_NAVIGATION_CONTROL_LARGE, offset: new BMap.Size(20, 40) };     //显示完整的平移缩放控件 和  设置放大缩小的位置
    map.addControl(new BMap.NavigationControl(opts));
    map.enableScrollWheelZoom();  // 开启鼠标滚轮缩放
    map.enableKeyboard();         // 开启键盘控制
    map.enableContinuousZoom();   // 开启连续缩放效果
    map.enableInertialDragging(); // 开启惯性拖拽效果
    map.addControl(new BMap.MapTypeControl({mapTypes: [BMAP_NORMAL_MAP, BMAP_HYBRID_MAP], offset: new BMap.Size(20, 40)}));     //2D图，卫星图
    //医院的ID号
    var id = "${bjbh}";

    //医院坐标
    var data = "${pos}";
    function setCenterPoint() {
        if (data != "") {
            var jsonObject = eval("(" + data + ")");
            if (jsonObject.x == 0 || jsonObject.y == 0) {
                search();
            }
            map.centerAndZoom(getMapCenter(jsonObject), initLevel);
            map.addEventListener("tilesloaded", function () {
                if (jsonObject.x != 0 && jsonObject.y != 0) {
                    addMarker(jsonObject);
                }
            });
        } else {
            map.centerAndZoom(getMapCenter(initCenterObj), initLevel);
        }
    }

    //获取初始中心点
    function getMapCenter(obj) {
        var point = new BMap.Point(initCenterObj.x, initCenterObj.y);
        if (obj.x != 0 && obj.y != 0) {
            point = new BMap.Point(obj.x, obj.y);
        }
        return point;
    }

    //按名称和地址查询医院信息进行标记
    var local = new BMap.LocalSearch(map, {
        renderOptions: {map: map, autoViewport: true}
    });

    function search() {
//        var projectName = document.getElementById("projectName");
        var buildAddress = document.getElementById("buildAddress");
        local.search(buildAddress.value);
    }

    function resetSearch() {
        $("#searchForm").find(":text,select").val("");
        search();
    }

    //添加标记
    var lastMarker = null;
    function addMarker(obj) {
        var point = new BMap.Point(obj.x, obj.y);
        if (!isInTheMap(point)) {
            return;
        }
        var marker = new BMap.Marker(point);
        marker.setIcon(BMapLib.MarkerTool.SYS_ICONS[10]);
        (function () {
            var _iw = createInfoWindow(obj);
            marker.addEventListener("click", function () {
                this.openInfoWindow(_iw);
            });
        })();
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

    //创建InfoWindow
    function createInfoWindow(obj) {
        return new BMap.InfoWindow("" +
                "<b>" + obj.name + "</b>"
                + "<br/>地址：" + (obj.address || ""));
    }

    //判断是否在map中
    function isInTheMap(point) {
        var bounds = map.getBounds();
        return bounds.containsPoint(point);
    }

    //刷新数据
    function refreshWindow() {
        window.location = "${ctx}/projectExtend/grid.do?queryValue=${queryValue}";
    }

    //添加右键菜单
    var contextMenu = new BMap.ContextMenu();
    var txtMenuItem = [
        {
            text: '关闭',
            callback: function () {
                closeWindow();
            }
        },
        {
            text: '放大',
            callback: function () {
                map.zoomIn();
            }
        },
        {
            text: '缩小',
            callback: function () {
                map.zoomOut();
            }
        },
        {
            text: '放大到最大级',
            callback: function () {
                map.setZoom(18);
            }
        },
        {
            text: '在此添加标注',
            callback: function (p) {
                var marker = new BMap.Marker(p),
                        px = map.pointToPixel(p);
                var currPoint = marker.getPosition();
                if (confirm("是否将该点标注为项目地点？\n当前坐标为：x:" + currPoint.lng + ",y:" + currPoint.lat)) {
                    $.ajax({
                        type: 'POST',
                        url: "${ctx}/projectExtend/saveMap.do",
                        data: {bjbh: "${bjbh}", x: currPoint.lng, y: currPoint.lat},
                        dataType: 'json',
                        success: function (data) {
                            initLevel = map.getZoom();
                            alert("项目坐标设置成功!");
                            if(window.opener) window.opener.refreshGrid(null);
                            closeWindow();
                        }});
                }
            }
        }
    ];

    for (var i = 0; i < txtMenuItem.length; i++) {
        contextMenu.addItem(new BMap.MenuItem(txtMenuItem[i].text, txtMenuItem[i].callback, 100));
        if (i == 0 || i == 3) {
            contextMenu.addSeparator();
        }
    }
    map.addContextMenu(contextMenu);
    setCenterPoint();

</script>
</body>
</html>
