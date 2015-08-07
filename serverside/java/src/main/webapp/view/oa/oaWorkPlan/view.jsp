<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
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
                    <td class="form_border" align="left" colspan="6">上报时间：${bean.beginDate}  ~${bean.endDate}
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
                <tr class="tr_dark">
                    <td class="addTd">
                        <input type="text" name="orderNo" class="input_text" style="width: 95%"
                               value="${item.orderNo}"
                               title="${item.orderNo}">
                    </td>

                    <td class="addTd">
                        <input type="text" name="dutyPerosn" class="input_text" style="width: 95%"
                               value="${item.dutyPerosn}"
                               title="${item.dutyPerosn}">
                    </td>

                    <td class="addTd">
                        <input type="text" name="keyWork" class="input_text" style="width: 95%" value="${item.keyWork}"
                               title="${item.keyWork}">
                    </td>
                    <td class="addTd">
                        <input type="text" name="content" class="input_text" style="width: 95%" value="${item.content}"
                               title="${item.content}">
                    </td>
                    <td class="addTd">
                        <input type="text" name="schedule" class="input_text" style="width: 95%"
                               value="${item.schedule}"
                               title="${item.schedule}">
                    </td>
                    <td class="addTd">
                        <input type="text" name="jbr" class="input_text" style="width: 95%" value="${item.jbr}"
                               title="${item.jbr}">
                    </td>
                </tr>
                </c:forEach>
                </c:if>
            </table>
            <c:if test="${bean.status=='2'|| bean.status=='3'||bean.status=='4'||bean.status=='5'||bean.status=='6'}">
                <fieldset class="form_fieldset">
                    <legend class="form_legend">
                        科长审核
                    </legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_dark">
                            <td class="form_label_right" width="15%">审核意见：</td>
                            <td class="form_content" colspan="3">
                                <form:textarea path="kzOpinion" cssClass="input_textarea_long"/>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </c:if>
            <c:if test="${bean.status=='3'||bean.status=='5'||bean.status=='6'}">
                <fieldset class="form_fieldset">
                    <legend class="form_legend">
                        分管领导审核
                    </legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_dark">
                            <td class="form_label_right" width="15%">审核意见：</td>
                            <td class="form_content" colspan="3">
                                <form:textarea path="fgOpinion" cssClass="input_textarea_long"/>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </c:if>
                <%--标准行迁入--%>
        </fieldset>
    </div>

    <table style="display: none;" cellpadding="0" cellspacing="0" class="form_table" border="0">
        <tbody id="hiddenStyle">
        <tr class="tr_dark"><%--标准行--%>
            <td class="addTd">
                <input type="text" name="orderNo" class="input_text" style="width: 95%"/>
            </td>
            <td class="addTd">
                <input type="text" name="dutyPerosn" class="input_text" style="width: 95%"/>
            </td>
            <td class="addTd">
                <input type="text" name="keyWork" class="input_text" style="width: 95%"/>
            </td>
            <td class="addTd">
                <input type="text" name="content" class="input_text" style="width: 95%"/>
            </td>
            <td class="addTd">
                <input type="text" name="schedule" class="input_text" style="width: 95%"/>
            </td>
            <td class="addTd">
                <input type="text" name="jbr" class="input_text" style="width: 95%"/>
            </td>
        </tr>
        </tbody>
    </table>
    </div>
    <table cellpadding="5" cellspacing="0" class="form_table">
        <tr class="tr_content">
            <td>
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</form:form>