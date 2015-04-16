<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/view/jd/jdRecordQuestion/commonJs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        if ('' == $("#jdInspection").val()) {
            $("#jdInspectionLabel").css("display", "block");
            $("#jdInspection").css("display", "none");
        }
        //页面验证初始化
        var validateCondition = [
            {name: "code", rule: "validate[required,maxSize[50]]"},
            {name: "jdTaskCode", rule: "validate[required,maxSize[50]]"},
            {name: "bjbh", rule: "validate[required,maxSize[50]]"},
            {name: "weather", rule: "validate[required,maxSize[2000]]"},
            {name: "projectName", rule: "validate[required,maxSize[2000]]"},
            {name: "jdManager", rule: "validate[required,maxSize[50]]"},
            {name: "attendPersons", rule: "validate[required,maxSize[2000]]"},
            {name: "jsDept", rule: "validate[required,maxSize[2000]]"},
            {name: "kcDept", rule: "validate[required,maxSize[2000]]"},
            {name: "sjDept", rule: "validate[required,maxSize[2000]]"},
            {name: "sgDept", rule: "validate[required,maxSize[2000]]"},
            {name: "jlDept", rule: "validate[required,maxSize[2000]]"},
            {name: "jcDept", rule: "validate[required,maxSize[2000]]"},
            {name: "notifyContent", rule: "validate[maxSize[2000]]"},
            {name: "inspectionContent", rule: "validate[maxSize[2000]]"},
            {name: "inspectionPosition", rule: "validate[maxSize[2000]]"},
            {name: "jdInspection", rule: "validate[maxSize[2000]]"},
            {name: "dealOpinion", rule: "validate[maxSize[2000]]"},
            {name: "description", rule: "validate[maxSize[ 2000]]"},
            {name: "jdDatetime", rule: "validate[required,maxSize[10]]"}
        ];
        /*初始化表单验证*/
        validateInit(validateCondition, formId);
        /*初始化星期*/
        getWeek('jdDatetime', 'week');
        /*初始化quality_check_behavior*/
        loadAjaxData("quality_check_behavior", "${ctx}/jdRecordQuestion/getRecordList.do?formTypeCode=${JD_RECORD_QUALITY_CHECK_TYPE}&questionTypeCode=${JD_RECORD_QUALITY_CHECK_BEHAVIOR}&formId=${bean.id}&pageStyle=input");
        /*初始化quality_check_entity*/
        loadAjaxData("quality_check_entity", "${ctx}/jdRecordQuestion/getRecordList.do?formTypeCode=${JD_RECORD_QUALITY_CHECK_TYPE}&questionTypeCode=${JD_RECORD_QUALITY_CHECK_ENTITY}&formId=${bean.id}&pageStyle=input");
        if (${not empty jdTaskCode}) {
            $("#jdTaskCode").val('${jdTaskCode}');
            $("#btnFlowCode").trigger("click");
        }
        /*初始化单位工程选项*/
        getDwgc();
    });

    /*根据勾选显示或隐藏*/
    function jdInspectionOp() {
        if ($("#jdInspectionCheck").attr("checked") != 'checked') {
            $("#jdInspectionLabel").css("display", "block");
            $("#jdInspection").css("display", "none");
            $("#jdInspection").val('');
        } else {
            $("#jdInspectionLabel").css("display", "none");
            $("#jdInspection").css("display", "block");
        }
    }
    function getDwgc(){
        var  jdTaskCode= $.trim($("#jdTaskCode").val());
        var dwgc=$.trim($("#dwgc").text());
        var obj =getAjaxData("${ctx}/projectInfo/getDwgcsByJdTaskCode.do?jdTaskCode="+jdTaskCode);
        $("#dwgc").empty();
        var data = obj[0];
        $("#dwgc").append("<option value=''>==选择==</option>");
        for(var x in data){
            if(x==dwgc){
                $("#dwgc").append("<option  selected  value='"+x+"'>"+data[x]+"</option>");

            }else{
                $("#dwgc").append("<option value='"+x+"'>"+data[x]+"</option>");
            }
        }
    }

    //保存操作
    function save(status, btn) {
        if (!validateForm(formId)) {
            return;
        }
        if (status == "${SUBMIT}") {
            $.messager.confirm('系统提示', '提交后不能再修改，确定吗?', function (r) {
                if (r) {
                    submitForm(status, btn);
                }
            });
        } else {
            submitForm(status, btn);
        }
    }
    //提交表单
    function submitForm(status, btn) {
        $('#status').val(status);

        <%--var hiddenStyleBEHAVIOR = document.getElementById("hiddenStyle${JD_RECORD_QUALITY_CHECK_BEHAVIOR}");--%>
        <%--var hiddenStyleENTITY = document.getElementById("hiddenStyle${JD_RECORD_QUALITY_CHECK_ENTITY}");--%>
        <%--standarditemDisable(hiddenStyleBEHAVIOR);--%>
        <%--standarditemDisable(hiddenStyleENTITY);--%>

        disableBtn(btn, '请稍候');
        saveAjaxData("${ctx}/jdRecordQuality/save.do", formId);
    }
</script>
<form:form commandName="bean">
<form:hidden path="id"/>
<form:hidden path="status"/>
<div class="form_div">
<table class="form_table" cellpadding="0" cellspacing="0">
<tr class="tr_dark">
    <td colspan="2">
        <fieldset style="width: 90%;margin:0px auto">
            <legend class="form_legend">基本信息</legend>
            <table class="form_table" cellpadding="0" cellspacing="0">
                <tr class="tr_dark">
                    <input type="hidden" id="planDetailId"name="planDetailId" value="${planDetailId}"/>
                    <td class="form_label_right"  width="15%">监督任务书编号：</td>
                    <td class="form_content" width="35%">
                        <form:input path="jdTaskCode" cssClass="input_text"/>
                        <input type="button" value="获取" id="btnFlowCode" class="button_all" onclick="getJdProjectInfo(this);getDwgc()">
                    </td>
                    <td class="form_label_right" width="15%">报建编号：</td>
                    <td class="form_content" width="35%"><form:input path="bjbh" cssClass="input_text"/></td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">工程名称：</td>
                    <td class="form_content" colspan="3">
                        <form:input path="projectName" cssClass="input_text_long"/></td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">监督记录编号：
                    </td>
                    <td class="form_content">
                        <form:input path="code" cssClass="input_text"/></td>
                    <td class="form_label_right">天气：</td>
                    <td class="form_content">
                        <form:input path="weather" cssClass="input_text"/></td>
                </tr>

                <tr class="tr_dark">
                    <td class="form_label_right">监督日期：</td>
                    <td class="form_content">
                        <input type="text" name="jdDatetime" id="jdDatetime" class="input_datetime"
                               value="<fmt:formatDate value="${bean.jdDatetime}" pattern="yyyy-MM-dd"/>"
                               onchange="getWeek('jdDatetime','week')"
                               readonly="true"/>
                        <input type="button" class="button_calendar" value=""
                               onClick="calendar('jdDatetime','dateFmt')"></td>
                    <td class="form_label_right">星期：</td>
                    <td class="form_content">
                        <div id="week">&nbsp;</div>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right"> 监督负责人：</td>
                    <td class="form_content">
                        <form:input path="jdManagerName" cssClass="input_text" readonly="true"/>
                        <input type="hidden" name="jdManager" id="jdManager" value="${bean.jdManager.id}"/>
                        <input type="button" value=" " class="button_select"
                               onclick="selectSysPerson('jdManager','jdManagerName');" title="点击选择人员">
                    </td>

                    <td class="form_label_right">参加监督人员：${jdRecordPerson.jdPersonDesc}</td>
                    <td class="form_content">
                        <select name="attendPersonsSelect" id="attendPersonsSelect" size="3" multiple
                                style="width:150px"
                                class="input_light">
                            <c:forEach var="jdRecordPerson" items="${jdRecordPersonList}">
                                <option value="${jdRecordPerson.id}">${jdRecordPerson.jdPersonDesc}</option>
                            </c:forEach>
                        </select>
                        <input type="button" value=" " class="button_person_add"
                               onclick="multiSelectSysPerson('attendPersonsSelect','attendPersonIds','attendPersons')"
                               title="请选参加监督人员"/>
                        <input type="button" value=" " class="button_person_remove"
                               onclick="removeMultiSelectOpt('attendPersonsSelect','attendPersonIds','attendPersons')"
                               title="移除选中人员"/>
                        <input type="hidden" name="attendPersonIds" id="attendPersonIds"
                               value="${jdRecordPersonIds}">
                        <form:hidden path="attendPersons"></form:hidden>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">单位工程：</td>
                    <td class="form_content" colspan="3">
                        <select name="dwgc" id="dwgc" size="1" title="">
                                ${bean.dwgc.id}
                        </select>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label">附件：</td>
                    <td class="form_content" colspan="3">
                            ${uploadButton}
                    </td>
                </tr>

            </table>
        </fieldset>

    </td>
</tr>
<tr class="tr_dark">
    <td colspan="2">
        <fieldset style="width: 90%;margin:0 auto">
            <legend class="form_legend">
                参建单位参加抽查人员
            </legend>
            <table class="form_table" cellpadding="0" cellspacing="0">
                <tr class="tr_light">
                    <td class="form_label_right" width="15%">建设单位：</td>
                    <td class="form_content">
                        <form:input path="jsDept" cssClass="input_text" cssStyle="width: 100%"/></td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">勘察单位：</td>
                    <td class="form_content">
                        <form:input path="kcDept" cssClass="input_text" cssStyle="width: 100%"/></td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">设计单位：</td>
                    <td class="form_content">
                        <form:input path="sjDept" cssClass="input_text" cssStyle="width: 100%"/></td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">施工单位：</td>
                    <td class="form_content">
                        <form:input path="sgDept" cssClass="input_text" cssStyle="width: 100%"/></td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">监理单位：</td>
                    <td class="form_content">
                        <form:input path="jlDept" cssClass="input_text" cssStyle="width: 100%"/></td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">检测单位：</td>
                    <td class="form_content">
                        <form:input path="jcDept" cssClass="input_text" cssStyle="width: 100%"/></td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">监督机构：</td>
                    <td class="form_content">${jdDept}</td>
                </tr>
            </table>
        </fieldset>
    </td>
</tr>
<tr class="tr_dark">
    <td colspan="2">
        <fieldset style="width: 90%;margin:0 auto">

            <table class="form_table" cellpadding="0" cellspacing="0">
                <tr class="tr_dark">
                    <td class="form_label" style="width: 80px">施工进度</td>
                    <td class="form_content">
                            <%--<form:textarea path="scheduleItems" cssClass="input_textarea"--%>
                            <%--cssStyle="width: 100%"></form:textarea>--%>
                        <sys:checkbox name="scheduleItems" colNum="0" code="PollingRecordStage" showType="edit"
                                      checkedNames="${bean.scheduleItems}" isSaveName="true"
                                      inputType="checkbox"></sys:checkbox>
                    </td>
                </tr>

                <tr>
                    <td class="form_label" style="width: 80px">监理对工程质<br>量状况的报告</td>
                    <td class="form_content">
                        <form:textarea path="notifyContent" cssClass="input_textarea"
                                       cssStyle="width: 100%"></form:textarea>
                    </td>
                </tr>

            </table>
        </fieldset>
    </td>
</tr>
<tr class="tr_dark">
    <td colspan="2">
        <fieldset style="width: 90%;margin:0 auto">
            <legend class="form_legend">质量行为抽查记录</legend>

            <table class="form_table" cellpadding="0" cellspacing="0">
                <tr class="tr_dark">
                    <td class="form_label" style="width: 80px">抽查<br>对象<br>内容</td>
                    <td class="form_content">
                        <form:textarea path="inspectionContent" cssClass="input_textarea"
                                       cssStyle="width: 100%"></form:textarea>
                    </td>
                </tr>
            </table>

            <table class="form_table" cellpadding="0" cellspacing="0">
                <tr class="tr_dark">
                    <td>
                        <div id="quality_check_behavior"></div>
                    </td>
                </tr>
            </table>


        </fieldset>
    </td>
</tr>
<tr class="tr_dark">
    <td colspan="2">
        <fieldset style="width: 90%;margin:0 auto">
            <legend class="form_legend"> 实体质量抽查记录</legend>
            <table class="form_table" cellpadding="0" cellspacing="0">
                <tr class="tr_dark">
                    <td class="form_label" style="width: 80px">抽查内容和<br>部位
                    </td>
                    <td class="form_content">
                        <form:textarea path="inspectionPosition" cssClass="input_textarea"
                                       cssStyle="width: 100%"></form:textarea>
                    </td>
                </tr>
            </table>
            <table class="form_table" cellpadding="0" cellspacing="0">
                <tr>
                    <td>
                        <div id="quality_check_entity"></div>
                    </td>
                </tr>
            </table>
        </fieldset>
    </td>
</tr>
<tr class="tr_dark">
    <td colspan="2">
        <fieldset style="width: 90%;margin:0 auto">

            <table class="form_table" cellpadding="0" cellspacing="0">
                <tr class="tr_dark">
                    <td style="width: 80px" class="form_label">
                        <input type="checkbox" name="jdInspectionCheck" id="jdInspectionCheck" checked="checked"
                               onclick="jdInspectionOp()"/>
                        监督抽测
                    </td>
                    <td class="form_content">
                        <div id="jdInspectionLabel" style="display: none; color: red">如需添加监督抽测信息，请勾选</div>
                        <form:textarea path="jdInspection" cssClass="input_textarea"
                                       cssStyle="width: 100%;display: block"></form:textarea>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td style="width: 80px" class="form_label">总处理意见</td>
                    <td class="form_content">
                        <form:textarea path="dealOpinion" cssClass="input_textarea"
                                       cssStyle="width: 100%"></form:textarea>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td style="width: 80px" class="form_label">备注</td>
                    <td class="form_content">
                        <form:textarea path="description" cssClass="input_textarea"
                                       cssStyle="width: 100%"></form:textarea>
                    </td>
                </tr>
            </table>
        </fieldset>
    </td>
</tr>
<tr class="tr_button">
    <td colspan="2">
        <input type="button" value="提交" class="button_confirm" onclick="save('${SUBMIT}',this)">&nbsp;
        <input type="button" value="保存" class="button_confirm" onclick="save('${EDIT}',this)">&nbsp;
        <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
    </td>
</tr>
</table>

</div>
</form:form>