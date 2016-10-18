<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"bjbh", rule:"validate[required,maxSize[100]]"},
            {name:"bdh", rule:"validate[required,maxSize[100]]"}
        ];
        validateInit(validateCondition, formId);
        showYzzpl();
    });

    //保存操作
    function save(buttonName, status, tab) {
        if (!validateForm(formId)) {
            return;
        }
        butType = tab;
        $("#status").val(status);
        if ("" != buttonName) {
            if (confirm("是否确定执行 " + buttonName + " 操作？")) {
                saveAjaxData("${ctx}/sgPermit/save.do", formId, doCloseWin);
            }
        } else {
            saveAjaxData("${ctx}/sgPermit/save.do", formId, refreshTabParam);
        }
    }
    function refreshTabParam() {
        if ($("#id").val() == "") {
            var ret = getAjaxData("${ctx}/sgPermit/getSgPermitId.do?projectTypeId=" + $("#projectType").val());
            if (ret != "") {
                var retId = getElementValue(ret, "id");
                if (retId != "") {
                    parent.id = retId;
                    $("#id").val(retId);
                }
            }
        }
        jumpInTab();
    }
    var butType;
    // tab页中跳转 butType为next 或者prev
    function jumpInTab() {
        var target = parent.$("li.tabs-selected");
        if ("tab1" == butType) {
            if ($(target).next()) {
                parent.$('#tabs').tabs('select', $(target).next().text());
            }
        }
    }
    function doCloseWin() {
        parent.closeWindow();
    }

    function checkNumner(element) {
        if (/^\d+\.\d+$/.test(element.value) || !isNaN(element.value)) {

        } else {
            showInfoMsg('只能输入整数和小数！', null);
            element.value = 0;
        }
    }

    function showYzzpl() {
        if (document.getElementById("isZftzl").checked) {
            $("#isZftzl").val("true");
            document.getElementById("yzzpl").style.display = "";
        } else {
            $("#isZftzl").val("false");
            document.getElementById("yzzpl").style.display = "none";
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="year"/>
    <form:hidden path="status"/>
    <input type="hidden" name="projectType" id="projectType" value="${bean.projectType.id}">

    <div class="form_div">
        <fieldset class="form_fieldset" style="width: 96%;">
            <legend>申请信息</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_dark">
                    <td class="form_label_right" nowrap>项目性质：</td>
                    <td class="form_content">
                        <sys:code code="${xmxz}" type="select" name="propertyType" id="propertyType" sysCodeDetailId="${bean.propertyType.id}"/>
                    </td>
                    <td class="form_label_right" nowrap>所属区县：</td>
                    <td class="form_content">
                        <select name="areaCode" class="form_select">
                            <option value="sh">上海市</option>
                        </select>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" nowrap>报建编号：</td>
                    <td class="form_content">
                        <form:input path="bjbh" cssClass="input_text_long"/>
                    </td>
                    <td class="form_label_right" nowrap>标段号：</td>
                    <td class="form_content">
                        <form:input path="bdh" cssClass="input_text_long"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" nowrap>业务编号：</td>
                    <td class="form_content" colspan="3">
                        <form:input path="bizCode" cssClass="input_text_long" readonly="true"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">项目名称：</td>
                    <td class="form_content" colspan="3">
                        <form:input path="projectName" cssClass="input_text" cssStyle="width: 96%;"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">建设单位：</td>
                    <td class="form_content" colspan="3">
                        <form:input path="buildName" cssClass="input_text" cssStyle="width: 96%;"/>
                    </td>
                </tr>

                <tr class="tr_light">
                    <td class="form_label_right" style="width: 20%;">建设单位性质：</td>
                    <td class="form_content" style="width: 30%;">
                        <form:input path="buildUnitType" cssClass="input_text" cssStyle="width: 90%;"/>
                    </td>
                    <td class="form_label_right" style="width: 20%;">建设单位地址：</td>
                    <td class="form_content" style="width: 30%;">
                        <form:input path="buildUnitAddress" cssClass="input_text" cssStyle="width: 90%;"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">建设单位法定代表人：</td>
                    <td class="form_content">
                        <form:input path="fr" cssClass="input_text" cssStyle="width: 90%;"/>
                    </td>
                    <td class="form_label_right" nowrap>建设单位联系电话：</td>
                    <td class="form_content">
                        <form:input path="buildUnitPhone" cssClass="input_text" cssStyle="width: 90%;"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" nowrap>建设单位联系人：</td>
                    <td class="form_content">
                        <form:input path="buildUnitPerson" cssClass="input_text" cssStyle="width: 90%;"/>
                    </td>
                    <td class="form_label_right">手机号：</td>
                    <td class="form_content">
                        <form:input path="buildUnitMobile" cssClass="input_text" cssStyle="width: 90%;"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">建设地点：</td>
                    <td class="form_content" colspan="3">
                        <form:input path="buildSite" cssClass="input_text" cssStyle="width: 96%;"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">建设地点所属区县：</td>
                    <td class="form_content" colspan="3">
                        <c:forEach items="${areaList}" var="item" varStatus="status">
                            <input type="radio" name="buildSiteCounty" value="${item.id}"
                                   <c:if test="${item.code==bean.buildSiteCounty}">checked</c:if>>${item.name}&nbsp;
                            <c:if test="${(status.index+1)%9==0}"><br></c:if>
                        </c:forEach>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">建设工程类别：</td>
                    <td class="form_content" colspan="3">
                        <c:forEach items="${lbs}" var="item">
                            <input type="checkbox" name="buildLbId" value="${item.id}"
                                   <c:if test="${fn:contains(bean.buildLbIds, item.id)}">checked</c:if>>${item.name}&nbsp;
                        </c:forEach>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">建设工程属性：</td>
                    <td class="form_content" colspan="3">
                        <c:forEach items="${sxs}" var="item">
                            <input type="radio" name="buildSx" value="${item.id}"
                                   <c:if test="${bean.buildSx.id == item.id}">checked</c:if>>${item.name}&nbsp;
                        </c:forEach>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">建设工程规模：</td>
                    <td class="form_content" colspan="3">
                        <form:input path="buildProjSize" cssClass="input_text" cssStyle="width: 96%;"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">国有资金比重%：</td>
                    <td class="form_content" colspan="3">
                        <form:input path="nationalFundsPro" cssClass="input_text_long" onchange="checkNumner(this)"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">合同价格（万元）：</td>
                    <td class="form_content">
                        <form:input path="contractPrice" cssClass="input_text" cssStyle="width: 90%;"/>
                    </td>
                    <td class="form_label_right" nowrap>合同工期（日历天）：</td>
                    <td class="form_content">
                        <form:input path="contractPeriod" cssClass="input_text" cssStyle="width: 90%;"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" nowrap>中标价格（万元）：</td>
                    <td class="form_content">
                        <form:input path="zbPrice" cssClass="input_text_long" cssStyle="width: 90%;"/>
                    </td>
                    <td class="form_label_right" nowrap>项目投资估算（万元）：</td>
                    <td class="form_content">
                        <form:input path="projectPlanCost" cssClass="input_text_long" cssStyle="width: 90%;"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">计划开工：</td>
                    <td class="form_content">
                        <form:input path="contractBeginDate" cssClass="input_date" readonly="true"/>
                        <input type="button" class="button_calendar" value=" " onClick="calendar('contractBeginDate');">
                    </td>
                    <td class="form_label_right">计划竣工：</td>
                    <td class="form_content">
                        <form:input path="contractEndDate" cssClass="input_date" readonly="true"/>
                        <input type="button" class="button_calendar" value=" " onClick="calendar('contractEndDate');">
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">现场开工情况：</td>
                    <td class="form_content" colspan="3">
                        <form:input path="startWorkCon" cssClass="input_text" cssStyle="width: 96%;"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="4">
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_header">
                                <td colspan="5">主要设计单位</td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" style="width: 12%;">主要设计单位：</td>
                                <td class="form_content" style="width: 88%;" colspan="4">
                                    <form:input path="sjUnitName" cssClass="input_text" cssStyle="width: 96%;"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td rowspan="3" class="form_label_right" style="width: 12%;"
                                    style="text-align: center;">主要设计单位
                                </td>
                                <td class="form_label_right" style="width: 15%;">招标方式：</td>
                                <td class="form_content" style="width: 30%;">
                                    <input type="text" name="mainSjZbfs" class="input_text" value="${hdExtend.mainSjZbfs}">
                                </td>
                                <td class="form_label_right" style="width: 10%;">中标价：</td>
                                <td class="form_content" style="width: 35%;">
                                    <input type="text" name="mainSjZbj" class="input_text" value="${hdExtend.mainSjZbj}">
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">资质等级：</td>
                                <td class="form_content">
                                    <input type="text" name="mainSjZzdj" class="input_text" value="${hdExtend.mainSjZzdj}">
                                </td>
                                <td class="form_label_right">证书编号：</td>
                                <td class="form_content">
                                    <input type="text" name="mainSjZsbh" class="input_text" value="${hdExtend.mainSjZsbh}">
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">项目负责人：</td>
                                <td class="form_content">
                                    <input type="text" name="mainSjXmfzr" class="input_text" value="${hdExtend.mainSjXmfzr}">
                                </td>
                                <td class="form_label_right">证书编号：</td>
                                <td class="form_content">
                                    <input type="text" name="mainSjZsbh2" class="input_text" value="${hdExtend.mainSjZsbh2}">
                                </td>
                            </tr>
                            <tr class="tr_header">
                                <td colspan="5">主要监理单位</td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">主要监理单位：</td>
                                <td class="form_content" colspan="4">
                                    <form:input path="jlUnitName" cssClass="input_text" cssStyle="width: 96%;"/>
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td rowspan="3" class="form_label_right" style="text-align: center;">主要监理单位</td>
                                <td class="form_label_right">招标方式：</td>
                                <td class="form_content">
                                    <input type="text" name="mainJlZbfs" class="input_text"
                                           value="${hdExtend.mainJlZbfs}">
                                </td>
                                <td class="form_label_right">中标价：</td>
                                <td class="form_content">
                                    <input type="text" name="mainJlZbj" class="input_text"
                                           value="${hdExtend.mainJlZbj}">
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">资质等级：</td>
                                <td class="form_content">
                                    <input type="text" name="mainJlZzdj" class="input_text"
                                           value="${hdExtend.mainJlZzdj}">
                                </td>
                                <td class="form_label_right">证书编号：</td>
                                <td class="form_content">
                                    <input type="text" name="mainJlZsbh" class="input_text" value="${hdExtend.mainJlZsbh}">
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">项目负责人：</td>
                                <td class="form_content">
                                    <input type="text" name="mainJlXmfzr" class="input_text" value="${hdExtend.mainJlXmfzr}">
                                </td>
                                <td class="form_label_right">证书编号：</td>
                                <td class="form_content">
                                    <input type="text" name="mainJlZsbh2" class="input_text" value="${hdExtend.mainJlZsbh2}">
                                </td>
                            </tr>
                            <tr class="tr_header">
                                <td colspan="5">主要施工单位</td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" style="width: 10%;">主要施工单位：</td>
                                <td class="form_content" style="width: 85%;" colspan="4">
                                    <form:input path="sgUnitName" cssClass="input_text" cssStyle="width: 96%;"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td rowspan="3" class="form_label_right" style="text-align: center;">主要施工单位</td>
                                <td class="form_label_right">招标方式：</td>
                                <td class="form_content">
                                    <input type="text" name="mainSgZbfs" class="input_text" value="${hdExtend.mainSgZbfs}">
                                </td>
                                <td class="form_label_right">中标价：</td>
                                <td class="form_content">
                                    <input type="text" name="mainSgZbj" class="input_text" value="${hdExtend.mainSgZbj}">
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">资质等级：</td>
                                <td class="form_content">
                                    <input type="text" name="mainSgZzdj" class="input_text" value="${hdExtend.mainSgZzdj}">
                                </td>
                                <td class="form_label_right">证书编号：</td>
                                <td class="form_content">
                                    <input type="text" name="mainSgZsbh" class="input_text" value="${hdExtend.mainSgZsbh}">
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">项目负责人：</td>
                                <td class="form_content">
                                    <input type="text" name="mainSgXmfzr" class="input_text" value="${hdExtend.mainSgXmfzr}">
                                </td>
                                <td class="form_label_right">证书编号：</td>
                                <td class="form_content">
                                    <input type="text" name="mainSgZsbh2" class="input_text" value="${hdExtend.mainSgZsbh2}"></td>
                            </tr>
                            <tr class="tr_header">
                                <td colspan="5">建设依据</td>
                            </tr>
                            <tr class="tr_dark">
                                <td rowspan="5" class="form_label_right" style="text-align: center;">建设依据</td>
                                <td class="form_label_right">工可批准或核准机关和文号：</td>
                                <td colspan="3" class="form_content">
                                    <input type="text" name="gkpzCode" class="input_text" value="${hdExtend.gkpzCode}">
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">批复或核准日期：</td>
                                <td class="form_content">
                                    <input type="text" name="hzDate" id="hzDate" class="input_date" value="${hdExtend.hzDate}">
                                    <input type="button" class="button_calendar" value=" " onClick="calendar('hzDate');">
                                </td>
                                <td class="form_label_right">投资估算：</td>
                                <td class="form_content">
                                    <input type="text" name="planCost" class="input_text" value="${hdExtend.planCost}">
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">初步设计批准机关和文号：</td>
                                <td colspan="3" class="form_content">
                                    <input type="text" name="cbshCode" class="input_text" value="${hdExtend.cbshCode}">
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">批复日期：</td>
                                <td class="form_content">
                                    <input type="text" name="pfDate" id="pfDate" class="input_date" value="${hdExtend.pfDate}">
                                    <input type="button" class="button_calendar" value=" " onClick="calendar('pfDate');">
                                </td>
                                <td class="form_label_right">批复工程：</td>
                                <td class="form_content">
                                    <input type="text" name="pfGq" class="input_text" value="${hdExtend.pfGq}">
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">总概算：</td>
                                <td colspan="3" class="form_content">
                                    <input type="text" name="totalGs" class="input_text" value="${hdExtend.totalGs}">
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" style="text-align: center;">主体工程<br>施工图审批</td>
                                <td class="form_label_right">批准机关和文号：</td>
                                <td colspan="3" class="form_content">
                                    <input type="text" name="pzjgCode" class="input_text" value="${hdExtend.pzjgCode}">
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right" style="text-align: center;">投资来源</td>
                                <td colspan="4" class="form_content">
                                    <input type="text" name="costFrom" class="input_text" value="${hdExtend.costFrom}">
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td colspan="4" class="form_content">
                        <input type="checkbox" id="isZftzl" name="isZftzl" value="1"
                               <c:if test="${bean.isZftzl}">checked </c:if>
                               onchange="showYzzpl()">是否政府投资类
                    </td>
                </tr>
                <tr id="yzzpl" <c:if test="${empty bean.isZftzl}">style="display: none" </c:if> class="tr_dark">
                    <td colspan="4">
                        <table style="width: 99%;">
                            <tr>
                                <td rowspan="4" valign="top">预制装配率</td>
                                <td>单跨跨径100米以下桥梁工程承台顶面以上构件</td>
                                <td><form:input path="yzzpl_1" cssClass="input_line_long" cssStyle="width: 50px;"/>%</td>
                            </tr>
                            <tr>
                                <td>隧道工程盾构段</td>
                                <td><form:input path="yzzpl_2" cssClass="input_line_long" cssStyle="width: 50px;"/>%</td>
                            </tr>
                            <tr>
                                <td>轨道交通工程地下过街通道</td>
                                <td><form:input path="yzzpl_3" cssClass="input_line_long" cssStyle="width: 50px;"/>%</td>
                            </tr>
                            <tr>
                                <td>水运工程（港口）桩顶面以上构件</td>
                                <td><form:input path="yzzpl_4" cssClass="input_line_long" cssStyle="width: 50px;"/>%</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td colspan="4">
                        <table cellpadding="0" cellspacing="0" class="table_thin_line" border="1" style="width: 100%;">
                            <tr class="tr_header">
                                <td style="width: 5%;">序号</td>
                                <td style="width: 50%;">申请材料名称</td>
                                <td style="width: 8%;">应交份数</td>
                                <td style="width: 8%;">实交份数</td>
                                <td style="width: 15%;">附件</td>
                            </tr>
                            <c:forEach items="${applyList}" var="map">
                                <c:set value="upLoad${map.no}" var="upLoadNo"/>
                                <tr class="tr_dark">
                                    <td style="text-align: center;">${map.no}
                                        <input type="hidden" name="no" value="${map.no}">
                                    </td>
                                    <td style="text-align: left;">&nbsp;${map.materialName}</td>
                                    <td style="text-align: center;">
                                        <c:if test="${map.yjNum != 0}">${map.yjNum}</c:if>
                                        <input type="hidden" name="yjNum${map.no}"
                                               value="<c:if test="${map.yjNum != 0}">${map.yjNum}</c:if>">
                                    </td>
                                    <td style="text-align: center;">
                                        <input type="text" name="sjNum${map.no}" class="input_number"
                                               value="${map.sjNum}"
                                               style="text-align: center;">
                                    </td>
                                    <td style="text-align: center;">${map[upLoadNo]}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td>
                </tr>
            </table>
        </fieldset>
        <div style="text-align: center;" class="tr_button">
            <input type="button" value="提交" class="button_confirm"
                   onclick="save(this.value,'${STATUS_SUBMIT}','${tab}')">&nbsp;
            <input type="button" value="保存" class="button_confirm" onclick="save('','${STATUS_EDIT}','${tab}')">&nbsp;
            <input type="button" value="取消" class="button_cancel" onclick="parent.closeWindow()">
        </div>
        <div class="div_space"></div>
    </div>
</form:form>
