<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<script type="text/javascript">
    //设为首页
    function setIndex(obj) {
        var url = window.location + "";

        if (document.all) {     //IE
            document.body.style.behavior = 'url(#default#homepage)';
            document.body.setHomePage(url);
        }
        else if (window.sidebar) {
            if (window.netscape) {
                try {
                    netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
                }
                catch (e) {
                    alert("您的浏览器未启用[设为首页]功能，开启方法：先在地址栏内输入about:config,然后将项 signed.applets.codebase_principal_support 值该为true即可");
                }
            }
            var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);
            prefs.setCharPref('browser.startup.homepage', url);
        }

    }
    //加入收藏
    function addFavi() {
        var url = window.location + "";
        if (document.all)    //IE
        {
            window.external.AddFavorite(url, '${siteName}');
        }
        else if (window.sidebar) {
            window.sidebar.addPanel('${siteName}', url, "");
        }
    }
</script>
<script src="${ctx}/view/www/Scripts/AC_RunActiveContent.js" type="text/javascript"></script>

<div class="Header">
    <div class="title" style="height: 113px">
        <%--<div class="top">--%>
            <%--<div class="time"></div>--%>
            <%--<div class="shortcuts" align="right">--%>
                <%--<img src="${ctx}/view/www/images/kj.jpg" width="212" height="24"--%>
                     <%--border="0" usemap="#Map"/>--%>
                <%--<map name="Map" id="Map">--%>
                    <%--<area shape="rect" coords="5,3,75,22" href="javascript:void(0);"--%>
                          <%--onclick="setIndex(this);" title="设为首页"/>--%>
                    <%--<area shape="rect" coords="75,3,141,22"--%>
                          <%--href="javascript:void(0);" onclick="addFavi();" title="加入收藏"/>--%>
                    <%--<area shape="rect" coords="141,3,196,22" href="#"--%>
                          <%--onclick="window.location = '${ctx}/site/about.do?type=Contact'" title="联系我们"/>--%>
                <%--</map>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="top_1">--%>
            <img src="${ctx}/view/www/images/wsbsdt_6.jpg" width="969" height="113" border="0">
            <%--<script type="text/javascript">--%>
                <%--AC_FL_RunContent('codebase', 'http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0', 'width', '969', 'height', '140', 'src', '${ctx}/view/www/images/title', 'quality', 'high', 'pluginspage', 'http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash', 'movie', '${ctx}/view/www/images/title'); //end AC code--%>
            <%--</script>--%>
            <%--<noscript>--%>
                <%--<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"--%>
                        <%--codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0"--%>
                        <%--width="969" height="140">--%>
                    <%--<param name="movie" value="${ctx}/view/www/images/title.swf"/>--%>
                    <%--<param name="quality" value="high"/>--%>
                    <%--<embed src="${ctx}/view/www/images/title.swf" quality="high"--%>
                           <%--pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash"--%>
                           <%--type="application/x-shockwave-flash" width="969" height="140"></embed>--%>
                <%--</object>--%>
            <%--</noscript>--%>
        <%--</div>--%>
    </div>
    <div class="nav">
        <%--<ul>--%>
            <%--<li class="n1">--%>
                <%--<a href="${ctx}/site/index.do?type=index"<c:if test="${type==null || type=='index'||type==''}">class="tag"</c:if>>首页</a>--%>
            <%--</li>--%>
            <%--<li class="n2">--%>
                <%--<a href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_INTRODUCTION}"--%>
                <%--<c:if test="${type == OA_PUBLIC_INFO_TYPE_INTRODUCTION}">class="tag"</c:if>>机构介绍</a>--%>
            <%--</li>--%>
            <%--<li class="n3">--%>
                <%--<a href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_NEWS}"--%>
                <%--<c:if test="${type == OA_PUBLIC_INFO_TYPE_NEWS}">class="tag"</c:if>>建管要闻</a>--%>
            <%--</li>--%>
            <%--<li class="n4">--%>
                <%--<a href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_WORK}"--%>
                <%--<c:if test="${type == OA_PUBLIC_INFO_TYPE_WORK}">class="tag"</c:if>>工作动态</a>--%>
            <%--</li>--%>
            <%--<li class="n5">--%>
                <%--<a href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_BULLETIN}"--%>
                <%--<c:if test="${type == OA_PUBLIC_INFO_TYPE_BULLETIN}"> class="tag"</c:if>>公告公示</a>--%>
            <%--</li>--%>
            <%--<li class="n6">--%>
                <%--<a href="${ctx}/site/list.do?type=${OA_PUBLIC_INO_TYPE_WSBSLC}"--%>
                        <%--<c:if test="${type == OA_PUBLIC_INO_TYPE_WSBSLC}"> class="tag"</c:if>>办事指南</a>--%>
            <%--</li>--%>
            <%--<li class="n7">--%>
                <%--<a href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_POLICY}"--%>
                <%--<c:if test="${type == OA_PUBLIC_INFO_TYPE_POLICY}"> class="tag"</c:if>>政策法规</a>--%>
            <%--</li>--%>
            <%--<li class="n8">--%>
                <%--<a href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_STANDARD}"--%>
                <%--<c:if test="${type == OA_PUBLIC_INFO_TYPE_STANDARD}"> class="tag"</c:if>>现行标准</a>--%>
            <%--</li>--%>
            <%--<li class="n9">--%>
                <%--<a href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_PIC}"--%>
                <%--<c:if test="${type == OA_PUBLIC_INFO_TYPE_PIC}"> class="tag"</c:if>>行业风采</a>--%>
            <%--</li>--%>
            <%--<li class="n10">--%>
                <%--<a href="${ctx}/site/list.do?type=${OA_PUBLIC_INO_TYPE_PARTYMEMBER}"--%>
                <%--<c:if test="${type == OA_PUBLIC_INO_TYPE_PARTYMEMBER}"> class="tag"</c:if>>党群天地</a>--%>
            <%--</li>--%>
        <%--</ul>--%>
    </div>
    <div class="clr"></div>
</div>


