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
        addTab("项目基本情况", "${ctx}/projInfo/view.do?id=${projectId}&isTab=true", "tab1");
        addTab("工程投资情况", "${ctx}/projExtendCost/view.do?projectId=${projectId}", "tab2");
        addTab("前期计划安排", "${ctx}/projExtendPre/view.do?projectId=${projectId}", "tab3");
        <%--addTab("工程建设完成情况", "${ctx}/projExtendSchedule/view.do?projectId=${projectId}", "tab4");--%>
    });

    //tab按钮跳转
    function jumbTab(tabTitle) {
        $("#tabs").tabs("select", tabTitle);
    }
</script>

<div id="tabs" class="easyui-tabs1" style="width:100%;height:100%;"></div>