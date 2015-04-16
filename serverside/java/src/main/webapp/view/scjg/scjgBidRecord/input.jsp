<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "bdh", rule: "validate[required]"},
            {name: "projectName", rule: "validate[required]"},
            {name: "code", rule: "validate[required]"},
            {name: "bjbh", rule: "validate[required]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn, flag) {
        if (!validateForm(formId)) {
            return;
        }
        if (flag == 1) {
            $("#status").val("1");
            submitForm(btn);
        } else if (flag == 2) {
            $.messager.confirm('系统提示', '提交审核后不能再修改，确定吗?', function (r) {
                if (r) {
                    $("#status").val("2");
                    submitForm(btn);
                }
            });
        } else if (flag == 3) {
            $.messager.confirm('系统提示', '确定要退回修改吗?', function (r) {
                if (r) {
                    $("#status").val("3");
                    submitForm(btn);
                }
            });
        } else if (flag == 4) {
            $.messager.confirm('系统提示', '审核通过后不能再修改，确定吗?', function (r) {
                if (r) {
                    $("#status").val("4");
                    submitForm(btn);
                }
            });
        }
    }

    //提交表单
    function submitForm(btn) {
        disableBtn(btn);
        saveAjaxData("${ctx}/scjgBidRecord/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <input type="hidden" name="status" id="status" value="${bean.status}"/>
        <input type="hidden" name="auditUser" id="auditUser" value="${bean.auditUser}"/>
        <input type="hidden" name="auditTime" id="auditTime" value="${bean.auditTime}"/>

        <table cellpadding="0" cellspacing="0" bgcolor="#f0f8ff" style="width: 100%">
            <tr>
                <td align="center">
                    <fieldset class="form_fieldset">
                        <legend align="center">上海市建设工程招投标监督记录</legend>

                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td class="form_label" nowrap>标段号：</td>
                                <td class="form_content" colspan="2">
                                    <form:input path="bdh" cssClass="input_text"/><font color="red">*</font></td>

                                <td class="form_label" nowrap>流水号：</td>
                                <td class="form_content" colspan="2"nowrap>
                                    <form:input path="code" cssClass="input_text"/><font color="red">*</font></td>

                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label" nowrap>项目名称：</td>
                                <td class="form_content" colspan="2">
                                    <form:input path="projectName" cssClass="input_text"/>   <font color="red">*</font>
                                </td>

                                <td class="form_label" nowrap>报建编号：</td>
                                <td class="form_content" colspan="2" nowrap>
                                    <form:input path="bjbh" cssClass="input_text"/>   <font color="red">*</font>
                                </td>

                            </tr>
                            <tr class="tr_light">
                                <td class="form_label" nowrap>招标方式：</td>
                                <td class="form_content">

                                    <sys:code code="ScjgBidRecordMethod" type="select" name="bidMethod"
                                              sysCodeDetailId="${bean.bidMethod.id}"/>
                                </td>

                                <td class="form_label" nowrap>项目类别：
                                    <sys:code code="ScjgBidRecordBiztype" type="select"
                                              name="bizType"
                                              sysCodeDetailId="${bean.bizType.id}"/></td>

                                <td class="form_label" nowrap>记录日期：&nbsp;&nbsp;</td>
                                <td class="form_content" colspan="3">
                                    <form:input path="fillDate" cssClass="input_date" readonly="true"/>
                                    <input type="button" class="button_calendar" value=" "
                                           onClick="calendar('fillDate');">

                                </td>
                            </tr>
                            <tr>
                            <tr class="tr_dark">
                                <td class="form_label" rowspan="3" nowrap>参加人员：</td>
                                <td class="form_label" nowrap>招标单位名称：</td>
                                <td class="form_content">
                                    <form:input path="bidDeptName" cssClass="input_text_long"/>
                                        <%--cssStyle="float:left;width: 90px"--%>
                                </td>
                                <td class="form_label" nowrap>招标单位人员：</td>
                                <td class="form_content" colspan="2">
                                    <form:input path="bidDeptPerson" cssClass="input_text"
                                                cssStyle="float:left;width: 110px"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label" nowrap>招标代理单位名称：</td>
                                <td class="form_content">
                                    <form:input path="bidDlDeptName" cssClass="input_text_long"/>
                                </td>
                                <td class="form_label" nowrap>招标代理单位人员：</td>
                                <td class="form_content" colspan="2">
                                    <form:input path="bidDlDeptPerson" cssClass="input_text"
                                                cssStyle="float:left;width: 110px"/>
                                </td>
                            </tr>

                            <tr class="tr_dark">
                                <td class="form_label" nowrap>评标委员会人员：</td>
                                <td class="form_content" colspan="3">
                                    <form:input path="bidCheckPerson" cssClass="input_text_long" length="100"/>
                                </td>
                            </tr>

                            <tr class="tr_light">
                                <td class="form_label" nowrap>监督类型：</td>
                                <td class="form_content" colspan="5">
                                    <sys:code code="ScjgBidRecordStage" type="select" name="jdStage"
                                              sysCodeDetailId="${bean.jdStage.id}"/>
                                </td>
                            </tr>

                            <tr class="tr_dark">
                                <td class="form_label" nowrap>监督记录：</td>
                                <td class="form_content" colspan="5">
                                    <form:textarea path="jdRecord" cssClass="input_textarea_long"/>
                                </td>
                            </tr>

                            <tr class="tr_dark">
                                <td class="form_label" nowrap>处理意见：</td>
                                <td class="form_content" colspan="5">
                                    <form:textarea path="dealOpinion" cssClass="input_textarea_long"/>
                                </td>
                            </tr>

                            <tr class="tr_light">
                                <td class="form_label">经办人：</td>
                                <td class="form_content">
                                    <form:input path="jbr" cssClass="input_text"/>
                                </td>
                                <td class="form_label"> <c:if test="${canAudit}">复核人： </c:if></td>
                                <td class="form_content" colspan="3">
                                    <c:if test="${canAudit}">  <form:input path="fhr" cssClass="input_text"/>  </c:if>
                                </td>
                            </tr>

                        </table>
                    </fieldset>
                </td>
            </tr>
            <tr class="tr_button">
                <td>
                    <c:if test="${canEdit&&(bean.status==SCJG_BID_RECORD_TIAN_XIE||bean.status==SCJG_BID_RECORD_TUI_HUI)}">
                        <input type="button" id="btnSub" value="提交复核" class="button_normal_long" onclick="save(this,2)">&nbsp;
                        <input type="button" id="btnSave" value="保存" class="button_confirm" onclick="save(this,1)">&nbsp;
                    </c:if>

                    <c:if test="${canAudit&&(bean.status==SCJG_BID_RECORD_TONG_GUO||bean.status==SCJG_BID_RECORD_FU_SHEN)}">
                        <input type="button" id="btnBack" value="退回修改" class="button_normal_long"
                               onclick="save(this,3)">&nbsp;
                        <input type="button" id="btnPass" value="复核通过" class="button_normal_long"
                               onclick="save(this,4)">&nbsp;
                    </c:if>

                    <c:if test="${addFlag=='add'}">
                        <input type="button" id="btnSub" value="提交复核" class="button_normal_long" onclick="save(this,2)">&nbsp;
                        <input type="button" id="btnSave" value="保存" class="button_confirm"
                               onclick="save(this,1)">&nbsp;
                    </c:if>
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>

    </div>
</form:form>