<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function getOptions(id){
        var html = $("#menuContent_"+id).html();
        var options={
            animation:true,
            html:true,
            placement:"right",
//                trigger:"hover",
            trigger:"manual",
//                title:"菜单标题",
            content:html,
            delay:0,
            container:"body",
            selector:false
        };
        return options;
    }
    function hideWin(){
        $(".menu1,.menu2").each(function(){
            $(this).popover("hide");
        });
    }

    $(function () {
        //菜单展开
        var ids = "${menuIds}";
        var ss = ids.split(",");
        for(var i=0;i<ss.length;i++){
            $("#menu_"+ss[i]).popover(getOptions(ss[i])).on("mouseenter", function () {
                var _this = this;
                hideWin();  //hide all old menu
                $(this).popover("show");  //show current
                resetMenuHeight();
                $(this).siblings(".popover").on("mouseleave", function () {
                    $(_this).popover('hide');
                });
            }).on("mouseleave", function () {
                        var _this = this;
                        setTimeout(function () {
                            if (!$(".popover:hover").length) {
                                $(_this).popover("hide");
                            }
                        }, 100);
                    });
        }

        $(document).click(function() {
            hideWin();
        });
    });
    function resetMenuHeight() {
        var divMenuObj = $(".popover.fade.right.in");
        var winH = $(window).height();
        var objH = divMenuObj.height();
        var objT = divMenuObj.offset().top;

        var arrowObj = $(".arrow");
        var arrowT = arrowObj.offset().top;
        if ((objH + objT) > winH) {
//            alert((objH+objT)+"|"+winH);
            var t = winH - objH - 20;
            if (t < 0) t = 0;
            divMenuObj.css("top", t);

//            var at = arrowT-t-20;
            arrowObj.css("top", objH - 40);
        }
    }
    function loadMenuPage(url,targ,pos,parentId){
        if (url == "") {
            showInfoMsg("此功能正在开发中", null);
            return;
        }
        if(url.indexOf("http://")==-1){
            url = CONTEXT_NAME + "/" + url;
        }
        if("_blank"==targ){
            openFullWindow(url,screen.availWidth,screen.availHeight,"MIS");
        }else{
            loadMainPage(url, pos);
        }
        $(".menu2").each(function(){
           $(this).attr("class","menu1");
        });
        $("#menu_"+parentId).attr("class","menu2");
    }

    //阻止冒泡，点击不再触发隐藏div的事件
    function preventPop(event){
        //event.stopPropagation();
    }
</script>
<style type="text/css">
        /*** 菜单效果 ***/
    .menu1{
        width:76px;height: 58px;margin-top: 5px;margin-left: 10px;background-color: #F3F3F3;
    }
    .menu2{
        width:76px;height: 58px;margin-top: 5px;margin-left: 10px;background: url("${themePath}/index_new/djh.png");
    }
    .menu_first{
        font-family: "微软雅黑","simsun";
    }
    .menu_div{
        font-family: "微软雅黑","simsun";
        font-size: 12px;
        /*width: 400px;*/
        line-height: 30px;
        text-align: left;
        padding-top: 5px;
    }
    .menu_parent{
        font-family: "微软雅黑","simsun";
        color: #0057B1;
        font-weight: bold;
        float: left;
    }
    .menu_child_div{
        float: left;
        width: 350px;
    }
    .menu_child{
        font-family: "微软雅黑","simsun";
        line-height: 30px;
    }

    a.menu_link:link
    {
        color: #080808;
    }
    a.menu_link:visited
    {
        color: #080808;
    }
    a.menu_link:active
    {
        color: #080808;
    }
    a.menu_link:hover
    {
        color: #F26521;
        text-decoration: underline;
    }
</style>

<c:forEach items="${list}" var="first" varStatus="status">
    <%--<li>--%>
        <table border="0" align="center" cellpadding="0" cellspacing="0" class="<c:choose><c:when test="${status.index==0}">menu2</c:when><c:otherwise>menu1</c:otherwise></c:choose>" id="menu_${first.menu.id}" onclick="preventPop(event);">
            <tr>
                <td height="30" align="center"><img src="${themePath}/index_new/menu_icon/${first.menu.icon}.png" width="47" height="30" /></td>
            </tr>
            <tr>
                <td height="25" align="center" class="menu_first">${first.menu.name}</td>
            </tr>
        </table>
    <%--</li>--%>
</c:forEach>

<c:forEach items="${list}" var="first" varStatus="status">
    <div id="menuContent_${first.menu.id}" style="display: none">
        <div style="height: 10px"></div>
        <table border="0" class="menu_div" onclick="preventPop(event);">
            <c:forEach items="${first.menuList}" var="second">
                <tr>
                    <td nowrap class="menu_parent" valign="top">${second.menu1.name}</td>
                    <td nowrap class="menu_child_div" valign="top">
                        <c:set var="count" value="${fn:length(second.menu1List)}"/>
                        <c:forEach items="${second.menu1List}" var="third" varStatus="status">&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#" class="menu_link" onclick="loadMenuPage('${third.menu2.url}','${third.menu2.target}','${third.pos}','${first.menu.id}')"><span class="menu_child">${third.menu2.name}</span></a><c:if test="${status.index>0 && (status.index+1) % 4==0 && (status.index+1)<count}"><br></c:if> </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div style="height: 20px;float: left"><br>&nbsp;</div>
    </div>
</c:forEach>