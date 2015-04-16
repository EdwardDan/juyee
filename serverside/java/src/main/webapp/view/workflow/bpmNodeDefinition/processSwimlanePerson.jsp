<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var processSwimlanePersonId = "processSwimlanePersonForm";

    function processSwimlanePersonTest() {
        $.post("${ctx}/bpmNodeDefinition/processSwimlanePerson.do",
                $("#processSwimlanePersonForm").serialize(), function (data) {
                    if (data.length < 100) {
                        data = $.parseJSON(data);
                        showInfoMsg(data.msg, "info");
                    } else {
                        $("#processSwimlanePersonWin").panel("body").html(data);
                    }
                });
    }
</script>
<form:form commandName="bean" action="processSwimlanePerson.do" id="processSwimlanePersonForm">
    <input type="hidden" name="id" value="${bean.id}"/>
    <%--<input type="hidden" name="groupId" value="${groupId}"/>--%>
    <%--<input type="hidden" name="positionTypeId" value="${positionTypeId}"/>--%>
    <%--<input type="hidden" name="expression" value="${expression}"/>--%>
    <div class="form_div tr_dark" align="center">
        <fieldset class="form_fieldset">
            <legend class="form_legend">测试数据</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <c:forEach var="bean" items="${varNames}"
                           varStatus="status">
                    <c:choose>
                        <c:when test="${status.count%2==0}">
                            <tr class="tr_light" align="center">
                        </c:when>
                        <c:otherwise>
                            <tr class="tr_dark" align="center">
                        </c:otherwise>
                    </c:choose>
                    <td class="form_label" width="40%">${bean.varName}:
                    </td>
                    <td class="form_content">
                        <input type="text" id="${bean.varName}" name="${bean.varName}" value="${bean.varValue}"
                               class="input_dark">
                    </td>
                    </tr>
                </c:forEach>
                <tr class="tr_dark">
                    <td colspan="3" align="center">
                        <input type="button" value="测试" class="button_confirm" onclick="processSwimlanePersonTest();">
                    </td>
                </tr>
            </table>
        </fieldset>
        <fieldset class="form_fieldset">
            <legend class="form_legend">
                人员信息
            </legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_header" align="center">
                    <td width="10%" class="form_border" nowrap>序号</td>
                    <td width="30%" class="form_border" nowrap>项目组</td>
                    <td width="30%" class="form_border" nowrap>岗位</td>
                    <td width="30%" class="form_border" nowrap>人员</td>
                </tr>
                <c:forEach var="bean" items="${persons}"
                           varStatus="status">
                    <c:choose>
                        <c:when test="${status.count%2==0}">
                            <tr class="tr_light" align="center">
                        </c:when>
                        <c:otherwise>
                            <tr class="tr_dark" align="center">
                        </c:otherwise>
                    </c:choose>
                    <td>${status.count}</td>
                    <td>${bean.group}</td>
                    <td>${bean.duty}</td>
                    <td>${bean.person}</td>
                    </tr>
                </c:forEach>
            </table>
        </fieldset>
        <div class="tr_button">
                <%--<input type="submit" value="确定"--%>
                <%--class="button_confirm">--%>
            <input type="button" value="关闭"
                   class="button_cancel"
                   onclick="closeWindow('processSwimlanePersonWin')">
        </div>
    </div>
</form:form>