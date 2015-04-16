<%--<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<%@ include file="/common/taglibs.jsp" %>--%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">--%>
<%--<html xmlns="http://www.w3.org/1999/xhtml">--%>
<%--<head>--%>
    <%--<meta http-equiv="x-ua-compatible" content="ie=7"/>--%>
    <%--<meta name="keywords"--%>
          <%--content="虹口区建筑管理所,管理所,建筑,机构介绍,建管要闻,工作动态,公告公示,现行标准,行业风采,党群天地"/>--%>
    <%--<meta name="description"--%>
          <%--content="虹口建筑管理所，主要包括项目的机构介绍,建管要闻,工作动态,公告公示,现行标准,行业风采,党群天地"/>--%>
    <%--<meta name="虹口区建筑管理所" content="上海巨一科技发展有限公司">--%>
    <%--<meta name="上海巨一科技发展有限公司主营业务" content="工程项目管理咨询及软件开发、桥梁公路交通工程及结构监测工程与系统集成">--%>
    <%--<meta name="上海巨一科技发展有限公司主要资质认证" content="软件企业认定证书、ISO9001、ISO2000、高新技术企业认定证书、信息系统集成资质认定证书、保密系统集成资质证书、工程设计施工一级从业资格">--%>
    <%--<meta name="上海巨一科技发展有限公司主要产品" content="一体化工程项目管理信息系统IproMIS(产品编号：沪DGY-2005-0572)">--%>
    <%--<meta name="项目管理信息系统产品功能"--%>
          <%--content="服务于业主方项目管理，支持业主与各参建单位协同工作的集成项目管理信息系统；满足业主方对工程建设全过程、全方位的信息进行收集、加工、存贮、查询与报告要求；支持业主方对工程建设的投资、进度、质量、安全等目标的计划、跟踪与控制工作；实现业主方的网上办公以及业主与各参建单位之间基于网络的信息沟通和远程协作。">  --%>
    <%--<link href="${ctx}/view/www/images/style.css" rel="stylesheet" type="text/css"/>--%>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>--%>
    <%--<title>欢迎访问${siteName}</title>--%>
    <%--<%@include file="common.jsp" %>--%>
    <%--<script language="JavaScript" src="${ctx}/js/floatPic.js"></script>--%>
    <%--<script type="text/javascript">--%>
        <%--//页面初始化加载各模块数据--%>
        <%--$(function() {--%>
            <%--loadAjaxData("sideshowId", "${ctx}/site/getPictureSideShow.do");--%>
            <%--loadAjaxData("picId", "${ctx}/site/getIndexPicRolling.do");--%>

            <%--var adObj = new AdMove("floatPic");--%>
            <%--adObj.Run();--%>
        <%--});--%>
    <%--</script>--%>
<%--</head>--%>

<%--<body>--%>
<%--<div id="floatPic" style="position:absolute;z-index:999;">--%>
    <%--<a href="${ctx}/site/list.do?type=wsbslc" title="办事指南"><img src="${ctx}/view/www/images/floatPic.png" border="0"></a>--%>
<%--</div>--%>
<%--<%@ include file="/view/www/top.jsp" %>--%>
<%--<div class="ContentHome">--%>
    <%--<div class="fous">--%>
        <%--<div class="one">--%>
            <%--<div class="left_news"></div>--%>
            <%--<div class="right"><a href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_NEWS}"> 更多>></a></div>--%>
        <%--</div>--%>
        <%--<div class="two">--%>
            <%--<div class="left" id="sideshowId">--%>
                <%--<!-- 幻灯片 begin -->--%>
                <%--<!-- 幻灯片 end -->--%>
            <%--</div>--%>
            <%--<div class="right">--%>
                <%--&lt;%&ndash;建管要闻部分&ndash;%&gt;--%>
                <%--<div class="top">&nbsp;&nbsp;<a href="javascript:void(0)" onClick="viewInfo(${topNews.id})"><sys:cutString--%>
                        <%--length="110">${topNews.contents}--%>
                <%--</sys:cutString></a>--%>
                <%--</div>--%>
                <%--<div class="down">--%>
                    <%--<c:forEach items="${news}" var="bean">--%>
                        <%--<ul class="line">--%>
                            <%--<li><img src="${ctx}/view/www/images/dit.jpg" width="5" height="5"/>&nbsp;--%>
                                <%--<a href="javascript:void(0)"  onclick="viewInfo(${bean.id},'${OA_PUBLIC_INFO_TYPE_NEWS}')" title="${bean.title}">--%>
                                <%--<sys:cutString length="${maxWordCount}">${bean.title}</sys:cutString> </a>&nbsp;&nbsp;--%>
                                <%--[<fmt:formatDate value="${bean.reportDate}" pattern="yyyy年MM月dd日"/>]--%>
                            <%--</li>--%>
                        <%--</ul>--%>
                    <%--</c:forEach>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>

    <%--<%@ include file="/view/www/right.jsp" %>--%>
    <%--<div class="fousthree">--%>
        <%--<div class="left">--%>
            <%--<div class="top">--%>
                <%--<div class="one"></div>--%>
                <%--<div class="two"><a href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_BULLETIN}">更多>></a></div>--%>
            <%--</div>--%>
            <%--<div class="down">--%>
                <%--&lt;%&ndash;<div class="one"><img src="${ctx}/view/www/images/1.jpg" width="111" height="167"/></div>&ndash;%&gt;--%>
                <%--<div class="two">--%>
                    <%--&lt;%&ndash;公告公示部分&ndash;%&gt;--%>
                    <%--<c:forEach items="${bulletin}" var="bean">--%>
                        <%--<ul class="line">--%>
                            <%--<li><img src="${ctx}/view/www/images/dit.jpg" width="5" height="5"/>&nbsp;--%>
                                <%--<a href="javascript:void(0)" onclick="viewInfo(${bean.id},'${OA_PUBLIC_INFO_TYPE_BULLETIN}')"  title="${bean.title}">--%>
                                    <%--<sys:cutString length="${maxCountList}">${bean.title}</sys:cutString></a></li>--%>
                        <%--</ul>--%>
                    <%--</c:forEach>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="right">--%>
            <%--<div class="top">--%>
                <%--<div class="one"></div>--%>
                <%--<div class="two"><a href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_WORK}">更多>></a></div>--%>
            <%--</div>--%>
            <%--<div class="down">--%>
                <%--&lt;%&ndash;工作动态部分&ndash;%&gt;--%>
                <%--&lt;%&ndash;<div class="one"><img src="${ctx}/view/www/images/2.jpg" width="111" height="167"/></div>&ndash;%&gt;--%>
                <%--<div class="two">--%>
                    <%--<c:forEach items="${work}" var="bean">--%>
                        <%--<ul class="line">--%>
                            <%--<li><img src="${ctx}/view/www/images/dit.jpg" width="5" height="5"/>&nbsp;--%>
                                <%--<a href="javascript:void(0)" onclick="viewInfo(${bean.id},'${OA_PUBLIC_INFO_TYPE_WORK}')" title="${bean.title}">--%>
                                    <%--<sys:cutString  length="${maxCountList}">${bean.title}</sys:cutString></a></li>--%>
                        <%--</ul>--%>
                    <%--</c:forEach>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

    <%--</div>--%>
    <%--<div class="fouspic">--%>
        <%--<div class="left"><img src="${ctx}/view/www/images/fouspic.jpg"/></div>--%>
        <%--<div class="right" id="picId">--%>
            <%--&lt;%&ndash;展示图片&ndash;%&gt;--%>

        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="fousfour">--%>
        <%--<div class="left">--%>
            <%--<div class="top">--%>
                <%--<div class="one"></div>--%>
                <%--&lt;%&ndash;政务法则部分&ndash;%&gt;--%>
                <%--<div class="two"><a href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_POLICY}">更多>></a></div>--%>
            <%--</div>--%>
            <%--<div class="down">--%>
                <%--&lt;%&ndash;<div class="one"><img src="${ctx}/view/www/images/3.jpg" width="111" height="167"/></div>&ndash;%&gt;--%>
                <%--<div class="two">--%>
                    <%--<c:forEach items="${policy}" var="bean">--%>
                        <%--<ul class="line">--%>
                            <%--<li><img src="${ctx}/view/www/images/dit.jpg" width="5" height="5"/>&nbsp;--%>
                                <%--<a  href="javascript:void(0)" onclick="viewInfo(${bean.id},'${OA_PUBLIC_INFO_TYPE_POLICY}')" title="${bean.title}">--%>
                                    <%--<sys:cutString  length="${maxCountList}">${bean.title}</sys:cutString></a></li>--%>
                        <%--</ul>--%>
                    <%--</c:forEach>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="right">--%>
            <%--<div class="top">--%>
                <%--<div class="one"></div>--%>
                <%--&lt;%&ndash;行业风采部分&ndash;%&gt;--%>
                <%--<div class="two"><a href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_PIC}">更多>></a></div>--%>
            <%--</div>--%>
            <%--<div class="down">--%>
                <%--&lt;%&ndash;<div class="one"><img src="${ctx}/view/www/images/4.jpg" width="111" height="167"/></div>&ndash;%&gt;--%>
                <%--<div class="two">--%>
                    <%--<c:forEach items="${pic}" var="bean">--%>
                        <%--<ul class="line">--%>
                            <%--<li><img src="${ctx}/view/www/images/dit.jpg" width="5" height="5"/>&nbsp;--%>
                                <%--<a  href="javascript:void(0)" onclick="viewInfo(${bean.id},'${OA_PUBLIC_INFO_TYPE_PIC}')"  title="${bean.title}">--%>
                                    <%--<sys:cutString length="${maxCountList}">${bean.title}</sys:cutString></a></li>--%>
                        <%--</ul>--%>
                    <%--</c:forEach>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="clr"></div>--%>
<%--</div>--%>
<%--<div class="clr"></div>--%>

<%--<%@ include file="/view/www/bottom.jsp" %>--%>
<%--</body>--%>
<%--</html>--%>

