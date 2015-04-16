<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    var userIds = "${userIds}";
    $(function () {

        //页面验证初始化
        var validateCondition = [
            {name:"name", rule:"validate[required,maxSize[25]]"},
            {name:"memo", rule:"validate[maxSize[250]]"}
        ];
        validateInit(validateCondition, formId);

    });

    /**
     * 删除工作组成员行，从userIds中删除该成员id。
     */
    function deleteAttachRow(rowId) {
        //        //删除行
        if (confirm("确定要删除吗!")) {
            $("#" + rowId).remove();

            //从userIds中删除该id
            var idAll = userIds.split(",");
            if (idAll.length == 1) {
                userIds = null;
            } else {
                var lengthAll = idAll.length;
                var tempId = "";
                //            var j = 0;
                for (var i = 0; i < lengthAll; i++) {
                    if (idAll[i] != rowId) {
                        tempId += idAll[i] + ",";
                        //                    if (j == 0) {
                        //                        userIds = idAll[i];
                        //                        j++;
                        //                    } else {
                        //                        userIds += "," + idAll[i];
                        //                    }
                    }
                }
                userIds = tempId.substring(0, tempId.length - 1);
            }
        }
    }

    /**
     * 增加新的工作组成员行，并进行判断如果存在改行则不再添加。
     */
    function addUserRow() {

        var userId = document.getElementById("userId").value;

        if (userIds == "" || userIds == null) {
            userIds = userId;
        } else {

            var idAll = userIds.split(",");
            var idSelect = userId.split(",");

            var lengthAll = idAll.length;
            var lengthSelect = idSelect.length;

            for (var i = 0; i < lengthAll; i++) {
                for (var j = 0; j < lengthSelect; j++) {
                    if (idSelect[j] == idAll[i]) {
                        idSelect[j] = -1;
                    }
                }
            }

            var tempId = "";
            for (var k = 0; k < idSelect.length; k++) {
                if (idSelect[k] != -1) {
                    tempId += idSelect[k] + ",";
                }
            }
            if (tempId != null && tempId != "") {
                userId = tempId.substring(0, tempId.length - 1);
                userIds += "," + userId;
            } else {
                userId = null;
            }
        }
        if (userId != null && userId != "") {
            $.ajax({
                type:'POST',
                url:"${ctx}/pollingWorkGroup/getUserRow.do",
                cache:false,
                data:"userId=" + userId,
                success:function (html) {
                    $("#table_list").append(html);
                }
            });
        }
    }

    /**
     * 去除select中重复的选项。
     */
    function removeRepeat() {
        var select = document.getElementById("belongArea");
        removeRepeatOption(select);
    }


    //保存操作
    function save(btn) {
        var ids = getSelectValues(document.getElementById("belongArea"));
        var a = document.getElementById("belongAreaId");
        a.value = ids;

        if (!validateForm(formId)) {
            return;
        }
        disableBtn(btn);
        //提交表单
        saveAjaxData("${ctx}/pollingWorkGroup/save.do?userIds=" + userIds, formId);

    }


</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right" width="25%">工作组名称：</td>
                <td class="form_content">
                    <form:input path="name" cssClass="input_text_long"/>
                </td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label_right">
                    责任区域：
                </td>
                <td class="form_content">
                    <select multiple="multiple" id="belongArea" name="belongArea"
                            style="width:250px;height:110px;">${belongAreaOptions}</select>
                    <input type="button" value=" " class="button_select_add"
                           onclick="multiSelectSysCode('${zrqu}','belongArea','belongAreaId','',removeRepeat)"
                           title="点击选择责任区域">
                    <input type="button" value=" " class="button_select_remove"
                           onclick="removeMultiSelectOpt('belongArea','belongAreaId','')" title="点击移除责任区域">
                    <input type="hidden" id="belongAreaId" name="belongAreaId" value="">
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right">工作组成员：</td>
                <td bgcolor="white">
                    <table border="0" cellpadding="1" cellspacing="1" style="border-color:white" class="form_table"
                           id="table_list">
                        <tr class="tr_light">
                            <td>姓名</td>
                            <td>所属部门</td>
                            <td>负责人</td>
                            <td>
                                <input type="button" value="添加" class="button_all"
                                       onClick="multiSelectSysUser('SysUser','userId','sysUserName',addUserRow)">
                                <input type="hidden" id="userId" name="userId" value="">
                            </td>
                        </tr>
                        <c:forEach items="${userList}" var="item">
                            <tr class="tr_dark" id="${item.sysUserId}">
                                <td>${item.userName}</td>
                                <td>${item.deptName}</td>
                                <td>
                                    <select id="isCharge${item.sysUserId}" name="isCharge${item.sysUserId}" class="form_select" style="width: 42px">
                                        <option value="0" <c:if test="${!item.isCharge}">selected </c:if>>否</option>
                                        <option value="1" <c:if test="${item.isCharge}">selected</c:if>>是</option>
                                    </select>
                                </td>
                                <td>
                                    <input type="button" class="button_normal" value="删除" onClick="deleteAttachRow('${item.sysUserId}')">
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">备注：</td>
                <td class="form_content">
                    <form:textarea path="memo" cssClass="input_textarea"/>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_border" colspan="2">
                    <input type="button" name="btn" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>