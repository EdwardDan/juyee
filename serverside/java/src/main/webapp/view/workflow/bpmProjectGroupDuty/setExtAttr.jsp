<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>虹口区建设工程管理系统</title>
    <script type="text/javascript">
        function save(btn) {
            var formId = "bean";

            //加入其他业务判断
//        if ($('#name').val() == '') {
//            showInfoMsg('请输入姓名！',null);
//            return;
//        }

            //提交表单
            var id = document.getElementById("extid").value;
            saveAjaxData("${ctx}/bpmProjectGroupDuty/saveExtAttrSetting.do", formId);
        <%--openFullWindow( "${ctx}/bpmProjectGroup/extAttr.do?id=" + id+ "&defCode=&attributeType=&expression=", 800,500,"项目组扩展属性");--%>
        }
    </script>
</head>

<body>
<%--<form name="listForm" method="post" action="saveExtAttrSetting.do">--%>
<form:form commandName="bean">
    <input type="hidden" name="id" id="extid" value="${bean.id}"/>
    <table cellpadding="2" cellspacing="2" class="form_table">
        <tr>
            <td class="tr_title" colspan="3">
                <!-- title begin -->
                扩展属性设置
                <!-- title begin -->
            </td>
        </tr>
        <tr class="tr_header">
            <td width="10%">序号</td>
            <td width="40%">扩展属性</td>
            <td width="40%">选择</td>
        </tr>
        <c:forEach var="bean" items="${attrs}"
                   varStatus="status">
            <c:choose>
                <c:when test="${status.count%2==0}">
                    <tr class="tr_light" align="center">
                </c:when>
                <c:otherwise>
                    <tr class="tr_dark" align="center">
                </c:otherwise>
            </c:choose>
            <td>${status.count}&nbsp;</td>
            <td>${bean.name}&nbsp;</td>

            <td><c:choose>
                <c:when test="${bean.checked=='true'}">
                    <input type="checkbox" id="item"
                           name="item"
                           value="${bean.code}"
                           checked="true"> &nbsp;
                </c:when>
                <c:otherwise>
                    <input type="checkbox" id="item"
                           name="item"
                           value="${bean.code}"> &nbsp;
                </c:otherwise>
            </c:choose></td>
            </tr>
        </c:forEach>
        <tr>
            <td align="center" colspan="3"
                class="tr_button">
                <input type="button" value="确定"
                       class="button_confirm" onclick="save(this)">
                <input type="reset" value="关闭"
                       class="button_cancel"
                       onclick="closeWindow()">
            </td>
        </tr>
    </table>

    <%--</form>--%>
</form:form>
</body>
</html>