<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            //{name:"orderNo", rule:"validate[required,custom[integer],maxSize[10]"},
            //{name:"code", rule:"validate[required,maxSize[100]]"},
            //{name:"name", rule:"validate[required,maxSize[100]]"},
            //{name:"isJoin", rule:"validate[required,maxSize[1]]"},
            //{name:"createTime", rule:"validate[required,maxSize[7]]"},
            //{name:"createUser", rule:"validate[required,maxSize[100]]"},
            //{name:"updateTime", rule:"validate[required,maxSize[7]]"},
            //{name:"updateUser", rule:"validate[required,maxSize[100]]"},
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        var isSave = true;
        if (!validateForm(formId)) {
            return;
        }
        $("#standTr").remove();
        $("input[name='operationCode']").each(function () {
            var code = $(this).val();
            if (null == code || '' == code) {
                showInfoMsg("编码不能为空");
                isSave = false;
                return false;
            }
        });
        //提交表单
        if (isSave) {
            saveAjaxData("${ctx}/oaReceiveStep/save.do", formId);
        }
    }
    function deleteLine(obj) {
        $(obj).parent().parent().remove();
    }
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
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right" width="20%">步骤序号：</td>
                <td class="form_content" width="30%">
                    <form:input path="orderNo" cssClass="input_text"/>
                </td>
                <td class="form_label_right" width="20%">流转步骤种类：</td>
                <td class="form_content" width="30%">
                    <form:input path="code" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
            <td class="form_label_right" width="20%">流转步骤名称：</td>
            <td class="form_content" width="30%">
                <form:input path="name" cssClass="input_text"/>
            </td>
            <td class="form_label_right" width="20%">是否会签：</td>
            <td class="form_content" width="30%">
                <form:checkbox path="isJoin" value="1"/>
            </td>
        </tr>
            <tr class="tr_dark">
                <td class="form_border" align="center" style="font-weight: bold;font-size: 17px" colspan="4">流转操作</td>
            </tr>
            </table>
        <table cellpadding="0" cellspacing="0" border="1" class="table_thin_line" style="text-align: center;width: 98%;"
               id="itemTable">
            <tr class="tr_header">
                    <td style="width:5%;">
                        <input type='button' value='新增' class='button_select_add' onclick='addLine()'>
                    </td>
                <td style="width: 25%;">操作编码</td>
                <td style="width: 20%;;">操作名称</td>
                <td style="width: 10%;">是否有效</td>
            </tr>
            <c:forEach items="${bean.oaReceiveOperations}" var="item">
                <tr class="tr_light">
                        <td>
                            <input type='button' value='删除' class='button_select_remove' onclick='deleteLine(this)'>
                        </td>
                    <td>
                        <input type="text" name="operationCode" class="input_text" style="width: 96%;" value="${item.code}"/>
                    </td>
                    <td>
                        <input type="text" name="operationName" class="input_text" style="width: 96%;" value="${item.name}" />
                    </td>
                    <td>
                        <select name="operationIsValid">
                            <option value="true" <c:if test="${item.isValid =='1'}"> selected </c:if> >是</option>
                            <option value="false" <c:if test="${item.isValid =='0'}">selected </c:if> >否</option>
                        </select>
                    </td>
                </tr>
            </c:forEach>
            <tr id="standTr" style="display: none;">
                <td style="width: 25px">
                    <input type='button' value='删除' class='button_select_remove' onclick='deleteLine(this)'>
                </td>
                <td>
                    <input type="text" name="operationCode" style="width: 96%;" class="input_text"/>
                </td>
                <td>
                    <input type="text" name="operationName" style="width: 96%;" class="input_text" />
                </td>

                <td>
                    <select name="operationIsValid">
                        <option value="true" <c:if test="${item.isValid =='1'}"> selected </c:if> >是</option>
                        <option value="false" <c:if test="${item.isValid =='0'}">selected </c:if> >否</option>
                    </select>
                </td>
            </tr>
        </table>
        <table  cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_button" >
                <td class="form_border" align="center">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>