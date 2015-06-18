<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";    
    $(function () {
        //页面验证初始化
        var validateCondition = [
                                                                        //{name:"beginTime", rule:"validate[required,maxSize[7]]"},            
                                                                                                      //{name:"endTime", rule:"validate[required,maxSize[7]]"},            
                                                                                                      //{name:"address", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"chargePerson", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"startDept", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"leader", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"innerPersons", rule:"validate[required,maxSize[${prop.length}]]"},            
                                                                                                      //{name:"title", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"content", rule:"validate[required,maxSize[${prop.length}]]"},            
                                                                                                      //{name:"relateMatter", rule:"validate[required,maxSize[${prop.length}]]"},            
                                                                                                      //{name:"workAdvise", rule:"validate[required,maxSize[${prop.length}]]"},            
                                                                                                      //{name:"status", rule:"validate[required,custom[integer],maxSize[2]"},            
                                                                                                      //{name:"fgAuditOpinion", rule:"validate[required,maxSize[${prop.length}]]"},            
                                                                                                      //{name:"fgAuditTime", rule:"validate[required,maxSize[7]]"},            
                                                                                                      //{name:"zrAuditOpinion", rule:"validate[required,maxSize[${prop.length}]]"},            
                                                                                                      //{name:"zrAuditTime", rule:"validate[required,maxSize[7]]"},            
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
        saveAjaxData("${ctx}/oaMeetingOuter/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
                                    <tr class="tr_light">
              <td class="form_label">会议开始时间：</td>
              <td class="form_content">
                                <input type="text" name="beginTime" id="beginTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.beginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('beginTime','all')">                                                        
            
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">会议结束时间：</td>
              <td class="form_content">
                                <input type="text" name="endTime" id="endTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('endTime','all')">                                                        
            
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">会议地点：</td>
              <td class="form_content">
                        <form:input path="address" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">主持人：</td>
              <td class="form_content">
                        <form:input path="chargePerson" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">发起单位：</td>
              <td class="form_content">
                        <form:input path="startDept" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">会议领导：</td>
              <td class="form_content">
                        <form:input path="leader" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">与会单位：</td>
              <td class="form_content">
                        <form:input path="innerPersons" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">会议名称：</td>
              <td class="form_content">
                        <form:input path="title" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">会议内容：</td>
              <td class="form_content">
                        <form:input path="content" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">与中心相关事宜：</td>
              <td class="form_content">
                        <form:input path="relateMatter" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">工作建议：</td>
              <td class="form_content">
                        <form:input path="workAdvise" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">状态：</td>
              <td class="form_content">
                        <form:input path="status" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">分管领导审核意见：</td>
              <td class="form_content">
                        <form:input path="fgAuditOpinion" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">分管领导审核时间：</td>
              <td class="form_content">
                                <input type="text" name="fgAuditTime" id="fgAuditTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.fgAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('fgAuditTime','all')">                                                        
            
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">主任审核意见：</td>
              <td class="form_content">
                        <form:input path="zrAuditOpinion" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">主任审核时间：</td>
              <td class="form_content">
                                <input type="text" name="zrAuditTime" id="zrAuditTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.zrAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('zrAuditTime','all')">                                                        
            
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