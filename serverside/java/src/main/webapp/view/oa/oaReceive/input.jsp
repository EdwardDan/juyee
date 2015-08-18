<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";    
    $(function () {
        //页面验证初始化
        var validateCondition = [
                                                                        //{name:"code", rule:"validate[required,maxSize[100]]"},            
                                                                                                      //{name:"fileCode", rule:"validate[required,maxSize[100]]"},            
                                                                                                      //{name:"title", rule:"validate[required,maxSize[250]]"},            
                                                                                                      //{name:"sourceDept", rule:"validate[required,maxSize[250]]"},            
                                                                                                      //{name:"receiveDate", rule:"validate[required,custom[date],maxSize[7]"},            
                                                                                                      //{name:"deptName", rule:"validate[required,maxSize[100]]"},            
                                                                                                      //{name:"writtenDate", rule:"validate[required,custom[date],maxSize[7]"},            
                                                                                                      //{name:"limitDate", rule:"validate[required,custom[date],maxSize[7]"},            
                                                                                                      //{name:"fs", rule:"validate[required,custom[integer],maxSize[6]"},            
                                                                                                      //{name:"ys", rule:"validate[required,custom[integer],maxSize[6]"},            
                                                                                                      //{name:"startDeptId", rule:"validate[required,custom[integer],maxSize[10]"},            
                                                                                                      //{name:"dealPersons", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"dealDepts", rule:"validate[required,maxSize[200]]"},            
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
        saveAjaxData("${ctx}/oaReceive/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
                                    <tr class="tr_light">
              <td class="form_label">收文编号：</td>
              <td class="form_content">
                        <form:input path="code" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">来文文号：</td>
              <td class="form_content">
                        <form:input path="fileCode" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">标题：</td>
              <td class="form_content">
                        <form:input path="title" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">来文单位：</td>
              <td class="form_content">
                        <form:input path="sourceDept" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">登记日期：</td>
              <td class="form_content">
                                <form:input path="receiveDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('receiveDate');">
                                                 
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">提供部门：</td>
              <td class="form_content">
                        <form:input path="deptName" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">成文日期：</td>
              <td class="form_content">
                                <form:input path="writtenDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('writtenDate');">
                                                 
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">办理时限：</td>
              <td class="form_content">
                                <form:input path="limitDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('limitDate');">
                                                 
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">份数：</td>
              <td class="form_content">
                        <form:input path="fs" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">页数：</td>
              <td class="form_content">
                        <form:input path="ys" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">牵头部门ID：</td>
              <td class="form_content">
                        <form:input path="startDeptId" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">处理人IDs：</td>
              <td class="form_content">
                        <form:input path="dealPersons" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">处理部门IDs：</td>
              <td class="form_content">
                        <form:input path="dealDepts" cssClass="input_text"/>						
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