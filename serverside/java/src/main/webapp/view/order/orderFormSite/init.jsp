<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<link rel="stylesheet" type="text/css" href="${ctx}/skin/jquery/easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/skin/jquery/easyui/themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/skin/jquery/easyui/default.css"/>
<script type="text/javascript">
    $(function () {
        $.parser.parse();
        $('#tabs').tabs({width:$("#tabs").parent().width(), height:$("#tabs").parent().height(), fit:true, border:false});
        $(window).resize(function () {
            setTimeout(function () {
                $('#tabs').tabs("resize");
            }, 500);
        });
        addTab("监督预约", "${ctx}/orderFormSite/grid.do", "tab1");
        addTab("历史预约单", "${ctx}/orderFormSite/grid2.do", "tab2");
    });
</script>

<div id="tabs" class="easyui-tabs1" style="width:100%;height:100%;"></div>