<%--<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<%@ include file="/common/taglibs.jsp" %>--%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">--%>
<%--<html xmlns="http://www.w3.org/1999/xhtml">--%>
<%--<head>--%>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>--%>
    <%--<title>欢迎访问${siteName}--${typeName}</title>--%>
    <%--<%@include file="common.jsp" %>--%>
    <%--<link href="${ctx}/view/www/images/style.css" rel="stylesheet" type="text/css"/>--%>
    <%--<script type="text/javascript">--%>
        <%--//页面初始化加载各模块数据--%>
        <%--$(function() {--%>
            <%--loadAjaxData("sideshowId", "${ctx}/site/getPictureSideShow.do?type=${type}");--%>
            <%--loadAjaxData("picId", "${ctx}/site/getIndexPicRolling.do");--%>

        <%--});--%>
    <%--</script>--%>
<%--</head>--%>

<%--<body>--%>
<%--<%@ include file="/view/www/top.jsp" %>--%>
<%--<div class="ContentHome">--%>
    <%--<div class="fous"  >--%>
        <%--<div class="one" >--%>
            <%--<div class="left_${type}" ></div>--%>
            <%--&lt;%&ndash;<div class="right"></div>&ndash;%&gt;--%>
        <%--</div>--%>
        <%--<div class="two" >--%>
            <%--<div class="left" id="sideshowId">--%>
                <%--<!-- 幻灯片 begin -->--%>
                <%--<!-- 幻灯片 end -->--%>
            <%--</div>--%>
            <%--<div class="right">--%>
                <%--&lt;%&ndash;<c:if test="${fn:length(topNews) }>0 ">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<div class="top">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<a href="javascript:void(0)" onclick="viewInfo(${topNews.id})">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<sys:cutString length="100">${topNews.contents} </sys:cutString></a>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</c:if>&ndash;%&gt;--%>
                <%--<div class="down">--%>
                    <%--<!-- 置顶记录 begin -->--%>
                <%--<c:forEach items="${pagepart1}" var="item">--%>
                        <%--<ul class="line">--%>
                            <%--<li>--%>
                                <%--<img src="${ctx}/view/www/images/dit.jpg" width="5" height="5" border="0"/>&nbsp;--%>
                                <%--<a href="javascript:void(0)" onclick="viewInfo(${item.id},'${type}')" title="${item.title}">--%>
                                    <%--<sys:cutString length="${listWordCountpart1}">${item.title}</sys:cutString>&nbsp;&nbsp;--%>
                                    <%--[<fmt:formatDate value="${item.reportDate}" pattern="yyyy年MM月dd日"/>]</a>--%>
                            <%--</li>--%>
                        <%--</ul>--%>
                 <%--</c:forEach>--%>
                    <%--<!-- 置顶记录 end -->--%>
                <%--</div>--%>
            <%--</div>--%>

            <%--<div class="three" >--%>
                <%--<div class="down">--%>
                    <%--<!-- 列表记录 begin -->--%>
                   <%--<c:forEach items="${pagepart2}" var="item">--%>
                        <%--<ul class="line">--%>
                            <%--<li>--%>
                                <%--&nbsp;<img src="${ctx}/view/www/images/dit.jpg" width="5" height="5" border="0"/>&nbsp;--%>
                                <%--<a href="javascript:void(0)" onclick="viewInfo(${item.id})" title="${item.title}">--%>
                                    <%--<sys:cutString length="${listWordCountpart2}">${item.title}</sys:cutString>&nbsp;&nbsp;--%>
                                    <%--[<fmt:formatDate value="${item.reportDate}" pattern="yyyy年MM月dd日"/>]</a>--%>
                            <%--</li>--%>
                        <%--</ul>--%>
                    <%--</c:forEach>--%>
                    <%--<!-- 列表记录 end -->--%>
                <%--</div>--%>
                <%--<%@ include file="/view/www/getPage.jsp" %>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="clr"></div>--%>
    <%--</div>--%>
    <%--<%@ include file="/view/www/right.jsp" %>--%>
     <%--<div class="clr"></div>--%>
<%--</div>--%>
<%--<%@ include file="/view/www/bottom.jsp" %>--%>
<%--</body>--%>
<%--</html>--%>
