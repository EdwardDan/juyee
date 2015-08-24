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
            var msg = "";
            //处理title的值
            if (1 == num) {
                colValue = (${curYear}+rowIndex - 2) + "年";
                colName = "${TYPE1}";
                hiddenYear = ${curYear}-1;
                msg = "累计完成投资（亿元）已填报，允许修改！";
            } else if (2 == num) {
                colValue = (${curYear}+rowIndex - 1) + "年";
                colName = "${TYPE2}";
                hiddenYear = ${curYear};
                msg = "年度计划投资（亿元）已填报，允许修改！";
            } else if (3 == num) {
                if (rowIndex % 2 == 0) {
                    colValue = (${curYear}+parseInt((rowIndex - 1) / 2)) + "年全年";
                    hiddenYear = ${curYear};
                    hiddenHalf = "qn";
                } else {
                    colValue = (${curYear}+parseInt((rowIndex - 1) / 2)) + "年上半年";
                    hiddenYear = ${curYear};
                    hiddenHalf = "sbn";
                }
                colName = "${TYPE3}";
                msg = "累计完成投资（亿元）已填报，允许修改！";
            } else if (4 == num) {
                colValue = "${curYear}年" + (${curMonth}+rowIndex - 1) + "月";
                colName = "${TYPE4}";
                hiddenYear =${curYear};
                hiddenMonth = ${curMonth};
                colNum = 4;
                msg = "财政资金（亿元）已填报，允许修改！";
            }
            loadAjaxDataCallback(null, "${ctx}/projExtendCost/checkData.do?extendId=${bean.id}&num=" + num + "&type=" + hiddenType + "&year=" + hiddenYear + "&half=" + hiddenHalf + "&month=" + hiddenMonth, function callbackEvent(ret) {
                var obj = eval("(" + ret + ")");
                if (obj.success) {
                    showInfoMsg(obj.title + msg);
                } else {
                    //列的处理
                    var html1 = "<input type='text' class='input_text' style='text-align: center;' readonly name='time" + colName + rowIndex + "' value='" + colValue + "'>";
                    html1 += "<input type='hidden' name='year" + colName + rowIndex + "' value='" + hiddenYear + "'>";
                    html1 += "<input type='hidden' name='half" + colName + rowIndex + "' value='" + hiddenHalf + "'>";
                    html1 += "<input type='hidden' name='index" + colName + "' value='" + rowIndex + "'>";
                    var html2 = "<input type='text' class='input_text' name='cost" + colName + rowIndex + "' value=''>";
                    var html3 = "<input type='text' class='input_text' name='czCostYbf" + colName + rowIndex + "' value=''>";
                    html3 += "<input type='hidden' name='year" + colName + rowIndex + "' value='" + hiddenYear + "'>";
                    html3 += "<input type='hidden' name='month" + colName + rowIndex + "' value='" + hiddenMonth + "'>";
                    var html4 = "<input type='text' class='input_text' name='czCostYwc" + colName + rowIndex + "' value=''>";
                    //列的个数
                    for (var i = 0; i < colNum; i++) {
                        var indexNo = document.getElementById("table" + num).rows.length - 2;
                        objCell = objRow.insertCell(i);
                        objCell.noWrap = "true";
                        objCell.align = "center";

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
                }
            });
        }
    }
    function deleteLine(obj, year, month, half, num) {
        var currYear =${curYear};
        var currMonth =${curMonth};
        if (1 == num) {
            currYear = ${curYear}-1;
        }
        var trObj = obj.parentNode.parentNode;
        if (1 == num || 2 == num || 3 == num) {
            if (year == currYear) {
                if (confirm("确定要删除吗!")) {
                    trObj.parentElement.removeChild(trObj);
                }
//                save(document.getElementById("save"), "delete");
            } else {
                showErrorMsg("历史数据不能删！");
            }
        } else if (4 == num) {
            if (year == currYear && month == currMonth) {
                if (confirm("确定要删除吗!")) {
                    trObj.parentElement.removeChild(trObj);
                }
//                save(document.getElementById("save"));
            } else {
                showErrorMsg("历史数据不能删！");
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
                               value="${type1.accComplete}">
                    </td>
                    <td style="width: 5%;" align="center">
                        &nbsp;<input type='button' value='删除' class='button_select_remove'
                                     onclick='deleteLine(this,"${type1.year}","","",1)'>
                    </td>
                </tr>
            </c:forEach>
            <tr id="${TYPE1}" style="display: none;height: 30px;">
                <td style="width: 15%;text-align: center;" align="center"></td>
                <td style="width: 30%;" align="center"></td>
                <td style="width: 5%;" align="center">
                    &nbsp;<input type='button' value='删除' class='button_select_remove'
                                 onclick='deleteLine(this,"${curYear-1}","","",1)'>
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
                               value="${type2.accComplete}">
                    </td>
                    <td style="width: 5%;" align="center">
                        &nbsp;<input type='button' value='删除' class='button_select_remove'
                                     onclick='deleteLine(this,"${type2.year}","","",2)'>
                    </td>
                </tr>
            </c:forEach>
            <tr id="${TYPE2}" style="display: none;height: 30px;">
                <td style="width: 15%;text-align: center;" align="center"></td>
                <td style="width: 30%;" align="center"></td>
                <td style="width: 5%;" align="center">
                    &nbsp;<input type='button' value='删除' class='button_select_remove'
                                 onclick='deleteLine(this,"${curYear}","","",2)'>
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
                               value="${type3.accComplete}">
                    </td>
                    <td style="width: 5%;" align="center">
                        &nbsp;<input type='button' value='删除' class='button_select_remove'
                                     onclick='deleteLine(this,"${type3.year}","","${type3.half}",3)'>
                    </td>
                </tr>
            </c:forEach>
            <tr id="${TYPE3}" style="display: none;height: 30px;">
                <td style="width: 15%;text-align: center;" align="center"></td>
                <td style="width: 30%;" align="center"></td>
                <td style="width: 5%;" align="center">
                    &nbsp;<input type='button' value='删除' class='button_select_remove'
                                 onclick='deleteLine(this,"${curYear}","","",3)'>
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
                               value="${type4.czzjYbf}">
                    </td>
                    <td style="width: 30%;" align="center">
                        <input type="text" class="input_text" name="czCostYwc${TYPE4}${status4.index+1}"
                               value="${type4.czzjYwc}">
                    </td>
                    <td style="width: 5%;" align="center">
                        &nbsp;<input type='button' value='删除' class='button_select_remove'
                                     onclick='deleteLine(this,"${type4.year}","${type4.month}","",4)'>
                    </td>
                </tr>
            </c:forEach>
            <tr id="${TYPE4}" style="display: none;height: 30px;">
                <td style="width: 15%;text-align: center;" align="center"></td>
                <td style="width: 75%;" align="center"></td>
                <td style="width: 75%;" align="center"></td>
                <td style="width: 5%;" align="center">
                    &nbsp;<input type='button' value='删除' class='button_select_remove'
                                 onclick='deleteLine(this,"${curYear}","${curMonth}","",4)'>
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