<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎访问${siteName}--${typeName}</title>
    <link href="${ctx}/view/www/images/style.css" rel="stylesheet" type="text/css"/>
    <%@include file="common.jsp" %>
    <script type="text/javascript">
        //页面初始化加载各模块数据
        $(function () {
            loadAjaxData("sideshowId", "${ctx}/site/getPictureSideShow.do?type=${type}");
            loadAjaxData("picId", "${ctx}/site/getIndexPicRolling.do");
        });
    </script>
</head>

<body>
<%@ include file="/view/www/top.jsp" %>
<div class="ContentHome">
    <div class="fous">
        <div class="one">
            <div class="left_${type}"></div>
            <%--<div class="right">更多>></div>--%>
        </div>
        <div class="two">
            <div class="left" id="sideshowId"></div>
            <div class="right">
                <div class="top">&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">为确保本区建设工程节后复工的安全生产，进一步深化建筑施工整治实效，区建管所安监科于2月13日至2月24日开展了虹口区2012年建设工程春节后复工安全生产专项检查...</a>
                </div>
                <div class="down">
                    <!-- 置顶记录 begin -->
                    <c:forEach items="${topList}" var="item">
                        <ul class="line">
                            <li>
                                <img src="${ctx}/view/www/images/dit.jpg" width="5" height="5" border="0"/>&nbsp;&nbsp;
                                <a href="javascript:void(0)" onclick="viewPic(${item.id})" title="${item.title}">
                                    <sys:cutString length="${topWordCount}">${item.title}</sys:cutString>&nbsp;&nbsp;
                                    [<fmt:formatDate value="${item.reportDate}" pattern="yyyy年MM月dd日"/>]
                                </a>
                            </li>
                        </ul>
                    </c:forEach>
                    <!-- 置顶记录 end -->
                </div>
            </div>

            <div class="three">
                <div class="down">
                    <!-- 列表记录 begin -->
                    <c:forEach items="${page.rows}" var="item">
                        <ul class="line">
                            <li>
                                <img src="${ctx}/view/www/images/dit.jpg" width="5" height="5" border="0"/>&nbsp;&nbsp;
                                <a href="javascript:void(0)" onclick="viewPic(${item.id})" title="${item.title}">
                                    <sys:cutString length="${listWordCount}">${item.title}</sys:cutString>&nbsp;&nbsp;
                                    [<fmt:formatDate value="${item.reportDate}" pattern="yyyy年MM月dd日"/>]
                                </a>
                            </li>
                        </ul>
                    </c:forEach>
                    <!-- 列表记录 end -->
                </div>
                <%@ include file="/view/www/getPage.jsp" %>
            </div>
        </div>
    </div>

    <%@ include file="/view/www/right.jsp" %>
</div>
<%@ include file="/view/www/bottom.jsp" %>
</body>
</html>
