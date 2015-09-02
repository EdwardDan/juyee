<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label_right" style="width: 20%">申请会议室：</td>
            <td class="form_content" style="width: 80%">&nbsp;
                ${bean.room.name}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">会议召开时间：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.useDate}" pattern="yyyy-MM-dd"/>&nbsp;&nbsp;
                ${bean.useTime}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">申请人：</td>
            <td class="form_content">&nbsp;
                ${bean.applyPerson}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">申请部门名称：</td>
            <td class="form_content">&nbsp;
                ${bean.applyDept}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">预计参与人数：</td>
            <td class="form_content">&nbsp;
                ${bean.personNum}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">内部人员：</td>
            <td class="form_content">&nbsp;
                <c:forEach var="innerPerson" items="${innerPersons}" varStatus="serial">
                    ${innerPerson.name}<c:if test="${!serial.last}">,</c:if> &nbsp;
                </c:forEach>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">外部人员：</td>
            <td class="form_content">&nbsp;
                ${bean.outerPersons}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">会议主题：</td>
            <td class="form_content">&nbsp;
                ${bean.title}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">会议内容：</td>
            <td class="form_content" style="word-break:break-all; word-wrap:break-word;">&nbsp;
                ${bean.content}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">状态：</td>
            <td class="form_content">&nbsp;
                ${ bean.statusName}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">附件：</td>
            <td class="form_content">
                ${downloadButton}
            </td>
        </tr>
        <c:if test="${bean.auditTime ne null}">
            <tr class="tr_dark">
                <td class="form_label_right">审核意见：</td>
                <td class="form_content">&nbsp;
                        ${bean.auditOpinion}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">审核时间：</td>
                <td class="form_content">&nbsp;
                    <fmt:formatDate value="${bean.auditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">审核人：</td>
                <td class="form_content">&nbsp;
                        ${bean.auditUser}
                </td>
            </tr>
        </c:if>
        <tr class="tr_button">
            <td class="form_content" style="text-align: center" colspan="2">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>