<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <script type="text/javascript">
        function save(btn) {
            var formId = "bean";

            //加入其他业务判断
//        if ($('#name').val() == '') {
//            showInfoMsg('请输入姓名！',null);
//            return;
//        }
            var id=document.getElementById("id").value;
            //提交表单
            openWindow("查看人员", "${ctx}/bpmSwimlane/queryPerson.do?id=" + id, false);
        }

    </script>
</head>


<div id="start">
    <%--<form name="listForm" method="post" action="viewSwimlanePerson.do">--%>
    <form:form commandName="bean" id="bean">
        <form:hidden path="id"/>
        <input type="hidden" name="id" value="${bean.id}" id="id"/>
        <%--<input type="hidden" name="groupId" value="${groupId}"/>--%>
        <%--<input type="hidden" name="positionTypeId" value="${positionTypeId}"/>--%>
        <%--<input type="hidden" name="expression" value="${expression}"/>--%>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr>
                <td class="tr_title">
                    测试数据
                    <table width="100%">
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
                            <td align="right" width="40%">${bean.varName}:
                            </td>
                            <td align="left"><input type="text"
                                                    id="${bean.varName}"
                                                    name="${bean.varName}"
                                                    value="${bean.varValue}" class="input_dark">
                            </td>
                            </tr>
                        </c:forEach>
                        <tr class="tr_button">
                            <td colspan="3" align="center"><input
                                    type="button" value="测试" onclick="save(this)"
                                    class="button_confirm"></td>
                        </tr>
                    </table>

                    <br/>
                </td>

            </tr>
                <%--<tr height="20%"><td></td></tr>           --%>
            <tr>
                <td valign="top">
                    <!-- main content begin -->
                    <table width="100%" border="0"
                           cellpadding="1" cellspacing="1"
                           bgcolor="white"
                           id="table_list">
                        <tr class="tr_header" align="center">
                            <td width="10%">序号</td>
                            <td width="30%">项目组</td>
                            <td width="30%">岗位</td>
                            <td width="30%">人员</td>
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
            </tr>
            <tr>
                <td align="center"
                    class="tr_button">
                        <%--<input type="submit" value="确定"--%>
                        <%--class="button_confirm">--%>
                    <input type="reset" value="关闭"
                           class="button_cancel"
                           onclick="closeWindow()">
                </td>
            </tr>
        </table>

        <!-- main content end -->


        <%--</form>--%>
    </form:form>
</div>

</html>