<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label_right" width="20%">姓名：</td>
            <td class="form_content" width="80%">&nbsp;
                ${bean.name}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">性别：</td>
            <td class="form_content">&nbsp;
                <c:choose><c:when test="${bean.sex}">男</c:when><c:otherwise>女</c:otherwise></c:choose>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">出生日期：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.birthDate}" pattern="yyyy-MM-dd"/>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">证件类型：</td>
            <td class="form_content">&nbsp;
                身份证
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">证件号码：</td>
            <td class="form_content">&nbsp;
                ${bean.idCard}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">学历：</td>
            <td class="form_content">&nbsp;
                ${bean.educationType.name}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">技术职称：</td>
            <td class="form_content">&nbsp;
                ${bean.techType.name}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">毕业时间：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.graduationTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">毕业院校：</td>
            <td class="form_content">&nbsp;
                ${bean.graduationSchool}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">所学专业：</td>
            <td class="form_content">&nbsp;
                ${bean.major}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">申请类型：</td>
            <td class="form_content">&nbsp;
                ${bean.applyType.name}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">工作简历：</td>
            <td class="form_content">
                <sys:toHtml>${bean.workResume}</sys:toHtml>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">生产业绩：</td>
            <td class="form_content">
                <sys:toHtml>${bean.production}</sys:toHtml>
            </td>
        </tr>

        <tr class="tr_dark">
            <td class="form_label_right">申请类别：</td>
            <td class="form_content">&nbsp;
                ${bean.applyCerType.name}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">企业名称：</td>
            <td class="form_content">&nbsp;
                ${bean.unitName}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">企业类型：</td>
            <td class="form_content">&nbsp;
                ${bean.unitType.name}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">照片：</td>
            <td class="form_content">
                ${photoButton}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">身份证照片：</td>
            <td class="form_content">
                ${cardButton}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">学历证或职称证照片：</td>
            <td class="form_content">
                ${educationButton}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">合同文件：</td>
            <td class="form_content">
                ${contractButton}
            </td>
        </tr>
        <c:if test="${canEdit}">
            <c:if test="${STATUS_PASS ==bean.status|| STATUS_BACK ==bean.status}">
                <tr class="tr_light">
                    <td class="form_label_right">初审意见：</td>
                    <td class="form_content">
                        <sys:toHtml>${bean.csOpinion}</sys:toHtml>
                    </td>
                </tr>
            </c:if>
        </c:if>
        <tr class="tr_button">
            <td class="form_content" style="text-align: center" colspan="2">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>