<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        loadAjaxData("treeLeft", "${ctx}/jdRecordQuestion/grid.do?questionTypeCode=${questionTypeCode}");
        loadAjaxData("treeRight", "${ctx}/jdRecordQuestion/getQuestions.do?formTypeCode=${formTypeCode}&formId=${formId}&questionTypeCode=${questionTypeCode}");
        $("#treeBorder").css("height", 500);
//        ajustTreeHeight();
        $("#treeLeft").width("70%");
        $("#treeRight").width("25%");
    });

</script>
<div class="treeLeft" id="treeLeft" style="overflow-x: hidden;"></div>
<div class="treeBorder" id="treeBorder"></div>
<div class="treeRight" id="treeRight"></div>
