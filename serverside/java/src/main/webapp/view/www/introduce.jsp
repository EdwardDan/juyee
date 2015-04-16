<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎访问${siteName}--${typeName}</title>
    <%@include file="common.jsp" %>
    <link href="${ctx}/view/www/images/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">
        //页面初始化加载各模块数据
        $(function() {
            <%--loadAjaxData("sideshowId", "${ctx}/site/getPictureSideShow.do?type=${type}");--%>
            <%--loadAjaxData("picId", "${ctx}/site/getIndexPicRolling.do");--%>

        });
    </script>
</head>

<body>
<%@ include file="/view/www/top.jsp" %>
<div class="ContentHome">
    <div class="fous">
        <div class="one">
            <div class="left_${type}"></div>
            <%--<div class="right"></div>--%>
        </div>
        <div class="three" style="height:800px" align="center"><br /><br />
          <img src="${ctx}/view/www/images/zzjgt.png" />
            <div class="right">
                <div class="down">
                </div>
            </div>
        </div>
      <div class="clr"></div>
    </div>
    <%@ include file="/view/www/right.jsp" %>
     <div class="clr"></div>
</div>
<%@ include file="/view/www/bottom.jsp" %>
</body>
</html>
