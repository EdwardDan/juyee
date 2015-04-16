<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function queryPerson() {
        var url = "?id=" + $("#id").val();// + "&groupId=" + groupId + "&positionTypeId=" + positionTypeId + "&expression=" + expression;
        $.get("${ctx}/bpmNodeDefinition/nodePerson.do" + url, function (data) {
            if (data.length < 100) {
                data = $.parseJSON(data);
                showInfoMsg(data.msg, "info");
            } else {
                openNewWindow("nodePersonWin", "查看人员");
                $("#nodePersonWin").panel("body").html(data);
            }
        });
    }

    function disabledQueryPerson() {
        document.getElementById("button_query").disabled = true;
    }

    function enabledQueryPerson() {
        document.getElementById("button_query").disabled = false;
    }

    var personLimitFormId = "personLimitForm";
    //保存操作
    function save(btn) {
        //提交表单
        saveAjaxData("${ctx}/bpmNodeDefinition/savePersonLimit.do", personLimitFormId);
    }
</script>
<form:form commandName="bean" action="savePersonLimit.do" id="personLimitForm">
    <form:hidden path="id"/>

    <div class="form_div">
        <input type="hidden" id="definitionId" name="definitionId" value="${bean.swimlaneDefinition.id}">

        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">节点名称:</td>
                <td class="form_content">${bean.name}</td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">
                    <input type="radio" name="swimlameType" value="2"
                           <c:if test="${swimlaneType=='2'}">checked="true"</c:if> >选择流程泳道:
                </td>
                <td class="form_content">
                    <select name="processSwimlaneId" class="select_normal">
                        <c:forEach items="${swimlanes}" var="swimlane">
                            <option value="${swimlane.id}"
                                    <c:if test="${swimlane.id==processSwimlane.id}">selected</c:if>>${swimlane.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">
                    <input type="radio" name="swimlameType" value="3"
                           <c:if test="${swimlaneType=='3'}">checked="true"</c:if> >自定义方式:&nbsp;&nbsp;
                </td>
                <td class="form_content"></td>
            </tr>
                <%--<tr class="td_light">--%>
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
                    <br>（例如匹配项目组的名称为监理工程师的人员：group.getName().equals('监理工程师')）
                    <br>（例如匹配页面传递来的关联某个合同段的人员：duty.getExtAttrItems("BID").getValues("name").contains(#relateBidNames)）
                    <br>（例如匹配页面传递来的某个选择为同意的人员（其中#checkRadio为模板定义中的key）："1".equals(#checkRadio)）
                    <br>（其余选择person,duty,group比如：person.getName()、group.getName()等）
                </td>
            </tr>
            <tr class="tr_button">
                <td colspan="2" nowrap>
                    <input name="button_save" type="button" class="button_confirm" value="确定" onclick="save(this);">
                    <input name="button_reset" type="reset" class="button_all" value="重写"
                           onclick="enabledQueryPerson();">
                    <c:if test="${bean.id!=null}">
                        <input name="button_query" id="button_query" type="button" class="button_all" value="人员"
                               onclick="queryPerson();">
                    </c:if>
                    <input name="button_back" type="button" class="button_cancel" value="关闭"
                           onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>