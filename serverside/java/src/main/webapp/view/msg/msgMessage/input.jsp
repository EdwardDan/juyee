<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    var msgMaxLength = 260;
    var signMaxLength = 10;
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"content", rule:"validate[required,maxSize[250]]"},
            {name:"innerPersonIds", rule:"validate[required,maxSize[1000]]"},
            {name:"gdPersonIds", rule:"validate[maxSize[1000]]"},
            {name:"mobiles", rule:"validate[maxSize[1000]]"}
        ];
        validateInit(validateCondition, formId);
    });

    /**
     * 去除select中重复的选项。
     */
    function removeRepeatInner() {
        var select = document.getElementById("innerPerson");
        removeRepeatOption(select);
    }

    /**
     * 去除select中重复的选项。
     */
    function removeRepeatGd() {
        var select = document.getElementById("gdPerson");
        removeRepeatOption(select);
    }

    //输入时统计剩余字数
    function RecountNum() {
        var maxLength = msgMaxLength - signMaxLength;
        var text = document.getElementById('content').value;
        var remainLength = maxLength - text.length;
        if (remainLength >= 0) {
            document.getElementById('remainLength').innerHTML = "还剩" + remainLength + "字可以输入";
        } else {
            document.getElementById('remainLength').innerHTML = "<font color='red'>消息内容不能超过" + maxLength + "字！</font>";
        }
    }

    //检验手机号中是否带非法字符
    function checkMobiles() {
        var mobiles = document.getElementById('mobiles').value;
        if (mobiles == '')
            return true;

        while (mobiles.indexOf(',') > -1) {
            mobiles = mobiles.replace(',', '');
        }
        while (mobiles.indexOf('，') > -1) {
            mobiles = mobiles.replace('，', '');
        }
        var reg = /^\d+$/;
        if (reg.test(mobiles)) {
            return true;
        }

        return false;sh
    }

    /**
     * 检查手动输入的电话号码是否符合手机号码规范。
     */
    function checkInputMobilesNormal() {
        var v = document.getElementById('mobiles');
        var mobiles = v.value;
        var reg = /^1[3|4|5|7|8][0-9]\d{8}$/;
        if (mobiles != null && mobiles != "") {
            if (mobiles.indexOf(",") == -1) {
                if (!reg.test(mobiles)) {
                    showInfoMsg('“' + mobiles + '”是无效的手机号码！', null);
                    return false;
                }
            } else {
                var arr = mobiles.split(",");
                var length = arr.length;
                for (var i = 0; i < length; i++) {
                    if (!reg.test(arr[i])) {
                        showInfoMsg('“' + arr[i] + '”是无效的手机号码！', null);
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 将输入的电话号码字符串中的中文“，”转换为英文的“,”，并去除多月的“,”。
     */
    function reviseMobilesString() {
        var v = document.getElementById('mobiles');
        var mobiles = v.value;
        while (mobiles.indexOf('，') > -1) {
            mobiles = mobiles.replace('，', ',');
        }

        var arr = mobiles.split(",");
        var newMobiles = "";
        var length = arr.length;
        for (var i = 0; i < length; i++) {
            if (arr[i] != null && arr[i] != "") {
                newMobiles += arr[i] + ",";
            }
        }
        if (newMobiles != null && newMobiles != "") {
            newMobiles = newMobiles.substring(0, newMobiles.length - 1);
        }
        v.value = newMobiles;
    }

    /**
     * 将所有的option电话号码放入隐藏的对应字段中。
     */
    function getMobilesToHiddenPath() {
        document.getElementById("innerPersonIds").value = getSelectValues(document.getElementById("innerPerson"));
        document.getElementById("gdPersonIds").value = getSelectValues(document.getElementById("gdPerson"));
    }

    //保存操作
    function save(btn) {

        getMobilesToHiddenPath();

        if (!checkMobiles()) {
            showInfoMsg('输入的手机号码含有字母或文字或特殊符号！', null);
            return false;
        }

        reviseMobilesString();

        if (!checkInputMobilesNormal()) {
            return false;
        }

        if (!validateForm(formId)) {
            return;
        }

        disableBtn(btn);

        //提交表单
        $("#isSend").val("0");
        saveAjaxData("${ctx}/msgMessage/save.do", formId, null);
    }

    //发送操作
    function send(btn) {

        getMobilesToHiddenPath();

        if (!checkMobiles()) {
            showInfoMsg('输入的手机号码含有字母或文字！', null);
            return false;
        }

        reviseMobilesString();

        if (!checkInputMobilesNormal()) {
            return false;
        }

        if (!validateForm(formId)) {
            return;
        }

        if ($('#innerPersonIds').val() == '' && $('#gdPersonIds').val() == '' && $('#mobiles').val() == '') {
            showInfoMsg('接收人不能全为空！', null);
            return;
        }

        //提交表单
        $.messager.confirm('系统提示', '您确定要发送消息吗?', function (r) {
            if (r) {
                $("#isSend").val("1");
                saveAjaxData("${ctx}/msgMessage/save.do", formId, null);
            }
        });
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="isSend"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label">短信内容：</td>
                <td class="form_content">
                    <form:textarea path="content" cssClass="input_textarea" onkeyup="RecountNum()"
                                   onmouseup="RecountNum()" onmouseover="RecountNum()"/>
                    <span id="remainLength"></span>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">内部接收人：</td>
                <td class="form_content">
                    <select multiple="multiple" id="innerPerson" name="innerPerson"
                            style="width:250px;height:110px;">
                        <c:forEach items="${innerPersons}" var="item">
                            <option value="${item.id}">${item.name}</option>
                        </c:forEach>
                            </select>
                    <input type="button" value=" " class="button_select_add"
                           onclick="multiSelectSysPerson('innerPerson','innerPersonIds','innerPersonNames')"
                           title="点击选择内部接收人">
                    <input type="button" value=" " class="button_select_remove"
                           onclick="removeMultiSelectOpt('innerPerson','innerPersonIds','innerPersonNames')"
                           title="点击移除内部接收人">
                    <input type="hidden" id="innerPersonIds" name="innerPersonIds" value="${bean.innerPersonIds}">
                    <input type="hidden" id="innerPersonNames" name="innerPersonNames" value="${bean.innerPersonNames}">
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">工地管理人员：</td>
                <td class="form_content">
                    <select multiple="multiple" id="gdPerson" name="gdPerson"
                            style="width:250px;height:110px;">
                        <c:forEach items="${gdPersons}" var="item">
                            <option value="${item.id}">${item.name}</option>
                        </c:forEach>
                            </select>
                    <input type="button" value=" " class="button_select_add"
                           onclick="multiSelectSysRegPerson('gdPerson','gdPersonIds','gdPersonNames',removeRepeatGd)"
                           title="点击选择工地管理人员">
                    <input type="button" value=" " class="button_select_remove"
                           onclick="removeMultiSelectOpt('gdPerson','gdPersonIds','gdPersonNames')" title="点击移除工地管理人员">
                    <input type="hidden" id="gdPersonIds" name="gdPersonIds" value="${bean.gdPersonIds}">
                    <input type="hidden" id="gdPersonNames" name="gdPersonNames" value="${bean.gdPersonNames}">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">临时接收人：</td>
                <td class="form_content">
                    <form:textarea path="mobiles" cssClass="input_textarea"/>&nbsp;多个号码需用分号“,”隔开
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">是否发送短信：</td>
                <td class="form_content">
                    <input type="radio" name="isSendSms" value="1" <c:if test="${bean.isSendSms==true}">checked</c:if>>是
                    <input type="radio" name="isSendSms" value="0" <c:if test="${bean.isSendSms==false}">checked</c:if>>否
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_label"></td>
                <td class="form_content">
                    <input type="button" value="发送" class="button_confirm" onclick="send(this)">&nbsp;
                    <input type="button" value="保存" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>