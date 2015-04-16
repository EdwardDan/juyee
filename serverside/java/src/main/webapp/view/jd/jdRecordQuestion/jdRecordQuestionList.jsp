<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<div class="div_space"></div>
<table cellpadding="0" cellspacing="0" border="1" class="form_table" id="${questionTypeCode}"
       style="border-color: #004444">

    <tr class="tr_header" align="center">
        <td class="form_td_line" style="width: 100px" >问题</td>
        <td class="form_td_line" style="width: 100px" >违反条约</td>
        <td class="form_td_line" style="width: 100px" >监督员</td>
        <td class="form_td_line" style="width: 20px"  ><input type='button' value='新增' class='button_select_add'
                                               onclick='addLine(this,"${formTypeCode}","${formId}","${questionTypeCode}")'>
        </td>
    </tr>

    <c:forEach items="${jdRecordQItem}" var="item" varStatus="statusNo">
        <tr class="tr_dark">
            <td class="form_td_line" nowrap>
                <input type="text" size='50' value="${item.questionDesc}"
                       name="questionDesc${questionTypeCode}"/>
                <input type="hidden"
                       id='indexNo${questionTypeCode}${item.questionId}'
                       value="6"
                       name="orderNo${questionTypeCode}"/>
                <input type="hidden"    value="${item.questionId}"
                       name="questionDescId${questionTypeCode}"/>
            </td>
            <td class="form_td_line" nowrap><input type="text" size='25' value="${item.unlawDesc}"
                                                   name="unlawDesc${questionTypeCode}"/>
                <input type="hidden"   value="${item.questionId}" readonly
                       name="unlawDescId${questionTypeCode}"/>
            </td>
            <td class="form_td_line" nowrap>
                <input type="text" size="10" value="${item.jdPersonDesc}" readonly
                       id="jdRecordQuestionPersonNames${statusNo.index}${questionTypeCode}"
                       name="jdRecordQuestionPersonNames${questionTypeCode}"/>

                <input type="button" value=" " class="button_person_add"
                       onclick="selectQuestionRerson('jdRecordQuestionPersonIds${statusNo.index}${questionTypeCode}','jdRecordQuestionPersonNames${statusNo.index}${questionTypeCode}',null)"
                       title="点击选择人员"/>
                <input type="button" value=" " class="button_person_remove"
                       onclick="removeRepeatqustion( 'jdRecordQuestionPersonIds${statusNo.index}${questionTypeCode}','jdRecordQuestionPersonNames${statusNo.index}${questionTypeCode}')"
                       title="点击移除人员"/>
                <input type="hidden"   id="jdRecordQuestionPersonIds${statusNo.index}${questionTypeCode}"
                       name="jdRecordQuestionPersonIds${questionTypeCode}" value="${item.jdPersonId}"/>
            </td>

            <td class="form_td_line" nowrap>
                <input type='button' value='删除' class='button_select_remove' onclick='deleteLine(this)'>
            </td>
        </tr>
    </c:forEach>
    <tr id="hiddenStyle${questionTypeCode}" class="tr_dark" style="display: none">
        <td class="form_td_line" nowrap>
        </td>
        <td class="form_td_line" nowrap>
        </td>
        <td class="form_td_line" nowrap>
        </td>
        <td class="form_td_line" nowrap>
            <input type='button' value='删除' class='button_select_remove' onclick='deleteLine(this)'>
        </td>
    </tr>
</table>
