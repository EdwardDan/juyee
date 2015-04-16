<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_header">
            <td class="form_border" width="5%" nowrap>序号</td>
            <td class="form_border" width="15%" nowrap>单位工程编号</td>
            <td class="form_border" width="25%" nowrap>单位工程名称</td>
            <td class="form_border" width="10%" nowrap>建筑面积(㎡)</td>
            <td class="form_border" width="10%" nowrap>工程造价(万元)</td>
            <td class="form_border" width="8%" nowrap>工程类型</td>
            <%--<td class="form_border" width="8%" nowrap>在监状态</td>--%>
            <td class="form_border" width="8%" nowrap>电梯数量</td>
            <td class="form_border" width="8%" nowrap>地上层数</td>
            <td class="form_border" width="8%" nowrap>地下层数</td>
            <td class="form_border" width="8%" nowrap>工程进度</td>
        </tr>
        <c:forEach items="${list}" var="item" varStatus="status">
                        <tr class="<c:choose><c:when test="${status.index % 2==0}">tr_light</c:when><c:otherwise>tr_dark</c:otherwise></c:choose>">
                            <td class="form_border">&nbsp;${status.index+1}</td>
                            <td class="form_border">&nbsp;${item.dwgcCard}</td>
                            <td class="form_border" align="left">&nbsp;${item.dwgcName}</td>
                            <td class="form_border" align="right" nowrap><fmt:formatNumber value="${item.buildArea}" pattern="#,###.####"/>&nbsp;</td>
                            <td class="form_border" align="right" nowrap><fmt:formatNumber value="${item.proCost}" pattern="#,###.####"/>&nbsp;</td>
                            <td class="form_border" nowrap>&nbsp;${item.proTypeName}</td>
                            <td class="form_border" nowrap>&nbsp;${item.zjStatusName}</td>
                            <td class="form_border" nowrap>&nbsp;${item.floorCount}</td>
                            <td class="form_border" nowrap>&nbsp;${item.groundFloorCount}</td>
                            <td class="form_border" nowrap>&nbsp;${item.schedule}</td>
                        </tr>
        </c:forEach>
        <tr class="tr_button">
            <td class="form_td_line" colspan="10">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>