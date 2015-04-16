<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"jdTaskCode", rule:"validate[required,maxSize[50]]"},
            {name:"bjbh", rule:"validate[required,maxSize[50]]"},
            //{name:"buildUnit", rule:"validate[required,maxSize[200]]"},
            //{name:"projectName", rule:"validate[required,maxSize[200]]"},
            {name:"reportDate", rule:"validate[required,custom[date],maxSize[10]"}
            //{name:"printDatetime", rule:"validate[required,maxSize[19]]"},
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
//        //提交表单
//        if ($("#id").val() == "") {
//            disableBtn(btn);
//        }

        saveAjaxData("${ctx}/jdReport/save.do", formId, refreshTabParam);

    }

    //将保存后的id带入其他tab页
    function refreshTabParam() {
        enableBtn($("#id"));
        if ($("#id").val() == "") {
            var ret = getAjaxData("${ctx}/jdReport/getReportId.do?jdTaskCode=" + $("#jdTaskCode").val());
            if (ret != "") {
                var retId = getElementValue(ret, "id");
                if (retId != "") {
                    parent.id = retId;
                    $("#id").val(retId);
                }
            }
        }

    }

    //[获取工程信息
    function getInfo(btn) {
        var v = $("#jdTaskCode").val();
        if (v == "") {
            showInfoMsg("请先输入监督任务书编号");
            return;
        }
        btn.value = "请稍候";
        btn.disabled = true;
        $.ajax({
            url:"${ctx}/projectInfo/getProjectInfoByJdTaskCode.do?jdTaskCode=" + v,
            cache:false,
            data:"",
            success:function (ret) {
                if (ret.indexOf("{") >= 0) {
                    var json = eval("(" + ret + ")");
                    var data = json[0];
                    if (data.projectName != "") {
                        $("#projectName").val(data.projectName);
                        $("#gczj").val(data.totalInvestmentDesc);
                        $("#jzmj").val(data.totalAreaDesc);
                        $("#gclx").val(data.projectType);
                        $("#buildUnit").val(data.jsdwmc);
                        $("#jsdw_fzr").val(data.jsdwLxr);

                        $("#kcdwmc").val(data.kcdwmc);
                        $("#kcdw_fzr").val(data.kcdwLxr);

                        $("#sjdwmc").val(data.sjdwmc);
                        $("#sjdw_fzr").val(data.sjdwLxr);

                        $("#jldwmc").val(data.jldwmc);
                        $("#jldw_fzr").val(data.jldwLxr);

                        $("#sgdwmc").val(data.sgdwmc);
                        $("#sgdw_fzr").val(data.sgdwLxr);

                        $("#bjbh").val(data.bjbh);
                    }
                } else {
                    showErrorMsg("未获取到有效工程信息");
                }
                btn.value = "获取";
                btn.disabled = false;
            }, error:function () {
                btn.value = "获取";
                btn.disabled = false;
            }
        });
    }

    //获取监督人员信息
    function getPersonInfo(selectObj) {
        var name = selectObj.name;
        var v = $("#" + name).val();
        var vv = v.split("|");
        $("#" + name + "_xm").val(vv[0]);
        $("#" + name + "_zy").val(vv[1]);
        $("#" + name + "_bh").val(vv[2]);
    }
</script>
<form:form commandName="bean">
<form:hidden path="id"/>
<input type="hidden" name="zljddw" id="zljddw" value="${zljddw}">

<div class="form_div" align="center">
<div align="center" class="tr_dark">
<div class="div_space"></div>
<fieldset class="form_fieldset">
    <legend class="form_legend">工程情况</legend>

    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label_right">监督任务书编号：</td>
            <td class="form_content">
                <form:input path="jdTaskCode" cssClass="input_text" maxlength="50" cssStyle="float:left"/>
                <input type="button" value="获取" class="button_all" onclick="getInfo(this)" style="float:left;"/>
            </td>
            <td class="form_label_right">报告类型：</td>
            <td class="form_content">
                <select name="category" id="category">
                    <c:forEach items="${reportTypeList}" var="item">
                        <option value="${item.name}"
                                <c:if test="${bean.reportType.name==item.name}">selected</c:if>>${item.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">工程名称：</td>
            <td class="form_content">
                <form:input path="projectName" cssClass="input_text_long" maxlength="100"/>
            </td>
            <td class="form_label_right">工程造价：</td>
            <td class="form_content">
                <input type="text" name="gczj" id="gczj" class="input_text_long" value="${content.gczj}"
                       maxlength="20"/>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">建筑面积：</td>
            <td class="form_content">
                <input type="text" name="jzmj" id="jzmj" class="input_text_long" value="${content.jzmj}"
                       maxlength="20"/>
            </td>
            <td class="form_label_right">工程类型：</td>
            <td class="form_content">
                <input type="text" name="gclx" id="gclx" class="input_text_long" value="${content.gclx}"
                       maxlength="50"/>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">开工时间：</td>
            <td class="form_content">
                <input type="text" name="kgsj" id="kgsj" class="input_text_long" value="${content.kgsj}"
                       readonly="true"/>
                <input type="button" class="button_calendar" value=" " onClick="calendar('kgsj');">
            </td>
            <td class="form_label_right">竣工验收时间：</td>
            <td class="form_content">
                <input type="text" name="jgyssj" id="jgyssj" class="input_text_long" value="${content.jgyssj}"
                       readonly="true"/>
                <input type="button" class="button_calendar" value=" " onClick="calendar('jgyssj');">
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">建设单位名称：</td>
            <td class="form_content">
                <form:input path="buildUnit" cssClass="input_text_long" maxlength="100"/>
            </td>
            <td class="form_label_right">项目负责人：</td>
            <td class="form_content">
                <input type="text" name="jsdw_fzr" id="jsdw_fzr" class="input_text_long" value="${content.jsdw_fzr}"
                       maxlength="30"/>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">勘察单位名称：</td>
            <td class="form_content">
                <input type="text" name="kcdwmc" id="kcdwmc" class="input_text_long" value="${content.kcdwmc}"
                       maxlength="100"/>
            </td>
            <td class="form_label_right">项目负责人：</td>
            <td class="form_content">
                <input type="text" name="kcdw_fzr" id="kcdw_fzr" class="input_text_long" value="${content.kcdw_fzr}"
                       maxlength="30"/>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">设计单位名称：</td>
            <td class="form_content">
                <input type="text" name="sjdwmc" id="sjdwmc" class="input_text_long" value="${content.sjdwmc}"
                       maxlength="100"/>
            </td>
            <td class="form_label_right">项目负责人：</td>
            <td class="form_content">
                <input type="text" name="sjdw_fzr" id="sjdw_fzr" class="input_text_long" value="${content.sjdw_fzr}"
                       maxlength="30"/>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">施工单位名称：</td>
            <td class="form_content">
                <input type="text" name="sgdwmc" id="sgdwmc" class="input_text_long" value="${content.sgdwmc}"
                       maxlength="100"/>
            </td>
            <td class="form_label_right">项目经理：</td>
            <td class="form_content">
                <input type="text" name="sgdw_fzr" id="sgdw_fzr" class="input_text_long" value="${content.sgdw_fzr}"
                       maxlength="30"/>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">监理单位名称：</td>
            <td class="form_content">
                <input type="text" name="jldwmc" id="jldwmc" class="input_text_long" value="${content.jldwmc}"
                       maxlength="100"/>
            </td>
            <td class="form_label_right">项目负责人：</td>
            <td class="form_content">
                <input type="text" name="jldw_fzr" id="jldw_fzr" class="input_text_long" value="${content.jldw_fzr}"
                       maxlength="30"/>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">审图单位名称：</td>
            <td class="form_content">
                <input type="text" name="stdwmc" id="stdwmc" class="input_text_long" value="${content.stdwmc}"
                       maxlength="100"/>
            </td>
            <td class="form_label_right">&nbsp;</td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right" width="15%" nowrap="true">检测单位名称：</td>
            <td class="form_content" width="35%">
                <input type="text" name="jcdwmc" id="jcdwmc" class="input_text_long" value="${content.jcdwmc}"
                       maxlength="100"/>
            </td>
            <td class="form_label_right" width="15%" nowrap="true">节能检测单位名称：</td>
            <td class="form_content" width="35%">
                <input type="text" name="jnjcdwmc" id="jnjcdwmc" class="input_text_long" value="${content.jnjcdwmc}"
                       maxlength="100"/>
            </td>
        </tr>
        <tr>
            <td colspan="4" class="form_border"></td>
        </tr>
    </table>
</fieldset>
<div class="div_space"></div>

<fieldset class="form_fieldset">
    <legend class="form_legend">质量监督申报</legend>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label_right">监督申报时间：</td>
            <td class="form_content">
                <input type="text" name="zljd_sbrq" id="zljd_sbrq" class="input_text_long"
                       value="${content.zljd_sbrq}" readonly="true"/>
                <input type="button" class="button_calendar" value=" " onClick="calendar('zljd_sbrq');">
            </td>
            <td class="form_label_right">报建编号：</td>
            <td class="form_content">
                <input type="text" name="bjbh" id="bjbh" class="input_text_long" value="${content.bjbh}"
                       maxlength="30"/>
            </td>
        </tr>
        <tr>
            <td colspan="4">
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_header" align="center">
                        <td width="30%" class="form_border">&nbsp;</td>
                        <td width="25%" class="form_border">姓名</td>
                        <td width="25%" class="form_border">专业</td>
                        <td width="25%" class="form_border">监督证编号</td>
                    </tr>
                    <tr class="tr_light" align="center">
                        <td class="form_border">监督部门负责人</td>
                        <td class="form_content">
                            <select name="zljd_bmfzr" id="zljd_bmfzr" onchange="getPersonInfo(this)" style="width:100%">
                                <option value="||">------</option>
                                <c:forEach items="${personList}" var="item">
                                    <option value="${item.person.name}|${item.subject.name}|${item.certificateCode}"
                                            <c:if test="${content.zljd_bmfzr_bh == item.certificateCode}">selected</c:if>>${item.person.name}</option>
                                </c:forEach>
                            </select>
                            <input type="hidden" name="zljd_bmfzr_xm" id="zljd_bmfzr_xm"
                                   value="${content.zljd_bmfzr_xm}">
                        </td>
                        <td class="form_content"><input type="text" name="zljd_bmfzr_zy" id="zljd_bmfzr_zy"
                                                        class="input_text_long" value="${content.zljd_bmfzr_zy}"
                                                        maxlength="30" readonly="true" style="text-align:center"/></td>
                        <td class="form_content"><input type="text" name="zljd_bmfzr_bh" id="zljd_bmfzr_bh"
                                                        class="input_text_long" value="${content.zljd_bmfzr_bh}"
                                                        maxlength="30" readonly="true" style="text-align:center"/></td>
                    </tr>
                    <tr class="tr_dark" align="center">
                        <td class="form_border">质量监督工程师</td>
                        <td class="form_content">
                            <select name="zljd_gcs" id="zljd_gcs" onchange="getPersonInfo(this)" style="width:100%">
                                <option value="||">------</option>
                                <c:forEach items="${personList}" var="item">
                                    <option value="${item.person.name}|${item.subject.name}|${item.certificateCode}"
                                            <c:if test="${content.zljd_gcs_bh == item.certificateCode}">selected</c:if>>${item.person.name}</option>
                                </c:forEach>
                            </select>
                            <input type="hidden" name="zljd_gcs_xm" id="zljd_gcs_xm" value="${content.zljd_gcs_xm}">
                        </td>
                        <td class="form_content"><input type="text" name="zljd_gcs_zy" id="zljd_gcs_zy"
                                                        class="input_text_long" value="${content.zljd_gcs_zy}"
                                                        maxlength="30" readonly="true" style="text-align:center"/></td>
                        <td class="form_content"><input type="text" name="zljd_gcs_bh" id="zljd_gcs_bh"
                                                        class="input_text_long" value="${content.zljd_gcs_bh}"
                                                        maxlength="30" readonly="true" style="text-align:center"/></td>
                    </tr>
                    <tr class="tr_light" align="center">
                        <td class="form_border" rowspan="3">质量监督人员</td>
                        <td class="form_content">
                            <select name="zljd_ry1" id="zljd_ry1" onchange="getPersonInfo(this)" style="width:100%">
                                <option value="||">------</option>
                                <c:forEach items="${personList}" var="item">
                                    <option value="${item.person.name}|${item.subject.name}|${item.certificateCode}"
                                            <c:if test="${content.zljd_ry1_bh == item.certificateCode}">selected</c:if>>${item.person.name}</option>
                                </c:forEach>
                            </select>
                            <input type="hidden" name="zljd_ry1_xm" id="zljd_ry1_xm" value="${content.zljd_ry1_xm}">
                        </td>
                        <td class="form_content"><input type="text" name="zljd_ry1_zy" id="zljd_ry1_zy"
                                                        class="input_text_long" value="${content.zljd_ry1_zy}"
                                                        maxlength="30" readonly="true" style="text-align:center"/></td>
                        <td class="form_content"><input type="text" name="zljd_ry1_bh" id="zljd_ry1_bh"
                                                        class="input_text_long" value="${content.zljd_ry1_bh}"
                                                        maxlength="30" readonly="true" style="text-align:center"/></td>
                    </tr>
                    <tr class="tr_light" align="center">
                        <td class="form_content">
                            <select name="zljd_ry2" id="zljd_ry2" onchange="getPersonInfo(this)" style="width:100%">
                                <option value="||">------</option>
                                <c:forEach items="${personList}" var="item">
                                    <option value="${item.person.name}|${item.subject.name}|${item.certificateCode}"
                                            <c:if test="${content.zljd_ry2_bh == item.certificateCode}">selected</c:if>>${item.person.name}</option>
                                </c:forEach>
                            </select>
                            <input type="hidden" name="zljd_ry2_xm" id="zljd_ry2_xm" value="${content.zljd_ry2_xm}">
                        </td>
                        <td class="form_content"><input type="text" name="zljd_ry2_zy" id="zljd_ry2_zy"
                                                        class="input_text_long" value="${content.zljd_ry2_zy}"
                                                        maxlength="30" readonly="true" style="text-align:center"/></td>
                        <td class="form_content"><input type="text" name="zljd_ry2_bh" id="zljd_ry2_bh"
                                                        class="input_text_long" value="${content.zljd_ry2_bh}"
                                                        maxlength="30" readonly="true" style="text-align:center"/></td>
                    </tr>
                    <tr class="tr_light" align="center">
                        <td class="form_content">
                            <select name="zljd_ry3" id="zljd_ry3" onchange="getPersonInfo(this)" style="width:100%">
                                <option value="||">------</option>
                                <c:forEach items="${personList}" var="item">
                                    <option value="${item.person.name}|${item.subject.name}|${item.certificateCode}"
                                            <c:if test="${content.zljd_ry3_bh == item.certificateCode}">selected</c:if>>${item.person.name}</option>
                                </c:forEach>
                            </select>
                            <input type="hidden" name="zljd_ry3_xm" id="zljd_ry3_xm" value="${content.zljd_ry3_xm}">
                        </td>
                        <td class="form_content"><input type="text" name="zljd_ry3_zy" id="zljd_ry3_zy"
                                                        class="input_text_long" value="${content.zljd_ry3_zy}"
                                                        maxlength="30" readonly="true" style="text-align:center"/></td>
                        <td class="form_content"><input type="text" name="zljd_ry3_bh" id="zljd_ry3_bh"
                                                        class="input_text_long" value="${content.zljd_ry3_bh}"
                                                        maxlength="30" readonly="true" style="text-align:center"/></td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td colspan="4" class="form_border"></td>
        </tr>
    </table>
</fieldset>
<div class="div_space"></div>

<fieldset class="form_fieldset">
    <legend class="form_legend">工程报监、开工前质量监督情况</legend>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label_right" width="15%" nowrap="true">首次交底会议时间：</td>
            <td class="form_content" width="35%">
                <input type="text" name="kgq_scjdhy_rq" id="kgq_scjdhy_rq" class="input_text_long"
                       value="${content.kgq_scjdhy_rq}" readonly="true"/>
                <input type="button" class="button_calendar" value=" " onClick="calendar('kgq_scjdhy_rq');">
            </td>
            <td class="form_label_right" width="15%" nowrap="true">节能监督首次时间：</td>
            <td class="form_content" width="35%">
                <input type="text" name="kgq_jnjdsc_rq" id="kgq_jnjdsc_rq" class="input_text_long"
                       value="${content.kgq_jnjdsc_rq}" readonly="true"/>
                <input type="button" class="button_calendar" value=" " onClick="calendar('kgq_jnjdsc_rq');">
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">其他应说明的情况：</td>
            <td class="form_content" colspan="3">
                <textarea rows="2" cols="80" name="kgq_sm" id="kgq_sm" class="input_textarea_long"
                          style="width:100%;height:40px" maxlength="500">${content.kgq_sm}</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="4" class="form_border"></td>
        </tr>
    </table>
</fieldset>
<div class="div_space"></div>

<fieldset class="form_fieldset">
    <legend class="form_legend">施工过程中质量监督检查情况</legend>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_content" colspan="4">&nbsp;&nbsp;抽查次数：
                <input type="text" name="gcz_cccs" id="gcz_cccs" class="input_text" value="${content.gcz_cccs}"
                       style="width:50px" maxlength="10"/>
                &nbsp;&nbsp;&nbsp;涉及
                    ${CHECKBOX_gcz_ccbw}
                &nbsp;&nbsp;&nbsp;等部位结构，未见违反工程建设标准强制性条文要求的问题存在。
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_content" colspan="4">&nbsp;&nbsp;抄送我站的分部质量验收证明包括：
                <span style="color:teal;font-weight:bold;">
                        ${CHECKBOX_gcz_fbyszm}
                </span>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_content" colspan="4">
                &nbsp;&nbsp;签发《建设工程局部暂停施工整改指令单》：
                <input type="text" name="gcz_zgzld" id="gcz_zgzld" class="input_text" value="${content.gcz_zgzld}"
                       style="width:50px" maxlength="10"/>份，
                &nbsp;&nbsp;&nbsp;签发《建设工程质量问题整改通知》
                <input type="text" name="gcz_zgtz" id="gcz_zgtz" class="input_text" value="${content.gcz_zgtz}"
                       style="width:50px" maxlength="10"/>份
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right" width="15%">其他应说明的情况：</td>
            <td class="form_content" colspan="3">
                <textarea rows="2" cols="80" name="gcz_sm" id="gcz_sm" class="input_textarea_long"
                          style="width:100%;height:40px" maxlength="500">${content.gcz_sm}</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="4" class="form_border"></td>
        </tr>
    </table>
</fieldset>
<div class="div_space"></div>

<fieldset class="form_fieldset">
    <legend class="form_legend">桩基、基础、主体、节能部位质量检测抽查情况</legend>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label_right" width="15%">其他应说明的情况：</td>
            <td class="form_content" colspan="3">
                <textarea rows="2" cols="80" name="zjbw_sm" id="zjbw_sm" class="input_textarea_long"
                          style="width:100%;height:40px" maxlength="500">${content.zjbw_sm}</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="4" class="form_border"></td>
        </tr>
    </table>
</fieldset>
<div class="div_space"></div>

<fieldset class="form_fieldset">
    <legend class="form_legend">节能保温工程质量监督检查情况</legend>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_content" colspan="3">&nbsp;&nbsp;节能形式</td>
        </tr>
        <tr class="tr_dark" style="color:green">
            <td class="form_content" colspan="3">&nbsp;&nbsp;1) 墙体保温系统<input type="checkbox" name="jnbwgc_xt_lx"
                                                                             value="无"
                                                                             <c:if test="${fn:indexOf(content.jnbwgc_xt_lx,'无')>=0||content.jnbwgc_xt_lx ==null}">checked</c:if>/><font
                    color="red">无</font></td>
        </tr>
        <tr class="tr_dark" style="color:red">
            <td class="form_content" width="15%" nowrap="true">&nbsp;&nbsp;<input type="checkbox" name="jnbwgc_xt_lx"
                                                                                  value="外墙外保温"
                                                                                  <c:if test="${fn:indexOf(content.jnbwgc_xt_lx,'外墙外保温')>=0}">checked</c:if>/>外墙外保温
            </td>
            <td class="form_content" width="85%" colspan="2">
                    ${CHECKBOX_jnbwgc_xt_wqwbw_xx}
                &nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="jnbwgc_xt_wqwbw_qt" id="jnbwgc_xt_wqwbw_qt"
                                               class="input_text" value="${content.jnbwgc_xt_wqwbw_qt}" maxlength="30"/>
            </td>
        </tr>
        <tr class="tr_dark" style="color:red">
            <td class="form_content">&nbsp;&nbsp;<input type="checkbox" name="jnbwgc_xt_lx" value="外墙内保温"
                                                        <c:if test="${fn:indexOf(content.jnbwgc_xt_lx,'外墙内保温')>=0}">checked</c:if>/>外墙内保温
            </td>
            <td class="form_content" colspan="2">
                    ${CHECKBOX_jnbwgc_xt_wqnbw_xx}
                &nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="jnbwgc_xt_wqnbw_qt" id="jnbwgc_xt_wqnbw_qt"
                                               class="input_text" value="${content.jnbwgc_xt_wqnbw_qt}" maxlength="30"/>
            </td>
        </tr>
        <tr class="tr_dark" style="color:red">
            <td class="form_content">&nbsp;&nbsp;<input type="checkbox" name="jnbwgc_xt_lx" value="墙体自保温"
                                                        <c:if test="${fn:indexOf(content.jnbwgc_xt_lx,'墙体自保温')>=0}">checked</c:if>/>墙体自保温
            </td>
            <td class="form_content" colspan="2">
                    ${CHECKBOX_jnbwgc_xt_qtzbw_xx}
                &nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="jnbwgc_xt_qtzbw_qt" id="jnbwgc_xt_qtzbw_qt"
                                               class="input_text" value="${content.jnbwgc_xt_qtzbw_qt}" maxlength="30"/>
            </td>
        </tr>
        <tr class="tr_dark" style="color:green">
            <td class="form_content">&nbsp;&nbsp;2) 屋面保温</td>
            <td class="form_content" colspan="2">
                    ${CHECKBOX_jnbwgc_wmbw_lx}
                &nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="jnbwgc_wmbw_qt" id="jnbwgc_wmbw_qt" class="input_text"
                                               value="${content.jnbwgc_wmbw_qt}" maxlength="30"/>
            </td>
        </tr>
        <tr class="tr_dark" style="color:green">
            <td class="form_content">&nbsp;&nbsp;3) 门窗保温</td>
            <td class="form_content" colspan="2">
                    ${CHECKBOX_jnbwgc_mcbw_lx}
                &nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="jnbwgc_mcbw_qt" id="jnbwgc_mcbw_qt" class="input_text"
                                               value="${content.jnbwgc_mcbw_qt}" maxlength="30"/>
            </td>
        </tr>
        <tr class="tr_dark" style="color:green">
            <td class="form_content">&nbsp;&nbsp;4) 其他节能</td>
            <td class="form_content" colspan="2">
                <input type="text" name="jnbwgc_qtjn_qt" id="jnbwgc_qtjn_qt" class="input_text_long"
                       value="${content.jnbwgc_qtjn_qt}" maxlength="30"/>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_border">抽查次数</td>
            <td class="form_content" colspan="2">
                <input type="text" name="jnbwgc_cccs" id="jnbwgc_cccs" class="input_text" value="${content.jnbwgc_cccs}"
                       style="width:50px" maxlength="10"/>次，
                &nbsp;&nbsp;&nbsp;签发《建设工程质量问题整改通知》
                <input type="text" name="jnbwgc_zgs" id="jnbwgc_zgs" class="input_text" value="${content.jnbwgc_zgs}"
                       style="width:50px" maxlength="10"/>份
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">其他应说明的情况：</td>
            <td class="form_content" colspan="2">
                <textarea rows="2" cols="80" name="jnbwgc_sm" id="jnbwgc_sm" class="input_textarea_long"
                          style="width:100%;height:40px" maxlength="500">${content.jnbwgc_sm}</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="4" class="form_border"></td>
        </tr>
    </table>
</fieldset>
<div class="div_space"></div>

<fieldset class="form_fieldset">
    <legend class="form_legend">工程建设参与各方执行国家强制性标注，质量行为及质量责任制履行情况</legend>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label_right" width="15%">其他应说明的情况：</td>
            <td class="form_content" colspan="3">
                <textarea rows="2" cols="80" name="zlxw_sm" id="zlxw_sm" class="input_textarea_long"
                          style="width:100%;height:40px" maxlength="500">${content.zlxw_sm}</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="4" class="form_border"></td>
        </tr>
    </table>
</fieldset>
<div class="div_space"></div>

<fieldset class="form_fieldset">
    <legend class="form_legend">工程竣工质量、技术资料抽查情况</legend>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label_right" width="15%">其他应说明的情况：</td>
            <td class="form_content" colspan="3">
                <textarea rows="2" cols="80" name="jszlcc_sm" id="jszlcc_sm" class="input_textarea_long"
                          style="width:100%;height:40px" maxlength="500">${content.jszlcc_sm}</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="4" class="form_border"></td>
        </tr>
    </table>
</fieldset>
<div class="div_space"></div>

<fieldset class="form_fieldset">
    <legend class="form_legend">竣工质量检测、试验抽查情况</legend>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label_right" width="15%" nowrap="true">已通过室内环境质量检测：</td>
            <td class="form_content" colspan="3">
                <input type="text" name="syccqk_hjjc" id="syccqk_hjjc" class="input_text_long"
                       value="${content.syccqk_hjjc}" maxlength="500"/>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right" width="15%">抽查建筑物的围护结构：</td>
            <td class="form_content" colspan="3">
                    ${CHECKBOX_syccqk_whjg}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right" width="15%">其他应说明的情况：</td>
            <td class="form_content" colspan="3">
                <textarea rows="2" cols="80" name="syccqk_sm" id="syccqk_sm" class="input_textarea_long"
                          style="width:100%;height:40px" maxlength="500">${content.syccqk_sm}</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="4" class="form_border"></td>
        </tr>
    </table>
</fieldset>
<div class="div_space"></div>

<fieldset class="form_fieldset">
    <legend class="form_legend">对工程遗留质量缺陷的监督意见</legend>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label_right" width="15%">其他应说明的情况：</td>
            <td class="form_content" colspan="3">
                <textarea rows="2" cols="80" name="zlqx_sm" id="zlqx_sm" class="input_textarea_long"
                          style="width:100%;height:40px" maxlength="500">${content.zlqx_sm}</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="4" class="form_border"></td>
        </tr>
    </table>
</fieldset>
<div class="div_space"></div>

<fieldset class="form_fieldset">
    <legend class="form_legend">监督报告信息</legend>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label_right" width="15%" nowrap="true">监督报告编制日期：</td>
            <td class="form_content" width="35%">
                <form:input path="reportDate" cssClass="input_date" readonly="true"/>
                <input type="button" class="button_calendar" value=" " onClick="calendar('reportDate');">
            </td>
            <td class="form_label_right" width="15%" nowrap="true">监督报告编制人：</td>
            <td class="form_content" width="35%">
                <form:input path="reportPerson" cssClass="input_text" readonly="true"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="form_border"></td>
        </tr>
    </table>
</fieldset>
<div class="div_space"></div>

<div class="tr_button">
    <input type="button" value="确定" id="ok" class="button_confirm" onclick="save(this)">&nbsp;
    <input type="button" value="取消" class="button_cancel" onclick="parent.closeWindow()">
</div>
</div>
</div>
</form:form>