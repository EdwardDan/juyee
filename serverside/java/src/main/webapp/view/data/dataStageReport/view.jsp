<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        <c:if test="${fn:length(bean.project.projBids)>0}">
        checkBid(document.getElementById("projectBidId"));
        </c:if>
    });
    //切换标段
    function checkBid(obj) {
        loadAjaxData("checkBid", "${ctx}/dataStageReport/checkBidDataView.do?bidId=" + obj.value+"&projectId=${projectId}" + "&id=${bean.id}");
    }
</script>

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
    <c:if test="${fn:length(bids)>0}">
        <div class="form_div" id="checkBid"></div>
    </c:if>
    <div class="div_space"></div>
    <div class="form_div" style="text-align: center;">
        <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
    </div>
    <div class="div_space"></div>
</div>
