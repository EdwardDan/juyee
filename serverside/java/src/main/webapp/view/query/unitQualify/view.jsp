<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="no_scrollbar">
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_title">
            <td colspan="6" align="left">
                &nbsp;企业信息
            </td>
        </tr>
        <tr class="tr_light">
            <td width="10%" class="form_label_right" nowrap>单位名称：</td>
            <td width="20%" class="form_content">&nbsp;${bean.unitName}</td>
            <td width="10%" class="form_label_right" nowrap>机构代码证：</td>
            <td width="20%" class="form_content">&nbsp;${bean.orgCode}</td>
            <td width="10%" class="form_label_right" nowrap>经济类型：</td>
            <td width="20%" class="form_content">&nbsp;${bean.unitEcoName}</td>
        </tr>
        <tr class="tr_dark">
            <td width="10%" class="form_label_right" nowrap>注册所在地：</td>
            <td width="20%" class="form_content">&nbsp;${bean.regCityName}</td>
            <td width="10%" class="form_label_right" nowrap>隶属省市：</td>
            <td width="20%" class="form_content">&nbsp;${bean.belogProvince}</td>
            <td width="10%" class="form_label_right" nowrap>注册地址：</td>
            <td width="20%" class="form_content">&nbsp;${bean.regAddress}</td>
        </tr>
        <tr>
            <td colspan="6" class="form_content" height="0">&nbsp;</td>
        </tr>
    </table>
    <div class="div_space"></div>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_title">
            <td colspan="9" align="left">
                &nbsp;企业资质情况
            </td>
        </tr>
        <tr class="tr_header">
            <td width="10%" class="form_td_line" nowrap>企业隶属</td>
            <td width="10%" class="form_td_line" nowrap>资质类别</td>
            <td width="10%" class="form_td_line" nowrap>资质等级</td>
            <td width="10%" class="form_td_line" nowrap>资质证书编号</td>
            <td width="10%" class="form_td_line" nowrap>主项资质</td>
            <td width="10%" class="form_td_line" nowrap>批准日期</td>
            <td width="10%" class="form_td_line" nowrap>有效期</td>
            <td width="10%" class="form_td_line" nowrap>暂定日期</td>
            <td width="20%" class="form_td_line" nowrap>承包工程范围</td>
        </tr>
        <c:forEach items="${list}" var="item" varStatus="status">
            <tr class="<c:choose><c:when test="${status.index % 2==0}">tr_light</c:when><c:otherwise>tr_dark</c:otherwise></c:choose>">
                <td class="form_td_line">&nbsp;${item.unitBelongDesc}</td>
                <td class="form_td_line">&nbsp;${item.qualifyTypeDesc}</td>
                <td class="form_td_line">&nbsp;${item.qualifyLevelDesc}</td>
                <td class="form_td_line">&nbsp;${item.qualifyCode}</td>
                <td class="form_td_line">&nbsp;<c:choose><c:when test="${item.isMainQualify}">是</c:when><c:otherwise>否</c:otherwise></c:choose></td>
                <td class="form_td_line">&nbsp;<fmt:formatDate value="${item.acceptDatetime}" pattern="yyyy-MM-dd"/></td>
                <td class="form_td_line">&nbsp;<fmt:formatDate value="${item.validDatetime}" pattern="yyyy-MM-dd"/></td>
                <td class="form_td_line">&nbsp;<fmt:formatDate value="${item.tempDatetime}" pattern="yyyy-MM-dd"/></td>
                <td class="form_content">&nbsp;<sys:toHtml>${item.holdWorkScope}</sys:toHtml></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="6" class="form_td_line" height="0"></td>
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