<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<script type="text/javascript">
    $(document).ready(function () {
        $("#detailTable tr:odd").addClass("tr_dark");
        $("#detailTable tr:even").addClass("tr_light");
    });
</script>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table" id="viewTable">
        <tr class="tr_light">
            <td class="form_label">数据表：</td>
            <td class="form_content">&nbsp;
                ${bean.table.tableName}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">操作类型：</td>
            <td class="form_content">&nbsp;
                ${bean.logType}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">操作日志：</td>
            <td class="form_content">
                <table width="100%" id="detailTable">
                    <tr align="center">
                        <td class="form_content"><b>字段名</b></td>
                        <c:if test="${tableLog.changeType eq 'INSERT' || tableLog.changeType eq 'UPDATE'}">
                            <td class="form_content"><b>字段值</b></td>
                        </c:if>
                        <c:if test="${tableLog.changeType eq 'UPDATE' || tableLog.changeType eq 'DELETE'}">
                            <td class="form_content"><b>原字段值</b></td>
                        </c:if>
                    </tr>
                    <c:forEach items="${tableLog.propertyLogs}" var="pl">
                        <tr>
                            <td class="form_content">${pl.propertyName}</td>
                            <c:if test="${tableLog.changeType eq 'INSERT' || tableLog.changeType eq 'UPDATE'}">
                                <td class="form_content">${pl.newValue}</td>
                            </c:if>
                            <c:if test="${tableLog.changeType eq 'UPDATE' || tableLog.changeType eq 'DELETE'}">
                                <td class="form_content">${pl.oldValue}</td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </table>

            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">IP地址：</td>
            <td class="form_content">&nbsp;
                ${bean.ipAddress}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">操作人：</td>
            <td class="form_content">&nbsp;
                ${bean.createUser}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">操作时间：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        </tr>
        <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>