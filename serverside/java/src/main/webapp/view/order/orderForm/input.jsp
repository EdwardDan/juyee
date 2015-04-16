<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    var proScheduleNameList = eval('${proScheduleNameList}');
    $(function () {
        //页面验证初始化
        var validateCondition = [
//            {name:"orderCode", rule:"validate[required,maxSize[50]]"},
            //{name:"flowCodeId", rule:"validate[required,maxSize[50]]"},
            {name: "jdTaskCode", rule: "validate[maxSize[50]]"},
            {name: "buildUnitName", rule: "validate[maxSize[200]]"},
            {name: "sgUnitName", rule: "validate[maxSize[200]]"},
            {name: "projectName", rule: "validate[maxSize[200]]"},
            {name: "buildAddress", rule: "validate[maxSize[200]]"},
            {name: "buildArea", rule: "validate[custom[number],maxSize[15]"},
            {name: "structure", rule: "validate[maxSize[50]]"},
            {name: "sgPosition", rule: "validate[maxSize[200]]"},
            {name: "buildLegalPerson", rule: "validate[maxSize[50]]"},
//            {name:"buildLegalPhone", rule:"validate[custom[phone]]"},
            {name: "projectManager", rule: "validate[required,maxSize[50]]"},
//            {name:"planSgDatatime", rule:"validate[required,maxSize[19]]"},
            {name: "orderDatetime", rule: "validate[required,maxSize[19]]"},
            {name: "inputTime", rule: "validate[required,maxSize[19]]"},
            {name: "linkMan", rule: "validate[required,maxSize[50]]"},
            {name: "linkManPhone", rule: "validate[required,custom[phone]]"}
        ];
        validateInit(validateCondition, formId);
        <c:if test="${not empty bean.id}">
        loadExcelJdDwgcList();
        </c:if>
    });

    //保存操作
    function save(btn, flag) {
        if (!validateForm(formId)) {
            return;
        }
//        if (checkFlowCode() == false) {
//            showErrorMsg("流转编号不存在，请重新输入！");
//            enableBtn(btn);
//            return;
//        }
        var arr = getTable();
        $("#dwgcItems").val(JSON.stringify(arr));
        if (flag == 0) {
            $("#orderStatus").val("${ORDER_FORM_STATUS_EDIT}");
            submitForm(btn);

        } else if (flag == 1) {
            $.messager.confirm('系统提示', '提交受理后不能再修改，确定吗?', function (r) {
                if (r) {
                    $("#orderStatus").val("${ORDER_FORM_STATUS_NOTACCEPT}");
                    submitForm(btn);
                }
            });
        }
    }
    <%--function checkFlowCode(code) {--%>
        <%--var fc = $("#flowCode").val();--%>
        <%--var ret = getAjaxData("${ctx}/proFlowCode/checkFlowCodeIsValid.do?flowCode=" + fc);--%>
        <%--return ret.success == true;--%>
    <%--}--%>

    //提交表单
    function submitForm(btn) {
        saveAjaxData("${ctx}/orderForm/save.do", formId);
        disableBtn(btn);
    }


    function getSelectStr(obj) {
        var str = '<select class="form_select" onchange="" name="proSchedule" id="proSchedule">';
        for (var i = 0; i < proScheduleNameList.length; i++) {
            str += '<option value="' + proScheduleNameList[i].name + '" ' + ( $.trim(obj) == $.trim(proScheduleNameList[i].name) ? ' proScheduleNameList[i]' : '') + '>' + proScheduleNameList[i].name + '</option>';
        }
        str += '</select>';
        return str;
    }

    //加载单位工程列表
    function loadExcelJdDwgcList() {
        var jdTaskCodeValue = $("#jdTaskCode").val();
        if(jdTaskCodeValue != ""){
            loadAjaxData("dwgcList","${ctx}/orderForm/excelJdDwgcView.do?isEdit=true&jdTaskCode=" + jdTaskCodeValue);
        }
    }

    //获取工程信息
    function getInfo(btn) {
        var v = $("#jdTaskCode").val();
        if (v == "") {
            showInfoMsg("请先输入监督任务书编号");
            return;
        }
        btn.value = "请稍候";
        btn.disabled = true;
        $.ajax({
            url: "${ctx}/orderForm/getProjectInfoAndLastOrderForm.do?jdTaskCode=" + v,
            async: false,
            data: "",
            contentType: "application/json; charset=utf-8",
            success: function (ret) {
                if (ret.indexOf("{") >= 0) {
                    var json = eval("(" + ret + ")");
                    var data = json[0];
//                    var excelJdDwgcList = data.excelJdDwgcList;
                    if (data.projectName != "") {
                        $("#projectName").val(data.projectName);
                        $("#buildUnitName").val(data.jsdwmc);
                        $("#sgUnitName").val(data.sgdwmc);
                        $("#buildAddress").val(data.buildAddress);
                        var totalAreaDesc= data.totalAreaDesc;
                        $("#buildArea").val(totalAreaDesc.replace("㎡","").replace(" ",""));
                        $("#structure").val(data.structureForm);
                        $("#buildLegalPerson").val(data.jsdwFr);
//                        $("#buildLegalPhone").val(data.jsdw_tel);
//                        $("#projectManager").val(data.jsdwLxr);
                        $("#linkMan").val(data.jsdwLxr);
                        $("#linkManPhone").val(data.jsdwTel);
//                        getExcelJdDwgcView(v);
                    }
                } else {
                    showErrorMsg("未获取到有效工程信息");
                }
                btn.value = "获取";
                btn.disabled = false;
            },
            error: function () {
                btn.value = "获取";
                btn.disabled = false;
            }
        })
        ;
    }
    function getTable() {
        var table = $("#projectTable");
        var array = [];
        for (var i = 1; i < table.find("tr").size(); i++) {
            var obj = new Object();
            var tr = $(table.find("tr")[i]);
            var td = $(tr.find("td")[2]);
            obj.id = td.find("input")[0].value;
            obj.proSchedule = td.find("select")[0].value;
            array.push(obj);
        }
        return array;
    }
    /*预约日期选择*/
    function getCalender() {
        //可以选择当天及以后
        calendarByJson({el: 'orderDatetime', dateFmt: 'yyyy-MM-dd HH:mm:ss', minDate: $('#inputTime').val()});
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <input type="hidden" name="orderStatus" id="orderStatus" value="${bean.orderStatus.id}">
    <input type="hidden" name="dwgcItems" id="dwgcItems" value="">

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" id="mainTable" bgcolor="#f0f8ff" style="width: 100%">
            <tr>
                <td align="center">
                    <fieldset class="form_fieldset">
                        <legend align="left" class="form_legend">工程信息</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td class="form_label_right" width="15%">监督任务书编号：</td>
                                <td class="form_content" colspan="3">
                                    <form:input path="jdTaskCode" cssClass="input_text" maxlength="50"
                                                cssStyle="float:left"/>
                                    <input type="button" value="获取" id="btnJdTaskCode" class="button_all"
                                           onclick="getInfo(this)" style="float:left;"/>
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right" width="20%">建设单位：</td>
                                <td class="form_content" style="width:252px">
                                    <form:input path="buildUnitName" cssClass="input_text_long"/>
                                </td>
                                <td class="form_label_right" style="width:100px">工程名称：</td>
                                <td class="form_content">
                                    <form:input path="projectName" cssClass="input_text_long"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">施工单位：</td>
                                <td class="form_content">
                                    <form:input path="sgUnitName" cssClass="input_text_long"/>
                                </td>
                                <td class="form_label_right">工程地点：</td>
                                <td class="form_content">
                                    <form:input path="buildAddress" cssClass="input_text_long"/>
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">建筑面积(㎡)：</td>
                                <td class="form_content">
                                    <form:input path="buildArea" cssClass="input_text"/>
                                </td>
                                <td class="form_label_right">结构层次：</td>
                                <td class="form_content">
                                    <form:input path="structure" cssClass="input_text"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">建设单位法人：</td>
                                <td class="form_content" colspan="3">
                                    <form:input path="buildLegalPerson" cssClass="input_text"/>
                                </td>
                            </tr>

                        </table>
                    </fieldset>
                </td>
            </tr>

            <tr>
                <td align="center">
                    <fieldset class="form_fieldset">
                        <legend align="left" class="form_legend">预约信息</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">

                                <%--<tr class="tr_dark">--%>
                                <%--<td class="form_label_right">&lt;%&ndash;联系电话：&ndash;%&gt;</td>--%>
                                <%--<td class="form_content" colspan="3">--%>
                                <%--&lt;%&ndash;<form:input path="buildLegalPhone" cssClass="input_text"/>&ndash;%&gt;--%>
                                <%--</td>--%>
                                <%--</tr>--%>
                            <tr class="tr_dark">
                                <td class="form_label_right" width="15%" nowrap>隐蔽工程部位：</td>
                                <td class="form_content" width="35%">
                                    <form:textarea path="sgPosition" cssClass="input_textarea"/>
                                </td>

                                <td class="form_label_right" width="15%">
                                    项目经理：
                                </td>
                                <td class="form_content">
                                    <form:input path="projectManager" cssClass="input_text"/>
                                </td>

                                    <%--<td class="form_label_right" nowrap>--%>
                                    <%--&nbsp;--%>
                                    <%--计划隐蔽日期：--%>
                                    <%--</td>--%>
                                    <%--<td class="form_content">--%>
                                    <%--&nbsp;--%>
                                    <%--<input type="text" name="planSgDatatime" id="planSgDatatime" class="input_datetime"--%>
                                    <%--value="<fmt:formatDate value="${bean.planSgDatatime}" pattern="yyyy-MM-dd HH:mm:ss"/>"--%>
                                    <%--readonly/>--%>
                                    <%--<input type="button" class="button_calendar" value=" " onClick="calendar('planSgDatatime','all')">--%>
                                    <%--</td>--%>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">联系人：</td>
                                <td class="form_content">
                                    <form:input path="linkMan" cssClass="input_text"/>
                                </td>
                                <td class="form_label_right">联系人手机号：</td>
                                <td class="form_content">
                                    <form:input path="linkManPhone" cssClass="input_text"/>
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">预约附件：</td>
                                <td class="form_content">
                                    &nbsp;${uploadButton}
                                </td>
                                <td class="form_label_right">预约日期：</td>
                                <td class="form_content">
                                    <input type="text" name="orderDatetime" id="orderDatetime" class="input_datetime"
                                           value="<fmt:formatDate value="${bean.orderDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                                           readonly/>
                                    <input type="button" class="button_calendar" value=" "
                                        <%--onClick="calendar('orderDatetime','all')">--%>
                                           onClick="getCalender()">
                                </td>
                            </tr>

                            <tr class="tr_light">
                                <td class="form_label_right">填表日期：</td>
                                <td class="form_content">
                                    <input type="text" name="inputTime" id="inputTime" class="input_datetime"
                                           value="<fmt:formatDate value="${bean.inputTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                                           readonly/>
                                        <%--<input type="button" class="button_calendar" value=" " onClick="calendar('inputTime','all')">--%>
                                </td>
                                <td class="form_content" colspan="2">&nbsp;</td>
                            </tr>

                        </table>
                    </fieldset>
                </td>
            </tr>

            <tr>
                <td align="center" id="dwgcList">&nbsp;</td>
            </tr>

            <c:if test="${ not empty orderFormMemo}">
                <tr>
                    <td align="center">
                        <fieldset class="form_fieldset">
                            <legend align="left" class="form_legend">${orderFormMemo.name}</legend>
                            <table cellpadding="0" cellspacing="0" class="form_table">
                                <tr class="tr_light">
                                    <td class="form_content" width="100%" style="color: blue">
                                        <sys:toHtml>${orderFormMemo.constraint}</sys:toHtml>
                                        &nbsp;
                                    </td>
                                </tr>
                            </table>
                        </fieldset>
                    </td>
                </tr>
            </c:if>
            <tr class="tr_button" align="center">
                <td class="form_border" colspan="4">
                    <c:if test="${isEdit}">
                        <input type="button" value="提交受理" class="button_normal_long" onclick="save(this,1)">&nbsp;
                        <input type="button" value="保存" id="ok" class="button_confirm" onclick="save(this,0)">&nbsp;
                    </c:if>
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>