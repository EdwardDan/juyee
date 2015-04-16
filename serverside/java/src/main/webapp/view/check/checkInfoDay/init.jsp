<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/default.css"/>
<script type="text/javascript">
    $(function () {
        $.parser.parse();
        $('#tabs').tabs({width:$("#tabs").parent().width(), height:$("#tabs").parent().height(), fit:true, border:false});
        $(window).resize(function () {
            setTimeout(function () {
                $('#tabs').tabs("resize");
            }, 500);
        });
        addTab("当日考勤", "${ctx}/checkInfoDay/grid.do?gdCode=${gdCode}&jdTaskCode=${jdTaskCode}", "tab1");
        addTab("历史查询", "${ctx}/checkInfoHistory/grid.do?gdCode=${gdCode}&jdTaskCode=${jdTaskCode}", "tab2");
        addTab("人员情况", "${ctx}/checkInfoPerson/grid.do?gdCode=${gdCode}&jdTaskCode=${jdTaskCode}", "tab3");
        addTab("统计分析", "${ctx}/checkInfoCalc/grid.do?gdCode=${gdCode}&jdTaskCode=${jdTaskCode}", "tab4");

        //adjust height

    });
</script>

<div id="tabs" class="easyui-tabs1" style="width:100%;height:100%;"></div>