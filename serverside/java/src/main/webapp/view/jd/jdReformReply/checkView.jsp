<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        document.getElementById("hiddenCode").style.display = 'none';

        if (${bean.limitDate==""}|| ${bean.limitDate==undefined} || ${bean.limitDate==null}) {
            document.getElementById("limitTime").innerHTML = "无";
        }
    });

</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <input type="hidden" value="${bean.status}" name="status" id="status"/>
    <input type="hidden" value="${stopFormId}" id="stopFormId" name="stopFormId"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <c:if test="${bean.status!=STATUS_EDIT}">
                <tr class="tr_light">
                    <td class="form_label">回复内容：</td>
                    <td class="form_content">
                            ${bean.replyContent}
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label">回复人：</td>
                    <td class="form_content">
                            ${bean.replyUsername}
                    </td>
                </tr>
            </c:if>
            <tr class="tr_light">
                <td class="form_label">复查意见：</td>
                <td class="form_content">
                    <p id="hiddenCode">
                        <sys:code code="${opinionType}" name="opinion" type="select" defaultName=""
                                  sysCodeDetailId="${bean.opinion.id}" disabled="" id="opinion" isAlowedNull="false"
                                  onChange="changeOpinion()"/></p>
                        ${optionName}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">存在问题：</td>
                <td class="form_content"> ${bean.existQuestion}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">附件：</td>
                <td class="form_content" colspan="4">
                        ${docButton}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">整改期限：</td>
                <td class="form_content" id="limitTime"> ${bean.limitDate}
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label">签发人：</td>
                <td class="form_content">
                        ${bean.signUsername}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">签发日期：</td>
                <td class="form_content">
                        ${bean.signDate}
                </td>
            </tr>

            <tr class="tr_button">
                <td class="form_content" colspan="2" style="text-align: center">
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>