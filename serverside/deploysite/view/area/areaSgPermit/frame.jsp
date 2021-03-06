<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<link rel="stylesheet" type="text/css" href="${ctx}/skin/jquery/easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/skin/jquery/easyui/themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/skin/jquery/easyui/default.css"/>

<script type="text/javascript">
    var pageParam = "?act=${act}&projectTypeId=${projectTypeId}&id=";
    var id = "${id}";
    $(function () {
        $.parser.parse();
        $('#tabs').tabs({
            width: $("#tabs").parent().width(),
            height: $("#tabs").parent().height(),
            fit: true,
            border: false
        });
        $(window).resize(function () {
            setTimeout(function () {
                $('#tabs').tabs("resize");
            }, 500);
        });
        var baseUrl = {
            <c:choose>
            <c:when test="${act == 'add' || act == 'edit'  || act == 'accept' || act == 'audit'}">
            <c:choose>
            <c:when test="${act == 'add' || act == 'edit'}">
            tab1: "${ctx}/areaSgPermit/modify.do",
            tab2: "${ctx}/areaProjPerson/modify.do",
            tab3: "${ctx}/areaSgUnitProj/modify.do",
            </c:when>
            <c:when test="${act == 'accept'}">
            tab1: "${ctx}/areaSgPermit/accept.do",
            tab2: "${ctx}/areaProjPerson/view.do",
            tab3: "${ctx}/areaSgUnitProj/view.do",
            </c:when>
            <c:otherwise>
            tab1: "${ctx}/areaSgPermit/audit.do",
            tab2: "${ctx}/areaProjPerson/view.do",
            tab3: "${ctx}/areaSgUnitProj/view.do",
            </c:otherwise>
            </c:choose>
            </c:when>
            <c:otherwise>
            tab1: "${ctx}/areaSgPermit/view.do",
            tab2: "${ctx}/areaProjPerson/view.do",
            tab3: "${ctx}/areaSgUnitProj/view.do",
            </c:otherwise>
            </c:choose>
        };
        var isFirstLoad = 0;    //加载时会把所有的tabs都加载一遍，然后跳转到第一个，所以设isFirstLoad>2，避免一次所有都加载
        var opts = {
            onOpen: function (target) {
                var iframe = $("iframe", this);
                if ((isFirstLoad++) > 1) {
                    iframe.attr("src", baseUrl[iframe.attr("id")] + pageParam + id);
                }
            }
        };
        addTab("${projName}项目", "", "tab1", opts);
        addTab("参建单位和合同项目负责人信息", "", "tab2", opts);
        addTab("单位工程列表", "", "tab3", opts);
    });
</script>

<div id="tabs" class="easyui-tabs1" style="width:100%;height:100%;"></div>
