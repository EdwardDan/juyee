<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    $(function () {
        loginCheck();

    });
    function loginCheck() {
        loadAjaxDataCallback(null, "${ctx}/platform/loginCheck.do?loginName=${loginName}&password=${password}&jumpUrl=${ctx}${jumpUrl}", backThing);
    }

    function backThing(ret) {
        var obj = eval("(" + ret + ")");
        if (obj.success) {
            window.location.href = obj.url;
        }
    }
</script>

