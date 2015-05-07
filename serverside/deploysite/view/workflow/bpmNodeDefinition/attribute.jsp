<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function doChange() {
        var timeOutAction = document.getElementById("timeOutAction").value;
        if (timeOutAction == "1") {
            document.getElementById("defultTrisition").disabled = false;
        } else {
            document.getElementById("defultTrisition").disabled = true;
        }
    }
    var attributeFormId = "attributeForm";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"dateLimit", rule:"validate[custom[integer],maxSize[2]]"}
        ];
        validateInit(validateCondition, attributeFormId);
        doChange();
    });

    //保存操作
    function save(btn) {
        if (!validateForm(attributeFormId)) {
            return;
        }
        //提交表单
        saveAjaxData("${ctx}/bpmNodeDefinition/saveAttribute.do", attributeFormId);
    }
</script>

<form:form commandName="bean" id="attributeForm">
<form:hidden path="id"/>
<%--<input type="hidden" value='${gridParam}'>--%>
<table cellpadding="0" cellspacing="0" class="form_table">
<tr class="tr_light">
    <td width="40%" class="form_label">节点名称:</td>
    <td class="form_content">${bean.name}</td>
</tr>
<tr class="tr_dark">
    <td class="form_label">动作类型:</td>
    <td class="form_content">
        <select id="taskCreateType" name="taskCreateType">${actionTypeSelect}</select>
        <c:choose>
            <c:when test="${taskNodeDefinition.canForward==true}">
                <input id="isCanForward" name="isCanForward" type="checkbox" checked="true">
            </c:when>
            <c:otherwise>
                <input id="isCanForward" name="isCanForward" type="checkbox">
            </c:otherwise>
        </c:choose>
        允许转发
    </td>
</tr>
<tr class="tr_light">
    <td class="form_label">操作类型:</td>
    <td class="form_content">
        <c:choose>
            <c:when test="${taskNodeDefinition.operateType=='2'}">
                <input type="radio" id="standOperate" name="operateType" value="2" checked="true">
            </c:when>
            <c:otherwise>
                <input type="radio" id="standOperate" name="operateType" value="2">
            </c:otherwise>
        </c:choose>标准操作
    </td>
</tr>
<tr class="tr_light">
    <td class="form_label">&nbsp;</td>
    <td class="form_content">
        &nbsp;&nbsp;&nbsp;
        <c:choose>
            <c:when test="${taskNodeDefinition.showPermitted==true}">
                <input type="checkbox" id="isShowPermitted" name="isShowPermitted" checked="true">
            </c:when>
            <c:otherwise>
                <input type="checkbox" id="isShowPermitted" name="isShowPermitted">
            </c:otherwise>
        </c:choose>批注、否决和保留意见
    </td>
</tr>
<tr class="tr_light">
    <td class="form_label">&nbsp;</td>
    <td class="form_content">
        &nbsp;&nbsp;&nbsp;
        <c:choose>
            <c:when test="${taskNodeDefinition.showRead==true}">
                <input type="checkbox" id="isShowRead" name="isShowRead" checked="true">
            </c:when>
            <c:otherwise>
                <input type="checkbox" id="isShowRead" name="isShowRead">
            </c:otherwise>
        </c:choose>已阅、未阅
    </td>
</tr>
<tr class="tr_light">
    <td class="form_label">&nbsp;</td>
    <td class="form_content">
        &nbsp;&nbsp;&nbsp;
        <c:choose>
            <c:when test="${taskNodeDefinition.showOpinion==true}">
                <input type="checkbox" id="isShowOpinion" name="isShowOpinion" checked="true">
            </c:when>
            <c:otherwise>
                <input type="checkbox" id="isShowOpinion" name="isShowOpinion">
            </c:otherwise>
        </c:choose>审核意见
    </td>
</tr>
<tr class="tr_light">
    <td class="form_label">&nbsp;</td>
    <td class="form_content">
        &nbsp;&nbsp;&nbsp;
        <c:choose>
            <c:when test="${taskNodeDefinition.showUpload==true}">
                <input type="checkbox" id="isShowUpload" name="isShowUpload" checked="true">
            </c:when>
            <c:otherwise>
                <input type="checkbox" id="isShowUpload" name="isShowUpload">
            </c:otherwise>
        </c:choose>附件上传
    </td>
</tr>
<tr class="tr_dark">
    <td class="form_label">&nbsp;</td>
    <td class="form_content">
        <c:choose>
            <c:when test="${taskNodeDefinition.operateType=='1'}">
                <input type="radio" id="formOperate" name="operateType" value="1" checked="true">
            </c:when>
            <c:otherwise>
                <input type="radio" id="formOperate" name="operateType" value="1">
            </c:otherwise>
        </c:choose>表单操作
    </td>
</tr>
<tr class="tr_dark">
    <td class="form_label"></td>
    <td class="form_content">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;选择模板:
        <select id="templateId" name="templateId" style="width:200px" class="form_select_long">${formSelect}</select>
    </td>
</tr>
<tr class="tr_dark">
    <td class="form_label"></td>
    <td class="form_content">
        &nbsp;&nbsp;&nbsp;对应模板区域:
        <select name="privilegeNames" id="privilegeNames" multiple="multiple" class="form_multi_select"
                style="width:200px">
            <c:forEach var="privilege" items="${privileges}" varStatus="status">
                <option value="${privilege.id}">${privilege.name}</option>
            </c:forEach>
        </select>
        <input type="hidden" name="privilegeIds" id="privilegeIds" value="${privilegeIds}">
        <input type="button" class="button_select_add"
               onClick="multiSelectFormPrivilege($('#templateId').val(),'privilegeNames','privilegeIds',null);"
               value=" ">
        <input type="button" class="button_select_remove"
               onClick="removeMultiSelectOpt('privilegeNames','privilegeIds',null);"
               value=" ">

    </td>
</tr>
<tr class="tr_dark">
    <td class="form_label"></td>
    <td class="form_content">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;初始化脚本:
        <textarea id="initScript" name="initScript" rows="6"
                  style="width:400px">${taskNodeDefinition.initScript}</textarea>
        <input type="button" value="取值" class="button_all"
               onclick="$('#initScript').val($('#formDefaultSet').text());">（仅适用1个流程多份表单之间传递值）
               <span style="display:none" id="formDefaultSet">
(function() {
    var bpmProcessInstance = task.getProcessInstance();
    var taskInstances = bpmProcessInstance.getBpmTaskInstances();
    var maxId = 0;
    var maxTaskInstance = null;
    for (var iterator = taskInstances.iterator(); iterator.hasNext();) {
        var next = iterator.next();
        if (next.getBpmFormAction() != null && maxId < next.getId()) {
            maxId = next.getId();
            maxTaskInstance = next;
        }
    }
    if (maxTaskInstance != null) {
        return maxTaskInstance.getBpmFormAction().getFormXml();
    } else {
        return "";
    }
})();
               </span>
    </td>
</tr>
<tr class="tr_light">
    <td class="form_label">处理时限:</td>
    <td class="form_content">
        <input id="dateLimit" name="dateLimit" value="${taskNodeDefinition.dateLimit}" style="width:100px">天
        <c:choose>
            <c:when test="${taskNodeDefinition.dateType=='1'}">
                <input type="radio" id="workDay" name="dateType" value="1" checked="true">
            </c:when>
            <c:otherwise>
                <input type="radio" id="workDay" name="dateType" value="1">
            </c:otherwise>
        </c:choose>工作日
        <c:choose>
            <c:when test="${taskNodeDefinition.dateType=='day'}">
                <input type="radio" id="day" name="dateType" value="2" checked="true">
            </c:when>
            <c:otherwise>
                <input type="radio" id="day" name="dateType" value="2">
            </c:otherwise>
        </c:choose>自然日
    </td>
</tr>
<tr class="tr_dark">
    <td class="form_label">预警策略:</td>
    <td class="form_content">
        <select id="earlyWarning" name="earlyWarning" style="width:100px">${earlyWarningSelect}</select>
    </td>
</tr>
<tr class="tr_light">
    <td class="form_label">超时处理动作:</td>
    <td class="form_content">
        <select id="timeOutAction" name="timeOutAction" style="width:100px"
                onchange="doChange();">${timeOutActionSelect}</select>
    </td>
</tr>
<tr class="tr_dark">
    <td class="form_label">选择默认分支:</td>
    <td class="form_content">
        <select id="defultTrisition" name="defultTrisition"
                style="width:100px">${transitionSelect}</select>
    </td>
</tr>
<tr class="tr_light">
    <td class="form_label">节点是否要选择人员:</td>
    <td class="form_content">
        <input id="isSelectUser" name="isSelectUser" type="checkbox"
               <c:if test="${taskNodeDefinition.selectUser=='true'}">checked="true"</c:if> >
    </td>
</tr>
<tr class="tr_button">
    <td colspan="2" nowrap>
        <input name="button_confirm" type="button" class="button_confirm" onclick="save(this);" value="确定">
        <input name="button_reset" type="reset" class="button_all" value="重写">
        <input name="button_cancel" type="button" class="button_cancel" value="关闭" onclick="closeWindow()">
    </td>
</tr>
</table>
</form:form>