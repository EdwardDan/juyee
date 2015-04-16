<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/default.css"/>

<script type="text/javascript">
    var pageParam = "&categoryCode=${categoryCode}&processDefinitionCode=";
    var processDefinitionCode = "${processDefinitionCode}";
    $(function () {
        $.parser.parse();
        $('#tabs').tabs({width:$("#tabs").parent().width(), height:$("#tabs").parent().height(), fit:true, border:false});
        $(window).resize(function () {
            setTimeout(function () {
                $('#tabs').tabs("resize");
            }, 500);
        });
        var baseUrl = {
            tab1:"${ctx}/bpmProcessInstance/grid.do?type=waitAudit&",
            tab2:"${ctx}/bpmProcessInstance/grid.do?type=hasAudit&",
            tab3:"${ctx}/bpmProcessInstance/grid.do?type=other&"
        };
        var isFirstLoad = 0;    //加载时会把所有的tabs都加载一遍，然后跳转到第一个，所以设isFirstLoad>2，避免一次所有都加载
        var opts = {
            onOpen:function (target) {
                var iframe = $("iframe", this);
                if ((isFirstLoad++) > 2) {
                    iframe.attr("src", baseUrl[iframe.attr("id")] + pageParam + processDefinitionCode);
                }
            }
        };
        addTab("待审列表", "", "tab1", opts);
        addTab("已审列表", "", "tab2", opts);
        <%--<c:if test="${isDisplayViewList}">--%>
        addTab("查看列表", "", "tab3", opts);
        <%--</c:if>--%>
    });
    function addTab(subtitle, url, id, opts) {
        var isFirstLoad = true;
        if (!$('#tabs').tabs('exists', subtitle)) {
            $('#tabs').tabs('add', $.extend({
                title:subtitle,
                content:createFrame('', id),
                closable:false,
                closed:true,
//			icon:icon
                onOpen:function () {
                    if (isFirstLoad) {
                        isFirstLoad = false;
                    } else {
                        $("#" + id).attr("src", url);
                    }
                }
            }, opts));
        } else {
            $('#tabs').tabs('select', subtitle);
            $('#mm-tabupdate').click();
        }
//	tabClose();
    }
</script>

<div id="tabs" class="easyui-tabs1" style="width:100%;height:100%;"></div>