<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<form:form commandName="bean">
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right">上报科室：</td>
                <td class="form_content"> ${bean.reportDept}
                </td>
                <td class="form_label_right">科室分管领导：</td>
                <td class="form_content">
                        ${bean.reportPerson}
                </td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label_right">上报开始时间：</td>
                <td class="form_content" colspan="3">
                        ${bean.beginDate} ~ ${bean.endDate}
                </td>
            </tr>
        </table>

        <table cellpadding="0" cellspacing="0" class="form_table" style="text-align: center" id="itemTable">
            <tr class="tr_light">
                <td class="form_border" style="width: 35px">
                    序号
                </td>
                <td class="form_border">
                    工作内容
                </td>
                <td class="form_border">
                    时间节点
                </td>

                <td class="form_border">
                    上报形式
                </td>

                <td class="form_border">
                    完成情况
                </td>

                <td class="form_border">
                    审核情况
                </td>
            </tr>
            <c:forEach items="${bean.oaWorkWatchItems}" var="item">
                <tr class="tr_light">
                    <td class="form_border">
                            ${item.orderNo}
                    </td>
                    <td class="form_border">
                            ${item.content}
                    </td>
                    <td class="form_border">
                            ${item.timeNode}
                    </td>

                    <td class="form_border">
                        ${item.reportMethod}
                    </td>

                    <td class="form_border">
                            ${item.completeDesc}
                    </td>

                    <td class="form_border">
                        <select name="actualDesc" disabled>
                            <option value=""></option>
                            <option value="属实" <c:if test="${item.actualDesc =='属实'}"> selected </c:if> >属实</option>
                            <option value="不属实"
                                    <c:if test="${item.actualDesc =='不属实'}">selected </c:if> >不属实
                            </option>
                        </select>
                            <%--<input type="text" class="input_text" name="actualDesc" readonly='true'--%>
                            <%--value="${item.actualDesc}"/>--%>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <c:if test="${not empty bean.zrOpinion}">
            <div style="height: 10px"></div>
            <fieldset class="form_fieldset">
                <legend class="form_legend">
                    主任审核
                </legend>
                <table cellpadding="0" cellspacing="0" class="form_table" style="text-align: center">
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 20%" colspan="1">
                            审核意见：
                        </td>
                        <td class="form_content" colspan="6">
                        <sys:toHtml>${bean.zrOpinion}</sys:toHtml>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </c:if>
        <c:if test="${not empty bean.bgsOpinion}">
            <div style="height: 10px"></div>
            <fieldset class="form_fieldset">
                <table cellpadding="0" cellspacing="0" class="form_table" style="text-align: center">
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 20%" colspan="1">
                            核实意见：
                        </td>
                        <td class="form_content" colspan="6">
                            <sys:toHtml>${bean.bgsOpinion}</sys:toHtml>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </c:if>
        <table cellpadding="0" cellspacing="0" class="form_table" style="text-align: center">
            <tr class="tr_button">
                <td style="text-align: center" >
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>