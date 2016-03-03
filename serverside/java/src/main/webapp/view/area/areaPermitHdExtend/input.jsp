<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";    
    $(function () {
        //页面验证初始化
        var validateCondition = [
                                                                        //{name:"mainSjUnit", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"mainSjZbfs", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"mainSjZbj", rule:"validate[required,custom[number],maxSize[10]"},
                                                                                                      //{name:"mainSjZzdj", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"mainSjXmfzr", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"mainSjZsbh", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"mainSjZsbh2", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"mainJlUnit", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"mainJlZbfs", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"mainJlZbj", rule:"validate[required,custom[number],maxSize[10]"},
                                                                                                      //{name:"mainJlZzdj", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"mainJlXmfzr", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"mainJlZsbh", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"mainJlZsbh2", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"mainSgUnit", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"mainSgZbfs", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"mainSgZbj", rule:"validate[required,custom[number],maxSize[10]"},
                                                                                                      //{name:"mainSgZzdj", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"mainSgXmfzr", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"mainSgZsbh", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"mainSgZsbh2", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"gkpzCode", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"hzDate", rule:"validate[required,custom[date],maxSize[7]"},            
                                                                                                      //{name:"planCost", rule:"validate[required,custom[number],maxSize[10]"},
                                                                                                      //{name:"cbshCode", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"pfDate", rule:"validate[required,custom[date],maxSize[7]"},            
                                                                                                      //{name:"pfGq", rule:"validate[required,custom[integer],maxSize[4]"},            
                                                                                                      //{name:"totalGs", rule:"validate[required,custom[number],maxSize[10]"},
                                                                                                      //{name:"pzjgCode", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"costFrom", rule:"validate[required,maxSize[200]]"},            
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
        saveAjaxData("${ctx}/areaPermitHdExtend/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
                                    <tr class="tr_light">
              <td class="form_label">主要设计单位：</td>
              <td class="form_content">
                        <form:input path="mainSjUnit" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">主要设计招标方式：</td>
              <td class="form_content">
                        <form:input path="mainSjZbfs" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">主要设计中标价：</td>
              <td class="form_content">
                        <form:input path="mainSjZbj" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">主要设计资质等级：</td>
              <td class="form_content">
                        <form:input path="mainSjZzdj" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">主要设计项目负责人：</td>
              <td class="form_content">
                        <form:input path="mainSjXmfzr" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">主要设计证书编号：</td>
              <td class="form_content">
                        <form:input path="mainSjZsbh" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">主要设计证书编号2：</td>
              <td class="form_content">
                        <form:input path="mainSjZsbh2" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">主要监理单位：</td>
              <td class="form_content">
                        <form:input path="mainJlUnit" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">主要监理招标方式：</td>
              <td class="form_content">
                        <form:input path="mainJlZbfs" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">主要监理中标价：</td>
              <td class="form_content">
                        <form:input path="mainJlZbj" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">主要监理资质等级：</td>
              <td class="form_content">
                        <form:input path="mainJlZzdj" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">主要监理项目负责人：</td>
              <td class="form_content">
                        <form:input path="mainJlXmfzr" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">主要监理证书编号：</td>
              <td class="form_content">
                        <form:input path="mainJlZsbh" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">主要监理证书编号2：</td>
              <td class="form_content">
                        <form:input path="mainJlZsbh2" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">主要施工单位：</td>
              <td class="form_content">
                        <form:input path="mainSgUnit" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">主要施工招标方式：</td>
              <td class="form_content">
                        <form:input path="mainSgZbfs" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">主要施工中标价：</td>
              <td class="form_content">
                        <form:input path="mainSgZbj" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">主要施工资质等级：</td>
              <td class="form_content">
                        <form:input path="mainSgZzdj" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">主要施工项目负责人：</td>
              <td class="form_content">
                        <form:input path="mainSgXmfzr" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">主要施工证书编号：</td>
              <td class="form_content">
                        <form:input path="mainSgZsbh" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">主要施工证书编号2：</td>
              <td class="form_content">
                        <form:input path="mainSgZsbh2" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">工可批准或核准机关和文号：</td>
              <td class="form_content">
                        <form:input path="gkpzCode" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">批复或核准日期：</td>
              <td class="form_content">
                                <form:input path="hzDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('hzDate');">
                                                 
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">投资估算：</td>
              <td class="form_content">
                        <form:input path="planCost" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">初步设计批准机关和文号：</td>
              <td class="form_content">
                        <form:input path="cbshCode" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">批复日期：</td>
              <td class="form_content">
                                <form:input path="pfDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('pfDate');">
                                                 
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">批复工期：</td>
              <td class="form_content">
                        <form:input path="pfGq" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">总概算：</td>
              <td class="form_content">
                        <form:input path="totalGs" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">批准机关和文号：</td>
              <td class="form_content">
                        <form:input path="pzjgCode" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">投资来源：</td>
              <td class="form_content">
                        <form:input path="costFrom" cssClass="input_text"/>						
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