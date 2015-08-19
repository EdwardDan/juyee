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
        addTab("工作督办列表", "${ctx}/oaWorkWatch/grid.do?tab=tab1", "tab1");
        <c:if test="${canSum==true}">
        addTab("工作督办汇总列表", "${ctx}/oaWorkWatchSum/grid.do?tab=tab2", "tab2");
        </c:if>
    });

    //tab按钮跳转
    function jumbTab(tabTitle) {
        $("#tabs").tabs("select", tabTitle);
    }
</script>

<div id="tabs" class="easyui-tabs1" style="width:100%;height:100%;"></div>