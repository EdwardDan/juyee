<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<link rel="stylesheet" type="text/css" href="${themePath}/workflow/workflow.css"/>
<script type="text/javascript" src="${ctx}/js/workflow.js"></script>

<script type="text/javascript">
    function viewFlowPic(value) {
        var url = "?id=" + value;
        openWindow("${ctx}/bpmProcessInstance/viewFlowPic.do" + url, 800, 600);
    }
    function viewFormData(processInstanceId, formId) {
        var url = "?processInstanceId=" + processInstanceId + "&formId=" + formId;
        openWindow("${ctx}/bpmProcessInstance/viewForm.do" + url, 800, 600);
    }
    function doDelete(id) {
        if (confirm("确定要删除该流程及其相关记录吗")) {
            window.location = "${ctx}/bpmProcessInstance/delete.do?id=" + id;
        }
    }
    //查看日志（如果从个人门户任务菜单进入那么必须加projectId，否则影响附件和下步审核人员）
    function doOpenWindow(currentProjectId) {
        var url = "${ctx}/bpmProcessInstance/log.do?bpmProcessInstanceId=${bean.id}";
        openWindow(url, 700, 400);
    }
</script>

<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td align="right" width="40%">编号:</td>
            <td><c:out value="${bean.code}"/>&nbsp;</td>
        </tr>
        <tr class="td_dark">
            <td align="right" width="40%">名称:</td>
            <td><c:out value="${bean.title}"/>&nbsp;</td>
        </tr>
        <tr class="td_light">
            <td align="right" width="40%">抄送人员:</td>
            <td>
                <c:choose>
                    <c:when test="${ccUserNames != ''}">${ccUserNames}</c:when>
                    <c:otherwise>无</c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr class="td_dark">
            <td align="right" width="40%">开始时间:</td>
            <td><fmt:formatDate value="${bean.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;</td>
        </tr>
        <tr class="td_light">
            <td align="right" width="40%">结束时间:</td>
            <td><fmt:formatDate value="${bean.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;</td>
        </tr>
        <tr class="td_dark">
            <td align="right" width="40%">表单:</td>
            <td>
                <c:forEach items="${formTemplates}" var="bpmForm">
                    <img src="${themePath}/workflow/doc.gif" style="cursor:pointer"
                         alt="${bpmForm.formTemplate.name}"
                         onclick="viewFormData('${bean.id}','${bpmForm.formTemplate.id}')">
                </c:forEach>
            </td>
        </tr>
        <tr class="td_light">
            <td align="right" width="40%">日志:</td>
            <td>
                <input type='button' title='查看日志' class='button_grid_custom' value='日志'
                       onClick='doOpenWindow("${currentProjId}");'/>
            </td>
        </tr>
        <tr class="td_dark">
            <td align="right" width="40%">当前状态:</td>
            <td>
                <input type='button' title='查看流转示意图' class='button_grid_custom' value='图示'
                       onClick='viewFlowPic(${bean.id})'/>
            </td>
        </tr>
        <tr class="tr_button">
            <td colspan="2" nowrap>
                <c:choose>
                    <c:when test="${from == 'opener'}">
                        <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
                    </c:when>
                    <c:otherwise>
                        <input name="button_back" type="button" class="button_back" value="返回"
                               onclick="history.back()">
                    </c:otherwise>
                </c:choose>
                <c:if test="${canDelete}">
                    <input name="button_back" type="button" class="button_cancel" value="删除"
                           onclick="doDelete(${ bean.id})">
                </c:if>
            </td>
        </tr>
    </table>
</div>