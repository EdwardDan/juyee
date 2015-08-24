<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "gctxGkpfTotal", rule: "validate[required,custom[number]"},
            {name: "gctxCspfTotal", rule: "validate[required,custom[number]"} ,
            {name: "gctxSourceFund", rule: "validate[required"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        disableBtn(btn);
        //提交表单
        doSave(btn, "${ctx}/projExtendCost/save.do");
        <%--saveAjaxData("${ctx}/projExtendCost/save.do", formId);--%>
    }
    function doSave(btn, url) {
        var sendData = "";
        if (formId != null && $('#' + formId).length > 0) {
            sendData = $("#" + formId).serializeArray();
        }
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
                enableBtn(btn, "保存");
            },
            error: function (xmlR, status, e) {
                showErrorMsg("[" + e + "]" + xmlR.responseText);
            }
        });
    }
    function addLine(obj, num, hiddenType) {
        var objTable = obj.parentNode.parentNode.parentNode.parentNode;

        if (obj.value == '新增') {
            var rowIndex = document.getElementById("table" + num).rows.length - 1;
            var objRow = objTable.insertRow(rowIndex);
            var objCell;
            var ssa = document.getElementById(hiddenType);

            var colValue = "";
            var colName = "";
            var hiddenYear = "";
            var hiddenMonth = "";
            var hiddenHalf = "";
            var colNum = 3;
            if (4 == num) {
                colNum = 4;
            }
            //列的个数
            for (var i = 0; i < colNum; i++) {
                var indexNo = document.getElementById("table" + num).rows.length - 2;
                objCell = objRow.insertCell(i);
                objCell.noWrap = "true";
                objCell.align = "center";
//                objCell.style.display = ssa.cells[i].style.display;
                //处理title的值
                if (1 == num) {
                    colValue = (${curYear}+indexNo - 2) + "年";
                    colName = "${TYPE1}";
                    hiddenYear = (${curYear}+indexNo - 2);
                } else if (2 == num) {
                    colValue = (${curYear}+indexNo - 1) + "年";
                    colName = "${TYPE2}";
                    hiddenYear = (${curYear}+indexNo - 1);
                } else if (3 == num) {
                    if (indexNo % 2 == 0) {
                        colValue = (${curYear}+parseInt((indexNo - 1) / 2)) + "年全年";
                        hiddenYear = (${curYear}+parseInt((indexNo - 1) / 2));
                        hiddenHalf = "qn";
                    } else {
                        colValue = (${curYear}+parseInt((indexNo - 1) / 2)) + "年上半年";
                        hiddenYear = (${curYear}+parseInt((indexNo - 1) / 2));
                        hiddenHalf = "sbn";
                    }
                    colName = "${TYPE3}";
                } else if (4 == num) {
                    colValue = "${curYear}年" + (${curMonth}+indexNo - 1) + "月";
                    colName = "${TYPE4}";
                    hiddenYear =${curYear};
                    hiddenMonth = (${curMonth}+indexNo - 1);
                }
                //列的处理
                var html1 = "<input type='text' class='input_text' style='text-align: center;' readonly name='time" + colName + indexNo + "' value='" + colValue + "'>";
                html1 += "<input type='hidden' name='year" + colName + indexNo + "' value='" + hiddenYear + "'>";
                html1 += "<input type='hidden' name='half" + colName + indexNo + "' value='" + hiddenHalf + "'>";
                html1 += "<input type='hidden' name='index" + colName + "' value='" + indexNo + "'>";
                var html2 = "<input type='text' class='input_text' name='cost" + colName + indexNo + "' value=''>";
                var html3 = "<input type='text' class='input_text' name='czCostYbf" + colName + indexNo + "' value=''>";
                html3 += "<input type='hidden' name='year" + colName + indexNo + "' value='" + hiddenYear + "'>";
                html3 += "<input type='hidden' name='month" + colName + indexNo + "' value='" + hiddenMonth + "'>";
                var html4 = "<input type='text' class='input_text' name='czCostYwc" + colName + indexNo + "' value=''>";

                if (i == 0) {
                    objCell.innerHTML = html1;
                } else {
                    objCell.innerHTML = ssa.cells[i].innerHTML;
                }
                if (4 == num) {
                    if (i == 1) {
                        objCell.innerHTML = html3;
                    } else if (i == 2) {
                        objCell.innerHTML = html4;
                    }
                } else {
                    if (i == 1) {
                        objCell.innerHTML = html2;
                    }
                }
            }
        } else {
            if (confirm("确定要删除吗!")) {
                var trObj = obj.parentNode.parentNode;
                trObj.parentElement.deleteRow(trObj.rowIndex);
            }
        }
    }
    function checkNumner(element) {
        if (/^\d+\.\d+$/.test(element.value) || !isNaN(element.value)) {
        } else {
            showInfoMsg('只能输入整数和小数！', null);
            element.value = 0;
        }
    }
</script>
<form:form commandName="bean">
<form:hidden path="id"/>
<input type="hidden" name="project" value="${bean.project.id}">

<div class="form_div">
<table cellpadding="0" cellspacing="0" class="form_table">
<tr class="tr_light">
    <td class="form_label_right" style="width: 20%;">工可批复总投资（亿元）：</td>
    <td class="form_content" style="width: 80%;">
        <form:input path="gctxGkpfTotal" cssClass="input_text"/>
    </td>
</tr>
<tr class="tr_dark">
    <td class="form_label_right">初设批复总投资（亿元）：</td>
    <td class="form_content">
        <form:input path="gctxCspfTotal" cssClass="input_text"/>
    </td>
</tr>
<tr class="tr_light">
    <td class="form_label_right">资金来源：</td>
    <td class="form_content">
        <form:input path="gctxSourceFund" cssClass="input_text_long" cssStyle="width: 90%;"/>
    </td>
</tr>
<tr>
    <td colspan="2">
        <div class="div_space"></div>
        <table cellpadding="0" cellspacing="0" class="table_thin_line" border="1" id="table1"
               style="width: 98%;">
            <tr class="tr_header">
                <td style="width: 15%;">截止时间</td>
                <td style="width: 30%;">累计完成投资（亿元）</td>
                <td style="width: 5%;">
                    <input type='button' value='新增' class='button_select_add'
                           onclick='addLine(this,1,"${TYPE1}")'>
                </td>
            </tr>
            <c:forEach items="${listType1}" var="type1" varStatus="status1">
                <tr style="height: 30px;">
                    <td style="width: 15%;text-align: center;" align="center">
                        <input type='text' class='input_text' style='text-align: center;' readonly
                               name='time${TYPE1}${status1.index+1}' value='${type1.title}'>
                        <input type='hidden' name='year${TYPE1}${status1.index+1}' value='${type1.year}'>
                        <input type='hidden' name='index${TYPE1}' value='${status1.index+1}'>
                    </td>
                    <td style="width: 30%;" align="center">
                        <input type="text" class="input_text" name="cost${TYPE1}${status1.index+1}"
                               value="${type1.accComplete}" onchange="checkNumner(this)">
                    </td>
                    <td style="width: 5%;" align="center">
                        &nbsp;<input type='button' value='删除' class='button_select_remove'
                                     onclick='addLine(this,1,"${TYPE1}")'>
                    </td>
                </tr>
            </c:forEach>
            <tr id="${TYPE1}" style="display: none;height: 30px;">
                <td style="width: 15%;text-align: center;" align="center"></td>
                <td style="width: 30%;" align="center"></td>
                <td style="width: 5%;" align="center">
                    &nbsp;<input type='button' value='删除' class='button_select_remove'
                                 onclick='addLine(this,1,"type1")'>
                </td>
            </tr>
        </table>
        <div class="div_space"></div>
    </td>
</tr>
<tr>
    <td colspan="2">
        <table cellpadding="0" cellspacing="0" class="table_thin_line" border="1" id="table2"
               style="width: 98%;">
            <tr class="tr_header">
                <td style="width: 15%;">时间</td>
                <td style="width: 30%;">年度计划投资（亿元）</td>
                <td style="width: 5%;">
                    <input type='button' value='新增' class='button_select_add'
                           onclick='addLine(this,2,"${TYPE2}")'>
                </td>
            </tr>
            <c:forEach items="${listType2}" var="type2" varStatus="status2">
                <tr style="height: 30px;">
                    <td style="width: 15%;text-align: center;" align="center">
                        <input type='text' class='input_text' style='text-align: center;' readonly
                               name='time${TYPE2}${status2.index+1}' value='${type2.title}'>
                        <input type='hidden' name='year${TYPE2}${status2.index+1}' value='${type2.year}'>
                        <input type='hidden' name='index${TYPE2}' value='${status2.index+1}'>
                    </td>
                    <td style="width: 30%;" align="center">
                        <input type="text" class="input_text" name="cost${TYPE2}${status2.index+1}"
                               value="${type2.accComplete}" onchange="checkNumner(this)">
                    </td>
                    <td style="width: 5%;" align="center">
                        &nbsp;<input type='button' value='删除' class='button_select_remove'
                                     onclick='addLine(this,2,"${TYPE2}")'>
                    </td>
                </tr>
            </c:forEach>
            <tr id="${TYPE2}" style="display: none;height: 30px;">
                <td style="width: 15%;text-align: center;" align="center"></td>
                <td style="width: 30%;" align="center"></td>
                <td style="width: 5%;" align="center">
                    &nbsp;<input type='button' value='删除' class='button_select_remove'
                                 onclick='addLine(this,2,"${TYPE2}")'>
                </td>
            </tr>
        </table>
        <div class="div_space"></div>
    </td>
</tr>
<tr>
    <td colspan="2">
        <table cellpadding="0" cellspacing="0" class="table_thin_line" border="1" id="table3"
               style="width: 98%;">
            <tr class="tr_header">
                <td style="width: 15%;">时间</td>
                <td style="width: 30%;">累计完成投资（亿元）</td>
                <td style="width: 5%;">
                    <input type='button' value='新增' class='button_select_add'
                           onclick='addLine(this,3,"${TYPE3}")'>
                </td>
            </tr>
            <c:forEach items="${listType3}" var="type3" varStatus="status3">
                <tr style="height: 30px;">
                    <td style="width: 15%;text-align: center;" align="center">
                        <input type='text' class='input_text' style='text-align: center;' readonly
                               name='time${TYPE3}${status3.index+1}' value='${type3.title}'>
                        <input type='hidden' name='year${TYPE3}${status3.index+1}' value='${type3.year}'>
                        <input type='hidden' name='half${TYPE3}${status3.index+1}' value='${type3.half}'>
                        <input type='hidden' name='index${TYPE3}' value='${status3.index+1}'>
                    </td>
                    <td style="width: 30%;" align="center">
                        <input type="text" class="input_text" name="cost${TYPE3}${status3.index+1}"
                               value="${type3.accComplete}" onchange="checkNumner(this)">
                    </td>
                    <td style="width: 5%;" align="center">
                        &nbsp;<input type='button' value='删除' class='button_select_remove'
                                     onclick='addLine(this,3,"${TYPE3}")'>
                    </td>
                </tr>
            </c:forEach>
            <tr id="${TYPE3}" style="display: none;height: 30px;">
                <td style="width: 15%;text-align: center;" align="center"></td>
                <td style="width: 30%;" align="center"></td>
                <td style="width: 5%;" align="center">
                    &nbsp;<input type='button' value='删除' class='button_select_remove'
                                 onclick='addLine(this,3,"${TYPE3}")'>
                </td>
            </tr>
        </table>
        <div class="div_space"></div>
    </td>
</tr>
<tr>
    <td colspan="2">
        <table cellpadding="0" cellspacing="0" class="table_thin_line" border="1" id="table4"
               style="width: 98%;">
            <tr class="tr_header">
                <td style="width: 15%;">时间</td>
                <td style="width: 30%;">财政资金已拨付额（亿元）</td>
                <td style="width: 30%;">财政资金已完成额（亿元））</td>
                <td style="width: 5%;">
                    <input type='button' value='新增' class='button_select_add'
                           onclick='addLine(this,4,"${TYPE4}")'>
                </td>
            </tr>
            <c:forEach items="${listType4}" var="type4" varStatus="status4">
                <tr style="height: 30px;">
                    <td style="width: 15%;text-align: center;" align="center">
                        <input type='text' class='input_text' style='text-align: center;' readonly
                               name='time${TYPE4}${status4.index+1}' value='${type4.title}'>
                        <input type='hidden' name='year${TYPE4}${status4.index+1}' value='${type4.year}'>
                        <input type='hidden' name='month${TYPE4}${status4.index+1}' value='${type4.month}'>
                        <input type='hidden' name='index${TYPE4}' value='${status4.index+1}'>
                    </td>
                    <td style="width: 30%;" align="center">
                        <input type="text" class="input_text" name="czCostYbf${TYPE4}${status4.index+1}"
                               value="${type4.czzjYbf}" onchange="checkNumner(this)">
                    </td>
                    <td style="width: 30%;" align="center">
                        <input type="text" class="input_text" name="czCostYwc${TYPE4}${status4.index+1}"
                               value="${type4.czzjYwc}" onchange="checkNumner(this)">
                    </td>
                    <td style="width: 5%;" align="center">
                        &nbsp;<input type='button' value='删除' class='button_select_remove'
                                     onclick='addLine(this,4,"${TYPE4}")'>
                    </td>
                </tr>
            </c:forEach>
            <tr id="${TYPE4}" style="display: none;height: 30px;">
                <td style="width: 15%;text-align: center;" align="center"></td>
                <td style="width: 75%;" align="center"></td>
                <td style="width: 75%;" align="center"></td>
                <td style="width: 5%;" align="center">
                    &nbsp;<input type='button' value='删除' class='button_select_remove'
                                 onclick='addLine(this,4,"${TYPE4}")'>
                </td>
            </tr>
        </table>
    </td>
</tr>
<tr class="tr_button" style="text-align: center;">
    <td class="form_content" colspan="2" style="text-align: center;">
        <input type="button" value="保存" class="button_confirm" onclick="save(this)">&nbsp;
        <input type="button" value="取消" class="button_cancel" onclick="parent.closeWindow()">
    </td>
</tr>
</table>
</div>
</form:form>