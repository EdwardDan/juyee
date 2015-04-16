<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function doAlert(){
        closeWindow();
        viewMoreTask();
    }
</script>
<div align="center" style="height:100px;vertical-align:middle;padding-top:100px">
     <%--<div>未找到有效记录，可能该记录已经被删除或处理结束了！请到“<a href="javascript:doAlert();"><font color="blue">【更多任务】</font></a>”中删除此无效任务！</div>--%>
     <div>未找到有效记录，可能该记录已经被删除或处理结束了！</div>
</div>