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
        addTab("银行待收保证金", "${ctx}/projectBidPay/grid.do?statusType=STATUS_DS", "tab1");
        addTab("银行已确认待退", "${ctx}/projectBidPay/grid.do?statusType=STATUS_DT", "tab2");
        <c:forEach items="${list}" var="item" varStatus="status">
        <c:if test="${item.code != '3'}">
        addTab("${item.name}", "${ctx}/projectBidCheck/grid.do?codeStatus=${item.code}", "tab${status.index+3}");
        </c:if>
        </c:forEach>

    });
</script>

<div id="tabs" class="easyui-tabs1" style="width:100%;height:100%;"></div>
