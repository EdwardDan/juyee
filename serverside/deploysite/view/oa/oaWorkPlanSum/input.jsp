<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function ()
    {
        //页面验证初始化
        var validateCondition = [
            //{name:"beginDate", rule:"validate[required,custom[date],maxSize[7]"},
            //{name:"endDate", rule:"validate[required,custom[date],maxSize[7]"},
            //{name:"documentId", rule:"validate[required,custom[integer],maxSize[10]"},
            //{name:"status", rule:"validate[required,custom[integer],maxSize[2]"},
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn, status)
    {
        if (!validateForm(formId))
        {
            return;
        }
        if (status !=${STATUS_EDIT} && !confirm("确定提交？提交后不能更改！"))
        {
            return;
        }
        $("#status").val(status);

        //提交表单
        saveAjaxData("${ctx}/oaWorkPlanSum/save.do", formId);
    }
</script>
<style>
    .input_text{
        font-size: 12px;
        border: 1px solid #b8b6b9;
        color: #007DBC;
        background-color: #FFFFFF;
        width: 100px;
        height: 20px;
    }
    .input_number_short{
        font-size: 12px;
        border: 1px solid #b8b6b9;
        color: #007DBC;
        background-color: #FFFFFF;
        width: 60px;
        height: 20px;
    }

</style>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="status"/>
    <form:hidden path="beginDate"/>
    <form:hidden path="endDate"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_title">
                <td>
                    一周工作安排（${bean.beginDate}~${bean.endDate}）
                </td>
            </tr>
        </table>
        <fieldset class="from_fieldset">
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_header">
                    <td class="form_border" width="8%">序号</td>
                    <td class="form_border" width="10%">责任人</td>
                    <td class="form_border" width="10%">重点工作</td>
                    <td class="form_border" width="10%">工作内容</td>
                    <td class="form_border" width="10%">科室</td>
                    <td class="form_border" width="10%">工作进度</td>
                    <td class="form_border" width="10%">经办人</td>
                </tr>
                <c:forEach items="${oaWorkPlanItems}" var="item" varStatus="st">
                <c:if test="${st.index%2==0}">
                <tr class="tr_dark"></c:if>
                    <c:if test="${st.index%2!=0}">
                <tr class="tr_light"></c:if>
                    <td class="form_content">
                        <input type="text" class="input_number_short" name="orderNo" value="${item.orderNo}">
                        <c:choose>
                            <c:when test="${empty bean.id}">
                                <input type="hidden" class="input_text" name="itemId" value="${item.id}">
                            </c:when>
                            <c:otherwise>
                                <input type="hidden" class="input_text" name="itemId" value="${item.workPlanItem.id}">
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td class="form_content">
                        <input type="text" class="input_text" name="dutyPerosn" value="${item.dutyPerosn}">
                    </td>
                    <td class="form_content">
                        <input type="text" class="input_text" name="keyWork" value="${item.keyWork}">
                    </td>
                    <td class="form_content">
                        <input type="text" class="input_text" name="content" value="${item.content}">
                    </td>
                <td class="form_content">
                    <c:choose>
                        <c:when test="${empty bean.id}">
                            <input type="text" class="input_text" name="reportDept" value="${item.weekPlan.reportDept}">
                        </c:when>
                        <c:otherwise>
                            <input type="text" class="input_text" name="reportDept" value="${item.workPlanItem.weekPlan.reportDept}"
                        </c:otherwise>
                    </c:choose>
                    </td>
                    <td class="form_content">
                        <input type="text" class="input_text" name="schedule" value="${item.schedule}">
                    </td>
                    <td class="form_content">
                        <input type="text" class="input_text" name="jbr" value="${item.jbr}">
                    </td>
                </tr>
                    </c:forEach>
            </table>
        </fieldset>
        <c:choose>
            <c:when test="${bean.status == STATUS_SUBMIT||bean.status == STATUS_MAIN_PASS||bean.status == STATUS_MAIN_BACK}">
                <fieldset class="form_fieldset">
                    <legend class="form_legend">
                        主任审核
                    </legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
                            <td class="form_label_right" style="width: 150px">主任审核意见：</td>
                            <td class="form_content" colspan="3">
                                <c:choose>
                                    <c:when test="${bean.status == STATUS_MAIN_BACK}">
                                        <form:textarea path="leaderOpinion" cssClass="input_textarea_long"
                                                       readonly="true"/>
                                    </c:when>
                                    <c:otherwise>
                                        <form:textarea path="leaderOpinion" cssClass="input_textarea_long"/>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </c:when>
            <c:otherwise>
                <form:hidden path="leaderOpinion"/>
            </c:otherwise>
        </c:choose>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_button">
                <td class="form_content" style="text-align: center">
                    <c:if test="${canEdit||canEdit_ZR}">
                        <c:if test="${empty bean.status|| STATUS_EDIT ==bean.status|| STATUS_MAIN_BACK ==bean.status}">
                            <input type="button" value="提交" class="button_confirm"
                                   onclick="save(this,'${STATUS_SUBMIT}')">&nbsp;
                            <input type="button" value="保存" class="button_confirm"
                                   onclick="save(this,'${STATUS_EDIT}')">&nbsp;
                        </c:if>
                    </c:if>
                    <c:if test="${canEdit_ZR}">
                        <c:if test="${STATUS_SUBMIT ==bean.status}">
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