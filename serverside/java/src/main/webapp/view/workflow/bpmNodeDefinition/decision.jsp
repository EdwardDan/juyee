<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function moveDecision(type, transitionIndex) {
        var id = document.getElementById("id").value;
        var url = "?id=" + id + "&type=" + type + "&transitionIndex=" + transitionIndex;
        window.location = "moveDecision.html" + url;
    }
    var decisionFormId = "decisionForm";
    //保存操作
    function save(btn) {
        //提交表单
        saveAjaxData("${ctx}/bpmNodeDefinition/saveDecision.do", decisionFormId);
    }
</script>
<form:form commandName="bean" id="decisionForm" action="saveDecision.do">
    <input type="hidden" name="id" value="${bean.id}"/>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_header">
            <td width="10%">序号</td>
            <td width="15%">分支</td>
            <td width="15%">目标节点</td>
            <td width="45%">表达式</td>
            <td width="10%">操作</td>
            <td width="5%">缺省值</td>
        </tr>
        <c:forEach var="bean" items="${decisionTransitions}"
                   varStatus="status">
            <c:choose>
                <c:when test="${status.count%2==0}">
                    <tr class="tr_light" align="center">
                </c:when>
                <c:otherwise>
                    <tr class="tr_dark" align="center">
                </c:otherwise>
            </c:choose>
            <td class="form_border">${status.count}</td>
            <td class="form_border">${bean.transitionName}</td>
            <td class="form_border">${bean.transitionTo}</td>
            <td class="form_border">
                    <%--<textarea type="text" class="input_text_long"--%>
                    <%--id="conditions"--%>
                    <%--name="conditions"--%>
                    <%--value="${bean.condition}">--%>
                <textarea id="conditions" name="conditions" rows="2"
                          style="width:400px">${bean.condition}</textarea>
                <input type="hidden" class="input_text_long" id="transitions" name="transitions"
                       value="${bean.transitionName}">
            </td>
            <td class="form_border">
                <input type="button" value="上移" class="button_up" onclick="moveDecision('up','${status.index}')">
                <input type="button" value="下移" class="button_down" onclick="moveDecision('down','${status.index}')">
            </td>
            <td class="form_border">
                <c:choose>
                    <c:when test="${defaultTransition==bean.transitionName}">
                        <input type="radio" name="defaultTransition" value="${bean.transitionName}" checked="true">
                    </c:when>
                    <c:otherwise>
                        <input type="radio" name="defaultTransition" value="${bean.transitionName}">
                    </c:otherwise>
                </c:choose>
            </td>
            </tr>
        </c:forEach>
        <tr class="tr_button">
            <td align="center" colspan="6">
                <input type="button" value="确定" class="button_confirm" onclick="save(this);">
                <input type="reset" value="返回" class="button_back" onclick="closeWindow();">
            </td>
        </tr>
        <tr class="tr_button">
            <td align="center" colspan="6">
                &nbsp;表达式：
                <span>&nbsp;&nbsp;◎ 例如：task.getFormField('zrzt_sh').equals('0') 表示表单中的key为zrzt_sh的值等于0时跳转到某个分支。</span>
            </td>
        </tr>
    </table>
</form:form>