<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        //加入其他业务判断
        if ($('#id').val() == '') {
            showInfoMsg('请先保存施工许可！', null);
            return;
        }
        //提交表单
        saveAjaxData("${ctx}/sgContractProjPerson/save.do", formId);
    }
    //增加或删除行
    function addLine(obj) {
        var objTable = obj.parentNode.parentNode.parentNode.parentNode;

        if (obj.value == '添加') {
            var rowIndex = document.getElementById("table1").rows.length - 1;
            var objRow = objTable.insertRow(rowIndex);
            var objCell;
            var ssa = document.getElementById("hiddenStyle");
            //列的个数
            for (var i = 0; i < 7; i++) {
                var indexNo = document.getElementById("table1").rows.length - 2;
                objCell = objRow.insertCell(i);
                objCell.noWrap = "true";
                objCell.style.display = ssa.cells[i].style.display;
                if (i == 0) {
                    objCell.innerHTML = indexNo + '<input type="hidden" name="num" value="' + indexNo + '"/>';
                } else {
                    objCell.innerHTML = ssa.cells[i].innerHTML;
                }
            }
        } else {
            if (confirm("确定要删除吗!")) {
                var trObj = obj.parentNode.parentNode;
                trObj.parentElement.deleteRow(trObj.rowIndex);
            }
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <div class="div_space"></div>
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="table_thin_line_center" border="1" id="table1">
            <tr class="tr_header">
                <td style="width: 5%;text-align: center;" nowrap>序号</td>
                <td style="width: 15%;text-align: center;" nowrap>合同信息报送编号</td>
                <td style="width: 15%;text-align: center;" nowrap>单位类型</td>
                <td style="width: 15%;text-align: center;" nowrap>单位名称</td>
                <td style="width: 15%;text-align: center;" nowrap>项目负责人</td>
                <%--<td style="width: 15%;text-align: center;" nowrap>身份证号</td>--%>
                <td style="width: 15%;text-align: center;" nowrap>电话号码</td>
                <td style="width: 5%;text-align: center;">
                    <input type='button' value='添加' class='button_select_add'
                           onclick='addLine(this)'>
                </td>
            </tr>
            <c:if test="${not empty bean}">
                <c:forEach items="${bean.sgContractProjPersons}" var="item">
                    <input type="hidden" name="personId" value="${item.id}">
                    <tr>
                        <td style="text-align: center;">
                                ${item.num}
                            <input type="hidden" class="input_number_short" name="num" value="${item.num}">
                        </td>
                        <td style="text-align: center;">
                            <input type="text" class="input_text" name="contractCode" value="${item.contractCode}" style="width: 95%;">
                        </td>
                        <td style="text-align: center;">
                            <sys:code code="${SGDWLX}" type="select" name="unitType" sysCodeDetailId="${item.unitType.id}"/>
                        </td>
                        <td style="text-align: center;">
                            <input type="text" class="input_text" name="unitName" value="${item.unitName}" style="width: 95%;">
                        </td>
                        <td style="text-align: center;">
                            <input type="text" class="input_text" name="unitMainPerson" value="${item.unitMainPerson}" style="width: 95%;">
                        </td>
                        <%--<td style="text-align: center;">--%>
                            <%--<input type="text" class="input_text" name="unitIdCard" value="${item.unitIdCard}" style="width: 95%;">--%>
                        <%--</td>--%>
                        <td style="text-align: center;">
                            <input type="text" class="input_text" name="unitPhone" value="${item.unitPhone}" style="width: 95%;">
                        </td>
                        <td style="text-align: center;">
                            <input type='button' value='删除' class='button_select_remove' onclick='addLine(this)'>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            <tr id="hiddenStyle" style="display: none;height: 30px;">
                <td style="text-align: center;"></td>
                <td style="text-align: center;">
                    <input type="text" name="contractCode" class="input_text" style="width: 95%;" value="">
                </td>
                <td style="text-align: center;">
                    <sys:code code="${SGDWLX}" type="select" name="unitType" sysCodeDetailId=""/>
                </td>
                <td style="text-align: center;">
                    <input type="text" name="unitName" class="input_text" style="width: 95%;" value="">
                </td>
                <td style="text-align: center;">
                    <input type="text" name="unitMainPerson" class="input_text" style="width: 95%;" value="">
                </td>
                <%--<td style="text-align: center;">--%>
                    <%--<input type="text" name="unitIdCard" class="input_text" style="width: 95%;" value="">--%>
                <%--</td>--%>
                <td style="text-align: center;">
                    <input type="text" name="unitPhone" class="input_text" style="width: 95%;" value="">
                </td>
                <td style="text-align: center;">
                    <input type='button' value='删除' class='button_select_remove' onclick='addLine(this)'>
                </td>
            </tr>
        </table>
    </div>
    <div class="div_space"></div>
    <div style="text-align: center;">
        <input type="button" value="保存" class="button_confirm" onclick="save(this)">&nbsp;
        <input type="button" value="取消" class="button_cancel" onclick="parent.closeWindow()">
    </div>
</form:form>