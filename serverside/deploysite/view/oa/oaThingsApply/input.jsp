<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(status, btn) {
        if (!validateForm(formId)) {
            return;
        }
        //防止新增时直接保存出错
        if ($("#tableThingDiv").html() == '' && ${fn:length(bean.oaThingsApplyItems)==0}) {
            showInfoMsg("请添加记录！");
            return;
        }

        //提交表单
        if (btn.value == "提交") {
            if (confirm("确定要提交吗？")) {
                saveAjaxData("${ctx}/oaThingsApply/saveInput.do?status=" + status, formId);
            }
        } else {
            saveAjaxData("${ctx}/oaThingsApply/saveInput.do?status=" + status, formId);
        }
    }

    function addLine(obj) {
        if (obj.value == "添加") {
            $("#tableThingDiv").append($("#hiddenStyle").html());
        } else {
            if (confirm("确定要删除吗!")) {
                var trObj = obj.parentNode.parentNode;
                trObj.parentElement.removeChild(trObj);
                sumMoney(); //删除明细时重新计算总价
            }
        }
    }
    //选择办公用品-单选
    function selectOaThings(inputId, inputName, callback) {
        var icon = addIcons("company.gif,dept.gif,person.gif");
        new PopTree({
            url:CONTEXT_NAME + '/oaThingsApply/treeDataForSelect.do?icon=' + icon,
            targetId:inputId,
            targetValueId:inputName,
            callback:callback
        });
    }
    function selectLine(obj) {
        var p = $(obj).parent('td');
        var inputId = p.children("input[name='thingId']");
        var inputName = p.children("input[name='name']");

        selectOaThings(inputId, inputName, function () {
            setThing(obj);
        });
    }
    function setThing(obj) {
        var parent = $(obj).parents('tr');
        var inputId = parent.find("input[name='thingId']").val();
        var json = getAjaxData("${ctx}/oaThingsApply/getThing.do?id=" + inputId);
        var obj = eval(json);
        parent.find("input[name='amount']").val("");
        parent.find("input[name='name']").val(obj["name"]);
        parent.find("input[name='model']").val(obj["model"]);
        parent.find("input[name='price']").val(obj["price"]);
        parent.find("input[name='unit']").val(obj["unit"]);
    }
    $(document).ready(function () {
        sumMoney();
        //文本框值改变即触发
        $(".input_text").live("change", function () {
            sumMoney();
        });
    });
    function sumMoney() {
        var money = parseFloat(0);
        $("input[name='amount']").each(function () {
            if ($(this).val() != '') {
                var parent = $(this).parents('tr');
                var price = parent.find("input[name='price']").val();
                money += parseFloat(this.value * price);
            }
        });
        $("#count").text(money);
    }

</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <%--<form:hidden path="status"/>--%>
    <table cellpadding="0" cellspacing="0" class="form_table" border="0">
        <tr class="tr_title">
            <td >办公用品申请</td>
        </tr>
        </table>
    <fieldset class="form_fieldset">
    <legend class="form_legend">申请信息</legend>
        <table cellpadding="0" cellspacing="0" class="form_table" border="1">
        <tr class="tr_dark">
            <td class="form_border" align="center" colspan="3"> ${bean.applyDept.name}
                <input type="text" name="deptName" id="deptName" class="input_text" value="${bean.applyDept.name}"
                       readonly="true">
                <input type="hidden" name="applyDept" id="applyDept"
                       value="<c:if test="${bean.applyDept!=null}">${bean.applyDept.id}</c:if>"/>
                <input type="button" id="deptSelBtn" value=" " class="button_select"
                       onclick="selectSysDept('applyDept','deptName')"
                       title="点击选择所属单位（部门）">
            </td>
            <td class="form_border" align="center" colspan="3">
                <input type="text" name="userName" id="userName" value="${bean.applyUser.displayName}"
                       class="input_text"
                       readonly="true">
                <input type="hidden" name="applyUser" id="applyUser" value="${bean.applyUser.id}">
                <img src="${themePath}/workflow/user.gif" alt="" border="0"
                     onclick="selectSysUser('applyUser','userName')">
            </td>
        </tr>
        <tr class="tr_header">
            <td width="35%">申请物品</td>
            <td width="15%">型号</td>
            <td width="15%">单位</td>
            <td width="15%">预计单价</td>
            <td width="15%">数量</td>
            <td width="5%" nowrap>
                &nbsp;<input type="button" value="添加" class="button_select_add" onclick="addLine(this)"/>
            </td>
        </tr>
        <c:if test="${not empty bean.oaThingsApplyItems && bean.oaThingsApplyItems != null}">
            <c:forEach items="${bean.oaThingsApplyItems}" var="item">
                <tr class="tr_dark">
                    <td>
                        <input type="hidden" name="thingId" value="${item.oaThings.id}">
                        <input type="text" name="name" class="input_text" style="width:98%;background-color: #deedf7;"
                               value="${item.name}"
                               title="${item.name}" ondblclick="selectLine(this)">
                    </td>
                    <td>
                        <input type="text" name="model" class="input_text" style="width: 95%" value="${item.model}"
                               title="${item.model}">
                    </td>

                    <td>
                        <input type="text" name="unit" class="input_text" style="width: 95%" value="${item.unit}"
                               title="${item.unit}">
                    </td>
                    <td>
                        <input type="text" name="price" class="input_text" style="width: 95%" value="${item.price}"
                               title="${item.price}">
                    </td>
                    <td>
                        <input type="text" name="amount" class="input_text" style="width: 95%" value="${item.amount}"
                               title="${item.amount}">
                    </td>
                    <td><input type="button" value="删除" class="button_select_remove" onclick="addLine(this)"/>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <tbody id="tableThingDiv"></tbody>
            <%--标准行迁入--%>
        <tr class="tr_dark">
            <td colspan="4" align="right"><b>预计总价</b></td>
            <td colspan="2" align="left"><span id="count">${count}</span></td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">申请说明：</td>
            <td class="form_content" colspan="5">
                <form:textarea path="applyContent" cssClass="input_textarea_long"/>
            </td>
        </tr>
    </table>
    </fieldset>
    <div class="tr_button" style="text-align: center">
        <input type="button" value="提交" class="button_confirm" onclick="save('${STATUS_SUBMIT}',this)">&nbsp;
        <input type="button" value="暂存" class="button_confirm" onclick="save('${STATUS_EDIT}',this)">&nbsp;
        <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
    </div>
</form:form>
<table style="display: none;" cellpadding="0" cellspacing="0" class="form_table" border="0">
    <tbody id="hiddenStyle">
    <tr class="tr_dark"><%--标准行--%>
        <td >
            <input type="hidden" name="thingId">
            <input type="text" name="name" class="input_text" style="width:98%;background-color: #deedf7;"
                   ondblclick="selectLine(this)">
        </td>
        <td >
            <input type="text" name="model" class="input_text" style="width: 95%">
        </td>
        <td >
            <input type="text" name="unit" class="input_text" style="width: 95%">
        </td>
        <td>
            <input type="text" name="price" class="input_text" style="width: 95%">
        </td>
        <td >
            <input type="text" name="amount" class="input_text" style="width: 95%">
        </td>
        <td ><input type="button" value="删除" class="button_select_remove" onclick="addLine(this)"/></td>
    </tr>
    </tbody>
</table>
