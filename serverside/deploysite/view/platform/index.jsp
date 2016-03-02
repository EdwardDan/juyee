<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>上海市交通建设工程管理系统</title>
    <%@include file="/common/header.jsp" %>
    <script src="${ctx}/js/jquery/easyui/outlook2.js" type="text/javascript"></script>
    <link href="${ctx}/view/platform/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">
        //初始化

        var loadUrlObj = "mainContent";
        $(function () {
            loadHomePage();
            if (${not empty sessionScope.noticePassword}) {
                showInfoMsg("${sessionScope.noticePassword}", "warning", changePass);
            }
            <c:set value="" var="noticePassword" scope="session" />
        });

        //退出系统
        function loginOut() {
            if (checkVideoObj()) {   //判断视频object使用window自带confirm，解决div遮挡导致视频页面无法退出
                if (window.confirm('您确定要退出系统吗?')) {
                    location.href = '${ctx}/j_spring_security_logout';
                }
            } else {
                $.messager.confirm('系统提示', '您确定要退出系统吗?', function (r) {
                    if (r) {
                        location.href = '${ctx}/j_spring_security_logout';
                    }
                });
            }
        }

        //选中事件
        function menuClicked(no) {
            var li = document.getElementsByTagName("li");
            for (var i = 0; i < li.length; i++) {
                if (no == i) {
                    li[i].className = "a" + (i + 1) + "tag";
                } else {
                    li[i].className = "a" + (i + 1);
                }
            }
        }

        //加载页面
        function loadUrl(no, url, title) {
            if (title != null) {
                setLocation(title);
            } else {
                var obj = $(".a" + (no + 1) + " a");
                if(obj.length==0){
                    obj=$(".a"+(no + 1)+"tag a");
                }
                setLocation(obj[0].innerHTML);
            }

            if (no != null) {
                menuClicked(no);
            }
            if (url == null) {
                showInfoMsg("此功能正在开发中");
            } else {
                loadAjaxData(loadUrlObj, url);
            }
        }

        //弹出页面
        function openUrl(no, url) {
            menuClicked(no);
            window.open(url);
        }

        //修改密码
        function changePass() {
            if (!checkVideoObj()) {
                openWindow({title:'修改密码', maximizable:false}, "${ctx}/sysPassword/changePass.do", false, 460, 260);
            } else {
                alert("请先关闭视频再修改密码");
            }
        }

        //返回首页
        function loadHomePage() {
            loadAjaxData(loadUrlObj, "${ctx}/platform/main.do");
            setLocation("首页");
        }

        //加载模块
        function loadPlatPage(type) {
            switch (type) {
                case "sgxk":
                    loadUrl(0, '${ctx}/sgPermit/grid.do');
                    break;
                case "qxsgxk":
                    loadUrl(1, '${ctx}/areaSgPermit/grid.do');
                    break;
                case "fjxz":
                    loadUrl(2, '${ctx}/platform/attachDownload.do');
                    break;
                default:
                    loadHomePage();
            }
        }
    </script>
</head>

<body class="easyui-layout" style="overflow-y: hidden" scroll="no">

<!-- 顶部区域 begin -->
<div region="north" split="true" border="false" style="overflow: hidden; height: 121px;">
    <div class="Header">
        <div class="logo">
            <div class="title"></div>
            <div class="pic"></div>
        </div>

        <div class="nav">
            <div class="user" style="float:left;margin-left:10px">欢迎您，${realName} ！</div>
            <div style="float:right;margin-right:15px;margin-top:5px;color:gray;">
                <a href="javascript:void(0)" onclick="loadHomePage();" title="返回首页"><img
                        src="${ctx}/view/platform/images/title_icon_home.png"/>&nbsp;<b>返回首页</b></a>&nbsp;&nbsp;&nbsp;
                <a href="javascript:void(0)" onclick="changePass();" title="修改密码"><img
                        src="${ctx}/view/platform/images/title_icon_help.png"/>&nbsp;<b>修改密码</b></a>&nbsp;&nbsp;&nbsp;
                <a href="javascript:void(0)" onclick="loginOut();" title="退出系统"><img
                        src="${ctx}/view/platform/images/title_icon_quit.png"/>&nbsp;<b>退出系统</b></a>
            </div>
        </div>
    </div>
    <div class="clr"></div>
</div>
<!-- 顶部区域 end -->

<!-- 左部区域 end -->
<div region="west" hide="true" split="true" id="west" style="width:208px;">
    <div class="Left">
        <div class="line">
            <div class="title"></div>
            <div class="kuang">
                <ul>
                    <li class="a1">
                        <a href="javascript:void(0)" onclick="loadPlatPage('sgxk')">施工许可</a>
                    </li>
                </ul>
                <ul>
                    <li class="a2">
                        <a href="javascript:void(0)" onclick="loadPlatPage('qxsgxk')">区县施工许可</a>
                    </li>
                </ul>
                <ul>
                    <li class="a3">
                        <a href="javascript:void(0)" onclick="loadPlatPage('fjxz')">附件下载</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- 左部区域 end -->

<!-- 主页面区域 begin -->
<div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
    <div id="mainLocation" class="mainLocation">
        <div id="mainLocationDesc" style="padding-top:6px"></div>
    </div>
    <div id="mainContent" class="gridBody" style="width:100%;height:100%;background-color: #fff"></div>
</div>
<!-- 左部区域 end -->

<!-- 底部区域 begin -->
<div region="south" split="true" style="height: 1px; background: #D2E0F2; ">
    <div class="footer"><!--上海巨一科技发展有限公司--></div>
</div>
<!-- 左部区域 end -->

</body>
</html>
