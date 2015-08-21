<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";    
    $(function () {
        //页面验证初始化
        var validateCondition = [
                                                                        //{name:"year", rule:"validate[required,custom[integer],maxSize[4]"},            
                                                                                                      //{name:"month", rule:"validate[required,custom[integer],maxSize[2]"},            
                                                                                                      //{name:"title", rule:"validate[required,maxSize[100]]"},            
                                                                                                      //{name:"projProgress", rule:"validate[required,maxSize[${prop.length}]]"},            
                                                                                                      //{name:"question", rule:"validate[required,maxSize[${prop.length}]]"},            
                                                                                                      //{name:"improveOpinion", rule:"validate[required,maxSize[${prop.length}]]"},            
                                                                                                      //{name:"description", rule:"validate[required,maxSize[${prop.length}]]"},            
                                                  ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //加入其他业务判断
//        if ($('#name').val() == '') {
//            showInfoMsg('请输入姓名！',null);
//            return;
//        }

        //提交表单
        saveAjaxData("${ctx}/projExtendSchedule/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
                                    <tr class="tr_light">
              <td class="form_label">年：</td>
              <td class="form_content">
                        <form:input path="year" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">月：</td>
              <td class="form_content">
                        <form:input path="month" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">时间（冗余字段）：</td>
              <td class="form_content">
                        <form:input path="title" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">项目进展情况：</td>
              <td class="form_content">
                        <form:input path="projProgress" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">存在问题：</td>
              <td class="form_content">
                        <form:input path="question" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">改进意见：</td>
              <td class="form_content">
                        <form:input path="improveOpinion" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">备注：</td>
              <td class="form_content">
                        <form:input path="description" cssClass="input_text"/>						
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