<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";    
    $(function () {
        //页面验证初始化
        var validateCondition = [
                                                                        //{name:"certName", rule:"validate[required,maxSize[100]]"},            
                                                                                                      //{name:"certCode", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"expireDate", rule:"validate[required,custom[date],maxSize[7]"},            
                                                                                                      //{name:"description", rule:"validate[required,maxSize[500]]"},            
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
        saveAjaxData("${ctx}/scjgSpecialWorkerCert/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
                                    <tr class="tr_light">
              <td class="form_label">证书名称：</td>
              <td class="form_content">
                        <form:input path="certName" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">证书编号：</td>
              <td class="form_content">
                        <form:input path="certCode" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">证书有效期：</td>
              <td class="form_content">
                                <form:input path="expireDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('expireDate');">
                                                 
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
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