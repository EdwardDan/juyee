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
            stand = "<tr>" + stand + "</tr>";
        } else {
            stand = "<tr>" + stand + "</tr>";
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
                <td class="form_label_right">督办科室：</td>
                <td class="form_content">
                    <form:input path="reportDept" cssClass="input_text"/>
                    <input type="button" value=" " class="button_select"
                           onclick="selectSysDept('','reportDept');" title="点击选择科室">
                </td>
                <td class="form_label_right">科室分管领导：</td>
                <td class="form_content">
                    <form:input path="reportPerson" cssClass="input_text"/>
                    <input type="button" value=" " class="button_select"
                           onclick="selectSysPerson('','reportPerson');" title="点击选择人员">
                </td>
            </tr>
        </table>
        <table cellpadding="0" cellspacing="0" border="1" class="table_thin_line" style="text-align: center;width: 98%;"
               id="itemTable">
            <tr class="tr_header">
                <td style="width:5%;">
                    <input type='button' value='新增' class='button_select_add' onclick='addLine(this)'>
                </td>
                <td style="width: 5%;">序号</td>
                <td style="width: 25%;">工作内容</td>
                <td style="width: 8%;">时间节点</td>
                <td style="width: 8%;">上报形式</td>
                <td style="width: 20%;;">完成情况</td>
                <td style="width: 10%;">审核情况</td>
            </tr>
            <c:forEach items="${bean.oaWorkWatchItems}" var="item">
                <tr class="tr_light">
                    <td style="width: 25px">
                        <input type='button' value='删除' class='button_select_remove' onclick='deleteLine(this)'>
                    </td>
                    <td>
                        <input type="text" name="orderNo" style="width: 96%;" class="input_text" value="${item.orderNo}"/>
                    </td>
                    <td>
                        <textarea name="content" class="input_textarea" style="width: 96%;height: 50px;">${item.content}</textarea>
                    </td>
                    <td>
                        <input type="text" name="timeNode" class="input_text" style="width: 96%;" value="${item.timeNode}"/>
                    </td>
                    <td>
                        <input type="text" name="reportMethod" class="input_text" style="width: 96%;" value="${item.reportMethod}"/>
                    </td>
                    <td>
                        <textarea name="completeDesc" class="input_textarea" style="width: 96%;height: 50px;">${item.completeDesc}</textarea>
                    </td>
                    <td>
                        <select name="actualDesc" disabled>
                            <option value=""></option>
                            <option value="属实" <c:if test="${item.actualDesc =='属实'}"> selected </c:if> >属实</option>
                            <option value="不属实"
                                    <c:if test="${item.actualDesc =='不属实'}">selected </c:if> >不属实
                            </option>
                        </select>
                    </td>
                </tr>
            </c:forEach>
            <tr id="standTr" style="display: none">
                <td style="width: 25px">
                    <input type='button' value='删除' class='button_select_remove' onclick='deleteLine(this)'>
                </td>
                <td>
                    <input type="text" name="orderNo" style="width: 96%;" class="input_text"/>
                </td>
                <td>
                    <textarea name="content" class="input_textarea" style="width: 96%;height: 50px;"></textarea>
                </td>
                <td>
                    <input type="text" name="timeNode" class="input_text" style="width: 96%;"/>
                </td>
                <td>
                    <input type="text" name="reportMethod" class="input_text" style="width: 96%;"/>
                </td>
                <td>
                    <textarea name="completeDesc" class="input_textarea" style="width: 96%;height: 50px;"></textarea>
                </td>
                <td>
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
                            <textarea class="input_textarea_long" name="zrOpinion">${bean.zrOpinion}</textarea>
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
                            <textarea class="input_textarea_long" name="bgsOpinion">${bean.bgsOpinion}</textarea>
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