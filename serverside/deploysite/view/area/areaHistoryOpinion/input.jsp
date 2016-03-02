<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";    
    $(function () {
        //页面验证初始化
        var validateCondition = [
                                                                        //{name:"auditDate", rule:"validate[required,maxSize[7]]"},            
                                                                                                      //{name:"opinion", rule:"validate[required,maxSize[2000]]"},            
                                                                                                      //{name:"status", rule:"validate[required,custom[integer],maxSize[2]"},            
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
        saveAjaxData("${ctx}/areaHistoryOpinion/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
                                    <tr class="tr_light">
              <td class="form_label">审核日期：</td>
              <td class="form_content">
                                <input type="text" name="auditDate" id="auditDate" class="input_datetime"
                           value="<fmt:formatDate value="${bean.auditDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('auditDate','all')">                                                        
            
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">审核意见：</td>
              <td class="form_content">
                        <form:input path="opinion" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">状态：</td>
              <td class="form_content">
                        <form:input path="status" cssClass="input_text"/>						
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