<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "planName", rule: "validate[required,maxSize[100]]"},
            {name: "planCode", rule: "validate[required,maxSize[20]]"}
        ];
        validateInit(validateCondition, formId);

        loadProjectData(null, "", "");
        setAuditButton(document.getElementById("checkOpinion"));
    });

    //保存操作
    function save(btn, flag) {
        if (!validateForm(formId)) {
            return;
        }
        var jdTaskCodes = document.getElementsByName("jdTaskCode");
        if (${!isAudit}) {
            for (var i = 0; i < jdTaskCodes.length; i++) {
                if ("" == $("#completeDate_" + jdTaskCodes[i].value).val()) {
                    showInfoMsg("计划完成日期必须输入！");
                    return;
                }
            }
        }
        if (flag == 0) {
            $("#planStatus").val("${status_edit}");
            submitForm(btn);

        } else if (flag == 1) {
            var values = getJdTaskCodesValues();
            if (values == "") {
                showInfoMsg("请选择至少一项监督工程");

            } else {
                $.messager.confirm('系统提示', '提交审核后不能再修改，确定吗?', function (r) {
                    if (r) {
                        $("#planStatus").val("${status_submit}");
                        submitForm(btn);
                    }
                });
            }
        } else if (flag == 2) {
            if ($("#checkMemo").val() == "") {
                showInfoMsg("请输入审核意见");

            } else {
                $.messager.confirm('系统提示', '确定要退回修改吗?', function (r) {
                    if (r) {

                        $("#planStatus").val("${status_back}");
                        submitForm(btn);
                    }
                });
            }
        } else if (flag == 3) {
            $.messager.confirm('系统提示', '审核通过后不能再修改，确定吗?', function (r) {
                if (r) {
                    $("#planStatus").val("${status_pass}");
                    submitForm(btn);
                }
            });
        }
    }
    //提交表单
    function submitForm(btn) {
        disableBtn(btn);
        saveAjaxData("${ctx}/planMainInfo/save.do", formId);
    }

    //选择监督工程
    function selectCheckProject(btn) {
        openNewWindow("selectWindow", "选择监督工程", "${ctx}/planDetail/selectProject.do?id=" + $("#id").val(), false, 800, 500);
    }

    //加载监督工程列表
    function loadProjectData(jdTaskCode, causex, selectCauseOtherx) {
        var jdManager_v = getValueForPersonSelf($("input[name^='jdManager_']"));
        var date_v = getValueSelf($("input[name^='completeDate']"));
        var cause_v = getValueSelf($("input[name^='v_selectCause']"));
        var cause_other_v = getValueSelf($("input[name^='v_causeOther']"));
        var param = getJdTaskCodesValues();
        if (jdTaskCode != null) {
            if (("," + param + ",").indexOf("," + jdTaskCode + ",") == -1) {
                if (param != "") {
                    param += "," + jdTaskCode;
                    jdManager_v += "!" + "";
                    date_v += "," + "";
                    cause_v += "," + "";
                    cause_other_v += "," + "";
                } else {
                    param += jdTaskCode;
                }
            }
        }
        param = "<jdTaskCode>" + param + "</jdTaskCode>";
        if (jdTaskCode != null) {
            param += "<jdManager>" + jdManager_v + "</jdManager>";
            param += "<date>" + date_v + "</date>";
            param += "<cause>" + cause_v + "</cause>";
            param += "<causeOther>" + cause_other_v + "</causeOther>";
        }
        var deleteDetailId = $("#deleteDetailId").val() + ",";
        var url = "${ctx}/planDetail/getDetailList.do?"+encodeURI("id=${bean.id}&param=" + param + "&isEdit=${isEdit}&isAudit=${isAudit}&jdTaskCode=" + jdTaskCode + "&causex=" + causex + "&selectCauseOtherx=" + selectCauseOtherx + "&deleteDetailId=" + deleteDetailId);
        loadAjaxData("flowList", url);
    }
    function getJdTaskCodesValues() {
        var values = "";
        var jdTaskCodeObj = document.getElementsByName("jdTaskCode");
        if (jdTaskCodeObj != null) {
            values = getValues(jdTaskCodeObj);
        }
        return values;
    }
    function getValueForPersonSelf(obj) {
        var v = "";
        for (var i = 0; i < obj.length; i++) {
            if (v == "") {
                v = obj[i].value;
            } else {
                v += "!" + obj[i].value;
            }
        }
        return v;
    }
    function getValueSelf(obj) {
        var v = "";
        for (var i = 0; i < obj.length; i++) {
            v += (obj[i].value + " ,");
        }
        return v.substr(0, v.length - 1);
    }
    function getValues(obj) {
        var v = "";
        for (var i = 0; i < obj.length; i++) {
            if (v == "") {
                v = obj[i].value;
            } else {
                v += "," + obj[i].value;
            }
        }
        return v;
    }

    //移除一行
    function doRemove(btn, detailId) {
        $.messager.confirm('系统提示', '确定移除该监督工程吗?', function (r) {
            if (r) {
                var trObj = btn.parentElement.parentElement;
                trObj.parentElement.deleteRow(trObj.rowIndex);

                var deleteDetailIds = $("#deleteDetailId").val();
                deleteDetailIds += "," + detailId;
                $("#deleteDetailId").val(deleteDetailIds);
            }
        });
    }

    //根据审核意见设置按钮
    function setAuditButton(select) {
        if (select.value == ${PLAN_MAIN_INFO_OPINION_OK}) {
            $("#btnBack").attr("disabled", true);
            $("#btnPass").attr("disabled", false);
        } else if (select.value == ${PLAN_MAIN_INFO_OPINION_NO}) {
            $("#btnBack").attr("disabled", false);
            $("#btnPass").attr("disabled", true);
        }
    }
</script>

<form:form commandName="bean">
    <form:hidden path="id"/>
    <input type="hidden" name="planType" id="planType" value="${bean.planType.id}"/>
    <input type="hidden" name="planStatus" id="planStatus" value="${bean.planStatus.id}"/>
    <input type="hidden" name="deleteDetailId" id="deleteDetailId" value=""/>

    <div class="form_div">
        <div align="center" class="tr_dark">
            <div class="div_space"></div>
            <fieldset class="form_fieldset">
                <legend class="form_legend">计划基本信息</legend>
                <c:choose>
                    <c:when test="${isEdit}">
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td class="form_label">计划编号：</td>
                                <td class="form_content">
                                    <form:input path="planCode" cssClass="input_text"/>
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label">计划名称：</td>
                                <td class="form_content">
                                    <form:input path="planName" cssClass="input_text_long"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label">计划描述：</td>
                                <td class="form_content">
                                    <form:textarea path="planDesc" cssClass="input_textarea_long" cssStyle="height:100px"/>
                                </td>
                            </tr>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td class="form_label_right" width="15%" nowrap>计划编号：</td>
                                <td class="form_content" colspan="5">
                                    &nbsp;${bean.planCode}
                                    <form:hidden path="planCode"/>
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">计划名称：</td>
                                <td class="form_content" colspan="5">
                                    &nbsp;${bean.planName}
                                    <form:hidden path="planName"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">计划描述：</td>
                                <td class="form_content" colspan="5">
                                    &nbsp;<sys:toHtml>${bean.planDesc}</sys:toHtml>
                                    <form:hidden path="planDesc"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" width="15%" nowrap>创建人：</td>
                                <td class="form_content" width="20%" nowrap>
                                    &nbsp;${bean.createUserName}
                                </td>
                                <td class="form_label_right" width="15%" nowrap>创建日期：</td>
                                <td class="form_content" width="20%" nowrap>
                                    &nbsp;<fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd"/>
                                </td>
                                <td class="form_label_right" width="15%" nowrap>任务状态：</td>
                                <td class="form_content" width="20%" nowrap>
                                    &nbsp;${bean.planStatus.name}
                                </td>
                            </tr>
                        </table>
                    </c:otherwise>
                </c:choose>
            </fieldset>
            <div class="div_space"></div>
            <fieldset class="form_fieldset">
                <legend class="form_legend">计划详情
                    <input type="hidden" value="${jdTaskCodes}" name="jdTaskCodes" id="jdTaskCodes">
                    <c:if test="${isEdit||isAudit}">
                        <input type="button" value="选择监督工程" class="button_all_long" onclick="selectCheckProject(this)">
                    </c:if>
                </legend>
                <div class="form_table" id="flowList"></div>
            </fieldset>
            <div class="div_space"></div>
            <fieldset class="form_fieldset"
                      <c:if test="${status_edit == bean.planStatus.id}">style="display:none"</c:if>>
                <legend class="form_legend">审核信息</legend>
                <c:choose>
                    <c:when test="${isAudit}">
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td class="form_label_right" width="10%" nowrap>审核人：</td>
                                <td class="form_content" width="20%" nowrap>
                                    &nbsp;${bean.checkUserName}
                                    <form:hidden path="checkUserName" cssClass="input_text"/>
                                    <input type="hidden" name="checkUser" id="checkUser" value="${bean.checkUser.id}"/>
                                </td>
                                <td class="form_label_right" width="10%" nowrap>审核日期：</td>
                                <td class="form_content" width="20%" nowrap>
                                    &nbsp;<fmt:formatDate value="${bean.checkDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                    <input type="hidden" name="checkDateTime" id="checkDateTime"
                                           value="${bean.checkDateTime}"/>
                                </td>
                                <td class="form_label_right" width="10%" nowrap>审核意见：</td>
                                <td class="form_content" width="20%" nowrap>
                                    <sys:code code="${PLAN_MAIN_INFO_OPINION}" name="checkOpinion" type="select"
                                              defaultName=""
                                              sysCodeDetailId="${bean.checkOpinion.id}" disabled="" id="checkOpinion"
                                              isAlowedNull="false" onChange="setAuditButton(this)"/>
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">审核备注：</td>
                                <td class="form_content" colspan="5">
                                    <form:textarea path="checkMemo" cssClass="input_textarea" cssStyle="width:90%"/>
                                </td>
                            </tr>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td class="form_label_right" width="10%" nowrap>审核人：</td>
                                <td class="form_content" width="20%" nowrap>
                                    &nbsp;${bean.checkUserName}
                                    <form:hidden path="checkUserName"/>
                                    <input type="hidden" name="checkUser" id="checkUser" value="${bean.checkUser.id}"/>
                                </td>
                                <td class="form_label_right" width="10%" nowrap>审核日期：</td>
                                <td class="form_content" width="20%" nowrap>
                                    &nbsp;<fmt:formatDate value="${bean.checkDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                    <input type="hidden" name="checkDateTime" id="checkDateTime"
                                           value="${bean.checkDateTime}"/>
                                </td>
                                <td class="form_label_right" width="10%" nowrap>审核意见：</td>
                                <td class="form_content" width="20%" nowrap>
                                    &nbsp;${bean.checkOpinion.id}
                                    <input type="hidden" name="checkOpinion" id="checkOpinion"
                                           value="${bean.checkOpinion.id}"/>
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">审核备注：</td>
                                <td class="form_content" colspan="5">
                                    &nbsp;<sys:toHtml>${bean.checkMemo}</sys:toHtml>
                                    <form:hidden path="checkMemo"/>
                                </td>
                            </tr>
                        </table>
                    </c:otherwise>
                </c:choose>
            </fieldset>
        </div>
        <div class="div_space"></div>

        <div class="tr_button">
            <c:if test="${isAudit}">
                <input type="button" id="btnBack" value="退回修改" class="button_normal_long" onclick="save(this,2)">&nbsp;
                <input type="button" id="btnPass" value="审核通过" class="button_normal_long" onclick="save(this,3)">&nbsp;
            </c:if>
            <c:if test="${isEdit}">
                <input type="button" id="btnSub" value="提交审核" class="button_normal_long" onclick="save(this,1)">&nbsp;
                <input type="button" id="btnSave" value="保存" class="button_confirm" onclick="save(this,0)">&nbsp;
            </c:if>
            <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
        </div>
    </div>
</form:form>