<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [];
        validateInit(validateCondition, formId);
    });

    function addLine() {
        var stand = $("#standTr").html()
        var len = $("#itemTable").find("tr").length;
        if (len % 2 == 0) {
            stand = "<tr class='tr_dark'>" + stand + "</tr>";
        } else {
            stand = "<tr class='tr_light'>" + stand + "</tr>";
        }
        $("#itemTable").find("tr:last").after(stand);
    }

    function deleteLine(obj) {
        $(obj).parent().parent().remove();
    }

    //保存操作
    function save(status) {
        if (!validateForm(formId)) {
            return;
        }
        $("#standTr").remove();
        $("#status").val(status);
        $("select[name='actualDesc']").each(function () {
            $(this).get(0).disabled = false;
        })
        //提交表单
        saveAjaxData("${ctx}/oaWorkWatch/save.do", formId);
    }

    $(function () {
        if (${bean.status==STATUS_INFO}) {
            $("input[name='completeDesc']").each(function () {
                $(this).get(0).readOnly = false;
            })
        }
        if (${bean.status==STATUS_B_CHECK}) {
            $("select[name='actualDesc']").each(function () {
                $(this).get(0).disabled = false;
            })
        }
    })
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <input type="hidden" value="${bean.status}" id="status" name="status"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right">上报科室：</td>
                <td class="form_content">
                    <form:input path="reportDept" cssClass="input_text"/>
                </td>
                <td class="form_label_right">科室分管领导：</td>
                <td class="form_content">
                    <form:input path="reportPerson" cssClass="input_text"/>
                </td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label_right">上报开始时间：</td>
                <td class="form_content" colspan="3">
                    <form:input path="beginDate" cssClass="input_date"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('beginDate','date')">
                    ~
                    <form:input path="endDate" cssClass="input_date"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('endDate','date')">
                </td>
            </tr>
        </table>

        <table cellpadding="0" cellspacing="0" class="form_table" style="text-align: center" id="itemTable">
            <tr class="tr_light">
                <td class="form_border" style="width: 25px">
                    <input type='button' value='新增' class='button_select_add' onclick='addLine(this)'>
                </td>
                <td class="form_border" style="width: 35px">
                    序号
                </td>
                <td class="form_border">
                    工作内容
                </td>
                <td class="form_border">
                    时间节点
                </td>

                <td class="form_border">
                    上报形式
                </td>

                <td class="form_border">
                    完成情况
                </td>

                <td class="form_border">
                    审核情况
                </td>
            </tr>
            <c:forEach items="${bean.oaWorkWatchItems}" var="item">
                <tr class="tr_light">
                    <td class="form_border" style="width: 25px">
                        <input type='button' value='删除' class='button_select_remove' onclick='deleteLine(this)'>
                    </td>
                    <td class="form_border">
                        <input type="text" class="input_text" name="orderNo" value="${item.orderNo}"
                               style="width: 35px"/>
                    </td>
                    <td class="form_border">
                        <input type="text" class="input_text" name="content" value="${item.content}"/>
                    </td>
                    <td class="form_border">
                        <input type="text" class="input_text" name="timeNode" value="${item.timeNode}"/>
                    </td>

                    <td class="form_border">
                        <input type="text" class="input_text" name="reportMethod" value="${item.reportMethod}"/>
                    </td>

                    <td class="form_border">
                        <input type="text" class="input_text" name="completeDesc" readonly='true'
                               value="${item.completeDesc}"/>
                    </td>

                    <td class="form_border">
                        <select name="actualDesc" disabled>
                            <option value=""></option>
                            <option value="属实" <c:if test="${item.actualDesc =='属实'}"> selected </c:if> >属实</option>
                            <option value="不属实"
                                    <c:if test="${item.actualDesc =='不属实'}">selected </c:if> >不属实
                            </option>
                        </select>
                            <%--<input type="text" class="input_text" name="actualDesc" readonly='true'--%>
                            <%--value="${item.actualDesc}"/>--%>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <table cellpadding="0" cellspacing="0" class="form_table" style="text-align: center">
            <tr id="standTr" style="display: none">
                <td class="form_border" style="width: 25px">
                    <input type='button' value='删除' class='button_select_remove' onclick='deleteLine(this)'>
                </td>
                <td class="form_border">
                    <input type="text" name="orderNo" style="width: 35px" class="input_text"/>
                </td>
                <td class="form_border">
                    <input type="text" name="content" class="input_text"/>
                </td>
                <td class="form_border">
                    <input type="text" name="timeNode" class="input_text"/>
                </td>

                <td class="form_border">
                    <input type="text" name="reportMethod" class="input_text"/>
                </td>

                <td class="form_border">
                    <input type="text" name="completeDesc" readonly='true' class="input_text"/>
                </td>

                <td class="form_border">
                    <select name="actualDesc" disabled>
                        <option value="属实" <c:if test="${item.actualDesc =='属实'}"> selected </c:if> >属实</option>
                        <option value="不属实"
                                <c:if test="${item.actualDesc =='不属实'}">selected </c:if> >不属实
                        </option>
                    </select>
                </td>
            </tr>
        </table>
        <c:if test="${bean.status == STATUS_ZR_SH}">
            <div style="height: 10px"></div>
            <fieldset class="form_fieldset">
                <legend class="form_legend">
                    主任审核
                </legend>
                <table cellpadding="0" cellspacing="0" class="form_table" style="text-align: center">
                    <tr class="tr_light">
                        <td class="form_label_right" colspan="1">
                            审核意见：
                        </td>
                        <td class="form_content" colspan="6">
                            <textarea class="input_textarea_long" name="zrOpinion"/>'${bean.zrOpinion}'</textarea>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </c:if>
        <c:if test="${bean.status == STATUS_B_CHECK}">
            <div style="height: 10px"></div>
            <fieldset class="form_fieldset">
                <table cellpadding="0" cellspacing="0" class="form_table" style="text-align: center">
                    <tr class="tr_light">
                        <td class="form_label_right" colspan="1">
                            核实意见：
                        </td>
                        <td class="form_content" colspan="6">
                            <textarea class="input_textarea_long" name="bgsOpinion"/>${bean.bgsOpinion}</textarea>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </c:if>
        <table cellpadding="0" cellspacing="0" class="form_table" style="text-align: center">
            <tr class="tr_button">
                <td style="text-align: center">
                    <c:if test="${empty bean.status||bean.status == STATUS_EDIT||bean.status == STATUS_BACK||bean.status == STATUS_CHECK_BACK}">
                        <input type="button" value="提交" class="button_confirm" onclick="save('${STATUS_ZR_SH}')">&nbsp;
                        <input type="button" value="保存" class="button_confirm" onclick="save('${STATUS_EDIT}')">&nbsp;
                    </c:if>

                    <c:if test="${bean.status == STATUS_ZR_SH}">
                        <input type="button" value="审核通过" class="button_normal_long" onclick="save('${STATUS_INFO}')">&nbsp;
                        <input type="button" value="退回修改" class="button_normal_long" onclick="save('${STATUS_BACK}')">&nbsp;
                    </c:if>

                    <c:if test="${bean.status == STATUS_INFO}">
                        <input type="button" value="暂存" class="button_confirm" onclick="save('${STATUS_INFO}')">&nbsp;
                        <input type="button" value="上报" class="button_confirm" onclick="save('${STATUS_B_CHECK}')">&nbsp;
                    </c:if>

                    <c:if test="${bean.status == STATUS_B_CHECK}">
                        <input type="button" value="核实通过" class="button_normal_long"
                               onclick="save('${STATUS_CHECK_PASS}')">&nbsp;
                        <input type="button" value="核实不通过" class="button_normal_long"
                               onclick="save('${STATUS_CHECK_BACK}')">&nbsp;
                    </c:if>
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>