<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        $(".easyui-layout").layout("collapse", "west");
        if (screen.width <= 1024) {
            $("#treeLeft").width("16em");
        }
        loadAjaxData("treeLeft", "${ctx}/gdMonitor/tree.do");
        loadAjaxData("treeRight", "${ctx}/gdMonitor/view.do");
        $("#treeBorder").css("height", $("#mainContent").height());
        ajustTreeHeight();
    });
</script>
<div class="treeLeft" id="treeLeft"></div>
<div class="treeBorder" id="treeBorder"></div>
<div class="treeRight" id="treeRight" style="background-color: #333; height: 100%;"></div>
