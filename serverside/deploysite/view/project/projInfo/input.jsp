<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "year", rule: "validate[required,custom[integer],maxSize[4]"},
            {name: "no", rule: "validate[required,custom[integer],maxSize[5]"},
            {name: "name", rule: "validate[required]"}
        ];
        validateInit(validateCondition, formId);
        changeArea();
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //提交表单
        saveAjaxData("${ctx}/projInfo/save.do", formId);
    }

    //控制重大与否
    function changeArea() {
        if (jQuery("#managerProperty option:selected").text() == '市属') {
            $("#areaId").val("0");
            $("#areaId").attr("disabled", true);
        } else {
            $("#areaId").attr("disabled", false);
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <fieldset class="form_fieldset" style="width: 96%;">
            <legend>项目基本信息</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_dark">
                    <td class="form_label_right" style="width: 20%">项目编号：</td>
                    <td class="form_content" style="width: 25%;">
                        <form:input path="projNum" cssClass="input_text"/>
                    </td>
                    <td class="form_label_right" style="width: 10%;">项目序号：</td>
                    <td class="form_content" style="width: 50%;">
                        <form:input path="no" cssClass="input_text"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">项目状态：</td>
                    <td class="form_content">
                        <sys:code code="${PROJ_INFO_STAGE}" name="ProjStage" id="ProjStage" type="select"
                                  sysCodeDetailId="${bean.stage.id}" style="width:150px"/>
                    </td>
                    <td class="form_label_right">业态类别：</td>
                    <td class="form_content">
                        <sys:code code="${PROJ_INFO_CATEGORY}" name="ProjCategory" id="ProjCategory" type="select"
                                  sysCodeDetailId="${bean.category.id}" style="width:150px" isAlowedNull="true"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">管理属性：</td>
                    <td class="form_content">
                        <select name="managerProperty" id="managerProperty" onchange="changeArea()" class="form_select"
                                style="width: 70px;">
                            <c:forEach var="propertyL" items="${propertyList}">
                                <option value="${propertyL.id}"
                                        <c:if test="${bean.property.id==propertyL.id}">selected </c:if>>${propertyL.name}</option>
                            </c:forEach>
                        </select>
                        <select name="isMajor" id="isMajor" class="form_select" style="width: 75px;">
                            <option value="1">重大</option>
                            <option value="0" <c:if test="${!bean.isMajor}">selected</c:if>>非重大</option>
                        </select>
                    </td>
                    <td class="form_label_right">项目来源：</td>
                    <td class="form_content">
                        <sys:code code="${PROJ_INFO_SOURCE}" name="ProjSources" id="ProjSources" type="select"
                                  sysCodeDetailId="${bean.projectSource.id}" style="width:150px"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">所属区县：</td>
                    <td class="form_content">
                        <select name="areaId" id="areaId" class="form_select" style="width: 150px;">
                            <option value="0">上海市</option>
                            <c:forEach var="area" items="${areaList}">
                                <option value="${area.id}"
                                        <c:if test="${bean.areaCode==area.name}">selected </c:if>>${area.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td class="form_label_right">项目属性：</td>
                    <td class="form_content">
                        <sys:code code="${PORJECT_PROJ_PROPERTY}" name="projProperty" id="projProperty" type="select"
                                  sysCodeDetailId="${bean.projProperty.id}" style="width:150px"/>
                            <%--<sys:checkbox name="ProjPackageAttr" code="${PROJ_INFO_DBSX}" checkedNames="${bean.packageAttr}"--%>
                            <%--inputType="checkbox" isSaveName="true" showType="edit" colNum="4"/>--%>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">开工日期：</td>
                    <td class="form_content">
                        <form:input path="startDate" cssClass="input_date" readonly="true"/>
                        <input type="button" class="button_calendar" value=" " onClick="calendar('startDate');">
                    </td>
                    <td class="form_label_right">完工日期：</td>
                    <td class="form_content">
                        <form:input path="endDate" cssClass="input_date" readonly="true"/>
                        <input type="button" class="button_calendar" value=" " onClick="calendar('endDate');">
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">项目名称：</td>
                    <td class="form_content" colspan="3">
                        <form:input path="name" cssClass="input_text_long" style="width:90%"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">起讫地点：</td>
                    <td class="form_content" colspan="3">
                        <form:input path="location" cssClass="input_text_long" style="width:90%"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">涉及区（县）：</td>
                    <td class="form_content" colspan="3">
                        <sys:checkbox name="ProjBelongArea" code="ProjBelongArea" checkedNames="${areas}"
                                      inputType="checkbox" isSaveName="false" showType="edit" colNum="9"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">规划红线（宽度m）：</td>
                    <td class="form_content">
                        <form:input path="ghhx" cssClass="input_text"/>
                    </td>
                    <td class="form_label_right">道路等级：</td>
                    <td class="form_content">
                        <sys:code code="${PORJECT_ROAD_GRADE}" name="roadGrade" id="roadGrade" type="select"
                                  sysCodeDetailId="${bean.roadGrade.id}" style="width:150px"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">道路技术等级：</td>
                    <td class="form_content" colspan="3">
                        <sys:code code="${PORJECT_ROAD_TEC_GRADE}" name="roadTecGrade" id="roadTecGrade" type="select"
                                  sysCodeDetailId="${bean.roadTecGrade.id}" style="width:150px"/>
                    </td>
                </tr>
            </table>
        </fieldset>
        <div class="div_space"></div>
        <fieldset class="form_fieldset" style="width: 96%;">
            <legend>项目扩展信息</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_dark">
                    <td class="form_border" rowspan="2" style="width:5%;">计划任务书</td>
                    <td class="form_label_right" style="width: 15%;">开工节点：</td>
                    <td class="form_content" style="width: 25%;" nowrap>
                        <form:input path="kgjd" cssClass="input_date" readonly="true"/>
                        <input type="button" class="button_calendar" value=" " onClick="calendar('kgjd');">
                    </td>
                    <td class="form_label_right" style="width: 15%;">完工节点：</td>
                    <td class="form_content" style="width: 30%;" nowrap>
                        <form:input path="wgjd" cssClass="input_date" readonly="true"/>
                        <input type="button" class="button_calendar" value=" " onClick="calendar('wgjd');">
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" style="width: 15%;">计划开工时间：</td>
                    <td class="form_content" style="width: 25%;" nowrap>
                        <form:input path="planStartDate" cssClass="input_date" readonly="true"/>
                        <input type="button" class="button_calendar" value=" " onClick="calendar('planStartDate');">
                    </td>
                    <td class="form_label_right" style="width: 15%;">计划完工时间：</td>
                    <td class="form_content" style="width: 30%;" nowrap>
                        <form:input path="planEndDate" cssClass="input_date" readonly="true"/>
                        <input type="button" class="button_calendar" value=" " onClick="calendar('planEndDate');">
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" style="width: 15%;" colspan="2">工程范围和主要内容：</td>
                    <td class="form_content" style="width: 25%;" colspan="3">
                        <form:textarea path="intro" cssClass="input_textarea_long"/>
                    </td>
                </tr>
            </table>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_dark">
                    <td class="form_label_right" rowspan="3" style="width:10%;">计划总投资：</td>
                    <td class="form_content" style="width: 15%;" rowspan="3">
                        <form:input path="planTotalInvest" cssClass="input_number"/>
                    </td>
                    <td class="form_border" rowspan="3" style="width:5%;">工可批复总投资</td>
                    <td class="form_label_right" style="width: 10%;">总投资：</td>
                    <td class="form_content" style="width: 25%;">
                        <form:input path="gkpfTotalInvest" cssClass="input_number"/>
                    </td>
                    <td class="form_border" rowspan="3" style="width:5%;">初设批复总投资</td>
                    <td class="form_label_right" style="width: 10%;">总投资：</td>
                    <td class="form_content" style="width: 25%;">
                        <form:input path="csTotalInvest" cssClass="input_number"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" style="width: 10%;">前期费用：</td>
                    <td class="form_content" style="width: 25%;">
                        <form:input path="gkpfPreInvest" cssClass="input_number"/>
                    </td>
                    <td class="form_label_right" style="width: 10%;">前期费用：</td>
                    <td class="form_content" style="width: 25%;">
                        <form:input path="csPreInvest" cssClass="input_number"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" style="width: 10%;">建安费用：</td>
                    <td class="form_content" style="width: 25%;">
                        <form:input path="gkpfJaInvest" cssClass="input_number"/>
                    </td>
                    <td class="form_label_right" style="width: 10%;">建安费用：</td>
                    <td class="form_content" style="width: 25%;">
                        <form:input path="csJaInvest" cssClass="input_number"/>
                    </td>
                </tr>
            </table>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_dark">
                    <td class="form_label_right" rowspan="3" style="width:10%;" nowrap>建设公司：</td>
                    <td class="form_content" style="width: 15%;" rowspan="3">
                        <input type="text" class="input_text" name="jsgs" id="jsgs" value="${content.jsgs}"
                               style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 10%;" nowrap>单独独立法人：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="jsgs_dlfr" id="jsgs_dlfr"
                               value="${content.jsgs_dlfr}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="jsgs_dlfr_tel" id="jsgs_dlfr_tel"
                               value="${content.jsgs_dlfr_tel}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="jsgs_dlfr_fax" id="jsgs_dlfr_fax"
                               value="${content.jsgs_dlfr_fax}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="jsgs_dlfr_phone" id="jsgs_dlfr_phone"
                               value="${content.jsgs_dlfr_phone}" style="width: 100px;"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" style="width: 10%;" nowrap>项目法人：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="jsgs_xmfr" id="jsgs_xmfr"
                               value="${content.jsgs_xmfr}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="jsgs_xmfr_tel" id="jsgs_xmfr_tel"
                               value="${content.jsgs_xmfr_tel}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="jsgs_xmfr_fax" id="jsgs_xmfr_fax"
                               value="${content.jsgs_xmfr_fax}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="jsgs_xmfr_phone" id="jsgs_xmfr_phone"
                               value="${content.jsgs_xmfr_phone}" style="width: 100px;"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" style="width: 10%;" nowrap>联系人：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="jsgs_lxr" id="jsgs_lxr"
                               value="${content.jsgs_lxr}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="jsgs_lxr_tel" id="jsgs_lxr_tel"
                               value="${content.jsgs_lxr_tel}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="jsgs_lxr_fax" id="jsgs_lxr_fax"
                               value="${content.jsgs_lxr_fax}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="jsgs_lxr_phone" id="jsgs_lxr_phone"
                               value="${content.jsgs_lxr_phone}" style="width: 100px;"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" rowspan="3" style="width:10%;" nowrap>勘察单位：</td>
                    <td class="form_content" style="width: 15%;" rowspan="3">
                        <input type="text" class="input_text" name="kcdw" id="kcdw" value="${content.kcdw}"
                               style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 10%;" nowrap>单独独立法人：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="kcdw_dlfr" id="kcdw_dlfr"
                               value="${content.kcdw_dlfr}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="kcdw_dlfr_tel" id="kcdw_dlfr_tel"
                               value="${content.kcdw_dlfr_tel}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="kcdw_dlfr_fax" id="kcdw_dlfr_fax"
                               value="${content.kcdw_dlfr_fax}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="kcdw_dlfr_phone" id="kcdw_dlfr_phone"
                               value="${content.kcdw_dlfr_phone}" style="width: 100px;"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" style="width: 10%;" nowrap>项目法人：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="kcdw_xmfr" id="kcdw_xmfr"
                               value="${content.kcdw_xmfr}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="kcdw_xmfr_tel" id="kcdw_xmfr_tel"
                               value="${content.kcdw_xmfr_tel}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="kcdw_xmfr_fax" id="kcdw_xmfr_fax"
                               value="${content.kcdw_xmfr_fax}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="kcdw_xmfr_phone" id="kcdw_xmfr_phone"
                               value="${content.kcdw_xmfr_phone}" style="width: 100px;"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" style="width: 10%;" nowrap>联系人：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="kcdw_lxr" id="kcdw_lxr"
                               value="${content.kcdw_lxr}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="kcdw_lxr_tel" id="kcdw_lxr_tel"
                               value="${content.kcdw_lxr_tel}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="kcdw_lxr_fax" id="kcdw_lxr_fax"
                               value="${content.kcdw_lxr_fax}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="kcdw_lxr_phone" id="kcdw_lxr_phone"
                               value="${content.kcdw_lxr_phone}" style="width: 100px;"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" rowspan="3" style="width:10%;" nowrap>设计单位：</td>
                    <td class="form_content" style="width: 15%;" rowspan="3">
                        <input type="text" class="input_text" name="sjdw" id="sjdw" value="${content.sjdw}"
                               style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 10%;" nowrap>单独独立法人：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="sjdw_dlfr" id="sjdw_dlfr"
                               value="${content.sjdw_dlfr}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="sjdw_dlfr_tel" id="sjdw_dlfr_tel"
                               value="${content.sjdw_dlfr_tel}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="sjdw_dlfr_fax" id="sjdw_dlfr_fax"
                               value="${content.sjdw_dlfr_fax}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="sjdw_dlfr_phone" id="sjdw_dlfr_phone"
                               value="${content.sjdw_dlfr_phone}" style="width: 100px;"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" style="width: 10%;" nowrap>项目法人：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="sjdw_xmfr" id="sjdw_xmfr"
                               value="${content.sjdw_xmfr}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="sjdw_xmfr_tel" id="sjdw_xmfr_tel"
                               value="${content.sjdw_xmfr_tel}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="sjdw_xmfr_fax" id="sjdw_xmfr_fax"
                               value="${content.sjdw_xmfr_fax}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="sjdw_xmfr_phone" id="sjdw_xmfr_phone"
                               value="${content.sjdw_xmfr_phone}" style="width: 100px;"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" style="width: 10%;" nowrap>联系人：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="sjdw_lxr" id="sjdw_lxr"
                               value="${content.sjdw_lxr}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="sjdw_lxr_tel" id="sjdw_lxr_tel"
                               value="${content.sjdw_lxr_tel}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="sjdw_lxr_fax" id="sjdw_lxr_fax"
                               value="${content.sjdw_lxr_fax}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="sjdw_lxr_phone" id="sjdw_lxr_phone"
                               value="${content.sjdw_lxr_phone}" style="width: 100px;"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" rowspan="3" style="width:10%;" nowrap>施工单位：</td>
                    <td class="form_content" style="width: 15%;" rowspan="3">
                        <input type="text" class="input_text" name="sgdw" id="sgdw" value="${content.sgdw}"
                               style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 10%;" nowrap>单独独立法人：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="sgdw_dlfr" id="sgdw_dlfr"
                               value="${content.sgdw_dlfr}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="sgdw_dlfr_tel" id="sgdw_dlfr_tel"
                               value="${content.sgdw_dlfr_tel}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="sgdw_dlfr_fax" id="sgdw_dlfr_fax"
                               value="${content.sgdw_dlfr_fax}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="sgdw_dlfr_phone" id="sgdw_dlfr_phone"
                               value="${content.sgdw_dlfr_phone}" style="width: 100px;"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" style="width: 10%;" nowrap>项目法人：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="sgdw_xmfr" id="sgdw_xmfr"
                               value="${content.sgdw_xmfr}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="sgdw_xmfr_tel" id="sgdw_xmfr_tel"
                               value="${content.sgdw_xmfr_tel}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="sgdw_xmfr_fax" id="sgdw_xmfr_fax"
                               value="${content.sgdw_xmfr_fax}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="sgdw_xmfr_phone" id="sgdw_xmfr_phone"
                               value="${content.sgdw_xmfr_phone}" style="width: 100px;"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" style="width: 10%;" nowrap>联系人：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="sgdw_lxr" id="sgdw_lxr"
                               value="${content.sgdw_lxr}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="sgdw_lxr_tel" id="sgdw_lxr_tel"
                               value="${content.sgdw_lxr_tel}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="sgdw_lxr_fax" id="sgdw_lxr_fax"
                               value="${content.sgdw_lxr_fax}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="sgdw_lxr_phone" id="sgdw_lxr_phone"
                               value="${content.sgdw_lxr_phone}" style="width: 100px;"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" rowspan="3" style="width:10%;" nowrap>监理单位：</td>
                    <td class="form_content" style="width: 15%;" rowspan="3">
                        <input type="text" class="input_text" name="jldw" id="jldw" value="${content.jldw}"
                               style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 10%;" nowrap>单独独立法人：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="jldw_dlfr" id="jldw_dlfr"
                               value="${content.jldw_dlfr}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="jldw_dlfr_tel" id="jldw_dlfr_tel"
                               value="${content.jldw_dlfr_tel}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="jldw_dlfr_fax" id="jldw_dlfr_fax"
                               value="${content.jldw_dlfr_fax}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="jldw_dlfr_phone" id="jldw_dlfr_phone"
                               value="${content.jldw_dlfr_phone}" style="width: 100px;"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" style="width: 10%;" nowrap>项目法人：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="jldw_xmfr" id="jldw_xmfr"
                               value="${content.jldw_xmfr}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="jldw_xmfr_tel" id="jldw_xmfr_tel"
                               value="${content.jldw_xmfr_tel}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="jldw_xmfr_fax" id="jldw_xmfr_fax"
                               value="${content.jldw_xmfr_fax}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="jldw_xmfr_phone" id="jldw_xmfr_phone"
                               value="${content.jldw_xmfr_phone}" style="width: 100px;"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" style="width: 10%;" nowrap>联系人：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="jldw_lxr" id="jldw_lxr"
                               value="${content.jldw_lxr}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="jldw_lxr_tel" id="jldw_lxr_tel"
                               value="${content.jldw_lxr_tel}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="jldw_lxr_fax" id="jldw_lxr_fax"
                               value="${content.jldw_lxr_fax}" style="width: 100px;"/>
                    </td>
                    <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                    <td class="form_content" style="width: 15%;">
                        <input type="text" class="input_text" name="jldw_lxr_phone" id="jldw_lxr_phone"
                               value="${content.jldw_lxr_phone}" style="width: 100px;"/>
                    </td>
                </tr>
            </table>
        </fieldset>
        <div class="div_space"></div>
        <div style="text-align: center;">
            <input type="button" value="保存" class="button_confirm" onclick="save(this)">&nbsp;
            <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
        </div>
    </div>
</form:form>
