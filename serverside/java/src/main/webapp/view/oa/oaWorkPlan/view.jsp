<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<style type="text/css">
    .addTd {
        border: 1px solid;
    }
</style>
<script type="text/javascript">
    //导出
    function printItems(btn){
        window.open( "${ctx}/oaWorkPlan/printExcel.do?id=${bean.id}");
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <div class="form_div">
        <fieldset class="form_fieldset">
            <legend class="form_legend">
                一周工作安排
            </legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label_right">上报科室：</td>
                    <td class="form_content">${bean.reportDept}</td>
                    <td class="form_label_right">上报人：</td>
                    <td class="form_content">${bean.reportPerson}</td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" style="width: 150px">上报时间：</td>
                    <td class="form_content" colspan="3">${bean.beginDate} ~${bean.endDate}
                    </td>
                </tr>
            </table>
            <table cellpadding="0" cellspacing="0" border="1" class="table_thin_line"
                   style="text-align: center;width: 100%"
                   id="itemTable">
                <tr class="tr_header">
                    <td style="width:5%">序号</td>
                    <td style="width:8%">责任人</td>
                    <td style="width:8%">是否重点工作</td>
                    <td style="width:25%">工作内容</td>
                    <td style="width:20%">工作进度</td>
                    <td style="width:10%">经办人</td>
                    <c:if test="${empty oaWorkPlanItems !=null}">
                    <c:forEach items="${oaWorkPlanItems}" var="item">
                <tr class="tr_light">
                    <td style="text-align: center">
                            ${item.orderNo}
                    </td>

                    <td style="text-align: center">
                            ${item.dutyPerosn}
                    </td>

                    <td style="text-align: center;">
                        <span style="color: red;">${item.keyWork} </span>
                    </td>
                    <td style="text-align: left;">
                        <sys:toHtml>${item.content}</sys:toHtml>
                    </td>
                    <td style="text-align: left;">
                        <sys:toHtml>${item.schedule}</sys:toHtml>
                    </td>
                    <td style="text-align: center">
                            ${item.jbr}
                    </td>
                </tr>
                </c:forEach>
                </c:if>
            </table>
        </fieldset>
        <c:if test="${bean.status==STATUS_BRANCH_PASS ||bean.status==STATUS_BRANCH_BACK ||bean.status==STATUS_MAIN_PASS ||bean.status==STATUS_MAIN_BACK }">
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
        <c:if test="${bean.status==STATUS_MAIN_PASS ||bean.status==STATUS_MAIN_BACK }">
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
            <td> <input type="button" value="导出" class="button_all" onclick="printItems(this)"/>&nbsp;
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</form:form>