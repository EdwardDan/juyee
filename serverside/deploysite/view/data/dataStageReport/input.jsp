<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    var flag = false;
    var last_m = "";
    $(function () {
        //页面验证初始化
        var validateCondition = [];
        validateInit(validateCondition, formId);
        loadMonthReport("${currentMonth}");
    });
    //提交操作
    function sub(btn){
        var number = 1;
        if (!validateForm(formId)) {
            return;
        }
        if (flag) {
            doSave(btn, "${ctx}/dataStageReport/save.do?reportLog=reportLog&month=" + last_m + "&year=" + $("#tbYear").val() + "&isSubmit=" + number);
        } else {
            doSave(btn, "${ctx}/dataStageReport/save.do?month=" + last_m + "&year=" + $("#tbYear").val() + "&isSubmit=" + number);
        }
    }
    //保存操作
    function save(btn) {
        var number = 0;
        if (!validateForm(formId)) {
            return;
        }
        if (flag) {
            doSave(btn, "${ctx}/dataStageReport/save.do?reportLog=reportLog&month=" + last_m + "&year=" + $("#tbYear").val() + "&isSubmit=" + number);
        } else {
            doSave(btn, "${ctx}/dataStageReport/save.do?month=" + last_m + "&year=" + $("#tbYear").val() + "&isSubmit=" + number);
        }
    }
    function doSave(btn, url) {
        var sendData = "";
        if (formId != null && $('#' + formId).length > 0) {
            sendData = $("#" + formId).serializeArray();
        }
        $(btn).attr("disabled", "disabled");
        $.ajax({
            type: "POST",
            url: url,
            data: sendData,
            dataType: "json",
            success: function (data) {
                if (data.success) {
                    showInfoMsg(data.msg);
                } else {
                    showErrorMsg(data.msg);
                }
                $(btn).removeAttr("disabled");
                flag = false;
            },
            error: function (xmlR, status, e) {
                showErrorMsg("[" + e + "]" + xmlR.responseText);
                $(btn).removeAttr("disabled");
            }
        });
    }


    function callbackEvent() {
        openWindow("办证推进填报", "${ctx}/dataStageReport/modify.do?projectId=${bean.project.id}&month=" + last_m, true, 1000, 600);
    }

    //选择填报内容
    function changeResultJH(obj, bidId, stepId, stageId) {
        var objValue = obj.value;
        var selectIndex = obj.selectedIndex;//获得是第几个被选中了
        var selectText = obj.options[selectIndex].text //获得被选中的项目的文本
        if ('' != objValue) {
            if (objValue == '${result1}') {
                $("#dealDateJH_" + bidId + "_" + stepId + "_" + stageId).hide();
                $("#xblJH_" + bidId + "_" + stepId + "_" + stageId).show();
            } else if (objValue == '${result4}') {
                $("#dealDateJH_" + bidId + "_" + stepId + "_" + stageId).show();
                $("#xblJH_" + bidId + "_" + stepId + "_" + stageId).hide();
                var dealDateJH = $("#dealDateJH_" + bidId + "_" + stepId + "_" + stageId).val();
                openNewWindow("new", "填报页面", "${ctx}/dataStageReport/resultInput.do?resultCodeJH=" + objValue + "&stepId=" + stepId + "&bidId=" + bidId + "&stageId=" + stageId + "&dealDateJH=" + dealDateJH, false, 500, 300);
            } else {
                $("#dealDateJH_" + bidId + "_" + stepId + "_" + stageId).show();
                $("#xblJH_" + bidId + "_" + stepId + "_" + stageId).hide();
                $("#dealDateJH_" + bidId + "_" + stepId + "_" + stageId).val(selectText);
            }
        }
    }
    function changeResultSJ(obj, bidId, stepId, stageId) {
        var objValue = obj.value;
        var selectIndex = obj.selectedIndex;//获得是第几个被选中了
        var selectText = obj.options[selectIndex].text //获得被选中的项目的文本
        if ('' != objValue) {
            if (objValue == '${result1}') {
                $("#dealDateSJ_" + bidId + "_" + stepId + "_" + stageId).hide();
                $("#xblSJ_" + bidId + "_" + stepId + "_" + stageId).show();
            } else if (objValue == '${result4}') {
                $("#dealDateSJ_" + bidId + "_" + stepId + "_" + stageId).show();
                $("#xblSJ_" + bidId + "_" + stepId + "_" + stageId).hide();
                var dealDateSJ = $("#dealDateSJ_" + bidId + "_" + stepId + "_" + stageId).val();
                openNewWindow("new", "填报页面", "${ctx}/dataStageReport/resultInput.do?resultCodeSJ=" + objValue + "&stepId=" + stepId + "&bidId=" + bidId + "&stageId=" + stageId + "&dealDateSJ=" + dealDateSJ, false, 500, 300);
            } else {
                $("#dealDateSJ_" + bidId + "_" + stepId + "_" + stageId).show();
                $("#xblSJ_" + bidId + "_" + stepId + "_" + stageId).hide();
                $("#dealDateSJ_" + bidId + "_" + stepId + "_" + stageId).val(selectText);
            }
        }
    }
    function loadMonthReport(month) {
        if (flag) {
            //如果changeFlag的值为true则提示
            alert("页面值已经修改，请先保存数据！")
        } else {
            if (last_m != month) {
                if (last_m != "") {
                    $("#td" + last_m).attr("class", "td_normal");
                }
                $("#td" + month).attr("class", "td_active");
                last_m = month;
            }
            var bidId = $("#projectBidId").val();
            loadAjaxData("checkBid", "${ctx}/dataStageReport/stageDataItem.do?projectId=${projectId}&month=" + month + "&bidId=" + bidId);
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
<form:form commandName="bean" name="bean" id="bean" method="post">
    <form:hidden path="id"/>
    <%--<form:hidden path="year"/>--%>
    <input type="hidden" name="projectId" value="${bean.project.id}">

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label_right" style="width: 15%;">项目名称：</td>
                <td class="form_content">${bean.project.name}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" style="width: 15%;">建设单位：</td>
                <td class="form_content">${content.jsgs}</td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" style="width: 15%;">选择标段：</td>
                <td class="form_content">
                    <select class="form_select" name="projectBidId" id="projectBidId"
                            onchange="loadMonthReport('${currentMonth}')">
                        <c:forEach items="${bids}" var="projectBid">
                            <option value="${projectBid.id}">${projectBid.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="form_label_right" style="width: 15%;">&nbsp;填报月份：</td>
                <td class="form_content">
                    <table cellpadding="0" cellspacing="0" border="1" class="table_thin_line" width="500">
                        <tr align="center">
                                <%--<c:forEach var="m" begin="1" end="12" step="1">--%>
                                <%--<td width="8%" id="td${m}" onclick="loadMonthReport('${m}')" style="cursor: pointer;"--%>
                                <%--<c:choose>--%>
                                <%--<c:when test="${currentMonth==m}">class="td_active"</c:when>--%>
                                <%--<c:otherwise>class="td_normal" title="查看当月数据"</c:otherwise>--%>
                                <%--</c:choose>>${m}月--%>
                                <%--</td>--%>
                                <%--</c:forEach>--%>
                            <select id="tbYear">
                                <c:forEach var="y" begin="2016" end="${currentYear}" step="1">
                                    <option
                                            <c:if test="${currentYear==y}">selected="selected"</c:if>
                                            value="${y}">${y}年
                                    </option>
                                </c:forEach>
                            </select>
                            <select onchange="loadMonthReport(document.getElementById('tbMonth').value)" id="tbMonth">
                                <c:forEach var="m" begin="1" end="${currentMonth}" step="1">
                                    <option
                                            <c:if test="${currentMonth==m}">selected="selected"</c:if>
                                            value="${m}">${m}月
                                    </option>
                                </c:forEach>
                            </select>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <div class="div_space"></div>
        <c:if test="${fn:length(bids)>0}">
            <div class="form_div" id="checkBid"></div>
        </c:if>
        <div class="div_space"></div>
        <div class="form_div" style="text-align: center;">
            <input type="button" value="提交" class="button_confirm" onclick="sub(this);closeWindow()">&nbsp;
            <input type="button" value="保存" class="button_confirm" onclick="save(this)">&nbsp;
            <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
        </div>
        <div class="div_space"></div>
    </div>
</form:form>
