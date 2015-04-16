<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>行政区域划分</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
    <style type="text/css">
        body, html, #allmap {
            width: 100%;
            height: 100%;
            overflow: hidden;
            margin: 0;
        }
    </style>
    <script type="text/javascript" src="${ctx}/js/json2.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=F9cabee75e7f50bdda4eb6d715d51131"></script>
    <%--<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.4"></script>--%>
    <!--加载鼠标绘制工具-->
    <script type="text/javascript" src="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.js"></script>
    <link rel="stylesheet" href="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.css"/>
    <!--加载检索信息窗口-->
    <script type="text/javascript" src="http://api.map.baidu.com/library/SearchInfoWindow/1.4/src/SearchInfoWindow_min.js"></script>
    <link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.4/src/SearchInfoWindow_min.css"/>
    <!--加载工具类-->
    <script type="text/javascript" src="http://api.map.baidu.com/library/GeoUtils/1.2/src/GeoUtils_min.js"></script>
</head>

<body>
<div id="allmap"></div>
</body>
</html>
<script type="text/javascript">

    // 百度地图API功能
    var map = new BMap.Map("allmap");
    var point = map.centerAndZoom(new BMap.Point(121.51179,31.270095), 15);
    map.centerAndZoom(point, 11);
    var target;
    var overlays = [];
    var infoWindow;
    var polygonData = ${polygonData};

    //设置信息框内容，样式
    var opts = {
        width: 250,     // 信息窗口宽度
        height: 150,     // 信息窗口高度
        title: "街道设置", // 信息窗口标题
        enableMessage: false//设置允许信息窗发送短息
    };

    //设置填充样式
    var polygonOpacity = 0.3;  //区域填充色透明度
    var polygonOpacityChange = 0.6;  //区域填充色透明度_鼠标移上去
    var styleOptions = {
        strokeColor: "blue",    //边线颜色。
        fillColor: "blue",      //填充颜色。当参数为空时，圆形将没有填充效果。
        strokeWeight: 2,       //边线的宽度，以像素为单位。
        strokeOpacity: polygonOpacityChange,	   //边线透明度，取值范围0 - 1。
        fillOpacity: polygonOpacity,      //填充的透明度，取值范围0 - 1。
        strokeStyle: 'solid' //边线的样式，solid或dashed。
    };

    var initMap = function () {
        polygonData = eval(polygonData);
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
            addEvents(polygon,areaName,false);
        }
    };
    function addEvents(polygon,areaName,isSave){
        //保存后刷新区域显示文字
        if(isSave){
            for(var i=0;i<labelArray.length;i++){
                var lab = labelArray[i];
                var poi = lab.getPosition();
                var check = BMapLib.GeoUtils.isPointInPolygon(poi,polygon);
//                alert(poi+"|"+check);
                if(check){
                    map.removeOverlay(lab);
                    labelArray.splice(i,1);
                    break;
                }
            }
        }
        //点击事件
        polygon.addEventListener("click", editStreetListener);

        //增加鼠标移动上去和移开的颜色变化
        polygon.addEventListener("mouseover",function(){
            changeColor(this,polygonOpacityChange);
        });
        polygon.addEventListener("mouseout",function(){
            changeColor(this,polygonOpacity);
        });

        map.addOverlay(polygon);

        //加载区域文字
        showLabel(polygon,areaName);
    }
    //获取多边形中心点
    function getPolygonCenter(polygon){
        var bounds = polygon.getBounds();
        var ne = bounds.getNorthEast(); //东北脚点
        var sw = bounds.getSouthWest(); //西南脚点
        var lng = sw.lng+(ne.lng-sw.lng)/2;
        var lat = sw.lat+(ne.lat-sw.lat)/2;
        return new BMap.Point(lng, lat);
    }
    //显示区域的文字标签
    var labelArray = new Array();
    function showLabel(polygon,name){
        var pot = getPolygonCenter(polygon);
        if(pot==null) return;
        var opts1 = {
            position : pot,    // 指定文本标注所在的地理位置
            offset   : new BMap.Size(-10, 0)    //设置文本偏移量
        };
        var label = new BMap.Label(name, opts1);  // 创建文本标注对象
        label.setStyle({
            color : "#FF0000",
            fontSize : "14px",
            height : "20px",
            border:"0",
            fontFamily:"simsun",
            textAlign:"center",
            background:"none"
//            background:"#7A79F8"
        });
        label.enableMassClear();
        map.addOverlay(label);

        labelArray.push(label);
    }

    //添加平移，缩放工具条
    map.enableScrollWheelZoom();
    map.addControl(new BMap.NavigationControl({offset: new BMap.Size(5, 50)}));  //添加默认缩放平移控件
    var editStreetListener = function (e) {
        editStreet(e.target, e.point);

        //高亮闪烁显示鼠标点击的区域
        var polygon = e.target;
        var delay = 0;
        for (var flashTimes = 0; flashTimes < 4; flashTimes++) {
            delay += 200;
            setTimeout(function () {
                changeColor(polygon,polygonOpacity);
            }, delay);

            delay += 200;
            setTimeout(function () {
                changeColor(polygon,polygonOpacityChange);
            }, delay);
        }

    };
    var editStreet = function (o,clickPoint) {
        target = o;
//        map.addOverlay(o);
        if(clickPoint==null){
            if(target.getPath().length>0){
                clickPoint = target.getPath()[target.getPath().length-1];
            }
        }

        var selectId = "";
        if(target.id) selectId = target.id;
        $.ajax({
            type: 'POST',
            url: "${ctx}/projectStreet/getStreetInfo.do",
            data: {id: selectId },
            dataType: 'text',
            success: function (data) {
                infoWindow = new BMap.InfoWindow(''+data, opts);  // 创建信息窗口对象
                infoWindow.addEventListener("close", function () {
                    if (target.id == null) {
                        map.removeOverlay(target);
                    }
                    infoWindow.close();
                });
                map.openInfoWindow(infoWindow, clickPoint);
            },failure:function(ret){alert("获取街镇信息失败");}
        });
    };

    var polygonDelete = function () {
        if(!confirm("确定要删除此区域吗？")) return;
        infoWindow.close();
        if (target.id) {
            $.ajax({
                type: 'POST',
                url: "${ctx}/projectStreet/drawDelete.do",
                data: {id: target.id },
                dataType: 'text',
                success: function (data) {
                    data = eval("(" + data + ")");
                    alert(data.msg);
                }});
        }
        map.removeOverlay(target);
    };

    var editPolygon = function () {
        target.enableEditing();
        infoWindow.close();
    };

    function save() {
        var streetId = document.getElementById("streetId").value;
        if(streetId == null || streetId == ""){
            alert("请选择街镇");
            return;
        }
        var color = document.getElementById("color").value;
        if(color == null || color == ""){
            alert("请选择颜色");
            return;
        }
        var pointData = JSON.stringify(target.getPath());
        if (!target.id) {
            target.id = '';
        }
        $.ajax({
            type: 'POST',
            url: "${ctx}/projectStreet/drawSave.do",
            data: {id: target.id, pointData: pointData, streetId: streetId,color:color },
            dataType: 'text',
            success: function (data) {
                data = eval("(" + data + ")");
                target.id = data.id;
                map.addOverlay(target);
                alert(data.msg);
//                target.addEventListener("click", editStreetListener);
                addEvents(target,data.name,true);
            },
        failure:function(ret){alert("保存失败");}});
        infoWindow.close();
        target.disableEditing();
    }

    //实例化鼠标绘制工具
    var drawingManager = new BMapLib.DrawingManager(map, {
        isOpen: false, //是否开启绘制模式
        enableDrawingTool: true, //是否显示工具栏
        drawingToolOptions: {
            anchor: BMAP_ANCHOR_TOP_RIGHT, //位置
            offset: new BMap.Size(10, 10), //偏离值
            scale: 0.8,//工具栏缩放比例
            drawingModes: [BMAP_DRAWING_POLYGON]
        },
        circleOptions: styleOptions, //圆的样式
        polylineOptions: styleOptions, //线的样式
        polygonOptions: styleOptions, //多边形的样式
        rectangleOptions: styleOptions //矩形的样式
    });

    //绘制结果函数
    var overlaycomplete = function (e) {
        overlays.push(e.overlay);
        drawingManager.close();
        for (var i = 0; i < overlays.length; i++) {
            overlays[i].disableEditing();
        }
        target = e.overlay;
        editStreet(target);
    };

    function changeColor(obj,opacity){
        if(obj != null){
//            obj.setStrokeColor(color);
//            obj.setFillColor(color);
            obj.setFillOpacity(opacity);
        }
    }

    //颜色选择
    var tmp_color_obj = null;
    function openColorSelect(obj){
        tmp_color_obj = obj;
        window.open('${ctx}/view/project/projectStreet/jscolor.htm',600,380);
    }
    function setColorValue(v){
        if(tmp_color_obj != null){
            tmp_color_obj.value = v;
        }
    }

    //添加鼠标绘制工具监听事件，用于获取绘制结果
    drawingManager.addEventListener('overlaycomplete', overlaycomplete);
    initMap();
</script>


