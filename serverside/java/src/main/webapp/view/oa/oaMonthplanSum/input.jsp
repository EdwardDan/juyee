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
    function save(status, buttonName) {
        if (!validateForm(formId)) {
            return;
        }
        //提交表单
        if (buttonName != "") {
            if (confirm("提交之后将不能再修改，确定继续吗？")) {
                saveAjaxData("${ctx}/oaMonthplanSum/save.do?status=" + status, formId);
            }
        } else {
            saveAjaxData("${ctx}/oaMonthplanSum/save.do?status=" + status, formId);
        }
    }

    //删除一行数据
    function deleteLine(obj, id) {
        if (confirm("确定要删除吗!")) {
            var trObj = obj.parentNode.parentNode;
            trObj.parentElement.deleteRow(trObj.rowIndex);
        }

        var itemId = $("#monthItemId").val();
        var itemIds = itemId + "," + id;
        $("#monthItemId").val(itemIds);
    }

    //整形数据验证（两位数）
    function checkInteger(element) {
        var orderNo = Number(element.value);
        if (!isNaN(orderNo)) {
            if (orderNo < 0 || orderNo > 99) {
                showInfoMsg('只能输入两位有效整数！', null);
                element.value = orderNo.replace(/^[1-9][0-9]?$/, '');
            }
        } else {
            showInfoMsg('数据不合法，请重新输入！', null);
        }
    }
</script>
<style type="text/css">
    .input_text_short {
        font-size: 12px;
        border: 1px solid #b8b6b9;
        color: #007DBC;
        background-color: #FFFFFF;
        width: 100px;
        height: 20px;
    }

    .input_number_short {
        font-size: 12px;
        color: #007DBC;
        border: 1px solid #b8b6b9;
        background-color: #FFFFFF;
        width: 50px;
        height: 20px;
    }

    .form_select_short {
        width: 45px;
        height: 22px;
        border: 1px solid #b8b6b9;
    }
</style>

<form:form commandName="bean">
<form:hidden path="id" id="id"/>
<input type="hidden" name="monthItemId" id="monthItemId" value="">

<div class="form_div">
<table cellpadding="0" cellspacing="0" class="form_table">
<tr height="50">
    <td colspan="7" align="center">
         <span class="net_form_title">
              虹口建管署${bean.year}年${bean.period}月主要工作完成情况
              <input type="hidden" name="year" value="${bean.year}">
              <input type="hidden" name="period" value="${bean.period}">
         </span>
    </td>
</tr>

<tr>
<td>
<table cellpadding="0" cellspacing="0" class="form_table">
<tr class="tr_header" width="98%">
    <td nawrap width="50" align="center">序号</td>
    <td nawrap width="255" align="center">工作内容</td>
    <td nawrap width="85" align="center">时间节点</td>
    <td nawrap width="105" align="center">责任人</td>
    <td nawrap width="105" align="center">部门</td>
    <td nawrap width="55" align="center">是否完成</td>
    <td nawrap width="50" align="center">操作</td>
</tr>
<tr>
<td colspan="7" align="center">
<c:if test="${not empty bean.id}">
    <fieldset class="form_fieldset" style="width: 98%;margin: 0 auto;display: true;">
        <legend class="form_legend">月度总结汇总</legend>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <c:forEach items="${mapListZjs}" var="itemZj" varStatus="status">
                <tr <c:choose>
                    <c:when test="${status.index%2==0}">class="tr_light"</c:when>
                    <c:otherwise>class="tr_dark"</c:otherwise>
                </c:choose>>
                    <td nawrap class="form_border">
                        <input type="text" class="input_number_short" name="orderNo"
                               value="${itemZj.orderNo}" onchange="checkInteger(this)"/>
                        <input type="hidden" name="itemId" value="${itemZj.itemId}">
                        <input type="hidden" name="reportType" value="${itemZj.reportType}">
                    </td>
                    <td nawrap class="form_border">
                        <textarea class="input_textarea"
                                  name="content">${itemZj.content}</textarea>
                    </td>
                    <td nawrap class="form_border">
                        <input type="text" class="input_date" name="timeNode"
                               value="${itemZj.timeNode}" readonly="true">
                        <input type="button" class="button_calendar" value=" "
                               onClick="calendar('timeNode');">
                    </td>
                    <td nawrap class="form_border">
                        <input type="text" class="input_text_short" name="reportPerson"
                               value="${itemZj.reportPerson}" readonly="true">
                    </td>
                    <td nawrap class="form_border">
                        <input type="text" class="input_text_short" name="reportDept"
                               value="${itemZj.reportDept}" readonly="true">
                    </td>
                    <td nawrap class="form_border">
                        <select name="isComplete" class="form_select_short">
                            <option value="1" <c:if test="${itemZj.isComplete}">selected</c:if>>
                                是
                            </option>
                            <option value="0"
                                    <c:if test="${!itemZj.isComplete}">selected</c:if>>否
                            </option>
                        </select>
                    </td>
                    <td class="form_border">
                        <input type="button" value="删除"
                               onclick="deleteLine(this,'${itemZj.itemId}')" class="button_normal"/>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </fieldset>
    <fieldset class="form_fieldset" style="width: 98%;margin: 0 auto;display: true;">
        <legend class="form_legend">月度计划汇总</legend>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <c:forEach items="${mapListJhs}" var="itemJh" varStatus="status">
                <tr <c:choose>
                    <c:when test="${status.index%2==0}">class="tr_light"</c:when>
                    <c:otherwise>class="tr_dark"</c:otherwise>
                </c:choose>>
                    <td nawrap class="form_border">
                        <input type="text" class="input_number_short" name="orderNo"
                               value="${itemJh.orderNo}" onchange="checkInteger(this)"/>
                        <input type="hidden" name="itemId" value="${itemJh.itemId}">
                        <input type="hidden" name="reportType" value="${itemJh.reportType}">
                    </td>
                    <td nawrap class="form_border">
                        <textarea class="input_textarea"
                                  name="content">${itemJh.content}</textarea>
                    </td>
                    <td nawrap class="form_border">
                        <input type="text" class="input_date" name="timeNode"
                               value="${itemJh.timeNode}" readonly="true">
                        <input type="button" class="button_calendar" value=" "
                               onClick="calendar('timeNode');">
                    </td>
                    <td nawrap class="form_border">
                        <input type="text" class="input_text_short" name="reportPerson"
                               value="${itemJh.reportPerson}" readonly="true">
                    </td>
                    <td nawrap class="form_border">
                        <input type="text" class="input_text_short" name="reportDept"
                               value="${itemJh.reportDept}" readonly="true">
                    </td>
                    <td nawrap class="form_border">
                        <select name="isComplete" class="form_select_short">
                            <option value="1" <c:if test="${itemJh.isComplete}">selected</c:if>>
                                是
                            </option>
                            <option value="0"
                                    <c:if test="${!itemJh.isComplete}">selected</c:if>>否
                            </option>
                        </select>
                    </td>
                    <td class="form_border">
                        <input type="button" value="删除"
                               onclick="deleteLine(this,'${itemJh.itemId}')"
                               class="button_normal"/>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </fieldset>
</c:if>
<c:if test="${empty bean.id}">
    <fieldset class="form_fieldset" style="width: 98%;margin: 0 auto;display: true;">
        <legend class="form_legend">月度总结汇总</legend>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <c:forEach items="${itemListZjs}" var="itemZj" varStatus="status">
                <c:if test="${not empty itemZj.zj}">
                    <tr <c:choose>
                        <c:when test="${status.index%2==0}">class="tr_light"</c:when>
                        <c:otherwise>class="tr_dark"</c:otherwise>
                    </c:choose>>
                        <td nawrap class="form_border">
                            <input type="text" class="input_number_short" name="orderNo"
                                   value="${itemZj.zj.orderNo}" onchange="checkInteger(this)"/>
                            <input type="hidden" name="itemId" value="${itemZj.zj.id}">
                            <input type="hidden" name="reportType" value="${itemZj.zj.reportType}">
                        </td>
                        <td nawrap class="form_border">
                            <textarea class="input_textarea"
                                      name="content">${itemZj.zj.content}</textarea>
                        </td>
                        <td nawrap class="form_border">
                            <input type="text" class="input_date" name="timeNode"
                                   value="${itemZj.zj.timeNode}" readonly="true">
                            <input type="button" class="button_calendar" value=" "
                                   onClick="calendar('timeNode');">
                        </td>
                        <td nawrap class="form_border">
                            <input type="text" class="input_text_short" name="reportPerson"
                                   value="${itemZj.zj.monthplan.reportPerson}" readonly="true">
                        </td>
                        <td nawrap class="form_border">
                            <input type="text" class="input_text_short" name="reportDept"
                                   value="${itemZj.zj.monthplan.reportDept}" readonly="true">
                        </td>
                        <td nawrap class="form_border">
                            <select name="isComplete" class="form_select_short">
                                <option value="1" <c:if test="${itemZj.zj.isComplete}">selected</c:if>>
                                    是
                                </option>
                                <option value="0" <c:if test="${!itemZj.zj.isComplete}">selected</c:if>>
                                    否
                                </option>
                            </select>
                        </td>
                        <td class="form_border">
                            <input type="button" value="删除" onclick="deleteLine(this,'${itemZj.zj.id}')"
                                   class="button_normal"/>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </fieldset>
    <fieldset class="form_fieldset" style="width: 98%;margin: 0 auto;display: true;">
        <legend class="form_legend">月度计划汇总</legend>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <c:forEach items="${itemListJhs}" var="itemJh" varStatus="status">
                <c:if test="${not empty itemJh.jh}">
                    <tr <c:choose>
                        <c:when test="${status.index%2==0}">class="tr_light"</c:when>
                        <c:otherwise>class="tr_dark"</c:otherwise>
                    </c:choose>>
                        <td nawrap class="form_border">
                            <input type="text" class="input_number_short" name="orderNo"
                                   value="${itemJh.jh.orderNo}" onchange="checkInteger(this)"/>
                            <input type="hidden" name="itemId" value="${itemJh.jh.id}">
                            <input type="hidden" name="reportType" value="${itemJh.jh.reportType}">
                        </td>
                        <td nawrap class="form_border">
                            <textarea class="input_textarea"
                                      name="content">${itemJh.jh.content}</textarea>
                        </td>
                        <td nawrap class="form_border">
                            <input type="text" class="input_date" name="timeNode" id="timeNode"
                                   value="${itemJh.jh.timeNode}" readonly="true">
                            <input type="button" class="button_calendar" value=" "
                                   onClick="calendar('timeNode');">
                        </td>
                        <td nawrap class="form_border">
                            <input type="text" class="input_text_short" name="reportPerson"
                                   value="${itemJh.jh.monthplan.reportPerson}" readonly="true">
                        </td>
                        <td nawrap class="form_border">
                            <input type="text" class="input_text_short" name="reportDept"
                                   value="${itemJh.jh.monthplan.reportDept}" readonly="true">
                        </td>
                        <td nawrap class="form_border">
                            <select name="isComplete" class="form_select_short">
                                <option value="1" <c:if test="${itemJh.jh.isComplete}">selected</c:if>>
                                    是
                                </option>
                                <option value="0" <c:if test="${!itemJh.jh.isComplete}">selected</c:if>>
                                    否
                                </option>
                            </select>
                        </td>
                        <td class="form_border">
                            <input type="button" value="删除" onclick="deleteLine(this,'${itemJh.jh.id}')"
                                   class="button_normal"/>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </fieldset>
</c:if>
</td>
</tr>
</table>
</td>
</tr>

<tr class="tr_button" align="center">
    <td class="form_border" colspan="7">
        <input type="button" value="提交" class="button_confirm"
               onclick="save('${STATUS_SUBMIT}',this.value)">&nbsp;
        <input type="button" value="暂存" class="button_confirm" onclick="save('${STATUS_EDIT}','')">&nbsp;
        <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
    </td>
</tr>
</table>
</div>
</form:form>