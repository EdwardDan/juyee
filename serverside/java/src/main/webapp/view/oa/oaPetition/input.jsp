<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";    
    $(function () {
        //页面验证初始化
        var validateCondition = [
                                                                        //{name:"code", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"statusDesc", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"sourceDesc", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"typeDesc", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"person", rule:"validate[required,maxSize[500]]"},            
                                                                                                      //{name:"tel", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"receiveDate", rule:"validate[required,custom[date],maxSize[7]"},            
                                                                                                      //{name:"address", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"jbrName", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"endDate", rule:"validate[required,custom[date],maxSize[7]"},            
                                                                                                      //{name:"content", rule:"validate[required,maxSize[${prop.length}]]"},            
                                                                                                      //{name:"dealResult", rule:"validate[required,maxSize[${prop.length}]]"},            
                                                                                                      //{name:"description", rule:"validate[required,maxSize[${prop.length}]]"},            
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
        saveAjaxData("${ctx}/oaPetition/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
                                    <tr class="tr_light">
              <td class="form_label">受理编号：</td>
              <td class="form_content">
                        <form:input path="code" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">受理状态中文描述：</td>
              <td class="form_content">
                        <form:input path="statusDesc" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">信访来源中文描述：</td>
              <td class="form_content">
                        <form:input path="sourceDesc" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">信访种类中文描述：</td>
              <td class="form_content">
                        <form:input path="typeDesc" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">信访人：</td>
              <td class="form_content">
                        <form:input path="person" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">联系电话：</td>
              <td class="form_content">
                        <form:input path="tel" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">收信日期：</td>
              <td class="form_content">
                                <form:input path="receiveDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('receiveDate');">
                                                 
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">联系地址：</td>
              <td class="form_content">
                        <form:input path="address" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">经办人姓名(冗余)：</td>
              <td class="form_content">
                        <form:input path="jbrName" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">结案日期：</td>
              <td class="form_content">
                                <form:input path="endDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('endDate');">
                                                 
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">信访事由：</td>
              <td class="form_content">
                        <form:input path="content" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">处理结果：</td>
              <td class="form_content">
                        <form:input path="dealResult" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">备注：</td>
              <td class="form_content">
                        <form:input path="description" cssClass="input_text"/>						
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