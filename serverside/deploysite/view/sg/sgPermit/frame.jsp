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
        $('#tabsChild').tabs({
            width: $("#tabsChild").parent().width(),
            height: $("#tabsChild").parent().height(),
            fit: true,
            border: false
        });
        $(window).resize(function () {
            setTimeout(function () {
                $('#tabsChild').tabs("resize");
            }, 500);
        });
        var baseUrl = {
            <c:choose>
            <c:when test="${act == 'add' || act == 'edit'  || act == 'accept' || act == 'audit'||act == 'jgzxYs'}">
            <c:choose>
            <c:when test="${act == 'add' || act == 'edit'}">
            tab1: "${ctx}/sgPermit/modify.do",
            tab2: "${ctx}/sgContractProjPerson/modify.do",
            tab3: "${ctx}/sgUnitProj/modify.do",
            </c:when>
            <c:when test="${act == 'accept'}">
            tab1: "${ctx}/sgPermit/accept.do",
            tab2: "${ctx}/sgContractProjPerson/view.do",
            tab3: "${ctx}/sgUnitProj/view.do",
            </c:when>
            <c:when test="${act == 'jgzxYs'}">
            tab1: "${ctx}/sgPermit/jgzxYs.do",
            tab2: "${ctx}/sgContractProjPerson/view.do",
            tab3: "${ctx}/sgUnitProj/view.do",
            </c:when>
            <c:otherwise>
            tab1: "${ctx}/sgPermit/audit.do",
            tab2: "${ctx}/sgContractProjPerson/view.do",
            tab3: "${ctx}/sgUnitProj/view.do",
            </c:otherwise>
            </c:choose>
            </c:when>
            <c:otherwise>
            tab1: "${ctx}/sgPermit/view.do",
            tab2: "${ctx}/sgContractProjPerson/view.do",
            tab3: "${ctx}/sgUnitProj/view.do",
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
        addTabChild("${projName}项目", "", "tab1", opts);
        addTabChild("参建单位和合同项目负责人信息", "", "tab2", opts);
        addTabChild("单位工程列表", "", "tab3", opts);
    });

    function addTabChild(subtitle, url, id, opts) {
        var isFirstLoad = true;
        if (!$('#tabsChild').tabs('exists', subtitle)) {
            $('#tabsChild').tabs('add', $.extend({
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
            $('#tabsChild').tabs('select', subtitle);
            $('#mm-tabupdate').click();
        }
//	tabClose();
    }
</script>

<div id="tabsChild" class="easyui-tabs1"></div>
