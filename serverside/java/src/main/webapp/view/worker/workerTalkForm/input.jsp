<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "projectName", rule: "validate[required]"},
            {name: "formCode", rule: "validate[required]"},
            {name: "content", rule: "validate[required]"},
            {name: "talkTime", rule: "validate[required]"},
            {name: "signDate", rule: "validate[required"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        var unitName1 = $("#unitName1").val();
        var unitName2 = $("#unitName2").val();
        if ("" == unitName1 && "" == unitName2) {
            $.messager.alert("提示", "请输入谈话单位!");
            return
        }
        $("#talkTime").val($("#talkTime").val().replace("年","-").replace("月","-").replace("日","").replace("时",":00:00.0"));
        //提交表单
        saveAjaxData("${ctx}/workerTalkForm/save.do", formId);
    }
    var id_ext = 0;
    function calendarTalk(objName) {
        var json = "dateFmt:'yyyy年MM月dd日 HH时'";
        if (objName != null && objName != "") {
            //如果传过来的为object则取name，兼容之前的代码，如calendar(document.getElementById('actStartDate'));
            if (objName instanceof Object || typeof(objName) == 'object') {
                if (!objName.name || null == objName.name) {
                    alert("无法选择日期，未设置元素标识");
                    return;
                }
                if (!objName.id || null == objName.id) {
                    id_ext++;   //针对增减行的需求，name都相同，设置一个唯一的id
                    objName.setAttribute("id", "id_" + id_ext);
                    objName = "id_" + id_ext;

                } else {
                    objName = objName.name;
                }
            }
            if (json != "") {
                json = "el:'" + objName + "'," + json;
            } else {
                json = "el:'" + objName + "'";
            }
        }
        if (json != "") json = "{" + json + "}";
        WdatePicker(eval("(" + json + ")"));
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right">工程名称：</td>
                <td class="form_content">
                    <form:input path="projectName" cssClass="input_text_long"/>
                </td>
                <td class="form_label_right">号：</td>
                <td class="form_content">
                    <form:input path="formCode" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">谈话单位1：</td>
                <td class="form_content" colspan="3">
                    <form:input path="unitName1" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">谈话单位2：</td>
                <td class="form_content" colspan="3">
                    <form:input path="unitName2" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">谈话事由：</td>
                <td class="form_content" colspan="3">
                    <form:textarea path="content" cssClass="input_textarea_long"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">谈话时间：</td>
                <td class="form_content" colspan="3">
                    <input type="text" name="talkTime" id="talkTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.talkTime}" pattern="yyyy年MM月dd日 HH时"/>"
                           readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendarTalk('talkTime')">

                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">签发时间：</td>
                <td class="form_content" colspan="3">
                    <form:input path="signDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('signDate');">

                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">签发人：</td>
                <td class="form_content" colspan="3">
                    <form:input path="signPerson" cssClass="input_text" readonly="true"/>
                    <input type="hidden" name="signPersonid" value=" "/>
                    <input type="button" value=" " class="button_select"
                           onclick="selectSysPerson('signPersonid','signPerson');" title="点击选择人员">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">内部谈话人：</td>
                <td class="form_content" colspan="3">
                    <form:input path="talkPerson" cssClass="input_text" readonly="true"/>
                    <input type="hidden" name="talkPersonid" value=" "/>
                    <input type="button" value=" " class="button_select"
                           onclick="selectSysPerson('talkPersonid','talkPerson');" title="点击选择人员">
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">携带材料：</td>
                <td class="form_content" colspan="3" style="padding-left: 45px">
                    <sys:checkbox name="materialIds" colNum="2" code="${WORKER_TALK_FORM_LISTS}" showType="edit"
                                  checkedNames="${bean.materialIds}" isSaveName="true"
                                  inputType="checkbox"></sys:checkbox>
                </td>
            </tr>

            <tr class="tr_button">
                <td class="form_content" colspan="4" style="text-align: center;">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>