<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    function displayTextarea(isPass) {
//        if (isPass == "true") {
//            $("#backCauseDiv").hide();
//        } else {
//            $("#backCauseDiv").show();
//        }
    }

    //保存操作
    function save(btn) {
        if($("#acceptDate").val()==null){
            alert("请输入${nextStep.name}！");
            return;
        }

        var chkRadio = $('input:radio[name="acceptStatusId"]:checked').val();
        if (chkRadio == "0") {
            if($("#backCause").val().length<3){
                alert("受理意见不能为空！");
                document.getElementById("backCause").focus();
                return;
            }
        }

        //提交表单
        if(confirm("确定要提交吗？")){
            saveAjaxData("${ctx}/netCommon/auditSave.do", formId, null);
        }
    }
</script>
<form action="" name="ban" id="bean" method="post">
    <input type="hidden" name="matterCode" id="matterCode" value="${matterCode}">
    <input type="hidden" name="bizClass" id="bizClass" value="${bizClass}">
    <input type="hidden" name="bizId" id="bizId" value="${bizId}">

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr>
                <td>
                    <fieldset class="form_fieldset" style="width: 90%;margin: 0 auto;display: true;">
                        <legend class="form_legend">${nextStep.name}</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td class="form_label_right">${acceptStatus.label}：</td>
                                <td class="form_content" colspan="3">
                                    <input type="text" name="acceptDate" id="acceptDate" class="input_date" readonly="true" value="${acceptDate}"/>
                                    <input type="button" class="button_calendar" value=" "
                                           onClick="calendar('acceptDate');">
                                </td>
                            </tr>
                            <tr class="tr_dark" <c:if test="${nextStep.isShowButton==false}">style="display: none"</c:if>>
                                <td class="form_label_right">受理意见：</td>
                                <td class="form_content" colspan="3">
                                    <table cellpadding="0" cellspacing="0" border="0" width="100%">
                                        <tr>
                                            <td width="30%">
                                                <c:forEach items="${nextList}"
                                                           var="item">
                                                    <input type="radio" name="acceptStatusId" value="${item.id}" <c:if test="${item.isPass==true}">checked</c:if>
                                                           onclick="displayTextarea('${item.isPass}')">${item.name}
                                                    <br><br>
                                                </c:forEach>
                                            </td>
                                            <td width="70%">
                                                <div id="backCauseDiv" style="display: block">
                                                    <textarea name="backCause" id="backCause" rows="5" cols="60"
                                                              class="input_textarea"></textarea>
                                                </div>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" width="20%">操作人：</td>
                                <td class="form_content" width="35%">
                                    ${opPerson}
                                </td>
                                <td class="form_label_right" width="15%">操作日期</td>
                                <td class="form_content" width="35%">
                                    ${opDate}
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_border">
                    <input type="button" value="提交" class="button_confirm"
                           onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>

    </div>
</form>