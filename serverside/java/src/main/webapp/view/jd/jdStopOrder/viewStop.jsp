<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function print() {
        printFR("jdStopOrder", encodeURI("id=${bean.id}"));
    }
</script>
<style type="text/css">
    .form_label {
        width: 20%;
    }
</style>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td colspan="2">
                <h1>上海市建设工程质量安全监督停工指令单</h1>
            </td>
        </tr>
        <tr class="tr_dark">
            <td colspan="2">
                虹口质监（${bean.year}）停字【${bean.orderNo}】号
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">责任主体：</td>
            <td class="form_content">
                ${bean.dutyDept}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">选择存在问题：</td>
            <td class="form_content">
                <table cellpadding="0" cellspacing="0" class="table_thin_line_center" border="1">
                    <tr class="tr_header">
                        <td width="10%">序号</td>
                        <td width="40%">问题</td>
                        <td width="30%">违反条款</td>
                        <td width="15%">监督员</td>
                    </tr>
                    <c:forEach items="${jdRecordQuestionMapList}" var="jdRecordQuestion" varStatus="varStatus">
                        <tr
                                <c:if test="${varStatus.index%2==0}">class="tr_dark"</c:if>
                                <c:if test="${varStatus.index%2==1}">class="tr_light"</c:if>
                                >
                            <td>${varStatus.index+1}</td>
                            <td>${jdRecordQuestion["questionDesc"]}</td>
                            <td>${jdRecordQuestion["unlawDesc"]}</td>
                            <td>${jdRecordQuestion["jdPersonDesc"]}</td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">复查单位：</td>
            <td class="form_content">
                ${recheckDept}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">停止施工时间：</td>
            <td class="form_content">
                <fmt:formatDate value="${bean.reformBeginDate}" pattern="yyyy年MM月dd日"/>${hour}时
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">整改期限：</td>
            <td class="form_content">
                ${bean.reformLimit}

            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">签发单位：</td>
            <td class="form_content">
                ${bean.signDept}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">签发人：</td>
            <td class="form_content">
                ${bean.signPerson}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">签发日期：</td>
            <td class="form_content">
                ${bean.signDate}
            </td>
        </tr>
        <tr class="tr_dark" style="display: none">
            <td class="form_label">备注：</td>
            <td class="form_content">
                ${bean.description}
            </td>
        </tr>
        <tr class="tr_button">
            <td colspan="2">
                <input type="button" value="打印" class="button_all" onclick="print()">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>

</div>