<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function queryPerson() {
        var url = "?id=" + $("#id").val();// + "&groupId=" + groupId + "&positionTypeId=" + positionTypeId + "&expression=" + expression;
        openNewWindow("processSwimlanePersonWin", "查看人员", "${ctx}/bpmNodeDefinition/processSwimlanePerson.do" + url);
    }

    function disabledQueryPerson() {
        document.getElementById("button_query").disabled = true;
    }

    function enabledQueryPerson() {
        document.getElementById("button_query").disabled = false;
    }
    var processSwimlaneFormId = "processSwimlaneForm";
    //保存操作
    function save(btn) {
        //提交表单
        saveAjaxData("${ctx}/bpmNodeDefinition/saveProcessSwimlane.do", processSwimlaneFormId);
    }
</script>
<form:form commandName="bean" action="saveProcessSwimlane.do" id="processSwimlaneForm">
    <form:hidden path="id"/>
    <input type="hidden" id="oldType" name="oldType" value='${type}'>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">泳道名称:</td>
            <td class="form_content">
                    ${bean.name}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">
                <input type="radio" name="swimlaneType" value="1"
                       <c:if test="${swimlaneType=='1'}">checked="true"</c:if> >选择系统泳道:
            </td>
            <td class="form_content">
                <select name="projectSwimlaneId" class="select_normal">
                    <c:forEach items="${swimlanes}" var="swimlane">
                        <option value="${swimlane.id}"
                                <c:if test="${swimlane.id==projectSwimlane.id}">selected</c:if>>${swimlane.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label"><input type="radio" name="swimlaneType"
                                          value="2"
                                          <c:if test="${swimlaneType=='2'}">checked="true"</c:if> >自定义方式:&nbsp;&nbsp;
            </td>
            <td class="form_content">&nbsp;</td>
        </tr>
            <%--<tr class="tr_light">--%>
            <%--<td align="right" width="40%">泳道名称:</td>--%>
            <%--<td>--%>
            <%--<form:input path="name" cssClass="input_text"/>--%>
            <%--</td>--%>
            <%--</tr>--%>
        <tr class="tr_dark">
            <td class="form_label">项目组类型:</td>
            <td class="form_content">
                <sys:code code="BpmProjectGroupType" name="groupId" id="groupId"
                          type="select"
                          sysCodeDetailId="${bean.swimlaneDefinition.group.id}"/>

            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">项目组岗位类型:</td>
            <td class="form_content">
                <sys:code code="BpmProjectGroupDutyType" name="positionTypeId"
                          id="positionTypeId" type="select"
                          sysCodeDetailId="${bean.swimlaneDefinition.positionType.id}"/>

            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">其他限制(表达式):</td>
            <td class="form_content">
                <textarea name="expression" id="expression"
                          class="input_textarea"
                          onkeydown="disabledQueryPerson();">${bean.swimlaneDefinition.expression}</textarea>
            </td>
        </tr>
        <tr class="tr_button">
            <td colspan="2" align="center" nowrap>
                <input name="button_save" type="button" class="button_confirm" value="确定" onclick="save(this);">
                <input name="button_reset" type="reset" class="button_all" value="重写"
                       onclick="enabledQueryPerson();">
                <c:if test="${bean.id!=null}">
                    <input name="button_query" type="button" class="button_all" value="人员"
                           onclick="queryPerson();">
                </c:if>
                <input name="button_back" type="button" class="button_cancel" value="关闭"
                       onclick="closeWindow()">
            </td>
        </tr>
    </table>
</form:form>