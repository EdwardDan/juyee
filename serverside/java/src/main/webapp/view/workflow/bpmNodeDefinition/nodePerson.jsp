<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function nodePersonTest() {
        $.post("${ctx}/bpmNodeDefinition/nodePerson.do",
                $("#nodePersonForm").serialize(), function (data) {
                    if (data.length < 100) {
                        data = $.parseJSON(data);
                        showInfoMsg(data.msg, "info");
                    } else {
                        $("#nodePersonWin").panel("body").html(data);
                    }
                });
    }
</script>
<form:form commandName="bean" action="nodePerson.do" id="nodePersonForm">
    <input type="hidden" name="id" value="${bean.id}"/>

    <div class="form_div tr_dark" align="center">
            <%--<input type="hidden" name="groupId" value="${groupId}"/>--%>
            <%--<input type="hidden" name="positionTypeId" value="${positionTypeId}"/>--%>
            <%--<input type="hidden" name="expression" value="${expression}"/>--%>
        <!-- main content begin -->

        <fieldset class="form_fieldset">
            <legend class="form_legend">
                字段映射
            </legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <c:forEach var="bean" items="${varNames}"
                           varStatus="status">
                    <c:choose>
                        <c:when test="${status.count%2==0}">
                            <tr class="td_light" align="center">
                        </c:when>
                        <c:otherwise>
                            <tr class="td_dark" align="center">
                        </c:otherwise>
                    </c:choose>
                    <td align="right" width="40%">${bean.varName}:</td>
                    <td align="left">
                        <input type="text" id="${bean.varName}" name="${bean.varName}"
                               value="${bean.varValue}" class="input_dark">
                    </td>
                    </tr>
                </c:forEach>
                <tr class="tr_button">
                    <td colspan="3" align="center">
                        <input type="button" value="测试" class="button_confirm" onclick="nodePersonTest();">
                    </td>
                </tr>
            </table>
        </fieldset>
        <!-- main content begin -->
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
            <input type="reset" value="关闭"
                   class="button_cancel"
                   onclick="closeWindow('nodePersonWin')">
        </div>
    </div>
</form:form>