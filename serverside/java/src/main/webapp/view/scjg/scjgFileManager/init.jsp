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
        addTab("交办件", "${ctx}/scjgFileAssign/grid.do", "tab1");
        addTab("来件处理", "${ctx}/scjgFileReceive/grid.do", "tab2");
        addTab("信访处理", "${ctx}/scjgFilePetition/grid.do", "tab3");

    });
</script>

<div id="tabs" class="easyui-tabs1" style="width:100%;height:100%;"></div>