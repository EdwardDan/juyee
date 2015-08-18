<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";    
    $(function () {
        //页面验证初始化
        var validateCondition = [
                                                                        //{name:"stepId", rule:"validate[required,custom[integer],maxSize[10]"},            
                                                                                                      //{name:"isDeal", rule:"validate[required,maxSize[1]]"},            
                                                                                                      //{name:"dealUser", rule:"validate[required,maxSize[100]]"},            
                                                                                                      //{name:"dealResult", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"receiveTime", rule:"validate[required,maxSize[7]]"},            
                                                                                                      //{name:"openTime", rule:"validate[required,maxSize[7]]"},            
                                                                                                      //{name:"completeTime", rule:"validate[required,maxSize[7]]"},            
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
        saveAjaxData("${ctx}/oaReceiveNode/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
                                    <tr class="tr_light">
              <td class="form_label">流转步骤ID：</td>
              <td class="form_content">
                        <form:input path="stepId" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">是否处理：</td>
              <td class="form_content">
                                    <form:checkbox path="isDeal" value="1"/>
                                      </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">处理人：</td>
              <td class="form_content">
                        <form:input path="dealUser" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">处理结果：</td>
              <td class="form_content">
                        <form:input path="dealResult" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">收到时间：</td>
              <td class="form_content">
                                <input type="text" name="receiveTime" id="receiveTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.receiveTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('receiveTime','all')">                                                        
            
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">打开时间：</td>
              <td class="form_content">
                                <input type="text" name="openTime" id="openTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.openTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('openTime','all')">                                                        
            
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">处理完成时间：</td>
              <td class="form_content">
                                <input type="text" name="completeTime" id="completeTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.completeTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('completeTime','all')">                                                        
            
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">创建时间：</td>
              <td class="form_content">
                                <input type="text" name="createTime" id="createTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('createTime','all')">                                                        
            
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">创建用户名：</td>
              <td class="form_content">
                        <form:input path="createUser" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">更新时间：</td>
              <td class="form_content">
                                <input type="text" name="updateTime" id="updateTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('updateTime','all')">                                                        
            
                          </td>                                
            </tr>
                                    <tr class="tr_light">
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