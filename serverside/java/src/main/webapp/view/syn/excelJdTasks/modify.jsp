<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/default.css"/>
<script type="text/javascript">
    //无iframe方式
    $(function () {
        $('#tabsChild').tabs({
            border:false
        });
    });
</script>

<div id="tabsChild" class="easyui-tabs1">
    <div title="基本信息" closable="false" cache="false"  href="${ctx}/excelJdTasks/modifyTask.do?id=${id}"></div>
    <div title="单位工程" closable="false" cache="false"  href="${ctx}/excelJdTasks/modifyDwgc.do?id=${id}"></div>
</div>