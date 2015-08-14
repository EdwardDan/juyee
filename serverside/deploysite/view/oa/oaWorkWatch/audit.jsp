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
        $("#standTr").remove();
        $("#status").val(status);
        $("select[name='actualDesc']").each(function () {
            $(this).get(0).disabled = false;
        });
        //提交表单
        if (buttonName != "") {
            if (confirm("是否确定执行 " + buttonName + " 操作？")) {
                saveAjaxData("${ctx}/oaWorkWatch/saveAudit.do?status=" + status, formId);
            }
        } else {
            saveAjaxData("${ctx}/oaWorkWatch/saveAudit.do?status=" + status, formId);
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right" style="width: 15%;">上报科室：</td>
                <td class="form_content" style="width: 35%;">
                        ${bean.reportDept}
                </td>
                <td class="form_label_right" style="width: 15%;">分管领导：</td>
                <td class="form_content" style="width: 35%;">
                        ${bean.reportPerson}
                </td>
            </tr>
        </table>
        <table cellpadding="0" cellspacing="0" border="1" class="table_thin_line"
               style="text-align: center;width: 98%;">
            <tr class="tr_header">
                <td style="width: 5%;">序号</td>
                <td style="width: 25%;">工作内容</td>
                <td style="width: 8%;">时间节点</td>
                <td style="width: 8%;">上报形式</td>
                <td style="width: 20%;;">完成情况</td>
                <td style="width: 10%;">审核情况</td>
            </tr>
            <c:forEach items="${bean.oaWorkWatchItems}" var="item">
                <tr class="tr_light">
                    <td>${item.orderNo}</td>
                    <td style="text-align: left;"><sys:toHtml>${item.content}</sys:toHtml></td>
                    <td>${item.timeNode}</td>
                    <td>${item.reportMethod}</td>
                    <td style="text-align: left;"><sys:toHtml>${item.completeDesc}</sys:toHtml></td>
                    <td>
                        <c:if test="${item.actualDesc ==''}"></c:if>
                        <c:if test="${item.actualDesc =='1'}">属实</c:if>
                        <c:if test="${item.actualDesc =='0'}">不属实</c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <c:if test="${bean.status == STATUS_SUBMIT}">
            <div style="height: 10px"></div>
            <fieldset class="form_fieldset" style="width: 96%;">
                <legend class="form_legend">
                    主任审核
                </legend>
                <table cellpadding="0" cellspacing="0" class="form_table" style="text-align: center">
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%;">
                            审核意见：
                        </td>
                        <td class="form_content">
                            <form:textarea path="zrOpinion" cssclass="input_textarea_long" cssStyle="width: 96%;"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </c:if>

        <table cellpadding="0" cellspacing="0" class="form_table" style="text-align: center">
            <tr class="tr_button">
                <td style="text-align: center">
                    <c:if test="${bean.status == STATUS_SUBMIT}">
                        <input type="button" value="审核通过" class="button_normal_long"
                               onclick="save('${STATUS_ZR_PASS}',this.value)">&nbsp;
                        <input type="button" value="审核退回" class="button_normal_long"
                               onclick="save('${STATUS_ZR_BACK}',this.value)">&nbsp;
                    </c:if>
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>