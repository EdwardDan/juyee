<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<style type="text/css">
    /** 仿 iOS 系统通知数字样式 **/
    span.num {
        background-color: #f00000;
        background-image: -webkit-linear-gradient(top, #f00, #600);  /**Chrome 10+, Saf5.1+, iOS 5+**/
        background-image:    -moz-linear-gradient(top, #f00, #600);  /**FF3.6+**/
        background-image:     -ms-linear-gradient(top, #f00, #600);  /**IE10**/
        background-image:      -o-linear-gradient(top, #f00, #600);  /**Opera 11.10+**/
        color: #fff;
        font-family: "Cetus", "Impact";
        font-weight: normal;
        font-size: 12px;
        padding: 1px 5px;
        /*border:2px solid #fff;*/
        border-radius: 15px;
        position: absolute;   /*会随浏览器移动*/
        margin-top: -5px;
        margin-left: -15px;
        /*box-shadow: 0 2px 3px 0px rgba(0,0,0,1);*/
        /*text-shadow: -1px -1px 0 #000;*/
        /*position: static;    /*固定方式，在IE兼容模式下显示错位*/
        /*top: -60px;*/
        /*margin-left: -15px;*/
        /*padding-left: -15px;*/
        z-index: 99999;
    }
</style>

<table width="98%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <c:forEach items="${list}" var="item">
            <td align="center"><img src="${themePath}/index_new/task_img/${item.img}.png" border="0" style="z-index: 998;cursor: pointer" onclick="parent.loadMainPage('${ctx}/${item.link}','${item.pos}')"/><c:if test="${item.count>0}"><span class="num"><c:choose><c:when test="${item.count>20}">更多</c:when><c:otherwise>${item.count}</c:otherwise></c:choose></span></c:if></td>
        </c:forEach>
    </tr>
    <tr>
        <c:forEach items="${list}" var="item">
            <td align="center"><strong>${item.name}</strong></td>
        </c:forEach>
    </tr>
</table>