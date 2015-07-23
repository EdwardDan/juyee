<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label_right" style="width: 20%">标段序号：</td>
            <td class="form_content" style="width: 30%">
                ${bean.no}
            </td>
            <td class="form_label_right" style="width: 20%">标段名称：</td>
            <td class="form_content" style="width: 30%">
                ${bean.name}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right" style="width: 20%">建设里程：</td>
            <td class="form_content" colspan="3">
                ${bean.buildMileage}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right" style="width: 20%">涉及区（县）：</td>
            <td class="form_content" style="width: 30%">
                ${areas}
            </td>
            <td class="form_label_right" style="width: 20%">开工日期：</td>
            <td class="form_content" style="width: 30%">
                ${bean.startDate}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right" style="width: 20%">项目联系人：</td>
            <td class="form_content" style="width: 30%">
                ${bean.projLink}
            </td>
            <td class="form_label_right" style="width: 20%">联系电话：</td>
            <td class="form_content" style="width: 30%">
                ${bean.linkTel}
            </td>
        </tr>
        <tr class="tr_light">
            <td colspan="4">
                <table class="form_table" cellspacing="0" cellpadding="0" style="width: 90%;margin: 0 auto">
                    <tr>
                        <td class="tr_title" colspan="4" nowrap>各参建单位信息</td>
                    </tr>
                    <tr>
                        <td class="tr_header" style="width: 15%">类型</td>
                        <td class="tr_header">名称</td>
                        <td class="tr_header">联系人</td>
                        <td class="tr_header">联系电话</td>
                    </tr>
                    <c:forEach var="relatedUnit" items="${relatedUnits}" varStatus="serial">
                        <tr>
                            <td class="form_border">${relatedUnit[0]}</td>
                            <td class="form_content">${relatedUnit[2]}</td>
                            <td class="form_content">${relatedUnit[3]}</td>
                            <td class="form_content">${relatedUnit[4]}</td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
        <tr class="tr_button">
            <td class="form_content" colspan="4" style="text-align: center">
                <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>