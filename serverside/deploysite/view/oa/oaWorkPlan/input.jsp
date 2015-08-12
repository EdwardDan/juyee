<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "reportDept", rule: "validate[required,maxSize[100]]"},
            {name: "reportPerson", rule: "validate[required,maxSize[50]]"},
            {name: "beginDate", rule: "validate[required]"},
            {name: "endDate", rule: "validate[required]"},
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn,status) {
        if (!validateForm(formId)) {
            return;
        }
        var beginDate = $("#beginDate").val() + ":00";
        var endDate = $("#endDate").val() + ":00";
        var d1 = new Date(beginDate.replace(/\-/g, "\/"));
        var d2 = new Date(endDate.replace(/\-/g, "\/"));

        if (beginDate != "" && endDate != "" && d1 >= d2) {
            alert("开始时间不能大于结束时间！");
            $("#beginDate").focus();
            $("#beginDate").css("background", "red");
            $("#endDate").css("background", "red");
            return;
        }

        //防止新增时直接保存出错
        if ($("#tableWorkPlanItemDiv").html() == '' && ${fn:length(oaWorkPlanItems)==0}) {
            showInfoMsg("请添加记录！");
            return;
        }
        //加入其他业务判断
        //修改状态
        if (status == '${STATUS_SUBMIT}') {
            $("#status").val(status);

            $.messager.confirm('系统提示', "确定提交吗？提交后将不能修改！", function (r) {
                if (r) {
                    //提交表单
                    saveAjaxData("${ctx}/oaWorkPlan/save.do", formId);
                }
            });
        } else if (status == '${STATUS_BRANCH_PASS}') {
            $("#status").val(status);
            $.messager.confirm('系统提示', "确定审核通过吗？通过后将不能修改", function (r) {
                if (r) {
                    //提交表单
                    saveAjaxData("${ctx}/oaWorkPlan/save.do", formId);
                }
            });
        } else if (status == '${STATUS_BRANCH_BACK}') {
            $("#status").val(status);
            $.messager.confirm('系统提示', "确定退回吗？", function (r) {
                if (r) {
                    //提交表单
                    saveAjaxData("${ctx}/oaWorkPlan/save.do", formId);
                }
            });
        }else if (status == '${STATUS_MAIN_PASS}') {
            $("#status").val(status);
            $.messager.confirm('系统提示', "确定审核通过吗？通过后将不能修改", function (r) {
                if (r) {
                    //提交表单
                    saveAjaxData("${ctx}/oaWorkPlan/save.do", formId);
                }
            });
        }else if (status == '${STATUS_MAIN_BACK}') {
            $("#status").val(status);
            $.messager.confirm('系统提示', "确定退回吗？", function (r) {
                if (r) {
                    //提交表单
                    saveAjaxData("${ctx}/oaWorkPlan/save.do", formId);
                }
            });
        }else{
            $("#status").val(status);
            //提交表单
            saveAjaxData("${ctx}/oaWorkPlan/save.do", formId);
        }

    }
    function addLine(obj) {
        if (obj.value == "添加") {
            $("#tableWorkPlanItemDiv").append($("#hiddenStyle").html());
        } else {
            if (confirm("确定要删除吗!")) {
                var trObj = obj.parentNode.parentNode;
                trObj.parentElement.removeChild(trObj);
            }
        }
    }
</script>
<style type="text/css">
    .addTd{
        border: 1px solid;
    }
</style>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="status"/>
    <form:hidden path="reportDept"/>
    <form:hidden path="reportPerson"/>
    <div class="form_div">
        <fieldset class="form_fieldset">
            <legend class="form_legend">
                一周工作安排
            </legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_border" align="center" colspan="3">上报科室：${bean.reportDept}
                        <%--<input type="text" name="reportDept" id="reportDept" class="input_text"--%>
                               <%--value="${bean.reportDept}" readonly="true"/>--%>
                        <%--<input type="hidden" name="applyDeptId" id="applyDeptId" value=""/>--%>
                        <%--<input type="button" value=" " class="button_select"--%>
                               <%--onclick="selectSysDept('applyDeptId','reportDept')" title="点击选择上报科室">--%>
                    </td>
                    <td class="form_border" align="center" colspan="4">上报人：${bean.reportPerson}
                        <%--<input type="text" name="reportPerson" id="reportPerson" class="input_text"--%>
                               <%--value="${bean.reportPerson}" readonly="true"/>--%>
                        <%--<input type="hidden" name="applyPersonId" id="applyPersonId" value="${applyPersonId}"/>--%>
                        <%--<input type="button" value=" " class="button_select"--%>
                               <%--onclick="selectSysUser('applyPersonId','reportPerson');" title="点击上报人">--%>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_border" align="left" colspan="7">上报时间：
                        <input type="text" name="beginDate" id="beginDate" class="input_date"
                               value="<fmt:formatDate value="${bean.beginDate}" pattern="yyyy-MM-dd"/>"
                               readonly="true"/>
                        <input type="button" class="button_calendar" value=" "
                               onClick="calendar('beginDate','beginDate')">
                        ~
                        <input type="text" name="endDate" id="endDate" class="input_date"
                               value="<fmt:formatDate value="${bean.endDate}" pattern="yyyy-MM-dd"/>"
                               readonly="true"/>
                        <input type="button" class="button_calendar" value=" " onClick="calendar('endDate','endDate')">
                    </td>
                </tr>
                <tr class="tr_header">
                    <td class="addTd" width="5%">序号</td>
                    <td class="addTd" width="10%">责任人</td>
                    <td class="addTd" width="25%">重点工作</td>
                    <td class="addTd" width="25%">工作内容</td>
                    <td class="addTd" width="20%">工作进度</td>
                    <td class="addTd" width="10%">经办人</td>
                    <td class="addTd" width="5%" nowrap>
                        &nbsp;<input type="button" value="添加" class="button_select_add" onclick="addLine(this)"/>
                    </td>
                </tr>

                <c:if test="${empty oaWorkPlanItems !=null}">
                <c:forEach items="${oaWorkPlanItems}" var="item">
                <tr class="tr_dark">
                    <td class="addTd">
                        <input type="text" name="orderNo" class="input_text" style="width: 95%"
                               value="${item.orderNo}"
                               title="${item.orderNo}">
                    </td>

                    <td class="addTd">
                        <input type="text" name="dutyPerosn" class="input_text" style="width: 95%"
                               value="${item.dutyPerosn}"
                               title="${item.dutyPerosn}">
                    </td>

                    <td class="addTd">
                        <input type="text" name="keyWork" class="input_text" style="width: 95%" value="${item.keyWork}"
                               title="${item.keyWork}">
                    </td>
                    <td class="addTd">
                        <input type="textarea" name="content" class="input_textarea" style="width: 95%" value="${item.content}"
                               title="${item.content}">
                    </td>
                    <td class="addTd">
                        <input type="textarea" name="schedule" class="input_textarea" style="width: 95%"
                               value="${item.schedule}"
                               title="${item.schedule}">
                    </td>
                    <td class="addTd">
                        <input type="text" name="jbr" class="input_text" style="width: 95%" value="${item.jbr}"
                               title="${item.jbr}">
                    </td>
                    <td class="addTd"><input type="button" value="删除" class="button_select_remove"
                                             onclick="addLine(this)"/>
                    </td>
                </tr>
                </c:forEach>
                </c:if>
                <tbody id="tableWorkPlanItemDiv"></tbody>
                    <%--标准行迁入--%>
            </table>
        </fieldset>
        <c:if test="${bean.status==STATUS_SUBMIT|| bean.status==STATUS_BRANCH_PASS||bean.status==STATUS_MAIN_PASS}">
            <fieldset class="form_fieldset">
                <legend class="form_legend">
                    科长审核
                </legend>
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_dark">
                        <td class="form_label_right" width="15%">审核意见：</td>
                        <td class="form_content" colspan="3">
                            <form:textarea path="kzOpinion" cssClass="input_textarea_long"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </c:if>
        <c:if test="${bean.status==STATUS_BRANCH_PASS||bean.status==STATUS_MAIN_PASS}">
            <fieldset class="form_fieldset">
                <legend class="form_legend">
                    分管领导审核
                </legend>
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_dark">
                        <td class="form_label_right" width="15%">审核意见：</td>
                        <td class="form_content" colspan="3">
                            <form:textarea path="fgOpinion" cssClass="input_textarea_long"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </c:if>

        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_button">
                <td class="form_content" style="text-align: center">
                    <c:if test="${canEdit||canEdit_KZ||canEdit_FG}">
                        <c:if test="${empty bean.status|| STATUS_EDIT ==bean.status|| STATUS_BRANCH_BACK ==bean.status|| STATUS_MAIN_BACK ==bean.status}">
                            <input type="button" value="提交" class="button_confirm"
                                   onclick="save(this,'${STATUS_SUBMIT}')">&nbsp;
                            <input type="button" value="保存" class="button_confirm"
                                   onclick="save(this,'${STATUS_EDIT}')">&nbsp;
                        </c:if>
                    </c:if>
                    <c:if test="${canEdit_KZ}">
                        <c:if test="${STATUS_SUBMIT ==bean.status}">
                            <input type="button" value="审核通过" class="button_normal_long"
                                   onclick="save(this,'${STATUS_BRANCH_PASS}')">&nbsp;
                            <input type="button" value="退回修改" class="button_normal_long"
                                   onclick="save(this,'${STATUS_BRANCH_BACK}')">&nbsp;
                        </c:if>
                    </c:if>

                    <c:if test="${canEdit_FG}">
                        <c:if test="${STATUS_BRANCH_PASS ==bean.status}">
                            <input type="button" value="审核通过" class="button_normal_long"
                                   onclick="save(this,'${STATUS_MAIN_PASS}')">&nbsp;
                            <input type="button" value="退回修改" class="button_normal_long"
                                   onclick="save(this,'${STATUS_MAIN_BACK}')">&nbsp;
                        </c:if>
                    </c:if>
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>
<table style="display: none;" cellpadding="0" cellspacing="0" class="form_table" border="0">
    <tbody id="hiddenStyle">
    <tr class="tr_dark"><%--标准行--%>
        <td class="addTd">
            <input type="text" name="orderNo" class="input_text" style="width: 95%"/>
        </td>
        <td class="addTd">
            <input type="text" name="dutyPerosn" class="input_text" style="width: 95%"/>
        </td>
        <td class="addTd">
            <input type="text"  name="keyWork" class="input_text" style="width: 95%"/>
        </td>
        <td class="addTd">
            <textarea  name="content" class="input_textarea" style="width: 95%"></textarea>
        </td>
        <td class="addTd">
            <textarea name="schedule" class="input_textarea" style="width: 95%"></textarea>
        </td>
        <td class="addTd">
            <input type="text" name="jbr" class="input_text" style="width: 95%" />
        </td>
        <td class="addTd"><input type="button" value="删除" class="button_select_remove"
                                 onclick="addLine(this)"/></td>
    </tr>
    </tbody>
</table>