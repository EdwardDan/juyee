<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/view/jd/jdRecordQuestion/commonJs.jsp" %>
<script type="text/javascript">
var formId = "bean";
$(function () {
    //页面验证初始化
    var validateCondition = [
        {name: "jdTaskCode", rule: "validate[required,maxSize[50]]"},
        {name: "bjbh", rule: "validate[required,maxSize[50]]"},
        {name: "weather", rule: "validate[required,maxSize[100]]"},
        {name: "projectName", rule: "validate[required,maxSize[100]]"},
        {name: "personName", rule: "validate[required]"},
        {name: "attendPersons", rule: "validate[required,maxSize[100]]"},
        {name: "jsDept", rule: "validate[required,maxSize[100]]"},
        {name: "kcDept", rule: "validate[required,maxSize[100]]"},
        {name: "sjDept", rule: "validate[required,maxSize[100]]"},
        {name: "sgDept", rule: "validate[required,maxSize[100]]"},
        {name: "jlDept", rule: "validate[required,maxSize[100]]"},
        {name: "jcDept", rule: "validate[required,maxSize[100]]"},
        {name: "dealOpinion", rule: "validate[required,maxSize[1000]]"}
    ];

    validateInit(validateCondition, formId);
    loadAjaxData("otherCheck", "${ctx}/jdRecordQuestion/getRecordList.do?formTypeCode=${JD_RECORD_SAFE_CHECK_TYPE}&questionTypeCode=${JD_RECORD_COMPLETE_CHECK_OTHER}&formId=${bean.id}&pageStyle=input");
    getWeek('jdDatetime', 'week');
    if (${not empty jdTaskCode}) {
        $("#jdTaskCode").val('${jdTaskCode}');
        $("#btnFlowCode").trigger("click");
    }
});

function disableBtnById(id) {
    var v = document.getElementById(id);
    if (v != undefined && v != null && v != "") {
        v.disabled = true;
    }
}

function disableAllBtn() {
    disableBtnById("pass");
    disableBtnById("back");

    disableBtnById("submit");
    disableBtnById("edit");
}

function enableBtnById(id, name) {
    var v = document.getElementById(id);
    if (v != undefined && v != null && v != "") {
        v.value = name;
        v.disabled = false;
    }
}

function enableAllBtn() {
    enableBtnById("pass", "通过");
    enableBtnById("back", "退回");

    enableBtnById("submit", "提交");
    enableBtnById("edit", "保存");
}

//保存操作
function save(status, btn) {

    getPersonIdsToHiddenPath();
    getPersonNamesToHiddenPath();

    disableAllBtn();
    disableBtn(btn);

    $("#status").val(status);
    if (!validateForm(formId)) {
        enableAllBtn();
        return;
    }

    if ($("#attendPersonIds").val() == null || $("#attendPersonIds").val() == "") {
        showErrorMsg("请选择参加监督人员！");
        $("#attendPerson")[0].focus();
        enableAllBtn();
        return;
    }

    if (status == '${STATUS_SUBMIT}') {
        if (!confirm("是否提交，提交后不能修改？")) {
            enableAllBtn();
            return false;
        }
    } else if (status == '${STATUS_PASS}') {
        if (!confirm("是否通过，通过后不能修改？")) {
            enableAllBtn();
            return false;
        }
    } else if (status == '${STATUS_BACK}') {
        if (!confirm("是否确定执行退回操作？")) {
            enableAllBtn();
            return false;
        }
    }

    //提交表单
    saveAjaxData("${ctx}/jdRecordComplete/save.do?jdcode=${jdcode}", formId);
}

function getPersonIdsToHiddenPath() {
    var a = getSelectValues(document.getElementById("attendPerson"));
    var b = document.getElementById("attendPersonIds");
    b.value = a;
}
function getPersonNamesToHiddenPath() {
    var a = getSelectNames("#attendPerson");
    var b = document.getElementById("attendPersons");
    b.value = a;
}

/**
 * 去除select中重复的选项。
 */
function removeRepeatInner() {
    var select = document.getElementById("attendPerson");
    removeRepeatOption(select);
}

var jdDwgcIds;
var jdDwgcNames;
function addExcelJdDwgc(selectId, inputId, inputName) {
    var v = $('#jdTaskCode').val();
    if (v == '' || v == null) {
        showErrorMsg("请输入监督任务书编号！")
    } else {

        jdDwgcIds = $('#excelJdDwgcIds').val();
        jdDwgcNames = $('#excelJdDwgcNames').val();
        multiSelectExcelJdDwgc(v, selectId, inputId, inputName, ExcelJdDwgcCallback);
    }
}


function ExcelJdDwgcCallback() {
    var inputIdString = $('#excelJdDwgcIds').val();
    var inputNameString = $('#excelJdDwgcNames').val();

    var oldIds = jdDwgcIds.split(",");

    var inputIds = inputIdString.split(",");
    var inputNames = inputNameString.split(",");

    var obj;
    var tr;
    var add = true;
    for (var i = 0; i < inputIds.length; i++) {
        obj = inputNames[i];

        for (var j = 0; j < oldIds.length; j++) {
            if (inputIds[i] == oldIds[j]) {
                add = false;
                break;
            }
        }

        if (add) {
            if (jdDwgcIds == null || jdDwgcIds == "") {
                jdDwgcIds = inputIds[i];
            } else {
                jdDwgcIds += "," + inputIds[i];
            }

            if (jdDwgcNames == null || jdDwgcNames == "") {
                jdDwgcNames = inputNames[i];
            } else {
                jdDwgcNames += "," + inputNames[i];
            }

            obj = obj.substring(0, obj.length - inputIds[i].length - 2);

            tr = '<tr class="tr_dark" id="tr_' + inputIds[i] + '"  name="tr_' + inputIds[i] + '">' +
                    '<td class="form_border" align="center">&nbsp;' + inputIds[i] + '</td>' +
                    '<td class="form_border"  align="left">&nbsp;' + obj + '</td>' +
                    '<td class="form_border" align="center">' +
                    '<input type="button" class="button_cancel" value="删除" onclick="deleteThisRow(\'' + inputIds[i] + '\')"></td></tr>';

            $("#ExcelJdDwgcTable").append(tr);
        }
        add = true;


    }

    $('#excelJdDwgcIds').val(jdDwgcIds);
    $('#excelJdDwgcNames').val(jdDwgcNames);

}

function deleteThisRow(trId) {
    var info = "您确定要删除此记录吗?";
    $.messager.confirm('系统提示', info, function (r) {
        if (r) {
            var inputIdString = $('#excelJdDwgcIds').val();
            var inputNameString = $('#excelJdDwgcNames').val();
            var inputIds = inputIdString.split(",");
            var inputNames = inputNameString.split(",");

            var obj;
            for (var i = 0; i < inputIds.length; i++) {
                obj = inputIds[i];

                if (trId == inputIds[i]) {
                    inputIds.splice(i, 1);
                    inputNames.splice(i, 1);
                }
            }

            $('#excelJdDwgcIds').val(inputIds.join(','));
            $('#excelJdDwgcNames').val(inputNames.join(','));

            var tr = $("#tr_" + trId);
            tr.remove();
        }
    });
}
</script>
<form:form commandName="bean">
<form:hidden path="id"/>
<form:hidden path="status"/>

<div class="form_div">
<table cellpadding="0" cellspacing="0" class="form_table">
<tr class="tr_light">
    <input type="hidden" id="planDetailId"name="planDetailId" value="${planDetailId}"/>
    <td class="form_label_right" width="15%">监督任务书编号：</td>
    <td class="form_content" width="35%">
        <form:input path="jdTaskCode" cssClass="input_text" maxlength="50"
                    cssStyle="float:left"/>
        <input type="button" value="获取" id="btnFlowCode" class="button_all"
               onclick="getJdProjectInfo(this)" style="float:left;"/>
    </td>
    <td class="form_label_right"  width="15%">报建编号：</td>
    <td class="form_content"  width="35%">
        <form:input path="bjbh" cssClass="input_text"/>
    </td>
</tr>

<tr class="tr_dark">
    <td class="form_label_right">工程名称：</td>
    <td class="form_content" colspan="3">
        <form:input path="projectName" cssClass="input_text_long" cssStyle="width: 623px"/>
    </td>
</tr>

<tr class="tr_light">
    <td class="form_label_right">监督记录编号：</td>
    <td class="form_content">
        <form:input path="code" cssClass="input_text" readonly="true"/>
    </td>
    <td class="form_label_right">天气：</td>
    <td class="form_content">
        <form:input path="weather" cssClass="input_text"/>
    </td>
</tr>

<tr class="tr_dark">
    <td class="form_label_right">监督日期：</td>
    <td class="form_content">
        <input type="text" name="jdDatetime" id="jdDatetime" class="input_datetime"
               value="<fmt:formatDate value="${bean.jdDatetime}" pattern="yyyy-MM-dd"/>"
               onchange="getWeek('jdDatetime','week')" onfocus="getWeek('jdDatetime','week')"
               readonly="true"/>
        <input type="button" class="button_calendar" value=""
               onClick="calendar('jdDatetime','dateFmt')"></td>

    </td>
    <td class="form_label_right">星期：</td>
    <td class="form_content">
        <div id="week" name="week">&nbsp;${weekCn}</div>
    </td>
</tr>

<tr class="tr_light">
    <td class="form_label_right">监督负责人：</td>
    <td class="form_content">
            <%--<form:input path="jdManager" cssClass="input_text"/>--%>
        <input type="text" name="personName" id="personName" class="input_text"
               value="${bean.jdManager.name}" readonly="true"/>
        <input type="hidden" name="jdManager" id="jdManager" value="${bean.jdManager.id}"/>
        <input type="button" value=" " class="button_select"
               onclick="selectSysPerson('jdManager','personName');" title="点击选择人员">
    </td>
    <td class="form_label_right">参加监督人员：</td>
    <td class="form_content" nowrap>
        <select multiple="multiple" id="attendPerson" name="attendPerson"
                style="width:250px;height:80px;">${attendPersonOptions}</select>
        <input type="button" value=" " class="button_person_add"
               onclick="multiSelectSysPerson('attendPerson','attendPersonIds','attendPersons',removeRepeatInner)"
               title="点击选择参加监督人员">
        <input type="button" value=" " class="button_person_remove"
               onclick="removeMultiSelectOpt('attendPerson','attendPersonIds','attendPersons')" title="点击移除参加监督人员">
        <input type="hidden" id="attendPersonIds" name="attendPersonIds" value="">
        <input type="hidden" id="attendPersons" name="attendPersons" value="${bean.attendPersons}">
    </td>
</tr>
<tr class="tr_light">
    <td class="form_label">附件：</td>
    <td class="form_content" colspan="3">
            ${uploadButton}
    </td>
</tr>

<tr>
    <td align="center" colspan="4">
        <fieldset class="net_form_fieldset">
            <legend class="form_legend">参建单位参加抽查人员</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label_right" width="15%">建设单位：</td>
                    <td class="form_content">
                        <form:input path="jsDept" cssClass="input_text_long" cssStyle="width: 608px"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">勘察单位：</td>
                    <td class="form_content">
                        <form:input path="kcDept" cssClass="input_text_long" cssStyle="width: 608px"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">设计单位：</td>
                    <td class="form_content">
                        <form:input path="sjDept" cssClass="input_text_long" cssStyle="width: 608px"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">施工单位：</td>
                    <td class="form_content">
                        <form:input path="sgDept" cssClass="input_text_long" cssStyle="width: 608px"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">监理单位：</td>
                    <td class="form_content">
                        <form:input path="jlDept" cssClass="input_text_long" cssStyle="width: 608px"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">检测单位：</td>
                    <td class="form_content">
                        <form:input path="jcDept" cssClass="input_text_long" cssStyle="width: 608px"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">监督机构：</td>
                    <td class="form_content">
                        <input id="jdjg" name="jdjg" class="input_text_long" style="width: 608px" value="${jdjg}"
                               readonly/>
                    </td>
                </tr>
            </table>
        </fieldset>
    </td>
</tr>

<tr>
    <td align="center" colspan="4">
        <fieldset class="net_form_fieldset">
            <legend class="form_legend">单位工程</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_dark">
                    <td class="form_content" style="text-align: right">
                        <select name="selectId" id="selectId" style="width:180px; display: none" size="5"></select>
                        <input type="hidden" name="excelJdDwgcNames" id="excelJdDwgcNames" value="${excelJdDwgcNames}"/>
                        <input type="hidden" name="excelJdDwgcIds" id="excelJdDwgcIds" value="${excelJdDwgcIds}"
                               style="width: 500px"/>
                        <input type="button" class="button_add_long" id="addUnit" name="addUnit"
                               onclick="addExcelJdDwgc('selectId', 'excelJdDwgcIds','excelJdDwgcNames')" value="选择单位工程">
                    </td>
                </tr>

                <tr class="tr_dark">
                    <td class="form_content">
                        <table cellpadding="0" cellspacing="0" class="form_table" id="ExcelJdDwgcTable"
                               name="ExcelJdDwgcTable">
                            <tr class="tr_header">
                                <td class="form_border" width="30%">单位工程编号</td>
                                <td class="form_border">单位工程名称</td>
                                <td class="form_border" width="15%">操作</td>
                            </tr>

                            <c:forEach items="${bean.jdRecordCompleteDwgcs}" var="item" varStatus="status">
                                <tr
                                        <c:choose>
                                            <c:when test="${(status.index % 2) == 0}">class="tr_dark"</c:when>
                                            <c:otherwise>class="tr_light"</c:otherwise>
                                        </c:choose> id="tr_${item.dwgcCode}" name="tr_${item.dwgcCode}">
                                    <td class="form_border" align="center">&nbsp;${item.dwgcCode}</td>
                                    <td class="form_border" align="left">&nbsp;${item.dwgcName}</td>
                                    <td class="form_border" align="center">
                                        <input type="button" class="button_cancel" value="删除"
                                               onclick="deleteThisRow('${item.dwgcCode}')">
                                    </td>
                                </tr>
                            </c:forEach>

                        </table>
                    </td>
                </tr>

            </table>
        </fieldset>
    </td>
</tr>

<tr>
    <td align="center" colspan="4">
        <fieldset class="net_form_fieldset">
            <legend class="form_legend">检查内容及发现问题</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">

                <c:forEach items="${checkItems}" var="item" varStatus="var">
                    <tr class="tr_dark">
                        <td class="form_content" style="text-align: left">${item.itemTitle}</td>
                    </tr>
                    <tr class="tr_dark">
                        <td class="form_content">
                            <table cellpadding="0" cellspacing="0" class="form_table">
                                <tr class="tr_header">
                                    <td class="form_border" width="5%">序号</td>
                                    <td class="form_border">竣工验收条件</td>
                                    <td class="form_border" width="20%">符合形式</td>
                                </tr>
                                <c:forEach items="${item.checkItem}" var="item2" varStatus="status">
                                    <tr <c:choose>
                                        <c:when test="${(status.index % 2) == 0}">class="tr_dark"</c:when>
                                        <c:otherwise>class="tr_light"</c:otherwise>
                                    </c:choose>>
                                        <td class="form_border" align="center" width="5%">&nbsp;${item2.orderNo}</td>
                                        <td class="form_border" align="left">&nbsp;${item2.condition}</td>
                                        <td class="form_border" align="center" width="20%">
                                            &nbsp;${item2.selectItems}</td>
                                    </tr>
                                </c:forEach>

                            </table>
                        </td>
                    </tr>
                </c:forEach>

                <tr class="tr_dark">
                    <td class="form_content" style="text-align: left">五、抽查发现的其他问题</td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_content">
                        <div id="otherCheck"></div>
                    </td>
                </tr>

            </table>
        </fieldset>
    </td>
</tr>

<tr class="tr_light">
    <td class="form_label_right">总处理意见：</td>
    <td class="form_content" colspan="3">
        <form:textarea path="dealOpinion" cssClass="input_textarea_long"/>
    </td>
</tr>
<tr class="tr_dark">
    <td class="form_label_right">备注：</td>
    <td class="form_content" colspan="3">
        <form:textarea path="description" cssClass="input_textarea_long"/>
    </td>
</tr>

<tr class="tr_button">
    <td class="form_content" colspan="4" style="text-align: center">
        <c:choose>
            <c:when test="${bean.status == STATUS_SUBMIT}">
                <%--<input id="back" name="back" type="button" value="退回" class="button_back"--%>
                <%--onclick="save('${STATUS_BACK}',this)"> &nbsp;--%>
                <%--<input id="pass" name="pass" type="button" value="通过" class="button_confirm"--%>
                <%--onclick="save('${STATUS_PASS}',this)"> &nbsp;--%>

                <input id="edit" name="edit" type="button" value="保存" class="button_confirm"
                       onclick="save('${STATUS_SUBMIT}',this)">&nbsp;
            </c:when>
            <c:otherwise>
                <input id="submit" name="submit" type="button" value="提交" class="button_confirm"
                       onclick="save('${STATUS_SUBMIT}',this)">&nbsp;
                <input id="edit" name="edit" type="button" value="保存" class="button_confirm"
                       onclick="save('${STATUS_EDIT}',this)">&nbsp;
            </c:otherwise>
        </c:choose>
        <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
    </td>
</tr>
</table>
</div>
</form:form>