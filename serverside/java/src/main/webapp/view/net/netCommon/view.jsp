<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr>
            <td colspan="2">
                <c:forEach items="${list}" var="item">
                    <div class="form_fieldset_space"></div>
                    <fieldset class="form_fieldset">
                        <legend class="form_legend"><c:choose><c:when test="${fn:length(list)==1}">受理过程</c:when><c:otherwise>${item.step.name}</c:otherwise></c:choose></legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_header">
                                <td class="form_border" width="23%">受理意见</td>
                                <td class="form_border" width="14%">操作人</td>
                                <td class="form_border" width="23%">受理日期</td>
                                <td class="form_border" width="40%">退回原因</td>
                            </tr>
                            <c:forEach items="${item.logs}" var="log">
                                <tr class="tr_light">
                                    <td class="form_border">${log.acceptStatus.name}</td>
                                    <td class="form_border">${log.opPerson}</td>
                                    <td class="form_border"><fmt:formatDate value="${log.acceptDate}" pattern="yyyy-MM-dd"/></td>
                                    <td class="form_border"><sys:toHtml>${log.backCause}</sys:toHtml></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </fieldset>
                </c:forEach>
            </td>
        </tr>
        <c:if test="${isNetApply}">
            <tr><td class="form_fieldset_space"></td></tr>
            <tr>
                <td width="50%" align="center">
                    <fieldset class="form_fieldset" style="width: 280px;height: 150px">
                        <legend class="form_legend">项目承发包类型和发包方式</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table" style="height: 130px">
                            <c:forEach items="${fbList}" var="item">
                                <tr class="tr_light">
                                    <td class="form_border" width="50%">
                                        <input type="checkbox" name="checkbox" <c:if test="${item.isChecked}">checked</c:if>/>${item.fb.name}
                                    </td>
                                    <td class="form_border" width="50%">
                                        <input type="checkbox" name="checkbox" <c:if test="${item.isBid}">checked</c:if>/>是否招标
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </fieldset>
                </td>
                <td width="50%" align="center">
                    <fieldset class="form_fieldset" style="width: 280px;height: 150px">
                        <legend class="form_legend">施工图审查</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td class="form_border" align="center" style="height: 130px">
                                    <input type="checkbox" name="checkbox" <c:if test="${isCheckDraw}">checked</c:if>/>是否需要施工图审查
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>
        </c:if>
        <tr><td class="form_fieldset_space"></td></tr>
        <tr class="tr_button">
            <td class="form_border" align="center" colspan="2">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>