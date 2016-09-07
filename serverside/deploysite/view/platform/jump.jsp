<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<%@include file="/common/header.jsp" %>
<script src="${ctx}/js/jquery/easyui/outlook2.js" type="text/javascript"></script>
<link href="${ctx}/js/bootstrap/css/bootstrap-popover.css" rel="stylesheet" media="screen">
<script src="${ctx}/js/bootstrap/js/bootstrap-popover.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function () {
        loadAjaxData("mainContent",encodeURI('${url}'));
    });
</script>

<!-- 主页面区域 -->
<div id="mainPanle" region="center" style="background: #fff; overflow-y:auto">
    <div id="mainLocation" class="mainLocation" style="display: none">
        <div id="mainLocationDesc" style="padding-top:6px"></div>
    </div>
    <div id="mainContent" class="gridBody" style="width:100%;height:100%;position: absolute;overflow-y: auto;">
    </div>
</div>