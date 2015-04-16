<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label_right" width="20%">主题：</td>
            <td class="form_content" colspan="3">&nbsp;
                ${bean.title}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right" width="20%">学习时间：</td>
            <td class="form_content" width="30%">
                ${bean.beginDate} ~ ${bean.endDate}
            </td>

            <td class="form_label_right" width="20%">学习时长：</td>
            <td class="form_content" width="30%">&nbsp;
                ${bean.duration}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">责任人：</td>
            <td class="form_content" colspan="3">&nbsp;
                ${bean.reportPerson}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">措施与方法：</td>
            <td class="form_content">&nbsp;
                ${bean.method}
            </td>
            <td class="form_label_right">费用：</td>
            <td class="form_content">&nbsp;
                ${bean.fee}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">参加人员:</td>
            <td class="form_content" colspan="3">
                <c:forEach items="${list}" var="oExpertiseUser">
                    ${oExpertiseUser.displayName}
                </c:forEach>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">学习目标：</td>
            <td class="form_content" colspan="3">&nbsp;
               <sys:toHtml>${bean.studyTarget}</sys:toHtml>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">学习内容：</td>
            <td class="form_content" colspan="3">&nbsp;
                <sys:toHtml>${bean.studyContent}</sys:toHtml>
            </td>
        </tr>

        <tr class="tr_light">
            <td class="form_label_right">状态：</td>
            <td class="form_content" colspan="3">&nbsp;
                ${status}
            </td>
        </tr>
        <c:if test="${bean.status==STATUS_PASS || bean.status==STATUS_BACK || bean.status==STATUS_COMPLETE}">
        <tr class="tr_dark">
            <td class="form_label_right">审核备注：</td>
            <td class="form_content" colspan="3">&nbsp;
                <sys:toHtml>${bean.auditMemo} </sys:toHtml>
            </td>
        </tr>
        </c:if>
        <c:if test="${bean.status==STATUS_COMPLETE}">
        <tr class="tr_light">
            <td class="form_label_right">学习情况描述：</td>
            <td class="form_content" colspan="3">&nbsp;
                <sys:toHtml> ${bean.studyDesc} </sys:toHtml>
            </td>
        </tr>
        </c:if>
        <tr class="tr_dark">
            <td class="form_label_right" nowrap>附件：</td>
            <td class="form_content" colspan="3">&nbsp;
                ${docButton}
            </td>
        </tr>
        <tr class="tr_button">
            <td class="form_border" colspan="4" align="center">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>