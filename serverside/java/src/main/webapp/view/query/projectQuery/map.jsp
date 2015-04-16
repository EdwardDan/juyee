<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>项目地图分布</title>
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

    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
        body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;}
        #golist {display: none;}
        @media (max-device-width: 780px){#golist{display: block !important;}}
    </style>
</head>
<body>
<form id="searchForm">
    <div id="searchContainer" class="form_div tr_title"
         style="z-index: 1000;position: absolute;;overflow-y: visible;background-repeat: repeat;">
        <div id="firstRow">
            项目属地:<sys:code code="ProBelongArea" name="proBelongArea" type="select" isAlowedNull="true"
                           style="width:6em;" isSaveName="true"/>
            工程性质 <sys:code code="ProType" type="select" name="typeId" isAlowedNull="true" style="width:8em;"
                           isSaveName="true"/>&nbsp;&nbsp;
            <%--重大危险源:--%>
            <%--<select name="dangerType" id="dangerType" class="form_select" style="width: 9em;">--%>
            <%--<option value="">请选择:</option>--%>
            <%--<c:forEach items="${dangerTypes}" var="dangerType">--%>
            <%--<option value="${dangerType}">${dangerType}</option>--%>
            <%--</c:forEach>--%>
            <%--</select>--%>
            监督频率:
            <select name="frequency" id="frequency" class="form_select">
                <option value="">请选择:</option>
                <c:forEach items="${monthsCN}" var="month" varStatus="vs">
                    <option value="${vs.count}_true">${month}个月内有监督记录</option>
                    <option value="${vs.count}_false">${month}个月内无监督记录</option>
                </c:forEach>
            </select>
            建筑面积：
            <select name="area_operation" id="area_operation" class="form_select" style="width:7em;">
                <option value=">">大于</option>
                <option value="<=">小于等于</option>
            </select>
            <input type="text" class="input_text" name="totalArea" id="totalArea" style="width: 60px;"/>
            <input type="button" name="query" value="查询" onclick="search()" class="button_confirm"/>
            <input type="button" name="query" value="重置" onclick="resetSearch()" class="button_cancel"/>
            <span id="showMore" style="cursor: pointer;">更多</span>
        </div>
        <div id="secondRow" style="display: none;">
            <%--监督任务书编号:<input type="text" name="jdTaskCode" id="jdTaskCode" class="input_text" style="width:100px;"/>&nbsp;&nbsp;--%>
            报建编号:<input type="text" name="bjbh" id="bjbh" class="input_text" style="width:100px;"/>&nbsp;&nbsp;
            项目名称:<input type="text" name="name" id="name" class="input_text"/>&nbsp;&nbsp;
            <%--建设单位:<input type="text" name="buildUnitName" id="buildUnitName" class="input_text"/>&nbsp;&nbsp;--%>
            <%--施工单位:<input type="text" name="sgUnitName" id="sgUnitName" class="input_text"/>&nbsp;&nbsp;--%>
        </div>

        <%--<div id="divStyle">--%>
        <%--<img src="http://api.map.baidu.com/library/MarkerTool/1.2/examples/images/transparent.gif"--%>
        <%--style="width:19px;height:25px;background-position: 0 -21px"/>园林绿化项目--%>
        <%--<img src="http://api.map.baidu.com/library/MarkerTool/1.2/examples/images/transparent.gif"--%>
        <%--style="width:19px;height:25px;background-position: -23px -21px"/>水务项目--%>
        <%--<img src="http://api.map.baidu.com/library/MarkerTool/1.2/examples/images/transparent.gif"--%>
        <%--style="width:19px;height:25px;background-position: -46px -21px"/>新改扩建房屋建筑--%>
        <%--<img src="http://api.map.baidu.com/library/MarkerTool/1.2/examples/images/transparent.gif"--%>
        <%--style="width:19px;height:25px;background-position: -69px -21px"/>交通运输、市政基础设施--%>
        <%--<img src="http://api.map.baidu.com/library/MarkerTool/1.2/examples/images/transparent.gif"--%>
        <%--style="width:19px;height:25px;background-position: -92px -21px"/>一般住房修缮--%>
        <%--&lt;%&ndash;<img src="http://api.map.baidu.com/library/MarkerTool/1.2/examples/images/transparent.gif"&ndash;%&gt;--%>
        <%--&lt;%&ndash;style="width:19px;height:25px;background-position: -115px -21px"/>&ndash;%&gt;--%>
        <%--</div>--%>
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
        map.centerAndZoom(new BMap.Point(121.511754, 31.270146), 15);

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
        $.getJSON("${ctx}/projectQuery/getMapData.do", $("#searchForm").serialize(), function (data) {
            BASEDATA = data;
            if (BASEDATA) {
                addMarkers(BASEDATA);

                loadStreet();
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
                addMarker(obj);
            }
        }
    }

    //添加项目标记
    <%--var icon1 = new BMap.Icon('${ctx}/skin/default/map/hasvideo.png', new BMap.Size(31, 32), {});--%>
    <%--var icon2 = new BMap.Icon('${ctx}/skin/default/map/nosvideo.png', new BMap.Size(31, 32), {});--%>
    <%--var icon3 = new BMap.Icon('${ctx}/skin/default/map/unlawful.png', new BMap.Size(31, 32), {});--%>
    var icon1 = new BMap.Icon('${ctx}/skin/default/pollingMap/general1.png', new BMap.Size(31, 32), {});
    var icon2 = new BMap.Icon('${ctx}/skin/default/pollingMap/major1.png', new BMap.Size(31, 32), {});
    var icon3 = new BMap.Icon('${ctx}/skin/default/pollingMap/unlawfull.png', new BMap.Size(31, 32), {});
    function getMarkerIcon(type, isMajor,isUnlawFul) {
        if (isMajor) {
            return icon2;
        } else if (isUnlawFul) {
            return icon3;
        } else {
            return icon1;
        }
        <%--if ("${PROJECT_TYPE_HAS_VIDEO}" == type || "${PROJECT_TYPE_NO_VIDEO}" == type) {--%>
            <%--return icon1;--%>

        <%--} else if ("${PROJECT_TYPE_UNLAWFUL}" == type) {--%>
            <%--return icon3;--%>
        <%--}--%>
    }
    function addMarker(obj) {
        var point = new BMap.Point(obj.X, obj.Y);
        if (!isInTheMap(point)) {
            return;
        }
        var marker = new BMap.Marker(point);
        marker.setIcon(getMarkerIcon(obj.TYPE,obj.isMajor,obj.isUnlawFul));
//        marker.setIcon(BMapLib.MarkerTool.SYS_ICONS[6]);
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
        var projName = obj.NAME || "";
        var script = "doViewProj('" + obj.TYPE + "','" + obj.BJBH + "')";
        var projHref = '<a href="javascript:' + script + '">' + projName + '</a>';
        return new BMap.InfoWindow("" +
                "<b>分类：</b>" + (obj.TYPENAME || "")
                + "<br/><b>项目名称：</b>" + projHref);
    }


    //判断是否在map中
    function isInTheMap(point) {
        var bounds = map.getBounds();
        return bounds.containsPoint(point);
    }

    initMap();

    //查看项目
    function doViewProj(type, bjbh) {
        if ("${PROJECT_TYPE_HAS_VIDEO}" == type || "${PROJECT_TYPE_NO_VIDEO}" == type) {
            parent.openWindow("详细信息（报建编号：" + bjbh + "）", "${ctx}/projectQuery/view.do?bjbh=" + bjbh, false, 900, 550);

        } else if ("${PROJECT_TYPE_UNLAWFUL}" == type) {
            parent.openWindow("查看六无工地信息", "${ctx}/pollingUnlawfulProject/view.do?id=" + bjbh, false);
        }
    }

    $("#showMore").click(function () {
        $("#secondRow").slideToggle('normal');
    });

    //显示街镇
    //设置填充样式
    var polygonOpacity = 0.3;  //区域填充色透明度
    var polygonOpacityChange = 0.6;  //区域填充色透明度_鼠标移上去
    var styleOptions = {
        strokeColor:"blue", //边线颜色。
        fillColor:"blue", //填充颜色。当参数为空时，圆形将没有填充效果。
        strokeWeight:1, //边线的宽度，以像素为单位。
        strokeOpacity:polygonOpacity, //边线透明度，取值范围0 - 1。
        fillOpacity:polygonOpacity, //填充的透明度，取值范围0 - 1。
        strokeStyle:'solid' //边线的样式，solid或dashed。
    };

    function loadStreet() {
        var polygonData = eval(${polygonData});
        for (var i = 0; i < polygonData.length; i++) {
            var pointArray = [];
            var lastPoint = null;
            var areaName = polygonData[i].name;
            var color = polygonData[i].color;
            for (var j = 0; j < polygonData[i].pointData.length; j++) {
                var points = eval(polygonData[i].pointData[j]);
                lastPoint = new BMap.Point(points.lng, points.lat);
                pointArray.push(lastPoint);
            }
            styleOptions.strokeColor = color;
            styleOptions.fillColor = color;
            var polygon = new BMap.Polygon(pointArray, styleOptions);
            polygon.id = polygonData[i].id;

            //增加事件
            //增加鼠标移动上去和移开的颜色变化
            polygon.addEventListener("mouseover", function () {
                changeColor(this, polygonOpacityChange);
            });
            polygon.addEventListener("mouseout", function () {
                changeColor(this, polygonOpacity);
            });
            map.addOverlay(polygon);

            //加载区域文字
            showLabel(polygon, areaName);
        }
    }
    //显示区域的文字标签
    function showLabel(polygon, name) {
        var pot = getPolygonCenter(polygon);
        if (pot == null) return;
        var opts = {
            position:pot, // 指定文本标注所在的地理位置
            offset:new BMap.Size(-10, 0)    //设置文本偏移量
        };
        var label = new BMap.Label(name, opts);  // 创建文本标注对象
        label.setStyle({
            color:"#003333",
            fontSize:"14px",
            height:"20px",
            border:"0",
            fontFamily:"微软雅黑",
            textAlign:"center",
            background:"none"
//            background:"#7A79F8"
        });
//        label.enableMassClear();
        map.addOverlay(label);
    }
    //获取多边形中心点
    function getPolygonCenter(polygon) {
        var bounds = polygon.getBounds();
        var ne = bounds.getNorthEast(); //东北脚点
        var sw = bounds.getSouthWest(); //西南脚点
        var lng = sw.lng + (ne.lng - sw.lng) / 2;
        var lat = sw.lat + (ne.lat - sw.lat) / 2;
        return new BMap.Point(lng, lat);
    }
    function changeColor(obj, opacity) {
        if (obj != null) {
            obj.setFillOpacity(opacity);
        }
    }
</script>
</body>
</html>
