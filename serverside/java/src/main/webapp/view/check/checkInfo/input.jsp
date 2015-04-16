<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
                                                                        //{name:"managerName", rule:"validate[required,maxSize[50]]"},
                                                                                                      //{name:"cardNo", rule:"validate[required,maxSize[50]]"},
                                                                                                      //{name:"checkTime", rule:"validate[required,maxSize[19]]"},
                                                                                                      //{name:"gdCode", rule:"validate[required,maxSize[50]]"},
                                                                                                      //{name:"devSn", rule:"validate[required,maxSize[50]]"},
                                                                                                      //{name:"checkStatus", rule:"validate[required,maxSize[10]]"},
                                                                                                      //{name:"verifyCode", rule:"validate[required,maxSize[10]]"},
                                                                                                      //{name:"longitude", rule:"validate[required,custom[number],maxSize[18]"},
                                                                                                      //{name:"latitude", rule:"validate[required,custom[number],maxSize[18]"},
                                                                                                      //{name:"positionTime", rule:"validate[required,maxSize[19]]"},
                                                                                                      //{name:"guid", rule:"validate[required,maxSize[50]]"},
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
        saveAjaxData("${ctx}/checkInfo/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
                                    <tr class="tr_light">
              <td class="form_label">人员姓名：</td>
              <td class="form_content">
                        <form:input path="managerName" cssClass="input_text"/>
                          </td>
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">身份证号：</td>
              <td class="form_content">
                        <form:input path="cardNo" cssClass="input_text"/>
                          </td>
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">考勤时间：</td>
              <td class="form_content">
                                <input type="text" name="checkTime" id="checkTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.checkTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('checkTime','all')">

                          </td>
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">工地编号：</td>
              <td class="form_content">
                        <form:input path="gdCode" cssClass="input_text"/>
                          </td>
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">设备序号：</td>
              <td class="form_content">
                        <form:input path="devSn" cssClass="input_text"/>
                          </td>
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">考勤状态（上班、下班）：</td>
              <td class="form_content">
                        <form:input path="checkStatus" cssClass="input_text"/>
                          </td>
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">识别标识（指纹、卡、指纹+面部）：</td>
              <td class="form_content">
                        <form:input path="verifyCode" cssClass="input_text"/>
                          </td>
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">经度：</td>
              <td class="form_content">
                        <form:input path="longitude" cssClass="input_text"/>
                          </td>
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">纬度：</td>
              <td class="form_content">
                        <form:input path="latitude" cssClass="input_text"/>
                          </td>
            </tr>
                                                <tr class="tr_dark">
              <td class="form_label">定位时间：</td>
              <td class="form_content">
                                <input type="text" name="positionTime" id="positionTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.positionTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('positionTime','all')">

                          </td>
            </tr>
                                    <tr class="tr_light">
              <td class="form_label">GUID：</td>
              <td class="form_content">
                        <form:input path="guid" cssClass="input_text"/>
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