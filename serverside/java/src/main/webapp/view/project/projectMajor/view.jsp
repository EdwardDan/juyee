<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label_right" width="20%">报建编号：</td>
            <td class="form_content">&nbsp;
                ${bean.bjbh}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">项目名称：</td>
            <td class="form_content">&nbsp;
                ${bean.projectName}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">项目地址：</td>
            <td class="form_content">&nbsp;
                ${bean.projectAdd}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">建设单位：</td>
            <td class="form_content">&nbsp;
                ${bean.jsUnitName}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">项目类型：</td>
            <td class="form_content">&nbsp;
                ${bean.projectType.name}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">当前进度：</td>
            <td class="form_content">&nbsp;
                ${bean.scheduleColorName}
            </td>
        </tr>
        <c:if test="${not empty bean.posX}">
            <tr class="tr_light">
                <td class="form_label_right">坐标X:</td>
                <td class="form_content">
                        ${bean.posX}
                </td>
                &nbsp;
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">坐标Y:</td>
                <td class="form_content">
                        ${bean.posY}
                </td>
                &nbsp;
            </tr>
        </c:if>
        <tr class="tr_button" aligh="center">
            <td class="form_border" colspan="2" aligh="center">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>