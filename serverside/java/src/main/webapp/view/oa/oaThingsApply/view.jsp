<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <table cellpadding="0" cellspacing="0" class="form_table" border="0">
        <tr class="tr_title">
            <td>办公用品申请</td>
        </tr>
    </table>
    <fieldset class="form_fieldset">
        <legend class="form_legend">申请信息</legend>
        <table cellpadding="0" cellspacing="0" class="form_table" border="1">
            <tr class="tr_dark">
                <td class="form_border" align="center" colspan="2">申请部门： ${bean.applyDept.name}
                </td>
                <td class="form_border" align="center" colspan="3">申请填报人：${bean.applyUser.displayName}
                </td>
            </tr>
            <tr class="tr_header">
                <td width="8%">申请物品</td>
                <td width="8%">型号</td>
                <td width="9%">单位</td>
                <td width="8%">预计单价</td>
                <td width="8%">数量</td>
            </tr>
            <c:if test="${not empty bean.oaThingsApplyItems && bean.oaThingsApplyItems != null}">
                <c:forEach items="${bean.oaThingsApplyItems}" var="item">
                    <tr class="tr_dark">
                        <td>${item.name}</td>
                        <td>${item.model}</td>
                        <td>${item.unit}</td>
                        <td>${item.price}</td>
                        <td>${item.amount}</td>
                    </tr>
                </c:forEach>
            </c:if>
            <tr class="tr_dark">
                <td colspan="3" align="right"><b>预计总价</b></td>
                <td colspan="2" align="left">${count}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">申请说明：</td>
                <td class="form_content" colspan="4"><sys:toHtml>${bean.applyContent}</sys:toHtml>
                </td>
            </tr>
        </table>
    </fieldset>
    <c:if test="${bean.status!=STATUS_EDIT&&bean.status!=STATUS_SUBMIT}">
    <fieldset class="form_fieldset">
        <legend class="form_legend">科长审核</legend>
        <table cellpadding="0" cellspacing="0" class="form_table" border="0">
            <tr class="tr_light">
                <td class="form_label_right" width="20%">科长审核意见：</td>
                <td class="form_content" width="80%">
                    <sys:toHtml>${bean.kzAuditOpinion}</sys:toHtml>
                </td>
            </tr>
        </table>
    </fieldset>
    </c:if>
    <c:if test="${bean.status==STATUS_MAIN_PASS||bean.status==STATUS_MAIN_BACK}">
    <fieldset class="form_fieldset">
        <legend class="form_legend">办公室主任审核</legend>
        <table cellpadding="0" cellspacing="0" class="form_table" border="0">
                <tr class="tr_light">
                    <td class="form_label_right" width="20%">办公室主任审核意见：</td>
                    <td class="form_content" width="80%"><sys:toHtml>${bean.zrAuditOpinion}</sys:toHtml>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">办公室处理人员：</td>
                    <td class="form_content">${bean.dealUser.displayName}</td>
                </tr>
        </table>
    </fieldset>
    </c:if>
    <div class="tr_button" style="text-align: center">
        <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
    </div>
</form:form>

