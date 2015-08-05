<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            //{name:"reportDept", rule:"validate[required,maxSize[100]]"},
            //{name:"reportUser", rule:"validate[required,maxSize[50]]"},
            //{name:"reportPerson", rule:"validate[required,maxSize[50]]"},
            //{name:"beginDate", rule:"validate[required,custom[integer],maxSize[4]"},
            //{name:"endDate", rule:"validate[required,custom[integer],maxSize[2]"},
            //{name:"documentId", rule:"validate[required,custom[integer],maxSize[10]"},
            //{name:"status", rule:"validate[required,custom[integer],maxSize[2]"},
            //{name:"zrOpinion", rule:"validate[required,maxSize[
            //{name:"zrAuditTime", rule:"validate[required,maxSize[7]]"},
            //{name:"zrAuditUser", rule:"validate[required,maxSize[100]]"},
            //{name:"kzOpinion", rule:"validate[required,maxSize[
            //{name:"kzAuditTime", rule:"validate[required,maxSize[7]]"},
            //{name:"kzAuditUser", rule:"validate[required,maxSize[100]]"},
            //{name:"bgsOpinion", rule:"validate[required,maxSize[
            //{name:"bgsAuditTime", rule:"validate[required,maxSize[7]]"},
            //{name:"bgsAuditUser", rule:"validate[required,maxSize[100]]"},
        ];
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
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //加入其他业务判断
//        if ($('#name').val() == '') {
//            showInfoMsg('请输入姓名！',null);
//            return;
//        }

        //提交表单
        saveAjaxData("${ctx}/oaWorkWatch/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

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
                    <form:input path="beginDate" cssClass="input_text"/>
                    ~
                    <form:input path="endDate" cssClass="input_text"/>
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
                <td class="form_border" >
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
        </table>

        <table cellpadding="0" cellspacing="0" class="form_table" style="text-align: center">
            <tr id="standTr" style="display: none">
                <td class="form_border" style="width: 25px">
                    <input type='button' value='删除' class='button_select_remove' onclick='deleteLine(this)'>
                </td>
                <td class="form_border">
                    <input type="text" name="orderNo" style="width: 35px"/>
                </td>
                <td class="form_border">
                    <input type="text" name="content"/>
                </td>
                <td class="form_border">
                    <input type="text" name="timeNode"/>
                </td>

                <td class="form_border">
                    <input type="text" name="reportMethod"/>
                </td>

                <td class="form_border">
                    <input type="text" name="completeDesc"/>
                </td>

                <td class="form_border">
                    <input type="text" name="actualDesc"/>
                </td>
            </tr>

            <tr class="tr_button">
                <td style="text-align: center">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>