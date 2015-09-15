<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var form2Id = "bean2";
    $(function () {
        //页面验证初始化
        var validateCondition = [
//            {name:"zbrSign", rule:"validate[required]"},
//            {name:"zbrTime", rule:"validate[required]"},
//            {name:"ksSign", rule:"validate[required]"},
//            {name:"ksTime", rule:"validate[required]"},
//            {name:"fgldSign", rule:"validate[required]"},
//            {name:"fgldTime", rule:"validate[required]"}
        ];
        validateInit(validateCondition, form2Id);
    });

    //保存操作
    function save(operationId, buttonName) {
        if (!validateForm(form2Id)) {
            return;
        }

        //提交表单
        if (buttonName != "") {
            if (confirm("是否确定执行 " + buttonName + " 操作？")) {
                saveAjaxData("${ctx}/oaReceive/auditSave.do?operationId=" + operationId, form2Id, function () {
                    setTimeout(function () {
                        parent.closeWindow();
                        openWindow("审核收文管理", "${ctx}/oaReceive/auditMain.do?id=${bean2.oaReceive.id}&type=auditMain", true, 850, 500);
                    }, 300);
                });
            }
        }
    }
    function addNb() {
        if (${bean2.oaReceive.step.code=='bmldyj'}) {
            var bljgPersons = $("#bljgPersonsNames").val();
            $("#dealResult").val("阅，请" + bljgPersons + "处理。")
        }
        if (${bean2.oaReceive.step.code=='ldps'}) {
            var dealDepts = $("#dealDeptsNames").val();
            $("#dealResult").val("阅，请" + dealDepts + "领导处理。")
        }
    }

</script>
<style type="text/css">
    .td_border {
        /*border: 1px solid;*/
        border-top-width: 1px;
        border-bottom-width: 1px;
        border-left-width: 1px;
        border-right-width: 1px;
        border-top-style: solid;
        border-bottom-style: solid;
        border-left-style: solid;
        border-right-style: solid;
        border-top-color: #333;
        border-bottom-color: #333;
        border-left-color: #333;
        border-right-color: #333;
    }
</style>
<form:form commandName="bean2">
    <form:hidden path="id"/>
    <form:hidden path="openTime"/>
    <form:hidden path="stepId"/>
    <form:hidden path="dealUser"/>
    <input type="hidden" name="oaReceive" id="oaReceive" value="${bean2.oaReceive.id}">

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table" style="border-collapse: collapse">
            <tr>
                <td class="head_title form_border" colspan="4">上海市交通建设管理中心</td>
            </tr>
            <tr class="tr_dark ">
                <td class="td_border" align="right" width="25%">收到时间：</td>
                <td class="td_border" align="left" width="25%"> &nbsp;
                    <fmt:formatDate value="${bean2.receiveTime}" pattern="yyyy-MM-dd HH:mm"/>
                </td>
                <td class="td_border" align="right" width="25%">打开时间：</td>
                <td class="td_border " align="left" width="25%">  &nbsp;
                    <fmt:formatDate value="${bean2.openTime}" pattern="yyyy-MM-dd HH:mm"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="td_border" align="right"> &nbsp;处理意见：</td>
                <td class="td_border" align="left" colspan="3">
                    <form:textarea path="dealResult"cssClass="input_textarea_long"></form:textarea>
                </td>
            </tr>

            <c:if test="${bean2.oaReceive.step.code=='bmldyj'}">
                <tr class="tr_dark">
                    <td class="td_border" align="right" nowrap> &nbsp;办理结果处理人：</td>
                    <td class="td_border" align="left" colspan="3">
                       <select name="ccUsers" id="ccUsers" size="3" multiple style="width:200px"
                                         class="input_light">
                            <c:forEach var="sysUser" items="${bljgUserHM}">
                                <option value="${sysUser.key}">${sysUser.value}</option>
                            </c:forEach>
                        </select>
                        <img src="${themePath}/workflow/user.gif" alt="请选择办理结果处理人" border="0"
                             style="cursor:pointer"
                             onclick="multiSelectSysUser('ccUsers','bljgPersons','bljgPersonsNames',addNb)">
                        <img src="${themePath}/workflow/file_delete.gif" width="16"
                             height="16" border="0" alt="移除选中人员" align="absbottom"
                             onClick="removeMultiSelectOpt('ccUsers','bljgPersons','bljgPersonsNames')">
                        <input type="hidden" name="bljgPersons" id="bljgPersons"
                               value="${bean.bljgPersons}">
                        <input type="hidden" name="bljgPersonsNames" id="bljgPersonsNames">
                    </td>
                </tr>
            </c:if>

            &nbsp; &nbsp;&nbsp;&nbsp;
            <c:if test="${bean2.oaReceive.step.code=='ldps'}">
                <tr class="tr_dark">
                    <td class="td_border" align="right"> &nbsp;处理部门：</td>
                    <td class="td_border" align="left" colspan="3">
                        <select name="ccDepts" id="ccDepts" size="3" multiple style="width:200px"
                                class="input_light">
                            <c:forEach var="sysDept" items="${sysDeptHM}">
                                <option value="${sysDept.key}">${sysDept.value}</option>
                            </c:forEach>
                        </select>
                        <img src="${themePath}/workflow/dept.gif" alt="请选择处理部门" border="0"
                             style="cursor:pointer"
                             onclick="multiSelectSysDeptOwner('ccDepts','dealDepts','dealDeptsNames',addNb)">
                        <img src="${themePath}/workflow/file_delete.gif" width="16"
                             height="16" border="0" alt="移除选中部门" align="absbottom"
                             onClick="removeMultiSelectOpt('ccDepts','dealDepts','dealDeptsNames')">
                        <input type="hidden" name="dealDepts" id="dealDepts"
                               value="${bean.dealDepts}">
                        <input type="hidden" name="dealDeptsNames" id="dealDeptsNames">
                    </td>
                </tr>
            </c:if>

            <tr class="tr_button">
                <td class="form_border" align="center" colspan="4">
                    <c:forEach items="${operations}" var="operation">
                        <input type="button" value="${operation.name}" class="button_normal_longer"
                               onclick="save('${operation.id}',this.value)">&nbsp;
                    </c:forEach>
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>