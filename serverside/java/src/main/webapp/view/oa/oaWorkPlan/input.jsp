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
        var beginDate = $("#beginDate").val();
        var endDate = $("#endDate").val();
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
        } else {
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

<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="status"/>
    <div class="form_div">
        <fieldset class="form_fieldset">
            <legend class="form_legend">
                一周工作安排
            </legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_dark">
                    <td class="form_label_right">上报科室：</td>
                    <td class="form_content">
                        <form:input path="reportDept" cssClass="input_text" readonly="true"/>
                    </td>

                    <td class="form_label_right">上报人：</td>
                    <td class="form_content">
                        <form:input path="reportPerson" cssClass="input_text" readonly="true"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" style="width: 150px">上报时间：</td>
                    <td class="form_content" colspan="3">
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
                    <td style="width:8%">经办人</td>
                    <td style="width:5%;">
                        <input type='button' value='添加' class='button_select_add' onclick='addLine(this)'>
                    </td>
                </tr>

                <c:if test="${empty oaWorkPlanItems !=null}">
                    <c:forEach items="${oaWorkPlanItems}" var="item">
                        <tr class="tr_dark">
                            <td>
                                <input type="text" name="orderNo" class="input_text"
                                       style="width: 95%;text-align: center"
                                       value="${item.orderNo}"
                                       title="${item.orderNo}">
                            </td>

                            <td>
                                <input type="text" name="dutyPerosn" class="input_text" style="width: 95%;"
                                       value="${item.dutyPerosn}"
                                       title="${item.dutyPerosn}">
                            </td>

                            <td>
                                <input type="text" name="keyWork" class="input_text" style="width: 95%;"
                                       value="${item.keyWork}"
                                       title="${item.keyWork}">
                            </td>
                            <td>
                                <textarea name="content" class="input_textarea"
                                          style="width: 95%;height: 50px;">${item.content}</textarea>
                            </td>
                            <td>
                                <textarea name="schedule" class="input_textarea"
                                          style="width: 95%;height: 50px;">${item.schedule}</textarea>
                            </td>
                            <td>
                                <input type="text" name="jbr" class="input_text" style="width: 95%;" value="${item.jbr}"
                                       title="${item.jbr}">
                            </td>
                            <td style="width: 25px"><input type="button" value="删除" class="button_select_remove"
                                                           onclick="addLine(this)"/>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                <tbody id="tableWorkPlanItemDiv"></tbody>
                    <%--标准行迁入--%>
            </table>
        </fieldset>

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
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>
<table style="display: none;" cellpadding="0" cellspacing="0" class="form_table" border="1">
    <tbody id="hiddenStyle">
    <tr class="tr_dark"><%--标准行--%>
        <td>
            <input type="text" name="orderNo" class="input_text" style="width: 95%;text-align: center"/>
        </td>
        <td>
            <input type="text" name="dutyPerosn" class="input_text" style="width: 95%;"/>
        </td>
        <td>
            <input type="text" name="keyWork" class="input_text" style="width: 95%;"/>
        </td>
        <td>
            <textarea name="content" class="input_textarea" style="width: 95%;height: 50px;"></textarea>
        </td>
        <td>
            <textarea name="schedule" class="input_textarea" style="width: 95%;height: 50px;"></textarea>
        </td>
        <td>
            <input type="text" name="jbr" class="input_text" style="width: 95%;"/>
        </td>
        <td style="width: 25px"><input type="button" value="删除" class="button_select_remove"
                                       onclick="addLine(this)"/></td>
    </tr>
    </tbody>
</table>