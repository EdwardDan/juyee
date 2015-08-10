<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<style type="text/css">
    .addTd{
        border: 1px solid;
    }
</style>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <div class="form_div">
        <fieldset class="form_fieldset">
            <legend class="form_legend">
                一周工作安排
            </legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_border" align="center" colspan="3">上报科室：${bean.reportDept}
                    </td>
                    <td class="form_border" align="center" colspan="3">上报人：${bean.reportPerson}
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_border" align="left" colspan="6">上报时间：${bean.beginDate} ~${bean.endDate}
                    </td>
                </tr>
                <tr class="tr_header">
                    <td class="addTd" width="5%">序号</td>
                    <td class="addTd" width="10%">责任人</td>
                    <td class="addTd" width="25%">重点工作</td>
                    <td class="addTd" width="25%">工作内容</td>
                    <td class="addTd" width="20%">工作进度</td>
                    <td class="addTd" width="10%">经办人</td>
                    <c:if test="${empty oaWorkPlanItems !=null}">
                    <c:forEach items="${oaWorkPlanItems}" var="item">
                <tr class="tr_light">
                    <td class="form_content" style="text-align: center">
                            ${item.orderNo}
                    </td>

                    <td class="form_content">
                            ${item.dutyPerosn}
                    </td>

                    <td class="form_content">
                            ${item.keyWork}
                    </td>
                    <td class="form_content">
                            ${item.content}
                    </td>
                    <td class="form_content">
                            ${item.schedule}
                    </td>
                    <td class="form_content">
                            ${item.jbr}
                    </td>
                </tr>
                </c:forEach>
                </c:if>
            </table>
        </fieldset>
        <c:if test="${bean.status=='3'||bean.status=='4'||bean.status=='5'||bean.status=='6'}">
            <fieldset class="form_fieldset">
                <legend class="form_legend">
                    科长审核
                </legend>
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_dark">
                        <td class="form_label_right" width="150px">审核意见：</td>
                        <td class="form_content" colspan="3">
                            <sys:toHtml>${bean.kzOpinion}</sys:toHtml>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </c:if>
        <c:if test="${bean.status=='5'||bean.status=='6'}">
            <fieldset class="form_fieldset">
                <legend class="form_legend">
                    分管领导审核
                </legend>
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_dark">
                        <td class="form_label_right" width="150px">审核意见：</td>
                        <td class="form_content" colspan="3">
                            <sys:toHtml>${bean.fgOpinion}</sys:toHtml>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </c:if>
    </div>
    <table cellpadding="5" cellspacing="0" class="form_table">
        <tr class="tr_content">
            <td>
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</form:form>