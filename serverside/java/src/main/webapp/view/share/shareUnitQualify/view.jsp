<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="no_scrollbar">
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">企业名称：</td>
                <td class="form_content">&nbsp;${unit.unitName}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">批准资质类型：</td>
                <td class="form_content">&nbsp;${qualify.qualifyBigTypeDesc}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">批准资质名称：</td>
                <td class="form_content">&nbsp;${qualify.qualifyTypeDesc}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">资质等级：</td>
                <td class="form_content">&nbsp;${qualify.qualifyLevelDesc}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">批准时间：</td>
                <td class="form_content">&nbsp;<fmt:formatDate value="${qualify.acceptDatetime}"
                                                               pattern="yyyy-MM-dd"/></td>
            </tr>
        </table>

        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_button">
                <td class="form_td_line" align="center">
                    <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</div>