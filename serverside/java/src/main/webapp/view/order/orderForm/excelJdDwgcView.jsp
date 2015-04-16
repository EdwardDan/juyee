<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<fieldset class="form_fieldset">
    <legend align="left" class="form_legend">单位工程</legend>
    <table cellpadding="0" cellspacing="0" id="projectTable" bgcolor="#f0f8ff" style="width: 100%">

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
        <c:forEach items="${excelJdDwgcList}" var="bean" varStatus="status">
            <tr class="<c:choose><c:when test="${status.index % 2==0}">tr_light</c:when><c:otherwise>tr_dark</c:otherwise></c:choose>">
                <td class="form_border" width="18%">${bean.dwgcName}</td>
                <td class="form_border" width="12%">${bean.dwgcCode}</td>
                <td class="form_border" width="10%">
                    <c:if test="${isEdit}">
                        <sys:code code="${proSchedule}" type="select" name="proSchedule" sysCodeDetailId=""
                                  defaultName="${bean.proSchedule}" isSaveName="true" style="width:80px"/>
                        <input type="hidden" name="dwgcId" value="${bean.id}">
                    </c:if>
                    <c:if test="${!isEdit}">
                        ${bean.proSchedule}
                    </c:if>
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
    </table>
</fieldset>