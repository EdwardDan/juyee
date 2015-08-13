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
    function save(btn, status) {
        if (!validateForm(formId)) {
            return;
        }
        //加入其他业务判断
        //修改状态
        if (status == '${STATUS_BRANCH_PASS}') {
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
        } else if (status == '${STATUS_MAIN_PASS}') {
            $("#status").val(status);
            $.messager.confirm('系统提示', "确定审核通过吗？通过后将不能修改", function (r) {
                if (r) {
                    //提交表单
                    saveAjaxData("${ctx}/oaWorkPlan/save.do", formId);
                }
            });
        } else if (status == '${STATUS_MAIN_BACK}') {
            $("#status").val(status);
            $.messager.confirm('系统提示', "确定退回吗？", function (r) {
                if (r) {
                    //提交表单
                    saveAjaxData("${ctx}/oaWorkPlan/save.do", formId);
                }
            });
        } else {
            $("#status").val(status);
            //提交表单
            saveAjaxData("${ctx}/oaWorkPlan/save.do", formId);
        }

    }
    $(function () {
        if (${bean.status==STATUS_BRANCH_PASS}) {
                $("#kzOpinion").attr("readOnly",true);
            }
    })
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="status"/>
    <form:hidden path="reportDept"/>
    <form:hidden path="reportPerson"/>
    <form:hidden path="beginDate"/>
    <form:hidden path="endDate"/>
    <div class="form_div">
        <fieldset class="form_fieldset">
            <legend class="form_legend">
                一周工作安排
            </legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label_right">上报科室：</td>
                    <td class="form_content">${bean.reportDept}</td>
                    <td class="form_label_right">上报人：</td>
                    <td class="form_content">${bean.reportPerson}</td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" style="width: 150px">上报时间：</td>
                    <td class="form_content" colspan="3">${bean.beginDate} ~${bean.endDate}
                    </td>
                </tr>
            </table>
            <table cellpadding="0" cellspacing="0" border="1" class="table_thin_line"
                   style="text-align: center;"
                   id="itemTable">
                <tr class="tr_header">
                    <td style="width:5%">序号</td>
                    <td style="width:8%">责任人</td>
                    <td style="width:8%">是否重点工作</td>
                    <td style="width:25%">工作内容</td>
                    <td style="width:20%">工作进度</td>
                    <td style="width:10%">经办人</td>
                    <c:if test="${empty oaWorkPlanItems !=null}">
                    <c:forEach items="${oaWorkPlanItems}" var="item">
                <tr class="tr_light">
                    <td class="form_content" style="text-align: center">
                            ${item.orderNo}
                                <input type="hidden" name="orderNo"  value="${item.orderNo}">
                    </td>

                    <td class="form_content">
                            ${item.dutyPerosn}
                                <input type="hidden" name="dutyPerosn"  value="${item.dutyPerosn}">
                    </td>

                    <td class="form_content">
                            ${item.keyWork}
                                <input type="hidden" name="keyWork" value="${item.keyWork}">
                    </td>
                    <td class="form_content">
                            ${item.content}
                                <input type="hidden" name="content"  value="${item.content}">
                    </td>
                    <td class="form_content">
                            ${item.schedule}
                                <input type="hidden" name="schedule"  value="${item.schedule}">
                    </td>
                    <td class="form_content">
                            ${item.jbr}
                                <input type="hidden" name="jbr"  value="${item.jbr}">
                    </td>
                </tr>
                </c:forEach>
                </c:if>
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
                            <textarea name="kzOpinion" id="kzOpinion"  class="input_textarea_long">${bean.kzOpinion}</textarea>
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