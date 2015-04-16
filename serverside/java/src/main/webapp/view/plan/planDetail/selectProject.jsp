<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/default.css"/>
<script type="text/javascript">
    $(function () {
        $.parser.parse();
        $('#tabs').tabs({width: $("#tabs").parent().width(), height: $("#tabs").parent().height(), fit: true, border: false});
        $(window).resize(function () {
            setTimeout(function () {
                $('#tabs').tabs("resize");
            }, 500);
        });
        addTab("3个月未安排过的项目", "${ctx}/planDetail/selectProjectGrid.do?id=${id}&tabType=leaving", "tab1");
        addTab("未安排过的项目", "${ctx}/planDetail/selectProjectGrid.do?id=${id}&tabType=nothing", "tab2");
        addTab("存在重大危险源的项目", "${ctx}/planDetail/selectProjectGrid.do?id=${id}&tabType=danger", "tab3");
        addTab("全部项目", "${ctx}/planDetail/selectProjectGrid.do?id=${id}&tabType=all", "tab4");
    });
</script>
<div id="tabs" class="easyui-tabs1" style="width:100%;height:100%;"></div>

<%--<div id="selectIframe" style="width:100%;height:100%;margin:0">--%>
<%--<iframe width="100%" height="100%" frameborder="0" scrolling="auto" src="${ctx}/planDetail/selectProjectGrid.do?id=${id}"></iframe>--%>
<%--</div>--%>
