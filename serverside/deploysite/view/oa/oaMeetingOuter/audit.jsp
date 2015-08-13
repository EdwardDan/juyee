<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(status, buttonName) {
        if (!validateForm(formId)) {
            return;
        }
        //提交表单
        if (buttonName != "") {
            if (confirm("是否确定执行 " + buttonName + " 操作？")) {
                saveAjaxData("${ctx}/oaMeetingOuter/auditSave.do?status=" + status, formId);
            }
        } else {
            saveAjaxData("${ctx}/oaMeetingOuter/auditSave.do?status=" + status, formId);
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <div class="form_div">
        <fieldset class="form_fieldset">
            <legend class="form_legend">
                外出会议
            </legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label_right" style="width: 150px">会议开始时间：</td>
                    <td class="form_content" colspan="3">
                        <fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${bean.beginTime}"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">会议地点：</td>
                    <td class="form_content" colspan="3">
                            ${bean.address}
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" style="width: 20%">主持人：</td>
                    <td class="form_content" style="width: 30%"> ${bean.chargePerson}
                    </td>
                    <td class="form_label_right" style="width: 20%">发起单位：</td>
                    <td class="form_content"> ${bean.startDept}
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">会议领导：</td>
                    <td class="form_content" colspan="3"> ${bean.leader}
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">与会单位：</td>
                    <td class="form_content" colspan="3"><sys:toHtml>${bean.innerPersons}</sys:toHtml>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">会议名称：</td>
                    <td class="form_content" colspan="3"><sys:toHtml>${bean.title}</sys:toHtml>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">会议内容：</td>
                    <td class="form_content" colspan="3"><sys:toHtml>${bean.content}</sys:toHtml>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">与中心相关事宜：</td>
                    <td class="form_content" colspan="3"><sys:toHtml>${bean.relateMatter}</sys:toHtml>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">工作建议：</td>
                    <td class="form_content" colspan="3"><sys:toHtml>${bean.workAdvise}</sys:toHtml>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">参会科室：</td>
                    <td class="form_content" colspan="3">
                            ${bean.attendDepts}
                    </td>
                <tr class="tr_light">
                    <td class="form_label_right">参会人员：</td>
                    <td class="form_content" colspan="3">
                            ${bean.attendPersons}
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">附件：</td>
                    <td class="form_content" colspan="3">
                            ${docButton}
                    </td>
                </tr>
            </table>
        </fieldset>
        <c:if test="${canEdit_ZR||canEdit_FG}">
            <fieldset class="form_fieldset">
                <legend class="form_legend">分管领导审核</legend>
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%;" nowrap>分管领导审核意见：</td>
                        <td class="form_content">
                            <c:if test="${bean.status == STATUS_SUBMIT}">
                                <form:textarea path="fgAuditOpinion" cssClass="input_textarea_long"/>
                            </c:if>
                            <c:if test="${bean.status==STATUS_BRANCH_PASS||bean.status==STATUS_MAIN_PASS}">
                                <form:hidden path="fgAuditOpinion"/>
                                <sys:toHtml> ${bean.fgAuditOpinion}</sys:toHtml>
                            </c:if>
                        </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset class="form_fieldset">
                <legend class="form_legend">主任审核</legend>
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_light">
                        <c:choose>
                            <c:when test="${bean.status == STATUS_BRANCH_PASS}">
                                <td class="form_label_right" style="width: 15%;" nowrap>主任审核意见：</td>
                                <td class="form_content">
                                    <form:textarea path="zrAuditOpinion" cssClass="input_textarea_long"/>
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td class="form_label_right" style="width: 15%;" nowrap>主任审核意见：</td>
                                <td class="form_content">
                                    <sys:toHtml> ${bean.zrAuditOpinion}</sys:toHtml>
                                </td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </table>
            </fieldset>
        </c:if>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_button">
                <td class="form_content" style="text-align: center">
                    <c:choose>
                        <c:when test="${bean.status == STATUS_SUBMIT}">
                            <input type="button" value="分管领导通过" class="button_normal_longer"
                                   onclick="save('${STATUS_BRANCH_PASS}',this.value)">&nbsp;
                            <input type="button" value="分管领导退回" class="button_normal_longer"
                                   onclick="save('${STATUS_BRANCH_BACK}',this.value)">&nbsp;
                        </c:when>
                        <c:when test="${bean.status == STATUS_BRANCH_PASS}">
                            <input type="button" value="主要领导通过" class="button_normal_longer"
                                   onclick="save('${STATUS_MAIN_PASS}',this.value)">&nbsp;
                            <input type="button" value="主要领导退回" class="button_normal_longer"
                                   onclick="save('${STATUS_MAIN_BACK}',this.value)">&nbsp;
                        </c:when>
                    </c:choose>
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>