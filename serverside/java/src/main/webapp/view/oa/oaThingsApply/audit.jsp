<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(status, btn) {
        //判断必输项
        if (status == ${STATUS_BRANCH_BACK} && $("#kzAuditOpinion").val() == '') {
            alert("退回修改需要填写审核意见！");
            return;
        }
        if (status == ${STATUS_MAIN_BACK} && $("#zrAuditOpinion").val() == '') {
            alert("退回修改需要填写审核意见！");
            return;
        }
        if (!validateForm(formId)) {
            return;
        }
        //提交表单
        if (status == '${STATUS_BRANCH_PASS}' || status == '${STATUS_MAIN_PASS}') {
            if (confirm("审核通过后将不能再修改，确定继续吗？")) {
                saveAjaxData("${ctx}/oaThingsApply/saveAudit.do?status=" + status, formId);
            }
        }
        if (status == '${STATUS_BRANCH_BACK}' || status == '${STATUS_MAIN_BACK}') {
            if (confirm("确定要退回修改吗？")) {
                saveAjaxData("${ctx}/oaThingsApply/saveAudit.do?status=" + status, formId);
            }
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <table cellpadding="0" cellspacing="0" class="form_table" border="0">
        <tr class="tr_title">
            <td>办公用品申请</td>
        </tr>
    </table>
    <fieldset class="form_fieldset">
        <legend class="form_legend">申请信息</legend>
        <table cellpadding="0" cellspacing="0" class="form_table" border="1">
            <tr class="tr_dark">
                <td class="form_border" align="center" colspan="2">申请部门： ${bean.applyDept.name}
                </td>
                <td class="form_border" align="center" colspan="3">申请人：${bean.applyUser.displayName}
                </td>
            </tr>
            <tr class="tr_header">
                <td width="8%">申请物品</td>
                <td width="8%">型号</td>
                <td width="9%">单位</td>
                <td width="8%">预计单价</td>
                <td width="8%">数量</td>
            </tr>
            <c:if test="${not empty bean.oaThingsApplyItems && bean.oaThingsApplyItems != null}">
                <c:forEach items="${bean.oaThingsApplyItems}" var="item">
                    <tr class="tr_dark">
                        <td>${item.name}</td>
                        <td>${item.model}</td>
                        <td>${item.unit}</td>
                        <td><span name="price">${item.price}</span></td>
                        <td><span name="amount">${item.amount}</span></td>
                    </tr>
                </c:forEach>
            </c:if>
            <tr class="tr_dark">
                <td colspan="3" align="right"><b>预计总价</b></td>
                <td colspan="2" align="left">${count}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">申请说明：</td>
                <td class="form_content" colspan="4"><sys:toHtml>${bean.applyContent}</sys:toHtml>
                </td>
            </tr>
        </table>
    </fieldset>
    <fieldset class="form_fieldset">
    <legend class="form_legend">科长审核</legend>
    <table cellpadding="0" cellspacing="0" class="form_table" border="0">
            <tr class="tr_light">
                <td class="form_label_right" width="20%">科长审核意见：</td>
                <td class="form_content" width="80%">
                    <c:if test="${auditKZ&&bean.status==STATUS_SUBMIT}">
                    <form:textarea path="kzAuditOpinion" cssClass="input_textarea_long"/>
                    </c:if>
                    <c:if test="${auditZR&&bean.status==STATUS_BRANCH_PASS}">
                        <form:hidden path="kzAuditOpinion"/>
                        <sys:toHtml>${bean.kzAuditOpinion}</sys:toHtml>
                    </c:if>
                </td>
            </tr>
    </table>
    </fieldset>
    <c:if test="${auditZR&&bean.status==STATUS_BRANCH_PASS}">
    <fieldset class="form_fieldset">
        <legend class="form_legend">办公室主任审核</legend>
        <table cellpadding="0" cellspacing="0" class="form_table" border="0">
            <tr class="tr_light">
                <td class="form_label_right" width="20%">办公室主任&nbsp; <br>审核意见：</td>
                <td class="form_content" width="80%">
                    <form:textarea path="zrAuditOpinion" cssClass="input_textarea_long"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">办公室处理人员：</td>
                <td class="form_content">
                    <input type="text" name="dealUserName" id="dealUserName" value="${bean.dealUser.displayName}"
                           class="input_text" readonly="true">
                    <input type="hidden" name="dealUser" id="dealUser" value="${bean.dealUser.id}">
                    <img src="${themePath}/workflow/user.gif" alt="" border="0"
                         onclick="selectSysUser('dealUser','dealUserName')">
                </td>
            </tr>
    </table>
    </fieldset>
    </c:if>
    <div class="tr_button" style="text-align: center">
        <c:choose>
            <c:when test="${bean.status == STATUS_SUBMIT}">
                <input type="button" value="审核通过" class="button_normal_long"
                       onclick="save('${STATUS_BRANCH_PASS}',this.value)">&nbsp;
                <input type="button" value="退回修改" class="button_normal_long"
                       onclick="save('${STATUS_BRANCH_BACK}',this.value)">&nbsp;
            </c:when>
            <c:when test="${bean.status == STATUS_BRANCH_PASS}">
                <input type="button" value="审核通过" class="button_normal_long"
                       onclick="save('${STATUS_MAIN_PASS}',this.value)">&nbsp;
                <input type="button" value="退回修改" class="button_normal_long"
                       onclick="save('${STATUS_MAIN_BACK}',this.value)">&nbsp;
            </c:when>
        </c:choose>
        <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
    </div>
</form:form>

