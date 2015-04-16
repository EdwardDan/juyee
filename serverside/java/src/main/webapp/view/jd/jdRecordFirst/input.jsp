<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/view/jd/jdRecordQuestion/commonJs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [

            {name: "bjbh", rule: "validate[required,maxSize[50]]"},

            {name: "projectName", rule: "validate[required,maxSize[200]]"},
            {name: "jdManager", rule: "validate[required,maxSize[50]]"}


        ];
        validateInit(validateCondition, formId);

//        $("#jdTaskCode").val("13AJJA0427D001");
        //初始化
        loadAjaxData("quality_check_behavior", "${ctx}/jdRecordQuestion/getRecordList.do?formTypeCode=${JD_RECORD_FIRST_CHECK_TYPE}&questionTypeCode=${JD_RECORD_FIRST_CHECK_NORMAL}&formId=${bean.id}&pageStyle=input");
        getDwgc();
        //初始化星期
        getWeek('jdDatetime', 'week');
        if (${not empty jdTaskCode}) {
            $("#jdTaskCode").val('${jdTaskCode}');
            $("#btnFlowCode").trigger("click");
        }

    });

    function getDwgc(){
        var  jdTaskCode= $.trim($("#jdTaskCode").val());
       var obj =getAjaxData("${ctx}/projectInfo/getDwgcsByJdTaskCode.do?jdTaskCode="+jdTaskCode);
        var dwgc=$.trim($("#dwgc").text());
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
        $("#status").val(status);
        if (!validateForm(formId)) {
            return;
        }
        if (status == '${STATUS_SUBMIT}') {
            if (!confirm("是否提交，提交后不能修改？")) {
                return false;
            }
        }

        saveAjaxData("${ctx}/jdRecordFirst/save.do?jdcode=${jdcode}", formId);
    }
</script>
<form:form commandName="bean">
<form:hidden path="id"/>
<input type="hidden" name="status" id="status" value="${bean.status}"/>

<div class="form_div">
<table class="form_table" cellpadding="0" cellspacing="0">
<tr>
    <td colspan="2">
        <fieldset style="width: 90%;margin:0px auto">
            <legend class="form_legend">基本信息</legend>
            <table class="form_table" cellpadding="0" cellspacing="0">
                <tr class="tr_dark">
                    <input type="hidden" id="planDetailId"name="planDetailId" value="${planDetailId}"/>
                    <td class="form_label_right" nowrap width="15%">监督任务书编号：</td>
                    <td class="form_content"  width="35%">
                        <form:input path="jdTaskCode" cssClass="input_text"/>
                        <input type="button" value="获取" id="btnFlowCode" class="button_all" onclick="getJdProjectInfo(this);getDwgc()">
                    </td>
                    <td class="form_label_right"  width="15%" nowrap>报建编号：</td>
                    <td class="form_content"  width="35%" >
                        <form:input path="bjbh" cssClass="input_text"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">工程名称：</td>
                    <td class="form_content" colspan="3">
                        <form:input path="projectName" cssClass="input_text_long"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">监督记录编号：</td>
                    <td class="form_content">
                        <form:input path="code" readonly="true" cssClass="input_text"/>
                    </td>
                    <td class="form_label_right">天气：</td>
                    <td class="form_content">
                        <form:input path="weather" cssClass="input_text"/>
                    </td>
                </tr>

                <tr class="tr_light">
                    <td class="form_label_right">监督日期：</td>
                    <td class="form_content" nowrap>
                        <input type="text" name="jdDatetime" id="jdDatetime" class="input_datetime"
                               value="<fmt:formatDate value="${bean.jdDatetime}" pattern="yyyy-MM-dd"/>"
                               readonly="true" onchange="getWeek('jdDatetime','week')"/>
                        <input type="button" class="button_calendar" value=" "
                               onClick="calendar('jdDatetime','dateFmt')">
                    </td>
                    <td class="form_label_right">星期：</td>
                    <td class="form_content">
                        <div id="week" name="week">&nbsp;${weekCn}

                        </div>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">监督负责人：</td>
                    <td class="form_content">
                        <form:input path="jdManagerName" cssClass="input_text" readonly="true"/>

                        <input type="hidden" name="jdManager" id="jdManager" value="${bean.jdManager.id}"/>
                        <input type="button" value=" " class="button_select"
                               onclick="selectSysPerson('jdManager','jdManagerName');" title="点击选择人员">
                    </td>

                    <td class="form_label_right">参加监督人员：</td>
                    <td class="form_content">
                        <table border="0" width="50%" align="left">
                            <tr>
                                <td width="5%">&nbsp;</td>
                                <td align="left" width="15%">
                                    <select name="attendPersonsSelect" id="attendPersonsSelect" size="3" multiple
                                            style="width:130px"class="input_light">
                                        <c:forEach var="jdRecordPerson" items="${jdRecordPersonList}">
                                            <option value="${jdRecordPerson.id}">${jdRecordPerson.jdPersonDesc}</option>
                                        </c:forEach>
                                    </select>
                                <td align="left">
                                    <input type="button" value=" " class="button_person_add"
                                           onclick="multiSelectSysPerson('attendPersonsSelect','attendPersonIds','attendPersons')"
                                           title="点击选择人员"/>
                                </td>
                                <td align="left">
                                <input type="button" value=" " class="button_person_remove"
                                       onClick="removeMultiSelectOpt('attendPersonsSelect','attendPersonIds','attendPersons')"
                                       title="点击移除人员"/>
                                    <input type="hidden" name="attendPersonIds" id="attendPersonIds"
                                           value="${processInstance.ccUserIds}">
                                    <form:hidden path="attendPersons"></form:hidden>
                                </td>
                                </td>
                            </tr>

                        </table>


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
<tr>
    <td colspan="2">
        <div class="div_space"></div>
        <fieldset style="width: 90%;margin:0px auto">
            <legend class="form_legend">参建单位参加抽查人员</legend>
            <table class="form_table" cellpadding="0" cellspacing="0">
                <tr class="tr_dark">
                    <td  width="15%" class="form_label_right">建设单位：</td>
                    <td>
                        <form:input path="jsDept" cssStyle="width: 100%" cssClass="input_text_long"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">勘察单位：</td>
                    <td>
                        <form:input path="kcDept" cssStyle="width: 100%" cssClass="input_text_long"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">设计单位：</td>
                    <td>
                        <form:input path="sjDept" cssStyle="width: 100%" cssClass="input_text_long"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">施工单位：</td>
                    <td>
                        <form:input path="sgDept" cssStyle="width: 100%" cssClass="input_text_long"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td  class="form_label_right">监理单位：</td>
                    <td>
                        <form:input path="jlDept" cssStyle="width: 100%" cssClass="input_text_long"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">检测单位：</td>
                    <td>
                        <form:input path="jcDept" cssStyle="width: 100%" cssClass="input_text_long"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">监督机构：</td>
                    <td align="left">${jdDeptNameNew}</td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">告知情况：</td>
                    <td>
                        <form:textarea path="notifyContent"
                                       cssStyle="width: 100%" cssClass="input_textarea_long"></form:textarea>
                    </td>
                </tr>
            </table>

        </fieldset>
    </td>
</tr>
<tr>
    <td colspan="2">

        <fieldset style="width: 90%;margin:0px auto">
            <legend class="form_legend">监督详情</legend>
            <table class="form_table" cellpadding="0" cellspacing="0">
                <tr class="tr_dark">
                    <td  width="15%" class="form_label_right">抽查对象内容：</td>
                    <td>
                        <form:textarea path="inspectionContent"
                                       cssStyle="width: 100%" cssClass="input_textarea_long"></form:textarea>
                    </td>
                </tr>
                <table class="form_table" cellpadding="0" cellspacing="0">
                    <tr>
                        <td colspan="2">
                            <div id="quality_check_behavior"></div>
                        </td>
                    </tr>
                </table>
                <table class="form_table" cellpadding="0" cellspacing="0">
                    <tr class="tr_dark">
                        <td  width="15%"  class="form_label_right">总处理意见：</td>
                        <td>
                            <form:textarea path="dealOpinion"
                                           cssStyle="width: 100%" cssClass="input_textarea_long"></form:textarea>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td  width="15%" class="form_label_right">备注：</td>
                        <td>
                            <form:textarea path="description"
                                           cssStyle="width: 100%" cssClass="input_textarea_long"></form:textarea>
                        </td>
                    </tr>
                </table>
            </table>
        </fieldset>
    </td>
</tr>

<tr class="tr_button">
    <td colspan="2">
        <input type="button" value="提交" class="button_confirm" onclick="save('${STATUS_SUBMIT}',this)">&nbsp;
        <input type="button" value="保存" class="button_confirm" onclick="save('${STATUS_EDIT}',this)">&nbsp;
        <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
    </td>
</tr>

</table>

</div>
</form:form>


