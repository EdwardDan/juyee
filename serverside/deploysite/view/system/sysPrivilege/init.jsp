<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        loadAjaxData("treeLeft", "${ctx}/sysPrivilege/tree.do");
        loadAjaxData("treeRight", "${ctx}/sysPrivilege/grid.do");
        $("#treeBorder").css("height", $("#mainContent").height());
        ajustTreeHeight();
    });
</script>
<div class="treeLeft" id="treeLeft"></div>
<div class="treeBorder" id="treeBorder"></div>
<div class="treeRight" id="treeRight"></div>