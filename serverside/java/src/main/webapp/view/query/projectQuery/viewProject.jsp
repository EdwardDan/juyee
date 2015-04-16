<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td width="15%" class="form_label_right" nowrap>报建编号：</td>
            <td width="40%" class="form_content" >&nbsp;${bean.bjbh}</td>
            <td width="15%" class="form_label_right" nowrap>报建日期：</td>
            <td width="30%" class="form_content">&nbsp;${bean.bjDate}</td>
        </tr>
        <tr class="tr_light">
            <%--<td class="form_label_right" nowrap>流转编号：</td>--%>
            <%--<td class="form_content" >&nbsp;${bean.flowCode}</td>--%>
            <td class="form_label_right" nowrap >工程地点：</td>
            <td class="form_content" colspan="3" >&nbsp;${bean.buildAddress}</td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right" nowrap>工程性质：</td>
            <td class="form_content" >&nbsp;${bean.projectProperty}</td>
            <td class="form_label_right" nowrap>建筑面积：</td>
            <td class="form_content" >&nbsp;${bean.totalAreaDesc}</td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right" nowrap>建安工作量：</td>
            <td class="form_content" >&nbsp;${bean.totalInvestmentDesc}</td>
            <td class="form_label_right" nowrap>单体数量：</td>
            <td class="form_content" >&nbsp;${bean.dtsl}</td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right" nowrap>工程名称：</td>
            <td class="form_content" colspan="3">&nbsp;${bean.projectName}</td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right" nowrap>工程地址：</td>
            <td class="form_content" colspan="3">&nbsp;${bean.buildAddress}</td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right" nowrap>建设单位：</td>
            <td class="form_content">&nbsp;${bean.jsdwmc}</td>
            <td class="form_label_right" nowrap>联系人：</td>
            <td class="form_content" >&nbsp;${bean.jsdwLxr}<c:if test="${not empty bean.jsdwTel}">（电话：${bean.jsdwTel}）</c:if></td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right" nowrap>施工单位：</td>
            <td class="form_content">&nbsp;${bean.sgdwmc}</td>
            <td class="form_label_right" nowrap>联系人：</td>
            <td class="form_content" >&nbsp;${bean.sgdwLxr}<c:if test="${not empty bean.sgdwTel}">（电话：${bean.sgdwTel}）</c:if></td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right" nowrap>勘察单位：</td>
            <td class="form_content">&nbsp;${bean.kcdwmc}</td>
            <td class="form_label_right" nowrap>联系人：</td>
            <td class="form_content" >&nbsp;${bean.kcdwLxr}<c:if test="${not empty bean.kcdwTel}">（电话：${bean.kcdwTel}）</c:if></td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right" nowrap>设计单位：</td>
            <td class="form_content">&nbsp;${bean.sjdwmc}</td>
            <td class="form_label_right" nowrap>联系人：</td>
            <td class="form_content" >&nbsp;${bean.sjdwLxr}<c:if test="${not empty bean.sjdwTel}">（电话：${bean.sjdwTel}）</c:if></td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right" nowrap>监理单位：</td>
            <td class="form_content">&nbsp;${bean.jldwmc}</td>
            <td class="form_label_right" nowrap>联系人：</td>
            <td class="form_content" >&nbsp;${bean.jldwLxr}<c:if test="${not empty bean.jldwTel}">（电话：${bean.jldwTel}）</c:if></td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right" nowrap>施工总包：</td>
            <td class="form_content">&nbsp;${bean.sgzbdwmc}</td>
            <td class="form_label_right" nowrap>联系人：</td>
            <td class="form_content" >&nbsp;${bean.sgzbdwLxr}<c:if test="${not empty bean.sgzbdwTel}">（电话：${bean.sgzbdwTel}）</c:if></td>
        </tr>
        <%--<tr class="tr_dark">--%>
            <%--<td class="form_label_right" nowrap>&nbsp;</td>--%>
            <%--<td class="form_content" colspan="3" style="text-align: left;">&nbsp;${projectMsg}</td>--%>
        <%--</tr>--%>
        <tr class="tr_button">
            <td class="form_td_line" colspan="4">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>