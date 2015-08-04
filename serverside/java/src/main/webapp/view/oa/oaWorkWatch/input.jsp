<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";    
    $(function () {
        //页面验证初始化
        var validateCondition = [
                                                                        //{name:"reportDept", rule:"validate[required,maxSize[100]]"},            
                                                                                                      //{name:"reportUser", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"reportPerson", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"beginDate", rule:"validate[required,custom[integer],maxSize[4]"},            
                                                                                                      //{name:"endDate", rule:"validate[required,custom[integer],maxSize[2]"},            
                                                                                                      //{name:"documentId", rule:"validate[required,custom[integer],maxSize[10]"},            
                                                                                                      //{name:"status", rule:"validate[required,custom[integer],maxSize[2]"},            
                                                                                                      //{name:"zrOpinion", rule:"validate[required,maxSize[${prop.length}]]"},            
                                                                                                      //{name:"zrAuditTime", rule:"validate[required,maxSize[7]]"},            
                                                                                                      //{name:"zrAuditUser", rule:"validate[required,maxSize[100]]"},            
                                                                                                      //{name:"kzOpinion", rule:"validate[required,maxSize[${prop.length}]]"},            
                                                                                                      //{name:"kzAuditTime", rule:"validate[required,maxSize[7]]"},            
                                                                                                      //{name:"kzAuditUser", rule:"validate[required,maxSize[100]]"},            
                                                                                                      //{name:"bgsOpinion", rule:"validate[required,maxSize[${prop.length}]]"},            
                                                                                                      //{name:"bgsAuditTime", rule:"validate[required,maxSize[7]]"},            
                                                                                                      //{name:"bgsAuditUser", rule:"validate[required,maxSize[100]]"},            
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
        saveAjaxData("${ctx}/oaWorkWatch/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
                                    <tr class="tr_light">
              <td class="form_label">上报科室：</td>
              <td class="form_content">
                        <form:input path="reportDept" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">上报人用户名：</td>
              <td class="form_content">
                        <form:input path="reportUser" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">科室分管领导：</td>
              <td class="form_content">
                        <form:input path="reportPerson" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">上报开始时间：</td>
              <td class="form_content">
                        <form:input path="beginDate" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">上报结束时间：</td>
              <td class="form_content">
                        <form:input path="endDate" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">附件ID(预留)：</td>
              <td class="form_content">
                        <form:input path="documentId" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">状态：</td>
              <td class="form_content">
                        <form:input path="status" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">主任审核意见：</td>
              <td class="form_content">
                        <form:input path="zrOpinion" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">主任审核时间：</td>
              <td class="form_content">
                                <input type="text" name="zrAuditTime" id="zrAuditTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.zrAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('zrAuditTime','all')">                                                        
            
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">主任审核用户名：</td>
              <td class="form_content">
                        <form:input path="zrAuditUser" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">科长审核意见：</td>
              <td class="form_content">
                        <form:input path="kzOpinion" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">科长审核时间：</td>
              <td class="form_content">
                                <input type="text" name="kzAuditTime" id="kzAuditTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.kzAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('kzAuditTime','all')">                                                        
            
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">科长审核用户名：</td>
              <td class="form_content">
                        <form:input path="kzAuditUser" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">办公室审核意见：</td>
              <td class="form_content">
                        <form:input path="bgsOpinion" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">办公室审核时间：</td>
              <td class="form_content">
                                <input type="text" name="bgsAuditTime" id="bgsAuditTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.bgsAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('bgsAuditTime','all')">                                                        
            
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">办公室审核用户名：</td>
              <td class="form_content">
                        <form:input path="bgsAuditUser" cssClass="input_text"/>						
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