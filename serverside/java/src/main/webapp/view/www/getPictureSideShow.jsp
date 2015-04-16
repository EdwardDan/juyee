<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%--获取顶部的图片幻灯页面--%>
<link href="${ctx}/view/www/images/style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
    var _newnowi = 1;
    var imgnum = [1,2,3,4,5];
    var imgroll2 = function(id) {
        if (-1 != id) {
            _newnowi = id;
        }else{
            //避免第1张图片显示时间太长
           if(document.getElementById("topimg11").style.display == ""){
               _newnowi = 2;
           }

        }
        for (var i = 1; i <= imgnum.length; i++) {
            showOrHide(i,i == _newnowi);
        }

        _newnowi = _newnowi + 1;
        if (_newnowi > imgnum.length) {
            _newnowi = 1;
        }
    };

    function showOrHide(i,isShow){
        if(isShow){
            document.getElementById("topimg1" + i).style.display = "";
            document.getElementById("linkt1" + i).setAttribute("class", "linkBoxchoose");
            document.getElementById("linkt1" + i).setAttribute("className", "linkBoxchoose");
        }else{
            document.getElementById("topimg1" + i).style.display = "none";
            document.getElementById("linkt1" + i).setAttribute("class", "linkBox");
            document.getElementById("linkt1" + i).setAttribute("className", "linkBox");
        }
    }

    $(function() {
        for (var i = 1; i <= imgnum.length; i++) {
            showOrHide(i,i==1);
        }
        var interval1 = window.setInterval("imgroll2(-1)", 3500);
    });
</script>
<div style="float:left;padding-left:5px;">
    <div style="float:left;position:absolute;">
        <c:forEach items="${newsUrl}" var="news" varStatus="i">
        <c:choose>
        <c:when test="${news.id!='none'}"><a href="${ctx}/site/infoView.do?id=${news.id}" target="_blank" title="${news.titles}"></c:when>
        <c:otherwise><a href="#"></c:otherwise>
            </c:choose>
                <img id="topimg1${i.index+1}" src="${ctx}${news.urls}" alt="${news.titles}"
                     style="width:236px;height:188px;position:absolute;"/>
        </a>
        </c:forEach>
    </div>
    <div style="float:left;margin-top:171px;margin-left:155px;position:absolute;background-color:#ACE1FA;">
        <table border="0" cellpadding="0" cellspacing="1">
            <tr>
                <c:forEach items="${newsUrl}" var="news" varStatus="i">

                    <td id="linkt1${i.index+1}" width="15px"
                        onmouseover="imgroll2(${i.index+1});clearInterval(interval1);"
                        onmouseout="interval1=window.setInterval('imgroll2(-1)',3500);"
                        class="linkBox">
                        <c:choose>
                        <c:when test="${news.id!='none'}"><a href="${ctx}/site/infoView.do?id=${news.id}" title="${news.titles}"></c:when>
                        <c:otherwise><a href="#"></c:otherwise>
                            </c:choose>
                                ${i.index+1}</a></td>

                </c:forEach>
            </tr>
        </table>
    </div>
</div>


