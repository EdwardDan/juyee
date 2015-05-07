<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div"></div>
<script type="text/javascript">
    (function () {
        $.messager.alert("系统提示", "当前节点不需要设置!", "info", function () {
            closeWindow();
        });
    })();
</script>