<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglibs.jsp" %>

<script type="text/javascript">
    $(function () {
        var questionDescId = document.getElementsByName("questionDescId${questionTypeCode}");
        var questionDesc = document.getElementsByName("questionDesc${questionTypeCode}");
        var unlawDesc = document.getElementsByName("unlawDesc${questionTypeCode}");
        if (null != questionDescId) {
            for (var queid = 0; queid < questionDescId.length; queid++) {

                var objTable = document.getElementById("tableNewRight${questionTypeCode}");
                var rowIndex = document.getElementById("tableNewRight${questionTypeCode}").rows.length;
                var objRow = objTable.insertRow(rowIndex);
                objRow.className = "tr_dark";

                var objCell1 = objRow.insertCell(0);
                objCell1.className = "form_td_line";
                objCell1.noWrap = "true";
                objCell1.innerHTML = '<td class="form_content">' + '<input type="text" class="input_text" style="width:150px"  name ="questionName${questionTypeCode}" value ="' + questionDesc[queid].value + '"/>' + '</td>';

                var objCell2 = objRow.insertCell(1);
                objCell2.className = "form_td_line";
                objCell2.noWrap = "true";
                objCell2.innerHTML = '<td class="form_content">' + '<input type="text" class="input_text" style="width:70px"  name ="refRuleName${questionTypeCode}" value ="' + unlawDesc[queid].value + '"/>' + '<input type="hidden"    id="question${questionTypeCode}' + questionDescId[queid].value + '" name ="questionIds${questionTypeCode}" value ="' + questionDescId[queid].value + '"/>' + '</td>';

                var objCell3 = objRow.insertCell(2);
                objCell3.className = "form_td_line";
                objCell3.noWrap = "true";
                objCell3.innerHTML = '<input type="button" value="删除" class="button_select_remove" onclick="deleteLine(this)">';
            }
        }
    });
</script>
<fieldset style="width: 90%;margin:0px auto">
    <legend class="form_legend"><b>已选择问题</b></legend>
<table cellpadding="0" cellspacing="0" border="1" id="tableNewRight${questionTypeCode}" class="form_table" style="width:240px;border-color: #004444;">
    <tr class="tr_header">
        <td class="form_td_line" nowrap width="60%"> 名称 </td>
        <td class="form_td_line" nowrap width="30%" colspan="2">依据法规</td>
    </tr>

</table>
   </fieldset>
<div class="div_space"></div>
<tr class="tr_button">
    <td class="form_label">&nbsp;</td>
    <td class="form_content" >
        <input type="button" value="确定" class="button_confirm" onclick="addQuestion('${questionTypeCode}');closeWindow()">
    </td>
</tr>
<div class="div_space"></div>
