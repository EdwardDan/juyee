<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>网上办事平台</title>
    <%@include file="/common/header.jsp" %>
    <script src="${ctx}/js/jquery/easyui/outlook2.js" type="text/javascript"></script>
    <link href="${ctx}/view/platform/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">
        //初始化
        var loadUrlObj = "mainContent";
        $(function () {
            loadHomePage();
        });

        //退出系统
        function loginOut() {
            if (window.confirm('您确定要退出吗?')) {
                <%--window.location.href = "${ctx}/netProject/logout.do";--%>
                window.location.href = '${ctx}/netZbdl/logout.do';
                <%--window.location.href = '${ctx}/j_spring_security_logout';--%>
            }
        }

        <%--//报建流程--%>
        <%--function loadFlowPage() {--%>
            <%--loadAjaxData(loadUrlObj, "${ctx}/netProject/help.do");--%>
            <%--setLocation("报建流程");--%>
        <%--}--%>

        //返回首页
        function loadHomePage() {
            <%--<c:choose>--%>
            <%--<c:when test="${isAccept}">--%>
            <%--loadAjaxData(loadUrlObj, "${ctx}/netQuality/grid.do");--%>
            <%--setLocation("网上报建项目受理列表");--%>
            <%--</c:when>--%>
            <%--<c:otherwise>--%>
            loadAjaxData(loadUrlObj, "${ctx}/netZbdl/grid.do");
            setLocation("招标报名信息");
            <%--</c:otherwise>--%>
            <%--</c:choose>--%>
        }
    </script>
</head>

<body class="easyui-layout" style="overflow-y: hidden" scroll="no">

<!-- 顶部区域 begin -->
<div region="north" split="true" border="false" style="overflow: hidden; height: 123px;">
    <div class="Header">
        <div class="logo">
            <div class="title_net"></div>
            <div class="pic"></div>
        </div>

        <div class="nav">
            <div class="user" style="float:left;margin-left:10px;width: 500px">你好，${loginName}，欢迎登录网上办事平台！
            </div>
            <div style="float:right;margin-right:15px;margin-top:5px;color:gray;">
                <%--<a href="javascript:void(0)" onclick="loadFlowPage();" title="报建流程"><b>[报建流程]</b></a>&nbsp;&nbsp;&nbsp;--%>
                <%--<a href="javascript:void(0)" onclick="loadHomePage();" title="返回首页"><img--%>
                <%--src="${ctx}/view/platform/images/title_icon_home.png"/>&nbsp;<b>返回首页</b></a>&nbsp;&nbsp;&nbsp;--%>
                <a href="javascript:void(0)" onclick="loginOut();" title="退出"><img
                        src="${ctx}/view/platform/images/title_icon_quit.png"/>&nbsp;<b>退出</b></a>
            </div>
        </div>
    </div>
    <%--<div class="clr"></div>--%>
</div>
<!-- 顶部区域 end -->

<!-- 主页面区域 begin -->
<div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
    <div id="mainLocation" class="mainLocation">
        <div id="mainLocationDesc" style="padding-top:6px"></div>
    </div>
    <div id="mainContent" class="gridBody" style="width:100%;height:100%;background-color: #fff"></div>
</div>
<!-- 主页面区域 end -->

<!-- 底部区域 begin -->
<div region="south" split="true" style="height: 1px; background: #D2E0F2; ">
    <div class="footer"><!--上海巨一科技发展有限公司--></div>
</div>
<!-- 底部区域 end -->

</body>
</html>