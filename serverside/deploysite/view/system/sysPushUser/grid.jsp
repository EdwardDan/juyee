<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";

    //保存操作
    function save(btn) {

        //提交表单
        saveAjaxData("${ctx}/sysPushUser/save.do", formId,editPushUser);
    }

    //全选/反选
    function checkAll(obj) {
        var c = obj.checked;
        $("input[name='checkbox']").each(function () {
            $(this).attr("checked", c==true ? c : false);
        });
    }

    function doMove(flag,defineId){

    }
</script>
<div class="form_div">
    <form:form commandName="bean">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_header">
                <td class="form_border" width="10%"><input type="checkbox" id="checkAll1" onclick="checkAll(this)" value="1"/>全选/反选</td>
                <td class="form_border" width="50%" colspan="2">推送模块</td>
                <td class="form_border" width="25%">推送间隔(天)</td>
                <td class="form_border" width="20%">排序</td>
            </tr>
            <c:set value="${fn:length(list)}" var="size"/>
            <c:forEach items="${list}" var="item" varStatus="status">
                <tr class="<c:choose><c:when test="${status.index % 2==0}">tr_light</c:when><c:otherwise>tr_dark</c:otherwise></c:choose>">
                    <td class="form_border"><input type="checkbox" name="checkbox" value="${item.define.id}" <c:if test="${not empty item.user.pushDefine}">checked</c:if>></td>
                    <td class="form_border"><img src="${themePath}/index_new/task_img/${item.define.taskImg}.png" border="0" align="absmiddle"/></td>
                    <td class="form_border">${item.define.modelName}</td>
                    <td class="form_border">${item.define.pushDelay}</td>
                    <td class="form_border">
                        <input type="text" class="input_text" style="width: 40px;text-align: center" name="orderNo_${item.define.id}" value="${item.user.orderNo}" onKeypress ="InputInteger()" size="3">
                    </td>
                </tr>
            </c:forEach>
            <tr class="tr_button">
                <td class="form_border" colspan="5">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="返回" class="button_back" onclick="loadIndex();">
                </td>
            </tr>
        </table>
    </form:form>
</div>