<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/default.css"/>
<script type="text/javascript">
    $(function () {
        $('#tabs').tabs({width:$("#tabs").parent().width(), height:$("#mainContent").height() - 50, fit:true, border:false});
        $(window).resize(function () {
            setTimeout(function () {
                $("#treeRight").height($("#mainContent").height() - 50);
                $('#tabs').tabs("resize");
            }, 500);
        });
        addTab("基本信息", "${ctx}/bpmProcessDefinition/modify.do?id=${processDefinitionId}", "tab1");
        addTab("节点设置", "${ctx}/bpmProcessDefinition/define.do?id=${processDefinitionId}", "tab2");
        addTab("查看泳道", "${ctx}/bpmProcessDefinition/viewSwimlane.do?id=${processDefinitionId}", "tab3");
        addTab("模板信息", "${ctx}/bpmProcessDefinition/template.do?id=${processDefinitionId}", "tab4");
        addTab("历史版本", "${ctx}/bpmProcessDefinition/version.do?id=${processDefinitionId}", "tab5");
        addTab("发布管理", "${ctx}/bpmProcessDefinition/deployManager.do?id=${processDefinitionId}", "tab6");
        addTab("业务绑定", "${ctx}/bpmProcessDefinition/bizBinding.do?id=${processDefinitionId}", "tab7");
    });
</script>

<div id="tabs" class="easyui-tabs1" style="width:100%;height:100%;"></div>