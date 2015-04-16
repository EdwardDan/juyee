<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>工作组地图分布</title>
    <%@include file="/common/header.jsp" %>
    <style type="text/css">
        html {
            height: 100%;
        }

        body {
            height: 100%;
            margin: 0;
            padding: 0;
        }

        #container {
            height: 100%;
        }

        #divStyle  img {
            border: none;
            background: url('http://api.map.baidu.com/library/MarkerTool/1.2/examples/images/icon.gif');
        }
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=1.2"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/library/MarkerTool/1.2/src/MarkerTool_min.js"></script>
    <%--<script type="text/javascript" src="${ctx}/js/jquery/jquery-1.7.1.min.js"></script>--%>
</head>
<script type="text/javascript">
    $(function () {
        if (${!showQuery}) {
            $("#firstRow").hide();
        }
    })
</script>
<body>
<form id="searchForm">
    <div id="searchContainer" class="form_div tr_title"
         style="z-index: 1000;position: absolute;;overflow-y: visible;background-repeat: repeat;">
        <div id="firstRow">
            巡检日期：<input type="text" name="time" id="time" value="${time}" class="input_date"
                        onClick="calendar('time');"/>
            <input type="button" name="query" id="query2" value="查询" onclick="search()" class="button_confirm"/>
            <%--<input type="button" name="query" value="重置" onclick="resetSearch()" class="button_cancel"/>--%>
        </div>
    </div>
</form>
<div id="container"></div>
<script type="text/javascript">
    var map;
    //项目坐标集合
    var BASEDATA;

    //创建和初始化地图函数：
    function initMap() {
//        var opts = { type:BMAP_NAVIGATION_CONTROL_LARGE };
        window.map = new BMap.Map("container");
        map.enableKeyboard();         // 开启键盘控制
        map.enableContinuousZoom();   // 开启连续缩放效果
        map.enableInertialDragging(); // 开启惯性拖拽效果
        map.enableScrollWheelZoom();

        //初始中心点
        map.centerAndZoom(new BMap.Point(121.249628, 31.045886), 14);

        map.addControl(new BMap.NavigationControl());

        search();
        map.addEventListener("tilesloaded", function () {
            if (BASEDATA) {
                addMarkers(BASEDATA);
            }
        });
    }

    function search() {
        map.clearOverlays();
        $.getJSON("${ctx}/pollingPersonMap/getMapData.do", $("#searchForm").serialize(), function (data) {
            BASEDATA = data;
            if (BASEDATA) {
                addMarkers(BASEDATA);
            }
        });
    }

    function resetSearch() {
        $("#searchForm").find(":text,select").val("");
        search();
    }

    function addMarkers(data) {
        for (var i = 0; i < data.length; i++) {
            var obj = data[i];
            if (obj.X != 0 && obj.Y != 0) {
                addMarker(obj, i);
            }
        }
    }

    //添加标记
    function addMarker(obj, i) {
        var point = new BMap.Point(obj.X, obj.Y);
        if (!isInTheMap(point) || (obj.num && obj.num == 1)) {
            return;
        }
        obj.num = 1;
        var marker = new BMap.Marker(point);
//        marker.setIcon(BMapLib.MarkerTool.SYS_ICONS[i+6]);
        marker.setIcon(BMapLib.MarkerTool.SYS_ICONS[8]);
        var label = new BMap.Label();
        label.setContent(obj.personName);
        label.setOffset(new BMap.Size(4, -15));
        marker.setLabel(label);
        (function () {
            var _iw = createInfoWindow(obj);
            marker.addEventListener("click", function () {
                this.openInfoWindow(_iw);
            });
        })();
        map.addOverlay(marker);
    }

    //创建InfoWindow
    function createInfoWindow(obj) {
        var script = "doView('" + obj.personid + "')";
        var projHref = '<a href="javascript:' + script + '">'+'<font color=red><b>组长：</b>' + obj.personName + '</font></a> <br/>';
        return new BMap.InfoWindow("" + projHref +
                "<br/><b>参加人员：</b>"
                +"" + (obj.attendPersons || ""));
    }

    //判断是否在map中
    function isInTheMap(point) {
        var bounds = map.getBounds();
        return bounds.containsPoint(point);
    }

    initMap();

    //查看监管人员巡检轨迹
    function doView(personid) {
        openFullWindow("${ctx}/pollingTrackMap/map.do?personid=" + personid + "&date=" + $("#time").val(), 950, 550);
    }

    $("#showMore").click(function () {
        $("#secondRow").slideToggle('normal');
    });
</script>
</body>
</html>
