<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            //{name:"bjbh", rule:"validate[required,maxSize[50]]"},
            {name:"reportTypeDesc", rule:"validate[required,maxSize[50]]"},
            //{name:"reportDate", rule:"validate[required,custom[date],maxSize[20]"},
            {name:"description", rule:"validate[required,maxSize[500]"}
        ];
        validateInit(validateCondition, formId);

        //加载项目信息
        loadProjectInfoByCode(null,$("#bjbh").val(),null,false,true);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //提交表单
        saveAjaxData("${ctx}/jdJlReport/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="jlDeptName"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr>
                <td colspan="2">
                    <fieldset class="form_fieldset">
                        <legend class="form_legend">工程信息</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td class="form_label_right" width="15%">项目名称：</td>
                                <td class="form_content" width="35%">
                                    <span id="projectName"></span>
                                </td>
                                <td class="form_label_right" width="15%">报建编号：</td>
                                <td class="form_content" width="35%">
                                    <form:input path="bjbh" cssClass="input_text" readonly="true"/>
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">工程地点：</td>
                                <td class="form_content">
                                    <span id="buildAddress"></span>
                                </td>
                                <td class="form_label_right">项目分类：</td>
                                <td class="form_content">
                                    <span id="projectType"></span>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" nowrap>工程造价：</td>
                                <td class="form_content">
                                    <span id="totalInvestmentDesc"></span>
                                </td>
                                <td class="form_label_right" nowrap>施工许可证发放日期：</td>
                                <td class="form_content">
                                    <span id="approvalDate"></span>
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">建筑面积：</td>
                                <td class="form_content">
                                    <span id="totalAreaDesc"></span>
                                </td>
                                <td class="form_label_right">单体数量：</td>
                                <td class="form_content">
                                    <span id="dtsl"></span>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">建设单位：</td>
                                <td class="form_content">
                                    <span id="jsdwmc"></span>
                                </td>
                                <td class="form_label_right">联系人：</td>
                                <td class="form_content">
                                    <span id="jsdwLxr"></span>&nbsp;&nbsp;<span id="jsdwTel"></span>
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">监理单位：</td>
                                <td class="form_content">
                                    <span id="jldwmc"></span>
                                </td>
                                <td class="form_label_right">联系人：</td>
                                <td class="form_content">
                                    <span id="jldwLxr"></span>&nbsp;&nbsp;<span id="jldwTel"></span>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="form_fieldset_space">&nbsp;</td>
            </tr>
            <tr>
                <td colspan="2">
                    <fieldset class="form_fieldset">
                        <legend class="form_legend">监理报告</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td class="form_label_right" width="15%">提交日期：</td>
                                <td class="form_content" width="35%">
                                    <form:input path="reportDate" cssClass="input_date_long" readonly="true"/>
                                </td>
                                <td class="form_label_right" width="15%">报告类型：</td>
                                <td class="form_content" width="35%">
                                    <sys:code code="JdJlReportType" type="select" name="reportTypeId"
                                              sysCodeDetailId="${bean.reportType.id}"/>
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">备注：</td>
                                <td class="form_content" colspan="3">
                                    <form:textarea path="description" cssClass="input_textarea_long"
                                                   cssStyle="width:100%"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">附件：</td>
                                <td class="form_content" colspan="3">&nbsp;${uploadButton}</td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_label"></td>
                <td class="form_content">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>