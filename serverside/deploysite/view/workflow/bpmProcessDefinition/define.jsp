<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<html xmlns:v="urn:schemas-microsoft-com:vml"
      xmlns="http://www.w3.org/TR/REC-html40">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5"/>
    <!--<link rel="stylesheet" type="text/css" href="visio.css"/>-->
    <title>${bean.name}</title>
    <style type="text/css">
        v\:* {
            behavior: url(#default#VML);
        }
    </style>
    <script type="text/javascript">
        //初始化操作：加载变化样式、设置底图链接、放大当前图片
        function init() {
            for (var i = 0; i < document.all.length; i++) {
                var obj = document.all[i];
                if (obj.tagName == "group" && obj.id == "ConvertedImage") {
                    obj.style.visibility = "visible";
                    break;
                }
            }
            //加载变化样式
            loadDefaultChangeStyle();

            //设置底图链接
//            alert(getImagedataObj())
        <%--getImagedataObj().src = "getEmz.html?id=${processDefinitionId}";--%>

            //放大当前图片
            var maxWidth = 900;    //显示最大宽度

            var groupObj = getGroupObj();
            var groupObj_width = groupObj.style.pixelWidth;
            var groupObj_height = groupObj.style.pixelHeight;
//            alert(groupObj_width+":"+groupObj_height);
            var pageWidth = document.body.clientWidth;
            if (pageWidth < maxWidth) maxWidth = pageWidth;
//            alert(maxWidth+":"+groupObj_width);
            if (maxWidth < groupObj_width) {
                maxWidth = groupObj_width;
                document.body.style.overflowX = "auto";
            } else {
                groupObj.style.pixelWidth = roundNumber(groupObj_width * (maxWidth / groupObj_width), 0) - 20;
                groupObj.style.pixelHeight = roundNumber(groupObj_height * (maxWidth / groupObj_width), 0) - 20;
                document.body.style.overflowX = "hidden";
            }
        }

        //加载节点颜色定义
        function loadDefaultChangeStyle() {
            if (document.all) {
                var shape = '<v:shapetype id="VISSHAPE_NEW" target="_parent" coordsize="2847,2000" coordorigin="-1000,-1000" filled="t" fillcolor="blue" stroked="t" strokecolor="blue" strokeweight="1"><v:fill opacity="0.3"/></v:shapetype>';
                document.all.VMLDiv.innerHTML = document.all.VMLDiv.innerHTML + shape;
            }
        }

        //改变节点颜色
        function changeShapeTyle(obj) {
            obj.type = "#VISSHAPE_NEW";
        }

        //获取group
        function getGroupObj() {
            var retObj = null;
            for (var i = 0; i < document.all.length; i++) {
                var obj = document.all[i];
                if (obj.tagName == "group" && obj.id != "") {
                    retObj = obj;
                    break;
                }
            }
            return retObj;
        }

        //根据pageID和shapeID获取所在节点
        function getShapeObj(pageID, shapeID) {
            var retObj = null;
            for (var i = 0; i < document.all.length; i++) {
                var obj = document.all[i];
                //因无法产生title，所以取消title判断条件
                if (obj.tagName == "shape" && obj.onclick != null) {
                    var str = "(" + pageID + "," + shapeID + ")";
                    if ((obj.onclick + "").indexOf(str) > -1) {
                        retObj = obj;
                        break;
                    }
                }
            }
            return retObj;
        }

        //获取imagedata
        function getImagedataObj() {
            var retObj = null;
            for (var i = 0; i < document.all.length; i++) {
                var obj = document.all[i];
                if (obj.tagName == "imagedata" && obj.src != "") {
                    retObj = obj;
                    break;
                }
            }
            return retObj;
        }

        function UpdateTooltip(obj, pageID, shapeID) {

        }
        function OnShapeClick(pageID, shapeID) {
            var obj = getShapeObj(pageID, shapeID);
            parent.openWindow("节点定义", "${ctx}/bpmNodeDefinition/nodeDefinition.do?id=${processDefinitionId}&shapeId=" + shapeID, false, 800, 560);
//            if(confirm("是否要改变颜色？此处供设置成功后返回调用改变节点颜色。"))
            //            {
            //                changeShapeTyle(obj);
            //            }
        }

        function OnSwimlineClick(pageID, shapeID) {
            var obj = getShapeObj(pageID, shapeID);
            parent.openWindow("泳道定义", "${ctx}/bpmNodeDefinition/processSwimlaneDefinition.do?id=${processDefinitionId}&shapeId=" + shapeID, false, 800, 560);
        }

        function roundNumber(oldNum, len) {
            if (null == len) len = 2;
            var add = 0;
            var s1 = oldNum + "";
            var start = s1.indexOf(".");
            if (start == -1) return oldNum;
            if (s1.substr(start + len + 1, 1) >= 5)add = 1;
            var temp = Math.pow(10, len);
            var s = Math.floor(oldNum * temp) + add;
            return (s / temp);
        }
    </script>
</head>

<body style="MARGIN:10px" onload="init()">
<div id="VMLDiv">

    <!-- 替换内容 begin -->
    ${vmlHtml}
    <!-- 替换内容 end -->

</div>
</body>
</html>
