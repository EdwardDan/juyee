<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <c:if test="${not empty bean.id}">
        <%@include file="/common/header.jsp" %>
    </c:if>
    <script type="text/javascript">
        var formId = "bean";
        $(function () {
            //页面验证初始化
            var validateCondition = [
                //{name:"jbpmDefinitionId", rule:"validate[required,custom[integer],max[10]"},
                {name:"code", rule:"validate[required,maxSize[25]]"},
                {name:"name", rule:"validate[required,maxSize[50]]"},
                {name:"templateName", rule:"validate[required]"}
                //{name:"version", rule:"validate[required,custom[integer],max[4]"},
                //{name:"orderNo", rule:"validate[required,custom[integer],max[10]"},
                //{name:"isValid", rule:"validate[required,maxSize[1]]"},
                //{name:"description", rule:"validate[required,maxSize[1000]]"},
                //{name:"workId", rule:"validate[required,custom[integer],max[10]"},
                //{name:"updateTime", rule:"validate[required,maxSize[19]]"},
                //{name:"createTime", rule:"validate[required,maxSize[19]]"},
                //{name:"bizObject", rule:"validate[required,maxSize[50]]"}
            ];
            validateInit(validateCondition, formId);
        });

        //保存操作
        function save(btn) {
            if (!validateForm(formId)) {
                return;
            }

            $("#formTemplateIds").val(getSelectValues($("#formTemplateNames").get(0)));
            //加入其他业务判断
//        if ($('#name').val() == '') {
//            showInfoMsg('请输入姓名！',null);
//            return;
//        }

            //提交表单
            btn.disabled = true;
            saveAjaxData("${ctx}/bpmProcessDefinition/save.do", formId);
            setTimeout(function () {
                btn.disabled = false;
            }, 5000);
        }

        function warnInfo() {
            if ($("#isChangeFlow").get(0).checked) {
                showInfoMsg('勾选此项会将流程泳道、节点等设置全部清空（基本信息除外）!', 'warn');
            }
        }

        //选择表单
        function doSelectFormTemplateForDefinition(bpmProcessDefinitionId, keyId, keyName) {
            if (bpmProcessDefinitionId == "") {
                alert("请先保存！");
                return;
            }
            selectFormTemplateForDefinition(bpmProcessDefinitionId, keyId, keyName);
        }

        //选择表单key
        function doSelectFormKey(formId, keyId, keyName, index) {
            //如果只有一张表单那么直接选择，不用先选择表单
            var formTemplateNamesEle = $("#formTemplateNames").get(0);
            var formTemplateIds_value = getSelectValues(formTemplateNamesEle);
            if (formTemplateIds_value != "" && formTemplateNamesEle.options.length == 1) {
                selectFormKey(formTemplateIds_value, keyId, keyName);
                if (keyId.value != "") {
                    $("#formName_" + index).val(getSelectNames(formTemplateNamesEle));
                    $("#formId_" + index).val(formTemplateIds_value);
                }
            } else {
                if (formId == "") {
                    alert("请先选择表单！");
                    return;
                }
                selectFormKey(formId, keyId, keyName);
            }
        }
    </script>
    <style type="text/css">
        .input_none {
            font-size: 12px;
            border: 0px none;
            background-color: #e0ebf2;
            width: 100%;
            height: 20px
        }
    </style>
</head>
<body>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <input type="hidden" name="category" id="category" value="${bean.category.id}"/>

    <div class="form_div tr_dark">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label">业务流程编码：</td>
                <td class="form_content">
                    <form:input path="code" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">业务流程名称：</td>
                <td class="form_content">
                    <form:input path="name" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">流程图模板：</td>
                <td class="form_content" nowrap>
                    <form:hidden path="processTemplate" value="${bean.processTemplate.id}"/>
                    <input type="text" id="templateName" name="templateName" class="input_text"
                           value="${bean.processTemplate.name}" readonly="true"/>
                    <input type="button" value=" " class="button_select"
                           onclick="selectProcessTemplate('processTemplate','templateName')" title="点击选择流程图模板">
                    <input type="checkbox" name="isChangeFlow" id="isChangeFlow" value="1"
                           title="勾选此项会将流程泳道、节点等设置全部清空（基本信息除外）!" onClick="warnInfo()">刷新流程
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">表单模板：</td>
                <td class="form_content">
                    <select id="formTemplateNames" name="formTemplateNames" multiple="multiple"
                            class="form_multi_select">
                        <c:forEach var="formTemplate" items="${formTemplates}">
                            <option value="${formTemplate.id}">${formTemplate.name}</option>
                        </c:forEach>
                    </select><input type="hidden" name="formTemplateIds" id="formTemplateIds">
                    <input type="button" value=" " class="button_select_add"
                           onClick="multiSelectFormTemplate('formTemplateNames','formTemplateIds','');"/>
                    <input type="button" value=" " class="button_select_remove"
                           onClick="removeMultiSelectOpt('formTemplateNames','formTemplateIds','');"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">文档目录：</td>
                <td class="form_content" nowrap>
                    <input type="text" name="fileCategoryName" id="fileCategoryName" class="input_text"
                           value="${bean.fileCategory.name}" readonly="true"/>
                    <input type="button" value=" " class="button_select"
                           onclick="selectDocCategory('fileCategory','fileCategoryName')" title="点击选择文档目录">
                    <form:hidden path="fileCategory" value="${bean.fileCategory.id}"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">备注：</td>
                <td class="form_content">
                    <form:textarea path="description" cssClass="input_textarea"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">排序：</td>
                <td class="form_content">
                    <form:input path="orderNo" cssClass="input_text"/>(数据越小越前面)
                </td>
            </tr>
        </table>
        <div class="div_space"></div>
        <fieldset class="form_fieldset" style="margin: auto;">
            <legend class="form_legend">
                字段映射
            </legend>
            <div class="form_table">
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_header" align="center">
                        <td width="30%" class="form_border" nowrap>数据库字段</td>
                        <td width="15%" class="form_border" nowrap>表单模板</td>
                        <td width="20%" class="form_border" nowrap>模板定义KEY</td>
                        <td width="20%" class="form_border" nowrap>列表显示名称</td>
                        <td width="20%" class="form_border" nowrap>列表显示宽度</td>
                        <td width="5%" class="form_border" nowrap>是否生效</td>
                        <td width="5%" class="form_border" nowrap>列表显示</td>
                    </tr>
                    <c:forEach items="${list}" var="listcolumn" varStatus="s">
                        <input type="hidden" name="no">
                        <tr class="tr_light">
                            <td nowrap class="form_border">
                                <input type="text" class="input_none" name="column_${s.index+1}"
                                       id="column_${s.index+1}"
                                       value="${listcolumn.column}" readonly style="text-align:center">
                            </td>
                            <td nowrap class="form_border">
                                <input type="text" class="input_text" name="formName_${s.index+1}"
                                       id="formName_${s.index+1}"
                                       value="${listcolumn.formName}" readonly>
                                <input type="hidden" name="formId_${s.index+1}" id="formId_${s.index+1}"
                                       value="${listcolumn.formId}">
                                <input type="button" value=" " class="button_select"
                                       onclick="doSelectFormTemplateForDefinition('${bean.id}','#formId_${s.index+1}','#formName_${s.index+1}')"/>
                            </td>
                            <td nowrap class="form_border">
                                <input type="button" value="=" class="button_normal" title="复制数据库字段值"
                                       onclick="$('#key_${s.index+1}').val($('#column_${s.index+1}').val())">
                                <input type="text" class="input_text" name="key_${s.index+1}" id="key_${s.index+1}"
                                       value="${listcolumn.key}">
                                <input type="button" value=" " class="button_select"
                                       onclick="doSelectFormKey($('#formId_${s.index+1}').val(),'#key_${s.index+1}',null,'${s.index+1}')"/>
                            </td>
                            <td nowrap class="form_border">
                                <input type="text" class="input_text" name="gridName_${s.index+1}"
                                       value="${listcolumn.gridName}">
                            </td>
                            <td nowrap class="form_border">
                                <input type="text" class="input_text" name="gridWidth_${s.index+1}"
                                       value="${listcolumn.gridWidth}" style="width:60px">%
                            </td>
                            <td nowrap class="form_border">
                                <input type="checkbox" name="isValid_${s.index+1}" value="1"
                                       <c:if test="${listcolumn.isValid}">checked</c:if>>
                            </td>
                            <td nowrap class="form_border">
                                <input type="checkbox" name="isGridShow_${s.index+1}" value="1"
                                       <c:if test="${listcolumn.isGridShow}">checked</c:if>>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </fieldset>
    </div>

    <div class="tr_button" align="center">
        <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
        <input type="reset" value="重写" class="button_all">&nbsp;
        <c:if test="${empty bean.id}">
            <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
        </c:if>
    </div>
</form:form>
</body>
</html>
