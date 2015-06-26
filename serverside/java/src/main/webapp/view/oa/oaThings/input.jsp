<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        //判断是否添加记录
        if (${bean.id==null}) {
            if ($("#tableThingDiv").html() == '') {
                showInfoMsg("请添加至少一个办公用品！");
                return;
            }
        }

        //加入其他业务判断
        var pdName = true;
        var pdAmount = true;
        var pdPrice = true;
        var reg = new RegExp("^[1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0$");

        //添加时验证格式
        $('table tbody[id=tableThingDiv] input[name=namel]').each(function () {
                    if ($(this).val() == '') {
                        $(this).css('background', '#FF3366');
                        alert("请输入办公用品名称!");
                        pdName = false;
                        return false;
                    }
                }
        );
        $('table tbody[id=tableThingDiv] input[name=pricel]').each(function () {
                    if (!reg.test($(this).val())) {
                        $(this).css('background', '#FF3366');
                        alert("请输入正确的单价!");
                        pdPrice = false;
                        return false;
                    }
                }
        );
        $('table tbody[id=tableThingDiv] input[name=amountl]').each(function () {
                    if (!reg.test($(this).val())) {
                        $(this).css('background', '#FF3366');
                        alert("请输入正确的库存!");
                        pdAmount = false;
                        return false;

                    }
                }
        );

        //编辑时格式验证
        if (${bean.id!=null}) {
            if ($('input[name=name]').val() == '') {
                showInfoMsg("请输入办公用品名称！");
                pdName = false;
                return;
            }
            if (!reg.test($('input[name=price]').val())) {
                showInfoMsg("请输入正确的单价！");
                pdPrice = false;
                return;
            }
            if (!reg.test($('input[name=amount]').val())) {
                showInfoMsg("请输入正确的库存！");
                pdAmount = false;
                return;
            }
        }

        //验证通过后提交表单
        if (pdName && pdAmount && pdPrice) {
            saveAjaxData("${ctx}/oaThings/save.do", formId);
        }

    }

    function addLine(obj) {
        if (obj.value == "添加") {
            $("#tableThingDiv").append($("#hiddenStyle").html());
        } else {
            if (confirm("确定要删除吗!")) {
                var trObj = obj.parentNode.parentNode;
                trObj.parentElement.removeChild(trObj);
            }
        }
    }
</script>

<form:form commandName="bean">
    <form:hidden path="id"/>
    <table cellpadding="0" cellspacing="0" class="form_table" border="0">

        <tr class="tr_header">
            <td width="15%">办公用品名称</td>
            <td width="8%">型号</td>
            <td width="8%">单位</td>
            <td width="9%">单价</td>
            <td width="8%">库存</td>
            <c:if test="${empty bean.id || bean.id == null}">
                <td width="2%" nowrap>
                    &nbsp;<input type="button" value="添加" class="button_select_add" onclick="addLine(this)"/>
                </td>
            </c:if>
        </tr>
        <c:if test="${not empty bean.id && bean.id != null}">
            <tr class="tr_dark">
                <td>
                    <input type="text" name="name" class="input_text" style="width:98%" value="${bean.name}"
                           title="${bean.name}">
                </td>
                <td>
                    <input type="text" name="model" class="input_text" style="width: 95%" value="${bean.model}"
                           title="${bean.model}">
                </td>

                <td>
                    <sys:code code="${oaThingsUnit}" name="unit" type="select" isSaveName="true"
                              defaultName="${bean.unit}"
                              style="width:100%"/>
                </td>
                <td>
                    <input type="text" name="price" class="input_text" style="width: 95%" value="${bean.price}"
                           title="${bean.price}">
                </td>
                <td>
                    <input type="text" name="amount" class="input_text" style="width: 95%" value="${bean.amount}"
                           title="${bean.amount}">
                </td>
            </tr>
        </c:if>
        <tbody id="tableThingDiv"></tbody>
            <%--标准行迁入--%>

    </table>
    <div class="tr_button" style="text-align: center">
        <input type="button" value="保存" class="button_confirm" onclick="save(this)">&nbsp;
        <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
    </div>
</form:form>

<table style="display: none;" cellpadding="0" cellspacing="0" class="form_table" border="0">
    <tbody id="hiddenStyle">
    <%--标准行--%>
    <tr class="tr_dark">
        <td width="15%">
            <input type="text" name="namel" class="input_text" style="width:98%">
        </td>
        <td width="8%">
            <input type="text" name="modell" class="input_text" style="width: 95%">
        </td>
        <td width="9%">
            <sys:code code="${oaThingsUnit}" name="unitl" type="select" isSaveName="true"
                      style="width:100%"/>
        </td>
        <td width="8%">
            <input type="text" name="pricel" class="input_text" style="width: 95%">
        </td>
        <td width="8%">
            <input type="text" name="amountl" class="input_text" style="width: 95%">
        </td>
        <td width="2%"><input type="button" value="删除" class="button_select_remove" onclick="addLine(this)"/></td>
    </tr>
    </tbody>
</table>
