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
            <td colspan="6" class="form_td_line" height="0">&nbsp;</td>
        </tr>
    </table>
    <div class="div_space"></div>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_title">
            <td colspan="7" align="left">
                &nbsp;人员资格信息
            </td>
        </tr>
        <tr class="tr_header">
            <td width="5%" class="form_td_line" nowrap>序号</td>
            <td width="15%" class="form_td_line" nowrap>姓名</td>
            <td width="8%" class="form_td_line" nowrap>性别</td>
            <td width="20%" class="form_td_line" nowrap>身份证</td>
            <td width="20%" class="form_td_line" nowrap>证书名称</td>
            <td width="20%" class="form_td_line" nowrap>证书编号</td>
            <td width="10%" class="form_td_line" nowrap>有效期</td>
        </tr>
        <c:forEach items="${list}" var="item" varStatus="status">
            <tr class="<c:choose><c:when test="${status.index % 2==0}">tr_light</c:when><c:otherwise>tr_dark</c:otherwise></c:choose>">
                <td class="form_td_line">&nbsp;${status.index+1}</td>
                <td class="form_td_line">&nbsp;${item.personName}</td>
                <td class="form_td_line">&nbsp;${item.personSex}</td>
                <td class="form_td_line">&nbsp;${item.cardNo}</td>
                <td class="form_td_line">&nbsp;${item.qualifyTypeDesc}</td>
                <td class="form_td_line">&nbsp;${item.regQualifyCode}</td>
                <td class="form_td_line">&nbsp;<fmt:formatDate value="${item.validDate}" pattern="yyyy-MM-dd"/></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="7" class="form_td_line" height="0">&nbsp;</td>
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