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
        addTab("报建项目", "${ctx}/projectQuery/gridBJ.do?flag=${flag1}", "tab1");
        addTab("在监项目", "${ctx}/projectQuery/grid.do?flag=${flag2}", "tab2");
        <%--addTab("完工未验", "${ctx}/projectQuery/grid.do?flag=${flag3}", "tab3");--%>
        addTab("小型项目", "${ctx}/projectQuery/gridAJ.do?flag=${flag4}", "tab3");
        addTab("重大工程", "${ctx}/projectMajor/grid.do", "tab4");
        addTab("六无工地", "${ctx}/pollingUnlawfulProject/grid.do", "tab5");

    });
</script>

<div id="tabs" class="easyui-tabs1" style="width:100%;height:100%;"></div>