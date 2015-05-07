<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<link rel="stylesheet" type="text/css" href="${themePath}/workflow/workflow.css"/>
<script type="text/javascript" src="${ctx}/js/workflow.js"></script>
<script type="text/javascript">
    function printExcel() {
        window.open("${ctx}/bpmProcessInstance/print.do?formId=${formId}&processInstanceId=${processInstanceId}");
    }
    function printExcelFR() {
        <%--var param = "report/${definitionCode}_${formCode}.cpt&pid=${processInstanceId}&fid=${formId}";--%>
        <%--window.open("${ctx}/ReportServer?reportlet=" + encodeURI(param));--%>
        printFR("${definitionCode}_${formCode}","pid=${processInstanceId}&fid=${formId}");
    }
    function doDelete(id) {
        if (confirm("确定要删除该流程及其相关记录吗")) {
            window.location = "${ctx}/bpmProcessInstance/delete.do?id=" + id;
        }
    }
    function jumpPage(btn, pageNo) {
        if (pageNo == ${pageNo}) {
            btn.disabled = true;
            return;
        }
        btn.value = "稍候";
        btn.disabled = true;
        window.location = "${ctx}/bpmProcessInstance/viewForm.do?processInstanceId=${processInstanceId}&type=${type}&pageNo=" + pageNo;
    }
</script>

<div align="right" style="height:35px;padding-top:5px">
    <c:if test="${prev != next}">
        <input type="button" class="button_normal" value="上页" onclick="jumpPage(this,${prev});"/>
        当前第${pageNo}页，总共${count}页
        <input type="button" class="button_normal" value="下页" onclick="jumpPage(this,${next});"/>
    </c:if>
    <c:if test="${formId != null}">
        <input type="button" class="button_all" value="打印" onclick="printExcel();"/>
        <%--<input type="button" class="button_normal_long" value="打印FR" onclick="printExcelFR();" <c:if test="${formCode}">disabled="true" title="无对应表单"</c:if>/>--%>
    </c:if>
    <c:if test="${canDelete}">
        <input type="button" name="button_back" class="button_cancel" value="删除"
               onclick="doDelete(${processInstanceId})"/>
    </c:if>
    <input name="button_back" type="button" class="button_cancel" value="关闭"
           onclick="parent.closeWindow()"/>
    &nbsp;
</div>
<div align="center">${bizHtml}<br><br></div>
<%--<div align="center"><jsp:include page="DocumentAttach.jsp"></jsp:include></div>--%>