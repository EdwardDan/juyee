<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">

    function removeRepeatqustion(id, name) {
        var id = document.getElementById(id);
        var name = document.getElementById(name);
        id.value = "";
        name.value = "";
    }

    function addLine(obj, formTypeCode, formId, questionTypeCode) {
        openNewWindow("newWindow2", "选择问题", "${ctx}/jdRecordQuestion/init.do?formTypeCode=" + formTypeCode + "&formId=" + formId + "&questionTypeCode=" + questionTypeCode, false, 950, 550);
    }

    function deleteLine(obj) {

        var trObj = obj.parentNode.parentNode;
        trObj.parentElement.deleteRow(trObj.rowIndex);
    }

    // 返回选中的问题单
    function addQuestion(questionTypeCode) {
        var questionIds = document.getElementsByName("questionIds" + questionTypeCode);
        var questionNames = document.getElementsByName("questionName" + questionTypeCode);
        var refRuleNames = document.getElementsByName("refRuleName" + questionTypeCode);

        if (null != questionIds) {
            var objTable = document.getElementById(questionTypeCode);
            var tableId = objTable.id;
            // 先删除被用户删除的监督问题
            var deleteItems = document.getElementsByName("questionDescId" + tableId);
            if (null != deleteItems) {
                var deleteRowIndexs = "";
                for (var ii = 0; ii < deleteItems.length; ii++) {
                    var flag = false;
                    for (var jj = 0; jj < questionIds.length; jj++) {
                        if (questionIds[jj].value == deleteItems[ii].value) {
                            flag = true;
                        }
                    }
                    if (!flag) {
                        deleteRowIndexs += ("indexNo" + questionTypeCode + deleteItems[ii].value + ',');
                    }
                }
                if (null != deleteRowIndexs && "" != deleteRowIndexs) {
                    var deleteRowIndexArray = deleteRowIndexs.substring(0, deleteRowIndexs.length - 1).split(",");
                    for (var saa = 0; saa < deleteRowIndexArray.length; saa++) {
                        var indexNO = document.getElementById(deleteRowIndexArray[saa]);
                        var trObj = indexNO.parentNode.parentNode;
                        trObj.parentElement.deleteRow(trObj.rowIndex);
                    }
                }
            }
            for (var quId = 0; quId < questionIds.length; quId++) {
                var rowIndex = objTable.rows.length ;
                var objRow = objTable.insertRow(rowIndex);
                var objCell;
                var name = "hiddenStyle" + tableId;
                var ssa = document.getElementById(name);
                objRow.className = "tr_dark";
                var flag = true;
                if (null != deleteItems) {
                    for (var zz = 0; zz < deleteItems.length; zz++) {
                        if (deleteItems[zz].value == questionIds[quId].value) {
                            flag = false;
                        }
                    }
                }
                if (flag) {
                    for (var i = 0; i < 4; i++) {
                        var indexno = document.getElementById(tableId).rows.length;

                        var htmlWord0 = '<input type="hidden"   value="6" id="indexNo' + tableId + questionIds[quId].value + '"  name="orderNo' + tableId + '"/>' +
                                '<input type="text" size="50" value="' + questionNames[quId].value + '"     name="questionDesc' + tableId + '"/>' +
                                '<input type="hidden"   value="' + questionIds[quId].value + '"    name="questionDescId' + tableId + '"/>';
                        var htmlWord1 = '<input type="text" size="25" value="' + refRuleNames[quId].value + '"   name="unlawDesc' + tableId + '"/>' +
                                '<input type="hidden"   value="' + questionIds[quId].value + '" readonly   name="unlawDescId' + tableId + '"/>';

                        var htmlWord2 = '<input type="text" size="10" value=""  id="jdRecordQuestionPersonNamesAdd' + indexno + tableId + '" name="jdRecordQuestionPersonNames' + tableId + '"/> '
                                + '<input type="button" value=" " class="button_person_add" ' +
                                'onclick="' + "selectQuestionRerson('jdRecordQuestionPersonIdsAdd" + indexno + tableId + "','jdRecordQuestionPersonNamesAdd" + indexno + tableId + "',null)" + '"' +
                                ' title="点击选择人员"/>  ' + '  <input type="button" value=" " class="button_person_remove"  ' +
                                'onclick="' + "removeRepeatqustion('jdRecordQuestionPersonIdsAdd" + indexno + tableId + "','jdRecordQuestionPersonNamesAdd" + indexno + tableId + "')" + '"' +
                                ' title="点击移除人员"/>' + ' <input type="hidden" id="jdRecordQuestionPersonIdsAdd' + indexno + tableId + '" name="jdRecordQuestionPersonIds' + tableId + '" value=""/>';

                        objCell = objRow.insertCell(i);
                        if (i == 2) {
                            objCell.innerHTML = htmlWord2;
                            objCell.className = "form_td_line";
                            objCell.noWrap = "true";
                        } else if (i == 0) {
                            objCell.innerHTML = htmlWord0;
                            objCell.className = "form_td_line";
                            objCell.noWrap = "true";
                        }
                        else if (i == 1) {
                            objCell.innerHTML = htmlWord1;
                            objCell.className = "form_td_line";
                            objCell.noWrap = "true";

                        }
                        else {
                            objCell.noWrap = "true";
                            objCell.innerHTML = ssa.cells[i].innerHTML;
                            objCell.style.display = ssa.cells[i].style.display;
                            objCell.className = "form_td_line";
                        }
                    }
                }
            }
        }
    }
    function selectQuestion(obj, id, name, refRule, questionTypeCode) {
        // 选中后增加行
        if (obj.checked) {
            var flag = true;
            // 如果之前有则不做操作
            var questionIds = document.getElementsByName("questionIds" + questionTypeCode);
            if (null != questionIds) {
                for (var indexNo = 0; indexNo < questionIds.length; indexNo++) {
                    if (questionIds[indexNo].value == id) {
                        flag = false;
                    }
                }
            }
            if (flag) {
                var objTable = document.getElementById("tableNewRight" + questionTypeCode);
                var rowIndex = document.getElementById("tableNewRight" + questionTypeCode).rows.length;
                var objRow = objTable.insertRow(rowIndex);
                objRow.className = "tr_dark";

                var objCell1 = objRow.insertCell(0);
                objCell1.className = "form_td_line";
                objCell1.noWrap = "true";
                objCell1.innerHTML = '<td class="form_content">' + '<input type="text" class="input_text" style="width:150px"  name ="questionName' + questionTypeCode + '" value ="' + name + '"/>' + '</td>';

                var objCell2 = objRow.insertCell(1);
                objCell2.className = "form_td_line";
                objCell2.noWrap = "true";
                objCell2.innerHTML = '<td class="form_content">' + '<input type="text" class="input_text" style="width:70px"  name ="refRuleName' + questionTypeCode + '" value ="' + refRule + '"/>' + '<input type="hidden"   id="question' + questionTypeCode + id + '" name ="questionIds' + questionTypeCode + '" value ="' + id + '"/>' + '</td>';

                var objCell3 = objRow.insertCell(2);
                objCell3.className = "form_td_line";
                objCell3.noWrap = "true";
                objCell3.innerHTML = '<input type="button" value="删除" class="button_select_remove" onclick="deleteLine(this)">';
            }
        }
        // 没有选中则删除行
        else {
            var questionIds = document.getElementsByName("questionIds" + questionTypeCode);
            if (null != questionIds) {
                for (var indexNo = 0; indexNo < questionIds.length; indexNo++) {
                    if (questionIds[indexNo].value == id) {

                        var xx = document.getElementById("question" + questionTypeCode + id);
                        var trObj = xx.parentNode.parentNode;
                        trObj.parentElement.deleteRow(trObj.rowIndex);
                    }
                }
            }
        }
    }
</script>