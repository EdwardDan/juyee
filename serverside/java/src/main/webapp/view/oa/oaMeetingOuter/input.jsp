<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            //{name:"beginTime", rule:"validate[required,maxSize[7]]"},
            //{name:"endTime", rule:"validate[required,maxSize[7]]"},
            //{name:"address", rule:"validate[required,maxSize[200]]"},
            //{name:"chargePerson", rule:"validate[required,maxSize[200]]"},
            //{name:"startDept", rule:"validate[required,maxSize[200]]"},
            //{name:"leader", rule:"validate[required,maxSize[200]]"},
            //{name:"innerPersons", rule:"validate[required,maxSize[200]]"},
            //{name:"title", rule:"validate[required,maxSize[200]]"},
            //{name:"content", rule:"validate[required,maxSize[200]]"},
            //{name:"relateMatter", rule:"validate[required,maxSize[200]]"},
            //{name:"workAdvise", rule:"validate[required,maxSize[200]]"},
            //{name:"status", rule:"validate[required,custom[integer],maxSize[2]"},
            //{name:"fgAuditOpinion", rule:"validate[required,maxSize[200]]"},
            //{name:"fgAuditTime", rule:"validate[required,maxSize[7]]"},
            //{name:"zrAuditOpinion", rule:"validate[required,maxSize[200]]"},
            //{name:"zrAuditTime", rule:"validate[required,maxSize[7]]"},
            //{name:"createTime", rule:"validate[required,maxSize[7]]"},
            //{name:"createUser", rule:"validate[required,maxSize[150]]"},
            //{name:"updateTime", rule:"validate[required,maxSize[7]]"},
            //{name:"updateUser", rule:"validate[required,maxSize[150]]"},
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn, status) {
        if (!validateForm(formId)) {
            return;
        }
        $(btn).get(0).disabled = true;
        $("#status").val(status);
        //提交表单
        saveAjaxData("${ctx}/oaMeetingOuter/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="status"/>

    <div class="form_div">
        <fieldset class="form_fieldset">
            <legend class="form_legend">
                外出会议
            </legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_border" style="width: 150px">会议时间：</td>
                    <td class="form_content" colspan="3">
                        <input type="text" name="beginTime" id="beginTime" class="input_datetime"
                               value="<fmt:formatDate value="${bean.beginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                               readonly="true"/>
                        <input type="button" class="button_calendar" value=" " onClick="calendar('beginTime','all')">
                        ~
                        <input type="text" name="endTime" id="endTime" class="input_datetime"
                               value="<fmt:formatDate value="${bean.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                               readonly="true"/>
                        <input type="button" class="button_calendar" value=" " onClick="calendar('endTime','all')">

                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_border">会议地点：</td>
                    <td class="form_content" colspan="3">
                        <form:input path="address" input_textarea_longcssClass="input_text_long"
                                    cssStyle="width: 400px"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_border">主持人：</td>
                    <td class="form_content">
                        <form:input path="chargePerson" cssClass="input_text"/>
                    </td>

                    <td class="form_border">发起单位：</td>
                    <td class="form_content">
                        <form:input path="startDept" cssClass="input_text"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_border">会议领导：</td>
                    <td class="form_content" colspan="3">
                        <form:textarea path="leader" cssClass="input_textarea" cssStyle="height: 30px;width: 400px"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_border">与会单位：</td>
                    <td class="form_content" colspan="3">
                        <form:textarea path="innerPersons" cssClass="input_textarea"
                                       cssStyle="height: 30px;width: 400px"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_border">会议名称：</td>
                    <td class="form_content" colspan="3">
                        <form:input path="title" input_textarea_longcssClass="input_text_long" cssStyle="width: 400px"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_border">会议内容：</td>
                    <td class="form_content" colspan="3">
                        <form:textarea path="content" cssClass="input_textarea_long"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_border">与中心相关事宜：</td>
                    <td class="form_content" colspan="3">
                        <form:textarea path="relateMatter" cssClass="input_textarea_long"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_border">工作建议：</td>
                    <td class="form_content" colspan="3">
                        <form:textarea path="workAdvise" cssClass="input_textarea_long"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_border">附件：</td>
                    <td class="form_content" colspan="3">
                            ${uploadButtonDocument}
                    </td>
                </tr>
            </table>
        </fieldset>
        <c:choose>
            <c:when test="${bean.status == STATUS_SUBMIT||bean.status == STATUS_BRANCH_PASS||bean.status == STATUS_MAIN_PASS||bean.status == STATUS_BRANCH_BACK||bean.status == STATUS_MAIN_BACK}">
                <fieldset class="form_fieldset">
                    <legend class="form_legend">
                        分管领导审核
                    </legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
                            <td class="form_border" style="width: 150px">分管领导审核意见：</td>
                            <td class="form_content" colspan="3">
                                <c:choose>
                                    <c:when test="${bean.status == STATUS_BRANCH_BACK||bean.status == STATUS_MAIN_BACK}">
                                        <form:textarea path="fgAuditOpinion" cssClass="input_textarea_long"
                                                       readonly="true"/>
                                    </c:when>
                                    <c:otherwise>
                                        <form:textarea path="fgAuditOpinion" cssClass="input_textarea_long"/>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </c:when>
            <c:otherwise>
                <form:hidden path="fgAuditOpinion"/>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${bean.status == STATUS_BRANCH_PASS||bean.status == STATUS_MAIN_BACK}">
                <fieldset class="form_fieldset">
                    <legend class="form_legend">
                        主任审核批示
                    </legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
                            <td class="form_border" style="width: 150px">主任审核意见：</td>
                            <td class="form_content" colspan="3">
                                <c:choose>
                                    <c:when test="${bean.status == STATUS_MAIN_BACK}">
                                        <form:textarea path="zrAuditOpinion" cssClass="input_textarea_long"
                                                       readonly="true"/>
                                    </c:when>
                                    <c:otherwise>
                                        <form:textarea path="zrAuditOpinion" cssClass="input_textarea_long"/>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </c:when>
            <c:otherwise>
                <form:hidden path="zrAuditOpinion"/>
            </c:otherwise>
        </c:choose>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_button">
                <td class="form_content" style="text-align: center">
                    <c:if test="${canEdit||canEdit_FG||canEdit_ZR}">
                        <c:if test="${empty bean.status|| STATUS_EDIT ==bean.status|| STATUS_BRANCH_BACK ==bean.status|| STATUS_MAIN_BACK ==bean.status}">
                            <input type="button" value="保存" class="button_confirm"
                                   onclick="save(this,'${STATUS_EDIT}')">&nbsp;
                            <input type="button" value="提交" class="button_confirm"
                                   onclick="save(this,'${STATUS_SUBMIT}')">&nbsp;
                        </c:if>
                    </c:if>
                    <c:if test="${canEdit_FG}">
                        <c:if test="${STATUS_SUBMIT ==bean.status}">
                            <input type="button" value="审核通过" class="button_normal_long"
                                   onclick="save(this,'${STATUS_BRANCH_PASS}')">&nbsp;
                            <input type="button" value="退回修改" class="button_normal_long"
                                   onclick="save(this,'${STATUS_BRANCH_BACK}')">&nbsp;
                        </c:if>
                    </c:if>

                    <c:if test="${canEdit_ZR}">
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