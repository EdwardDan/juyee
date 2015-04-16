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
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

//提交表单
        saveAjaxData("${ctx}/projectBidCheck/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_header" align="center">
            <td width="5%" nowrap class="form_border">序号</td>
            <td width="34%" nowrap class="form_border">购买标书单位</td>
            <td width="12%" nowrap class="form_border">联系人</td>
            <td width="12%" nowrap class="form_border">联系电话</td>
            <td width="12%" nowrap class="form_border">购买标书时间</td>

            <td width="12%" nowrap class="form_border">缴纳金额（元）</td>
            <td width="12%" nowrap class="form_border">缴纳日期</td>

            <td width="12%" nowrap class="form_border">退还金额（元）</td>
            <td width="12%" nowrap class="form_border">退换日期</td>

            <td width="1%" nowrap class="form_border" hidden="hidden">主键</td>
            </td>
        </tr>
        <c:forEach items="${bean.projectBidSignDepts}" var="item" varStatus="status">
            <tr <c:choose>
                <c:when test="${status.index % 2==0}">class="tr_light" </c:when>
                <c:otherwise>class="tr_dark" </c:otherwise>
            </c:choose>>
                <td nowrap class="form_border">${status.index+1}</td>
                <td nowrap class="form_content">${item.signUnit}</td>
                <td nowrap class="form_border"> ${item.linkPerson}</td>
                <td nowrap class="form_border"> ${item.linkTel}</td>
                <td nowrap class="form_border"><fmt:formatDate value="${item.signDate}"
                                                               pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td nowrap class="form_border">
                    <input type="text" class="input_number" value="${item.payAccount}" name="payAccount" readonly="true"/>
                </td>
                <td nowrap class="form_border">
                    <input type="text" class="input_date" value="${item.payDate}" name="payDate"
                           onClick="calendar(null,'date');"/>
                </td>


                <td nowrap class="form_border">
                    <input type="text" class="input_number" value="${item.returnAccount}" name="returnAccount" readonly="true"/>
                </td>
                <td nowrap class="form_border">
                    <input type="text" class="input_date" value="${item.returnDate}" name="returnDate"
                           onClick="calendar(null,'date');"/>
                </td>

                <td nowrap class="form_border">
                    <input type="text" value="${item.id}" name="deptId" hidden="hidden"/>
                </td>
            </tr>
        </c:forEach>
        <tr class="tr_button">
            <td colspan="7" align="center" class="form_border">
                <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</form:form>