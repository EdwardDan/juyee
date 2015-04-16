<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";    
    $(function () {
        //页面验证初始化
        var validateCondition = [
                                                                        //{name:"recordId", rule:"validate[required,custom[integer],maxSize[10]"},            
                                                                                                      //{name:"typeCode", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"orderNo", rule:"validate[required,custom[integer],maxSize[4]"},            
                                                                                                      //{name:"questionId", rule:"validate[required,custom[integer],maxSize[10]"},            
                                                                                                      //{name:"questionDesc", rule:"validate[required,maxSize[${prop.length}]]"},            
                                                                                                      //{name:"dealAdvise", rule:"validate[required,maxSize[${prop.length}]]"},            
                                                                                                      //{name:"unlawId", rule:"validate[required,custom[integer],maxSize[10]"},            
                                                                                                      //{name:"unlawDesc", rule:"validate[required,maxSize[${prop.length}]]"},            
                                                                                                      //{name:"jdPersonId", rule:"validate[required,custom[integer],maxSize[10]"},            
                                                                                                      //{name:"jdPersonDesc", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"planEndDate", rule:"validate[required,custom[date],maxSize[7]"},            
                                                                                                      //{name:"isForm", rule:"validate[required,maxSize[1]]"},            
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
        saveAjaxData("${ctx}/jdRecordQuestion/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
                                    <tr class="tr_light">
              <td class="form_label">监督id(首次/安全/质量/竣工)：</td>
              <td class="form_content">
                        <form:input path="recordId" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">问题类别编码：</td>
              <td class="form_content">
                        <form:input path="typeCode" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">序号：</td>
              <td class="form_content">
                        <form:input path="orderNo" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">问题id：</td>
              <td class="form_content">
                        <form:input path="questionId" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">问题描述：</td>
              <td class="form_content">
                        <form:input path="questionDesc" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">处理建议：</td>
              <td class="form_content">
                        <form:input path="dealAdvise" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">违法条款id：</td>
              <td class="form_content">
                        <form:input path="unlawId" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">违法条款描述：</td>
              <td class="form_content">
                        <form:input path="unlawDesc" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">监督员id：</td>
              <td class="form_content">
                        <form:input path="jdPersonId" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">监督员描述：</td>
              <td class="form_content">
                        <form:input path="jdPersonDesc" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">拟整改截止日期：</td>
              <td class="form_content">
                                <form:input path="planEndDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('planEndDate');">
                                                 
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">是否开单：</td>
              <td class="form_content">
                                    <form:checkbox path="isForm" value="1"/>
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