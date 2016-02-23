<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";    
    $(function () {
        //页面验证初始化
        var validateCondition = [
                                                                        //{name:"code", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"servicePerson", rule:"validate[required,maxSize[50]]"},            
                                                                                                      //{name:"thingsName", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"serviceUnit", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"serviceAddress", rule:"validate[required,maxSize[200]]"},            
                                                                                                      //{name:"moemo", rule:"validate[required,maxSize[1000]]"},            
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
        saveAjaxData("${ctx}/serviceReturn/save.do", formId);
    }
    function removeLine(obj){
        $(obj).parent().parent().remove();
    }

    function addLine() {
        var len = findMaxNo("autoNum");//获取总条数+1
        var standTr = new RegExp("standTr_", "g");
        //替换id便于提示
        var autoNumId = new RegExp("autoNum", "g");
        var autoServiceBookId = new RegExp("autoServiceBook", "g");
        var autoServicePersonId = new RegExp("autoServicePerson", "g");
        var autoReceiveDateId = new RegExp("autoReceiveDate", "g");
        var autoReceiveSignId = new RegExp("autoReceiveSign", "g");
        var autoMemoId = new RegExp("autoMemo", "g");

        var stand = $("#standTr").html().replace(standTr, "").replace(autoNumId, "autoNum" + len).replace(autoServiceBookId, "autoServiceBook" + len)
                .replace(autoServicePersonId, "autoServicePerson" + len).replace(autoReceiveDateId, "autoReceiveDate" + len).replace(autoReceiveSignId, "autoReceiveSign" + len)
                .replace(autoMemoId, "autoMemo" + len);
        if (len % 2 == 0) {
            stand = "<tr class='tr_dark'>" + stand + "</tr>";
        } else {
            stand = "<tr class='tr_light'>" + stand + "</tr>";
        }
        $("#testInfo").find("tr:last").after(stand);
        $("#autoNum"+len).val(len);
        return len;
    }

    function findMaxNo(obj) {
        var no = 1;
        $("input[id^='" + obj + "']").each(function () {
                    var temp = $(this).attr("id").replace(obj, "");
                    if ('' != temp || parseInt(temp) >= no) {
                        no = (parseInt(temp) + 1);
                    }
                }
        );
        return no;
    }

</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
              <td class="form_label_right" style="width: 20%">编号：</td>
              <td class="form_content" style="width: 30%">
                  <form:input path="code" cssClass="input_text"/>
              </td>

              <td class="form_label_right" style="width: 20%">受送达人：</td>
              <td class="form_content" style="width: 30%">
                  <form:input path="servicePerson" cssClass="input_text"/>
              </td>
            </tr>

            <tr class="tr_dark">
              <td class="form_label_right">事项名称：</td>
              <td class="form_content">
                  <form:input path="thingsName" cssClass="input_text"/>
              </td>
              <td class="form_label_right">送达单位：</td>
              <td class="form_content">
                  <form:input path="serviceUnit" cssClass="input_text"/>
              </td>
            </tr>

            <tr class="tr_light">
              <td class="form_label_right">送达地点：</td>
              <td class="form_content">
                  <form:input path="serviceAddress" cssClass="input_text"/>
              </td>

            <td class="form_label_right"></td>
              <td class="form_content">
                          </td>                                
            </tr>
            <tr>
                <td colspan="4">
                    <table cellpadding="0" cellspacing="0" class="table_thin_line" name="testInfo" id="testInfo" border="1" style="width: 100%">
                        <tr class="tr_header" >
                            <td style="width: 5%" nowrap="nowrap" ><input type='button'  class='button_select_add'
                                                                  onclick='addLine()' ></td>
                            <td style="width: 15%" nowrap="nowrap">送达文书</td>
                            <td style="width: 15%" nowrap="nowrap">送达人</td>
                            <td style="width: 15%" nowrap="nowrap">收到日期</td>
                            <td style="width: 15%" nowrap="nowrap">收件人签名</td>
                            <td style="width: 15%" nowrap="nowrap">备注</td>
                        </tr>
                        <c:forEach items="${serviceReturnItems}" var="serviceReturnItem" varStatus="status">
                            <tr class="tr_light">
                                <td  style="text-align: center;width: 5%; ">
                                    <input type="text" name="num"
                                           style="border: none;background: transparent;width: 16px; text-align: center"
                                           value="${serviceReturnItem.num}"/>
                                </td>
                                <td  style="text-align: center;width: 15%">
                                    <sys:code code="${SERVICE_BOOK_TYPE}" name="serviceBook" type="select" defaultName=""
                                              style="width: 95%"
                                              sysCodeDetailId="${serviceReturnItem.serviceBookType.id}" disabled=""
                                    isAlowedNull="true" onChange=""/>
                                </td>
                                <td  style="text-align: center;width: 15%">
                                    <input type="text" name="servicePersonSub" class="input_text"
                                           style="width: 95%; text-align: center"
                                           value="${serviceReturnItem.servicePerson}"/>
                                </td>
                                <td  style="text-align: center;width: 15%">
                                    <input type="text" name="receiveDate" id="autoReceiveDate${status.index+1}"
                                           style="width: 95%; text-align: center" class="input_text"
                                           value="${serviceReturnItem.receiveDate}" onclick="calendar('autoReceiveDate${status.index+1}','date')"/>
                                </td>
                                <td  style="text-align: center;width: 15%">
                                    <input type="text" name="receiveSign" class="input_text"
                                           style="width: 95%; text-align: center"
                                           value="${serviceReturnItem.receiveSign}"/>
                                </td>
                                <td  style="text-align: center;width: 15%">
                                    <input type="text" name="memo" class="input_text"
                                           style="width: 95%; text-align: center"
                                           value="${serviceReturnItem.memo}"/>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
                <%--标准行--%>
            <tr style="display: none" id="standTr" ><%--标准行--%>
                <td  nowrap style="width: 5%">
                    <input type='button' value='删除' class='button_select_remove' onclick='removeLine(this)'/>
                    <input type="hidden" name="standTr_num" id="autoNum"/>
                </td>
                <td  style="width: 15%">
                    <sys:code code="${SERVICE_BOOK_TYPE}" name="standTr_serviceBook" type="select" style="width: 95%"
                              disabled="" id="autoServiceBook"
                              isAlowedNull="true" onChange=""/>
                </td>
                <td  style="width: 15%">
                    <input type="text" class="input_text" name="standTr_servicePersonSub"  id="autoServicePerson" style="width: 95%"/>
                </td>
                <td  style="width: 15%">
                    <input type="text"  name="standTr_receiveDate" id="autoReceiveDate" value="" class="input_text"
                           style="width: 95%"
                           onclick="calendar('autoReceiveDate','date')"/>
                </td>
                <td  style="width: 15%">
                    <input type="text"  name="standTr_receiveSign" id="autoReceiveSign" value="" class="input_text"
                           style="width: 95%"/>
                </td>
                <td  style="width: 15%">
                    <input type="text"  name="standTr_memo" id="autoMemo" value="" class="input_text"
                           style="width: 95%"/>
                </td>
            </tr>
                                     
            <tr class="tr_button">
                <td class="form_content" colspan="4" style="text-align: center">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>