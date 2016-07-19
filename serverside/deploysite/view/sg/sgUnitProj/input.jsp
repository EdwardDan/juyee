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
        saveAjaxData("${ctx}/sgUnitProj/save.do", formId, $(parent.$("li.tabs-selected")).next().text());
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
            for (var i = 0; i < 6; i++) {
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
                <td style="width: 5%;text-align: center;">序号</td>
                <td style="width: 8%;text-align: center;">单位工程编号</td>
                <td style="width: 10%;text-align: center;">单位工程名称</td>
                <%--<td style="width: 10%;text-align: center;">单位工程类型</td>--%>
                <td style="width: 40%;text-align: center;">建设内容</td>
                <td style="width: 5%;text-align: center;">
                    <input type='button' value='添加' class='button_select_add'
                           onclick='addLine(this)'>
                </td>
            </tr>
            <c:if test="${not empty bean}">
                <c:forEach items="${bean.sgUnitProjs}" var="item">
                    <tr>
                        <td style="text-align: center;">
                                ${item.num}
                            <input type="hidden" class="input_number_short" name="num" value="${item.num}">
                        </td>
                        <td style="text-align: center;">
                            <input type="text" class="input_text" name="unitProjCode" value="${item.unitProjCode}" style="width: 95%;">
                        </td>
                        <td style="text-align: center;">
                            <input type="text" class="input_text" name="unitProjName" value="${item.unitProjName}" style="width: 95%;">
                        </td>
                        <%--<td style="text-align: center;">--%>
                            <%--<sys:code code="${SGDWGCLX}" type="select" name="unitProjType" style="width:95%;"--%>
                                      <%--sysCodeDetailId="${item.unitProjType.id}"/>--%>
                        <%--</td>--%>
                        <td style="text-align: center;">
                            <input type="text" class="input_text" name="projectIndex" value="${item.projectIndex}" style="width: 95%;">
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
                    <input type="text" name="unitProjCode" class="input_text" style="width: 95%;" value="">
                </td>
                <td style="text-align: center;">
                    <input type="text" name="unitProjName" class="input_text" style="width: 95%;" value="">
                </td>
                <%--<td style="text-align: center;">--%>
                    <%--<sys:code code="${SGDWGCLX}" type="select" name="unitProjType" sysCodeDetailId=""/>--%>
                <%--</td>--%>
                <td style="text-align: center;">
                    <input type="text" name="projectIndex" class="input_text" style="width: 95%;" value="">
                </td>
                <td style="text-align: center;">
                    <input type='button' value='删除' class='button_select_remove'
                           onclick='addLine(this)'>
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