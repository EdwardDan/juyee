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
        addTab("我的任务<c:if test="${not empty count1}">(${count1})</c:if>", "${ctx}/oaTask/grid.do", "tab1");
        addTab("我的消息<c:if test="${not empty count2}">(${count2})</c:if>", "${ctx}/msgReceive/grid.do", "tab2");
        addTab("已处理任务", "${ctx}/oaTaskHistory/grid.do", "tab3");
    });
</script>

<div id="tabs" class="easyui-tabs1" style="width:100%;height:100%;">
</div>