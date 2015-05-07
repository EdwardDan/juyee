<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/default.css"/>
<script type="text/javascript">
    $(function () {
        $.parser.parse();
        $('#tabs').tabs({width: $("#tabs").parent().width(), height:$("#tabs").parent().height(), border:false});
        <c:forEach items="${list}" var="item" varStatus="status">
        <c:if test="${item.code!=SYS_REGPERSON_TYPE_Gd}">
        addTab("${item.name}", "${ctx}/sysRegPerson/grid.do?"+encodeURI("regType=${item.code}"), "tab${status.index+1}");
        </c:if>
        </c:forEach>
    });
</script>

<div id="tabs" class="easyui-tabs1" style="width:100%;height:100%;"></div>