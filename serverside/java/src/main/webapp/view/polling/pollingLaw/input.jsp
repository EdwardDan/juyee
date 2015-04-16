<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";    
    $(function () {
        //页面验证初始化
        var validateCondition = [
                                                                        //{name:"stddocid", rule:"validate[required,custom[integer],maxSize[10]"},            
                                                                                                      //{name:"catalog", rule:"validate[required,maxSize[500]]"},            
                                                                                                      //{name:"descriptions", rule:"validate[required,maxSize[${prop.length}]]"},            
                                                                                                      //{name:"tksm", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"tkbh", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"lx", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"jdfl", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"iitemno", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"type", rule:"validate[required,custom[integer],maxSize[5]"},            
                                                                                                      //{name:"shotdes", rule:"validate[required,maxSize[${prop.length}]]"},            
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
        saveAjaxData("${ctx}/pollingLaw/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
                                    <tr class="tr_light">
              <td class="form_label">关联字段ID：</td>
              <td class="form_content">
                        <form:input path="stddocid" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">条款编号：</td>
              <td class="form_content">
                        <form:input path="catalog" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">条款内容：</td>
              <td class="form_content">
                        <form:input path="descriptions" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">标准名称：</td>
              <td class="form_content">
                        <form:input path="tksm" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">标准编号：</td>
              <td class="form_content">
                        <form:input path="tkbh" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">分类：</td>
              <td class="form_content">
                        <form:input path="lx" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">监督分类：</td>
              <td class="form_content">
                        <form:input path="jdfl" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">序号：</td>
              <td class="form_content">
                        <form:input path="iitemno" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">类型：</td>
              <td class="form_content">
                        <form:input path="type" cssClass="input_text"/>						
                          </td>                                
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">条款简述：</td>
              <td class="form_content">
                        <form:input path="shotdes" cssClass="input_text"/>						
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