<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label_right">报建编号：</td>
            <td class="form_content">&nbsp;
                ${bean.bjbh}
            </td>
            <td class="form_label_right">标段号：</td>
            <td class="form_content">&nbsp;
                ${bean.bdh}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">项目名称：</td>
            <td class="form_content" colspan="3">&nbsp;
                ${bean.projectName}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">建设单位：</td>
            <td class="form_content" colspan="3">&nbsp;
                ${bean.buildUnit}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">建设地点：</td>
            <td class="form_content" colspan="3">&nbsp;
                ${bean.buildAddress}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">购买标书截至时间：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.signLastDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <td class="form_label_right">投标保证金截止日期：</td>
            <td class="form_content">
                <fmt:formatDate value="${bean.signDate}" pattern="yyyy-MM-dd"/>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">招标代理单位：</td>
            <td class="form_content" colspan="3">&nbsp;
                ${bean.signProxyUnit}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">联系人：</td>
            <td class="form_content">&nbsp;
                ${bean.linkPerson}
            </td>
            <td class="form_label_right">联系电话：</td>
            <td class="form_content">&nbsp;
                ${bean.linkTel}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">项目投标保证金：</td>
            <td class="form_content" colspan="3">&nbsp;
                ${bean.signAccount}（元）
            </td>
        </tr>
    </table>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_header">
            <td class="form_border" nowrap width="40%">购买标书单位</td>
            <td class="form_border" nowrap width="20%">联系人</td>
            <td class="form_border" nowrap width="20%">联系电话</td>
            <td class="form_border" nowrap width="20%">购买标书时间</td>
        </tr>
        <c:forEach items="${list}" var="item" varStatus="status">
            <tr class="<c:choose><c:when test="${status.index % 2==0}">tr_light</c:when><c:otherwise>tr_dark</c:otherwise></c:choose>">
                 <td class="form_border">${item.signUnit}</td>
                 <td class="form_border">${item.linkPerson}</td>
                 <td class="form_border">${item.linkTel}</td>
                 <td class="form_border">
                     <fmt:formatDate value="${item.signDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                 </td>
            </tr>
        </c:forEach>
    </table>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_button">
            <td colspan="4">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>