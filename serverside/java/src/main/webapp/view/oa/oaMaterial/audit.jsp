<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "code", rule: "validate[required,maxSize[50]]"},
            {name: "reportDate", rule: "validate[required,custom[date],maxSize[20]"},
            {name: "reportPerson", rule: "validate[required,maxSize[50]]"},
            {name: "reportDept", rule: "validate[required,maxSize[100]]"}
            <c:if test="${bean.status == STATUS_SUBMIT}">
            ,
            {name: "officeOpinion", rule: "validate[required,maxSize[2000]]"},
            {name: "officeAuditTime", rule: "validate[required,maxSize[30]]"}
            </c:if>
            <c:if test="${bean.status == STATUS_SUBMIT_LEADER}">
            ,
            {name: "leaderOpinion", rule: "validate[required,maxSize[2000]]"},
            {name: "leaderAuditTime", rule: "validate[required,maxSize[30]]"}
            </c:if>
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(status, buttonName) {
        //判断必输项
        if ( status == ${STATUS_SUBMIT_LEADER}) {
            $("#officeOpinion").attr("data-validation-engine", "validate[maxSize[2000]]");
            $("#officeAuditTime").attr("data-validation-engine", "validate[maxSize[30]]");
        } else if (status == ${STATUS_BACK}) {
            $("#officeOpinion").attr("data-validation-engine", "validate[required,maxSize[2000]]");
            $("#officeAuditTime").attr("data-validation-engine", "validate[required,maxSize[30]]");
        }
        if (status == ${STATUS_PASS}) {
            $("#leaderOpinion").attr("data-validation-engine", "validate[maxSize[2000]]");
            $("#leaderAuditTime").attr("data-validation-engine", "validate[maxSize[30]]");
        } else if (status == ${STATUS_BACK_LEADER}) {
            $("#leaderOpinion").attr("data-validation-engine", "validate[required,maxSize[2000]]");
            $("#leaderAuditTime").attr("data-validation-engine", "validate[required,maxSize[30]]");
        }

        if (!validateForm(formId)) {
            return;
        }
        //判断第一列物资设备名称不能为空
        var materialName = $("input[id^='materialName']");
        for (var i = 0; i < materialName.length; i++) {
            if (materialName[i].value == '') {
                showInfoMsg("物资设备名称不能为空！");
                return;
            }
        }
        //加入其他业务判断
        if (status == '${STATUS_PASS}')
            if (!checkTime()) return;

        //提交表单
        if (status == '${STATUS_PASS}' || status == '${STATUS_SUBMIT_LEADER}') {
            if (confirm("审核通过后将不能再修改，确定继续吗？")) {
                removeStandRow();
                saveAjaxData("${ctx}/oaMaterial/saveAudit.do?status=" + status, formId);
            }
        }
        if (status == '${STATUS_BACK_LEADER}' || status == '${STATUS_BACK}') {
            if (confirm("确定要退回修改吗？")) {
                removeStandRow();
                saveAjaxData("${ctx}/oaMaterial/saveAudit.do?status=" + status, formId);
            }
        }
    }
    //判断时间
    function checkTime() {
        var officeAuditTime = $("#officeAuditTime").val();
        var leaderAuditTime = $("#leaderAuditTime").val();
        if (officeAuditTime > leaderAuditTime) {
            showInfoMsg("办公室审核时间不能大于领导审核时间！");
            return false;
        }
        return true;
    }
    //删除标准行
    function removeStandRow() {
        var hiddenStyle = document.getElementById("hiddenStyle");
        standarditemDisable(hiddenStyle);
    }
    //增加或删除行
    function addLine(obj) {
        var objTable = obj.parentNode.parentNode.parentNode.parentNode;

        if (obj.value == '增加') {
            var rowIndex = document.getElementById("table1").rows.length - 1;
            var objRow = objTable.insertRow(rowIndex);
            var objCell;
            var ssa = document.getElementById("hiddenStyle");
            if (rowIndex % 2 == 0) {
                objRow.className = "td_light";
            } else {
                objRow.className = "td_dark";
            }
            //设置第一列
            var html1 = "<input type='text' name='materialName' id='materialName_" + rowIndex + "' class='input_text' value=''>";
            //列的个数
            for (var i = 0; i < 6; i++) {
                var indexNo = document.getElementById("table1").rows.length - 2;
                objCell = objRow.insertCell(i);
                objCell.noWrap = "true";
                objCell.style.display = ssa.cells[i].style.display;
                if (i == 0) {
                    objCell.innerHTML = '&nbsp;' + indexNo;
                } else if (i == 1) {
                    objCell.innerHTML = html1; //设置第一列
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

<div class="form_div">
<table cellpadding="0" cellspacing="0" class="form_table">
<tr>
    <td>
        <fieldset class="form_fieldset" style="width: 90%;margin: 0 auto;display: true;">
            <legend class="form_legend">物资申请</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label_right">申请编号：</td>
                    <td class="form_content">
                        <form:input path="code" cssClass="input_text"/>
                    </td>
                    <td class="form_label_right">申请日期：</td>
                    <td class="form_content">
                        <form:input path="reportDate" cssClass="input_date" readonly="true"/>
                        <input type="button" class="button_calendar" value=" "
                               onClick="calendar('reportDate');">
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">申请部门：</td>
                    <td class="form_content">
                        <input type="text" name="reportDept" id="reportDept" class="input_text"
                               value="${bean.reportDept}"
                               readonly="true">
                        <input type="hidden" name="sysDeptId" id="sysDeptId" value=""/>
                        <input type="button" class="button_select"
                               onclick="selectSysDept('sysDeptId','reportDept')"
                               title="点击选择申请部门">
                    </td>
                    <td class="form_label_right">申请人：</td>
                    <td class="form_content">
                        <input type="text" name="reportPerson" id="reportPerson" class="input_text"
                               value="${bean.reportPerson}" readonly="true"/>
                        <input type="hidden" name="person" id="person" value=""/>
                        <input type="button" class="button_select"
                               onclick="selectSysPerson('person','reportPerson');"
                               title="点击选择申请人员">
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">备注要求：</td>
                    <td class="form_content" colspan="3">
                        <form:textarea path="requireDesc" cssClass="input_textarea_long"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="4">
                        <table id="table1" cellpadding="0" cellspacing="0" width="100%" align="center">
                            <tr class="tr_header">
                                <td class="form_td_line" width="40" nowrap>序号</td>
                                <td class="form_td_line" width="155" nowrap>物资设备名称</td>
                                <td class="form_td_line" width="155" nowrap>具体规格型号</td>
                                <td class="form_td_line" width="155" nowrap>供应商情况</td>
                                <td class="form_td_line" width="155" nowrap>数量</td>
                                <td class="form_td_line" width="60" nowrap>操作&nbsp;
                                    <input type="button" class="button_select_add" onclick="addLine(this)"
                                           value="增加">
                                </td>
                            </tr>
                            <c:forEach items="${bean.oaMaterialItems}" var="item" varStatus="status">
                                <tr class="tr_dark">
                                    <td align="center" nowrap>${status.index+1}</td>
                                    <td align="center" nowrap>
                                        <input type="text" name="materialName" id="materialName${item.id}"
                                               class="input_text" value="${item.materialName}">
                                    </td>
                                    <td align="center" nowrap>
                                        <input type="text" name="materialModel"
                                               class="input_text" value="${item.materialModel}">
                                    </td>
                                    <td align="center" nowrap>
                                        <input type="text" name="supplier" class="input_text"
                                               value="${item.supplier}">
                                    </td>
                                    <td align="center" nowrap>
                                        <input type="text" name="materialNum"
                                               class="input_text" value="${item.materialNum}">
                                    </td>
                                    <td align="center" nowrap>
                                        <input type="button" class="button_select_add"
                                               onclick="addLine(this)" value="增加">&nbsp;
                                        <input type="button" class="button_select_remove"
                                               onclick="addLine(this)" value="删除">
                                    </td>
                                </tr>
                            </c:forEach>
                            <tr id="hiddenStyle" style="display: none" class="tr_dark">
                                <td align="center" nowrap></td>
                                <td align="center" nowrap></td>
                                <td align="center" nowrap>
                                    <input type="text" id="materialModel" name="materialModel"
                                           class="input_text" value="">
                                </td>
                                <td align="center" nowrap>
                                    <input type="text" id="supplier" name="supplier" class="input_text"
                                           value="">
                                </td>
                                <td align="center" nowrap>
                                    <input type="text" id="materialNum" name="materialNum"
                                           class="input_text" value="">
                                </td>
                                <td align="center" nowrap>
                                    <input type="button" class="button_select_add" onclick="addLine(this)"
                                           value="增加">&nbsp;
                                    <input type="button" class="button_select_remove"
                                           onclick="addLine(this)" value="删除">
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </fieldset>
    </td>
</tr>
<tr>
    <td>
        <fieldset class="form_fieldset" style="width: 90%;margin: 0 auto;display: true;">
            <legend class="form_legend">办公室审核</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <c:choose>
                    <c:when test="${bean.status == STATUS_SUBMIT_LEADER}">
                        <tr class="tr_dark">
                            <td class="form_label_right" width="20%">办公室审核意见：</td>
                            <td class="form_content">
                                <form:textarea path="officeOpinion" cssClass="input_textarea_long" readonly="true"/>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right">审核时间：</td>
                            <td class="form_content">
                                <input type="text" name="officeAuditTime" class="input_datetime"
                                       value="<fmt:formatDate value="${bean.officeAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                                       readonly="true"/>
                                <input type="button" class="button_calendar" value=" " disabled="true"
                                       onClick="calendar('officeAuditTime','all')">
                            </td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <tr class="tr_dark">
                            <td class="form_label_right" width="20%">办公室审核意见：</td>
                            <td class="form_content">
                                <form:textarea path="officeOpinion" cssClass="input_textarea_long"/>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right">审核时间：</td>
                            <td class="form_content">
                                <input type="text" name="officeAuditTime" id="officeAuditTime"
                                       class="input_datetime"
                                       value="<fmt:formatDate value="${bean.officeAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                                       readonly="true"/>
                                <input type="button" class="button_calendar" value=" "
                                       onClick="calendar('officeAuditTime','all')">
                            </td>
                        </tr>
                    </c:otherwise>
                </c:choose>

            </table>
        </fieldset>
    </td>
</tr>
<tr style="<c:if test="${bean.status == STATUS_SUBMIT}">display: none;</c:if>">
    <td>
        <fieldset class="form_fieldset" style="width: 90%;margin: 0 auto;display: true;">
            <legend class="form_legend">领导审核</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label_right" width="20%">主管领导审核意见：</td>
                    <td class="form_content">
                        <form:textarea path="leaderOpinion" cssClass="input_textarea_long"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">审核时间：</td>
                    <td class="form_content">
                        <input type="text" name="leaderAuditTime" id="leaderAuditTime"
                               class="input_datetime"
                               value="<fmt:formatDate value="${bean.leaderAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                               readonly="true"/>
                        <input type="button" class="button_calendar" value=""
                               onClick="calendar('leaderAuditTime','all')">
                    </td>
                </tr>
            </table>
        </fieldset>
    </td>
</tr>
<tr class="tr_button">
    <td class="form_border" align="center" colspan="4">
        <c:choose>
            <c:when test="${bean.status == STATUS_SUBMIT}">
                <input type="button" value="审核通过" class="button_normal_long"
                       onclick="save('${STATUS_SUBMIT_LEADER}',this.value)">&nbsp;
                <input type="button" value="退回修改" class="button_normal_long"
                       onclick="save('${STATUS_BACK}',this.value)">&nbsp;
            </c:when>
            <c:when test="${bean.status == STATUS_SUBMIT_LEADER}">
                <input type="button" value="审核通过" class="button_normal_long"
                       onclick="save('${STATUS_PASS}',this.value)">&nbsp;
                <input type="button" value="退回修改" class="button_normal_long"
                       onclick="save('${STATUS_BACK_LEADER}',this.value)">&nbsp;
            </c:when>
        </c:choose>
        <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
    </td>
</tr>
</table>
</div>
</form:form>