<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>监管人员巡检轨迹</title>
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
</head>
<body>
<form id="searchForm">
    <div id="searchContainer" class="form_div tr_title"
         style="z-index: 1000;position: absolute;;overflow-y: visible;background-repeat: repeat;">
        <div id="firstRow">
            监督负责人：${personName}&nbsp;&nbsp;
            日期：${date}&nbsp;&nbsp;
            设备编号:
            <select name="imei" id="imei" class="form_select" style="width:140px;">
                <c:forEach items="${imeiList}" var="item">
                    <option value="${item}" <c:if test="${item==imei}">selected</c:if>>${item}</option>
                </c:forEach>
            </select>
            <input type="hidden" name="date" id="date" value="${date}">
            <input type="hidden" name="personid" id="personid" value="${personid}">
            <input type="button" name="btnQuery" value="查询" onclick="searchAll(this)" class="button_confirm"/>
        </div>
    </div>
</form>
<div id="container"></div>
<script type="text/javascript">
    var map;

    //创建和初始化地图函数：
    function initMap() {
//        var opts = { type:BMAP_NAVIGATION_CONTROL_LARGE };
        window.map = new BMap.Map("container");
        map.enableKeyboard();         // 开启键盘控制
        map.enableContinuousZoom();   // 开启连续缩放效果
        map.enableInertialDragging(); // 开启惯性拖拽效果
        map.enableScrollWheelZoom();

        //初始中心点
        map.centerAndZoom(new BMap.Point(121.263296, 31.062757), 14);

        map.addControl(new BMap.NavigationControl());

        map.clearOverlays();
        searchAll(null);
//        map.addEventListener("tilesloaded", function () {
//            if (BASEDATA) {
//                addMarkers(BASEDATA);
//            }
//        });
    }
    function searchAll(btn) {
        //获取巡检轨迹
        searchTrack();

        //获取巡检项目
        searchProject();
    }

    //显示图标
    function getIcon(iconNo, iconName, offsetX, offsetY) {
        if (iconNo != null) {
            return BMapLib.MarkerTool.SYS_ICONS[iconNo];
        } else if (iconName != null) {
            if (offsetX != null) {
                return new BMap.Icon('${ctx}/skin/default/map/' + iconName, new BMap.Size(26, 30), {    anchor:new BMap.Size(offsetX, offsetY)});
            } else {
                return new BMap.Icon('${ctx}/skin/default/map/' + iconName, new BMap.Size(26, 30), {    anchor:new BMap.Size(13, 30)});
            }
        } else {
            return BMapLib.MarkerTool.SYS_ICONS[1];
        }
    }

    function searchTrack() {
        $.getJSON("${ctx}/pollingTrackMap/getTrackList.do", $("#searchForm").serialize(), function (data) {
            if (data) {
                var icon = getIcon(null, "zz_point.png", null, null);
                var pointerArray = new Array();
                var markerArray = new Array();
                for (var i = 0; i < data.length; i++) {
                    var obj = data[i];
                    if (obj.X != 0 && obj.Y != 0) {
                        var p = new BMap.Point(obj.X, obj.Y);
                        pointerArray.push(p);

                        var curIcon = icon;
                        if (i == 0) {
                            curIcon = getIcon(null, "zz_start.png", 18, 30);
                        }
                        else if (i == (data.length - 1)) {
                            curIcon = getIcon(null, "zz_end.png", 8, 30);
                        }
                        markerArray.push(new BMap.Marker(p, {icon:curIcon}));
                    }
                }
                //画线
                var polyline = new BMap.Polyline(pointerArray, {strokeColor:"blue", strokeWeight:6, strokeOpacity:0.7});
                map.addOverlay(polyline);
                //只添加开始和结束的标注
                map.addOverlay(markerArray[0]);
                map.addOverlay(markerArray[markerArray.length - 1]);

                //画点
//                for (var j = 0; j < markerArray.length; j++) {
                //显示可视区域内的标注
//                    var result = BMapLib.GeoUtils.isPointInRect(markerArray[j].point, map.getBounds());
//                    if (result)
//                    {
//                    map.addOverlay(markerArray[j]);
//                    }else{
//                        map.removeOverlay(markerArray[j]);
//                    }
//                }
            }
        });
    }
    function searchProject() {
        $.getJSON("${ctx}/pollingTrackMap/getProjectList.do", $("#searchForm").serialize(), function (data) {
            if (data != null) {
                addMarkers(data);
            }
        });
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
//        if (!isInTheMap(point)) {
//            return;
//        }
        var icon = BMapLib.MarkerTool.SYS_ICONS[8];
        var marker = new BMap.Marker(point);
        marker.setIcon(icon);
        marker.setZIndex(i);
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
        var projName = obj.projectName;
        var bjbh = obj.bjbh;
        var date = "${date}";
        var personid =  ${personid};
        var projHref = '<a href="${ctx}/pollingTrackMap/getPollingList.do?bjbh=' + bjbh + '&date=' + date + '&personid=' + personid + '" title="点击查看">' + projName + '</a>';
        var info = "<br><b>工程名称：</b>" + projHref + "<br>";
        info += "</br><b>报建编号：" + (obj.bjbh) + "&nbsp;&nbsp;监督任务书编号：" + (obj.jdTaskCode) + "</b><br/><b>监督日期：" + (obj.jdDatetime) + "&nbsp;&nbsp;</b>";
        return new BMap.InfoWindow("" + info);
    }


    //判断是否在map中
    function isInTheMap(point) {
        var bounds = map.getBounds();
        return bounds.containsPoint(point);
    }

    initMap();
    //    map.addEventListener("tilesloaded", searchAll(null));
    //    map.addEventListener("zoomend",  searchAll(null));
    //    map.addEventListener("moveend",  searchAll(null));

    $("#showMore").click(function () {
        $("#secondRow").slideToggle('normal');
    });
</script>
</body>
</html>