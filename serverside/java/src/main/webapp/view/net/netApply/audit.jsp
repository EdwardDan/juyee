<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        displayTextarea();
    });
    function displayTextarea() {
        var acceptStatusId = $('input:radio[name="acceptStatusId"]:checked').val();
        if (acceptStatusId == '${statusId2}') {
            $("#fbType").attr("display", "block");
            $("#fbType").css("display", "block");
            $("#bjbhDisplay").attr("display", "block");
            $("#bjbhDisplay").css("display", "block");
        } else {
            $("#fbType").attr("display", "none");
            $("#fbType").css("display", "none");
        }
        if (acceptStatusId == '${statusId3}') {
            $("#backCauseDiv").attr("display", "block");
            $("#backCauseDiv").css("display", "block");
            $("#bjbhDisplay").attr("display", "none");
            $("#bjbhDisplay").css("display", "none");
        } else {
            $("#backCauseDiv").attr("display", "none");
            $("#backCauseDiv").css("display", "none");
        }
    }

    //保存操作
    function save(btn) {
        var acceptDate = $("#acceptDate").val();
        if (acceptDate == null || acceptDate == '') {
            alert("受理日期不能为空！");
            return;
        }

        var chkRadio = $('input:radio[name="acceptStatusId"]:checked').val();
        if (chkRadio == '${statusId3}') {
            if ($("#backCause").val().length < 3) {
                alert("受理意见不能为空！");
                document.getElementById("backCause").focus();
                return;
            }
        }
        if (chkRadio == '${statusId2}') {
            var bjbh = $("#bjbh").val();
            if (bjbh == '' || bjbh == null) {
                alert("报建编号不能为空！");
                document.getElementById("bjbh").focus();
                return;
            }
        }

        //提交表单
        if (confirm("确定要提交吗？")) {
            saveAjaxData("${ctx}/netApply/auditSave.do", formId, null);
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <input type="hidden" name="matterCode" id="matterCode" value="${matterCode}">
    <input type="hidden" name="bizClass" id="bizClass" value="${bizClass}">
    <input type="hidden" name="bizId" id="bizId" value="${bizId}">

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light" id="bjbhDisplay">
                <td class="form_label_right" width="40%">报建编号：</td>
                <td class="form_content">
                    &nbsp;<form:input path="bjbh" cssClass="input_text"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_dark">
                            <td class="form_label_right" width="15%">受理意见：</td>
                            <td class="form_content">
                                <c:forEach items="${nextList}" var="item">
                                    <input type="radio" name="acceptStatusId" value="${item.id}"
                                           <c:if test="${item.id==statusId2}">checked</c:if>
                                           onclick="displayTextarea()">${item.name}
                                </c:forEach>
                            </td>
                            <td class="form_label_right" width="15%">${acceptStatus.label}：</td>
                            <td class="form_content">
                                <input type="text" name="acceptDate" id="acceptDate" class="input_date"
                                       readonly="true" value="${acceptDate}"/>
                                <input type="button" class="button_calendar" value="" onClick="calendar('acceptDate');">
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>

            <tr class="tr_light" id="fbType" style="display: none;" align="center">
                <td width="50%" align="center">
                    <fieldset class="form_fieldset" style="width: 280px;height: 150px">
                        <legend class="form_legend">项目承发包类型和发包方式</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table" style="height: 130px">
                            <c:forEach items="${fbList}" var="item">
                                <tr class="tr_light">
                                    <td class="form_border" width="50%">
                                        <input type="checkbox" name="typeId" value="${item.fb.id}"
                                               <c:if test="${item.isChecked}">checked</c:if>/>${item.fb.name}
                                    </td>
                                    <td class="form_border" width="50%">
                                        <input type="checkbox" name="isBid${item.fb.id}"
                                               <c:if test="${item.isBid}">checked</c:if>/>是否招标
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </fieldset>
                </td>
                <td width="50%" align="center">
                    <fieldset class="form_fieldset" style="width: 280px;height: 150px">
                        <legend class="form_legend">施工图审查</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td class="form_border" align="center" style="height: 130px">
                                    <input type="checkbox" name="isCheckDraw"
                                           <c:if test="${isCheckDraw}">checked</c:if>/>是否需要施工图审查
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>
            <tr class="tr_light" id="backCauseDiv" style="display: none">
                <td class="form_label_right" width="20%">退回原因：</td>
                <td class="form_content">
                    <textarea name="backCause" id="backCause" rows="5" cols="60"
                              class="input_textarea" style="width: 90%;"></textarea>
                </td>
            </tr>
            <tr align="center">
                <td colspan="2" align="center">
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_dark">
                            <td class="form_label_right" width="15%">操作人：</td>
                            <td class="form_content" width="35%">
                                &nbsp;${opPerson}
                            </td>
                            <td class="form_label_right" width="15%">操作日期：</td>
                            <td class="form_content" width="35%">
                                &nbsp;${opDate}
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>

            <tr class="tr_button">
                <td class="form_border" colspan="2" align="center">
                    <input type="button" value="提交" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>