<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!--图片展示滚动-->
<style type="text/css">
    <!--
    #demo {
        background: #FFF;
        overflow: hidden;
        border: 1px dashed #CCC;
        width: 660px;
        height: 120px;
        vertical-align:middle;
    }
    #demo img {
        border: 3px solid #F2F2F2;
    }
    #indemo {
        float: left;
        width: 800%;
    }
    #demo1 {
        float: left;
    }
    #demo2 {
        float: left;
    }
    -->
</style>
<div id="demo">
    <div id="indemo">
        <div id="demo1">
            <c:forEach items="${picList}" var="pic">
                <c:if test="${pic.id>0}">
                <a href="javascript:void(0)" onclick="viewInfo(${pic.id},'${OA_PUBLIC_INFO_TYPE_PIC}')" title="${bean.title}"></c:if>
                <img style="width:160px;height:110px" src="${ctx}${pic.url}" title="" border="1"></a>
            </c:forEach>
        </div>
        <div id="demo2"></div>
    </div>
</div>
<script type="text/javascript">
    var speed = 30; //数字越大速度越慢
    var tab = document.getElementById("demo");
    var tab1 = document.getElementById("demo1");
    var tab2 = document.getElementById("demo2");
    tab2.innerHTML = tab1.innerHTML;
    function Marquee() {
        if (tab2.offsetWidth - tab.scrollLeft <= 0)
            tab.scrollLeft -= tab1.offsetWidth
        else {
            tab.scrollLeft++;
        }
    }
    var MyMar = setInterval(Marquee, speed);
    tab.onmouseover = function() {
        clearInterval(MyMar)
    };
    tab.onmouseout = function() {
        MyMar = setInterval(Marquee, speed)
    };
</script>





