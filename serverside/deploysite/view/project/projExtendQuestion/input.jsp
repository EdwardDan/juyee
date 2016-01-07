<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save() {
        if (!validateForm(formId)) {
            return;
        }

        //提交表单
        saveAjaxData("${ctx}/projExtendQuestion/save.do", formId);
    }
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
            var num = 3;
            if (${qdType==dutyType}) {
                num = 4;
            }
            //设置第一列
            var html1 = '<input type="hidden" name="num" value="' + rowIndex + '">';

            var html2 = '<input type="text" name="deptNames' + rowIndex + '" id="deptNames' + rowIndex + '" class="input_text" value="" style="width: 90%;"/>';
            html2 += '<input type="hidden" name="deptIds' + rowIndex + '" id="deptIds' + rowIndex + '" value=""/>';
            html2 += '<input type="button" value="" onclick="multiSelectSysCode(' + "'${dutyDept}'" + ',' + "''" + ',' + "deptIds" + rowIndex + ',' + "deptNames" + rowIndex + ')" class="button_select" title="点击选择责任部门"/> ';
            //列的个数
            for (var i = 0; i < num; i++) {
                var indexNo = document.getElementById("table1").rows.length - 2;
                objCell = objRow.insertCell(i);
                objCell.noWrap = "true";
                objCell.style.display = ssa.cells[i].style.display;
                if (num == 4) {
                    if (i == 1) {
                        objCell.innerHTML = html1; //设置第2列
                    } else if (i == 2) {
                        objCell.innerHTML = html2; //设置第2列
                    } else {
                        objCell.innerHTML = ssa.cells[i].innerHTML;
                    }
                } else {
                    if (i == 0) {
                        alert(ssa.cells[0].innerHTML + html1)
                        objCell.innerHTML = ssa.cells[i].innerHTML + html1; //设置第2列
                    } else {
                        objCell.innerHTML = ssa.cells[i].innerHTML;
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

</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <input type="hidden" name="qdType" id="qdType" value="${qdType}">

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" border="1" class="table_thin_line"
               style="text-align: center;width: 98%;" id="table1">
            <tr class="tr_header">
                <td style="width: 20%;">时间</td>
                <td
                        <c:if test="${qdType==dutyType}">style="width:45%;" </c:if>
                        <c:if test="${qdType==questionType}">style="width:75%;"</c:if>>
                    问题描述
                </td>
                <c:if test="${qdType==dutyType}">
                    <td style="width:30%;">责任部门</td>
                </c:if>
                <td style="width:5%;">
                    <input type='button' value='增加' class='button_select_add' onclick='addLine(this)'>
                </td>
            </tr>

            <c:forEach items="${bean.projExtendQuestions}" var="item" varStatus="status">
                <input type="hidden" name="questionId" value="${item.id}">
                <tr class="tr_light">
                    <td>
                            ${item.year}年${item.month}月
                        <input type="hidden" name="year" value="${item.year}">
                        <input type="hidden" name="month" value="${item.month}">
                        <input type="hidden" name="num" value="${status.index+1}">
                    </td>
                    <c:if test="${qdType==dutyType}">
                        <td style="text-align: left;">${item.question}</td>
                    </c:if>
                    <c:if test="${qdType==questionType}">
                        <td>
                            <input type="text" class="input_text" name="question" value="${item.question}"
                                   style="width: 96%;"/>
                        </td>
                    </c:if>
                    <c:if test="${qdType==dutyType}">
                        <td>
                            <input type="text" name="deptNames${status.index}" id="deptNames${status.index}"
                                   class="input_text" value="${item.deptName}" style="width: 80%;"/>
                            <input type="hidden" name="deptIds${status.index}" id="deptIds${status.index}"
                                   value="${item.deptIds}"/>
                            <input type="button" class="button_select" title="点击选择责任部门"
                                   onclick="multiSelectSysCode('${dutyDept}','','deptIds${status.index}','deptNames${status.index}')">
                        </td>
                    </c:if>
                    <td>
                        <input type="button" value="删除" class="button_select_remove"
                               onclick="addLine(this)">
                    </td>
                </tr>
            </c:forEach>

            <tr id="hiddenStyle" style="display: none;height: 30px;">
                <td>
                    <select class="form_select" name="year" style="width: 60px;">${yearOptions}</select>年
                    <select class="form_select" name="month" style="width: 40px;">${monthOptions}</select>月
                </td>
                <c:if test="${qdType==dutyType}">
                    <td></td>
                </c:if>
                <c:if test="${qdType==questionType}">
                    <td>
                        <input type="text" class="input_text" name="question" value="" style="width: 96%;"/>
                    </td>
                </c:if>
                <c:if test="${qdType==dutyType}">
                    <td></td>
                </c:if>
                <td>
                    <input type="button" value="删除" class="button_select_remove" onclick="addLine(this)">
                </td>
            </tr>
        </table>
    </div>
    <div class="div_space"></div>
    <div class="form_content" style="text-align: center;">
        <input type="button" value="保存" class="button_confirm" onclick="save(this)">&nbsp;
        <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
    </div>
</form:form>
