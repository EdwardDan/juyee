<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId="beanDwgc" ;
    //保存操作
    function save(btn) {
//        if (!validateForm(formId)) {
//            return;
//        }

        saveAjaxData("${ctx}/excelJdTasksOld/saveExcelJdDwgc.do", formId);

    }

</script>
<form:form commandName="beanDwgc">
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_header">
            <%--单位工程名称、单位工程编号、工程进度、工程类型、建筑面积、地上层数、地下层数、电梯台数、造价（万元）、结构类型--%>
            <td class="form_border" nowrap>单位工程名称</td>
            <td class="form_border" nowrap>单位工程编号</td>
            <td class="form_border" nowrap>工程进度</td>
            <td class="form_border" nowrap>工程类型</td>
            <td class="form_border" nowrap>建筑面积</td>
            <td class="form_border" nowrap>地上层数</td>
            <td class="form_border" nowrap>地下层数</td>
            <td class="form_border" nowrap>电梯台数</td>
            <td class="form_border" nowrap>造价（万元）</td>
            <td class="form_border" nowrap>结构类型</td>
        </tr>
        <c:forEach items="${list}" var="bean" varStatus="status">
            <tr class="<c:choose><c:when test="${status.index % 2==0}">tr_light</c:when><c:otherwise>tr_dark</c:otherwise></c:choose>">
                <td class="form_border" width="15%">${bean.dwgcName}</td>
                <td class="form_border" width="15%">${bean.dwgcCode}</td>
                <td class="form_border" width="10%">
                    <sys:code code="${proSchedule}" type="select" name="proSchedule" sysCodeDetailId=""
                              defaultName="${bean.proSchedule}" isSaveName="true"/>
                    <input type="hidden" name="dwgcIds" value="${bean.id}">
                </td>
                <td class="form_border" width="10%">${bean.projectType}</td>
                <td class="form_border" width="8%">${bean.dwgcArea}</td>
                <td class="form_border" width="8%">${bean.upCs}</td>
                <td class="form_border" width="8%">${bean.downCs}</td>
                <td class="form_border" width="8%">${bean.ts}</td>
                <td class="form_border" width="10%">${bean.dwgcMoney}</td>
                <td class="form_border" width="12%">${bean.structType}</td>
            </tr>
        </c:forEach>
        <tr class="tr_button">
            <td class="form_td_line" colspan="10">
                <input type="button" value="保存" class="button_confirm" onclick="save(this)">&nbsp;
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>
    </form:form>
