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
    function save(status, buttonName) {
        if (!validateForm(formId)) {
            return;
        }
        saveAjaxData("${ctx}/projectBidPay/save.do?statusType=" + ${statusType} +"&status=" + status, formId);
    }
    function isAff(obj) {
        if (obj.checked) {
            $(obj).parent().find("#isAfford").val(1);
        } else {
            $(obj).parent().find("#isAfford").val(0);
        }
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
            <c:if test="${statusType==STATUS_DS||statusType==STATUS_DJ}">
                <td width="12%" nowrap class="form_border">缴纳金额（元）</td>
                <td width="12%" nowrap class="form_border">是否已缴纳</td>
            </c:if>
            <c:if test="${statusType==STATUS_YQR}">
                <td width="12%" nowrap class="form_border">是否需要退还</td>
                <td width="12%" nowrap class="form_border">退还金额（元）</td>
                <td width="12%" nowrap class="form_border">退还日期</td>
            </c:if>
            <td width="1%" nowrap class="form_border" style="display: none;">主键</td>

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
                <c:if test="${statusType==STATUS_DS||statusType==STATUS_DJ}">
                    <td nowrap class="form_border">
                        <input type="text" class="input_number" value="${item.projectBidSign.signAccount}"
                               name="payAccount"/>
                    </td>
                    <td nowrap class="form_border">
                        <input type="checkbox" value="1" onclick="isAff(this)"
                               <c:if test="${item.isAfford==1}">checked="checked" </c:if> />
                        <input type="hidden" value="${item.isAfford}" name="isAfford" id="isAfford"/>
                            <%--<input type="text" class="input_datetime"--%>
                            <%--value="<fmt:formatDate value="${item.payDate}" pattern="yyyy-MM-dd"/>"--%>
                            <%--name="payDate" onClick="calendar(null,'date');" readonly/>--%>
                    </td>
                </c:if>
                <c:if test="${statusType==STATUS_YQR}">
                    <td nowrap class="form_border">
                        <input type="checkbox" <c:if test="${item.needBack==1}">checked="checked" </c:if> disabled/>
                    </td>
                    <td nowrap class="form_border">
                        <input type="text" class="input_number" value="${item.projectBidSign.signAccount}"
                               name="returnAccount" readonly/>
                    </td>
                    <td nowrap class="form_border">
                        <input type="text" class="input_datetime"
                               value="<fmt:formatDate value="${item.returnDate}" pattern="yyyy-MM-dd"/>"
                               name="returnDate" onClick="calendar(null,'date');" readonly/>
                    </td>
                </c:if>
                <td nowrap class="form_border" style="display: none;">
                    <input type="hidden" value="${item.id}" name="deptId" hidden="hidden"/>
                </td>
            </tr>
        </c:forEach>
        <tr class="tr_button">
            <c:if test="${statusType==STATUS_DS||statusType==STATUS_DJ}">
                <td colspan="8" align="center" class="form_border">
                        <%--<input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;--%>
                    <input type="button" value="提交" class="button_confirm" onclick="save('${STATUS_DS}','')">&nbsp;
                    <input type="button" value="暂存" class="button_confirm" onclick="save('${STATUS_DJ}','')">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </c:if>
            <c:if test="${statusType==STATUS_YQR}">
                <td colspan="8" align="center" class="form_border">
                    <input type="button" value="提交" class="button_confirm" onclick="save('${STATUS_YT}','')">&nbsp;
                    <input type="button" value="暂存" class="button_confirm" onclick="save('${STATUS_YQR}','')">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </c:if>

        </tr>
    </table>
</form:form>