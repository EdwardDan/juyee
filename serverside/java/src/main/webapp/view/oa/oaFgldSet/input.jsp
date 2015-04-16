<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            //{name:"description", rule:"validate[required,maxSize[500]]"},
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
//        //判断是否选择人员
//        if($('#fgldPerson').val() == ''){
//            showInfoMsg('请选择分管领导！',null);
//            return;
//        }
//        if($('#sysDeptId').val() == ''){
//            showInfoMsg('请选择分管部门！',null);
//            return;
//        }

        //提交表单
        saveAjaxData("${ctx}/oaFgldSet/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <input type="hidden" name="parent" id="parent" value="${bean.parent.id}"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
               <td class="form_label_right">人员：</td>
               <td class="form_content">
                   <input type="text" name="fgldPerson" id="fgldPerson" class="input_text"
                          value="${bean.user.person.name}" readonly="true"/>
                   <input type="hidden" name="person" id="person" value=""/>
                   <input type="button" class="button_select"
                          onclick="selectSysPerson('person','fgldPerson');"
                          title="点击选择申请人员">
               </td>
            </tr>
            <tr class="tr_dark">
                 <td class="form_label_right">分管部门：</td>
                 <td class="form_content">
                    <select multiple="multiple" id="sysDeptSel" name="sysDeptSel" class="input_textarea">
                         <c:forEach items="${bean.oaFgldSetItems}" var="item">
                              <option value="${item.dept.id}">${item.dept.name}</option>
                         </c:forEach>
                    </select>
                    <input type="button" value=" " class="button_select_add"
                           onclick="multiSelectSysDept('sysDeptSel','sysDeptId','')" title="点击选择单位">
                    <input type="button" value=" " class="button_select_remove"
                           onclick="removeMultiSelectOpt('sysDeptSel','sysDeptId','')" tittle="点击移除所选单位">
                    <input type="hidden" id="sysDeptId" name="sysDeptId" value="">
                 </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">备注：</td>
                <td class="form_content">
                    <form:textarea path="description" cssClass="input_textarea_long"
                                   cssStyle="width:100%"/>
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