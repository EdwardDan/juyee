<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "reportDept", rule: "validate[required,maxSize[100]]"},
            {name: "reportPerson", rule: "validate[required,maxSize[50]]"}
        ];
        validateInit(validateCondition, formId);
        if (${bean.status==STATUS_ZR_PASS}) {
            $("textarea[name='completeDesc']").each(function () {
                $(this).get(0).readOnly = false;
            })
        }
        if (${bean.status==STATUS_INFO}) {
            $("select[name='actualDesc']").each(function () {
                $(this).get(0).disabled = false;
            })
        }
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
    function save(status, buttonName) {
        var isSave = true;
        if (!validateForm(formId)) {
            return;
        }
        $("#standTr").remove();
        $("#status").val(status);
        $("select[name='actualDesc']").each(function () {
            $(this).get(0).disabled = false;
        });
        $("input[name='orderNo']").each(function () {
            var orderNo = $(this).val();
            if (null == orderNo || '' == orderNo) {
                showInfoMsg("序号不能为空");
                isSave = false;
                return false;
            }
        });
        if (isSave) {
            //提交表单
            if (buttonName != "") {
                if (confirm("是否确定执行 " + buttonName + " 操作？")) {
                    saveAjaxData("${ctx}/oaWorkWatch/save.do?status=" + status, formId);
                }
            } else {
                saveAjaxData("${ctx}/oaWorkWatch/save.do?status=" + status, formId);
            }
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right">上报科室：</td>
                <td class="form_content">
                    <form:input path="reportDept" cssClass="input_text" readonly="true"/>
                    <c:if test="${bean.status == STATUS_EDIT}">
                        <input type="button" value=" " class="button_select"
                               onclick="selectSysDept('','reportDept');" title="点击选择科室">
                    </c:if>
                </td>
                <td class="form_label_right">分管领导：</td>
                <td class="form_content">
                    <form:input path="reportPerson" cssClass="input_text" readonly="true"/>
                    <c:if test="${bean.status == STATUS_EDIT}">
                        <input type="button" value=" " class="button_select"
                               onclick="selectSysPerson('','reportPerson');" title="点击选择人员">
                    </c:if>
                </td>
            </tr>
        </table>
        <table cellpadding="0" cellspacing="0" border="1" class="table_thin_line" style="text-align: center;width: 98%;"
               id="itemTable">
            <c:set var="canEditPass" value="${bean.status == STATUS_ZR_PASS}"/>
            <c:set var="canHS" value="${bean.status == STATUS_INFO}"/>
            <tr class="tr_header">
                <c:if test="${!canEditPass && !canHS}">
                    <td style="width:5%;">
                        <input type='button' value='新增' class='button_select_add' onclick='addLine()'>
                    </td>
                </c:if>
                <td style="width: 5%;">序号</td>
                <td style="width: 25%;">工作内容</td>
                <td style="width: 8%;">时间节点</td>
                <td style="width: 8%;">上报形式</td>
                <td style="width: 20%;;">完成情况</td>
                <td style="width: 10%;">审核情况</td>
            </tr>
            <c:forEach items="${bean.oaWorkWatchItems}" var="item">
                <tr class="tr_light">
                    <c:if test="${!canEditPass && !canHS}">
                        <td>
                            <input type='button' value='删除' class='button_select_remove' onclick='deleteLine(this)'>
                        </td>
                    </c:if>
                    <td>
                        <input type="text" name="orderNo" style="width: 90%;" class="input_text"
                               value="${item.orderNo}" <c:if test="${canEditPass || canHS}">readonly</c:if>/>
                    </td>
                    <td>
                        <textarea name="content" class="input_textarea" <c:if test="${canEditPass || canHS}">readonly</c:if>
                                  style="width: 96%;height: 50px;">${item.content}</textarea>
                    </td>
                    <td>
                        <input type="text" name="timeNode" class="input_text" style="width: 90%;"
                               value="${item.timeNode}" <c:if test="${canEditPass || canHS}">readonly</c:if>/>
                    </td>
                    <td>
                        <input type="text" name="reportMethod" class="input_text" style="width: 90%;"
                               value="${item.reportMethod}" <c:if test="${canEditPass || canHS}">readonly</c:if>/>
                    </td>
                    <td>
                        <textarea name="completeDesc" class="input_textarea" readonly="true"
                                  style="width: 96%;height: 50px;">${item.completeDesc}</textarea>
                    </td>
                    <td>
                        <select name="actualDesc" disabled>
                            <option value="">==请选择==</option>
                            <option value="1" <c:if test="${item.actualDesc =='1' || item.actualDesc ==''}"> selected </c:if> >完成</option>
                            <option value="2" <c:if test="${item.actualDesc =='2'}">selected </c:if> >延期</option>
                            <option value="3" <c:if test="${item.actualDesc =='3'}">selected </c:if> >调整</option>
                        </select>
                    </td>
                </tr>
            </c:forEach>
            <tr id="standTr" style="display: none;">
                <td style="width: 25px">
                    <input type='button' value='删除' class='button_select_remove' onclick='deleteLine(this)'>
                </td>
                <td>
                    <input type="text" name="orderNo" style="width: 90%;" class="input_text"/>
                </td>
                <td>
                    <textarea name="content" class="input_textarea" style="width: 96%;height: 50px;"></textarea>
                </td>
                <td>
                    <input type="text" name="timeNode" class="input_text" style="width: 90%;"/>
                </td>
                <td>
                    <input type="text" name="reportMethod" class="input_text" style="width: 90%;"/>
                </td>
                <td>
                    <textarea name="completeDesc" class="input_textarea" style="width: 96%;height: 50px;"
                              readonly="true"></textarea>
                </td>
                <td>
                    <select name="actualDesc" disabled>
                        <option value="">==请选择==</option>
                        <option value="1" <c:if test="${item.actualDesc =='1'}"> selected </c:if> >完成</option>
                        <option value="2" <c:if test="${item.actualDesc =='2'}">selected </c:if> >延期</option>
                        <option value="3" <c:if test="${item.actualDesc =='3'}">selected </c:if> >调整</option>
                    </select>
                </td>
            </tr>
        </table>
        <div style="height: 10px"></div>
        <c:if test="${bean.status == STATUS_INFO}">
            <fieldset class="form_fieldset" style="width: 96%;">
                <legend class="form_legend">
                    主任审核
                </legend>
                <table cellpadding="0" cellspacing="0" class="form_table" style="text-align: center">
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%">
                            审核意见：
                        </td>
                        <td class="form_content">
                            <sys:toHtml>${bean.zrOpinion}</sys:toHtml>
                        </td>
                    </tr>
                </table>
            </fieldset>
            <div style="height: 10px"></div>
            <fieldset class="form_fieldset" style="width: 96%;">
                <legend class="form_legend">
                    办公室核实
                </legend>
                <table cellpadding="0" cellspacing="0" class="form_table" style="text-align: center">
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%;">
                            核实意见：
                        </td>
                        <td class="form_content">
                            <form:textarea path="bgsOpinion" cssclass="input_textarea_long" cssStyle="width: 96%;"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </c:if>
        <table cellpadding="0" cellspacing="0" class="form_table" style="text-align: center">
            <tr class="tr_button">
                <td style="text-align: center">
                    <c:if test="${bean.status == STATUS_EDIT||bean.status == STATUS_ZR_BACK||bean.status == STATUS_B_BACK}">
                        <input type="button" value="提交" class="button_confirm"
                               onclick="save('${STATUS_SUBMIT}',this.value)">&nbsp;
                        <input type="button" value="保存" class="button_confirm" onclick="save('${STATUS_EDIT}','')">&nbsp;
                    </c:if>
                    <c:if test="${bean.status == STATUS_ZR_PASS}">
                        <input type="button" value="上报" class="button_confirm"
                               onclick="save('${STATUS_INFO}',this.value)">&nbsp;
                        <input type="button" value="暂存" class="button_confirm" onclick="save('${STATUS_ZR_PASS}','')">&nbsp;
                    </c:if>
                    <c:if test="${bean.status == STATUS_INFO}">
                        <input type="button" value="核实通过" class="button_normal_long"
                               onclick="save('${STATUS_B_PASS}',this.value)">&nbsp;
                        <input type="button" value="核实退回" class="button_normal_long"
                               onclick="save('${STATUS_B_BACK}',this.value)">&nbsp;
                    </c:if>
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>