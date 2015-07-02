<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    var flag = false;
    $(function () {
        //页面验证初始化
        var validateCondition = [];
        validateInit(validateCondition, formId);
        <c:if test="${fn:length(bean.project.projBids)>0}">
        checkBid(document.getElementById("projectBidId"));
        </c:if>
    });
    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        if (flag) {
//            alert("页面数据有改动，需要保存历史数据！");
            saveAjaxData("${ctx}/dataStageReport/save.do?reportLog=reportLog", formId);
        } else {
            saveAjaxData("${ctx}/dataStageReport/save.do", formId);
        }
    }
    //选择填报内容
    function changeResult(obj, bidId, stageId) {
        var objValue = obj.value;
        var selectIndex = obj.selectedIndex;//获得是第几个被选中了
        var selectText = obj.options[selectIndex].text //获得被选中的项目的文本
        if ('' != objValue) {
            if (objValue == 1 || objValue == 4) {
                var dealDate = $("#dealDate_" + bidId + "_" + stageId).val();
                openNewWindow("new", "填报页面", "${ctx}/dataStageReport/resultInput.do?resultCode=" + objValue + "&bidId=" + bidId + "&stageId=" + stageId + "&dealDate=" + dealDate, false, 500, 300);
            } else {
                $("#dealDate_" + bidId + "_" + stageId).val(selectText);
            }
        }
    }
    //切换标段
    function checkBid(obj) {
        loadAjaxData("checkBid", "${ctx}/dataStageReport/checkBidData.do?bidId=" + obj.value+"&projectId=${projectId}" + "&id=${bean.id}");
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="year"/>
    <form:hidden path="month"/>
    <input type="hidden" name="projectId" value="${bean.project.id}">

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label_right" style="width: 15%;">项目名称：</td>
                <td class="form_content">${bean.project.name}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" style="width: 15%;">建设单位：</td>
                <td class="form_content">${bean.project.jsDept}</td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" style="width: 15%;">选择标段：</td>
                <td class="form_content">
                    <select class="form_select" name="projectBidId" id="projectBidId" onchange="checkBid(this)">
                        <c:forEach items="${bids}" var="projectBid">
                            <option value="${projectBid.id}">${projectBid.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
        </table>
        <div class="div_space"></div>
        <c:if test="${fn:length(bean.project.projBids)>0}">
            <div class="form_div" id="checkBid"></div>
        </c:if>
        <div class="div_space"></div>
        <div class="form_div" style="text-align: center;">
            <input type="button" value="保存" class="button_confirm" onclick="save(this)">&nbsp;
            <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
        </div>
        <div class="div_space"></div>
    </div>
</form:form>