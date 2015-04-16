<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function printExcelFR() {
        printFR("workerInspectRecord", "id=${bean.id}");
    }
</script>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label_right" width="20%">报建编号：</td>
            <td class="form_content" colspan="3">&nbsp;
                ${bean.bjbh}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right" width="20%">检查地点：</td>
            <td class="form_content" colspan="3">&nbsp;
                ${bean.checkAddress}
            </td>
        </tr>

        <tr class="tr_light">
            <td class="form_label_right" width="20%">检查日期：</td>
            <td class="form_content" colspan="3">&nbsp;
                <fmt:formatDate value="${bean.checkDate}" pattern="yyyy-MM-dd"/> &nbsp;${bean.startTime}~${bean.endTime}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">当事人：</td>
            <td class="form_content">&nbsp;
                ${bean.currentPerson}
            </td>
            <td class="form_label_right">地址：</td>
            <td class="form_content">&nbsp;
                ${bean.address}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">法定代表人：</td>
            <td class="form_content">&nbsp;
                ${bean.fr}
            </td>
            <td class="form_label_right">电话：</td>
            <td class="form_content">&nbsp;
                ${bean.tel}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">检查人员：</td>
            <td class="form_content">&nbsp;
                ${bean.checkPerson}
            </td>
            <td class="form_label_right">记录人：</td>
            <td class="form_content">&nbsp;
                ${bean.recordPerson}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right" width="20%">现场检查情况：</td>
            <td class="form_content" colspan="3">&nbsp;
                <sys:toHtml> ${bean.checkContent}</sys:toHtml>
            </td>
        </tr>
        <%--<tr class="tr_dark">--%>
            <%--<td class="form_label_right" width="20%">是否来源手持终端：</td>--%>
            <%--<td class="form_content" colspan="3">&nbsp;--%>
                <%--<c:choose><c:when test="${bean.isFromAndroid}">是</c:when><c:otherwise>否</c:otherwise></c:choose>--%>
            <%--</td>--%>
        <%--</tr>--%>
        <tr>
            <td colspan="4">
                <input type="button" class="button_all" value="打印" onclick="printExcelFR();"/>
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>