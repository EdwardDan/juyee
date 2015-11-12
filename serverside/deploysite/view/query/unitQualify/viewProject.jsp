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
                &nbsp;承建工程
            </td>
        </tr>
        <tr class="tr_header">
            <td width="5%" class="form_td_line" nowrap>序号</td>
            <td width="10%" class="form_td_line" nowrap>报建编号</td>
            <td width="25%" class="form_td_line" nowrap>项目名称</td>
            <td width="18%" class="form_td_line" nowrap>建设地点</td>
            <td width="10%" class="form_td_line" nowrap>项目分类</td>
            <td width="10%" class="form_td_line" nowrap>总投资(万元)</td>
            <td width="10%" class="form_td_line" nowrap>总面积(㎡)</td>
            <td width="10%" class="form_td_line" nowrap>报建日期</td>
        </tr>
        <c:forEach items="${list}" var="item" varStatus="status">
            <tr class="<c:choose><c:when test="${status.index % 2==0}">tr_light</c:when><c:otherwise>tr_dark</c:otherwise></c:choose>">
                <td class="form_td_line" nowrap>&nbsp;${status.index+1}</td>
                <td class="form_td_line" nowrap>&nbsp;${item.project.bjbh}</td>
                <td class="form_td_line" align="left">&nbsp;${item.project.projectName}</td>
                <td class="form_td_line" align="left">&nbsp;${item.project.buildAddress}</td>
                <td class="form_td_line" nowrap>&nbsp;${item.typeName}</td>
                <td class="form_td_line" nowrap align="right"><fmt:formatNumber value="${item.project.totalInvestment}" pattern="#,###.####"/>&nbsp;</td>
                <td class="form_td_line" nowrap align="right"><fmt:formatNumber value="${item.project.totalArea}" pattern="#,###.####"/>&nbsp;</td>
                <td class="form_td_line" nowrap>&nbsp;<fmt:formatDate value="${item.project.bjDate}" pattern="yyyy-MM-dd"/></td>
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