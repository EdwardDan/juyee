<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    var changeFlag = false;
    $(function () {
        //页面验证初始化
        var validateCondition = [];
        validateInit(validateCondition, formId);
        loadMonthReport();
    });
    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        //提交表单
        var bidId = $("#projBid").val();
        if (bidId == null) {
            alert("标段不能为空！")
        } else {
            doSave(btn, formId);
            <%--saveAjaxData("${ctx}/dataNodeReport/save.do?month=" + last_m, formId);--%>
        }
    }
    function doSave(btn, formId) {
        var sendData = "";
        if (formId != null && $('#' + formId).length > 0) {
            sendData = $("#" + formId).serializeArray();
        }
        $(btn).attr("disabled", "disabled");
        $.ajax({
            type: "POST",
            url: "${ctx}/dataNodeReport/save.do" ,
            data: sendData,
            dataType: "json",
            success: function (data) {
                if (data.success) {
                    showInfoMsg(data.msg);
                } else {
                    showErrorMsg(data.msg);
                }
                $(btn).removeAttr("disabled");
                changeFlag = false;
            },
            error: function (xmlR, status, e) {
                showErrorMsg("[" + e + "]" + xmlR.responseText);
                $(btn).removeAttr("disabled");
            }
        });
    }

    function loadMonthReport() {
        if (changeFlag == true) {
            //如果changeFlag的值为true则提示
            alert("页面值已经修改，请先保存数据！")
        } else {
            var bidId = $("#projBid").val();
            loadAjaxData("monthReportDiv", "${ctx}/dataNodeReport/nodeDataItem.do?id=${id}&month=" + $("#month").val() + "&bidId=" + bidId+ "&year=" + $("#year").val());
        }
    }
</script>
<style type="text/css">
    .td_normal {
        height: 20px;
        background-color: white;
    }

    .td_active {
        height: 20px;
        background-color: #0074cc;
        font-weight: bold;
    }
</style>
<div class="form_div">
    <form:form commandName="bean">
        <form:hidden path="id"/>
        <input type="hidden" name="projectId" value="${projInfo.id}">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right" width="20%">项目名称：</td>
                <td class="form_content" width="80%">
                        ${projInfo.name}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">建设单位：</td>
                <td class="form_content">
                        ${content.jsgs}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">选择标段：</td>
                <td class="form_content">
                    <select name="projBid" id="projBid" class="form_select_long"
                            onchange="loadMonthReport('${currentMonth}')">
                        <c:if test="${projBids!= null&&fn:length(projBids)>0}">
                            <c:forEach items="${projBids}" var="item">
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                        </c:if>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="right">&nbsp;填报年月：</td>
                <td align="left">
                    <select id="year" name="year" onclick="loadMonthReport()">
                            ${yearSelectOptions}
                    </select>年
                    <select id="month" name="month" onclick="loadMonthReport()">
                            ${monthSelectOptions}
                    </select> 月
                        <%--<table cellpadding="0" cellspacing="0" border="1" class="table_thin_line" width="500">--%>
                        <%--<tr align="center">--%>
                        <%--<c:forEach var="m" begin="1" end="12" step="1">--%>
                        <%--<td width="8%" id="td${m}" onclick="loadMonthReport('${m}')"--%>
                        <%--<c:choose>--%>
                        <%--<c:when test="${currentMonth==m}">class="td_active" </c:when>--%>
                        <%--<c:otherwise>class="td_normal" style="cursor: pointer"--%>
                        <%--title="查看当月数据"</c:otherwise>--%>
                        <%--</c:choose>>${m}月--%>
                        <%--</td>--%>
                        <%--</c:forEach>--%>
                        <%--</tr>--%>
                        <%--</table>--%>
                </td>
            </tr>
            <tr>
                <td colspan="2" id="monthReportDiv" align="center">
                    &nbsp;
                </td>
            </tr>
            <tr class="tr_button">
                <td align="center" colspan="2">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </form:form>
</div>
