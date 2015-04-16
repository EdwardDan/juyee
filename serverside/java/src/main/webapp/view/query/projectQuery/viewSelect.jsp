<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_header">
            <td class="form_border" width="20%" nowrap="true">工地编号</td>
            <td class="form_border" width="50%" nowrap="true">工地名称</td>
            <td class="form_border" width="15%" nowrap="true">当前状态</td>
            <td class="form_border" width="15%" nowrap="true">操作</td>
        </tr>
        <c:forEach items="${list}" var="item" varStatus="status">
            <tr
                    <c:choose>
                        <c:when test="${status.index % 2==0}">class="tr_light" </c:when>
                        <c:otherwise>class="tr_dark" </c:otherwise>
                    </c:choose>>
                <td class="form_border" align="center" nowrap="true">&nbsp;${item.gdCode}</td>
                <td class="form_border" align="left" style="word-break:break-all;">&nbsp;${item.gdName}</td>
                <td class="form_border" align="center" nowrap="true">&nbsp;${item.gdStatusDesc}</td>
                <td class="form_border" align="center" nowrap="true"><input type="button" value="查看"
                                                              onclick="doView('${bean.bjbh}','${item.gdCode}','${jdTaskCode}')"
                                                              class="button_normal"></td>
            </tr>
        </c:forEach>
        <tr class="tr_button">
            <td class="form_td_line" align="center" colspan="4">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>