<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "leaderOpinion", rule: "validate[required,maxSize[2000]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(status, buttonName) {
        //判断必输项
        if (status == ${STATUS_PASS}) {
            $("#leaderOpinion").attr("data-validation-engine", "validate[maxSize[2000]]");
        } else if (status == ${STATUS_BACK}) {
            $("#leaderOpinion").attr("data-validation-engine", "validate[required,maxSize[2000]]");
        }
        if (!validateForm(formId)) {
            return;
        }
        //提交表单
        if (status == '${STATUS_PASS}') {
            if (confirm("审核通过后将不能再修改，确定继续吗？")) {
                saveAjaxData("${ctx}/oaQuarterplanSum/auditSave.do?status=" + status, formId);
            }
        }
        if (status == '${STATUS_BACK}') {
            if (confirm("确定要退回修改吗？")) {
                saveAjaxData("${ctx}/oaQuarterplanSum/auditSave.do?status=" + status, formId);
            }
        }
    }

</script>

<form:form commandName="bean">
    <form:hidden path="id"/>
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr height="50">
                <td colspan="2" align="center">
                    <span class="net_form_title">
                        <%--虹口建管署${bean.year}年<c:if test="${not empty bean.period}">第${bean.period}季度</c:if> 主要工作完成--%>
                        虹口建管署${yearPeriodName}主要工作完成
                    </span>
                </td>
            </tr>
            <tr>
                <td>
                    <fieldset class="form_fieldset" style="width: 96%;margin: 0 auto;display: true;">
                        <legend class="form_legend">季度/年度汇总</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table" id="table1">
                            <tr class="tr_dark">
                                <td class="form_label_right" width="15%" nowrap>发布内容：</td>
                                <td class="form_content" nawrap>
                                    ${bean.sumContent}
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <fieldset class="form_fieldset" style="width: 96%;margin: 0 auto;display: true;">
                        <legend class="form_legend">领导审核</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td class="form_label_right" width="15%">领导审核意见：</td>
                                <td class="form_content">
                                    <form:textarea path="leaderOpinion" cssClass="input_textarea_long"
                                                   cssStyle="width: 90%"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>

            <tr class="tr_button" align="center">
                <td class="form_border" colspan="2">
                    <input type="button" value="审核通过" class="button_normal_long"
                           onclick="save('${STATUS_PASS}',this.value)">&nbsp;
                    <input type="button" value="退回修改" class="button_normal_long"
                           onclick="save('${STATUS_BACK}',this.value)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>