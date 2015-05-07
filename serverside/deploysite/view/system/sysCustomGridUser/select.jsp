<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    //保存操作
    function save(btn) {
        var val = $('input:radio[name="customGridId"]:checked').val();
        if (val == null) {
            alert("请选择至少一个版块!");

        } else {

            //提交表单
            saveAjaxData("${ctx}/sysCustomGridUser/save.do", formId, reloadGridData);
        }
    }
    //刷新数据
    function reloadGridData() {
        var car_no = "${orderNo}";
        if (car_no != "") {
            loadAjaxData("car" + car_no, "${ctx}/mainPage/mainInfo.do?orderNo=" + car_no);
        }
    }
</script>

<form:form commandName="bean">
    <input type="hidden" name="orderNo" id="orderNo" value="${orderNo}">

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <c:forEach items="${list}" var="item">
                <tr class="tr_light" <c:if test="${item.grid.orderNo == checkedNo}">style="background-color: #ffedad;"</c:if>>
                    <td class="form_border" colspan="2" align="left">
                        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
                        <input type="radio" name="customGridId" value="${item.grid.id}" <c:if test="${item.grid.orderNo == checkedNo}">checked</c:if>> ${item.grid.modelName}
                    </td>
                </tr>
            </c:forEach>
            <tr class="tr_button">
                <td class="form_label"></td>
                <td class="form_content">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>