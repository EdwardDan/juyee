<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function printReturnBook(){
        window.open("${ctx}/serviceReturn/printView.do?id=${bean.id}", "送达回书", "status=no,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,width=800,hight=600;");
    }
</script>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label_right" style="width: 20%">编号：</td>
            <td class="form_content" style="width: 30%">
                ${bean.code}
            </td>

            <td class="form_label_right" style="width:20%">受送达人：</td>
            <td class="form_content" style="width: 30%">
                ${bean.servicePerson}
            </td>
        </tr>

        <tr class="tr_dark">
            <td class="form_label_right">事项名称：</td>
            <td class="form_content">
                ${bean.thingsName}
            </td>
            <td class="form_label_right">送达单位：</td>
            <td class="form_content">
                ${bean.serviceUnit}
            </td>
        </tr>

        <tr class="tr_light">
            <td class="form_label_right">送达地点：</td>
            <td class="form_content">
                ${bean.serviceAddress}
            </td>

            <td class="form_label_right"></td>
            <td class="form_content">
            </td>
        </tr>
        <tr>
            <td colspan="4">
                <table cellpadding="0" cellspacing="0" class="table_thin_line" border="1" style="width: 100%">
                    <tr class="tr_header">
                        <td style="width: 5% "> 序号</td>
                        <td style="width: 15% ">送达文书</td>
                        <td style="width: 15% ">送达人</td>
                        <td style="width: 15% ">收到日期</td>
                        <td style="width: 15% ">收件人签名</td>
                        <td style="width: 20% ">备注</td>
                    </tr>
                    <c:forEach items="${serviceReturnItems}" var="serviceReturnItem">
                        <tr class="tr_dark">
                            <td  style="text-align: center;width: 5%">${serviceReturnItem.num}
                            </td>
                            <td  style="text-align: center;width: 15%">${serviceReturnItem.serviceBook}
                            </td>
                            <td  style="text-align: center;width: 15%">${serviceReturnItem.servicePerson}
                            </td>
                            <td  style="text-align: center;width: 15%">${serviceReturnItem.receiveDate}
                            </td>
                            <td  style="text-align: center;width: 15%">${serviceReturnItem.receiveSign}
                            </td>
                            <td  style="text-align: center;width: 20%">${serviceReturnItem.memo}
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>

        <tr class="tr_button">
            <td class="form_content" colspan="4" style="text-align: center">
                <input type="button" value="送达回证" class="button_normal_long" onclick="printReturnBook(this)">&nbsp;
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>