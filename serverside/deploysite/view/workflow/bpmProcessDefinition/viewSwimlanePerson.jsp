<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
     <c:if test="${not empty bean.id}">
        <%@include file="/common/header.jsp" %>
    </c:if>
    <script type="text/javascript">
        function save(btn) {
            var formId = "bean";

            //加入其他业务判断
//        if ($('#name').val() == '') {
//            showInfoMsg('请输入姓名！',null);
//            return;
//        }

            //提交表单
            saveAjaxData("${ctx}/bpmProcessDefinition/viewSwimlanePerson.do", formId);
        }
        function closetab() {
            var id=document.getElementById("id").value;
            loadAjaxData("start", "${ctx}/bpmProcessDefinition/viewSwimlane.do?id="+id);
        }
    </script>
</head>


<div id="start">
<form name="listForm" method="post" action="viewSwimlanePerson.do">
    <%--<form:hidden path="id"/>--%>
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
                                type="submit" value="测试"
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
                       cellpadding="0" cellspacing="1"
                       bordercolor="#FFFFFF"
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
                <input type="reset" value="返回"
                       class="button_back"
                       onclick="closetab()">
            </td>
        </tr>
    </table>

    <!-- main content end -->


</form>
    </div>

</html>