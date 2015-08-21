<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";    
    $(function () {
        //页面验证初始化
        var validateCondition = [
                                                                        //{name:"gctxGkpfTotal", rule:"validate[required,custom[number],maxSize[15]"},
                                                                                                      //{name:"gctxCspfTotal", rule:"validate[required,custom[number],maxSize[15]"},
                                                                                                      //{name:"gctxSourceFund", rule:"validate[required,maxSize[500]]"},            
                                                                                                      //{name:"planXmjysTime", rule:"validate[required,custom[date],maxSize[10]"},            
                                                                                                      //{name:"planGkTime", rule:"validate[required,custom[date],maxSize[10]"},            
                                                                                                      //{name:"planCbsjTime", rule:"validate[required,custom[date],maxSize[10]"},            
                                                                                                      //{name:"gcjsIsBigin", rule:"validate[required,maxSize[1]]"},            
                                                                                                      //{name:"gcjsBeginTime", rule:"validate[required,custom[date],maxSize[10]"},            
                                                                                                      //{name:"gcjsIsEnd", rule:"validate[required,maxSize[1]]"},            
                                                                                                      //{name:"gcjsEndTime", rule:"validate[required,custom[date],maxSize[10]"},            
                                                                                                      //{name:"createTime", rule:"validate[required,maxSize[7]]"},            
                                                                                                      //{name:"createUser", rule:"validate[required,maxSize[100]]"},            
                                                                                                      //{name:"updateTime", rule:"validate[required,maxSize[7]]"},            
                                                                                                      //{name:"updateUser", rule:"validate[required,maxSize[100]]"},            
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
        saveAjaxData("${ctx}/projExtend/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
                                    <tr class="tr_light">
              <td class="form_label">工可批复总投资（亿元）：</td>
              <td class="form_content">
                        <form:input path="gctxGkpfTotal" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">初设批复总投资（亿元）：</td>
              <td class="form_content">
                        <form:input path="gctxCspfTotal" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">资金来源：</td>
              <td class="form_content">
                        <form:input path="gctxSourceFund" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">项目建议书完成时间：</td>
              <td class="form_content">
                                <form:input path="planXmjysTime" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('planXmjysTime');">
                                                 
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">工可完成时间：</td>
              <td class="form_content">
                                <form:input path="planGkTime" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('planGkTime');">
                                                 
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">初步设计完成时间：</td>
              <td class="form_content">
                                <form:input path="planCbsjTime" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('planCbsjTime');">
                                                 
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">是否开工：</td>
              <td class="form_content">
                                    <form:checkbox path="gcjsIsBigin" value="1"/>
                                      </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">开工时间：</td>
              <td class="form_content">
                                <form:input path="gcjsBeginTime" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('gcjsBeginTime');">
                                                 
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">是否完工：</td>
              <td class="form_content">
                                    <form:checkbox path="gcjsIsEnd" value="1"/>
                                      </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">完工时间：</td>
              <td class="form_content">
                                <form:input path="gcjsEndTime" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('gcjsEndTime');">
                                                 
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">创建时间：</td>
              <td class="form_content">
                                <input type="text" name="createTime" id="createTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('createTime','all')">                                                        
            
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">创建用户名：</td>
              <td class="form_content">
                        <form:input path="createUser" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">更新时间：</td>
              <td class="form_content">
                                <input type="text" name="updateTime" id="updateTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('updateTime','all')">                                                        
            
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">更新用户名：</td>
              <td class="form_content">
                        <form:input path="updateUser" cssClass="input_text"/>						
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