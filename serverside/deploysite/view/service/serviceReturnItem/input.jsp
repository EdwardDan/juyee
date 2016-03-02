<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";    
    $(function () {
        //页面验证初始化
        var validateCondition = [
                                                                        //{name:"num", rule:"validate[required,custom[integer],maxSize[4]"},            
                                                                                                      //{name:"serviceBook", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"servicePerson", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"receiveDate", rule:"validate[required,custom[date],maxSize[7]"},            
                                                                                                      //{name:"receiveSign", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"memo", rule:"validate[required,maxSize[1000]]"},            
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
        saveAjaxData("${ctx}/serviceReturnItem/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
                                    <tr class="tr_light">
              <td class="form_label">序号：</td>
              <td class="form_content">
                        <form:input path="num" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">送达文书：</td>
              <td class="form_content">
                        <form:input path="serviceBook" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">送达人：</td>
              <td class="form_content">
                        <form:input path="servicePerson" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">收到日期：</td>
              <td class="form_content">
                                <form:input path="receiveDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('receiveDate');">
                                                 
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">收到人签名：</td>
              <td class="form_content">
                        <form:input path="receiveSign" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">备注：</td>
              <td class="form_content">
                        <form:input path="memo" cssClass="input_text"/>						
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