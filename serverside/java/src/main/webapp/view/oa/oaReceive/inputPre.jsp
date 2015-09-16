<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "fileCode", rule: "validate[required,maxSize[100]]"},
            {name: "title", rule: "validate[required,maxSize[250]]"},
            {name: "sourceDept", rule: "validate[maxSize[250]]"},
            {name: "receiveDate", rule: "validate[maxSize[20]"},
            {name: "deptName", rule: "validate[maxSize[100]]"},
            {name: "writtenDate", rule: "validate[maxSize[20]"},
            {name: "limitDate", rule: "validate[maxSize[20]"},
            {name: "fs", rule: "validate[custom[integer],maxSize[6]"},
            {name: "ys", rule: "validate[custom[integer],maxSize[6]"}
        ];
        validateInit(validateCondition, formId);
        doLwwh($("#lwdw").val());
    });

    //保存操作
    function save(operationId, btn) {
        if (!validateForm(formId)) {
            return;
        }
        //提交表单
        saveAjaxData("${ctx}/oaReceive/savePre.do?operationId=" + operationId, formId);
    }
    function doLwwh(objVal) {
        loadAjaxDataCallback(null, "${ctx}/oaReceive/getLwwh.do?lwdwId=" + objVal, getLwwh);
    }
    function getLwwh(ret) {
        var obj = eval("(" + ret + ")");
        if (obj.success == true) {
            $("#fileCode").val(obj.lwwh);
        }
    }
</script>
<style type="text/css">
    .td_border {
        /*border: 1px solid;*/
        border-top-width: 1px;
        border-bottom-width: 1px;
        border-left-width: 1px;
        border-right-width: 1px;
        border-top-style: solid;
        border-bottom-style: solid;
        border-left-style: solid;
        border-right-style: solid;
        border-top-color: #333;
        border-bottom-color: #333;
        border-left-color: #333;
        border-right-color: #333;
    }
</style>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <input type="hidden" name="node" id="node" value="${node.id}">
    <input type="hidden" name="step" id="step" value="${bean.step.id}">
    <input type="hidden" name="openTime" id="openTime" value="${openTime}">

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table" style="border-collapse: collapse">
            <tr>
                <td class="head_title form_border" colspan="6">上海市交通建设工程管理中心文件处理单</td>
            </tr>
            <tr class="tr_light">
                <td class="form_content" colspan="4">&nbsp;&nbsp;文件类型： <sys:code code="${type}" type="select"
                                                                                 name="type" id="type"
                                                                                 sysCodeDetailId="${bean.type.id}"/></td>
                <td class="form_label" align="right" colspan="2">
                    沪建管（<select name="year" class="form_select" style="width: 60px;">${yearOption}</select>）
                    <select name="codeType" id="codeType" class="form_select" style="width: 50px;">
                        <option value="sw">收委</option>
                        <option value="sh">收横</option>
                        <option value="ss">收受</option>
                    </select>
                    <form:input path="orderNo" cssClass="input_text" cssStyle="width: 30px;text-align: center;"/>号&nbsp;&nbsp;
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="td_border" align="right">来文文号：</td>
                <td class="td_border" align="left" colspan="3">
                    <input name="fileCode" id="fileCode" value="${bean.fileCode}" class="input_text_long"
                           style="width: 80%">
                </td>
                <td class="td_border" align="right">办理时限：</td>
                <td class="td_border" align="left">
                    <form:input path="limitDate" cssClass="input_datetime" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('limitDate','all');">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="td_border" align="right">标题：</td>
                <td class="td_border" align="left" colspan="5">
                    <input name="title" id="title" value="${bean.title}" class="input_text_long" style="width: 80%">
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="td_border" align="right">来文单位：</td>
                <td class="td_border" align="left" colspan="3">
                    <sys:code code="${lwdw}" type="select" name="lwdw" id="lwdw" sysCodeDetailId="${bean.lwdw.id}"
                              onChange="doLwwh(this.value);" style="width:80%;"/>
                        <%--<input name="sourceDept" id="sourceDept" value="${bean.sourceDept}" class="input_text_long" style="width: 80%">--%>
                </td>
                <td class="td_border" align="right">份数：</td>
                <td class="td_border" align="left">
                    <form:input path="fs" cssClass="input_text"/>
                </td>
            </tr>

            <tr class="tr_light">
                <td class="td_border" align="right" style="width: 10%;">登记日期：</td>
                <td class="td_border" align="left" style="width: 23%;">
                    <form:input path="receiveDate" cssClass="input_datetime" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('receiveDate','all');">
                </td>
                <td class="td_border" align="right" style="width: 10%;">成文日期：</td>
                <td class="td_border" align="left" style="width: 23%;">
                    <form:input path="writtenDate" cssClass="input_datetime" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('writtenDate','all');">
                </td>
                <td class="td_border" align="right" style="width: 10%;">页数：</td>
                <td class="td_border" align="left" style="width: 24%;">
                    <form:input path="ys" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="td_border" align="right">提供部门：</td>
                <td class="td_border" align="left" colspan="3">
                    <input name="deptName" id="deptName" value="${bean.deptName}" class="input_text_long"
                           style="width: 80%">
                </td>
                <td class="td_border" align="right">密级：</td>
                <td class="td_border" align="left">
                    <sys:code code="${secret}" type="select" name="secret" id="secret"
                              sysCodeDetailId="${bean.secret.id}"/>
                </td>
            </tr>


            <tr class="tr_light">
                <td class="td_border" align="right">紧急程度：</td>
                <td class="td_border" align="left">
                    <sys:code code="${urgent}" type="select" name="urgent" id="urgent"
                              sysCodeDetailId="${bean.urgent.id}"/>
                </td>
                <td class="td_border" align="right">公文种类：</td>
                <td class="td_border" align="left">
                    <sys:code code="${fileType}" type="select" name="fileType" id="fileType"
                              sysCodeDetailId="${bean.fileType.id}"/>
                </td>
                <td class="td_border" align="right">牵头部门：</td>
                <td class="td_border" align="left">
                    <form:input path="startDept" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="td_border" align="right">附件：</td>
                <td class="td_border" align="left" colspan="5">
                    &nbsp;<c:forEach items="${docAttachs}" var="docName">&nbsp;${docName.fileName}&nbsp;
                </c:forEach>${uploadButton}
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_border" align="center" colspan="6">
                    <c:forEach items="${operations}" var="operation">
                        <input type="button" value="${operation.name}" class="button_normal_longer"
                               onclick="save('${operation.id}',this.value)">&nbsp;
                    </c:forEach>
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>