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
            {name: "projectName", rule: "validate[required,maxSize[100]]"},
            {name: "jsDept", rule: "validate[required,maxSize[200]]"},
            {name: "kcDept", rule: "validate[required,maxSize[200]]"},
            {name: "sjDept", rule: "validate[required,maxSize[200]]"},
            {name: "sgDept", rule: "validate[required,maxSize[200]]"},
            {name: "jlDept", rule: "validate[required,maxSize[200]]"},
            {name: "dealOpinion", rule: "validate[required,maxSize[1000]]"}
        ];
        validateInit(validateCondition, formId);
        /*初始化星期*/
        getWeek('jdDatetime', 'week');

        loadAjaxData("safeCheck", "${ctx}/jdRecordQuestion/getRecordList.do?formTypeCode=${JD_RECORD_SAFE_CHECK_TYPE}&questionTypeCode=${JD_RECORD_SAFE_CHECK_BEHAVIOR}&formId=${bean.id}&pageStyle=input");
        loadAjaxData("safeConstr", "${ctx}/jdRecordQuestion/getRecordList.do?formTypeCode=${JD_RECORD_SAFE_CHECK_TYPE}&questionTypeCode=${JD_RECORD_SAFE_CHECK_FACILITY}&formId=${bean.id}&pageStyle=input");
//        getDwgc();
    });

    //保存操作
    function save(btn, flag) {
        if (!validateForm(formId)) {
            return;
        }
        if (flag == ${STATUS_EDIT}) {
            $("#status").val(${STATUS_EDIT});
            submitForm(btn);
        } else if (flag == ${STATUS_SUBMIT}) {
            $.messager.confirm('系统提示', '提交后不能再修改，确定吗?', function (r) {
                if (r) {
                    $("#status").val(${STATUS_SUBMIT});
                    submitForm(btn);
                }
            });
        }
    }

    //提交表单
    function submitForm(btn2) {
        <%--var hiddenStyleBEHAVIOR = document.getElementById("hiddenStyle${JD_RECORD_SAFE_CHECK_BEHAVIOR}");--%>
        <%--var hiddenStyleFACILITY = document.getElementById("hiddenStyle${JD_RECORD_SAFE_CHECK_FACILITY}");--%>
        <%--standarditemDisable(hiddenStyleBEHAVIOR);--%>
        <%--standarditemDisable(hiddenStyleFACILITY);--%>
        disableBtn(btn2);

        //提交表单
        saveAjaxData("${ctx}/jdRecordSafe/save.do", formId);
    }

    /**
     * 去除select中重复的选项。
     */
    function removeRepeatInner() {
        var select = document.getElementById("attendPersonsSelect");
        removeRepeatOption(select);
    }
    function getDwgc(){
        var  jdTaskCode= $.trim($("#jdTaskCode").val());
        var obj =getAjaxData("${ctx}/projectInfo/getDwgcsByJdTaskCode.do?jdTaskCode="+jdTaskCode);
        $("#dwgc").empty();
        var data = obj[0];
        $("#dwgc").append("<option value=''>==选择==</option>");
        for(var x in data){
            $("#dwgc").append("<option value='"+x+"'>"+data[x]+"</option>");
        }
    }

    function getOs() {
        if (navigator.userAgent.indexOf("MSIE") > 0) {
            return "MSIE";
        }
    }
    function copyBoxValue(obj) {
        var rep;
        if ("MSIE" == getOs()) {
            rep = "\r\n"
        } else {
            rep = "\n"
        }
        if (obj.checked) {
            var ipValue = document.getElementById("inspectionPosition").value;
            if (!(ipValue.indexOf(rep + obj.name + rep) >= 0 || ipValue.indexOf(obj.name + rep) >= 0)) {
                document.getElementById("inspectionPosition").value += obj.name + rep;
            }
        } else {
            checkName(obj, rep);
        }
    }
    function checkName(obj, rep) {
        var ipValue = document.getElementById("inspectionPosition").value;
        if (ipValue.indexOf(rep + obj.name + rep) >= 0 || ipValue.indexOf(obj.name + rep) >= 0) {
            document.getElementById("inspectionPosition").value = document.getElementById("inspectionPosition").value.replace(rep + obj.name + rep, "");
            document.getElementById("inspectionPosition").value = document.getElementById("inspectionPosition").value.replace(rep + obj.name, "");
            document.getElementById("inspectionPosition").value = document.getElementById("inspectionPosition").value.replace(obj.name + rep, "");
            return  checkName(obj);
        }
    }
</script>
<form:form commandName="bean">
<form:hidden path="id"/>

<div class="form_div">
<div class="div_space"></div>
<fieldset class="form_fieldset">
    <input type="hidden" name="status" id="status" value="${bean.status}"/>
    <input type="hidden" id="planDetailId"name="planDetailId" value="${planDetailId}"/>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label" colspan="1">监督任务书编号：</td>
            <td class="form_content" colspan="3" nowrap="true">
                <form:input path="jdTaskCode" cssClass="input_text"/>
                <input type="button" value="获取" id="btnFlowCode" class="button_all"
                       onclick="getJdProjectInfo(this);getDwgc()"/>
            </td>
            <td class="form_label" colspan="1">报建编号：</td>
            <td class="form_content" colspan="3">
                <form:input path="bjbh" cssClass="input_text"/>
            </td>
        </tr>

        <tr class="tr_light">
            <td class="form_label" colspan="1">工程名称：</td>
            <td class="form_content" colspan="7">
                <form:input path="projectName" cssStyle="width: 540px" cssClass="input_text_long"/>
            </td>


        </tr>
        <tr class="tr_dark">
            <td class="form_label" colspan="1">监督记录编号：</td>
            <td class="form_content" colspan="3">
                <form:input path="code" readonly="true" cssClass="input_text"/>
            </td>
            <td class="form_label" colspan="1">天气：</td>
            <td class="form_content" colspan="3">
                <form:input path="weather" cssClass="input_text"/>
            </td>
        </tr>

        <tr class="tr_light">
            <td class="form_label" colspan="1">监督日期：</td>
            <td class="form_content" nowrap colspan="3">
                <input type="text" name="jdDatetime" id="jdDatetime" class="input_datetime"
                       value="<fmt:formatDate value="${bean.jdDatetime}" pattern="yyyy-MM-dd"/>"
                       onchange="getWeek('jdDatetime','week')" readonly="true"/>
                <input type="button" class="button_calendar" value=" " onClick="calendar('jdDatetime','dateFmt')">
            </td>

            <td class="form_label" colspan="1">星期：</td>
            <td class="form_content" colspan="3">
                <div id="week">&nbsp;</div>
            </td>
        </tr>

        <tr class="tr_dark">
            <td class="form_label" colspan="1">监督负责人：</td>
            <td class="form_content" colspan="3" nowrap>
                <form:input path="jdManagerName" cssClass="input_text" readonly="true"/>
                <input type="hidden" name="jdManager" value="${bean.jdManager.id}"/>
                <input type="button" value=" " class="button_select"
                       onclick="selectSysPerson('jdManager','jdManagerName');" title="点击选择人员">
            </td>
            <td class="form_label" colspan="1">参加监督人员：</td>
            <td class="form_content" colspan="3">
                <table border="0" width="50%" align="left">
                    <tr>
                        <td width="5%">&nbsp;</td>
                        <td align="left" width="150px">
                            <select name="attendPerson" id="attendPerson" size="3" multiple
                                    style="width:130px"
                                    class="input_light">
                                <c:forEach var="jdRecordPerson" items="${jdRecordPersonList}">
                                    <option value="${jdRecordPerson.jdPerson.id}">${jdRecordPerson.jdPersonDesc}</option>
                                </c:forEach>
                            </select>

                        <td align="left">
                            <input type="button" class="button_person_add"
                                   onclick="multiSelectSysPerson('attendPerson','attendPersonIds','attendPersons')"
                                   title="请选参加监督人员"/>
                        </td>
                        <td align="left">
                            <input type="button" title="点击移除人员" class="button_person_remove"
                                   onClick="removeMultiSelectOpt('attendPerson','attendPersonIds','attendPersons')"/>
                            <input type="hidden" name="attendPersonIds" id="attendPersonIds"
                                   value="${jdRecordPersonIds}">
                            <form:hidden path="attendPersons"></form:hidden>
                        </td>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr class="tr_dark" style="display: none;">
            <td class="form_label_right">单位工程：</td>
            <td class="form_content" colspan="7">
                <select name="dwgc" id="dwgc" size="1" title=" ">
                        ${dwgc}
                </select>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">附件：</td>
            <td class="form_content" colspan="7">
                    ${uploadButton}
            </td>
        </tr>

    </table>
</fieldset>
<div class="div_space"></div>
<fieldset class="form_fieldset">
    <legend class="form_legend">参建单位参加抽查人员</legend>
    <table cellpadding="0" cellspacing="0" class="form_table">

        <tr class="tr_light">
            <td class="form_label" colspan="1">建设单位：</td>
            <td class="form_content" colspan="3">
                <form:input path="jsDept" cssStyle="width: 575px" cssClass="input_text_long"/>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">勘察单位：</td>
            <td class="form_content">
                <form:input path="kcDept" cssStyle="width: 575px" cssClass="input_text_long"/>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">设计单位：</td>
            <td class="form_content">
                <form:input path="sjDept" cssStyle="width: 575px" cssClass="input_text_long"/>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">施工单位：</td>
            <td class="form_content">
                <form:input path="sgDept" cssStyle="width: 575px" cssClass="input_text_long"/>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">监理单位：</td>
            <td class="form_content">
                <form:input path="jlDept" cssStyle="width: 575px" cssClass="input_text_long"/>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">检测单位：</td>
            <td class="form_content">
                <form:input path="jcDept" cssStyle="width: 575px" cssClass="input_text_long"/>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">监督机构：</td>
            <td class="form_content">
                <input type="text" name="jdjg" id="jdjg" value="${jdjg}" readonly style="width: 575px"
                       class="input_text_long"/>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">施工进度：</td>
            <td class="form_content" nowrap>
                <sys:checkbox name="scheduleItems" colNum="0" code="PollingRecordStage" showType="edit"
                              checkedNames="${bean.scheduleItems}" isSaveName="true"
                              inputType="checkbox"></sys:checkbox>
            </td>
        </tr>
    </table>
</fieldset>
<fieldset class="form_fieldset">
    <legend class="form_legend">安全行为检查</legend>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label" nowrap style="width: 80px">抽查对象内容：</td>
            <td class="form_content">
                <form:textarea path="inspectionContent" cssStyle="width: 95%" cssClass="input_textarea_long"/>
            </td>
        </tr>
    </table>
    <div id="safeCheck"></div>
</fieldset>
<fieldset class="form_fieldset">
    <legend class="form_legend">安全设施检查</legend>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label" nowrap style="width: 80px">抽查对象内容：</td>
            <td class="form_content">
                <form:textarea path="inspectionPosition" cssStyle="width: 98%" cssClass="input_textarea_long"/>
            </td>
            <td style="width: 275px" class="form_content">
                <c:forEach items="${listCode}" var="item">
                    <input type="checkbox" id="${item.name}" name="${item.name}"
                           onClick="copyBoxValue(this)"/>   ${item.name}
                </c:forEach>
            </td>
        </tr>
    </table>
    <div id="safeConstr"></div>
</fieldset>
<div class="div_space"></div>
<fieldset class="form_fieldset">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label" style="width: 80px" nowrap>总处理意见：</td>
            <td class="form_content">
                <form:textarea path="dealOpinion" cssStyle="width: 95%" cssClass="input_textarea_long"/>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label" style="width: 80px" nowrap>备注：</td>
            <td class="form_content">
                <form:textarea path="description" cssStyle="width: 95%" cssClass="input_textarea_long"/>
            </td>
        </tr>
    </table>
</fieldset>

<div class="div_space"></div>
<tr class="tr_button">
    <td class="form_label"></td>
    <td class="form_content">
        <input type="button" value="保存" class="button_confirm" onclick="save(this,1)">&nbsp;
        <input type="button" value="提交" class="button_confirm" onclick="save(this,2)">&nbsp;
        <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
    </td>
</tr>
<div class="div_space"></div>
</div>

</form:form>