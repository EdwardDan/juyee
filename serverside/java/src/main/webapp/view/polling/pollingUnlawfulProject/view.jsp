<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td nowrap class="form_label_right">工程名称：</td>
            <td nowrap class="form_content">${bean.projectName}</td>
            <td nowrap class="form_label_right">建设地址：</td>
            <td nowrap class="form_content" width="30%">${bean.buildAddress}</td>
        </tr>
        <tr class="tr_dark">
            <td nowrap class="form_label_right">建设单位：</td>
            <td nowrap class="form_content">${bean.buildUnit}</td>
            <td nowrap class="form_label_right">施工单位：</td>
            <td nowrap class="form_content"> ${bean.sgUnit}</td>
        </tr>
        <tr class="tr_light">
            <td nowrap class="form_label_right">建设单位联系人：</td>
            <td nowrap class="form_content">${bean.buildLinkman}</td>
            <td nowrap class="form_label_right">施工单位联系人：</td>
            <td nowrap class="form_content">${bean.sgUnitLinkman}</td>
        </tr>
        <tr class="tr_dark">
            <td nowrap class="form_label_right">建设单位联系电话：</td>
            <td nowrap class="form_content"> ${bean.buildLinkPhone}</td>
            <td nowrap class="form_label_right">施工单位联系电话：</td>
            <td nowrap class="form_content"> ${bean.sgUnitLinkPhone}</td>
        </tr>
        <tr class="tr_light">
            <td nowrap class="form_label_right">立项申请：</td>
            <td class="form_content"><c:choose><c:when
                    test="${bean.isLx}">有</c:when><c:otherwise>无</c:otherwise></c:choose></td>
            <td nowrap nowrap class="form_label_right">土地权证：</td>
            <td class="form_content"><c:choose><c:when
                    test="${bean.isTdqz}">有</c:when><c:otherwise>无</c:otherwise></c:choose></td>
        </tr>
        <tr class="tr_dark">
            <td nowrap nowrap class="form_label_right">规划许可：</td>
            <td class="form_content"><c:choose><c:when
                    test="${bean.isGhxk}">有</c:when><c:otherwise>无</c:otherwise></c:choose></td>
            <td nowrap nowrap class="form_label_right">施工许可：</td>
            <td class="form_content"><c:choose><c:when
                    test="${bean.isSgxk}">有</c:when><c:otherwise>无</c:otherwise></c:choose></td>
        </tr>
        <tr class="tr_light">
            <td nowrap class="form_label_right">监督负责人：</td>
            <td nowrap class="form_content">${bean.mainPerson}</td>
            <td nowrap class="form_label_right">监督成员：</td>
            <td nowrap class="form_content">${bean.groupPerson}</td>
        </tr>
        <tr class="tr_dark">
            <td nowrap class="form_label_right">发现时间：</td>
            <td nowrap class="form_content" colspan="3"><fmt:formatDate value="${bean.createTime}"
                                                                        pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
        </tr>
        <tr class="tr_light">
            <td nowrap class="form_label_right">问题描述：</td>
            <td nowrap class="form_content" colspan="3">${bean.questionDesc}</td>
        </tr>
        <tr class="tr_dark">
            <td nowrap class="form_label">项目属地：</td>
            <td nowrap class="form_content" colspan="3"> ${bean.belongArea}</td>
        </tr>
        <tr class="tr_dark">
            <td nowrap class="form_label" nowrap>坐标X：</td>
            <td nowrap class="form_content" nowrap> ${bean.posX}</td>
            <td nowrap class="form_label" nowrap>坐标Y：</td>
            <td nowrap class="form_content" nowrap> ${bean.posY}</td>
        </tr>

        <tr class="tr_button">
            <td class="form_label_right" colspan="2"></td>
            <td class="form_content" colspan="2">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>