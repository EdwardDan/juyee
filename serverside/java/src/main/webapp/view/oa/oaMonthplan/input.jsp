<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "reportDept", rule: "validate[required,maxSize[50]]"},
            {name: "reportPerson", rule: "validate[required,maxSize[25]]"},
            {name: "year", rule: "validate[required,custom[integer],maxSize[4]"},
            {name: "period", rule: "validate[required,custom[integer],maxSize[2]"},
//         {name:"content", rule:"validate[required,maxSize[1000]]"},
//           {name:"timeNode", rule:"validate[required,custom[date],maxSize[20]]"},
//         {name:"reportType", rule:"validate[required]"},
//            {name:"isComplete", rule:"validate[required]"},
            {name: "fgOpinion", rule: "validate[required,maxSize[1000]]"},
            {name: "fgAuditTime", rule: "validate[required,maxSize[20]]"}
        ];
        validateInit(validateCondition, formId);
    });


    //保存操作
    function save(status, buttonName) {
        if (!validateForm(formId)) {
            return;
        }

        //判断第一列内容不能为空
        var content = $("textarea[id^='content']");
        for (var i = 0; i < content.length; i++) {
            if (content[i].value == '') {
                showInfoMsg("工作内容不为空！");
                return;
            }
        }


        //提交表单

        if (buttonName != "") {
            if (confirm("提交之后将不能再修改，确定继续吗？")) {
                removeStandRow();
                saveAjaxData("${ctx}/oaMonthplan/save.do?status=" + status, formId);
            }
        } else {
            removeStandRow();
            saveAjaxData("${ctx}/oaMonthplan/save.do?status=" + status, formId);
        }
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
            var html1 = "<textarea type='text' name='content' id='content_" + rowIndex + "' class='input_textarea' value=''>";

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
                        <legend class="form_legend">月度总结和计划</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td class="form_label_right">提交部门：</td>
                                <td class="form_content">
                                    <input type="text" name="reportDept" id="reportDept" class="input_text"
                                           value="${bean.reportDept}" readonly="true">
                                    <input type="hidden" name="sysDeptId" id="sysDeptId" value=""/>
                                    <input type="button" class="button_select"
                                           onclick="selectSysDept('sysDeptId','reportDept')"
                                           title="点击选择申请部门">
                                </td>
                                <td class="form_label_right">责任人：</td>
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
                                <td class="form_label_right">报告时间：</td>
                                <td class="form_content" colspan="4">
                                    <select name="year" id="year" title="请选择开始时间（时）">
                                            ${YearSelectOptions}
                                    </select>年
                                    <select name="period" id="period" title="请选择开始时间（时）">
                                            ${PeriodSelectOptions}
                                    </select>月
                                </td>
                            </tr>
                            <tr>
                                <td colspan="4">
                                    <table id="table1" cellpadding="0" cellspacing="0" width="100%" align="center">
                                        <tr class="tr_header">
                                            <td class="form_td_line" width="40" nowrap>序号</td>
                                            <td class="form_td_line" width="155" nowrap>工作内容</td>
                                            <td class="form_td_line" width="155" nowrap>时间节点</td>
                                            <td class="form_td_line" width="155" nowrap>报告类型</td>
                                            <td class="form_td_line" width="155" nowrap>是否完成</td>
                                            <td class="form_td_line" width="60" nowrap>操作&nbsp;
                                                <input type="button" class="button_select_add" onclick="addLine(this)"
                                                       value="增加">
                                            </td>
                                        </tr>

                                        <c:forEach items="${bean.oaMonthplanItems}" var="item" varStatus="status">
                                            <tr class="tr_dark">
                                                <td align="center" nowrap>
                                                    ${status.index+1}
                                                </td>
                                                <td align="left" nowrap>
                                                    <textarea type="text" name="content" id="content${item.id}"
                                                              class="input_textarea">${item.content}</textarea>
                                                </td>
                                                <td align="center" nowrap>
                                                    <input name="timeNode" type="text" class="input_date"
                                                           value="${item.timeNode}"
                                                           onClick="calendar(null,'date');">
                                                </td>
                                                <td>
                                                    <select name="reportType">
                                                        <option
                                                                <c:if test="${item.reportType=='总结'}">selected</c:if>
                                                                value="总结">总结
                                                        </option>
                                                        <option
                                                                <c:if test="${item.reportType=='计划'}">selected</c:if>
                                                                value="计划">计划
                                                        </option>
                                                    </select>

                                                </td>
                                                <td align="center" nowrap>
                                                    <select name="isComplete">
                                                        <option
                                                                <c:if test="${item.isComplete==true}">selected</c:if>
                                                                value="true">是
                                                        </option>
                                                        <option
                                                                <c:if test="${item.isComplete==false}">selected</c:if>
                                                                value="false">否
                                                        </option>
                                                    </select>

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
                                            <td align="left" nowrap></td>
                                            <td align="center" nowrap>
                                                <input name="timeNode" type="text" class="input_date"
                                                       onClick="calendar(null,'date');">
                                            </td>
                                            <td align="center" nowrap>
                                                <select name="reportType">
                                                    <option value="总结">总结</option>
                                                    <option value="计划">计划</option>
                                                </select>

                                            </td>
                                            <td align="center" nowrap>
                                                <select name="isComplete">
                                                    <option value="true">是</option>
                                                    <option value="false">否</option>
                                                </select>
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
            <tr class="tr_button">
                <td class="form_border">
                    <input type="button" value="提交" class="button_confirm"
                           onclick="save('${STATUS_SUBMIT}',this.value)">&nbsp;
                    <input type="button" value="暂存" class="button_confirm"
                           onclick="save('${STATUS_EDIT}','')">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>

    </div>
</form:form>