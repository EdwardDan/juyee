<%--
  Created by IntelliJ IDEA.
  User: 黄国荣
  Date: 2014/4/28
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "reportDept", rule: "validate[required,maxSize[50]]"},
            {name: "reportPerson", rule: "validate[required,maxSize[25]]"},
            {name: "year", rule: "validate[required,custom[integer],maxSize[4]"},
            {name: "period", rule: "validate[required,custom[integer],maxSize[2]"},
//         {name:"content", rule:"validate[required,maxSize[1000]]"},
//           {name:"timeNode", rule:"validate[required,custom[date],maxSize[20]]"},
//         {name:"reportType", rule:"validate[required]"},
//            {name:"isComplete", rule:"validate[required]"},
            //     {name: "fgOpinion", rule: "validate[required,maxSize[1000]]"},
            {name: "fgAuditTime", rule: "validate[required,maxSize[20]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(status, buttonName) {
        if (!validateForm(formId)) {
            return;
        }

        if (buttonName == "退回修改") {
            var fgOpinion = $("#fgOpinion").val();
            if (fgOpinion == '') {
                showInfoMsg("审核意见不为空！");
                return;
            }

        }

        //提交表单
        if (buttonName != "") {
            if (confirm("审核通过后将不能再修改，确定继续吗？")) {
                // removeStandRow();
                saveAjaxData("${ctx}/oaMonthplan/auditSave.do?status=" + status, formId);
            }
        } else {
            //removeStandRow();
            saveAjaxData("${ctx}/oaMonthplan/auditSave.do?status=" + status, formId);
        }
    }


</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr>
                <td>

                    <fieldset class="form_fieldset" style="width: 90%;margin: 0 auto;display: true;">
                        <legend class="form_legend">月度总结和计划</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td class="form_label_right">提交部门：</td>
                                <td class="form_content">&nbsp;
                                        ${bean.reportDept}                    </td>

                                <td class="form_label_right">责任人：</td>
                                <td class="form_content">&nbsp;
                                        ${bean.reportPerson}                    </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">报告年份：</td>
                                <td class="form_content" colspan="4">&nbsp;
                                        ${bean.year} 年 ${bean.period} 月
                                </td>
                            </tr>
                            <tr>
                                <td colspan="4">

                                    <table cellpadding="0" cellspacing="0" width="100%" align="center">
                                        <tr class="tr_header">
                                            <td class="form_td_line" width="40" nowrap>序号</td>
                                            <td class="form_td_line" width="155" nowrap>工作内容</td>
                                            <td class="form_td_line" width="155" nowrap>时间节点</td>
                                            <td class="form_td_line" width="155" nowrap>报告类型</td>
                                            <td class="form_td_line" width="155" nowrap>是否完成</td>
                                        </tr>
                                    </table>

                                </td>
                            </tr>
                            <tr>
                                <td colspan="4">
                                    <fieldset class="form_fieldset" style="width:98%;margin: 0 auto;display: true;">
                                        <legend class="form_legend">月度总结</legend>
                                    <table id="table1" cellpadding="0" cellspacing="0" width="100%" align="center">
                                        <c:forEach items="${bean.oaMonthplanItems}" var="item" varStatus="status">

                                            <c:if test="${item.reportType=='总结'}">
                                                <tr class="tr_dark">
                                                    <td align="center" class="form_td_line" width="40"
                                                        nowrap>${status.index+1}</td>
                                                    <td align="left" width="155" nowrap>
                                                        <textarea  name="contentZj_${item.id}" id="contentZj_${item.id}"
                                                                  class="input_textarea">${item.content}</textarea>
                                                        <input type="hidden" name="itemZjs" value="${item.id}"/>
                                                    </td>
                                                    <td align="center" class="form_td_line" width="155" nowrap>${item.timeNode}</td>
                                                    <td align="center" class="form_td_line" width="155"
                                                        nowrap>${item.reportType}</td>
                                                    <td align="center" class="form_td_line" width="155" nowrap>
                                                        <c:if test="${item.isComplete==false}">否</c:if><c:if
                                                            test="${item.isComplete==true}">是</c:if>
                                                    </td>
                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </table>
                                        </fieldset>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="4">
                                    <fieldset class="form_fieldset" style="width:98%;margin: 0 auto;display: true;">
                                        <legend class="form_legend">月度计划</legend>
                                    <table id="table2" cellpadding="0" cellspacing="0" width="100%" align="center">
                                        <c:forEach items="${bean.oaMonthplanItems}" var="item" varStatus="status">
                                            <c:if test="${item.reportType=='计划'}">
                                                <tr class="tr_dark">
                                                    <td align="center" class="form_td_line" width="40"
                                                        nowrap>${status.index+1}</td>
                                                    <td align="left" width="155" nowrap>
                                                        <textarea  name="contentJh_${item.id}" id="contentJh_${item.id}"
                                                                  class="input_textarea">${item.content}</textarea>
                                                        <input type="hidden" name="itemJhs" value="${item.id}"/>
                                                    </td>
                                                    <td align="center" class="form_td_line" width="155" nowrap>${item.timeNode}</td>
                                                    <td align="center" class="form_td_line" width="155"
                                                        nowrap>${item.reportType}</td>
                                                    <td align="center" class="form_td_line" width="155" nowrap>
                                                        <c:if test="${item.isComplete==false}">否</c:if><c:if
                                                            test="${item.isComplete==true}">是</c:if>
                                                    </td>
                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </table>
                                        </fieldset>
                                </td>
                            </tr>

                        </table>
                    </fieldset>
                </td>
            </tr>
            <tr>
                <td>
                    <fieldset class="form_fieldset" style="width: 90%;margin: 0 auto;display: true;">
                        <legend class="form_legend">分管领导审核</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_dark">
                                <td class="form_label_right" width="20%">分管领导审核意见：</td>
                                <td class="form_content">
                                    <form:textarea path="fgOpinion" cssClass="input_textarea_long"/>
                                </td>
                            </tr>
                            <tr class="tr_light" hidden="true">
                                <td class="form_label_right">分管领导审核时间：</td>
                                <td class="form_content">
                                    <input type="text" name="fgAuditTime" id="fgAuditTime"
                                           class="input_datetime"
                                           value="<fmt:formatDate value="${bean.fgAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                                           readonly="true"/>
                                    <input type="button" class="button_calendar" value=" "
                                           onClick="calendar('fgAuditTime','all')">

                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_border">
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