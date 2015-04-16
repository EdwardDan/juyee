<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function printExcelFR() {
        printFR("jdRecoverForm", "id=${bean.id}");
    }
</script>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_title">
            <td colspan="2">上海市建设工程复工通知单</td>
        </tr>
        <tr class="tr_dark">
            <td class="form_td_line" colspan="2">
                虹口质监（${bean.year}）复字[${bean.orderNo}]号
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">责任主体：</td>
            <td class="form_content">&nbsp;
                ${bean.dutyDept}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">工程名称：</td>
            <td class="form_content">&nbsp;
                ${bean.projectName}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">整改起始时间：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.reformBeginDate}" pattern="yyyy-MM-dd"/>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">恢复施工时间：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.recoverDate}" pattern="yyyy-MM-dd"/>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">签发单位：</td>
            <td class="form_content">&nbsp;
                ${bean.signDept}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">签发人：</td>
            <td class="form_content">&nbsp;
                ${bean.signPerson}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">签发日期：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.signDate}" pattern="yyyy-MM-dd"/>
            </td>
        </tr>
        <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="打印" class="button_all" onclick="printExcelFR()">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>