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
        addTab("首次监督", "${ctx}/jdRecordFirst/grid.do?code=${code}", "tab1");

        <c:choose>
        <c:when test="${code=='quality'}">
        addTab("过程质量监督", "${ctx}/jdRecordQuality/grid.do", "tab2");
        addTab("竣工验收监督", "${ctx}/jdRecordComplete/grid.do?code=${code}", "tab4");
        </c:when>
        <c:otherwise>
        addTab("过程安全监督", "${ctx}/jdRecordSafe/grid.do", "tab3");
        <%--addTab("现场踏勘监督", "${ctx}/jdRecordComplete/grid.do?code=${code}", "tab3");   //grid.jsp需同步修改--%>
        </c:otherwise>
        </c:choose>
    });
</script>

<div id="tabs" class="easyui-tabs1" style="width:100%;height:100%;"></div>
