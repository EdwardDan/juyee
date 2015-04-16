<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            //{name:"jdTaskCode", rule:"validate[required,maxSize[10]]"},
            //{name:"bjbh", rule:"validate[required,maxSize[50]]"},
            //{name:"gdCode", rule:"validate[required,maxSize[50]]"},
            {name:"gdName", rule:"validate[required,maxSize[100]]"},
            //{name:"belongArea", rule:"validate[required,maxSize[50]]"},
            //{name:"streetArea", rule:"validate[required,maxSize[50]]"},
            //{name:"longitude", rule:"validate[required,custom[number],maxSize[18]"},
            //{name:"latitude", rule:"validate[required,custom[number],maxSize[18]"},
            //{name:"devName", rule:"validate[required,maxSize[50]]"},
            {name:"devSn", rule:"validate[required,maxSize[25]]"},
            {name:"devMode", rule:"validate[required,maxSize[25]]"},
            {name:"devSim", rule:"validate[required,custom[phone],maxSize[20]]"},
            //{name:"devIp", rule:"validate[required,maxSize[50]]"},
            //{name:"currentLongitude", rule:"validate[required,custom[number],maxSize[18]"},
            //{name:"currentLatitude", rule:"validate[required,custom[number],maxSize[18]"},
            //{name:"positionTime", rule:"validate[required,maxSize[19]]"},
            //{name:"lastOnlineTime", rule:"validate[required,maxSize[19]]"},
            //{name:"onlineStatus", rule:"validate[required,custom[integer],maxSize[10]"},
            //{name:"isSync", rule:"validate[required,maxSize[1]]"},
            {name:"regDateTime", rule:"validate[required,maxSize[19]]"}//,
            //{name:"regUserName", rule:"validate[required,maxSize[50]]"},
            //{name:"cancelDateTime", rule:"validate[required,maxSize[19]]"},
            //{name:"cancelStatus", rule:"validate[required,custom[integer],maxSize[10]"},
            //{name:"cancelUserName", rule:"validate[required,maxSize[50]]"},
            //{name:"guid", rule:"validate[required,maxSize[50]]"},
        ];
        validateInit(validateCondition, formId);

        var gn = "${bean.gdName}";
        if (gn != null && gn != "" && gn != undefined) {
            getGdInfoSelect(1);
        }
    });

    //重新标注考勤工地后回调设置编辑页面的经纬度。
    function setPostion(lng, lat){
        $("#longitude").val(lng);
        $("#latitude").val(lat);
    }
    //保存操作
    function save(btn) {
        disableBtn(btn);
        if($("#gdCode").val() == null || $("#gdCode").val() == ""){
            alert("请选择一个工地！");
            enableBtn(btn);
            return;
        }

        if (!validateForm(formId)) {
            enableBtn(btn);
            return;
        }

        if (!checkDevSn()) {
            enableBtn(btn);
            return;
        }

        if (!checkDevSim()) {
            enableBtn(btn);
            return;
        }

        //如果监督任务书编号为空，则设置根据监督任务书编号获得的所有字段为空。
        var a = $("#jdTaskCode");
        a.val($.trim(a.val()));
        var v = a.val();
        if (v == null || v == "") {
            $("#bjbh").val("");
            $("#gdCode").val("");
            $("#gdName").val("");
            $("#projectName").html("");
        }

        //提交表单
        saveAjaxData("${ctx}/checkDeviceInfo/save.do", formId);
    }

    //获取工程信息
    function getProjectInfo() {

        var v = $("#selectGd").val();
        if (v == null || v == "" || v == undefined) {
            $("#bjbh").val("");
            $("#gdCode").val("");
            $("#gdName").val("");
            $("#projectName").html("");
            return;
        }
        $("#gdCode").val(v);

        $.ajax({
            url:"${ctx}/checkDeviceInfo/getProjectInfo.do?gdCode=" + v,
            cache:false,
            data:"",
            success:function (ret) {
                $("#projectDiv").html(ret);
                $("#bjbh").val($("#bjbhNew").val());
                $("#gdName").val($("#gdNameNew").val());
                $("#projectName").html($("#projectNameNew").val());
                $("#buttonGet").val("获取");
                $("#buttonGet").disabled = false;
            }, error:function () {
                $("#projectDiv").html(errAjaxMsg);
                $("#buttonGet").val("获取");
                $("#buttonGet").disabled = false;
            }
        });
    }

    //获取监督任务书编号下的工地信息
    function getGdInfoSelect(flag) {
//        if (flag != 1) {
//            $("#bjbh").val("");
//            $("#gdCode").val("");
//            $("#gdName").val("");
//            $("#projectName").html("");
//        }
        var b = $("#gdCode").val();
        var a = $("#jdTaskCode");
        a.val($.trim(a.val()));
        var v = a.val();
        if (v == null || v == "") {
            showInfoMsg("请先输入监督任务书编号");
            return;
        }
        $("#buttonGet").val("请稍候");
        $("#buttonGet").disabled = true;
        $.ajax({
            url:"${ctx}/checkDeviceInfo/getGdInfoSelect.do?jdTaskCode=" + v + "&gdCode=" + b,

            cache:false,
            data:"",
            success:function (ret) {
                $("#gdNameSelect").html(ret);
                $("#buttonGet").val("获取");
                $("#buttonGet").disabled = false;
                getProjectInfo();
            }, error:function () {
                $("#projectDiv").html(errAjaxMsg);
                $("#buttonGet").val("获取");
                $("#buttonGet").disabled = false;
            }
        });
    }

    //检查设备编号是否已经被使用。
    function checkDevSn() {
        var v = $("#devSn").val();
        var id = $("#id").val();
        if (v != null && v != "") {
            var msg = getAjaxData("${ctx}/checkDeviceInfo/checkDevSn.do?devSn=" + v + "&id=" + id);
            if (msg.success == "false") {
                showErrorMsg("设备编号“" + v + "”已经被使用，请使用其他编号！");
                return false;
            }
        }
        return true;
    }

    //检查设备SIM卡号是否已经被使用。
    function checkDevSim() {
        var v = $("#devSim").val();
        var id = $("#id").val();
        if (v != null && v != "") {
            var msg = getAjaxData("${ctx}/checkDeviceInfo/checkDevSim.do?devSim=" + v + "&id=" + id);
            if (msg.success == "false") {
                showErrorMsg("设备SIM卡号“" + v + "”已经被使用，请使用其他卡号！");
                return false;
            }
        }
        return true;
    }

    function doSet(button) {
        var id = $("#id").val();
        if (id == null || id == "" || id == undefined) {
            showErrorMsg("请先保存输入的信息，再进行地图标注！");
            return;
        }
        openFullWindow("${ctx}/checkDeviceInfo/map.do?id=" + id, 900, 600);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="bjbh"/>
    <form:hidden path="gdName"/>
    <form:hidden path="gdCode"/>
    <div style="DISPLAY: null" id="projectDiv"></div>
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right" width="16%">监督任务书编号：</td>
                <td class="form_content" nowrap="true" width="34%">
                    <form:input path="jdTaskCode" cssClass="input_text" cssStyle="float:left;width: 100px"/>
                    <input type="button" value="获取" class="button_all" onclick="getGdInfoSelect()" id="buttonGet"
                           style="float:left;">
                </td>

                <td class="form_label_right" width="11%">工程名称：</td>
                <td class="form_content">
                    &nbsp;<span id="projectName" name="projectName">${project.data.projectName}</span>
                </td>

            </tr>

            <tr class="tr_dark">
                <td class="form_label_right">工地名称：</td>
                <td class="form_content" id="gdNameSelect" name="gdNameSelect" colspan="3">
                    &nbsp;
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right">工地经度：</td>
                <td class="form_content">
                    <form:input path="longitude" cssClass="input_text" readonly="true"/>
                </td>

                <td class="form_label_right">工地纬度：</td>
                <td class="form_content">
                    <form:input path="latitude" cssClass="input_text" readonly="true"/>
                    <input type="button" class="button_normal_long" value="重新定位" onclick="doSet(this)"/>
                </td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label_right">设备编号：</td>
                <td class="form_content">
                    <form:input path="devSn" cssClass="input_text"/>
                </td>

                <td class="form_label_right">设备型号：</td>
                <td class="form_content">
                    <form:input path="devMode" cssClass="input_text"/>
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right">设备SIM卡：</td>
                <td class="form_content">
                    <form:input path="devSim" cssClass="input_text"/>
                </td>

                <td class="form_label_right">注册时间：</td>
                <td class="form_content">
                    <input type="text" name="regDateTime" id="regDateTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.regDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                           readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('regDateTime','all')">

                </td>
            </tr>

            <tr class="tr_button">
                <td class="form_content" colspan="4" style="text-align:center">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>