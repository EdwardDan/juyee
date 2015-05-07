<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/default.css"/>
<script type="text/javascript">
    $(function () {
        $('#nodeDefinitionTabs').tabs({
            border:false,
            fit:true
        });
    });
</script>

<div id="nodeDefinitionTabs" class="easyui-tabs1">
<c:forEach var="tab" items="${tabs}" varStatus="status">
    <div title="${tab.name}" closable="true" cache="false"
         href="${ctx}/bpmNodeDefinition/${tab.url}?id=${nodeId}"></div>
</c:forEach>