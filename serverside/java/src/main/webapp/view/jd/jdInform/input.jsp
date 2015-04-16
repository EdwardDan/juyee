<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "lxr", rule: "validate[required,maxSize[25]]"},
            {name: "tel", rule: "validate[required,maxSize[25]]"},
            {name: "zipCode", rule: "validate[required,maxSize[25]]"},
            {name: "address", rule: "validate[required,maxSize[100]]"}
//            {name: "fax", rule: "validate[required,maxSize[25]]"}
        ];
        validateInit(validateCondition, formId);

        //加载项目信息
        loadProjectInfoByCode(document.getElementById("loadPrjBtn"),$("#bjbh").val(),null,false,false);
    });

    //保存操作
    function save(status, btn) {
        if (!validateForm(formId)) {
            return;
        }

        //加入其他业务判断
        if (status == '${STATUS_SUBMIT}'){
            if (confirm("提交之后将不能再修改，确定继续吗？")) {
                $("#status").val(status);
                saveAjaxData("${ctx}/jdInform/save.do", formId,null);
            }
        } else {
            $("#status").val(status);
            saveAjaxData("${ctx}/jdInform/save.do", formId,null);
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="status"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr>
                <td colspan="2">
                    <fieldset class="form_fieldset">
                        <legend class="form_legend">工程信息</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td class="form_label_right" width="20%" nowrap>报建编号：</td>
                                <td class="form_content" width="30%" nowrap>
                                    <form:input path="bjbh" cssClass="input_text"/>
                                    <input type="button" value="获取" class="button_all" id="loadPrjBtn" onclick="loadProjectInfoByCode(this,$('#bjbh').val(),null,true,false)">
                                </td>
                                <td class="form_label_right" width="20%" nowrap>项目名称：</td>
                                <td class="form_content" width="30%" nowrap>
                                    <input type="text" name="projectName" id="projectName" class="input_text_long" readonly="true">
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right" nowrap>项目分类：</td>
                                <td class="form_content" nowrap>
                                    <input type="text" name="projectType" id="projectType" class="input_text" readonly="true">
                                </td>
                                <td class="form_label_right" nowrap>工程地点：</td>
                                <td class="form_content" nowrap>
                                    <input type="text" name="buildAddress" id="buildAddress" class="input_text_long" readonly="true">
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" nowrap>建筑面积：</td>
                                <td class="form_content" nowrap>
                                    <input type="text" name="totalArea" id="totalArea" class="input_text" readonly="true">
                                </td>
                                <td class="form_label_right" nowrap>单体数量：</td>
                                <td class="form_content" nowrap>
                                    <input type="text" name="dtsl" id="dtsl" class="input_text" readonly="true">㎡
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right" nowrap>工程造价：</td>
                                <td class="form_content" nowrap colspan="3">
                                    <input type="text" name="totalInvestment" id="totalInvestment" class="input_text" readonly="true">万元
                                </td>
                            </tr>

                            <tr class="tr_light">
                                <td class="form_label_right" nowrap>建设单位：</td>
                                <td class="form_content" nowrap>
                                    <input type="text" name="jsdwmc" id="jsdwmc" class="input_text_long" readonly="true">
                                </td>
                                <td class="form_label_right" nowrap>联系人：</td>
                                <td class="form_content" nowrap>
                                    <input type="text" name="jsdwLxr" id="jsdwLxr" class="input_text" readonly="true">
                                    <input type="text" name="jsdwTel" id="jsdwTel" class="input_text" readonly="true">
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right" nowrap>施工单位：</td>
                                <td class="form_content" nowrap>
                                    <input type="text" name="sgdwmc" id="sgdwmc" class="input_text_long" readonly="true">

                                </td>
                                <td class="form_label_right" nowrap>联系人：</td>
                                <td class="form_content" nowrap>
                                    <input type="text" name="sgdwLxr" id="sgdwLxr" class="input_text" readonly="true">
                                    <input type="text" name="sgdwTel" id="sgdwTel" class="input_text" readonly="true">
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" nowrap>勘察单位：</td>
                                <td class="form_content" nowrap>
                                    <input type="text" name="kcdwmc" id="kcdwmc" class="input_text_long" readonly="true">

                                </td>
                                <td class="form_label_right" nowrap>联系人：</td>
                                <td class="form_content" nowrap>
                                    <input type="text" name="kcdwLxr" id="kcdwLxr" class="input_text" readonly="true">
                                    <input type="text" name="kcdwTel" id="kcdwTel" class="input_text" readonly="true">
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right" nowrap>设计单位：</td>
                                <td class="form_content" nowrap>
                                    <input type="text" name="sjdwmc" id="sjdwmc" class="input_text_long" readonly="true">
                                </td>
                                <td class="form_label_right" nowrap>联系人：</td>
                                <td class="form_content" nowrap>
                                    <input type="text" name="sjdwLxr" id="sjdwLxr" class="input_text" readonly="true">
                                    <input type="text" name="sjdwTel" id="sjdwTel" class="input_text" readonly="true">
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" nowrap>监理单位：</td>
                                <td class="form_content" nowrap>
                                    <input type="text" name="jldwmc" id="jldwmc" class="input_text_long" readonly="true">
                                </td>
                                <td class="form_label_right" nowrap>联系人：</td>
                                <td class="form_content" nowrap>
                                    <input type="text" name="jldwLxr" id="jldwLxr" class="input_text" readonly="true">
                                    <input type="text" name="jldwTel" id="jldwTel" class="input_text" readonly="true">

                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right" nowrap>施工总包：</td>
                                <td class="form_content" nowrap>
                                    <input type="text" name="sgzbdwmc" id="sgzbdwmc" class="input_text_long" readonly="true">
                                </td>
                                <td class="form_label_right" nowrap>联系人：</td>
                                <td class="form_content" nowrap>
                                    <input type="text" name="sgzbdwLxr" id="sgzbdwLxr" class="input_text" readonly="true">
                                    <input type="text" name="sgzbdwTel" id="sgzbdwTel" class="input_text" readonly="true">
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
                <td>
                    <fieldset class="form_fieldset">
                        <legend class="form_legend">质量监督告知书</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_dark">
                                <td class="form_label_right" nowrap width="20%">监督联系人：</td>
                                <td class="form_content" width="30%">
                                    <form:input path="lxr" cssClass="input_text"/>
                                </td>

                                <td class="form_label_right" nowrap width="20%">联系电话：</td>
                                <td class="form_content" width="30%">
                                    <form:input path="tel" cssClass="input_text"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" nowrap>邮政编码：</td>
                                <td class="form_content">
                                    <form:input path="zipCode" cssClass="input_text"/>
                                </td>

                                <td class="form_label_right" nowrap>联系地址：</td>
                                <td class="form_content">
                                    <form:input path="address" cssClass="input_text"/>
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right" nowrap>传真号码：</td>
                                <td class="form_content" nowrap>
                                    <form:input path="fax" cssClass="input_text"/>
                                </td>
                                <td class="form_label_right" nowrap>施工许可证发放日期：</td>
                                <td class="form_content" nowrap>
                                    <input type="text" name="sgxkDate" id="sgxkDate" class="input_datetime"
                                           value="<fmt:formatDate value="${bean.sgxkDate}" pattern="yyyy-MM-dd"/>"
                                           readonly="true"/>
                                    <input type="button" class="button_calendar" value=" "
                                           onClick="calendar('sgxkDate','')">
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" nowrap>备注：</td>
                                <td class="form_content" colspan="3">
                                    <form:textarea path="description" cssClass="input_textarea_long" cssStyle="width: 100%"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>

            <tr class="tr_button">
                <td class="form_border" align="center" colspan="4">
                    <input type="button" value="提交" class="button_confirm" onclick="save('${STATUS_SUBMIT}',this)">&nbsp;
                    <input type="button" value="暂存" class="button_confirm" onclick="save('${STATUS_EDIT}',this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>