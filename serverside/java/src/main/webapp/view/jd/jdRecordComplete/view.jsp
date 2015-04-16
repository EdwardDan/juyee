<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function printExcelFR() {
        printFR("JdRecordComplete", "id=${bean.id}");
    }
</script>
<div class="form_div">
<table cellpadding="0" cellspacing="0" class="form_table">
<tr class="tr_light">
    <td class="form_label_right" width="15%">监督任务书编号：</td>
    <td class="form_content"  width="35%">
        &nbsp;${bean.jdTaskCode}
    </td>
    <td class="form_label_right" width="15%">报建编号：</td>
    <td class="form_content" width="35%">
        &nbsp;${bean.bjbh}
    </td>
</tr>

<tr class="tr_dark">
    <td class="form_label_right">工程名称：</td>
    <td class="form_content" colspan="3">
        &nbsp;${bean.projectName}
    </td>
</tr>

<tr class="tr_light">
    <td class="form_label_right">监督记录编号：</td>
    <td class="form_content">
        &nbsp;${bean.code}
    </td>
    <td class="form_label_right">天气：</td>
    <td class="form_content">
        &nbsp;${bean.weather}
    </td>
</tr>

<tr class="tr_dark">
    <td class="form_label_right">监督日期：</td>
    <td class="form_content">
        &nbsp;<fmt:formatDate value="${bean.jdDatetime}" pattern="yyyy-MM-dd"/>
    </td>
    <td class="form_label_right">星期：</td>
    <td class="form_content">
        &nbsp;${weekCn}
    </td>
</tr>

<tr class="tr_light">
    <td class="form_label_right">监督负责人：</td>
    <td class="form_content">
        &nbsp;${bean.jdManager.name}
    </td>
    <td class="form_label_right">参加监督人员：</td>
    <td class="form_content">
        &nbsp;${bean.attendPersons}
    </td>
</tr>
<tr class="tr_light">
    <td class="form_label">附件：</td>
    <td class="form_content" colspan="3">
        ${docButton}
    </td>
</tr>
<tr>
    <td align="center" colspan="4">
        <fieldset class="net_form_fieldset">
            <legend class="form_legend">参建单位参加抽查人员</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label_right" width="15%">建设单位：</td>
                    <td class="form_content">
                        &nbsp;${bean.jsDept}
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">勘察单位：</td>
                    <td class="form_content">
                        &nbsp;${bean.kcDept}
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">设计单位：</td>
                    <td class="form_content">
                        &nbsp;${bean.sjDept}
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">施工单位：</td>
                    <td class="form_content">
                        &nbsp;${bean.sgDept}
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">监理单位：</td>
                    <td class="form_content">
                        &nbsp;${bean.jlDept}
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">检测单位：</td>
                    <td class="form_content">
                        &nbsp;${bean.jcDept}
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">监督机构：</td>
                    <td class="form_content">
                        <%--&nbsp;${bean.jdjg}--%>
                        &nbsp;${jdjg}
                    </td>
                </tr>
            </table>
        </fieldset>
    </td>
</tr>

<tr>
    <td align="center" colspan="4">
        <fieldset class="net_form_fieldset">
            <legend class="form_legend">单位工程</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_dark">
                    <td class="form_content">
                        <table cellpadding="0" cellspacing="0" class="form_table" id="ExcelJdDwgcTable"
                               name="ExcelJdDwgcTable">
                            <tr class="tr_header">
                                <td class="form_border" width="30%">单位工程编号</td>
                                <td class="form_border">单位工程名称</td>
                            </tr>

                            <c:forEach items="${bean.jdRecordCompleteDwgcs}" var="item" varStatus="status">
                                <tr
                                        <c:choose>
                                            <c:when test="${(status.index % 2) == 0}">class="tr_dark"</c:when>
                                            <c:otherwise>class="tr_light"</c:otherwise>
                                        </c:choose> id="tr_${item.dwgcCode}" name="tr_${item.dwgcCode}">
                                    <td class="form_border" align="center">&nbsp;${item.dwgcCode}</td>
                                    <td class="form_border" align="left">&nbsp;${item.dwgcName}</td>
                                </tr>
                            </c:forEach>

                        </table>
                    </td>
                </tr>

            </table>
        </fieldset>
    </td>
</tr>

<tr>
    <td align="center" colspan="4">
        <fieldset class="net_form_fieldset">
            <legend class="form_legend">检查内容及发现问题</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">

                <c:forEach items="${checkItems}" var="item" varStatus="var">

                    <tr class="tr_dark">
                        <td class="form_content" style="text-align: left">${item.itemTitle}</td>
                    </tr>
                    <tr class="tr_dark">
                        <td class="form_content">
                            <table cellpadding="0" cellspacing="0" class="form_table">
                                <tr class="tr_header">
                                    <td class="form_border" width="5%">序号</td>
                                    <td class="form_border">竣工验收条件</td>
                                    <td class="form_border" width="20%">符合形式</td>
                                </tr>
                                <c:forEach items="${item.checkItem}" var="item2" varStatus="status">

                                    <tr
                                            <c:choose>
                                                <c:when test="${(status.index % 2) == 0}">class="tr_dark"</c:when>
                                                <c:otherwise>class="tr_light"</c:otherwise>
                                            </c:choose>>
                                        <td class="form_border" align="center" width="5%">&nbsp;${item2.orderNo}</td>
                                        <td class="form_border" align="left">&nbsp;${item2.condition}</td>
                                        <td class="form_border" align="center" width="20%">
                                            &nbsp;${item2.selectItems}</td>
                                    </tr>
                                </c:forEach>

                            </table>
                        </td>
                    </tr>
                </c:forEach>

                <tr class="tr_dark">
                    <td class="form_content" style="text-align: left">五、抽查发现的其他问题</td>
                </tr>

                <tr class="tr_dark">
                    <td class="form_content">
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_header">
                                <td class="form_border">序号</td>
                                <td class="form_border">问题</td>
                                <td class="form_border">违反条款</td>
                                <td class="form_border">监督员</td>
                            </tr>

                            <c:forEach items="${jdRecordQItem}" var="item" varStatus="status">
                                <tr
                                        <c:choose>
                                            <c:when test="${(status.index % 2) == 0}">class="tr_dark"</c:when>
                                            <c:otherwise>class="tr_light"</c:otherwise>
                                        </c:choose>>
                                    <td class="form_td_line" align="center" width="5%">&nbsp;${item.orderNo}</td>
                                    <td class="form_td_line" align="left" align="center">&nbsp;${item.questionDesc}</td>
                                    <td class="form_td_line" align="left" align="center" width="30%">
                                        &nbsp;${item.unlawDesc}</td>
                                    <td class="form_td_line" align="center" width="20%">&nbsp;${item.jdPersonDesc}</td>
                                </tr>
                            </c:forEach>

                        </table>
                    </td>
                </tr>

            </table>
        </fieldset>
    </td>
</tr>

<tr class="tr_light">
    <td class="form_label_right">总处理意见：</td>
    <td class="form_content" colspan="3">
        <sys:toHtml>${bean.dealOpinion}</sys:toHtml>&nbsp;
    </td>
</tr>
<tr class="tr_dark">
    <td class="form_label_right">备注：</td>
    <td class="form_content" colspan="3">
        <sys:toHtml>${bean.description}</sys:toHtml>&nbsp;
    </td>
</tr>

<tr class="tr_button">
    <td class="form_content" colspan="4" style="text-align: center">
        <input type="button" class="button_all" value="打印" onclick="printExcelFR();"/>
        <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
    </td>
</tr>
</table>
</div>